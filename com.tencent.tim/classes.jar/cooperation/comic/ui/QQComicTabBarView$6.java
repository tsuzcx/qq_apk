package cooperation.comic.ui;

import avdl;
import aveb;
import aved;
import com.tencent.qphone.base.util.QLog;

class QQComicTabBarView$6
  implements Runnable
{
  QQComicTabBarView$6(QQComicTabBarView paramQQComicTabBarView) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Aved != null) {
      this.this$0.jdField_a_of_type_Aved.deleteObserver(this.this$0.jdField_a_of_type_Aved$a);
    }
    if (aveb.a != null) {
      aveb.a.b(this.this$0.jdField_a_of_type_Avdk);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebViewTabBarView", 2, "unregister observers");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.comic.ui.QQComicTabBarView.6
 * JD-Core Version:    0.7.0.1
 */