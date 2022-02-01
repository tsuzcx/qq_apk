import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.FilePreviewActivity.a;

public class atsz
  extends attt
{
  String TAG = "DiscOfflinePreviewController<FileAssistant>";
  QQAppInterface app;
  String bHG;
  String bHH;
  atsn d = null;
  
  public atsz(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
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
      QLog.e(this.TAG, 1, " init OfflinePreviewController error,uuid is null,stack:" + audx.ti());
      if (this.a != null) {
        this.a.a(false, "", "", -100005L, "", "", null, this.bHG);
      }
      return false;
    }
    this.app.a().fB(this.bHH, this.bHG);
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
    this.d = new atta(this);
    this.app.a().addObserver(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atsz
 * JD-Core Version:    0.7.0.1
 */