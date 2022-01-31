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

public abstract class wos<T extends wot>
  extends vcf
{
  private Stream<T> a;
  public uxs a;
  public wou a;
  protected wow<T> a;
  
  public wos(@NonNull wow<T> paramwow)
  {
    this.jdField_a_of_type_Wou = new wou();
    this.jdField_a_of_type_Wow = paramwow;
    xqq.a(this.jdField_a_of_type_Wow);
  }
  
  private void d()
  {
    a();
    Bosses.get().postLightWeightJob(new FeedListPageLoaderBase.1(this), 0);
  }
  
  public abstract JobSegment<wov, T> a();
  
  public abstract JobSegment<Integer, wov> a(wou paramwou);
  
  protected abstract T a();
  
  protected abstract T a(ErrorMessage paramErrorMessage);
  
  public wou a()
  {
    return this.jdField_a_of_type_Wou;
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    this.jdField_a_of_type_Wou.a();
    d();
  }
  
  protected abstract void a(List<String> paramList, boolean paramBoolean);
  
  public void a(wou paramwou)
  {
    this.jdField_a_of_type_Wou = paramwou;
    wxe.a("Q.qqstory.home.position", "restore last time cache:%s", paramwou);
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
 * Qualified Name:     wos
 * JD-Core Version:    0.7.0.1
 */