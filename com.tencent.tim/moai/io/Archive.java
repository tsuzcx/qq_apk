package moai.io;

import android.content.Context;
import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Archive {
    public static final String TAG = Archive.class.getSimpleName();

    public static class  ArchiveResult {
        public boolean ret;
        public File file;
        public int total;
        public int index;
        // total
        public ArrayList<String> succfiles;
        public String zippath;

        public void upadte(boolean ret, File file, int index) {
            this.ret = ret;
            this.file = file;
            this.index = index;
        }
    }

    public static interface ArchiveListener {
        public void onArchiveFile(ArchiveResult result);
        public void onArchiveComplete(ArchiveResult result);
    }

    /**
     * @param zipFilePath  生成压缩文件地址
     * @param fileList     待压缩文件列表
     * @return
     */
    // 旧接口 public static void ArchiveFiles(Context context, String zipFilePath, List<File> fileList, ArchiveListener listener)
    public static void ArchiveFiles(Context context, String zipFilePath, long ziplength, List<File> fileList, ArchiveListener listener) {
        // long ziplength = getZipLength(context);
        ArrayList<String> succFiles = new ArrayList<>();
        try {
            ZipOutputStream zos = new ZipOutputStream(
                    new BufferedOutputStream(new FileOutputStream(zipFilePath)));

            ArchiveResult result = new ArchiveResult();
            result.total = fileList.size();
            for (int i = 0; i < fileList.size(); i++) {
                boolean ret = zipFile(zos, fileList.get(i), ziplength);
                if (!ret) {
                    Log.e(TAG, "failed to zip file");
                } else {
                    succFiles.add(fileList.get(i).getAbsolutePath());
                }

                if (listener != null) {
                    result.upadte(ret, fileList.get(i), i);
                    listener.onArchiveFile(result);
                }
            }

            zos.close();

            if (listener != null) {
                result.succfiles = succFiles;
                result.zippath = zipFilePath;
                listener.onArchiveComplete(result);
            }
        } catch (Exception e) {
            Log.e(TAG, "ArchiveFiles" + e.getMessage());
        }
    }


    private static boolean zipFile(ZipOutputStream zos, File file, long ziplength) {
        if (file == null || !file.exists()) {
            return false;
        }

        byte[] buf = new byte[8 * 1024];
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            zos.putNextEntry(new ZipEntry(file.getName()));
            fis.skip(Math.max(0, file.length() - ziplength));

            Arrays.fill(buf, (byte) 0);
            int _size = 0;
            while ((_size = fis.read(buf)) > 0) {
                zos.write(buf, 0, _size);
            }
            return true;
        } catch (IOException e) {
            Log.e(TAG, "Error on zipping file:" + file.getName() + ", error msg:" + e.getMessage());
            return false;
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                zos.closeEntry();
            } catch (Exception e) {
                Log.e(TAG, "Error on close zip file." );
            }
        }
    }


}
