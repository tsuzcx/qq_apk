import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.beauty.QavBeautyMenuPanel;
import com.tencent.mobileqq.utils.AudioHelper;

public class jdc
  implements jct
{
  public jdc(QavPanel paramQavPanel) {}
  
  public void e(View paramView1, View paramView2)
  {
    if (this.this$0.cd != null) {
      this.this$0.cd.onClick(paramView2);
    }
  }
  
  public void y(View paramView, int paramInt)
  {
    paramView = this.this$0.a(paramInt);
    if ((paramView instanceof QavBeautyMenuPanel)) {
      ((QavBeautyMenuPanel)paramView).refreshUI();
    }
    long l = AudioHelper.hG();
    this.this$0.c(l, paramInt, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jdc
 * JD-Core Version:    0.7.0.1
 */