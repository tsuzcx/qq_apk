import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mobileqq.activity.ScoreQAVFragment;
import com.tencent.mobileqq.activity.ScoreQAVFragment.OnItemClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;
import mqq.app.MobileQQ;

public class tob
  extends RecyclerView.Adapter
{
  ScoreQAVFragment.OnItemClickListener jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment$OnItemClickListener;
  
  public tob(ScoreQAVFragment paramScoreQAVFragment) {}
  
  public toc a(ViewGroup paramViewGroup, int paramInt)
  {
    return new toc(this, LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()).inflate(2130969350, paramViewGroup, false), this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment$OnItemClickListener);
  }
  
  public void a(ScoreQAVFragment.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment$OnItemClickListener = paramOnItemClickListener;
  }
  
  public void a(toc paramtoc, int paramInt)
  {
    paramtoc.a.setText((CharSequence)this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.jdField_a_of_type_JavaUtilList.get(paramInt));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.a(paramInt))
    {
      paramtoc.a.setSelected(true);
      return;
    }
    paramtoc.a.setSelected(false);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tob
 * JD-Core Version:    0.7.0.1
 */