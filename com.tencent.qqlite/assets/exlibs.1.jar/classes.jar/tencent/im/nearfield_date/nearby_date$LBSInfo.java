package tencent.im.nearfield_date;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class nearby_date$LBSInfo
  extends MessageMicro
{
  public static final int MSG_GPS_FIELD_NUMBER = 1;
  public static final int RPT_MSG_CELLS_FIELD_NUMBER = 3;
  public static final int RPT_MSG_WIFIS_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_gps", "rpt_msg_wifis", "rpt_msg_cells" }, new Object[] { null, null, null }, LBSInfo.class);
  public nearby_date.GPS msg_gps = new nearby_date.GPS();
  public final PBRepeatMessageField rpt_msg_cells = PBField.initRepeatMessage(nearby_date.Cell.class);
  public final PBRepeatMessageField rpt_msg_wifis = PBField.initRepeatMessage(nearby_date.Wifi.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.nearfield_date.nearby_date.LBSInfo
 * JD-Core Version:    0.7.0.1
 */