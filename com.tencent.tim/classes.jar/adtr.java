import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class adtr
{
  private WeakReference<QQAppInterface> gj;
  private HashMap<String, adts> jI = new HashMap();
  
  public adtr(QQAppInterface paramQQAppInterface)
  {
    this.gj = new WeakReference(paramQQAppInterface);
  }
  
  public adts a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ArkApp.ArkMessagePreprocessorMgr", 2, "AAShare.getPreprocessor in valid param");
      }
      return null;
    }
    synchronized (this.jI)
    {
      paramString = (adts)this.jI.get(paramString);
      return paramString;
    }
  }
  
  public void a(String paramString, adts paramadts)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramadts == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ArkApp.ArkMessagePreprocessorMgr", 2, "AAShare.setPreprocessor in valid param");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ArkApp.ArkMessagePreprocessorMgr", 2, new Object[] { "AAShare.setPreprocessor app=", paramString });
    }
    synchronized (this.jI)
    {
      this.jI.put(paramString, paramadts);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adtr
 * JD-Core Version:    0.7.0.1
 */