package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleNotify
{
  public static final class CircleMessage
    extends MessageMicro<CircleMessage>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50 }, new String[] { "circleType", "action", "msgID", "name", "emailSuffix", "avatarUrl" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", "", "" }, CircleMessage.class);
    public final PBInt32Field action = PBField.initInt32(0);
    public final PBStringField avatarUrl = PBField.initString("");
    public final PBInt32Field circleType = PBField.initInt32(0);
    public final PBStringField emailSuffix = PBField.initString("");
    public final PBStringField msgID = PBField.initString("");
    public final PBStringField name = PBField.initString("");
  }
  
  public static final class UserCertifyMessage
    extends MessageMicro<UserCertifyMessage>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField body = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field msgType = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "msgType", "body" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, UserCertifyMessage.class);
    }
  }
  
  public static final class WriteStaffInfo
    extends MessageMicro<WriteStaffInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "action", "uin", "msgID", "staffInfo" }, new Object[] { Integer.valueOf(0), "", "", null }, WriteStaffInfo.class);
    public final PBInt32Field action = PBField.initInt32(0);
    public final PBStringField msgID = PBField.initString("");
    public QQCircleBase.StaffInfo staffInfo = new QQCircleBase.StaffInfo();
    public final PBStringField uin = PBField.initString("");
  }
  
  public static final class WriteStudentInfo
    extends MessageMicro<WriteStudentInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "action", "uin", "msgID", "studentInfo" }, new Object[] { Integer.valueOf(0), "", "", null }, WriteStudentInfo.class);
    public final PBInt32Field action = PBField.initInt32(0);
    public final PBStringField msgID = PBField.initString("");
    public QQCircleBase.StudentInfo studentInfo = new QQCircleBase.StudentInfo();
    public final PBStringField uin = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqcircle.QQCircleNotify
 * JD-Core Version:    0.7.0.1
 */