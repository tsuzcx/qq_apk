import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyTabDragAnimationView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;

public class kvu
{
  private static boolean aib;
  
  public static boolean AE()
  {
    return aib;
  }
  
  public static View a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (BaseApplicationImpl.sApplication == null) {
      return null;
    }
    View localView = View.inflate(BaseApplicationImpl.sApplication, 2131563155, null);
    ((DragTextView)localView.findViewById(2131381236)).setDragViewType(2);
    ((ReadInjoyTabDragAnimationView)localView.findViewById(2131379150)).setEmotionDrawable(paramInt1, paramInt2, paramInt3, paramInt4, paramInt6, paramInt7);
    ((TextView)localView.findViewById(2131380957)).setText(paramInt5);
    return localView;
  }
  
  public static void mN(boolean paramBoolean)
  {
    try
    {
      aib = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kvu
 * JD-Core Version:    0.7.0.1
 */