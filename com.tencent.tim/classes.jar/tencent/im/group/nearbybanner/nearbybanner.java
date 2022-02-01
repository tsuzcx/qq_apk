package tencent.im.group.nearbybanner;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class nearbybanner
{
  public static final class BannerInfo
    extends MessageMicro<BannerInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_img_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public nearbybanner.CreateGroupBanner msg_create_banner = new nearbybanner.CreateGroupBanner();
    public nearbybanner.RecommGroupBanner msg_recomm_banner = new nearbybanner.RecommGroupBanner();
    public nearbybanner.SearchBanner msg_search_banner = new nearbybanner.SearchBanner();
    public nearbybanner.SetGroupBanner msg_set_banner = new nearbybanner.SetGroupBanner();
    public nearbybanner.WebBanner msg_web_banner = new nearbybanner.WebBanner();
    public final PBUInt32Field uint32_jump_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58 }, new String[] { "uint32_jump_type", "bytes_img_url", "msg_web_banner", "msg_recomm_banner", "msg_set_banner", "msg_search_banner", "msg_create_banner" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, null, null, null, null }, BannerInfo.class);
    }
  }
  
  public static final class Banners
    extends MessageMicro<Banners>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rpt_banner_info", "uint32_slide_time" }, new Object[] { null, Integer.valueOf(0) }, Banners.class);
    public final PBRepeatMessageField<nearbybanner.BannerInfo> rpt_banner_info = PBField.initRepeatMessage(nearbybanner.BannerInfo.class);
    public final PBUInt32Field uint32_slide_time = PBField.initUInt32(0);
  }
  
  public static final class ClientInfo
    extends MessageMicro<ClientInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_client_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_lcd_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_lcd_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_os = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint32_lcd_height", "uint32_lcd_width", "bytes_client_version", "uint32_os" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, ClientInfo.class);
    }
  }
  
  public static final class CreateGroupBanner
    extends MessageMicro<CreateGroupBanner>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_group_type" }, new Object[] { Integer.valueOf(0) }, CreateGroupBanner.class);
    public final PBUInt32Field uint32_group_type = PBField.initUInt32(0);
  }
  
  public static final class RecommGroupBanner
    extends MessageMicro<RecommGroupBanner>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_group_code" }, new Object[] { Long.valueOf(0L) }, RecommGroupBanner.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_client_info", "msg_user_info" }, new Object[] { null, null }, ReqBody.class);
    public nearbybanner.ClientInfo msg_client_info = new nearbybanner.ClientInfo();
    public nearbybanner.UserInfo msg_user_info = new nearbybanner.UserInfo();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error = PBField.initBytes(ByteStringMicro.EMPTY);
    public nearbybanner.Banners msg_banners = new nearbybanner.Banners();
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_result", "bytes_error", "msg_banners" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null }, RspBody.class);
    }
  }
  
  public static final class SearchBanner
    extends MessageMicro<SearchBanner>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_search_keyword = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_search_keyword" }, new Object[] { localByteStringMicro }, SearchBanner.class);
    }
  }
  
  public static final class SetGroupBanner
    extends MessageMicro<SetGroupBanner>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_group_code" }, new Object[] { Long.valueOf(0L) }, SetGroupBanner.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class UserInfo
    extends MessageMicro<UserInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_geocontent = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt64Field int64_latitude = PBField.initInt64(0L);
    public final PBInt64Field int64_longitude = PBField.initInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "int64_longitude", "int64_latitude", "bytes_geocontent" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro }, UserInfo.class);
    }
  }
  
  public static final class WebBanner
    extends MessageMicro<WebBanner>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_jump_url" }, new Object[] { localByteStringMicro }, WebBanner.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.group.nearbybanner.nearbybanner
 * JD-Core Version:    0.7.0.1
 */