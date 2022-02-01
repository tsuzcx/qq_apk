import android.view.View;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.AssociateItem;
import com.tencent.mobileqq.search.fragment.GroupSearchFragment;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import java.util.ArrayList;
import java.util.List;
import pb.unite.search.DynamicAssociationWord.SuggestUrlItem;

public class amlm
  extends acnn
{
  public amlm(UniteSearchActivity paramUniteSearchActivity) {}
  
  public void a(String paramString, int paramInt, List<AssociateSearchWordsFragment.AssociateItem> paramList, List<DynamicAssociationWord.SuggestUrlItem> paramList1, DynamicAssociationWord.SuggestUrlItem paramSuggestUrlItem)
  {
    if (paramString.equals(this.this$0.caJ))
    {
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment == null) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment = new AssociateSearchWordsFragment();
      }
      paramList1 = new ArrayList();
      paramSuggestUrlItem = new AssociateSearchWordsFragment.AssociateItem();
      paramSuggestUrlItem.businessType = 1;
      StringBuilder localStringBuilder = new StringBuilder("");
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramInt = 0;
        if (paramInt < paramList.size())
        {
          String str = ((AssociateSearchWordsFragment.AssociateItem)paramList.get(paramInt)).title;
          AssociateSearchWordsFragment.AssociateItem localAssociateItem = new AssociateSearchWordsFragment.AssociateItem();
          localAssociateItem.title = str;
          if ((this.this$0.from == 25) || (this.this$0.from == 26))
          {
            localAssociateItem.businessType = 6;
            label160:
            localAssociateItem.index = (paramInt + 1);
            paramList1.add(localAssociateItem);
            if (paramInt == paramList.size() - 1) {
              break label229;
            }
            paramList1.add(paramSuggestUrlItem);
            localStringBuilder.append(str).append("::");
          }
          for (;;)
          {
            paramInt += 1;
            break;
            localAssociateItem.businessType = 3;
            break label160;
            label229:
            localStringBuilder.append(str);
          }
        }
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.Pr(true);
      this.this$0.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.PP(paramString);
      this.this$0.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.md(paramList1);
      UniteSearchActivity.mSessionId = this.this$0.getCurrentAccountUin() + System.currentTimeMillis();
      amub.a(null, new ReportModelDC02528().module("all_result").action("exp_thinkword_list").ver1(this.this$0.vo()).ver2(amub.eZ(this.this$0.from)).ver3(UniteSearchActivity.caO).ver6(UniteSearchActivity.caN).ver7("{experiment_id:" + amub.cce + "}").session_id(UniteSearchActivity.mSessionId).ver4(localStringBuilder.toString()));
    }
  }
  
  public void a(String paramString1, Integer paramInteger, String paramString2) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3)
  {
    if (!this.this$0.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.caF.equals(paramString2)) {}
    while (!this.this$0.caJ.equals(paramString1)) {
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.X(paramString1, paramInt, paramString3);
    this.this$0.GU.setVisibility(0);
  }
  
  public void a(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<amps> paramList, List<ampw> paramList1)
  {
    for (;;)
    {
      try
      {
        boolean bool = this.this$0.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.caF.equals(paramString2);
        if (!bool) {
          return;
        }
        if ((this.this$0.caJ == null) || (!this.this$0.caJ.equals(paramString1))) {
          continue;
        }
        if (!paramBoolean1)
        {
          this.this$0.fp = paramArrayOfByte;
          this.this$0.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.bt(paramArrayOfByte);
          paramString2 = amkl.e(paramList1, paramBoolean1);
          this.this$0.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramString1, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString2);
          continue;
        }
        if (paramList != null) {
          break label125;
        }
      }
      finally {}
      a(paramString1, paramBoolean1, paramString2, -1, "tabList == null");
      continue;
      label125:
      if ((paramList.size() > 0) && ((((amps)paramList.get(0)).tabName.equals(acfp.m(2131716246))) || ((((amps)paramList.get(0)).Ga != null) && (((amps)paramList.get(0)).Ga.size() == 0)))) {
        paramList.remove(0);
      }
      this.this$0.GU.setVisibility(0);
      this.this$0.fp = paramArrayOfByte;
      this.this$0.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.bt(paramArrayOfByte);
      paramString2 = amkl.e(paramList1, paramBoolean1);
      this.this$0.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramString1, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString2);
      UniteSearchActivity.cDe = true;
    }
  }
  
  public void k(int paramInt1, String paramString, int paramInt2) {}
  
  public void v(List<amrb> paramList, int paramInt)
  {
    if (paramInt != this.this$0.IR()) {}
    while (this.this$0.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment == null) {
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment.aB(paramList, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amlm
 * JD-Core Version:    0.7.0.1
 */