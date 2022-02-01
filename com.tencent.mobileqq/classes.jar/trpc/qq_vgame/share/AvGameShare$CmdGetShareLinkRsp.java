package trpc.qq_vgame.share;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class AvGameShare$CmdGetShareLinkRsp
  extends MessageMicro<CmdGetShareLinkRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "share_url" }, new Object[] { "" }, CmdGetShareLinkRsp.class);
  public final PBStringField share_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.share.AvGameShare.CmdGetShareLinkRsp
 * JD-Core Version:    0.7.0.1
 */