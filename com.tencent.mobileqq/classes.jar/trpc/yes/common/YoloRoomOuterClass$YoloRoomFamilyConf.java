package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import trpc.yes.wuji.WujiYoloRoomOuterClass.WujiFamilyRoomWidgetsConfList;
import trpc.yes.wuji.WujiYoloRoomOuterClass.WujiYoloFamilyRoomTabConfList;

public final class YoloRoomOuterClass$YoloRoomFamilyConf
  extends MessageMicro<YoloRoomFamilyConf>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "tab_conf_list", "widgets_conf_list" }, new Object[] { null, null }, YoloRoomFamilyConf.class);
  public WujiYoloRoomOuterClass.WujiYoloFamilyRoomTabConfList tab_conf_list = new WujiYoloRoomOuterClass.WujiYoloFamilyRoomTabConfList();
  public final PBRepeatMessageField<WujiYoloRoomOuterClass.WujiFamilyRoomWidgetsConfList> widgets_conf_list = PBField.initRepeatMessage(WujiYoloRoomOuterClass.WujiFamilyRoomWidgetsConfList.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomFamilyConf
 * JD-Core Version:    0.7.0.1
 */