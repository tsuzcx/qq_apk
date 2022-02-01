import android.media.MediaFormat;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class rmf
  extends accg
{
  private ConcurrentHashMap<String, LocalMediaInfo> co = new ConcurrentHashMap();
  private MediaFormat mediaFormat;
  
  public rmf(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public void a(String paramString, LocalMediaInfo paramLocalMediaInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowProcessor", 2, "setCatcheMediaInfo path : " + paramString);
    }
    this.co.put(paramString, paramLocalMediaInfo);
  }
  
  public LocalMediaInfo b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (LocalMediaInfo)this.co.get(paramString);
    }
    return null;
  }
  
  public void c(MediaFormat paramMediaFormat)
  {
    this.mediaFormat = paramMediaFormat;
  }
  
  public void clear()
  {
    this.mediaFormat = null;
    this.co.clear();
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowProcessor", 2, "clearCatcheMediaInfo");
    }
  }
  
  public boolean fv(String paramString)
  {
    return this.co.containsKey(paramString);
  }
  
  public MediaFormat getMediaFormat()
  {
    return this.mediaFormat;
  }
  
  protected Class<? extends acci> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void sB(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.co.remove(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rmf
 * JD-Core Version:    0.7.0.1
 */