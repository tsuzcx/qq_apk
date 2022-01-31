import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.troop.file.MoveFileActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;

public class xak
  extends BaseAdapter
  implements bfos
{
  private int jdField_a_of_type_Int;
  private int b;
  
  private xak(MoveFileActivity paramMoveFileActivity) {}
  
  public int getCount()
  {
    return MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity).size();
  }
  
  public Object getItem(int paramInt)
  {
    return MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getLayoutInflater().inflate(2131560335, MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity), false);
      paramView = new xal(null);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131366508));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131366507));
      paramView.b = ((TextView)paramViewGroup.findViewById(2131364182));
      paramViewGroup.setTag(paramView);
    }
    paramView = (xal)paramViewGroup.getTag();
    azpi localazpi = (azpi)MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity).get(paramInt);
    if (localazpi != null)
    {
      if (!MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity, paramInt)) {
        break label162;
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localazpi.c);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843116);
    }
    while (paramInt == MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity))
    {
      paramView.b.setVisibility(0);
      return paramViewGroup;
      label162:
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131706906));
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843118);
    }
    paramView.b.setVisibility(4);
    return paramViewGroup;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramInt3;
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      QLog.e("IphoneTitleBarActivity", 4, "onScrollStateChanged=SCROLL_STATE_IDLE");
      if (this.jdField_a_of_type_Int == this.b - 2)
      {
        if (!MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity)) {
          break label44;
        }
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.a(true);
      }
    }
    label44:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.a(false);
    } while (bakx.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.app, this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity, this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.a) == 0);
    this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xak
 * JD-Core Version:    0.7.0.1
 */