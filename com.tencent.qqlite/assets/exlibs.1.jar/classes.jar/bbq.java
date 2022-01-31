import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.common.util.ImageUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class bbq
  extends Handler
{
  public bbq(QQBrowserActivity paramQQBrowserActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = 1;
    switch (paramMessage.what)
    {
    }
    label84:
    label89:
    do
    {
      Object localObject;
      do
      {
        do
        {
          return;
          j = paramMessage.arg1;
          boolean bool;
          if ((j & 0x1) == 0)
          {
            bool = true;
            this.a.a(bool);
            if ((j & 0x2) != 0) {
              break label84;
            }
          }
          for (;;)
          {
            if (i == 0) {
              break label89;
            }
            QQBrowserActivity.a(this.a).setVisibility(0);
            return;
            bool = false;
            break;
            i = 0;
          }
          QQBrowserActivity.b(this.a).setVisibility(8);
          return;
        } while (this.a.k);
        i = paramMessage.arg1;
        int j = paramMessage.arg2;
        paramMessage = QQBrowserActivity.a(this.a).getBackground();
        if (paramMessage != null)
        {
          localObject = paramMessage.getBounds();
          if ((((Rect)localObject).width() <= 0) || ((((Rect)localObject).height() <= 0) && (j < 20)))
          {
            sendMessageDelayed(obtainMessage(2, i, j + 1), 50L);
            return;
          }
        }
        localObject = QQBrowserActivity.c(this.a).getDrawable();
        if (localObject != null)
        {
          Rect localRect = ((Drawable)localObject).getBounds();
          if ((localRect.width() <= 0) || ((localRect.height() <= 0) && (j < 20)))
          {
            sendMessageDelayed(obtainMessage(2, i, j + 1), 50L);
            return;
          }
        }
        if (paramMessage != null)
        {
          if (!QQBrowserActivity.a(this.a))
          {
            QQBrowserActivity.a(this.a, paramMessage);
            QQBrowserActivity.a(this.a, true);
          }
          paramMessage = ImageUtil.a(paramMessage, i);
          if (paramMessage != null) {
            QQBrowserActivity.b(this.a).setBackgroundDrawable(paramMessage);
          }
        }
      } while (localObject == null);
      if (!QQBrowserActivity.b(this.a))
      {
        QQBrowserActivity.b(this.a, (Drawable)localObject);
        QQBrowserActivity.b(this.a, true);
      }
      paramMessage = ImageUtil.a((Drawable)localObject, i);
    } while (paramMessage == null);
    QQBrowserActivity.d(this.a).setImageDrawable(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bbq
 * JD-Core Version:    0.7.0.1
 */