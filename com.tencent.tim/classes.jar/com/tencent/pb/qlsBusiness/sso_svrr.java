package com.tencent.pb.qlsBusiness;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class sso_svrr
{
  public static final class QLSSsoBSvrHeader
    extends MessageMicro<QLSSsoBSvrHeader>
  {
    public static final int SUBCMD_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "subcmd" }, new Object[] { Integer.valueOf(0) }, QLSSsoBSvrHeader.class);
    public final PBUInt32Field subcmd = PBField.initUInt32(0);
  }
  
  public static final class QLSSsoBSvrOpenId2UinReq
    extends MessageMicro<QLSSsoBSvrOpenId2UinReq>
  {
    public static final int APPID_FIELD_NUMBER = 2;
    public static final int HEADER_FIELD_NUMBER = 1;
    public static final int OPENID_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "header", "appid", "openid" }, new Object[] { null, Integer.valueOf(0), "" }, QLSSsoBSvrOpenId2UinReq.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public sso_svrr.QLSSsoBSvrHeader header = new sso_svrr.QLSSsoBSvrHeader();
    public final PBStringField openid = PBField.initString("");
  }
  
  public static final class QLSSsoBSvrOpenId2UinRsp
    extends MessageMicro<QLSSsoBSvrOpenId2UinRsp>
  {
    public static final int APPID_FIELD_NUMBER = 2;
    public static final int HEADER_FIELD_NUMBER = 1;
    public static final int OPENID_FIELD_NUMBER = 3;
    public static final int QQUIN_FIELD_NUMBER = 5;
    public static final int RESULT_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40 }, new String[] { "header", "appid", "openid", "result", "qquin" }, new Object[] { null, Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) }, QLSSsoBSvrOpenId2UinRsp.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public sso_svrr.QLSSsoBSvrHeader header = new sso_svrr.QLSSsoBSvrHeader();
    public final PBStringField openid = PBField.initString("");
    public final PBUInt32Field qquin = PBField.initUInt32(0);
    public final PBUInt32Field result = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.qlsBusiness.sso_svrr
 * JD-Core Version:    0.7.0.1
 */