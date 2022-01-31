import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.util.PADetailReportUtil;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity.JumpSrcConstants;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import cooperation.qzone.widget.QzoneSearchResultView;
import java.util.Map;

public class wom
  implements View.OnClickListener
{
  wom(SearchContactsFragment paramSearchContactsFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    won localwon;
    int i;
    if ((paramView != null) && ((paramView instanceof won)))
    {
      localwon = (won)paramView;
      if ((localwon.b != 80000003) || (SearchContactsFragment.c(this.a) == null)) {
        break label287;
      }
      this.a.a(SearchContactsFragment.c(this.a), SearchContactsFragment.a(this.a), SearchContactsFragment.b(this.a));
      Integer localInteger = (Integer)SearchContactsFragment.a(this.a).get(Integer.valueOf(localwon.b));
      Object localObject = null;
      paramView = (View)localObject;
      if (localwon.a != null)
      {
        paramView = (View)localObject;
        if (localwon.a.uin != null) {
          paramView = String.valueOf(localwon.a.uin.get());
        }
      }
      int j = localwon.b;
      if (localInteger == null) {
        break label354;
      }
      i = localInteger.intValue();
      label155:
      SearchUtils.a(j, i, 0, true, paramView, this.a.jdField_a_of_type_JavaLangString, SearchContactsFragment.c());
      if (localwon.b != 80000002) {
        break label405;
      }
      localObject = this.a.getActivity();
      if ((localObject != null) && ((localObject instanceof SearchBaseActivity)))
      {
        i = ((SearchBaseActivity)localObject).a();
        if (SearchContactsFragment.c() != 12) {
          break label359;
        }
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006571", "0X8006571", 0, 1, 0, "0", SearchBaseActivity.JumpSrcConstants.a(i), paramView, this.a.jdField_a_of_type_JavaLangString);
        localObject = PADetailReportUtil.a();
        if (localInteger == null) {
          break label400;
        }
        i = localInteger.intValue();
        ((PADetailReportUtil)localObject).a(2, paramView, i, SearchContactsFragment.c());
      }
    }
    label287:
    label354:
    label359:
    while (localwon.b != 80000003) {
      for (;;)
      {
        return;
        if (localwon.b == 80000004)
        {
          QzoneSearchResultView.a(this.a.getActivity(), localwon.jdField_c_of_type_JavaLangString);
          break;
        }
        paramView = this.a;
        i = localwon.b;
        if (localwon.jdField_c_of_type_Int == 2) {}
        for (boolean bool = true;; bool = false)
        {
          paramView.a(i, bool);
          break;
        }
        i = 0;
        break label155;
        PublicAccountReportUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D20", "0X8005D20", 0, 0, "0", SearchBaseActivity.JumpSrcConstants.a(i), this.a.jdField_a_of_type_JavaLangString, "", false);
        continue;
        i = 0;
      }
    }
    label400:
    label405:
    if (SearchContactsFragment.c() == 12)
    {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800658A", "0X800658A", 0, 0, "0", "", this.a.jdField_a_of_type_JavaLangString, "0");
      return;
    }
    PublicAccountReportUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D95", "0X8005D95", 0, 0, "0", "", this.a.jdField_a_of_type_JavaLangString, "0", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wom
 * JD-Core Version:    0.7.0.1
 */