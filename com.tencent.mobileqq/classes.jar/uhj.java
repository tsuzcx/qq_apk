import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.TMG.utils.QLog;

class uhj
  implements View.OnClickListener
{
  uhj(uhf paramuhf, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    trx localtrx;
    boolean bool;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      localtrx = uhf.a(this.jdField_a_of_type_Uhf);
      StringBuilder localStringBuilder = new StringBuilder().append("startReply getFeedCommentInfo is");
      if (localtrx == null) {
        break label97;
      }
      bool = true;
      QLog.d("QCircleReplyMessagePresenter", 1, bool);
      if (localtrx != null)
      {
        if (paramView.getId() != 2131379038) {
          break label102;
        }
        uhf.a(this.jdField_a_of_type_Uhf, localtrx, 2);
      }
    }
    for (;;)
    {
      uax.a().a((Activity)this.jdField_a_of_type_AndroidContentContext, localtrx, uhf.a(this.jdField_a_of_type_Uhf));
      return;
      label97:
      bool = false;
      break;
      label102:
      if (this.jdField_a_of_type_Uhf.a == 1) {
        uhf.a(this.jdField_a_of_type_Uhf, localtrx, 6);
      } else if (this.jdField_a_of_type_Uhf.a == 2) {
        uhf.a(this.jdField_a_of_type_Uhf, localtrx, 10);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uhj
 * JD-Core Version:    0.7.0.1
 */