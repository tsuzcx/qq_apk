package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class s_commment
  extends JceStruct
{
  static s_audio cache_audio;
  static ArrayList cache_commentpic;
  static ArrayList cache_picdata;
  static ArrayList cache_replys;
  static s_user cache_user;
  public s_audio audio = null;
  public String commentid = "";
  public ArrayList commentpic = null;
  public String content = "";
  public int date = 0;
  public ArrayList picdata = null;
  public String refer = "";
  public int replynum = 0;
  public ArrayList replys = null;
  public s_user user = null;
  
  public s_commment() {}
  
  public s_commment(String paramString1, s_user params_user, String paramString2, int paramInt1, String paramString3, ArrayList paramArrayList1, int paramInt2, ArrayList paramArrayList2, s_audio params_audio, ArrayList paramArrayList3)
  {
    this.commentid = paramString1;
    this.user = params_user;
    this.content = paramString2;
    this.date = paramInt1;
    this.refer = paramString3;
    this.replys = paramArrayList1;
    this.replynum = paramInt2;
    this.picdata = paramArrayList2;
    this.audio = params_audio;
    this.commentpic = paramArrayList3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.commentid = paramJceInputStream.readString(0, false);
    if (cache_user == null) {
      cache_user = new s_user();
    }
    this.user = ((s_user)paramJceInputStream.read(cache_user, 1, false));
    this.content = paramJceInputStream.readString(2, false);
    this.date = paramJceInputStream.read(this.date, 3, false);
    this.refer = paramJceInputStream.readString(4, false);
    Object localObject;
    if (cache_replys == null)
    {
      cache_replys = new ArrayList();
      localObject = new s_reply();
      cache_replys.add(localObject);
    }
    this.replys = ((ArrayList)paramJceInputStream.read(cache_replys, 5, false));
    this.replynum = paramJceInputStream.read(this.replynum, 6, false);
    if (cache_picdata == null)
    {
      cache_picdata = new ArrayList();
      localObject = new s_picdata();
      cache_picdata.add(localObject);
    }
    this.picdata = ((ArrayList)paramJceInputStream.read(cache_picdata, 7, false));
    if (cache_audio == null) {
      cache_audio = new s_audio();
    }
    this.audio = ((s_audio)paramJceInputStream.read(cache_audio, 8, false));
    if (cache_commentpic == null)
    {
      cache_commentpic = new ArrayList();
      localObject = new s_picdata();
      cache_commentpic.add(localObject);
    }
    this.commentpic = ((ArrayList)paramJceInputStream.read(cache_commentpic, 9, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.commentid != null) {
      paramJceOutputStream.write(this.commentid, 0);
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
    if (this.replys != null) {
      paramJceOutputStream.write(this.replys, 5);
    }
    paramJceOutputStream.write(this.replynum, 6);
    if (this.picdata != null) {
      paramJceOutputStream.write(this.picdata, 7);
    }
    if (this.audio != null) {
      paramJceOutputStream.write(this.audio, 8);
    }
    if (this.commentpic != null) {
      paramJceOutputStream.write(this.commentpic, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_commment
 * JD-Core Version:    0.7.0.1
 */