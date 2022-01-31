import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.av.gaudio.GAudioNotifyCenter;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.VideoItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class egp
  implements ActionSheet.OnButtonClickListener
{
  public egp(VideoItemBuilder paramVideoItemBuilder, ActionSheet paramActionSheet, boolean paramBoolean, MessageForVideo paramMessageForVideo) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    switch (paramInt)
    {
    }
    long l;
    do
    {
      do
      {
        return;
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        ChatActivityUtils.a(VideoItemBuilder.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder), (Activity)VideoItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder), VideoItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder).jdField_a_of_type_JavaLangString, true, true, null);
      } while (VideoItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder).jdField_a_of_type_Int != 3000);
      l = Long.valueOf(VideoItemBuilder.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder).jdField_a_of_type_JavaLangString).longValue();
    } while (VideoItemBuilder.e(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder).a().a() == l);
    ReportController.b(VideoItemBuilder.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder), "CliOper", "", "", "Multi_call", "Multi_call_disobj_launch", 0, 0, "", "", "", "");
    return;
    String str1;
    String str2;
    label235:
    QQAppInterface localQQAppInterface;
    label308:
    Context localContext;
    if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForVideo.isVideo)
    {
      str1 = "Two_call";
      str2 = "Two_call_launch";
      switch (VideoItemBuilder.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder).jdField_a_of_type_Int)
      {
      default: 
        paramView = "0";
        ReportController.b(VideoItemBuilder.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder), "CliOper", "", "", str1, str2, 0, 0, paramView, "", "", "");
        paramInt = VideoItemBuilder.e(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder).jdField_a_of_type_Int;
        str2 = VideoItemBuilder.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder).d;
        if (paramInt == 1006)
        {
          paramView = VideoItemBuilder.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder).jdField_a_of_type_JavaLangString;
          str1 = null;
          if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForVideo.type == 2) {
            ReportController.b(VideoItemBuilder.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder), "CliOper", "", "", "0X8004009", "", 0, 0, "2", "", "", "");
          }
          if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForVideo.type == 0) {
            ReportController.b(VideoItemBuilder.i(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder), "CliOper", "", "", "0X800400A", "", 0, 0, "2", "", "", "");
          }
          localQQAppInterface = VideoItemBuilder.j(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder);
          localContext = VideoItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder);
          if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForVideo.isVideo) {
            break label510;
          }
        }
        break;
      }
    }
    label510:
    for (boolean bool = true;; bool = false)
    {
      ChatActivityUtils.a(localQQAppInterface, localContext, paramInt, str1, str2, paramView, bool, VideoItemBuilder.i(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder).b, true, true, null, "from_internal");
      return;
      str1 = "Two_video_call";
      str2 = "Two_video_call_launch";
      break;
      paramView = "0";
      break label235;
      paramView = "1";
      break label235;
      paramView = "2";
      break label235;
      paramView = "3";
      break label235;
      paramView = "4";
      break label235;
      str1 = VideoItemBuilder.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder).jdField_a_of_type_JavaLangString;
      paramView = null;
      break label308;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     egp
 * JD-Core Version:    0.7.0.1
 */