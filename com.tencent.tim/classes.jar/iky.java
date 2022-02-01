import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;

public class iky
  extends iku
{
  boolean RZ = false;
  int aop = -1;
  int aoq = -1;
  
  public iky(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  public int an(String paramString)
  {
    int j = 0;
    int i;
    if ("750".equalsIgnoreCase(paramString)) {
      i = this.aop;
    }
    for (;;)
    {
      igd.aJ("SupportZimu", "isSupportPeer:" + paramString + "|" + i);
      return i;
      if ("735".equalsIgnoreCase(paramString))
      {
        i = this.aoq;
      }
      else
      {
        i = j;
        if ("live".equalsIgnoreCase(paramString))
        {
          i = j;
          if (this.RZ) {
            i = 1;
          }
        }
      }
    }
  }
  
  public void anD()
  {
    VideoController localVideoController = this.mApp.b();
    localVideoController.d(12, "SUPPORT_TRUE");
    localVideoController.d(13, "SUPPORT_TRUE");
    igd.aJ("SupportZimu", "sendSupportMsg");
  }
  
  public boolean ct(String paramString)
  {
    return false;
  }
  
  public boolean e(int paramInt, String paramString)
  {
    igd.aJ("SupportZimu", "onReceiveSupportMessage type:" + paramInt + "|" + paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      String[] arrayOfString = paramString.split("\\|");
      paramString = null;
      if (arrayOfString.length > 0) {
        paramString = arrayOfString[0];
      }
      switch (paramInt)
      {
      }
      while (("SUPPORT_TRUE".equalsIgnoreCase(paramString)) || ("SUPPORT_FALSE".equalsIgnoreCase(paramString)))
      {
        return true;
        if ("SUPPORT_TRUE".equalsIgnoreCase(paramString))
        {
          this.aop = 1;
        }
        else if ("SUPPORT_FALSE".equalsIgnoreCase(paramString))
        {
          this.aop = 0;
          continue;
          if ("SUPPORT_TRUE".equalsIgnoreCase(paramString))
          {
            this.aoq = 1;
          }
          else if ("SUPPORT_FALSE".equalsIgnoreCase(paramString))
          {
            this.aoq = 0;
            continue;
            if ("SUPPORT_TRUE".equalsIgnoreCase(paramString)) {
              this.RZ = true;
            } else if ("SUPPORT_FALSE".equalsIgnoreCase(paramString)) {
              this.RZ = false;
            }
          }
        }
      }
    }
    return false;
  }
  
  public void restore()
  {
    this.aop = -1;
    this.aoq = -1;
    this.RZ = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iky
 * JD-Core Version:    0.7.0.1
 */