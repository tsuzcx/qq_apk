package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class fd_aio_msgs
{
  public static final class GrabFDGrayMsg
    extends MessageMicro<GrabFDGrayMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42 }, new String[] { "host_uin", "grab_uin", "fdid", "msg_type", "high_light_des" }, new Object[] { null, null, "", Integer.valueOf(1), null }, GrabFDGrayMsg.class);
    public final PBStringField fdid = PBField.initString("");
    public fd_comm.UinProf grab_uin = new fd_comm.UinProf();
    public fd_comm.TxtAndUrl high_light_des = new fd_comm.TxtAndUrl();
    public fd_comm.UinProf host_uin = new fd_comm.UinProf();
    public final PBEnumField msg_type = PBField.initEnum(1);
  }
  
  public static final class ShareFDAioMsg
    extends MessageMicro<ShareFDAioMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 90, 96, 104, 170, 178 }, new String[] { "host_uin", "fdid", "share_meta", "expire_time", "fd_txt", "busi_id", "theme_id", "aio_tails", "high_light_msg" }, new Object[] { Long.valueOf(0L), "", null, Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), "", "" }, ShareFDAioMsg.class);
    public final PBStringField aio_tails = PBField.initString("");
    public final PBUInt32Field busi_id = PBField.initUInt32(0);
    public final PBUInt32Field expire_time = PBField.initUInt32(0);
    public final PBStringField fd_txt = PBField.initString("");
    public final PBStringField fdid = PBField.initString("");
    public final PBStringField high_light_msg = PBField.initString("");
    public final PBUInt64Field host_uin = PBField.initUInt64(0L);
    public fd_comm.FDShareMeta share_meta = new fd_comm.FDShareMeta();
    public final PBUInt32Field theme_id = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     fudai.fd_aio_msgs
 * JD-Core Version:    0.7.0.1
 */