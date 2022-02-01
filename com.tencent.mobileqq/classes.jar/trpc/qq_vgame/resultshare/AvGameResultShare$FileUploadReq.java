package trpc.qq_vgame.resultshare;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameResultShare$FileUploadReq
  extends MessageMicro<FileUploadReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "uin", "play_game_id", "file_type", "file_url" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), "" }, FileUploadReq.class);
  public final PBEnumField file_type = PBField.initEnum(0);
  public final PBStringField file_url = PBField.initString("");
  public final PBStringField play_game_id = PBField.initString("");
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.resultshare.AvGameResultShare.FileUploadReq
 * JD-Core Version:    0.7.0.1
 */