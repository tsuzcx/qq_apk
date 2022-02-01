package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class ShopOuterClass$GiftCommonConf
  extends MessageMicro<GiftCommonConf>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field anchor_profit_rate = PBField.initInt32(0);
  public final PBInt32Field banner_click_count_down_time = PBField.initInt32(0);
  public final PBStringField entry_animation_url = PBField.initString("");
  public final PBStringField entry_bubble_new_gift_text = PBField.initString("");
  public final PBStringField entry_bubble_text = PBField.initString("");
  public final PBStringField gift_cd_error_msg = PBField.initString("");
  public final PBStringField gift_profit_text = PBField.initString("");
  public final PBInt32Field is_show_entry_bubble = PBField.initInt32(0);
  public final PBBoolField is_show_entry_red_dot = PBField.initBool(false);
  public final PBBoolField is_show_reserve_pos = PBField.initBool(false);
  public final PBBoolField is_show_tab_red_dot = PBField.initBool(false);
  public ShopOuterClass.GiftNumItemList num_config = new ShopOuterClass.GiftNumItemList();
  public final PBBoolField sound_switch = PBField.initBool(false);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Boolean localBoolean = Boolean.valueOf(false);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58, 66, 74, 82, 88, 96, 106 }, new String[] { "is_show_entry_red_dot", "is_show_tab_red_dot", "is_show_reserve_pos", "anchor_profit_rate", "is_show_entry_bubble", "gift_cd_error_msg", "gift_profit_text", "entry_bubble_text", "num_config", "entry_bubble_new_gift_text", "banner_click_count_down_time", "sound_switch", "entry_animation_url" }, new Object[] { localBoolean, localBoolean, localBoolean, localInteger, localInteger, "", "", "", null, "", localInteger, localBoolean, "" }, GiftCommonConf.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.ShopOuterClass.GiftCommonConf
 * JD-Core Version:    0.7.0.1
 */