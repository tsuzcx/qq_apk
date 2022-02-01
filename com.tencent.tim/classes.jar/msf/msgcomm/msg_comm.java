package msf.msgcomm;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_head.InstCtrl;

public final class msg_comm
{
  public static final class AppShareInfo
    extends MessageMicro<AppShareInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField appshare_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field appshare_id = PBField.initUInt32(0);
    public msg_comm.PluginInfo appshare_resource = new msg_comm.PluginInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "appshare_id", "appshare_cookie", "appshare_resource" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null }, AppShareInfo.class);
    }
  }
  
  public static final class C2CTmpMsgHead
    extends MessageMicro<C2CTmpMsgHead>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field c2c_type = PBField.initUInt32(0);
    public final PBUInt32Field direction_flag = PBField.initUInt32(0);
    public final PBStringField from_phone = PBField.initString("");
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
    public final PBUInt64Field group_uin = PBField.initUInt64(0L);
    public final PBUInt32Field lock_display = PBField.initUInt32(0);
    public final PBBytesField reserved = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field service_type = PBField.initUInt32(0);
    public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field sig_type = PBField.initUInt32(0);
    public final PBStringField to_phone = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 58, 66, 72, 80, 90 }, new String[] { "c2c_type", "service_type", "group_uin", "group_code", "sig", "sig_type", "from_phone", "to_phone", "lock_display", "direction_flag", "reserved" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, C2CTmpMsgHead.class);
    }
  }
  
  public static final class ContentHead
    extends MessageMicro<ContentHead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "pkg_num", "pkg_index", "div_seq", "auto_reply" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ContentHead.class);
    public final PBUInt32Field auto_reply = PBField.initUInt32(0);
    public final PBUInt32Field div_seq = PBField.initUInt32(0);
    public final PBUInt32Field pkg_index = PBField.initUInt32(0);
    public final PBUInt32Field pkg_num = PBField.initUInt32(0);
  }
  
  public static final class DiscussInfo
    extends MessageMicro<DiscussInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field discuss_info_seq = PBField.initUInt64(0L);
    public final PBBytesField discuss_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField discuss_remark = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field discuss_type = PBField.initUInt32(0);
    public final PBUInt64Field discuss_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "discuss_uin", "discuss_type", "discuss_info_seq", "discuss_remark", "discuss_name" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, DiscussInfo.class);
    }
  }
  
  public static final class ExtGroupKeyInfo
    extends MessageMicro<ExtGroupKeyInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ext_group_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field cur_max_seq = PBField.initUInt32(0);
    public final PBUInt64Field cur_time = PBField.initUInt64(0L);
    public final PBUInt32Field operate_by_parents = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "cur_max_seq", "cur_time", "operate_by_parents", "bytes_ext_group_info" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, ExtGroupKeyInfo.class);
    }
  }
  
  public static final class GroupInfo
    extends MessageMicro<GroupInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField group_card = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field group_card_type = PBField.initUInt32(0);
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
    public final PBUInt64Field group_info_seq = PBField.initUInt64(0L);
    public final PBUInt32Field group_level = PBField.initUInt32(0);
    public final PBBytesField group_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField group_rank = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field group_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 56, 66 }, new String[] { "group_code", "group_type", "group_info_seq", "group_card", "group_rank", "group_level", "group_card_type", "group_name" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3 }, GroupInfo.class);
    }
  }
  
  public static final class Msg
    extends MessageMicro<Msg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "msg_head", "content_head", "msg_body", "appshare_info" }, new Object[] { null, null, null, null }, Msg.class);
    public msg_comm.AppShareInfo appshare_info = new msg_comm.AppShareInfo();
    public msg_comm.ContentHead content_head = new msg_comm.ContentHead();
    public im_msg_body.MsgBody msg_body = new im_msg_body.MsgBody();
    public msg_comm.MsgHead msg_head = new msg_comm.MsgHead();
  }
  
  public static final class MsgHead
    extends MessageMicro<MsgHead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66, 74, 80, 88, 96, 106, 114, 120, 130, 136, 146, 154, 162, 170, 176, 184, 192, 202, 210, 216, 224 }, new String[] { "from_uin", "to_uin", "msg_type", "c2c_cmd", "msg_seq", "msg_time", "msg_uid", "c2c_tmp_msg_head", "group_info", "from_appid", "from_instid", "user_active", "discuss_info", "from_nick", "auth_uin", "auth_nick", "msg_flag", "auth_remark", "group_name", "mutiltrans_head", "msg_inst_ctrl", "public_account_group_send_flag", "wseq_in_c2c_msghead", "cpid", "ext_group_key_info", "multi_compatible_text", "auth_sex", "is_src_msg" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, "", Long.valueOf(0L), "", Integer.valueOf(0), "", "", null, null, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null, "", Integer.valueOf(0), Boolean.valueOf(false) }, MsgHead.class);
    public final PBStringField auth_nick = PBField.initString("");
    public final PBStringField auth_remark = PBField.initString("");
    public final PBUInt32Field auth_sex = PBField.initUInt32(0);
    public final PBUInt64Field auth_uin = PBField.initUInt64(0L);
    public final PBUInt32Field c2c_cmd = PBField.initUInt32(0);
    public msg_comm.C2CTmpMsgHead c2c_tmp_msg_head = new msg_comm.C2CTmpMsgHead();
    public final PBUInt64Field cpid = PBField.initUInt64(0L);
    public msg_comm.DiscussInfo discuss_info = new msg_comm.DiscussInfo();
    public msg_comm.ExtGroupKeyInfo ext_group_key_info = new msg_comm.ExtGroupKeyInfo();
    public final PBUInt32Field from_appid = PBField.initUInt32(0);
    public final PBUInt32Field from_instid = PBField.initUInt32(0);
    public final PBStringField from_nick = PBField.initString("");
    public final PBUInt64Field from_uin = PBField.initUInt64(0L);
    public msg_comm.GroupInfo group_info = new msg_comm.GroupInfo();
    public final PBStringField group_name = PBField.initString("");
    public final PBBoolField is_src_msg = PBField.initBool(false);
    public final PBUInt32Field msg_flag = PBField.initUInt32(0);
    public im_msg_head.InstCtrl msg_inst_ctrl = new im_msg_head.InstCtrl();
    public final PBUInt32Field msg_seq = PBField.initUInt32(0);
    public final PBUInt32Field msg_time = PBField.initUInt32(0);
    public final PBUInt32Field msg_type = PBField.initUInt32(0);
    public final PBUInt64Field msg_uid = PBField.initUInt64(0L);
    public final PBStringField multi_compatible_text = PBField.initString("");
    public msg_comm.MutilTransHead mutiltrans_head = new msg_comm.MutilTransHead();
    public final PBUInt32Field public_account_group_send_flag = PBField.initUInt32(0);
    public final PBUInt64Field to_uin = PBField.initUInt64(0L);
    public final PBUInt32Field user_active = PBField.initUInt32(0);
    public final PBUInt32Field wseq_in_c2c_msghead = PBField.initUInt32(0);
  }
  
  public static final class MsgType0x210
    extends MessageMicro<MsgType0x210>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField msg_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field sub_msg_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "sub_msg_type", "msg_content" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, MsgType0x210.class);
    }
  }
  
  public static final class MutilTransHead
    extends MessageMicro<MutilTransHead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "status", "msgId" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, MutilTransHead.class);
    public final PBUInt32Field msgId = PBField.initUInt32(0);
    public final PBUInt32Field status = PBField.initUInt32(0);
  }
  
  public static final class PluginInfo
    extends MessageMicro<PluginInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 58, 66, 74, 82, 90 }, new String[] { "res_id", "pkg_name", "new_ver", "res_type", "lan_type", "priority", "res_name", "res_desc", "res_url_big", "res_url_small", "res_conf" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", "" }, PluginInfo.class);
    public final PBUInt32Field lan_type = PBField.initUInt32(0);
    public final PBUInt32Field new_ver = PBField.initUInt32(0);
    public final PBStringField pkg_name = PBField.initString("");
    public final PBUInt32Field priority = PBField.initUInt32(0);
    public final PBStringField res_conf = PBField.initString("");
    public final PBStringField res_desc = PBField.initString("");
    public final PBUInt32Field res_id = PBField.initUInt32(0);
    public final PBStringField res_name = PBField.initString("");
    public final PBUInt32Field res_type = PBField.initUInt32(0);
    public final PBStringField res_url_big = PBField.initString("");
    public final PBStringField res_url_small = PBField.initString("");
  }
  
  public static final class Uin2Nick
    extends MessageMicro<Uin2Nick>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_uin", "str_nick" }, new Object[] { Long.valueOf(0L), "" }, Uin2Nick.class);
    public final PBStringField str_nick = PBField.initString("");
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class UinPairMsg
    extends MessageMicro<UinPairMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pb_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field c2c_type = PBField.initUInt32(0);
    public final PBUInt32Field last_read_time = PBField.initUInt32(0);
    public final PBRepeatMessageField<msg_comm.Msg> msg = PBField.initRepeatMessage(msg_comm.Msg.class);
    public final PBUInt32Field msg_completed = PBField.initUInt32(0);
    public final PBUInt64Field peer_uin = PBField.initUInt64(0L);
    public final PBUInt32Field service_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_to_tiny_id = PBField.initUInt64(0L);
    public final PBUInt32Field unread_msg_num = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 64, 72, 82, 88 }, new String[] { "last_read_time", "peer_uin", "msg_completed", "msg", "unread_msg_num", "c2c_type", "service_type", "bytes_pb_reserve", "uint64_to_tiny_id" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L) }, UinPairMsg.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     msf.msgcomm.msg_comm
 * JD-Core Version:    0.7.0.1
 */