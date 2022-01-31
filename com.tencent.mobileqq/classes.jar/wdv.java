import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPullSegment.Observer.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.parallel.SimpleParallelObserver;
import mqq.os.MqqHandler;

public class wdv
  extends SimpleParallelObserver
{
  wdv(wds paramwds) {}
  
  public void onAllFunctionComplete(boolean paramBoolean)
  {
    super.onAllFunctionComplete(paramBoolean);
    ThreadManager.getUIHandler().post(new DetailFeedAllInfoPullSegment.Observer.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wdv
 * JD-Core Version:    0.7.0.1
 */