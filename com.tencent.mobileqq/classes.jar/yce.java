import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.1;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.async.JobSegment;
import com.tribe.async.reactive.Stream;
import java.util.List;

public abstract class yce<T extends ycf>
  extends wpx
{
  private Stream<T> a;
  public wlk a;
  public ycg a;
  protected yci<T> a;
  
  public yce(@NonNull yci<T> paramyci)
  {
    this.jdField_a_of_type_Ycg = new ycg();
    this.jdField_a_of_type_Yci = paramyci;
    zdl.a(this.jdField_a_of_type_Yci);
  }
  
  private void d()
  {
    a();
    Bosses.get().postLightWeightJob(new FeedListPageLoaderBase.1(this), 0);
  }
  
  public abstract JobSegment<ych, T> a();
  
  public abstract JobSegment<Integer, ych> a(ycg paramycg);
  
  protected abstract T a();
  
  protected abstract T a(ErrorMessage paramErrorMessage);
  
  public ycg a()
  {
    return this.jdField_a_of_type_Ycg;
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    this.jdField_a_of_type_Ycg.a();
    d();
  }
  
  protected abstract void a(List<String> paramList, boolean paramBoolean);
  
  public void a(ycg paramycg)
  {
    this.jdField_a_of_type_Ycg = paramycg;
    ykq.a("Q.qqstory.home.position", "restore last time cache:%s", paramycg);
  }
  
  public T b()
  {
    return a();
  }
  
  public void c()
  {
    super.c();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yce
 * JD-Core Version:    0.7.0.1
 */