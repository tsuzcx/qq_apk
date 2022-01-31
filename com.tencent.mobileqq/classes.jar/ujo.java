import android.support.annotation.NonNull;
import java.util.List;

public abstract class ujo<Config extends ujw>
{
  protected uiz a;
  private Config a;
  
  protected List<uja> a()
  {
    if (this.jdField_a_of_type_Uiz != null) {
      return this.jdField_a_of_type_Uiz.a();
    }
    return null;
  }
  
  protected abstract List<uiz> a(@NonNull List<uja> paramList);
  
  public Config a()
  {
    return this.jdField_a_of_type_Ujw;
  }
  
  public void a(uiz paramuiz)
  {
    if (paramuiz.b() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      xqq.a(bool);
      this.jdField_a_of_type_Uiz = paramuiz;
      return;
    }
  }
  
  public void a(Config paramConfig)
  {
    this.jdField_a_of_type_Ujw = paramConfig;
  }
  
  public List<uiz> b()
  {
    List localList = a();
    if ((localList == null) || (localList.size() == 0))
    {
      wxe.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "data is null");
      return null;
    }
    if ((a() != null) && (localList.size() < a().b))
    {
      wxe.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "too little data");
      return null;
    }
    return a(a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ujo
 * JD-Core Version:    0.7.0.1
 */