package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QPayReminderMsg
{
  public static final class GetInfoReq
    extends MessageMicro<GetInfoReq>
  {
    public static final int INFO_DATE_FIELD_NUMBER = 3;
    public static final int SCENE_FIELD_NUMBER = 1;
    public static final int SUB_CMD_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "scene", "sub_cmd", "info_date" }, new Object[] { "", "", "" }, GetInfoReq.class);
    public final PBStringField info_date = PBField.initString("");
    public final PBStringField scene = PBField.initString("");
    public final PBStringField sub_cmd = PBField.initString("");
  }
  
  public static final class GetInfoRsp
    extends MessageMicro<GetInfoRsp>
  {
    public static final int CONTENT_FIELD_NUMBER = 5;
    public static final int INFO_DATE_FIELD_NUMBER = 6;
    public static final int RESULT_CODE_FIELD_NUMBER = 1;
    public static final int RESULT_INFO_FIELD_NUMBER = 2;
    public static final int TEMPLATE_NO_FIELD_NUMBER = 4;
    public static final int URGENCY_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50 }, new String[] { "result_code", "result_info", "urgency", "template_no", "content", "info_date" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), "", "" }, GetInfoRsp.class);
    public final PBStringField content = PBField.initString("");
    public final PBStringField info_date = PBField.initString("");
    public final PBUInt32Field result_code = PBField.initUInt32(0);
    public final PBStringField result_info = PBField.initString("");
    public final PBUInt32Field template_no = PBField.initUInt32(0);
    public final PBUInt32Field urgency = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.mobileim.structmsg.QPayReminderMsg
 * JD-Core Version:    0.7.0.1
 */