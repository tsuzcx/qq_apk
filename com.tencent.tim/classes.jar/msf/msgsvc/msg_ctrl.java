package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_ctrl
{
  public static final class MsgCtrl
    extends MessageMicro<MsgCtrl>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "msg_flag", "resv_resv_info" }, new Object[] { Integer.valueOf(0), null }, MsgCtrl.class);
    public final PBUInt32Field msg_flag = PBField.initUInt32(0);
    public msg_ctrl.ResvResvInfo resv_resv_info = new msg_ctrl.ResvResvInfo();
  }
  
  public static final class ResvResvInfo
    extends MessageMicro<ResvResvInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_reserv1 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_resv_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_reserv2 = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_reserv3 = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56, 64 }, new String[] { "uint32_flag", "bytes_reserv1", "uint64_reserv2", "uint64_reserv3", "uint32_create_time", "uint32_pic_height", "uint32_pic_width", "uint32_resv_flag" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ResvResvInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     msf.msgsvc.msg_ctrl
 * JD-Core Version:    0.7.0.1
 */