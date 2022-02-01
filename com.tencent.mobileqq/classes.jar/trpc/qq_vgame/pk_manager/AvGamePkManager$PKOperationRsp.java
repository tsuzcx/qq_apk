package trpc.qq_vgame.pk_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.qq_vgame.common.AvGameCommon.Result;

public final class AvGamePkManager$PKOperationRsp
  extends MessageMicro<PKOperationRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField answer_tip = PBField.initString("");
  public final PBStringField biz_ad_tip = PBField.initString("");
  public final PBStringField biz_ad_wording = PBField.initString("");
  public final PBStringField biz_titel_pic_url = PBField.initString("");
  public final PBStringField biz_title_pic_idx = PBField.initString("");
  public final PBBoolField close_realtime_report = PBField.initBool(false);
  public final PBUInt32Field curRound = PBField.initUInt32(0);
  public final PBBoolField mav_closed = PBField.initBool(false);
  public final PBUInt32Field pool_id = PBField.initUInt32(0);
  public AvGameCommon.Result res = new AvGameCommon.Result();
  public final PBEnumField scene = PBField.initEnum(0);
  public final PBUInt32Field sponsor_id = PBField.initUInt32(0);
  public final PBUInt32Field start_user_num = PBField.initUInt32(0);
  public final PBUInt32Field wait_res_timeout = PBField.initUInt32(0);
  public final PBStringField waiting_background_url = PBField.initString("");
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50, 58, 66, 74, 82, 88, 96, 104, 112, 122 }, new String[] { "res", "pool_id", "start_user_num", "scene", "mav_closed", "biz_title_pic_idx", "biz_titel_pic_url", "biz_ad_wording", "biz_ad_tip", "answer_tip", "sponsor_id", "curRound", "close_realtime_report", "wait_res_timeout", "waiting_background_url" }, new Object[] { null, localInteger, localInteger, localInteger, localBoolean, "", "", "", "", "", localInteger, localInteger, localBoolean, localInteger, "" }, PKOperationRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.pk_manager.AvGamePkManager.PKOperationRsp
 * JD-Core Version:    0.7.0.1
 */