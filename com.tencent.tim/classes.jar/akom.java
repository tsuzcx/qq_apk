import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.SougouSearchInfo;
import com.tencent.mobileqq.ocr.ui.BaseOCRTextSearchFragment;
import com.tencent.mobileqq.ocr.ui.BaseOCRTextSearchFragment.a;
import com.tencent.mobileqq.ocr.ui.SearchResultFragment;
import com.tencent.mobileqq.ocr.ui.SearchResultPageView.1;
import com.tencent.mobileqq.ocr.ui.SearchResultViewPagerAdapter.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

public class akom
  implements akog.b
{
  View Fv = null;
  boolean Ub = false;
  public BaseOCRTextSearchFragment.a a;
  SearchResultViewPagerAdapter.a a;
  QQAppInterface app;
  akog jdField_b_of_type_Akog;
  BaseOCRTextSearchFragment jdField_b_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment;
  boolean cni = false;
  int curIndex = 0;
  public XListView e;
  boolean hasMore = false;
  TextView iT;
  boolean isLoading = false;
  LinearLayout jM;
  ProgressBar mProgressBar;
  Handler mUIHandler = new Handler(Looper.getMainLooper());
  
  public akom(BaseOCRTextSearchFragment.a parama, SearchResultFragment paramSearchResultFragment)
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment$a = parama;
    this.jdField_b_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment = paramSearchResultFragment;
    this.jdField_b_of_type_Akog = new akog(parama.getActivity(), this.app, this);
  }
  
  private void gS(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment$a.getActivity(), QQBrowserActivity.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("url", paramString2);
    localIntent.putExtra("hide_more_button", true);
    this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment$a.getActivity().startActivity(localIntent);
  }
  
  protected void Sg(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment$a.eI(null);
      return;
      this.mProgressBar.setVisibility(8);
      this.iT.setVisibility(8);
      this.e.setVisibility(0);
      continue;
      this.mProgressBar.setVisibility(8);
      this.e.setVisibility(8);
      this.iT.setVisibility(0);
      this.iT.setText(2131698219);
      continue;
      this.mProgressBar.setVisibility(8);
      this.e.setVisibility(8);
      this.iT.setVisibility(0);
      this.iT.setText(2131701464);
      continue;
      this.mProgressBar.setVisibility(0);
      this.e.setVisibility(8);
      this.iT.setVisibility(8);
    }
  }
  
  public View a(Context paramContext, SearchResultViewPagerAdapter.a parama)
  {
    if (this.Fv == null)
    {
      paramContext = LayoutInflater.from(paramContext).inflate(2131561519, null);
      this.e = ((XListView)paramContext.findViewById(2131377856));
      this.mProgressBar = ((ProgressBar)paramContext.findViewById(2131379160));
      this.iT = ((TextView)paramContext.findViewById(2131372437));
      this.e.setOnTouchListener(this.jdField_b_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment.f);
      this.jM = ((LinearLayout)paramContext.findViewById(2131370782));
      this.app = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      this.Fv = paramContext;
      this.e.setAdapter(this.jdField_b_of_type_Akog);
    }
    a(parama);
    return this.Fv;
  }
  
  public void a(akog.a parama)
  {
    if (parama == null) {
      return;
    }
    if ((parama.groupType == 2049) && (parama.type == 0))
    {
      parama = (OCRTextSearchInfo.SougouSearchInfo)parama.el;
      if ((parama != null) && (!TextUtils.isEmpty(parama.jumpURL))) {
        gS(this.app.getCurrentUin(), parama.jumpURL);
      }
    }
    anot.a(null, "dc00898", "", "", "0X80082E9", "0X80082E9", 0, 0, "", "", "", "");
  }
  
  protected void a(SearchResultViewPagerAdapter.a parama)
  {
    if (this.Ub) {
      return;
    }
    this.Ub = true;
    this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultViewPagerAdapter$a = parama;
    if ((this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultViewPagerAdapter$a.errorCode == 0) && (this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultViewPagerAdapter$a.cB != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.SearchResultFragment", 2, "results: " + this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultViewPagerAdapter$a.cB.size());
      }
      List localList = this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultViewPagerAdapter$a.cB;
      if (localList.size() != 0) {
        this.jdField_b_of_type_Akog.a(this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultViewPagerAdapter$a, localList, false, false);
      }
    }
    else
    {
      dCq();
      Sg(parama.errorCode);
      return;
    }
    Sg(-1);
  }
  
  public void dCq()
  {
    this.mUIHandler.postDelayed(new SearchResultPageView.1(this), 50L);
  }
  
  public void init(boolean paramBoolean)
  {
    this.Ub = false;
    this.curIndex = 0;
    this.cni = false;
    this.isLoading = false;
    this.hasMore = paramBoolean;
    if (this.jdField_b_of_type_Akog != null) {
      this.jdField_b_of_type_Akog.clearItems();
    }
  }
  
  public void onShow() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akom
 * JD-Core Version:    0.7.0.1
 */