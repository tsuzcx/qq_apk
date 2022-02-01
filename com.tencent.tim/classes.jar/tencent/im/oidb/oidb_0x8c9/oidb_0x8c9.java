package tencent.im.oidb.oidb_0x8c9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8c9
{
  public static final class GroupAppUnreadInfo
    extends MessageMicro<GroupAppUnreadInfo>
  {
    public static final int OPT_INT32_GROUP_ALBUM_PASSIVE_CNT_FIELD_NUMBER = 3;
    public static final int OPT_INT32_GROUP_UNREAD_NUM_FIELD_NUMBER = 2;
    public static final int OPT_UINT64_APPID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "opt_uint64_appid", "opt_int32_group_unread_num", "opt_int32_group_album_passive_cnt" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, GroupAppUnreadInfo.class);
    public final PBInt32Field opt_int32_group_album_passive_cnt = PBField.initInt32(0);
    public final PBInt32Field opt_int32_group_unread_num = PBField.initInt32(0);
    public final PBUInt64Field opt_uint64_appid = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int OPT_BYTES_GROUP_SIG_FIELD_NUMBER = 4;
    public static final int OPT_UINT64_FROM_UIN_FIELD_NUMBER = 1;
    public static final int OPT_UINT64_GROUP_CODE_FIELD_NUMBER = 2;
    public static final int RPT_UINT64_APPID_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField opt_bytes_group_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field opt_uint64_from_uin = PBField.initUInt64(0L);
    public final PBUInt64Field opt_uint64_group_code = PBField.initUInt64(0L);
    public final PBRepeatField<Long> rpt_uint64_appid = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "opt_uint64_from_uin", "opt_uint64_group_code", "rpt_uint64_appid", "opt_bytes_group_sig" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    public static final int OPT_INT32_SHOW_RED_POINT_MOBILE_FIELD_NUMBER = 3;
    public static final int OPT_UINT64_GROUP_CODE_FIELD_NUMBER = 1;
    public static final int RPT_GROUP_APP_UNREAD_INFO_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "opt_uint64_group_code", "rpt_group_app_unread_info", "opt_int32_show_red_point_mobile" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0) }, RspBody.class);
    public final PBInt32Field opt_int32_show_red_point_mobile = PBField.initInt32(0);
    public final PBUInt64Field opt_uint64_group_code = PBField.initUInt64(0L);
    public final PBRepeatMessageField<oidb_0x8c9.GroupAppUnreadInfo> rpt_group_app_unread_info = PBField.initRepeatMessage(oidb_0x8c9.GroupAppUnreadInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x8c9.oidb_0x8c9
 * JD-Core Version:    0.7.0.1
 */