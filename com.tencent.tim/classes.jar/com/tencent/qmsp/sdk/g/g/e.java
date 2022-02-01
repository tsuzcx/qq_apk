package com.tencent.qmsp.sdk.g.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Looper;

public class e
{
  public static final e f = new e();
  public d a;
  public String b;
  public String c;
  public final Object d = new Object();
  public ServiceConnection e = new e.a(this);
  
  public String a(Context paramContext, String paramString)
  {
    for (;;)
    {
      try
      {
        if (Looper.myLooper() == Looper.getMainLooper()) {
          break;
        }
        if (this.a == null)
        {
          ??? = new Intent();
          ((Intent)???).setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
          ((Intent)???).setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
          if (paramContext.bindService((Intent)???, this.e, 1)) {}
          synchronized (this.d)
          {
            try
            {
              this.d.wait(3000L);
              ??? = this.a;
              if (??? == null)
              {
                paramContext = "";
                return paramContext;
              }
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
              continue;
            }
          }
        }
        try
        {
          paramContext = b(paramContext, paramString);
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
        }
      }
      finally {}
    }
    throw new IllegalStateException("Cannot run on MainThread");
  }
  
  public boolean a(Context paramContext)
  {
    boolean bool = true;
    try
    {
      paramContext = paramContext.getPackageManager();
      paramContext = paramContext.getPackageInfo("com.heytap.openid", 0);
      if (Build.VERSION.SDK_INT >= 28)
      {
        if (paramContext != null) {
          if (paramContext.getLongVersionCode() >= 1L) {
            return bool;
          }
        }
      }
      else if (paramContext != null)
      {
        int i = paramContext.versionCode;
        if (i >= 1) {
          return bool;
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      return false;
    }
    bool = false;
    return bool;
  }
  
  /* Error */
  public final String b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: getfield 131	com/tencent/qmsp/sdk/g/g/e:b	Ljava/lang/String;
    //   7: invokestatic 137	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +11 -> 21
    //   13: aload_0
    //   14: aload_1
    //   15: invokevirtual 141	android/content/Context:getPackageName	()Ljava/lang/String;
    //   18: putfield 131	com/tencent/qmsp/sdk/g/g/e:b	Ljava/lang/String;
    //   21: aload_0
    //   22: getfield 143	com/tencent/qmsp/sdk/g/g/e:c	Ljava/lang/String;
    //   25: invokestatic 137	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifeq +145 -> 173
    //   31: aload_0
    //   32: getfield 131	com/tencent/qmsp/sdk/g/g/e:b	Ljava/lang/String;
    //   35: astore 4
    //   37: aload_1
    //   38: invokevirtual 105	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   41: aload 4
    //   43: bipush 64
    //   45: invokevirtual 111	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   48: getfield 147	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   51: astore 4
    //   53: aload 5
    //   55: astore_1
    //   56: aload 4
    //   58: ifnull +110 -> 168
    //   61: aload 5
    //   63: astore_1
    //   64: aload 4
    //   66: arraylength
    //   67: ifle +101 -> 168
    //   70: aload 4
    //   72: iconst_0
    //   73: aaload
    //   74: invokevirtual 153	android/content/pm/Signature:toByteArray	()[B
    //   77: astore 4
    //   79: ldc 155
    //   81: invokestatic 161	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   84: astore 6
    //   86: aload 5
    //   88: astore_1
    //   89: aload 6
    //   91: ifnull +77 -> 168
    //   94: aload 6
    //   96: aload 4
    //   98: invokevirtual 165	java/security/MessageDigest:digest	([B)[B
    //   101: astore_1
    //   102: new 167	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   109: astore 4
    //   111: iconst_0
    //   112: istore_3
    //   113: iload_3
    //   114: aload_1
    //   115: arraylength
    //   116: if_icmpge +46 -> 162
    //   119: aload 4
    //   121: aload_1
    //   122: iload_3
    //   123: baload
    //   124: sipush 255
    //   127: iand
    //   128: sipush 256
    //   131: ior
    //   132: invokestatic 174	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   135: iconst_1
    //   136: iconst_3
    //   137: invokevirtual 180	java/lang/String:substring	(II)Ljava/lang/String;
    //   140: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: iload_3
    //   145: iconst_1
    //   146: iadd
    //   147: istore_3
    //   148: goto -35 -> 113
    //   151: astore_1
    //   152: aload_1
    //   153: invokevirtual 127	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   156: aconst_null
    //   157: astore 4
    //   159: goto -106 -> 53
    //   162: aload 4
    //   164: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: astore_1
    //   168: aload_0
    //   169: aload_1
    //   170: putfield 143	com/tencent/qmsp/sdk/g/g/e:c	Ljava/lang/String;
    //   173: aload_0
    //   174: getfield 49	com/tencent/qmsp/sdk/g/g/e:a	Lcom/tencent/qmsp/sdk/g/g/d;
    //   177: checkcast 189	com/tencent/qmsp/sdk/g/g/d$a$a
    //   180: aload_0
    //   181: getfield 131	com/tencent/qmsp/sdk/g/g/e:b	Ljava/lang/String;
    //   184: aload_0
    //   185: getfield 143	com/tencent/qmsp/sdk/g/g/e:c	Ljava/lang/String;
    //   188: aload_2
    //   189: invokevirtual 192	com/tencent/qmsp/sdk/g/g/d$a$a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   192: astore_2
    //   193: aload_2
    //   194: astore_1
    //   195: aload_2
    //   196: invokestatic 137	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   199: ifeq +6 -> 205
    //   202: ldc 85
    //   204: astore_1
    //   205: aload_1
    //   206: areturn
    //   207: astore_1
    //   208: aload_1
    //   209: invokevirtual 193	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   212: aload 5
    //   214: astore_1
    //   215: goto -47 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	e
    //   0	218	1	paramContext	Context
    //   0	218	2	paramString	String
    //   112	36	3	i	int
    //   35	128	4	localObject1	Object
    //   1	212	5	localObject2	Object
    //   84	11	6	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   37	53	151	android/content/pm/PackageManager$NameNotFoundException
    //   79	86	207	java/security/NoSuchAlgorithmException
    //   94	111	207	java/security/NoSuchAlgorithmException
    //   113	144	207	java/security/NoSuchAlgorithmException
    //   162	168	207	java/security/NoSuchAlgorithmException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.g.e
 * JD-Core Version:    0.7.0.1
 */