import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class xly
  implements View.OnClickListener
{
  xly(xlx paramxlx, MessageForQzoneFeed paramMessageForQzoneFeed) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl = xlx.hx(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl);
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    Object localObject2 = aurr.getArgumentsFromURL(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl);
    Object localObject1 = null;
    if (localObject2 != null) {
      localObject1 = (String)((Map)localObject2).get("g");
    }
    if (("110".equals(localObject1)) || ("279".equals(localObject1)) || ("318".equals(localObject1)))
    {
      localObject1 = paramView.getContext();
      avpw.d locald = avpw.d.a();
      locald.cMP = this.jdField_a_of_type_Xlx.app.getCurrentAccountUin();
      locald.nickname = this.jdField_a_of_type_Xlx.app.getCurrentNickname();
      avpw.a((Activity)localObject1, locald, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl, "mqqChat.QzoneCard", this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.appId, -1);
      localObject1 = new QZoneClickReport.a();
      ((QZoneClickReport.a)localObject1).actionType = "1";
      ((QZoneClickReport.a)localObject1).cMI = "0";
      ((QZoneClickReport.a)localObject1).tabletype = 4;
      ((QZoneClickReport.a)localObject1).sourceType = "3";
      ((QZoneClickReport.a)localObject1).sourceFrom = "AIO";
      ((QZoneClickReport.a)localObject1).sourceTo = "detailPage";
      QZoneClickReport.startReportImediately(this.jdField_a_of_type_Xlx.app.getAccount(), (QZoneClickReport.a)localObject1);
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("source_type", "3");
      ((HashMap)localObject1).put("source_from", "AIO");
      ((HashMap)localObject1).put("source_to", "detailPage");
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance(this.jdField_a_of_type_Xlx.app.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject1, null);
      label278:
      localObject1 = null;
      if (localObject2 != null) {
        localObject1 = (String)((Map)localObject2).get("a");
      }
      if (localObject1 != null)
      {
        if (!((String)localObject1).equals("4")) {
          break label474;
        }
        localObject1 = "1";
      }
    }
    for (;;)
    {
      localObject2 = new QZoneClickReport.a();
      ((QZoneClickReport.a)localObject2).actionType = "330";
      ((QZoneClickReport.a)localObject2).cMI = "2";
      ((QZoneClickReport.a)localObject2).reserves = ((String)localObject1);
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.isFirstMsgWithNewFriend) {
        ((QZoneClickReport.a)localObject2).reserves10 = "1";
      }
      ((QZoneClickReport.a)localObject2).reservesExt = new ArrayList();
      ((QZoneClickReport.a)localObject2).reservesExt.add(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl);
      QZoneClickReport.startReportImediately(this.jdField_a_of_type_Xlx.app.getAccount(), (QZoneClickReport.a)localObject2);
      anot.a(this.jdField_a_of_type_Xlx.app, "dc00898", "", "", "0x8009434", "0x8009434", 0, 0, "", "2", "", "");
      anot.a(this.jdField_a_of_type_Xlx.app, "CliOper", "", "", "0X8006000", "0X8006000", 0, 0, "", "", "", "");
      break;
      this.jdField_a_of_type_Xlx.hO(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl);
      break label278;
      label474:
      if (((String)localObject1).equals("311")) {
        localObject1 = "2";
      } else if (((String)localObject1).equals("2")) {
        localObject1 = "3";
      } else {
        localObject1 = "4";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xly
 * JD-Core Version:    0.7.0.1
 */