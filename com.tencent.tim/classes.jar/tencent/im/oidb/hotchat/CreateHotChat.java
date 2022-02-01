package tencent.im.oidb.hotchat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CreateHotChat
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "create_req_info", "lbs_info" }, new Object[] { null, null }, ReqBody.class);
    public Common.WifiPOIInfo create_req_info = new Common.WifiPOIInfo();
    public LBS.LBSInfo lbs_info = new LBS.LBSInfo();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_group_code", "uint32_group_uin" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
    public final PBUInt32Field uint32_group_code = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_uin = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.hotchat.CreateHotChat
 * JD-Core Version:    0.7.0.1
 */