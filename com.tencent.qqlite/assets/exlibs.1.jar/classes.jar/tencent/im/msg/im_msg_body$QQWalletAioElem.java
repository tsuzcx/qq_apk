package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_msg_body$QQWalletAioElem
  extends MessageMicro
{
  public static final int BYTES_BLACKSTRIPE_FIELD_NUMBER = 7;
  public static final int BYTES_CONTENT_FIELD_NUMBER = 5;
  public static final int BYTES_LINKURL_FIELD_NUMBER = 6;
  public static final int BYTES_NOTICE_FIELD_NUMBER = 8;
  public static final int BYTES_SUBTITLE_FIELD_NUMBER = 4;
  public static final int BYTES_TITLE_FIELD_NUMBER = 3;
  public static final int UINT32_BACKGROUND_FIELD_NUMBER = 1;
  public static final int UINT32_ICON_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_blackstripe = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_linkurl = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_notice = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subtitle = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_background = PBField.initUInt32(0);
  public final PBUInt32Field uint32_icon = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66 }, new String[] { "uint32_background", "uint32_icon", "bytes_title", "bytes_subtitle", "bytes_content", "bytes_linkurl", "bytes_blackstripe", "bytes_notice" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6 }, QQWalletAioElem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.QQWalletAioElem
 * JD-Core Version:    0.7.0.1
 */