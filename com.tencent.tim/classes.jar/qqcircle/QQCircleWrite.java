package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleWrite
{
  public static final class DelStaffInfoReq
    extends MessageMicro<DelStaffInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "msgID" }, new Object[] { null, "" }, DelStaffInfoReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBStringField msgID = PBField.initString("");
  }
  
  public static final class DelStaffInfoRsp
    extends MessageMicro<DelStaffInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, DelStaffInfoRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  }
  
  public static final class DelStudentInfoReq
    extends MessageMicro<DelStudentInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "msgID" }, new Object[] { null, "" }, DelStudentInfoReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBStringField msgID = PBField.initString("");
  }
  
  public static final class DelStudentInfoRsp
    extends MessageMicro<DelStudentInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, DelStudentInfoRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  }
  
  public static final class DoFollowTagReq
    extends MessageMicro<DoFollowTagReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "extInfo", "followType", "from", "tagNameList" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), "" }, DoFollowTagReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBUInt32Field followType = PBField.initUInt32(0);
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBRepeatField<String> tagNameList = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class DoFollowTagRsp
    extends MessageMicro<DoFollowTagRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, DoFollowTagRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  }
  
  public static final class JoinCompanyCircleReq
    extends MessageMicro<JoinCompanyCircleReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "staffInfo", "msgID" }, new Object[] { null, null, "" }, JoinCompanyCircleReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBStringField msgID = PBField.initString("");
    public QQCircleBase.StaffInfo staffInfo = new QQCircleBase.StaffInfo();
  }
  
  public static final class JoinCompanyCircleRsp
    extends MessageMicro<JoinCompanyCircleRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "msgID" }, new Object[] { null, "" }, JoinCompanyCircleRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBStringField msgID = PBField.initString("");
  }
  
  public static final class JoinSchoolCircleReq
    extends MessageMicro<JoinSchoolCircleReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "studentInfo", "msgID" }, new Object[] { null, null, "" }, JoinSchoolCircleReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBStringField msgID = PBField.initString("");
    public QQCircleBase.StudentInfo studentInfo = new QQCircleBase.StudentInfo();
  }
  
  public static final class JoinSchoolCircleRsp
    extends MessageMicro<JoinSchoolCircleRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "msgID" }, new Object[] { null, "" }, JoinSchoolCircleRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBStringField msgID = PBField.initString("");
  }
  
  public static final class UpdateStaffInfoReq
    extends MessageMicro<UpdateStaffInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "extInfo", "staffInfo", "msgID", "oldMsgID" }, new Object[] { null, null, "", "" }, UpdateStaffInfoReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBStringField msgID = PBField.initString("");
    public final PBStringField oldMsgID = PBField.initString("");
    public QQCircleBase.StaffInfo staffInfo = new QQCircleBase.StaffInfo();
  }
  
  public static final class UpdateStaffInfoRsp
    extends MessageMicro<UpdateStaffInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, UpdateStaffInfoRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  }
  
  public static final class UpdateStudentInfoReq
    extends MessageMicro<UpdateStudentInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "extInfo", "studentInfo", "msgID", "oldMsgID" }, new Object[] { null, null, "", "" }, UpdateStudentInfoReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBStringField msgID = PBField.initString("");
    public final PBStringField oldMsgID = PBField.initString("");
    public QQCircleBase.StudentInfo studentInfo = new QQCircleBase.StudentInfo();
  }
  
  public static final class UpdateStudentInfoRsp
    extends MessageMicro<UpdateStudentInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, UpdateStudentInfoRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  }
  
  public static final class VerifyEmailReq
    extends MessageMicro<VerifyEmailReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "token" }, new Object[] { null, "" }, VerifyEmailReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBStringField token = PBField.initString("");
  }
  
  public static final class VerifyEmailRsp
    extends MessageMicro<VerifyEmailRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "invalid" }, new Object[] { null, Integer.valueOf(0) }, VerifyEmailRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBInt32Field invalid = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqcircle.QQCircleWrite
 * JD-Core Version:    0.7.0.1
 */