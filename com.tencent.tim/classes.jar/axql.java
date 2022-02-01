import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;
import java.util.List;

public class axql
  implements Cloneable
{
  public List<PtvTemplateManager.PtvTemplateInfo> Fv;
  public String bZc;
  public int categoryId;
  public String categoryName;
  public boolean czY;
  public boolean dvY;
  public int dyC;
  
  public axql() {}
  
  public axql(String paramString)
  {
    this.categoryName = paramString;
  }
  
  public axql a()
  {
    axql localaxql = new axql();
    localaxql.categoryName = this.categoryName;
    localaxql.categoryId = this.categoryId;
    localaxql.czY = this.czY;
    localaxql.bZc = this.bZc;
    localaxql.dyC = this.dyC;
    localaxql.dvY = this.dvY;
    localaxql.Fv = new ArrayList();
    localaxql.Fv.addAll(this.Fv);
    return localaxql;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axql
 * JD-Core Version:    0.7.0.1
 */