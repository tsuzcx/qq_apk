package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleInvitebase
{
  public static final class CricleInviteInfo
    extends MessageMicro<CricleInviteInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "inviteID", "ticket", "genTime" }, new Object[] { "", "", Long.valueOf(0L) }, CricleInviteInfo.class);
    public final PBInt64Field genTime = PBField.initInt64(0L);
    public final PBStringField inviteID = PBField.initString("");
    public final PBStringField ticket = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqcircle.QQCircleInvitebase
 * JD-Core Version:    0.7.0.1
 */