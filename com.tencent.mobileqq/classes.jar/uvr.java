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

public abstract class uvr<T extends uvs>
  extends tje
{
  private Stream<T> a;
  public ter a;
  public uvt a;
  protected uvv<T> a;
  
  public uvr(@NonNull uvv<T> paramuvv)
  {
    this.jdField_a_of_type_Uvt = new uvt();
    this.jdField_a_of_type_Uvv = paramuvv;
    vxp.a(this.jdField_a_of_type_Uvv);
  }
  
  private void d()
  {
    a();
    Bosses.get().postLightWeightJob(new FeedListPageLoaderBase.1(this), 0);
  }
  
  public abstract JobSegment<uvu, T> a();
  
  public abstract JobSegment<Integer, uvu> a(uvt paramuvt);
  
  protected abstract T a();
  
  protected abstract T a(ErrorMessage paramErrorMessage);
  
  public uvt a()
  {
    return this.jdField_a_of_type_Uvt;
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    this.jdField_a_of_type_Uvt.a();
    d();
  }
  
  protected abstract void a(List<String> paramList, boolean paramBoolean);
  
  public void a(uvt paramuvt)
  {
    this.jdField_a_of_type_Uvt = paramuvt;
    ved.a("Q.qqstory.home.position", "restore last time cache:%s", paramuvt);
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
 * Qualified Name:     uvr
 * JD-Core Version:    0.7.0.1
 */