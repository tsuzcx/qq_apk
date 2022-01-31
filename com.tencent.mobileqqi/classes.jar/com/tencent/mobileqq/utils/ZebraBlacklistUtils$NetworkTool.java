package com.tencent.mobileqq.utils;

import CommonClientInterface.stReqComm;
import CommonClientInterface.stReqHeader;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.net.SocketTimeoutException;

public class ZebraBlacklistUtils$NetworkTool
  implements Runnable
{
  private ZebraBlacklistUtils.JceRequestCallback jdField_a_of_type_ComTencentMobileqqUtilsZebraBlacklistUtils$JceRequestCallback;
  private String jdField_a_of_type_JavaLangString = "";
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  private String b = "";
  
  public ZebraBlacklistUtils$NetworkTool(String paramString1, String paramString2, byte[] paramArrayOfByte, ZebraBlacklistUtils.JceRequestCallback paramJceRequestCallback)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_ComTencentMobileqqUtilsZebraBlacklistUtils$JceRequestCallback = paramJceRequestCallback;
  }
  
  public static stReqHeader a(String paramString1, String paramString2)
  {
    stReqHeader localstReqHeader = new stReqHeader();
    label181:
    for (;;)
    {
      try
      {
        stReqComm localstReqComm = new stReqComm();
        localstReqComm.iAppId = 1004;
        localstReqComm.iPlat = 1;
        localstReqComm.sAppVersion = "1.1.0";
        if (TextUtils.isEmpty(Build.MODEL))
        {
          localObject1 = "Unknown";
          localstReqComm.sDeviceName = ((String)localObject1);
          if (TextUtils.isEmpty(Build.VERSION.RELEASE))
          {
            localObject1 = "Unknown";
            localstReqComm.sOSVersion = ((String)localObject1);
            if (!TextUtils.isEmpty(ZebraBlacklistUtils.d)) {
              continue;
            }
            localObject1 = "";
            localstReqComm.sDeviceID = ((String)localObject1);
            localObject1 = (QQAppInterface)BaseApplicationImpl.a().a();
            if (localObject1 == null) {
              break label181;
            }
            localObject1 = ((QQAppInterface)localObject1).a();
            Object localObject2 = localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              localObject2 = "";
            }
            localstReqComm.sUid = ((String)localObject2);
            localstReqHeader.reqComm = localstReqComm;
            localstReqHeader.sApply = paramString1;
            localstReqHeader.sCmd = paramString2;
            return localstReqHeader;
          }
        }
        else
        {
          localObject1 = Build.MODEL;
          continue;
        }
        Object localObject1 = Build.VERSION.RELEASE;
        continue;
        localObject1 = ZebraBlacklistUtils.d;
        continue;
        localObject1 = "";
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return localstReqHeader;
      }
    }
  }
  
  private void a(String paramString, byte[] paramArrayOfByte)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        paramString = a(paramString, paramArrayOfByte);
        if (paramString == null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqUtilsZebraBlacklistUtils$JceRequestCallback == null) {
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilsZebraBlacklistUtils$JceRequestCallback.a();
        }
      }
      catch (SocketTimeoutException paramString)
      {
        paramString.printStackTrace();
        this.jdField_a_of_type_ComTencentMobileqqUtilsZebraBlacklistUtils$JceRequestCallback.a();
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsZebraBlacklistUtils$JceRequestCallback != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsZebraBlacklistUtils$JceRequestCallback.a(paramString);
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        this.jdField_a_of_type_ComTencentMobileqqUtilsZebraBlacklistUtils$JceRequestCallback.a();
      }
    }
  }
  
  /* Error */
  private static byte[] a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: new 127	org/apache/http/impl/client/DefaultHttpClient
    //   6: dup
    //   7: invokespecial 128	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   10: astore 9
    //   12: aload 9
    //   14: invokeinterface 134 1 0
    //   19: astore_3
    //   20: aload_3
    //   21: sipush 30000
    //   24: invokestatic 140	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   27: aload_3
    //   28: sipush 30000
    //   31: invokestatic 143	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   34: aload_3
    //   35: sipush 1024
    //   38: invokestatic 146	org/apache/http/params/HttpConnectionParams:setSocketBufferSize	(Lorg/apache/http/params/HttpParams;I)V
    //   41: new 148	org/apache/http/client/methods/HttpPost
    //   44: dup
    //   45: aload_0
    //   46: invokespecial 151	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   49: astore_0
    //   50: aload_0
    //   51: new 153	org/apache/http/entity/ByteArrayEntity
    //   54: dup
    //   55: aload_1
    //   56: invokespecial 155	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
    //   59: invokevirtual 159	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   62: aload 9
    //   64: aload_0
    //   65: invokeinterface 163 2 0
    //   70: astore_1
    //   71: aload_1
    //   72: ifnull +14 -> 86
    //   75: aload_1
    //   76: invokeinterface 169 1 0
    //   81: astore_0
    //   82: aload_0
    //   83: ifnonnull +56 -> 139
    //   86: aload 9
    //   88: ifnull +15 -> 103
    //   91: aload 9
    //   93: invokeinterface 173 1 0
    //   98: invokeinterface 178 1 0
    //   103: iconst_0
    //   104: ifeq +11 -> 115
    //   107: new 180	java/lang/NullPointerException
    //   110: dup
    //   111: invokespecial 181	java/lang/NullPointerException:<init>	()V
    //   114: athrow
    //   115: aload 8
    //   117: astore_1
    //   118: iconst_0
    //   119: ifeq +11 -> 130
    //   122: new 180	java/lang/NullPointerException
    //   125: dup
    //   126: invokespecial 181	java/lang/NullPointerException:<init>	()V
    //   129: athrow
    //   130: aload_1
    //   131: areturn
    //   132: astore_0
    //   133: aload_0
    //   134: invokevirtual 109	java/lang/Exception:printStackTrace	()V
    //   137: aconst_null
    //   138: areturn
    //   139: aload_1
    //   140: invokeinterface 169 1 0
    //   145: invokeinterface 187 1 0
    //   150: astore_1
    //   151: new 189	java/io/ByteArrayOutputStream
    //   154: dup
    //   155: invokespecial 190	java/io/ByteArrayOutputStream:<init>	()V
    //   158: astore 5
    //   160: aload 5
    //   162: astore_3
    //   163: aload_1
    //   164: astore 6
    //   166: aload 5
    //   168: astore 4
    //   170: aload_1
    //   171: invokevirtual 196	java/io/InputStream:read	()I
    //   174: istore_2
    //   175: aload 5
    //   177: astore_0
    //   178: iload_2
    //   179: iconst_m1
    //   180: if_icmpeq +43 -> 223
    //   183: aload 5
    //   185: astore_3
    //   186: aload_1
    //   187: astore 6
    //   189: aload 5
    //   191: astore 4
    //   193: aload 5
    //   195: iload_2
    //   196: invokevirtual 200	java/io/ByteArrayOutputStream:write	(I)V
    //   199: goto -39 -> 160
    //   202: astore 7
    //   204: aload 5
    //   206: astore_0
    //   207: aload_0
    //   208: astore_3
    //   209: aload_1
    //   210: astore 6
    //   212: aload_0
    //   213: astore 4
    //   215: aload_0
    //   216: astore 5
    //   218: aload 7
    //   220: invokevirtual 109	java/lang/Exception:printStackTrace	()V
    //   223: aload_0
    //   224: ifnonnull +48 -> 272
    //   227: aload 9
    //   229: ifnull +15 -> 244
    //   232: aload 9
    //   234: invokeinterface 173 1 0
    //   239: invokeinterface 178 1 0
    //   244: aload_1
    //   245: ifnull +7 -> 252
    //   248: aload_1
    //   249: invokevirtual 203	java/io/InputStream:close	()V
    //   252: aload 8
    //   254: astore_1
    //   255: aload_0
    //   256: ifnull -126 -> 130
    //   259: aload_0
    //   260: invokevirtual 204	java/io/ByteArrayOutputStream:close	()V
    //   263: aconst_null
    //   264: areturn
    //   265: astore_0
    //   266: aload_0
    //   267: invokevirtual 109	java/lang/Exception:printStackTrace	()V
    //   270: aconst_null
    //   271: areturn
    //   272: aload_0
    //   273: astore_3
    //   274: aload_1
    //   275: astore 6
    //   277: aload_0
    //   278: astore 4
    //   280: aload_0
    //   281: astore 5
    //   283: aload_0
    //   284: invokevirtual 208	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   287: astore 7
    //   289: aload 7
    //   291: astore_3
    //   292: aload 9
    //   294: ifnull +15 -> 309
    //   297: aload 9
    //   299: invokeinterface 173 1 0
    //   304: invokeinterface 178 1 0
    //   309: aload_1
    //   310: ifnull +7 -> 317
    //   313: aload_1
    //   314: invokevirtual 203	java/io/InputStream:close	()V
    //   317: aload_3
    //   318: astore_1
    //   319: aload_0
    //   320: ifnull -190 -> 130
    //   323: aload_0
    //   324: invokevirtual 204	java/io/ByteArrayOutputStream:close	()V
    //   327: aload_3
    //   328: areturn
    //   329: astore_0
    //   330: aload_0
    //   331: invokevirtual 109	java/lang/Exception:printStackTrace	()V
    //   334: aload_3
    //   335: areturn
    //   336: astore_1
    //   337: aconst_null
    //   338: astore_3
    //   339: aconst_null
    //   340: astore_0
    //   341: aload_1
    //   342: invokevirtual 109	java/lang/Exception:printStackTrace	()V
    //   345: aload_1
    //   346: athrow
    //   347: astore 4
    //   349: aload_0
    //   350: astore_1
    //   351: aload 4
    //   353: astore_0
    //   354: aload 9
    //   356: ifnull +15 -> 371
    //   359: aload 9
    //   361: invokeinterface 173 1 0
    //   366: invokeinterface 178 1 0
    //   371: aload_1
    //   372: ifnull +7 -> 379
    //   375: aload_1
    //   376: invokevirtual 203	java/io/InputStream:close	()V
    //   379: aload_3
    //   380: ifnull +7 -> 387
    //   383: aload_3
    //   384: invokevirtual 204	java/io/ByteArrayOutputStream:close	()V
    //   387: aload_0
    //   388: athrow
    //   389: astore_0
    //   390: aconst_null
    //   391: astore 4
    //   393: aconst_null
    //   394: astore_1
    //   395: aload 4
    //   397: astore_3
    //   398: aload_1
    //   399: astore 6
    //   401: aload_0
    //   402: invokevirtual 209	java/lang/Error:printStackTrace	()V
    //   405: aload 9
    //   407: ifnull +15 -> 422
    //   410: aload 9
    //   412: invokeinterface 173 1 0
    //   417: invokeinterface 178 1 0
    //   422: aload_1
    //   423: ifnull +7 -> 430
    //   426: aload_1
    //   427: invokevirtual 203	java/io/InputStream:close	()V
    //   430: aload 8
    //   432: astore_1
    //   433: aload 4
    //   435: ifnull -305 -> 130
    //   438: aload 4
    //   440: invokevirtual 204	java/io/ByteArrayOutputStream:close	()V
    //   443: aconst_null
    //   444: areturn
    //   445: astore_0
    //   446: aload_0
    //   447: invokevirtual 109	java/lang/Exception:printStackTrace	()V
    //   450: aconst_null
    //   451: areturn
    //   452: astore_1
    //   453: aload_1
    //   454: invokevirtual 109	java/lang/Exception:printStackTrace	()V
    //   457: goto -70 -> 387
    //   460: astore_0
    //   461: aconst_null
    //   462: astore_3
    //   463: aconst_null
    //   464: astore_1
    //   465: goto -111 -> 354
    //   468: astore_0
    //   469: aconst_null
    //   470: astore_3
    //   471: goto -117 -> 354
    //   474: astore_0
    //   475: aload 6
    //   477: astore_1
    //   478: goto -124 -> 354
    //   481: astore_0
    //   482: aconst_null
    //   483: astore 4
    //   485: goto -90 -> 395
    //   488: astore_0
    //   489: goto -94 -> 395
    //   492: astore_3
    //   493: aload_1
    //   494: astore_0
    //   495: aload_3
    //   496: astore_1
    //   497: aload 5
    //   499: astore_3
    //   500: goto -159 -> 341
    //   503: astore 7
    //   505: aconst_null
    //   506: astore_0
    //   507: goto -300 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	510	0	paramString	String
    //   0	510	1	paramArrayOfByte	byte[]
    //   174	22	2	i	int
    //   19	452	3	localObject1	Object
    //   492	4	3	localException1	Exception
    //   499	1	3	localObject2	Object
    //   168	111	4	localObject3	Object
    //   347	5	4	localObject4	Object
    //   391	93	4	localObject5	Object
    //   158	340	5	localObject6	Object
    //   164	312	6	arrayOfByte1	byte[]
    //   202	17	7	localException2	Exception
    //   287	3	7	arrayOfByte2	byte[]
    //   503	1	7	localException3	Exception
    //   1	430	8	localObject7	Object
    //   10	401	9	localDefaultHttpClient	org.apache.http.impl.client.DefaultHttpClient
    // Exception table:
    //   from	to	target	type
    //   107	115	132	java/lang/Exception
    //   122	130	132	java/lang/Exception
    //   170	175	202	java/lang/Exception
    //   193	199	202	java/lang/Exception
    //   248	252	265	java/lang/Exception
    //   259	263	265	java/lang/Exception
    //   313	317	329	java/lang/Exception
    //   323	327	329	java/lang/Exception
    //   12	71	336	java/lang/Exception
    //   75	82	336	java/lang/Exception
    //   139	151	336	java/lang/Exception
    //   341	347	347	finally
    //   12	71	389	java/lang/Error
    //   75	82	389	java/lang/Error
    //   139	151	389	java/lang/Error
    //   426	430	445	java/lang/Exception
    //   438	443	445	java/lang/Exception
    //   375	379	452	java/lang/Exception
    //   383	387	452	java/lang/Exception
    //   12	71	460	finally
    //   75	82	460	finally
    //   139	151	460	finally
    //   151	160	468	finally
    //   170	175	474	finally
    //   193	199	474	finally
    //   218	223	474	finally
    //   283	289	474	finally
    //   401	405	474	finally
    //   151	160	481	java/lang/Error
    //   170	175	488	java/lang/Error
    //   193	199	488	java/lang/Error
    //   218	223	488	java/lang/Error
    //   283	289	488	java/lang/Error
    //   218	223	492	java/lang/Exception
    //   283	289	492	java/lang/Exception
    //   151	160	503	java/lang/Exception
  }
  
  public void run()
  {
    a(this.jdField_a_of_type_JavaLangString + this.b, this.jdField_a_of_type_ArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ZebraBlacklistUtils.NetworkTool
 * JD-Core Version:    0.7.0.1
 */