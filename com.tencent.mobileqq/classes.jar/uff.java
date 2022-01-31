import android.support.annotation.NonNull;
import java.util.List;

public abstract class uff<Config extends ufn>
{
  protected ueq a;
  private Config a;
  
  protected List<uer> a()
  {
    if (this.jdField_a_of_type_Ueq != null) {
      return this.jdField_a_of_type_Ueq.a();
    }
    return null;
  }
  
  protected abstract List<ueq> a(@NonNull List<uer> paramList);
  
  public Config a()
  {
    return this.jdField_a_of_type_Ufn;
  }
  
  public void a(ueq paramueq)
  {
    if (paramueq.b() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      xmh.a(bool);
      this.jdField_a_of_type_Ueq = paramueq;
      return;
    }
  }
  
  public void a(Config paramConfig)
  {
    this.jdField_a_of_type_Ufn = paramConfig;
  }
  
  public List<ueq> b()
  {
    List localList = a();
    if ((localList == null) || (localList.size() == 0))
    {
      wsv.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "data is null");
      return null;
    }
    if ((a() != null) && (localList.size() < a().b))
    {
      wsv.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "too little data");
      return null;
    }
    return a(a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uff
 * JD-Core Version:    0.7.0.1
 */