package tencent.im.oidb.cmd0x59a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x59a
{
  public static final class ExpertFields
    extends MessageMicro<ExpertFields>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 168, 176 }, new String[] { "uint32_req_name", "uint32_req_face_url" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ExpertFields.class);
    public final PBUInt32Field uint32_req_face_url = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_name = PBField.initUInt32(0);
  }
  
  public static final class ExpertInfo
    extends MessageMicro<ExpertInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_face_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_expert_tinyid = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 170, 178 }, new String[] { "uint64_expert_tinyid", "bytes_name", "bytes_face_url" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, ExpertInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cgi_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_client_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_web_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_cmd0x59a.ExpertFields msg_expert_fields = new oidb_cmd0x59a.ExpertFields();
    public final PBUInt32Field uint32_category_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_expert_tinyid = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50 }, new String[] { "uint32_category_id", "bytes_client_version", "bytes_web_version", "bytes_cgi_version", "uint64_expert_tinyid", "msg_expert_fields" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), null }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_category_id", "msg_expert_info" }, new Object[] { Integer.valueOf(0), null }, RspBody.class);
    public oidb_cmd0x59a.ExpertInfo msg_expert_info = new oidb_cmd0x59a.ExpertInfo();
    public final PBUInt32Field uint32_category_id = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x59a.oidb_cmd0x59a
 * JD-Core Version:    0.7.0.1
 */