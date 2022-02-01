import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.FilePreviewActivity.a;

public class atub
  extends attt
{
  String TAG = "OfflinePreviewController<FileAssistant>";
  QQAppInterface app;
  String bHG;
  atsn d = null;
  
  public atub(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.app = paramQQAppInterface;
    this.bHG = paramString;
    if (TextUtils.isEmpty(paramString)) {
      QLog.e(this.TAG, 1, " init OfflinePreviewController error,uuid is null,stack:" + audx.ti());
    }
    ix();
  }
  
  public int Em()
  {
    return 1;
  }
  
  public boolean alr()
  {
    if (TextUtils.isEmpty(this.bHG))
    {
      QLog.e(this.TAG, 1, " init OfflinePreviewController error,uuid is null,stack:" + audx.ti());
      if (this.a != null) {
        this.a.a(false, "", "", -100005L, "", "", null, this.bHG);
      }
      return false;
    }
    this.app.a().YY(this.bHG);
    return true;
  }
  
  public void clear()
  {
    if (this.d != null) {
      this.app.a().deleteObserver(this.d);
    }
  }
  
  public void ix()
  {
    this.d = new atuc(this);
    this.app.a().addObserver(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atub
 * JD-Core Version:    0.7.0.1
 */