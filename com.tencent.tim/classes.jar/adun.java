import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.LruCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class adun
  extends Handler
{
  adun(aduk paramaduk, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1001) {
      for (;;)
      {
        try
        {
          paramMessage = (ArrayList)paramMessage.obj;
          if ((paramMessage == null) || (paramMessage.size() <= 0)) {
            continue;
          }
          Iterator localIterator = paramMessage.iterator();
          if (!localIterator.hasNext()) {
            continue;
          }
          str1 = (String)localIterator.next();
          str2 = (String)this.g.q.get(str1);
          paramMessage = BitmapFactory.decodeFile(str2);
          if (paramMessage == null) {
            continue;
          }
          if (aduk.a(this.g) != 1) {
            continue;
          }
          localObject1 = QQAppInterface.b(paramMessage, aqhu.ka(paramMessage.getWidth()), 50, 50);
          paramMessage = (Message)localObject1;
          if (auvj.isNightMode())
          {
            paramMessage = new Paint();
            paramMessage.setAntiAlias(true);
            paramMessage.setColor(ThemeUtil.NIGHTMODE_MASKCOLOR);
            localObject2 = new Canvas((Bitmap)localObject1);
            ((Canvas)localObject2).drawRoundRect(new RectF(0.0F, 0.0F, ((Canvas)localObject2).getWidth(), ((Canvas)localObject2).getHeight()), aqhu.dZk, aqhu.dZk, paramMessage);
            paramMessage = (Message)localObject1;
          }
        }
        catch (OutOfMemoryError paramMessage)
        {
          String str1;
          String str2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("NonMainAppHeadLoader", 2, "decodeFile, OutOfMemoryError");
          return;
          Object localObject1 = this.g.B(paramMessage);
          paramMessage = (Message)localObject1;
          if (!auvj.isNightMode()) {
            continue;
          }
          paramMessage = new Paint();
          paramMessage.setAntiAlias(true);
          paramMessage.setColor(ThemeUtil.NIGHTMODE_MASKCOLOR);
          Object localObject2 = new Canvas((Bitmap)localObject1);
          ((Canvas)localObject2).drawCircle(((Canvas)localObject2).getWidth() / 2, ((Canvas)localObject2).getHeight() / 2, ((Canvas)localObject2).getWidth() / 2, paramMessage);
          paramMessage = (Message)localObject1;
          continue;
        }
        catch (Exception paramMessage)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("NonMainAppHeadLoader", 2, "decodeFile, exception:" + paramMessage.toString());
        }
        if (paramMessage != null)
        {
          localObject1 = Message.obtain();
          localObject2 = new Bundle();
          ((Bundle)localObject2).putParcelable("bmp", paramMessage);
          ((Bundle)localObject2).putString("uin", str1);
          ((Bundle)localObject2).putString("path", str2);
          ((Message)localObject1).obj = localObject2;
          ((Message)localObject1).what = 1002;
          this.g.mUIHandler.sendMessage((Message)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("NonMainAppHeadLoader", 2, "decodeFile, uin:" + str1);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adun
 * JD-Core Version:    0.7.0.1
 */