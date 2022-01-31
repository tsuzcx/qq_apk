import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.SingleFeedPlayInfo;
import java.util.ArrayList;
import java.util.List;

public class vqo
  extends vpa<SingleFeedPlayInfo>
{
  public vqo(SingleFeedPlayInfo paramSingleFeedPlayInfo)
  {
    super(paramSingleFeedPlayInfo);
  }
  
  public woq a(String paramString)
  {
    paramString = new woq(((SingleFeedPlayInfo)this.a).mFeedFeedId, 0, "", "");
    paramString.b = ((SingleFeedPlayInfo)this.a).mFeedPullType;
    return paramString;
  }
  
  public void a(boolean paramBoolean, int paramInt, vps paramvps)
  {
    ArrayList localArrayList = new ArrayList();
    vpb localvpb = new vpb(((SingleFeedPlayInfo)this.a).mFeedFeedId, new woq(((SingleFeedPlayInfo)this.a).mFeedFeedId, 0, "", ""));
    localvpb.a.b = ((SingleFeedPlayInfo)this.a).mFeedPullType;
    localArrayList.add(localvpb);
    paramvps.a(new ErrorMessage(), localArrayList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vqo
 * JD-Core Version:    0.7.0.1
 */