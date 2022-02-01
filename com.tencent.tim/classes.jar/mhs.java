import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.SpecialTopicInfo;

public class mhs
{
  public articlesummary.PackInfo a;
  public int aRX = 6;
  public int aSf;
  public int aSg;
  public int aSh;
  public long algorithmID;
  public String desc;
  public int followStatus;
  public boolean hasExposed;
  public String iconUrl;
  public String jumpUrl;
  public long strategyID;
  public String title;
  public long uin;
  public int videoCount;
  public long vp;
  public long vq;
  public long vr;
  
  public static mhs a(articlesummary.PackInfo paramPackInfo)
  {
    try
    {
      mhs localmhs = new mhs();
      localmhs.a = paramPackInfo;
      localmhs.title = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).str_header_title.get();
      localmhs.desc = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).bytes_recommend_reason.get().toStringUtf8();
      localmhs.uin = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint64_puin.get();
      localmhs.iconUrl = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).str_header_icon_url.get();
      localmhs.aRX = paramPackInfo.pack_type.get();
      localmhs.vq = paramPackInfo.uint64_pack_id.get();
      localmhs.jumpUrl = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).str_header_jump_url.get();
      localmhs.aSf = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint32_icon_shape.get();
      localmhs.algorithmID = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint64_algorithm_id.get();
      localmhs.strategyID = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint32_strategy_id.get();
      localmhs.vr = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint64_topic_id.get();
      localmhs.vp = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint32_posttime.get();
      localmhs.followStatus = paramPackInfo.uint32_follow_status.get();
      return localmhs;
    }
    catch (Exception paramPackInfo) {}
    return null;
  }
  
  public String toString()
  {
    return "PolymericInfo【 packID : " + this.vq + "\n polymericType : " + this.aRX + "\n algorithmID : " + this.algorithmID + "\n strategyID : " + this.strategyID + "\n title : " + this.title + "\n desc : " + this.desc + "\n publicTime : " + this.vp + "\n iconUrl : " + this.iconUrl + "\n uin : " + this.uin + "\n topicID : " + this.vr + "\n topicMemberCount : " + this.aSg + "\n jumpUrl : " + this.jumpUrl + "\n videoCount : " + this.videoCount + "\n followStatus : " + this.followStatus + "】";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mhs
 * JD-Core Version:    0.7.0.1
 */