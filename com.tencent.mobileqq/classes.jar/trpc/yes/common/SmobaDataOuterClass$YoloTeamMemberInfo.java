package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SmobaDataOuterClass$YoloTeamMemberInfo
  extends MessageMicro<YoloTeamMemberInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field defaultscoreofgrade = PBField.initUInt32(0);
  public final PBUInt32Field defaultshowrankgrade = PBField.initUInt32(0);
  public final PBUInt32Field gender = PBField.initUInt32(0);
  public final PBStringField headurl = PBField.initString("");
  public final PBUInt32Field isleader = PBField.initUInt32(0);
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
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 48, 56, 64, 72, 80, 88, 96, 800 }, new String[] { "roleid", "openid", "partition", "nickname", "headurl", "showrankgrade", "isleader", "scoreofgrade", "gender", "pvplevel", "defaultshowrankgrade", "defaultscoreofgrade", "uid" }, new Object[] { Long.valueOf(0L), "", localInteger, "", "", localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, Long.valueOf(0L) }, YoloTeamMemberInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.SmobaDataOuterClass.YoloTeamMemberInfo
 * JD-Core Version:    0.7.0.1
 */