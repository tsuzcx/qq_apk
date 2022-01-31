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

public abstract class uiy<T extends uiz>
  extends swl
{
  private Stream<T> a;
  public sry a;
  public uja a;
  protected ujc<T> a;
  
  public uiy(@NonNull ujc<T> paramujc)
  {
    this.jdField_a_of_type_Uja = new uja();
    this.jdField_a_of_type_Ujc = paramujc;
    vkw.a(this.jdField_a_of_type_Ujc);
  }
  
  private void d()
  {
    a();
    Bosses.get().postLightWeightJob(new FeedListPageLoaderBase.1(this), 0);
  }
  
  public abstract JobSegment<ujb, T> a();
  
  public abstract JobSegment<Integer, ujb> a(uja paramuja);
  
  protected abstract T a();
  
  protected abstract T a(ErrorMessage paramErrorMessage);
  
  public uja a()
  {
    return this.jdField_a_of_type_Uja;
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    this.jdField_a_of_type_Uja.a();
    d();
  }
  
  protected abstract void a(List<String> paramList, boolean paramBoolean);
  
  public void a(uja paramuja)
  {
    this.jdField_a_of_type_Uja = paramuja;
    urk.a("Q.qqstory.home.position", "restore last time cache:%s", paramuja);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uiy
 * JD-Core Version:    0.7.0.1
 */