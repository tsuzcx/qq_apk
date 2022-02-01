import android.util.Log;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class afos
{
  private static afos a;
  public static int widthPixels;
  private Map<Integer, ArrayList<View>> kn = new ConcurrentHashMap();
  
  public static afos a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new afos();
      }
      return a;
    }
    finally {}
  }
  
  public void destory()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelViewPool", 2, "destory");
    }
    if ((this.kn != null) && (this.kn.size() > 0))
    {
      Iterator localIterator = this.kn.entrySet().iterator();
      while (localIterator.hasNext())
      {
        ArrayList localArrayList = (ArrayList)((Map.Entry)localIterator.next()).getValue();
        if (localArrayList != null) {
          localArrayList.clear();
        }
      }
      this.kn.clear();
    }
  }
  
  public View getView(int paramInt)
  {
    if ((this.kn != null) && (this.kn.containsKey(Integer.valueOf(paramInt))))
    {
      Object localObject = (ArrayList)this.kn.get(Integer.valueOf(paramInt));
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = (View)((ArrayList)localObject).remove(0);
        if (QLog.isColorLevel()) {
          Log.d("EmotionPanelViewPool", "getView from pool : paneyType = " + paramInt);
        }
        return localObject;
      }
    }
    return null;
  }
  
  public void t(int paramInt, View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      ArrayList localArrayList;
      if (this.kn == null)
      {
        this.kn = new ConcurrentHashMap();
        localArrayList = new ArrayList();
        localArrayList.add(paramView);
        this.kn.put(Integer.valueOf(paramInt), localArrayList);
        return;
      }
      if (this.kn.containsKey(Integer.valueOf(paramInt)))
      {
        localArrayList = (ArrayList)this.kn.get(Integer.valueOf(paramInt));
        if ((localArrayList != null) && (!localArrayList.contains(paramView))) {
          localArrayList.add(0, paramView);
        }
      }
      while (QLog.isColorLevel())
      {
        Log.d("EmotionPanelViewPool", "relase view panelType = " + paramInt);
        return;
        localArrayList = new ArrayList();
        localArrayList.add(0, paramView);
        this.kn.put(Integer.valueOf(paramInt), localArrayList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afos
 * JD-Core Version:    0.7.0.1
 */