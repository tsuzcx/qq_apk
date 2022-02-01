import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.widget.SlideDetectListView;

public class agci
  implements View.OnLongClickListener
{
  public agci(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    if (!this.this$0.akH())
    {
      this.this$0.a.bk(null);
      this.this$0.c.eiZ();
      return false;
    }
    paramView.setSelected(true);
    aqoa localaqoa = new aqoa();
    localaqoa.dV(2131365679, paramView.getContext().getString(2131692505));
    this.this$0.k = aqgq.a(paramView, localaqoa, new agcj(this, paramView), new agck(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agci
 * JD-Core Version:    0.7.0.1
 */