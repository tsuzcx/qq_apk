package tencent.im.nearfield_group;

import appoint.define.appoint_define.LBSInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class nearfield_group
{
  public static final class BusiReqHead
    extends MessageMicro<BusiReqHead>
  {
    public static final int INT32_SEQ_FIELD_NUMBER = 2;
    public static final int INT32_VERSION_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int32_version", "int32_seq" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0) }, BusiReqHead.class);
    public final PBInt32Field int32_seq = PBField.initInt32(0);
    public final PBInt32Field int32_version = PBField.initInt32(1);
  }
  
  public static final class BusiRespHead
    extends MessageMicro<BusiRespHead>
  {
    public static final int INT32_REPLY_CODE_FIELD_NUMBER = 3;
    public static final int INT32_SEQ_FIELD_NUMBER = 2;
    public static final int INT32_VERSION_FIELD_NUMBER = 1;
    public static final int STR_RESULT_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "int32_version", "int32_seq", "int32_reply_code", "str_result" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), "" }, BusiRespHead.class);
    public final PBInt32Field int32_reply_code = PBField.initInt32(0);
    public final PBInt32Field int32_seq = PBField.initInt32(0);
    public final PBInt32Field int32_version = PBField.initInt32(1);
    public final PBStringField str_result = PBField.initString("");
  }
  
  public static final class GroupProfile
    extends MessageMicro<GroupProfile>
  {
    public static final int BYTES_DISTANCE_FIELD_NUMBER = 5;
    public static final int BYTES_GROUP_NAME_FIELD_NUMBER = 2;
    public static final int BYTES_OWNER_NICK_FIELD_NUMBER = 4;
    public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 1;
    public static final int UINT64_OWNER_UIN_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_distance = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_owner_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_owner_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42 }, new String[] { "uint64_group_code", "bytes_group_name", "uint64_owner_uin", "bytes_owner_nick", "bytes_distance" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3 }, GroupProfile.class);
    }
  }
  
  public static final class ReqExit
    extends MessageMicro<ReqExit>
  {
    public static final int MSG_HEAD_FIELD_NUMBER = 1;
    public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_head", "uint64_group_code" }, new Object[] { null, Long.valueOf(0L) }, ReqExit.class);
    public nearfield_group.BusiReqHead msg_head = new nearfield_group.BusiReqHead();
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class ReqGetGroupList
    extends MessageMicro<ReqGetGroupList>
  {
    public static final int MSG_HEAD_FIELD_NUMBER = 1;
    public static final int MSG_LBS_INFO_FIELD_NUMBER = 2;
    public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "msg_head", "msg_lbs_info", "uint64_group_code" }, new Object[] { null, null, Long.valueOf(0L) }, ReqGetGroupList.class);
    public nearfield_group.BusiReqHead msg_head = new nearfield_group.BusiReqHead();
    public appoint_define.LBSInfo msg_lbs_info = new appoint_define.LBSInfo();
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class ReqJoinGroup
    extends MessageMicro<ReqJoinGroup>
  {
    public static final int BYTES_DISTANCE_FIELD_NUMBER = 4;
    public static final int MSG_HEAD_FIELD_NUMBER = 1;
    public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 2;
    public static final int UINT64_OWNER_UIN_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_distance = PBField.initBytes(ByteStringMicro.EMPTY);
    public nearfield_group.BusiReqHead msg_head = new nearfield_group.BusiReqHead();
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_owner_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "msg_head", "uint64_group_code", "uint64_owner_uin", "bytes_distance" }, new Object[] { null, Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro }, ReqJoinGroup.class);
    }
  }
  
  public static final class RespExit
    extends MessageMicro<RespExit>
  {
    public static final int MSG_HEAD_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_head" }, new Object[] { null }, RespExit.class);
    public nearfield_group.BusiRespHead msg_head = new nearfield_group.BusiRespHead();
  }
  
  public static final class RespGetGroupList
    extends MessageMicro<RespGetGroupList>
  {
    public static final int MSG_HEAD_FIELD_NUMBER = 1;
    public static final int RPT_MSG_GROUP_LIST_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_head", "rpt_msg_group_list" }, new Object[] { null, null }, RespGetGroupList.class);
    public nearfield_group.BusiRespHead msg_head = new nearfield_group.BusiRespHead();
    public final PBRepeatMessageField<nearfield_group.GroupProfile> rpt_msg_group_list = PBField.initRepeatMessage(nearfield_group.GroupProfile.class);
  }
  
  public static final class RespJoinGroup
    extends MessageMicro<RespJoinGroup>
  {
    public static final int MSG_HEAD_FIELD_NUMBER = 1;
    public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_head", "uint64_group_code" }, new Object[] { null, Long.valueOf(0L) }, RespJoinGroup.class);
    public nearfield_group.BusiRespHead msg_head = new nearfield_group.BusiRespHead();
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.nearfield_group.nearfield_group
 * JD-Core Version:    0.7.0.1
 */