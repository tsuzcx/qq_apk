import android.content.Context;
import android.graphics.Rect;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public abstract class jdl
{
  public VideoAppInterface mApp;
  Context mContext;
  
  protected jdl(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    this.mContext = paramContext;
    this.mApp = paramVideoAppInterface;
    QLog.d("ScreenLayout", 1, "ScreenLayout. onCreate." + this);
  }
  
  public static jdl a(Context paramContext, VideoAppInterface paramVideoAppInterface, int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    switch (paramInt)
    {
    default: 
      paramContext = localObject;
    }
    for (;;)
    {
      return paramContext;
      if (paramBoolean)
      {
        try
        {
          paramContext = new jdr(paramContext, paramVideoAppInterface);
          continue;
        }
        finally {}
      }
      else
      {
        paramContext = new jdo(paramContext, paramVideoAppInterface);
        continue;
        if (paramBoolean)
        {
          paramContext = new jdq(paramContext, paramVideoAppInterface);
        }
        else
        {
          paramContext = new jdm(paramContext, paramVideoAppInterface);
          continue;
          if (paramBoolean)
          {
            paramContext = new jdr(paramContext, paramVideoAppInterface);
          }
          else
          {
            paramContext = new jdn(paramContext, paramVideoAppInterface);
            continue;
            if (paramBoolean) {
              paramContext = new jdr(paramContext, paramVideoAppInterface);
            } else {
              paramContext = new jdp(paramContext, paramVideoAppInterface);
            }
          }
        }
      }
    }
  }
  
  public void a(int paramInt, Rect paramRect1, Rect paramRect2, ConcurrentHashMap<Long, jfj> paramConcurrentHashMap) {}
  
  public void a(iiv paramiiv, izm[] paramArrayOfizm, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4) {}
  
  public void a(izm[] paramArrayOfizm, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void a(izm[] paramArrayOfizm, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {}
  
  public abstract int getStyle();
  
  public void onDestroy()
  {
    QLog.d("ScreenLayout", 1, "ScreenLayout. onDestroy." + this);
    this.mContext = null;
  }
  
  public boolean vX()
  {
    return getStyle() == 2;
  }
  
  public abstract boolean wD();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jdl
 * JD-Core Version:    0.7.0.1
 */