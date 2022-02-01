import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPuller.1;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPuller.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class qrs
{
  private Stream<qru> jdField_a_of_type_ComTribeAsyncReactiveStream;
  private qrs.b jdField_a_of_type_Qrs$b;
  private qru jdField_a_of_type_Qru = new qru();
  public boolean aEX = true;
  private String mFeedId;
  private boolean mIsOpen = true;
  
  public qrs(@NonNull String paramString, @NonNull qrs.b paramb, boolean paramBoolean)
  {
    this.mFeedId = paramString;
    this.jdField_a_of_type_Qrs$b = paramb;
    this.aEX = paramBoolean;
  }
  
  private void b(qru paramqru, boolean paramBoolean, ErrorMessage paramErrorMessage)
  {
    ThreadManager.getUIHandler().post(new DetailFeedAllInfoPuller.2(this, paramqru, paramBoolean, paramErrorMessage));
  }
  
  public void bpY()
  {
    Bosses.get().postLightWeightJob(new DetailFeedAllInfoPuller.1(this), 0);
  }
  
  public void bpZ()
  {
    if (this.jdField_a_of_type_ComTribeAsyncReactiveStream != null) {
      this.jdField_a_of_type_ComTribeAsyncReactiveStream.cancel();
    }
    this.jdField_a_of_type_ComTribeAsyncReactiveStream = Stream.of(this.mFeedId).map(new ThreadOffFunction("Q.qqstory.detail.DetailFeedAllInfoPuller", 2)).map(new qrs.a(this.mFeedId));
    if (this.aEX) {
      this.jdField_a_of_type_ComTribeAsyncReactiveStream = this.jdField_a_of_type_ComTribeAsyncReactiveStream.map(new qro());
    }
    this.jdField_a_of_type_ComTribeAsyncReactiveStream.subscribe(new qrs.c());
  }
  
  public void terminate()
  {
    if (this.jdField_a_of_type_ComTribeAsyncReactiveStream != null) {
      this.jdField_a_of_type_ComTribeAsyncReactiveStream.cancel();
    }
  }
  
  public class a
    extends JobSegment<String, qru>
  {
    private pyk a = new pyk();
    
    public a(@NonNull String paramString)
    {
      this.a.nk = new ArrayList();
      this$1 = new qvd(paramString, 0, "", "");
      this.a.nk.add(qrs.this);
    }
    
    protected void a(JobContext paramJobContext, String paramString)
    {
      ppv.a().a(this.a, new qrt(this, paramJobContext));
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(qru paramqru, boolean paramBoolean, ErrorMessage paramErrorMessage);
  }
  
  public class c
    extends SimpleObserver<qru>
  {
    public c() {}
    
    public void b(qru paramqru)
    {
      super.onNext(paramqru);
      qrs.a(qrs.this, paramqru, false, new ErrorMessage());
    }
    
    public void onCancel()
    {
      super.onCancel();
      ram.w("Q.qqstory.detail.DetailFeedAllInfoPuller", "refresh data cancel");
    }
    
    public void onError(@NonNull Error paramError)
    {
      super.onError(paramError);
      qrs.a(qrs.this, null, false, (ErrorMessage)paramError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qrs
 * JD-Core Version:    0.7.0.1
 */