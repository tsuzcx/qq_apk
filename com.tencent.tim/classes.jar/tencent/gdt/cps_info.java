package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cps_info
{
  public static final class CpsCacheInfo
    extends MessageMicro<CpsCacheInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42 }, new String[] { "trace_id", "kol_id", "media_info", "pcg_media_trace_infos", "product_share_info" }, new Object[] { "", Long.valueOf(0L), null, null, null }, CpsCacheInfo.class);
    public final PBUInt64Field kol_id = PBField.initUInt64(0L);
    public MediaInfo media_info = new MediaInfo();
    public final PBRepeatMessageField<cps_info.PcgMediaTraceInfo> pcg_media_trace_infos = PBField.initRepeatMessage(cps_info.PcgMediaTraceInfo.class);
    public final PBRepeatMessageField<cps_info.ProductShareInfo> product_share_info = PBField.initRepeatMessage(cps_info.ProductShareInfo.class);
    public final PBStringField trace_id = PBField.initString("");
    
    public static final class MediaInfo
      extends MessageMicro<MediaInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "trace_id", "user_id" }, new Object[] { "", "" }, MediaInfo.class);
      public final PBStringField trace_id = PBField.initString("");
      public final PBStringField user_id = PBField.initString("");
    }
  }
  
  public static final class CpsChanTagInfo
    extends MessageMicro<CpsChanTagInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "product_id", "trace_id", "is_distribution" }, new Object[] { Long.valueOf(0L), "", Boolean.valueOf(false) }, CpsChanTagInfo.class);
    public final PBBoolField is_distribution = PBField.initBool(false);
    public final PBUInt64Field product_id = PBField.initUInt64(0L);
    public final PBStringField trace_id = PBField.initString("");
  }
  
  public static final class PcgMediaTraceInfo
    extends MessageMicro<PcgMediaTraceInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 66, 74, 82 }, new String[] { "timestamp", "media_type", "product_id", "scene", "content_id", "trace_id", "buyer_id", "seller_id", "ext_info", "seller_grade" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "", "", "", "", "", "" }, PcgMediaTraceInfo.class);
    public final PBStringField buyer_id = PBField.initString("");
    public final PBStringField content_id = PBField.initString("");
    public final PBStringField ext_info = PBField.initString("");
    public final PBInt32Field media_type = PBField.initInt32(0);
    public final PBUInt64Field product_id = PBField.initUInt64(0L);
    public final PBInt32Field scene = PBField.initInt32(0);
    public final PBStringField seller_grade = PBField.initString("");
    public final PBStringField seller_id = PBField.initString("");
    public final PBUInt64Field timestamp = PBField.initUInt64(0L);
    public final PBStringField trace_id = PBField.initString("");
  }
  
  public static final class ProductShareInfo
    extends MessageMicro<ProductShareInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "product_id", "share_rate" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, ProductShareInfo.class);
    public final PBUInt64Field product_id = PBField.initUInt64(0L);
    public final PBUInt32Field share_rate = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.gdt.cps_info
 * JD-Core Version:    0.7.0.1
 */