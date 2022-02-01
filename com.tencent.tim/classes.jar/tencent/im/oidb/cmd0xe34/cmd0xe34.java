package tencent.im.oidb.cmd0xe34;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xe34
{
  public static final class BindUinInfo
    extends MessageMicro<BindUinInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint64_uin", "uint32_app_id", "uint32_instance_id", "msg_login_sig" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null }, BindUinInfo.class);
    public cmd0xe34.LoginSig msg_login_sig = new cmd0xe34.LoginSig();
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_instance_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class C2CMsgUnreadNumInfo
    extends MessageMicro<C2CMsgUnreadNumInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "peer_uin_num", "msg_num", "last_msg_time" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, C2CMsgUnreadNumInfo.class);
    public final PBUInt32Field last_msg_time = PBField.initUInt32(0);
    public final PBUInt32Field msg_num = PBField.initUInt32(0);
    public final PBUInt32Field peer_uin_num = PBField.initUInt32(0);
  }
  
  public static final class GroupMsgUnreadNumInfo
    extends MessageMicro<GroupMsgUnreadNumInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "group_num", "msg_num", "last_msg_time" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GroupMsgUnreadNumInfo.class);
    public final PBUInt32Field group_num = PBField.initUInt32(0);
    public final PBUInt32Field last_msg_time = PBField.initUInt32(0);
    public final PBUInt32Field msg_num = PBField.initUInt32(0);
  }
  
  public static final class LoginSig
    extends MessageMicro<LoginSig>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_type", "bytes_sig", "uint32_appid" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, LoginSig.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_bind_uin_info" }, new Object[] { null }, ReqBody.class);
    public final PBRepeatMessageField<cmd0xe34.BindUinInfo> rpt_bind_uin_info = PBField.initRepeatMessage(cmd0xe34.BindUinInfo.class);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rpt_unread_info", "ReqInterval" }, new Object[] { null, Integer.valueOf(0) }, RspBody.class);
    public final PBUInt32Field ReqInterval = PBField.initUInt32(0);
    public final PBRepeatMessageField<cmd0xe34.UnReadInfo> rpt_unread_info = PBField.initRepeatMessage(cmd0xe34.UnReadInfo.class);
  }
  
  public static final class UnReadInfo
    extends MessageMicro<UnReadInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uint64_uin", "c2c_info", "group_info", "retcode" }, new Object[] { Long.valueOf(0L), null, null, Integer.valueOf(0) }, UnReadInfo.class);
    public cmd0xe34.C2CMsgUnreadNumInfo c2c_info = new cmd0xe34.C2CMsgUnreadNumInfo();
    public cmd0xe34.GroupMsgUnreadNumInfo group_info = new cmd0xe34.GroupMsgUnreadNumInfo();
    public final PBInt32Field retcode = PBField.initInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe34.cmd0xe34
 * JD-Core Version:    0.7.0.1
 */