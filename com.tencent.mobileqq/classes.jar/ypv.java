import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.transfile.StoryUploadProcessor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ypv
  implements View.OnClickListener
{
  protected long a;
  protected View a;
  public ypw a;
  
  public ypv(ypw paramypw, View paramView)
  {
    this.jdField_a_of_type_Ypw = paramypw;
    this.jdField_a_of_type_AndroidViewView = paramView;
    paramView.setOnClickListener(this);
  }
  
  private boolean a()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.jdField_a_of_type_Long;
    if ((l2 > 0L) && (l2 < 2000L)) {
      return true;
    }
    this.jdField_a_of_type_Long = l1;
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (!a())
    {
      ykv.a("home_page", "clk_shoot", 0, 0, new String[0]);
      this.jdField_a_of_type_Ypw.a();
    }
    StoryUploadProcessor.checkUploadSessionKey();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ypv
 * JD-Core Version:    0.7.0.1
 */