import android.text.TextUtils.EllipsizeCallback;
import android.widget.TextView;
import com.tencent.biz.troop.file.MoveFileActivity;

public class xad
  implements TextUtils.EllipsizeCallback
{
  public xad(MoveFileActivity paramMoveFileActivity, TextView paramTextView) {}
  
  public void ellipsized(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity));
      return;
    }
    String str1 = MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity).substring(0, paramInt1);
    String str2 = MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity).substring(paramInt2, MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity).length());
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str1 + "..." + str2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xad
 * JD-Core Version:    0.7.0.1
 */