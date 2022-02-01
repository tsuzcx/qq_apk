package tencent.im.oidb.cmd0x5d2;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x5d2
{
  public static final class FriendInfo
    extends MessageMicro<FriendInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field age = PBField.initUInt32(0);
    public final PBUInt32Field gender = PBField.initUInt32(0);
    public final PBUInt32Field group = PBField.initUInt32(0);
    public final PBUInt32Field login = PBField.initUInt32(0);
    public final PBBytesField remark = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50 }, new String[] { "uin", "gender", "age", "group", "login", "remark" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, FriendInfo.class);
    }
  }
  
  public static final class FriendList
    extends MessageMicro<FriendList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uin", "nick" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, FriendList.class);
    }
  }
  
  public static final class GroupInfo
    extends MessageMicro<GroupInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field id = PBField.initUInt32(0);
    public final PBBytesField name = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "id", "name" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, GroupInfo.class);
    }
  }
  
  public static final class LoginInfo
    extends MessageMicro<LoginInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field id = PBField.initUInt32(0);
    public final PBBytesField name = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "id", "name" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, LoginInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "sub_cmd", "req_get_list", "req_get_info" }, new Object[] { Integer.valueOf(0), null, null }, ReqBody.class);
    public oidb_0x5d2.ReqGetInfo req_get_info = new oidb_0x5d2.ReqGetInfo();
    public oidb_0x5d2.ReqGetList req_get_list = new oidb_0x5d2.ReqGetList();
    public final PBUInt32Field sub_cmd = PBField.initUInt32(0);
  }
  
  public static final class ReqGetInfo
    extends MessageMicro<ReqGetInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uin_list" }, new Object[] { Long.valueOf(0L) }, ReqGetInfo.class);
    public final PBRepeatField<Long> uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class ReqGetList
    extends MessageMicro<ReqGetList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "seq" }, new Object[] { Integer.valueOf(0) }, ReqGetList.class);
    public final PBUInt32Field seq = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "sub_cmd", "rsp_get_list", "rsp_get_info" }, new Object[] { Integer.valueOf(0), null, null }, RspBody.class);
    public oidb_0x5d2.RspGetInfo rsp_get_info = new oidb_0x5d2.RspGetInfo();
    public oidb_0x5d2.RspGetList rsp_get_list = new oidb_0x5d2.RspGetList();
    public final PBUInt32Field sub_cmd = PBField.initUInt32(0);
  }
  
  public static final class RspGetInfo
    extends MessageMicro<RspGetInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40 }, new String[] { "group_info", "login_info", "time", "frd_info", "frd_delete" }, new Object[] { null, null, Integer.valueOf(0), null, Long.valueOf(0L) }, RspGetInfo.class);
    public final PBRepeatField<Long> frd_delete = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatMessageField<oidb_0x5d2.FriendInfo> frd_info = PBField.initRepeatMessage(oidb_0x5d2.FriendInfo.class);
    public final PBRepeatMessageField<oidb_0x5d2.GroupInfo> group_info = PBField.initRepeatMessage(oidb_0x5d2.GroupInfo.class);
    public final PBRepeatMessageField<oidb_0x5d2.LoginInfo> login_info = PBField.initRepeatMessage(oidb_0x5d2.LoginInfo.class);
    public final PBUInt32Field time = PBField.initUInt32(0);
  }
  
  public static final class RspGetList
    extends MessageMicro<RspGetList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "seq", "list" }, new Object[] { Integer.valueOf(0), null }, RspGetList.class);
    public final PBRepeatMessageField<oidb_0x5d2.FriendList> list = PBField.initRepeatMessage(oidb_0x5d2.FriendList.class);
    public final PBUInt32Field seq = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5d2.oidb_0x5d2
 * JD-Core Version:    0.7.0.1
 */