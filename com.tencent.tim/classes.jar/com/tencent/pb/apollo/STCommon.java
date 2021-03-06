package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class STCommon
{
  public static final class STCPatchUpdateInfoReq
    extends MessageMicro<STCPatchUpdateInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 402 }, new String[] { "list", "from" }, new Object[] { null, "" }, STCPatchUpdateInfoReq.class);
    public final PBStringField from = PBField.initString("");
    public final PBRepeatMessageField<STCommon.STLocalCVerInfo> list = PBField.initRepeatMessage(STCommon.STLocalCVerInfo.class);
  }
  
  public static final class STLocalCVerInfo
    extends MessageMicro<STLocalCVerInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "busId", "itemId", "localVer" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0) }, STLocalCVerInfo.class);
    public final PBUInt32Field busId = PBField.initUInt32(0);
    public final PBStringField itemId = PBField.initString("");
    public final PBUInt32Field localVer = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.apollo.STCommon
 * JD-Core Version:    0.7.0.1
 */