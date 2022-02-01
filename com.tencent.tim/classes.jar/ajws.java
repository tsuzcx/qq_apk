import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.now.FeedsProtocol.TopicCfg;
import com.tencent.pb.now.ilive_feeds_read.TopicCfg;
import java.util.List;

public class ajws
{
  private String aiF;
  private String bSF;
  private int cMl;
  private int dlu;
  private int dlv;
  private String topicDesc;
  private String topicName;
  
  public static akjj a(List<ilive_feeds_read.TopicCfg> paramList, akjj paramakjj)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = (ilive_feeds_read.TopicCfg)paramList.get(0);
      paramakjj.a = new ajws();
      paramakjj.a.Nd(paramList.jump_url.get());
      paramakjj.a.Nb(paramList.topic_name.get());
      paramakjj.a.Na(paramList.topic_desc.get());
      paramakjj.a.Rz(paramList.topic_parti_num.get());
      paramakjj.a.Nc(paramList.topic_pic_url.get());
      paramakjj.a.Ry(paramList.topic_tag.get());
      paramakjj.a.RA(paramList.topic_type.get());
    }
    return paramakjj;
  }
  
  public static VideoData a(List<FeedsProtocol.TopicCfg> paramList, VideoData paramVideoData)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = (FeedsProtocol.TopicCfg)paramList.get(0);
      paramVideoData.a = new ajws();
      paramVideoData.a.Nd(paramList.jump_url.get());
      paramVideoData.a.Nb(paramList.topic_name.get());
      paramVideoData.a.Na(paramList.topic_desc.get());
      paramVideoData.a.Rz(paramList.topic_parti_num.get());
      paramVideoData.a.Nc(paramList.topic_pic_url.get());
      paramVideoData.a.Ry(paramList.topic_tag.get());
      paramVideoData.a.RA(paramList.topic_type.get());
    }
    return paramVideoData;
  }
  
  public void Na(String paramString)
  {
    this.topicDesc = paramString;
  }
  
  public void Nb(String paramString)
  {
    this.topicName = paramString;
  }
  
  public void Nc(String paramString)
  {
    this.bSF = paramString;
  }
  
  public void Nd(String paramString)
  {
    this.aiF = paramString;
  }
  
  public void RA(int paramInt)
  {
    this.cMl = paramInt;
  }
  
  public void Ry(int paramInt)
  {
    this.dlu = paramInt;
  }
  
  public void Rz(int paramInt)
  {
    this.dlv = paramInt;
  }
  
  public String getTopicName()
  {
    return this.topicName;
  }
  
  public String jV()
  {
    return this.aiF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajws
 * JD-Core Version:    0.7.0.1
 */