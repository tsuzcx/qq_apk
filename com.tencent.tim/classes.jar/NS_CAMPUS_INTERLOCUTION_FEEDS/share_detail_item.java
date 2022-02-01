package NS_CAMPUS_INTERLOCUTION_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class share_detail_item
  extends JceStruct
{
  public int action_type;
  public String action_url = "";
  public long answer_num;
  public String content = "";
  public String module_name = "";
  public String nick = "";
  public String optype = "";
  public String pic_url = "";
  public String portrait = "";
  public String school_name = "";
  public String share_content = "";
  public int type;
  public long uin;
  public long user_type;
  public long visit_num;
  
  public share_detail_item() {}
  
  public share_detail_item(int paramInt1, String paramString1, int paramInt2, String paramString2, long paramLong1, String paramString3, String paramString4, String paramString5, long paramLong2, long paramLong3, String paramString6, long paramLong4, String paramString7, String paramString8, String paramString9)
  {
    this.action_type = paramInt1;
    this.action_url = paramString1;
    this.type = paramInt2;
    this.pic_url = paramString2;
    this.uin = paramLong1;
    this.nick = paramString3;
    this.optype = paramString4;
    this.content = paramString5;
    this.visit_num = paramLong2;
    this.answer_num = paramLong3;
    this.portrait = paramString6;
    this.user_type = paramLong4;
    this.school_name = paramString7;
    this.module_name = paramString8;
    this.share_content = paramString9;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.action_type = paramJceInputStream.read(this.action_type, 0, true);
    this.action_url = paramJceInputStream.readString(1, true);
    this.type = paramJceInputStream.read(this.type, 2, true);
    this.pic_url = paramJceInputStream.readString(3, true);
    this.uin = paramJceInputStream.read(this.uin, 10, false);
    this.nick = paramJceInputStream.readString(11, false);
    this.optype = paramJceInputStream.readString(12, false);
    this.content = paramJceInputStream.readString(13, false);
    this.visit_num = paramJceInputStream.read(this.visit_num, 14, false);
    this.answer_num = paramJceInputStream.read(this.answer_num, 15, false);
    this.portrait = paramJceInputStream.readString(16, false);
    this.user_type = paramJceInputStream.read(this.user_type, 17, false);
    this.school_name = paramJceInputStream.readString(20, false);
    this.module_name = paramJceInputStream.readString(21, false);
    this.share_content = paramJceInputStream.readString(30, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.action_type, 0);
    paramJceOutputStream.write(this.action_url, 1);
    paramJceOutputStream.write(this.type, 2);
    paramJceOutputStream.write(this.pic_url, 3);
    paramJceOutputStream.write(this.uin, 10);
    if (this.nick != null) {
      paramJceOutputStream.write(this.nick, 11);
    }
    if (this.optype != null) {
      paramJceOutputStream.write(this.optype, 12);
    }
    if (this.content != null) {
      paramJceOutputStream.write(this.content, 13);
    }
    paramJceOutputStream.write(this.visit_num, 14);
    paramJceOutputStream.write(this.answer_num, 15);
    if (this.portrait != null) {
      paramJceOutputStream.write(this.portrait, 16);
    }
    paramJceOutputStream.write(this.user_type, 17);
    if (this.school_name != null) {
      paramJceOutputStream.write(this.school_name, 20);
    }
    if (this.module_name != null) {
      paramJceOutputStream.write(this.module_name, 21);
    }
    if (this.share_content != null) {
      paramJceOutputStream.write(this.share_content, 30);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_CAMPUS_INTERLOCUTION_FEEDS.share_detail_item
 * JD-Core Version:    0.7.0.1
 */