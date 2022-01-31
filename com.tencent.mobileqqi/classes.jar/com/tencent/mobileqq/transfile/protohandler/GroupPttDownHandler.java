package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import java.util.List;
import tencent.im.cs.cmd0x388.cmd0x388.GetPttUrlReq;
import tencent.im.cs.cmd0x388.cmd0x388.ReqBody;

public class GroupPttDownHandler
  extends BaseHandler
{
  void a(int paramInt, RichProto.RichProtoReq.ReqCommon paramReqCommon, cmd0x388.ReqBody paramReqBody)
  {
    paramReqCommon = (RichProto.RichProtoReq.GroupPttDownReq)paramReqCommon;
    cmd0x388.GetPttUrlReq localGetPttUrlReq = new cmd0x388.GetPttUrlReq();
    localGetPttUrlReq.setHasFlag(true);
    localGetPttUrlReq.uint64_file_id.set(paramInt);
    localGetPttUrlReq.uint64_dst_uin.set(Long.valueOf(paramReqCommon.jdField_c_of_type_JavaLangString).longValue());
    localGetPttUrlReq.uint64_group_code.set(Long.parseLong(paramReqCommon.d));
    localGetPttUrlReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramReqCommon.jdField_a_of_type_ArrayOfByte));
    if (paramReqCommon.jdField_a_of_type_Long != 0L) {
      localGetPttUrlReq.uint64_fileid.set(paramReqCommon.jdField_a_of_type_Long);
    }
    localGetPttUrlReq.uint32_req_platform_type.set(9);
    localGetPttUrlReq.uint32_req_term.set(5);
    localGetPttUrlReq.uint32_inner_ip.set(0);
    PBUInt32Field localPBUInt32Field = localGetPttUrlReq.uint32_bu_type;
    if (paramReqCommon.jdField_c_of_type_Int == 1) {}
    for (paramInt = 3;; paramInt = 4)
    {
      localPBUInt32Field.set(paramInt);
      localGetPttUrlReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(RichMediaUtil.a()));
      paramReqBody.rpt_msg_getptt_url_req.add(localGetPttUrlReq);
      return;
    }
  }
  
  /* Error */
  public void a(com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 134	com/tencent/mobileqq/transfile/ProtoReqManager$ProtoResp:jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   4: astore 4
    //   6: aload_1
    //   7: getfield 134	com/tencent/mobileqq/transfile/ProtoReqManager$ProtoResp:jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   10: invokevirtual 140	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   13: astore 5
    //   15: aload_2
    //   16: getfield 145	com/tencent/mobileqq/transfile/ProtoReqManager$ProtoReq:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   19: checkcast 147	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq
    //   22: astore 6
    //   24: aload 6
    //   26: getfield 150	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq:jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoResp	Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp;
    //   29: astore 7
    //   31: aload_1
    //   32: getfield 153	com/tencent/mobileqq/transfile/ProtoReqManager$ProtoResp:jdField_a_of_type_ComTencentMobileqqAppMessageObserver$StatictisInfo	Lcom/tencent/mobileqq/app/MessageObserver$StatictisInfo;
    //   35: astore 8
    //   37: aload 4
    //   39: invokevirtual 157	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   42: sipush 1000
    //   45: if_icmpeq +78 -> 123
    //   48: aload 4
    //   50: invokevirtual 157	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   53: istore_3
    //   54: iload_3
    //   55: sipush 1002
    //   58: if_icmpeq +10 -> 68
    //   61: iload_3
    //   62: sipush 1013
    //   65: if_icmpne +33 -> 98
    //   68: aload_0
    //   69: iconst_m1
    //   70: sipush 9311
    //   73: aload 4
    //   75: invokestatic 162	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/qphone/base/remote/FromServiceMsg;)Ljava/lang/String;
    //   78: ldc 164
    //   80: aload 8
    //   82: aload 7
    //   84: getfield 169	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   87: invokevirtual 172	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:a	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/MessageObserver$StatictisInfo;Ljava/util/List;)V
    //   90: aload 6
    //   92: aload 7
    //   94: invokestatic 177	com/tencent/mobileqq/transfile/protohandler/RichProtoProc:a	(Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp;)V
    //   97: return
    //   98: aload_0
    //   99: iconst_m1
    //   100: sipush 9044
    //   103: aload 4
    //   105: invokestatic 162	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/qphone/base/remote/FromServiceMsg;)Ljava/lang/String;
    //   108: ldc 164
    //   110: aload 8
    //   112: aload 7
    //   114: getfield 169	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   117: invokevirtual 172	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:a	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/MessageObserver$StatictisInfo;Ljava/util/List;)V
    //   120: goto -30 -> 90
    //   123: new 179	tencent/im/cs/cmd0x388/cmd0x388$RspBody
    //   126: dup
    //   127: invokespecial 180	tencent/im/cs/cmd0x388/cmd0x388$RspBody:<init>	()V
    //   130: aload 5
    //   132: invokevirtual 184	tencent/im/cs/cmd0x388/cmd0x388$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   135: checkcast 179	tencent/im/cs/cmd0x388/cmd0x388$RspBody
    //   138: getfield 187	tencent/im/cs/cmd0x388/cmd0x388$RspBody:rpt_msg_getptt_url_rsp	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   141: invokevirtual 191	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   144: invokeinterface 197 1 0
    //   149: astore 9
    //   151: aload 9
    //   153: invokeinterface 203 1 0
    //   158: ifeq -68 -> 90
    //   161: aload 9
    //   163: invokeinterface 207 1 0
    //   168: checkcast 209	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp
    //   171: astore_1
    //   172: aload 7
    //   174: getfield 169	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   177: aload_1
    //   178: getfield 210	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:uint64_file_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   181: invokevirtual 212	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   184: l2i
    //   185: invokeinterface 215 2 0
    //   190: checkcast 217	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttDownResp
    //   193: astore 4
    //   195: aload_1
    //   196: getfield 220	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   199: invokevirtual 222	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   202: istore_3
    //   203: iload_3
    //   204: ifne +378 -> 582
    //   207: iconst_0
    //   208: istore_3
    //   209: aload_1
    //   210: getfield 226	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:rpt_uint32_down_ip	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   213: invokevirtual 231	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   216: ifle +430 -> 646
    //   219: aload_1
    //   220: getfield 234	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:rpt_uint32_down_port	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   223: invokevirtual 231	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   226: ifgt +6 -> 232
    //   229: goto +417 -> 646
    //   232: aload_1
    //   233: getfield 237	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:bytes_down_para	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   236: invokevirtual 240	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   239: invokevirtual 243	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   242: astore 10
    //   244: aload 4
    //   246: aload 10
    //   248: putfield 245	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttDownResp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   251: aload 10
    //   253: ifnull +17 -> 270
    //   256: iload_3
    //   257: ifeq +138 -> 395
    //   260: aload_1
    //   261: getfield 248	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:bytes_down_domain	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   264: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   267: ifne +128 -> 395
    //   270: new 129	java/lang/Exception
    //   273: dup
    //   274: ldc 253
    //   276: invokespecial 256	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   279: athrow
    //   280: astore_1
    //   281: aload_0
    //   282: iconst_m1
    //   283: sipush -9527
    //   286: ldc_w 258
    //   289: ldc2_w 259
    //   292: invokestatic 265	com/tencent/mobileqq/transfile/BaseTransProcessor:a	(Ljava/lang/String;J)Ljava/lang/String;
    //   295: new 267	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 268	java/lang/StringBuilder:<init>	()V
    //   302: aload_1
    //   303: invokevirtual 271	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   306: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: ldc_w 277
    //   312: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload 5
    //   317: invokestatic 283	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   320: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: invokevirtual 286	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: aload 8
    //   328: aload 4
    //   330: invokevirtual 289	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:a	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/MessageObserver$StatictisInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   333: goto -182 -> 151
    //   336: astore_1
    //   337: aload_0
    //   338: iconst_m1
    //   339: sipush -9527
    //   342: ldc_w 258
    //   345: ldc2_w 259
    //   348: invokestatic 265	com/tencent/mobileqq/transfile/BaseTransProcessor:a	(Ljava/lang/String;J)Ljava/lang/String;
    //   351: new 267	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 268	java/lang/StringBuilder:<init>	()V
    //   358: aload_1
    //   359: invokevirtual 271	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   362: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: ldc_w 277
    //   368: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: aload 5
    //   373: invokestatic 283	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   376: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: invokevirtual 286	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: aload 8
    //   384: aload 7
    //   386: getfield 169	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   389: invokevirtual 172	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:a	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/MessageObserver$StatictisInfo;Ljava/util/List;)V
    //   392: goto -302 -> 90
    //   395: iload_3
    //   396: ifne +107 -> 503
    //   399: aload_1
    //   400: getfield 226	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:rpt_uint32_down_ip	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   403: invokevirtual 290	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   406: astore 10
    //   408: aload_1
    //   409: getfield 234	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:rpt_uint32_down_port	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   412: invokevirtual 290	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   415: astore 11
    //   417: iconst_0
    //   418: istore_3
    //   419: iload_3
    //   420: aload 10
    //   422: invokeinterface 291 1 0
    //   427: if_icmpge +76 -> 503
    //   430: new 293	com/tencent/mobileqq/transfile/ServerAddr
    //   433: dup
    //   434: invokespecial 294	com/tencent/mobileqq/transfile/ServerAddr:<init>	()V
    //   437: astore 12
    //   439: aload 12
    //   441: aload 10
    //   443: iload_3
    //   444: invokeinterface 215 2 0
    //   449: checkcast 296	java/lang/Integer
    //   452: invokevirtual 299	java/lang/Integer:intValue	()I
    //   455: i2l
    //   456: ldc2_w 300
    //   459: land
    //   460: invokestatic 306	com/tencent/mobileqq/utils/httputils/PkgTools:a	(J)Ljava/lang/String;
    //   463: putfield 307	com/tencent/mobileqq/transfile/ServerAddr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   466: aload 12
    //   468: aload 11
    //   470: iload_3
    //   471: invokeinterface 215 2 0
    //   476: checkcast 296	java/lang/Integer
    //   479: invokevirtual 299	java/lang/Integer:intValue	()I
    //   482: putfield 310	com/tencent/mobileqq/transfile/ServerAddr:b	I
    //   485: aload 4
    //   487: getfield 313	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttDownResp:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   490: iload_3
    //   491: aload 12
    //   493: invokevirtual 318	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   496: iload_3
    //   497: iconst_1
    //   498: iadd
    //   499: istore_3
    //   500: goto -81 -> 419
    //   503: aload_1
    //   504: getfield 248	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:bytes_down_domain	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   507: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   510: ifeq +55 -> 565
    //   513: new 293	com/tencent/mobileqq/transfile/ServerAddr
    //   516: dup
    //   517: invokespecial 294	com/tencent/mobileqq/transfile/ServerAddr:<init>	()V
    //   520: astore 10
    //   522: aload 10
    //   524: aload_1
    //   525: getfield 248	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:bytes_down_domain	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   528: invokevirtual 240	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   531: invokevirtual 243	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   534: putfield 307	com/tencent/mobileqq/transfile/ServerAddr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   537: aload 10
    //   539: bipush 80
    //   541: putfield 310	com/tencent/mobileqq/transfile/ServerAddr:b	I
    //   544: aload 4
    //   546: getfield 313	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttDownResp:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   549: aload 10
    //   551: invokevirtual 321	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   554: pop
    //   555: aload 4
    //   557: aload 10
    //   559: getfield 307	com/tencent/mobileqq/transfile/ServerAddr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   562: putfield 323	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttDownResp:b	Ljava/lang/String;
    //   565: aload_0
    //   566: iconst_0
    //   567: iconst_0
    //   568: ldc 164
    //   570: ldc 164
    //   572: aload 8
    //   574: aload 4
    //   576: invokevirtual 289	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:a	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/MessageObserver$StatictisInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   579: goto -428 -> 151
    //   582: iload_3
    //   583: invokestatic 328	com/tencent/mobileqq/transfile/protohandler/GroupPicUpHandler:a	(I)Z
    //   586: ifeq +31 -> 617
    //   589: aload_0
    //   590: aload_0
    //   591: getfield 331	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:aj	I
    //   594: iconst_1
    //   595: iadd
    //   596: putfield 331	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:aj	I
    //   599: aload_0
    //   600: getfield 331	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:aj	I
    //   603: iconst_2
    //   604: if_icmpge +13 -> 617
    //   607: aload 6
    //   609: getfield 334	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq:jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager	Lcom/tencent/mobileqq/transfile/ProtoReqManager;
    //   612: aload_2
    //   613: invokevirtual 339	com/tencent/mobileqq/transfile/ProtoReqManager:a	(Lcom/tencent/mobileqq/transfile/ProtoReqManager$ProtoReq;)V
    //   616: return
    //   617: aload_0
    //   618: iconst_m1
    //   619: sipush -9527
    //   622: iload_3
    //   623: i2l
    //   624: invokestatic 340	com/tencent/mobileqq/transfile/BaseTransProcessor:a	(J)Ljava/lang/String;
    //   627: ldc 164
    //   629: aload 8
    //   631: aload 4
    //   633: invokevirtual 289	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:a	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/MessageObserver$StatictisInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   636: goto -485 -> 151
    //   639: astore_1
    //   640: aconst_null
    //   641: astore 4
    //   643: goto -362 -> 281
    //   646: iconst_1
    //   647: istore_3
    //   648: goto -416 -> 232
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	651	0	this	GroupPttDownHandler
    //   0	651	1	paramProtoResp	com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp
    //   0	651	2	paramProtoReq	ProtoReqManager.ProtoReq
    //   53	595	3	i	int
    //   4	638	4	localObject1	java.lang.Object
    //   13	359	5	arrayOfByte	byte[]
    //   22	586	6	localRichProtoReq	RichProto.RichProtoReq
    //   29	356	7	localRichProtoResp	RichProto.RichProtoResp
    //   35	595	8	localStatictisInfo	com.tencent.mobileqq.app.MessageObserver.StatictisInfo
    //   149	13	9	localIterator	java.util.Iterator
    //   242	316	10	localObject2	java.lang.Object
    //   415	54	11	localList	List
    //   437	55	12	localServerAddr	com.tencent.mobileqq.transfile.ServerAddr
    // Exception table:
    //   from	to	target	type
    //   195	203	280	java/lang/Exception
    //   209	219	280	java/lang/Exception
    //   219	229	280	java/lang/Exception
    //   232	251	280	java/lang/Exception
    //   260	270	280	java/lang/Exception
    //   270	280	280	java/lang/Exception
    //   399	417	280	java/lang/Exception
    //   419	496	280	java/lang/Exception
    //   503	565	280	java/lang/Exception
    //   565	579	280	java/lang/Exception
    //   582	616	280	java/lang/Exception
    //   617	636	280	java/lang/Exception
    //   123	151	336	java/lang/Exception
    //   151	172	336	java/lang/Exception
    //   281	333	336	java/lang/Exception
    //   172	195	639	java/lang/Exception
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
      localProtoReq.jdField_a_of_type_JavaLangString = "ImgStore.GroupPicDown#pttGd";
      localProtoReq.jdField_a_of_type_ArrayOfByte = a(paramRichProtoReq.jdField_a_of_type_JavaUtilList);
      localProtoReq.jdField_a_of_type_JavaLangObject = paramRichProtoReq;
      localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = this;
      a(paramRichProtoReq, localProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.GroupPttDownHandler
 * JD-Core Version:    0.7.0.1
 */