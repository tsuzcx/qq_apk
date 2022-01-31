import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.SingleFeedPlayInfo;
import java.util.ArrayList;
import java.util.List;

public class vmf
  extends vkr<SingleFeedPlayInfo>
{
  public vmf(SingleFeedPlayInfo paramSingleFeedPlayInfo)
  {
    super(paramSingleFeedPlayInfo);
  }
  
  public wkh a(String paramString)
  {
    paramString = new wkh(((SingleFeedPlayInfo)this.a).mFeedFeedId, 0, "", "");
    paramString.b = ((SingleFeedPlayInfo)this.a).mFeedPullType;
    return paramString;
  }
  
  public void a(boolean paramBoolean, int paramInt, vlj paramvlj)
  {
    ArrayList localArrayList = new ArrayList();
    vks localvks = new vks(((SingleFeedPlayInfo)this.a).mFeedFeedId, new wkh(((SingleFeedPlayInfo)this.a).mFeedFeedId, 0, "", ""));
    localvks.a.b = ((SingleFeedPlayInfo)this.a).mFeedPullType;
    localArrayList.add(localvks);
    paramvlj.a(new ErrorMessage(), localArrayList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vmf
 * JD-Core Version:    0.7.0.1
 */