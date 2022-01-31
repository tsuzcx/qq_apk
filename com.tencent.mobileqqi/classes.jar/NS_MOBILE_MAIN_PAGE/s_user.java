package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_user
  extends JceStruct
{
  public String answer = "";
  public int appid = 0;
  public String birthday_time = "";
  public int comm_friend_num = 0;
  public String dateval = "";
  public long fans_num = 0L;
  public String fans_num_express = "";
  public int from = 0;
  public boolean isFamousQzone = true;
  public boolean is_concerned = true;
  public boolean is_lunar = true;
  public boolean is_new_birthday_friend = false;
  public boolean is_new_visitor = true;
  public boolean is_qq_friend = true;
  public boolean is_send = true;
  public String nickname = "";
  public String profile_url = "";
  public String question = "";
  public String reason = "";
  public byte relat_days = 0;
  public String ugc_content_id = "";
  public long uin = 0L;
  public String uinkey = "";
  public String visit_info = "";
  public String visit_info_content = "";
  public String visit_info_prefix = "";
  public byte visit_mod = 0;
  public long vtime = 0L;
  
  public s_user() {}
  
  public s_user(long paramLong1, String paramString1, int paramInt1, long paramLong2, String paramString2, String paramString3, boolean paramBoolean1, int paramInt2, String paramString4, boolean paramBoolean2, String paramString5, String paramString6, String paramString7, boolean paramBoolean3, String paramString8, boolean paramBoolean4, boolean paramBoolean5, long paramLong3, String paramString9, boolean paramBoolean6, byte paramByte1, String paramString10, boolean paramBoolean7, byte paramByte2, int paramInt3, String paramString11, String paramString12, String paramString13)
  {
    this.uin = paramLong1;
    this.nickname = paramString1;
    this.from = paramInt1;
    this.vtime = paramLong2;
    this.uinkey = paramString2;
    this.dateval = paramString3;
    this.is_send = paramBoolean1;
    this.comm_friend_num = paramInt2;
    this.profile_url = paramString4;
    this.is_lunar = paramBoolean2;
    this.birthday_time = paramString5;
    this.question = paramString6;
    this.answer = paramString7;
    this.is_qq_friend = paramBoolean3;
    this.visit_info = paramString8;
    this.is_new_visitor = paramBoolean4;
    this.isFamousQzone = paramBoolean5;
    this.fans_num = paramLong3;
    this.fans_num_express = paramString9;
    this.is_concerned = paramBoolean6;
    this.visit_mod = paramByte1;
    this.reason = paramString10;
    this.is_new_birthday_friend = paramBoolean7;
    this.relat_days = paramByte2;
    this.appid = paramInt3;
    this.ugc_content_id = paramString11;
    this.visit_info_prefix = paramString12;
    this.visit_info_content = paramString13;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.nickname = paramJceInputStream.readString(1, false);
    this.from = paramJceInputStream.read(this.from, 2, false);
    this.vtime = paramJceInputStream.read(this.vtime, 3, false);
    this.uinkey = paramJceInputStream.readString(4, false);
    this.dateval = paramJceInputStream.readString(5, false);
    this.is_send = paramJceInputStream.read(this.is_send, 6, false);
    this.comm_friend_num = paramJceInputStream.read(this.comm_friend_num, 7, false);
    this.profile_url = paramJceInputStream.readString(8, false);
    this.is_lunar = paramJceInputStream.read(this.is_lunar, 9, false);
    this.birthday_time = paramJceInputStream.readString(10, false);
    this.question = paramJceInputStream.readString(11, false);
    this.answer = paramJceInputStream.readString(12, false);
    this.is_qq_friend = paramJceInputStream.read(this.is_qq_friend, 13, false);
    this.visit_info = paramJceInputStream.readString(14, false);
    this.is_new_visitor = paramJceInputStream.read(this.is_new_visitor, 15, false);
    this.isFamousQzone = paramJceInputStream.read(this.isFamousQzone, 16, false);
    this.fans_num = paramJceInputStream.read(this.fans_num, 17, false);
    this.fans_num_express = paramJceInputStream.readString(18, false);
    this.is_concerned = paramJceInputStream.read(this.is_concerned, 19, false);
    this.visit_mod = paramJceInputStream.read(this.visit_mod, 20, false);
    this.reason = paramJceInputStream.readString(21, false);
    this.is_new_birthday_friend = paramJceInputStream.read(this.is_new_birthday_friend, 22, false);
    this.relat_days = paramJceInputStream.read(this.relat_days, 23, false);
    this.appid = paramJceInputStream.read(this.appid, 24, false);
    this.ugc_content_id = paramJceInputStream.readString(25, false);
    this.visit_info_prefix = paramJceInputStream.readString(26, false);
    this.visit_info_content = paramJceInputStream.readString(27, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.nickname != null) {
      paramJceOutputStream.write(this.nickname, 1);
    }
    paramJceOutputStream.write(this.from, 2);
    paramJceOutputStream.write(this.vtime, 3);
    if (this.uinkey != null) {
      paramJceOutputStream.write(this.uinkey, 4);
    }
    if (this.dateval != null) {
      paramJceOutputStream.write(this.dateval, 5);
    }
    paramJceOutputStream.write(this.is_send, 6);
    paramJceOutputStream.write(this.comm_friend_num, 7);
    if (this.profile_url != null) {
      paramJceOutputStream.write(this.profile_url, 8);
    }
    paramJceOutputStream.write(this.is_lunar, 9);
    if (this.birthday_time != null) {
      paramJceOutputStream.write(this.birthday_time, 10);
    }
    if (this.question != null) {
      paramJceOutputStream.write(this.question, 11);
    }
    if (this.answer != null) {
      paramJceOutputStream.write(this.answer, 12);
    }
    paramJceOutputStream.write(this.is_qq_friend, 13);
    if (this.visit_info != null) {
      paramJceOutputStream.write(this.visit_info, 14);
    }
    paramJceOutputStream.write(this.is_new_visitor, 15);
    paramJceOutputStream.write(this.isFamousQzone, 16);
    paramJceOutputStream.write(this.fans_num, 17);
    if (this.fans_num_express != null) {
      paramJceOutputStream.write(this.fans_num_express, 18);
    }
    paramJceOutputStream.write(this.is_concerned, 19);
    paramJceOutputStream.write(this.visit_mod, 20);
    if (this.reason != null) {
      paramJceOutputStream.write(this.reason, 21);
    }
    paramJceOutputStream.write(this.is_new_birthday_friend, 22);
    paramJceOutputStream.write(this.relat_days, 23);
    paramJceOutputStream.write(this.appid, 24);
    if (this.ugc_content_id != null) {
      paramJceOutputStream.write(this.ugc_content_id, 25);
    }
    if (this.visit_info_prefix != null) {
      paramJceOutputStream.write(this.visit_info_prefix, 26);
    }
    if (this.visit_info_content != null) {
      paramJceOutputStream.write(this.visit_info_content, 27);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_user
 * JD-Core Version:    0.7.0.1
 */