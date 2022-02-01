package NS_MINI_SHARE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MiniProgramShare
{
  public static final class StAdaptShareInfoReq
    extends MessageMicro<StAdaptShareInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 56, 64, 74, 82, 90, 98, 104, 112, 122, 128, 138, 146, 154, 162 }, new String[] { "extInfo", "appid", "title", "desc", "time", "scene", "templetType", "businessType", "picUrl", "vidUrl", "jumpUrl", "iconUrl", "verType", "shareType", "versionId", "withShareTicket", "webURL", "appidRich", "template", "rcvOpenId" }, new Object[] { null, "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "", "", null, "" }, StAdaptShareInfoReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField appidRich = PBField.initString("");
    public final PBEnumField businessType = PBField.initEnum(0);
    public final PBStringField desc = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField iconUrl = PBField.initString("");
    public final PBStringField jumpUrl = PBField.initString("");
    public final PBStringField picUrl = PBField.initString("");
    public final PBStringField rcvOpenId = PBField.initString("");
    public final PBEnumField scene = PBField.initEnum(0);
    public final PBInt32Field shareType = PBField.initInt32(0);
    public MiniProgramShare.StTemplateInfo template = new MiniProgramShare.StTemplateInfo();
    public final PBEnumField templetType = PBField.initEnum(0);
    public final PBUInt32Field time = PBField.initUInt32(0);
    public final PBStringField title = PBField.initString("");
    public final PBEnumField verType = PBField.initEnum(0);
    public final PBStringField versionId = PBField.initString("");
    public final PBStringField vidUrl = PBField.initString("");
    public final PBStringField webURL = PBField.initString("");
    public final PBInt32Field withShareTicket = PBField.initInt32(0);
  }
  
  public static final class StAdaptShareInfoRsp
    extends MessageMicro<StAdaptShareInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "jsonData" }, new Object[] { null, "" }, StAdaptShareInfoRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField jsonData = PBField.initString("");
  }
  
  public static final class StAdaptSharePicReq
    extends MessageMicro<StAdaptSharePicReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "srcPicUrl" }, new Object[] { null, "" }, StAdaptSharePicReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField srcPicUrl = PBField.initString("");
  }
  
  public static final class StAdaptSharePicRsp
    extends MessageMicro<StAdaptSharePicRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "picUrl" }, new Object[] { null, "" }, StAdaptSharePicRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField picUrl = PBField.initString("");
  }
  
  public static final class StGetGroupShareInfoReq
    extends MessageMicro<StGetGroupShareInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "appid", "shareTicket" }, new Object[] { null, "", "" }, StGetGroupShareInfoReq.class);
    public final PBStringField appid = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField shareTicket = PBField.initString("");
  }
  
  public static final class StGetGroupShareInfoRsp
    extends MessageMicro<StGetGroupShareInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "encryptedData", "iv" }, new Object[] { null, "", "" }, StGetGroupShareInfoRsp.class);
    public final PBStringField encryptedData = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField iv = PBField.initString("");
  }
  
  public static final class StGetMiniAppPathReq
    extends MessageMicro<StGetMiniAppPathReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 58 }, new String[] { "extInfo", "main_appid", "appid", "path", "miniAppType", "webURL", "content" }, new Object[] { null, "", "", "", Integer.valueOf(0), "", "" }, StGetMiniAppPathReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField main_appid = PBField.initString("");
    public final PBInt32Field miniAppType = PBField.initInt32(0);
    public final PBStringField path = PBField.initString("");
    public final PBStringField webURL = PBField.initString("");
  }
  
  public static final class StGetMiniAppPathRsp
    extends MessageMicro<StGetMiniAppPathRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "content" }, new Object[] { null, "" }, StGetMiniAppPathRsp.class);
    public final PBStringField content = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StSendArkMsgReq
    extends MessageMicro<StSendArkMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "extInfo", "appId", "openId", "arkJson" }, new Object[] { null, "", "", "" }, StSendArkMsgReq.class);
    public final PBStringField appId = PBField.initString("");
    public final PBStringField arkJson = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField openId = PBField.initString("");
  }
  
  public static final class StSendArkMsgRsp
    extends MessageMicro<StSendArkMsgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StSendArkMsgRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StTemplateInfo
    extends MessageMicro<StTemplateInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "templateId", "templateData" }, new Object[] { "", "" }, StTemplateInfo.class);
    public final PBStringField templateData = PBField.initString("");
    public final PBStringField templateId = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MINI_SHARE.MiniProgramShare
 * JD-Core Version:    0.7.0.1
 */