package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class META_PROTOCOL
{
  public static final class StAccountInfo
    extends MessageMicro<StAccountInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40 }, new String[] { "email", "passwordMd5", "activateTicket", "activateEmailTime", "activateState" }, new Object[] { "", "", "", Integer.valueOf(0), Integer.valueOf(0) }, StAccountInfo.class);
    public final PBUInt32Field activateEmailTime = PBField.initUInt32(0);
    public final PBUInt32Field activateState = PBField.initUInt32(0);
    public final PBStringField activateTicket = PBField.initString("");
    public final PBStringField email = PBField.initString("");
    public final PBStringField passwordMd5 = PBField.initString("");
  }
  
  public static final class StAddressInfo
    extends MessageMicro<StAddressInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "country", "province", "city" }, new Object[] { "", "", "" }, StAddressInfo.class);
    public final PBStringField city = PBField.initString("");
    public final PBStringField country = PBField.initString("");
    public final PBStringField province = PBField.initString("");
  }
  
  public static final class StAdminTicketInfo
    extends MessageMicro<StAdminTicketInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50 }, new String[] { "developerId", "createTimestamp", "renewTimestamp", "pwd", "uin", "A2Key" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), "", "", "" }, StAdminTicketInfo.class);
    public final PBStringField A2Key = PBField.initString("");
    public final PBUInt32Field createTimestamp = PBField.initUInt32(0);
    public final PBStringField developerId = PBField.initString("");
    public final PBStringField pwd = PBField.initString("");
    public final PBUInt32Field renewTimestamp = PBField.initUInt32(0);
    public final PBStringField uin = PBField.initString("");
  }
  
  public static final class StAdministratorInfo
    extends MessageMicro<StAdministratorInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "uin", "IDName", "IDNum", "phoneNum" }, new Object[] { "", "", "", "" }, StAdministratorInfo.class);
    public final PBStringField IDName = PBField.initString("");
    public final PBStringField IDNum = PBField.initString("");
    public final PBStringField phoneNum = PBField.initString("");
    public final PBStringField uin = PBField.initString("");
  }
  
  public static final class StAnnouncementInfo
    extends MessageMicro<StAnnouncementInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "announceId", "announceTime", "announceTitle", "contentUrl" }, new Object[] { "", Integer.valueOf(0), "", "" }, StAnnouncementInfo.class);
    public final PBStringField announceId = PBField.initString("");
    public final PBUInt32Field announceTime = PBField.initUInt32(0);
    public final PBStringField announceTitle = PBField.initString("");
    public final PBStringField contentUrl = PBField.initString("");
  }
  
  public static final class StAppInfo
    extends MessageMicro<StAppInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "appid", "appSecret", "developerId", "appname", "appIcon", "appDesc", "serviceCategory", "baselibMiniVersion" }, new Object[] { "", "", "", "", "", "", "", "" }, StAppInfo.class);
    public final PBStringField appDesc = PBField.initString("");
    public final PBStringField appIcon = PBField.initString("");
    public final PBStringField appSecret = PBField.initString("");
    public final PBStringField appid = PBField.initString("");
    public final PBStringField appname = PBField.initString("");
    public final PBStringField baselibMiniVersion = PBField.initString("");
    public final PBStringField developerId = PBField.initString("");
    public final PBRepeatField<String> serviceCategory = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class StAppResidueModifyTime
    extends MessageMicro<StAppResidueModifyTime>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "appname", "appIcon", "appDesc", "serviceCategory", "serverDomain" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, StAppResidueModifyTime.class);
    public final PBInt32Field appDesc = PBField.initInt32(0);
    public final PBInt32Field appIcon = PBField.initInt32(0);
    public final PBInt32Field appname = PBField.initInt32(0);
    public final PBInt32Field serverDomain = PBField.initInt32(0);
    public final PBInt32Field serviceCategory = PBField.initInt32(0);
  }
  
  public static final class StAuditInfo
    extends MessageMicro<StAuditInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "submitTime", "refuseReason" }, new Object[] { Integer.valueOf(0), "" }, StAuditInfo.class);
    public final PBStringField refuseReason = PBField.initString("");
    public final PBUInt32Field submitTime = PBField.initUInt32(0);
  }
  
  public static final class StAuthorityInfo
    extends MessageMicro<StAuthorityInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64 }, new String[] { "develop", "experience", "loginAdmin", "dataAnalyze", "developManage", "developSetup", "pauseService", "gameOperate" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, StAuthorityInfo.class);
    public final PBUInt32Field dataAnalyze = PBField.initUInt32(0);
    public final PBUInt32Field develop = PBField.initUInt32(0);
    public final PBUInt32Field developManage = PBField.initUInt32(0);
    public final PBUInt32Field developSetup = PBField.initUInt32(0);
    public final PBUInt32Field experience = PBField.initUInt32(0);
    public final PBUInt32Field gameOperate = PBField.initUInt32(0);
    public final PBUInt32Field loginAdmin = PBField.initUInt32(0);
    public final PBUInt32Field pauseService = PBField.initUInt32(0);
  }
  
  public static final class StBaselibVersion
    extends MessageMicro<StBaselibVersion>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "version", "affectedPercentage" }, new Object[] { "", "" }, StBaselibVersion.class);
    public final PBStringField affectedPercentage = PBField.initString("");
    public final PBStringField version = PBField.initString("");
  }
  
  public static final class StCodeInfo
    extends MessageMicro<StCodeInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48 }, new String[] { "uin", "A2Key", "appid", "openid", "createTimestamp", "used" }, new Object[] { "", "", "", "", Integer.valueOf(0), Integer.valueOf(0) }, StCodeInfo.class);
    public final PBStringField A2Key = PBField.initString("");
    public final PBStringField appid = PBField.initString("");
    public final PBUInt32Field createTimestamp = PBField.initUInt32(0);
    public final PBStringField openid = PBField.initString("");
    public final PBStringField uin = PBField.initString("");
    public final PBInt32Field used = PBField.initInt32(0);
  }
  
  public static final class StDeveloperInfo
    extends MessageMicro<StDeveloperInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 48, 56, 66, 74, 82, 90, 98, 106, 112 }, new String[] { "developerId", "createTimestamp", "updateTimestamp", "email", "type", "auditState", "IDType", "IDName", "IDNum", "IDImg", "contactPhoneNum", "contactAddress", "administratorInfo", "appNum" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", "", null, Integer.valueOf(0) }, StDeveloperInfo.class);
    public final PBStringField IDImg = PBField.initString("");
    public final PBStringField IDName = PBField.initString("");
    public final PBStringField IDNum = PBField.initString("");
    public final PBUInt32Field IDType = PBField.initUInt32(0);
    public META_PROTOCOL.StAdministratorInfo administratorInfo = new META_PROTOCOL.StAdministratorInfo();
    public final PBUInt32Field appNum = PBField.initUInt32(0);
    public final PBUInt32Field auditState = PBField.initUInt32(0);
    public final PBStringField contactAddress = PBField.initString("");
    public final PBStringField contactPhoneNum = PBField.initString("");
    public final PBUInt32Field createTimestamp = PBField.initUInt32(0);
    public final PBStringField developerId = PBField.initString("");
    public final PBStringField email = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field updateTimestamp = PBField.initUInt32(0);
  }
  
  public static final class StGeneralSituation
    extends MessageMicro<StGeneralSituation>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "dataType", "number", "dayContrast", "weekContrast", "monthContrast" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), "", "", "" }, StGeneralSituation.class);
    public final PBEnumField dataType = PBField.initEnum(1);
    public final PBStringField dayContrast = PBField.initString("");
    public final PBStringField monthContrast = PBField.initString("");
    public final PBUInt64Field number = PBField.initUInt64(0L);
    public final PBStringField weekContrast = PBField.initString("");
  }
  
  public static final class StLoginCode
    extends MessageMicro<StLoginCode>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "reqFrm", "userIp", "createTimestamp", "used" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) }, StLoginCode.class);
    public final PBUInt32Field createTimestamp = PBField.initUInt32(0);
    public final PBInt32Field reqFrm = PBField.initInt32(0);
    public final PBInt32Field used = PBField.initInt32(0);
    public final PBStringField userIp = PBField.initString("");
  }
  
  public static final class StLoginTicket
    extends MessageMicro<StLoginTicket>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40 }, new String[] { "reqFrm", "uin", "key", "createTimestamp", "renewTimestamp" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0) }, StLoginTicket.class);
    public final PBUInt32Field createTimestamp = PBField.initUInt32(0);
    public final PBStringField key = PBField.initString("");
    public final PBUInt32Field renewTimestamp = PBField.initUInt32(0);
    public final PBInt32Field reqFrm = PBField.initInt32(0);
    public final PBStringField uin = PBField.initString("");
  }
  
  public static final class StMemberInfo
    extends MessageMicro<StMemberInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 58, 66, 74 }, new String[] { "appid", "createTime", "updateTime", "state", "uin", "nick", "avatar", "remark", "authority" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", null }, StMemberInfo.class);
    public final PBStringField appid = PBField.initString("");
    public META_PROTOCOL.StAuthorityInfo authority = new META_PROTOCOL.StAuthorityInfo();
    public final PBStringField avatar = PBField.initString("");
    public final PBUInt32Field createTime = PBField.initUInt32(0);
    public final PBStringField nick = PBField.initString("");
    public final PBStringField remark = PBField.initString("");
    public final PBUInt32Field state = PBField.initUInt32(0);
    public final PBStringField uin = PBField.initString("");
    public final PBUInt32Field updateTime = PBField.initUInt32(0);
  }
  
  public static final class StServerDomainInfo
    extends MessageMicro<StServerDomainInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 56 }, new String[] { "appid", "requestDomain", "socketDomain", "uploadFileDomain", "downloadFileDomain", "createTimestamp", "updateTimestamp" }, new Object[] { "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0) }, StServerDomainInfo.class);
    public final PBStringField appid = PBField.initString("");
    public final PBUInt32Field createTimestamp = PBField.initUInt32(0);
    public final PBRepeatField<String> downloadFileDomain = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatField<String> requestDomain = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatField<String> socketDomain = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field updateTimestamp = PBField.initUInt32(0);
    public final PBRepeatField<String> uploadFileDomain = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class StSessionKeyInfo
    extends MessageMicro<StSessionKeyInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40 }, new String[] { "uin", "openid", "sessionKey", "createTimestamp", "renewTimestamp" }, new Object[] { "", "", "", Integer.valueOf(0), Integer.valueOf(0) }, StSessionKeyInfo.class);
    public final PBUInt32Field createTimestamp = PBField.initUInt32(0);
    public final PBStringField openid = PBField.initString("");
    public final PBUInt32Field renewTimestamp = PBField.initUInt32(0);
    public final PBStringField sessionKey = PBField.initString("");
    public final PBStringField uin = PBField.initString("");
  }
  
  public static final class StTestAccount
    extends MessageMicro<StTestAccount>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "uin", "pwd", "comment" }, new Object[] { "", "", "" }, StTestAccount.class);
    public final PBStringField comment = PBField.initString("");
    public final PBStringField pwd = PBField.initString("");
    public final PBStringField uin = PBField.initString("");
  }
  
  public static final class StUserIdInfo
    extends MessageMicro<StUserIdInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "uin", "appid", "openid" }, new Object[] { "", "", "" }, StUserIdInfo.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField openid = PBField.initString("");
    public final PBStringField uin = PBField.initString("");
  }
  
  public static final class StUserInfo
    extends MessageMicro<StUserInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42 }, new String[] { "nick", "avatar", "gender", "address", "language" }, new Object[] { "", "", Integer.valueOf(0), null, "" }, StUserInfo.class);
    public META_PROTOCOL.StAddressInfo address = new META_PROTOCOL.StAddressInfo();
    public final PBStringField avatar = PBField.initString("");
    public final PBInt32Field gender = PBField.initInt32(0);
    public final PBStringField language = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
  }
  
  public static final class StVersionAuditInfo
    extends MessageMicro<StVersionAuditInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50 }, new String[] { "versionId", "createTime", "updateTime", "updateInstruction", "testAccount", "rejectReason" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), "", null, "" }, StVersionAuditInfo.class);
    public final PBUInt32Field createTime = PBField.initUInt32(0);
    public final PBStringField rejectReason = PBField.initString("");
    public final PBRepeatMessageField<META_PROTOCOL.StTestAccount> testAccount = PBField.initRepeatMessage(META_PROTOCOL.StTestAccount.class);
    public final PBStringField updateInstruction = PBField.initString("");
    public final PBUInt32Field updateTime = PBField.initUInt32(0);
    public final PBStringField versionId = PBField.initString("");
  }
  
  public static final class StVersionInfo
    extends MessageMicro<StVersionInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50, 58, 66, 72, 80, 90, 96, 104 }, new String[] { "versionId", "type", "creater", "appid", "version", "versionDesc", "resourceName", "resourceUrl", "createTime", "updateTime", "restoreIp", "releaseRate", "hasSubPkg" }, new Object[] { "", Integer.valueOf(0), "", "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) }, StVersionInfo.class);
    public final PBStringField appid = PBField.initString("");
    public final PBUInt32Field createTime = PBField.initUInt32(0);
    public final PBStringField creater = PBField.initString("");
    public final PBInt32Field hasSubPkg = PBField.initInt32(0);
    public final PBUInt32Field releaseRate = PBField.initUInt32(0);
    public final PBStringField resourceName = PBField.initString("");
    public final PBStringField resourceUrl = PBField.initString("");
    public final PBStringField restoreIp = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field updateTime = PBField.initUInt32(0);
    public final PBStringField version = PBField.initString("");
    public final PBStringField versionDesc = PBField.initString("");
    public final PBStringField versionId = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MINI_META.META_PROTOCOL
 * JD-Core Version:    0.7.0.1
 */