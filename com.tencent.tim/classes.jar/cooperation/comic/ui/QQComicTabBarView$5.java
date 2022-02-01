package cooperation.comic.ui;

import avdl;
import aveb;
import aved;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class QQComicTabBarView$5
  implements Runnable
{
  QQComicTabBarView$5(QQComicTabBarView paramQQComicTabBarView) {}
  
  public void run()
  {
    this.this$0.mApp = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    this.this$0.jdField_a_of_type_Aved = ((aved)this.this$0.mApp.getManager(213));
    if (this.this$0.jdField_a_of_type_Aved != null) {
      this.this$0.jdField_a_of_type_Aved.addObserver(this.this$0.jdField_a_of_type_Aved$a);
    }
    if (aveb.a != null) {
      aveb.a.a(this.this$0.jdField_a_of_type_Avdk);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebViewTabBarView", 2, "register observers");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.comic.ui.QQComicTabBarView.5
 * JD-Core Version:    0.7.0.1
 */