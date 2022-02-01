package trpc.qq_av_together.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class WTogetherCommon$PlayerParams
  extends MessageMicro<PlayerParams>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "type", "url_params", "txvlive_player_params", "tx_player_params" }, new Object[] { Integer.valueOf(0), null, null, null }, PlayerParams.class);
  public WTogetherCommon.TxPlayerParams tx_player_params = new WTogetherCommon.TxPlayerParams();
  public WTogetherCommon.TxvlivePlayerParams txvlive_player_params = new WTogetherCommon.TxvlivePlayerParams();
  public final PBEnumField type = PBField.initEnum(0);
  public WTogetherCommon.UrlParams url_params = new WTogetherCommon.UrlParams();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_av_together.common.WTogetherCommon.PlayerParams
 * JD-Core Version:    0.7.0.1
 */