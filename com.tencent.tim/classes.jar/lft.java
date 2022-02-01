import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeVideoView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class lft
{
  public static void a(ListView paramListView, boolean paramBoolean)
  {
    h(paramListView);
  }
  
  public static void c(Container paramContainer)
  {
    paramContainer = paramContainer.getViewIdMapping().entrySet().iterator();
    while (paramContainer.hasNext())
    {
      Object localObject = (Map.Entry)paramContainer.next();
      if ((((Map.Entry)localObject).getValue() instanceof lso))
      {
        localObject = (lso)((Map.Entry)localObject).getValue();
        if ((((lso)localObject).a() instanceof NativeVideoView)) {
          ((lso)localObject).a().kH();
        }
      }
    }
  }
  
  public static void cr(View paramView)
  {
    if ((paramView instanceof lfo)) {
      ((lfo)paramView).stop();
    }
  }
  
  public static void d(Container paramContainer)
  {
    paramContainer = paramContainer.getViewIdMapping().entrySet().iterator();
    while (paramContainer.hasNext())
    {
      Object localObject = (Map.Entry)paramContainer.next();
      if ((((Map.Entry)localObject).getValue() instanceof lso))
      {
        localObject = (lso)((Map.Entry)localObject).getValue();
        if ((((lso)localObject).a() instanceof NativeVideoView)) {
          ((lso)localObject).a().stop();
        }
      }
    }
  }
  
  public static void g(ListView paramListView)
  {
    a(paramListView, true);
  }
  
  private static void h(ListView paramListView)
  {
    int j = 0;
    int i = 0;
    View localView;
    if (i < paramListView.getChildCount())
    {
      localView = paramListView.getChildAt(i);
      if (((localView instanceof lfo)) && (kwz.c(localView) >= 60.0F))
      {
        QLog.d("gifvideo.VideoPlayControlUtils", 2, ">= 60f");
        if (!((lfo)localView).start()) {}
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        QLog.d("gifvideo.VideoPlayControlUtils", 2, "item to play: " + i);
        for (;;)
        {
          if (j < paramListView.getChildCount())
          {
            localView = paramListView.getChildAt(j);
            if (((localView instanceof lfo)) && (j != i)) {
              ((lfo)localView).stop();
            }
            j += 1;
            continue;
            i += 1;
            break;
          }
        }
      }
      return;
      i = -1;
    }
  }
  
  public static void i(ListView paramListView)
  {
    if ((!kxm.isAppOnForeground(paramListView.getContext())) || (paramListView.getChildCount() <= 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramListView.getChildCount())
      {
        View localView = paramListView.getChildAt(i);
        if ((localView instanceof lfo)) {
          ((lfo)localView).pause();
        }
        i += 1;
      }
    }
  }
  
  public static void j(ListView paramListView)
  {
    if ((!kxm.isAppOnForeground(paramListView.getContext())) || (paramListView.getChildCount() <= 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramListView.getChildCount())
      {
        View localView = paramListView.getChildAt(i);
        if ((localView instanceof lfo)) {
          ((lfo)localView).stop();
        }
        i += 1;
      }
    }
  }
  
  public static void k(ListView paramListView)
  {
    if ((!kxm.isAppOnForeground(paramListView.getContext())) || (paramListView.getChildCount() <= 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramListView.getChildCount())
      {
        View localView = paramListView.getChildAt(i);
        if ((localView instanceof lfo)) {
          ((lfo)localView).destroy();
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lft
 * JD-Core Version:    0.7.0.1
 */