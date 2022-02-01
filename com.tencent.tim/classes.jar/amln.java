import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.AssociateItem;
import com.tencent.mobileqq.search.fragment.GroupSearchFragment;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pb.unify.search.UnifySearchAssociationWord.SuggestUrlItem;

public class amln
  extends acnl
{
  public amln(UniteSearchActivity paramUniteSearchActivity) {}
  
  private void a(amra paramamra)
  {
    if (paramamra == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "patchRichExtraData, source:" + this.this$0.source + " from:" + this.this$0.from);
    }
    int j = this.this$0.source;
    int i = j;
    if (this.this$0.source == 0) {
      switch (this.this$0.from)
      {
      default: 
        i = j;
      }
    }
    for (;;)
    {
      boolean bool = ThemeUtil.isNowThemeIsNight(this.this$0.app, false, null);
      String str = amuq.a(i, paramamra.awh(), paramamra.keyword, bool);
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "patchRichExtraData, extraData:" + str);
      }
      paramamra.PT(str);
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  private void b(amra paramamra)
  {
    if (paramamra == null) {
      return;
    }
    int i = paramamra.IY();
    if (paramamra.awh())
    {
      amub.a(this.this$0.app, this.this$0.source, this.this$0.from, "0X8009D2C", i, 0, paramamra.keyword);
      return;
    }
    amub.a(this.this$0.app, this.this$0.source, this.this$0.from, "0X8009D40", i, 0, paramamra.keyword);
  }
  
  private void ma(List<ampw> paramList)
  {
    if (paramList != null)
    {
      Iterator localIterator1 = paramList.iterator();
      while (localIterator1.hasNext())
      {
        paramList = (ampw)localIterator1.next();
        if ((paramList != null) && (paramList.getGroupName() != null) && (paramList.getGroupName().equals(spp.aFw)))
        {
          paramList = paramList.eX();
          if (paramList != null)
          {
            Iterator localIterator2 = paramList.iterator();
            label76:
            QQAppInterface localQQAppInterface;
            while (localIterator2.hasNext())
            {
              paramList = (ampx)localIterator2.next();
              if ((paramList != null) && ((paramList instanceof amqg)))
              {
                paramList = (amqg)paramList;
                localQQAppInterface = this.this$0.app;
                if (paramList.getUin() == null) {
                  break label159;
                }
              }
            }
            label159:
            for (paramList = paramList.getUin();; paramList = "")
            {
              anot.a(localQQAppInterface, "dc00898", "", paramList, "auth_search", "exp", 0, 0, "", "", "", "");
              break label76;
              break;
            }
          }
        }
      }
    }
  }
  
  private void mb(List<ampw> paramList)
  {
    if (paramList == null) {
      label4:
      return;
    } else {
      paramList = paramList.iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label4;
      }
      Object localObject1 = (ampw)paramList.next();
      if ((((ampw)localObject1).eX() == null) || (((ampw)localObject1).eX().size() == 0)) {
        break;
      }
      Object localObject2 = ((ampw)localObject1).eX().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ampx localampx = (ampx)((Iterator)localObject2).next();
        if ((localampx instanceof ampy)) {
          ((ampy)localampx).setSource(this.this$0.source);
        }
      }
      if (!(localObject1 instanceof ampr)) {
        break;
      }
      localObject1 = ((ampw)localObject1).eX().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ampx)((Iterator)localObject1).next();
        if ((localObject2 instanceof amra))
        {
          int i = ((amra)localObject2).vY();
          if (!amut.a().ll(i))
          {
            ((Iterator)localObject1).remove();
            if (QLog.isColorLevel()) {
              QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "handleUniteSearchResult, remove rich node:" + i);
            }
          }
          a((amra)localObject2);
          b((amra)localObject2);
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt, List<AssociateSearchWordsFragment.AssociateItem> paramList, List<UnifySearchAssociationWord.SuggestUrlItem> paramList1, UnifySearchAssociationWord.SuggestUrlItem paramSuggestUrlItem)
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
      this.this$0.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.Pr(true);
      this.this$0.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.PP(paramString);
      this.this$0.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.md(paramList1);
      amub.a(null, new ReportModelDC02528().module("all_result").action("exp_thinkword_list").ver1(this.this$0.vo()).ver2(amub.eZ(this.this$0.from)).ver4(localStringBuilder.toString()).ver7("{experiment_id:" + amub.cce + "}"));
    }
  }
  
  public void a(String paramString1, Integer paramInteger, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "handleAssociateResultError keyword=" + paramString1 + "  resultCode=" + paramInteger + "  errorMsg=" + paramString2);
    }
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3)
  {
    if (!this.this$0.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.caF.equals(paramString2)) {}
    while (!this.this$0.caJ.equals(paramString1)) {
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.X(paramString1, paramInt, paramString3);
    if (QLog.isColorLevel()) {
      QLog.i("Q.uniteSearch.UniteSearchActivity", 2, "handleUniteSearchError resultCode=" + paramInt + " key=" + paramString1);
    }
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
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "handleUniteSearchResult, keyword = " + paramString1 + ", isFirstReq = " + paramBoolean1 + ", reqTime = " + paramString2 + ", cookie = " + paramArrayOfByte + ", isEnd = " + paramBoolean2 + ", tabList = " + paramList + ", result = " + paramList1);
        }
        mb(paramList1);
        if (!paramBoolean1)
        {
          this.this$0.fp = paramArrayOfByte;
          this.this$0.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.bt(paramArrayOfByte);
          paramString2 = amkl.e(paramList1, paramBoolean1);
          this.this$0.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramString1, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString2);
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label252;
        }
      }
      finally {}
      QLog.i("Q.uniteSearch.UniteSearchActivity", 2, "handleUniteSearchResult isEnd=" + paramBoolean2 + " key=" + paramString1);
      label252:
      if (paramList == null)
      {
        a(paramString1, paramBoolean1, paramString2, -1, "tabList == null");
      }
      else
      {
        if ((paramList.size() > 0) && ((((amps)paramList.get(0)).tabName.equals(acfp.m(2131716247))) || ((((amps)paramList.get(0)).Ga != null) && (((amps)paramList.get(0)).Ga.size() == 0)))) {
          paramList.remove(0);
        }
        this.this$0.GU.setVisibility(0);
        this.this$0.fp = paramArrayOfByte;
        this.this$0.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.bt(paramArrayOfByte);
        paramString2 = amkl.e(paramList1, paramBoolean1);
        ma(paramList1);
        this.this$0.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(paramString1, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString2);
        UniteSearchActivity.cDe = true;
      }
    }
  }
  
  public void k(int paramInt1, String paramString, int paramInt2) {}
  
  public void v(List<amrb> paramList, int paramInt)
  {
    if (paramInt != this.this$0.IR()) {}
    while (this.this$0.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment == null) {
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment.aB(paramList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amln
 * JD-Core Version:    0.7.0.1
 */