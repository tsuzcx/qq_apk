package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class s_reply
  extends JceStruct
{
  static s_audio cache_audio;
  static Map<String, String> cache_extendInfo;
  static ArrayList<s_likeman> cache_likemans;
  static ArrayList<s_picdata> cache_replypic;
  static s_user cache_target;
  static s_user cache_user = new s_user();
  public s_audio audio;
  public String content = "";
  public int date;
  public int displayflag;
  public Map<String, String> extendInfo;
  public boolean isDeleted;
  public int isliked;
  public int likeNum;
  public ArrayList<s_likeman> likemans;
  public String refer = "";
  public String replyLikeKey = "";
  public String replyid = "";
  public ArrayList<s_picdata> replypic;
  public s_user target;
  public s_user user;
  
  static
  {
    cache_audio = new s_audio();
    cache_target = new s_user();
    cache_replypic = new ArrayList();
    Object localObject = new s_picdata();
    cache_replypic.add(localObject);
    cache_extendInfo = new HashMap();
    cache_extendInfo.put("", "");
    cache_likemans = new ArrayList();
    localObject = new s_likeman();
    cache_likemans.add(localObject);
  }
  
  public s_reply() {}
  
  public s_reply(String paramString1, s_user params_user1, String paramString2, int paramInt1, String paramString3, s_audio params_audio, s_user params_user2, ArrayList<s_picdata> paramArrayList, boolean paramBoolean, Map<String, String> paramMap, int paramInt2, int paramInt3, String paramString4, int paramInt4, ArrayList<s_likeman> paramArrayList1)
  {
    this.replyid = paramString1;
    this.user = params_user1;
    this.content = paramString2;
    this.date = paramInt1;
    this.refer = paramString3;
    this.audio = params_audio;
    this.target = params_user2;
    this.replypic = paramArrayList;
    this.isDeleted = paramBoolean;
    this.extendInfo = paramMap;
    this.displayflag = paramInt2;
    this.likeNum = paramInt3;
    this.replyLikeKey = paramString4;
    this.isliked = paramInt4;
    this.likemans = paramArrayList1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.replyid = paramJceInputStream.readString(0, false);
    this.user = ((s_user)paramJceInputStream.read(cache_user, 1, false));
    this.content = paramJceInputStream.readString(2, false);
    this.date = paramJceInputStream.read(this.date, 3, false);
    this.refer = paramJceInputStream.readString(4, false);
    this.audio = ((s_audio)paramJceInputStream.read(cache_audio, 5, false));
    this.target = ((s_user)paramJceInputStream.read(cache_target, 6, false));
    this.replypic = ((ArrayList)paramJceInputStream.read(cache_replypic, 7, false));
    this.isDeleted = paramJceInputStream.read(this.isDeleted, 8, false);
    this.extendInfo = ((Map)paramJceInputStream.read(cache_extendInfo, 9, false));
    this.displayflag = paramJceInputStream.read(this.displayflag, 10, false);
    this.likeNum = paramJceInputStream.read(this.likeNum, 11, false);
    this.replyLikeKey = paramJceInputStream.readString(12, false);
    this.isliked = paramJceInputStream.read(this.isliked, 13, false);
    this.likemans = ((ArrayList)paramJceInputStream.read(cache_likemans, 14, false));
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
    if (this.replypic != null) {
      paramJceOutputStream.write(this.replypic, 7);
    }
    paramJceOutputStream.write(this.isDeleted, 8);
    if (this.extendInfo != null) {
      paramJceOutputStream.write(this.extendInfo, 9);
    }
    paramJceOutputStream.write(this.displayflag, 10);
    paramJceOutputStream.write(this.likeNum, 11);
    if (this.replyLikeKey != null) {
      paramJceOutputStream.write(this.replyLikeKey, 12);
    }
    paramJceOutputStream.write(this.isliked, 13);
    if (this.likemans != null) {
      paramJceOutputStream.write(this.likemans, 14);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_reply
 * JD-Core Version:    0.7.0.1
 */