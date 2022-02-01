package com.tencent.pb.vipfontupdate;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class VipFontUpdate
{
  public static final class TCheckReq
    extends MessageMicro<TCheckReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "i32_type", "i32_font_id", "str_message_test" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "" }, TCheckReq.class);
    public final PBInt32Field i32_font_id = PBField.initInt32(0);
    public final PBInt32Field i32_type = PBField.initInt32(0);
    public final PBStringField str_message_test = PBField.initString("");
  }
  
  public static final class TCheckRsp
    extends MessageMicro<TCheckRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "i32_ret", "st_tips_info", "valid_time" }, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L) }, TCheckRsp.class);
    public final PBInt32Field i32_ret = PBField.initInt32(0);
    public VipFontUpdate.TTipsInfo st_tips_info = new VipFontUpdate.TTipsInfo();
    public final PBInt64Field valid_time = PBField.initInt64(0L);
  }
  
  public static final class TDiyFontReq
    extends MessageMicro<TDiyFontReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_font_req_info" }, new Object[] { null }, TDiyFontReq.class);
    public final PBRepeatMessageField<TDiyFontReqInfo> rpt_font_req_info = PBField.initRepeatMessage(TDiyFontReqInfo.class);
    
    public static final class TDiyFontReqInfo
      extends MessageMicro<TDiyFontReqInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "u64_uin", "i32_font_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, TDiyFontReqInfo.class);
      public final PBInt32Field i32_font_id = PBField.initInt32(0);
      public final PBUInt64Field u64_uin = PBField.initUInt64(0L);
    }
  }
  
  public static final class TDiyFontRsp
    extends MessageMicro<TDiyFontRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_font_rsp_info" }, new Object[] { null }, TDiyFontRsp.class);
    public final PBRepeatMessageField<TDiyFontRspInfo> rpt_font_rsp_info = PBField.initRepeatMessage(TDiyFontRspInfo.class);
    
    public static final class TDiyFontRspInfo
      extends MessageMicro<TDiyFontRspInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "u64_uin", "i32_font_id", "u32_diy_font_timestamp", "str_diy_font_config" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "" }, TDiyFontRspInfo.class);
      public final PBInt32Field i32_font_id = PBField.initInt32(0);
      public final PBStringField str_diy_font_config = PBField.initString("");
      public final PBUInt32Field u32_diy_font_timestamp = PBField.initUInt32(0);
      public final PBUInt64Field u64_uin = PBField.initUInt64(0L);
    }
  }
  
  public static final class TFontFreshReq
    extends MessageMicro<TFontFreshReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 56, 64 }, new String[] { "i32_local_font_id", "i32_cpu_freq", "i32_cpu_num", "i32_total_mem", "str_brand", "str_model", "i32_os_type", "i32_version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0) }, TFontFreshReq.class);
    public final PBInt32Field i32_cpu_freq = PBField.initInt32(0);
    public final PBInt32Field i32_cpu_num = PBField.initInt32(0);
    public final PBInt32Field i32_local_font_id = PBField.initInt32(0);
    public final PBInt32Field i32_os_type = PBField.initInt32(0);
    public final PBInt32Field i32_total_mem = PBField.initInt32(0);
    public final PBInt32Field i32_version = PBField.initInt32(0);
    public final PBStringField str_brand = PBField.initString("");
    public final PBStringField str_model = PBField.initString("");
  }
  
  public static final class TFontFreshRsp
    extends MessageMicro<TFontFreshRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "i32_font_type" }, new Object[] { Integer.valueOf(0) }, TFontFreshRsp.class);
    public final PBInt32Field i32_font_type = PBField.initInt32(0);
  }
  
  public static final class TFontMd5CheckReq
    extends MessageMicro<TFontMd5CheckReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_md5_info" }, new Object[] { null }, TFontMd5CheckReq.class);
    public final PBRepeatMessageField<TMd5Info> rpt_md5_info = PBField.initRepeatMessage(TMd5Info.class);
    
    public static final class TMd5Info
      extends MessageMicro<TMd5Info>
    {
      static final MessageMicro.FieldMap __fieldMap__;
      public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBInt32Field i32_font_id = PBField.initInt32(0);
      
      static
      {
        ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "i32_font_id", "bytes_md5" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, TMd5Info.class);
      }
    }
  }
  
  public static final class TFontMd5CheckRsp
    extends MessageMicro<TFontMd5CheckRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_md5_ret" }, new Object[] { null }, TFontMd5CheckRsp.class);
    public final PBRepeatMessageField<TMd5Ret> rpt_md5_ret = PBField.initRepeatMessage(TMd5Ret.class);
    
    public static final class TMd5Ret
      extends MessageMicro<TMd5Ret>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "i32_check_font_id", "i32_check_ret" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, TMd5Ret.class);
      public final PBInt32Field i32_check_font_id = PBField.initInt32(0);
      public final PBInt32Field i32_check_ret = PBField.initInt32(0);
    }
  }
  
  public static final class TFontSsoReq
    extends MessageMicro<TFontSsoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 66, 74, 82, 90, 98 }, new String[] { "u32_cmd", "u64_seq", "i32_implat", "str_osver", "str_mqqver", "st_fresh_req", "st_md5_check_req", "st_poster_req", "st_check_req", "st_diyfont_req", "st_getposterfont_req", "st_setposterfont_req" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "", "", null, null, null, null, null, null, null }, TFontSsoReq.class);
    public final PBInt32Field i32_implat = PBField.initInt32(0);
    public VipFontUpdate.TCheckReq st_check_req = new VipFontUpdate.TCheckReq();
    public VipFontUpdate.TDiyFontReq st_diyfont_req = new VipFontUpdate.TDiyFontReq();
    public VipFontUpdate.TFontFreshReq st_fresh_req = new VipFontUpdate.TFontFreshReq();
    public VipFontUpdate.TGetPosterFontReq st_getposterfont_req = new VipFontUpdate.TGetPosterFontReq();
    public VipFontUpdate.TFontMd5CheckReq st_md5_check_req = new VipFontUpdate.TFontMd5CheckReq();
    public VipFontUpdate.TPosterReq st_poster_req = new VipFontUpdate.TPosterReq();
    public VipFontUpdate.TSetPosterFontReq st_setposterfont_req = new VipFontUpdate.TSetPosterFontReq();
    public final PBStringField str_mqqver = PBField.initString("");
    public final PBStringField str_osver = PBField.initString("");
    public final PBUInt32Field u32_cmd = PBField.initUInt32(0);
    public final PBUInt64Field u64_seq = PBField.initUInt64(0L);
  }
  
  public static final class TFontSsoRsp
    extends MessageMicro<TFontSsoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50, 58, 66, 82, 90, 98 }, new String[] { "i32_ret", "str_msg", "u32_cmd", "u64_seq", "st_fresh_rsp", "st_md5_check_rsp", "st_poster_rsp", "st_check_rsp", "st_diyfont_rsp", "st_getposterfont_rsp", "st_setposterfont_rsp" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Long.valueOf(0L), null, null, null, null, null, null, null }, TFontSsoRsp.class);
    public final PBInt32Field i32_ret = PBField.initInt32(0);
    public VipFontUpdate.TCheckRsp st_check_rsp = new VipFontUpdate.TCheckRsp();
    public VipFontUpdate.TDiyFontRsp st_diyfont_rsp = new VipFontUpdate.TDiyFontRsp();
    public VipFontUpdate.TFontFreshRsp st_fresh_rsp = new VipFontUpdate.TFontFreshRsp();
    public VipFontUpdate.TGetPosterFontRsp st_getposterfont_rsp = new VipFontUpdate.TGetPosterFontRsp();
    public VipFontUpdate.TFontMd5CheckRsp st_md5_check_rsp = new VipFontUpdate.TFontMd5CheckRsp();
    public VipFontUpdate.TPosterRsp st_poster_rsp = new VipFontUpdate.TPosterRsp();
    public VipFontUpdate.TSetPosterFontRsp st_setposterfont_rsp = new VipFontUpdate.TSetPosterFontRsp();
    public final PBStringField str_msg = PBField.initString("");
    public final PBUInt32Field u32_cmd = PBField.initUInt32(0);
    public final PBUInt64Field u64_seq = PBField.initUInt64(0L);
  }
  
  public static final class TGetPosterFontReq
    extends MessageMicro<TGetPosterFontReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "isgetrecommend" }, new Object[] { Integer.valueOf(0) }, TGetPosterFontReq.class);
    public final PBInt32Field isgetrecommend = PBField.initInt32(0);
  }
  
  public static final class TGetPosterFontRsp
    extends MessageMicro<TGetPosterFontRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "rpt_using_list", "st_redpoint", "i32_recommend_font_id" }, new Object[] { null, null, Integer.valueOf(0) }, TGetPosterFontRsp.class);
    public final PBRepeatField<Integer> i32_recommend_font_id = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public final PBRepeatMessageField<VipFontUpdate.TPosterFontInfo> rpt_using_list = PBField.initRepeatMessage(VipFontUpdate.TPosterFontInfo.class);
    public VipFontUpdate.TPosterFontRedPoint st_redpoint = new VipFontUpdate.TPosterFontRedPoint();
  }
  
  public static final class TPosterFontInfo
    extends MessageMicro<TPosterFontInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "i32_font_id", "u64_ts" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, TPosterFontInfo.class);
    public final PBInt32Field i32_font_id = PBField.initInt32(0);
    public final PBUInt64Field u64_ts = PBField.initUInt64(0L);
  }
  
  public static final class TPosterFontRedPoint
    extends MessageMicro<TPosterFontRedPoint>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "u64_ts", "u64_last" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, TPosterFontRedPoint.class);
    public final PBUInt64Field u64_last = PBField.initUInt64(0L);
    public final PBUInt64Field u64_ts = PBField.initUInt64(0L);
  }
  
  public static final class TPosterInfo
    extends MessageMicro<TPosterInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "i32_font_id", "str_img_url", "str_tag_url" }, new Object[] { Integer.valueOf(0), "", "" }, TPosterInfo.class);
    public final PBInt32Field i32_font_id = PBField.initInt32(0);
    public final PBStringField str_img_url = PBField.initString("");
    public final PBStringField str_tag_url = PBField.initString("");
  }
  
  public static final class TPosterReq
    extends MessageMicro<TPosterReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "i32_valid" }, new Object[] { Integer.valueOf(0) }, TPosterReq.class);
    public final PBInt32Field i32_valid = PBField.initInt32(0);
  }
  
  public static final class TPosterRsp
    extends MessageMicro<TPosterRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "i32_valid", "rpt_mine_list", "rpt_recommend_list" }, new Object[] { Integer.valueOf(0), null, null }, TPosterRsp.class);
    public final PBInt32Field i32_valid = PBField.initInt32(0);
    public final PBRepeatMessageField<VipFontUpdate.TPosterInfo> rpt_mine_list = PBField.initRepeatMessage(VipFontUpdate.TPosterInfo.class);
    public final PBRepeatMessageField<VipFontUpdate.TPosterInfo> rpt_recommend_list = PBField.initRepeatMessage(VipFontUpdate.TPosterInfo.class);
  }
  
  public static final class TSetPosterFontReq
    extends MessageMicro<TSetPosterFontReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "i32_font_id" }, new Object[] { Integer.valueOf(0) }, TSetPosterFontReq.class);
    public final PBInt32Field i32_font_id = PBField.initInt32(0);
  }
  
  public static final class TSetPosterFontRsp
    extends MessageMicro<TSetPosterFontRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "i32_ret", "st_tips_info" }, new Object[] { Integer.valueOf(0), null }, TSetPosterFontRsp.class);
    public final PBInt32Field i32_ret = PBField.initInt32(0);
    public VipFontUpdate.TTipsInfo st_tips_info = new VipFontUpdate.TTipsInfo();
  }
  
  public static final class TTipsInfo
    extends MessageMicro<TTipsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "i32_type", "str_msg", "str_title", "str_button", "str_url", "str_vip_type", "str_month", "str_aid" }, new Object[] { Integer.valueOf(0), "", "", "", "", "", "", "" }, TTipsInfo.class);
    public final PBInt32Field i32_type = PBField.initInt32(0);
    public final PBStringField str_aid = PBField.initString("");
    public final PBStringField str_button = PBField.initString("");
    public final PBStringField str_month = PBField.initString("");
    public final PBStringField str_msg = PBField.initString("");
    public final PBStringField str_title = PBField.initString("");
    public final PBStringField str_url = PBField.initString("");
    public final PBStringField str_vip_type = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.vipfontupdate.VipFontUpdate
 * JD-Core Version:    0.7.0.1
 */