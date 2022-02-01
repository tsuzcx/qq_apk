import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class pso
  implements psj
{
  public boolean aBw;
  public Map<String, WeakReference<QQStoryBaseActivity>> fI;
  protected HashMap<String, WeakReference<QQStoryBaseActivity>> fi = new LinkedHashMap();
  
  public boolean IH()
  {
    Iterator localIterator = this.fi.values().iterator();
    while (localIterator.hasNext())
    {
      QQStoryBaseActivity localQQStoryBaseActivity = (QQStoryBaseActivity)((WeakReference)localIterator.next()).get();
      if ((localQQStoryBaseActivity != null) && (!localQQStoryBaseActivity.isFinishing())) {
        localQQStoryBaseActivity.finish();
      }
    }
    this.fi.clear();
    if (this.fI != null) {
      this.fI.clear();
    }
    this.aBw = false;
    return true;
  }
  
  public ArrayList<Integer> a(QQStoryBaseActivity paramQQStoryBaseActivity)
  {
    ArrayList localArrayList1 = new ArrayList(this.fi.values());
    ArrayList localArrayList2 = new ArrayList();
    int j = localArrayList1.size();
    int i = 0;
    while (i < j)
    {
      QQStoryBaseActivity localQQStoryBaseActivity = (QQStoryBaseActivity)((WeakReference)localArrayList1.get(i)).get();
      if ((localQQStoryBaseActivity != null) && (!localQQStoryBaseActivity.isFinishing()) && (localQQStoryBaseActivity.getActivityName().equals(paramQQStoryBaseActivity.getActivityName())))
      {
        if (QLog.isColorLevel()) {
          QLog.d("zivonchen", 2, "QQStoryActivityManager getActivityFirstIndex: " + i + ", class = " + paramQQStoryBaseActivity.getActivityName());
        }
        localArrayList2.add(Integer.valueOf(i));
      }
      i += 1;
    }
    return localArrayList2;
  }
  
  public void a(QQStoryBaseActivity paramQQStoryBaseActivity)
  {
    String str = paramQQStoryBaseActivity.getActivityName() + "_" + paramQQStoryBaseActivity.hashCode();
    paramQQStoryBaseActivity = new WeakReference(paramQQStoryBaseActivity);
    this.fi.put(str, paramQQStoryBaseActivity);
    if ((this.aBw) && (this.fI != null)) {
      this.fI.put(str, paramQQStoryBaseActivity);
    }
  }
  
  public void b(QQStoryBaseActivity paramQQStoryBaseActivity)
  {
    paramQQStoryBaseActivity = paramQQStoryBaseActivity.getActivityName() + "_" + paramQQStoryBaseActivity.hashCode();
    this.fi.remove(paramQQStoryBaseActivity);
    if ((this.aBw) && (this.fI != null))
    {
      this.fI.remove(paramQQStoryBaseActivity);
      if (this.fI.isEmpty())
      {
        this.aBw = false;
        if (QLog.isColorLevel()) {
          QLog.i("qqstory.QQStoryActivityManager", 2, "player activity stack is empty, disable!");
        }
      }
    }
  }
  
  public void dP(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList(this.fi.values());
    paramInt2 -= 1;
    while (paramInt2 >= paramInt1)
    {
      Object localObject = (QQStoryBaseActivity)((WeakReference)localArrayList.get(paramInt2)).get();
      if ((localObject != null) && (!((QQStoryBaseActivity)localObject).isFinishing()))
      {
        ((QQStoryBaseActivity)localObject).finish();
        localObject = ((QQStoryBaseActivity)localObject).getActivityName() + "_" + localObject.hashCode();
        this.fi.remove(localObject);
        if (this.fI != null) {
          this.fI.remove(localObject);
        }
      }
      paramInt2 -= 1;
    }
  }
  
  public void onDestroy()
  {
    this.fi.clear();
    if (this.fI != null) {
      this.fI.clear();
    }
    this.aBw = false;
  }
  
  public void onInit() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pso
 * JD-Core Version:    0.7.0.1
 */