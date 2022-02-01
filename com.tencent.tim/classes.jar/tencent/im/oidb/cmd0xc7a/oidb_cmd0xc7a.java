package tencent.im.oidb.cmd0xc7a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.qqconnect.Appinfo;

public final class oidb_cmd0xc7a
{
  public static final class GetUinInfoReq
    extends MessageMicro<GetUinInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uins" }, new Object[] { Long.valueOf(0L) }, GetUinInfoReq.class);
    public final PBRepeatField<Long> uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class GetUinInfoRsp
    extends MessageMicro<GetUinInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "uin_infos" }, new Object[] { null }, GetUinInfoRsp.class);
    public final PBRepeatMessageField<oidb_cmd0xc7a.UinInfo> uin_infos = PBField.initRepeatMessage(oidb_cmd0xc7a.UinInfo.class);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90 }, new String[] { "cmd", "get_uin_info_req" }, new Object[] { Integer.valueOf(0), null }, ReqBody.class);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public oidb_cmd0xc7a.GetUinInfoReq get_uin_info_req = new oidb_cmd0xc7a.GetUinInfoReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 90 }, new String[] { "wording", "next_req_duration", "get_uin_info_rsp" }, new Object[] { "", Integer.valueOf(0), null }, RspBody.class);
    public oidb_cmd0xc7a.GetUinInfoRsp get_uin_info_rsp = new oidb_cmd0xc7a.GetUinInfoRsp();
    public final PBUInt32Field next_req_duration = PBField.initUInt32(0);
    public final PBStringField wording = PBField.initString("");
  }
  
  public static final class UinInfo
    extends MessageMicro<UinInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 90 }, new String[] { "uin", "nick", "face_url", "face_url_simple", "appinfo" }, new Object[] { Long.valueOf(0L), "", "", "", null }, UinInfo.class);
    public qqconnect.Appinfo appinfo = new qqconnect.Appinfo();
    public final PBStringField face_url = PBField.initString("");
    public final PBStringField face_url_simple = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc7a.oidb_cmd0xc7a
 * JD-Core Version:    0.7.0.1
 */