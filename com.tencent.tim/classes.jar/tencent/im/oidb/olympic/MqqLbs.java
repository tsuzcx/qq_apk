package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MqqLbs
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
  
  public static final class CheatApp
    extends MessageMicro<CheatApp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_app_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_run_status = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_app_name", "uint32_run_status" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, CheatApp.class);
    }
  }
  
  public static final class GPS
    extends MessageMicro<GPS>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50 }, new String[] { "int32_lat", "int32_lon", "int32_alt", "int32_type", "uint32_precision", "str_addr" }, new Object[] { Integer.valueOf(900000000), Integer.valueOf(900000000), Integer.valueOf(-10000000), Integer.valueOf(0), Integer.valueOf(0), "" }, GPS.class);
    public final PBInt32Field int32_alt = PBField.initInt32(-10000000);
    public final PBInt32Field int32_lat = PBField.initInt32(900000000);
    public final PBInt32Field int32_lon = PBField.initInt32(900000000);
    public final PBInt32Field int32_type = PBField.initInt32(0);
    public final PBStringField str_addr = PBField.initString("");
    public final PBUInt32Field uint32_precision = PBField.initUInt32(0);
  }
  
  public static final class LBSCheckInfo
    extends MessageMicro<LBSCheckInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "uint32_fake_period", "uint32_fake_times", "rpt_msg_lbs_fake_info", "rpt_msg_cheat_app", "uint32_root_jailbreak" }, new Object[] { Integer.valueOf(60), Integer.valueOf(0), null, null, Integer.valueOf(0) }, LBSCheckInfo.class);
    public final PBRepeatMessageField<MqqLbs.CheatApp> rpt_msg_cheat_app = PBField.initRepeatMessage(MqqLbs.CheatApp.class);
    public final PBRepeatMessageField<MqqLbs.LBSFakeInfo> rpt_msg_lbs_fake_info = PBField.initRepeatMessage(MqqLbs.LBSFakeInfo.class);
    public final PBUInt32Field uint32_fake_period = PBField.initUInt32(60);
    public final PBUInt32Field uint32_fake_times = PBField.initUInt32(0);
    public final PBUInt32Field uint32_root_jailbreak = PBField.initUInt32(0);
  }
  
  public static final class LBSFakeInfo
    extends MessageMicro<LBSFakeInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_fake_type", "uint32_fake_times" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, LBSFakeInfo.class);
    public final PBUInt32Field uint32_fake_times = PBField.initUInt32(0);
    public final PBUInt32Field uint32_fake_type = PBField.initUInt32(0);
  }
  
  public static final class LBSInfo
    extends MessageMicro<LBSInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_gps", "rpt_msg_wifis", "rpt_msg_cells" }, new Object[] { null, null, null }, LBSInfo.class);
    public MqqLbs.GPS msg_gps = new MqqLbs.GPS();
    public final PBRepeatMessageField<MqqLbs.Cell> rpt_msg_cells = PBField.initRepeatMessage(MqqLbs.Cell.class);
    public final PBRepeatMessageField<MqqLbs.Wifi> rpt_msg_wifis = PBField.initRepeatMessage(MqqLbs.Wifi.class);
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
 * Qualified Name:     tencent.im.oidb.olympic.MqqLbs
 * JD-Core Version:    0.7.0.1
 */