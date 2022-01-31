package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x346$ApplyListDownloadRsp
  extends MessageMicro
{
  public static final int INT32_RET_CODE_FIELD_NUMBER = 10;
  public static final int RPT_MSG_FILE_LIST_FIELD_NUMBER = 70;
  public static final int STR_RET_MSG_FIELD_NUMBER = 20;
  public static final int UINT32_BEGIN_INDEX_FIELD_NUMBER = 40;
  public static final int UINT32_IS_END_FIELD_NUMBER = 60;
  public static final int UINT32_RSP_COUNT_FIELD_NUMBER = 50;
  public static final int UINT32_TOTAL_COUNT_FIELD_NUMBER = 30;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 240, 320, 400, 480, 562 }, new String[] { "int32_ret_code", "str_ret_msg", "uint32_total_count", "uint32_begin_index", "uint32_rsp_count", "uint32_is_end", "rpt_msg_file_list" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, ApplyListDownloadRsp.class);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public final PBRepeatMessageField rpt_msg_file_list = PBField.initRepeatMessage(cmd0x346.FileInfo.class);
  public final PBStringField str_ret_msg = PBField.initString("");
  public final PBUInt32Field uint32_begin_index = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
  public final PBUInt32Field uint32_rsp_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total_count = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x346.cmd0x346.ApplyListDownloadRsp
 * JD-Core Version:    0.7.0.1
 */