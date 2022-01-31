package tencent.im.sso2sns.cmd0x3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class sso2sns_0x3_blocklist$ReqBodyGetBlockList
  extends MessageMicro
{
  public static final int FIXED32_LAST_GET_TIME_FIELD_NUMBER = 2;
  public static final int UINT32_GET_TYPE_FIELD_NUMBER = 5;
  public static final int UINT32_START_POS_FIELD_NUMBER = 3;
  public static final int UINT32_WANT_NUM_FIELD_NUMBER = 4;
  public static final int UINT64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 21, 24, 32, 40 }, new String[] { "uint64_uin", "fixed32_last_get_time", "uint32_start_pos", "uint32_want_num", "uint32_get_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBodyGetBlockList.class);
  public final PBFixed32Field fixed32_last_get_time = PBField.initFixed32(0);
  public final PBUInt32Field uint32_get_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_start_pos = PBField.initUInt32(0);
  public final PBUInt32Field uint32_want_num = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist.ReqBodyGetBlockList
 * JD-Core Version:    0.7.0.1
 */