package tencent.sso.roam;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Roam
{
  public static final class RoamQualifyReq
    extends MessageMicro<RoamQualifyReq>
  {
    public static final int HEAD_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "head" }, new Object[] { null }, RoamQualifyReq.class);
    public Roam.RoamReqHead head = new Roam.RoamReqHead();
  }
  
  public static final class RoamQualifyRsp
    extends MessageMicro<RoamQualifyRsp>
  {
    public static final int HEAD_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "head" }, new Object[] { null }, RoamQualifyRsp.class);
    public Roam.RoamRspHead head = new Roam.RoamRspHead();
  }
  
  public static final class RoamReqHead
    extends MessageMicro<RoamReqHead>
  {
    public static final int CLIENT_PLAT_ID_FIELD_NUMBER = 2;
    public static final int CLIENT_VER_FIELD_NUMBER = 3;
    public static final int OS_VER_FIELD_NUMBER = 4;
    public static final int PROTOCOL_VER_FIELD_NUMBER = 1;
    public static final int UIN_FIELD_NUMBER = 5;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "protocol_ver", "client_plat_id", "client_ver", "os_ver", "uin" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Long.valueOf(0L) }, RoamReqHead.class);
    public final PBInt32Field client_plat_id = PBField.initInt32(0);
    public final PBStringField client_ver = PBField.initString("");
    public final PBStringField os_ver = PBField.initString("");
    public final PBInt32Field protocol_ver = PBField.initInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class RoamRspHead
    extends MessageMicro<RoamRspHead>
  {
    public static final int MSG_FIELD_NUMBER = 2;
    public static final int RESULT_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "result", "msg" }, new Object[] { Integer.valueOf(0), "" }, RoamRspHead.class);
    public final PBStringField msg = PBField.initString("");
    public final PBInt32Field result = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.sso.roam.Roam
 * JD-Core Version:    0.7.0.1
 */