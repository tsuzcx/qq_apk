import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPullSegment.Observer.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.parallel.SimpleParallelObserver;
import mqq.os.MqqHandler;

public class yfk
  extends SimpleParallelObserver
{
  yfk(yfh paramyfh) {}
  
  public void onAllFunctionComplete(boolean paramBoolean)
  {
    super.onAllFunctionComplete(paramBoolean);
    ThreadManager.getUIHandler().post(new DetailFeedAllInfoPullSegment.Observer.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfk
 * JD-Core Version:    0.7.0.1
 */