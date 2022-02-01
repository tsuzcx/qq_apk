import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amsh
  implements View.OnClickListener
{
  amsh(amsf paramamsf, ampx paramampx) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getContext();
    String str = this.jdField_a_of_type_Ampx.getUin();
    if ((localObject instanceof BaseActivity))
    {
      amxk.b("all_result", "clk_result_join", new String[0]);
      localObject = (BaseActivity)localObject;
      amsf.a(this.jdField_a_of_type_Amsf, (Activity)localObject, str);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amsh
 * JD-Core Version:    0.7.0.1
 */