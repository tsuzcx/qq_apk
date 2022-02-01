import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.10.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajzx
  implements View.OnClickListener
{
  ajzx(ajzv paramajzv) {}
  
  public void onClick(View paramView)
  {
    this.this$0.hq(paramView);
    new ajxs().h("video").i("playpage_fw_click").a().dy(this.this$0.app);
    ThreadManagerV2.excute(new PlayOperationViewModel.10.1(this, (ajpj)this.this$0.app.getManager(106)), 16, null, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajzx
 * JD-Core Version:    0.7.0.1
 */