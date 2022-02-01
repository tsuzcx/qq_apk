import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.adapter.LebaListViewAdapter;
import com.tencent.mobileqq.app.QQAppInterface;

public class eyk
  extends Handler
{
  public eyk(LebaListViewAdapter paramLebaListViewAdapter) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = paramMessage.obj;
        } while (!(localObject instanceof View));
        localObject = (View)localObject;
        switch (paramMessage.arg1)
        {
        default: 
          ((View)localObject).setBackgroundResource(2130837877);
          return;
        case 0: 
          ((View)localObject).setBackgroundResource(2130837877);
          return;
        case 1: 
          ((View)localObject).setBackgroundResource(2130837882);
          return;
        case 2: 
          ((View)localObject).setBackgroundResource(2130837879);
          return;
        }
        ((View)localObject).setBackgroundResource(2130837881);
        return;
        paramMessage = paramMessage.obj;
      } while ((!(paramMessage instanceof ImageView)) || (TextUtils.isEmpty(this.a.c)));
      paramMessage = (ImageView)paramMessage;
      localObject = this.a.a.b(this.a.c);
    } while (localObject == null);
    paramMessage.setImageDrawable((Drawable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eyk
 * JD-Core Version:    0.7.0.1
 */