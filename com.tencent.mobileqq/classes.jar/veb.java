import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.QzoneFeedItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.util.URLUtil;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class veb
  implements View.OnClickListener
{
  public veb(QzoneFeedItemBuilder paramQzoneFeedItemBuilder, MessageForQzoneFeed paramMessageForQzoneFeed) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl = QzoneFeedItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl);
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl)) {
      return;
    }
    Map localMap = URLUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl);
    Object localObject = null;
    if (localMap != null) {
      localObject = (String)localMap.get("g");
    }
    if (("110".equals(localObject)) || ("279".equals(localObject)) || ("318".equals(localObject)))
    {
      paramView = paramView.getContext();
      localObject = QZoneHelper.UserInfo.a();
      ((QZoneHelper.UserInfo)localObject).a = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder.a.getCurrentAccountUin();
      ((QZoneHelper.UserInfo)localObject).b = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder.a.getCurrentNickname();
      QZoneHelper.a((Activity)paramView, (QZoneHelper.UserInfo)localObject, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl, "mqqChat.QzoneCard", this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.appId, -1);
      paramView = new QZoneClickReport.ReportInfo();
      paramView.c = "1";
      paramView.d = "0";
      paramView.b = 4;
      paramView.k = "3";
      paramView.l = "AIO";
      paramView.m = "detailPage";
      QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder.a.getAccount(), paramView);
      paramView = new HashMap();
      paramView.put("source_type", "3");
      paramView.put("source_from", "AIO");
      paramView.put("source_to", "detailPage");
      StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder.a.getAccount(), "actQZSourceDataReport", true, 0L, 0L, paramView, null);
      paramView = null;
      if (localMap != null) {
        paramView = (String)localMap.get("a");
      }
      if (paramView != null)
      {
        if (!paramView.equals("4")) {
          break label415;
        }
        paramView = "1";
      }
    }
    for (;;)
    {
      localObject = new QZoneClickReport.ReportInfo();
      ((QZoneClickReport.ReportInfo)localObject).c = "330";
      ((QZoneClickReport.ReportInfo)localObject).d = "2";
      ((QZoneClickReport.ReportInfo)localObject).e = paramView;
      ((QZoneClickReport.ReportInfo)localObject).a = new ArrayList();
      ((QZoneClickReport.ReportInfo)localObject).a.add(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl);
      QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder.a.getAccount(), (QZoneClickReport.ReportInfo)localObject);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder.a, "CliOper", "", "", "0X8006000", "0X8006000", 0, 0, "", "", "", "");
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl);
      break;
      label415:
      if (paramView.equals("311")) {
        paramView = "2";
      } else if (paramView.equals("2")) {
        paramView = "3";
      } else {
        paramView = "4";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     veb
 * JD-Core Version:    0.7.0.1
 */