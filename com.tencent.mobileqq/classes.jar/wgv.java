import android.support.annotation.NonNull;
import java.util.List;

public abstract class wgv<Config extends whd>
{
  protected wgg a;
  private Config a;
  
  protected List<wgh> a()
  {
    if (this.jdField_a_of_type_Wgg != null) {
      return this.jdField_a_of_type_Wgg.a();
    }
    return null;
  }
  
  protected abstract List<wgg> a(@NonNull List<wgh> paramList);
  
  public Config a()
  {
    return this.jdField_a_of_type_Whd;
  }
  
  public void a(wgg paramwgg)
  {
    if (paramwgg.b() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      znw.a(bool);
      this.jdField_a_of_type_Wgg = paramwgg;
      return;
    }
  }
  
  public void a(Config paramConfig)
  {
    this.jdField_a_of_type_Whd = paramConfig;
  }
  
  public List<wgg> b()
  {
    List localList = a();
    if ((localList == null) || (localList.size() == 0))
    {
      yuk.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "data is null");
      return null;
    }
    if ((a() != null) && (localList.size() < a().b))
    {
      yuk.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "too little data");
      return null;
    }
    return a(a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wgv
 * JD-Core Version:    0.7.0.1
 */