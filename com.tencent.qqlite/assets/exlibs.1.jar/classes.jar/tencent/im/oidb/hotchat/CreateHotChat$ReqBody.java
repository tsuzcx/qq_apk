package tencent.im.oidb.hotchat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class CreateHotChat$ReqBody
  extends MessageMicro
{
  public static final int CREATE_REQ_INFO_FIELD_NUMBER = 1;
  public static final int LBS_INFO_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "create_req_info", "lbs_info" }, new Object[] { null, null }, ReqBody.class);
  public Common.WifiPOIInfo create_req_info = new Common.WifiPOIInfo();
  public LBS.LBSInfo lbs_info = new LBS.LBSInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.hotchat.CreateHotChat.ReqBody
 * JD-Core Version:    0.7.0.1
 */