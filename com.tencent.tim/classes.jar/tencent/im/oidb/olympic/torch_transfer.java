package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class torch_transfer
{
  public static final class BusinessEntryInfo
    extends MessageMicro<BusinessEntryInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_business_entry_new", "uint32_business_entry_seq" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, BusinessEntryInfo.class);
    public final PBUInt32Field uint32_business_entry_new = PBField.initUInt32(0);
    public final PBUInt32Field uint32_business_entry_seq = PBField.initUInt32(0);
  }
  
  public static final class CityBackPicInfo
    extends MessageMicro<CityBackPicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50, 58 }, new String[] { "uint32_city_id", "str_city_name", "uint64_city_pic_id", "str_city_pic_url", "str_city_pic_md5", "str_cons_pic_url", "str_cons_pic_md5" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), "", "", "", "" }, CityBackPicInfo.class);
    public final PBStringField str_city_name = PBField.initString("");
    public final PBStringField str_city_pic_md5 = PBField.initString("");
    public final PBStringField str_city_pic_url = PBField.initString("");
    public final PBStringField str_cons_pic_md5 = PBField.initString("");
    public final PBStringField str_cons_pic_url = PBField.initString("");
    public final PBUInt32Field uint32_city_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_city_pic_id = PBField.initUInt64(0L);
  }
  
  public static final class LightCityInfo
    extends MessageMicro<LightCityInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_cur_city_id", "uint32_next_city_num" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, LightCityInfo.class);
    public final PBUInt32Field uint32_cur_city_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_next_city_num = PBField.initUInt32(0);
  }
  
  public static final class TorchLimitInfo
    extends MessageMicro<TorchLimitInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_timestamp", "bool_limit" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false) }, TorchLimitInfo.class);
    public final PBBoolField bool_limit = PBField.initBool(false);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
  }
  
  public static final class TorchPicInfo
    extends MessageMicro<TorchPicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_business_type", "str_torch_pic_url", "str_torch_pic_md5", "rpt_city_pic_list" }, new Object[] { Integer.valueOf(0), "", "", null }, TorchPicInfo.class);
    public final PBRepeatMessageField<torch_transfer.CityBackPicInfo> rpt_city_pic_list = PBField.initRepeatMessage(torch_transfer.CityBackPicInfo.class);
    public final PBStringField str_torch_pic_md5 = PBField.initString("");
    public final PBStringField str_torch_pic_url = PBField.initString("");
    public final PBUInt32Field uint32_business_type = PBField.initUInt32(0);
  }
  
  public static final class TorchbearerInfo
    extends MessageMicro<TorchbearerInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 66 }, new String[] { "uint64_uin", "uint64_bearer_id", "uint32_transfer_num", "msg_pic_info", "msg_light_city_info", "msg_limit_info", "msg_business_entry_info", "msg_torcher_rank_info" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), null, null, null, null, null }, TorchbearerInfo.class);
    public torch_transfer.BusinessEntryInfo msg_business_entry_info = new torch_transfer.BusinessEntryInfo();
    public torch_transfer.LightCityInfo msg_light_city_info = new torch_transfer.LightCityInfo();
    public torch_transfer.TorchLimitInfo msg_limit_info = new torch_transfer.TorchLimitInfo();
    public torch_transfer.TorchPicInfo msg_pic_info = new torch_transfer.TorchPicInfo();
    public torch_transfer.TorcherRankInfo msg_torcher_rank_info = new torch_transfer.TorcherRankInfo();
    public final PBUInt32Field uint32_transfer_num = PBField.initUInt32(0);
    public final PBUInt64Field uint64_bearer_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class TorcherRankInfo
    extends MessageMicro<TorcherRankInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "bool_only_torcher", "uint32_rankings" }, new Object[] { Boolean.valueOf(false), Integer.valueOf(0) }, TorcherRankInfo.class);
    public final PBBoolField bool_only_torcher = PBField.initBool(false);
    public final PBUInt32Field uint32_rankings = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.olympic.torch_transfer
 * JD-Core Version:    0.7.0.1
 */