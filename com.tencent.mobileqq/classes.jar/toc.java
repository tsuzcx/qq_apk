import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.ScoreQAVFragment.OnItemClickListener;
import com.tencent.qphone.base.util.QLog;

class toc
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  Button jdField_a_of_type_AndroidWidgetButton;
  ScoreQAVFragment.OnItemClickListener jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment$OnItemClickListener;
  
  public toc(tob paramtob, View paramView, ScoreQAVFragment.OnItemClickListener paramOnItemClickListener)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment$OnItemClickListener = paramOnItemClickListener;
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131366224));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment$OnItemClickListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment$OnItemClickListener.a(paramView, getPosition());
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ScoreActivity", 2, "mOnItemClickListener is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     toc
 * JD-Core Version:    0.7.0.1
 */