package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class account_detail_dynamic_list
{
  public static final class AccountDetailDynamicListRequest
    extends MessageMicro<AccountDetailDynamicListRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "versionInfo", "puin", "last_msg_id", "msg_cnt" }, new Object[] { "", Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, AccountDetailDynamicListRequest.class);
    public final PBUInt64Field last_msg_id = PBField.initUInt64(0L);
    public final PBUInt32Field msg_cnt = PBField.initUInt32(0);
    public final PBUInt64Field puin = PBField.initUInt64(0L);
    public final PBStringField versionInfo = PBField.initString("");
  }
  
  public static final class AccountDetailDynamicListResponse
    extends MessageMicro<AccountDetailDynamicListResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field last_msg_id = PBField.initUInt64(0L);
    public final PBUInt32Field msg_cnt = PBField.initUInt32(0);
    public final PBRepeatField<ByteStringMicro> msg_infos = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBUInt64Field puin = PBField.initUInt64(0L);
    public account_detail_dynamic_list.RetInfo ret_info = new account_detail_dynamic_list.RetInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42 }, new String[] { "ret_info", "puin", "last_msg_id", "msg_cnt", "msg_infos" }, new Object[] { null, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, AccountDetailDynamicListResponse.class);
    }
  }
  
  public static final class RetInfo
    extends MessageMicro<RetInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret_code", "err_info" }, new Object[] { Integer.valueOf(0), "" }, RetInfo.class);
    public final PBStringField err_info = PBField.initString("");
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mp.account_detail_dynamic_list
 * JD-Core Version:    0.7.0.1
 */