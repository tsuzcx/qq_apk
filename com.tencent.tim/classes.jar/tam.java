import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.BaseApplication;

public class tam
{
  public static boolean NB()
  {
    boolean bool = false;
    if (Build.VERSION.SDK_INT >= 18) {}
    try
    {
      bool = BaseApplication.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  /* Error */
  public static tal a(java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +243 -> 247
    //   7: new 47	tal
    //   10: dup
    //   11: invokespecial 50	tal:<init>	()V
    //   14: astore_2
    //   15: new 52	org/json/JSONObject
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 55	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   23: astore_0
    //   24: aload_0
    //   25: ldc 57
    //   27: invokevirtual 60	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   30: ifeq +170 -> 200
    //   33: aload_0
    //   34: ldc 57
    //   36: invokevirtual 64	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   39: istore_1
    //   40: aload_2
    //   41: iload_1
    //   42: putfield 66	tal:priority	I
    //   45: aload_0
    //   46: ldc 68
    //   48: invokevirtual 60	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   51: ifeq +154 -> 205
    //   54: aload_0
    //   55: ldc 68
    //   57: invokevirtual 64	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   60: istore_1
    //   61: aload_2
    //   62: iload_1
    //   63: putfield 71	tal:bAK	I
    //   66: aload_0
    //   67: ldc 73
    //   69: invokevirtual 60	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   72: ifeq +60 -> 132
    //   75: aload_0
    //   76: ldc 73
    //   78: invokevirtual 77	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   81: astore_3
    //   82: aload_3
    //   83: ldc 79
    //   85: invokevirtual 60	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   88: ifeq +122 -> 210
    //   91: aload_3
    //   92: ldc 79
    //   94: invokevirtual 64	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   97: sipush 1000
    //   100: imul
    //   101: istore_1
    //   102: aload_2
    //   103: iload_1
    //   104: putfield 82	tal:bAM	I
    //   107: aload_3
    //   108: ldc 84
    //   110: invokevirtual 60	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   113: ifeq +102 -> 215
    //   116: aload_3
    //   117: ldc 84
    //   119: invokevirtual 64	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   122: sipush 1000
    //   125: imul
    //   126: istore_1
    //   127: aload_2
    //   128: iload_1
    //   129: putfield 87	tal:bAL	I
    //   132: aload_0
    //   133: ldc 89
    //   135: invokevirtual 60	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   138: ifeq +60 -> 198
    //   141: aload_0
    //   142: ldc 89
    //   144: invokevirtual 77	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   147: astore_0
    //   148: aload_0
    //   149: ldc 79
    //   151: invokevirtual 60	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   154: ifeq +66 -> 220
    //   157: aload_0
    //   158: ldc 79
    //   160: invokevirtual 64	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   163: sipush 1000
    //   166: imul
    //   167: istore_1
    //   168: aload_2
    //   169: iload_1
    //   170: putfield 92	tal:bAO	I
    //   173: aload_0
    //   174: ldc 84
    //   176: invokevirtual 60	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   179: ifeq +46 -> 225
    //   182: aload_0
    //   183: ldc 84
    //   185: invokevirtual 64	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   188: sipush 1000
    //   191: imul
    //   192: istore_1
    //   193: aload_2
    //   194: iload_1
    //   195: putfield 95	tal:bAN	I
    //   198: aload_2
    //   199: areturn
    //   200: iconst_0
    //   201: istore_1
    //   202: goto -162 -> 40
    //   205: iconst_0
    //   206: istore_1
    //   207: goto -146 -> 61
    //   210: iconst_0
    //   211: istore_1
    //   212: goto -110 -> 102
    //   215: iconst_0
    //   216: istore_1
    //   217: goto -90 -> 127
    //   220: iconst_0
    //   221: istore_1
    //   222: goto -54 -> 168
    //   225: iconst_0
    //   226: istore_1
    //   227: goto -34 -> 193
    //   230: astore_2
    //   231: aconst_null
    //   232: astore_0
    //   233: aload_2
    //   234: invokevirtual 36	java/lang/Throwable:printStackTrace	()V
    //   237: aload_0
    //   238: areturn
    //   239: astore_3
    //   240: aload_2
    //   241: astore_0
    //   242: aload_3
    //   243: astore_2
    //   244: goto -11 -> 233
    //   247: aconst_null
    //   248: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	paramString	java.lang.String
    //   39	188	1	i	int
    //   14	185	2	localtal	tal
    //   230	11	2	localThrowable1	Throwable
    //   243	1	2	localObject	Object
    //   81	36	3	localJSONObject	org.json.JSONObject
    //   239	4	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   7	15	230	java/lang/Throwable
    //   15	40	239	java/lang/Throwable
    //   40	61	239	java/lang/Throwable
    //   61	102	239	java/lang/Throwable
    //   102	127	239	java/lang/Throwable
    //   127	132	239	java/lang/Throwable
    //   132	168	239	java/lang/Throwable
    //   168	193	239	java/lang/Throwable
    //   193	198	239	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tam
 * JD-Core Version:    0.7.0.1
 */