package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudCertibase
{
  public static final class CompanyBaseInfo
    extends MessageMicro<CompanyBaseInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "id", "name", "logo", "emailSuffix" }, new Object[] { "", "", "", "" }, CompanyBaseInfo.class);
    public final PBStringField emailSuffix = PBField.initString("");
    public final PBStringField id = PBField.initString("");
    public final PBStringField logo = PBField.initString("");
    public final PBStringField name = PBField.initString("");
  }
  
  public static final class EducationExp
    extends MessageMicro<EducationExp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48 }, new String[] { "schoolInfo", "collegeID", "collegeName", "degree", "enrollmentYear", "idx" }, new Object[] { null, "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, EducationExp.class);
    public final PBStringField collegeID = PBField.initString("");
    public final PBStringField collegeName = PBField.initString("");
    public final PBInt32Field degree = PBField.initInt32(0);
    public final PBUInt32Field enrollmentYear = PBField.initUInt32(0);
    public final PBUInt32Field idx = PBField.initUInt32(0);
    public FeedCloudCertibase.SchoolBaseInfo schoolInfo = new FeedCloudCertibase.SchoolBaseInfo();
  }
  
  public static final class SchoolBaseInfo
    extends MessageMicro<SchoolBaseInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42 }, new String[] { "id", "name", "category", "logo", "emailSuffix" }, new Object[] { "", "", Integer.valueOf(0), "", "" }, SchoolBaseInfo.class);
    public final PBInt32Field category = PBField.initInt32(0);
    public final PBStringField emailSuffix = PBField.initString("");
    public final PBStringField id = PBField.initString("");
    public final PBStringField logo = PBField.initString("");
    public final PBStringField name = PBField.initString("");
  }
  
  public static final class StaffInfo
    extends MessageMicro<StaffInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "companyInfo", "email", "evidencePicturies", "entryYear" }, new Object[] { null, "", "", Long.valueOf(0L) }, StaffInfo.class);
    public FeedCloudCertibase.CompanyBaseInfo companyInfo = new FeedCloudCertibase.CompanyBaseInfo();
    public final PBStringField email = PBField.initString("");
    public final PBInt64Field entryYear = PBField.initInt64(0L);
    public final PBRepeatField<String> evidencePicturies = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class StudentCertification
    extends MessageMicro<StudentCertification>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "email", "evidencePicturies" }, new Object[] { "", "" }, StudentCertification.class);
    public final PBStringField email = PBField.initString("");
    public final PBRepeatField<String> evidencePicturies = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class StudentInfo
    extends MessageMicro<StudentInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "eduExp", "certifiData" }, new Object[] { null, null }, StudentInfo.class);
    public FeedCloudCertibase.StudentCertification certifiData = new FeedCloudCertibase.StudentCertification();
    public FeedCloudCertibase.EducationExp eduExp = new FeedCloudCertibase.EducationExp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     feedcloud.FeedCloudCertibase
 * JD-Core Version:    0.7.0.1
 */