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

public abstract class yid<T extends yie>
  extends wvr
{
  private Stream<T> a;
  public wre a;
  public yif a;
  protected yih<T> a;
  
  public yid(@NonNull yih<T> paramyih)
  {
    this.jdField_a_of_type_Yif = new yif();
    this.jdField_a_of_type_Yih = paramyih;
    zkb.a(this.jdField_a_of_type_Yih);
  }
  
  private void d()
  {
    a();
    Bosses.get().postLightWeightJob(new FeedListPageLoaderBase.1(this), 0);
  }
  
  public abstract JobSegment<yig, T> a();
  
  public abstract JobSegment<Integer, yig> a(yif paramyif);
  
  protected abstract T a();
  
  protected abstract T a(ErrorMessage paramErrorMessage);
  
  public yif a()
  {
    return this.jdField_a_of_type_Yif;
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    this.jdField_a_of_type_Yif.a();
    d();
  }
  
  protected abstract void a(List<String> paramList, boolean paramBoolean);
  
  public void a(yif paramyif)
  {
    this.jdField_a_of_type_Yif = paramyif;
    yqp.a("Q.qqstory.home.position", "restore last time cache:%s", paramyif);
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
 * Qualified Name:     yid
 * JD-Core Version:    0.7.0.1
 */