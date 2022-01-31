import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.HotRecommendFeedPlayInfo;
import java.util.ArrayList;
import java.util.List;

public class vkz
  extends vkr<HotRecommendFeedPlayInfo>
{
  public vkz(HotRecommendFeedPlayInfo paramHotRecommendFeedPlayInfo)
  {
    super(paramHotRecommendFeedPlayInfo);
  }
  
  public wkh a(String paramString)
  {
    paramString = new wkh(((HotRecommendFeedPlayInfo)this.a).mFeedFeedId, 0, "", "");
    paramString.b = ((HotRecommendFeedPlayInfo)this.a).mPullType;
    return paramString;
  }
  
  public void a(boolean paramBoolean, int paramInt, vlj paramvlj)
  {
    ArrayList localArrayList = new ArrayList();
    vks localvks = new vks(((HotRecommendFeedPlayInfo)this.a).mFeedFeedId, new wkh(((HotRecommendFeedPlayInfo)this.a).mFeedFeedId, 0, "", ""));
    localvks.a.b = ((HotRecommendFeedPlayInfo)this.a).mPullType;
    localArrayList.add(localvks);
    paramvlj.a(new ErrorMessage(), localArrayList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vkz
 * JD-Core Version:    0.7.0.1
 */