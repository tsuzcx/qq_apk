package com.tencent.protofile.getopenid;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GetOpenidProto
{
  public static final class GetOpenidEntry
    extends MessageMicro<GetOpenidEntry>
  {
    public static final int ID_FIELD_NUMBER = 2;
    public static final int OPENID_FIELD_NUMBER = 3;
    public static final int TYPE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "type", "id", "openid" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), "" }, GetOpenidEntry.class);
    public final PBUInt64Field id = PBField.initUInt64(0L);
    public final PBStringField openid = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
  }
  
  public static final class GetOpenidReq
    extends MessageMicro<GetOpenidReq>
  {
    public static final int APPID_FIELD_NUMBER = 1;
    public static final int LIST_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "appid", "list" }, new Object[] { Long.valueOf(0L), null }, GetOpenidReq.class);
    public final PBUInt64Field appid = PBField.initUInt64(0L);
    public final PBRepeatMessageField<GetOpenidProto.GetOpenidEntry> list = PBField.initRepeatMessage(GetOpenidProto.GetOpenidEntry.class);
  }
  
  public static final class GetOpenidResp
    extends MessageMicro<GetOpenidResp>
  {
    public static final int LIST_FIELD_NUMBER = 2;
    public static final int RETCODE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "retcode", "list" }, new Object[] { Integer.valueOf(0), null }, GetOpenidResp.class);
    public final PBRepeatMessageField<GetOpenidProto.GetOpenidEntry> list = PBField.initRepeatMessage(GetOpenidProto.GetOpenidEntry.class);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.protofile.getopenid.GetOpenidProto
 * JD-Core Version:    0.7.0.1
 */