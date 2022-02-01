package tencent.im.oidb.cmd0x59f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x59f
{
  public static final class BindContactInfo
    extends MessageMicro<BindContactInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "str_mobile", "str_nation_code", "uint32_bind_time", "bool_inactive", "uint32_bind_type" }, new Object[] { "", "", Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0) }, BindContactInfo.class);
    public final PBBoolField bool_inactive = PBField.initBool(false);
    public final PBStringField str_mobile = PBField.initString("");
    public final PBStringField str_nation_code = PBField.initString("");
    public final PBUInt32Field uint32_bind_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bind_type = PBField.initUInt32(0);
  }
  
  public static final class Guidelines_808
    extends MessageMicro<Guidelines_808>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_welcomepage_flag", "msg_guidelines_web" }, new Object[] { Integer.valueOf(0), null }, Guidelines_808.class);
    public oidb_0x59f.Guidelines_808_web msg_guidelines_web = new oidb_0x59f.Guidelines_808_web();
    public final PBUInt32Field uint32_welcomepage_flag = PBField.initUInt32(0);
  }
  
  public static final class Guidelines_808_web
    extends MessageMicro<Guidelines_808_web>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_friends_recomm_flag", "uint32_groups_recomm_flag", "str_web_url" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "" }, Guidelines_808_web.class);
    public final PBStringField str_web_url = PBField.initString("");
    public final PBUInt32Field uint32_friends_recomm_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_groups_recomm_flag = PBField.initUInt32(0);
  }
  
  public static final class Guidelines_common
    extends MessageMicro<Guidelines_common>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_welcomepage_flag", "msg_guidelines_web" }, new Object[] { Integer.valueOf(0), null }, Guidelines_common.class);
    public oidb_0x59f.Guidelines_common_web msg_guidelines_web = new oidb_0x59f.Guidelines_common_web();
    public final PBUInt32Field uint32_welcomepage_flag = PBField.initUInt32(0);
  }
  
  public static final class Guidelines_common_web
    extends MessageMicro<Guidelines_common_web>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56, 64 }, new String[] { "str_web_url", "uint32_groups_recomm_flag", "uint32_set_gender", "uint32_set_birthday", "uint32_set_head", "uint32_set_school", "uint32_set_region", "uint32_set_company" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Guidelines_common_web.class);
    public final PBStringField str_web_url = PBField.initString("");
    public final PBUInt32Field uint32_groups_recomm_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_set_birthday = PBField.initUInt32(0);
    public final PBUInt32Field uint32_set_company = PBField.initUInt32(0);
    public final PBUInt32Field uint32_set_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_set_head = PBField.initUInt32(0);
    public final PBUInt32Field uint32_set_region = PBField.initUInt32(0);
    public final PBUInt32Field uint32_set_school = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ReqBody.class);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 88, 96, 106, 112, 122, 130, 138, 144, 154, 162, 168, 178, 800 }, new String[] { "uint32_is_first_login", "uint32_default_jump", "uint32_is_first_mqq_login", "uint32_is_first_pc_login", "uint32_mqq_first_login", "uint32_pc_first_login", "msg_welcome_page", "uint32_reg_time", "msg_contact_bind_info", "str_account_mobile", "str_reg_mobile", "uint32_gray_flag", "str_guide_url", "msg_guidelines808", "uint32_addrlist_entrance_flag", "msg_guidelines813", "uint32_need_not_req_nexttime" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), null, "", "", Integer.valueOf(0), "", null, Integer.valueOf(0), null, Integer.valueOf(0) }, RspBody.class);
    public oidb_0x59f.BindContactInfo msg_contact_bind_info = new oidb_0x59f.BindContactInfo();
    public oidb_0x59f.Guidelines_808 msg_guidelines808 = new oidb_0x59f.Guidelines_808();
    public oidb_0x59f.Guidelines_common msg_guidelines813 = new oidb_0x59f.Guidelines_common();
    public oidb_0x59f.WelcomePage msg_welcome_page = new oidb_0x59f.WelcomePage();
    public final PBStringField str_account_mobile = PBField.initString("");
    public final PBStringField str_guide_url = PBField.initString("");
    public final PBStringField str_reg_mobile = PBField.initString("");
    public final PBUInt32Field uint32_addrlist_entrance_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_default_jump = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gray_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_first_login = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_first_mqq_login = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_first_pc_login = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mqq_first_login = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_not_req_nexttime = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pc_first_login = PBField.initUInt32(0);
    public final PBUInt32Field uint32_reg_time = PBField.initUInt32(0);
  }
  
  public static final class WelcomeMenu
    extends MessageMicro<WelcomeMenu>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 88, 98, 106, 114 }, new String[] { "uint32_id", "str_icon_url", "str_wording", "str_target_url" }, new Object[] { Integer.valueOf(0), "", "", "" }, WelcomeMenu.class);
    public final PBStringField str_icon_url = PBField.initString("");
    public final PBStringField str_target_url = PBField.initString("");
    public final PBStringField str_wording = PBField.initString("");
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
  }
  
  public static final class WelcomePage
    extends MessageMicro<WelcomePage>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 98, 106, 242 }, new String[] { "str_big_photo_url", "str_big_photo_wording", "str_welcome_msg", "rpt_menu_list" }, new Object[] { "", "", "", null }, WelcomePage.class);
    public final PBRepeatMessageField<oidb_0x59f.WelcomeMenu> rpt_menu_list = PBField.initRepeatMessage(oidb_0x59f.WelcomeMenu.class);
    public final PBStringField str_big_photo_url = PBField.initString("");
    public final PBStringField str_big_photo_wording = PBField.initString("");
    public final PBStringField str_welcome_msg = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x59f.oidb_0x59f
 * JD-Core Version:    0.7.0.1
 */