package tencent.im.oidb.cmd0xbe0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.gallery.gallery.GalleryInfo;

public final class cmd0xbe0
{
  public static final class MoreGallery
    extends MessageMicro<MoreGallery>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_gallery_info" }, new Object[] { null }, MoreGallery.class);
    public final PBRepeatMessageField<gallery.GalleryInfo> rpt_msg_gallery_info = PBField.initRepeatMessage(gallery.GalleryInfo.class);
  }
  
  public static final class NextGallery
    extends MessageMicro<NextGallery>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_gallery_info", "rpt_msg_gallery_info" }, new Object[] { null, null }, NextGallery.class);
    public gallery.GalleryInfo msg_gallery_info = new gallery.GalleryInfo();
    public final PBRepeatMessageField<gallery.GalleryInfo> rpt_msg_gallery_info = PBField.initRepeatMessage(gallery.GalleryInfo.class);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_context = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_imsi = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_req_advertise_para = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field comic_id = PBField.initUInt32(0);
    public cmd0xbe0.StackInfo msg_stack_info = new cmd0xbe0.StackInfo();
    public cmd0xbe0.UserInfo msg_user_info = new cmd0xbe0.UserInfo();
    public final PBUInt32Field uint32_current_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_data_page_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_data_page_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_wifi = PBField.initUInt32(0);
    public final PBUInt32Field uint32_more_gallery = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_attch_comments = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_social_info = PBField.initUInt32(0);
    public final PBUInt32Field uint32_next_gallery = PBField.initUInt32(0);
    public final PBUInt32Field uint32_next_req_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_os = PBField.initUInt32(0);
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
    public final PBUInt32Field uint32_style = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 58, 64, 72, 80, 88, 96, 104, 112, 122, 130, 800, 808, 816 }, new String[] { "uint32_more_gallery", "uint32_next_gallery", "msg_stack_info", "msg_user_info", "bytes_version", "uint32_os", "bytes_imsi", "uint32_is_wifi", "uint32_next_req_size", "uint32_need_social_info", "uint32_need_attch_comments", "uint32_current_index", "uint32_source", "uint32_style", "bytes_context", "bytes_req_advertise_para", "comic_id", "uint32_data_page_num", "uint32_data_page_index" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "msg_more_gallery", "msg_next_gallery", "uint32_is_end" }, new Object[] { null, null, Integer.valueOf(0) }, RspBody.class);
    public cmd0xbe0.MoreGallery msg_more_gallery = new cmd0xbe0.MoreGallery();
    public cmd0xbe0.NextGallery msg_next_gallery = new cmd0xbe0.NextGallery();
    public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
  }
  
  public static final class StackGallery
    extends MessageMicro<StackGallery>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_row_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_is_clicked = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_exposure = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_place = PBField.initUInt32(0);
    public final PBUInt32Field uint32_read_pic_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_read_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56 }, new String[] { "bytes_row_key", "uint32_place", "uint32_is_exposure", "uint32_is_clicked", "uint32_pic_count", "uint32_read_pic_count", "uint64_read_time" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, StackGallery.class);
    }
  }
  
  public static final class StackInfo
    extends MessageMicro<StackInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_current_gallery_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<cmd0xbe0.StackGallery> rpt_msg_stack_gallery = PBField.initRepeatMessage(cmd0xbe0.StackGallery.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_msg_stack_gallery", "bytes_current_gallery_rowkey" }, new Object[] { null, localByteStringMicro }, StackInfo.class);
    }
  }
  
  public static final class UserInfo
    extends MessageMicro<UserInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field bytes_user_bir = PBField.initUInt32(0);
    public final PBBytesField bytes_user_city = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_user_sex = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "bytes_user_bir", "uint32_user_sex", "bytes_user_city" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, UserInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbe0.cmd0xbe0
 * JD-Core Version:    0.7.0.1
 */