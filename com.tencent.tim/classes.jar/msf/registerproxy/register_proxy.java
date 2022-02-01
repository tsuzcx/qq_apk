package msf.registerproxy;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class register_proxy
{
  public static final class DiscussList
    extends MessageMicro<DiscussList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64 }, new String[] { "discuss_code", "discuss_seq", "member_seq", "info_seq", "bHotGroup", "redpack_time", "has_msg", "dicuss_flag" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false), Long.valueOf(0L), Boolean.valueOf(false), Long.valueOf(0L) }, DiscussList.class);
    public final PBBoolField bHotGroup = PBField.initBool(false);
    public final PBInt64Field dicuss_flag = PBField.initInt64(0L);
    public final PBUInt64Field discuss_code = PBField.initUInt64(0L);
    public final PBUInt64Field discuss_seq = PBField.initUInt64(0L);
    public final PBBoolField has_msg = PBField.initBool(false);
    public final PBUInt64Field info_seq = PBField.initUInt64(0L);
    public final PBUInt64Field member_seq = PBField.initUInt64(0L);
    public final PBUInt64Field redpack_time = PBField.initUInt64(0L);
  }
  
  public static final class GroupList
    extends MessageMicro<GroupList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80 }, new String[] { "group_code", "group_seq", "member_seq", "mask", "redpack_time", "has_msg", "group_flag", "group_type", "group_name_seq", "group_member_seq" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, GroupList.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
    public final PBInt64Field group_flag = PBField.initInt64(0L);
    public final PBUInt32Field group_member_seq = PBField.initUInt32(0);
    public final PBUInt32Field group_name_seq = PBField.initUInt32(0);
    public final PBUInt64Field group_seq = PBField.initUInt64(0L);
    public final PBUInt64Field group_type = PBField.initUInt64(0L);
    public final PBBoolField has_msg = PBField.initBool(false);
    public final PBUInt64Field mask = PBField.initUInt64(0L);
    public final PBUInt64Field member_seq = PBField.initUInt64(0L);
    public final PBUInt64Field redpack_time = PBField.initUInt64(0L);
  }
  
  public static final class SvcPbResponsePullDisMsgProxy
    extends MessageMicro<SvcPbResponsePullDisMsgProxy>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field member_seq = PBField.initUInt64(0L);
    public final PBBytesField msg_content = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "member_seq", "msg_content" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, SvcPbResponsePullDisMsgProxy.class);
    }
  }
  
  public static final class SvcRegisterProxyMsgResp
    extends MessageMicro<SvcRegisterProxyMsgResp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField c2c_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<register_proxy.DiscussList> discuss_list = PBField.initRepeatMessage(register_proxy.DiscussList.class);
    public final PBUInt32Field discuss_list_flag = PBField.initUInt32(0);
    public final PBRepeatMessageField<register_proxy.SvcPbResponsePullDisMsgProxy> discuss_msg = PBField.initRepeatMessage(register_proxy.SvcPbResponsePullDisMsgProxy.class);
    public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field flag = PBField.initUInt32(0);
    public final PBRepeatMessageField<register_proxy.SvcResponsePbPullGroupMsgProxy> gourp_msg = PBField.initRepeatMessage(register_proxy.SvcResponsePbPullGroupMsgProxy.class);
    public final PBRepeatMessageField<register_proxy.GroupList> group_list = PBField.initRepeatMessage(register_proxy.GroupList.class);
    public register_proxy.SvcResponseMsgInfo msg_info = new register_proxy.SvcResponseMsgInfo();
    public final PBBytesField pub_account_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBUInt32Field seq = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50, 58, 66, 74, 82, 90, 96 }, new String[] { "result", "err_msg", "flag", "seq", "msg_info", "group_list", "discuss_list", "gourp_msg", "discuss_msg", "c2c_msg", "pub_account_msg", "discuss_list_flag" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0) }, SvcRegisterProxyMsgResp.class);
    }
  }
  
  public static final class SvcResponseMsgInfo
    extends MessageMicro<SvcResponseMsgInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "group_num", "discuss_num" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, SvcResponseMsgInfo.class);
    public final PBUInt32Field discuss_num = PBField.initUInt32(0);
    public final PBUInt32Field group_num = PBField.initUInt32(0);
  }
  
  public static final class SvcResponsePbPullGroupMsgProxy
    extends MessageMicro<SvcResponsePbPullGroupMsgProxy>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field member_seq = PBField.initUInt64(0L);
    public final PBBytesField msg_content = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "member_seq", "msg_content" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, SvcResponsePbPullGroupMsgProxy.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     msf.registerproxy.register_proxy
 * JD-Core Version:    0.7.0.1
 */