import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.launchbean.QCircleSettingBean;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StUser;
import qqcircle.QQCircleFeedBase.StMainPageBusiRspData;

class vdt
  implements bliz
{
  vdt(vdr paramvdr, blir paramblir, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    boolean bool2 = true;
    if (!aazb.a("showMoreActionSheetClick"))
    {
      paramView = this.jdField_a_of_type_Blir.a(paramInt);
      if (!TextUtils.isEmpty(paramView)) {}
    }
    else
    {
      return;
    }
    if (paramView.equals(this.jdField_a_of_type_Vdr.a().getResources().getString(2131697246)))
    {
      vtq.a(vdr.a(this.jdField_a_of_type_Vdr).id.get(), 11, 31, 2);
      uyx.a(this.jdField_a_of_type_Vdr.a(), this.jdField_a_of_type_JavaLangString, null, -1);
    }
    do
    {
      for (;;)
      {
        this.jdField_a_of_type_Blir.dismiss();
        return;
        if (paramView.equals(this.jdField_a_of_type_Vdr.a().getResources().getString(2131697355)))
        {
          uyx.a(this.jdField_a_of_type_Vdr.a(), "https://h5.qzone.qq.com/v2/wezone/wallet?_wv=3&_proxy=1", null, -1);
          vtq.a(vdr.a(this.jdField_a_of_type_Vdr).id.get(), 11, 34, 2);
        }
        else
        {
          if (!paramView.equals(this.jdField_a_of_type_Vdr.a().getResources().getString(2131697335))) {
            break;
          }
          vdr.d(this.jdField_a_of_type_Vdr);
        }
      }
    } while (!paramView.equals(this.jdField_a_of_type_Vdr.a().getResources().getString(2131697334)));
    boolean bool1;
    if ((vdr.a(this.jdField_a_of_type_Vdr) != null) && (uzg.b(vdr.a(this.jdField_a_of_type_Vdr).opMask.get())))
    {
      bool1 = true;
      label240:
      if ((vdr.a(this.jdField_a_of_type_Vdr) == null) || (!uzg.c(vdr.a(this.jdField_a_of_type_Vdr).opMask.get()))) {
        break label326;
      }
    }
    for (;;)
    {
      paramView = new QCircleSettingBean();
      paramView.setCanJumpProfile(bool1);
      paramView.setCanSyncTroopARK(bool2);
      paramView.setFromReportBean(this.jdField_a_of_type_Vdr.a().clone().setElementIdStr("portraitlist"));
      uyx.a(this.jdField_a_of_type_Vdr.a(), paramView);
      break;
      bool1 = false;
      break label240;
      label326:
      bool2 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdt
 * JD-Core Version:    0.7.0.1
 */