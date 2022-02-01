package tencent.im.oidb.cmd0x8b3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_0x8b3
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public oidb_0x8b3.groupinfo st_group_info = new oidb_0x8b3.groupinfo();
    public final PBBytesField string_hot_group_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "string_hot_group_id", "st_group_info" }, new Object[] { localByteStringMicro, null }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField string_hot_group_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "string_hot_group_id" }, new Object[] { localByteStringMicro }, RspBody.class);
    }
  }
  
  public static final class groupinfo
    extends MessageMicro<groupinfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField string_group_memo = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField string_jumping_url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "string_group_memo", "string_jumping_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, groupinfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8b3.oidb_0x8b3
 * JD-Core Version:    0.7.0.1
 */