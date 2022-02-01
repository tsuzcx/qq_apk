package com.tencent.token;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import btmsdkobf.ad;
import btmsdkobf.cp;
import btmsdkobf.z;
import com.tencent.token.ui.DownloadAppActivity;
import com.tencent.token.ui.DownloadQQSecureActivity;
import com.tencent.token.ui.gallery.GalleryActivity;
import com.tencent.token.ui.qqpim.QQPimNewActivity;
import com.tmsdk.TMSDKContext;
import com.tmsdk.base.conch.ConchService.ConchPushInfo;
import com.tmsdk.base.conch.ConchService.IConchPushListener;
import com.tmsdk.base.conch.ConchServiceProxy;
import com.tmsdk.common.util.TmsLog;
import java.util.ArrayList;

public final class kz
{
  public String a;
  public String b;
  public String c;
  private ky d;
  private ky e;
  private ky f;
  private ky g;
  
  private kz()
  {
    a(false);
  }
  
  public static void a(Context paramContext, String paramString, ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 4))
    {
      Intent localIntent = new Intent(paramContext, DownloadAppActivity.class);
      String str;
      if ("com.tencent.gallerymanager".equals(paramString)) {
        str = "http://qqwx.qq.com/s?aid=index&p=14&c=102322&vt=1&pf=0";
      } else if ("com.tencent.qqpimsecure".equals(paramString)) {
        str = "http://qqwx.qq.com/s?aid=index&p=1&c=107013&vt=1&pf=0";
      } else if ("com.tencent.qqpim".equals(paramString)) {
        str = "http://qqwx.qq.com/s?aid=index&p=11&c=106613&vt=1&pf=0";
      } else if ("android.lite.clean".equals(paramString)) {
        str = "http://qqwx.qq.com/s?aid=index&p=25&c=107047&vt=1&pf=0";
      } else if ("com.tencent.gamestick".equals(paramString)) {
        str = "http://qqwx.qq.com/s?aid=index&p=18&c=102798&vt=1&pf=0";
      } else if ("com.tencent.transfer".equals(paramString)) {
        str = "http://qqwx.qq.com/s?aid=index&p=15&c=106613&vt=1&pf=0";
      } else {
        str = "";
      }
      localIntent.putExtra("downloadurl", str);
      localIntent.putExtra("title", (String)paramArrayList.get(0));
      localIntent.putExtra("des", (String)paramArrayList.get(1));
      localIntent.putExtra("subdes", (String)paramArrayList.get(2));
      localIntent.putExtra("button", (String)paramArrayList.get(3));
      localIntent.putExtra("imgurl", (String)paramArrayList.get(4));
      localIntent.putExtra("pkg", paramString);
      paramContext.startActivity(localIntent);
      return;
    }
    if ("com.tencent.qqpimsecure".equals(paramString))
    {
      paramContext.startActivity(new Intent(paramContext, DownloadQQSecureActivity.class));
      return;
    }
    if ("com.tencent.qqpim".equals(paramString))
    {
      paramContext.startActivity(new Intent(paramContext, QQPimNewActivity.class));
      return;
    }
    if ("com.tencent.gallerymanager".equals(paramString))
    {
      paramContext.startActivity(new Intent(paramContext, GalleryActivity.class));
      return;
    }
  }
  
  public final ky a(String paramString)
  {
    if ("key_dialog_cofig_6348".equals(paramString)) {
      return this.d;
    }
    if ("key_tips1_cofig_6348".equals(paramString)) {
      return this.e;
    }
    if ("key_tips2_cofig_6348".equals(paramString)) {
      return this.f;
    }
    if ("key_eval_cofig_6348".equals(paramString)) {
      return this.g;
    }
    return null;
  }
  
  public final void a()
  {
    new Thread(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 24
        //   2: ldc 26
        //   4: invokestatic 32	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   7: ldc 34
        //   9: ldc 36
        //   11: invokestatic 42	com/tencent/token/ahc:c	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   14: astore_1
        //   15: new 44	java/io/File
        //   18: dup
        //   19: new 44	java/io/File
        //   22: dup
        //   23: invokestatic 50	com/tencent/token/global/RqdApplication:b	()Landroid/content/Context;
        //   26: invokevirtual 56	android/content/Context:getFilesDir	()Ljava/io/File;
        //   29: ldc 58
        //   31: invokespecial 61	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
        //   34: ldc 63
        //   36: invokespecial 61	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
        //   39: astore 7
        //   41: aload_1
        //   42: invokestatic 69	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   45: ifne +167 -> 212
        //   48: ldc 24
        //   50: ldc 71
        //   52: aload_1
        //   53: invokestatic 77	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   56: invokevirtual 81	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   59: invokestatic 32	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   62: new 44	java/io/File
        //   65: dup
        //   66: invokestatic 50	com/tencent/token/global/RqdApplication:b	()Landroid/content/Context;
        //   69: invokevirtual 56	android/content/Context:getFilesDir	()Ljava/io/File;
        //   72: ldc 58
        //   74: invokespecial 61	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
        //   77: astore_2
        //   78: aload_2
        //   79: invokevirtual 85	java/io/File:exists	()Z
        //   82: ifne +8 -> 90
        //   85: aload_2
        //   86: invokevirtual 88	java/io/File:mkdirs	()Z
        //   89: pop
        //   90: new 90	com/tencent/token/ajn
        //   93: dup
        //   94: invokespecial 91	com/tencent/token/ajn:<init>	()V
        //   97: aload_1
        //   98: invokevirtual 94	com/tencent/token/ajn:a	(Ljava/lang/String;)[B
        //   101: astore_3
        //   102: aload_3
        //   103: ifnull +109 -> 212
        //   106: new 96	java/io/FileOutputStream
        //   109: dup
        //   110: aload 7
        //   112: invokespecial 99	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   115: astore_2
        //   116: aload_2
        //   117: astore_1
        //   118: aload_2
        //   119: aload_3
        //   120: iconst_0
        //   121: aload_3
        //   122: arraylength
        //   123: invokevirtual 103	java/io/FileOutputStream:write	([BII)V
        //   126: aload_2
        //   127: astore_1
        //   128: ldc 24
        //   130: ldc 105
        //   132: invokestatic 32	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   135: aload_2
        //   136: astore_1
        //   137: ldc 34
        //   139: ldc 36
        //   141: invokestatic 107	com/tencent/token/ahc:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   144: aload_2
        //   145: invokevirtual 110	java/io/FileOutputStream:close	()V
        //   148: goto +64 -> 212
        //   151: astore_3
        //   152: goto +12 -> 164
        //   155: astore_1
        //   156: aconst_null
        //   157: astore_2
        //   158: goto +36 -> 194
        //   161: astore_3
        //   162: aconst_null
        //   163: astore_2
        //   164: aload_2
        //   165: astore_1
        //   166: aload_3
        //   167: invokevirtual 113	java/lang/Exception:printStackTrace	()V
        //   170: aload_2
        //   171: ifnull +41 -> 212
        //   174: aload_2
        //   175: invokevirtual 110	java/io/FileOutputStream:close	()V
        //   178: goto +34 -> 212
        //   181: astore_1
        //   182: aload_1
        //   183: invokevirtual 113	java/lang/Exception:printStackTrace	()V
        //   186: goto +26 -> 212
        //   189: astore_3
        //   190: aload_1
        //   191: astore_2
        //   192: aload_3
        //   193: astore_1
        //   194: aload_2
        //   195: ifnull +15 -> 210
        //   198: aload_2
        //   199: invokevirtual 110	java/io/FileOutputStream:close	()V
        //   202: goto +8 -> 210
        //   205: astore_2
        //   206: aload_2
        //   207: invokevirtual 113	java/lang/Exception:printStackTrace	()V
        //   210: aload_1
        //   211: athrow
        //   212: new 115	java/util/ArrayList
        //   215: dup
        //   216: invokespecial 116	java/util/ArrayList:<init>	()V
        //   219: astore 8
        //   221: aload 7
        //   223: invokevirtual 85	java/io/File:exists	()Z
        //   226: ifeq +243 -> 469
        //   229: ldc 24
        //   231: ldc 118
        //   233: invokestatic 32	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   236: new 120	java/io/FileReader
        //   239: dup
        //   240: aload 7
        //   242: invokespecial 121	java/io/FileReader:<init>	(Ljava/io/File;)V
        //   245: astore_1
        //   246: new 123	java/io/BufferedReader
        //   249: dup
        //   250: aload_1
        //   251: invokespecial 126	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   254: astore 6
        //   256: aload_1
        //   257: astore_2
        //   258: aload 6
        //   260: astore_3
        //   261: aload 6
        //   263: invokevirtual 130	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   266: astore 4
        //   268: aload 4
        //   270: ifnull +51 -> 321
        //   273: aload_1
        //   274: astore_2
        //   275: aload 6
        //   277: astore_3
        //   278: aload 8
        //   280: aload 4
        //   282: invokevirtual 134	java/util/ArrayList:add	(Ljava/lang/Object;)Z
        //   285: pop
        //   286: aload_1
        //   287: astore_2
        //   288: aload 6
        //   290: astore_3
        //   291: ldc 24
        //   293: ldc 136
        //   295: aload 4
        //   297: invokestatic 77	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   300: invokevirtual 81	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   303: invokestatic 32	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   306: aload_1
        //   307: astore_2
        //   308: aload 6
        //   310: astore_3
        //   311: aload 6
        //   313: invokevirtual 130	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   316: astore 4
        //   318: goto -50 -> 268
        //   321: aload_1
        //   322: invokevirtual 137	java/io/FileReader:close	()V
        //   325: aload 6
        //   327: invokevirtual 138	java/io/BufferedReader:close	()V
        //   330: goto +89 -> 419
        //   333: astore_1
        //   334: goto +81 -> 415
        //   337: astore 5
        //   339: aload_1
        //   340: astore 4
        //   342: aload 6
        //   344: astore_1
        //   345: goto +36 -> 381
        //   348: astore_2
        //   349: aconst_null
        //   350: astore_3
        //   351: goto +84 -> 435
        //   354: astore 5
        //   356: aconst_null
        //   357: astore_2
        //   358: aload_1
        //   359: astore 4
        //   361: aload_2
        //   362: astore_1
        //   363: goto +18 -> 381
        //   366: astore_2
        //   367: aconst_null
        //   368: astore_1
        //   369: aload_1
        //   370: astore_3
        //   371: goto +64 -> 435
        //   374: astore 5
        //   376: aconst_null
        //   377: astore_1
        //   378: aload_1
        //   379: astore 4
        //   381: aload 4
        //   383: astore_2
        //   384: aload_1
        //   385: astore_3
        //   386: aload 5
        //   388: invokevirtual 113	java/lang/Exception:printStackTrace	()V
        //   391: aload 4
        //   393: ifnull +11 -> 404
        //   396: aload 4
        //   398: invokevirtual 137	java/io/FileReader:close	()V
        //   401: goto +3 -> 404
        //   404: aload_1
        //   405: ifnull +14 -> 419
        //   408: aload_1
        //   409: invokevirtual 138	java/io/BufferedReader:close	()V
        //   412: goto +7 -> 419
        //   415: aload_1
        //   416: invokevirtual 113	java/lang/Exception:printStackTrace	()V
        //   419: aload 7
        //   421: invokevirtual 141	java/io/File:delete	()Z
        //   424: pop
        //   425: goto +44 -> 469
        //   428: astore 4
        //   430: aload_2
        //   431: astore_1
        //   432: aload 4
        //   434: astore_2
        //   435: aload_1
        //   436: ifnull +10 -> 446
        //   439: aload_1
        //   440: invokevirtual 137	java/io/FileReader:close	()V
        //   443: goto +3 -> 446
        //   446: aload_3
        //   447: ifnull +14 -> 461
        //   450: aload_3
        //   451: invokevirtual 138	java/io/BufferedReader:close	()V
        //   454: goto +7 -> 461
        //   457: aload_1
        //   458: invokevirtual 113	java/lang/Exception:printStackTrace	()V
        //   461: aload 7
        //   463: invokevirtual 141	java/io/File:delete	()Z
        //   466: pop
        //   467: aload_2
        //   468: athrow
        //   469: aload 8
        //   471: invokevirtual 145	java/util/ArrayList:size	()I
        //   474: iconst_3
        //   475: if_icmple +68 -> 543
        //   478: ldc 147
        //   480: aload 8
        //   482: iconst_0
        //   483: invokevirtual 151	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   486: checkcast 73	java/lang/String
        //   489: invokestatic 107	com/tencent/token/ahc:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   492: ldc 153
        //   494: aload 8
        //   496: iconst_1
        //   497: invokevirtual 151	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   500: checkcast 73	java/lang/String
        //   503: invokestatic 107	com/tencent/token/ahc:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   506: ldc 155
        //   508: aload 8
        //   510: iconst_2
        //   511: invokevirtual 151	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   514: checkcast 73	java/lang/String
        //   517: invokestatic 107	com/tencent/token/ahc:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   520: ldc 157
        //   522: aload 8
        //   524: iconst_3
        //   525: invokevirtual 151	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   528: checkcast 73	java/lang/String
        //   531: invokestatic 107	com/tencent/token/ahc:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   534: aload_0
        //   535: getfield 16	com/tencent/token/kz$1:a	Lcom/tencent/token/kz;
        //   538: iconst_1
        //   539: invokevirtual 160	com/tencent/token/kz:a	(Z)V
        //   542: return
        //   543: ldc 24
        //   545: ldc 162
        //   547: invokestatic 165	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   550: return
        //   551: astore_1
        //   552: goto -137 -> 415
        //   555: astore_1
        //   556: goto -99 -> 457
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	559	0	this	1
        //   14	123	1	localObject1	Object
        //   155	1	1	localObject2	Object
        //   165	1	1	localObject3	Object
        //   181	10	1	localException1	java.lang.Exception
        //   193	129	1	localObject4	Object
        //   333	7	1	localException2	java.lang.Exception
        //   344	114	1	localObject5	Object
        //   551	1	1	localException3	java.lang.Exception
        //   555	1	1	localException4	java.lang.Exception
        //   77	122	2	localObject6	Object
        //   205	2	2	localException5	java.lang.Exception
        //   257	51	2	localObject7	Object
        //   348	1	2	localObject8	Object
        //   357	5	2	localObject9	Object
        //   366	1	2	localObject10	Object
        //   383	85	2	localObject11	Object
        //   101	21	3	arrayOfByte	byte[]
        //   151	1	3	localException6	java.lang.Exception
        //   161	6	3	localException7	java.lang.Exception
        //   189	4	3	localObject12	Object
        //   260	191	3	localObject13	Object
        //   266	131	4	localObject14	Object
        //   428	5	4	localObject15	Object
        //   337	1	5	localException8	java.lang.Exception
        //   354	1	5	localException9	java.lang.Exception
        //   374	13	5	localException10	java.lang.Exception
        //   254	89	6	localBufferedReader	java.io.BufferedReader
        //   39	423	7	localFile	java.io.File
        //   219	304	8	localArrayList	ArrayList
        // Exception table:
        //   from	to	target	type
        //   118	126	151	java/lang/Exception
        //   128	135	151	java/lang/Exception
        //   137	144	151	java/lang/Exception
        //   106	116	155	finally
        //   106	116	161	java/lang/Exception
        //   144	148	181	java/lang/Exception
        //   174	178	181	java/lang/Exception
        //   118	126	189	finally
        //   128	135	189	finally
        //   137	144	189	finally
        //   166	170	189	finally
        //   198	202	205	java/lang/Exception
        //   321	330	333	java/lang/Exception
        //   261	268	337	java/lang/Exception
        //   278	286	337	java/lang/Exception
        //   291	306	337	java/lang/Exception
        //   311	318	337	java/lang/Exception
        //   246	256	348	finally
        //   246	256	354	java/lang/Exception
        //   236	246	366	finally
        //   236	246	374	java/lang/Exception
        //   261	268	428	finally
        //   278	286	428	finally
        //   291	306	428	finally
        //   311	318	428	finally
        //   386	391	428	finally
        //   396	401	551	java/lang/Exception
        //   408	412	551	java/lang/Exception
        //   439	443	555	java/lang/Exception
        //   450	454	555	java/lang/Exception
      }
    }).start();
  }
  
  public final void a(boolean paramBoolean)
  {
    this.d = ky.a("key_dialog_cofig_6348", ahc.c("key_dialog_cofig_6348", null));
    StringBuilder localStringBuilder = new StringBuilder("dialog config fromCloud(");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("): ");
    localStringBuilder.append(this.d);
    TmsLog.i("GuideMgr", localStringBuilder.toString());
    this.e = ky.a("key_tips1_cofig_6348", ahc.c("key_tips1_cofig_6348", null));
    localStringBuilder = new StringBuilder("tips1 config fromCloud(");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("): ");
    localStringBuilder.append(this.e);
    TmsLog.i("GuideMgr", localStringBuilder.toString());
    this.f = ky.a("key_tips2_cofig_6348", ahc.c("key_tips2_cofig_6348", null));
    localStringBuilder = new StringBuilder("tips2 config fromCloud(");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("): ");
    localStringBuilder.append(this.f);
    TmsLog.i("GuideMgr", localStringBuilder.toString());
    this.g = ky.a("key_eval_cofig_6348", ahc.c("key_eval_cofig_6348", null));
    localStringBuilder = new StringBuilder("eval config fromCloud(");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("): ");
    localStringBuilder.append(this.g);
    TmsLog.i("GuideMgr", localStringBuilder.toString());
  }
  
  public static final class a
  {
    public static kz a = new kz((byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.kz
 * JD-Core Version:    0.7.0.1
 */