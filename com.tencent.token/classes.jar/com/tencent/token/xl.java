package com.tencent.token;

import com.tmsdk.TMSDKContext;
import java.util.ArrayList;
import tmsdk.common.tcc.TccCryptor;

public final class xl
  implements asf
{
  public final ash a(String paramString)
  {
    return new xn(paramString);
  }
  
  public final asj a()
  {
    return xo.a.a();
  }
  
  public final asg b()
  {
    return xm.a.a();
  }
  
  public final asl c()
  {
    return xp.a.a();
  }
  
  public final asi d()
  {
    new asi()
    {
      public final void a(int paramAnonymousInt, ArrayList<String> paramAnonymousArrayList)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        if (paramAnonymousArrayList.size() > 0)
        {
          int j = paramAnonymousArrayList.size();
          int i = 0;
          while (i < j)
          {
            localStringBuilder.append((String)paramAnonymousArrayList.get(i));
            if (i != j - 1) {
              localStringBuilder.append(",");
            }
            i += 1;
          }
        }
        TMSDKContext.SaveStringData(paramAnonymousInt, localStringBuilder.toString());
      }
    };
  }
  
  public final ask e()
  {
    new ask()
    {
      public final byte[] a(byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2)
      {
        return TccCryptor.encrypt(paramAnonymousArrayOfByte1, paramAnonymousArrayOfByte2);
      }
      
      public final byte[] b(byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2)
      {
        return TccCryptor.decrypt(paramAnonymousArrayOfByte1, paramAnonymousArrayOfByte2);
      }
    };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.xl
 * JD-Core Version:    0.7.0.1
 */