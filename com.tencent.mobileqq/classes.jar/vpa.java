import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.TMG.utils.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vpa
  implements View.OnClickListener
{
  vpa(vow paramvow, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      if (vvw.a()) {
        break label33;
      }
      vvw.a(this.jdField_a_of_type_AndroidContentContext, 3);
    }
    label33:
    vba localvba;
    boolean bool;
    label61:
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localvba = vow.a(this.jdField_a_of_type_Vow);
      StringBuilder localStringBuilder = new StringBuilder().append("startReply getFeedCommentInfo is");
      if (localvba == null) {
        break;
      }
      bool = true;
      QLog.d("QCircleReplyMessagePresenter", 1, bool);
    } while (localvba == null);
    if (this.jdField_a_of_type_Vow.a == 1) {
      vow.a(this.jdField_a_of_type_Vow, localvba, 6);
    }
    for (;;)
    {
      vvz.a().a((Activity)this.jdField_a_of_type_AndroidContentContext, localvba, vow.a(this.jdField_a_of_type_Vow), vow.a(this.jdField_a_of_type_Vow));
      vow.a(this.jdField_a_of_type_Vow, paramView);
      break;
      bool = false;
      break label61;
      if (this.jdField_a_of_type_Vow.a == 2) {
        vow.a(this.jdField_a_of_type_Vow, localvba, 10);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vpa
 * JD-Core Version:    0.7.0.1
 */