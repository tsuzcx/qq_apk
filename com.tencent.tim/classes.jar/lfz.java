import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class lfz
{
  private ReadInJoyBaseListViewGroup jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
  private ndi jdField_b_of_type_Ndi;
  
  public final boolean Cb()
  {
    return this.jdField_b_of_type_Ndi.akw;
  }
  
  public void F(Map<Integer, mgu> paramMap) {}
  
  public void O(boolean paramBoolean, int paramInt) {}
  
  public final aqdf a()
  {
    return this.jdField_b_of_type_Ndi.a();
  }
  
  public ReadInJoyBaseListViewGroup a()
  {
    return this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
  }
  
  public AbsListView a()
  {
    if (this.jdField_b_of_type_Ndi != null) {
      return this.jdField_b_of_type_Ndi.b();
    }
    return null;
  }
  
  public final ndi a()
  {
    return this.jdField_b_of_type_Ndi;
  }
  
  public void a(View paramView, ArticleInfo paramArticleInfo, int paramInt) {}
  
  public void a(View paramView, ListView paramListView) {}
  
  public final void a(ReadInJoyBaseListViewGroup paramReadInJoyBaseListViewGroup)
  {
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup = paramReadInJoyBaseListViewGroup;
  }
  
  public void a(Map<Long, mgu> paramMap, boolean paramBoolean) {}
  
  public void a(Set<Long> paramSet, Map<Long, mgu> paramMap) {}
  
  public final void a(ndi paramndi)
  {
    this.jdField_b_of_type_Ndi = paramndi;
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2) {}
  
  public void aEa() {}
  
  public void aLV() {}
  
  public void aLW() {}
  
  public void b(View paramView, ListView paramListView) {}
  
  public void b(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2) {}
  
  public Integer c(int paramInt)
  {
    return Integer.valueOf(this.jdField_b_of_type_Ndi.getItemViewType(paramInt));
  }
  
  public void c(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt) {}
  
  public void ck(List<BaseArticleInfo> paramList) {}
  
  public View d(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public boolean df(int paramInt)
  {
    return false;
  }
  
  public AnimationSet f()
  {
    return this.jdField_b_of_type_Ndi.f();
  }
  
  public Boolean g()
  {
    return null;
  }
  
  public final Activity getActivity()
  {
    return this.jdField_b_of_type_Ndi.getActivity();
  }
  
  public final int getCount()
  {
    return this.jdField_b_of_type_Ndi.getCount();
  }
  
  public final Object getData(int paramInt)
  {
    return this.jdField_b_of_type_Ndi.getItem(paramInt);
  }
  
  public int nh()
  {
    return this.jdField_b_of_type_Ndi.nh();
  }
  
  public int ni()
  {
    return this.jdField_b_of_type_Ndi.qx();
  }
  
  public abstract int np();
  
  public void nv(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.lP(paramBoolean);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onDestroy() {}
  
  public void onListViewScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onListViewScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onStart() {}
  
  public void onStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lfz
 * JD-Core Version:    0.7.0.1
 */