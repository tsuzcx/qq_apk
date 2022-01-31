import android.app.Activity;
import android.view.View;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.VideoActionSheet;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.VideoItemBuilder;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class vlo
  implements ActionSheet.OnButtonClickListener
{
  public vlo(VideoItemBuilder paramVideoItemBuilder, VideoActionSheet paramVideoActionSheet, MessageForVideo paramMessageForVideo, int paramInt) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvUtilsVideoActionSheet.dismiss();
    switch (paramInt)
    {
    }
    do
    {
      return;
      VideoItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder, true, this.jdField_a_of_type_ComTencentMobileqqDataMessageForVideo);
      return;
      if (this.jdField_a_of_type_Int == 0)
      {
        VideoItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder, true, this.jdField_a_of_type_ComTencentMobileqqDataMessageForVideo);
        return;
      }
      if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4))
      {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, true, true, null, null, 1, 0);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006407", "0X8006407", 3, 0, "", "", "", "");
        return;
      }
    } while (this.jdField_a_of_type_Int != 5);
    PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder.jdField_a_of_type_AndroidContentContext, 2, 9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vlo
 * JD-Core Version:    0.7.0.1
 */