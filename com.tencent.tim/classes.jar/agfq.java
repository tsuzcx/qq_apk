import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;

public class agfq
  implements View.OnLongClickListener
{
  public agfq(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseLocalFileTabView.a(this.this$0))) {
      return false;
    }
    paramView.setSelected(true);
    aqoa localaqoa = new aqoa();
    localaqoa.dV(2131367525, paramView.getContext().getString(2131721067));
    localaqoa.dV(2131365679, paramView.getContext().getString(2131692505));
    this.this$0.k = aqgq.a(paramView, localaqoa, new agfr(this, paramView), new agft(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agfq
 * JD-Core Version:    0.7.0.1
 */