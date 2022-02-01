import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;

public class ageb
  implements View.OnLongClickListener
{
  public ageb(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseCloudFileTabView.b(this.this$0))) {
      return false;
    }
    paramView.setSelected(true);
    aqoa localaqoa = new aqoa();
    localaqoa.dV(2131365679, paramView.getContext().getString(2131692505));
    this.this$0.k = aqgq.a(paramView, localaqoa, new agec(this, paramView), new aged(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ageb
 * JD-Core Version:    0.7.0.1
 */