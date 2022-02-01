import android.support.annotation.NonNull;
import java.util.List;

public abstract class vja<Config extends vji>
{
  protected vil a;
  private Config a;
  
  protected List<vim> a()
  {
    if (this.jdField_a_of_type_Vil != null) {
      return this.jdField_a_of_type_Vil.a();
    }
    return null;
  }
  
  protected abstract List<vil> a(@NonNull List<vim> paramList);
  
  public Config a()
  {
    return this.jdField_a_of_type_Vji;
  }
  
  public void a(vil paramvil)
  {
    if (paramvil.b() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      yos.a(bool);
      this.jdField_a_of_type_Vil = paramvil;
      return;
    }
  }
  
  public void a(Config paramConfig)
  {
    this.jdField_a_of_type_Vji = paramConfig;
  }
  
  public List<vil> b()
  {
    List localList = a();
    if ((localList == null) || (localList.size() == 0))
    {
      xvv.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "data is null");
      return null;
    }
    if ((a() != null) && (localList.size() < a().b))
    {
      xvv.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "too little data");
      return null;
    }
    return a(a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vja
 * JD-Core Version:    0.7.0.1
 */