package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StShare;

public final class QQCircleBase
{
  public static final class StAppInfo
    extends MessageMicro<StAppInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "app_version", "qua", "platform" }, new Object[] { "", "", "" }, StAppInfo.class);
    public final PBStringField app_version = PBField.initString("");
    public final PBStringField platform = PBField.initString("");
    public final PBStringField qua = PBField.initString("");
  }
  
  public static final class StNetworkInfo
    extends MessageMicro<StNetworkInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "network_type" }, new Object[] { "" }, StNetworkInfo.class);
    public final PBStringField network_type = PBField.initString("");
  }
  
  public static final class StUserBusiData
    extends MessageMicro<StUserBusiData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 50, 58, 64 }, new String[] { "fansNum", "followNum", "feedNum", "schoolInfos", "companyInfos", "certification" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), null, null, Integer.valueOf(0) }, StUserBusiData.class);
    public final PBInt32Field certification = PBField.initInt32(0);
    public final PBRepeatMessageField<QQCircleBase.UserCircleInfo> companyInfos = PBField.initRepeatMessage(QQCircleBase.UserCircleInfo.class);
    public final PBInt64Field fansNum = PBField.initInt64(0L);
    public final PBInt32Field feedNum = PBField.initInt32(0);
    public final PBInt64Field followNum = PBField.initInt64(0L);
    public final PBRepeatMessageField<QQCircleBase.UserCircleInfo> schoolInfos = PBField.initRepeatMessage(QQCircleBase.UserCircleInfo.class);
  }
  
  public static final class StaffInfo
    extends MessageMicro<StaffInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 58, 66, 72, 80 }, new String[] { "name", "companyName", "position", "email", "evidencePicturies", "optime", "id", "companyLogo", "onboardingTime", "leaveTime" }, new Object[] { "", "", "", "", "", Long.valueOf(0L), "", "", Integer.valueOf(0), Integer.valueOf(0) }, StaffInfo.class);
    public final PBStringField companyLogo = PBField.initString("");
    public final PBStringField companyName = PBField.initString("");
    public final PBStringField email = PBField.initString("");
    public final PBRepeatField<String> evidencePicturies = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField id = PBField.initString("");
    public final PBUInt32Field leaveTime = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBUInt32Field onboardingTime = PBField.initUInt32(0);
    public final PBInt64Field optime = PBField.initInt64(0L);
    public final PBStringField position = PBField.initString("");
  }
  
  public static final class StudentInfo
    extends MessageMicro<StudentInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 58, 66, 72, 82, 90, 98, 104 }, new String[] { "name", "schoolName", "collegeName", "education", "degree", "enrollmentTime", "email", "evidencePicturies", "optime", "id", "schoolLogo", "collegeID", "graduationTime" }, new Object[] { "", "", "", Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), "", "", Long.valueOf(0L), "", "", "", Integer.valueOf(0) }, StudentInfo.class);
    public final PBStringField collegeID = PBField.initString("");
    public final PBStringField collegeName = PBField.initString("");
    public final PBEnumField degree = PBField.initEnum(1);
    public final PBEnumField education = PBField.initEnum(1);
    public final PBStringField email = PBField.initString("");
    public final PBUInt32Field enrollmentTime = PBField.initUInt32(0);
    public final PBRepeatField<String> evidencePicturies = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field graduationTime = PBField.initUInt32(0);
    public final PBStringField id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBInt64Field optime = PBField.initInt64(0L);
    public final PBStringField schoolLogo = PBField.initString("");
    public final PBStringField schoolName = PBField.initString("");
  }
  
  public static final class UserCircleInfo
    extends MessageMicro<UserCircleInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 50, 58 }, new String[] { "id", "name", "circleType", "circleTab", "logo", "shareInfo", "tagId" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0), "", null, "" }, UserCircleInfo.class);
    public final PBInt32Field circleTab = PBField.initInt32(0);
    public final PBInt32Field circleType = PBField.initInt32(0);
    public final PBStringField id = PBField.initString("");
    public final PBStringField logo = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public FeedCloudMeta.StShare shareInfo = new FeedCloudMeta.StShare();
    public final PBStringField tagId = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqcircle.QQCircleBase
 * JD-Core Version:    0.7.0.1
 */