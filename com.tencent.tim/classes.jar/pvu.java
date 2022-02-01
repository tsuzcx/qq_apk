import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import java.util.List;

public class pvu
  extends pro<puh, prp<puh>>
{
  private int bkV = -1;
  
  public pvu(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(prp<puh> paramprp)
  {
    super.onViewDetachedFromWindow(paramprp);
    paramprp.bey();
  }
  
  public prp b(ViewGroup paramViewGroup, int paramInt)
  {
    return pwv.c(paramViewGroup, paramInt);
  }
  
  public void b(prp paramprp, int paramInt)
  {
    paramprp.P((puh)getItem(paramInt));
  }
  
  public int bf(String paramString)
  {
    List localList = be();
    int i = 0;
    while (i < localList.size())
    {
      if (TextUtils.equals(((puh)localList.get(i)).unionId, paramString)) {
        return st() + i;
      }
      i += 1;
    }
    return st();
  }
  
  public int dr(int paramInt)
  {
    puh localpuh = (puh)getItem(paramInt);
    if (localpuh != null) {
      return localpuh.nodeType;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pvu
 * JD-Core Version:    0.7.0.1
 */