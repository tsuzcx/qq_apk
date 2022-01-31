import android.view.View;
import com.dataline.activities.LiteActivity;
import com.dataline.util.DatalineSessionAdapter;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.List;

public class aj
  implements ActionSheet.OnButtonClickListener
{
  public aj(LiteActivity paramLiteActivity, DataLineMsgSet paramDataLineMsgSet, List paramList, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      return;
      if (LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity))
      {
        paramView = (DataLineHandler)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.b.a(8);
        this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.setPaused(false);
        if (paramView.a(this.jdField_a_of_type_JavaUtilList)) {
          LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).notifyDataSetChanged();
        } else {
          FMToastUtil.a(2131558544);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     aj
 * JD-Core Version:    0.7.0.1
 */