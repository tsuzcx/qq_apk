package localpb.richMsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MarketFaceMsg$MarketFaceRec
  extends MessageMicro
{
  public static final int BYTES_FACE_ID_FIELD_NUMBER = 4;
  public static final int BYTES_FACE_NAME_FIELD_NUMBER = 1;
  public static final int BYTES_KEY_FIELD_NUMBER = 7;
  public static final int BYTES_PARAM_FIELD_NUMBER = 8;
  public static final int UINT32_FACE_INFO_FIELD_NUMBER = 3;
  public static final int UINT32_IMAGE_HEIGHT_FIELD_NUMBER = 11;
  public static final int UINT32_IMAGE_WIDTH_FIELD_NUMBER = 10;
  public static final int UINT32_ITEM_TYPE_FIELD_NUMBER = 2;
  public static final int UINT32_MEDIA_TYPE_FIELD_NUMBER = 9;
  public static final int UINT32_SUB_TYPE_FIELD_NUMBER = 6;
  public static final int UINT32_TAB_ID_FIELD_NUMBER = 5;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_face_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_face_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_param = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_face_info = PBField.initUInt32(0);
  public final PBUInt32Field uint32_image_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_image_width = PBField.initUInt32(0);
  public final PBUInt32Field uint32_item_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_media_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sub_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tab_id = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 48, 58, 66, 72, 80, 88 }, new String[] { "bytes_face_name", "uint32_item_type", "uint32_face_info", "bytes_face_id", "uint32_tab_id", "uint32_sub_type", "bytes_key", "bytes_param", "uint32_media_type", "uint32_image_width", "uint32_image_height" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, MarketFaceRec.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     localpb.richMsg.MarketFaceMsg.MarketFaceRec
 * JD-Core Version:    0.7.0.1
 */