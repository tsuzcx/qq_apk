package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_reply
  extends JceStruct
{
  static s_audio cache_audio;
  static s_user cache_target;
  static s_user cache_user;
  public s_audio audio = null;
  public String content = "";
  public int date = 0;
  public String refer = "";
  public String replyid = "";
  public s_user target = null;
  public s_user user = null;
  
  public s_reply() {}
  
  public s_reply(String paramString1, s_user params_user1, String paramString2, int paramInt, String paramString3, s_audio params_audio, s_user params_user2)
  {
    this.replyid = paramString1;
    this.user = params_user1;
    this.content = paramString2;
    this.date = paramInt;
    this.refer = paramString3;
    this.audio = params_audio;
    this.target = params_user2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.replyid = paramJceInputStream.readString(0, false);
    if (cache_user == null) {
      cache_user = new s_user();
    }
    this.user = ((s_user)paramJceInputStream.read(cache_user, 1, false));
    this.content = paramJceInputStream.readString(2, false);
    this.date = paramJceInputStream.read(this.date, 3, false);
    this.refer = paramJceInputStream.readString(4, false);
    if (cache_audio == null) {
      cache_audio = new s_audio();
    }
    this.audio = ((s_audio)paramJceInputStream.read(cache_audio, 5, false));
    if (cache_target == null) {
      cache_target = new s_user();
    }
    this.target = ((s_user)paramJceInputStream.read(cache_target, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.replyid != null) {
      paramJceOutputStream.write(this.replyid, 0);
    }
    if (this.user != null) {
      paramJceOutputStream.write(this.user, 1);
    }
    if (this.content != null) {
      paramJceOutputStream.write(this.content, 2);
    }
    paramJceOutputStream.write(this.date, 3);
    if (this.refer != null) {
      paramJceOutputStream.write(this.refer, 4);
    }
    if (this.audio != null) {
      paramJceOutputStream.write(this.audio, 5);
    }
    if (this.target != null) {
      paramJceOutputStream.write(this.target, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_reply
 * JD-Core Version:    0.7.0.1
 */