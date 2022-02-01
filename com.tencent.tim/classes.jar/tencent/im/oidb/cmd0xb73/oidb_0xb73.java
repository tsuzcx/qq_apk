package tencent.im.oidb.cmd0xb73;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xb73
{
  public static final class LikeAnimationConfig
    extends MessageMicro<LikeAnimationConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_icon_config_list" }, new Object[] { null }, LikeAnimationConfig.class);
    public final PBRepeatMessageField<oidb_0xb73.LikeAnimationIconConfig> rpt_msg_icon_config_list = PBField.initRepeatMessage(oidb_0xb73.LikeAnimationIconConfig.class);
  }
  
  public static final class LikeAnimationIconConfig
    extends MessageMicro<LikeAnimationIconConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_icon_url" }, new Object[] { localByteStringMicro }, LikeAnimationIconConfig.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_cookie", "uint32_req_type" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0xb73.LikeAnimationConfig msg_like_animation_config = new oidb_0xb73.LikeAnimationConfig();
    public final PBUInt32Field uint32_next_req_interval = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "bytes_cookie", "uint32_next_req_interval", "msg_like_animation_config" }, new Object[] { localByteStringMicro, Integer.valueOf(0), null }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb73.oidb_0xb73
 * JD-Core Version:    0.7.0.1
 */