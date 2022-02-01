import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Date;

public class asyj
{
  private static String cFY = "CPSP";
  private String cFZ;
  private boolean dgE;
  private long eI;
  
  public asyj(String paramString, long paramLong)
  {
    this.cFZ = paramString;
    this.eI = paramLong;
  }
  
  private boolean aIM()
  {
    boolean bool = true;
    Object localObject = BaseApplication.getContext().getSharedPreferences(cFY + "_" + getProcessName(), 0);
    this.dgE = true;
    try
    {
      long l3 = ((SharedPreferences)localObject).getLong(this.cFZ, 0L);
      l1 = new Date().getTime();
      long l2 = l1 - l3;
      if (l3 != 0L)
      {
        l3 = this.eI;
        if ((l2 >= l3) || (l2 <= 0L)) {}
      }
    }
    catch (Exception localException1)
    {
      long l1;
      bool = false;
    }
    try
    {
      this.dgE = false;
      return true;
    }
    catch (Exception localException2)
    {
      break label146;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong(this.cFZ, l1);
    ((SharedPreferences.Editor)localObject).commit();
    return false;
    label146:
    localException1.printStackTrace();
    return bool;
  }
  
  private void esr()
  {
    if (!this.dgE) {
      return;
    }
    Object localObject = BaseApplication.getContext().getSharedPreferences(cFY + "_" + getProcessName(), 0);
    try
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).remove(this.cFZ);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(asyj.a parama)
  {
    if (parama != null)
    {
      if (aIM()) {
        break label22;
      }
      parama.run();
    }
    for (;;)
    {
      esr();
      return;
      label22:
      parama.ess();
    }
  }
  
  /* Error */
  public String getProcessName()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: new 110	java/io/File
    //   9: dup
    //   10: new 41	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   17: ldc 112
    //   19: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokestatic 118	android/os/Process:myPid	()I
    //   25: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   28: ldc 123
    //   30: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokespecial 126	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual 129	java/io/File:exists	()Z
    //   44: ifne +6 -> 50
    //   47: ldc 131
    //   49: areturn
    //   50: new 133	java/io/FileReader
    //   53: dup
    //   54: aload_1
    //   55: invokespecial 136	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   58: astore_2
    //   59: aload_2
    //   60: ifnull +272 -> 332
    //   63: new 138	java/io/BufferedReader
    //   66: dup
    //   67: aload_2
    //   68: invokespecial 141	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   71: astore_1
    //   72: aload 8
    //   74: astore 5
    //   76: aload_1
    //   77: astore 6
    //   79: aload_1
    //   80: ifnull +49 -> 129
    //   83: aload_1
    //   84: astore 4
    //   86: aload_2
    //   87: astore_3
    //   88: aload_1
    //   89: invokevirtual 144	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   92: astore 9
    //   94: aload 8
    //   96: astore 5
    //   98: aload_1
    //   99: astore 6
    //   101: aload_1
    //   102: astore 4
    //   104: aload_2
    //   105: astore_3
    //   106: aload 9
    //   108: invokestatic 150	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   111: ifne +18 -> 129
    //   114: aload_1
    //   115: astore 4
    //   117: aload_2
    //   118: astore_3
    //   119: aload 9
    //   121: invokevirtual 155	java/lang/String:trim	()Ljava/lang/String;
    //   124: astore 5
    //   126: aload_1
    //   127: astore 6
    //   129: aload_2
    //   130: ifnull +7 -> 137
    //   133: aload_2
    //   134: invokevirtual 158	java/io/FileReader:close	()V
    //   137: aload 5
    //   139: astore_2
    //   140: aload 6
    //   142: ifnull +11 -> 153
    //   145: aload 6
    //   147: invokevirtual 159	java/io/BufferedReader:close	()V
    //   150: aload 5
    //   152: astore_2
    //   153: aload_2
    //   154: invokestatic 150	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   157: ifne +147 -> 304
    //   160: aload_2
    //   161: ldc 161
    //   163: invokevirtual 165	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   166: astore_1
    //   167: aload_1
    //   168: arraylength
    //   169: iconst_1
    //   170: if_icmple +131 -> 301
    //   173: aload_1
    //   174: aload_1
    //   175: arraylength
    //   176: iconst_1
    //   177: isub
    //   178: aaload
    //   179: areturn
    //   180: astore_1
    //   181: aload_1
    //   182: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   185: goto -48 -> 137
    //   188: astore_1
    //   189: aload_1
    //   190: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   193: aload 5
    //   195: astore_2
    //   196: goto -43 -> 153
    //   199: astore 5
    //   201: aconst_null
    //   202: astore_1
    //   203: aconst_null
    //   204: astore_2
    //   205: aload_1
    //   206: astore 4
    //   208: aload_2
    //   209: astore_3
    //   210: aload 5
    //   212: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   215: aload_2
    //   216: ifnull +7 -> 223
    //   219: aload_2
    //   220: invokevirtual 158	java/io/FileReader:close	()V
    //   223: aload 7
    //   225: astore_2
    //   226: aload_1
    //   227: ifnull -74 -> 153
    //   230: aload_1
    //   231: invokevirtual 159	java/io/BufferedReader:close	()V
    //   234: aload 7
    //   236: astore_2
    //   237: goto -84 -> 153
    //   240: astore_1
    //   241: aload_1
    //   242: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   245: aload 7
    //   247: astore_2
    //   248: goto -95 -> 153
    //   251: astore_2
    //   252: aload_2
    //   253: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   256: goto -33 -> 223
    //   259: astore_1
    //   260: aconst_null
    //   261: astore 4
    //   263: aconst_null
    //   264: astore_2
    //   265: aload_2
    //   266: ifnull +7 -> 273
    //   269: aload_2
    //   270: invokevirtual 158	java/io/FileReader:close	()V
    //   273: aload 4
    //   275: ifnull +8 -> 283
    //   278: aload 4
    //   280: invokevirtual 159	java/io/BufferedReader:close	()V
    //   283: aload_1
    //   284: athrow
    //   285: astore_2
    //   286: aload_2
    //   287: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   290: goto -17 -> 273
    //   293: astore_2
    //   294: aload_2
    //   295: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   298: goto -15 -> 283
    //   301: ldc 131
    //   303: areturn
    //   304: ldc 131
    //   306: areturn
    //   307: astore_1
    //   308: aconst_null
    //   309: astore 4
    //   311: goto -46 -> 265
    //   314: astore_1
    //   315: aload_3
    //   316: astore_2
    //   317: goto -52 -> 265
    //   320: astore 5
    //   322: aconst_null
    //   323: astore_1
    //   324: goto -119 -> 205
    //   327: astore 5
    //   329: goto -124 -> 205
    //   332: aconst_null
    //   333: astore 6
    //   335: aload 8
    //   337: astore 5
    //   339: goto -210 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	this	asyj
    //   39	136	1	localObject1	Object
    //   180	2	1	localIOException1	java.io.IOException
    //   188	2	1	localIOException2	java.io.IOException
    //   202	29	1	localObject2	Object
    //   240	2	1	localIOException3	java.io.IOException
    //   259	25	1	localObject3	Object
    //   307	1	1	localObject4	Object
    //   314	1	1	localObject5	Object
    //   323	1	1	localObject6	Object
    //   58	190	2	localObject7	Object
    //   251	2	2	localIOException4	java.io.IOException
    //   264	6	2	localObject8	Object
    //   285	2	2	localIOException5	java.io.IOException
    //   293	2	2	localIOException6	java.io.IOException
    //   316	1	2	localObject9	Object
    //   87	229	3	localObject10	Object
    //   84	226	4	localObject11	Object
    //   74	120	5	localObject12	Object
    //   199	12	5	localException1	Exception
    //   320	1	5	localException2	Exception
    //   327	1	5	localException3	Exception
    //   337	1	5	localObject13	Object
    //   77	257	6	localObject14	Object
    //   1	245	7	localObject15	Object
    //   4	332	8	localObject16	Object
    //   92	28	9	str	String
    // Exception table:
    //   from	to	target	type
    //   133	137	180	java/io/IOException
    //   145	150	188	java/io/IOException
    //   50	59	199	java/lang/Exception
    //   230	234	240	java/io/IOException
    //   219	223	251	java/io/IOException
    //   50	59	259	finally
    //   269	273	285	java/io/IOException
    //   278	283	293	java/io/IOException
    //   63	72	307	finally
    //   88	94	314	finally
    //   106	114	314	finally
    //   119	126	314	finally
    //   210	215	314	finally
    //   63	72	320	java/lang/Exception
    //   88	94	327	java/lang/Exception
    //   106	114	327	java/lang/Exception
    //   119	126	327	java/lang/Exception
  }
  
  public static abstract interface a
  {
    public abstract void ess();
    
    public abstract void run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asyj
 * JD-Core Version:    0.7.0.1
 */