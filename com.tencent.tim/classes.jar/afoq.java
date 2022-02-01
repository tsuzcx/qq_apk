import android.content.Context;
import android.util.Log;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class afoq
{
  private static afoq a;
  private List<EmotionPanelListView> Ai = new ArrayList();
  
  public static afoq a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new afoq();
      }
      return a;
    }
    finally {}
  }
  
  public EmotionPanelListView a(Context paramContext)
  {
    if ((this.Ai != null) && (this.Ai.size() > 0))
    {
      paramContext = (EmotionPanelListView)this.Ai.remove(0);
      if (QLog.isColorLevel()) {
        Log.d("EmotionPanelListViewPool", "from listview pool and poolSize = " + this.Ai.size());
      }
      return paramContext;
    }
    return new EmotionPanelListView(paramContext);
  }
  
  public void c(EmotionPanelListView paramEmotionPanelListView)
  {
    if (paramEmotionPanelListView == null) {}
    for (;;)
    {
      return;
      if (this.Ai == null)
      {
        this.Ai = new ArrayList();
        this.Ai.add(paramEmotionPanelListView);
      }
      while (QLog.isColorLevel())
      {
        Log.d("EmotionPanelListViewPool", "relase listview");
        return;
        if (!this.Ai.contains(paramEmotionPanelListView)) {
          this.Ai.add(0, paramEmotionPanelListView);
        }
      }
    }
  }
  
  public void destory()
  {
    if (QLog.isColorLevel()) {
      Log.d("EmotionPanelListViewPool", "destory");
    }
    if (this.Ai != null)
    {
      this.Ai.clear();
      this.Ai = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afoq
 * JD-Core Version:    0.7.0.1
 */