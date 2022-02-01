package com.tencent.biz.pubaccount.readinjoy.common;

import android.os.Bundle;
import kxw;

public class ThirdVideoManager$1$1
  implements Runnable
{
  public ThirdVideoManager$1$1(kxw paramkxw, boolean paramBoolean, Bundle paramBundle) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 33	java/lang/System:currentTimeMillis	()J
    //   3: aload_0
    //   4: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:a	Lkxw;
    //   7: getfield 39	kxw:td	J
    //   10: lsub
    //   11: lstore_3
    //   12: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +40 -> 55
    //   18: ldc 47
    //   20: iconst_2
    //   21: new 49	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   28: ldc 52
    //   30: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: lload_3
    //   34: invokevirtual 59	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   37: ldc 61
    //   39: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: getfield 18	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:val$isSuccess	Z
    //   46: invokevirtual 64	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   49: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: iconst_m1
    //   56: istore_1
    //   57: ldc 74
    //   59: astore 8
    //   61: aload_0
    //   62: getfield 18	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:val$isSuccess	Z
    //   65: istore 5
    //   67: new 76	kxz
    //   70: dup
    //   71: invokespecial 77	kxz:<init>	()V
    //   74: astore 10
    //   76: aload 10
    //   78: aload_0
    //   79: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:a	Lkxw;
    //   82: getfield 81	kxw:val$vid	Ljava/lang/String;
    //   85: putfield 84	kxz:vid	Ljava/lang/String;
    //   88: aload_0
    //   89: getfield 18	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:val$isSuccess	Z
    //   92: ifeq +1196 -> 1288
    //   95: aload_0
    //   96: getfield 20	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:val$bundle	Landroid/os/Bundle;
    //   99: ldc 86
    //   101: invokevirtual 92	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   104: astore 9
    //   106: aload 9
    //   108: ifnull +1174 -> 1282
    //   111: aload 9
    //   113: arraylength
    //   114: iflt +1168 -> 1282
    //   117: new 94	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse
    //   120: dup
    //   121: invokespecial 95	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:<init>	()V
    //   124: astore 11
    //   126: aload 11
    //   128: aload 9
    //   130: invokevirtual 99	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   133: pop
    //   134: aload 11
    //   136: getfield 103	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:ret_info	Lcom/tencent/mobileqq/ac/ArticleCenter$RetInfo;
    //   139: getfield 109	com/tencent/mobileqq/ac/ArticleCenter$RetInfo:ret_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   142: invokevirtual 115	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   145: istore_2
    //   146: aload 11
    //   148: getfield 103	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:ret_info	Lcom/tencent/mobileqq/ac/ArticleCenter$RetInfo;
    //   151: getfield 119	com/tencent/mobileqq/ac/ArticleCenter$RetInfo:err_info	Lcom/tencent/mobileqq/pb/PBStringField;
    //   154: invokevirtual 123	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   157: astore 9
    //   159: iload_2
    //   160: ifne +1100 -> 1260
    //   163: aload 11
    //   165: getfield 127	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   168: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   171: astore 8
    //   173: aload 8
    //   175: ifnull +13 -> 188
    //   178: aload 10
    //   180: aload 8
    //   182: invokevirtual 137	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   185: putfield 139	kxz:url	Ljava/lang/String;
    //   188: aload 10
    //   190: iload_2
    //   191: putfield 143	kxz:errorCode	I
    //   194: aload 10
    //   196: aload 11
    //   198: getfield 146	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:video_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   201: invokevirtual 115	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   204: putfield 149	kxz:videoType	I
    //   207: aload 11
    //   209: getfield 152	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:encode_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   212: invokevirtual 115	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   215: iconst_1
    //   216: if_icmpne +755 -> 971
    //   219: iconst_1
    //   220: istore 6
    //   222: aload 10
    //   224: iload 6
    //   226: putfield 155	kxz:aiJ	Z
    //   229: aload 10
    //   231: aload 11
    //   233: getfield 158	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   236: invokevirtual 115	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   239: putfield 160	kxz:width	I
    //   242: aload 10
    //   244: aload 11
    //   246: getfield 163	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   249: invokevirtual 115	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   252: putfield 165	kxz:height	I
    //   255: aload 10
    //   257: getfield 155	kxz:aiJ	Z
    //   260: ifeq +20 -> 280
    //   263: aload 10
    //   265: aload_0
    //   266: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:a	Lkxw;
    //   269: getfield 169	kxw:b	Lkxv;
    //   272: aload 11
    //   274: invokestatic 174	kxv:a	(Lkxv;Lcom/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse;)Ljava/lang/String;
    //   277: putfield 177	kxz:adF	Ljava/lang/String;
    //   280: aload 11
    //   282: getfield 180	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:json_video_detail	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   285: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   288: astore 8
    //   290: aload 8
    //   292: ifnull +1353 -> 1645
    //   295: aload 11
    //   297: getfield 180	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:json_video_detail	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   300: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   303: invokevirtual 137	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   306: astore 8
    //   308: new 182	org/json/JSONObject
    //   311: dup
    //   312: aload 8
    //   314: invokespecial 185	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   317: astore 12
    //   319: aload 10
    //   321: getfield 155	kxz:aiJ	Z
    //   324: ifeq +16 -> 340
    //   327: aload 10
    //   329: aload 12
    //   331: ldc 187
    //   333: iconst_1
    //   334: invokevirtual 191	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   337: putfield 194	kxz:Tx	Z
    //   340: aload 10
    //   342: aload 12
    //   344: ldc 196
    //   346: ldc 74
    //   348: invokevirtual 200	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   351: putfield 203	kxz:videoReportInfo	Ljava/lang/String;
    //   354: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   357: ifeq +29 -> 386
    //   360: ldc 47
    //   362: iconst_2
    //   363: new 49	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   370: ldc 205
    //   372: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: aload 8
    //   377: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   386: iconst_0
    //   387: istore_1
    //   388: aload 11
    //   390: getfield 209	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   393: invokevirtual 214	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   396: ifeq +595 -> 991
    //   399: aload 11
    //   401: getfield 209	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   404: invokevirtual 217	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   407: ifnull +584 -> 991
    //   410: aload 11
    //   412: getfield 209	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   415: invokevirtual 217	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   418: astore 8
    //   420: aload 8
    //   422: invokeinterface 222 1 0
    //   427: ifle +564 -> 991
    //   430: aload 8
    //   432: invokeinterface 226 1 0
    //   437: astore 12
    //   439: aload 12
    //   441: invokeinterface 231 1 0
    //   446: ifeq +545 -> 991
    //   449: aload 12
    //   451: invokeinterface 235 1 0
    //   456: checkcast 237	com/tencent/mobileqq/ac/ArticleCenter$VideoInfo
    //   459: astore 13
    //   461: new 76	kxz
    //   464: dup
    //   465: invokespecial 77	kxz:<init>	()V
    //   468: astore 14
    //   470: aload 14
    //   472: aload_0
    //   473: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:a	Lkxw;
    //   476: getfield 81	kxw:val$vid	Ljava/lang/String;
    //   479: putfield 84	kxz:vid	Ljava/lang/String;
    //   482: aload 13
    //   484: getfield 238	com/tencent/mobileqq/ac/ArticleCenter$VideoInfo:url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   487: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   490: ifnull +494 -> 984
    //   493: aload 13
    //   495: getfield 238	com/tencent/mobileqq/ac/ArticleCenter$VideoInfo:url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   498: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   501: invokevirtual 137	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   504: astore 8
    //   506: aload 14
    //   508: aload 8
    //   510: putfield 139	kxz:url	Ljava/lang/String;
    //   513: aload 13
    //   515: getfield 239	com/tencent/mobileqq/ac/ArticleCenter$VideoInfo:encode_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   518: invokevirtual 115	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   521: iconst_1
    //   522: if_icmpne +1128 -> 1650
    //   525: iconst_1
    //   526: istore 6
    //   528: aload 14
    //   530: iload 6
    //   532: putfield 155	kxz:aiJ	Z
    //   535: aload 13
    //   537: getfield 242	com/tencent/mobileqq/ac/ArticleCenter$VideoInfo:rate	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   540: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   543: ifnull +1113 -> 1656
    //   546: aload 13
    //   548: getfield 242	com/tencent/mobileqq/ac/ArticleCenter$VideoInfo:rate	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   551: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   554: invokevirtual 137	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   557: astore 8
    //   559: aload 14
    //   561: aload 8
    //   563: putfield 245	kxz:adD	Ljava/lang/String;
    //   566: aload 14
    //   568: aload 13
    //   570: getfield 246	com/tencent/mobileqq/ac/ArticleCenter$VideoInfo:width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   573: invokevirtual 115	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   576: putfield 160	kxz:width	I
    //   579: aload 14
    //   581: aload 13
    //   583: getfield 247	com/tencent/mobileqq/ac/ArticleCenter$VideoInfo:height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   586: invokevirtual 115	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   589: putfield 165	kxz:height	I
    //   592: aload 10
    //   594: getfield 251	kxz:ko	Ljava/util/ArrayList;
    //   597: aload 14
    //   599: invokevirtual 257	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   602: pop
    //   603: goto -164 -> 439
    //   606: astore 8
    //   608: bipush 254
    //   610: istore_1
    //   611: aload 8
    //   613: ifnonnull +659 -> 1272
    //   616: ldc 74
    //   618: astore 8
    //   620: iconst_0
    //   621: istore 5
    //   623: iload 5
    //   625: istore 7
    //   627: aload 8
    //   629: astore 9
    //   631: iload_1
    //   632: istore_2
    //   633: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   636: ifeq +117 -> 753
    //   639: ldc 47
    //   641: iconst_2
    //   642: new 49	java/lang/StringBuilder
    //   645: dup
    //   646: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   649: ldc_w 259
    //   652: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: aload 10
    //   657: getfield 149	kxz:videoType	I
    //   660: invokevirtual 262	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   663: ldc_w 264
    //   666: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: aload 10
    //   671: getfield 155	kxz:aiJ	Z
    //   674: invokevirtual 64	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   677: ldc_w 266
    //   680: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: aload 10
    //   685: getfield 139	kxz:url	Ljava/lang/String;
    //   688: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: ldc_w 268
    //   694: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: aload 10
    //   699: getfield 245	kxz:adD	Ljava/lang/String;
    //   702: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: ldc_w 270
    //   708: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: iload_1
    //   712: invokevirtual 262	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   715: ldc_w 272
    //   718: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: aload 8
    //   723: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: ldc_w 274
    //   729: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   732: iload 5
    //   734: invokevirtual 64	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   737: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   740: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   743: iload_1
    //   744: istore_2
    //   745: aload 8
    //   747: astore 9
    //   749: iload 5
    //   751: istore 7
    //   753: aload_0
    //   754: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:a	Lkxw;
    //   757: getfield 277	kxw:a	Lkxv$a;
    //   760: ifnull +771 -> 1531
    //   763: aload 10
    //   765: getfield 149	kxz:videoType	I
    //   768: ifne +544 -> 1312
    //   771: aload 10
    //   773: getfield 139	kxz:url	Ljava/lang/String;
    //   776: invokestatic 283	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   779: ifne +860 -> 1639
    //   782: aload 10
    //   784: invokestatic 286	kxv:a	(Lkxz;)V
    //   787: iconst_1
    //   788: istore 5
    //   790: iload 5
    //   792: ifeq +545 -> 1337
    //   795: aload_0
    //   796: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:a	Lkxw;
    //   799: getfield 277	kxw:a	Lkxv$a;
    //   802: aload 10
    //   804: invokeinterface 290 2 0
    //   809: aload_0
    //   810: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:a	Lkxw;
    //   813: getfield 169	kxw:b	Lkxv;
    //   816: invokestatic 293	kxv:a	(Lkxv;)Ljava/lang/Object;
    //   819: astore 8
    //   821: aload 8
    //   823: monitorenter
    //   824: aload_0
    //   825: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:a	Lkxw;
    //   828: getfield 169	kxw:b	Lkxv;
    //   831: invokestatic 296	kxv:a	(Lkxv;)Ljava/util/ArrayList;
    //   834: aload_0
    //   835: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:a	Lkxw;
    //   838: getfield 81	kxw:val$vid	Ljava/lang/String;
    //   841: invokevirtual 299	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   844: istore 6
    //   846: iload 6
    //   848: ifeq +24 -> 872
    //   851: aload_0
    //   852: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:a	Lkxw;
    //   855: getfield 169	kxw:b	Lkxv;
    //   858: invokestatic 296	kxv:a	(Lkxv;)Ljava/util/ArrayList;
    //   861: aload_0
    //   862: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:a	Lkxw;
    //   865: getfield 81	kxw:val$vid	Ljava/lang/String;
    //   868: invokevirtual 302	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   871: pop
    //   872: aload 8
    //   874: monitorexit
    //   875: iconst_0
    //   876: istore 6
    //   878: new 304	mio
    //   881: dup
    //   882: invokespecial 305	mio:<init>	()V
    //   885: astore 8
    //   887: aload 8
    //   889: iload 5
    //   891: putfield 308	mio:success	Z
    //   894: aload 8
    //   896: aload_0
    //   897: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:a	Lkxw;
    //   900: getfield 81	kxw:val$vid	Ljava/lang/String;
    //   903: putfield 309	mio:vid	Ljava/lang/String;
    //   906: aload_0
    //   907: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:a	Lkxw;
    //   910: getfield 169	kxw:b	Lkxv;
    //   913: lload_3
    //   914: invokestatic 315	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   917: putfield 319	kxv:r	Ljava/lang/Long;
    //   920: aload 8
    //   922: lload_3
    //   923: putfield 322	mio:costTime	J
    //   926: aload 8
    //   928: iload_2
    //   929: i2l
    //   930: putfield 325	mio:vW	J
    //   933: aload 8
    //   935: aload 9
    //   937: putfield 328	mio:aiT	Ljava/lang/String;
    //   940: aload 8
    //   942: iload 6
    //   944: putfield 331	mio:amQ	Z
    //   947: aload_0
    //   948: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:a	Lkxw;
    //   951: getfield 335	kxw:val$app	Lmqq/app/AppRuntime;
    //   954: invokevirtual 341	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   957: invokestatic 346	kxm:getAccount	()Ljava/lang/String;
    //   960: iload 7
    //   962: aload 8
    //   964: invokevirtual 350	mio:u	()Ljava/util/HashMap;
    //   967: invokestatic 354	kxm:c	(Landroid/content/Context;Ljava/lang/String;ZLjava/util/HashMap;)V
    //   970: return
    //   971: iconst_0
    //   972: istore 6
    //   974: goto -752 -> 222
    //   977: astore 8
    //   979: iconst_1
    //   980: istore_1
    //   981: goto -593 -> 388
    //   984: ldc 74
    //   986: astore 8
    //   988: goto -482 -> 506
    //   991: aload 10
    //   993: getfield 155	kxz:aiJ	Z
    //   996: ifeq +74 -> 1070
    //   999: new 356	java/util/HashMap
    //   1002: dup
    //   1003: invokespecial 357	java/util/HashMap:<init>	()V
    //   1006: astore 12
    //   1008: iload_1
    //   1009: ifeq +663 -> 1672
    //   1012: ldc_w 359
    //   1015: astore 8
    //   1017: aload 12
    //   1019: ldc_w 361
    //   1022: aload 8
    //   1024: invokevirtual 365	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1027: pop
    //   1028: aload 11
    //   1030: getfield 180	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:json_video_detail	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1033: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1036: ifnull +210 -> 1246
    //   1039: aload 12
    //   1041: ldc_w 367
    //   1044: aload 11
    //   1046: getfield 180	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:json_video_detail	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1049: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1052: invokevirtual 137	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1055: invokevirtual 365	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1058: pop
    //   1059: invokestatic 373	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1062: invokestatic 346	kxm:getAccount	()Ljava/lang/String;
    //   1065: aload 12
    //   1067: invokestatic 376	kxm:a	(Landroid/content/Context;Ljava/lang/String;Ljava/util/HashMap;)V
    //   1070: aconst_null
    //   1071: astore 8
    //   1073: aload 11
    //   1075: getfield 180	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:json_video_detail	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1078: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1081: ifnull +16 -> 1097
    //   1084: aload 11
    //   1086: getfield 180	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:json_video_detail	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1089: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1092: invokevirtual 137	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1095: astore 8
    //   1097: aconst_null
    //   1098: aconst_null
    //   1099: ldc_w 378
    //   1102: ldc_w 378
    //   1105: iconst_0
    //   1106: iconst_0
    //   1107: iconst_0
    //   1108: invokestatic 384	msz:h	(Z)Ljava/lang/String;
    //   1111: ldc_w 386
    //   1114: invokestatic 391	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1117: aload 10
    //   1119: getfield 203	kxz:videoReportInfo	Ljava/lang/String;
    //   1122: aload 8
    //   1124: iconst_0
    //   1125: invokestatic 396	kbp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1128: new 182	org/json/JSONObject
    //   1131: dup
    //   1132: invokespecial 397	org/json/JSONObject:<init>	()V
    //   1135: astore 8
    //   1137: aload 8
    //   1139: ldc_w 398
    //   1142: aload 10
    //   1144: getfield 84	kxz:vid	Ljava/lang/String;
    //   1147: invokevirtual 401	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1150: pop
    //   1151: aload 8
    //   1153: ldc_w 403
    //   1156: aload 10
    //   1158: getfield 155	kxz:aiJ	Z
    //   1161: invokevirtual 406	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   1164: pop
    //   1165: aload 8
    //   1167: ldc_w 407
    //   1170: aload 10
    //   1172: getfield 139	kxz:url	Ljava/lang/String;
    //   1175: invokevirtual 401	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1178: pop
    //   1179: aload 8
    //   1181: ldc_w 409
    //   1184: aload 10
    //   1186: getfield 177	kxz:adF	Ljava/lang/String;
    //   1189: invokevirtual 401	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1192: pop
    //   1193: aconst_null
    //   1194: aconst_null
    //   1195: ldc_w 411
    //   1198: ldc_w 411
    //   1201: iconst_0
    //   1202: iconst_0
    //   1203: ldc 74
    //   1205: ldc 74
    //   1207: ldc 74
    //   1209: aload 8
    //   1211: invokevirtual 412	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1214: iconst_0
    //   1215: invokestatic 396	kbp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1218: aload 11
    //   1220: getfield 413	com/tencent/mobileqq/ac/ArticleCenter$GetUrlByVidResponse:rate	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1223: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1226: astore 8
    //   1228: aload 8
    //   1230: ifnull +433 -> 1663
    //   1233: aload 10
    //   1235: aload 8
    //   1237: invokevirtual 137	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1240: putfield 245	kxz:adD	Ljava/lang/String;
    //   1243: goto +420 -> 1663
    //   1246: aload 12
    //   1248: ldc_w 367
    //   1251: ldc 74
    //   1253: invokevirtual 365	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1256: pop
    //   1257: goto -198 -> 1059
    //   1260: aload 10
    //   1262: iload_2
    //   1263: putfield 143	kxz:errorCode	I
    //   1266: iconst_0
    //   1267: istore 5
    //   1269: goto +394 -> 1663
    //   1272: aload 8
    //   1274: invokevirtual 416	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1277: astore 8
    //   1279: goto -659 -> 620
    //   1282: iconst_0
    //   1283: istore 5
    //   1285: goto -662 -> 623
    //   1288: aload_0
    //   1289: getfield 20	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:val$bundle	Landroid/os/Bundle;
    //   1292: ldc_w 418
    //   1295: bipush 253
    //   1297: invokevirtual 422	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   1300: istore_2
    //   1301: iload 5
    //   1303: istore 7
    //   1305: aload 8
    //   1307: astore 9
    //   1309: goto -556 -> 753
    //   1312: aload 10
    //   1314: getfield 139	kxz:url	Ljava/lang/String;
    //   1317: invokestatic 283	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1320: ifne +319 -> 1639
    //   1323: iconst_1
    //   1324: istore 5
    //   1326: goto -536 -> 790
    //   1329: astore 9
    //   1331: aload 8
    //   1333: monitorexit
    //   1334: aload 9
    //   1336: athrow
    //   1337: aload_0
    //   1338: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:a	Lkxw;
    //   1341: getfield 169	kxw:b	Lkxv;
    //   1344: invokestatic 293	kxv:a	(Lkxv;)Ljava/lang/Object;
    //   1347: astore 8
    //   1349: aload 8
    //   1351: monitorenter
    //   1352: aload_0
    //   1353: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:a	Lkxw;
    //   1356: getfield 169	kxw:b	Lkxv;
    //   1359: invokestatic 296	kxv:a	(Lkxv;)Ljava/util/ArrayList;
    //   1362: aload_0
    //   1363: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:a	Lkxw;
    //   1366: getfield 81	kxw:val$vid	Ljava/lang/String;
    //   1369: invokevirtual 299	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   1372: ifeq +63 -> 1435
    //   1375: aload_0
    //   1376: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:a	Lkxw;
    //   1379: getfield 277	kxw:a	Lkxv$a;
    //   1382: aload 10
    //   1384: invokeinterface 290 2 0
    //   1389: aload_0
    //   1390: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:a	Lkxw;
    //   1393: getfield 169	kxw:b	Lkxv;
    //   1396: invokestatic 296	kxv:a	(Lkxv;)Ljava/util/ArrayList;
    //   1399: aload_0
    //   1400: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:a	Lkxw;
    //   1403: getfield 81	kxw:val$vid	Ljava/lang/String;
    //   1406: invokevirtual 302	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   1409: pop
    //   1410: iconst_0
    //   1411: istore 6
    //   1413: aload 8
    //   1415: monitorexit
    //   1416: goto -538 -> 878
    //   1419: astore 9
    //   1421: aload 8
    //   1423: monitorexit
    //   1424: aload 9
    //   1426: athrow
    //   1427: astore 10
    //   1429: iconst_0
    //   1430: istore 6
    //   1432: goto -19 -> 1413
    //   1435: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1438: ifeq +35 -> 1473
    //   1441: ldc 47
    //   1443: iconst_2
    //   1444: new 49	java/lang/StringBuilder
    //   1447: dup
    //   1448: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   1451: ldc_w 424
    //   1454: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1457: aload_0
    //   1458: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:a	Lkxw;
    //   1461: getfield 81	kxw:val$vid	Ljava/lang/String;
    //   1464: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1467: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1470: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1473: aload_0
    //   1474: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:a	Lkxw;
    //   1477: getfield 169	kxw:b	Lkxv;
    //   1480: aload_0
    //   1481: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:a	Lkxw;
    //   1484: getfield 81	kxw:val$vid	Ljava/lang/String;
    //   1487: aload_0
    //   1488: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:a	Lkxw;
    //   1491: getfield 427	kxw:val$cmd	Ljava/lang/String;
    //   1494: aload_0
    //   1495: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:a	Lkxw;
    //   1498: getfield 277	kxw:a	Lkxv$a;
    //   1501: invokevirtual 430	kxv:a	(Ljava/lang/String;Ljava/lang/String;Lkxv$a;)V
    //   1504: aload_0
    //   1505: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:a	Lkxw;
    //   1508: getfield 169	kxw:b	Lkxv;
    //   1511: invokestatic 296	kxv:a	(Lkxv;)Ljava/util/ArrayList;
    //   1514: aload_0
    //   1515: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:a	Lkxw;
    //   1518: getfield 81	kxw:val$vid	Ljava/lang/String;
    //   1521: invokevirtual 257	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1524: pop
    //   1525: iconst_1
    //   1526: istore 6
    //   1528: goto -115 -> 1413
    //   1531: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1534: ifeq +12 -> 1546
    //   1537: ldc 47
    //   1539: iconst_2
    //   1540: ldc_w 432
    //   1543: invokestatic 435	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1546: aload_0
    //   1547: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:a	Lkxw;
    //   1550: getfield 169	kxw:b	Lkxv;
    //   1553: invokestatic 293	kxv:a	(Lkxv;)Ljava/lang/Object;
    //   1556: astore 8
    //   1558: aload 8
    //   1560: monitorenter
    //   1561: aload_0
    //   1562: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:a	Lkxw;
    //   1565: getfield 169	kxw:b	Lkxv;
    //   1568: invokestatic 296	kxv:a	(Lkxv;)Ljava/util/ArrayList;
    //   1571: aload_0
    //   1572: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:a	Lkxw;
    //   1575: getfield 81	kxw:val$vid	Ljava/lang/String;
    //   1578: invokevirtual 299	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   1581: istore 5
    //   1583: iload 5
    //   1585: ifeq +24 -> 1609
    //   1588: aload_0
    //   1589: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:a	Lkxw;
    //   1592: getfield 169	kxw:b	Lkxv;
    //   1595: invokestatic 296	kxv:a	(Lkxv;)Ljava/util/ArrayList;
    //   1598: aload_0
    //   1599: getfield 16	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager$1$1:a	Lkxw;
    //   1602: getfield 81	kxw:val$vid	Ljava/lang/String;
    //   1605: invokevirtual 302	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   1608: pop
    //   1609: aload 8
    //   1611: monitorexit
    //   1612: iconst_0
    //   1613: istore 6
    //   1615: iconst_0
    //   1616: istore 5
    //   1618: goto -740 -> 878
    //   1621: astore 9
    //   1623: aload 8
    //   1625: monitorexit
    //   1626: aload 9
    //   1628: athrow
    //   1629: astore 10
    //   1631: goto -22 -> 1609
    //   1634: astore 10
    //   1636: goto -764 -> 872
    //   1639: iconst_0
    //   1640: istore 5
    //   1642: goto -852 -> 790
    //   1645: iconst_0
    //   1646: istore_1
    //   1647: goto -1259 -> 388
    //   1650: iconst_0
    //   1651: istore 6
    //   1653: goto -1125 -> 528
    //   1656: ldc 74
    //   1658: astore 8
    //   1660: goto -1101 -> 559
    //   1663: aload 9
    //   1665: astore 8
    //   1667: iload_2
    //   1668: istore_1
    //   1669: goto -1046 -> 623
    //   1672: ldc_w 437
    //   1675: astore 8
    //   1677: goto -660 -> 1017
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1680	0	this	1
    //   56	1613	1	i	int
    //   145	1523	2	j	int
    //   11	912	3	l	long
    //   65	1576	5	bool1	boolean
    //   220	1432	6	bool2	boolean
    //   625	679	7	bool3	boolean
    //   59	503	8	localObject1	Object
    //   606	6	8	localException1	java.lang.Exception
    //   977	1	8	localException2	java.lang.Exception
    //   104	1204	9	localObject4	Object
    //   1329	6	9	localObject5	Object
    //   1419	6	9	localObject6	Object
    //   1621	43	9	localObject7	Object
    //   74	1309	10	localkxz1	kxz
    //   1427	1	10	localException3	java.lang.Exception
    //   1629	1	10	localException4	java.lang.Exception
    //   1634	1	10	localException5	java.lang.Exception
    //   124	1095	11	localGetUrlByVidResponse	com.tencent.mobileqq.ac.ArticleCenter.GetUrlByVidResponse
    //   317	930	12	localObject8	Object
    //   459	123	13	localVideoInfo	com.tencent.mobileqq.ac.ArticleCenter.VideoInfo
    //   468	130	14	localkxz2	kxz
    // Exception table:
    //   from	to	target	type
    //   117	159	606	java/lang/Exception
    //   163	173	606	java/lang/Exception
    //   178	188	606	java/lang/Exception
    //   188	219	606	java/lang/Exception
    //   222	280	606	java/lang/Exception
    //   280	290	606	java/lang/Exception
    //   388	439	606	java/lang/Exception
    //   439	506	606	java/lang/Exception
    //   506	525	606	java/lang/Exception
    //   528	559	606	java/lang/Exception
    //   559	603	606	java/lang/Exception
    //   991	1008	606	java/lang/Exception
    //   1017	1059	606	java/lang/Exception
    //   1059	1070	606	java/lang/Exception
    //   1073	1097	606	java/lang/Exception
    //   1097	1228	606	java/lang/Exception
    //   1233	1243	606	java/lang/Exception
    //   1246	1257	606	java/lang/Exception
    //   1260	1266	606	java/lang/Exception
    //   295	340	977	java/lang/Exception
    //   340	386	977	java/lang/Exception
    //   824	846	1329	finally
    //   851	872	1329	finally
    //   872	875	1329	finally
    //   1331	1334	1329	finally
    //   1352	1389	1419	finally
    //   1389	1410	1419	finally
    //   1413	1416	1419	finally
    //   1421	1424	1419	finally
    //   1435	1473	1419	finally
    //   1473	1525	1419	finally
    //   1389	1410	1427	java/lang/Exception
    //   1561	1583	1621	finally
    //   1588	1609	1621	finally
    //   1609	1612	1621	finally
    //   1623	1626	1621	finally
    //   1588	1609	1629	java/lang/Exception
    //   851	872	1634	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ThirdVideoManager.1.1
 * JD-Core Version:    0.7.0.1
 */