package tencent.im.oidb.hotchat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x8a8
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int JOINED_WIFI_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "joined_wifi" }, new Object[] { null }, ReqBody.class);
    public LBS.Wifi joined_wifi = new LBS.Wifi();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.hotchat.oidb_0x8a8
 * JD-Core Version:    0.7.0.1
 */