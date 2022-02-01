import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspPublishVideo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

public class pzo
  extends ppw
{
  public static final String CMD = ppf.fQ("StorySvc.video_show_publish");
  public static final String avX = ppf.fQ("StoryGroupSvc.do_video_publish");
  public static final String awi = String.valueOf(1);
  public static final String awj = String.valueOf(2);
  public static final String awk = String.valueOf(3);
  public static final String awl = String.valueOf(4);
  public static final String awm = String.valueOf(5);
  public long AC;
  public boolean aCH;
  public boolean aCI;
  public boolean aCJ;
  public String atJsonData;
  public String avY;
  public String avZ;
  public String awa;
  public String awb;
  public String awc;
  public String awd;
  public String awe;
  public String awf;
  public String awg;
  public String awh;
  public pty b;
  public byte[] bC;
  public int blx;
  public int bly;
  public int comparedActivityId;
  public int comparedLevel;
  public long createTime;
  public AddressItem d;
  public String doodleText;
  public String interactThumbnailUrl;
  public int isPicture;
  public String label;
  public int latitude;
  public String localCreateCity;
  public long localCreateTime;
  public int longitude;
  public String mLocalDate;
  public String pollThumbnailUrl;
  public byte[] readerConfBytes;
  public byte[] tagInfoBytes;
  public long timeZoneOffset;
  public String title = "";
  public String vid;
  public long videoBytes;
  public int videoHeight;
  @Nullable
  public String videoThumbnailUrl;
  public int videoType;
  public String videoUrl;
  public int videoWidth;
  
  public pzo(boolean paramBoolean)
  {
    this.aCH = paramBoolean;
    this.bjM = 5;
  }
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspPublishVideo localRspPublishVideo = new qqstory_service.RspPublishVideo();
    try
    {
      localRspPublishVideo.mergeFrom(paramArrayOfByte);
      return new qav(localRspPublishVideo);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
    return null;
  }
  
  /* Error */
  protected byte[] encode()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 135	pzo:vid	Ljava/lang/String;
    //   4: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +13 -> 20
    //   10: new 143	java/lang/IllegalArgumentException
    //   13: dup
    //   14: ldc 145
    //   16: invokespecial 148	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   19: athrow
    //   20: aload_0
    //   21: getfield 150	pzo:AC	J
    //   24: lconst_0
    //   25: lcmp
    //   26: ifgt +33 -> 59
    //   29: new 143	java/lang/IllegalArgumentException
    //   32: dup
    //   33: new 152	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   40: ldc 155
    //   42: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_0
    //   46: getfield 150	pzo:AC	J
    //   49: invokevirtual 162	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   52: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 148	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   58: athrow
    //   59: aload_0
    //   60: getfield 168	pzo:videoUrl	Ljava/lang/String;
    //   63: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   66: ifeq +33 -> 99
    //   69: new 143	java/lang/IllegalArgumentException
    //   72: dup
    //   73: new 152	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   80: ldc 170
    //   82: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_0
    //   86: getfield 168	pzo:videoUrl	Ljava/lang/String;
    //   89: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokespecial 148	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   98: athrow
    //   99: aload_0
    //   100: getfield 172	pzo:aCI	Z
    //   103: ifeq +28 -> 131
    //   106: aload_0
    //   107: getfield 174	pzo:bC	[B
    //   110: ifnull +11 -> 121
    //   113: aload_0
    //   114: getfield 174	pzo:bC	[B
    //   117: arraylength
    //   118: ifgt +13 -> 131
    //   121: new 143	java/lang/IllegalArgumentException
    //   124: dup
    //   125: ldc 176
    //   127: invokespecial 148	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   130: athrow
    //   131: new 178	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo
    //   134: dup
    //   135: invokespecial 179	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:<init>	()V
    //   138: astore_3
    //   139: aload_3
    //   140: getfield 182	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   143: aload_0
    //   144: getfield 104	pzo:title	Ljava/lang/String;
    //   147: invokestatic 188	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   150: invokevirtual 194	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   153: aload_3
    //   154: getfield 196	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:vid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   157: aload_0
    //   158: getfield 135	pzo:vid	Ljava/lang/String;
    //   161: invokestatic 188	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   164: invokevirtual 194	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   167: aload_3
    //   168: getfield 199	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:video_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   171: aload_0
    //   172: getfield 168	pzo:videoUrl	Ljava/lang/String;
    //   175: invokestatic 188	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   178: invokevirtual 194	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   181: aload_3
    //   182: getfield 203	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:total_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   185: aload_0
    //   186: getfield 150	pzo:AC	J
    //   189: invokevirtual 208	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   192: aload_0
    //   193: getfield 210	pzo:mLocalDate	Ljava/lang/String;
    //   196: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   199: ifeq +24 -> 223
    //   202: aload_0
    //   203: invokestatic 216	qvf:c	()Ljava/text/SimpleDateFormat;
    //   206: new 218	java/util/Date
    //   209: dup
    //   210: aload_0
    //   211: getfield 220	pzo:createTime	J
    //   214: invokespecial 222	java/util/Date:<init>	(J)V
    //   217: invokevirtual 228	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   220: putfield 210	pzo:mLocalDate	Ljava/lang/String;
    //   223: aload_3
    //   224: getfield 232	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:date	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   227: aload_0
    //   228: getfield 210	pzo:mLocalDate	Ljava/lang/String;
    //   231: invokestatic 237	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   234: invokevirtual 241	java/lang/Integer:intValue	()I
    //   237: invokevirtual 246	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   240: aload_3
    //   241: getfield 249	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   244: aload_0
    //   245: getfield 251	pzo:blx	I
    //   248: invokevirtual 246	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   251: aload_3
    //   252: getfield 254	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:sync_to_qzone	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   255: astore_2
    //   256: aload_0
    //   257: getfield 256	pzo:aCJ	Z
    //   260: ifeq +762 -> 1022
    //   263: iconst_1
    //   264: istore_1
    //   265: aload_2
    //   266: iload_1
    //   267: invokevirtual 246	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   270: ldc_w 258
    //   273: ldc_w 260
    //   276: aload_0
    //   277: getfield 256	pzo:aCJ	Z
    //   280: invokestatic 265	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   283: invokestatic 270	ram:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   286: aload_0
    //   287: getfield 272	pzo:awh	Ljava/lang/String;
    //   290: ifnull +14 -> 304
    //   293: aload_3
    //   294: getfield 276	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:compared_vid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   297: aload_0
    //   298: getfield 272	pzo:awh	Ljava/lang/String;
    //   301: invokevirtual 280	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   304: aload_0
    //   305: getfield 282	pzo:comparedLevel	I
    //   308: ifeq +14 -> 322
    //   311: aload_3
    //   312: getfield 285	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:compared_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   315: aload_0
    //   316: getfield 282	pzo:comparedLevel	I
    //   319: invokevirtual 246	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   322: aload_0
    //   323: getfield 287	pzo:comparedActivityId	I
    //   326: ifeq +14 -> 340
    //   329: aload_3
    //   330: getfield 290	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:compared_activity_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   333: aload_0
    //   334: getfield 287	pzo:comparedActivityId	I
    //   337: invokevirtual 246	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   340: ldc_w 292
    //   343: ldc_w 294
    //   346: aload_0
    //   347: getfield 282	pzo:comparedLevel	I
    //   350: invokestatic 297	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   353: aload_0
    //   354: getfield 287	pzo:comparedActivityId	I
    //   357: invokestatic 297	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   360: invokestatic 300	ram:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   363: aload_0
    //   364: getfield 302	pzo:awg	Ljava/lang/String;
    //   367: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   370: ifne +17 -> 387
    //   373: aload_3
    //   374: getfield 305	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:game_pk_vid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   377: aload_0
    //   378: getfield 302	pzo:awg	Ljava/lang/String;
    //   381: invokestatic 188	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   384: invokevirtual 194	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   387: new 307	org/json/JSONObject
    //   390: dup
    //   391: invokespecial 308	org/json/JSONObject:<init>	()V
    //   394: astore_2
    //   395: aload_2
    //   396: ldc_w 310
    //   399: aload_0
    //   400: getfield 312	pzo:videoWidth	I
    //   403: invokevirtual 316	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   406: pop
    //   407: aload_2
    //   408: ldc_w 318
    //   411: aload_0
    //   412: getfield 320	pzo:videoHeight	I
    //   415: invokevirtual 316	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   418: pop
    //   419: aload_2
    //   420: ldc_w 322
    //   423: aload_0
    //   424: getfield 324	pzo:videoBytes	J
    //   427: invokevirtual 327	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   430: pop
    //   431: aload_2
    //   432: ldc_w 329
    //   435: aload_0
    //   436: getfield 331	pzo:isPicture	I
    //   439: invokevirtual 316	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   442: pop
    //   443: aload_0
    //   444: getfield 333	pzo:doodleText	Ljava/lang/String;
    //   447: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   450: ifne +15 -> 465
    //   453: aload_2
    //   454: ldc_w 335
    //   457: aload_0
    //   458: getfield 333	pzo:doodleText	Ljava/lang/String;
    //   461: invokevirtual 338	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   464: pop
    //   465: aload_0
    //   466: getfield 340	pzo:awa	Ljava/lang/String;
    //   469: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   472: ifne +15 -> 487
    //   475: aload_2
    //   476: ldc_w 342
    //   479: aload_0
    //   480: getfield 340	pzo:awa	Ljava/lang/String;
    //   483: invokevirtual 338	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   486: pop
    //   487: aload_0
    //   488: getfield 344	pzo:awb	Ljava/lang/String;
    //   491: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   494: ifne +15 -> 509
    //   497: aload_2
    //   498: ldc_w 346
    //   501: aload_0
    //   502: getfield 344	pzo:awb	Ljava/lang/String;
    //   505: invokevirtual 338	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   508: pop
    //   509: aload_0
    //   510: getfield 348	pzo:atJsonData	Ljava/lang/String;
    //   513: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   516: ifne +22 -> 538
    //   519: aload_2
    //   520: ldc_w 350
    //   523: new 352	org/json/JSONArray
    //   526: dup
    //   527: aload_0
    //   528: getfield 348	pzo:atJsonData	Ljava/lang/String;
    //   531: invokespecial 353	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   534: invokevirtual 338	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   537: pop
    //   538: aload_2
    //   539: ldc_w 355
    //   542: aload_0
    //   543: getfield 357	pzo:timeZoneOffset	J
    //   546: ldc2_w 358
    //   549: ldiv
    //   550: invokevirtual 327	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   553: pop
    //   554: aload_0
    //   555: getfield 331	pzo:isPicture	I
    //   558: ifne +497 -> 1055
    //   561: aload_0
    //   562: getfield 361	pzo:videoType	I
    //   565: ifne +462 -> 1027
    //   568: aload_3
    //   569: getfield 364	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:content_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   572: iconst_1
    //   573: invokevirtual 246	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   576: aload_0
    //   577: getfield 366	pzo:localCreateTime	J
    //   580: lconst_0
    //   581: lcmp
    //   582: ifeq +501 -> 1083
    //   585: aload_2
    //   586: ldc_w 368
    //   589: aload_0
    //   590: getfield 366	pzo:localCreateTime	J
    //   593: invokevirtual 327	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   596: pop
    //   597: aload_2
    //   598: ldc_w 370
    //   601: iconst_1
    //   602: invokevirtual 373	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   605: pop
    //   606: aload_3
    //   607: getfield 376	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:content_origin	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   610: iconst_1
    //   611: invokevirtual 246	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   614: aload_0
    //   615: getfield 378	pzo:localCreateCity	Ljava/lang/String;
    //   618: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   621: ifne +15 -> 636
    //   624: aload_2
    //   625: ldc_w 380
    //   628: aload_0
    //   629: getfield 378	pzo:localCreateCity	Ljava/lang/String;
    //   632: invokevirtual 338	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   635: pop
    //   636: aload_0
    //   637: getfield 382	pzo:longitude	I
    //   640: ifeq +15 -> 655
    //   643: aload_2
    //   644: ldc_w 384
    //   647: aload_0
    //   648: getfield 382	pzo:longitude	I
    //   651: invokevirtual 316	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   654: pop
    //   655: aload_0
    //   656: getfield 386	pzo:latitude	I
    //   659: ifeq +15 -> 674
    //   662: aload_2
    //   663: ldc_w 388
    //   666: aload_0
    //   667: getfield 386	pzo:latitude	I
    //   670: invokevirtual 316	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   673: pop
    //   674: aload_0
    //   675: getfield 390	pzo:awd	Ljava/lang/String;
    //   678: ifnull +34 -> 712
    //   681: aload_2
    //   682: ldc_w 392
    //   685: new 307	org/json/JSONObject
    //   688: dup
    //   689: aload_0
    //   690: getfield 390	pzo:awd	Ljava/lang/String;
    //   693: invokespecial 393	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   696: invokevirtual 396	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   699: pop
    //   700: aload_2
    //   701: ldc_w 398
    //   704: aload_0
    //   705: getfield 400	pzo:pollThumbnailUrl	Ljava/lang/String;
    //   708: invokevirtual 396	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   711: pop
    //   712: aload_0
    //   713: getfield 402	pzo:awe	Ljava/lang/String;
    //   716: ifnull +34 -> 750
    //   719: aload_2
    //   720: ldc_w 404
    //   723: new 307	org/json/JSONObject
    //   726: dup
    //   727: aload_0
    //   728: getfield 402	pzo:awe	Ljava/lang/String;
    //   731: invokespecial 393	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   734: invokevirtual 396	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   737: pop
    //   738: aload_2
    //   739: ldc_w 406
    //   742: aload_0
    //   743: getfield 408	pzo:interactThumbnailUrl	Ljava/lang/String;
    //   746: invokevirtual 396	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   749: pop
    //   750: aload_0
    //   751: getfield 282	pzo:comparedLevel	I
    //   754: ifeq +15 -> 769
    //   757: aload_2
    //   758: ldc_w 410
    //   761: aload_0
    //   762: getfield 282	pzo:comparedLevel	I
    //   765: invokevirtual 316	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   768: pop
    //   769: aload_0
    //   770: getfield 412	pzo:awf	Ljava/lang/String;
    //   773: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   776: ifne +22 -> 798
    //   779: aload_2
    //   780: ldc_w 414
    //   783: new 307	org/json/JSONObject
    //   786: dup
    //   787: aload_0
    //   788: getfield 412	pzo:awf	Ljava/lang/String;
    //   791: invokespecial 393	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   794: invokevirtual 396	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   797: pop
    //   798: aload_3
    //   799: getfield 417	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:video_attr	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   802: aload_2
    //   803: invokevirtual 418	org/json/JSONObject:toString	()Ljava/lang/String;
    //   806: invokestatic 188	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   809: invokevirtual 194	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   812: aload_0
    //   813: getfield 420	pzo:b	Lpty;
    //   816: ifnull +111 -> 927
    //   819: aload_0
    //   820: getfield 420	pzo:b	Lpty;
    //   823: iconst_1
    //   824: invokevirtual 426	pty:i	(Z)Ljava/lang/String;
    //   827: astore_2
    //   828: ldc_w 258
    //   831: ldc_w 428
    //   834: aload_2
    //   835: invokestatic 270	ram:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   838: aload_3
    //   839: getfield 431	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:video_extern_link_attr	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   842: aload_2
    //   843: invokestatic 188	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   846: invokevirtual 194	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   849: aload_0
    //   850: getfield 420	pzo:b	Lpty;
    //   853: getfield 434	pty:styleType	I
    //   856: iconst_3
    //   857: if_icmpne +11 -> 868
    //   860: aload_3
    //   861: getfield 437	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:is_capture_together_video	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   864: iconst_1
    //   865: invokevirtual 246	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   868: aload_0
    //   869: getfield 420	pzo:b	Lpty;
    //   872: getfield 440	pty:a	Lpty$a;
    //   875: ifnull +52 -> 927
    //   878: aload_0
    //   879: getfield 420	pzo:b	Lpty;
    //   882: getfield 440	pty:a	Lpty$a;
    //   885: getfield 445	pty$a:avp	Ljava/lang/String;
    //   888: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   891: ifne +36 -> 927
    //   894: aload_3
    //   895: getfield 449	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:wording_check	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   898: invokevirtual 455	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   901: astore_2
    //   902: aload_2
    //   903: aload_0
    //   904: getfield 420	pzo:b	Lpty;
    //   907: getfield 440	pty:a	Lpty$a;
    //   910: getfield 445	pty$a:avp	Ljava/lang/String;
    //   913: invokeinterface 461 2 0
    //   918: pop
    //   919: aload_3
    //   920: getfield 449	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:wording_check	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   923: aload_2
    //   924: invokevirtual 464	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   927: aload_0
    //   928: getfield 348	pzo:atJsonData	Ljava/lang/String;
    //   931: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   934: ifne +169 -> 1103
    //   937: new 352	org/json/JSONArray
    //   940: dup
    //   941: aload_0
    //   942: getfield 348	pzo:atJsonData	Ljava/lang/String;
    //   945: invokespecial 353	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   948: astore_2
    //   949: aload_2
    //   950: ifnull +153 -> 1103
    //   953: aload_2
    //   954: invokevirtual 467	org/json/JSONArray:length	()I
    //   957: ifle +146 -> 1103
    //   960: new 469	java/util/ArrayList
    //   963: dup
    //   964: invokespecial 470	java/util/ArrayList:<init>	()V
    //   967: astore 4
    //   969: iconst_0
    //   970: istore_1
    //   971: iload_1
    //   972: aload_2
    //   973: invokevirtual 467	org/json/JSONArray:length	()I
    //   976: if_icmpge +118 -> 1094
    //   979: aload 4
    //   981: aload_2
    //   982: iload_1
    //   983: invokevirtual 474	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   986: ldc_w 476
    //   989: invokevirtual 479	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   992: invokestatic 484	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   995: invokeinterface 461 2 0
    //   1000: pop
    //   1001: iload_1
    //   1002: iconst_1
    //   1003: iadd
    //   1004: istore_1
    //   1005: goto -34 -> 971
    //   1008: astore_2
    //   1009: ldc_w 258
    //   1012: ldc_w 486
    //   1015: aload_2
    //   1016: invokestatic 490	ram:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1019: goto -779 -> 240
    //   1022: iconst_0
    //   1023: istore_1
    //   1024: goto -759 -> 265
    //   1027: aload_3
    //   1028: getfield 364	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:content_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1031: aload_0
    //   1032: getfield 361	pzo:videoType	I
    //   1035: invokevirtual 246	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   1038: goto -462 -> 576
    //   1041: astore_2
    //   1042: ldc_w 258
    //   1045: ldc_w 492
    //   1048: aload_2
    //   1049: invokestatic 490	ram:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1052: goto -125 -> 927
    //   1055: aload_3
    //   1056: getfield 364	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:content_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1059: astore 4
    //   1061: aload_0
    //   1062: getfield 361	pzo:videoType	I
    //   1065: iconst_3
    //   1066: if_icmpne +657 -> 1723
    //   1069: aload_0
    //   1070: getfield 361	pzo:videoType	I
    //   1073: istore_1
    //   1074: aload 4
    //   1076: iload_1
    //   1077: invokevirtual 246	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   1080: goto -504 -> 576
    //   1083: aload_3
    //   1084: getfield 376	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:content_origin	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1087: iconst_0
    //   1088: invokevirtual 246	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   1091: goto -477 -> 614
    //   1094: aload_3
    //   1095: getfield 495	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:mention_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   1098: aload 4
    //   1100: invokevirtual 499	com/tencent/mobileqq/pb/PBRepeatField:addAll	(Ljava/util/Collection;)V
    //   1103: aload_0
    //   1104: getfield 501	pzo:label	Ljava/lang/String;
    //   1107: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1110: ifne +17 -> 1127
    //   1113: aload_3
    //   1114: getfield 503	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:label	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1117: aload_0
    //   1118: getfield 501	pzo:label	Ljava/lang/String;
    //   1121: invokestatic 188	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1124: invokevirtual 194	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   1127: aload_0
    //   1128: getfield 505	pzo:avY	Ljava/lang/String;
    //   1131: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1134: ifeq +428 -> 1562
    //   1137: aload_0
    //   1138: getfield 333	pzo:doodleText	Ljava/lang/String;
    //   1141: astore_2
    //   1142: aload_2
    //   1143: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1146: ifne +14 -> 1160
    //   1149: aload_3
    //   1150: getfield 508	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:doodle_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1153: aload_2
    //   1154: invokestatic 188	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1157: invokevirtual 194	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   1160: aload_0
    //   1161: getfield 510	pzo:videoThumbnailUrl	Ljava/lang/String;
    //   1164: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1167: ifne +17 -> 1184
    //   1170: aload_3
    //   1171: getfield 513	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:video_cover	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1174: aload_0
    //   1175: getfield 510	pzo:videoThumbnailUrl	Ljava/lang/String;
    //   1178: invokestatic 188	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1181: invokevirtual 194	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   1184: aload_0
    //   1185: getfield 515	pzo:avZ	Ljava/lang/String;
    //   1188: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1191: ifne +17 -> 1208
    //   1194: aload_3
    //   1195: getfield 518	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:doodle_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1198: aload_0
    //   1199: getfield 515	pzo:avZ	Ljava/lang/String;
    //   1202: invokestatic 188	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1205: invokevirtual 194	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   1208: aload_0
    //   1209: getfield 520	pzo:d	Lcom/tencent/biz/qqstory/model/item/AddressItem;
    //   1212: ifnull +17 -> 1229
    //   1215: aload_3
    //   1216: getfield 524	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:address	Lcom/tencent/biz/qqstory/network/pb/qqstory_struct$Address;
    //   1219: aload_0
    //   1220: getfield 520	pzo:d	Lcom/tencent/biz/qqstory/model/item/AddressItem;
    //   1223: invokevirtual 530	com/tencent/biz/qqstory/model/item/AddressItem:convertToProtoObject	()Lcom/tencent/biz/qqstory/network/pb/qqstory_struct$Address;
    //   1226: invokevirtual 535	com/tencent/biz/qqstory/network/pb/qqstory_struct$Address:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   1229: aload_3
    //   1230: getfield 538	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:create_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1233: aload_0
    //   1234: getfield 220	pzo:createTime	J
    //   1237: ldc2_w 358
    //   1240: ldiv
    //   1241: invokevirtual 208	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   1244: aload_0
    //   1245: getfield 540	pzo:awc	Ljava/lang/String;
    //   1248: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1251: ifne +17 -> 1268
    //   1254: aload_3
    //   1255: getfield 543	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:multi_shoot_group_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1258: aload_0
    //   1259: getfield 540	pzo:awc	Ljava/lang/String;
    //   1262: invokestatic 188	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1265: invokevirtual 194	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   1268: aload_0
    //   1269: getfield 545	pzo:readerConfBytes	[B
    //   1272: ifnull +36 -> 1308
    //   1275: aload_0
    //   1276: getfield 545	pzo:readerConfBytes	[B
    //   1279: arraylength
    //   1280: ifle +28 -> 1308
    //   1283: new 547	com/tencent/biz/qqstory/network/pb/qqstory_struct$VideoReaderConf
    //   1286: dup
    //   1287: invokespecial 548	com/tencent/biz/qqstory/network/pb/qqstory_struct$VideoReaderConf:<init>	()V
    //   1290: astore_2
    //   1291: aload_2
    //   1292: aload_0
    //   1293: getfield 545	pzo:readerConfBytes	[B
    //   1296: invokevirtual 549	com/tencent/biz/qqstory/network/pb/qqstory_struct$VideoReaderConf:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1299: pop
    //   1300: aload_3
    //   1301: getfield 553	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:reader_conf	Lcom/tencent/biz/qqstory/network/pb/qqstory_struct$VideoReaderConf;
    //   1304: aload_2
    //   1305: invokevirtual 554	com/tencent/biz/qqstory/network/pb/qqstory_struct$VideoReaderConf:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   1308: aload_0
    //   1309: getfield 174	pzo:bC	[B
    //   1312: ifnull +33 -> 1345
    //   1315: aload_0
    //   1316: getfield 174	pzo:bC	[B
    //   1319: arraylength
    //   1320: ifle +25 -> 1345
    //   1323: new 556	com/tencent/biz/qqstory/network/pb/qqstory_struct$VideoSpreadGroupList
    //   1326: dup
    //   1327: invokespecial 557	com/tencent/biz/qqstory/network/pb/qqstory_struct$VideoSpreadGroupList:<init>	()V
    //   1330: astore_2
    //   1331: aload_2
    //   1332: aload_0
    //   1333: getfield 174	pzo:bC	[B
    //   1336: invokevirtual 558	com/tencent/biz/qqstory/network/pb/qqstory_struct$VideoSpreadGroupList:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1339: pop
    //   1340: aload_3
    //   1341: aload_2
    //   1342: putfield 562	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:group_list	Lcom/tencent/biz/qqstory/network/pb/qqstory_struct$VideoSpreadGroupList;
    //   1345: aload_3
    //   1346: getfield 565	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:ignore_personal_publish	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1349: astore_2
    //   1350: aload_0
    //   1351: getfield 172	pzo:aCI	Z
    //   1354: ifeq +232 -> 1586
    //   1357: iconst_1
    //   1358: istore_1
    //   1359: aload_2
    //   1360: iload_1
    //   1361: invokevirtual 246	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   1364: aload_3
    //   1365: getfield 568	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:group_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1368: aload_0
    //   1369: getfield 570	pzo:bly	I
    //   1372: invokevirtual 246	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   1375: aload_0
    //   1376: getfield 572	pzo:tagInfoBytes	[B
    //   1379: ifnull +73 -> 1452
    //   1382: aload_0
    //   1383: getfield 572	pzo:tagInfoBytes	[B
    //   1386: arraylength
    //   1387: ifle +65 -> 1452
    //   1390: new 574	com/tencent/biz/qqstory/network/pb/qqstory_struct$TagInfoBase
    //   1393: dup
    //   1394: invokespecial 575	com/tencent/biz/qqstory/network/pb/qqstory_struct$TagInfoBase:<init>	()V
    //   1397: astore_2
    //   1398: aload_2
    //   1399: aload_0
    //   1400: getfield 572	pzo:tagInfoBytes	[B
    //   1403: invokevirtual 576	com/tencent/biz/qqstory/network/pb/qqstory_struct$TagInfoBase:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1406: pop
    //   1407: aload_3
    //   1408: getfield 579	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:video_label_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1411: aload_2
    //   1412: getfield 582	com/tencent/biz/qqstory/network/pb/qqstory_struct$TagInfoBase:tag_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1415: invokevirtual 585	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1418: invokevirtual 208	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   1421: aload_3
    //   1422: getfield 588	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:video_label_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1425: aload_2
    //   1426: getfield 591	com/tencent/biz/qqstory/network/pb/qqstory_struct$TagInfoBase:tag_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1429: invokevirtual 593	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1432: invokevirtual 246	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   1435: aload_3
    //   1436: getfield 596	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:video_label_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1439: aload_2
    //   1440: getfield 599	com/tencent/biz/qqstory/network/pb/qqstory_struct$TagInfoBase:tag_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1443: invokevirtual 601	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1446: invokestatic 188	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1449: invokevirtual 194	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   1452: aload_3
    //   1453: getfield 604	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:client_version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1456: iconst_5
    //   1457: invokevirtual 246	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   1460: aload_0
    //   1461: getfield 390	pzo:awd	Ljava/lang/String;
    //   1464: ifnull +146 -> 1610
    //   1467: aload_0
    //   1468: getfield 390	pzo:awd	Ljava/lang/String;
    //   1471: invokestatic 609	com/tencent/biz/qqstory/model/item/StoryVideoItem$b:a	(Ljava/lang/String;)Lcom/tencent/biz/qqstory/model/item/StoryVideoItem$b;
    //   1474: astore_2
    //   1475: aload_2
    //   1476: ifnull +134 -> 1610
    //   1479: aload_2
    //   1480: getfield 613	com/tencent/biz/qqstory/model/item/StoryVideoItem$b:bR	[Ljava/lang/String;
    //   1483: ifnull +127 -> 1610
    //   1486: aload_2
    //   1487: getfield 613	com/tencent/biz/qqstory/model/item/StoryVideoItem$b:bR	[Ljava/lang/String;
    //   1490: arraylength
    //   1491: iconst_2
    //   1492: if_icmple +118 -> 1610
    //   1495: aload_3
    //   1496: getfield 616	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:poll_text	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1499: aload_2
    //   1500: getfield 613	com/tencent/biz/qqstory/model/item/StoryVideoItem$b:bR	[Ljava/lang/String;
    //   1503: iconst_0
    //   1504: aaload
    //   1505: invokevirtual 280	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   1508: new 469	java/util/ArrayList
    //   1511: dup
    //   1512: aload_2
    //   1513: getfield 613	com/tencent/biz/qqstory/model/item/StoryVideoItem$b:bR	[Ljava/lang/String;
    //   1516: arraylength
    //   1517: invokespecial 618	java/util/ArrayList:<init>	(I)V
    //   1520: astore 4
    //   1522: iconst_1
    //   1523: istore_1
    //   1524: iload_1
    //   1525: aload_2
    //   1526: getfield 613	com/tencent/biz/qqstory/model/item/StoryVideoItem$b:bR	[Ljava/lang/String;
    //   1529: arraylength
    //   1530: if_icmpge +71 -> 1601
    //   1533: aload 4
    //   1535: aload_2
    //   1536: getfield 613	com/tencent/biz/qqstory/model/item/StoryVideoItem$b:bR	[Ljava/lang/String;
    //   1539: iload_1
    //   1540: aaload
    //   1541: invokeinterface 461 2 0
    //   1546: pop
    //   1547: iload_1
    //   1548: iconst_1
    //   1549: iadd
    //   1550: istore_1
    //   1551: goto -27 -> 1524
    //   1554: astore_2
    //   1555: aload_2
    //   1556: invokevirtual 621	org/json/JSONException:printStackTrace	()V
    //   1559: goto -456 -> 1103
    //   1562: aload_0
    //   1563: getfield 505	pzo:avY	Ljava/lang/String;
    //   1566: astore_2
    //   1567: goto -425 -> 1142
    //   1570: astore_2
    //   1571: aload_2
    //   1572: invokevirtual 622	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   1575: goto -267 -> 1308
    //   1578: astore_2
    //   1579: aload_2
    //   1580: invokevirtual 622	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   1583: goto -238 -> 1345
    //   1586: iconst_0
    //   1587: istore_1
    //   1588: goto -229 -> 1359
    //   1591: astore 4
    //   1593: aload 4
    //   1595: invokevirtual 622	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   1598: goto -191 -> 1407
    //   1601: aload_3
    //   1602: getfield 625	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:poll_options	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   1605: aload 4
    //   1607: invokevirtual 464	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   1610: aload_0
    //   1611: getfield 402	pzo:awe	Ljava/lang/String;
    //   1614: ifnull +75 -> 1689
    //   1617: aload_0
    //   1618: getfield 402	pzo:awe	Ljava/lang/String;
    //   1621: invokestatic 630	com/tencent/biz/qqstory/model/item/StoryVideoItem$a:a	(Ljava/lang/String;)Lcom/tencent/biz/qqstory/model/item/StoryVideoItem$a;
    //   1624: astore_2
    //   1625: aload_2
    //   1626: ifnull +63 -> 1689
    //   1629: aload_2
    //   1630: getfield 631	com/tencent/biz/qqstory/model/item/StoryVideoItem$a:bR	[Ljava/lang/String;
    //   1633: ifnull +56 -> 1689
    //   1636: aload_2
    //   1637: getfield 631	com/tencent/biz/qqstory/model/item/StoryVideoItem$a:bR	[Ljava/lang/String;
    //   1640: arraylength
    //   1641: ifle +48 -> 1689
    //   1644: new 633	com/tencent/biz/qqstory/network/pb/qqstory_struct$InteractPasterInfo
    //   1647: dup
    //   1648: invokespecial 634	com/tencent/biz/qqstory/network/pb/qqstory_struct$InteractPasterInfo:<init>	()V
    //   1651: astore 4
    //   1653: aload 4
    //   1655: getfield 637	com/tencent/biz/qqstory/network/pb/qqstory_struct$InteractPasterInfo:paster_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1658: aload_2
    //   1659: getfield 640	com/tencent/biz/qqstory/model/item/StoryVideoItem$a:type	I
    //   1662: invokevirtual 246	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   1665: aload 4
    //   1667: getfield 643	com/tencent/biz/qqstory/network/pb/qqstory_struct$InteractPasterInfo:paster_contents	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   1670: aload_2
    //   1671: getfield 631	com/tencent/biz/qqstory/model/item/StoryVideoItem$a:bR	[Ljava/lang/String;
    //   1674: invokestatic 649	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   1677: invokevirtual 464	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   1680: aload_3
    //   1681: getfield 653	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:interact_paster_info	Lcom/tencent/biz/qqstory/network/pb/qqstory_struct$InteractPasterInfo;
    //   1684: aload 4
    //   1686: invokevirtual 654	com/tencent/biz/qqstory/network/pb/qqstory_struct$InteractPasterInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   1689: ldc_w 258
    //   1692: new 152	java/lang/StringBuilder
    //   1695: dup
    //   1696: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1699: ldc_w 656
    //   1702: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1705: aload_3
    //   1706: invokestatic 661	rpf:a	(Lcom/tencent/mobileqq/pb/MessageMicro;)Ljava/lang/String;
    //   1709: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1712: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1715: invokestatic 664	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1718: aload_3
    //   1719: invokevirtual 667	com/tencent/biz/qqstory/network/pb/qqstory_service$ReqPublishVideo:toByteArray	()[B
    //   1722: areturn
    //   1723: iconst_0
    //   1724: istore_1
    //   1725: goto -651 -> 1074
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1728	0	this	pzo
    //   264	1461	1	i	int
    //   255	727	2	localObject1	java.lang.Object
    //   1008	8	2	localNumberFormatException	java.lang.NumberFormatException
    //   1041	8	2	localException	java.lang.Exception
    //   1141	395	2	localObject2	java.lang.Object
    //   1554	2	2	localJSONException	org.json.JSONException
    //   1566	1	2	str	String
    //   1570	2	2	localInvalidProtocolBufferMicroException1	InvalidProtocolBufferMicroException
    //   1578	2	2	localInvalidProtocolBufferMicroException2	InvalidProtocolBufferMicroException
    //   1624	47	2	locala	com.tencent.biz.qqstory.model.item.StoryVideoItem.a
    //   138	1581	3	localReqPublishVideo	com.tencent.biz.qqstory.network.pb.qqstory_service.ReqPublishVideo
    //   967	567	4	localObject3	java.lang.Object
    //   1591	15	4	localInvalidProtocolBufferMicroException3	InvalidProtocolBufferMicroException
    //   1651	34	4	localInteractPasterInfo	com.tencent.biz.qqstory.network.pb.qqstory_struct.InteractPasterInfo
    // Exception table:
    //   from	to	target	type
    //   223	240	1008	java/lang/NumberFormatException
    //   387	465	1041	java/lang/Exception
    //   465	487	1041	java/lang/Exception
    //   487	509	1041	java/lang/Exception
    //   509	538	1041	java/lang/Exception
    //   538	576	1041	java/lang/Exception
    //   576	614	1041	java/lang/Exception
    //   614	636	1041	java/lang/Exception
    //   636	655	1041	java/lang/Exception
    //   655	674	1041	java/lang/Exception
    //   674	712	1041	java/lang/Exception
    //   712	750	1041	java/lang/Exception
    //   750	769	1041	java/lang/Exception
    //   769	798	1041	java/lang/Exception
    //   798	868	1041	java/lang/Exception
    //   868	927	1041	java/lang/Exception
    //   1027	1038	1041	java/lang/Exception
    //   1055	1074	1041	java/lang/Exception
    //   1074	1080	1041	java/lang/Exception
    //   1083	1091	1041	java/lang/Exception
    //   937	949	1554	org/json/JSONException
    //   953	969	1554	org/json/JSONException
    //   971	1001	1554	org/json/JSONException
    //   1094	1103	1554	org/json/JSONException
    //   1291	1308	1570	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1331	1345	1578	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1398	1407	1591	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public String mg()
  {
    if (this.aCH) {
      return avX;
    }
    return CMD;
  }
  
  public String toString()
  {
    return "PublishStoryVideoRequest{title='" + this.title + '\'' + ", vid='" + this.vid + '\'' + ", videoThumbnailUrl='" + this.videoThumbnailUrl + '\'' + ", mOriginalMaskPicUrl='" + this.avZ + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pzo
 * JD-Core Version:    0.7.0.1
 */