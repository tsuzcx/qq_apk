import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ucj
  implements ttw
{
  public ucj(ViolaBaseView paramViolaBaseView, String paramString1, String paramString2, ucm paramucm) {}
  
  public void a()
  {
    String str1 = nvf.a(this.jdField_a_of_type_JavaLangString);
    str1 = str1 + this.jdField_a_of_type_JavaLangString + File.separator;
    String str2 = nuz.d(this.b);
    if (new File(str1 + str2).exists()) {
      if (QLog.isColorLevel()) {
        QLog.e(ViolaBaseView.a(), 2, "downloadOfflineSuccess js exists [url:" + this.b + "]");
      }
    }
    do
    {
      for (;;)
      {
        str1 = tto.a(this.b);
        if (TextUtils.isEmpty(str1)) {
          break;
        }
        if (this.jdField_a_of_type_Ucm != null) {
          this.jdField_a_of_type_Ucm.a(str1);
        }
        if (QLog.isColorLevel()) {
          QLog.e(ViolaBaseView.a(), 2, "downloadOfflineSuccess and jsSource succ [url:" + this.b + "]");
        }
        return;
        if (QLog.isColorLevel()) {
          QLog.e(ViolaBaseView.a(), 2, "downloadOfflineSuccess js no exists [url:" + this.b + "]");
        }
      }
      if (this.jdField_a_of_type_Ucm != null) {
        this.jdField_a_of_type_Ucm.a();
      }
    } while (!QLog.isColorLevel());
    QLog.e(ViolaBaseView.a(), 2, "downloadOfflineSuccess but js null [url:" + this.b + "]");
  }
  
  public void a(int paramInt) {}
  
  public void b()
  {
    if (this.jdField_a_of_type_Ucm != null) {
      this.jdField_a_of_type_Ucm.a();
    }
    if (QLog.isColorLevel()) {
      QLog.e(ViolaBaseView.a(), 2, "downloadOfflineFailed [url:" + this.b + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ucj
 * JD-Core Version:    0.7.0.1
 */