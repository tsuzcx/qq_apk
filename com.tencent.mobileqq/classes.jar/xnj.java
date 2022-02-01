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

public abstract class xnj<T extends xnk>
  extends wbc
{
  private Stream<T> a;
  public vwp a;
  public xnl a;
  protected xnn<T> a;
  
  public xnj(@NonNull xnn<T> paramxnn)
  {
    this.jdField_a_of_type_Xnl = new xnl();
    this.jdField_a_of_type_Xnn = paramxnn;
    yos.a(this.jdField_a_of_type_Xnn);
  }
  
  private void d()
  {
    a();
    Bosses.get().postLightWeightJob(new FeedListPageLoaderBase.1(this), 0);
  }
  
  public abstract JobSegment<xnm, T> a();
  
  public abstract JobSegment<Integer, xnm> a(xnl paramxnl);
  
  protected abstract T a();
  
  protected abstract T a(ErrorMessage paramErrorMessage);
  
  public xnl a()
  {
    return this.jdField_a_of_type_Xnl;
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    this.jdField_a_of_type_Xnl.a();
    d();
  }
  
  protected abstract void a(List<String> paramList, boolean paramBoolean);
  
  public void a(xnl paramxnl)
  {
    this.jdField_a_of_type_Xnl = paramxnl;
    xvv.a("Q.qqstory.home.position", "restore last time cache:%s", paramxnl);
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
 * Qualified Name:     xnj
 * JD-Core Version:    0.7.0.1
 */