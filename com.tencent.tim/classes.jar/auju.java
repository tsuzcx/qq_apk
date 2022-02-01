import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class auju
  extends aujv
{
  private Drawable a(View paramView, String paramString)
  {
    if ((paramView != null) && (!TextUtils.isEmpty(paramString))) {
      try
      {
        paramString = paramView.getClass().getDeclaredField(paramString);
        paramString.setAccessible(true);
        paramView = paramString.get(paramView);
        if ((paramView instanceof Drawable))
        {
          paramView = (Drawable)paramView;
          return paramView;
        }
      }
      catch (Exception paramView)
      {
        QLog.d("GrabMainTabResourceName", 1, paramView, new Object[0]);
      }
    }
    return null;
  }
  
  public List<aujl> b(View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramView instanceof TabDragAnimationView))
    {
      a(a(paramView, "mBgDrawable"), localArrayList, "background");
      a(a(paramView, "mBgPressedDrawable"), localArrayList, "background");
      a(a(paramView, "mEmotionDrawable"), localArrayList, "background");
      a(a(paramView, "mEmotionPressedDrawable"), localArrayList, "background");
      a(a(paramView, "mClickAnimationDrawable"), localArrayList, "background");
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auju
 * JD-Core Version:    0.7.0.1
 */