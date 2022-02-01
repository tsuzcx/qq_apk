package tencent.im.oidb.cmd0xa02;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xa02
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int RPT_TINYID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_tinyid" }, new Object[] { null }, ReqBody.class);
    public final PBRepeatMessageField<cmd0xa02.TinyID> rpt_tinyid = PBField.initRepeatMessage(cmd0xa02.TinyID.class);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    public static final int RPT_TINYID2USERACC_INFO_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_tinyid2useracc_info" }, new Object[] { null }, RspBody.class);
    public final PBRepeatMessageField<cmd0xa02.TinyID2UserAccInfo> rpt_tinyid2useracc_info = PBField.initRepeatMessage(cmd0xa02.TinyID2UserAccInfo.class);
  }
  
  public static final class TinyID
    extends MessageMicro<TinyID>
  {
    public static final int UINT64_TINYID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_tinyid" }, new Object[] { Long.valueOf(0L) }, TinyID.class);
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
  }
  
  public static final class TinyID2UserAccInfo
    extends MessageMicro<TinyID2UserAccInfo>
  {
    public static final int STR_USERACC_IDENTIFIER_FIELD_NUMBER = 4;
    public static final int UINT32_SDKAPPID_FIELD_NUMBER = 3;
    public static final int UINT32_USERACCTYPE_FIELD_NUMBER = 2;
    public static final int UINT64_TINYID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint64_tinyid", "uint32_useracctype", "uint32_sdkappid", "str_useracc_identifier" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "" }, TinyID2UserAccInfo.class);
    public final PBStringField str_useracc_identifier = PBField.initString("");
    public final PBUInt32Field uint32_sdkappid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_useracctype = PBField.initUInt32(0);
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa02.cmd0xa02
 * JD-Core Version:    0.7.0.1
 */