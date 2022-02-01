package tencent.im.oidb.inner.cmdGroupAdGetAdInfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GetTroopAioTopAD
{
  public static final class AdInfo
    extends MessageMicro<AdInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 58 }, new String[] { "uint32_ad_id", "str_background_url", "str_more_url", "str_pic_url", "uint32_valid_interval", "ad_show_type", "msg_ext_adinfo" }, new Object[] { Integer.valueOf(0), "", "", "", Integer.valueOf(0), Integer.valueOf(0), null }, AdInfo.class);
    public final PBEnumField ad_show_type = PBField.initEnum(0);
    public GetTroopAioTopAD.ExtAdInfo msg_ext_adinfo = new GetTroopAioTopAD.ExtAdInfo();
    public final PBStringField str_background_url = PBField.initString("");
    public final PBStringField str_more_url = PBField.initString("");
    public final PBStringField str_pic_url = PBField.initString("");
    public final PBUInt32Field uint32_ad_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_valid_interval = PBField.initUInt32(0);
  }
  
  public static final class AppInfo
    extends MessageMicro<AppInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "plat_type", "str_app_version" }, new Object[] { Integer.valueOf(1), "" }, AppInfo.class);
    public final PBEnumField plat_type = PBField.initEnum(1);
    public final PBStringField str_app_version = PBField.initString("");
  }
  
  public static final class ExtAdInfo
    extends MessageMicro<ExtAdInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "str_word", "str_ui_url", "str_jmp_url" }, new Object[] { "", "", "" }, ExtAdInfo.class);
    public final PBStringField str_jmp_url = PBField.initString("");
    public final PBStringField str_ui_url = PBField.initString("");
    public final PBStringField str_word = PBField.initString("");
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_groupcode", "msg_app_info" }, new Object[] { Long.valueOf(0L), null }, ReqBody.class);
    public GetTroopAioTopAD.AppInfo msg_app_info = new GetTroopAioTopAD.AppInfo();
    public final PBUInt64Field uint64_groupcode = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_res", "uint32_time_interval", "rpt_ad_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, RspBody.class);
    public final PBRepeatMessageField<GetTroopAioTopAD.AdInfo> rpt_ad_info = PBField.initRepeatMessage(GetTroopAioTopAD.AdInfo.class);
    public final PBUInt32Field uint32_res = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time_interval = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.inner.cmdGroupAdGetAdInfo.GetTroopAioTopAD
 * JD-Core Version:    0.7.0.1
 */