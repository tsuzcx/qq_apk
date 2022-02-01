package trpc.qq_av_together.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class WTogetherCommon$VideoInfoRsp
  extends MessageMicro<VideoInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "video_src_type", "title", "qqfile_info", "direct_url_info", "online_resource_info" }, new Object[] { Integer.valueOf(0), "", null, null, null }, VideoInfoRsp.class);
  public WTogetherCommon.DirectUrlInfo direct_url_info = new WTogetherCommon.DirectUrlInfo();
  public WTogetherCommon.OnlineResourceInfo online_resource_info = new WTogetherCommon.OnlineResourceInfo();
  public WTogetherCommon.QQFileInfo qqfile_info = new WTogetherCommon.QQFileInfo();
  public final PBStringField title = PBField.initString("");
  public final PBEnumField video_src_type = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trpc.qq_av_together.common.WTogetherCommon.VideoInfoRsp
 * JD-Core Version:    0.7.0.1
 */