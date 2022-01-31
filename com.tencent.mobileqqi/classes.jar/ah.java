import android.view.View;
import com.dataline.activities.LiteActivity;
import com.dataline.util.DatalineSessionAdapter.ItemHolder;
import com.dataline.util.DatalineSessionAdapter.ItemHolder.TextItemHolder;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;
import java.util.Iterator;

public class ah
  implements ActionSheet.OnButtonClickListener
{
  public ah(LiteActivity paramLiteActivity, DataLineMsgSet paramDataLineMsgSet, DatalineSessionAdapter.ItemHolder paramItemHolder, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -1000)
      {
        paramView = this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter$ItemHolder.a().jdField_a_of_type_JavaLangString;
        LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, paramView, this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter$ItemHolder.a().jdField_a_of_type_Long, -1);
      }
      else
      {
        DataLineMsgRecord localDataLineMsgRecord;
        if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2000)
        {
          this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.setPaused(false);
          paramView = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().iterator();
          while (paramView.hasNext())
          {
            localDataLineMsgRecord = (DataLineMsgRecord)paramView.next();
            if (DataLineMsgSet.isCanReciveOrResend(localDataLineMsgRecord)) {
              LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, localDataLineMsgRecord.path, localDataLineMsgRecord.sessionid, 0);
            }
          }
        }
        else if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2005) || (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2333))
        {
          this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.setPaused(false);
          paramView = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().iterator();
          while (paramView.hasNext())
          {
            localDataLineMsgRecord = (DataLineMsgRecord)paramView.next();
            if (DataLineMsgSet.isCanReciveOrResend(localDataLineMsgRecord)) {
              LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, localDataLineMsgRecord.path, localDataLineMsgRecord.sessionid, 2);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ah
 * JD-Core Version:    0.7.0.1
 */