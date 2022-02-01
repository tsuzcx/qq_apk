import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.BubblePopupWindow.b;

public class asha
  implements View.OnLongClickListener
{
  public BubblePopupWindow a;
  public String cEN = "";
  private View.OnClickListener cp = new ashb(this);
  
  public asha(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    int i = paramView.getId();
    this.cEN = String.valueOf(paramView.getTag());
    aqoa localaqoa = new aqoa();
    localaqoa.dV(i, acfp.m(2131711161));
    this.a = aqgq.a(paramView, localaqoa, this.cp);
    this.a.a(new asha.a());
    return true;
  }
  
  class a
    implements BubblePopupWindow.b
  {
    a() {}
    
    public void onDismiss()
    {
      asha.this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asha
 * JD-Core Version:    0.7.0.1
 */