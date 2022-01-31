package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;

public class TroopFileTransferManager$TaskHttpUpload
  extends TroopFileTransferManager.Task
{
  public TroopFileTransferManager$TaskHttpUpload(TroopFileTransferManager paramTroopFileTransferManager, TroopFileTransferManager.Item paramItem)
  {
    super(paramTroopFileTransferManager, paramItem, 2);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private HttpResponse a(HttpClient paramHttpClient, String paramString, byte[] paramArrayOfByte)
  {
    if ((paramHttpClient == null) || (paramString == null) || (paramArrayOfByte == null)) {
      return null;
    }
    paramString = new HttpPost(paramString);
    paramString.setHeader("User-Agent", "TroopFile");
    paramString.setHeader("Content-Type", "text/octet");
    paramString.setHeader("Connection", "keep-alive");
    if (NetworkUtil.g(BaseApplication.getContext())) {
      paramString.setHeader("Net-type", "Wifi");
    }
    for (;;)
    {
      paramString.setEntity(new ByteArrayEntity(paramArrayOfByte));
      try
      {
        paramHttpClient = paramHttpClient.execute(paramString);
        return paramHttpClient;
      }
      catch (ClientProtocolException paramHttpClient)
      {
        paramHttpClient.printStackTrace();
        return null;
      }
      catch (IOException paramHttpClient)
      {
        paramHttpClient.printStackTrace();
      }
      paramString.setHeader("Net-type", "gprs");
    }
    return null;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   4: aload_0
    //   5: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   8: invokevirtual 99	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   11: ifeq +4 -> 15
    //   14: return
    //   15: new 101	java/io/File
    //   18: dup
    //   19: aload_0
    //   20: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   23: getfield 107	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   26: invokespecial 108	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: astore 13
    //   31: aload_0
    //   32: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   35: invokevirtual 111	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lmqq/manager/ProxyIpManager;
    //   38: ifnull +1404 -> 1442
    //   41: aload_0
    //   42: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   45: invokevirtual 111	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lmqq/manager/ProxyIpManager;
    //   48: iconst_5
    //   49: invokeinterface 117 2 0
    //   54: astore 11
    //   56: iconst_0
    //   57: istore_1
    //   58: sipush 1024
    //   61: istore_3
    //   62: iload_1
    //   63: istore_2
    //   64: iload_1
    //   65: iconst_3
    //   66: if_icmpgt +223 -> 289
    //   69: iload_1
    //   70: ifle +117 -> 187
    //   73: invokestatic 50	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   76: invokestatic 120	com/tencent/mobileqq/utils/NetworkUtil:f	(Landroid/content/Context;)Z
    //   79: ifne +54 -> 133
    //   82: aload_0
    //   83: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   86: aload_0
    //   87: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   90: iconst_3
    //   91: bipush 106
    //   93: invokevirtual 123	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   96: return
    //   97: astore 10
    //   99: invokestatic 129	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   102: ifeq +11 -> 113
    //   105: ldc 131
    //   107: iconst_4
    //   108: ldc 133
    //   110: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aload 10
    //   115: invokevirtual 138	java/lang/InterruptedException:printStackTrace	()V
    //   118: aload_0
    //   119: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   122: aload_0
    //   123: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   126: iconst_3
    //   127: bipush 102
    //   129: invokevirtual 123	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   132: return
    //   133: iconst_0
    //   134: istore_2
    //   135: iload_2
    //   136: iload_1
    //   137: bipush 100
    //   139: imul
    //   140: if_icmpge +47 -> 187
    //   143: ldc2_w 139
    //   146: invokestatic 146	java/lang/Thread:sleep	(J)V
    //   149: aload_0
    //   150: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   153: aload_0
    //   154: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   157: invokevirtual 99	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   160: ifne -146 -> 14
    //   163: invokestatic 50	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   166: invokestatic 120	com/tencent/mobileqq/utils/NetworkUtil:f	(Landroid/content/Context;)Z
    //   169: ifne +1279 -> 1448
    //   172: aload_0
    //   173: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   176: aload_0
    //   177: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   180: iconst_3
    //   181: bipush 106
    //   183: invokevirtual 123	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   186: return
    //   187: aload_0
    //   188: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   191: aload_0
    //   192: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   195: invokevirtual 99	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   198: ifne -184 -> 14
    //   201: aload 13
    //   203: invokevirtual 150	java/io/File:length	()J
    //   206: aload_0
    //   207: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   210: getfield 154	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   213: lcmp
    //   214: ifeq +19 -> 233
    //   217: aload_0
    //   218: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   221: aload_0
    //   222: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   225: iconst_3
    //   226: sipush 206
    //   229: invokevirtual 123	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   232: return
    //   233: iload_1
    //   234: iconst_1
    //   235: iadd
    //   236: istore_1
    //   237: iload_3
    //   238: newarray byte
    //   240: astore 14
    //   242: sipush 16384
    //   245: istore_3
    //   246: new 156	java/io/FileInputStream
    //   249: dup
    //   250: aload 13
    //   252: invokespecial 159	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   255: astore 10
    //   257: aload 10
    //   259: aload_0
    //   260: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   263: getfield 162	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   266: invokevirtual 166	java/io/FileInputStream:skip	(J)J
    //   269: pop2
    //   270: aload 10
    //   272: aload 14
    //   274: invokevirtual 170	java/io/FileInputStream:read	([B)I
    //   277: istore_2
    //   278: aload 10
    //   280: invokevirtual 173	java/io/FileInputStream:close	()V
    //   283: iload_2
    //   284: ifge +125 -> 409
    //   287: iload_1
    //   288: istore_2
    //   289: iload_2
    //   290: iconst_3
    //   291: if_icmple +1056 -> 1347
    //   294: aload_0
    //   295: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   298: aload_0
    //   299: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   302: iconst_3
    //   303: bipush 105
    //   305: invokevirtual 123	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   308: aload_0
    //   309: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   312: aconst_null
    //   313: putfield 177	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:CheckKey	[B
    //   316: aload_0
    //   317: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   320: aconst_null
    //   321: putfield 180	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   324: return
    //   325: astore 10
    //   327: aload_0
    //   328: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   331: aload_0
    //   332: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   335: iconst_3
    //   336: sipush 201
    //   339: invokevirtual 123	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   342: return
    //   343: astore 10
    //   345: aload 10
    //   347: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   350: goto -67 -> 283
    //   353: astore 11
    //   355: aload 11
    //   357: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   360: aload_0
    //   361: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   364: aload_0
    //   365: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   368: iconst_3
    //   369: sipush 203
    //   372: invokevirtual 123	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   375: aload 10
    //   377: invokevirtual 173	java/io/FileInputStream:close	()V
    //   380: return
    //   381: astore 10
    //   383: aload 10
    //   385: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   388: return
    //   389: astore 11
    //   391: aload 10
    //   393: invokevirtual 173	java/io/FileInputStream:close	()V
    //   396: aload 11
    //   398: athrow
    //   399: astore 10
    //   401: aload 10
    //   403: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   406: goto -10 -> 396
    //   409: aload_0
    //   410: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   413: getfield 177	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:CheckKey	[B
    //   416: arraylength
    //   417: iconst_2
    //   418: iadd
    //   419: iconst_2
    //   420: iadd
    //   421: aload_0
    //   422: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   425: getfield 183	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   428: arraylength
    //   429: iadd
    //   430: bipush 20
    //   432: iadd
    //   433: iload_2
    //   434: iadd
    //   435: istore 4
    //   437: new 185	java/io/ByteArrayOutputStream
    //   440: dup
    //   441: iload 4
    //   443: bipush 16
    //   445: iadd
    //   446: invokespecial 188	java/io/ByteArrayOutputStream:<init>	(I)V
    //   449: astore 10
    //   451: new 190	java/io/DataOutputStream
    //   454: dup
    //   455: aload 10
    //   457: invokespecial 193	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   460: astore 12
    //   462: aload 12
    //   464: ldc 194
    //   466: invokevirtual 197	java/io/DataOutputStream:writeInt	(I)V
    //   469: aload 12
    //   471: sipush 1007
    //   474: invokevirtual 197	java/io/DataOutputStream:writeInt	(I)V
    //   477: aload 12
    //   479: iconst_0
    //   480: invokevirtual 197	java/io/DataOutputStream:writeInt	(I)V
    //   483: aload 12
    //   485: iload 4
    //   487: invokevirtual 197	java/io/DataOutputStream:writeInt	(I)V
    //   490: aload 12
    //   492: aload_0
    //   493: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   496: getfield 177	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:CheckKey	[B
    //   499: arraylength
    //   500: invokevirtual 200	java/io/DataOutputStream:writeShort	(I)V
    //   503: aload 12
    //   505: aload_0
    //   506: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   509: getfield 177	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:CheckKey	[B
    //   512: invokevirtual 203	java/io/DataOutputStream:write	([B)V
    //   515: aload 12
    //   517: aload_0
    //   518: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   521: getfield 183	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   524: arraylength
    //   525: invokevirtual 200	java/io/DataOutputStream:writeShort	(I)V
    //   528: aload 12
    //   530: aload_0
    //   531: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   534: getfield 183	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   537: invokevirtual 203	java/io/DataOutputStream:write	([B)V
    //   540: aload 12
    //   542: aload_0
    //   543: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   546: getfield 154	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   549: ldc2_w 204
    //   552: land
    //   553: l2i
    //   554: invokevirtual 197	java/io/DataOutputStream:writeInt	(I)V
    //   557: aload 12
    //   559: aload_0
    //   560: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   563: getfield 162	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   566: ldc2_w 204
    //   569: land
    //   570: l2i
    //   571: invokevirtual 197	java/io/DataOutputStream:writeInt	(I)V
    //   574: aload 12
    //   576: iload_2
    //   577: invokevirtual 197	java/io/DataOutputStream:writeInt	(I)V
    //   580: aload 12
    //   582: aload_0
    //   583: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   586: getfield 154	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   589: bipush 32
    //   591: lshr
    //   592: l2i
    //   593: invokevirtual 197	java/io/DataOutputStream:writeInt	(I)V
    //   596: aload 12
    //   598: aload_0
    //   599: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   602: getfield 162	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   605: bipush 32
    //   607: lshr
    //   608: l2i
    //   609: invokevirtual 197	java/io/DataOutputStream:writeInt	(I)V
    //   612: aload 12
    //   614: aload 14
    //   616: iconst_0
    //   617: iload_2
    //   618: invokevirtual 208	java/io/DataOutputStream:write	([BII)V
    //   621: aload 10
    //   623: invokevirtual 212	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   626: astore 14
    //   628: aload 10
    //   630: invokevirtual 213	java/io/ByteArrayOutputStream:close	()V
    //   633: aload 12
    //   635: invokevirtual 214	java/io/DataOutputStream:close	()V
    //   638: aconst_null
    //   639: astore 10
    //   641: aconst_null
    //   642: astore 12
    //   644: aload 11
    //   646: ifnull +188 -> 834
    //   649: aload 12
    //   651: astore 10
    //   653: aload 11
    //   655: invokeinterface 220 1 0
    //   660: ifle +174 -> 834
    //   663: aload 11
    //   665: iconst_0
    //   666: invokeinterface 224 2 0
    //   671: checkcast 226	mqq/manager/ProxyIpManager$ProxyIp
    //   674: astore 12
    //   676: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   679: ifeq +37 -> 716
    //   682: ldc 131
    //   684: iconst_2
    //   685: ldc 231
    //   687: iconst_2
    //   688: anewarray 233	java/lang/Object
    //   691: dup
    //   692: iconst_0
    //   693: aload 12
    //   695: getfield 236	mqq/manager/ProxyIpManager$ProxyIp:ip	Ljava/lang/String;
    //   698: aastore
    //   699: dup
    //   700: iconst_1
    //   701: aload 12
    //   703: getfield 240	mqq/manager/ProxyIpManager$ProxyIp:port	I
    //   706: invokestatic 246	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   709: aastore
    //   710: invokestatic 252	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   713: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   716: ldc 254
    //   718: iconst_5
    //   719: anewarray 233	java/lang/Object
    //   722: dup
    //   723: iconst_0
    //   724: aload 12
    //   726: getfield 236	mqq/manager/ProxyIpManager$ProxyIp:ip	Ljava/lang/String;
    //   729: aastore
    //   730: dup
    //   731: iconst_1
    //   732: aload_0
    //   733: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   736: getfield 162	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   739: invokestatic 259	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   742: aastore
    //   743: dup
    //   744: iconst_2
    //   745: aload_0
    //   746: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   749: getfield 162	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   752: iload_2
    //   753: i2l
    //   754: ladd
    //   755: invokestatic 259	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   758: aastore
    //   759: dup
    //   760: iconst_3
    //   761: aload_0
    //   762: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   765: getfield 180	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   768: aastore
    //   769: dup
    //   770: iconst_4
    //   771: bipush 80
    //   773: invokestatic 246	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   776: aastore
    //   777: invokestatic 252	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   780: astore 10
    //   782: aload_0
    //   783: iconst_0
    //   784: aload 12
    //   786: getfield 240	mqq/manager/ProxyIpManager$ProxyIp:port	I
    //   789: sipush 10000
    //   792: sipush 20000
    //   795: invokestatic 264	com/dataline/util/HttpUtil:a	(ZIII)Lorg/apache/http/client/HttpClient;
    //   798: aload 10
    //   800: aload 14
    //   802: invokespecial 266	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:a	(Lorg/apache/http/client/HttpClient;Ljava/lang/String;[B)Lorg/apache/http/HttpResponse;
    //   805: astore 10
    //   807: aload 10
    //   809: ifnull +170 -> 979
    //   812: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   815: ifeq +624 -> 1439
    //   818: ldc 131
    //   820: iconst_2
    //   821: ldc_w 268
    //   824: iconst_0
    //   825: anewarray 233	java/lang/Object
    //   828: invokestatic 252	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   831: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   834: aload 10
    //   836: astore 12
    //   838: aload 10
    //   840: ifnonnull +222 -> 1062
    //   843: invokestatic 271	com/dataline/util/HttpUtil:a	()Lcom/dataline/util/HttpUtil$NetworkProxy;
    //   846: ifnull +609 -> 1455
    //   849: iconst_1
    //   850: istore 5
    //   852: aload_0
    //   853: iconst_0
    //   854: iload 5
    //   856: sipush 10000
    //   859: sipush 20000
    //   862: invokestatic 274	com/dataline/util/HttpUtil:a	(ZZII)Lorg/apache/http/client/HttpClient;
    //   865: ldc_w 276
    //   868: iconst_3
    //   869: anewarray 233	java/lang/Object
    //   872: dup
    //   873: iconst_0
    //   874: aload_0
    //   875: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   878: getfield 180	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   881: aastore
    //   882: dup
    //   883: iconst_1
    //   884: aload_0
    //   885: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   888: getfield 162	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   891: invokestatic 259	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   894: aastore
    //   895: dup
    //   896: iconst_2
    //   897: aload_0
    //   898: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   901: getfield 162	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   904: iload_2
    //   905: i2l
    //   906: ladd
    //   907: invokestatic 259	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   910: aastore
    //   911: invokestatic 252	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   914: aload 14
    //   916: invokespecial 266	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:a	(Lorg/apache/http/client/HttpClient;Ljava/lang/String;[B)Lorg/apache/http/HttpResponse;
    //   919: astore 10
    //   921: aload 10
    //   923: ifnonnull +109 -> 1032
    //   926: goto -864 -> 62
    //   929: astore 11
    //   931: aload 11
    //   933: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   936: aload_0
    //   937: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   940: aload_0
    //   941: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   944: iconst_3
    //   945: bipush 102
    //   947: invokevirtual 123	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   950: aload 10
    //   952: invokevirtual 213	java/io/ByteArrayOutputStream:close	()V
    //   955: aload 12
    //   957: invokevirtual 214	java/io/DataOutputStream:close	()V
    //   960: return
    //   961: astore 10
    //   963: return
    //   964: astore 11
    //   966: aload 10
    //   968: invokevirtual 213	java/io/ByteArrayOutputStream:close	()V
    //   971: aload 12
    //   973: invokevirtual 214	java/io/DataOutputStream:close	()V
    //   976: aload 11
    //   978: athrow
    //   979: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   982: ifeq +38 -> 1020
    //   985: ldc 131
    //   987: iconst_2
    //   988: ldc_w 278
    //   991: iconst_2
    //   992: anewarray 233	java/lang/Object
    //   995: dup
    //   996: iconst_0
    //   997: aload 12
    //   999: getfield 236	mqq/manager/ProxyIpManager$ProxyIp:ip	Ljava/lang/String;
    //   1002: aastore
    //   1003: dup
    //   1004: iconst_1
    //   1005: aload 12
    //   1007: getfield 240	mqq/manager/ProxyIpManager$ProxyIp:port	I
    //   1010: invokestatic 246	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1013: aastore
    //   1014: invokestatic 252	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1017: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1020: aload 11
    //   1022: iconst_0
    //   1023: invokeinterface 281 2 0
    //   1028: pop
    //   1029: goto -376 -> 653
    //   1032: aload 10
    //   1034: astore 12
    //   1036: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1039: ifeq +23 -> 1062
    //   1042: ldc 131
    //   1044: iconst_2
    //   1045: ldc_w 283
    //   1048: iconst_0
    //   1049: anewarray 233	java/lang/Object
    //   1052: invokestatic 252	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1055: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1058: aload 10
    //   1060: astore 12
    //   1062: aload 12
    //   1064: invokeinterface 289 1 0
    //   1069: astore 10
    //   1071: aload 10
    //   1073: invokeinterface 294 1 0
    //   1078: sipush 200
    //   1081: if_icmpeq +128 -> 1209
    //   1084: aload 10
    //   1086: invokeinterface 294 1 0
    //   1091: sipush 206
    //   1094: if_icmpeq +115 -> 1209
    //   1097: aload 12
    //   1099: ldc_w 296
    //   1102: invokeinterface 300 2 0
    //   1107: astore 10
    //   1109: aload 10
    //   1111: ifnull +325 -> 1436
    //   1114: aload 10
    //   1116: invokeinterface 306 1 0
    //   1121: ifnull +315 -> 1436
    //   1124: aload 10
    //   1126: invokeinterface 306 1 0
    //   1131: ldc_w 308
    //   1134: invokevirtual 312	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1137: ifeq +8 -> 1145
    //   1140: iconst_4
    //   1141: istore_2
    //   1142: goto -853 -> 289
    //   1145: aload 10
    //   1147: invokeinterface 306 1 0
    //   1152: ldc_w 314
    //   1155: invokevirtual 312	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1158: ifne +35 -> 1193
    //   1161: aload 10
    //   1163: invokeinterface 306 1 0
    //   1168: ldc_w 316
    //   1171: invokevirtual 312	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1174: ifne +19 -> 1193
    //   1177: aload 10
    //   1179: invokeinterface 306 1 0
    //   1184: ldc_w 318
    //   1187: invokevirtual 312	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1190: ifeq +246 -> 1436
    //   1193: aload_0
    //   1194: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1197: aload_0
    //   1198: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1201: iconst_3
    //   1202: sipush 206
    //   1205: invokevirtual 123	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   1208: return
    //   1209: aload_0
    //   1210: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1213: iconst_0
    //   1214: aload 14
    //   1216: arraylength
    //   1217: i2l
    //   1218: invokevirtual 321	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(IJ)V
    //   1221: new 323	java/io/DataInputStream
    //   1224: dup
    //   1225: aload 12
    //   1227: invokeinterface 327 1 0
    //   1232: invokeinterface 333 1 0
    //   1237: invokespecial 336	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   1240: astore 10
    //   1242: aload 10
    //   1244: ldc2_w 337
    //   1247: invokevirtual 339	java/io/DataInputStream:skip	(J)J
    //   1250: pop2
    //   1251: aload 10
    //   1253: invokevirtual 343	java/io/DataInputStream:readByte	()B
    //   1256: ifeq +8 -> 1264
    //   1259: iconst_0
    //   1260: istore_2
    //   1261: goto -972 -> 289
    //   1264: aload 10
    //   1266: invokevirtual 346	java/io/DataInputStream:readInt	()I
    //   1269: i2l
    //   1270: lstore 6
    //   1272: aload 10
    //   1274: invokevirtual 346	java/io/DataInputStream:readInt	()I
    //   1277: i2l
    //   1278: lstore 8
    //   1280: aload 12
    //   1282: invokeinterface 327 1 0
    //   1287: invokeinterface 349 1 0
    //   1292: aload_0
    //   1293: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1296: lload 8
    //   1298: bipush 32
    //   1300: lshl
    //   1301: lload 6
    //   1303: ldc2_w 350
    //   1306: land
    //   1307: lor
    //   1308: putfield 162	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1311: aload_0
    //   1312: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1315: aload_0
    //   1316: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1319: invokevirtual 354	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   1322: iconst_0
    //   1323: istore_1
    //   1324: goto -1262 -> 62
    //   1327: astore 10
    //   1329: aload 10
    //   1331: invokevirtual 355	java/lang/IllegalStateException:printStackTrace	()V
    //   1334: goto -1272 -> 62
    //   1337: astore 10
    //   1339: aload 10
    //   1341: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   1344: goto -1282 -> 62
    //   1347: aload_0
    //   1348: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1351: aload_0
    //   1352: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1355: getfield 154	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1358: putfield 162	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1361: aload_0
    //   1362: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1365: aload_0
    //   1366: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1369: bipush 6
    //   1371: invokevirtual 358	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)V
    //   1374: aload_0
    //   1375: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1378: aload_0
    //   1379: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1382: invokevirtual 360	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:d	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   1385: aload_0
    //   1386: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1389: aconst_null
    //   1390: putfield 363	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Md5	[B
    //   1393: aload_0
    //   1394: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1397: aconst_null
    //   1398: putfield 183	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   1401: aload_0
    //   1402: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1405: aload_0
    //   1406: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1409: aload_0
    //   1410: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1413: getfield 365	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:g	J
    //   1416: invokevirtual 369	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;
    //   1419: iconst_1
    //   1420: invokevirtual 372	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;Z)V
    //   1423: goto -1115 -> 308
    //   1426: astore 10
    //   1428: goto -452 -> 976
    //   1431: astore 10
    //   1433: goto -795 -> 638
    //   1436: goto -1374 -> 62
    //   1439: goto -605 -> 834
    //   1442: aconst_null
    //   1443: astore 11
    //   1445: goto -1389 -> 56
    //   1448: iload_2
    //   1449: iconst_1
    //   1450: iadd
    //   1451: istore_2
    //   1452: goto -1317 -> 135
    //   1455: iconst_0
    //   1456: istore 5
    //   1458: goto -606 -> 852
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1461	0	this	TaskHttpUpload
    //   57	1267	1	i	int
    //   63	1389	2	j	int
    //   61	185	3	k	int
    //   435	51	4	m	int
    //   850	607	5	bool	boolean
    //   1270	32	6	l1	long
    //   1278	19	8	l2	long
    //   97	17	10	localInterruptedException	java.lang.InterruptedException
    //   255	24	10	localFileInputStream	java.io.FileInputStream
    //   325	1	10	localFileNotFoundException	java.io.FileNotFoundException
    //   343	33	10	localIOException1	IOException
    //   381	11	10	localIOException2	IOException
    //   399	3	10	localIOException3	IOException
    //   449	502	10	localObject1	java.lang.Object
    //   961	98	10	localException1	java.lang.Exception
    //   1069	204	10	localObject2	java.lang.Object
    //   1327	3	10	localIllegalStateException	java.lang.IllegalStateException
    //   1337	3	10	localIOException4	IOException
    //   1426	1	10	localException2	java.lang.Exception
    //   1431	1	10	localException3	java.lang.Exception
    //   54	1	11	localList	java.util.List
    //   353	3	11	localIOException5	IOException
    //   389	275	11	localObject3	java.lang.Object
    //   929	3	11	localIOException6	IOException
    //   964	57	11	localObject4	java.lang.Object
    //   1443	1	11	localObject5	java.lang.Object
    //   460	821	12	localObject6	java.lang.Object
    //   29	222	13	localFile	java.io.File
    //   240	975	14	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   73	96	97	java/lang/InterruptedException
    //   143	186	97	java/lang/InterruptedException
    //   187	232	97	java/lang/InterruptedException
    //   237	242	97	java/lang/InterruptedException
    //   246	257	97	java/lang/InterruptedException
    //   278	283	97	java/lang/InterruptedException
    //   327	342	97	java/lang/InterruptedException
    //   345	350	97	java/lang/InterruptedException
    //   375	380	97	java/lang/InterruptedException
    //   383	388	97	java/lang/InterruptedException
    //   391	396	97	java/lang/InterruptedException
    //   396	399	97	java/lang/InterruptedException
    //   401	406	97	java/lang/InterruptedException
    //   409	462	97	java/lang/InterruptedException
    //   628	638	97	java/lang/InterruptedException
    //   653	716	97	java/lang/InterruptedException
    //   716	807	97	java/lang/InterruptedException
    //   812	834	97	java/lang/InterruptedException
    //   843	849	97	java/lang/InterruptedException
    //   852	921	97	java/lang/InterruptedException
    //   950	960	97	java/lang/InterruptedException
    //   966	976	97	java/lang/InterruptedException
    //   976	979	97	java/lang/InterruptedException
    //   979	1020	97	java/lang/InterruptedException
    //   1020	1029	97	java/lang/InterruptedException
    //   1036	1058	97	java/lang/InterruptedException
    //   1062	1109	97	java/lang/InterruptedException
    //   1114	1140	97	java/lang/InterruptedException
    //   1145	1193	97	java/lang/InterruptedException
    //   1193	1208	97	java/lang/InterruptedException
    //   1209	1221	97	java/lang/InterruptedException
    //   1221	1259	97	java/lang/InterruptedException
    //   1264	1322	97	java/lang/InterruptedException
    //   1329	1334	97	java/lang/InterruptedException
    //   1339	1344	97	java/lang/InterruptedException
    //   246	257	325	java/io/FileNotFoundException
    //   278	283	343	java/io/IOException
    //   257	278	353	java/io/IOException
    //   375	380	381	java/io/IOException
    //   257	278	389	finally
    //   355	375	389	finally
    //   391	396	399	java/io/IOException
    //   462	628	929	java/io/IOException
    //   950	960	961	java/lang/Exception
    //   462	628	964	finally
    //   931	950	964	finally
    //   1221	1259	1327	java/lang/IllegalStateException
    //   1264	1322	1327	java/lang/IllegalStateException
    //   1221	1259	1337	java/io/IOException
    //   1264	1322	1337	java/io/IOException
    //   966	976	1426	java/lang/Exception
    //   628	638	1431	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskHttpUpload
 * JD-Core Version:    0.7.0.1
 */