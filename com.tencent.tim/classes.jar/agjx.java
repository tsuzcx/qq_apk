import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.a;
import com.tencent.qphone.base.util.QLog;

public class agjx
  extends agku
{
  String TAG = "DiscOfflinePreviewController<FileAssistant>";
  aghq a;
  QQAppInterface app;
  String bHG;
  String bHH;
  
  public agjx(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Aghq = null;
    this.app = paramQQAppInterface;
    this.bHG = paramString1;
    this.bHH = paramString2;
    ix();
  }
  
  public int Em()
  {
    return 2;
  }
  
  public boolean alr()
  {
    if (TextUtils.isEmpty(this.bHG))
    {
      QLog.e(this.TAG, 1, " init OfflinePreviewController error,uuid is null,stack:" + ahav.ti());
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$a != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$a.a(false, "", "", -100005L, "", "", null, this.bHG, null);
      }
      return false;
    }
    this.app.a().fB(this.bHH, this.bHG);
    return true;
  }
  
  public void clear()
  {
    if (this.jdField_a_of_type_Aghq != null) {
      this.app.a().deleteObserver(this.jdField_a_of_type_Aghq);
    }
  }
  
  public void ix()
  {
    this.jdField_a_of_type_Aghq = new agjy(this);
    this.app.a().addObserver(this.jdField_a_of_type_Aghq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agjx
 * JD-Core Version:    0.7.0.1
 */