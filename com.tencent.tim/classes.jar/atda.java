import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class atda
{
  private static atda a;
  public static final String aYk = BaseApplicationImpl.getContext().getFilesDir() + File.separator + "lightalkfiles";
  public static final String aYl = aYk + File.separator + "lightalk_tips_config";
  public static final String aYm = aYk + File.separator + "qq_aio_tips_lightalk_icon";
  private String GB;
  private String cGE;
  public String mJumpUrl;
  public String mWording;
  
  public static atda a()
  {
    long l1 = SystemClock.uptimeMillis();
    ciu();
    long l2 = SystemClock.uptimeMillis();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("read config cost ").append(l2 - l1).append(" , result is ");
      if (a != null) {
        break label71;
      }
    }
    label71:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("lightalktips", 2, bool);
      return a;
    }
  }
  
  /* Error */
  private static void ciu()
  {
    // Byte code:
    //   0: getstatic 88	atda:a	Latda;
    //   3: ifnull +18 -> 21
    //   6: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +11 -> 20
    //   12: ldc 90
    //   14: iconst_2
    //   15: ldc 103
    //   17: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   20: return
    //   21: new 39	java/io/File
    //   24: dup
    //   25: getstatic 57	atda:aYl	Ljava/lang/String;
    //   28: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   31: astore_0
    //   32: new 39	java/io/File
    //   35: dup
    //   36: getstatic 61	atda:aYm	Ljava/lang/String;
    //   39: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: astore_1
    //   43: aload_0
    //   44: invokevirtual 109	java/io/File:exists	()Z
    //   47: ifeq -27 -> 20
    //   50: aload_0
    //   51: invokevirtual 112	java/io/File:length	()J
    //   54: lconst_0
    //   55: lcmp
    //   56: ifle -36 -> 20
    //   59: aload_1
    //   60: invokevirtual 109	java/io/File:exists	()Z
    //   63: ifeq -43 -> 20
    //   66: new 114	java/io/FileInputStream
    //   69: dup
    //   70: aload_0
    //   71: invokespecial 117	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   74: astore_1
    //   75: aload_1
    //   76: astore_0
    //   77: aload_1
    //   78: invokevirtual 121	java/io/FileInputStream:available	()I
    //   81: newarray byte
    //   83: astore_2
    //   84: aload_1
    //   85: astore_0
    //   86: aload_1
    //   87: aload_2
    //   88: invokevirtual 125	java/io/FileInputStream:read	([B)I
    //   91: pop
    //   92: aload_1
    //   93: astore_0
    //   94: new 127	java/lang/String
    //   97: dup
    //   98: aload_2
    //   99: ldc 129
    //   101: invokespecial 132	java/lang/String:<init>	([BLjava/lang/String;)V
    //   104: astore_2
    //   105: aload_2
    //   106: ifnull +76 -> 182
    //   109: aload_1
    //   110: astore_0
    //   111: aload_2
    //   112: ldc 134
    //   114: invokevirtual 138	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   117: astore_2
    //   118: aload_1
    //   119: astore_0
    //   120: aload_2
    //   121: arraylength
    //   122: iconst_4
    //   123: if_icmpne +59 -> 182
    //   126: aload_1
    //   127: astore_0
    //   128: new 2	atda
    //   131: dup
    //   132: invokespecial 139	atda:<init>	()V
    //   135: putstatic 88	atda:a	Latda;
    //   138: aload_1
    //   139: astore_0
    //   140: getstatic 88	atda:a	Latda;
    //   143: aload_2
    //   144: iconst_0
    //   145: aaload
    //   146: putfield 141	atda:mWording	Ljava/lang/String;
    //   149: aload_1
    //   150: astore_0
    //   151: getstatic 88	atda:a	Latda;
    //   154: aload_2
    //   155: iconst_1
    //   156: aaload
    //   157: putfield 143	atda:mJumpUrl	Ljava/lang/String;
    //   160: aload_1
    //   161: astore_0
    //   162: getstatic 88	atda:a	Latda;
    //   165: aload_2
    //   166: iconst_2
    //   167: aaload
    //   168: putfield 145	atda:cGE	Ljava/lang/String;
    //   171: aload_1
    //   172: astore_0
    //   173: getstatic 88	atda:a	Latda;
    //   176: aload_2
    //   177: iconst_3
    //   178: aaload
    //   179: putfield 147	atda:GB	Ljava/lang/String;
    //   182: aload_1
    //   183: ifnull -163 -> 20
    //   186: aload_1
    //   187: invokevirtual 150	java/io/FileInputStream:close	()V
    //   190: return
    //   191: astore_0
    //   192: aload_0
    //   193: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   196: return
    //   197: astore_2
    //   198: aconst_null
    //   199: astore_1
    //   200: aload_1
    //   201: astore_0
    //   202: aload_2
    //   203: invokevirtual 154	java/lang/Exception:printStackTrace	()V
    //   206: aload_1
    //   207: astore_0
    //   208: aconst_null
    //   209: putstatic 88	atda:a	Latda;
    //   212: aload_1
    //   213: ifnull -193 -> 20
    //   216: aload_1
    //   217: invokevirtual 150	java/io/FileInputStream:close	()V
    //   220: return
    //   221: astore_0
    //   222: aload_0
    //   223: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   226: return
    //   227: astore_1
    //   228: aconst_null
    //   229: astore_0
    //   230: aload_0
    //   231: ifnull +7 -> 238
    //   234: aload_0
    //   235: invokevirtual 150	java/io/FileInputStream:close	()V
    //   238: aload_1
    //   239: athrow
    //   240: astore_0
    //   241: aload_0
    //   242: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   245: goto -7 -> 238
    //   248: astore_1
    //   249: goto -19 -> 230
    //   252: astore_2
    //   253: goto -53 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   31	142	0	localObject1	Object
    //   191	2	0	localIOException1	java.io.IOException
    //   201	7	0	localObject2	Object
    //   221	2	0	localIOException2	java.io.IOException
    //   229	6	0	localObject3	Object
    //   240	2	0	localIOException3	java.io.IOException
    //   42	175	1	localObject4	Object
    //   227	12	1	localObject5	Object
    //   248	1	1	localObject6	Object
    //   83	94	2	localObject7	Object
    //   197	6	2	localException1	java.lang.Exception
    //   252	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   186	190	191	java/io/IOException
    //   66	75	197	java/lang/Exception
    //   216	220	221	java/io/IOException
    //   66	75	227	finally
    //   234	238	240	java/io/IOException
    //   77	84	248	finally
    //   86	92	248	finally
    //   94	105	248	finally
    //   111	118	248	finally
    //   120	126	248	finally
    //   128	138	248	finally
    //   140	149	248	finally
    //   151	160	248	finally
    //   162	171	248	finally
    //   173	182	248	finally
    //   202	206	248	finally
    //   208	212	248	finally
    //   77	84	252	java/lang/Exception
    //   86	92	252	java/lang/Exception
    //   94	105	252	java/lang/Exception
    //   111	118	252	java/lang/Exception
    //   120	126	252	java/lang/Exception
    //   128	138	252	java/lang/Exception
    //   140	149	252	java/lang/Exception
    //   151	160	252	java/lang/Exception
    //   162	171	252	java/lang/Exception
    //   173	182	252	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atda
 * JD-Core Version:    0.7.0.1
 */