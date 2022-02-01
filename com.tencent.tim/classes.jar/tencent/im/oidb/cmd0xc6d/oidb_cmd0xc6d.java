package tencent.im.oidb.cmd0xc6d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xc6d
{
  public static final class ModuleInfo
    extends MessageMicro<ModuleInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_json = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field bytes_type = PBField.initUInt32(0);
    public final PBFloatField bytes_weight = PBField.initFloat(0.0F);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 21, 26 }, new String[] { "bytes_type", "bytes_weight", "bytes_json" }, new Object[] { Integer.valueOf(0), Float.valueOf(0.0F), localByteStringMicro }, ModuleInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_row_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_client_switchs = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 88 }, new String[] { "bytes_row_key", "uint64_client_switchs" }, new Object[] { localByteStringMicro, Long.valueOf(0L) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> rpt_card_json = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBRepeatMessageField<oidb_cmd0xc6d.ModuleInfo> rpt_insert_module_info = PBField.initRepeatMessage(oidb_cmd0xc6d.ModuleInfo.class);
    public final PBRepeatMessageField<oidb_cmd0xc6d.TextCardInfo> rpt_text_insert_card_info = PBField.initRepeatMessage(oidb_cmd0xc6d.TextCardInfo.class);
    public final PBUInt32Field uint32_card_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "rpt_card_json", "uint32_card_type", "rpt_insert_module_info", "rpt_text_insert_card_info" }, new Object[] { localByteStringMicro, Integer.valueOf(0), null, null }, RspBody.class);
    }
  }
  
  public static final class TextCardInfo
    extends MessageMicro<TextCardInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_insert_forwards = PBField.initBool(false);
    public final PBBoolField bool_locate_forwards = PBField.initBool(false);
    public final PBBytesField bytes_card_json = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_indexing_type = PBField.initEnum(0);
    public final PBUInt32Field uint32_location = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "enum_indexing_type", "uint32_location", "bool_locate_forwards", "bool_insert_forwards", "bytes_card_json" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(false), localByteStringMicro }, TextCardInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc6d.oidb_cmd0xc6d
 * JD-Core Version:    0.7.0.1
 */