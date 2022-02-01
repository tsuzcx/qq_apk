import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

public class auye
{
  /* Error */
  public static java.lang.String Fk()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: invokestatic 14	android/os/Process:myPid	()I
    //   5: istore_0
    //   6: new 16	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   13: ldc 22
    //   15: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: iload_0
    //   19: invokestatic 32	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   22: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc 34
    //   27: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore_1
    //   34: ldc 39
    //   36: astore 4
    //   38: new 41	java/io/FileReader
    //   41: dup
    //   42: aload_1
    //   43: invokespecial 44	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   46: astore_3
    //   47: new 46	java/io/BufferedReader
    //   50: dup
    //   51: aload_3
    //   52: sipush 8192
    //   55: invokespecial 49	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   58: astore 5
    //   60: aload 5
    //   62: invokevirtual 52	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   65: pop
    //   66: aload 5
    //   68: invokevirtual 52	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   71: pop
    //   72: aload 5
    //   74: invokevirtual 52	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   77: astore_1
    //   78: aload_1
    //   79: astore_2
    //   80: aload_1
    //   81: ifnull +9 -> 90
    //   84: aload 5
    //   86: invokevirtual 52	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   89: astore_2
    //   90: aload 4
    //   92: astore_1
    //   93: aload_2
    //   94: ifnull +22 -> 116
    //   97: aload_2
    //   98: ldc 54
    //   100: invokevirtual 58	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   103: astore_1
    //   104: aload_1
    //   105: arraylength
    //   106: bipush 9
    //   108: if_icmplt +35 -> 143
    //   111: aload_1
    //   112: bipush 8
    //   114: aaload
    //   115: astore_1
    //   116: aload_3
    //   117: ifnull +7 -> 124
    //   120: aload_3
    //   121: invokevirtual 61	java/io/FileReader:close	()V
    //   124: aload_1
    //   125: astore 4
    //   127: aload 5
    //   129: ifnull +11 -> 140
    //   132: aload 5
    //   134: invokevirtual 62	java/io/BufferedReader:close	()V
    //   137: aload_1
    //   138: astore 4
    //   140: aload 4
    //   142: areturn
    //   143: ldc 64
    //   145: astore_1
    //   146: goto -30 -> 116
    //   149: astore_2
    //   150: aload_2
    //   151: invokevirtual 67	java/io/IOException:printStackTrace	()V
    //   154: aload_1
    //   155: areturn
    //   156: astore_3
    //   157: aconst_null
    //   158: astore_1
    //   159: aload_3
    //   160: invokevirtual 67	java/io/IOException:printStackTrace	()V
    //   163: aload_2
    //   164: ifnull +7 -> 171
    //   167: aload_2
    //   168: invokevirtual 61	java/io/FileReader:close	()V
    //   171: aload_1
    //   172: ifnull -32 -> 140
    //   175: aload_1
    //   176: invokevirtual 62	java/io/BufferedReader:close	()V
    //   179: ldc 39
    //   181: areturn
    //   182: astore_1
    //   183: aload_1
    //   184: invokevirtual 67	java/io/IOException:printStackTrace	()V
    //   187: ldc 39
    //   189: areturn
    //   190: astore_2
    //   191: aconst_null
    //   192: astore_1
    //   193: aconst_null
    //   194: astore_3
    //   195: aload_3
    //   196: ifnull +7 -> 203
    //   199: aload_3
    //   200: invokevirtual 61	java/io/FileReader:close	()V
    //   203: aload_1
    //   204: ifnull +7 -> 211
    //   207: aload_1
    //   208: invokevirtual 62	java/io/BufferedReader:close	()V
    //   211: aload_2
    //   212: athrow
    //   213: astore_1
    //   214: aload_1
    //   215: invokevirtual 67	java/io/IOException:printStackTrace	()V
    //   218: goto -7 -> 211
    //   221: astore_2
    //   222: aconst_null
    //   223: astore_1
    //   224: goto -29 -> 195
    //   227: astore_2
    //   228: aload 5
    //   230: astore_1
    //   231: goto -36 -> 195
    //   234: astore 4
    //   236: aload_2
    //   237: astore_3
    //   238: aload 4
    //   240: astore_2
    //   241: goto -46 -> 195
    //   244: astore 5
    //   246: aconst_null
    //   247: astore_1
    //   248: aload_3
    //   249: astore_2
    //   250: aload 5
    //   252: astore_3
    //   253: goto -94 -> 159
    //   256: astore_1
    //   257: aload_3
    //   258: astore_2
    //   259: aload_1
    //   260: astore_3
    //   261: aload 5
    //   263: astore_1
    //   264: goto -105 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   5	14	0	i	int
    //   33	143	1	localObject1	Object
    //   182	2	1	localIOException1	java.io.IOException
    //   192	16	1	localObject2	Object
    //   213	2	1	localIOException2	java.io.IOException
    //   223	25	1	localObject3	Object
    //   256	4	1	localIOException3	java.io.IOException
    //   263	1	1	localObject4	Object
    //   1	97	2	localObject5	Object
    //   149	19	2	localIOException4	java.io.IOException
    //   190	22	2	localObject6	Object
    //   221	1	2	localObject7	Object
    //   227	10	2	localObject8	Object
    //   240	19	2	localObject9	Object
    //   46	75	3	localFileReader	java.io.FileReader
    //   156	4	3	localIOException5	java.io.IOException
    //   194	67	3	localObject10	Object
    //   36	105	4	localObject11	Object
    //   234	5	4	localObject12	Object
    //   58	171	5	localBufferedReader	java.io.BufferedReader
    //   244	18	5	localIOException6	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   120	124	149	java/io/IOException
    //   132	137	149	java/io/IOException
    //   38	47	156	java/io/IOException
    //   167	171	182	java/io/IOException
    //   175	179	182	java/io/IOException
    //   38	47	190	finally
    //   199	203	213	java/io/IOException
    //   207	211	213	java/io/IOException
    //   47	60	221	finally
    //   60	78	227	finally
    //   84	90	227	finally
    //   97	111	227	finally
    //   159	163	234	finally
    //   47	60	244	java/io/IOException
    //   60	78	256	java/io/IOException
    //   84	90	256	java/io/IOException
    //   97	111	256	java/io/IOException
  }
  
  public static final int getNetWorkType(Context paramContext)
  {
    Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localObject == null) {
      return -1;
    }
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if ((localObject == null) || (!((NetworkInfo)localObject).isAvailable())) {
      return -1;
    }
    if (((NetworkInfo)localObject).getType() == 1) {
      return 0;
    }
    switch (((TelephonyManager)paramContext.getSystemService("phone")).getNetworkType())
    {
    case 3: 
    default: 
      return 1;
    case 4: 
      return 2;
    case 2: 
      return 2;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auye
 * JD-Core Version:    0.7.0.1
 */