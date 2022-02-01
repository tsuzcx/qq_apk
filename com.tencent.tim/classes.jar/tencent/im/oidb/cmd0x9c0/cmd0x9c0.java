package tencent.im.oidb.cmd0x9c0;

import appoint.define.appoint_define.LBSInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x9c0
{
  public static final class NearbyUser
    extends MessageMicro<NearbyUser>
  {
    public static final int BYTES_NICK_FIELD_NUMBER = 4;
    public static final int BYTES_REMARK_FIELD_NUMBER = 3;
    public static final int UINT32_IS_FRD_FIELD_NUMBER = 2;
    public static final int UINT64_NEARBY_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_remark = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_is_frd = PBField.initUInt32(0);
    public final PBUInt64Field uint64_nearby_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint64_nearby_uin", "uint32_is_frd", "bytes_remark", "bytes_nick" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, NearbyUser.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int MSG_LBS_INFO_FIELD_NUMBER = 3;
    public static final int UINT32_HEARTBEAT_FIELD_NUMBER = 2;
    public static final int UINT64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_uin", "uint32_heartbeat", "msg_lbs_info" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null }, ReqBody.class);
    public appoint_define.LBSInfo msg_lbs_info = new appoint_define.LBSInfo();
    public final PBUInt32Field uint32_heartbeat = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    public static final int RPT_NEARBY_USER_LIST_FIELD_NUMBER = 2;
    public static final int UINT32_HEARTBEAT_INTERVAL_FIELD_NUMBER = 4;
    public static final int UINT32_REQ_INTERVAL_FIELD_NUMBER = 3;
    public static final int UINT64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint64_uin", "rpt_nearby_user_list", "uint32_req_interval", "uint32_heartbeat_interval" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
    public final PBRepeatMessageField<cmd0x9c0.NearbyUser> rpt_nearby_user_list = PBField.initRepeatMessage(cmd0x9c0.NearbyUser.class);
    public final PBUInt32Field uint32_heartbeat_interval = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_interval = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9c0.cmd0x9c0
 * JD-Core Version:    0.7.0.1
 */