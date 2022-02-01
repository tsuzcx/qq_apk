import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.extendfriend.bean.MiniAppRecommInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import common.config.service.QzoneConfig;
import java.io.File;

public class aftv
{
  public static final String PATH = BaseApplicationImpl.getApplication().getFilesDir().getPath() + "/mini/koulie_config.ini";
  private static byte[] lock = new byte[0];
  private MiniAppRecommInfo a;
  
  private void a(aftv.a parama)
  {
    int i = 1;
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_kuolie_recomm_enable", 1) == 1) {}
    while (i == 0)
    {
      if (parama != null) {
        parama.a(false, null);
      }
      return;
      i = 0;
    }
    if (this.a == null) {
      this.a = a();
    }
    MiniAppCmdUtil.getInstance().getKuolieAppList(null, new aftw(this, parama));
  }
  
  /* Error */
  public MiniAppRecommInfo a()
  {
    // Byte code:
    //   0: getstatic 48	aftv:PATH	Ljava/lang/String;
    //   3: astore_3
    //   4: aload_3
    //   5: invokestatic 98	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: istore_2
    //   9: iload_2
    //   10: ifeq +32 -> 42
    //   13: iconst_0
    //   14: ifeq +11 -> 25
    //   17: new 100	java/lang/NullPointerException
    //   20: dup
    //   21: invokespecial 101	java/lang/NullPointerException:<init>	()V
    //   24: athrow
    //   25: aconst_null
    //   26: astore_3
    //   27: aload_3
    //   28: areturn
    //   29: astore_3
    //   30: ldc 103
    //   32: iconst_1
    //   33: ldc 105
    //   35: aload_3
    //   36: invokestatic 111	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   39: goto -14 -> 25
    //   42: new 33	java/io/File
    //   45: dup
    //   46: aload_3
    //   47: invokespecial 114	java/io/File:<init>	(Ljava/lang/String;)V
    //   50: astore_3
    //   51: aload_3
    //   52: invokevirtual 118	java/io/File:exists	()Z
    //   55: istore_2
    //   56: iload_2
    //   57: ifne +30 -> 87
    //   60: iconst_0
    //   61: ifeq +11 -> 72
    //   64: new 100	java/lang/NullPointerException
    //   67: dup
    //   68: invokespecial 101	java/lang/NullPointerException:<init>	()V
    //   71: athrow
    //   72: aconst_null
    //   73: areturn
    //   74: astore_3
    //   75: ldc 103
    //   77: iconst_1
    //   78: ldc 105
    //   80: aload_3
    //   81: invokestatic 111	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   84: goto -12 -> 72
    //   87: new 120	java/io/FileInputStream
    //   90: dup
    //   91: aload_3
    //   92: invokespecial 123	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   95: astore 5
    //   97: aload 5
    //   99: invokevirtual 127	java/io/FileInputStream:available	()I
    //   102: istore_1
    //   103: iload_1
    //   104: newarray byte
    //   106: astore_3
    //   107: aload 5
    //   109: aload_3
    //   110: iconst_0
    //   111: iload_1
    //   112: invokevirtual 131	java/io/FileInputStream:read	([BII)I
    //   115: pop
    //   116: aload_3
    //   117: invokestatic 137	com/tencent/component/network/downloader/common/Utils:unmarshall	([B)Landroid/os/Parcel;
    //   120: astore 4
    //   122: aload 4
    //   124: astore_3
    //   125: aload 4
    //   127: ldc 139
    //   129: invokevirtual 145	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   132: invokevirtual 151	android/os/Parcel:readParcelable	(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;
    //   135: checkcast 139	com/tencent/mobileqq/extendfriend/bean/MiniAppRecommInfo
    //   138: astore 6
    //   140: aload 4
    //   142: ifnull +8 -> 150
    //   145: aload 4
    //   147: invokevirtual 154	android/os/Parcel:recycle	()V
    //   150: aload 6
    //   152: astore_3
    //   153: aload 5
    //   155: ifnull -128 -> 27
    //   158: aload 5
    //   160: invokevirtual 157	java/io/FileInputStream:close	()V
    //   163: aload 6
    //   165: areturn
    //   166: astore_3
    //   167: ldc 103
    //   169: iconst_1
    //   170: ldc 105
    //   172: aload_3
    //   173: invokestatic 111	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   176: aload 6
    //   178: areturn
    //   179: astore 6
    //   181: aconst_null
    //   182: astore 4
    //   184: aload 4
    //   186: astore_3
    //   187: ldc 103
    //   189: iconst_1
    //   190: ldc 105
    //   192: aload 6
    //   194: invokestatic 111	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   197: aload 4
    //   199: ifnull +8 -> 207
    //   202: aload 4
    //   204: invokevirtual 154	android/os/Parcel:recycle	()V
    //   207: aload 5
    //   209: ifnull +8 -> 217
    //   212: aload 5
    //   214: invokevirtual 157	java/io/FileInputStream:close	()V
    //   217: aconst_null
    //   218: areturn
    //   219: astore 4
    //   221: aconst_null
    //   222: astore_3
    //   223: aload_3
    //   224: ifnull +7 -> 231
    //   227: aload_3
    //   228: invokevirtual 154	android/os/Parcel:recycle	()V
    //   231: aload 4
    //   233: athrow
    //   234: astore 4
    //   236: aload 5
    //   238: astore_3
    //   239: ldc 103
    //   241: iconst_1
    //   242: ldc 105
    //   244: aload 4
    //   246: invokestatic 111	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   249: aload_3
    //   250: ifnull -33 -> 217
    //   253: aload_3
    //   254: invokevirtual 157	java/io/FileInputStream:close	()V
    //   257: goto -40 -> 217
    //   260: astore_3
    //   261: ldc 103
    //   263: iconst_1
    //   264: ldc 105
    //   266: aload_3
    //   267: invokestatic 111	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   270: goto -53 -> 217
    //   273: astore_3
    //   274: ldc 103
    //   276: iconst_1
    //   277: ldc 105
    //   279: aload_3
    //   280: invokestatic 111	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   283: goto -66 -> 217
    //   286: astore_3
    //   287: aconst_null
    //   288: astore 4
    //   290: aload 4
    //   292: ifnull +8 -> 300
    //   295: aload 4
    //   297: invokevirtual 157	java/io/FileInputStream:close	()V
    //   300: aload_3
    //   301: athrow
    //   302: astore 4
    //   304: ldc 103
    //   306: iconst_1
    //   307: ldc 105
    //   309: aload 4
    //   311: invokestatic 111	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   314: goto -14 -> 300
    //   317: astore_3
    //   318: aload 5
    //   320: astore 4
    //   322: goto -32 -> 290
    //   325: astore 5
    //   327: aload_3
    //   328: astore 4
    //   330: aload 5
    //   332: astore_3
    //   333: goto -43 -> 290
    //   336: astore 4
    //   338: aconst_null
    //   339: astore_3
    //   340: goto -101 -> 239
    //   343: astore 4
    //   345: goto -122 -> 223
    //   348: astore 6
    //   350: goto -166 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	353	0	this	aftv
    //   102	10	1	i	int
    //   8	49	2	bool	boolean
    //   3	25	3	str	String
    //   29	18	3	localThrowable1	java.lang.Throwable
    //   50	2	3	localFile	File
    //   74	18	3	localThrowable2	java.lang.Throwable
    //   106	47	3	localObject1	Object
    //   166	7	3	localThrowable3	java.lang.Throwable
    //   186	68	3	localObject2	Object
    //   260	7	3	localThrowable4	java.lang.Throwable
    //   273	7	3	localThrowable5	java.lang.Throwable
    //   286	15	3	localObject3	Object
    //   317	11	3	localObject4	Object
    //   332	8	3	localObject5	Object
    //   120	83	4	localParcel	android.os.Parcel
    //   219	13	4	localObject6	Object
    //   234	11	4	localThrowable6	java.lang.Throwable
    //   288	8	4	localObject7	Object
    //   302	8	4	localThrowable7	java.lang.Throwable
    //   320	9	4	localObject8	Object
    //   336	1	4	localThrowable8	java.lang.Throwable
    //   343	1	4	localObject9	Object
    //   95	224	5	localFileInputStream	java.io.FileInputStream
    //   325	6	5	localObject10	Object
    //   138	39	6	localMiniAppRecommInfo	MiniAppRecommInfo
    //   179	14	6	localThrowable9	java.lang.Throwable
    //   348	1	6	localThrowable10	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   17	25	29	java/lang/Throwable
    //   64	72	74	java/lang/Throwable
    //   158	163	166	java/lang/Throwable
    //   116	122	179	java/lang/Throwable
    //   116	122	219	finally
    //   97	116	234	java/lang/Throwable
    //   145	150	234	java/lang/Throwable
    //   202	207	234	java/lang/Throwable
    //   227	231	234	java/lang/Throwable
    //   231	234	234	java/lang/Throwable
    //   253	257	260	java/lang/Throwable
    //   212	217	273	java/lang/Throwable
    //   0	9	286	finally
    //   42	56	286	finally
    //   87	97	286	finally
    //   295	300	302	java/lang/Throwable
    //   97	116	317	finally
    //   145	150	317	finally
    //   202	207	317	finally
    //   227	231	317	finally
    //   231	234	317	finally
    //   239	249	325	finally
    //   0	9	336	java/lang/Throwable
    //   42	56	336	java/lang/Throwable
    //   87	97	336	java/lang/Throwable
    //   125	140	343	finally
    //   187	197	343	finally
    //   125	140	348	java/lang/Throwable
  }
  
  /* Error */
  public boolean a(MiniAppRecommInfo paramMiniAppRecommInfo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 5
    //   8: aload_1
    //   9: ifnonnull +5 -> 14
    //   12: iconst_0
    //   13: ireturn
    //   14: invokestatic 162	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   17: astore_2
    //   18: aload_2
    //   19: aload_1
    //   20: iconst_0
    //   21: invokevirtual 166	android/os/Parcel:writeParcelable	(Landroid/os/Parcelable;I)V
    //   24: aload_2
    //   25: invokevirtual 170	android/os/Parcel:marshall	()[B
    //   28: astore 5
    //   30: aload_3
    //   31: astore_1
    //   32: getstatic 48	aftv:PATH	Ljava/lang/String;
    //   35: astore 6
    //   37: aload_3
    //   38: astore_1
    //   39: new 33	java/io/File
    //   42: dup
    //   43: aload 6
    //   45: invokespecial 114	java/io/File:<init>	(Ljava/lang/String;)V
    //   48: astore 7
    //   50: aload_3
    //   51: astore_1
    //   52: aload 7
    //   54: invokevirtual 173	java/io/File:getParentFile	()Ljava/io/File;
    //   57: astore 8
    //   59: aload_3
    //   60: astore_1
    //   61: aload 8
    //   63: invokevirtual 118	java/io/File:exists	()Z
    //   66: ifeq +13 -> 79
    //   69: aload_3
    //   70: astore_1
    //   71: aload 8
    //   73: invokevirtual 176	java/io/File:isDirectory	()Z
    //   76: ifne +11 -> 87
    //   79: aload_3
    //   80: astore_1
    //   81: aload 8
    //   83: invokevirtual 179	java/io/File:mkdirs	()Z
    //   86: pop
    //   87: aload_3
    //   88: astore_1
    //   89: aload 7
    //   91: invokevirtual 118	java/io/File:exists	()Z
    //   94: ifeq +13 -> 107
    //   97: aload_3
    //   98: astore_1
    //   99: aload 7
    //   101: invokevirtual 182	java/io/File:isFile	()Z
    //   104: ifne +11 -> 115
    //   107: aload_3
    //   108: astore_1
    //   109: aload 7
    //   111: invokevirtual 185	java/io/File:createNewFile	()Z
    //   114: pop
    //   115: aload_3
    //   116: astore_1
    //   117: new 187	java/io/FileOutputStream
    //   120: dup
    //   121: aload 7
    //   123: iconst_0
    //   124: invokespecial 190	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   127: astore_3
    //   128: aload_3
    //   129: aload 5
    //   131: invokevirtual 194	java/io/FileOutputStream:write	([B)V
    //   134: aload_3
    //   135: invokevirtual 197	java/io/FileOutputStream:flush	()V
    //   138: ldc 103
    //   140: iconst_1
    //   141: new 18	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   148: ldc 199
    //   150: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload 6
    //   155: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 203	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: aload_3
    //   165: ifnull +7 -> 172
    //   168: aload_3
    //   169: invokevirtual 204	java/io/FileOutputStream:close	()V
    //   172: aload_2
    //   173: ifnull +7 -> 180
    //   176: aload_2
    //   177: invokevirtual 154	android/os/Parcel:recycle	()V
    //   180: iconst_1
    //   181: ireturn
    //   182: astore_1
    //   183: ldc 103
    //   185: iconst_1
    //   186: ldc 206
    //   188: aload_1
    //   189: invokestatic 111	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   192: goto -20 -> 172
    //   195: astore_3
    //   196: aload_2
    //   197: astore_1
    //   198: aload_3
    //   199: astore_2
    //   200: ldc 103
    //   202: iconst_1
    //   203: ldc 206
    //   205: aload_2
    //   206: invokestatic 111	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   209: aload_1
    //   210: ifnull -198 -> 12
    //   213: aload_1
    //   214: invokevirtual 154	android/os/Parcel:recycle	()V
    //   217: iconst_0
    //   218: ireturn
    //   219: astore_1
    //   220: aload 4
    //   222: astore_3
    //   223: aload_1
    //   224: astore 4
    //   226: aload_3
    //   227: astore_1
    //   228: ldc 103
    //   230: iconst_1
    //   231: ldc 206
    //   233: aload 4
    //   235: invokestatic 111	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   238: aload_3
    //   239: ifnull +7 -> 246
    //   242: aload_3
    //   243: invokevirtual 204	java/io/FileOutputStream:close	()V
    //   246: aload_2
    //   247: ifnull -235 -> 12
    //   250: aload_2
    //   251: invokevirtual 154	android/os/Parcel:recycle	()V
    //   254: iconst_0
    //   255: ireturn
    //   256: astore_1
    //   257: ldc 103
    //   259: iconst_1
    //   260: ldc 206
    //   262: aload_1
    //   263: invokestatic 111	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   266: goto -20 -> 246
    //   269: astore_1
    //   270: aload_2
    //   271: ifnull +7 -> 278
    //   274: aload_2
    //   275: invokevirtual 154	android/os/Parcel:recycle	()V
    //   278: aload_1
    //   279: athrow
    //   280: astore 4
    //   282: aload_1
    //   283: astore_3
    //   284: aload 4
    //   286: astore_1
    //   287: aload_3
    //   288: ifnull +7 -> 295
    //   291: aload_3
    //   292: invokevirtual 204	java/io/FileOutputStream:close	()V
    //   295: aload_1
    //   296: athrow
    //   297: astore_3
    //   298: ldc 103
    //   300: iconst_1
    //   301: ldc 206
    //   303: aload_3
    //   304: invokestatic 111	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   307: goto -12 -> 295
    //   310: astore_1
    //   311: aconst_null
    //   312: astore_2
    //   313: goto -43 -> 270
    //   316: astore_3
    //   317: aload_1
    //   318: astore_2
    //   319: aload_3
    //   320: astore_1
    //   321: goto -51 -> 270
    //   324: astore_2
    //   325: aload 5
    //   327: astore_1
    //   328: goto -128 -> 200
    //   331: astore_1
    //   332: goto -45 -> 287
    //   335: astore 4
    //   337: goto -111 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	340	0	this	aftv
    //   0	340	1	paramMiniAppRecommInfo	MiniAppRecommInfo
    //   17	302	2	localObject1	Object
    //   324	1	2	localThrowable1	java.lang.Throwable
    //   4	165	3	localFileOutputStream	java.io.FileOutputStream
    //   195	4	3	localThrowable2	java.lang.Throwable
    //   222	70	3	localMiniAppRecommInfo1	MiniAppRecommInfo
    //   297	7	3	localThrowable3	java.lang.Throwable
    //   316	4	3	localObject2	Object
    //   1	233	4	localMiniAppRecommInfo2	MiniAppRecommInfo
    //   280	5	4	localObject3	Object
    //   335	1	4	localThrowable4	java.lang.Throwable
    //   6	320	5	arrayOfByte	byte[]
    //   35	119	6	str	String
    //   48	74	7	localFile1	File
    //   57	25	8	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   168	172	182	java/lang/Throwable
    //   18	30	195	java/lang/Throwable
    //   183	192	195	java/lang/Throwable
    //   257	266	195	java/lang/Throwable
    //   295	297	195	java/lang/Throwable
    //   298	307	195	java/lang/Throwable
    //   32	37	219	java/lang/Throwable
    //   39	50	219	java/lang/Throwable
    //   52	59	219	java/lang/Throwable
    //   61	69	219	java/lang/Throwable
    //   71	79	219	java/lang/Throwable
    //   81	87	219	java/lang/Throwable
    //   89	97	219	java/lang/Throwable
    //   99	107	219	java/lang/Throwable
    //   109	115	219	java/lang/Throwable
    //   117	128	219	java/lang/Throwable
    //   242	246	256	java/lang/Throwable
    //   18	30	269	finally
    //   168	172	269	finally
    //   183	192	269	finally
    //   242	246	269	finally
    //   257	266	269	finally
    //   291	295	269	finally
    //   295	297	269	finally
    //   298	307	269	finally
    //   32	37	280	finally
    //   39	50	280	finally
    //   52	59	280	finally
    //   61	69	280	finally
    //   71	79	280	finally
    //   81	87	280	finally
    //   89	97	280	finally
    //   99	107	280	finally
    //   109	115	280	finally
    //   117	128	280	finally
    //   228	238	280	finally
    //   291	295	297	java/lang/Throwable
    //   14	18	310	finally
    //   200	209	316	finally
    //   14	18	324	java/lang/Throwable
    //   128	164	331	finally
    //   128	164	335	java/lang/Throwable
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, MiniAppRecommInfo paramMiniAppRecommInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aftv
 * JD-Core Version:    0.7.0.1
 */