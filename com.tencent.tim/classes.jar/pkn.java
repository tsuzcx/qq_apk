import android.support.annotation.NonNull;
import java.util.List;

public abstract class pkn<Config extends pku.a>
{
  protected pkd a;
  private Config a;
  
  public Config a()
  {
    return this.jdField_a_of_type_Pku$a;
  }
  
  protected abstract List<pkd> ah(@NonNull List<pkd.a> paramList);
  
  public void b(Config paramConfig)
  {
    this.jdField_a_of_type_Pku$a = paramConfig;
  }
  
  public List<pkd> bE()
  {
    List localList = getData();
    if ((localList == null) || (localList.size() == 0))
    {
      ram.w("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "data is null");
      return null;
    }
    if ((a() != null) && (localList.size() < a().bje))
    {
      ram.w("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "too little data");
      return null;
    }
    return ah(getData());
  }
  
  public void c(pkd parampkd)
  {
    if (parampkd.getCount() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      rom.assertTrue(bool);
      this.jdField_a_of_type_Pkd = parampkd;
      return;
    }
  }
  
  protected List<pkd.a> getData()
  {
    if (this.jdField_a_of_type_Pkd != null) {
      return this.jdField_a_of_type_Pkd.bD();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pkn
 * JD-Core Version:    0.7.0.1
 */