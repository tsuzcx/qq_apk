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

public final class ks
{
  public String a;
  public String b;
  public String c;
  private kr d;
  private kr e;
  private kr f;
  private kr g;
  
  private ks()
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
  
  public final kr a(String paramString)
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
        //   11: invokestatic 42	com/tencent/token/afq:c	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   14: astore_1
        //   15: new 44	java/lang/StringBuilder
        //   18: dup
        //   19: invokespecial 45	java/lang/StringBuilder:<init>	()V
        //   22: astore_2
        //   23: aload_2
        //   24: invokestatic 51	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
        //   27: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   30: pop
        //   31: aload_2
        //   32: getstatic 61	java/io/File:separator	Ljava/lang/String;
        //   35: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   38: pop
        //   39: aload_2
        //   40: ldc 66
        //   42: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   45: pop
        //   46: new 57	java/io/File
        //   49: dup
        //   50: aload_2
        //   51: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   54: ldc 72
        //   56: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
        //   59: astore 7
        //   61: aload_1
        //   62: invokestatic 80	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   65: ifne +194 -> 259
        //   68: ldc 24
        //   70: ldc 82
        //   72: aload_1
        //   73: invokestatic 88	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   76: invokevirtual 92	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   79: invokestatic 32	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   82: new 44	java/lang/StringBuilder
        //   85: dup
        //   86: invokespecial 45	java/lang/StringBuilder:<init>	()V
        //   89: astore_2
        //   90: aload_2
        //   91: invokestatic 51	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
        //   94: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   97: pop
        //   98: aload_2
        //   99: getstatic 61	java/io/File:separator	Ljava/lang/String;
        //   102: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   105: pop
        //   106: aload_2
        //   107: ldc 66
        //   109: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   112: pop
        //   113: new 57	java/io/File
        //   116: dup
        //   117: aload_2
        //   118: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   121: invokespecial 95	java/io/File:<init>	(Ljava/lang/String;)V
        //   124: astore_2
        //   125: aload_2
        //   126: invokevirtual 99	java/io/File:exists	()Z
        //   129: ifne +8 -> 137
        //   132: aload_2
        //   133: invokevirtual 102	java/io/File:mkdirs	()Z
        //   136: pop
        //   137: new 104	com/tencent/token/ahq
        //   140: dup
        //   141: invokespecial 105	com/tencent/token/ahq:<init>	()V
        //   144: aload_1
        //   145: invokevirtual 108	com/tencent/token/ahq:a	(Ljava/lang/String;)[B
        //   148: astore_3
        //   149: aload_3
        //   150: ifnull +109 -> 259
        //   153: new 110	java/io/FileOutputStream
        //   156: dup
        //   157: aload 7
        //   159: invokespecial 113	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   162: astore_2
        //   163: aload_2
        //   164: astore_1
        //   165: aload_2
        //   166: aload_3
        //   167: iconst_0
        //   168: aload_3
        //   169: arraylength
        //   170: invokevirtual 117	java/io/FileOutputStream:write	([BII)V
        //   173: aload_2
        //   174: astore_1
        //   175: ldc 24
        //   177: ldc 119
        //   179: invokestatic 32	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   182: aload_2
        //   183: astore_1
        //   184: ldc 34
        //   186: ldc 36
        //   188: invokestatic 122	com/tencent/token/afq:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   191: aload_2
        //   192: invokevirtual 125	java/io/FileOutputStream:close	()V
        //   195: goto +64 -> 259
        //   198: astore_3
        //   199: goto +12 -> 211
        //   202: astore_1
        //   203: aconst_null
        //   204: astore_2
        //   205: goto +36 -> 241
        //   208: astore_3
        //   209: aconst_null
        //   210: astore_2
        //   211: aload_2
        //   212: astore_1
        //   213: aload_3
        //   214: invokevirtual 128	java/lang/Exception:printStackTrace	()V
        //   217: aload_2
        //   218: ifnull +41 -> 259
        //   221: aload_2
        //   222: invokevirtual 125	java/io/FileOutputStream:close	()V
        //   225: goto +34 -> 259
        //   228: astore_1
        //   229: aload_1
        //   230: invokevirtual 128	java/lang/Exception:printStackTrace	()V
        //   233: goto +26 -> 259
        //   236: astore_3
        //   237: aload_1
        //   238: astore_2
        //   239: aload_3
        //   240: astore_1
        //   241: aload_2
        //   242: ifnull +15 -> 257
        //   245: aload_2
        //   246: invokevirtual 125	java/io/FileOutputStream:close	()V
        //   249: goto +8 -> 257
        //   252: astore_2
        //   253: aload_2
        //   254: invokevirtual 128	java/lang/Exception:printStackTrace	()V
        //   257: aload_1
        //   258: athrow
        //   259: new 130	java/util/ArrayList
        //   262: dup
        //   263: invokespecial 131	java/util/ArrayList:<init>	()V
        //   266: astore 8
        //   268: aload 7
        //   270: invokevirtual 99	java/io/File:exists	()Z
        //   273: ifeq +243 -> 516
        //   276: ldc 24
        //   278: ldc 133
        //   280: invokestatic 32	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   283: new 135	java/io/FileReader
        //   286: dup
        //   287: aload 7
        //   289: invokespecial 136	java/io/FileReader:<init>	(Ljava/io/File;)V
        //   292: astore_1
        //   293: new 138	java/io/BufferedReader
        //   296: dup
        //   297: aload_1
        //   298: invokespecial 141	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   301: astore 6
        //   303: aload_1
        //   304: astore_2
        //   305: aload 6
        //   307: astore_3
        //   308: aload 6
        //   310: invokevirtual 144	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   313: astore 4
        //   315: aload 4
        //   317: ifnull +51 -> 368
        //   320: aload_1
        //   321: astore_2
        //   322: aload 6
        //   324: astore_3
        //   325: aload 8
        //   327: aload 4
        //   329: invokevirtual 148	java/util/ArrayList:add	(Ljava/lang/Object;)Z
        //   332: pop
        //   333: aload_1
        //   334: astore_2
        //   335: aload 6
        //   337: astore_3
        //   338: ldc 24
        //   340: ldc 150
        //   342: aload 4
        //   344: invokestatic 88	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   347: invokevirtual 92	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   350: invokestatic 32	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   353: aload_1
        //   354: astore_2
        //   355: aload 6
        //   357: astore_3
        //   358: aload 6
        //   360: invokevirtual 144	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   363: astore 4
        //   365: goto -50 -> 315
        //   368: aload_1
        //   369: invokevirtual 151	java/io/FileReader:close	()V
        //   372: aload 6
        //   374: invokevirtual 152	java/io/BufferedReader:close	()V
        //   377: goto +89 -> 466
        //   380: astore_1
        //   381: goto +81 -> 462
        //   384: astore 5
        //   386: aload_1
        //   387: astore 4
        //   389: aload 6
        //   391: astore_1
        //   392: goto +36 -> 428
        //   395: astore_2
        //   396: aconst_null
        //   397: astore_3
        //   398: goto +84 -> 482
        //   401: astore 5
        //   403: aconst_null
        //   404: astore_2
        //   405: aload_1
        //   406: astore 4
        //   408: aload_2
        //   409: astore_1
        //   410: goto +18 -> 428
        //   413: astore_2
        //   414: aconst_null
        //   415: astore_1
        //   416: aload_1
        //   417: astore_3
        //   418: goto +64 -> 482
        //   421: astore 5
        //   423: aconst_null
        //   424: astore_1
        //   425: aload_1
        //   426: astore 4
        //   428: aload 4
        //   430: astore_2
        //   431: aload_1
        //   432: astore_3
        //   433: aload 5
        //   435: invokevirtual 128	java/lang/Exception:printStackTrace	()V
        //   438: aload 4
        //   440: ifnull +11 -> 451
        //   443: aload 4
        //   445: invokevirtual 151	java/io/FileReader:close	()V
        //   448: goto +3 -> 451
        //   451: aload_1
        //   452: ifnull +14 -> 466
        //   455: aload_1
        //   456: invokevirtual 152	java/io/BufferedReader:close	()V
        //   459: goto +7 -> 466
        //   462: aload_1
        //   463: invokevirtual 128	java/lang/Exception:printStackTrace	()V
        //   466: aload 7
        //   468: invokevirtual 155	java/io/File:delete	()Z
        //   471: pop
        //   472: goto +44 -> 516
        //   475: astore 4
        //   477: aload_2
        //   478: astore_1
        //   479: aload 4
        //   481: astore_2
        //   482: aload_1
        //   483: ifnull +10 -> 493
        //   486: aload_1
        //   487: invokevirtual 151	java/io/FileReader:close	()V
        //   490: goto +3 -> 493
        //   493: aload_3
        //   494: ifnull +14 -> 508
        //   497: aload_3
        //   498: invokevirtual 152	java/io/BufferedReader:close	()V
        //   501: goto +7 -> 508
        //   504: aload_1
        //   505: invokevirtual 128	java/lang/Exception:printStackTrace	()V
        //   508: aload 7
        //   510: invokevirtual 155	java/io/File:delete	()Z
        //   513: pop
        //   514: aload_2
        //   515: athrow
        //   516: aload 8
        //   518: invokevirtual 159	java/util/ArrayList:size	()I
        //   521: iconst_3
        //   522: if_icmple +68 -> 590
        //   525: ldc 161
        //   527: aload 8
        //   529: iconst_0
        //   530: invokevirtual 165	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   533: checkcast 84	java/lang/String
        //   536: invokestatic 122	com/tencent/token/afq:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   539: ldc 167
        //   541: aload 8
        //   543: iconst_1
        //   544: invokevirtual 165	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   547: checkcast 84	java/lang/String
        //   550: invokestatic 122	com/tencent/token/afq:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   553: ldc 169
        //   555: aload 8
        //   557: iconst_2
        //   558: invokevirtual 165	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   561: checkcast 84	java/lang/String
        //   564: invokestatic 122	com/tencent/token/afq:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   567: ldc 171
        //   569: aload 8
        //   571: iconst_3
        //   572: invokevirtual 165	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   575: checkcast 84	java/lang/String
        //   578: invokestatic 122	com/tencent/token/afq:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   581: aload_0
        //   582: getfield 16	com/tencent/token/ks$1:a	Lcom/tencent/token/ks;
        //   585: iconst_1
        //   586: invokevirtual 174	com/tencent/token/ks:a	(Z)V
        //   589: return
        //   590: ldc 24
        //   592: ldc 176
        //   594: invokestatic 179	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   597: return
        //   598: astore_1
        //   599: goto -137 -> 462
        //   602: astore_1
        //   603: goto -99 -> 504
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	606	0	this	1
        //   14	170	1	localObject1	Object
        //   202	1	1	localObject2	Object
        //   212	1	1	localObject3	Object
        //   228	10	1	localException1	java.lang.Exception
        //   240	129	1	localObject4	Object
        //   380	7	1	localException2	java.lang.Exception
        //   391	114	1	localObject5	Object
        //   598	1	1	localException3	java.lang.Exception
        //   602	1	1	localException4	java.lang.Exception
        //   22	224	2	localObject6	Object
        //   252	2	2	localException5	java.lang.Exception
        //   304	51	2	localObject7	Object
        //   395	1	2	localObject8	Object
        //   404	5	2	localObject9	Object
        //   413	1	2	localObject10	Object
        //   430	85	2	localObject11	Object
        //   148	21	3	arrayOfByte	byte[]
        //   198	1	3	localException6	java.lang.Exception
        //   208	6	3	localException7	java.lang.Exception
        //   236	4	3	localObject12	Object
        //   307	191	3	localObject13	Object
        //   313	131	4	localObject14	Object
        //   475	5	4	localObject15	Object
        //   384	1	5	localException8	java.lang.Exception
        //   401	1	5	localException9	java.lang.Exception
        //   421	13	5	localException10	java.lang.Exception
        //   301	89	6	localBufferedReader	java.io.BufferedReader
        //   59	450	7	localFile	java.io.File
        //   266	304	8	localArrayList	ArrayList
        // Exception table:
        //   from	to	target	type
        //   165	173	198	java/lang/Exception
        //   175	182	198	java/lang/Exception
        //   184	191	198	java/lang/Exception
        //   153	163	202	finally
        //   153	163	208	java/lang/Exception
        //   191	195	228	java/lang/Exception
        //   221	225	228	java/lang/Exception
        //   165	173	236	finally
        //   175	182	236	finally
        //   184	191	236	finally
        //   213	217	236	finally
        //   245	249	252	java/lang/Exception
        //   368	377	380	java/lang/Exception
        //   308	315	384	java/lang/Exception
        //   325	333	384	java/lang/Exception
        //   338	353	384	java/lang/Exception
        //   358	365	384	java/lang/Exception
        //   293	303	395	finally
        //   293	303	401	java/lang/Exception
        //   283	293	413	finally
        //   283	293	421	java/lang/Exception
        //   308	315	475	finally
        //   325	333	475	finally
        //   338	353	475	finally
        //   358	365	475	finally
        //   433	438	475	finally
        //   443	448	598	java/lang/Exception
        //   455	459	598	java/lang/Exception
        //   486	490	602	java/lang/Exception
        //   497	501	602	java/lang/Exception
      }
    }).start();
  }
  
  public final void a(boolean paramBoolean)
  {
    this.d = kr.a("key_dialog_cofig_6348", afq.c("key_dialog_cofig_6348", null));
    StringBuilder localStringBuilder = new StringBuilder("dialog config fromCloud(");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("): ");
    localStringBuilder.append(this.d);
    TmsLog.i("GuideMgr", localStringBuilder.toString());
    this.e = kr.a("key_tips1_cofig_6348", afq.c("key_tips1_cofig_6348", null));
    localStringBuilder = new StringBuilder("tips1 config fromCloud(");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("): ");
    localStringBuilder.append(this.e);
    TmsLog.i("GuideMgr", localStringBuilder.toString());
    this.f = kr.a("key_tips2_cofig_6348", afq.c("key_tips2_cofig_6348", null));
    localStringBuilder = new StringBuilder("tips2 config fromCloud(");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("): ");
    localStringBuilder.append(this.f);
    TmsLog.i("GuideMgr", localStringBuilder.toString());
    this.g = kr.a("key_eval_cofig_6348", afq.c("key_eval_cofig_6348", null));
    localStringBuilder = new StringBuilder("eval config fromCloud(");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("): ");
    localStringBuilder.append(this.g);
    TmsLog.i("GuideMgr", localStringBuilder.toString());
  }
  
  public static final class a
  {
    public static ks a = new ks((byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ks
 * JD-Core Version:    0.7.0.1
 */