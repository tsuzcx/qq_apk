import QC.UniBusiSimpleItemDetail;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment;
import com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class alfm
  implements View.OnClickListener
{
  alfm(alfl paramalfl, UniBusiSimpleItemDetail paramUniBusiSimpleItemDetail) {}
  
  public void onClick(View paramView)
  {
    if ((alfl.a(this.jdField_b_of_type_Alfl) == 5) && (alfl.a(this.jdField_b_of_type_Alfl) != null) && ((alfl.a(this.jdField_b_of_type_Alfl) instanceof StickyNotePublishFragment)) && (!((StickyNotePublishFragment)alfl.a(this.jdField_b_of_type_Alfl)).hasContent()))
    {
      QQToast.a(alfl.a(this.jdField_b_of_type_Alfl), acfp.m(2131715488), 0).show();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    alfl.a(this.jdField_b_of_type_Alfl, this.jdField_b_of_type_QCUniBusiSimpleItemDetail.itemId);
    int i = alfl.a(this.jdField_b_of_type_Alfl).dsM;
    alfl.a(this.jdField_b_of_type_Alfl);
    if (i == 2)
    {
      if (9 == alfl.a(this.jdField_b_of_type_Alfl)) {}
      for (str = "1";; str = "2")
      {
        VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "item_click", "", 0, "", str);
        this.jdField_b_of_type_Alfl.notifyDataSetChanged();
        alfl.a(this.jdField_b_of_type_Alfl, this.jdField_b_of_type_QCUniBusiSimpleItemDetail);
        alfl.a(this.jdField_b_of_type_Alfl, true);
        this.jdField_b_of_type_Alfl.a(alfl.a(this.jdField_b_of_type_Alfl), this.jdField_b_of_type_QCUniBusiSimpleItemDetail.itemId, this.jdField_b_of_type_QCUniBusiSimpleItemDetail.feeType, this.jdField_b_of_type_Alfl.a);
        break;
      }
    }
    if (9 == alfl.a(this.jdField_b_of_type_Alfl)) {}
    for (String str = "1";; str = "2")
    {
      VasWebviewUtil.reportCommercialDrainage("friend_wall", "item_click", "", 0, "", str);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alfm
 * JD-Core Version:    0.7.0.1
 */