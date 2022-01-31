package oicq.wlogin_sdk.b;

import java.util.List;
import oicq.wlogin_sdk.tools.util;

public class bd
  extends a
{
  public bd()
  {
    this.g = 363;
  }
  
  public byte[] a(List<String> paramList)
  {
    int k;
    int i;
    if (paramList != null)
    {
      k = paramList.size();
      i = 0;
      j = 0;
      while (j < k)
      {
        i += 2;
        if (paramList.get(j) == null) {
          break label198;
        }
        i = ((String)paramList.get(j)).length() + i;
        j += 1;
      }
    }
    for (int j = k;; j = 0)
    {
      byte[] arrayOfByte1 = new byte[i + 2];
      util.int16_to_buf(arrayOfByte1, 0, j);
      if (paramList != null)
      {
        i = 2;
        k = 0;
        if (k < j)
        {
          if (paramList.get(k) != null)
          {
            byte[] arrayOfByte2 = ((String)paramList.get(k)).getBytes();
            util.int16_to_buf(arrayOfByte1, i, arrayOfByte2.length);
            i += 2;
            System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i, arrayOfByte2.length);
            i = arrayOfByte2.length + i;
          }
          for (;;)
          {
            k += 1;
            break;
            util.int16_to_buf(arrayOfByte1, i, 0);
            i += 2;
          }
        }
      }
      a(this.g);
      b(arrayOfByte1, arrayOfByte1.length);
      d();
      return a();
      label198:
      break;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.bd
 * JD-Core Version:    0.7.0.1
 */