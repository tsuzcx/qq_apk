package moai.patch.handle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import moai.patch.log.PatchLog;

class NewApkCreator
{
  private static Set<String> addDiffFile(ZipOutputStream paramZipOutputStream, File paramFile1, File paramFile2, boolean paramBoolean)
    throws IOException
  {
    HashSet localHashSet = new HashSet();
    if (paramBoolean) {
      localHashSet.addAll(write(paramZipOutputStream, paramFile1.listFiles(), paramFile1.getAbsolutePath()));
    }
    localHashSet.addAll(write(paramZipOutputStream, paramFile2.listFiles(), paramFile2.getAbsolutePath()));
    return localHashSet;
  }
  
  private static String createApk(String paramString, File paramFile1, File paramFile2, boolean paramBoolean)
  {
    long l;
    File localFile;
    ZipOutputStream localZipOutputStream;
    for (;;)
    {
      InputStream localInputStream;
      try
      {
        l = System.currentTimeMillis();
        localFile = new File(paramFile1, "patch.apk");
        localZipOutputStream = new ZipOutputStream(new FileOutputStream(localFile));
        paramFile1 = addDiffFile(localZipOutputStream, new File(paramFile1, "dex"), new File(paramFile2, "res"), paramBoolean);
        paramFile2 = new ZipFile(paramString);
        Enumeration localEnumeration = paramFile2.entries();
        byte[] arrayOfByte = new byte[1048576];
        if (!localEnumeration.hasMoreElements()) {
          break;
        }
        paramString = (ZipEntry)localEnumeration.nextElement();
        String str = paramString.getName();
        if ((str.contains("../")) || (paramString.isDirectory()) || (paramFile1.contains(str)) || ((str.endsWith(".dex")) && (!paramBoolean))) {
          continue;
        }
        localInputStream = paramFile2.getInputStream(paramString);
        if (paramString.getMethod() == 0)
        {
          paramString = new ZipEntry(paramString);
          localZipOutputStream.putNextEntry(paramString);
          int i = localInputStream.read(arrayOfByte);
          if (i == -1) {
            break label260;
          }
          localZipOutputStream.write(arrayOfByte, 0, i);
          continue;
        }
        paramString = new ZipEntry(str);
      }
      catch (Exception paramString)
      {
        PatchLog.e(6002, "create apk fail:" + paramString.toString());
        throw new RuntimeException(paramString);
      }
      continue;
      label260:
      localZipOutputStream.flush();
      localZipOutputStream.closeEntry();
      localInputStream.close();
    }
    localZipOutputStream.close();
    PatchLog.i(6001, "create apk time cost:" + (System.currentTimeMillis() - l));
    paramString = localFile.getAbsolutePath();
    return paramString;
  }
  
  static String createApkNoDex(String paramString, File paramFile1, File paramFile2)
    throws IOException
  {
    return createApk(paramString, paramFile1, paramFile2, false);
  }
  
  public static String createApkWithDex(String paramString, File paramFile1, File paramFile2)
    throws IOException
  {
    return createApk(paramString, paramFile1, paramFile2, true);
  }
  
  private static List<String> write(ZipOutputStream paramZipOutputStream, File[] paramArrayOfFile, String paramString)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayOfFile != null) && (paramArrayOfFile.length > 0))
    {
      int j = paramArrayOfFile.length;
      int i = 0;
      if (i < j)
      {
        Object localObject1 = paramArrayOfFile[i];
        if (((File)localObject1).isDirectory()) {
          localArrayList.addAll(write(paramZipOutputStream, ((File)localObject1).listFiles(), paramString));
        }
        for (;;)
        {
          i += 1;
          break;
          Object localObject2 = ((File)localObject1).getAbsolutePath().substring(paramString.length() + 1);
          localArrayList.add(localObject2);
          paramZipOutputStream.putNextEntry(new ZipEntry((String)localObject2));
          localObject1 = new FileInputStream((File)localObject1);
          localObject2 = new byte[8192];
          for (;;)
          {
            int k = ((FileInputStream)localObject1).read((byte[])localObject2);
            if (k == -1) {
              break;
            }
            paramZipOutputStream.write((byte[])localObject2, 0, k);
          }
          paramZipOutputStream.closeEntry();
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.handle.NewApkCreator
 * JD-Core Version:    0.7.0.1
 */