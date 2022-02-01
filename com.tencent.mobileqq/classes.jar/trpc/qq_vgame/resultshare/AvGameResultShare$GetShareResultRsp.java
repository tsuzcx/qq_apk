package trpc.qq_vgame.resultshare;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AvGameResultShare$GetShareResultRsp
  extends MessageMicro<GetShareResultRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "err_code", "err_msg", "cover_url", "video_url", "ranking_list" }, new Object[] { Integer.valueOf(0), "", "", "", null }, GetShareResultRsp.class);
  public final PBStringField cover_url = PBField.initString("");
  public final PBUInt32Field err_code = PBField.initUInt32(0);
  public final PBStringField err_msg = PBField.initString("");
  public final PBRepeatMessageField<AvGameResultShare.UserScoreInfo> ranking_list = PBField.initRepeatMessage(AvGameResultShare.UserScoreInfo.class);
  public final PBStringField video_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trpc.qq_vgame.resultshare.AvGameResultShare.GetShareResultRsp
 * JD-Core Version:    0.7.0.1
 */