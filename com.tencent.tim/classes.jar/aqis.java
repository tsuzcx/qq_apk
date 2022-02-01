import android.text.TextUtils;
import com.tencent.mobileqq.widget.MessageProgressView.RefreshProgressRunnable;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class aqis
{
  public ConcurrentHashMap<String, MessageProgressView.RefreshProgressRunnable> iY = new ConcurrentHashMap();
  
  public static final aqis a()
  {
    return aqis.a.b();
  }
  
  public void UK(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      MessageProgressView.RefreshProgressRunnable localRefreshProgressRunnable = (MessageProgressView.RefreshProgressRunnable)this.iY.get(paramString);
      if (localRefreshProgressRunnable != null) {
        localRefreshProgressRunnable.stop();
      }
    }
    try
    {
      this.iY.remove(paramString);
      if (QLog.isColorLevel()) {
        QLog.e("MessageProgressView", 2, " aflter removeAnimRunnable size=" + this.iY.size());
      }
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MessageProgressView", 2, "removeAnimRunnable exception = " + paramString.getMessage());
        }
      }
    }
  }
  
  public MessageProgressView.RefreshProgressRunnable a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (this.iY.isEmpty()) {
      return null;
    }
    return (MessageProgressView.RefreshProgressRunnable)this.iY.get(paramString);
  }
  
  public void a(String paramString, MessageProgressView.RefreshProgressRunnable paramRefreshProgressRunnable)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.iY.put(paramString, paramRefreshProgressRunnable);
    }
  }
  
  public void edT()
  {
    Iterator localIterator = this.iY.keySet().iterator();
    while (localIterator.hasNext()) {
      UK((String)localIterator.next());
    }
  }
  
  static class a
  {
    private static final aqis a = new aqis(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqis
 * JD-Core Version:    0.7.0.1
 */