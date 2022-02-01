package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class JDSearch
{
  public static final class JdHotSearchDetail
    extends MessageMicro<JdHotSearchDetail>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "session_id", "errorcode", "errormsg", "jd_sku_item" }, new Object[] { "", Integer.valueOf(0), "", null }, JdHotSearchDetail.class);
    public final PBInt32Field errorcode = PBField.initInt32(0);
    public final PBStringField errormsg = PBField.initString("");
    public final PBRepeatMessageField<JDSearch.JdSkuItem> jd_sku_item = PBField.initRepeatMessage(JDSearch.JdSkuItem.class);
    public final PBStringField session_id = PBField.initString("");
  }
  
  public static final class JdHotSearchReq
    extends MessageMicro<JdHotSearchReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uin32_timeout_ms" }, new Object[] { Integer.valueOf(0) }, JdHotSearchReq.class);
    public final PBUInt32Field uin32_timeout_ms = PBField.initUInt32(0);
  }
  
  public static final class JdHotSearchRsp
    extends MessageMicro<JdHotSearchRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "jd_hot_search_errorcode", "jd_hot_search_ocr_errormsg", "jd_hot_search_detail" }, new Object[] { Integer.valueOf(0), "", null }, JdHotSearchRsp.class);
    public JDSearch.JdHotSearchDetail jd_hot_search_detail = new JDSearch.JdHotSearchDetail();
    public final PBInt32Field jd_hot_search_errorcode = PBField.initInt32(0);
    public final PBStringField jd_hot_search_ocr_errormsg = PBField.initString("");
  }
  
  public static final class JdPicSearchDetail
    extends MessageMicro<JdPicSearchDetail>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50, 58 }, new String[] { "session_id", "errorcode", "errormsg", "promotion_url", "coupon_url", "rectangle", "jd_sku_item" }, new Object[] { "", Integer.valueOf(0), "", "", "", null, null }, JdPicSearchDetail.class);
    public final PBStringField coupon_url = PBField.initString("");
    public final PBInt32Field errorcode = PBField.initInt32(0);
    public final PBStringField errormsg = PBField.initString("");
    public final PBRepeatMessageField<JDSearch.JdSkuItem> jd_sku_item = PBField.initRepeatMessage(JDSearch.JdSkuItem.class);
    public final PBStringField promotion_url = PBField.initString("");
    public JDSearch.Rectangle rectangle = new JDSearch.Rectangle();
    public final PBStringField session_id = PBField.initString("");
  }
  
  public static final class JdPicSearchReq
    extends MessageMicro<JdPicSearchReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uin32_timeout_ms" }, new Object[] { Integer.valueOf(0) }, JdPicSearchReq.class);
    public final PBUInt32Field uin32_timeout_ms = PBField.initUInt32(0);
  }
  
  public static final class JdPicSearchRsp
    extends MessageMicro<JdPicSearchRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "jd_pic_search_errorcode", "jd_pic_search_ocr_errormsg", "jd_pic_search_detail" }, new Object[] { Integer.valueOf(0), "", null }, JdPicSearchRsp.class);
    public JDSearch.JdPicSearchDetail jd_pic_search_detail = new JDSearch.JdPicSearchDetail();
    public final PBInt32Field jd_pic_search_errorcode = PBField.initInt32(0);
    public final PBStringField jd_pic_search_ocr_errormsg = PBField.initString("");
  }
  
  public static final class JdSearchDetail
    extends MessageMicro<JdSearchDetail>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50 }, new String[] { "session_id", "errorcode", "errormsg", "jd_sku_item", "jd_more_url", "rectangle" }, new Object[] { "", Integer.valueOf(0), "", null, "", null }, JdSearchDetail.class);
    public final PBInt32Field errorcode = PBField.initInt32(0);
    public final PBStringField errormsg = PBField.initString("");
    public final PBStringField jd_more_url = PBField.initString("");
    public final PBRepeatMessageField<JDSearch.JdSkuItem> jd_sku_item = PBField.initRepeatMessage(JDSearch.JdSkuItem.class);
    public JDSearch.Rectangle rectangle = new JDSearch.Rectangle();
    public final PBStringField session_id = PBField.initString("");
  }
  
  public static final class JdSearchReq
    extends MessageMicro<JdSearchReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uin32_timeout_ms" }, new Object[] { Integer.valueOf(0) }, JdSearchReq.class);
    public final PBUInt32Field uin32_timeout_ms = PBField.initUInt32(0);
  }
  
  public static final class JdSearchRsp
    extends MessageMicro<JdSearchRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "jd_search_errorcode", "jd_search_errormsg", "jd_search_detail" }, new Object[] { Integer.valueOf(0), "", null }, JdSearchRsp.class);
    public JDSearch.JdSearchDetail jd_search_detail = new JDSearch.JdSearchDetail();
    public final PBInt32Field jd_search_errorcode = PBField.initInt32(0);
    public final PBStringField jd_search_errormsg = PBField.initString("");
  }
  
  public static final class JdSkuItem
    extends MessageMicro<JdSkuItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "detail_url", "image_url", "sku_id", "sku_name", "sku_price" }, new Object[] { "", "", "", "", "" }, JdSkuItem.class);
    public final PBStringField detail_url = PBField.initString("");
    public final PBStringField image_url = PBField.initString("");
    public final PBStringField sku_id = PBField.initString("");
    public final PBStringField sku_name = PBField.initString("");
    public final PBStringField sku_price = PBField.initString("");
  }
  
  public static final class Rectangle
    extends MessageMicro<Rectangle>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 16, 29, 37, 45 }, new String[] { "bottom", "is_user_rectangle", "left", "right", "top" }, new Object[] { Float.valueOf(0.0F), Integer.valueOf(0), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F) }, Rectangle.class);
    public final PBFloatField bottom = PBField.initFloat(0.0F);
    public final PBInt32Field is_user_rectangle = PBField.initInt32(0);
    public final PBFloatField left = PBField.initFloat(0.0F);
    public final PBFloatField right = PBField.initFloat(0.0F);
    public final PBFloatField top = PBField.initFloat(0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.JDSearch
 * JD-Core Version:    0.7.0.1
 */