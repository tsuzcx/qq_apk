package com.huawei.hianalytics.ab.bc.de;

import android.text.TextUtils;
import com.huawei.hianalytics.ab.bc.ab.bc;
import com.huawei.hianalytics.ab.bc.ab.bc.ab;
import com.huawei.hianalytics.ab.bc.ab.fg;
import com.huawei.hianalytics.ab.bc.ef.ab;

public class gh
{
  private static gh ab = new gh();
  private ab bc = new ab();
  
  public static gh ab()
  {
    return ab;
  }
  
  /* Error */
  private String fg()
  {
    // Byte code:
    //   0: invokestatic 36	com/huawei/hianalytics/ab/ab/bc:ik	()Landroid/content/Context;
    //   3: invokevirtual 42	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   6: invokevirtual 48	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   9: ldc 50
    //   11: invokevirtual 56	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   14: astore_2
    //   15: aload_2
    //   16: astore_1
    //   17: aload_2
    //   18: invokestatic 61	com/huawei/hianalytics/ab/bc/kl/de:ab	(Ljava/io/InputStream;)Ljava/lang/String;
    //   21: astore_3
    //   22: aload_2
    //   23: invokestatic 64	com/huawei/hianalytics/ab/bc/kl/de:ab	(Ljava/io/Closeable;)V
    //   26: aload_3
    //   27: areturn
    //   28: astore_1
    //   29: aconst_null
    //   30: astore_2
    //   31: aload_2
    //   32: astore_1
    //   33: ldc 66
    //   35: ldc 68
    //   37: invokestatic 74	com/huawei/hianalytics/ab/bc/ef/ab:cd	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload_2
    //   41: invokestatic 64	com/huawei/hianalytics/ab/bc/kl/de:ab	(Ljava/io/Closeable;)V
    //   44: aconst_null
    //   45: areturn
    //   46: astore_1
    //   47: aconst_null
    //   48: astore_3
    //   49: aload_1
    //   50: astore_2
    //   51: aload_3
    //   52: invokestatic 64	com/huawei/hianalytics/ab/bc/kl/de:ab	(Ljava/io/Closeable;)V
    //   55: aload_2
    //   56: athrow
    //   57: astore_2
    //   58: aload_1
    //   59: astore_3
    //   60: goto -9 -> 51
    //   63: astore_1
    //   64: goto -33 -> 31
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	gh
    //   16	1	1	localObject1	Object
    //   28	1	1	localIOException1	java.io.IOException
    //   32	1	1	localObject2	Object
    //   46	13	1	localObject3	Object
    //   63	1	1	localIOException2	java.io.IOException
    //   14	42	2	localObject4	Object
    //   57	1	2	localObject5	Object
    //   21	39	3	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   0	15	28	java/io/IOException
    //   0	15	46	finally
    //   17	22	57	finally
    //   33	40	57	finally
    //   17	22	63	java/io/IOException
  }
  
  public void bc()
  {
    long l1 = ef();
    if (l1 == 0L)
    {
      l1 = System.currentTimeMillis();
      str1 = fg();
      if (TextUtils.isEmpty(str1)) {
        ab.cd("hmsSdk", "get rsa pubkey config error");
      }
    }
    long l2;
    do
    {
      return;
      str2 = bc.ab().bc(bc.ab.ab);
      String str3 = bc.ab().ab(bc.ab.bc).bc(str1, str2);
      this.bc.ab(str1);
      this.bc.ab(l1);
      this.bc.bc(str2);
      this.bc.cd(str3);
      return;
      l2 = System.currentTimeMillis();
    } while (l2 - l1 <= 43200000L);
    String str2 = this.bc.ab;
    String str1 = bc.ab().bc(bc.ab.ab);
    str2 = bc.ab().ab(bc.ab.bc).bc(str2, str1);
    this.bc.ab(l2);
    this.bc.bc(str1);
    this.bc.cd(str2);
  }
  
  public String cd()
  {
    return this.bc.bc;
  }
  
  public String de()
  {
    return this.bc.cd;
  }
  
  public long ef()
  {
    return this.bc.de;
  }
  
  class ab
  {
    String ab;
    String bc;
    String cd;
    long de = 0L;
    
    ab() {}
    
    void ab(long paramLong)
    {
      gh.ab(gh.this).de = paramLong;
    }
    
    void ab(String paramString)
    {
      gh.ab(gh.this).ab = paramString;
    }
    
    void bc(String paramString)
    {
      gh.ab(gh.this).bc = paramString;
    }
    
    void cd(String paramString)
    {
      gh.ab(gh.this).cd = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.bc.de.gh
 * JD-Core Version:    0.7.0.1
 */