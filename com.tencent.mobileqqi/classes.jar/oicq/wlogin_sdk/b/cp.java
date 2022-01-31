package oicq.wlogin_sdk.b;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

public class cp
  extends a
{
  public cp()
  {
    this.g = 1297;
  }
  
  public byte[] a(List<String> paramList)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(1024);
    localByteBuffer.putShort((short)paramList.size());
    Iterator localIterator = paramList.iterator();
    int i;
    int k;
    int j;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        paramList = (String)localIterator.next();
        if ((paramList != null) && (paramList.length() != 0))
        {
          i = paramList.indexOf('(');
          k = paramList.indexOf(')');
          if ((i == 0) && (k > 0))
          {
            j = Integer.valueOf(paramList.substring(i + 1, k)).intValue();
            if ((0x100000 & j) > 0)
            {
              i = 1;
              label116:
              if ((j & 0x8000000) <= 0) {
                break label193;
              }
              j = 1;
              label127:
              if (i == 0) {
                break label235;
              }
            }
          }
        }
      }
    }
    label193:
    label235:
    for (byte b1 = (byte)1;; b1 = 0)
    {
      byte b2 = b1;
      if (j != 0) {
        b2 = (byte)(b1 | 0x2);
      }
      paramList = paramList.substring(k + 1);
      for (;;)
      {
        localByteBuffer.put(b2);
        localByteBuffer.putShort((short)paramList.length());
        localByteBuffer.put(paramList.getBytes());
        break;
        i = 0;
        break label116;
        j = 0;
        break label127;
        b2 = 1;
      }
      a(this.g);
      b(localByteBuffer.array(), localByteBuffer.position());
      d();
      return a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.cp
 * JD-Core Version:    0.7.0.1
 */