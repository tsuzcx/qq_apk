package tencent.im.oidb.cmd0x983;

import appoint.define.appoint_define.LBSInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x983
{
  public static final class AddonItem
    extends MessageMicro<AddonItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_addon_id" }, new Object[] { Integer.valueOf(0) }, AddonItem.class);
    public final PBUInt32Field uint32_addon_id = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_lbs_info", "uint32_network" }, new Object[] { null, Integer.valueOf(0) }, ReqBody.class);
    public appoint_define.LBSInfo msg_lbs_info = new appoint_define.LBSInfo();
    public final PBUInt32Field uint32_network = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_addon_list" }, new Object[] { null }, RspBody.class);
    public final PBRepeatMessageField<oidb_cmd0x983.AddonItem> rpt_addon_list = PBField.initRepeatMessage(oidb_cmd0x983.AddonItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x983.oidb_cmd0x983
 * JD-Core Version:    0.7.0.1
 */