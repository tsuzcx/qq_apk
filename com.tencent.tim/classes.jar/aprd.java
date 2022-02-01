import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class aprd
{
  public static ArrayList<aprd.a> a(long paramLong, DataInputStream paramDataInputStream, int paramInt1, int paramInt2)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    paramDataInputStream.read(new byte[10]);
    paramDataInputStream.read(new byte[3]);
    paramDataInputStream.readByte();
    paramDataInputStream.readInt();
    paramDataInputStream.readInt();
    paramDataInputStream.readInt();
    paramDataInputStream.readInt();
    paramDataInputStream.readByte();
    paramDataInputStream.readByte();
    paramDataInputStream.readByte();
    paramDataInputStream.readByte();
    int i = paramDataInputStream.readShort();
    paramDataInputStream.read(new byte[i]);
    int j = paramDataInputStream.readShort();
    paramDataInputStream.read(new byte[j]);
    int m;
    for (i = i + 36 + 2 + j; i < paramInt1; i = i + 3 + m)
    {
      int k = paramDataInputStream.readByte();
      m = paramDataInputStream.readShort();
      j = 0;
      Object localObject1 = null;
      Object localObject4 = null;
      if (j < m)
      {
        int i1 = paramDataInputStream.readByte();
        int n = paramDataInputStream.readShort();
        Object localObject5 = new byte[n];
        paramDataInputStream.read((byte[])localObject5);
        Object localObject2;
        Object localObject3;
        if (k == 3) {
          if (i1 == 2)
          {
            localObject5 = new String((byte[])localObject5);
            if (((String)localObject5).startsWith("{"))
            {
              i1 = ((String)localObject5).lastIndexOf('}');
              localObject2 = localObject4;
              localObject3 = localObject1;
              if (i1 != -1)
              {
                localObject2 = localObject4;
                localObject3 = localObject1;
                if (((String)localObject5).length() > 1)
                {
                  localObject2 = ((String)localObject5).substring(1, i1).replaceAll("-", "").toUpperCase();
                  localObject3 = localObject1;
                }
              }
            }
          }
        }
        for (;;)
        {
          j = j + 3 + n;
          localObject4 = localObject2;
          localObject1 = localObject3;
          break;
          i1 = ((String)localObject5).lastIndexOf('.');
          localObject2 = localObject4;
          localObject3 = localObject1;
          if (i1 != -1)
          {
            localObject2 = localObject4;
            localObject3 = localObject1;
            if (((String)localObject5).length() > 1)
            {
              localObject2 = ((String)localObject5).substring(0, i1).toUpperCase();
              localObject3 = localObject1;
              continue;
              localObject2 = localObject4;
              localObject3 = localObject1;
              if (i1 == 4)
              {
                long l = d((byte[])localObject5);
                localObject2 = localObject4;
                localObject3 = localObject1;
                if (!TextUtils.isEmpty(localObject4))
                {
                  localObject2 = localObject4;
                  localObject3 = localObject1;
                  if (l != -1L)
                  {
                    localObject3 = localObject1;
                    if (localObject1 == null) {
                      localObject3 = new aprd.a();
                    }
                    ((aprd.a)localObject3).groupUin = paramLong;
                    ((aprd.a)localObject3).msgTime = paramInt2;
                    ((aprd.a)localObject3).fileId = l;
                    ((aprd.a)localObject3).fileMd5 = localObject4;
                    localArrayList.add(localObject3);
                    localObject2 = localObject4;
                    continue;
                    if (k == 5)
                    {
                      localObject2 = localObject4;
                      localObject3 = localObject1;
                      if (i1 == 255)
                      {
                        localObject2 = localObject4;
                        localObject3 = localObject1;
                      }
                    }
                    else
                    {
                      localObject2 = localObject4;
                      localObject3 = localObject1;
                      if (k == 6)
                      {
                        localObject2 = localObject4;
                        localObject3 = localObject1;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static ArrayList<aprd.a> a(long paramLong, byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    ArrayList localArrayList1 = new ArrayList();
    HashMap localHashMap = new HashMap();
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    DataInputStream localDataInputStream = new DataInputStream(paramArrayOfByte);
    int i = 0;
    while (i < paramInt)
    {
      localDataInputStream.readShort();
      localDataInputStream.readShort();
      localDataInputStream.readInt();
      localDataInputStream.readInt();
      localDataInputStream.readInt();
      localDataInputStream.readByte();
      localDataInputStream.readInt();
      localDataInputStream.readInt();
      int j = localDataInputStream.readInt();
      localDataInputStream.readInt();
      ArrayList localArrayList2 = a(paramLong, localDataInputStream, localDataInputStream.readShort(), j);
      int k = localArrayList2.size();
      j = 0;
      while (j < k)
      {
        aprd.a locala = (aprd.a)localArrayList2.get(j);
        if (!localHashMap.containsKey(Long.valueOf(locala.fileId)))
        {
          localArrayList1.add(locala);
          localHashMap.put(Long.valueOf(locala.fileId), Boolean.valueOf(true));
        }
        j += 1;
      }
      i += 1;
    }
    localDataInputStream.close();
    paramArrayOfByte.close();
    localHashMap.clear();
    return localArrayList1;
  }
  
  public static long d(byte[] paramArrayOfByte)
  {
    long l = 0L;
    int i = 0;
    while (i < 4)
    {
      l += ((paramArrayOfByte[i] & 0xFF) << (3 - i) * 8);
      i += 1;
    }
    return l;
  }
  
  public static class a
  {
    public long fileId;
    public String fileMd5;
    public long groupUin;
    public int msgTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aprd
 * JD-Core Version:    0.7.0.1
 */