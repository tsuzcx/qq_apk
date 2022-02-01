package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ark_form_data
{
  public static final class ArkFormData
    extends MessageMicro<ArkFormData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ad_info", "form_info" }, new Object[] { null, null }, ArkFormData.class);
    public qq_ad_get.QQAdGetRsp.AdInfo ad_info = new qq_ad_get.QQAdGetRsp.AdInfo();
    public FormInfo form_info = new FormInfo();
    
    public static final class AdInfo
      extends MessageMicro<AdInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "product_type", "display_info", "report_info", "dest_info" }, new Object[] { Integer.valueOf(0), null, null, null }, AdInfo.class);
      public qq_ad_get.QQAdGetRsp.AdInfo.DestInfo dest_info = new qq_ad_get.QQAdGetRsp.AdInfo.DestInfo();
      public qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo display_info = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo();
      public final PBUInt32Field product_type = PBField.initUInt32(0);
      public qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo report_info = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
      
      public static final class DestInfo
        extends MessageMicro<DestInfo>
      {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 26, 32 }, new String[] { "canvas_json", "dest_type" }, new Object[] { "", Integer.valueOf(0) }, DestInfo.class);
        public final PBStringField canvas_json = PBField.initString("");
        public final PBUInt32Field dest_type = PBField.initUInt32(0);
      }
      
      public static final class DisplayInfo
        extends MessageMicro<DisplayInfo>
      {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 58 }, new String[] { "advertiser_info" }, new Object[] { null }, DisplayInfo.class);
        public AdvertiserInfo advertiser_info = new AdvertiserInfo();
        
        public static final class AdvertiserInfo
          extends MessageMicro<AdvertiserInfo>
        {
          static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 32 }, new String[] { "advertiser_id" }, new Object[] { Long.valueOf(0L) }, AdvertiserInfo.class);
          public final PBUInt64Field advertiser_id = PBField.initUInt64(0L);
        }
      }
      
      public static final class ReportInfo
        extends MessageMicro<ReportInfo>
      {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 34, 50 }, new String[] { "landing_page_report_url", "trace_info" }, new Object[] { "", null }, ReportInfo.class);
        public final PBStringField landing_page_report_url = PBField.initString("");
        public TraceInfo trace_info = new TraceInfo();
        
        public static final class TraceInfo
          extends MessageMicro<TraceInfo>
        {
          static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18 }, new String[] { "traceid" }, new Object[] { "" }, TraceInfo.class);
          public final PBStringField traceid = PBField.initString("");
        }
      }
    }
    
    public static final class FormInfo
      extends MessageMicro<FormInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "form_module_id", "index" }, new Object[] { "", Integer.valueOf(0) }, FormInfo.class);
      public final PBStringField form_module_id = PBField.initString("");
      public final PBUInt32Field index = PBField.initUInt32(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.gdt.ark_form_data
 * JD-Core Version:    0.7.0.1
 */