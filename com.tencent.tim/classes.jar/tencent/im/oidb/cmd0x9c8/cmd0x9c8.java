package tencent.im.oidb.cmd0x9c8;

import appoint.define.appoint_define.InterestItem;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x9c8
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int STR_KEYWORD_FIELD_NUMBER = 1;
    public static final int UINT32_FETCH_COUNT_FIELD_NUMBER = 4;
    public static final int UINT32_FETCH_START_FIELD_NUMBER = 3;
    public static final int UINT32_MATCH_OP_FIELD_NUMBER = 5;
    public static final int UINT32_PERSONAL_INFO_FLAG_FIELD_NUMBER = 6;
    public static final int UINT32_TAG_TYPE_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48 }, new String[] { "str_keyword", "uint32_tag_type", "uint32_fetch_start", "uint32_fetch_count", "uint32_match_op", "uint32_personal_info_flag" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public final PBStringField str_keyword = PBField.initString("");
    public final PBUInt32Field uint32_fetch_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_fetch_start = PBField.initUInt32(0);
    public final PBUInt32Field uint32_match_op = PBField.initUInt32(0);
    public final PBUInt32Field uint32_personal_info_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_tag_type = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    public static final int RPT_MSG_SEL_LIST_FIELD_NUMBER = 4;
    public static final int RPT_MSG_TAG_LIST_FIELD_NUMBER = 2;
    public static final int STR_ERROR_FIELD_NUMBER = 5;
    public static final int UINT32_NEXT_POS_FIELD_NUMBER = 3;
    public static final int UINT32_TAG_TYPE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42 }, new String[] { "uint32_tag_type", "rpt_msg_tag_list", "uint32_next_pos", "rpt_msg_sel_list", "str_error" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0), null, "" }, RspBody.class);
    public final PBRepeatMessageField<appoint_define.InterestItem> rpt_msg_sel_list = PBField.initRepeatMessage(appoint_define.InterestItem.class);
    public final PBRepeatMessageField<appoint_define.InterestItem> rpt_msg_tag_list = PBField.initRepeatMessage(appoint_define.InterestItem.class);
    public final PBStringField str_error = PBField.initString("");
    public final PBUInt32Field uint32_next_pos = PBField.initUInt32(0);
    public final PBUInt32Field uint32_tag_type = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9c8.cmd0x9c8
 * JD-Core Version:    0.7.0.1
 */