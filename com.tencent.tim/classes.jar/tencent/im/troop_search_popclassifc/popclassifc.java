package tencent.im.troop_search_popclassifc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.troop_search_userinfo.userinfo.UserInfo;

public final class popclassifc
{
  public static final class BannerCard
    extends MessageMicro<BannerCard>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rpt_banner_items", "uint32_slid_interval" }, new Object[] { null, Integer.valueOf(0) }, BannerCard.class);
    public final PBRepeatMessageField<popclassifc.BannerItem> rpt_banner_items = PBField.initRepeatMessage(popclassifc.BannerItem.class);
    public final PBUInt32Field uint32_slid_interval = PBField.initUInt32(0);
  }
  
  public static final class BannerItem
    extends MessageMicro<BannerItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_pic_url", "str_transfer_url" }, new Object[] { "", "" }, BannerItem.class);
    public final PBStringField str_pic_url = PBField.initString("");
    public final PBStringField str_transfer_url = PBField.initString("");
  }
  
  public static final class HotWordItem
    extends MessageMicro<HotWordItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_hot_word", "str_text_color" }, new Object[] { "", "" }, HotWordItem.class);
    public final PBStringField str_hot_word = PBField.initString("");
    public final PBStringField str_text_color = PBField.initString("");
  }
  
  public static final class PopCard
    extends MessageMicro<PopCard>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "title_bar", "rpt_pop_items" }, new Object[] { null, null }, PopCard.class);
    public final PBRepeatMessageField<popclassifc.PopItem> rpt_pop_items = PBField.initRepeatMessage(popclassifc.PopItem.class);
    public popclassifc.TitleBar title_bar = new popclassifc.TitleBar();
  }
  
  public static final class PopHotWordCard
    extends MessageMicro<PopHotWordCard>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "title_bar", "rpt_pop_items" }, new Object[] { null, null }, PopHotWordCard.class);
    public final PBRepeatMessageField<popclassifc.HotWordItem> rpt_pop_items = PBField.initRepeatMessage(popclassifc.HotWordItem.class);
    public popclassifc.TitleBar title_bar = new popclassifc.TitleBar();
  }
  
  public static final class PopItem
    extends MessageMicro<PopItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "str_desc", "str_icon_url", "str_transfer_url" }, new Object[] { "", "", "" }, PopItem.class);
    public final PBStringField str_desc = PBField.initString("");
    public final PBStringField str_icon_url = PBField.initString("");
    public final PBStringField str_transfer_url = PBField.initString("");
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "user_info" }, new Object[] { null }, ReqBody.class);
    public userinfo.UserInfo user_info = new userinfo.UserInfo();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 50 }, new String[] { "banner_card", "pop_card", "uint32_latitude", "uint32_longitude", "str_city_id", "pop_hotword" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), "", null }, RspBody.class);
    public popclassifc.BannerCard banner_card = new popclassifc.BannerCard();
    public popclassifc.PopCard pop_card = new popclassifc.PopCard();
    public popclassifc.PopHotWordCard pop_hotword = new popclassifc.PopHotWordCard();
    public final PBStringField str_city_id = PBField.initString("");
    public final PBUInt32Field uint32_latitude = PBField.initUInt32(0);
    public final PBUInt32Field uint32_longitude = PBField.initUInt32(0);
  }
  
  public static final class TitleBar
    extends MessageMicro<TitleBar>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_icon_url", "str_desc" }, new Object[] { "", "" }, TitleBar.class);
    public final PBStringField str_desc = PBField.initString("");
    public final PBStringField str_icon_url = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.troop_search_popclassifc.popclassifc
 * JD-Core Version:    0.7.0.1
 */