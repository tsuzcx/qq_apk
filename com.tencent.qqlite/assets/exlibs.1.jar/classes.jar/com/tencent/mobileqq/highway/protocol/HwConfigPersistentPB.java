package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class HwConfigPersistentPB
{
  public static final class HwConfigItemPB
    extends MessageMicro<HwConfigItemPB>
  {
    public static final int RPT_END_POINT_LIST_FIELD_NUMBER = 2;
    public static final int STRING_KEY_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "string_key", "rpt_end_point_list" }, new Object[] { "", null }, HwConfigItemPB.class);
    public final PBRepeatMessageField<HwConfigPersistentPB.HwEndPointPB> rpt_end_point_list = PBField.initRepeatMessage(HwConfigPersistentPB.HwEndPointPB.class);
    public final PBStringField string_key = PBField.initString("");
  }
  
  public static final class HwConfigPB
    extends MessageMicro<HwConfigPB>
  {
    public static final int RPT_CONFIG_ITEM_LIST_FIELD_NUMBER = 1;
    public static final int RPT_NET_SEG_CONF_LIST_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_config_item_list", "rpt_net_seg_conf_list" }, new Object[] { null, null }, HwConfigPB.class);
    public final PBRepeatMessageField<HwConfigPersistentPB.HwConfigItemPB> rpt_config_item_list = PBField.initRepeatMessage(HwConfigPersistentPB.HwConfigItemPB.class);
    public final PBRepeatMessageField<HwConfigPersistentPB.HwNetSegConfPB> rpt_net_seg_conf_list = PBField.initRepeatMessage(HwConfigPersistentPB.HwNetSegConfPB.class);
  }
  
  public static final class HwEndPointPB
    extends MessageMicro<HwEndPointPB>
  {
    public static final int INT32_PORT_FIELD_NUMBER = 2;
    public static final int INT64_TIMESTAMPE_FIELD_NUMBER = 3;
    public static final int STRING_HOST_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "string_host", "int32_port", "int64_timestampe" }, new Object[] { "", Integer.valueOf(0), Long.valueOf(0L) }, HwEndPointPB.class);
    public final PBInt32Field int32_port = PBField.initInt32(0);
    public final PBInt64Field int64_timestampe = PBField.initInt64(0L);
    public final PBStringField string_host = PBField.initString("");
  }
  
  public static final class HwNetSegConfPB
    extends MessageMicro<HwNetSegConfPB>
  {
    public static final int INT64_CUR_CONN_NUM_FIELD_NUMBER = 4;
    public static final int INT64_NET_TYPE_FIELD_NUMBER = 1;
    public static final int INT64_SEG_NUM_FIELD_NUMBER = 3;
    public static final int INT64_SEG_SIZE_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "int64_net_type", "int64_seg_size", "int64_seg_num", "int64_cur_conn_num" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, HwNetSegConfPB.class);
    public final PBInt64Field int64_cur_conn_num = PBField.initInt64(0L);
    public final PBInt64Field int64_net_type = PBField.initInt64(0L);
    public final PBInt64Field int64_seg_num = PBField.initInt64(0L);
    public final PBInt64Field int64_seg_size = PBField.initInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.HwConfigPersistentPB
 * JD-Core Version:    0.7.0.1
 */