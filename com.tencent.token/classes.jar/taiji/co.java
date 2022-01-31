package taiji;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class co
{
  public static void a(String paramString1, String paramString2)
  {
    paramString1 = new ZipFile(paramString1);
    Enumeration localEnumeration = paramString1.entries();
    byte[] arrayOfByte = new byte[1024];
    while (localEnumeration.hasMoreElements())
    {
      Object localObject1 = (ZipEntry)localEnumeration.nextElement();
      if (!((ZipEntry)localObject1).getName().contains("../")) {
        if (((ZipEntry)localObject1).isDirectory())
        {
          new File(paramString2, ((ZipEntry)localObject1).getName()).mkdirs();
        }
        else
        {
          BufferedInputStream localBufferedInputStream = new BufferedInputStream(paramString1.getInputStream((ZipEntry)localObject1));
          localObject1 = new File(paramString2, ((ZipEntry)localObject1).getName());
          Object localObject2 = ((File)localObject1).getParentFile();
          if ((localObject2 != null) && (!((File)localObject2).exists())) {
            ((File)localObject2).mkdirs();
          }
          localObject1 = new FileOutputStream((File)localObject1);
          localObject2 = new BufferedOutputStream((OutputStream)localObject1, 1024);
          for (;;)
          {
            int i = localBufferedInputStream.read(arrayOfByte, 0, 1024);
            if (i == -1) {
              break;
            }
            ((FileOutputStream)localObject1).write(arrayOfByte, 0, i);
          }
          ((BufferedOutputStream)localObject2).flush();
          ((BufferedOutputStream)localObject2).close();
          ((FileOutputStream)localObject1).close();
          localBufferedInputStream.close();
        }
      }
    }
    paramString1.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.co
 * JD-Core Version:    0.7.0.1
 */