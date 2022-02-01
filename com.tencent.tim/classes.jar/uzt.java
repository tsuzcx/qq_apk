import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.view.ProfileShoppingView;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class uzt
  implements ausj.a
{
  uzt(uzn paramuzn, String paramString, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.val$actionSheet.superDismiss();
      return;
      anot.a(this.a.this$0.app, "CliOper", "", "", "card_mall", "0X8006680", 0, 0, "1", "", "", VipUtils.d(this.a.this$0.app, this.a.this$0.app.getCurrentAccountUin()));
      if (this.a.this$0.jdField_a_of_type_Alcn.cwc) {
        VasWebviewUtil.reportCommercialDrainage(this.a.this$0.app.getCurrentAccountUin(), "group_card", "click_setresult", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      }
      if ((this.a.this$0.jdField_a_of_type_Alcn.d.lCurrentStyleId == alcs.agm) || (this.a.this$0.jdField_a_of_type_Alcn.d.lCurrentStyleId == alcs.agl)) {
        VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clk_setmy", "0", 1, 0, 0, jqc.hS(), String.valueOf(this.a.this$0.jdField_a_of_type_Alcn.d.lCurrentBgId), String.valueOf(this.a.this$0.jdField_a_of_type_Alcn.d.lCurrentStyleId));
      }
      if ((this.a.this$0.FY == 160L) || (this.a.this$0.FY == 1600L) || ((aqep.T(this.a.this$0.bgtype)) && (this.a.this$0.jdField_a_of_type_Alcn.d.cardType != 2) && (this.a.this$0.jdField_a_of_type_Alcn.d.dynamicCardFlag != 1)) || (this.a.this$0.jdField_a_of_type_Alcn.d.lCurrentStyleId == alcs.agk) || ((this.a.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileShoppingView)))
      {
        Toast.makeText(this.a.this$0.getApplicationContext(), 2131697311, 0).show();
      }
      else if (alcs.cy(this.a.this$0.jdField_a_of_type_Alcn.d.lCurrentStyleId))
      {
        aqlt.a(this.a.this$0.jdField_a_of_type_Alcn.d, this.a.this$0.app, this.a.this$0);
        anot.a(this.a.this$0.app, "dc00898", "", "", "qvip", "0X8009E3A", 2, 0, "", "", "", "");
      }
      else if ((!TextUtils.isEmpty(this.a.this$0.jdField_a_of_type_Alcn.d.diyText)) && (this.a.this$0.jdField_a_of_type_Alcn.d.diyTextFontId != 0))
      {
        this.a.this$0.bOD();
      }
      else
      {
        this.a.this$0.a(this.a.this$0.FX, this.a.this$0.FY, this.a.this$0.FZ, this.a.this$0.aNe);
        anot.a(this.a.this$0.app, "dc00898", "", "", "", "0X800A4C1", 0, 0, "", "", "", "");
        continue;
        anot.a(this.a.this$0.app, "CliOper", "", "", "card_mall", "0X8006680", 0, 0, "2", "", "", VipUtils.d(this.a.this$0.app, this.a.this$0.app.getCurrentAccountUin()));
        if (this.a.this$0.jdField_a_of_type_Alcn.cwc) {
          VasWebviewUtil.reportCommercialDrainage(this.a.this$0.app.getCurrentAccountUin(), "group_card", "click_more", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        }
        if ((this.a.this$0.jdField_a_of_type_Alcn.d.lCurrentStyleId == alcs.agm) || (this.a.this$0.jdField_a_of_type_Alcn.d.lCurrentStyleId == alcs.agl)) {
          VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clk_morecard", "0", 1, 0, 0, jqc.hS(), String.valueOf(this.a.this$0.jdField_a_of_type_Alcn.d.lCurrentBgId), String.valueOf(this.a.this$0.jdField_a_of_type_Alcn.d.lCurrentStyleId));
        }
        String str1 = "";
        Object localObject = this.a.this$0.oQ();
        paramView = str1;
        if (localObject != null)
        {
          paramView = str1;
          if (((String)localObject).equals("CustomCover")) {
            paramView = "oldCustom=1";
          }
        }
        localObject = this.a.this$0;
        String str2 = this.a.this$0.app.getCurrentAccountUin();
        if (this.val$action.equals("CLICK_HEADER_BG")) {}
        for (str1 = "inside.friendCardBackground";; str1 = "inside.blackBar")
        {
          aqep.a((Activity)localObject, str2, str1, 1, 1, 1, paramView, false);
          break;
        }
        anot.a(this.a.this$0.app, "CliOper", "", "", "card_mall", "0X8006680", 0, 0, "3", "", "", VipUtils.d(this.a.this$0.app, this.a.this$0.app.getCurrentAccountUin()));
        if (this.a.this$0.jdField_a_of_type_Alcn.cwc) {
          VasWebviewUtil.reportCommercialDrainage(this.a.this$0.app.getCurrentAccountUin(), "group_card", "click_cancel", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uzt
 * JD-Core Version:    0.7.0.1
 */