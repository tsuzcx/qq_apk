package tencent.im.oidb.cmd0xbe4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xbe4
{
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ext_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_cmd0xbe4.MsgContent msg_content = new oidb_cmd0xbe4.MsgContent();
    public oidb_cmd0xbe4.MsgFolderInfo msg_folder_info = new oidb_cmd0xbe4.MsgFolderInfo();
    public final PBStringField str_msgid = PBField.initString("");
    public final PBUInt32Field uint32_msg_sub_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_msg_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 66, 74, 82, 88 }, new String[] { "uint64_seq", "uint64_msg_time", "uint32_msg_type", "uint64_from_uin", "bytes_pic_url", "bytes_jump_url", "msg_folder_info", "msg_content", "bytes_ext_data", "str_msgid", "uint32_msg_sub_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, null, null, localByteStringMicro3, "", Integer.valueOf(0) }, MsgBody.class);
    }
  }
  
  public static final class MsgContent
    extends MessageMicro<MsgContent>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 90, 98, 106, 112 }, new String[] { "string_feeds_id", "uint32_feed_type", "uint32_type", "str_desc", "str_feeds_pic", "string_sys_activityid", "uint32_sys_from" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), "", "", "", Integer.valueOf(0) }, MsgContent.class);
    public final PBStringField str_desc = PBField.initString("");
    public final PBStringField str_feeds_pic = PBField.initString("");
    public final PBStringField string_feeds_id = PBField.initString("");
    public final PBStringField string_sys_activityid = PBField.initString("");
    public final PBUInt32Field uint32_feed_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sys_from = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  }
  
  public static final class MsgFolderInfo
    extends MessageMicro<MsgFolderInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_orange_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_summary = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field folder_red_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_show_folder = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_show_folder", "folder_red_type", "bytes_orange_word", "bytes_summary" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, MsgFolderInfo.class);
    }
  }
  
  public static final class MsgGetReq
    extends MessageMicro<MsgGetReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_last_msg", "uint32_msg_content", "str_msgid" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "" }, MsgGetReq.class);
    public final PBStringField str_msgid = PBField.initString("");
    public final PBUInt32Field uint32_last_msg = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_content = PBField.initUInt32(0);
  }
  
  public static final class MsgGetRsp
    extends MessageMicro<MsgGetRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_unread", "uint64_max_seq", "msg_body" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), null }, MsgGetRsp.class);
    public oidb_cmd0xbe4.MsgBody msg_body = new oidb_cmd0xbe4.MsgBody();
    public final PBUInt64Field uint64_max_seq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_unread = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "client_version", "msg_get_req" }, new Object[] { "", null }, ReqBody.class);
    public final PBStringField client_version = PBField.initString("");
    public oidb_cmd0xbe4.MsgGetReq msg_get_req = new oidb_cmd0xbe4.MsgGetReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_get_rsp" }, new Object[] { null }, RspBody.class);
    public oidb_cmd0xbe4.MsgGetRsp msg_get_rsp = new oidb_cmd0xbe4.MsgGetRsp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4
 * JD-Core Version:    0.7.0.1
 */