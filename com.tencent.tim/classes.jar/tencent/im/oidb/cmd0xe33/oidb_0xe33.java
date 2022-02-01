package tencent.im.oidb.cmd0xe33;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.kandian.ugc.topic_info.TopicInfo;

public final class oidb_0xe33
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "topic_info_set_req" }, new Object[] { null }, ReqBody.class);
    public oidb_0xe33.TopicInfoSetReq topic_info_set_req = new oidb_0xe33.TopicInfoSetReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "topic_info_set_rsp" }, new Object[] { null }, RspBody.class);
    public oidb_0xe33.TopicInfoSetRsp topic_info_set_rsp = new oidb_0xe33.TopicInfoSetRsp();
  }
  
  public static final class TopicInfoSetReq
    extends MessageMicro<TopicInfoSetReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "info", "operate_type" }, new Object[] { null, Integer.valueOf(0) }, TopicInfoSetReq.class);
    public topic_info.TopicInfo info = new topic_info.TopicInfo();
    public final PBUInt32Field operate_type = PBField.initUInt32(0);
  }
  
  public static final class TopicInfoSetRsp
    extends MessageMicro<TopicInfoSetRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "topic_id", "ret_code", "err_msg" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "" }, TopicInfoSetRsp.class);
    public final PBStringField err_msg = PBField.initString("");
    public final PBEnumField ret_code = PBField.initEnum(0);
    public final PBUInt32Field topic_id = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe33.oidb_0xe33
 * JD-Core Version:    0.7.0.1
 */