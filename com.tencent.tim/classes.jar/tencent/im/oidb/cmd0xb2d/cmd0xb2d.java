package tencent.im.oidb.cmd0xb2d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.gallery.gallery.GalleryInfo;
import tencent.im.oidb.gallery.gallery.GalleryList;

public final class cmd0xb2d
{
  public static final class Cookies
    extends MessageMicro<Cookies>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 120 }, new String[] { "uint32_next_start", "uint64_test_count" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, Cookies.class);
    public final PBUInt32Field uint32_next_start = PBField.initUInt32(0);
    public final PBUInt64Field uint64_test_count = PBField.initUInt64(0L);
  }
  
  public static final class PageReq
    extends MessageMicro<PageReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_size = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_size", "bytes_cookies" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, PageReq.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_context = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_gallery_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<ByteStringMicro> bytes_gallery_rowkey_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBInt32Field int32_source = PBField.initInt32(0);
    public cmd0xb2d.PageReq msg_page_req = new cmd0xb2d.PageReq();
    public final PBUInt32Field uint32_need_attch_comments = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_social_info = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 48, 56 }, new String[] { "bytes_gallery_rowkey", "bytes_gallery_rowkey_list", "int32_source", "msg_page_req", "bytes_context", "uint32_need_social_info", "uint32_need_attch_comments" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), null, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_gallery_info", "msg_gallery_list" }, new Object[] { null, null }, RspBody.class);
    public gallery.GalleryInfo msg_gallery_info = new gallery.GalleryInfo();
    public gallery.GalleryList msg_gallery_list = new gallery.GalleryList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb2d.cmd0xb2d
 * JD-Core Version:    0.7.0.1
 */