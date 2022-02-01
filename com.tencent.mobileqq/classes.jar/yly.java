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

public abstract class yly<T extends ylz>
  extends wzm
{
  private Stream<T> a;
  public wuz a;
  public yma a;
  protected ymc<T> a;
  
  public yly(@NonNull ymc<T> paramymc)
  {
    this.jdField_a_of_type_Yma = new yma();
    this.jdField_a_of_type_Ymc = paramymc;
    znw.a(this.jdField_a_of_type_Ymc);
  }
  
  private void d()
  {
    a();
    Bosses.get().postLightWeightJob(new FeedListPageLoaderBase.1(this), 0);
  }
  
  public abstract JobSegment<ymb, T> a();
  
  public abstract JobSegment<Integer, ymb> a(yma paramyma);
  
  protected abstract T a();
  
  protected abstract T a(ErrorMessage paramErrorMessage);
  
  public yma a()
  {
    return this.jdField_a_of_type_Yma;
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    this.jdField_a_of_type_Yma.a();
    d();
  }
  
  protected abstract void a(List<String> paramList, boolean paramBoolean);
  
  public void a(yma paramyma)
  {
    this.jdField_a_of_type_Yma = paramyma;
    yuk.a("Q.qqstory.home.position", "restore last time cache:%s", paramyma);
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
 * Qualified Name:     yly
 * JD-Core Version:    0.7.0.1
 */