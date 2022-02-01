package trpc.qq_vgame.game_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.qq_vgame.common.AvGameCommon.Result;

public final class AvGameList$CmdGameListRsp
  extends MessageMicro<CmdGameListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42 }, new String[] { "game_list", "curr_game_index", "resource_url", "resource_md5", "res" }, new Object[] { null, Integer.valueOf(0), "", "", null }, CmdGameListRsp.class);
  public final PBUInt32Field curr_game_index = PBField.initUInt32(0);
  public final PBRepeatMessageField<AvGameList.GameListItemInfo> game_list = PBField.initRepeatMessage(AvGameList.GameListItemInfo.class);
  public AvGameCommon.Result res = new AvGameCommon.Result();
  public final PBStringField resource_md5 = PBField.initString("");
  public final PBStringField resource_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trpc.qq_vgame.game_list.AvGameList.CmdGameListRsp
 * JD-Core Version:    0.7.0.1
 */