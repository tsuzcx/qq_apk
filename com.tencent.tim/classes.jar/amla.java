import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.AssociateItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import pb.unite.search.DynamicAssociationWord.SuggestUrlItem;

public class amla
  extends acnn
{
  public amla(ActiveEntitySearchActivity paramActiveEntitySearchActivity) {}
  
  public void a(String paramString, int paramInt, List<AssociateSearchWordsFragment.AssociateItem> paramList, List<DynamicAssociationWord.SuggestUrlItem> paramList1, DynamicAssociationWord.SuggestUrlItem paramSuggestUrlItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, "handleSuggestUrlResult keyword=" + paramString + " activity keyword=" + this.this$0.keyword + " size=" + paramList1.size());
    }
    if (paramString.equals(this.this$0.keyword))
    {
      if (this.this$0.a == null) {
        this.this$0.a = new AssociateSearchWordsFragment();
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
          localAssociateItem.businessType = 3;
          localAssociateItem.index = (paramInt + 1);
          paramList1.add(localAssociateItem);
          if (paramInt != paramList.size() - 1)
          {
            paramList1.add(paramSuggestUrlItem);
            localStringBuilder.append(str).append("::");
          }
          for (;;)
          {
            paramInt += 1;
            break;
            localStringBuilder.append(str);
          }
        }
      }
      this.this$0.a.Pr(true);
      this.this$0.a.PP(paramString);
      this.this$0.a.md(paramList1);
      amub.a(null, new ReportModelDC02528().module("subweb_search").action("exp_thinkword_list").obj1(amxk.c(this.this$0.as)).ver1(this.this$0.vo()).ver4(localStringBuilder.toString()).ver7("{experiment_id:" + amub.cce + "}"));
    }
  }
  
  public void a(String paramString1, Integer paramInteger, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, "handleAssociateResultError keyword=" + paramString1 + "  resultCode=" + paramInteger + "  errorMsg=" + paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amla
 * JD-Core Version:    0.7.0.1
 */