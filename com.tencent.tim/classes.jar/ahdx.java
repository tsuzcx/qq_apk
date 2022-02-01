import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;

public class ahdx
  implements ausj.b
{
  public ahdx(SendBottomBar paramSendBottomBar) {}
  
  public void OnClick(View paramView, int paramInt, String paramString)
  {
    if (paramString.equals(acfp.m(2131714259)))
    {
      paramView = ahav.a("排序方式:\n时间", acfp.m(2131714268), null);
      SendBottomBar.a(this.this$0).setText(paramView);
      if (SendBottomBar.a(this.this$0).eA() == 0) {
        return;
      }
      SendBottomBar.a(this.this$0).setSortType(0);
    }
    for (;;)
    {
      this.this$0.ah.dismiss();
      return;
      if (paramString.equals(acfp.m(2131714288)))
      {
        paramView = ahav.a("排序方式:\n大小", acfp.m(2131714262), null);
        SendBottomBar.a(this.this$0).setText(paramView);
        if (SendBottomBar.a(this.this$0).eA() == 1) {
          break;
        }
        SendBottomBar.a(this.this$0).setSortType(1);
        continue;
      }
      if (paramString.equals(acfp.m(2131714261)))
      {
        paramView = ahav.a("排序方式:\n类型", acfp.m(2131714284), null);
        SendBottomBar.a(this.this$0).setText(paramView);
        if (SendBottomBar.a(this.this$0).eA() == 2) {
          break;
        }
        SendBottomBar.a(this.this$0).setSortType(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahdx
 * JD-Core Version:    0.7.0.1
 */