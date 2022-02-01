package tencent.im.msg.hummer.resv;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ResvAttrForGiftMsg
{
  public static final class ActivityGiftInfo
    extends MessageMicro<ActivityGiftInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "is_activity_gift", "text_color", "text", "url" }, new Object[] { Integer.valueOf(0), "", "", "" }, ActivityGiftInfo.class);
    public final PBUInt32Field is_activity_gift = PBField.initUInt32(0);
    public final PBStringField text = PBField.initString("");
    public final PBStringField text_color = PBField.initString("");
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class InteractGift
    extends MessageMicro<InteractGift>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_interact_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_interact_id" }, new Object[] { localByteStringMicro }, InteractGift.class);
    }
  }
  
  public static final class ResvAttr
    extends MessageMicro<ResvAttr>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public ResvAttrForGiftMsg.ActivityGiftInfo activity_gift_info = new ResvAttrForGiftMsg.ActivityGiftInfo();
    public final PBBytesField bytes_charm_heroism = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_recv_score = PBField.initInt32(0);
    public final PBInt32Field int32_send_score = PBField.initInt32(0);
    public ResvAttrForGiftMsg.InteractGift msg_interact_gift = new ResvAttrForGiftMsg.InteractGift();
    public final PBUInt32Field uint32_animation_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_button_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_obj_color = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48, 58, 66 }, new String[] { "int32_send_score", "int32_recv_score", "bytes_charm_heroism", "uint32_button_flag", "uint32_obj_color", "uint32_animation_type", "msg_interact_gift", "activity_gift_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null }, ResvAttr.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.msg.hummer.resv.ResvAttrForGiftMsg
 * JD-Core Version:    0.7.0.1
 */