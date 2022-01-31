package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import java.io.UnsupportedEncodingException;
import java.util.List;
import tencent.im.cs.cmd0x388.cmd0x388.GetPttUrlReq;
import tencent.im.cs.cmd0x388.cmd0x388.ReqBody;

public class GroupPttDownHandler
  extends BaseHandler
{
  void a(int paramInt, RichProto.RichProtoReq.ReqCommon paramReqCommon, cmd0x388.ReqBody paramReqBody)
  {
    Object localObject = (RichProto.RichProtoReq.GroupPttDownReq)paramReqCommon;
    paramReqCommon = new cmd0x388.GetPttUrlReq();
    paramReqCommon.setHasFlag(true);
    paramReqCommon.uint64_file_id.set(paramInt);
    paramReqCommon.uint64_dst_uin.set(Long.valueOf(((RichProto.RichProtoReq.GroupPttDownReq)localObject).jdField_c_of_type_JavaLangString).longValue());
    paramReqCommon.uint64_group_code.set(Long.parseLong(((RichProto.RichProtoReq.GroupPttDownReq)localObject).d));
    paramReqCommon.bytes_file_md5.set(ByteStringMicro.copyFrom(((RichProto.RichProtoReq.GroupPttDownReq)localObject).jdField_a_of_type_ArrayOfByte));
    if (((RichProto.RichProtoReq.GroupPttDownReq)localObject).jdField_a_of_type_Long != 0L) {
      paramReqCommon.uint64_fileid.set(((RichProto.RichProtoReq.GroupPttDownReq)localObject).jdField_a_of_type_Long);
    }
    paramReqCommon.uint32_req_platform_type.set(9);
    paramReqCommon.uint32_req_term.set(5);
    paramReqCommon.uint32_inner_ip.set(0);
    PBUInt32Field localPBUInt32Field = paramReqCommon.uint32_bu_type;
    if (((RichProto.RichProtoReq.GroupPttDownReq)localObject).jdField_c_of_type_Int == 1) {
      paramInt = 3;
    }
    for (;;)
    {
      localPBUInt32Field.set(paramInt);
      paramReqCommon.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(RichMediaUtil.a()));
      if (((RichProto.RichProtoReq.GroupPttDownReq)localObject).jdField_a_of_type_JavaLangString != null) {}
      try
      {
        localObject = ((RichProto.RichProtoReq.GroupPttDownReq)localObject).jdField_a_of_type_JavaLangString.getBytes("utf-8");
        paramReqCommon.bytes_file_key.set(ByteStringMicro.copyFrom((byte[])localObject));
        label191:
        paramReqBody.rpt_msg_getptt_url_req.add(paramReqCommon);
        return;
        paramInt = 4;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        break label191;
      }
    }
  }
  
  /* Error */
  public void a(com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 149	com/tencent/mobileqq/transfile/ProtoReqManager$ProtoResp:jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   4: astore 4
    //   6: aload_1
    //   7: getfield 149	com/tencent/mobileqq/transfile/ProtoReqManager$ProtoResp:jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   10: invokevirtual 155	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   13: astore 8
    //   15: aload_2
    //   16: getfield 160	com/tencent/mobileqq/transfile/ProtoReqManager$ProtoReq:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   19: checkcast 162	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq
    //   22: astore 5
    //   24: aload 5
    //   26: getfield 165	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq:jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoResp	Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp;
    //   29: astore 6
    //   31: aload_1
    //   32: getfield 168	com/tencent/mobileqq/transfile/ProtoReqManager$ProtoResp:jdField_a_of_type_ComTencentMobileqqAppMessageObserver$StatictisInfo	Lcom/tencent/mobileqq/app/MessageObserver$StatictisInfo;
    //   35: astore 7
    //   37: aload 4
    //   39: invokevirtual 172	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   42: sipush 1000
    //   45: if_icmpeq +114 -> 159
    //   48: aload 4
    //   50: invokevirtual 172	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   53: istore_3
    //   54: iload_3
    //   55: sipush 1002
    //   58: if_icmpeq +10 -> 68
    //   61: iload_3
    //   62: sipush 1013
    //   65: if_icmpne +51 -> 116
    //   68: aload 4
    //   70: invokestatic 177	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/qphone/base/remote/FromServiceMsg;)Ljava/lang/String;
    //   73: astore 8
    //   75: aload 4
    //   77: invokevirtual 180	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   80: astore_2
    //   81: aload_2
    //   82: astore_1
    //   83: aload_2
    //   84: ifnonnull +6 -> 90
    //   87: ldc 182
    //   89: astore_1
    //   90: aload_0
    //   91: iconst_m1
    //   92: sipush 9311
    //   95: aload 8
    //   97: aload_1
    //   98: aload 7
    //   100: aload 6
    //   102: getfield 187	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   105: invokevirtual 190	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:a	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/MessageObserver$StatictisInfo;Ljava/util/List;)V
    //   108: aload 5
    //   110: aload 6
    //   112: invokestatic 195	com/tencent/mobileqq/transfile/protohandler/RichProtoProc:a	(Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp;)V
    //   115: return
    //   116: aload 4
    //   118: invokestatic 177	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/qphone/base/remote/FromServiceMsg;)Ljava/lang/String;
    //   121: astore 8
    //   123: aload 4
    //   125: invokevirtual 180	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   128: astore_2
    //   129: aload_2
    //   130: astore_1
    //   131: aload_2
    //   132: ifnonnull +6 -> 138
    //   135: ldc 182
    //   137: astore_1
    //   138: aload_0
    //   139: iconst_m1
    //   140: sipush 9044
    //   143: aload 8
    //   145: aload_1
    //   146: aload 7
    //   148: aload 6
    //   150: getfield 187	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   153: invokevirtual 190	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:a	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/MessageObserver$StatictisInfo;Ljava/util/List;)V
    //   156: goto -48 -> 108
    //   159: new 197	tencent/im/cs/cmd0x388/cmd0x388$RspBody
    //   162: dup
    //   163: invokespecial 198	tencent/im/cs/cmd0x388/cmd0x388$RspBody:<init>	()V
    //   166: aload 8
    //   168: invokevirtual 202	tencent/im/cs/cmd0x388/cmd0x388$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   171: checkcast 197	tencent/im/cs/cmd0x388/cmd0x388$RspBody
    //   174: getfield 205	tencent/im/cs/cmd0x388/cmd0x388$RspBody:rpt_msg_getptt_url_rsp	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   177: invokevirtual 209	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   180: invokeinterface 215 1 0
    //   185: astore 9
    //   187: aload 9
    //   189: invokeinterface 221 1 0
    //   194: ifeq -86 -> 108
    //   197: aload 9
    //   199: invokeinterface 225 1 0
    //   204: checkcast 227	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp
    //   207: astore_1
    //   208: aload 6
    //   210: getfield 187	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   213: aload_1
    //   214: getfield 228	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:uint64_file_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   217: invokevirtual 230	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   220: l2i
    //   221: invokeinterface 233 2 0
    //   226: checkcast 235	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttDownResp
    //   229: astore 4
    //   231: aload_1
    //   232: getfield 238	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   235: invokevirtual 240	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   238: istore_3
    //   239: iload_3
    //   240: ifne +379 -> 619
    //   243: iconst_0
    //   244: istore_3
    //   245: aload_1
    //   246: getfield 244	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:rpt_uint32_down_ip	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   249: invokevirtual 249	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   252: ifle +431 -> 683
    //   255: aload_1
    //   256: getfield 252	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:rpt_uint32_down_port	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   259: invokevirtual 249	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   262: ifgt +6 -> 268
    //   265: goto +418 -> 683
    //   268: aload_1
    //   269: getfield 255	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:bytes_down_para	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   272: invokevirtual 258	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   275: invokevirtual 261	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   278: astore 10
    //   280: aload 4
    //   282: aload 10
    //   284: putfield 262	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttDownResp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   287: aload 10
    //   289: ifnull +17 -> 306
    //   292: iload_3
    //   293: ifeq +139 -> 432
    //   296: aload_1
    //   297: getfield 265	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:bytes_down_domain	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   300: invokevirtual 268	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   303: ifne +129 -> 432
    //   306: new 144	java/lang/Exception
    //   309: dup
    //   310: ldc_w 270
    //   313: invokespecial 273	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   316: athrow
    //   317: astore_1
    //   318: aload_0
    //   319: iconst_m1
    //   320: sipush -9527
    //   323: ldc_w 275
    //   326: ldc2_w 276
    //   329: invokestatic 282	com/tencent/mobileqq/transfile/BaseTransProcessor:a	(Ljava/lang/String;J)Ljava/lang/String;
    //   332: new 284	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 285	java/lang/StringBuilder:<init>	()V
    //   339: aload_1
    //   340: invokevirtual 288	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   343: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: ldc_w 294
    //   349: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: aload 8
    //   354: invokestatic 300	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   357: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: aload 7
    //   365: aload 4
    //   367: invokevirtual 306	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:a	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/MessageObserver$StatictisInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   370: goto -183 -> 187
    //   373: astore_1
    //   374: aload_0
    //   375: iconst_m1
    //   376: sipush -9527
    //   379: ldc_w 275
    //   382: ldc2_w 276
    //   385: invokestatic 282	com/tencent/mobileqq/transfile/BaseTransProcessor:a	(Ljava/lang/String;J)Ljava/lang/String;
    //   388: new 284	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 285	java/lang/StringBuilder:<init>	()V
    //   395: aload_1
    //   396: invokevirtual 288	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   399: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: ldc_w 294
    //   405: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: aload 8
    //   410: invokestatic 300	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   413: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: aload 7
    //   421: aload 6
    //   423: getfield 187	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   426: invokevirtual 190	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:a	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/MessageObserver$StatictisInfo;Ljava/util/List;)V
    //   429: goto -321 -> 108
    //   432: iload_3
    //   433: ifne +107 -> 540
    //   436: aload_1
    //   437: getfield 244	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:rpt_uint32_down_ip	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   440: invokevirtual 307	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   443: astore 10
    //   445: aload_1
    //   446: getfield 252	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:rpt_uint32_down_port	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   449: invokevirtual 307	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   452: astore 11
    //   454: iconst_0
    //   455: istore_3
    //   456: iload_3
    //   457: aload 10
    //   459: invokeinterface 308 1 0
    //   464: if_icmpge +76 -> 540
    //   467: new 310	com/tencent/mobileqq/transfile/ServerAddr
    //   470: dup
    //   471: invokespecial 311	com/tencent/mobileqq/transfile/ServerAddr:<init>	()V
    //   474: astore 12
    //   476: aload 12
    //   478: aload 10
    //   480: iload_3
    //   481: invokeinterface 233 2 0
    //   486: checkcast 313	java/lang/Integer
    //   489: invokevirtual 316	java/lang/Integer:intValue	()I
    //   492: i2l
    //   493: ldc2_w 317
    //   496: land
    //   497: invokestatic 323	com/tencent/mobileqq/utils/httputils/PkgTools:a	(J)Ljava/lang/String;
    //   500: putfield 324	com/tencent/mobileqq/transfile/ServerAddr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   503: aload 12
    //   505: aload 11
    //   507: iload_3
    //   508: invokeinterface 233 2 0
    //   513: checkcast 313	java/lang/Integer
    //   516: invokevirtual 316	java/lang/Integer:intValue	()I
    //   519: putfield 327	com/tencent/mobileqq/transfile/ServerAddr:b	I
    //   522: aload 4
    //   524: getfield 330	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttDownResp:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   527: iload_3
    //   528: aload 12
    //   530: invokevirtual 335	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   533: iload_3
    //   534: iconst_1
    //   535: iadd
    //   536: istore_3
    //   537: goto -81 -> 456
    //   540: aload_1
    //   541: getfield 265	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:bytes_down_domain	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   544: invokevirtual 268	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   547: ifeq +55 -> 602
    //   550: new 310	com/tencent/mobileqq/transfile/ServerAddr
    //   553: dup
    //   554: invokespecial 311	com/tencent/mobileqq/transfile/ServerAddr:<init>	()V
    //   557: astore 10
    //   559: aload 10
    //   561: aload_1
    //   562: getfield 265	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:bytes_down_domain	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   565: invokevirtual 258	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   568: invokevirtual 261	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   571: putfield 324	com/tencent/mobileqq/transfile/ServerAddr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   574: aload 10
    //   576: bipush 80
    //   578: putfield 327	com/tencent/mobileqq/transfile/ServerAddr:b	I
    //   581: aload 4
    //   583: getfield 330	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttDownResp:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   586: aload 10
    //   588: invokevirtual 338	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   591: pop
    //   592: aload 4
    //   594: aload 10
    //   596: getfield 324	com/tencent/mobileqq/transfile/ServerAddr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   599: putfield 340	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttDownResp:b	Ljava/lang/String;
    //   602: aload_0
    //   603: iconst_0
    //   604: iconst_0
    //   605: ldc 182
    //   607: ldc 182
    //   609: aload 7
    //   611: aload 4
    //   613: invokevirtual 306	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:a	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/MessageObserver$StatictisInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   616: goto -429 -> 187
    //   619: iload_3
    //   620: invokestatic 345	com/tencent/mobileqq/transfile/protohandler/GroupPicUpHandler:a	(I)Z
    //   623: ifeq +31 -> 654
    //   626: aload_0
    //   627: aload_0
    //   628: getfield 348	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:ao	I
    //   631: iconst_1
    //   632: iadd
    //   633: putfield 348	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:ao	I
    //   636: aload_0
    //   637: getfield 348	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:ao	I
    //   640: iconst_2
    //   641: if_icmpge +13 -> 654
    //   644: aload 5
    //   646: getfield 351	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq:jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager	Lcom/tencent/mobileqq/transfile/ProtoReqManager;
    //   649: aload_2
    //   650: invokevirtual 356	com/tencent/mobileqq/transfile/ProtoReqManager:a	(Lcom/tencent/mobileqq/transfile/ProtoReqManager$ProtoReq;)V
    //   653: return
    //   654: aload_0
    //   655: iconst_m1
    //   656: sipush -9527
    //   659: iload_3
    //   660: i2l
    //   661: invokestatic 357	com/tencent/mobileqq/transfile/BaseTransProcessor:a	(J)Ljava/lang/String;
    //   664: ldc 182
    //   666: aload 7
    //   668: aload 4
    //   670: invokevirtual 306	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:a	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/MessageObserver$StatictisInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   673: goto -486 -> 187
    //   676: astore_1
    //   677: aconst_null
    //   678: astore 4
    //   680: goto -362 -> 318
    //   683: iconst_1
    //   684: istore_3
    //   685: goto -417 -> 268
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	688	0	this	GroupPttDownHandler
    //   0	688	1	paramProtoResp	com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp
    //   0	688	2	paramProtoReq	ProtoReqManager.ProtoReq
    //   53	632	3	i	int
    //   4	675	4	localObject1	Object
    //   22	623	5	localRichProtoReq	RichProto.RichProtoReq
    //   29	393	6	localRichProtoResp	RichProto.RichProtoResp
    //   35	632	7	localStatictisInfo	com.tencent.mobileqq.app.MessageObserver.StatictisInfo
    //   13	396	8	localObject2	Object
    //   185	13	9	localIterator	java.util.Iterator
    //   278	317	10	localObject3	Object
    //   452	54	11	localList	List
    //   474	55	12	localServerAddr	com.tencent.mobileqq.transfile.ServerAddr
    // Exception table:
    //   from	to	target	type
    //   231	239	317	java/lang/Exception
    //   245	255	317	java/lang/Exception
    //   255	265	317	java/lang/Exception
    //   268	287	317	java/lang/Exception
    //   296	306	317	java/lang/Exception
    //   306	317	317	java/lang/Exception
    //   436	454	317	java/lang/Exception
    //   456	533	317	java/lang/Exception
    //   540	602	317	java/lang/Exception
    //   602	616	317	java/lang/Exception
    //   619	653	317	java/lang/Exception
    //   654	673	317	java/lang/Exception
    //   159	187	373	java/lang/Exception
    //   187	208	373	java/lang/Exception
    //   318	370	373	java/lang/Exception
    //   208	231	676	java/lang/Exception
  }
  
  void a(RichProto.RichProtoReq paramRichProtoReq)
  {
    RichProto.RichProtoResp localRichProtoResp = paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoResp;
    localRichProtoResp.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < paramRichProtoReq.jdField_a_of_type_JavaUtilList.size())
    {
      RichProto.RichProtoResp.GroupPttDownResp localGroupPttDownResp = new RichProto.RichProtoResp.GroupPttDownResp();
      localRichProtoResp.jdField_a_of_type_JavaUtilList.add(i, localGroupPttDownResp);
      i += 1;
    }
  }
  
  byte[] a(List paramList)
  {
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(4);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (RichProto.RichProtoReq.ReqCommon)paramList.get(i), localReqBody);
      i += 1;
    }
    switch (NetworkCenter.a().a())
    {
    default: 
      i = 6;
    }
    for (;;)
    {
      paramList = NetworkCenter.a().a();
      int j = i;
      if (paramList != null)
      {
        j = i;
        if (paramList.contains("wap")) {
          j = 5;
        }
      }
      localReqBody.uint32_net_type.set(j);
      return localReqBody.toByteArray();
      i = 3;
      continue;
      i = 6;
      continue;
      i = 7;
      continue;
      i = 8;
    }
  }
  
  public void c(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.jdField_a_of_type_JavaUtilList != null) && (paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
      localProtoReq.jdField_a_of_type_JavaLangString = "PttStore.GroupPttDown";
      localProtoReq.jdField_a_of_type_ArrayOfByte = a(paramRichProtoReq.jdField_a_of_type_JavaUtilList);
      localProtoReq.jdField_a_of_type_JavaLangObject = paramRichProtoReq;
      localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = this;
      a(paramRichProtoReq, localProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.GroupPttDownHandler
 * JD-Core Version:    0.7.0.1
 */