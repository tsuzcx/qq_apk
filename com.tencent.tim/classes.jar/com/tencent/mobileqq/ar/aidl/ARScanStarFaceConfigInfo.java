package com.tencent.mobileqq.ar.aidl;

import adgf;
import aduc;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParser;

public class ARScanStarFaceConfigInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ARScanStarFaceConfigInfo> CREATOR = new adgf();
  static boolean bMS;
  static String xmlContent = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n\n<!--扫明星脸活动-->\n<ScanStarConfig>\n\t<!--普通人脸描述wording-->\n\t<normalFaceDescription>发现一个很酷的人，去扫明星有惊喜！</normalFaceDescription>\n\t<Activity>\n\t\t<actID>11</actID>\n\t\t<starName>杨洋</starName>\n\t\t<starUin>12345</starUin>\n\t\t<!--活动标题-->\n\t\t<actTitle>杨洋代言空间</actTitle>\n\t\t<!--活动描述wording-->\n\t\t<actDescription>杨洋活动简介</actDescription>\n\t\t<!--活动跳转Web的地址-->\n\t\t<starWebUrl>https://qq.com/starweburl.html</starWebUrl>\n\t\t<!--广告图片url-->\n\t\t<adImgUrl>https://qq.com/adimgurl.html</adImgUrl>\n\t\t<!--活动开始时间-->\n\t\t<beginTime>2017-05-07 00:00</beginTime>\n\t\t<!--活动结束时间-->\n\t\t<endTime>2017-07-31 23:59</endTime>\n\t</Activity>\n\t\n\t<Activity>\n\t\t<actID>12</actID>\n\t\t<starName>杨颖</starName>\n\t\t<starUin>12346</starUin>\n\t\t<!--活动标题-->\n\t\t<actTitle>杨颖代言XX</actTitle>\n\t\t<!--活动描述wording-->\n\t\t<actDescription>杨颖活动简介</actDescription>\n\t\t<!--活动跳转Web的地址-->\n\t\t<starWebUrl>https://qq.com/starweburl2.html</starWebUrl>\n\t\t<!--广告图片url-->\n\t\t<adImgUrl>https://qq.com/adimgurl2.html</adImgUrl>\n\t\t<!--活动开始时间-->\n\t\t<beginTime>2017-06-07 00:00</beginTime>\n\t\t<!--活动结束时间-->\n\t\t<endTime>2017-08-31 23:59</endTime>\n\t</Activity>\n</ScanStarConfig>\n\n\n\n\n";
  public ARScanStarFaceActInfo[] a;
  public String bsM;
  
  public ARScanStarFaceConfigInfo() {}
  
  public ARScanStarFaceConfigInfo(Parcel paramParcel)
  {
    this.bsM = paramParcel.readString();
    this.a = ((ARScanStarFaceActInfo[])paramParcel.createTypedArray(ARScanStarFaceActInfo.CREATOR));
  }
  
  public static ARScanStarFaceConfigInfo a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanStarFaceCfgInfo", 2, "loadConfigFromFile. uin = " + paramString);
    }
    if (paramString == null) {
      return null;
    }
    return a(BaseApplicationImpl.sApplication.getFilesDir().getPath(), "ar_scan_star_face_config" + paramString);
  }
  
  /* Error */
  public static ARScanStarFaceConfigInfo a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore_3
    //   5: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +37 -> 45
    //   11: ldc 59
    //   13: iconst_2
    //   14: new 61	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   21: ldc 101
    //   23: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 103
    //   32: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_1
    //   36: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: getstatic 105	com/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo:bMS	Z
    //   48: ifeq +12 -> 60
    //   51: getstatic 29	com/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo:xmlContent	Ljava/lang/String;
    //   54: invokestatic 108	com/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo;
    //   57: astore_2
    //   58: aload_2
    //   59: areturn
    //   60: aload_3
    //   61: astore_2
    //   62: aload_0
    //   63: ifnull -5 -> 58
    //   66: aload_3
    //   67: astore_2
    //   68: aload_0
    //   69: ldc 110
    //   71: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   74: ifne -16 -> 58
    //   77: aload_3
    //   78: astore_2
    //   79: aload_1
    //   80: ifnull -22 -> 58
    //   83: aload_3
    //   84: astore_2
    //   85: aload_1
    //   86: ldc 110
    //   88: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   91: ifne -33 -> 58
    //   94: new 87	java/io/File
    //   97: dup
    //   98: aload_0
    //   99: aload_1
    //   100: invokespecial 119	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: astore 7
    //   105: aload_3
    //   106: astore_2
    //   107: aload 7
    //   109: invokevirtual 122	java/io/File:exists	()Z
    //   112: ifeq -54 -> 58
    //   115: new 124	java/io/FileInputStream
    //   118: dup
    //   119: aload 7
    //   121: invokespecial 127	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   124: astore_0
    //   125: new 129	java/io/BufferedInputStream
    //   128: dup
    //   129: aload_0
    //   130: invokespecial 132	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   133: astore 5
    //   135: aload_0
    //   136: astore_2
    //   137: aload 5
    //   139: astore_1
    //   140: aload_0
    //   141: invokevirtual 136	java/io/FileInputStream:available	()I
    //   144: newarray byte
    //   146: astore_3
    //   147: aload_0
    //   148: astore_2
    //   149: aload 5
    //   151: astore_1
    //   152: aload 5
    //   154: aload_3
    //   155: invokevirtual 140	java/io/BufferedInputStream:read	([B)I
    //   158: pop
    //   159: aload_0
    //   160: astore_2
    //   161: aload 5
    //   163: astore_1
    //   164: new 112	java/lang/String
    //   167: dup
    //   168: aload_3
    //   169: ldc 142
    //   171: invokespecial 145	java/lang/String:<init>	([BLjava/lang/String;)V
    //   174: invokestatic 108	com/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo;
    //   177: astore_3
    //   178: aload_3
    //   179: astore_2
    //   180: aload 5
    //   182: ifnull +8 -> 190
    //   185: aload 5
    //   187: invokevirtual 148	java/io/BufferedInputStream:close	()V
    //   190: aload_2
    //   191: astore_1
    //   192: aload_0
    //   193: ifnull +9 -> 202
    //   196: aload_0
    //   197: invokevirtual 149	java/io/FileInputStream:close	()V
    //   200: aload_2
    //   201: astore_1
    //   202: aload_1
    //   203: astore_2
    //   204: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   207: ifeq -149 -> 58
    //   210: ldc 59
    //   212: iconst_2
    //   213: new 61	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   220: ldc 151
    //   222: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: aload_1
    //   226: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: aload_1
    //   236: areturn
    //   237: astore_1
    //   238: aload_1
    //   239: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   242: goto -52 -> 190
    //   245: astore_0
    //   246: aload_0
    //   247: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   250: aload_2
    //   251: astore_1
    //   252: goto -50 -> 202
    //   255: astore 4
    //   257: aconst_null
    //   258: astore_3
    //   259: aconst_null
    //   260: astore_0
    //   261: aload_3
    //   262: astore_2
    //   263: aload_0
    //   264: astore_1
    //   265: aload 7
    //   267: invokevirtual 160	java/io/File:delete	()Z
    //   270: pop
    //   271: aload_3
    //   272: astore_2
    //   273: aload_0
    //   274: astore_1
    //   275: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   278: ifeq +33 -> 311
    //   281: aload_3
    //   282: astore_2
    //   283: aload_0
    //   284: astore_1
    //   285: ldc 59
    //   287: iconst_2
    //   288: new 61	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   295: ldc 162
    //   297: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload 4
    //   302: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   305: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokestatic 165	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   311: aload_0
    //   312: ifnull +7 -> 319
    //   315: aload_0
    //   316: invokevirtual 148	java/io/BufferedInputStream:close	()V
    //   319: aload 6
    //   321: astore_1
    //   322: aload_3
    //   323: ifnull -121 -> 202
    //   326: aload_3
    //   327: invokevirtual 149	java/io/FileInputStream:close	()V
    //   330: aload 6
    //   332: astore_1
    //   333: goto -131 -> 202
    //   336: astore_0
    //   337: aload_0
    //   338: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   341: aload 6
    //   343: astore_1
    //   344: goto -142 -> 202
    //   347: astore_0
    //   348: aload_0
    //   349: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   352: goto -33 -> 319
    //   355: astore_3
    //   356: aconst_null
    //   357: astore_0
    //   358: aconst_null
    //   359: astore_1
    //   360: aload_1
    //   361: ifnull +7 -> 368
    //   364: aload_1
    //   365: invokevirtual 148	java/io/BufferedInputStream:close	()V
    //   368: aload_0
    //   369: ifnull +7 -> 376
    //   372: aload_0
    //   373: invokevirtual 149	java/io/FileInputStream:close	()V
    //   376: aload_3
    //   377: athrow
    //   378: astore_1
    //   379: aload_1
    //   380: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   383: goto -15 -> 368
    //   386: astore_0
    //   387: aload_0
    //   388: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   391: goto -15 -> 376
    //   394: astore_3
    //   395: aconst_null
    //   396: astore_1
    //   397: goto -37 -> 360
    //   400: astore_3
    //   401: aload_2
    //   402: astore_0
    //   403: goto -43 -> 360
    //   406: astore 4
    //   408: aconst_null
    //   409: astore_1
    //   410: aload_0
    //   411: astore_3
    //   412: aload_1
    //   413: astore_0
    //   414: goto -153 -> 261
    //   417: astore 4
    //   419: aload_0
    //   420: astore_3
    //   421: aload 5
    //   423: astore_0
    //   424: goto -163 -> 261
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	427	0	paramString1	String
    //   0	427	1	paramString2	String
    //   57	345	2	localObject1	Object
    //   4	323	3	localObject2	Object
    //   355	22	3	localObject3	Object
    //   394	1	3	localObject4	Object
    //   400	1	3	localObject5	Object
    //   411	10	3	str	String
    //   255	46	4	localThrowable1	java.lang.Throwable
    //   406	1	4	localThrowable2	java.lang.Throwable
    //   417	1	4	localThrowable3	java.lang.Throwable
    //   133	289	5	localBufferedInputStream	java.io.BufferedInputStream
    //   1	341	6	localObject6	Object
    //   103	163	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   185	190	237	java/io/IOException
    //   196	200	245	java/io/IOException
    //   115	125	255	java/lang/Throwable
    //   326	330	336	java/io/IOException
    //   315	319	347	java/io/IOException
    //   115	125	355	finally
    //   364	368	378	java/io/IOException
    //   372	376	386	java/io/IOException
    //   125	135	394	finally
    //   140	147	400	finally
    //   152	159	400	finally
    //   164	178	400	finally
    //   265	271	400	finally
    //   275	281	400	finally
    //   285	311	400	finally
    //   125	135	406	java/lang/Throwable
    //   140	147	417	java/lang/Throwable
    //   152	159	417	java/lang/Throwable
    //   164	178	417	java/lang/Throwable
  }
  
  public static boolean aG(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanStarFaceCfgInfo", 2, "saveConfigToFile. uin = " + paramString2);
    }
    if (paramString2 == null) {
      return false;
    }
    return m(paramString1, BaseApplicationImpl.sApplication.getFilesDir().getPath(), "ar_scan_star_face_config" + paramString2);
  }
  
  public static ARScanStarFaceConfigInfo b(String paramString)
  {
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    ARScanStarFaceConfigInfo localARScanStarFaceConfigInfo = new ARScanStarFaceConfigInfo();
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        i = localXmlPullParser.getEventType();
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ScanStarFaceCfgInfo", 2, paramString, localException);
        return null;
      }
      int i = localXmlPullParser.next();
      break label536;
      localObject = localXmlPullParser.getName();
      if (((String)localObject).equalsIgnoreCase("Activity"))
      {
        localObject = new ARScanStarFaceActInfo();
        i = localXmlPullParser.next();
        if (i != 1) {
          if (i == 2)
          {
            str = localXmlPullParser.getName();
            bool = str.equalsIgnoreCase("actID");
            if (bool) {
              try
              {
                ((ARScanStarFaceActInfo)localObject).SP = Long.valueOf(localXmlPullParser.nextText()).longValue();
                i = localXmlPullParser.next();
              }
              catch (NumberFormatException localNumberFormatException)
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.e("ScanStarFaceCfgInfo", 2, "actID parse failed", localNumberFormatException);
                continue;
              }
            } else if (localNumberFormatException.equalsIgnoreCase("starName")) {
              ((ARScanStarFaceActInfo)localObject).starName = localException.nextText();
            } else if (localNumberFormatException.equalsIgnoreCase("starUin")) {
              ((ARScanStarFaceActInfo)localObject).bsI = localException.nextText();
            } else if (localNumberFormatException.equalsIgnoreCase("actTitle")) {
              ((ARScanStarFaceActInfo)localObject).nu = localException.nextText();
            } else if (localNumberFormatException.equalsIgnoreCase("actDescription")) {
              ((ARScanStarFaceActInfo)localObject).bsJ = localException.nextText();
            } else if (localNumberFormatException.equalsIgnoreCase("starWebUrl")) {
              ((ARScanStarFaceActInfo)localObject).bsK = localException.nextText();
            } else if (localNumberFormatException.equalsIgnoreCase("adImgUrl")) {
              ((ARScanStarFaceActInfo)localObject).bsL = localException.nextText();
            } else if (localNumberFormatException.equalsIgnoreCase("beginTime")) {
              ((ARScanStarFaceActInfo)localObject).beginTime = aduc.ah(localException.nextText());
            } else if (localNumberFormatException.equalsIgnoreCase("endTime")) {
              ((ARScanStarFaceActInfo)localObject).endTime = aduc.ah(localException.nextText());
            }
          }
          else if ((i == 3) && (localException.getName().equalsIgnoreCase("Activity")))
          {
            localArrayList.add(localObject);
          }
        }
      }
      else if (((String)localObject).equalsIgnoreCase("normalFaceDescription"))
      {
        localARScanStarFaceConfigInfo.bsM = localException.nextText();
        label536:
        while (i == 1)
        {
          Object localObject;
          String str;
          boolean bool;
          if (localArrayList.size() > 0)
          {
            localARScanStarFaceConfigInfo.a = new ARScanStarFaceActInfo[localArrayList.size()];
            localArrayList.toArray(localARScanStarFaceConfigInfo.a);
          }
          if (QLog.isColorLevel()) {
            QLog.d("ScanStarFaceCfgInfo", 2, "parseConfig success|config=" + Arrays.toString(localARScanStarFaceConfigInfo.a) + ", normalFaceDescription =" + localARScanStarFaceConfigInfo.bsM);
          }
          return localARScanStarFaceConfigInfo;
        }
        switch (i)
        {
        }
      }
    }
  }
  
  public static void deleteConfigFile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanStarFaceCfgInfo", 2, "deleteConfigFile. uin = " + paramString);
    }
    if (paramString == null) {
      return;
    }
    deleteConfigFile(BaseApplicationImpl.sApplication.getFilesDir().getPath(), "ar_scan_star_face_config" + paramString);
  }
  
  public static void deleteConfigFile(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanStarFaceCfgInfo", 2, "deleteConfigFile. dir = " + paramString1 + ", filename = " + paramString2);
    }
    if ((paramString1 == null) || (paramString1.equals("")) || (paramString2 == null) || (paramString2.equals(""))) {}
    do
    {
      return;
      paramString1 = new File(paramString1, paramString2);
    } while (!paramString1.exists());
    paramString1.delete();
  }
  
  /* Error */
  public static boolean m(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +38 -> 44
    //   9: ldc 59
    //   11: iconst_2
    //   12: new 61	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 318
    //   22: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc 103
    //   31: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_2
    //   35: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: aload_0
    //   45: ifnull +29 -> 74
    //   48: aload_1
    //   49: ifnull +25 -> 74
    //   52: aload_1
    //   53: ldc 110
    //   55: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   58: ifne +16 -> 74
    //   61: aload_2
    //   62: ifnull +12 -> 74
    //   65: aload_2
    //   66: ldc 110
    //   68: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   71: ifeq +7 -> 78
    //   74: iconst_0
    //   75: istore_3
    //   76: iload_3
    //   77: ireturn
    //   78: new 87	java/io/File
    //   81: dup
    //   82: aload_1
    //   83: aload_2
    //   84: invokespecial 119	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: astore 6
    //   89: new 87	java/io/File
    //   92: dup
    //   93: aload_1
    //   94: new 61	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   101: aload_2
    //   102: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: ldc_w 320
    //   108: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokespecial 119	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: astore 7
    //   119: iconst_0
    //   120: newarray byte
    //   122: astore_1
    //   123: aload_0
    //   124: ldc 142
    //   126: invokevirtual 323	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   129: astore_0
    //   130: aload 6
    //   132: invokevirtual 326	java/io/File:getParentFile	()Ljava/io/File;
    //   135: astore_1
    //   136: aload_1
    //   137: invokevirtual 122	java/io/File:exists	()Z
    //   140: ifne +8 -> 148
    //   143: aload_1
    //   144: invokevirtual 329	java/io/File:mkdir	()Z
    //   147: pop
    //   148: aload 7
    //   150: invokevirtual 122	java/io/File:exists	()Z
    //   153: ifeq +9 -> 162
    //   156: aload 7
    //   158: invokevirtual 160	java/io/File:delete	()Z
    //   161: pop
    //   162: new 331	java/io/FileOutputStream
    //   165: dup
    //   166: aload 7
    //   168: invokespecial 332	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   171: astore_2
    //   172: new 334	java/io/BufferedOutputStream
    //   175: dup
    //   176: aload_2
    //   177: invokespecial 337	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   180: astore_1
    //   181: aload_1
    //   182: aload_0
    //   183: invokevirtual 340	java/io/BufferedOutputStream:write	([B)V
    //   186: aload_1
    //   187: invokevirtual 343	java/io/BufferedOutputStream:flush	()V
    //   190: aload 7
    //   192: aload 6
    //   194: invokestatic 349	aqhq:renameFile	(Ljava/io/File;Ljava/io/File;)Z
    //   197: istore 4
    //   199: aload_1
    //   200: ifnull +7 -> 207
    //   203: aload_1
    //   204: invokevirtual 350	java/io/BufferedOutputStream:close	()V
    //   207: iload 4
    //   209: istore_3
    //   210: aload_2
    //   211: ifnull -135 -> 76
    //   214: aload_2
    //   215: invokevirtual 351	java/io/FileOutputStream:close	()V
    //   218: iload 4
    //   220: ireturn
    //   221: astore_0
    //   222: aload_0
    //   223: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   226: iload 4
    //   228: ireturn
    //   229: astore_0
    //   230: aload_0
    //   231: invokevirtual 352	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   234: aload_1
    //   235: astore_0
    //   236: goto -106 -> 130
    //   239: astore_0
    //   240: aload_0
    //   241: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   244: goto -37 -> 207
    //   247: astore_2
    //   248: aconst_null
    //   249: astore_1
    //   250: aload 5
    //   252: astore_0
    //   253: aload_2
    //   254: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   257: aload_1
    //   258: ifnull +7 -> 265
    //   261: aload_1
    //   262: invokevirtual 350	java/io/BufferedOutputStream:close	()V
    //   265: aload_0
    //   266: ifnull +7 -> 273
    //   269: aload_0
    //   270: invokevirtual 351	java/io/FileOutputStream:close	()V
    //   273: iconst_0
    //   274: ireturn
    //   275: astore_1
    //   276: aload_1
    //   277: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   280: goto -15 -> 265
    //   283: astore_0
    //   284: aload_0
    //   285: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   288: goto -15 -> 273
    //   291: astore_0
    //   292: aconst_null
    //   293: astore_1
    //   294: aconst_null
    //   295: astore_2
    //   296: aload_1
    //   297: ifnull +7 -> 304
    //   300: aload_1
    //   301: invokevirtual 350	java/io/BufferedOutputStream:close	()V
    //   304: aload_2
    //   305: ifnull +7 -> 312
    //   308: aload_2
    //   309: invokevirtual 351	java/io/FileOutputStream:close	()V
    //   312: aload_0
    //   313: athrow
    //   314: astore_1
    //   315: aload_1
    //   316: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   319: goto -15 -> 304
    //   322: astore_1
    //   323: aload_1
    //   324: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   327: goto -15 -> 312
    //   330: astore_0
    //   331: aconst_null
    //   332: astore_1
    //   333: goto -37 -> 296
    //   336: astore_0
    //   337: goto -41 -> 296
    //   340: astore 5
    //   342: aload_0
    //   343: astore_2
    //   344: aload 5
    //   346: astore_0
    //   347: goto -51 -> 296
    //   350: astore 5
    //   352: aconst_null
    //   353: astore_1
    //   354: aload_2
    //   355: astore_0
    //   356: aload 5
    //   358: astore_2
    //   359: goto -106 -> 253
    //   362: astore 5
    //   364: aload_2
    //   365: astore_0
    //   366: aload 5
    //   368: astore_2
    //   369: goto -116 -> 253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	372	0	paramString1	String
    //   0	372	1	paramString2	String
    //   0	372	2	paramString3	String
    //   75	135	3	bool1	boolean
    //   197	30	4	bool2	boolean
    //   1	250	5	localObject1	Object
    //   340	5	5	localObject2	Object
    //   350	7	5	localIOException1	java.io.IOException
    //   362	5	5	localIOException2	java.io.IOException
    //   87	106	6	localFile1	File
    //   117	74	7	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   214	218	221	java/io/IOException
    //   123	130	229	java/io/UnsupportedEncodingException
    //   203	207	239	java/io/IOException
    //   162	172	247	java/io/IOException
    //   261	265	275	java/io/IOException
    //   269	273	283	java/io/IOException
    //   162	172	291	finally
    //   300	304	314	java/io/IOException
    //   308	312	322	java/io/IOException
    //   172	181	330	finally
    //   181	199	336	finally
    //   253	257	340	finally
    //   172	181	350	java/io/IOException
    //   181	199	362	java/io/IOException
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.bsM);
    paramParcel.writeTypedArray(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo
 * JD-Core Version:    0.7.0.1
 */