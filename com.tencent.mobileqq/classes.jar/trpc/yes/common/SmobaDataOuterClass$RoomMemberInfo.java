package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SmobaDataOuterClass$RoomMemberInfo
  extends MessageMicro<RoomMemberInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field camp_no = PBField.initInt32(0);
  public final PBStringField headurl = PBField.initString("");
  public final PBInt32Field isleader = PBField.initInt32(0);
  public final PBUInt32Field mempos = PBField.initUInt32(0);
  public final PBStringField nickname = PBField.initString("");
  public final PBStringField openid = PBField.initString("");
  public final PBUInt32Field partition = PBField.initUInt32(0);
  public final PBUInt32Field pvplevel = PBField.initUInt32(0);
  public final PBUInt64Field roleid = PBField.initUInt64(0L);
  public final PBUInt32Field scoreofgrade = PBField.initUInt32(0);
  public final PBUInt32Field showrankgrade = PBField.initUInt32(0);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50, 58, 64, 72, 80, 88, 800 }, new String[] { "openid", "partition", "camp_no", "isleader", "mempos", "nickname", "headurl", "showrankgrade", "scoreofgrade", "pvplevel", "roleid", "uid" }, new Object[] { "", localInteger, localInteger, localInteger, localInteger, "", "", localInteger, localInteger, localInteger, localLong, localLong }, RoomMemberInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.SmobaDataOuterClass.RoomMemberInfo
 * JD-Core Version:    0.7.0.1
 */