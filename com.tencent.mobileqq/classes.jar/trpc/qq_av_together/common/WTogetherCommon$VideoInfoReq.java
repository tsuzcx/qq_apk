package trpc.qq_av_together.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class WTogetherCommon$VideoInfoReq
  extends MessageMicro<VideoInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "video_src_type", "forward_req", "direct_url_info", "online_resource_id" }, new Object[] { Integer.valueOf(0), null, null, "" }, VideoInfoReq.class);
  public WTogetherCommon.DirectUrlInfo direct_url_info = new WTogetherCommon.DirectUrlInfo();
  public WTogetherCommon.ForwardReq forward_req = new WTogetherCommon.ForwardReq();
  public final PBStringField online_resource_id = PBField.initString("");
  public final PBEnumField video_src_type = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trpc.qq_av_together.common.WTogetherCommon.VideoInfoReq
 * JD-Core Version:    0.7.0.1
 */