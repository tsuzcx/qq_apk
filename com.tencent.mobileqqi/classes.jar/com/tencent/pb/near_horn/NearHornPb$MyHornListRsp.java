package com.tencent.pb.near_horn;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class NearHornPb$MyHornListRsp
  extends MessageMicro
{
  public static final int CLIENT_BUFF_FIELD_NUMBER = 5;
  public static final int CONTINUE_QUERY_FIELD_NUMBER = 2;
  public static final int HEAD_FIELD_NUMBER = 1;
  public static final int MY_HORNS_FIELD_NUMBER = 3;
  public static final int SVR_BUFF_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42 }, new String[] { "head", "continue_query", "my_horns", "svr_buff", "client_buff" }, new Object[] { null, Boolean.valueOf(false), null, "", "" }, MyHornListRsp.class);
  public final PBStringField client_buff = PBField.initString("");
  public final PBBoolField continue_query = PBField.initBool(false);
  public NearHornPb.HornRspHead head = new NearHornPb.HornRspHead();
  public final PBRepeatMessageField my_horns = PBField.initRepeatMessage(NearHornPb.MyHornInfo.class);
  public final PBStringField svr_buff = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.pb.near_horn.NearHornPb.MyHornListRsp
 * JD-Core Version:    0.7.0.1
 */