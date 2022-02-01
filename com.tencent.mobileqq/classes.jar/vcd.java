import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StUser;
import qqcircle.QQCircleFeedBase.StMainPageBusiRspData;

class vcd
  implements bkhw
{
  vcd(vcb paramvcb, bkho parambkho, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    boolean bool2 = true;
    if (!aauy.a("showMoreActionSheetClick"))
    {
      paramView = this.jdField_a_of_type_Bkho.a(paramInt);
      if (!TextUtils.isEmpty(paramView)) {}
    }
    else
    {
      return;
    }
    if (paramView.equals(this.jdField_a_of_type_Vcb.a().getResources().getString(2131697181)))
    {
      vrf.a(vcb.a(this.jdField_a_of_type_Vcb).id.get(), 11, 31, 2);
      uxo.a(this.jdField_a_of_type_Vcb.a(), this.jdField_a_of_type_JavaLangString);
    }
    do
    {
      for (;;)
      {
        this.jdField_a_of_type_Bkho.dismiss();
        return;
        if (paramView.equals(this.jdField_a_of_type_Vcb.a().getResources().getString(2131697277)))
        {
          uxo.a(this.jdField_a_of_type_Vcb.a(), "https://h5.qzone.qq.com/v2/wezone/wallet?_wv=3&_proxy=1");
          vrf.a(vcb.a(this.jdField_a_of_type_Vcb).id.get(), 11, 34, 2);
        }
        else
        {
          if (!paramView.equals(this.jdField_a_of_type_Vcb.a().getResources().getString(2131697258))) {
            break;
          }
          vcb.d(this.jdField_a_of_type_Vcb);
        }
      }
    } while (!paramView.equals(this.jdField_a_of_type_Vcb.a().getResources().getString(2131697257)));
    boolean bool1;
    if ((vcb.a(this.jdField_a_of_type_Vcb) != null) && (uxx.b(vcb.a(this.jdField_a_of_type_Vcb).opMask.get())))
    {
      bool1 = true;
      label236:
      if ((vcb.a(this.jdField_a_of_type_Vcb) == null) || (!uxx.c(vcb.a(this.jdField_a_of_type_Vcb).opMask.get()))) {
        break label294;
      }
    }
    for (;;)
    {
      uxo.a(bool1, bool2, this.jdField_a_of_type_Vcb.a().clone().setElementIdStr("portraitlist"));
      break;
      bool1 = false;
      break label236;
      label294:
      bool2 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vcd
 * JD-Core Version:    0.7.0.1
 */