package com.tencent.token.global.taiji;

import android.content.Context;
import com.tmsdk.TMSDKContext;
import java.util.ArrayList;
import tmsdk.common.module.pgsdk.manager.ITaijiFactory;
import tmsdk.common.module.pgsdk.manager.ITaijiKVProfileManager;
import tmsdk.common.module.pgsdk.manager.ITaijiPreferenceManager;
import tmsdk.common.module.pgsdk.manager.ITaijiReportManager;
import tmsdk.common.module.pgsdk.manager.ITaijiSharkNetwork;
import tmsdk.common.module.pgsdk.manager.ITaijiTccCryptManager;
import tmsdk.common.module.pgsdk.manager.ITaijiThreadPoolManager;
import tmsdk.common.tcc.TccCryptor;

public class j
  implements ITaijiFactory
{
  public static String a(ArrayList<String> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      int j = paramArrayList.size();
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append((String)paramArrayList.get(i));
        if (i != j - 1) {
          localStringBuilder.append(",");
        }
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  public ITaijiKVProfileManager getKVProfileManager()
  {
    return k.a();
  }
  
  public ITaijiPreferenceManager getPreferenceManager(Context paramContext, String paramString, int paramInt)
  {
    return new l(paramString);
  }
  
  public ITaijiReportManager getReportManager()
  {
    new ITaijiReportManager()
    {
      public void reportString(int paramAnonymousInt, ArrayList<String> paramAnonymousArrayList)
      {
        TMSDKContext.SaveStringData(paramAnonymousInt, j.a(paramAnonymousArrayList));
      }
    };
  }
  
  public ITaijiSharkNetwork getSharkNetwork()
  {
    return m.a();
  }
  
  public ITaijiTccCryptManager getTccCryptManager()
  {
    new ITaijiTccCryptManager()
    {
      public byte[] decrypt(byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2)
      {
        return TccCryptor.decrypt(paramAnonymousArrayOfByte1, paramAnonymousArrayOfByte2);
      }
      
      public byte[] encrypt(byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2)
      {
        return TccCryptor.encrypt(paramAnonymousArrayOfByte1, paramAnonymousArrayOfByte2);
      }
      
      public byte[] makePassword(byte[] paramAnonymousArrayOfByte)
      {
        return TccCryptor.makePassword(paramAnonymousArrayOfByte);
      }
    };
  }
  
  public ITaijiThreadPoolManager getThreadPoolManager()
  {
    return n.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.j
 * JD-Core Version:    0.7.0.1
 */