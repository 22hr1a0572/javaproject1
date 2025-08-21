File Compressor and Decompressor
'''
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.zip.*;
public class FileCompressorDecompressor extends JFrame {
    private JTextArea logArea;
    private JProgressBar progressBar;
    public FileCompressorDecompressor() {
        setTitle("File Compressor & Decompressor");
        setSize(550, 420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JButton compressBtn = new JButton("Compress File");
        JButton decompressBtn = new JButton("Decompress File");
        logArea = new JTextArea();
        logArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logArea);
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        compressBtn.addActionListener(this::compressFile);
        decompressBtn.addActionListener(this::decompressFile);
        JPanel panel = new JPanel();
        panel.add(compressBtn);
        panel.add(decompressBtn);
        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(progressBar, BorderLayout.SOUTH);
    }
    private void compressFile(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose file to compress");
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File fileToCompress = fileChooser.getSelectedFile();
            String zipFileName = fileToCompress.getAbsolutePath() + ".zip";
            new Thread(() -> {
                try (FileInputStream fis = new FileInputStream(fileToCompress);
                     FileOutputStream fos = new FileOutputStream(zipFileName);
                     ZipOutputStream zos = new ZipOutputStream(fos)) {
                    ZipEntry zipEntry = new ZipEntry(fileToCompress.getName());
                    zos.putNextEntry(zipEntry);
                    byte[] buffer = new byte[1024];
                    long totalBytes = fileToCompress.length();
                    long bytesProcessed = 0;
                    int length;
                    while ((length = fis.read(buffer)) > 0) {
                        zos.write(buffer, 0, length);
                        bytesProcessed += length;
                        int progress = (int) ((bytesProcessed * 100) / totalBytes);
                        SwingUtilities.invokeLater(() -> progressBar.setValue(progress));
                    }
                    zos.closeEntry();
                    logArea.append("✅ Compressed: " + fileToCompress.getName() + " → " + zipFileName + "\n");
                } catch (IOException ex) {
                    logArea.append("❌ Error compressing: " + ex.getMessage() + "\n");
                }
                SwingUtilities.invokeLater(() -> progressBar.setValue(0));
            }).start();
        }
    }
    private void decompressFile(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose ZIP file to decompress");
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File zipFile = fileChooser.getSelectedFile();
            String outputDir = zipFile.getParent() + File.separator + "unzipped_";
            new Thread(() -> {
                try (FileInputStream fis = new FileInputStream(zipFile);
                     ZipInputStream zis = new ZipInputStream(fis)) {
                    ZipEntry entry;
                    while ((entry = zis.getNextEntry()) != null) {
                        File newFile = new File(outputDir + entry.getName());
                        newFile.getParentFile().mkdirs();
                        try (FileOutputStream fos = new FileOutputStream(newFile)) {
                            byte[] buffer = new byte[1024];
                            int length;
                            long bytesProcessed = 0;
                            while ((length = zis.read(buffer)) > 0) {
                                fos.write(buffer, 0, length);
                                bytesProcessed += length;
                                int progress = (int) (Math.min(100, bytesProcessed / 1000));
                                SwingUtilities.invokeLater(() -> progressBar.setValue(progress));
                            }
                        }

                        zis.closeEntry();
                        logArea.append("✅ Decompressed: " + entry.getName() + " → " + newFile.getAbsolutePath() + "\n");
                    }
                } catch (IOException ex) {
                    logArea.append("❌ Error decompressing: " + ex.getMessage() + "\n");
                }
                SwingUtilities.invokeLater(() -> progressBar.setValue(0));
            }).start();
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FileCompressorDecompressor().setVisible(true));
    }
}
'''
