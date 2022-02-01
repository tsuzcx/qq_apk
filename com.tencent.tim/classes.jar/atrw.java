import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.tim.filemanager.activity.recentfile.QfileBaseRecentFileTabView;

public class atrw
  implements View.OnLongClickListener
{
  public atrw(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseRecentFileTabView.a(this.this$0))) {
      return false;
    }
    paramView.setSelected(true);
    aqoa localaqoa = new aqoa();
    localaqoa.Z(2131365679, paramView.getContext().getString(2131692505), 2130839081);
    this.this$0.k = aqgq.a(paramView, localaqoa, new atrx(this, paramView), new atrz(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atrw
 * JD-Core Version:    0.7.0.1
 */