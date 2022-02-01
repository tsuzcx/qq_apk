import android.text.TextUtils;
import com.tencent.common.app.AppInterface;

public class oee
{
  private acdl b;
  private AppInterface mApp;
  private String message;
  
  public oee(AppInterface paramAppInterface)
  {
    this.mApp = paramAppInterface;
    this.b = new oef(this);
    if (this.mApp != null) {
      this.mApp.addObserver(this.b);
    }
  }
  
  public long M(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    if (this.mApp != null)
    {
      acde localacde = (acde)this.mApp.getBusinessHandler(8);
      if (localacde != null)
      {
        this.message = paramString;
        return localacde.a(paramString, 0).longValue();
      }
    }
    return 0L;
  }
  
  public void onDestroy()
  {
    if (this.mApp != null) {
      this.mApp.removeObserver(this.b);
    }
    this.mApp = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oee
 * JD-Core Version:    0.7.0.1
 */