package com.tencent.token;

import com.tmsdk.TMSDKContext;
import java.util.ArrayList;
import tmsdk.common.tcc.TccCryptor;

public final class xk
  implements ase
{
  public final asg a(String paramString)
  {
    return new xm(paramString);
  }
  
  public final asi a()
  {
    return xn.a.a();
  }
  
  public final asf b()
  {
    return xl.a.a();
  }
  
  public final ask c()
  {
    return xo.a.a();
  }
  
  public final ash d()
  {
    new ash()
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
  
  public final asj e()
  {
    new asj()
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
 * Qualified Name:     com.tencent.token.xk
 * JD-Core Version:    0.7.0.1
 */