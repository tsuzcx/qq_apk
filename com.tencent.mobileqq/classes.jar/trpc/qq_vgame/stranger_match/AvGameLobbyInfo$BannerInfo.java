package trpc.qq_vgame.stranger_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class AvGameLobbyInfo$BannerInfo
  extends MessageMicro<BannerInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "picture_url", "skip_url" }, new Object[] { "", "" }, BannerInfo.class);
  public final PBStringField picture_url = PBField.initString("");
  public final PBStringField skip_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trpc.qq_vgame.stranger_match.AvGameLobbyInfo.BannerInfo
 * JD-Core Version:    0.7.0.1
 */