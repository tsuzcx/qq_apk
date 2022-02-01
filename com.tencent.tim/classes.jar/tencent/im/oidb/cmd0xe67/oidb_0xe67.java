package tencent.im.oidb.cmd0xe67;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe67
{
  public static final class Cell
    extends MessageMicro<Cell>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "int32_mcc", "int32_mnc", "int32_lac", "int32_cellid", "int32_rssi" }, new Object[] { Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(0) }, Cell.class);
    public final PBInt32Field int32_cellid = PBField.initInt32(-1);
    public final PBInt32Field int32_lac = PBField.initInt32(-1);
    public final PBInt32Field int32_mcc = PBField.initInt32(-1);
    public final PBInt32Field int32_mnc = PBField.initInt32(-1);
    public final PBInt32Field int32_rssi = PBField.initInt32(0);
  }
  
  public static final class GPS
    extends MessageMicro<GPS>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "int32_lat", "int32_lon", "int32_alt", "int32_type" }, new Object[] { Integer.valueOf(900000000), Integer.valueOf(900000000), Integer.valueOf(-10000000), Integer.valueOf(0) }, GPS.class);
    public final PBInt32Field int32_alt = PBField.initInt32(-10000000);
    public final PBInt32Field int32_lat = PBField.initInt32(900000000);
    public final PBInt32Field int32_lon = PBField.initInt32(900000000);
    public final PBInt32Field int32_type = PBField.initInt32(0);
  }
  
  public static final class LBSInfo
    extends MessageMicro<LBSInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_gps", "rpt_msg_wifis", "rpt_msg_cells" }, new Object[] { null, null, null }, LBSInfo.class);
    public oidb_0xe67.GPS msg_gps = new oidb_0xe67.GPS();
    public final PBRepeatMessageField<oidb_0xe67.Cell> rpt_msg_cells = PBField.initRepeatMessage(oidb_0xe67.Cell.class);
    public final PBRepeatMessageField<oidb_0xe67.Wifi> rpt_msg_wifis = PBField.initRepeatMessage(oidb_0xe67.Wifi.class);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_lbs_info", "uint32_action" }, new Object[] { null, Integer.valueOf(0) }, ReqBody.class);
    public oidb_0xe67.LBSInfo msg_lbs_info = new oidb_0xe67.LBSInfo();
    public final PBUInt32Field uint32_action = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_flare_switch" }, new Object[] { Integer.valueOf(0) }, RspBody.class);
    public final PBUInt32Field uint32_flare_switch = PBField.initUInt32(0);
  }
  
  public static final class Wifi
    extends MessageMicro<Wifi>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_mac", "int32_rssi" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, Wifi.class);
    public final PBInt32Field int32_rssi = PBField.initInt32(0);
    public final PBUInt64Field uint64_mac = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe67.oidb_0xe67
 * JD-Core Version:    0.7.0.1
 */