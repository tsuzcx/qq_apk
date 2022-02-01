package tencent.im.s2c.msgtype0x211.submsgtype0x9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class C2CType0x211_SubC2CType0x9
{
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    public static final int CMD_Enum_Printer = 1;
    public static final int CMD_Enum_Printer_Result = 2;
    public static final int CMD_GET_PRINTER_STATE = 5;
    public static final int CMD_GET_PRINTER_STATE_RESULT = 6;
    public static final int CMD_None = 0;
    public static final int CMD_Print_Result = 3;
    public static final int CMD_RESTRY = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "str_service", "uint32_CMD", "msg_printer" }, new Object[] { "", Integer.valueOf(0), null }, MsgBody.class);
    public MsgPrinter msg_printer = new MsgPrinter();
    public final PBStringField str_service = PBField.initString("");
    public final PBUInt32Field uint32_CMD = PBField.initUInt32(0);
    
    public static final class HPPrinterStateInfo
      extends MessageMicro<HPPrinterStateInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint64_printer_din", "str_printer_qr_pic_url", "str_printer_qr_open_url", "str_printer_tip_url" }, new Object[] { Long.valueOf(0L), "", "", "" }, HPPrinterStateInfo.class);
      public final PBStringField str_printer_qr_open_url = PBField.initString("");
      public final PBStringField str_printer_qr_pic_url = PBField.initString("");
      public final PBStringField str_printer_tip_url = PBField.initString("");
      public final PBUInt64Field uint64_printer_din = PBField.initUInt64(0L);
    }
    
    public static final class MsgPrinter
      extends MessageMicro<MsgPrinter>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 50, 58 }, new String[] { "rpt_string_printer", "uint64_print_session_id", "uint32_print_result", "str_result_msg", "rpt_uint64_session_id", "rpt_msg_support_file_info", "hp_printer_state_info" }, new Object[] { "", Long.valueOf(0L), Integer.valueOf(0), "", Long.valueOf(0L), null, null }, MsgPrinter.class);
      public C2CType0x211_SubC2CType0x9.MsgBody.HPPrinterStateInfo hp_printer_state_info = new C2CType0x211_SubC2CType0x9.MsgBody.HPPrinterStateInfo();
      public final PBRepeatMessageField<C2CType0x211_SubC2CType0x9.MsgBody.SupportFileInfo> rpt_msg_support_file_info = PBField.initRepeatMessage(C2CType0x211_SubC2CType0x9.MsgBody.SupportFileInfo.class);
      public final PBRepeatField<String> rpt_string_printer = PBField.initRepeat(PBStringField.__repeatHelper__);
      public final PBRepeatField<Long> rpt_uint64_session_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
      public final PBStringField str_result_msg = PBField.initString("");
      public final PBUInt32Field uint32_print_result = PBField.initUInt32(0);
      public final PBUInt64Field uint64_print_session_id = PBField.initUInt64(0L);
    }
    
    public static final class SupportFileInfo
      extends MessageMicro<SupportFileInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "str_file_suffix", "uint32_copies", "uint32_duplex" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0) }, SupportFileInfo.class);
      public final PBStringField str_file_suffix = PBField.initString("");
      public final PBUInt32Field uint32_copies = PBField.initUInt32(0);
      public final PBUInt32Field uint32_duplex = PBField.initUInt32(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x9.C2CType0x211_SubC2CType0x9
 * JD-Core Version:    0.7.0.1
 */