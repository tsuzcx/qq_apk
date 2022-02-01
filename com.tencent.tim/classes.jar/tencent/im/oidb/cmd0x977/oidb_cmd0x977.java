package tencent.im.oidb.cmd0x977;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x977
{
  public static final class FollowListInfo
    extends MessageMicro<FollowListInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90 }, new String[] { "uint32_follow_list_type", "rpt_follow_status_info" }, new Object[] { Integer.valueOf(1), null }, FollowListInfo.class);
    public final PBRepeatMessageField<oidb_cmd0x977.FollowStatusInfo> rpt_follow_status_info = PBField.initRepeatMessage(oidb_cmd0x977.FollowStatusInfo.class);
    public final PBEnumField uint32_follow_list_type = PBField.initEnum(1);
  }
  
  public static final class FollowStatusInfo
    extends MessageMicro<FollowStatusInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 82, 88, 96, 106, 112 }, new String[] { "uint64_uin", "enum_status", "enum_account_type", "enum_fans_status", "msg_topic_info", "enum_forbid_idol_status", "enum_forbid_fans_status", "user_info", "uint32_is_being_followed" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), null, Integer.valueOf(-1), Integer.valueOf(-1), null, Integer.valueOf(0) }, FollowStatusInfo.class);
    public final PBEnumField enum_account_type = PBField.initEnum(1);
    public final PBEnumField enum_fans_status = PBField.initEnum(0);
    public final PBEnumField enum_forbid_fans_status = PBField.initEnum(-1);
    public final PBEnumField enum_forbid_idol_status = PBField.initEnum(-1);
    public final PBEnumField enum_status = PBField.initEnum(0);
    public oidb_cmd0x977.FollowTopicInfo msg_topic_info = new oidb_cmd0x977.FollowTopicInfo();
    public final PBUInt32Field uint32_is_being_followed = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    public oidb_cmd0x977.KdUserInfo user_info = new oidb_cmd0x977.KdUserInfo();
  }
  
  public static final class FollowTopicInfo
    extends MessageMicro<FollowTopicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_picurl = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
    public final PBUInt32Field uint32_unreadcount = PBField.initUInt32(0);
    public final PBUInt32Field uint32_usercount = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 80 }, new String[] { "bytes_name", "bytes_picurl", "uint32_usercount", "uint32_unreadcount", "bytes_url", "uint32_source" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0) }, FollowTopicInfo.class);
    }
  }
  
  public static final class KdUserInfo
    extends MessageMicro<KdUserInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_qq_head_url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_nick", "bytes_qq_head_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, KdUserInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 90 }, new String[] { "uint64_uin", "uint64_client_switch", "msg_req_follow_para" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), null }, ReqBody.class);
    public oidb_cmd0x977.ReqFollowPara msg_req_follow_para = new oidb_cmd0x977.ReqFollowPara();
    public final PBUInt64Field uint64_client_switch = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqFollowPara
    extends MessageMicro<ReqFollowPara>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField op_type = PBField.initEnum(1);
    public final PBRepeatField<Long> rpt_subscribe_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatField<Long> rpt_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBEnumField uint32_follow_list_type = PBField.initEnum(1);
    public final PBUInt32Field uint32_need_kd_user_info = PBField.initUInt32(0);
    public final PBUInt32Field uint32_no_check_friends = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 80, 90, 96, 104, 112, 120, 128, 136 }, new String[] { "op_type", "uint32_req_count", "bytes_cookie", "uint64_dst_uin", "uint32_follow_list_type", "rpt_uin_list", "rpt_subscribe_list", "uint32_need_kd_user_info", "uint32_no_check_friends" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), Integer.valueOf(1), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, ReqFollowPara.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90 }, new String[] { "uint64_uin", "msg_rsp_follow_data" }, new Object[] { Long.valueOf(0L), null }, RspBody.class);
    public oidb_cmd0x977.RspFollowData msg_rsp_follow_data = new oidb_cmd0x977.RspFollowData();
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspFollowData
    extends MessageMicro<RspFollowData>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_cmd0x977.FollowListInfo msg_follow_list = new oidb_cmd0x977.FollowListInfo();
    public final PBEnumField op_type = PBField.initEnum(1);
    public final PBUInt32Field uint32_is_no_more_data = PBField.initUInt32(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_total_count = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 90, 96, 106 }, new String[] { "op_type", "uint32_is_no_more_data", "uint64_total_count", "bytes_cookie", "uint64_dst_uin", "msg_follow_list" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro, Long.valueOf(0L), null }, RspFollowData.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x977.oidb_cmd0x977
 * JD-Core Version:    0.7.0.1
 */