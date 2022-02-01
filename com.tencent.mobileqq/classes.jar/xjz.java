import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.SingleFeedPlayInfo;
import java.util.ArrayList;
import java.util.List;

public class xjz
  extends xil<SingleFeedPlayInfo>
{
  public xjz(SingleFeedPlayInfo paramSingleFeedPlayInfo)
  {
    super(paramSingleFeedPlayInfo);
  }
  
  public yib a(String paramString)
  {
    paramString = new yib(((SingleFeedPlayInfo)this.a).mFeedFeedId, 0, "", "");
    paramString.b = ((SingleFeedPlayInfo)this.a).mFeedPullType;
    return paramString;
  }
  
  public void a(boolean paramBoolean, int paramInt, xjd paramxjd)
  {
    ArrayList localArrayList = new ArrayList();
    xim localxim = new xim(((SingleFeedPlayInfo)this.a).mFeedFeedId, new yib(((SingleFeedPlayInfo)this.a).mFeedFeedId, 0, "", ""));
    localxim.a.b = ((SingleFeedPlayInfo)this.a).mFeedPullType;
    localArrayList.add(localxim);
    paramxjd.a(new ErrorMessage(), localArrayList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xjz
 * JD-Core Version:    0.7.0.1
 */