package cooperation.comic.ui;

import android.view.View;
import aveg;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.redtouch.RedTouchUI;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

class QQComicTabBarView$7$1
  implements Runnable
{
  QQComicTabBarView$7$1(QQComicTabBarView.7 param7, ArrayList paramArrayList, boolean paramBoolean, Map paramMap) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewTabBarView", 2, "start show red touch");
    }
    int i = this.a.this$0.qt();
    if ((i >= 0) && (i < QQComicTabBarView.a(this.a.this$0)))
    {
      localObject = QQComicTabBarView.a(this.a.this$0, i).getTag(-3);
      if (!(localObject instanceof QQComicTabBarView.b)) {}
    }
    for (Object localObject = ((QQComicTabBarView.b)localObject).a;; localObject = null)
    {
      Iterator localIterator = this.Ca.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (this.dmK) {}
        for (RedTouchUI localRedTouchUI = (RedTouchUI)this.a.this$0.a.get(str);; localRedTouchUI = (RedTouchUI)this.a.this$0.a.get(this.a.this$0.b.h(str)))
        {
          if ((localRedTouchUI == null) || (localRedTouchUI.equals(localObject))) {
            break label208;
          }
          this.a.this$0.a(localRedTouchUI, (RedAppInfo)this.val$map.get(str), false);
          break;
        }
        label208:
        if (QLog.isColorLevel()) {
          QLog.d("WebViewTabBarView", 2, "cannot find red touch on path: " + str);
        }
      }
      this.a.this$0.ezE();
      if (QLog.isColorLevel()) {
        QLog.d("WebViewTabBarView", 2, "end show red touch");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.comic.ui.QQComicTabBarView.7.1
 * JD-Core Version:    0.7.0.1
 */