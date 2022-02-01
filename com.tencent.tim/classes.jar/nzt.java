import com.tencent.biz.pubaccount.subscript.ReadInJoyArticle;
import java.util.ArrayList;
import java.util.List;

public class nzt
  implements acci
{
  protected void b(boolean paramBoolean, ArrayList<ReadInJoyArticle> paramArrayList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      if (paramObject != null) {
        try
        {
          r(paramBoolean, (ArrayList)paramObject);
          return;
        }
        catch (Exception paramObject)
        {
          return;
        }
      }
      r(false, new ArrayList(0));
      return;
    }
    if (paramObject != null) {
      try
      {
        b(paramBoolean, (ArrayList)paramObject);
        return;
      }
      catch (Exception paramObject)
      {
        return;
      }
    }
    b(false, new ArrayList(0));
  }
  
  protected void r(boolean paramBoolean, List<nzw> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nzt
 * JD-Core Version:    0.7.0.1
 */