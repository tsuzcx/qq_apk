package tencent.im.oidb.cmd0x77f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x77f
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_listtype", "rpt_msg_visit_prof_rec", "uint32_list_ruleid" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0) }, ReqBody.class);
    public final PBRepeatMessageField<cmd0x77f.VisitProfRec> rpt_msg_visit_prof_rec = PBField.initRepeatMessage(cmd0x77f.VisitProfRec.class);
    public final PBUInt32Field uint32_list_ruleid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_listtype = PBField.initUInt32(0);
  }
  
  public static final class VisitProfRec
    extends MessageMicro<VisitProfRec>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "uint64_tinyid", "uint32_seq", "uint32_enter_count", "uint32_visit_duration", "uint32_visit_pic_count", "uint32_opflag" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, VisitProfRec.class);
    public final PBUInt32Field uint32_enter_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_opflag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_visit_duration = PBField.initUInt32(0);
    public final PBUInt32Field uint32_visit_pic_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x77f.cmd0x77f
 * JD-Core Version:    0.7.0.1
 */