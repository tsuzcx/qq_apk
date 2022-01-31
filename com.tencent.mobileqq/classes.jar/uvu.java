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

public abstract class uvu<T extends uvv>
  extends tjh
{
  private Stream<T> a;
  public teu a;
  public uvw a;
  protected uvy<T> a;
  
  public uvu(@NonNull uvy<T> paramuvy)
  {
    this.jdField_a_of_type_Uvw = new uvw();
    this.jdField_a_of_type_Uvy = paramuvy;
    vxs.a(this.jdField_a_of_type_Uvy);
  }
  
  private void d()
  {
    a();
    Bosses.get().postLightWeightJob(new FeedListPageLoaderBase.1(this), 0);
  }
  
  public abstract JobSegment<uvx, T> a();
  
  public abstract JobSegment<Integer, uvx> a(uvw paramuvw);
  
  protected abstract T a();
  
  protected abstract T a(ErrorMessage paramErrorMessage);
  
  public uvw a()
  {
    return this.jdField_a_of_type_Uvw;
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    this.jdField_a_of_type_Uvw.a();
    d();
  }
  
  protected abstract void a(List<String> paramList, boolean paramBoolean);
  
  public void a(uvw paramuvw)
  {
    this.jdField_a_of_type_Uvw = paramuvw;
    veg.a("Q.qqstory.home.position", "restore last time cache:%s", paramuvw);
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
 * Qualified Name:     uvu
 * JD-Core Version:    0.7.0.1
 */