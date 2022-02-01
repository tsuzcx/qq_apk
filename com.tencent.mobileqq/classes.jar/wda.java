import android.support.annotation.NonNull;
import java.util.List;

public abstract class wda<Config extends wdi>
{
  protected wcl a;
  private Config a;
  
  protected List<wcm> a()
  {
    if (this.jdField_a_of_type_Wcl != null) {
      return this.jdField_a_of_type_Wcl.a();
    }
    return null;
  }
  
  protected abstract List<wcl> a(@NonNull List<wcm> paramList);
  
  public Config a()
  {
    return this.jdField_a_of_type_Wdi;
  }
  
  public void a(wcl paramwcl)
  {
    if (paramwcl.b() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      zkb.a(bool);
      this.jdField_a_of_type_Wcl = paramwcl;
      return;
    }
  }
  
  public void a(Config paramConfig)
  {
    this.jdField_a_of_type_Wdi = paramConfig;
  }
  
  public List<wcl> b()
  {
    List localList = a();
    if ((localList == null) || (localList.size() == 0))
    {
      yqp.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "data is null");
      return null;
    }
    if ((a() != null) && (localList.size() < a().b))
    {
      yqp.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "too little data");
      return null;
    }
    return a(a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wda
 * JD-Core Version:    0.7.0.1
 */