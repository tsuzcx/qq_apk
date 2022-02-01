import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.IPSiteModel.Goods;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class afpp
  implements View.OnClickListener
{
  afpp(afpo paramafpo, IPSiteModel.Goods paramGoods) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(afpo.a(this.jdField_a_of_type_Afpo), QQBrowserActivity.class);
    localIntent.putExtra("hide_operation_bar", true);
    VasWebviewUtil.openQQBrowserWithoutAD(afpo.a(this.jdField_a_of_type_Afpo), this.jdField_a_of_type_ComTencentMobileqqDataIPSiteModel$Goods.url, -1L, localIntent, false, -1);
    VasWebviewUtil.reportCommercialDrainage(afpo.a(this.jdField_a_of_type_Afpo), "IP", "aio_productclk", "", 0, 0, 0, afpo.b(this.jdField_a_of_type_Afpo), afpo.c(this.jdField_a_of_type_Afpo), "", "", "", "", "", 0, 0, 0, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afpp
 * JD-Core Version:    0.7.0.1
 */