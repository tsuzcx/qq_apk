package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import qqa;

public class ShareGroupsListView
  extends MyMemoriesListView
{
  b a;
  public qqa a;
  
  public ShareGroupsListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ShareGroupsListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ShareGroupsListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void bpD() {}
  
  public void setListAdapter(qqa paramqqa)
  {
    super.setListAdapter(paramqqa);
    this.jdField_a_of_type_Qqa = paramqqa;
  }
  
  public void setUIEventListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView$b = paramb;
    this.jdField_a_of_type_Qqa.a(paramb);
    super.setListener(paramb, paramb);
  }
  
  public static abstract interface a
  {
    public abstract void dL(View paramView);
    
    public abstract void dM(View paramView);
  }
  
  public static abstract interface b
    extends MyMemoriesListView.a, MyMemoriesListView.b, ShareGroupInnerListView.a, ShareGroupsListView.a
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView
 * JD-Core Version:    0.7.0.1
 */