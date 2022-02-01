package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudCertification
{
  public static final class ApplyCreateCompanyReq
    extends MessageMicro<ApplyCreateCompanyReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "name" }, new Object[] { null, "" }, ApplyCreateCompanyReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBStringField name = PBField.initString("");
  }
  
  public static final class ApplyCreateCompanyRsp
    extends MessageMicro<ApplyCreateCompanyRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, ApplyCreateCompanyRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  }
  
  public static final class AuthCompanyReq
    extends MessageMicro<AuthCompanyReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "staffInfo" }, new Object[] { null, null }, AuthCompanyReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public FeedCloudCertibase.StaffInfo staffInfo = new FeedCloudCertibase.StaffInfo();
  }
  
  public static final class AuthCompanyRsp
    extends MessageMicro<AuthCompanyRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "certID" }, new Object[] { null, "" }, AuthCompanyRsp.class);
    public final PBStringField certID = PBField.initString("");
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  }
  
  public static final class AuthSchoolByPOIReq
    extends MessageMicro<AuthSchoolByPOIReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "schoolInfo", "gpsInfo" }, new Object[] { null, null, null }, AuthSchoolByPOIReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public FeedCloudMeta.StGPSV2 gpsInfo = new FeedCloudMeta.StGPSV2();
    public FeedCloudCertibase.SchoolBaseInfo schoolInfo = new FeedCloudCertibase.SchoolBaseInfo();
  }
  
  public static final class AuthSchoolByPOIRsp
    extends MessageMicro<AuthSchoolByPOIRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "idx" }, new Object[] { null, Integer.valueOf(0) }, AuthSchoolByPOIRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBUInt32Field idx = PBField.initUInt32(0);
  }
  
  public static final class AuthSchoolReq
    extends MessageMicro<AuthSchoolReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "extInfo", "idx", "certiData" }, new Object[] { null, Integer.valueOf(0), null }, AuthSchoolReq.class);
    public FeedCloudCertibase.StudentCertification certiData = new FeedCloudCertibase.StudentCertification();
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBUInt32Field idx = PBField.initUInt32(0);
  }
  
  public static final class AuthSchoolRsp
    extends MessageMicro<AuthSchoolRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "status" }, new Object[] { null, Integer.valueOf(0) }, AuthSchoolRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBInt32Field status = PBField.initInt32(0);
  }
  
  public static final class BypassBeatReq
    extends MessageMicro<BypassBeatReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], BypassBeatReq.class);
  }
  
  public static final class BypassBeatRsp
    extends MessageMicro<BypassBeatRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField errormsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field ret = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret", "errormsg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, BypassBeatRsp.class);
    }
  }
  
  public static final class CertOrganizationDetail
    extends MessageMicro<CertOrganizationDetail>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "id", "type", "schoolInfo", "companyInfo" }, new Object[] { "", Integer.valueOf(0), null, null }, CertOrganizationDetail.class);
    public FeedCloudCertibase.CompanyBaseInfo companyInfo = new FeedCloudCertibase.CompanyBaseInfo();
    public final PBStringField id = PBField.initString("");
    public FeedCloudCertibase.SchoolBaseInfo schoolInfo = new FeedCloudCertibase.SchoolBaseInfo();
    public final PBInt32Field type = PBField.initInt32(0);
  }
  
  public static final class CertificationDetail
    extends MessageMicro<CertificationDetail>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 56 }, new String[] { "type", "status", "optime", "studentInfo", "staffInfo", "certID", "source" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null, null, "", Integer.valueOf(0) }, CertificationDetail.class);
    public final PBStringField certID = PBField.initString("");
    public final PBInt64Field optime = PBField.initInt64(0L);
    public final PBInt32Field source = PBField.initInt32(0);
    public FeedCloudCertibase.StaffInfo staffInfo = new FeedCloudCertibase.StaffInfo();
    public final PBInt32Field status = PBField.initInt32(0);
    public FeedCloudCertibase.StudentInfo studentInfo = new FeedCloudCertibase.StudentInfo();
    public final PBInt32Field type = PBField.initInt32(0);
  }
  
  public static final class DelStaffInfoReq
    extends MessageMicro<DelStaffInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "certID" }, new Object[] { null, "" }, DelStaffInfoReq.class);
    public final PBStringField certID = PBField.initString("");
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
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
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "idx" }, new Object[] { null, Integer.valueOf(0) }, DelStudentInfoReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBUInt32Field idx = PBField.initUInt32(0);
  }
  
  public static final class DelStudentInfoRsp
    extends MessageMicro<DelStudentInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, DelStudentInfoRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  }
  
  public static final class GetCertOrganizationReq
    extends MessageMicro<GetCertOrganizationReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "nameList", "needDetail" }, new Object[] { null, "", Integer.valueOf(0) }, GetCertOrganizationReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBRepeatField<String> nameList = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBInt32Field needDetail = PBField.initInt32(0);
  }
  
  public static final class GetCertOrganizationRsp
    extends MessageMicro<GetCertOrganizationRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "orgnaizationList" }, new Object[] { null, null }, GetCertOrganizationRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBRepeatMessageField<FeedCloudCertification.CertOrganizationDetail> orgnaizationList = PBField.initRepeatMessage(FeedCloudCertification.CertOrganizationDetail.class);
  }
  
  public static final class GetEmailSuffixReq
    extends MessageMicro<GetEmailSuffixReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "id" }, new Object[] { null, "" }, GetEmailSuffixReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBStringField id = PBField.initString("");
  }
  
  public static final class GetEmailSuffixRsp
    extends MessageMicro<GetEmailSuffixRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "emailSuffix" }, new Object[] { null, "" }, GetEmailSuffixRsp.class);
    public final PBStringField emailSuffix = PBField.initString("");
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  }
  
  public static final class GetUploadPresignedURLReq
    extends MessageMicro<GetUploadPresignedURLReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "fileName" }, new Object[] { null, "" }, GetUploadPresignedURLReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBStringField fileName = PBField.initString("");
  }
  
  public static final class GetUploadPresignedURLRsp
    extends MessageMicro<GetUploadPresignedURLRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "presignedURL", "objectName" }, new Object[] { null, "", "" }, GetUploadPresignedURLRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBStringField objectName = PBField.initString("");
    public final PBStringField presignedURL = PBField.initString("");
  }
  
  public static final class GetUserCertificationReq
    extends MessageMicro<GetUserCertificationReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40 }, new String[] { "extInfo", "certFlag", "hostUin", "statusFlag", "needDetail" }, new Object[] { null, Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) }, GetUserCertificationReq.class);
    public final PBInt32Field certFlag = PBField.initInt32(0);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBStringField hostUin = PBField.initString("");
    public final PBInt32Field needDetail = PBField.initInt32(0);
    public final PBInt32Field statusFlag = PBField.initInt32(0);
  }
  
  public static final class GetUserCertificationRsp
    extends MessageMicro<GetUserCertificationRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "certList" }, new Object[] { null, null }, GetUserCertificationRsp.class);
    public final PBRepeatMessageField<FeedCloudCertification.CertificationDetail> certList = PBField.initRepeatMessage(FeedCloudCertification.CertificationDetail.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  }
  
  public static final class GetUserPOIInfoReq
    extends MessageMicro<GetUserPOIInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "gpsInfo" }, new Object[] { null, null }, GetUserPOIInfoReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public FeedCloudMeta.StGPSV2 gpsInfo = new FeedCloudMeta.StGPSV2();
  }
  
  public static final class GetUserPOIInfoRsp
    extends MessageMicro<GetUserPOIInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "schoolInfo" }, new Object[] { null, null }, GetUserPOIInfoRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public FeedCloudCertibase.SchoolBaseInfo schoolInfo = new FeedCloudCertibase.SchoolBaseInfo();
  }
  
  public static final class SaveEducationExpReq
    extends MessageMicro<SaveEducationExpReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "eduExp" }, new Object[] { null, null }, SaveEducationExpReq.class);
    public FeedCloudCertibase.EducationExp eduExp = new FeedCloudCertibase.EducationExp();
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  }
  
  public static final class SaveEducationExpRsp
    extends MessageMicro<SaveEducationExpRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "idx" }, new Object[] { null, Integer.valueOf(0) }, SaveEducationExpRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBUInt32Field idx = PBField.initUInt32(0);
  }
  
  public static final class UpdateStaffInfoReq
    extends MessageMicro<UpdateStaffInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "staffInfo", "certID" }, new Object[] { null, null, "" }, UpdateStaffInfoReq.class);
    public final PBStringField certID = PBField.initString("");
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public FeedCloudCertibase.StaffInfo staffInfo = new FeedCloudCertibase.StaffInfo();
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
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "studentInfo" }, new Object[] { null, null }, UpdateStudentInfoReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public FeedCloudCertibase.StudentInfo studentInfo = new FeedCloudCertibase.StudentInfo();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     feedcloud.FeedCloudCertification
 * JD-Core Version:    0.7.0.1
 */