package com.tencent.mobileqq.app;

import acbn;
import acif;
import ajpj;
import anbk;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ton;

public class NearbyGrayTipsManager
  implements Manager
{
  private long Qz;
  private QQAppInterface app;
  private boolean bIE;
  private boolean bIF;
  private int bgv;
  private int cxd;
  private int cxe;
  private int cxf;
  private Random g;
  private ArrayList<GrayTipsConfig> tq = new ArrayList();
  private List<GreetWording> xJ;
  private List<FaceScoreWording> xK;
  private List<GrayTipStatisticData> xL;
  
  public NearbyGrayTipsManager(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.xJ = new ArrayList(2);
    this.xK = new ArrayList(2);
    this.xL = new ArrayList(2);
    this.g = new Random();
    this.g.setSeed(System.currentTimeMillis());
  }
  
  private FaceScoreWording a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q..troop.faceScore", 2, "getFaceScoreWordingById id= " + paramInt);
    }
    for (;;)
    {
      int i;
      synchronized (this.xK)
      {
        int j = this.xK.size();
        i = 0;
        FaceScoreWording localFaceScoreWording = null;
        if (i < j)
        {
          localFaceScoreWording = (FaceScoreWording)this.xK.get(i);
          if (localFaceScoreWording == null) {
            break label144;
          }
          if (localFaceScoreWording.id != paramInt) {}
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q..troop.faceScore", 2, "getFaceScoreWordingById return faceScoreWording= " + localFaceScoreWording);
          }
          return localFaceScoreWording;
        }
        localFaceScoreWording = null;
      }
      label144:
      i += 1;
    }
  }
  
  private GrayTipsConfig a(int paramInt1, int paramInt2, int paramInt3, long paramLong, GrayTipsConfig paramGrayTipsConfig)
  {
    for (;;)
    {
      synchronized (this.tq)
      {
        if (this.tq.size() <= 0) {
          break label248;
        }
        Iterator localIterator = this.tq.iterator();
        localObject = paramGrayTipsConfig;
        if (localIterator.hasNext())
        {
          GrayTipsConfig localGrayTipsConfig = (GrayTipsConfig)localIterator.next();
          if ((localGrayTipsConfig == null) || (localGrayTipsConfig.sceneId != 3) || (localGrayTipsConfig.sceneThree == null) || (!localGrayTipsConfig.sceneThree.keywordTrigger) || (localGrayTipsConfig.sceneThree.keywords == null) || (localGrayTipsConfig.sceneThree.keywords.size() == 0) || (localGrayTipsConfig.sceneThree.whichSide == null) || (!localGrayTipsConfig.sceneThree.whichSide.contains(Integer.valueOf(paramInt3)))) {
            continue;
          }
          if (!localGrayTipsConfig.isValid(this.app, paramInt1, paramInt2, paramLong)) {
            break label241;
          }
          if (paramGrayTipsConfig == null)
          {
            localObject = localGrayTipsConfig;
          }
          else
          {
            localObject = localGrayTipsConfig;
            if (paramGrayTipsConfig.priority >= localGrayTipsConfig.priority)
            {
              if (paramGrayTipsConfig.priority != localGrayTipsConfig.priority) {
                break label241;
              }
              localObject = localGrayTipsConfig;
              if (paramGrayTipsConfig.createTime >= localGrayTipsConfig.createTime) {
                break label241;
              }
            }
          }
        }
        else
        {
          return localObject;
        }
      }
      for (;;)
      {
        paramGrayTipsConfig = (GrayTipsConfig)localObject;
        break;
        label241:
        localObject = paramGrayTipsConfig;
      }
      label248:
      Object localObject = paramGrayTipsConfig;
    }
  }
  
  private GrayTipsConfig a(int paramInt1, int paramInt2, long paramLong, GrayTipsConfig paramGrayTipsConfig)
  {
    for (;;)
    {
      synchronized (this.tq)
      {
        if (this.tq.size() <= 0) {
          break label215;
        }
        Iterator localIterator = this.tq.iterator();
        localObject = paramGrayTipsConfig;
        if (localIterator.hasNext())
        {
          GrayTipsConfig localGrayTipsConfig = (GrayTipsConfig)localIterator.next();
          if ((localGrayTipsConfig == null) || (localGrayTipsConfig.sceneId != 2) || (localGrayTipsConfig.sceneTwo == null) || (!localGrayTipsConfig.sceneTwo.sayHiFrequencyControl) || (localGrayTipsConfig.sceneTwo.timeRange == 0) || (localGrayTipsConfig.sceneTwo.sayHiPeopleCount == 0)) {
            continue;
          }
          if (!localGrayTipsConfig.isValid(this.app, paramInt1, paramInt2, paramLong)) {
            break label208;
          }
          if (paramGrayTipsConfig == null)
          {
            localObject = localGrayTipsConfig;
          }
          else
          {
            localObject = localGrayTipsConfig;
            if (paramGrayTipsConfig.priority >= localGrayTipsConfig.priority)
            {
              if (paramGrayTipsConfig.priority != localGrayTipsConfig.priority) {
                break label208;
              }
              localObject = localGrayTipsConfig;
              if (paramGrayTipsConfig.createTime >= localGrayTipsConfig.createTime) {
                break label208;
              }
            }
          }
        }
        else
        {
          return localObject;
        }
      }
      for (;;)
      {
        paramGrayTipsConfig = (GrayTipsConfig)localObject;
        break;
        label208:
        localObject = paramGrayTipsConfig;
      }
      label215:
      Object localObject = paramGrayTipsConfig;
    }
  }
  
  /* Error */
  public static GrayTipsConfig a(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 225	java/io/File:exists	()Z
    //   8: ifne +7 -> 15
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_1
    //   14: areturn
    //   15: new 112	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   22: astore 6
    //   24: new 227	java/io/FileReader
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 230	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   32: astore_0
    //   33: new 232	java/io/BufferedReader
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 235	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   41: astore_3
    //   42: aload_0
    //   43: astore_2
    //   44: aload_3
    //   45: astore_1
    //   46: aload_3
    //   47: invokevirtual 238	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   50: astore 4
    //   52: aload 4
    //   54: ifnull +253 -> 307
    //   57: aload_0
    //   58: astore_2
    //   59: aload_3
    //   60: astore_1
    //   61: aload 6
    //   63: aload 4
    //   65: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: goto -27 -> 42
    //   72: astore 4
    //   74: aload_0
    //   75: astore_2
    //   76: aload_3
    //   77: astore_1
    //   78: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +15 -> 96
    //   84: aload_0
    //   85: astore_2
    //   86: aload_3
    //   87: astore_1
    //   88: ldc 240
    //   90: iconst_2
    //   91: ldc 242
    //   93: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   96: aload_0
    //   97: astore_2
    //   98: aload_3
    //   99: astore_1
    //   100: aload 4
    //   102: invokevirtual 245	java/io/FileNotFoundException:printStackTrace	()V
    //   105: aload_3
    //   106: ifnull +7 -> 113
    //   109: aload_3
    //   110: invokevirtual 248	java/io/BufferedReader:close	()V
    //   113: aload_0
    //   114: ifnull +7 -> 121
    //   117: aload_0
    //   118: invokevirtual 249	java/io/FileReader:close	()V
    //   121: aload 6
    //   123: invokevirtual 252	java/lang/StringBuilder:length	()I
    //   126: ifle +406 -> 532
    //   129: new 254	org/json/JSONObject
    //   132: dup
    //   133: aload 6
    //   135: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokespecial 257	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   141: astore_2
    //   142: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   145: ifeq +29 -> 174
    //   148: ldc 240
    //   150: iconst_2
    //   151: new 112	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   158: ldc_w 259
    //   161: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_2
    //   165: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   174: new 14	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig
    //   177: dup
    //   178: invokespecial 260	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:<init>	()V
    //   181: astore_0
    //   182: aload_0
    //   183: aload_2
    //   184: invokestatic 264	com/tencent/mobileqq/app/NearbyGrayTipsManager:l	(Lcom/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig;Lorg/json/JSONObject;)V
    //   187: aload_0
    //   188: astore_1
    //   189: aload_2
    //   190: ldc_w 266
    //   193: invokevirtual 270	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   196: ifne -183 -> 13
    //   199: aload_2
    //   200: ldc_w 266
    //   203: invokevirtual 274	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   206: astore_1
    //   207: aload_0
    //   208: aload_1
    //   209: invokestatic 277	com/tencent/mobileqq/app/NearbyGrayTipsManager:k	(Lcom/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig;Lorg/json/JSONObject;)V
    //   212: aload_0
    //   213: aload_1
    //   214: invokestatic 280	com/tencent/mobileqq/app/NearbyGrayTipsManager:j	(Lcom/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig;Lorg/json/JSONObject;)V
    //   217: aload_0
    //   218: aload_1
    //   219: invokestatic 283	com/tencent/mobileqq/app/NearbyGrayTipsManager:i	(Lcom/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig;Lorg/json/JSONObject;)V
    //   222: aload_0
    //   223: aload_1
    //   224: invokestatic 286	com/tencent/mobileqq/app/NearbyGrayTipsManager:h	(Lcom/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig;Lorg/json/JSONObject;)V
    //   227: aload_0
    //   228: aload_1
    //   229: invokestatic 288	com/tencent/mobileqq/app/NearbyGrayTipsManager:g	(Lcom/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig;Lorg/json/JSONObject;)V
    //   232: aload_0
    //   233: aload_1
    //   234: invokestatic 291	com/tencent/mobileqq/app/NearbyGrayTipsManager:f	(Lcom/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig;Lorg/json/JSONObject;)V
    //   237: aload_0
    //   238: aload_1
    //   239: invokestatic 294	com/tencent/mobileqq/app/NearbyGrayTipsManager:e	(Lcom/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig;Lorg/json/JSONObject;)V
    //   242: aload_0
    //   243: aload_1
    //   244: invokestatic 296	com/tencent/mobileqq/app/NearbyGrayTipsManager:d	(Lcom/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig;Lorg/json/JSONObject;)V
    //   247: aload_0
    //   248: aload_1
    //   249: invokestatic 299	com/tencent/mobileqq/app/NearbyGrayTipsManager:c	(Lcom/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig;Lorg/json/JSONObject;)V
    //   252: aload_0
    //   253: aload_1
    //   254: invokestatic 302	com/tencent/mobileqq/app/NearbyGrayTipsManager:b	(Lcom/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig;Lorg/json/JSONObject;)V
    //   257: aload_0
    //   258: aload_1
    //   259: invokestatic 304	com/tencent/mobileqq/app/NearbyGrayTipsManager:a	(Lcom/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig;Lorg/json/JSONObject;)V
    //   262: aload_0
    //   263: areturn
    //   264: astore_1
    //   265: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq +33 -> 301
    //   271: ldc 240
    //   273: iconst_2
    //   274: new 112	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   281: ldc_w 306
    //   284: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload 6
    //   289: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   301: aload_1
    //   302: invokevirtual 307	org/json/JSONException:printStackTrace	()V
    //   305: aload_0
    //   306: areturn
    //   307: aload_3
    //   308: ifnull +7 -> 315
    //   311: aload_3
    //   312: invokevirtual 248	java/io/BufferedReader:close	()V
    //   315: aload_0
    //   316: ifnull -195 -> 121
    //   319: aload_0
    //   320: invokevirtual 249	java/io/FileReader:close	()V
    //   323: goto -202 -> 121
    //   326: astore_0
    //   327: aload_0
    //   328: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   331: goto -210 -> 121
    //   334: astore_1
    //   335: aload_1
    //   336: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   339: goto -24 -> 315
    //   342: astore_1
    //   343: aload_1
    //   344: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   347: goto -234 -> 113
    //   350: astore_0
    //   351: aload_0
    //   352: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   355: goto -234 -> 121
    //   358: astore 5
    //   360: aconst_null
    //   361: astore 4
    //   363: aconst_null
    //   364: astore_0
    //   365: aload 4
    //   367: astore_2
    //   368: aload_0
    //   369: astore_1
    //   370: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   373: ifeq +17 -> 390
    //   376: aload 4
    //   378: astore_2
    //   379: aload_0
    //   380: astore_1
    //   381: ldc 240
    //   383: iconst_2
    //   384: ldc_w 310
    //   387: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   390: aload 4
    //   392: astore_2
    //   393: aload_0
    //   394: astore_1
    //   395: aload 5
    //   397: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   400: aload_0
    //   401: ifnull +7 -> 408
    //   404: aload_0
    //   405: invokevirtual 248	java/io/BufferedReader:close	()V
    //   408: aload 4
    //   410: ifnull -289 -> 121
    //   413: aload 4
    //   415: invokevirtual 249	java/io/FileReader:close	()V
    //   418: goto -297 -> 121
    //   421: astore_0
    //   422: aload_0
    //   423: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   426: goto -305 -> 121
    //   429: astore_0
    //   430: aload_0
    //   431: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   434: goto -26 -> 408
    //   437: astore_3
    //   438: aconst_null
    //   439: astore_0
    //   440: aconst_null
    //   441: astore_1
    //   442: aload_1
    //   443: ifnull +7 -> 450
    //   446: aload_1
    //   447: invokevirtual 248	java/io/BufferedReader:close	()V
    //   450: aload_0
    //   451: ifnull +7 -> 458
    //   454: aload_0
    //   455: invokevirtual 249	java/io/FileReader:close	()V
    //   458: aload_3
    //   459: athrow
    //   460: astore_1
    //   461: aload_1
    //   462: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   465: goto -15 -> 450
    //   468: astore_0
    //   469: aload_0
    //   470: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   473: goto -15 -> 458
    //   476: astore_1
    //   477: aconst_null
    //   478: astore_0
    //   479: goto -214 -> 265
    //   482: astore_3
    //   483: aconst_null
    //   484: astore_1
    //   485: goto -43 -> 442
    //   488: astore_3
    //   489: aload_2
    //   490: astore_0
    //   491: goto -49 -> 442
    //   494: astore 5
    //   496: aconst_null
    //   497: astore_1
    //   498: aload_0
    //   499: astore 4
    //   501: aload_1
    //   502: astore_0
    //   503: goto -138 -> 365
    //   506: astore 5
    //   508: aload_0
    //   509: astore 4
    //   511: aload_3
    //   512: astore_0
    //   513: goto -148 -> 365
    //   516: astore 4
    //   518: aconst_null
    //   519: astore_0
    //   520: aconst_null
    //   521: astore_3
    //   522: goto -448 -> 74
    //   525: astore 4
    //   527: aconst_null
    //   528: astore_3
    //   529: goto -455 -> 74
    //   532: aconst_null
    //   533: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	534	0	paramFile	File
    //   12	247	1	localObject1	Object
    //   264	38	1	localJSONException1	JSONException
    //   334	2	1	localIOException1	java.io.IOException
    //   342	2	1	localIOException2	java.io.IOException
    //   369	78	1	localFile1	File
    //   460	2	1	localIOException3	java.io.IOException
    //   476	1	1	localJSONException2	JSONException
    //   484	18	1	localObject2	Object
    //   43	447	2	localObject3	Object
    //   41	271	3	localBufferedReader	java.io.BufferedReader
    //   437	22	3	localObject4	Object
    //   482	1	3	localObject5	Object
    //   488	24	3	localObject6	Object
    //   521	8	3	localObject7	Object
    //   50	14	4	str	String
    //   72	29	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   361	149	4	localFile2	File
    //   516	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   525	1	4	localFileNotFoundException3	java.io.FileNotFoundException
    //   358	38	5	localIOException4	java.io.IOException
    //   494	1	5	localIOException5	java.io.IOException
    //   506	1	5	localIOException6	java.io.IOException
    //   22	266	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   46	52	72	java/io/FileNotFoundException
    //   61	69	72	java/io/FileNotFoundException
    //   182	187	264	org/json/JSONException
    //   189	262	264	org/json/JSONException
    //   319	323	326	java/io/IOException
    //   311	315	334	java/io/IOException
    //   109	113	342	java/io/IOException
    //   117	121	350	java/io/IOException
    //   24	33	358	java/io/IOException
    //   413	418	421	java/io/IOException
    //   404	408	429	java/io/IOException
    //   24	33	437	finally
    //   446	450	460	java/io/IOException
    //   454	458	468	java/io/IOException
    //   129	174	476	org/json/JSONException
    //   174	182	476	org/json/JSONException
    //   33	42	482	finally
    //   46	52	488	finally
    //   61	69	488	finally
    //   78	84	488	finally
    //   88	96	488	finally
    //   100	105	488	finally
    //   370	376	488	finally
    //   381	390	488	finally
    //   395	400	488	finally
    //   33	42	494	java/io/IOException
    //   46	52	506	java/io/IOException
    //   61	69	506	java/io/IOException
    //   24	33	516	java/io/FileNotFoundException
    //   33	42	525	java/io/FileNotFoundException
  }
  
  private GrayTipsConfig a(String paramString, GrayTipsConfig paramGrayTipsConfig)
  {
    GrayTipsConfig localGrayTipsConfig = paramGrayTipsConfig;
    if (paramGrayTipsConfig != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        localGrayTipsConfig = null;
      }
    }
    else {
      return localGrayTipsConfig;
    }
    int i = 0;
    for (;;)
    {
      if ((i >= paramGrayTipsConfig.sceneThree.keywords.size()) || (paramString.indexOf((String)paramGrayTipsConfig.sceneThree.keywords.get(i)) >= 0))
      {
        localGrayTipsConfig = paramGrayTipsConfig;
        if (i != paramGrayTipsConfig.sceneThree.keywords.size()) {
          break;
        }
        return null;
      }
      i += 1;
    }
  }
  
  private GreetWording a(int paramInt)
  {
    int i;
    synchronized (this.xJ)
    {
      int j = this.xJ.size();
      i = 0;
      GreetWording localGreetWording = null;
      if (i < j)
      {
        localGreetWording = (GreetWording)this.xJ.get(i);
        if (localGreetWording != null) {
          if (localGreetWording.id != paramInt) {
            break label82;
          }
        }
      }
      else
      {
        return localGreetWording;
      }
    }
    for (;;)
    {
      i += 1;
      break;
      label82:
      Object localObject2 = null;
    }
  }
  
  private void a(long paramLong, GrayTipsConfig paramGrayTipsConfig, List<MessageRecord> paramList)
  {
    paramLong = (paramLong - paramGrayTipsConfig.sceneTwo.timeRange * 60 * 1000) / 1000L;
    int i = paramList.size() - 1;
    if (i >= 0)
    {
      paramGrayTipsConfig = (MessageRecord)paramList.get(i);
      if (paramGrayTipsConfig != null) {
        if (paramGrayTipsConfig.time < paramLong) {
          paramList.remove(i);
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        paramList.remove(i);
      }
    }
  }
  
  private void a(GrayTipsConfig paramGrayTipsConfig, List<MessageRecord> paramList)
  {
    paramGrayTipsConfig = paramGrayTipsConfig.aioTypes.iterator();
    while (paramGrayTipsConfig.hasNext())
    {
      Object localObject = (Integer)paramGrayTipsConfig.next();
      if (((Integer)localObject).intValue() == 1)
      {
        localObject = this.app.a(1001).g(acbn.bkE, 1001);
        List localList = this.app.a(10002).g(acbn.bkE, 10002);
        paramList.addAll((Collection)localObject);
        paramList.addAll(localList);
      }
      else if (((Integer)localObject).intValue() == 2)
      {
        paramList.addAll(this.app.a(1010).g(acbn.bkY, 1010));
      }
    }
  }
  
  private static void a(GrayTipsConfig paramGrayTipsConfig, JSONObject paramJSONObject)
    throws JSONException
  {
    int j = 0;
    if (!paramJSONObject.isNull("SceneType")) {
      paramGrayTipsConfig.sceneId = paramJSONObject.getInt("SceneType");
    }
    Object localObject1;
    Object localObject2;
    int i;
    if (!paramJSONObject.isNull("RandomWording"))
    {
      localObject1 = paramJSONObject.getJSONArray("RandomWording");
      localObject2 = new ArrayList();
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        ((ArrayList)localObject2).add(((JSONArray)localObject1).getString(i));
        i += 1;
      }
      paramGrayTipsConfig.randomWordings = ((ArrayList)localObject2);
    }
    if (!paramJSONObject.isNull("SceneFirst"))
    {
      localObject1 = paramJSONObject.getJSONObject("SceneFirst");
      localObject2 = new SceneOne();
      if (!((JSONObject)localObject1).isNull("SayHiTrigger")) {
        ((SceneOne)localObject2).sayHiTrigger = ((JSONObject)localObject1).getBoolean("SayHiTrigger");
      }
      paramGrayTipsConfig.sceneOne = ((SceneOne)localObject2);
    }
    if (!paramJSONObject.isNull("SceneSecond"))
    {
      localObject1 = paramJSONObject.getJSONObject("SceneSecond");
      localObject2 = new SceneTwo();
      if (!((JSONObject)localObject1).isNull("SayHiFrequencyControl"))
      {
        ((SceneTwo)localObject2).sayHiFrequencyControl = ((JSONObject)localObject1).getBoolean("SayHiFrequencyControl");
        if (!((JSONObject)localObject1).isNull("TimeRange")) {
          ((SceneTwo)localObject2).timeRange = ((JSONObject)localObject1).getInt("TimeRange");
        }
        if (!((JSONObject)localObject1).isNull("UsersCount")) {
          ((SceneTwo)localObject2).sayHiPeopleCount = ((JSONObject)localObject1).getInt("UsersCount");
        }
      }
      paramGrayTipsConfig.sceneTwo = ((SceneTwo)localObject2);
    }
    Object localObject3;
    if (!paramJSONObject.isNull("SceneThird"))
    {
      localObject2 = paramJSONObject.getJSONObject("SceneThird");
      if (!((JSONObject)localObject2).isNull("KeywordTrigger"))
      {
        localObject1 = new SceneThree();
        ((SceneThree)localObject1).keywordTrigger = ((JSONObject)localObject2).getBoolean("KeywordTrigger");
        if (!((JSONObject)localObject2).isNull("MessageSide"))
        {
          localObject3 = ((JSONObject)localObject2).getJSONArray("MessageSide");
          ArrayList localArrayList = new ArrayList();
          i = 0;
          while (i < ((JSONArray)localObject3).length())
          {
            localArrayList.add(Integer.valueOf(((JSONArray)localObject3).getInt(i)));
            i += 1;
          }
          ((SceneThree)localObject1).whichSide = localArrayList;
        }
        if (!((JSONObject)localObject2).isNull("KeywordList"))
        {
          localObject2 = ((JSONObject)localObject2).getJSONArray("KeywordList");
          localObject3 = new ArrayList();
          i = 0;
          while (i < ((JSONArray)localObject2).length())
          {
            ((ArrayList)localObject3).add(((JSONArray)localObject2).getString(i));
            i += 1;
          }
          ((SceneThree)localObject1).keywords = ((ArrayList)localObject3);
        }
        paramGrayTipsConfig.sceneThree = ((SceneThree)localObject1);
      }
    }
    if (!paramJSONObject.isNull("SceneForth"))
    {
      localObject1 = paramJSONObject.getJSONObject("SceneForth");
      localObject2 = new SceneFour();
      ((SceneFour)localObject2).enterAIOTrigger = ((JSONObject)localObject1).getBoolean("AIOTrigger");
      paramGrayTipsConfig.sceneFour = ((SceneFour)localObject2);
    }
    if (!paramJSONObject.isNull("SceneFifth"))
    {
      localObject1 = paramJSONObject.getJSONObject("SceneFifth");
      paramJSONObject = new SceneFive();
      paramJSONObject.faceScoreTrigger = ((JSONObject)localObject1).getBoolean("FaceScoreTrigger");
      localObject2 = ((JSONObject)localObject1).getJSONArray("RandomWordingForMale");
      localObject3 = new ArrayList();
      i = 0;
      while (i < ((JSONArray)localObject2).length())
      {
        ((ArrayList)localObject3).add(((JSONArray)localObject2).getString(i));
        i += 1;
      }
      paramJSONObject.randomWordingForMale = ((ArrayList)localObject3);
      localObject1 = ((JSONObject)localObject1).getJSONArray("RandomWordingForFemale");
      localObject2 = new ArrayList();
      i = j;
      while (i < ((JSONArray)localObject1).length())
      {
        ((ArrayList)localObject2).add(((JSONArray)localObject1).getString(i));
        i += 1;
      }
      paramJSONObject.randomWordingForFeMale = ((ArrayList)localObject2);
      paramGrayTipsConfig.sceneFive = paramJSONObject;
    }
  }
  
  /* Error */
  public static boolean a(GrayTipsConfig paramGrayTipsConfig)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aconst_null
    //   3: astore 8
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore 7
    //   11: aconst_null
    //   12: astore 4
    //   14: aload_0
    //   15: ifnonnull +5 -> 20
    //   18: iload_1
    //   19: ireturn
    //   20: new 468	java/io/FileOutputStream
    //   23: dup
    //   24: new 112	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   31: invokestatic 471	com/tencent/mobileqq/app/NearbyGrayTipsManager:rE	()Ljava/lang/String;
    //   34: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_0
    //   38: getfield 472	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:id	I
    //   41: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: ldc_w 474
    //   47: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokespecial 475	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   56: astore_2
    //   57: new 477	java/io/BufferedOutputStream
    //   60: dup
    //   61: aload_2
    //   62: invokespecial 480	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   65: astore_3
    //   66: aload_3
    //   67: astore 6
    //   69: aload_2
    //   70: astore 5
    //   72: new 482	java/io/ObjectOutputStream
    //   75: dup
    //   76: aload_3
    //   77: invokespecial 483	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   80: astore 4
    //   82: aload 4
    //   84: aload_0
    //   85: invokevirtual 487	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   88: aload_3
    //   89: invokevirtual 490	java/io/BufferedOutputStream:flush	()V
    //   92: iconst_1
    //   93: istore_1
    //   94: aload 4
    //   96: ifnull +8 -> 104
    //   99: aload 4
    //   101: invokevirtual 491	java/io/ObjectOutputStream:close	()V
    //   104: aload_3
    //   105: ifnull +7 -> 112
    //   108: aload_3
    //   109: invokevirtual 492	java/io/BufferedOutputStream:close	()V
    //   112: aload_2
    //   113: ifnull -95 -> 18
    //   116: aload_2
    //   117: invokevirtual 493	java/io/FileOutputStream:close	()V
    //   120: iconst_1
    //   121: ireturn
    //   122: astore_0
    //   123: aload_0
    //   124: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   127: iconst_1
    //   128: ireturn
    //   129: astore_3
    //   130: aconst_null
    //   131: astore_0
    //   132: aconst_null
    //   133: astore_2
    //   134: aload_3
    //   135: invokevirtual 245	java/io/FileNotFoundException:printStackTrace	()V
    //   138: aload_0
    //   139: ifnull +7 -> 146
    //   142: aload_0
    //   143: invokevirtual 491	java/io/ObjectOutputStream:close	()V
    //   146: aload 4
    //   148: ifnull +8 -> 156
    //   151: aload 4
    //   153: invokevirtual 492	java/io/BufferedOutputStream:close	()V
    //   156: aload_2
    //   157: ifnull -139 -> 18
    //   160: aload_2
    //   161: invokevirtual 493	java/io/FileOutputStream:close	()V
    //   164: iconst_0
    //   165: ireturn
    //   166: astore_0
    //   167: aload_0
    //   168: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   171: iconst_0
    //   172: ireturn
    //   173: astore_0
    //   174: aconst_null
    //   175: astore_3
    //   176: aconst_null
    //   177: astore_2
    //   178: aload 8
    //   180: astore 4
    //   182: aload 4
    //   184: astore 7
    //   186: aload_3
    //   187: astore 6
    //   189: aload_2
    //   190: astore 5
    //   192: aload_0
    //   193: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   196: aload 4
    //   198: ifnull +8 -> 206
    //   201: aload 4
    //   203: invokevirtual 491	java/io/ObjectOutputStream:close	()V
    //   206: aload_3
    //   207: ifnull +7 -> 214
    //   210: aload_3
    //   211: invokevirtual 492	java/io/BufferedOutputStream:close	()V
    //   214: aload_2
    //   215: ifnull -197 -> 18
    //   218: aload_2
    //   219: invokevirtual 493	java/io/FileOutputStream:close	()V
    //   222: iconst_0
    //   223: ireturn
    //   224: astore_0
    //   225: aload_0
    //   226: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   229: iconst_0
    //   230: ireturn
    //   231: astore_0
    //   232: aconst_null
    //   233: astore_3
    //   234: aconst_null
    //   235: astore_2
    //   236: aload 5
    //   238: astore 4
    //   240: aload 4
    //   242: ifnull +8 -> 250
    //   245: aload 4
    //   247: invokevirtual 491	java/io/ObjectOutputStream:close	()V
    //   250: aload_3
    //   251: ifnull +7 -> 258
    //   254: aload_3
    //   255: invokevirtual 492	java/io/BufferedOutputStream:close	()V
    //   258: aload_2
    //   259: ifnull +7 -> 266
    //   262: aload_2
    //   263: invokevirtual 493	java/io/FileOutputStream:close	()V
    //   266: aload_0
    //   267: athrow
    //   268: astore_2
    //   269: aload_2
    //   270: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   273: goto -7 -> 266
    //   276: astore_0
    //   277: aconst_null
    //   278: astore_3
    //   279: aload 5
    //   281: astore 4
    //   283: goto -43 -> 240
    //   286: astore_0
    //   287: aload 7
    //   289: astore 4
    //   291: aload 6
    //   293: astore_3
    //   294: aload 5
    //   296: astore_2
    //   297: goto -57 -> 240
    //   300: astore_0
    //   301: goto -61 -> 240
    //   304: astore 5
    //   306: aload 4
    //   308: astore_3
    //   309: aload_0
    //   310: astore 4
    //   312: aload 5
    //   314: astore_0
    //   315: goto -75 -> 240
    //   318: astore_0
    //   319: aconst_null
    //   320: astore_3
    //   321: aload 8
    //   323: astore 4
    //   325: goto -143 -> 182
    //   328: astore_0
    //   329: aload 8
    //   331: astore 4
    //   333: goto -151 -> 182
    //   336: astore_0
    //   337: goto -155 -> 182
    //   340: astore_3
    //   341: aconst_null
    //   342: astore_0
    //   343: goto -209 -> 134
    //   346: astore 5
    //   348: aconst_null
    //   349: astore_0
    //   350: aload_3
    //   351: astore 4
    //   353: aload 5
    //   355: astore_3
    //   356: goto -222 -> 134
    //   359: astore_0
    //   360: aload_3
    //   361: astore 5
    //   363: aload_0
    //   364: astore_3
    //   365: aload 4
    //   367: astore_0
    //   368: aload 5
    //   370: astore 4
    //   372: goto -238 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	paramGrayTipsConfig	GrayTipsConfig
    //   1	93	1	bool	boolean
    //   56	207	2	localFileOutputStream	java.io.FileOutputStream
    //   268	2	2	localIOException	java.io.IOException
    //   296	1	2	localObject1	Object
    //   65	44	3	localBufferedOutputStream	java.io.BufferedOutputStream
    //   129	6	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   175	146	3	localObject2	Object
    //   340	11	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   355	10	3	localObject3	Object
    //   12	359	4	localObject4	Object
    //   6	289	5	localObject5	Object
    //   304	9	5	localObject6	Object
    //   346	8	5	localFileNotFoundException3	java.io.FileNotFoundException
    //   361	8	5	localObject7	Object
    //   67	225	6	localObject8	Object
    //   9	279	7	localObject9	Object
    //   3	327	8	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   99	104	122	java/io/IOException
    //   108	112	122	java/io/IOException
    //   116	120	122	java/io/IOException
    //   20	57	129	java/io/FileNotFoundException
    //   142	146	166	java/io/IOException
    //   151	156	166	java/io/IOException
    //   160	164	166	java/io/IOException
    //   20	57	173	java/io/IOException
    //   201	206	224	java/io/IOException
    //   210	214	224	java/io/IOException
    //   218	222	224	java/io/IOException
    //   20	57	231	finally
    //   245	250	268	java/io/IOException
    //   254	258	268	java/io/IOException
    //   262	266	268	java/io/IOException
    //   57	66	276	finally
    //   72	82	286	finally
    //   192	196	286	finally
    //   82	92	300	finally
    //   134	138	304	finally
    //   57	66	318	java/io/IOException
    //   72	82	328	java/io/IOException
    //   82	92	336	java/io/IOException
    //   57	66	340	java/io/FileNotFoundException
    //   72	82	346	java/io/FileNotFoundException
    //   82	92	359	java/io/FileNotFoundException
  }
  
  private void aCH()
  {
    Object localObject1;
    Object localObject3;
    int j;
    int i;
    try
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("nearby_aio_operation_gray_tips", 4, "loadLocalData");
      }
      Fv(true);
      localObject1 = this.app.getPreferences();
      this.cxf = ((SharedPreferences)localObject1).getInt("nearby_max_count_in_one_day", 0);
      this.Qz = ((SharedPreferences)localObject1).getLong("nearby_mark_day_time", 0L);
      if (QLog.isDevelopLevel()) {
        QLog.i("nearby_aio_operation_gray_tips", 4, "loadLocalData, [" + this.cxf + "," + this.Qz + "]");
      }
      localObject1 = rE();
      localObject3 = new File((String)localObject1);
      if (!((File)localObject3).isDirectory()) {
        break label240;
      }
      localObject3 = ((File)localObject3).listFiles();
      if ((localObject3 == null) || (localObject3.length <= 0)) {
        break label236;
      }
      j = localObject3.length;
      i = 0;
    }
    finally {}
    Object localObject4 = ((File)localObject4).getName();
    if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (((String)localObject4).endsWith(".conf")))
    {
      localObject4 = q((String)localObject1 + (String)localObject4);
      if ((localObject4 instanceof GrayTipsConfig)) {
        a((GrayTipsConfig)localObject4);
      }
    }
    label264:
    for (;;)
    {
      label236:
      cKP();
      label240:
      return;
      for (;;)
      {
        if (i >= j) {
          break label264;
        }
        localObject4 = localObject3[i];
        if (localObject4 != null) {
          break;
        }
        i += 1;
      }
    }
  }
  
  private static void b(GrayTipsConfig paramGrayTipsConfig, JSONObject paramJSONObject)
    throws JSONException
  {
    int j = 0;
    Object localObject1;
    Object localObject2;
    int i;
    Object localObject3;
    if (!paramJSONObject.isNull("FavoriteContent1"))
    {
      localObject1 = paramJSONObject.getJSONArray("FavoriteContent1");
      localObject2 = new ArrayList();
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localObject3 = ((JSONArray)localObject1).getJSONObject(i);
        if (!((JSONObject)localObject3).isNull("Title"))
        {
          Wording localWording = new Wording();
          localWording.text = ((JSONObject)localObject3).getString("Title");
          if (!((JSONObject)localObject3).isNull("HighlightTitle")) {
            localWording.highlightText = ((JSONObject)localObject3).getString("HighlightTitle");
          }
          ((ArrayList)localObject2).add(localWording);
        }
        i += 1;
      }
      paramGrayTipsConfig.favoriteGrayTipWordings1 = ((ArrayList)localObject2);
    }
    if (!paramJSONObject.isNull("FavoriteContent2"))
    {
      paramJSONObject = paramJSONObject.getJSONArray("FavoriteContent2");
      localObject1 = new ArrayList();
      i = j;
      while (i < paramJSONObject.length())
      {
        localObject2 = paramJSONObject.getJSONObject(i);
        if (!((JSONObject)localObject2).isNull("Title"))
        {
          localObject3 = new Wording();
          ((Wording)localObject3).text = ((JSONObject)localObject2).getString("Title");
          if (!((JSONObject)localObject2).isNull("HighlightTitle")) {
            ((Wording)localObject3).highlightText = ((JSONObject)localObject2).getString("HighlightTitle");
          }
          ((ArrayList)localObject1).add(localObject3);
        }
        i += 1;
      }
      paramGrayTipsConfig.favoriteGrayTipWordings2 = ((ArrayList)localObject1);
    }
  }
  
  private static void c(GrayTipsConfig paramGrayTipsConfig, JSONObject paramJSONObject)
    throws JSONException
  {
    if (!paramJSONObject.isNull("Content"))
    {
      paramJSONObject = paramJSONObject.getJSONArray("Content");
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        if (!localJSONObject.isNull("Title"))
        {
          Wording localWording = new Wording();
          localWording.text = localJSONObject.getString("Title");
          if (!localJSONObject.isNull("HighlightTitle")) {
            localWording.highlightText = localJSONObject.getString("HighlightTitle");
          }
          localArrayList.add(localWording);
        }
        i += 1;
      }
      paramGrayTipsConfig.grayTipWordings = localArrayList;
    }
  }
  
  private static void d(GrayTipsConfig paramGrayTipsConfig, JSONObject paramJSONObject)
    throws JSONException
  {
    if (!paramJSONObject.isNull("Link")) {
      paramGrayTipsConfig.url = paramJSONObject.getString("Link");
    }
  }
  
  private static void e(GrayTipsConfig paramGrayTipsConfig, JSONObject paramJSONObject)
    throws JSONException
  {
    if (!paramJSONObject.isNull("ShowKeyboardSupport")) {
      paramGrayTipsConfig.showKeyboard = paramJSONObject.getBoolean("ShowKeyboardSupport");
    }
  }
  
  private static void f(GrayTipsConfig paramGrayTipsConfig, JSONObject paramJSONObject)
    throws JSONException
  {
    if (!paramJSONObject.isNull("TimeDailyControl")) {
      paramGrayTipsConfig.timeRangeControl = paramJSONObject.getBoolean("TimeDailyControl");
    }
    if (!paramJSONObject.isNull("TimeRangeDaily"))
    {
      paramJSONObject = paramJSONObject.getJSONArray("TimeRangeDaily");
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        if ((!localJSONObject.isNull("BeginTime")) && (!localJSONObject.isNull("EndTime")))
        {
          TimeRangeInOneDay localTimeRangeInOneDay = new TimeRangeInOneDay();
          localTimeRangeInOneDay.beginTime = localJSONObject.getInt("BeginTime");
          localTimeRangeInOneDay.endTime = localJSONObject.getInt("EndTime");
          localArrayList.add(localTimeRangeInOneDay);
        }
        i += 1;
      }
      paramGrayTipsConfig.timeRange = localArrayList;
    }
  }
  
  private static void g(GrayTipsConfig paramGrayTipsConfig, JSONObject paramJSONObject)
    throws JSONException
  {
    if (!paramJSONObject.isNull("SexType"))
    {
      paramJSONObject = paramJSONObject.getJSONArray("SexType");
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramJSONObject.length())
      {
        localArrayList.add(Integer.valueOf(paramJSONObject.getInt(i)));
        i += 1;
      }
      paramGrayTipsConfig.sexTypes = localArrayList;
    }
  }
  
  public static boolean g(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    if (localCalendar1.get(6) != localCalendar2.get(6)) {}
    while (localCalendar1.get(1) != localCalendar2.get(1)) {
      return false;
    }
    return true;
  }
  
  private static void h(GrayTipsConfig paramGrayTipsConfig, JSONObject paramJSONObject)
    throws JSONException
  {
    if (!paramJSONObject.isNull("AIOType"))
    {
      paramJSONObject = paramJSONObject.getJSONArray("AIOType");
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramJSONObject.length())
      {
        localArrayList.add(Integer.valueOf(paramJSONObject.getInt(i)));
        i += 1;
      }
      paramGrayTipsConfig.aioTypes = localArrayList;
    }
  }
  
  /* Error */
  public static void h(Object paramObject, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 11
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 5
    //   12: aconst_null
    //   13: astore 9
    //   15: aload_0
    //   16: ifnonnull +19 -> 35
    //   19: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +12 -> 34
    //   25: ldc 240
    //   27: iconst_2
    //   28: ldc_w 645
    //   31: invokestatic 501	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: return
    //   35: iconst_0
    //   36: istore_3
    //   37: new 468	java/io/FileOutputStream
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 475	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   45: astore_1
    //   46: new 477	java/io/BufferedOutputStream
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 480	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   54: astore 4
    //   56: aload 4
    //   58: astore 6
    //   60: aload 5
    //   62: astore 7
    //   64: aload_1
    //   65: astore 5
    //   67: new 482	java/io/ObjectOutputStream
    //   70: dup
    //   71: aload 4
    //   73: invokespecial 483	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   76: astore 8
    //   78: aload 8
    //   80: aload_0
    //   81: invokevirtual 487	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   84: aload 4
    //   86: invokevirtual 490	java/io/BufferedOutputStream:flush	()V
    //   89: iconst_1
    //   90: istore_3
    //   91: aload 4
    //   93: ifnull +8 -> 101
    //   96: aload 4
    //   98: invokevirtual 492	java/io/BufferedOutputStream:close	()V
    //   101: aload 8
    //   103: ifnull +8 -> 111
    //   106: aload 8
    //   108: invokevirtual 491	java/io/ObjectOutputStream:close	()V
    //   111: iload_3
    //   112: istore_2
    //   113: aload_1
    //   114: ifnull +9 -> 123
    //   117: aload_1
    //   118: invokevirtual 493	java/io/FileOutputStream:close	()V
    //   121: iload_3
    //   122: istore_2
    //   123: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq -92 -> 34
    //   129: ldc 240
    //   131: iconst_2
    //   132: new 112	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   139: ldc_w 647
    //   142: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: iload_2
    //   146: invokevirtual 650	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   149: ldc_w 530
    //   152: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_0
    //   156: invokevirtual 651	java/lang/Object:toString	()Ljava/lang/String;
    //   159: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 501	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   168: return
    //   169: astore 4
    //   171: aload 4
    //   173: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   176: goto -75 -> 101
    //   179: astore 4
    //   181: aload 4
    //   183: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   186: goto -75 -> 111
    //   189: astore_1
    //   190: aload_1
    //   191: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   194: iload_3
    //   195: istore_2
    //   196: goto -73 -> 123
    //   199: astore 5
    //   201: aconst_null
    //   202: astore 4
    //   204: aconst_null
    //   205: astore_1
    //   206: aload 9
    //   208: astore 7
    //   210: aload 5
    //   212: invokevirtual 245	java/io/FileNotFoundException:printStackTrace	()V
    //   215: aload 4
    //   217: ifnull +8 -> 225
    //   220: aload 4
    //   222: invokevirtual 492	java/io/BufferedOutputStream:close	()V
    //   225: aload 7
    //   227: ifnull +8 -> 235
    //   230: aload 7
    //   232: invokevirtual 491	java/io/ObjectOutputStream:close	()V
    //   235: iload_3
    //   236: istore_2
    //   237: aload_1
    //   238: ifnull -115 -> 123
    //   241: aload_1
    //   242: invokevirtual 493	java/io/FileOutputStream:close	()V
    //   245: iload_3
    //   246: istore_2
    //   247: goto -124 -> 123
    //   250: astore_1
    //   251: aload_1
    //   252: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   255: iload_3
    //   256: istore_2
    //   257: goto -134 -> 123
    //   260: astore 4
    //   262: aload 4
    //   264: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   267: goto -42 -> 225
    //   270: astore 4
    //   272: aload 4
    //   274: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   277: goto -42 -> 235
    //   280: astore 8
    //   282: aconst_null
    //   283: astore 4
    //   285: aconst_null
    //   286: astore_1
    //   287: aload 10
    //   289: astore 9
    //   291: aload 4
    //   293: astore 6
    //   295: aload 9
    //   297: astore 7
    //   299: aload_1
    //   300: astore 5
    //   302: aload 8
    //   304: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   307: aload 4
    //   309: ifnull +8 -> 317
    //   312: aload 4
    //   314: invokevirtual 492	java/io/BufferedOutputStream:close	()V
    //   317: aload 9
    //   319: ifnull +8 -> 327
    //   322: aload 9
    //   324: invokevirtual 491	java/io/ObjectOutputStream:close	()V
    //   327: iload_3
    //   328: istore_2
    //   329: aload_1
    //   330: ifnull -207 -> 123
    //   333: aload_1
    //   334: invokevirtual 493	java/io/FileOutputStream:close	()V
    //   337: iload_3
    //   338: istore_2
    //   339: goto -216 -> 123
    //   342: astore_1
    //   343: aload_1
    //   344: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   347: iload_3
    //   348: istore_2
    //   349: goto -226 -> 123
    //   352: astore 4
    //   354: aload 4
    //   356: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   359: goto -42 -> 317
    //   362: astore 4
    //   364: aload 4
    //   366: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   369: goto -42 -> 327
    //   372: astore 8
    //   374: aconst_null
    //   375: astore 4
    //   377: aconst_null
    //   378: astore_1
    //   379: aload 11
    //   381: astore 9
    //   383: aload 4
    //   385: astore 6
    //   387: aload 9
    //   389: astore 7
    //   391: aload_1
    //   392: astore 5
    //   394: aload 8
    //   396: invokevirtual 652	java/lang/Exception:printStackTrace	()V
    //   399: aload 4
    //   401: ifnull +8 -> 409
    //   404: aload 4
    //   406: invokevirtual 492	java/io/BufferedOutputStream:close	()V
    //   409: aload 9
    //   411: ifnull +8 -> 419
    //   414: aload 9
    //   416: invokevirtual 491	java/io/ObjectOutputStream:close	()V
    //   419: iload_3
    //   420: istore_2
    //   421: aload_1
    //   422: ifnull -299 -> 123
    //   425: aload_1
    //   426: invokevirtual 493	java/io/FileOutputStream:close	()V
    //   429: iload_3
    //   430: istore_2
    //   431: goto -308 -> 123
    //   434: astore_1
    //   435: aload_1
    //   436: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   439: iload_3
    //   440: istore_2
    //   441: goto -318 -> 123
    //   444: astore 4
    //   446: aload 4
    //   448: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   451: goto -42 -> 409
    //   454: astore 4
    //   456: aload 4
    //   458: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   461: goto -42 -> 419
    //   464: astore_0
    //   465: aconst_null
    //   466: astore 4
    //   468: aconst_null
    //   469: astore_1
    //   470: aload 4
    //   472: ifnull +8 -> 480
    //   475: aload 4
    //   477: invokevirtual 492	java/io/BufferedOutputStream:close	()V
    //   480: aload 7
    //   482: ifnull +8 -> 490
    //   485: aload 7
    //   487: invokevirtual 491	java/io/ObjectOutputStream:close	()V
    //   490: aload_1
    //   491: ifnull +7 -> 498
    //   494: aload_1
    //   495: invokevirtual 493	java/io/FileOutputStream:close	()V
    //   498: aload_0
    //   499: athrow
    //   500: astore 4
    //   502: aload 4
    //   504: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   507: goto -27 -> 480
    //   510: astore 4
    //   512: aload 4
    //   514: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   517: goto -27 -> 490
    //   520: astore_1
    //   521: aload_1
    //   522: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   525: goto -27 -> 498
    //   528: astore_0
    //   529: aconst_null
    //   530: astore 4
    //   532: goto -62 -> 470
    //   535: astore_0
    //   536: aload 6
    //   538: astore 4
    //   540: aload 5
    //   542: astore_1
    //   543: goto -73 -> 470
    //   546: astore_0
    //   547: aload 8
    //   549: astore 7
    //   551: goto -81 -> 470
    //   554: astore_0
    //   555: goto -85 -> 470
    //   558: astore 8
    //   560: aconst_null
    //   561: astore 4
    //   563: aload 11
    //   565: astore 9
    //   567: goto -184 -> 383
    //   570: astore 8
    //   572: aload 11
    //   574: astore 9
    //   576: goto -193 -> 383
    //   579: astore 5
    //   581: aload 8
    //   583: astore 9
    //   585: aload 5
    //   587: astore 8
    //   589: goto -206 -> 383
    //   592: astore 8
    //   594: aconst_null
    //   595: astore 4
    //   597: aload 10
    //   599: astore 9
    //   601: goto -310 -> 291
    //   604: astore 8
    //   606: aload 10
    //   608: astore 9
    //   610: goto -319 -> 291
    //   613: astore 5
    //   615: aload 8
    //   617: astore 9
    //   619: aload 5
    //   621: astore 8
    //   623: goto -332 -> 291
    //   626: astore 5
    //   628: aconst_null
    //   629: astore 4
    //   631: aload 9
    //   633: astore 7
    //   635: goto -425 -> 210
    //   638: astore 5
    //   640: aload 9
    //   642: astore 7
    //   644: goto -434 -> 210
    //   647: astore 5
    //   649: aload 8
    //   651: astore 7
    //   653: goto -443 -> 210
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	656	0	paramObject	Object
    //   0	656	1	paramString	String
    //   112	329	2	bool1	boolean
    //   36	404	3	bool2	boolean
    //   54	43	4	localBufferedOutputStream	java.io.BufferedOutputStream
    //   169	3	4	localIOException1	java.io.IOException
    //   179	3	4	localIOException2	java.io.IOException
    //   202	19	4	localObject1	Object
    //   260	3	4	localIOException3	java.io.IOException
    //   270	3	4	localIOException4	java.io.IOException
    //   283	30	4	localObject2	Object
    //   352	3	4	localIOException5	java.io.IOException
    //   362	3	4	localIOException6	java.io.IOException
    //   375	30	4	localObject3	Object
    //   444	3	4	localIOException7	java.io.IOException
    //   454	3	4	localIOException8	java.io.IOException
    //   466	10	4	localObject4	Object
    //   500	3	4	localIOException9	java.io.IOException
    //   510	3	4	localIOException10	java.io.IOException
    //   530	100	4	localObject5	Object
    //   10	56	5	str1	String
    //   199	12	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   300	241	5	str2	String
    //   579	7	5	localException1	java.lang.Exception
    //   613	7	5	localIOException11	java.io.IOException
    //   626	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   638	1	5	localFileNotFoundException3	java.io.FileNotFoundException
    //   647	1	5	localFileNotFoundException4	java.io.FileNotFoundException
    //   58	479	6	localObject6	Object
    //   7	645	7	localObject7	Object
    //   76	31	8	localObjectOutputStream	java.io.ObjectOutputStream
    //   280	23	8	localIOException12	java.io.IOException
    //   372	176	8	localException2	java.lang.Exception
    //   558	1	8	localException3	java.lang.Exception
    //   570	12	8	localException4	java.lang.Exception
    //   587	1	8	localException5	java.lang.Exception
    //   592	1	8	localIOException13	java.io.IOException
    //   604	12	8	localIOException14	java.io.IOException
    //   621	29	8	localIOException15	java.io.IOException
    //   13	628	9	localObject8	Object
    //   1	606	10	localObject9	Object
    //   4	569	11	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   96	101	169	java/io/IOException
    //   106	111	179	java/io/IOException
    //   117	121	189	java/io/IOException
    //   37	46	199	java/io/FileNotFoundException
    //   241	245	250	java/io/IOException
    //   220	225	260	java/io/IOException
    //   230	235	270	java/io/IOException
    //   37	46	280	java/io/IOException
    //   333	337	342	java/io/IOException
    //   312	317	352	java/io/IOException
    //   322	327	362	java/io/IOException
    //   37	46	372	java/lang/Exception
    //   425	429	434	java/io/IOException
    //   404	409	444	java/io/IOException
    //   414	419	454	java/io/IOException
    //   37	46	464	finally
    //   475	480	500	java/io/IOException
    //   485	490	510	java/io/IOException
    //   494	498	520	java/io/IOException
    //   46	56	528	finally
    //   67	78	535	finally
    //   302	307	535	finally
    //   394	399	535	finally
    //   78	89	546	finally
    //   210	215	554	finally
    //   46	56	558	java/lang/Exception
    //   67	78	570	java/lang/Exception
    //   78	89	579	java/lang/Exception
    //   46	56	592	java/io/IOException
    //   67	78	604	java/io/IOException
    //   78	89	613	java/io/IOException
    //   46	56	626	java/io/FileNotFoundException
    //   67	78	638	java/io/FileNotFoundException
    //   78	89	647	java/io/FileNotFoundException
  }
  
  private static void i(GrayTipsConfig paramGrayTipsConfig, JSONObject paramJSONObject)
    throws JSONException
  {
    if (!paramJSONObject.isNull("Frequency"))
    {
      paramJSONObject = paramJSONObject.getJSONObject("Frequency");
      if (!paramJSONObject.isNull("SingleTaskTipsCountPerDay")) {
        paramGrayTipsConfig.singleTask_MaxTipsCountPerDay = paramJSONObject.getInt("SingleTaskTipsCountPerDay");
      }
      if (!paramJSONObject.isNull("SingleTaskTotalTipsCount")) {
        paramGrayTipsConfig.singleTask_maxTipsCount = paramJSONObject.getInt("SingleTaskTotalTipsCount");
      }
    }
  }
  
  private static void j(GrayTipsConfig paramGrayTipsConfig, JSONObject paramJSONObject)
    throws JSONException
  {
    if (!paramJSONObject.isNull("Priority")) {
      paramGrayTipsConfig.priority = paramJSONObject.getInt("Priority");
    }
  }
  
  private static void k(GrayTipsConfig paramGrayTipsConfig, JSONObject paramJSONObject)
    throws JSONException
  {
    if (!paramJSONObject.isNull("ID")) {
      paramGrayTipsConfig.id = paramJSONObject.getInt("ID");
    }
  }
  
  private static void l(GrayTipsConfig paramGrayTipsConfig, JSONObject paramJSONObject)
    throws JSONException
  {
    if (!paramJSONObject.isNull("CreationDate")) {
      paramGrayTipsConfig.createTime = (paramJSONObject.getLong("CreationDate") * 1000L);
    }
    if (!paramJSONObject.isNull("TipEnable")) {
      paramGrayTipsConfig.grayTipsEnable = paramJSONObject.getBoolean("TipEnable");
    }
    if (!paramJSONObject.isNull("GlobalTipsCountPerDay")) {
      paramGrayTipsConfig.global_MaxTipsCountPerDay = paramJSONObject.getInt("GlobalTipsCountPerDay");
    }
    if (!paramJSONObject.isNull("Frequency"))
    {
      paramJSONObject = paramJSONObject.getJSONObject("Frequency");
      if (!paramJSONObject.isNull("TipsCount")) {
        paramGrayTipsConfig.maxTipsCount = paramJSONObject.getInt("TipsCount");
      }
      if (!paramJSONObject.isNull("MessageCount")) {
        paramGrayTipsConfig.messageCount = paramJSONObject.getInt("MessageCount");
      }
    }
  }
  
  /* Error */
  public static Object q(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: new 695	java/io/FileInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 696	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   11: astore_0
    //   12: new 698	java/io/BufferedInputStream
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 701	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   20: astore_1
    //   21: new 703	java/io/ObjectInputStream
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 704	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   29: astore 5
    //   31: aload 5
    //   33: astore 4
    //   35: aload_1
    //   36: astore_3
    //   37: aload_0
    //   38: astore_2
    //   39: aload 5
    //   41: invokevirtual 707	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   44: astore 6
    //   46: aload 6
    //   48: astore_2
    //   49: aload 5
    //   51: ifnull +8 -> 59
    //   54: aload 5
    //   56: invokevirtual 708	java/io/ObjectInputStream:close	()V
    //   59: aload_1
    //   60: ifnull +7 -> 67
    //   63: aload_1
    //   64: invokevirtual 709	java/io/BufferedInputStream:close	()V
    //   67: aload_2
    //   68: astore_1
    //   69: aload_0
    //   70: ifnull +9 -> 79
    //   73: aload_0
    //   74: invokevirtual 710	java/io/FileInputStream:close	()V
    //   77: aload_2
    //   78: astore_1
    //   79: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +39 -> 121
    //   85: new 112	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   92: ldc_w 712
    //   95: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: astore_2
    //   99: aload_1
    //   100: ifnonnull +283 -> 383
    //   103: ldc_w 714
    //   106: astore_0
    //   107: ldc 240
    //   109: iconst_2
    //   110: aload_2
    //   111: aload_0
    //   112: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 501	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload_1
    //   122: areturn
    //   123: astore_0
    //   124: aload_0
    //   125: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   128: aload_2
    //   129: astore_1
    //   130: goto -51 -> 79
    //   133: astore 6
    //   135: aconst_null
    //   136: astore 5
    //   138: aconst_null
    //   139: astore_1
    //   140: aconst_null
    //   141: astore_0
    //   142: aload 5
    //   144: astore 4
    //   146: aload_1
    //   147: astore_3
    //   148: aload_0
    //   149: astore_2
    //   150: aload 6
    //   152: invokevirtual 245	java/io/FileNotFoundException:printStackTrace	()V
    //   155: aload 5
    //   157: ifnull +8 -> 165
    //   160: aload 5
    //   162: invokevirtual 708	java/io/ObjectInputStream:close	()V
    //   165: aload_1
    //   166: ifnull +7 -> 173
    //   169: aload_1
    //   170: invokevirtual 709	java/io/BufferedInputStream:close	()V
    //   173: aload 7
    //   175: astore_1
    //   176: aload_0
    //   177: ifnull -98 -> 79
    //   180: aload_0
    //   181: invokevirtual 710	java/io/FileInputStream:close	()V
    //   184: aload 7
    //   186: astore_1
    //   187: goto -108 -> 79
    //   190: astore_0
    //   191: aload_0
    //   192: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   195: aload 7
    //   197: astore_1
    //   198: goto -119 -> 79
    //   201: astore 6
    //   203: aconst_null
    //   204: astore 5
    //   206: aconst_null
    //   207: astore_1
    //   208: aconst_null
    //   209: astore_0
    //   210: aload 5
    //   212: astore 4
    //   214: aload_1
    //   215: astore_3
    //   216: aload_0
    //   217: astore_2
    //   218: aload 6
    //   220: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   223: aload 5
    //   225: ifnull +8 -> 233
    //   228: aload 5
    //   230: invokevirtual 708	java/io/ObjectInputStream:close	()V
    //   233: aload_1
    //   234: ifnull +7 -> 241
    //   237: aload_1
    //   238: invokevirtual 709	java/io/BufferedInputStream:close	()V
    //   241: aload 7
    //   243: astore_1
    //   244: aload_0
    //   245: ifnull -166 -> 79
    //   248: aload_0
    //   249: invokevirtual 710	java/io/FileInputStream:close	()V
    //   252: aload 7
    //   254: astore_1
    //   255: goto -176 -> 79
    //   258: astore_0
    //   259: aload_0
    //   260: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   263: aload 7
    //   265: astore_1
    //   266: goto -187 -> 79
    //   269: astore 6
    //   271: aconst_null
    //   272: astore 5
    //   274: aconst_null
    //   275: astore_1
    //   276: aconst_null
    //   277: astore_0
    //   278: aload 5
    //   280: astore 4
    //   282: aload_1
    //   283: astore_3
    //   284: aload_0
    //   285: astore_2
    //   286: aload 6
    //   288: invokevirtual 652	java/lang/Exception:printStackTrace	()V
    //   291: aload 5
    //   293: ifnull +8 -> 301
    //   296: aload 5
    //   298: invokevirtual 708	java/io/ObjectInputStream:close	()V
    //   301: aload_1
    //   302: ifnull +7 -> 309
    //   305: aload_1
    //   306: invokevirtual 709	java/io/BufferedInputStream:close	()V
    //   309: aload 7
    //   311: astore_1
    //   312: aload_0
    //   313: ifnull -234 -> 79
    //   316: aload_0
    //   317: invokevirtual 710	java/io/FileInputStream:close	()V
    //   320: aload 7
    //   322: astore_1
    //   323: goto -244 -> 79
    //   326: astore_0
    //   327: aload_0
    //   328: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   331: aload 7
    //   333: astore_1
    //   334: goto -255 -> 79
    //   337: astore 5
    //   339: aconst_null
    //   340: astore 4
    //   342: aconst_null
    //   343: astore_1
    //   344: aconst_null
    //   345: astore_0
    //   346: aload 4
    //   348: ifnull +8 -> 356
    //   351: aload 4
    //   353: invokevirtual 708	java/io/ObjectInputStream:close	()V
    //   356: aload_1
    //   357: ifnull +7 -> 364
    //   360: aload_1
    //   361: invokevirtual 709	java/io/BufferedInputStream:close	()V
    //   364: aload_0
    //   365: ifnull +7 -> 372
    //   368: aload_0
    //   369: invokevirtual 710	java/io/FileInputStream:close	()V
    //   372: aload 5
    //   374: athrow
    //   375: astore_0
    //   376: aload_0
    //   377: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   380: goto -8 -> 372
    //   383: aload_1
    //   384: invokevirtual 651	java/lang/Object:toString	()Ljava/lang/String;
    //   387: astore_0
    //   388: goto -281 -> 107
    //   391: astore 5
    //   393: aconst_null
    //   394: astore 4
    //   396: aconst_null
    //   397: astore_1
    //   398: goto -52 -> 346
    //   401: astore 5
    //   403: aconst_null
    //   404: astore 4
    //   406: goto -60 -> 346
    //   409: astore 5
    //   411: aload_3
    //   412: astore_1
    //   413: aload_2
    //   414: astore_0
    //   415: goto -69 -> 346
    //   418: astore 6
    //   420: aconst_null
    //   421: astore 5
    //   423: aconst_null
    //   424: astore_1
    //   425: goto -147 -> 278
    //   428: astore 6
    //   430: aconst_null
    //   431: astore 5
    //   433: goto -155 -> 278
    //   436: astore 6
    //   438: goto -160 -> 278
    //   441: astore 6
    //   443: aconst_null
    //   444: astore 5
    //   446: aconst_null
    //   447: astore_1
    //   448: goto -238 -> 210
    //   451: astore 6
    //   453: aconst_null
    //   454: astore 5
    //   456: goto -246 -> 210
    //   459: astore 6
    //   461: goto -251 -> 210
    //   464: astore 6
    //   466: aconst_null
    //   467: astore 5
    //   469: aconst_null
    //   470: astore_1
    //   471: goto -329 -> 142
    //   474: astore 6
    //   476: aconst_null
    //   477: astore 5
    //   479: goto -337 -> 142
    //   482: astore 6
    //   484: goto -342 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	487	0	paramString	String
    //   20	451	1	localObject1	Object
    //   38	376	2	localObject2	Object
    //   36	376	3	localObject3	Object
    //   33	372	4	localObjectInputStream1	java.io.ObjectInputStream
    //   29	268	5	localObjectInputStream2	java.io.ObjectInputStream
    //   337	36	5	localObject4	Object
    //   391	1	5	localObject5	Object
    //   401	1	5	localObject6	Object
    //   409	1	5	localObject7	Object
    //   421	57	5	localObject8	Object
    //   44	3	6	localObject9	Object
    //   133	18	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   201	18	6	localIOException1	java.io.IOException
    //   269	18	6	localException1	java.lang.Exception
    //   418	1	6	localException2	java.lang.Exception
    //   428	1	6	localException3	java.lang.Exception
    //   436	1	6	localException4	java.lang.Exception
    //   441	1	6	localIOException2	java.io.IOException
    //   451	1	6	localIOException3	java.io.IOException
    //   459	1	6	localIOException4	java.io.IOException
    //   464	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   474	1	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   482	1	6	localFileNotFoundException4	java.io.FileNotFoundException
    //   1	331	7	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   54	59	123	java/io/IOException
    //   63	67	123	java/io/IOException
    //   73	77	123	java/io/IOException
    //   3	12	133	java/io/FileNotFoundException
    //   160	165	190	java/io/IOException
    //   169	173	190	java/io/IOException
    //   180	184	190	java/io/IOException
    //   3	12	201	java/io/IOException
    //   228	233	258	java/io/IOException
    //   237	241	258	java/io/IOException
    //   248	252	258	java/io/IOException
    //   3	12	269	java/lang/Exception
    //   296	301	326	java/io/IOException
    //   305	309	326	java/io/IOException
    //   316	320	326	java/io/IOException
    //   3	12	337	finally
    //   351	356	375	java/io/IOException
    //   360	364	375	java/io/IOException
    //   368	372	375	java/io/IOException
    //   12	21	391	finally
    //   21	31	401	finally
    //   39	46	409	finally
    //   150	155	409	finally
    //   218	223	409	finally
    //   286	291	409	finally
    //   12	21	418	java/lang/Exception
    //   21	31	428	java/lang/Exception
    //   39	46	436	java/lang/Exception
    //   12	21	441	java/io/IOException
    //   21	31	451	java/io/IOException
    //   39	46	459	java/io/IOException
    //   12	21	464	java/io/FileNotFoundException
    //   21	31	474	java/io/FileNotFoundException
    //   39	46	482	java/io/FileNotFoundException
  }
  
  public static String rE()
  {
    File localFile = new File(BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath() + "/nearby_gray_tips_configs");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getAbsolutePath() + "/";
  }
  
  public void Fv(boolean paramBoolean)
  {
    this.bIE = paramBoolean;
  }
  
  public GrayTipStatisticData a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    ??? = null;
    label221:
    for (;;)
    {
      int i;
      synchronized (this.xL)
      {
        int j = this.xL.size();
        i = 0;
        ??? = ???;
        if (i < j)
        {
          ??? = (GrayTipStatisticData)this.xL.get(i);
          if ((??? == null) || (((GrayTipStatisticData)???).mId != paramInt)) {}
        }
        else
        {
          if ((??? != null) || (!paramBoolean1)) {
            break label221;
          }
          ??? = q(GrayTipStatisticData.getPath(this.app.getCurrentAccountUin(), paramInt));
          if (!(??? instanceof GrayTipStatisticData)) {
            break label221;
          }
          ??? = (GrayTipStatisticData)???;
          synchronized (this.xL)
          {
            this.xL.add(???);
            ??? = ???;
            if (??? == null)
            {
              ??? = ???;
              if (paramBoolean2) {
                ??? = new GrayTipStatisticData(paramInt);
              }
            }
          }
        }
      }
      synchronized (this.xL)
      {
        this.xL.add(???);
        return ???;
        i += 1;
        continue;
        localObject2 = finally;
        throw localObject2;
        localObject3 = finally;
        throw localObject3;
      }
    }
  }
  
  public GrayTipsConfig a(int paramInt1, int paramInt2, long paramLong)
  {
    if (!this.bIE) {
      aCH();
    }
    Object localObject2;
    if (!this.bIF)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("nearby_aio_operation_gray_tips", 4, "getValidConfigForEnterAIO, not enable");
      }
      localObject2 = null;
      return localObject2;
    }
    GrayTipsConfig localGrayTipsConfig1 = null;
    label294:
    label303:
    label310:
    label317:
    for (;;)
    {
      GrayTipsConfig localGrayTipsConfig3;
      synchronized (this.tq)
      {
        if (this.tq.size() > 0)
        {
          Iterator localIterator = this.tq.iterator();
          localGrayTipsConfig1 = null;
          if (!localIterator.hasNext()) {
            break label317;
          }
          localGrayTipsConfig3 = (GrayTipsConfig)localIterator.next();
          if ((localGrayTipsConfig3 == null) || (localGrayTipsConfig3.sceneId != 4) || (localGrayTipsConfig3.sceneFour == null) || (!localGrayTipsConfig3.sceneFour.enterAIOTrigger)) {
            continue;
          }
          if (!localGrayTipsConfig3.isValid(this.app, paramInt1, paramInt2, paramLong)) {
            break label310;
          }
          if (!QLog.isDevelopLevel()) {
            break label294;
          }
          QLog.i("nearby_aio_operation_gray_tips", 4, "getValidConfigForEnterAIO, valid id = " + localGrayTipsConfig3.id);
          break label294;
          localObject2 = localGrayTipsConfig3;
          if (localGrayTipsConfig1.priority < localGrayTipsConfig3.priority) {
            break label303;
          }
          if (localGrayTipsConfig1.priority != localGrayTipsConfig3.priority) {
            break label310;
          }
          localObject2 = localGrayTipsConfig3;
          if (localGrayTipsConfig1.createTime < localGrayTipsConfig3.createTime) {
            break label303;
          }
          break label310;
        }
        localObject2 = localGrayTipsConfig1;
        if (localGrayTipsConfig1 == null) {
          break;
        }
        localObject2 = a(localGrayTipsConfig1.id, true, true);
        if ((localObject2 != null) && (((GrayTipStatisticData)localObject2).isLimit(localGrayTipsConfig1, paramLong))) {
          return null;
        }
      }
      a(localGrayTipsConfig2, false);
      return localGrayTipsConfig2;
      if (localGrayTipsConfig2 == null)
      {
        Object localObject1;
        for (localObject2 = localGrayTipsConfig3;; localObject2 = localObject1)
        {
          localObject1 = localObject2;
          break;
        }
      }
    }
  }
  
  public GrayTipsConfig a(int paramInt1, int paramInt2, String paramString, int paramInt3, long paramLong)
  {
    Object localObject = null;
    if (!this.bIE) {
      aCH();
    }
    if (!this.bIF) {
      return null;
    }
    GrayTipsConfig localGrayTipsConfig = a(paramInt1, paramInt2, paramInt3, paramLong, null);
    if (localGrayTipsConfig != null)
    {
      GrayTipStatisticData localGrayTipStatisticData = a(localGrayTipsConfig.id, true, true);
      if ((localGrayTipStatisticData == null) || (!localGrayTipStatisticData.isLimit(localGrayTipsConfig, paramLong))) {}
    }
    for (;;)
    {
      return a(paramString, (GrayTipsConfig)localObject);
      localObject = localGrayTipsConfig;
    }
  }
  
  public String a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q..troop.faceScore", 2, "getRandomFaceScoreWording id=" + paramInt1 + "  gender=" + paramInt2 + "  toLoad=" + paramBoolean);
    }
    FaceScoreWording localFaceScoreWording = a(paramInt1);
    if ((localFaceScoreWording == null) && (paramBoolean))
    {
      Object localObject = q(FaceScoreWording.getPath(paramInt1));
      if ((localObject instanceof FaceScoreWording)) {
        localFaceScoreWording = (FaceScoreWording)localObject;
      }
    }
    for (;;)
    {
      if (localFaceScoreWording == null) {
        return "";
      }
      return localFaceScoreWording.getWording(this.g, paramInt2);
    }
  }
  
  public void a(GrayTipsConfig paramGrayTipsConfig)
  {
    ArrayList localArrayList;
    int i;
    if (paramGrayTipsConfig != null)
    {
      localArrayList = this.tq;
      i = 0;
    }
    for (;;)
    {
      try
      {
        Object localObject;
        if (i < this.tq.size())
        {
          localObject = (GrayTipsConfig)this.tq.get(i);
          if (((GrayTipsConfig)localObject).id != paramGrayTipsConfig.id) {
            break label202;
          }
          if (paramGrayTipsConfig.createTime > ((GrayTipsConfig)localObject).createTime) {
            this.tq.set(i, paramGrayTipsConfig);
          }
        }
        if (i == this.tq.size()) {
          this.tq.add(paramGrayTipsConfig);
        }
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updateOrAddAConfig").append(",").append("[").append(i).append(",").append("config_id =").append(paramGrayTipsConfig.id).append(",").append("config_scene_id =").append(paramGrayTipsConfig.sceneId).append(",").append("]");
          QLog.i("nearby_aio_operation_gray_tips", 4, ((StringBuilder)localObject).toString());
        }
        return;
      }
      finally {}
      return;
      label202:
      i += 1;
    }
  }
  
  public void a(GrayTipsConfig paramGrayTipsConfig, boolean paramBoolean)
  {
    Object localObject1;
    if ((paramGrayTipsConfig != null) && (paramGrayTipsConfig.sceneId == 4))
    {
      localObject2 = a(paramGrayTipsConfig.id);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new GreetWording(paramGrayTipsConfig.id);
        localObject2 = this.xJ;
        if (!paramBoolean) {
          break label83;
        }
      }
    }
    for (;;)
    {
      label83:
      try
      {
        this.xJ.add(0, localObject1);
        ((GreetWording)localObject1).saveWording(paramGrayTipsConfig.createTime, paramGrayTipsConfig.randomWordings, paramBoolean);
        return;
      }
      finally {}
      this.xJ.add(localObject1);
    }
  }
  
  public void aa(int paramInt, long paramLong)
  {
    if (!this.bIE) {
      aCH();
    }
    GrayTipStatisticData localGrayTipStatisticData = a(paramInt, true, true);
    if (localGrayTipStatisticData != null)
    {
      localGrayTipStatisticData.increase(paramLong);
      h(localGrayTipStatisticData, GrayTipStatisticData.getPath(this.app.getCurrentAccountUin(), paramInt));
    }
    if (g(paramLong, this.Qz)) {
      this.cxf += 1;
    }
    for (;;)
    {
      this.app.getPreferences().edit().putInt("nearby_max_count_in_one_day", this.cxf).putLong("nearby_mark_day_time", this.Qz).commit();
      return;
      this.cxf = 1;
      this.Qz = paramLong;
    }
  }
  
  public boolean abc()
  {
    if (!this.bIE) {
      aCH();
    }
    return this.bIF;
  }
  
  public boolean ah(List<ChatMessage> paramList)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    int k;
    if (paramList != null)
    {
      bool1 = bool2;
      if (this.cxe > 0)
      {
        bool1 = bool2;
        if (this.bgv > 0)
        {
          i = paramList.size() - 1;
          j = 0;
          if (i < 0) {
            break label165;
          }
          if (!anbk.ls(((ChatMessage)paramList.get(i)).msgtype))
          {
            k = j + 1;
            j = k;
            if (k != this.bgv) {}
          }
        }
      }
    }
    label162:
    label165:
    for (int j = i;; j = 0)
    {
      k = paramList.size() - 1;
      i = 0;
      label98:
      if (k >= j)
      {
        if (-2027 != ((ChatMessage)paramList.get(k)).msgtype) {
          break label162;
        }
        i += 1;
      }
      for (;;)
      {
        k -= 1;
        break label98;
        i -= 1;
        break;
        bool1 = bool2;
        if (i >= this.cxe) {
          bool1 = true;
        }
        return bool1;
      }
    }
  }
  
  public GrayTipsConfig b(int paramInt1, int paramInt2, long paramLong)
  {
    GrayTipsConfig localGrayTipsConfig1 = null;
    Object localObject3 = null;
    if (QLog.isColorLevel()) {
      QLog.d("Q..troop.faceScore", 2, "getValidConfigForFaceScore aioType= " + paramInt1 + "  otherGender=" + paramInt2 + "  curTime=" + paramLong);
    }
    if (!this.bIE) {
      aCH();
    }
    if (!this.bIF) {
      return localObject3;
    }
    label280:
    label287:
    for (;;)
    {
      synchronized (this.tq)
      {
        if (this.tq.size() > 0)
        {
          Iterator localIterator = this.tq.iterator();
          localGrayTipsConfig1 = null;
          if (!localIterator.hasNext()) {
            break label287;
          }
          GrayTipsConfig localGrayTipsConfig2 = (GrayTipsConfig)localIterator.next();
          if ((localGrayTipsConfig2 == null) || (localGrayTipsConfig2.sceneId != 5) || (localGrayTipsConfig2.sceneFive == null) || (!localGrayTipsConfig2.sceneFive.faceScoreTrigger)) {
            continue;
          }
          if (!localGrayTipsConfig2.isValid(this.app, paramInt1, paramInt2, paramLong)) {
            break label280;
          }
          if (localGrayTipsConfig1 == null)
          {
            localObject3 = localGrayTipsConfig2;
          }
          else
          {
            localObject3 = localGrayTipsConfig2;
            if (localGrayTipsConfig1.priority >= localGrayTipsConfig2.priority)
            {
              if (localGrayTipsConfig1.priority != localGrayTipsConfig2.priority) {
                break label280;
              }
              localObject3 = localGrayTipsConfig2;
              if (localGrayTipsConfig1.createTime >= localGrayTipsConfig2.createTime) {
                break label280;
              }
            }
          }
        }
        else
        {
          localObject3 = localGrayTipsConfig1;
          if (localGrayTipsConfig1 == null) {
            break;
          }
          b(localGrayTipsConfig1, false);
          return localGrayTipsConfig1;
        }
      }
      for (;;)
      {
        Object localObject2 = localObject3;
        break;
        localObject3 = localObject2;
      }
    }
  }
  
  public void b(GrayTipsConfig paramGrayTipsConfig, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q..troop.faceScore", 2, "updateFaceScoreWording config= " + paramGrayTipsConfig + "  needSaveToFile=" + paramBoolean);
    }
    Object localObject1;
    if ((paramGrayTipsConfig != null) && (paramGrayTipsConfig.sceneId == 5) && (paramGrayTipsConfig.sceneFive != null))
    {
      localObject2 = a(paramGrayTipsConfig.id);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new FaceScoreWording(paramGrayTipsConfig.id);
        localObject2 = this.xK;
        if (!paramBoolean) {
          break label142;
        }
      }
    }
    for (;;)
    {
      label142:
      try
      {
        this.xK.add(0, localObject1);
        ((FaceScoreWording)localObject1).saveWording(paramGrayTipsConfig.createTime, paramGrayTipsConfig.sceneFive.randomWordingForMale, paramGrayTipsConfig.sceneFive.randomWordingForFeMale, paramBoolean);
        return;
      }
      finally {}
      this.xK.add(localObject1);
    }
  }
  
  public boolean bI(long paramLong)
  {
    if (!this.bIE) {
      aCH();
    }
    if (this.cxd == 0) {}
    do
    {
      return false;
      if (!g(paramLong, this.Qz)) {
        break;
      }
    } while (this.cxf < this.cxd);
    return true;
    this.cxf = 0;
    this.Qz = 0L;
    return false;
  }
  
  public GrayTipsConfig c(int paramInt1, int paramInt2, long paramLong)
  {
    if (!this.bIE) {
      aCH();
    }
    if (!this.bIF) {
      return null;
    }
    label260:
    label267:
    for (;;)
    {
      Object localObject3;
      synchronized (this.tq)
      {
        if (this.tq.size() > 0)
        {
          Iterator localIterator = this.tq.iterator();
          GrayTipsConfig localGrayTipsConfig = null;
          if (!localIterator.hasNext()) {
            break label267;
          }
          Object localObject4 = (GrayTipsConfig)localIterator.next();
          if ((localObject4 == null) || (((GrayTipsConfig)localObject4).sceneId != 1) || (((GrayTipsConfig)localObject4).sceneOne == null) || (!((GrayTipsConfig)localObject4).sceneOne.sayHiTrigger)) {
            continue;
          }
          if (!((GrayTipsConfig)localObject4).isValid(this.app, paramInt1, paramInt2, paramLong)) {
            break label260;
          }
          if (localGrayTipsConfig == null)
          {
            localObject3 = localObject4;
            break label253;
          }
          localObject3 = localObject4;
          if (localGrayTipsConfig.priority < ((GrayTipsConfig)localObject4).priority) {
            break label253;
          }
          if (localGrayTipsConfig.priority != ((GrayTipsConfig)localObject4).priority) {
            break label260;
          }
          localObject3 = localObject4;
          if (localGrayTipsConfig.createTime < ((GrayTipsConfig)localObject4).createTime) {
            break label253;
          }
          break label260;
          localObject3 = localGrayTipsConfig;
          if (localGrayTipsConfig != null)
          {
            localObject4 = a(localGrayTipsConfig.id, true, true);
            localObject3 = localGrayTipsConfig;
            if (localObject4 != null)
            {
              localObject3 = localGrayTipsConfig;
              if (((GrayTipStatisticData)localObject4).isLimit(localGrayTipsConfig, paramLong)) {
                localObject3 = null;
              }
            }
          }
          return localObject3;
        }
      }
      Object localObject2 = null;
      continue;
      for (;;)
      {
        label253:
        localObject2 = localObject3;
        break;
        localObject3 = localObject2;
      }
    }
  }
  
  public void cKP()
  {
    if ((this.tq != null) && (this.tq.size() > 0)) {
      for (;;)
      {
        synchronized (this.tq)
        {
          if (this.tq.size() > 0)
          {
            Object localObject1 = (GrayTipsConfig)this.tq.get(0);
            Iterator localIterator = this.tq.iterator();
            if (localIterator.hasNext())
            {
              GrayTipsConfig localGrayTipsConfig = (GrayTipsConfig)localIterator.next();
              if (localGrayTipsConfig.createTime > ((GrayTipsConfig)localObject1).createTime) {
                localObject1 = localGrayTipsConfig;
              }
            }
            else
            {
              this.bIF = ((GrayTipsConfig)localObject1).grayTipsEnable;
              this.cxd = ((GrayTipsConfig)localObject1).global_MaxTipsCountPerDay;
              this.cxe = ((GrayTipsConfig)localObject1).maxTipsCount;
              this.bgv = ((GrayTipsConfig)localObject1).messageCount;
            }
          }
          else
          {
            return;
          }
        }
      }
    }
  }
  
  public void cKQ()
  {
    ??? = new File(rE());
    if ((??? != null) && (((File)???).exists()) && (((File)???).isDirectory()))
    {
      ??? = ((File)???).listFiles();
      if ((??? != null) && (???.length > 0))
      {
        int j = ???.length;
        int i = 0;
        while (i < j)
        {
          ???[i].delete();
          i += 1;
        }
      }
    }
    if ((this.tq != null) && (this.tq.size() > 0)) {}
    synchronized (this.tq)
    {
      this.tq.clear();
      this.bIF = false;
      return;
    }
  }
  
  public GrayTipsConfig d(int paramInt1, int paramInt2, long paramLong)
  {
    if (!this.bIE) {
      aCH();
    }
    if (!this.bIF) {}
    label258:
    for (;;)
    {
      return null;
      Object localObject2 = a(paramInt1, paramInt2, paramLong, null);
      Object localObject1 = localObject2;
      Object localObject3;
      if (localObject2 != null)
      {
        localObject3 = a(((GrayTipsConfig)localObject2).id, true, true);
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject1 = localObject2;
          if (((GrayTipStatisticData)localObject3).isLimit((GrayTipsConfig)localObject2, paramLong)) {
            localObject1 = null;
          }
        }
      }
      if ((localObject1 != null) && (localObject1.aioTypes != null) && (localObject1.aioTypes.size() > 0))
      {
        localObject3 = new ArrayList();
        a(localObject1, (List)localObject3);
        a(paramLong, localObject1, (List)localObject3);
        Collections.sort((List)localObject3, new acif(this));
        localObject2 = (QQMessageFacade)this.app.getManager(20);
        paramInt1 = 0;
        localObject3 = ((List)localObject3).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label255;
        }
        Object localObject4 = (MessageRecord)((Iterator)localObject3).next();
        localObject4 = ((QQMessageFacade)localObject2).a(((MessageRecord)localObject4).senderuin, ((MessageRecord)localObject4).istroop);
        if ((localObject4 == null) || (((QQMessageFacade.Message)localObject4).hasReply)) {
          break label252;
        }
        paramInt2 = paramInt1 + 1;
        paramInt1 = paramInt2;
        if (paramInt2 < localObject1.sceneTwo.sayHiPeopleCount) {
          break label252;
        }
      }
      for (;;)
      {
        if (paramInt2 < localObject1.sceneTwo.sayHiPeopleCount) {
          break label258;
        }
        return localObject1;
        label252:
        break;
        label255:
        paramInt2 = paramInt1;
      }
    }
  }
  
  public String j(int paramInt, boolean paramBoolean)
  {
    GreetWording localGreetWording = a(paramInt);
    if ((localGreetWording == null) && (paramBoolean))
    {
      Object localObject = q(GreetWording.getPath(paramInt));
      if ((localObject instanceof GreetWording)) {
        localGreetWording = (GreetWording)localObject;
      }
    }
    for (;;)
    {
      if (localGreetWording == null) {
        return "";
      }
      return localGreetWording.getWording(this.g);
    }
  }
  
  public void onDestroy() {}
  
  public static class FaceScoreWording
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public long createTime;
    public List<String> femaleWordingList;
    public int id;
    public int lastIndex;
    public Object lock = new Object();
    public List<String> maleWordingList;
    
    public FaceScoreWording(int paramInt)
    {
      this.id = paramInt;
      this.maleWordingList = new ArrayList(5);
      this.femaleWordingList = new ArrayList(5);
    }
    
    public FaceScoreWording(int paramInt1, long paramLong, List<String> paramList1, List<String> paramList2, int paramInt2)
    {
      this.id = paramInt1;
      this.createTime = paramLong;
      this.maleWordingList = paramList1;
      this.femaleWordingList = paramList2;
      this.lastIndex = paramInt2;
    }
    
    public static String getPath(int paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(NearbyGrayTipsManager.rE()).append(FaceScoreWording.class.getSimpleName()).append("_").append(paramInt);
      return localStringBuilder.toString();
    }
    
    public String getWording(Random paramRandom, int paramInt)
    {
      String str = "";
      localObject = this.lock;
      if (paramInt == 1) {}
      for (;;)
      {
        try
        {
          localList = this.femaleWordingList;
          int j = localList.size();
          if (j > 0)
          {
            int i = paramRandom.nextInt(j);
            paramInt = i;
            if (i == this.lastIndex) {
              paramInt = (this.lastIndex + 1) % j;
            }
            this.lastIndex = paramInt;
            str = (String)localList.get(paramInt);
          }
          return str;
        }
        finally {}
        List localList = this.maleWordingList;
      }
    }
    
    public void saveWording(long paramLong, List<String> paramList1, List<String> paramList2, boolean paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q..troop.faceScore", 2, "saveWording time= " + paramLong + "  maleWordingList=" + paramList1 + "  femaleWordingList=" + paramList2 + "  needSaveToFile=" + paramBoolean);
      }
      if ((paramList1 == null) || (paramList1.size() == 0) || (paramList2 == null) || (paramList2.size() == 0)) {}
      for (;;)
      {
        return;
        FaceScoreWording localFaceScoreWording = null;
        synchronized (this.lock)
        {
          if ((this.maleWordingList.size() == 0) || (this.createTime < paramLong))
          {
            this.createTime = paramLong;
            this.maleWordingList.clear();
            this.maleWordingList.addAll(paramList1);
          }
          if ((this.femaleWordingList.size() == 0) || (this.createTime < paramLong))
          {
            this.createTime = paramLong;
            this.femaleWordingList.clear();
            this.femaleWordingList.addAll(paramList2);
          }
          if (paramBoolean)
          {
            localFaceScoreWording = new FaceScoreWording(this.id);
            localFaceScoreWording.createTime = this.createTime;
            localFaceScoreWording.lastIndex = this.lastIndex;
            localFaceScoreWording.maleWordingList.addAll(paramList1);
            localFaceScoreWording.femaleWordingList.addAll(paramList2);
          }
          if ((!paramBoolean) || (localFaceScoreWording == null)) {
            continue;
          }
          ThreadManager.getFileThreadHandler().post(new NearbyGrayTipsManager.FaceScoreWording.1(this, localFaceScoreWording));
          return;
        }
      }
    }
  }
  
  public static class GrayTipStatisticData
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public int mId;
    public long mLastMarkDay;
    public int mOneDayCount;
    public int mTotalCount;
    
    public GrayTipStatisticData() {}
    
    public GrayTipStatisticData(int paramInt)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("nearby_aio_operation_gray_tips", 4, "GreetTipStaticData, " + paramInt);
      }
      this.mId = paramInt;
      this.mTotalCount = 0;
      this.mOneDayCount = 0;
      this.mLastMarkDay = 0L;
    }
    
    public static String getPath(String paramString, int paramInt)
    {
      paramString = MD5.toMD5(paramString + "_" + paramInt);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(NearbyGrayTipsManager.rE()).append(GrayTipStatisticData.class.getSimpleName()).append("_").append(paramString);
      return localStringBuilder.toString();
    }
    
    public void increase(long paramLong)
    {
      this.mTotalCount += 1;
      if (NearbyGrayTipsManager.g(paramLong, this.mLastMarkDay)) {}
      for (this.mOneDayCount += 1;; this.mOneDayCount = 1)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("nearby_aio_operation_gray_tips", 4, "increase, " + toString());
        }
        return;
        this.mLastMarkDay = paramLong;
      }
    }
    
    public boolean isLimit(NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig, long paramLong)
    {
      boolean bool2 = true;
      boolean bool1;
      if (paramGrayTipsConfig.singleTask_maxTipsCount > 0) {
        if (this.mTotalCount >= paramGrayTipsConfig.singleTask_maxTipsCount) {
          bool1 = true;
        }
      }
      for (;;)
      {
        if ((!bool1) && (paramGrayTipsConfig.singleTask_MaxTipsCountPerDay > 0) && (NearbyGrayTipsManager.g(paramLong, this.mLastMarkDay))) {
          if (this.mOneDayCount >= paramGrayTipsConfig.singleTask_MaxTipsCountPerDay) {
            bool1 = bool2;
          }
        }
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("nearby_aio_operation_gray_tips", 4, "isLimit = " + bool1 + "," + paramGrayTipsConfig.toString() + "," + toString());
          }
          return bool1;
          bool1 = false;
          break;
          bool1 = false;
        }
        bool1 = false;
      }
    }
    
    public String toString()
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append('[').append(this.mId).append(',').append(this.mTotalCount).append(',').append(this.mOneDayCount).append(',').append(this.mLastMarkDay).append(',').append(']');
      return localStringBuffer.toString();
    }
  }
  
  public static class GrayTipsConfig
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public ArrayList<Integer> aioTypes;
    public long createTime;
    public ArrayList<NearbyGrayTipsManager.Wording> favoriteGrayTipWordings1;
    public ArrayList<NearbyGrayTipsManager.Wording> favoriteGrayTipWordings2;
    public int global_MaxTipsCountPerDay;
    public ArrayList<NearbyGrayTipsManager.Wording> grayTipWordings;
    public boolean grayTipsEnable;
    public int id;
    public int maxTipsCount;
    public int messageCount;
    public int priority;
    public ArrayList<String> randomWordings;
    public NearbyGrayTipsManager.SceneFive sceneFive;
    public NearbyGrayTipsManager.SceneFour sceneFour;
    public int sceneId;
    public NearbyGrayTipsManager.SceneOne sceneOne;
    public NearbyGrayTipsManager.SceneThree sceneThree;
    public NearbyGrayTipsManager.SceneTwo sceneTwo;
    public ArrayList<Integer> sexTypes;
    public boolean showKeyboard;
    public int singleTask_MaxTipsCountPerDay;
    public int singleTask_maxTipsCount;
    public ArrayList<NearbyGrayTipsManager.TimeRangeInOneDay> timeRange;
    public boolean timeRangeControl;
    public String url;
    
    public NearbyGrayTipsManager.Wording getFavoriteGrayTipWording1(Random paramRandom)
    {
      int k = 0;
      int i;
      int m;
      int j;
      if (this.favoriteGrayTipWordings1 != null)
      {
        i = this.favoriteGrayTipWordings1.size();
        if ((i <= 1) || (paramRandom == null)) {
          break label140;
        }
        m = paramRandom.nextInt(i);
        j = m;
        label37:
        if (j >= i) {
          break label159;
        }
        paramRandom = (NearbyGrayTipsManager.Wording)this.favoriteGrayTipWordings1.get(j);
        if ((paramRandom == null) || (TextUtils.isEmpty(paramRandom.text))) {
          break label124;
        }
      }
      for (;;)
      {
        Object localObject = paramRandom;
        if (paramRandom == null) {
          i = k;
        }
        for (;;)
        {
          localObject = paramRandom;
          if (i < m)
          {
            localObject = (NearbyGrayTipsManager.Wording)this.favoriteGrayTipWordings1.get(i);
            if ((localObject == null) || (TextUtils.isEmpty(((NearbyGrayTipsManager.Wording)localObject).text))) {}
          }
          else
          {
            return localObject;
            i = 0;
            break;
            label124:
            j += 1;
            break label37;
          }
          i += 1;
          paramRandom = null;
        }
        label140:
        if (i == 1) {
          return (NearbyGrayTipsManager.Wording)this.favoriteGrayTipWordings1.get(0);
        }
        return null;
        label159:
        paramRandom = null;
      }
    }
    
    public NearbyGrayTipsManager.Wording getFavoriteGrayTipWording2(Random paramRandom)
    {
      int k = 0;
      int i;
      int m;
      int j;
      if (this.favoriteGrayTipWordings2 != null)
      {
        i = this.favoriteGrayTipWordings2.size();
        if ((i <= 1) || (paramRandom == null)) {
          break label140;
        }
        m = paramRandom.nextInt(i);
        j = m;
        label37:
        if (j >= i) {
          break label159;
        }
        paramRandom = (NearbyGrayTipsManager.Wording)this.favoriteGrayTipWordings2.get(j);
        if ((paramRandom == null) || (TextUtils.isEmpty(paramRandom.text))) {
          break label124;
        }
      }
      for (;;)
      {
        Object localObject = paramRandom;
        if (paramRandom == null) {
          i = k;
        }
        for (;;)
        {
          localObject = paramRandom;
          if (i < m)
          {
            localObject = (NearbyGrayTipsManager.Wording)this.favoriteGrayTipWordings2.get(i);
            if ((localObject == null) || (TextUtils.isEmpty(((NearbyGrayTipsManager.Wording)localObject).text))) {}
          }
          else
          {
            return localObject;
            i = 0;
            break;
            label124:
            j += 1;
            break label37;
          }
          i += 1;
          paramRandom = null;
        }
        label140:
        if (i == 1) {
          return (NearbyGrayTipsManager.Wording)this.favoriteGrayTipWordings2.get(0);
        }
        return null;
        label159:
        paramRandom = null;
      }
    }
    
    public NearbyGrayTipsManager.Wording getGrayTipWording(Random paramRandom)
    {
      int k = 0;
      int i;
      int m;
      int j;
      if (this.grayTipWordings != null)
      {
        i = this.grayTipWordings.size();
        if ((i <= 1) || (paramRandom == null)) {
          break label140;
        }
        m = paramRandom.nextInt(i);
        j = m;
        label37:
        if (j >= i) {
          break label159;
        }
        paramRandom = (NearbyGrayTipsManager.Wording)this.grayTipWordings.get(j);
        if ((paramRandom == null) || (TextUtils.isEmpty(paramRandom.text))) {
          break label124;
        }
      }
      for (;;)
      {
        Object localObject = paramRandom;
        if (paramRandom == null) {
          i = k;
        }
        for (;;)
        {
          localObject = paramRandom;
          if (i < m)
          {
            localObject = (NearbyGrayTipsManager.Wording)this.grayTipWordings.get(i);
            if ((localObject == null) || (TextUtils.isEmpty(((NearbyGrayTipsManager.Wording)localObject).text))) {}
          }
          else
          {
            return localObject;
            i = 0;
            break;
            label124:
            j += 1;
            break label37;
          }
          i += 1;
          paramRandom = null;
        }
        label140:
        if (i == 1) {
          return (NearbyGrayTipsManager.Wording)this.grayTipWordings.get(0);
        }
        return null;
        label159:
        paramRandom = null;
      }
    }
    
    public boolean isInValidRangeDaily(long paramLong)
    {
      boolean bool2;
      if ((!this.timeRangeControl) || (this.timeRange == null) || (this.timeRange.size() == 0))
      {
        bool2 = true;
        return bool2;
      }
      Object localObject = Calendar.getInstance();
      ((Calendar)localObject).setTimeInMillis(paramLong);
      int i = ((Calendar)localObject).get(11);
      localObject = this.timeRange.iterator();
      boolean bool1 = false;
      label61:
      while (((Iterator)localObject).hasNext())
      {
        NearbyGrayTipsManager.TimeRangeInOneDay localTimeRangeInOneDay = (NearbyGrayTipsManager.TimeRangeInOneDay)((Iterator)localObject).next();
        if (localTimeRangeInOneDay != null)
        {
          if (localTimeRangeInOneDay.beginTime <= localTimeRangeInOneDay.endTime) {
            if ((i >= localTimeRangeInOneDay.beginTime) && (i < localTimeRangeInOneDay.endTime)) {
              bool1 = true;
            }
          }
          for (;;)
          {
            bool2 = bool1;
            if (bool1) {
              break;
            }
            break label61;
            bool1 = false;
            continue;
            if (((i >= localTimeRangeInOneDay.beginTime) && (i < 24)) || ((i >= 0) && (i < localTimeRangeInOneDay.endTime))) {
              bool1 = true;
            } else {
              bool1 = false;
            }
          }
        }
      }
      return bool1;
    }
    
    public boolean isValid(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, long paramLong)
    {
      if ((this.aioTypes != null) && (!this.aioTypes.contains(Integer.valueOf(paramInt1)))) {
        return false;
      }
      if (this.sexTypes != null)
      {
        paramInt1 = ((ajpj)paramQQAppInterface.getManager(106)).ip(paramInt2);
        if (!this.sexTypes.contains(Integer.valueOf(paramInt1))) {
          return false;
        }
      }
      return isInValidRangeDaily(paramLong);
    }
    
    public String toString()
    {
      return "GrayTipsConfig{id=" + this.id + ", createTime=" + this.createTime + ", grayTipsEnable=" + this.grayTipsEnable + ", global_MaxTipsCountPerDay=" + this.global_MaxTipsCountPerDay + ", maxTipsCount=" + this.maxTipsCount + ", messageCount=" + this.messageCount + ", priority=" + this.priority + ", singleTask_MaxTipsCountPerDay=" + this.singleTask_MaxTipsCountPerDay + ", singleTask_maxTipsCount=" + this.singleTask_maxTipsCount + ", aioTypes=" + this.aioTypes + ", sexTypes=" + this.sexTypes + ", timeRangeControl=" + this.timeRangeControl + ", timeRange=" + this.timeRange + ", showKeyboard=" + this.showKeyboard + ", url='" + this.url + '\'' + ", grayTipWordings=" + this.grayTipWordings + ", favoriteGrayTipWordings1=" + this.favoriteGrayTipWordings1 + ", favoriteGrayTipWordings2=" + this.favoriteGrayTipWordings2 + ", sceneId=" + this.sceneId + ", randomWordings=" + this.randomWordings + ", sceneOne=" + this.sceneOne + ", sceneTwo=" + this.sceneTwo + ", sceneThree=" + this.sceneThree + ", sceneFour=" + this.sceneFour + ", sceneFive=" + this.sceneFive + '}';
    }
  }
  
  public static class GreetWording
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public long createTime;
    public int id;
    public int lastIndex;
    public List<String> list;
    
    public GreetWording()
    {
      this(0);
      if (QLog.isDevelopLevel()) {
        QLog.i("nearby_aio_operation_gray_tips", 4, "GreetWording");
      }
    }
    
    public GreetWording(int paramInt)
    {
      this.id = paramInt;
      this.createTime = 0L;
      this.list = new ArrayList(20);
      this.lastIndex = -1;
    }
    
    public static String getPath(int paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(NearbyGrayTipsManager.rE()).append(GreetWording.class.getSimpleName()).append("_").append(paramInt);
      return localStringBuilder.toString();
    }
    
    public String getWording(Random paramRandom)
    {
      String str = "";
      synchronized (this.list)
      {
        int k = this.list.size();
        if (k > 0)
        {
          int j = paramRandom.nextInt(k);
          int i = j;
          if (j == this.lastIndex) {
            i = (this.lastIndex + 1) % k;
          }
          this.lastIndex = i;
          str = (String)this.list.get(i);
        }
        return str;
      }
    }
    
    public void saveWording(long paramLong, List<String> paramList, boolean paramBoolean)
    {
      if ((paramList == null) || (paramList.size() == 0)) {}
      for (;;)
      {
        return;
        Object localObject2 = null;
        synchronized (this.list)
        {
          Object localObject1;
          if (this.list.size() != 0)
          {
            localObject1 = localObject2;
            if (this.createTime >= paramLong) {}
          }
          else
          {
            this.createTime = paramLong;
            this.list.clear();
            this.list.addAll(paramList);
            localObject1 = localObject2;
            if (paramBoolean)
            {
              localObject1 = new GreetWording(this.id);
              ((GreetWording)localObject1).createTime = this.createTime;
              ((GreetWording)localObject1).lastIndex = this.lastIndex;
              ((GreetWording)localObject1).list.addAll(paramList);
            }
          }
          if ((!paramBoolean) || (localObject1 == null)) {
            continue;
          }
          ThreadManager.getFileThreadHandler().post(new NearbyGrayTipsManager.GreetWording.1(this, (GreetWording)localObject1));
          return;
        }
      }
    }
    
    public String toString()
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append('[').append(this.id).append(',').append(this.createTime).append(',').append(this.lastIndex).append(',');
      if (this.list.size() == 0) {
        localStringBuffer.append("size is 0");
      }
      for (;;)
      {
        localStringBuffer.append(']');
        return localStringBuffer.toString();
        localStringBuffer.append("size = ").append(this.list.size());
        localStringBuffer.append('(');
        Iterator localIterator = this.list.iterator();
        while (localIterator.hasNext()) {
          localStringBuffer.append((String)localIterator.next()).append(',');
        }
        localStringBuffer.append(')');
      }
    }
  }
  
  public static class SceneFive
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public boolean faceScoreTrigger;
    public ArrayList<String> randomWordingForFeMale;
    public ArrayList<String> randomWordingForMale;
  }
  
  public static class SceneFour
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public boolean enterAIOTrigger;
  }
  
  public static class SceneOne
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public boolean sayHiTrigger;
  }
  
  public static class SceneThree
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public boolean keywordTrigger;
    public ArrayList<String> keywords;
    public ArrayList<Integer> whichSide;
  }
  
  public static class SceneTwo
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public boolean sayHiFrequencyControl;
    public int sayHiPeopleCount;
    public int timeRange;
  }
  
  public static class TimeRangeInOneDay
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public int beginTime;
    public int endTime;
  }
  
  public static class Wording
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public String highlightText;
    public String text;
    
    public String toString()
    {
      return "Wording{text='" + this.text + '\'' + ", highlightText='" + this.highlightText + '\'' + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearbyGrayTipsManager
 * JD-Core Version:    0.7.0.1
 */