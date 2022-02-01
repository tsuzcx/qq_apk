package trpc.qq_av_together.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import trpc.qq_av_together.common.WTogetherCommon.VideoInfoReq;

public final class WTogetherRoomMng$CmdChangeVideoFileReq
  extends MessageMicro<CmdChangeVideoFileReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field client_type = PBField.initUInt32(0);
  public final PBEnumField from = PBField.initEnum(0);
  public final PBUInt64Field room_id = PBField.initUInt64(0L);
  public final PBUInt64Field seq = PBField.initUInt64(0L);
  public WTogetherCommon.VideoInfoReq video_info_req = new WTogetherCommon.VideoInfoReq();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40 }, new String[] { "from", "seq", "room_id", "video_info_req", "client_type" }, new Object[] { localInteger, localLong, localLong, null, localInteger }, CmdChangeVideoFileReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdChangeVideoFileReq
 * JD-Core Version:    0.7.0.1
 */