import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.tim.filemanager.activity.LocalFileBrowserActivity;

public class atov
  implements View.OnLongClickListener
{
  public atov(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
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
    localaqoa.Z(2131365679, paramView.getContext().getString(2131692505), 2130839081);
    this.this$0.k = aqgq.a(paramView, localaqoa, new atow(this, paramView), new atox(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atov
 * JD-Core Version:    0.7.0.1
 */