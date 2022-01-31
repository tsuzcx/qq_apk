import android.view.View;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.VideoActionSheet;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.item.VideoItemBuilder;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class vin
  implements ActionSheet.OnButtonClickListener
{
  public vin(VideoItemBuilder paramVideoItemBuilder, VideoActionSheet paramVideoActionSheet, MessageForVideo paramMessageForVideo, int paramInt, PstnSessionInfo paramPstnSessionInfo) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvUtilsVideoActionSheet.dismiss();
    switch (paramInt)
    {
    }
    do
    {
      return;
      VideoItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder, false, this.jdField_a_of_type_ComTencentMobileqqDataMessageForVideo);
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForVideo.isVideo)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005642", "0X8005642", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005243", "0X8005243", 0, 0, "", "", "", "");
      return;
      if (this.jdField_a_of_type_Int == 0)
      {
        VideoItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder, false, this.jdField_a_of_type_ComTencentMobileqqDataMessageForVideo);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005243", "0X8005243", 0, 0, "", "", "", "");
        return;
      }
      if ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2))
      {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppPstnSessionInfo, 0);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006406", "0X8006406", 6, 0, "", "", "", "");
        return;
      }
    } while (this.jdField_a_of_type_Int != 5);
    PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder.jdField_a_of_type_AndroidContentContext, 1, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vin
 * JD-Core Version:    0.7.0.1
 */