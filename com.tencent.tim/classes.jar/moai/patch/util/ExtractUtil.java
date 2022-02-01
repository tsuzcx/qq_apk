package moai.patch.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import moai.patch.handle.DexPatch;
import moai.patch.log.PatchLog;

public class ExtractUtil
{
  private static final int CENTRAL_DIRECTORY_BEGIN_SIGNATURE = 33639248;
  private static final int CENTRAL_DIRECTORY_END_SIGNATURE = 101010256;
  private static final int DATA_DESCRIPTOR_SIGNATURE = 134695760;
  private static final int DEX_JUMP_BEGIN_SIGNATURE = 269044560;
  private static final int DEX_JUMP_END_SIGNATURE = 285821776;
  private static final int FILE_HEADER_SIGNATURE = 67324752;
  
  public static void extractAllDexExcept(String paramString, File paramFile1, File paramFile2, File[] paramArrayOfFile)
    throws IOException
  {
    Object localObject = new ZipFile(paramString).entries();
    ArrayList localArrayList = new ArrayList();
    String str1;
    while (((Enumeration)localObject).hasMoreElements())
    {
      str1 = ((ZipEntry)((Enumeration)localObject).nextElement()).getName();
      if ((str1.startsWith("classes")) && (str1.endsWith(".dex")) && (!str1.equals("classes.dex"))) {
        localArrayList.add(str1);
      }
    }
    if (localArrayList.size() > 0)
    {
      localObject = localArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        str1 = (String)((Iterator)localObject).next();
        int j = 1;
        int i = 1;
        int k = j;
        if (paramArrayOfFile != null)
        {
          k = j;
          if (paramArrayOfFile.length > 0)
          {
            int m = paramArrayOfFile.length;
            j = 0;
            for (;;)
            {
              k = i;
              if (j >= m) {
                break;
              }
              if (paramArrayOfFile[j].getName().contains(str1)) {
                i = 0;
              }
              j += 1;
            }
          }
        }
        if (k != 0)
        {
          String str2 = paramFile2 + File.separator + str1;
          extractFile(paramString, str1, str2);
          DexPatch.renameToPatchDex(paramFile1.getName(), new File(str2));
        }
      }
    }
    PatchLog.i(9008, "dex size:" + localArrayList.size());
  }
  
  private static void extractFile(File paramFile, String paramString1, String paramString2)
    throws IOException
  {
    paramFile = new ZipFile(paramFile);
    paramString1 = PatchUtil.forceGetEntry(paramFile, paramString1);
    paramString2 = new File(paramString2);
    PatchUtil.forceMkdir(paramString2.getParentFile());
    paramString2 = new BufferedOutputStream(new FileOutputStream(paramString2));
    paramFile = new BufferedInputStream(paramFile.getInputStream(paramString1));
    paramString1 = new byte[2048];
    for (;;)
    {
      int i = paramFile.read(paramString1);
      if (i <= 0) {
        break;
      }
      paramString2.write(paramString1, 0, i);
    }
    paramString2.flush();
    paramString2.close();
    paramFile.close();
  }
  
  public static void extractFile(String paramString1, String paramString2, String paramString3)
    throws IOException
  {
    extractFile(new File(paramString1), paramString2, paramString3);
  }
  
  public static List<File> subZip(String paramString1, String paramString2, String paramString3, String paramString4)
    throws IOException
  {
    long l4 = System.currentTimeMillis();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap4 = new HashMap();
    short s = (short)paramString2.getBytes().length;
    long l3 = 0L;
    paramString1 = new RandomAccessFile(paramString1, "r");
    long l1 = paramString1.length() - 4L;
    long l2 = l3;
    int j;
    int k;
    Object localObject2;
    if (l1 >= 0L)
    {
      paramString1.seek(l1);
      i = Integer.reverseBytes(paramString1.readInt());
      if (i == 269044560)
      {
        PatchLog.d("enter fast mode");
        try
        {
          i = Integer.reverseBytes(paramString1.readInt());
          l2 = l3;
          if (i == 285821776) {
            break label567;
          }
          l2 = paramString1.getFilePointer();
          paramString1.seek(i);
          localByteBuffer1 = ByteBuffer.allocate(s + 46);
          localByteBuffer1.putInt(Integer.reverseBytes(33639248));
          paramString1.read(localByteBuffer1.array(), 4, 16);
          i = Integer.reverseBytes(paramString1.readInt());
          paramString1.seek(paramString1.getFilePointer() - 4L);
          paramString1.read(localByteBuffer1.array(), 20, 8);
          localByteBuffer1.position(localByteBuffer1.position() + 24);
          j = Short.reverseBytes(paramString1.readShort());
          paramString1.skipBytes(12);
          k = Integer.reverseBytes(paramString1.readInt());
          localObject2 = new byte[j];
          paramString1.read((byte[])localObject2);
          localObject2 = new String((byte[])localObject2);
          localByteBuffer1.putShort(Short.reverseBytes(s));
          localByteBuffer1.position(localByteBuffer1.position() + 16);
          localByteBuffer1.put(paramString2.getBytes());
          PatchLog.d("expectedName " + (String)localObject2 + " found, compressedSize: " + i + ", lfhOffset:" + k);
          if ((!((String)localObject2).endsWith(paramString3)) || (((String)localObject2).equals(paramString2)) || (k < 0) || (k >= paramString1.length())) {
            throw new IllegalArgumentException("illegal filename or offset");
          }
        }
        catch (Throwable localThrowable)
        {
          PatchLog.e(9009, "fast mode failed:", localThrowable);
          localHashMap2.clear();
          localHashMap3.clear();
          localHashMap4.clear();
          localHashMap1.clear();
        }
      }
      while (i != 101010256) {
        for (;;)
        {
          ByteBuffer localByteBuffer1;
          l1 -= 1L;
          break;
          localHashMap2.put(localObject2, Integer.valueOf(k));
          localHashMap3.put(localObject2, Integer.valueOf(i));
          localHashMap4.put(localObject2, localThrowable);
          localHashMap1.put(localObject2, new File(paramString4 + ((String)localObject2).subSequence(0, ((String)localObject2).length() - paramString3.length()) + ".zip"));
          paramString1.seek(l2);
        }
      }
      paramString1.skipBytes(12);
      l2 = Integer.reverseBytes(paramString1.readInt());
    }
    label567:
    PatchLog.d("found ecod cost +" + (System.currentTimeMillis() - l4) + "ms");
    int m;
    int n;
    Object localObject1;
    if (localHashMap1.size() == 0)
    {
      PatchLog.d("enter search mode");
      paramString1.seek(l2);
      do
      {
        for (;;)
        {
          i = Integer.reverseBytes(paramString1.readInt());
          if (i != 33639248) {
            break;
          }
          l1 = paramString1.getFilePointer();
          paramString1.skipBytes(16);
          i = Integer.reverseBytes(paramString1.readInt());
          paramString1.skipBytes(4);
          j = Short.reverseBytes(paramString1.readShort());
          k = Short.reverseBytes(paramString1.readShort());
          m = Short.reverseBytes(paramString1.readShort());
          paramString1.skipBytes(8);
          n = Integer.reverseBytes(paramString1.readInt());
          localObject1 = new byte[j];
          paramString1.read((byte[])localObject1);
          l2 = paramString1.getFilePointer();
          localObject1 = new String((byte[])localObject1);
          if ((((String)localObject1).endsWith(paramString3)) && (!((String)localObject1).equals(paramString2)))
          {
            paramString1.seek(l1);
            localObject2 = ByteBuffer.allocate(s + 46);
            ((ByteBuffer)localObject2).putInt(Integer.reverseBytes(33639248));
            paramString1.read(((ByteBuffer)localObject2).array(), 4, 24);
            ((ByteBuffer)localObject2).position(((ByteBuffer)localObject2).position() + 24);
            ((ByteBuffer)localObject2).putShort(Short.reverseBytes(s));
            ((ByteBuffer)localObject2).position(((ByteBuffer)localObject2).position() + 16);
            ((ByteBuffer)localObject2).put(paramString2.getBytes());
            PatchLog.d("expectedName " + (String)localObject1 + " found, compressedSize: " + i);
            localHashMap2.put(localObject1, Integer.valueOf(n));
            localHashMap3.put(localObject1, Integer.valueOf(i));
            localHashMap4.put(localObject1, localObject2);
            localHashMap1.put(localObject1, new File(paramString4 + ((String)localObject1).subSequence(0, ((String)localObject1).length() - paramString3.length()) + ".zip"));
          }
          paramString1.seek(k + l2 + m);
        }
      } while (i != 101010256);
    }
    PatchLog.d("found dir cost +" + (System.currentTimeMillis() - l4) + "ms");
    paramString3 = localHashMap1.keySet().iterator();
    ByteBuffer localByteBuffer2;
    while (paramString3.hasNext())
    {
      localObject2 = (String)paramString3.next();
      localObject1 = ((File)localHashMap1.get(localObject2)).getAbsolutePath();
      paramString4 = (ByteBuffer)localHashMap4.get(localObject2);
      j = ((Integer)localHashMap2.get(localObject2)).intValue();
      paramString1.seek(j);
      if (Integer.reverseBytes(paramString1.readInt()) == 67324752)
      {
        localObject1 = new BufferedOutputStream(new FileOutputStream((String)localObject1));
        localByteBuffer2 = ByteBuffer.allocate(s + 30);
        localByteBuffer2.putInt(Integer.reverseBytes(67324752));
        paramString1.read(localByteBuffer2.array(), 4, 2);
        if ((Short.reverseBytes(paramString1.readShort()) & 0x8) == 0) {
          break label1806;
        }
        PatchLog.d("Has data descriptor after file content!");
      }
    }
    label1806:
    for (int i = 1;; i = 0)
    {
      paramString1.seek(paramString1.getFilePointer() - 2L);
      paramString1.read(localByteBuffer2.array(), 6, 20);
      localByteBuffer2.position(localByteBuffer2.position() + 22);
      paramString1.seek(j + 14);
      int i1 = ((Integer)localHashMap3.get(localObject2)).intValue();
      PatchLog.d("file " + (String)localObject2 + " - crc: " + Integer.reverseBytes(paramString1.readInt()));
      PatchLog.d("file " + (String)localObject2 + " - compressed: " + Integer.reverseBytes(paramString1.readInt()));
      PatchLog.d("file " + (String)localObject2 + " - uncompressed: " + Integer.reverseBytes(paramString1.readInt()));
      localByteBuffer2.putShort(Short.reverseBytes(s));
      localByteBuffer2.putShort((short)0);
      localByteBuffer2.put(paramString2.getBytes());
      ((OutputStream)localObject1).write(localByteBuffer2.array());
      int i2 = localByteBuffer2.array().length;
      paramString1.seek(j + 26);
      j = Short.reverseBytes(paramString1.readShort());
      k = Short.reverseBytes(paramString1.readShort());
      localObject2 = new byte[j];
      paramString1.readFully((byte[])localObject2);
      PatchLog.d("file - expectedName: " + new String((byte[])localObject2));
      paramString1.skipBytes(k);
      localObject2 = new byte[i1];
      j = 0;
      while (j < i1)
      {
        m = paramString1.read((byte[])localObject2);
        if (m == -1) {
          break;
        }
        n = i1 - j;
        k = n;
        if (m <= n) {
          k = m;
        }
        ((OutputStream)localObject1).write((byte[])localObject2, 0, k);
        j += m;
      }
      k = 0 + i2 + j;
      j = k;
      if (i != 0)
      {
        j = k;
        if (Integer.reverseBytes(paramString1.readInt()) == 134695760)
        {
          PatchLog.d("copy data descriptor part");
          localObject2 = new byte[12];
          paramString1.readFully((byte[])localObject2);
          ((OutputStream)localObject1).write((byte[])localObject2);
          j = k + 12;
        }
      }
      localObject2 = ByteBuffer.allocate(22);
      ((ByteBuffer)localObject2).putInt(Integer.reverseBytes(101010256));
      ((ByteBuffer)localObject2).putShort((short)0);
      ((ByteBuffer)localObject2).putShort((short)0);
      ((ByteBuffer)localObject2).putShort(Short.reverseBytes((short)1));
      ((ByteBuffer)localObject2).putShort(Short.reverseBytes((short)1));
      ((ByteBuffer)localObject2).putInt(Integer.reverseBytes(paramString4.array().length));
      ((ByteBuffer)localObject2).putInt(Integer.reverseBytes(j));
      ((ByteBuffer)localObject2).putShort((short)0);
      ((OutputStream)localObject1).write(paramString4.array());
      ((OutputStream)localObject1).write(((ByteBuffer)localObject2).array());
      ((OutputStream)localObject1).close();
      break;
      PatchLog.d("copy files cost +" + (System.currentTimeMillis() - l4) + "ms");
      paramString1 = new ArrayList();
      paramString1.addAll(localHashMap1.values());
      return paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.util.ExtractUtil
 * JD-Core Version:    0.7.0.1
 */