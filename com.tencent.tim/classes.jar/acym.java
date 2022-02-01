import com.tencent.ark.open.ArkView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class acym
{
  private List<ArkView> yb = new ArrayList();
  
  public void a(ArkView paramArkView)
  {
    this.yb.add(paramArkView);
  }
  
  public void onDestroy()
  {
    Iterator localIterator = this.yb.iterator();
    while (localIterator.hasNext())
    {
      ArkView localArkView = (ArkView)localIterator.next();
      if (localArkView != null) {
        localArkView.onDestroy();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArkCollector", 2, this.yb.size() + " ArkViews onDestroy");
    }
    this.yb.clear();
  }
  
  public void onPause()
  {
    Iterator localIterator = this.yb.iterator();
    while (localIterator.hasNext())
    {
      ArkView localArkView = (ArkView)localIterator.next();
      if (localArkView != null) {
        localArkView.onPause();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArkCollector", 2, this.yb.size() + " ArkViews onPause");
    }
  }
  
  public void onResume()
  {
    Iterator localIterator = this.yb.iterator();
    while (localIterator.hasNext())
    {
      ArkView localArkView = (ArkView)localIterator.next();
      if (localArkView != null) {
        localArkView.onResume();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArkCollector", 2, this.yb.size() + " ArkViews onResume");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acym
 * JD-Core Version:    0.7.0.1
 */