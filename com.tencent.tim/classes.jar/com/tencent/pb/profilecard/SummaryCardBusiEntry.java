package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SummaryCardBusiEntry
{
  public static final class Color
    extends MessageMicro<Color>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_r", "uint32_g", "uint32_b" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Color.class);
    public final PBUInt32Field uint32_b = PBField.initUInt32(0);
    public final PBUInt32Field uint32_g = PBField.initUInt32(0);
    public final PBUInt32Field uint32_r = PBField.initUInt32(0);
  }
  
  public static final class CommonReq
    extends MessageMicro<CommonReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "serviceCmd", "vcReq", "hrReq" }, new Object[] { "", null, null }, CommonReq.class);
    public SummaryCardBusiEntry.HideRecordsReq hrReq = new SummaryCardBusiEntry.HideRecordsReq();
    public final PBStringField serviceCmd = PBField.initString("");
    public SummaryCardBusiEntry.VisitorCountReq vcReq = new SummaryCardBusiEntry.VisitorCountReq();
  }
  
  public static final class DetailRecord
    extends MessageMicro<DetailRecord>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "fuin", "source", "vtime", "mod", "hideFlag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, DetailRecord.class);
    public final PBUInt32Field fuin = PBField.initUInt32(0);
    public final PBInt32Field hideFlag = PBField.initInt32(0);
    public final PBInt32Field mod = PBField.initInt32(0);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt32Field vtime = PBField.initUInt32(0);
  }
  
  public static final class HideRecordsReq
    extends MessageMicro<HideRecordsReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "huin", "fuin", "records" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, HideRecordsReq.class);
    public final PBUInt32Field fuin = PBField.initUInt32(0);
    public final PBUInt32Field huin = PBField.initUInt32(0);
    public final PBRepeatMessageField<SummaryCardBusiEntry.DetailRecord> records = PBField.initRepeatMessage(SummaryCardBusiEntry.DetailRecord.class);
  }
  
  public static final class Label
    extends MessageMicro<Label>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public SummaryCardBusiEntry.Color edging_color = new SummaryCardBusiEntry.Color();
    public final PBEnumField enum_type = PBField.initEnum(1);
    public SummaryCardBusiEntry.Color text_color = new SummaryCardBusiEntry.Color();
    public final PBUInt32Field uint32_label_attr = PBField.initUInt32(0);
    public final PBUInt32Field uint32_label_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 48 }, new String[] { "bytes_name", "enum_type", "text_color", "edging_color", "uint32_label_attr", "uint32_label_type" }, new Object[] { localByteStringMicro, Integer.valueOf(1), null, null, Integer.valueOf(0), Integer.valueOf(0) }, Label.class);
    }
  }
  
  public static final class LoginSig
    extends MessageMicro<LoginSig>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_type", "bytes_sig", "uint32_appid" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, LoginSig.class);
    }
  }
  
  public static final class VisitorCountReq
    extends MessageMicro<VisitorCountReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "requireuin", "operuin", "mod", "reportFlag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, VisitorCountReq.class);
    public final PBInt32Field mod = PBField.initInt32(0);
    public final PBUInt32Field operuin = PBField.initUInt32(0);
    public final PBInt32Field reportFlag = PBField.initInt32(0);
    public final PBUInt32Field requireuin = PBField.initUInt32(0);
  }
  
  public static final class VisitorCountRsp
    extends MessageMicro<VisitorCountRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "requireuin", "totalLike", "totalView", "hotValue", "redValue", "hotDiff" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, VisitorCountRsp.class);
    public final PBUInt32Field hotDiff = PBField.initUInt32(0);
    public final PBUInt32Field hotValue = PBField.initUInt32(0);
    public final PBUInt32Field redValue = PBField.initUInt32(0);
    public final PBUInt32Field requireuin = PBField.initUInt32(0);
    public final PBUInt32Field totalLike = PBField.initUInt32(0);
    public final PBUInt32Field totalView = PBField.initUInt32(0);
  }
  
  public static final class comm
    extends MessageMicro<comm>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field build = PBField.initInt32(0);
    public final PBUInt32Field client_ip = PBField.initUInt32(0);
    public SummaryCardBusiEntry.ui display = new SummaryCardBusiEntry.ui();
    public final PBStringField err_msg = PBField.initString("");
    public final PBUInt64Field fromuin = PBField.initUInt64(0L);
    public SummaryCardBusiEntry.LoginSig msg_login_sig = new SummaryCardBusiEntry.LoginSig();
    public SummaryCardBusiEntry.rich_ui msg_rich_display = new SummaryCardBusiEntry.rich_ui();
    public SummaryCardBusiEntry.uin_info msg_uin_info = new SummaryCardBusiEntry.uin_info();
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBStringField qqver = PBField.initString("");
    public final PBInt32Field result = PBField.initInt32(0);
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBUInt32Field service = PBField.initUInt32(0);
    public final PBBytesField session_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field session_type = PBField.initUInt32(0);
    public final PBUInt64Field touin = PBField.initUInt64(0L);
    public final PBUInt32Field uint32_version = PBField.initUInt32(0);
    public final PBUInt32Field ver = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 64, 74, 80, 90, 96, 106, 112, 122, 136, 146, 154 }, new String[] { "ver", "seq", "fromuin", "touin", "service", "session_type", "session_key", "client_ip", "display", "result", "err_msg", "platform", "qqver", "build", "msg_login_sig", "uint32_version", "msg_uin_info", "msg_rich_display" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), null, Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0), null, Integer.valueOf(0), null, null }, comm.class);
    }
  }
  
  public static final class rich_ui
    extends MessageMicro<rich_ui>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "strName", "strServiceUrl", "rptUiList" }, new Object[] { "", "", null }, rich_ui.class);
    public final PBRepeatMessageField<SummaryCardBusiEntry.ui_info> rptUiList = PBField.initRepeatMessage(SummaryCardBusiEntry.ui_info.class);
    public final PBStringField strName = PBField.initString("");
    public final PBStringField strServiceUrl = PBField.initString("");
  }
  
  public static final class ui
    extends MessageMicro<ui>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "url", "title", "content", "jump_url" }, new Object[] { "", "", "", "" }, ui.class);
    public final PBStringField content = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class ui_info
    extends MessageMicro<ui_info>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64 }, new String[] { "strTitle", "strCoverUrl", "strJmpUrl", "strSubInfo", "strDesc", "strTitleIconUrl", "rptGroupTagList", "uint64_group_code" }, new Object[] { "", "", "", "", "", "", null, Long.valueOf(0L) }, ui_info.class);
    public final PBRepeatMessageField<SummaryCardBusiEntry.Label> rptGroupTagList = PBField.initRepeatMessage(SummaryCardBusiEntry.Label.class);
    public final PBStringField strCoverUrl = PBField.initString("");
    public final PBStringField strDesc = PBField.initString("");
    public final PBStringField strJmpUrl = PBField.initString("");
    public final PBStringField strSubInfo = PBField.initString("");
    public final PBStringField strTitle = PBField.initString("");
    public final PBStringField strTitleIconUrl = PBField.initString("");
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class uin_info
    extends MessageMicro<uin_info>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int64_longitude", "int64_latitude" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, uin_info.class);
    public final PBInt64Field int64_latitude = PBField.initInt64(0L);
    public final PBInt64Field int64_longitude = PBField.initInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.profilecard.SummaryCardBusiEntry
 * JD-Core Version:    0.7.0.1
 */