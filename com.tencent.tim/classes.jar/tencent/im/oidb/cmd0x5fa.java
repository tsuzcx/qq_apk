package tencent.im.oidb;

import appoint.define.appoint_define.AppointID;
import appoint.define.appoint_define.StrangerInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x5fa
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int RPT_APPOINT_IDS_FIELD_NUMBER = 1;
    public static final int UINT32_GET_REFER_REC_FIELD_NUMBER = 3;
    public static final int UINT32_REFER_IDX_FIELD_NUMBER = 2;
    public static final int UINT32_REQ_NEXT_COUNT_FIELD_NUMBER = 4;
    public static final int UINT32_REQ_PREV_COUNT_FIELD_NUMBER = 5;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40 }, new String[] { "rpt_appoint_ids", "uint32_refer_idx", "uint32_get_refer_rec", "uint32_req_next_count", "uint32_req_prev_count" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public appoint_define.AppointID rpt_appoint_ids = new appoint_define.AppointID();
    public final PBUInt32Field uint32_get_refer_rec = PBField.initUInt32(0);
    public final PBUInt32Field uint32_refer_idx = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_next_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_prev_count = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    public static final int RPT_MSG_STRANGER_INFO_FIELD_NUMBER = 1;
    public static final int UINT32_REACH_END_FIELD_NUMBER = 3;
    public static final int UINT32_REACH_START_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "rpt_msg_stranger_info", "uint32_reach_start", "uint32_reach_end" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
    public final PBRepeatMessageField<appoint_define.StrangerInfo> rpt_msg_stranger_info = PBField.initRepeatMessage(appoint_define.StrangerInfo.class);
    public final PBUInt32Field uint32_reach_end = PBField.initUInt32(0);
    public final PBUInt32Field uint32_reach_start = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5fa
 * JD-Core Version:    0.7.0.1
 */