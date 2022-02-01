import com.tencent.biz.pubaccount.subscript.ReadInJoyArticle;
import java.util.ArrayList;
import java.util.List;

public class tvm
  implements anui
{
  protected void a(boolean paramBoolean, ArrayList<ReadInJoyArticle> paramArrayList) {}
  
  protected void a(boolean paramBoolean, List<tvr> paramList) {}
  
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
          a(paramBoolean, (ArrayList)paramObject);
          return;
        }
        catch (Exception paramObject)
        {
          return;
        }
      }
      a(false, new ArrayList(0));
      return;
    }
    if (paramObject != null) {
      try
      {
        a(paramBoolean, (ArrayList)paramObject);
        return;
      }
      catch (Exception paramObject)
      {
        return;
      }
    }
    a(false, new ArrayList(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tvm
 * JD-Core Version:    0.7.0.1
 */