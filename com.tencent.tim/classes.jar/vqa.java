import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.widget.FixedBounceScrollView;

public class vqa
  extends Handler
{
  public vqa(QQSettingMe paramQQSettingMe, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      paramMessage = new Rect();
      localObject = this.this$0.p[4];
      this.this$0.a.offsetDescendantRectToMyCoords((View)localObject, paramMessage);
      localObject = new Rect();
      this.this$0.a.getDrawingRect((Rect)localObject);
      boolean bool = ((Rect)localObject).contains(paramMessage);
      if (!bool) {
        this.this$0.a.scrollTo(this.this$0.a.getScrollX(), paramMessage.top);
      }
      if (bool) {}
      for (long l = 0L;; l = 50L)
      {
        sendEmptyMessageDelayed(1, l);
        return;
      }
    }
    paramMessage = new Rect();
    Object localObject = this.this$0.p[4];
    ((View)localObject).getHitRect(paramMessage);
    localObject = ((View)localObject).findViewById(2131369534);
    paramMessage.offset(((View)localObject).getLeft() + wja.dp2px(34.0F, this.this$0.cV.getResources()), ((View)localObject).getTop() - wja.dp2px(18.0F, this.this$0.cV.getResources()));
    localObject = (FrameLayout.LayoutParams)QQSettingMe.b(this.this$0).getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).leftMargin = paramMessage.left;
    ((FrameLayout.LayoutParams)localObject).topMargin = paramMessage.top;
    QQSettingMe.b(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
    QQSettingMe.b(this.this$0).setPadding(wja.dp2px(6.0F, this.this$0.cV.getResources()), wja.dp2px(4.0F, this.this$0.cV.getResources()), wja.dp2px(6.0F, this.this$0.cV.getResources()), wja.dp2px(8.0F, this.this$0.cV.getResources()));
    QQSettingMe.b(this.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vqa
 * JD-Core Version:    0.7.0.1
 */