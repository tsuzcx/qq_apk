import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.SingleFeedPlayInfo;
import java.util.ArrayList;
import java.util.List;

public class wpf
  extends wnr<SingleFeedPlayInfo>
{
  public wpf(SingleFeedPlayInfo paramSingleFeedPlayInfo)
  {
    super(paramSingleFeedPlayInfo);
  }
  
  public xnh a(String paramString)
  {
    paramString = new xnh(((SingleFeedPlayInfo)this.a).mFeedFeedId, 0, "", "");
    paramString.b = ((SingleFeedPlayInfo)this.a).mFeedPullType;
    return paramString;
  }
  
  public void a(boolean paramBoolean, int paramInt, woj paramwoj)
  {
    ArrayList localArrayList = new ArrayList();
    wns localwns = new wns(((SingleFeedPlayInfo)this.a).mFeedFeedId, new xnh(((SingleFeedPlayInfo)this.a).mFeedFeedId, 0, "", ""));
    localwns.a.b = ((SingleFeedPlayInfo)this.a).mFeedPullType;
    localArrayList.add(localwns);
    paramwoj.a(new ErrorMessage(), localArrayList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wpf
 * JD-Core Version:    0.7.0.1
 */