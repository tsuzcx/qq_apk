package tencent.im.oidb.gallery;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class galleryFeeds
{
  public static final class GalleryFeedsInfo
    extends MessageMicro<GalleryFeedsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_attachment_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_attachment_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_attachment_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_note_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_note_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_operation_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_topic_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_topic_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_article_style = PBField.initEnum(0);
    public galleryFeeds.Picture msg_custom_cover = new galleryFeeds.Picture();
    public galleryFeeds.UserInfo msg_publisher_info = new galleryFeeds.UserInfo();
    public final PBUInt32Field uint32_is_account_derelict = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 72, 82, 90, 98, 106 }, new String[] { "enum_article_style", "bytes_attachment_icon_url", "bytes_attachment_content", "bytes_attachment_jump_url", "bytes_note_icon_url", "bytes_note_content", "bytes_topic_icon_url", "bytes_operation_id", "uint32_is_account_derelict", "bytes_jump_url", "bytes_topic_pic_url", "msg_custom_cover", "msg_publisher_info" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, Integer.valueOf(0), localByteStringMicro8, localByteStringMicro9, null, null }, GalleryFeedsInfo.class);
    }
  }
  
  public static final class Picture
    extends MessageMicro<Picture>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_height = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_width = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 32, 40 }, new String[] { "bytes_pic_url", "uint64_width", "uint64_height" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Long.valueOf(0L) }, Picture.class);
    }
  }
  
  public static final class UserInfo
    extends MessageMicro<UserInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_header_url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_header_url" }, new Object[] { localByteStringMicro }, UserInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.gallery.galleryFeeds
 * JD-Core Version:    0.7.0.1
 */