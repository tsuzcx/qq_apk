package com.tencent.biz.huiyin;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class HuiyinRedDotProto
{
  public static final class RedDotGetReq
    extends MessageMicro<RedDotGetReq>
  {
    public static final int APPID_FIELD_NUMBER = 1;
    public static final int UID_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "appid", "uid" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, RedDotGetReq.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBUInt64Field uid = PBField.initUInt64(0L);
  }
  
  public static final class RedDotGetRsp
    extends MessageMicro<RedDotGetRsp>
  {
    public static final int RETINFO_FIELD_NUMBER = 1;
    public static final int TOTALNUM_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "retinfo", "totalNum" }, new Object[] { null, Long.valueOf(0L) }, RedDotGetRsp.class);
    public HuiyinRedDotProto.RetInfo retinfo = new HuiyinRedDotProto.RetInfo();
    public final PBUInt64Field totalNum = PBField.initUInt64(0L);
  }
  
  public static final class RedDotSetReq
    extends MessageMicro<RedDotSetReq>
  {
    public static final int APPID_FIELD_NUMBER = 3;
    public static final int CLEAR_FIELD_NUMBER = 5;
    public static final int FROM_UID_FIELD_NUMBER = 1;
    public static final int NUM_FIELD_NUMBER = 4;
    public static final int TO_UID_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "from_uid", "to_uid", "appid", "num", "clear" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false) }, RedDotSetReq.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBBoolField clear = PBField.initBool(false);
    public final PBUInt64Field from_uid = PBField.initUInt64(0L);
    public final PBInt32Field num = PBField.initInt32(0);
    public final PBUInt64Field to_uid = PBField.initUInt64(0L);
  }
  
  public static final class RedDotSetRsp
    extends MessageMicro<RedDotSetRsp>
  {
    public static final int RETINFO_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "retinfo" }, new Object[] { null }, RedDotSetRsp.class);
    public HuiyinRedDotProto.RetInfo retinfo = new HuiyinRedDotProto.RetInfo();
  }
  
  public static final class RetInfo
    extends MessageMicro<RetInfo>
  {
    public static final int ERR_MSG_FIELD_NUMBER = 2;
    public static final int RESULT_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "result", "err_msg" }, new Object[] { Integer.valueOf(0), "" }, RetInfo.class);
    public final PBStringField err_msg = PBField.initString("");
    public final PBUInt32Field result = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.huiyin.HuiyinRedDotProto
 * JD-Core Version:    0.7.0.1
 */