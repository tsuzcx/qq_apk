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

public abstract class wkj<T extends wkk>
  extends uxw
{
  private Stream<T> a;
  public utj a;
  public wkl a;
  protected wkn<T> a;
  
  public wkj(@NonNull wkn<T> paramwkn)
  {
    this.jdField_a_of_type_Wkl = new wkl();
    this.jdField_a_of_type_Wkn = paramwkn;
    xmh.a(this.jdField_a_of_type_Wkn);
  }
  
  private void d()
  {
    a();
    Bosses.get().postLightWeightJob(new FeedListPageLoaderBase.1(this), 0);
  }
  
  public abstract JobSegment<wkm, T> a();
  
  public abstract JobSegment<Integer, wkm> a(wkl paramwkl);
  
  protected abstract T a();
  
  protected abstract T a(ErrorMessage paramErrorMessage);
  
  public wkl a()
  {
    return this.jdField_a_of_type_Wkl;
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    this.jdField_a_of_type_Wkl.a();
    d();
  }
  
  protected abstract void a(List<String> paramList, boolean paramBoolean);
  
  public void a(wkl paramwkl)
  {
    this.jdField_a_of_type_Wkl = paramwkl;
    wsv.a("Q.qqstory.home.position", "restore last time cache:%s", paramwkl);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wkj
 * JD-Core Version:    0.7.0.1
 */