package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.UinPairMsg;
import tencent.im.c2c.msgtype0xa6.submsgtype0xc1.SubMsgType0xc1.MsgBody;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_head.InstCtrl;
import tencent.im.msg.im_receipt.ReceiptReq;
import tencent.im.msg.im_receipt.ReceiptResp;
import tencent.im.s2c.msgtype0x210.submsgtype0x1a.SubMsgType0x1a.MsgBody;

public final class msg_svc
{
  public static final class AccostTmp
    extends MessageMicro<AccostTmp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField reply = PBField.initBool(false);
    public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field to_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "to_uin", "sig", "reply" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Boolean.valueOf(false) }, AccostTmp.class);
    }
  }
  
  public static final class AddressListTmp
    extends MessageMicro<AddressListTmp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field from_contact_size = PBField.initUInt32(0);
    public final PBStringField from_phone = PBField.initString("");
    public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField to_phone = PBField.initString("");
    public final PBUInt64Field to_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40 }, new String[] { "from_phone", "to_phone", "to_uin", "sig", "from_contact_size" }, new Object[] { "", "", Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0) }, AddressListTmp.class);
    }
  }
  
  public static final class AuthTmp
    extends MessageMicro<AuthTmp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field to_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "to_uin", "sig" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, AuthTmp.class);
    }
  }
  
  public static final class BsnsTmp
    extends MessageMicro<BsnsTmp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field to_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "to_uin", "sig" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, BsnsTmp.class);
    }
  }
  
  public static final class BusinessWPATmp
    extends MessageMicro<BusinessWPATmp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField sigt = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field to_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "to_uin", "sig", "sigt" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, BusinessWPATmp.class);
    }
  }
  
  public static final class C2C
    extends MessageMicro<C2C>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "to_uin" }, new Object[] { Long.valueOf(0L) }, C2C.class);
    public final PBUInt64Field to_uin = PBField.initUInt64(0L);
  }
  
  public static final class CommTmp
    extends MessageMicro<CommTmp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field c2c_type = PBField.initUInt32(0);
    public final PBBytesField reserved = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field svr_type = PBField.initUInt32(0);
    public final PBUInt64Field to_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "to_uin", "c2c_type", "svr_type", "sig", "reserved" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, CommTmp.class);
    }
  }
  
  public static final class Dis
    extends MessageMicro<Dis>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "dis_uin" }, new Object[] { Long.valueOf(0L) }, Dis.class);
    public final PBUInt64Field dis_uin = PBField.initUInt64(0L);
  }
  
  public static final class DisTmp
    extends MessageMicro<DisTmp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "dis_uin", "to_uin" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, DisTmp.class);
    public final PBUInt64Field dis_uin = PBField.initUInt64(0L);
    public final PBUInt64Field to_uin = PBField.initUInt64(0L);
  }
  
  public static final class Grp
    extends MessageMicro<Grp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "group_code" }, new Object[] { Long.valueOf(0L) }, Grp.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
  }
  
  public static final class GrpTmp
    extends MessageMicro<GrpTmp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "group_uin", "to_uin" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, GrpTmp.class);
    public final PBUInt64Field group_uin = PBField.initUInt64(0L);
    public final PBUInt64Field to_uin = PBField.initUInt64(0L);
  }
  
  public static final class MsgSendInfo
    extends MessageMicro<MsgSendInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "receiver" }, new Object[] { Integer.valueOf(0) }, MsgSendInfo.class);
    public final PBUInt32Field receiver = PBField.initUInt32(0);
  }
  
  public static final class MultiMsgAssist
    extends MessageMicro<MultiMsgAssist>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_redbag_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField msg_use = PBField.initEnum(1);
    public final PBRepeatMessageField<msg_svc.RoutingHead> repeated_routing = PBField.initRepeatMessage(msg_svc.RoutingHead.class);
    public final PBUInt32Field uint32_has_readbag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_has_vedio = PBField.initUInt32(0);
    public final PBUInt64Field uint64_redbag_amount = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_temp_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_vedio_len = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 48, 56, 64 }, new String[] { "repeated_routing", "msg_use", "uint64_temp_id", "uint64_vedio_len", "bytes_redbag_id", "uint64_redbag_amount", "uint32_has_readbag", "uint32_has_vedio" }, new Object[] { null, Integer.valueOf(1), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, MultiMsgAssist.class);
    }
  }
  
  public static final class NearByAssistantTmp
    extends MessageMicro<NearByAssistantTmp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField reply = PBField.initBool(false);
    public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field to_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "to_uin", "sig", "reply" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Boolean.valueOf(false) }, NearByAssistantTmp.class);
    }
  }
  
  public static final class NearByDatingTmp
    extends MessageMicro<NearByDatingTmp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField reply = PBField.initBool(false);
    public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field to_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "to_uin", "sig", "reply" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Boolean.valueOf(false) }, NearByDatingTmp.class);
    }
  }
  
  public static final class PbBindUinGetMsgReq
    extends MessageMicro<PbBindUinGetMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field bind_uin = PBField.initUInt64(0L);
    public final PBBytesField bind_uin_sig = PBField.initBytes(ByteStringMicro.copyFromUtf8(""));
    public final PBBytesField sync_cookie = PBField.initBytes(ByteStringMicro.copyFromUtf8(""));
    public final PBEnumField sync_flag = PBField.initEnum(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.copyFromUtf8("");
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.copyFromUtf8("");
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "bind_uin", "bind_uin_sig", "sync_flag", "sync_cookie" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, PbBindUinGetMsgReq.class);
    }
  }
  
  public static final class PbBindUinMsgReadedConfirmReq
    extends MessageMicro<PbBindUinMsgReadedConfirmReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field bind_uin = PBField.initUInt64(0L);
    public final PBBytesField sync_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "sync_cookie", "bind_uin" }, new Object[] { localByteStringMicro, Long.valueOf(0L) }, PbBindUinMsgReadedConfirmReq.class);
    }
  }
  
  public static final class PbBindUinMsgReadedConfirmResp
    extends MessageMicro<PbBindUinMsgReadedConfirmResp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field bind_uin = PBField.initUInt64(0L);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBBytesField sync_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "result", "errmsg", "sync_cookie", "bind_uin" }, new Object[] { Integer.valueOf(0), "", localByteStringMicro, Long.valueOf(0L) }, PbBindUinMsgReadedConfirmResp.class);
    }
  }
  
  public static final class PbBindUinUnReadMsgNumReq
    extends MessageMicro<PbBindUinUnReadMsgNumReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field bind_uin = PBField.initUInt64(0L);
    public final PBBytesField sync_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "bind_uin", "sync_cookie" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, PbBindUinUnReadMsgNumReq.class);
    }
  }
  
  public static final class PbBindUinUnReadMsgNumResp
    extends MessageMicro<PbBindUinUnReadMsgNumResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "result", "errmsg", "bind_uin", "msg_num" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), Integer.valueOf(0) }, PbBindUinUnReadMsgNumResp.class);
    public final PBUInt64Field bind_uin = PBField.initUInt64(0L);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt32Field msg_num = PBField.initUInt32(0);
    public final PBUInt32Field result = PBField.initUInt32(0);
  }
  
  public static final class PbC2CMsgWithDrawReq
    extends MessageMicro<PbC2CMsgWithDrawReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_reserved = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<MsgInfo> msg_info = PBField.initRepeatMessage(MsgInfo.class);
    public final PBUInt32Field uint32_long_message_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "msg_info", "uint32_long_message_flag", "bytes_reserved", "uint32_sub_cmd" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, PbC2CMsgWithDrawReq.class);
    }
    
    public static final class MsgInfo
      extends MessageMicro<MsgInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 162 }, new String[] { "uint64_from_uin", "uint64_to_uin", "uint32_msg_seq", "uint64_msg_uid", "uint64_msg_time", "uint32_msg_random", "uint32_pkg_num", "uint32_pkg_index", "uint32_div_seq", "uint32_msg_type", "routing_head" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, MsgInfo.class);
      public msg_svc.RoutingHead routing_head = new msg_svc.RoutingHead();
      public final PBUInt32Field uint32_div_seq = PBField.initUInt32(0);
      public final PBUInt32Field uint32_msg_random = PBField.initUInt32(0);
      public final PBUInt32Field uint32_msg_seq = PBField.initUInt32(0);
      public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
      public final PBUInt32Field uint32_pkg_index = PBField.initUInt32(0);
      public final PBUInt32Field uint32_pkg_num = PBField.initUInt32(0);
      public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_msg_time = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_msg_uid = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
    }
  }
  
  public static final class PbC2CMsgWithDrawResp
    extends MessageMicro<PbC2CMsgWithDrawResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "result", "errmsg", "msg_status", "uint32_sub_cmd" }, new Object[] { Integer.valueOf(0), "", null, Integer.valueOf(0) }, PbC2CMsgWithDrawResp.class);
    public final PBStringField errmsg = PBField.initString("");
    public final PBRepeatMessageField<MsgStatus> msg_status = PBField.initRepeatMessage(MsgStatus.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    
    public static final class MsgStatus
      extends MessageMicro<MsgStatus>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_info", "uint32_status" }, new Object[] { null, Integer.valueOf(0) }, MsgStatus.class);
      public msg_svc.PbC2CMsgWithDrawReq.MsgInfo msg_info = new msg_svc.PbC2CMsgWithDrawReq.MsgInfo();
      public final PBUInt32Field uint32_status = PBField.initUInt32(0);
    }
  }
  
  public static final class PbC2CReadedReportReq
    extends MessageMicro<PbC2CReadedReportReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<UinPairReadInfo> pair_info = PBField.initRepeatMessage(UinPairReadInfo.class);
    public final PBBytesField sync_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "sync_cookie", "pair_info" }, new Object[] { localByteStringMicro, null }, PbC2CReadedReportReq.class);
    }
    
    public static final class UinPairReadInfo
      extends MessageMicro<UinPairReadInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__;
      public final PBUInt32Field aio_type = PBField.initUInt32(0);
      public final PBUInt32Field chat_type = PBField.initUInt32(0);
      public final PBUInt64Field cpid = PBField.initUInt64(0L);
      public final PBBytesField crm_sig = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBUInt32Field last_read_time = PBField.initUInt32(0);
      public final PBEnumField peer_type = PBField.initEnum(1);
      public final PBUInt64Field peer_uin = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_to_tiny_id = PBField.initUInt64(0L);
      
      static
      {
        ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48, 56, 72 }, new String[] { "peer_uin", "last_read_time", "crm_sig", "peer_type", "chat_type", "cpid", "aio_type", "uint64_to_tiny_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(1), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, UinPairReadInfo.class);
      }
    }
  }
  
  public static final class PbC2CReadedReportResp
    extends MessageMicro<PbC2CReadedReportResp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBBytesField sync_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "result", "errmsg", "sync_cookie" }, new Object[] { Integer.valueOf(0), "", localByteStringMicro }, PbC2CReadedReportResp.class);
    }
  }
  
  public static final class PbC2CUnReadMsgNumReq
    extends MessageMicro<PbC2CUnReadMsgNumReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], PbC2CUnReadMsgNumReq.class);
  }
  
  public static final class PbC2CUnReadMsgNumResp
    extends MessageMicro<PbC2CUnReadMsgNumResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "result", "errmsg", "msg_num" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0) }, PbC2CUnReadMsgNumResp.class);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt32Field msg_num = PBField.initUInt32(0);
    public final PBUInt32Field result = PBField.initUInt32(0);
  }
  
  public static final class PbDelRoamMsgReq
    extends MessageMicro<PbDelRoamMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "c2c_msg", "grp_msg", "dis_msg" }, new Object[] { null, null, null }, PbDelRoamMsgReq.class);
    public C2CMsg c2c_msg = new C2CMsg();
    public DisMsg dis_msg = new DisMsg();
    public GrpMsg grp_msg = new GrpMsg();
    
    public static final class C2CMsg
      extends MessageMicro<C2CMsg>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "from_uin", "peer_uin", "msg_time", "msg_random", "msg_seq" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, C2CMsg.class);
      public final PBUInt64Field from_uin = PBField.initUInt64(0L);
      public final PBUInt32Field msg_random = PBField.initUInt32(0);
      public final PBUInt32Field msg_seq = PBField.initUInt32(0);
      public final PBUInt32Field msg_time = PBField.initUInt32(0);
      public final PBUInt64Field peer_uin = PBField.initUInt64(0L);
    }
    
    public static final class DisMsg
      extends MessageMicro<DisMsg>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "discuss_uin", "msg_seq" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, DisMsg.class);
      public final PBUInt64Field discuss_uin = PBField.initUInt64(0L);
      public final PBUInt64Field msg_seq = PBField.initUInt64(0L);
    }
    
    public static final class GrpMsg
      extends MessageMicro<GrpMsg>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "group_code", "msg_seq", "uint32_resv_flag" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, GrpMsg.class);
      public final PBUInt64Field group_code = PBField.initUInt64(0L);
      public final PBUInt64Field msg_seq = PBField.initUInt64(0L);
      public final PBUInt32Field uint32_resv_flag = PBField.initUInt32(0);
    }
  }
  
  public static final class PbDelRoamMsgResp
    extends MessageMicro<PbDelRoamMsgResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "result", "errmsg" }, new Object[] { Integer.valueOf(0), "" }, PbDelRoamMsgResp.class);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt32Field result = PBField.initUInt32(0);
  }
  
  public static final class PbDeleteMsgReq
    extends MessageMicro<PbDeleteMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msgItems" }, new Object[] { null }, PbDeleteMsgReq.class);
    public final PBRepeatMessageField<MsgItem> msgItems = PBField.initRepeatMessage(MsgItem.class);
    
    public static final class MsgItem
      extends MessageMicro<MsgItem>
    {
      static final MessageMicro.FieldMap __fieldMap__;
      public final PBUInt64Field from_uin = PBField.initUInt64(0L);
      public final PBUInt32Field msg_seq = PBField.initUInt32(0);
      public final PBUInt32Field msg_type = PBField.initUInt32(0);
      public final PBUInt64Field msg_uid = PBField.initUInt64(0L);
      public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBUInt64Field to_uin = PBField.initUInt64(0L);
      
      static
      {
        ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 58 }, new String[] { "from_uin", "to_uin", "msg_type", "msg_seq", "msg_uid", "sig" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro }, MsgItem.class);
      }
    }
  }
  
  public static final class PbDeleteMsgResp
    extends MessageMicro<PbDeleteMsgResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "result", "errmsg" }, new Object[] { Integer.valueOf(0), "" }, PbDeleteMsgResp.class);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt32Field result = PBField.initUInt32(0);
  }
  
  public static final class PbDiscussReadedReportReq
    extends MessageMicro<PbDiscussReadedReportReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "conf_uin", "last_read_seq" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, PbDiscussReadedReportReq.class);
    public final PBUInt64Field conf_uin = PBField.initUInt64(0L);
    public final PBUInt64Field last_read_seq = PBField.initUInt64(0L);
  }
  
  public static final class PbDiscussReadedReportResp
    extends MessageMicro<PbDiscussReadedReportResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40 }, new String[] { "result", "errmsg", "conf_uin", "member_seq", "conf_seq" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, PbDiscussReadedReportResp.class);
    public final PBUInt64Field conf_seq = PBField.initUInt64(0L);
    public final PBUInt64Field conf_uin = PBField.initUInt64(0L);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt64Field member_seq = PBField.initUInt64(0L);
    public final PBUInt32Field result = PBField.initUInt32(0);
  }
  
  public static final class PbGetDiscussMsgReq
    extends MessageMicro<PbGetDiscussMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56 }, new String[] { "discuss_uin", "end_seq", "begin_seq", "last_get_time", "discuss_info_seq", "filter", "member_seq" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, PbGetDiscussMsgReq.class);
    public final PBUInt64Field begin_seq = PBField.initUInt64(0L);
    public final PBUInt64Field discuss_info_seq = PBField.initUInt64(0L);
    public final PBUInt64Field discuss_uin = PBField.initUInt64(0L);
    public final PBUInt64Field end_seq = PBField.initUInt64(0L);
    public final PBEnumField filter = PBField.initEnum(0);
    public final PBUInt64Field last_get_time = PBField.initUInt64(0L);
    public final PBUInt64Field member_seq = PBField.initUInt64(0L);
  }
  
  public static final class PbGetDiscussMsgResp
    extends MessageMicro<PbGetDiscussMsgResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50, 56, 64 }, new String[] { "result", "errmsg", "discuss_uin", "return_end_seq", "return_begin_seq", "msg", "last_get_time", "discuss_info_seq" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(0L), Long.valueOf(0L) }, PbGetDiscussMsgResp.class);
    public final PBUInt64Field discuss_info_seq = PBField.initUInt64(0L);
    public final PBUInt64Field discuss_uin = PBField.initUInt64(0L);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt64Field last_get_time = PBField.initUInt64(0L);
    public final PBRepeatMessageField<msg_comm.Msg> msg = PBField.initRepeatMessage(msg_comm.Msg.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBUInt64Field return_begin_seq = PBField.initUInt64(0L);
    public final PBUInt64Field return_end_seq = PBField.initUInt64(0L);
  }
  
  public static final class PbGetGroupMsgReq
    extends MessageMicro<PbGetGroupMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64 }, new String[] { "group_code", "begin_seq", "end_seq", "filter", "member_seq", "public_group", "shield_flag", "save_traffic_flag" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0) }, PbGetGroupMsgReq.class);
    public final PBUInt64Field begin_seq = PBField.initUInt64(0L);
    public final PBUInt64Field end_seq = PBField.initUInt64(0L);
    public final PBEnumField filter = PBField.initEnum(0);
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
    public final PBUInt64Field member_seq = PBField.initUInt64(0L);
    public final PBBoolField public_group = PBField.initBool(false);
    public final PBUInt32Field save_traffic_flag = PBField.initUInt32(0);
    public final PBUInt32Field shield_flag = PBField.initUInt32(0);
  }
  
  public static final class PbGetGroupMsgResp
    extends MessageMicro<PbGetGroupMsgResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50 }, new String[] { "result", "errmsg", "group_code", "return_begin_seq", "return_end_seq", "msg" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null }, PbGetGroupMsgResp.class);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
    public final PBRepeatMessageField<msg_comm.Msg> msg = PBField.initRepeatMessage(msg_comm.Msg.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBUInt64Field return_begin_seq = PBField.initUInt64(0L);
    public final PBUInt64Field return_end_seq = PBField.initUInt64(0L);
  }
  
  public static final class PbGetMsgReq
    extends MessageMicro<PbGetMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_server_buf = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field context_flag = PBField.initUInt32(0);
    public final PBUInt32Field latest_ramble_number = PBField.initUInt32(20);
    public final PBBytesField msg_ctrl_buf = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field msg_req_type = PBField.initUInt32(0);
    public final PBUInt32Field online_sync_flag = PBField.initUInt32(1);
    public final PBUInt32Field other_ramble_number = PBField.initUInt32(3);
    public final PBBytesField pubaccount_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field ramble_flag = PBField.initUInt32(1);
    public final PBBytesField sync_cookie = PBField.initBytes(ByteStringMicro.copyFromUtf8(""));
    public final PBEnumField sync_flag = PBField.initEnum(0);
    public final PBUInt32Field whisper_session_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.copyFromUtf8("");
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56, 64, 72, 82, 90, 98 }, new String[] { "sync_flag", "sync_cookie", "ramble_flag", "latest_ramble_number", "other_ramble_number", "online_sync_flag", "context_flag", "whisper_session_id", "msg_req_type", "pubaccount_cookie", "msg_ctrl_buf", "bytes_server_buf" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, PbGetMsgReq.class);
    }
  }
  
  public static final class PbGetMsgResp
    extends MessageMicro<PbGetMsgResp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field bind_uin = PBField.initUInt64(0L);
    public final PBStringField errmsg = PBField.initString("");
    public final PBBoolField is_partial_sync = PBField.initBool(false);
    public final PBBytesField msg_ctrl_buf = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field msg_rsp_type = PBField.initUInt32(0);
    public final PBBytesField pubaccount_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBBytesField sync_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField sync_flag = PBField.initEnum(0);
    public final PBRepeatMessageField<msg_comm.UinPairMsg> uin_pair_msgs = PBField.initRepeatMessage(msg_comm.UinPairMsg.class);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 48, 56, 66, 72, 82 }, new String[] { "result", "errmsg", "sync_cookie", "sync_flag", "uin_pair_msgs", "bind_uin", "msg_rsp_type", "pubaccount_cookie", "is_partial_sync", "msg_ctrl_buf" }, new Object[] { Integer.valueOf(0), "", localByteStringMicro1, Integer.valueOf(0), null, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro2, Boolean.valueOf(false), localByteStringMicro3 }, PbGetMsgResp.class);
    }
  }
  
  public static final class PbGetOneDayRoamMsgReq
    extends MessageMicro<PbGetOneDayRoamMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "peer_uin", "last_msgtime", "random", "read_cnt" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, PbGetOneDayRoamMsgReq.class);
    public final PBUInt64Field last_msgtime = PBField.initUInt64(0L);
    public final PBUInt64Field peer_uin = PBField.initUInt64(0L);
    public final PBUInt64Field random = PBField.initUInt64(0L);
    public final PBUInt32Field read_cnt = PBField.initUInt32(0);
  }
  
  public static final class PbGetOneDayRoamMsgResp
    extends MessageMicro<PbGetOneDayRoamMsgResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50, 56 }, new String[] { "result", "errmsg", "peer_uin", "last_msgtime", "random", "msg", "iscomplete" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, Integer.valueOf(0) }, PbGetOneDayRoamMsgResp.class);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt32Field iscomplete = PBField.initUInt32(0);
    public final PBUInt64Field last_msgtime = PBField.initUInt64(0L);
    public final PBRepeatMessageField<msg_comm.Msg> msg = PBField.initRepeatMessage(msg_comm.Msg.class);
    public final PBUInt64Field peer_uin = PBField.initUInt64(0L);
    public final PBUInt64Field random = PBField.initUInt64(0L);
    public final PBUInt32Field result = PBField.initUInt32(0);
  }
  
  public static final class PbGetRoamMsgReq
    extends MessageMicro<PbGetRoamMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field begin_msgtime = PBField.initUInt64(0L);
    public final PBUInt32Field check_pwd = PBField.initUInt32(0);
    public final PBUInt64Field last_msgtime = PBField.initUInt64(0L);
    public final PBUInt64Field peer_uin = PBField.initUInt64(0L);
    public final PBBytesField pwd = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field random = PBField.initUInt64(0L);
    public final PBUInt32Field read_cnt = PBField.initUInt32(0);
    public final PBUInt32Field req_type = PBField.initUInt32(0);
    public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field subcmd = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58, 64, 72, 80 }, new String[] { "peer_uin", "last_msgtime", "random", "read_cnt", "check_pwd", "sig", "pwd", "subcmd", "begin_msgtime", "req_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, PbGetRoamMsgReq.class);
    }
  }
  
  public static final class PbGetRoamMsgResp
    extends MessageMicro<PbGetRoamMsgResp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt64Field last_msgtime = PBField.initUInt64(0L);
    public final PBRepeatMessageField<msg_comm.Msg> msg = PBField.initRepeatMessage(msg_comm.Msg.class);
    public final PBUInt64Field peer_uin = PBField.initUInt64(0L);
    public final PBUInt64Field random = PBField.initUInt64(0L);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50, 58 }, new String[] { "result", "errmsg", "peer_uin", "last_msgtime", "random", "msg", "sig" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, localByteStringMicro }, PbGetRoamMsgResp.class);
    }
  }
  
  public static final class PbGroupMsgWithDrawReq
    extends MessageMicro<PbGroupMsgWithDrawReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_userdef = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<MessageInfo> msg_list = PBField.initRepeatMessage(MessageInfo.class);
    public final PBUInt32Field uint32_group_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "uint32_sub_cmd", "uint32_group_type", "uint64_group_code", "msg_list", "bytes_userdef" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null, localByteStringMicro }, PbGroupMsgWithDrawReq.class);
    }
    
    public static final class MessageInfo
      extends MessageMicro<MessageInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_msg_seq", "uint32_msg_random", "uint32_msg_type", "uint32_resv_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, MessageInfo.class);
      public final PBUInt32Field uint32_msg_random = PBField.initUInt32(0);
      public final PBUInt32Field uint32_msg_seq = PBField.initUInt32(0);
      public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
      public final PBUInt32Field uint32_resv_flag = PBField.initUInt32(0);
    }
  }
  
  public static final class PbGroupMsgWithDrawResp
    extends MessageMicro<PbGroupMsgWithDrawResp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_userdef = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField errmsg = PBField.initString("");
    public final PBRepeatMessageField<MessageResult> failed_msg_list = PBField.initRepeatMessage(MessageResult.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50, 58 }, new String[] { "result", "errmsg", "uint32_sub_cmd", "uint32_group_type", "uint64_group_code", "failed_msg_list", "bytes_userdef" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null, localByteStringMicro }, PbGroupMsgWithDrawResp.class);
    }
    
    public static final class MessageResult
      extends MessageMicro<MessageResult>
    {
      static final MessageMicro.FieldMap __fieldMap__;
      public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBUInt32Field uint32_msg_random = PBField.initUInt32(0);
      public final PBUInt32Field uint32_msg_seq = PBField.initUInt32(0);
      public final PBUInt32Field uint32_msg_time = PBField.initUInt32(0);
      public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
      public final PBUInt32Field uint32_result = PBField.initUInt32(0);
      
      static
      {
        ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48 }, new String[] { "uint32_result", "uint32_msg_seq", "uint32_msg_time", "uint32_msg_random", "bytes_err_msg", "uint32_msg_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, MessageResult.class);
      }
    }
  }
  
  public static final class PbGroupReadedReportReq
    extends MessageMicro<PbGroupReadedReportReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "group_code", "last_read_seq" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, PbGroupReadedReportReq.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
    public final PBUInt64Field last_read_seq = PBField.initUInt64(0L);
  }
  
  public static final class PbGroupReadedReportResp
    extends MessageMicro<PbGroupReadedReportResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40 }, new String[] { "result", "errmsg", "group_code", "member_seq", "group_msg_seq" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, PbGroupReadedReportResp.class);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
    public final PBUInt64Field group_msg_seq = PBField.initUInt64(0L);
    public final PBUInt64Field member_seq = PBField.initUInt64(0L);
    public final PBUInt32Field result = PBField.initUInt32(0);
  }
  
  public static final class PbInputNotifyInfo
    extends MessageMicro<PbInputNotifyInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pb_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field ime = PBField.initUInt32(0);
    public final PBBytesField ios_push_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field notify_flag = PBField.initUInt32(0);
    public final PBUInt64Field to_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "to_uin", "ime", "notify_flag", "bytes_pb_reserve", "ios_push_wording" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, PbInputNotifyInfo.class);
    }
  }
  
  public static final class PbMsgReadedReportReq
    extends MessageMicro<PbMsgReadedReportReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "grp_read_report", "dis_read_report", "c2c_read_report", "bind_uin_read_report" }, new Object[] { null, null, null, null }, PbMsgReadedReportReq.class);
    public msg_svc.PbBindUinMsgReadedConfirmReq bind_uin_read_report = new msg_svc.PbBindUinMsgReadedConfirmReq();
    public msg_svc.PbC2CReadedReportReq c2c_read_report = new msg_svc.PbC2CReadedReportReq();
    public final PBRepeatMessageField<msg_svc.PbDiscussReadedReportReq> dis_read_report = PBField.initRepeatMessage(msg_svc.PbDiscussReadedReportReq.class);
    public final PBRepeatMessageField<msg_svc.PbGroupReadedReportReq> grp_read_report = PBField.initRepeatMessage(msg_svc.PbGroupReadedReportReq.class);
  }
  
  public static final class PbMsgReadedReportResp
    extends MessageMicro<PbMsgReadedReportResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "grp_read_report", "dis_read_report", "c2c_read_report", "bind_uin_read_report" }, new Object[] { null, null, null, null }, PbMsgReadedReportResp.class);
    public msg_svc.PbBindUinMsgReadedConfirmResp bind_uin_read_report = new msg_svc.PbBindUinMsgReadedConfirmResp();
    public msg_svc.PbC2CReadedReportResp c2c_read_report = new msg_svc.PbC2CReadedReportResp();
    public final PBRepeatMessageField<msg_svc.PbDiscussReadedReportResp> dis_read_report = PBField.initRepeatMessage(msg_svc.PbDiscussReadedReportResp.class);
    public final PBRepeatMessageField<msg_svc.PbGroupReadedReportResp> grp_read_report = PBField.initRepeatMessage(msg_svc.PbGroupReadedReportResp.class);
  }
  
  public static final class PbMsgWithDrawReq
    extends MessageMicro<PbMsgWithDrawReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "c2c_with_draw", "group_with_draw" }, new Object[] { null, null }, PbMsgWithDrawReq.class);
    public final PBRepeatMessageField<msg_svc.PbC2CMsgWithDrawReq> c2c_with_draw = PBField.initRepeatMessage(msg_svc.PbC2CMsgWithDrawReq.class);
    public final PBRepeatMessageField<msg_svc.PbGroupMsgWithDrawReq> group_with_draw = PBField.initRepeatMessage(msg_svc.PbGroupMsgWithDrawReq.class);
  }
  
  public static final class PbMsgWithDrawResp
    extends MessageMicro<PbMsgWithDrawResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "c2c_with_draw", "group_with_draw" }, new Object[] { null, null }, PbMsgWithDrawResp.class);
    public final PBRepeatMessageField<msg_svc.PbC2CMsgWithDrawResp> c2c_with_draw = PBField.initRepeatMessage(msg_svc.PbC2CMsgWithDrawResp.class);
    public final PBRepeatMessageField<msg_svc.PbGroupMsgWithDrawResp> group_with_draw = PBField.initRepeatMessage(msg_svc.PbGroupMsgWithDrawResp.class);
  }
  
  public static final class PbPullDiscussMsgSeqReq
    extends MessageMicro<PbPullDiscussMsgSeqReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "discuss_info_req" }, new Object[] { null }, PbPullDiscussMsgSeqReq.class);
    public final PBRepeatMessageField<DiscussInfoReq> discuss_info_req = PBField.initRepeatMessage(DiscussInfoReq.class);
    
    public static final class DiscussInfoReq
      extends MessageMicro<DiscussInfoReq>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "conf_uin", "last_seq" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, DiscussInfoReq.class);
      public final PBUInt64Field conf_uin = PBField.initUInt64(0L);
      public final PBUInt64Field last_seq = PBField.initUInt64(0L);
    }
  }
  
  public static final class PbPullDiscussMsgSeqResp
    extends MessageMicro<PbPullDiscussMsgSeqResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "result", "errmsg", "discuss_info_resp" }, new Object[] { Integer.valueOf(0), "", null }, PbPullDiscussMsgSeqResp.class);
    public final PBRepeatMessageField<DiscussInfoResp> discuss_info_resp = PBField.initRepeatMessage(DiscussInfoResp.class);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt32Field result = PBField.initUInt32(0);
    
    public static final class DiscussInfoResp
      extends MessageMicro<DiscussInfoResp>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "conf_uin", "member_seq", "conf_seq" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, DiscussInfoResp.class);
      public final PBUInt64Field conf_seq = PBField.initUInt64(0L);
      public final PBUInt64Field conf_uin = PBField.initUInt64(0L);
      public final PBUInt64Field member_seq = PBField.initUInt64(0L);
    }
  }
  
  public static final class PbPullGroupMsgSeqReq
    extends MessageMicro<PbPullGroupMsgSeqReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "group_info_req" }, new Object[] { null }, PbPullGroupMsgSeqReq.class);
    public final PBRepeatMessageField<GroupInfoReq> group_info_req = PBField.initRepeatMessage(GroupInfoReq.class);
    
    public static final class GroupInfoReq
      extends MessageMicro<GroupInfoReq>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "group_code", "last_seq" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, GroupInfoReq.class);
      public final PBUInt64Field group_code = PBField.initUInt64(0L);
      public final PBUInt64Field last_seq = PBField.initUInt64(0L);
    }
  }
  
  public static final class PbPullGroupMsgSeqResp
    extends MessageMicro<PbPullGroupMsgSeqResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "result", "errmsg", "group_info_resp" }, new Object[] { Integer.valueOf(0), "", null }, PbPullGroupMsgSeqResp.class);
    public final PBStringField errmsg = PBField.initString("");
    public final PBRepeatMessageField<GroupInfoResp> group_info_resp = PBField.initRepeatMessage(GroupInfoResp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    
    public static final class GroupInfoResp
      extends MessageMicro<GroupInfoResp>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "group_code", "member_seq", "group_seq" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, GroupInfoResp.class);
      public final PBUInt64Field group_code = PBField.initUInt64(0L);
      public final PBUInt64Field group_seq = PBField.initUInt64(0L);
      public final PBUInt64Field member_seq = PBField.initUInt64(0L);
    }
  }
  
  public static final class PbSearchRoamMsgInCloudReq
    extends MessageMicro<PbSearchRoamMsgInCloudReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField serialize_reqbody = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "serialize_reqbody" }, new Object[] { localByteStringMicro }, PbSearchRoamMsgInCloudReq.class);
    }
  }
  
  public static final class PbSearchRoamMsgInCloudResp
    extends MessageMicro<PbSearchRoamMsgInCloudResp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<msg_comm.Msg> msg = PBField.initRepeatMessage(msg_comm.Msg.class);
    public final PBBytesField serialize_rspbody = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg", "serialize_rspbody" }, new Object[] { null, localByteStringMicro }, PbSearchRoamMsgInCloudResp.class);
    }
  }
  
  public static final class PbSendMsgReq
    extends MessageMicro<PbSendMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public msg_comm.AppShareInfo app_share = new msg_comm.AppShareInfo();
    public msg_comm.ContentHead content_head = new msg_comm.ContentHead();
    public final PBUInt32Field data_statist = PBField.initUInt32(0);
    public msg_svc.PbInputNotifyInfo input_notify_info = new msg_svc.PbInputNotifyInfo();
    public im_msg_body.MsgBody msg_body = new im_msg_body.MsgBody();
    public msg_ctrl.MsgCtrl msg_ctrl = new msg_ctrl.MsgCtrl();
    public final PBUInt32Field msg_rand = PBField.initUInt32(0);
    public final PBUInt32Field msg_seq = PBField.initUInt32(0);
    public final PBUInt32Field msg_via = PBField.initUInt32(0);
    public msg_svc.MultiMsgAssist multi_msg_assist = new msg_svc.MultiMsgAssist();
    public final PBUInt32Field multi_send_seq = PBField.initUInt32(0);
    public im_receipt.ReceiptReq receipt_req = new im_receipt.ReceiptReq();
    public msg_svc.RoutingHead routing_head = new msg_svc.RoutingHead();
    public final PBBytesField sync_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 50, 58, 64, 72, 82, 90, 98, 106, 112 }, new String[] { "routing_head", "content_head", "msg_body", "msg_seq", "msg_rand", "sync_cookie", "app_share", "msg_via", "data_statist", "multi_msg_assist", "input_notify_info", "msg_ctrl", "receipt_req", "multi_send_seq" }, new Object[] { null, null, null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, null, Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, Integer.valueOf(0) }, PbSendMsgReq.class);
    }
  }
  
  public static final class PbSendMsgResp
    extends MessageMicro<PbSendMsgResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 48, 58, 66, 72 }, new String[] { "result", "errmsg", "send_time", "uint32_svrbusy_wait_time", "msg_send_info", "errtype", "trans_svr_info", "receipt_resp", "text_analysis_result" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), null, null, Integer.valueOf(0) }, PbSendMsgResp.class);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt32Field errtype = PBField.initUInt32(0);
    public msg_svc.MsgSendInfo msg_send_info = new msg_svc.MsgSendInfo();
    public im_receipt.ReceiptResp receipt_resp = new im_receipt.ReceiptResp();
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBUInt32Field send_time = PBField.initUInt32(0);
    public final PBUInt32Field text_analysis_result = PBField.initUInt32(0);
    public msg_svc.TransSvrInfo trans_svr_info = new msg_svc.TransSvrInfo();
    public final PBUInt32Field uint32_svrbusy_wait_time = PBField.initUInt32(0);
  }
  
  public static final class PbThirdQQUnReadMsgNumReq
    extends MessageMicro<PbThirdQQUnReadMsgNumReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "thirdqq_req_info", "source" }, new Object[] { null, Integer.valueOf(0) }, PbThirdQQUnReadMsgNumReq.class);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBRepeatMessageField<ThirdQQReqInfo> thirdqq_req_info = PBField.initRepeatMessage(ThirdQQReqInfo.class);
    
    public static final class ThirdQQReqInfo
      extends MessageMicro<ThirdQQReqInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__;
      public final PBUInt64Field third_uin = PBField.initUInt64(0L);
      public final PBBytesField third_uin_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField third_uin_sig = PBField.initBytes(ByteStringMicro.EMPTY);
      
      static
      {
        ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "third_uin", "third_uin_sig", "third_uin_cookie" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, ThirdQQReqInfo.class);
      }
    }
  }
  
  public static final class PbThirdQQUnReadMsgNumResp
    extends MessageMicro<PbThirdQQUnReadMsgNumResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "result", "errmsg", "thirdqq_resp_info", "interval" }, new Object[] { Integer.valueOf(0), "", null, Integer.valueOf(0) }, PbThirdQQUnReadMsgNumResp.class);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt32Field interval = PBField.initUInt32(0);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBRepeatMessageField<ThirdQQRespInfo> thirdqq_resp_info = PBField.initRepeatMessage(ThirdQQRespInfo.class);
    
    public static final class ThirdQQRespInfo
      extends MessageMicro<ThirdQQRespInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__;
      public final PBUInt32Field last_msg_time = PBField.initUInt32(0);
      public final PBUInt32Field msg_flag = PBField.initUInt32(0);
      public final PBUInt32Field msg_num = PBField.initUInt32(0);
      public final PBUInt32Field redbag_time = PBField.initUInt32(0);
      public final PBUInt32Field status = PBField.initUInt32(0);
      public final PBUInt64Field third_uin = PBField.initUInt64(0L);
      public final PBBytesField third_uin_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
      
      static
      {
        ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56 }, new String[] { "third_uin", "third_uin_cookie", "msg_num", "msg_flag", "redbag_time", "status", "last_msg_time" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ThirdQQRespInfo.class);
      }
    }
  }
  
  public static final class PbUnReadMsgSeqReq
    extends MessageMicro<PbUnReadMsgSeqReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "c2c_unread_info", "binduin_unread_info", "group_unread_info", "discuss_unread_info", "thirdqq_unread_info" }, new Object[] { null, null, null, null, null }, PbUnReadMsgSeqReq.class);
    public final PBRepeatMessageField<msg_svc.PbBindUinUnReadMsgNumReq> binduin_unread_info = PBField.initRepeatMessage(msg_svc.PbBindUinUnReadMsgNumReq.class);
    public msg_svc.PbC2CUnReadMsgNumReq c2c_unread_info = new msg_svc.PbC2CUnReadMsgNumReq();
    public msg_svc.PbPullDiscussMsgSeqReq discuss_unread_info = new msg_svc.PbPullDiscussMsgSeqReq();
    public msg_svc.PbPullGroupMsgSeqReq group_unread_info = new msg_svc.PbPullGroupMsgSeqReq();
    public msg_svc.PbThirdQQUnReadMsgNumReq thirdqq_unread_info = new msg_svc.PbThirdQQUnReadMsgNumReq();
  }
  
  public static final class PbUnReadMsgSeqResp
    extends MessageMicro<PbUnReadMsgSeqResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "c2c_unread_info", "binduin_unread_info", "group_unread_info", "discuss_unread_info", "thirdqq_unread_info" }, new Object[] { null, null, null, null, null }, PbUnReadMsgSeqResp.class);
    public final PBRepeatMessageField<msg_svc.PbBindUinUnReadMsgNumResp> binduin_unread_info = PBField.initRepeatMessage(msg_svc.PbBindUinUnReadMsgNumResp.class);
    public msg_svc.PbC2CUnReadMsgNumResp c2c_unread_info = new msg_svc.PbC2CUnReadMsgNumResp();
    public msg_svc.PbPullDiscussMsgSeqResp discuss_unread_info = new msg_svc.PbPullDiscussMsgSeqResp();
    public msg_svc.PbPullGroupMsgSeqResp group_unread_info = new msg_svc.PbPullGroupMsgSeqResp();
    public msg_svc.PbThirdQQUnReadMsgNumResp thirdqq_unread_info = new msg_svc.PbThirdQQUnReadMsgNumResp();
  }
  
  public static final class PubGroupTmp
    extends MessageMicro<PubGroupTmp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field group_uin = PBField.initUInt64(0L);
    public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field to_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "to_uin", "sig", "group_uin" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Long.valueOf(0L) }, PubGroupTmp.class);
    }
  }
  
  public static final class PublicPlat
    extends MessageMicro<PublicPlat>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field to_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "to_uin", "sig" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, PublicPlat.class);
    }
  }
  
  public static final class QQQueryBusinessTmp
    extends MessageMicro<QQQueryBusinessTmp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field to_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "to_uin", "sig" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, QQQueryBusinessTmp.class);
    }
  }
  
  public static final class RichStatusTmp
    extends MessageMicro<RichStatusTmp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field to_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "to_uin", "sig" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, RichStatusTmp.class);
    }
  }
  
  public static final class RoutingHead
    extends MessageMicro<RoutingHead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170, 178 }, new String[] { "c2c", "grp", "grp_tmp", "dis", "dis_tmp", "wpa_tmp", "secret_file", "public_plat", "trans_msg", "address_list", "rich_status_tmp", "trans_cmd", "accost_tmp", "pub_group_tmp", "trans_0x211", "business_wpa_tmp", "auth_tmp", "bsns_tmp", "qq_querybusiness_tmp", "nearby_dating_tmp", "nearby_assistant_tmp", "comm_tmp" }, new Object[] { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, RoutingHead.class);
    public msg_svc.AccostTmp accost_tmp = new msg_svc.AccostTmp();
    public msg_svc.AddressListTmp address_list = new msg_svc.AddressListTmp();
    public msg_svc.AuthTmp auth_tmp = new msg_svc.AuthTmp();
    public msg_svc.BsnsTmp bsns_tmp = new msg_svc.BsnsTmp();
    public msg_svc.BusinessWPATmp business_wpa_tmp = new msg_svc.BusinessWPATmp();
    public msg_svc.C2C c2c = new msg_svc.C2C();
    public msg_svc.CommTmp comm_tmp = new msg_svc.CommTmp();
    public msg_svc.Dis dis = new msg_svc.Dis();
    public msg_svc.DisTmp dis_tmp = new msg_svc.DisTmp();
    public msg_svc.Grp grp = new msg_svc.Grp();
    public msg_svc.GrpTmp grp_tmp = new msg_svc.GrpTmp();
    public msg_svc.NearByAssistantTmp nearby_assistant_tmp = new msg_svc.NearByAssistantTmp();
    public msg_svc.NearByDatingTmp nearby_dating_tmp = new msg_svc.NearByDatingTmp();
    public msg_svc.PubGroupTmp pub_group_tmp = new msg_svc.PubGroupTmp();
    public msg_svc.PublicPlat public_plat = new msg_svc.PublicPlat();
    public msg_svc.QQQueryBusinessTmp qq_querybusiness_tmp = new msg_svc.QQQueryBusinessTmp();
    public msg_svc.RichStatusTmp rich_status_tmp = new msg_svc.RichStatusTmp();
    public msg_svc.SecretFileHead secret_file = new msg_svc.SecretFileHead();
    public msg_svc.Trans0x211 trans_0x211 = new msg_svc.Trans0x211();
    public msg_svc.TransCmd trans_cmd = new msg_svc.TransCmd();
    public msg_svc.TransMsg trans_msg = new msg_svc.TransMsg();
    public msg_svc.WPATmp wpa_tmp = new msg_svc.WPATmp();
  }
  
  public static final class SecretFileHead
    extends MessageMicro<SecretFileHead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "secret_file_msg", "secret_file_status" }, new Object[] { null, null }, SecretFileHead.class);
    public SubMsgType0xc1.MsgBody secret_file_msg = new SubMsgType0xc1.MsgBody();
    public SubMsgType0x1a.MsgBody secret_file_status = new SubMsgType0x1a.MsgBody();
  }
  
  public static final class Trans0x211
    extends MessageMicro<Trans0x211>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field c2c_type = PBField.initUInt32(0);
    public final PBUInt32Field cc_cmd = PBField.initUInt32(0);
    public im_msg_head.InstCtrl inst_ctrl = new im_msg_head.InstCtrl();
    public final PBUInt32Field service_type = PBField.initUInt32(0);
    public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field to_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48 }, new String[] { "to_uin", "cc_cmd", "inst_ctrl", "sig", "c2c_type", "service_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, Trans0x211.class);
    }
  }
  
  public static final class TransCmd
    extends MessageMicro<TransCmd>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "to_uin", "msg_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, TransCmd.class);
    public final PBUInt32Field msg_type = PBField.initUInt32(0);
    public final PBUInt64Field to_uin = PBField.initUInt64(0L);
  }
  
  public static final class TransMsg
    extends MessageMicro<TransMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "to_uin", "c2c_cmd" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, TransMsg.class);
    public final PBUInt32Field c2c_cmd = PBField.initUInt32(0);
    public final PBUInt64Field to_uin = PBField.initUInt64(0L);
  }
  
  public static final class TransReq
    extends MessageMicro<TransReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field command = PBField.initInt32(0);
    public final PBBytesField req_buff = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field req_tag = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "command", "req_tag", "req_buff" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, TransReq.class);
    }
  }
  
  public static final class TransResp
    extends MessageMicro<TransResp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField errmsg = PBField.initString("");
    public final PBBytesField resp_buff = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field resp_tag = PBField.initUInt32(0);
    public final PBUInt32Field result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "result", "errmsg", "resp_tag", "resp_buff" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), localByteStringMicro }, TransResp.class);
    }
  }
  
  public static final class TransSvrInfo
    extends MessageMicro<TransSvrInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_trans_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBUInt32Field uint32_sub_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_sub_type", "int32_ret_code", "bytes_err_msg", "bytes_trans_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, TransSvrInfo.class);
    }
  }
  
  public static final class WPATmp
    extends MessageMicro<WPATmp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field to_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "to_uin", "sig" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, WPATmp.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     msf.msgsvc.msg_svc
 * JD-Core Version:    0.7.0.1
 */