import android.support.annotation.NonNull;
import java.util.List;

public abstract class vxv<Config extends vyd>
{
  protected vxg a;
  private Config a;
  
  protected List<vxh> a()
  {
    if (this.jdField_a_of_type_Vxg != null) {
      return this.jdField_a_of_type_Vxg.a();
    }
    return null;
  }
  
  protected abstract List<vxg> a(@NonNull List<vxh> paramList);
  
  public Config a()
  {
    return this.jdField_a_of_type_Vyd;
  }
  
  public void a(vxg paramvxg)
  {
    if (paramvxg.b() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      zdl.a(bool);
      this.jdField_a_of_type_Vxg = paramvxg;
      return;
    }
  }
  
  public void a(Config paramConfig)
  {
    this.jdField_a_of_type_Vyd = paramConfig;
  }
  
  public List<vxg> b()
  {
    List localList = a();
    if ((localList == null) || (localList.size() == 0))
    {
      ykq.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "data is null");
      return null;
    }
    if ((a() != null) && (localList.size() < a().b))
    {
      ykq.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "too little data");
      return null;
    }
    return a(a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxv
 * JD-Core Version:    0.7.0.1
 */