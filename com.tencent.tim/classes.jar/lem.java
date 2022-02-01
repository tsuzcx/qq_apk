import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyProteusFamilyListViewGroup;
import java.util.List;

public class lem
  extends kfr
  implements View.OnClickListener
{
  private ReadInJoyBaseListViewGroup jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
  private ndi jdField_a_of_type_Ndi;
  private ViewGroup aM;
  private boolean isInited;
  private View jH;
  private View mLoadingView;
  
  public lem(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void aDy()
  {
    if (this.jH != null) {
      this.jH.setVisibility(8);
    }
    if (this.aM != null) {
      this.mLoadingView = this.aM.findViewById(2131374329);
    }
  }
  
  public void aBZ()
  {
    super.aBZ();
  }
  
  public void h(boolean paramBoolean, List<BaseArticleInfo> paramList)
  {
    if (!this.isInited)
    {
      onCreate();
      this.isInited = true;
    }
    if (this.mLoadingView != null) {
      this.mLoadingView.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null)
    {
      if (this.aM != null)
      {
        ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.getParent() != null) {
          ((ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.getParent()).removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup);
        }
        this.aM.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup, localLayoutParams);
      }
      ((ReadInJoyProteusFamilyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).h(true, paramList);
    }
  }
  
  public void i(ViewGroup paramViewGroup)
  {
    super.i(paramViewGroup);
    this.aM = paramViewGroup;
    aDy();
  }
  
  public ViewGroup j()
  {
    return this.aM;
  }
  
  public void onClick(View paramView) {}
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup = new ReadInJoyProteusFamilyListViewGroup(this, 0, 0, 0, null, 2131560479);
    this.jdField_a_of_type_Ndi = ((ReadInJoyProteusFamilyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a();
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Ndi != null) {
      this.jdField_a_of_type_Ndi.clearData();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lem
 * JD-Core Version:    0.7.0.1
 */