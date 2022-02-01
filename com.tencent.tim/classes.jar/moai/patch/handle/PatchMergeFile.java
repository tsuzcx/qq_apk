package moai.patch.handle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipFile;
import moai.patch.util.PatchUtil;

class PatchMergeFile
{
  static void mergeDiffFile(String paramString1, String paramString2, String paramString3)
    throws IOException
  {
    paramString2 = new BufferedReader(new FileReader(paramString2));
    paramString1 = new ZipFile(paramString1);
    paramString3 = new FileOutputStream(paramString3);
    for (;;)
    {
      Object localObject = paramString2.readLine();
      if (localObject == null) {
        break;
      }
      if (((String)localObject).startsWith("0"))
      {
        localObject = paramString1.getInputStream(PatchUtil.forceGetEntry(paramString1, ((String)localObject).substring(2, ((String)localObject).lastIndexOf("-"))));
        byte[] arrayOfByte = new byte[1024];
        for (;;)
        {
          int i = ((InputStream)localObject).read(arrayOfByte);
          if (i == -1) {
            break;
          }
          paramString3.write(arrayOfByte, 0, i);
        }
        ((InputStream)localObject).close();
      }
    }
    paramString3.close();
  }
  
  static int recover(String paramString1, String paramString2, String paramString3)
    throws Exception
  {
    paramString2 = new BufferedReader(new FileReader(paramString2));
    paramString1 = new FileInputStream(paramString1);
    int j = 0;
    for (;;)
    {
      Object localObject1 = paramString2.readLine();
      if (localObject1 == null) {
        break;
      }
      Object localObject2 = ((String)localObject1).substring(2, ((String)localObject1).lastIndexOf("-"));
      int i = Integer.parseInt(((String)localObject1).substring(((String)localObject1).lastIndexOf("-") + 1));
      localObject1 = new File(paramString3, (String)localObject2);
      PatchUtil.forceMkdir(((File)localObject1).getParentFile());
      localObject1 = new FileOutputStream((File)localObject1);
      localObject2 = new byte[1024];
      if (i > 0)
      {
        if (i > localObject2.length) {}
        for (int k = localObject2.length;; k = i)
        {
          k = paramString1.read((byte[])localObject2, 0, k);
          ((FileOutputStream)localObject1).write((byte[])localObject2, 0, k);
          i -= k;
          break;
        }
      }
      ((FileOutputStream)localObject1).close();
      j += 1;
    }
    paramString1.close();
    paramString2.close();
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.handle.PatchMergeFile
 * JD-Core Version:    0.7.0.1
 */