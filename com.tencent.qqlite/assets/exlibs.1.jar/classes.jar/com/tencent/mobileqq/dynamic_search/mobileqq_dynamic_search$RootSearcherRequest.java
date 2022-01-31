package com.tencent.mobileqq.dynamic_search;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobileqq_dynamic_search$RootSearcherRequest
  extends MessageMicro
{
  public static final int BUSINESS_FIELD_NUMBER = 2;
  public static final int BUSI_MASK_FIELD_NUMBER = 5;
  public static final int PAGE_SIZE_FIELD_NUMBER = 4;
  public static final int PLUGIN_STATE_FIELD_NUMBER = 7;
  public static final int REQ_CTRL_TYPE_FIELD_NUMBER = 6;
  public static final int START_INDEX_FIELD_NUMBER = 3;
  public static final int VER_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58 }, new String[] { "ver", "business", "start_index", "page_size", "busi_mask", "req_ctrl_type", "plugin_state" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), Long.valueOf(-1L), Integer.valueOf(0), null }, RootSearcherRequest.class);
  public final PBInt64Field busi_mask = PBField.initInt64(-1L);
  public final PBEnumField business = PBField.initEnum(0);
  public final PBInt32Field page_size = PBField.initInt32(3);
  public final PBRepeatMessageField plugin_state = PBField.initRepeatMessage(mobileqq_dynamic_search.PluginState.class);
  public final PBEnumField req_ctrl_type = PBField.initEnum(0);
  public final PBInt32Field start_index = PBField.initInt32(0);
  public final PBUInt32Field ver = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.RootSearcherRequest
 * JD-Core Version:    0.7.0.1
 */