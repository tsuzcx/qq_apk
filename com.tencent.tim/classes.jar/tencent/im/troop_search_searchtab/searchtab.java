package tencent.im.troop_search_searchtab;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.group.group_label.GroupLabel.Label;
import tencent.im.troop_search_userinfo.userinfo.UserInfo;

public final class searchtab
{
  public static final class Card
    extends MessageMicro<Card>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58 }, new String[] { "type", "title_bar", "rpt_item1", "rpt_item2", "rpt_item3", "str_transfer_desc", "str_transfer_url" }, new Object[] { Integer.valueOf(1), null, null, null, null, "", "" }, Card.class);
    public final PBRepeatMessageField<searchtab.Item1> rpt_item1 = PBField.initRepeatMessage(searchtab.Item1.class);
    public final PBRepeatMessageField<searchtab.Item2> rpt_item2 = PBField.initRepeatMessage(searchtab.Item2.class);
    public final PBRepeatMessageField<searchtab.Item3> rpt_item3 = PBField.initRepeatMessage(searchtab.Item3.class);
    public final PBStringField str_transfer_desc = PBField.initString("");
    public final PBStringField str_transfer_url = PBField.initString("");
    public searchtab.TitleBar title_bar = new searchtab.TitleBar();
    public final PBEnumField type = PBField.initEnum(1);
  }
  
  public static final class Item1
    extends MessageMicro<Item1>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_algorithm = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_group_finger_memo = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<GroupLabel.Label> rpt_msg_group_label = PBField.initRepeatMessage(GroupLabel.Label.class);
    public final PBStringField str_img_url = PBField.initString("");
    public final PBStringField str_loc = PBField.initString("");
    public final PBStringField str_name = PBField.initString("");
    public final PBStringField str_oper_desc = PBField.initString("");
    public final PBStringField str_oper_transfer_url = PBField.initString("");
    public final PBStringField str_transfer_url = PBField.initString("");
    public final PBUInt32Field uint32_mem_cnt = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 58, 66, 74, 82, 90 }, new String[] { "uint64_group_code", "str_name", "str_img_url", "str_loc", "uint32_mem_cnt", "str_oper_desc", "str_oper_transfer_url", "str_transfer_url", "rpt_msg_group_label", "bytes_group_finger_memo", "bytes_algorithm" }, new Object[] { Long.valueOf(0L), "", "", "", Integer.valueOf(0), "", "", "", null, localByteStringMicro1, localByteStringMicro2 }, Item1.class);
    }
  }
  
  public static final class Item2
    extends MessageMicro<Item2>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "str_name", "str_img_url", "str_desc", "str_transfer_url" }, new Object[] { "", "", "", "" }, Item2.class);
    public final PBStringField str_desc = PBField.initString("");
    public final PBStringField str_img_url = PBField.initString("");
    public final PBStringField str_name = PBField.initString("");
    public final PBStringField str_transfer_url = PBField.initString("");
  }
  
  public static final class Item3
    extends MessageMicro<Item3>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "str_name", "str_img_url", "str_desc1", "str_desc2", "str_transfer_url" }, new Object[] { "", "", "", "", "" }, Item3.class);
    public final PBStringField str_desc1 = PBField.initString("");
    public final PBStringField str_desc2 = PBField.initString("");
    public final PBStringField str_img_url = PBField.initString("");
    public final PBStringField str_name = PBField.initString("");
    public final PBStringField str_transfer_url = PBField.initString("");
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "user_info", "uint32_label_style" }, new Object[] { null, Integer.valueOf(0) }, ReqBody.class);
    public final PBUInt32Field uint32_label_style = PBField.initUInt32(0);
    public userinfo.UserInfo user_info = new userinfo.UserInfo();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "rpt_card", "uint32_latitude", "uint32_longitude", "str_city_id" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), "" }, RspBody.class);
    public final PBRepeatMessageField<searchtab.Card> rpt_card = PBField.initRepeatMessage(searchtab.Card.class);
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
 * Qualified Name:     tencent.im.troop_search_searchtab.searchtab
 * JD-Core Version:    0.7.0.1
 */