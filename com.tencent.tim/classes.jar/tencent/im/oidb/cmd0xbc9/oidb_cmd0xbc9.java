package tencent.im.oidb.cmd0xbc9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xbc9
{
  public static final class AdReport
    extends MessageMicro<AdReport>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_report_url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_report_url" }, new Object[] { localByteStringMicro }, AdReport.class);
    }
  }
  
  public static final class BannerItem
    extends MessageMicro<BannerItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_banner_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_superscript_color = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_superscript_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_cmd0xbc9.AdReport> msg_ad_click_report = PBField.initRepeatMessage(oidb_cmd0xbc9.AdReport.class);
    public final PBRepeatMessageField<oidb_cmd0xbc9.AdReport> msg_ad_exposure_report = PBField.initRepeatMessage(oidb_cmd0xbc9.AdReport.class);
    public oidb_cmd0xbc9.ContentBannerItem msg_article_content_item = new oidb_cmd0xbc9.ContentBannerItem();
    public oidb_cmd0xbc9.VideoBannerItem msg_video_banner_item = new oidb_cmd0xbc9.VideoBannerItem();
    public final PBUInt32Field uint32_banner_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_ad = PBField.initUInt32(0);
    public final PBUInt64Field uint64_banner_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 56, 66, 74, 80 }, new String[] { "uint32_banner_type", "msg_video_banner_item", "msg_article_content_item", "bytes_superscript_text", "bytes_superscript_color", "bytes_banner_title", "uint32_is_ad", "msg_ad_click_report", "msg_ad_exposure_report", "uint64_banner_id" }, new Object[] { Integer.valueOf(0), null, null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), null, null, Long.valueOf(0L) }, BannerItem.class);
    }
  }
  
  public static final class BannerRoundReqBody
    extends MessageMicro<BannerRoundReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_channel_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_channel_id", "bytes_cookie" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, BannerRoundReqBody.class);
    }
  }
  
  public static final class BannerRoundRspBody
    extends MessageMicro<BannerRoundRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_cmd0xbc9.MoreChannelItem msg_more_channel_item = new oidb_cmd0xbc9.MoreChannelItem();
    public final PBRepeatMessageField<oidb_cmd0xbc9.BannerItem> rpt_msg_banner_list = PBField.initRepeatMessage(oidb_cmd0xbc9.BannerItem.class);
    public final PBRepeatMessageField<oidb_cmd0xbc9.DynamicBannerItem> rpt_msg_dynamic_banner_list = PBField.initRepeatMessage(oidb_cmd0xbc9.DynamicBannerItem.class);
    public final PBUInt32Field uint32_channel_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_update = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50 }, new String[] { "uint32_need_update", "rpt_msg_banner_list", "uint32_channel_id", "bytes_cookie", "rpt_msg_dynamic_banner_list", "msg_more_channel_item" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0), localByteStringMicro, null, null }, BannerRoundRspBody.class);
    }
  }
  
  public static final class ContentBannerItem
    extends MessageMicro<ContentBannerItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_image_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_link_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "bytes_image_url", "bytes_link_url", "bytes_title", "bytes_rowkey" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, ContentBannerItem.class);
    }
  }
  
  public static final class DynamicBannerItem
    extends MessageMicro<DynamicBannerItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_dynamic_json = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_dynamic_json" }, new Object[] { localByteStringMicro }, DynamicBannerItem.class);
    }
  }
  
  public static final class MoreChannelItem
    extends MessageMicro<MoreChannelItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_link_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_title", "bytes_link_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, MoreChannelItem.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_banner_round_req_body" }, new Object[] { null }, ReqBody.class);
    public oidb_cmd0xbc9.BannerRoundReqBody msg_banner_round_req_body = new oidb_cmd0xbc9.BannerRoundReqBody();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_banner_round_rsp_body" }, new Object[] { null }, RspBody.class);
    public oidb_cmd0xbc9.BannerRoundRspBody msg_banner_round_rsp_body = new oidb_cmd0xbc9.BannerRoundRspBody();
  }
  
  public static final class VideoBannerItem
    extends MessageMicro<VideoBannerItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_account_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_inner_uinque_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_share_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_cover = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_busi_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_feeds_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_ugc = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_duration = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_width = PBField.initUInt32(0);
    public final PBUInt64Field uint64_account_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 58, 64, 74, 82, 88, 96, 104, 112 }, new String[] { "bytes_share_url", "uint32_video_duration", "uint32_video_width", "uint32_video_height", "bytes_video_vid", "bytes_video_cover", "bytes_inner_uinque_id", "uint32_busi_type", "bytes_title", "bytes_account_name", "uint64_account_uin", "uint32_feeds_type", "uint64_feeds_id", "uint32_is_ugc" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), localByteStringMicro5, localByteStringMicro6, Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, VideoBannerItem.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9
 * JD-Core Version:    0.7.0.1
 */