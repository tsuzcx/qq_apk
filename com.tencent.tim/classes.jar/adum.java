import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.LruCache;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class adum
  extends Handler
{
  adum(aduk paramaduk, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1000) {
      if (this.g.uL.size() > 0)
      {
        paramMessage = new ArrayList(this.g.uL.size());
        paramMessage.addAll(this.g.uL);
        this.g.dX(paramMessage);
      }
    }
    Object localObject;
    String str;
    do
    {
      this.g.uL.removeAll(paramMessage);
      for (;;)
      {
        return;
        if (paramMessage.what == 1002) {
          try
          {
            localObject = (Bundle)paramMessage.obj;
            paramMessage = (Bitmap)((Bundle)localObject).getParcelable("bmp");
            str = ((Bundle)localObject).getString("uin");
            localObject = ((Bundle)localObject).getString("path");
            if (paramMessage != null) {
              this.g.p.put(str, paramMessage);
            }
            Iterator localIterator = this.g.yr.iterator();
            while (localIterator.hasNext())
            {
              aduk.a locala = (aduk.a)localIterator.next();
              if (locala != null) {
                locala.b(str, (String)localObject, paramMessage);
              }
            }
            if (!QLog.isColorLevel()) {}
          }
          catch (Exception paramMessage) {}
        }
      }
      QLog.e("NonMainAppHeadLoader", 2, "refreshImg, exception:" + paramMessage.toString());
      return;
    } while (!QLog.isColorLevel());
    QLog.d("NonMainAppHeadLoader", 2, "refreshImg, uin:" + str + ", path=" + (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adum
 * JD-Core Version:    0.7.0.1
 */