package com.tencent.protofile.discuss;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FlyTicket
{
  public static final class DiscussGetUrlRequest
    extends MessageMicro<DiscussGetUrlRequest>
  {
    public static final int CONF_UIN_FIELD_NUMBER = 1;
    public static final int IS_NEED_LONG_LINK_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "conf_uin", "is_need_long_link" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false) }, DiscussGetUrlRequest.class);
    public final PBUInt32Field conf_uin = PBField.initUInt32(0);
    public final PBBoolField is_need_long_link = PBField.initBool(false);
  }
  
  public static final class DiscussGetUrlResponse
    extends MessageMicro<DiscussGetUrlResponse>
  {
    public static final int RET_INFO_FIELD_NUMBER = 1;
    public static final int SHORT_URL_FIELD_NUMBER = 5;
    public static final int SIG_FIELD_NUMBER = 3;
    public static final int URL_FIELD_NUMBER = 2;
    public static final int V_TIME_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42 }, new String[] { "ret_info", "url", "sig", "v_time", "short_url" }, new Object[] { null, "", "", Integer.valueOf(0), "" }, DiscussGetUrlResponse.class);
    public FlyTicket.RetInfo ret_info = new FlyTicket.RetInfo();
    public final PBStringField short_url = PBField.initString("");
    public final PBStringField sig = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field v_time = PBField.initUInt32(0);
  }
  
  public static final class DiscussSigDecodeRequest
    extends MessageMicro<DiscussSigDecodeRequest>
  {
    public static final int SIG_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "sig" }, new Object[] { "" }, DiscussSigDecodeRequest.class);
    public final PBStringField sig = PBField.initString("");
  }
  
  public static final class DiscussSigDecodeResponse
    extends MessageMicro<DiscussSigDecodeResponse>
  {
    public static final int RET_INFO_FIELD_NUMBER = 1;
    public static final int SIG_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ret_info", "sig" }, new Object[] { null, "" }, DiscussSigDecodeResponse.class);
    public FlyTicket.RetInfo ret_info = new FlyTicket.RetInfo();
    public final PBStringField sig = PBField.initString("");
  }
  
  public static final class RetInfo
    extends MessageMicro<RetInfo>
  {
    public static final int ERR_INFO_FIELD_NUMBER = 2;
    public static final int RET_CODE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret_code", "err_info" }, new Object[] { Integer.valueOf(0), "" }, RetInfo.class);
    public final PBStringField err_info = PBField.initString("");
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.protofile.discuss.FlyTicket
 * JD-Core Version:    0.7.0.1
 */