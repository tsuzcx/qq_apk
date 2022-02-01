package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.search;

import acbn;
import amlt;
import ampx;
import amsf.a;
import amvg;
import amwd;
import android.view.View;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mpb;
import mpd;
import mpe;

public class HybridSearchFragment
  extends BaseSearchFragment
  implements amsf.a
{
  private a a;
  private Set<String> ac = new HashSet();
  
  public static HybridSearchFragment a()
  {
    return new HybridSearchFragment();
  }
  
  public boolean DS()
  {
    return false;
  }
  
  public amlt a()
  {
    return new mpd(this, this.jdField_a_of_type_ComTencentWidgetListView, this.c);
  }
  
  public amwd a()
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    localHashSet.add(acbn.blz);
    localArrayList.add(new amvg(this.d, -1, 1, null, localHashSet));
    localArrayList.add(new mpb());
    return new mpe(localArrayList);
  }
  
  public void a(a parama)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSearchHybridSearchFragment$a = parama;
  }
  
  public void cQ(List<String> paramList)
  {
    this.ac.clear();
    if (paramList != null) {
      this.ac.addAll(paramList);
    }
  }
  
  public void cR(View paramView)
  {
    paramView = (ampx)paramView.getTag(2131381960);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSearchHybridSearchFragment$a != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSearchHybridSearchFragment$a.a(paramView);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(ampx paramampx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.search.HybridSearchFragment
 * JD-Core Version:    0.7.0.1
 */