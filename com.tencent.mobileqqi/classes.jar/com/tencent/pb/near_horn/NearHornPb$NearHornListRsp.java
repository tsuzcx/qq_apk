package com.tencent.pb.near_horn;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class NearHornPb$NearHornListRsp
  extends MessageMicro
{
  public static final int CLIENT_BUFF_FIELD_NUMBER = 15;
  public static final int CONTINUE_QUERY_FIELD_NUMBER = 2;
  public static final int FREE_CNT_FIELD_NUMBER = 4;
  public static final int FREE_POLICY_PMT_FIELD_NUMBER = 10;
  public static final int H5_NAVIGATION_TEXT_FIELD_NUMBER = 16;
  public static final int HEAD_FIELD_NUMBER = 1;
  public static final int HORN_EMPTY_PMT_FIELD_NUMBER = 8;
  public static final int HORN_VALID_TIME_FIELD_NUMBER = 12;
  public static final int HORN_WORD_MAX_FIELD_NUMBER = 11;
  public static final int NOW_FIELD_NUMBER = 3;
  public static final int NO_CNT_HINT_FIELD_NUMBER = 13;
  public static final int PAY_CNT_FIELD_NUMBER = 5;
  public static final int PRESENT_CNT_FIELD_NUMBER = 6;
  public static final int RPT_HORN_INFO_FIELD_NUMBER = 9;
  public static final int STAY_SECOND_FIELD_NUMBER = 7;
  public static final int SVR_BUFF_FIELD_NUMBER = 14;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56, 66, 74, 82, 88, 96, 106, 114, 122, 130 }, new String[] { "head", "continue_query", "now", "free_cnt", "pay_cnt", "present_cnt", "stay_second", "horn_empty_pmt", "rpt_horn_info", "free_policy_pmt", "horn_word_max", "horn_valid_time", "no_cnt_hint", "svr_buff", "client_buff", "h5_navigation_text" }, new Object[] { null, Boolean.valueOf(false), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", null, "", Integer.valueOf(0), Integer.valueOf(0), "", "", "", "" }, NearHornListRsp.class);
  public final PBStringField client_buff = PBField.initString("");
  public final PBBoolField continue_query = PBField.initBool(false);
  public final PBUInt32Field free_cnt = PBField.initUInt32(0);
  public final PBStringField free_policy_pmt = PBField.initString("");
  public final PBStringField h5_navigation_text = PBField.initString("");
  public NearHornPb.HornRspHead head = new NearHornPb.HornRspHead();
  public final PBStringField horn_empty_pmt = PBField.initString("");
  public final PBUInt32Field horn_valid_time = PBField.initUInt32(0);
  public final PBUInt32Field horn_word_max = PBField.initUInt32(0);
  public final PBStringField no_cnt_hint = PBField.initString("");
  public final PBInt64Field now = PBField.initInt64(0L);
  public final PBUInt32Field pay_cnt = PBField.initUInt32(0);
  public final PBUInt32Field present_cnt = PBField.initUInt32(0);
  public final PBRepeatMessageField rpt_horn_info = PBField.initRepeatMessage(NearHornPb.HornInfo.class);
  public final PBUInt32Field stay_second = PBField.initUInt32(0);
  public final PBStringField svr_buff = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.pb.near_horn.NearHornPb.NearHornListRsp
 * JD-Core Version:    0.7.0.1
 */