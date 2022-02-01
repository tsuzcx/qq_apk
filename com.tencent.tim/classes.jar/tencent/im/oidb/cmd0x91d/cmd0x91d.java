package tencent.im.oidb.cmd0x91d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.label.comm.PersonalityTagComm.LabelInfo;

public final class cmd0x91d
{
  public static final class LabelUpdateInfo
    extends MessageMicro<LabelUpdateInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_label_info", "uint32_upload_photos" }, new Object[] { null, Integer.valueOf(0) }, LabelUpdateInfo.class);
    public PersonalityTagComm.LabelInfo msg_label_info = new PersonalityTagComm.LabelInfo();
    public final PBUInt32Field uint32_upload_photos = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_req_uin", "uint64_last_time" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, ReqBody.class);
    public final PBUInt64Field uint64_last_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_req_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_update_info", "uint64_last_time" }, new Object[] { null, Long.valueOf(0L) }, RspBody.class);
    public cmd0x91d.LabelUpdateInfo msg_update_info = new cmd0x91d.LabelUpdateInfo();
    public final PBUInt64Field uint64_last_time = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x91d.cmd0x91d
 * JD-Core Version:    0.7.0.1
 */