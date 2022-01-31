import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.HotRecommendFeedPlayInfo;
import java.util.ArrayList;
import java.util.List;

public class vpi
  extends vpa<HotRecommendFeedPlayInfo>
{
  public vpi(HotRecommendFeedPlayInfo paramHotRecommendFeedPlayInfo)
  {
    super(paramHotRecommendFeedPlayInfo);
  }
  
  public woq a(String paramString)
  {
    paramString = new woq(((HotRecommendFeedPlayInfo)this.a).mFeedFeedId, 0, "", "");
    paramString.b = ((HotRecommendFeedPlayInfo)this.a).mPullType;
    return paramString;
  }
  
  public void a(boolean paramBoolean, int paramInt, vps paramvps)
  {
    ArrayList localArrayList = new ArrayList();
    vpb localvpb = new vpb(((HotRecommendFeedPlayInfo)this.a).mFeedFeedId, new woq(((HotRecommendFeedPlayInfo)this.a).mFeedFeedId, 0, "", ""));
    localvpb.a.b = ((HotRecommendFeedPlayInfo)this.a).mPullType;
    localArrayList.add(localvpb);
    paramvps.a(new ErrorMessage(), localArrayList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vpi
 * JD-Core Version:    0.7.0.1
 */