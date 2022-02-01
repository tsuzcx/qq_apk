package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class EmosmPb
{
  public static final class BqAssocInfo
    extends MessageMicro<BqAssocInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50, 58, 66, 74, 82, 88, 98, 106, 114 }, new String[] { "u32_tab_id", "str_tab_name", "u32_tab_feetype", "i32_tab_type", "i32_tab_ringtype", "str_item_id", "str_item_name", "str_item_key", "rpt_str_item_keyword", "rpt_support_size", "uint32_emoji_type", "rpt_apng_support_size", "str_ipsite_url", "str_ipsite_name" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", null, Integer.valueOf(0), null, "", "" }, BqAssocInfo.class);
    public final PBInt32Field i32_tab_ringtype = PBField.initInt32(0);
    public final PBInt32Field i32_tab_type = PBField.initInt32(0);
    public final PBRepeatMessageField<EmosmPb.SupportSize> rpt_apng_support_size = PBField.initRepeatMessage(EmosmPb.SupportSize.class);
    public final PBRepeatField<String> rpt_str_item_keyword = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatMessageField<EmosmPb.SupportSize> rpt_support_size = PBField.initRepeatMessage(EmosmPb.SupportSize.class);
    public final PBStringField str_ipsite_name = PBField.initString("");
    public final PBStringField str_ipsite_url = PBField.initString("");
    public final PBStringField str_item_id = PBField.initString("");
    public final PBStringField str_item_key = PBField.initString("");
    public final PBStringField str_item_name = PBField.initString("");
    public final PBStringField str_tab_name = PBField.initString("");
    public final PBUInt32Field u32_tab_feetype = PBField.initUInt32(0);
    public final PBUInt32Field u32_tab_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_emoji_type = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 160 }, new String[] { "uint32_sub_cmd", "uint64_uin", "msg_subcmd0x1_req_deltab", "msg_subcmd0x2_req_fetchtab", "msg_subcmd0x3_req_fetchbq", "int32_plat_id", "str_app_version", "msg_subcmd0x6_req", "msg_subcmd0x7_req", "msg_subcmd0x8_req_addtab", "msg_subcmd0x9_req", "msg_subcmd0x10_req", "msg_subcmd0x5_req", "msg_subcmd0x11_req", "msg_subcmd0x12_req", "msg_subcmd0x13_req", "msg_subcmd0x14_req_fetchtab_mac", "msg_subcmd0x18_req", "msg_subcmd0x19_req", "uint32_business_id" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, null, null, Integer.valueOf(0), "", null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(0) }, ReqBody.class);
    public final PBInt32Field int32_plat_id = PBField.initInt32(0);
    public EmosmPb.SubCmd0x10MoveOrderReq msg_subcmd0x10_req = new EmosmPb.SubCmd0x10MoveOrderReq();
    public EmosmPb.SubCmd0x11Req msg_subcmd0x11_req = new EmosmPb.SubCmd0x11Req();
    public EmosmPb.SubCmd0x12Req msg_subcmd0x12_req = new EmosmPb.SubCmd0x12Req();
    public EmosmPb.SubCmd0x13Req msg_subcmd0x13_req = new EmosmPb.SubCmd0x13Req();
    public EmosmPb.SubCmd0x14ReqFetchTabMac msg_subcmd0x14_req_fetchtab_mac = new EmosmPb.SubCmd0x14ReqFetchTabMac();
    public EmosmPb.SubCmd0x18Req msg_subcmd0x18_req = new EmosmPb.SubCmd0x18Req();
    public EmosmPb.SubCmd0x19Req msg_subcmd0x19_req = new EmosmPb.SubCmd0x19Req();
    public EmosmPb.SubCmd0x1ReqDelTab msg_subcmd0x1_req_deltab = new EmosmPb.SubCmd0x1ReqDelTab();
    public EmosmPb.SubCmd0x2ReqFetchTab msg_subcmd0x2_req_fetchtab = new EmosmPb.SubCmd0x2ReqFetchTab();
    public EmosmPb.SubCmd0x3ReqFetchBq msg_subcmd0x3_req_fetchbq = new EmosmPb.SubCmd0x3ReqFetchBq();
    public EmosmPb.SubCmd0x5ReqBQRecommend msg_subcmd0x5_req = new EmosmPb.SubCmd0x5ReqBQRecommend();
    public EmosmPb.SubCmd0x6Req msg_subcmd0x6_req = new EmosmPb.SubCmd0x6Req();
    public EmosmPb.SubCmd0x7Req msg_subcmd0x7_req = new EmosmPb.SubCmd0x7Req();
    public EmosmPb.SubCmd0x8ReqAddTab msg_subcmd0x8_req_addtab = new EmosmPb.SubCmd0x8ReqAddTab();
    public EmosmPb.SubCmd0x9BqAssocReq msg_subcmd0x9_req = new EmosmPb.SubCmd0x9BqAssocReq();
    public final PBStringField str_app_version = PBField.initString("");
    public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 138, 146, 154, 160 }, new String[] { "uint32_sub_cmd", "int32_result", "msg_subcmd0x1_rsp_deltab", "msg_subcmd0x2_rsp_fetchtab", "msg_subcmd0x3_rsp_fetchbq", "msg_subcmd0x5_recommend", "msg_subcmd0x6_collect_auth", "msg_subcmd0x7_rsp", "msg_subcmd0x8_rsp_addtab", "msg_subcmd0x9_rsp", "msg_subcmd0x10_rsp", "msg_subcmd0x11_rsp", "msg_subcmd0x12_rsp", "msg_subcmd0x13_rsp", "msg_subcmd0x14_rsp_fetchtab_mac", "msg_subcmd0x18_rsp", "msg_subcmd0x19_rsp", "uint32_business_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(0) }, RspBody.class);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public EmosmPb.SubCmd0x10MoveOrderRsp msg_subcmd0x10_rsp = new EmosmPb.SubCmd0x10MoveOrderRsp();
    public EmosmPb.SubCmd0x11Rsp msg_subcmd0x11_rsp = new EmosmPb.SubCmd0x11Rsp();
    public EmosmPb.SubCmd0x12Rsp msg_subcmd0x12_rsp = new EmosmPb.SubCmd0x12Rsp();
    public EmosmPb.SubCmd0x13Rsp msg_subcmd0x13_rsp = new EmosmPb.SubCmd0x13Rsp();
    public EmosmPb.SubCmd0x14RspFetchTabMac msg_subcmd0x14_rsp_fetchtab_mac = new EmosmPb.SubCmd0x14RspFetchTabMac();
    public EmosmPb.SubCmd0x18Rsp msg_subcmd0x18_rsp = new EmosmPb.SubCmd0x18Rsp();
    public EmosmPb.SubCmd0x19Rsp msg_subcmd0x19_rsp = new EmosmPb.SubCmd0x19Rsp();
    public EmosmPb.SubCmd0x1RspDelTab msg_subcmd0x1_rsp_deltab = new EmosmPb.SubCmd0x1RspDelTab();
    public EmosmPb.SubCmd0x2RspFetchTab msg_subcmd0x2_rsp_fetchtab = new EmosmPb.SubCmd0x2RspFetchTab();
    public EmosmPb.SubCmd0x3RspFetchBq msg_subcmd0x3_rsp_fetchbq = new EmosmPb.SubCmd0x3RspFetchBq();
    public EmosmPb.SubCmd0x5RspBQRecommend msg_subcmd0x5_recommend = new EmosmPb.SubCmd0x5RspBQRecommend();
    public EmosmPb.SubCmd0x6Rsp msg_subcmd0x6_collect_auth = new EmosmPb.SubCmd0x6Rsp();
    public EmosmPb.SubCmd0x7Rsp msg_subcmd0x7_rsp = new EmosmPb.SubCmd0x7Rsp();
    public EmosmPb.SubCmd0x8RspAddTab msg_subcmd0x8_rsp_addtab = new EmosmPb.SubCmd0x8RspAddTab();
    public EmosmPb.SubCmd0x9BqAssocRsp msg_subcmd0x9_rsp = new EmosmPb.SubCmd0x9BqAssocRsp();
    public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  }
  
  public static final class STAIOFixRecommend
    extends MessageMicro<STAIOFixRecommend>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "u32_pos", "rpt_list" }, new Object[] { Integer.valueOf(0), null }, STAIOFixRecommend.class);
    public final PBRepeatMessageField<EmosmPb.STRecommendTabInfo> rpt_list = PBField.initRepeatMessage(EmosmPb.STRecommendTabInfo.class);
    public final PBUInt32Field u32_pos = PBField.initUInt32(0);
  }
  
  public static final class STRecommendTabInfo
    extends MessageMicro<STRecommendTabInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50, 58, 66, 74, 80, 88 }, new String[] { "u32_tab_id", "str_tab_name", "i32_tab_type", "i32_feetype", "i32_price", "str_button_url", "str_thumb_nail_url", "str_bg_color", "str_title_color", "i32_recommend_mode", "int32_red_point_flag" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), Integer.valueOf(0) }, STRecommendTabInfo.class);
    public final PBInt32Field i32_feetype = PBField.initInt32(0);
    public final PBInt32Field i32_price = PBField.initInt32(0);
    public final PBInt32Field i32_recommend_mode = PBField.initInt32(0);
    public final PBInt32Field i32_tab_type = PBField.initInt32(0);
    public final PBInt32Field int32_red_point_flag = PBField.initInt32(0);
    public final PBStringField str_bg_color = PBField.initString("");
    public final PBStringField str_button_url = PBField.initString("");
    public final PBStringField str_tab_name = PBField.initString("");
    public final PBStringField str_thumb_nail_url = PBField.initString("");
    public final PBStringField str_title_color = PBField.initString("");
    public final PBUInt32Field u32_tab_id = PBField.initUInt32(0);
  }
  
  public static final class SmallYellowItem
    extends MessageMicro<SmallYellowItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "id", "type", "count", "ts" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, SmallYellowItem.class);
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBUInt32Field id = PBField.initUInt32(0);
    public final PBUInt64Field ts = PBField.initUInt64(0L);
    public final PBUInt32Field type = PBField.initUInt32(0);
  }
  
  public static final class SubCmd0x10MoveOrderReq
    extends MessageMicro<SubCmd0x10MoveOrderReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_tab_id" }, new Object[] { Integer.valueOf(0) }, SubCmd0x10MoveOrderReq.class);
    public final PBRepeatField<Integer> uint32_tab_id = PBField.initRepeat(PBInt32Field.__repeatHelper__);
  }
  
  public static final class SubCmd0x10MoveOrderRsp
    extends MessageMicro<SubCmd0x10MoveOrderRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "int32_move_detail" }, new Object[] { Integer.valueOf(0) }, SubCmd0x10MoveOrderRsp.class);
    public final PBInt32Field int32_move_detail = PBField.initInt32(0);
  }
  
  public static final class SubCmd0x11Req
    extends MessageMicro<SubCmd0x11Req>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], SubCmd0x11Req.class);
  }
  
  public static final class SubCmd0x11Rsp
    extends MessageMicro<SubCmd0x11Rsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "itemlist" }, new Object[] { null }, SubCmd0x11Rsp.class);
    public final PBRepeatMessageField<EmosmPb.SmallYellowItem> itemlist = PBField.initRepeatMessage(EmosmPb.SmallYellowItem.class);
  }
  
  public static final class SubCmd0x12Req
    extends MessageMicro<SubCmd0x12Req>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "itemlist" }, new Object[] { null }, SubCmd0x12Req.class);
    public final PBRepeatMessageField<EmosmPb.SmallYellowItem> itemlist = PBField.initRepeatMessage(EmosmPb.SmallYellowItem.class);
  }
  
  public static final class SubCmd0x12Rsp
    extends MessageMicro<SubCmd0x12Rsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "ret" }, new Object[] { Integer.valueOf(0) }, SubCmd0x12Rsp.class);
    public final PBInt32Field ret = PBField.initInt32(0);
  }
  
  public static final class SubCmd0x13Req
    extends MessageMicro<SubCmd0x13Req>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "itemlist" }, new Object[] { null }, SubCmd0x13Req.class);
    public final PBRepeatMessageField<EmosmPb.SmallYellowItem> itemlist = PBField.initRepeatMessage(EmosmPb.SmallYellowItem.class);
  }
  
  public static final class SubCmd0x13Rsp
    extends MessageMicro<SubCmd0x13Rsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "itemlist" }, new Object[] { null }, SubCmd0x13Rsp.class);
    public final PBRepeatMessageField<EmosmPb.SmallYellowItem> itemlist = PBField.initRepeatMessage(EmosmPb.SmallYellowItem.class);
  }
  
  public static final class SubCmd0x14ReqFetchTabMac
    extends MessageMicro<SubCmd0x14ReqFetchTabMac>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 16, 29, 32 }, new String[] { "fixed32_timestamp_ios", "int32_segment_flag_ios", "fixed32_timestamp_android", "int32_segment_flag_android" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SubCmd0x14ReqFetchTabMac.class);
    public final PBFixed32Field fixed32_timestamp_android = PBField.initFixed32(0);
    public final PBFixed32Field fixed32_timestamp_ios = PBField.initFixed32(0);
    public final PBInt32Field int32_segment_flag_android = PBField.initInt32(0);
    public final PBInt32Field int32_segment_flag_ios = PBField.initInt32(0);
  }
  
  public static final class SubCmd0x14RspFetchTabMac
    extends MessageMicro<SubCmd0x14RspFetchTabMac>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 16, 29, 32, 42, 50, 58, 64 }, new String[] { "fixed32_timestamp_ios", "int32_segment_flag_ios", "fixed32_timestamp_android", "int32_segment_flag_android", "rpt_msg_tabinfo", "rpt_magic_tabinfo", "rpt_smallbq_tabinfo", "uint32_tab_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, Integer.valueOf(0) }, SubCmd0x14RspFetchTabMac.class);
    public final PBFixed32Field fixed32_timestamp_android = PBField.initFixed32(0);
    public final PBFixed32Field fixed32_timestamp_ios = PBField.initFixed32(0);
    public final PBInt32Field int32_segment_flag_android = PBField.initInt32(0);
    public final PBInt32Field int32_segment_flag_ios = PBField.initInt32(0);
    public final PBRepeatMessageField<TabInfo> rpt_magic_tabinfo = PBField.initRepeatMessage(TabInfo.class);
    public final PBRepeatMessageField<TabInfo> rpt_msg_tabinfo = PBField.initRepeatMessage(TabInfo.class);
    public final PBRepeatMessageField<TabInfo> rpt_smallbq_tabinfo = PBField.initRepeatMessage(TabInfo.class);
    public final PBRepeatField<Integer> uint32_tab_id = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    
    public static final class TabInfo
      extends MessageMicro<TabInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 21, 24, 32, 40, 50 }, new String[] { "uint32_tab_id", "fixed32_expire_time", "uint32_flags", "int32_wording_id", "int32_tab_type", "str_tab_name" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, TabInfo.class);
      public final PBFixed32Field fixed32_expire_time = PBField.initFixed32(0);
      public final PBInt32Field int32_tab_type = PBField.initInt32(0);
      public final PBInt32Field int32_wording_id = PBField.initInt32(0);
      public final PBStringField str_tab_name = PBField.initString("");
      public final PBUInt32Field uint32_flags = PBField.initUInt32(0);
      public final PBUInt32Field uint32_tab_id = PBField.initUInt32(0);
    }
  }
  
  public static final class SubCmd0x18Req
    extends MessageMicro<SubCmd0x18Req>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_tab_id" }, new Object[] { Integer.valueOf(0) }, SubCmd0x18Req.class);
    public final PBUInt32Field uint32_tab_id = PBField.initUInt32(0);
  }
  
  public static final class SubCmd0x18Rsp
    extends MessageMicro<SubCmd0x18Rsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "bool_jump_flag", "uint32_author_id" }, new Object[] { Boolean.valueOf(false), Integer.valueOf(0) }, SubCmd0x18Rsp.class);
    public final PBBoolField bool_jump_flag = PBField.initBool(false);
    public final PBUInt32Field uint32_author_id = PBField.initUInt32(0);
  }
  
  public static final class SubCmd0x19Req
    extends MessageMicro<SubCmd0x19Req>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_package_id" }, new Object[] { Integer.valueOf(0) }, SubCmd0x19Req.class);
    public final PBUInt32Field uint32_package_id = PBField.initUInt32(0);
  }
  
  public static final class SubCmd0x19Rsp
    extends MessageMicro<SubCmd0x19Rsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 61 }, new String[] { "uint32_package_id", "str_ip_url", "str_ip_name", "str_ip_detail", "str_op_name", "str_jump_url", "fixed32_time" }, new Object[] { Integer.valueOf(0), "", "", "", "", "", Integer.valueOf(0) }, SubCmd0x19Rsp.class);
    public final PBFixed32Field fixed32_time = PBField.initFixed32(0);
    public final PBStringField str_ip_detail = PBField.initString("");
    public final PBStringField str_ip_name = PBField.initString("");
    public final PBStringField str_ip_url = PBField.initString("");
    public final PBStringField str_jump_url = PBField.initString("");
    public final PBStringField str_op_name = PBField.initString("");
    public final PBUInt32Field uint32_package_id = PBField.initUInt32(0);
  }
  
  public static final class SubCmd0x1ReqDelTab
    extends MessageMicro<SubCmd0x1ReqDelTab>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_tab_id", "rpt_tab_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, SubCmd0x1ReqDelTab.class);
    public final PBRepeatField<Integer> rpt_tab_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_tab_id = PBField.initUInt32(0);
  }
  
  public static final class SubCmd0x1RspDelTab
    extends MessageMicro<SubCmd0x1RspDelTab>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_tab_id" }, new Object[] { Integer.valueOf(0) }, SubCmd0x1RspDelTab.class);
    public final PBUInt32Field uint32_tab_id = PBField.initUInt32(0);
  }
  
  public static final class SubCmd0x2ReqFetchTab
    extends MessageMicro<SubCmd0x2ReqFetchTab>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 16 }, new String[] { "fixed32_timestamp", "int32_segment_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, SubCmd0x2ReqFetchTab.class);
    public final PBFixed32Field fixed32_timestamp = PBField.initFixed32(0);
    public final PBInt32Field int32_segment_flag = PBField.initInt32(0);
  }
  
  public static final class SubCmd0x2RspFetchTab
    extends MessageMicro<SubCmd0x2RspFetchTab>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 16, 26, 34, 42, 48 }, new String[] { "fixed32_timestamp", "int32_segment_flag", "rpt_msg_tabinfo", "rpt_magic_tabinfo", "rpt_smallbq_tabinfo", "uint32_tab_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null, Integer.valueOf(0) }, SubCmd0x2RspFetchTab.class);
    public final PBFixed32Field fixed32_timestamp = PBField.initFixed32(0);
    public final PBInt32Field int32_segment_flag = PBField.initInt32(0);
    public final PBRepeatMessageField<TabInfo> rpt_magic_tabinfo = PBField.initRepeatMessage(TabInfo.class);
    public final PBRepeatMessageField<TabInfo> rpt_msg_tabinfo = PBField.initRepeatMessage(TabInfo.class);
    public final PBRepeatMessageField<TabInfo> rpt_smallbq_tabinfo = PBField.initRepeatMessage(TabInfo.class);
    public final PBRepeatField<Integer> uint32_tab_id = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    
    public static final class TabInfo
      extends MessageMicro<TabInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 21, 24, 32, 40, 50 }, new String[] { "uint32_tab_id", "fixed32_expire_time", "uint32_flags", "int32_wording_id", "int32_tab_type", "str_tab_name" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, TabInfo.class);
      public final PBFixed32Field fixed32_expire_time = PBField.initFixed32(0);
      public final PBInt32Field int32_tab_type = PBField.initInt32(0);
      public final PBInt32Field int32_wording_id = PBField.initInt32(0);
      public final PBStringField str_tab_name = PBField.initString("");
      public final PBUInt32Field uint32_flags = PBField.initUInt32(0);
      public final PBUInt32Field uint32_tab_id = PBField.initUInt32(0);
    }
  }
  
  public static final class SubCmd0x3ReqFetchBq
    extends MessageMicro<SubCmd0x3ReqFetchBq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> rpt_bytes_bqid = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBRepeatField<ByteStringMicro> rpt_new_itemid = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBUInt32Field uint32_tab_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_tab_id", "rpt_bytes_bqid", "rpt_new_itemid" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, SubCmd0x3ReqFetchBq.class);
    }
  }
  
  public static final class SubCmd0x3RspFetchBq
    extends MessageMicro<SubCmd0x3RspFetchBq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> rpt_bytes_key = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_bytes_key" }, new Object[] { localByteStringMicro }, SubCmd0x3RspFetchBq.class);
    }
  }
  
  public static final class SubCmd0x5ReqBQRecommend
    extends MessageMicro<SubCmd0x5ReqBQRecommend>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "int32_last_recommend_version" }, new Object[] { Integer.valueOf(0) }, SubCmd0x5ReqBQRecommend.class);
    public final PBInt32Field int32_last_recommend_version = PBField.initInt32(0);
  }
  
  public static final class SubCmd0x5RspBQRecommend
    extends MessageMicro<SubCmd0x5RspBQRecommend>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56, 66, 72, 80, 88, 98, 104 }, new String[] { "st_tab_info", "str_morebq_img_url", "bool_update_flag", "int32_last_recommend_version", "bool_recommend_show_flag", "int32_show_num", "int32_exposure_num", "st_new_tab_info", "int32_red_point_flag", "int32_light_out_interval", "int32_req_frequency", "st_fixinfo", "int32_ruleid" }, new Object[] { null, "", Boolean.valueOf(false), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0) }, SubCmd0x5RspBQRecommend.class);
    public final PBBoolField bool_recommend_show_flag = PBField.initBool(false);
    public final PBBoolField bool_update_flag = PBField.initBool(false);
    public final PBInt32Field int32_exposure_num = PBField.initInt32(0);
    public final PBInt32Field int32_last_recommend_version = PBField.initInt32(0);
    public final PBInt32Field int32_light_out_interval = PBField.initInt32(0);
    public final PBInt32Field int32_red_point_flag = PBField.initInt32(0);
    public final PBInt32Field int32_req_frequency = PBField.initInt32(0);
    public final PBInt32Field int32_ruleid = PBField.initInt32(0);
    public final PBInt32Field int32_show_num = PBField.initInt32(0);
    public final PBRepeatMessageField<EmosmPb.STAIOFixRecommend> st_fixinfo = PBField.initRepeatMessage(EmosmPb.STAIOFixRecommend.class);
    public final PBRepeatMessageField<EmosmPb.STRecommendTabInfo> st_new_tab_info = PBField.initRepeatMessage(EmosmPb.STRecommendTabInfo.class);
    public final PBRepeatMessageField<EmosmPb.STRecommendTabInfo> st_tab_info = PBField.initRepeatMessage(EmosmPb.STRecommendTabInfo.class);
    public final PBStringField str_morebq_img_url = PBField.initString("");
  }
  
  public static final class SubCmd0x6Req
    extends MessageMicro<SubCmd0x6Req>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "u32_tab_id", "str_item_id" }, new Object[] { Integer.valueOf(0), "" }, SubCmd0x6Req.class);
    public final PBStringField str_item_id = PBField.initString("");
    public final PBUInt32Field u32_tab_id = PBField.initUInt32(0);
  }
  
  public static final class SubCmd0x6Rsp
    extends MessageMicro<SubCmd0x6Rsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "int32_auth_detail", "str_auth_msg" }, new Object[] { Integer.valueOf(0), "" }, SubCmd0x6Rsp.class);
    public final PBInt32Field int32_auth_detail = PBField.initInt32(0);
    public final PBStringField str_auth_msg = PBField.initString("");
  }
  
  public static final class SubCmd0x7Req
    extends MessageMicro<SubCmd0x7Req>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "u32_tab_id", "str_item_id" }, new Object[] { Integer.valueOf(0), "" }, SubCmd0x7Req.class);
    public final PBStringField str_item_id = PBField.initString("");
    public final PBUInt32Field u32_tab_id = PBField.initUInt32(0);
  }
  
  public static final class SubCmd0x7Rsp
    extends MessageMicro<SubCmd0x7Rsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "int32_auth_detail", "str_auth_msg" }, new Object[] { Integer.valueOf(0), "" }, SubCmd0x7Rsp.class);
    public final PBInt32Field int32_auth_detail = PBField.initInt32(0);
    public final PBStringField str_auth_msg = PBField.initString("");
  }
  
  public static final class SubCmd0x8ReqAddTab
    extends MessageMicro<SubCmd0x8ReqAddTab>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_tab_id" }, new Object[] { Integer.valueOf(0) }, SubCmd0x8ReqAddTab.class);
    public final PBUInt32Field uint32_tab_id = PBField.initUInt32(0);
  }
  
  public static final class SubCmd0x8RspAddTab
    extends MessageMicro<SubCmd0x8RspAddTab>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], SubCmd0x8RspAddTab.class);
  }
  
  public static final class SubCmd0x9BqAssocReq
    extends MessageMicro<SubCmd0x9BqAssocReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "str_key_word", "rpt_str_bq_item_id", "rpt_str_dead_bq_item_id" }, new Object[] { "", "", "" }, SubCmd0x9BqAssocReq.class);
    public final PBRepeatField<String> rpt_str_bq_item_id = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatField<String> rpt_str_dead_bq_item_id = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField str_key_word = PBField.initString("");
  }
  
  public static final class SubCmd0x9BqAssocRsp
    extends MessageMicro<SubCmd0x9BqAssocRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rpt_assoc_bqs", "i32_reset_exposure_flag" }, new Object[] { null, Integer.valueOf(0) }, SubCmd0x9BqAssocRsp.class);
    public final PBInt32Field i32_reset_exposure_flag = PBField.initInt32(0);
    public final PBRepeatMessageField<EmosmPb.BqAssocInfo> rpt_assoc_bqs = PBField.initRepeatMessage(EmosmPb.BqAssocInfo.class);
  }
  
  public static final class SupportSize
    extends MessageMicro<SupportSize>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "u32_Width", "u32_height" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, SupportSize.class);
    public final PBUInt32Field u32_Width = PBField.initUInt32(0);
    public final PBUInt32Field u32_height = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.emosm.EmosmPb
 * JD-Core Version:    0.7.0.1
 */