package tencent.im.c2c.msgtype0xa6.submsgtype0xc1;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0xc1
{
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_encrypt_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public SubMsgType0xc1.NotOnlineImage not_online_image = new SubMsgType0xc1.NotOnlineImage();
    public final PBUInt32Field uint32_encrypt_prehead_length = PBField.initUInt32(0);
    public final PBUInt32Field uint32_encrypt_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_left_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_read_times = PBField.initUInt32(0);
    public final PBUInt32Field uint32_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ttl = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56, 64, 74, 80, 88, 98 }, new String[] { "bytes_file_key", "uint64_from_uin", "uint64_to_uin", "uint32_status", "uint32_ttl", "uint32_type", "uint32_encrypt_prehead_length", "uint32_encrypt_type", "bytes_encrypt_key", "uint32_read_times", "uint32_left_time", "not_online_image" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), null }, MsgBody.class);
    }
  }
  
  public static final class NotOnlineImage
    extends MessageMicro<NotOnlineImage>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField download_path = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field file_len = PBField.initUInt32(0);
    public final PBBytesField file_path = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField flag = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field img_type = PBField.initUInt32(0);
    public final PBBytesField old_ver_send_file = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field original = PBField.initUInt32(0);
    public final PBUInt32Field pic_height = PBField.initUInt32(0);
    public final PBBytesField pic_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field pic_width = PBField.initUInt32(0);
    public final PBBytesField previews_image = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField res_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_download_url = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 50, 58, 64, 72, 82, 90, 98, 104 }, new String[] { "file_path", "file_len", "download_path", "old_ver_send_file", "img_type", "previews_image", "pic_md5", "pic_height", "pic_width", "res_id", "flag", "str_download_url", "original" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro6, localByteStringMicro7, "", Integer.valueOf(0) }, NotOnlineImage.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.c2c.msgtype0xa6.submsgtype0xc1.SubMsgType0xc1
 * JD-Core Version:    0.7.0.1
 */