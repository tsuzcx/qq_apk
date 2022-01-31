import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.Scroller;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.DrawerFrame.IDrawerCallbacks;

public class eop
  extends Handler
{
  public eop(DrawerFrame paramDrawerFrame) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
        boolean bool = DrawerFrame.a(this.a).computeScrollOffset();
        if (DrawerFrame.a(this.a) != null)
        {
          DrawerFrame.a(this.a).offsetLeftAndRight(DrawerFrame.a(this.a).getCurrX() - DrawerFrame.a(this.a));
          this.a.a(DrawerFrame.a(this.a));
        }
        DrawerFrame.a(this.a, DrawerFrame.a(this.a).getCurrX());
        this.a.postInvalidate();
        if (!bool)
        {
          DrawerFrame.a(this.a, false);
          DrawerFrame.b(this.a, true);
          DrawerFrame.a(this.a).sendEmptyMessage(3);
          return;
        }
        DrawerFrame.a(this.a).sendEmptyMessage(1);
        return;
        bool = DrawerFrame.a(this.a).computeScrollOffset();
        if (DrawerFrame.a(this.a) != null)
        {
          DrawerFrame.a(this.a).offsetLeftAndRight(DrawerFrame.a(this.a).getCurrX() - DrawerFrame.a(this.a));
          this.a.a(DrawerFrame.a(this.a));
        }
        DrawerFrame.a(this.a, DrawerFrame.a(this.a).getCurrX());
        this.a.postInvalidate();
        if (!bool)
        {
          DrawerFrame.a(this.a, false);
          DrawerFrame.b(this.a, false);
          if (DrawerFrame.b(this.a) != null) {
            DrawerFrame.b(this.a).setVisibility(4);
          }
          DrawerFrame.a(this.a).sendEmptyMessage(4);
          return;
        }
        DrawerFrame.a(this.a).sendEmptyMessage(2);
        return;
      } while (DrawerFrame.a(this.a));
      if (DrawerFrame.a(this.a) != null) {
        DrawerFrame.a(this.a).b(DrawerFrame.b(this.a));
      }
      DrawerFrame.b(this.a, 0);
      this.a.b(1);
      return;
    } while (DrawerFrame.a(this.a));
    if (DrawerFrame.a(this.a) != null) {
      DrawerFrame.a(this.a).a(DrawerFrame.b(this.a));
    }
    DrawerFrame.b(this.a, 0);
    this.a.b(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eop
 * JD-Core Version:    0.7.0.1
 */