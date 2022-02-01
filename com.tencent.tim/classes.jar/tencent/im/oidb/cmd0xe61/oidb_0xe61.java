package tencent.im.oidb.cmd0xe61;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe61
{
  public static final class BeancurdCubeInfo
    extends MessageMicro<BeancurdCubeInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_busi_data_req = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_busi_data_rsp = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_busi_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_event_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_flag = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_frd_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_pull_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_pull_interval_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_valid_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 8002, 8010 }, new String[] { "uint64_busi_id", "uint64_uin", "uint64_frd_uin", "uint64_event_time", "uint64_pull_interval_time", "uint64_last_pull_time", "uint64_valid_time", "uint64_flag", "bytes_busi_data_req", "bytes_busi_data_rsp" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, BeancurdCubeInfo.class);
    }
  }
  
  public static final class BeancurdCubeInfoResult
    extends MessageMicro<BeancurdCubeInfoResult>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_result", "beancurdCubeInfo" }, new Object[] { Integer.valueOf(0), null }, BeancurdCubeInfoResult.class);
    public oidb_0xe61.BeancurdCubeInfo beancurdCubeInfo = new oidb_0xe61.BeancurdCubeInfo();
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_beancurd_cube_info" }, new Object[] { null }, ReqBody.class);
    public final PBRepeatMessageField<oidb_0xe61.BeancurdCubeInfo> rpt_beancurd_cube_info = PBField.initRepeatMessage(oidb_0xe61.BeancurdCubeInfo.class);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_beancurd_cube_info_result" }, new Object[] { null }, RspBody.class);
    public final PBRepeatMessageField<oidb_0xe61.BeancurdCubeInfoResult> rpt_beancurd_cube_info_result = PBField.initRepeatMessage(oidb_0xe61.BeancurdCubeInfoResult.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe61.oidb_0xe61
 * JD-Core Version:    0.7.0.1
 */