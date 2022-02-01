import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenContainer;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoInnerStatusListener;

class arlk
  implements arlf
{
  arlk(arlj paramarlj) {}
  
  public void TZ(boolean paramBoolean)
  {
    if ((this.this$0.b != null) && (this.this$0.b.getVisibility() != 0))
    {
      this.this$0.a(true, new View[] { this.this$0.b });
      if ((paramBoolean) && (arlj.a(this.this$0) != null) && (arlj.a(this.this$0) == 0))
      {
        arlj.a(this.this$0).notifyVideoStart();
        this.this$0.a(false, new View[] { arlj.a(this.this$0) });
      }
    }
    else
    {
      return;
    }
    if ((arlj.a(this.this$0) != null) && (arlj.a(this.this$0).getVisibility() == 0))
    {
      this.this$0.a(false, new View[] { arlj.a(this.this$0) });
      return;
    }
    this.this$0.a(true, new View[] { arlj.a(this.this$0) });
    arlj.a(this.this$0, 1);
  }
  
  public void ccz()
  {
    this.this$0.Ze(5);
  }
  
  public void ekb()
  {
    if (arlj.a(this.this$0) != null)
    {
      arlj.a(this.this$0).notifyVideoStop();
      arlj.a(this.this$0, 1);
    }
    this.this$0.a(true, new View[] { arlj.a(this.this$0) });
  }
  
  public void ekc()
  {
    if (arlj.a(this.this$0) != null) {
      arlj.a(this.this$0).notifyVideoStop();
    }
    this.this$0.a(true, new View[] { arlj.a(this.this$0) });
    this.this$0.a(false, new View[] { this.this$0.b });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arlk
 * JD-Core Version:    0.7.0.1
 */