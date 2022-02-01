package tencent.im.oidb;

import appoint.define.appoint_define.DateComment;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x5fd
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int MSG_COMMENT_FIELD_NUMBER = 1;
    public static final int STR_LAST_COMMENT_ID_FIELD_NUMBER = 3;
    public static final int UINT32_MAX_FETCH_COUNT_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "msg_comment", "uint32_max_fetch_count", "str_last_comment_id" }, new Object[] { null, Integer.valueOf(0), "" }, ReqBody.class);
    public appoint_define.DateComment msg_comment = new appoint_define.DateComment();
    public final PBStringField str_last_comment_id = PBField.initString("");
    public final PBUInt32Field uint32_max_fetch_count = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    public static final int MSG_COMMENT_FIELD_NUMBER = 1;
    public static final int STR_COMMENT_WORDING_FIELD_NUMBER = 4;
    public static final int STR_ERROR_TIPS_FIELD_NUMBER = 2;
    public static final int UINT32_CLEAR_CACHE_FLAG_FIELD_NUMBER = 3;
    public static final int UINT32_COMMENT_NUM_FIELD_NUMBER = 5;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40 }, new String[] { "msg_comment", "str_error_tips", "uint32_clear_cache_flag", "str_comment_wording", "uint32_comment_num" }, new Object[] { null, "", Integer.valueOf(0), "", Integer.valueOf(0) }, RspBody.class);
    public final PBRepeatMessageField<appoint_define.DateComment> msg_comment = PBField.initRepeatMessage(appoint_define.DateComment.class);
    public final PBStringField str_comment_wording = PBField.initString("");
    public final PBStringField str_error_tips = PBField.initString("");
    public final PBUInt32Field uint32_clear_cache_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_comment_num = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5fd
 * JD-Core Version:    0.7.0.1
 */