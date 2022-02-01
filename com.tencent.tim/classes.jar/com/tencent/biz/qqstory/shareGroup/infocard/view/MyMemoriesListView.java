package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import aqiw;
import auuo;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.view.MemoriesInnerListView.a;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryListLoadMoreView;
import com.tencent.biz.qqstory.view.widget.QQStoryPullToRefreshListView;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import java.util.List;
import pye.a;
import qpx;
import qpy;

public class MyMemoriesListView
  extends QQStoryPullToRefreshListView
  implements auuo, AbsListView.e
{
  public a a;
  public StoryListLoadMoreView a;
  public qpx a;
  private int bnB = 5;
  public PullRefreshHeader c;
  private AbsListView.e mOnScrollListener;
  
  public MyMemoriesListView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public MyMemoriesListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public MyMemoriesListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private boolean Kg()
  {
    int i;
    if (this.jdField_a_of_type_Qpx.getCount() == 3) {
      i = 0;
    }
    while (i < this.jdField_a_of_type_Qpx.getCount())
    {
      VideoCollectionItem localVideoCollectionItem = (VideoCollectionItem)this.jdField_a_of_type_Qpx.getItem(i);
      if ((!localVideoCollectionItem.isEmptyFakeItem) && (!TextUtils.isEmpty(localVideoCollectionItem.collectionId))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private void init()
  {
    super.setActTAG("list_qqstory_memories");
    this.c = ((PullRefreshHeader)LayoutInflater.from(getContext()).inflate(2131561945, this, false));
    this.c.setTextColor(-1, -1, -1, -1, -1);
    this.c.setHeaderBgDrawable(getResources().getDrawable(2130839645));
    super.setOverScrollHeader(this.c);
    super.setOverScrollHeight(getResources().getDimensionPixelSize(2131299308));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView = new StoryListLoadMoreView(getContext());
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.eW(3);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.setOnClickListener(new qpy(this));
    super.addFooterView(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView);
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundColor(-1);
    super.setOverScrollListener(this);
    super.setOnScrollListener(this);
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (paramInt == 0) {
      this.c.Q(0L);
    }
  }
  
  public void a(pye.a parama)
  {
    if ((parama.b.isSuccess()) && (parama.nb != null) && (parama.nb.size() > 0)) {
      this.jdField_a_of_type_Qpx.l(parama.collectionId, parama.nb);
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (paramInt == 0)
    {
      this.c.S(0L);
      if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewMyMemoriesListView$a != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewMyMemoriesListView$a.onPullRefresh();
      }
    }
    return true;
  }
  
  public void an(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.c.tT(0);
    }
    for (;;)
    {
      super.postDelayed(new MyMemoriesListView.2(this), 800L);
      return;
      this.c.tT(1);
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (paramInt == 0) {
      this.c.R(0L);
    }
  }
  
  protected void bpD() {}
  
  public void c(int paramInt, View paramView, ListView paramListView)
  {
    if (paramInt == 0) {
      this.c.S(0L);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mOnScrollListener != null) {
      this.mOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if ((paramInt2 == 0) && (paramInt3 == 0)) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Qpx.getCount() == 0) || (Kg()) || (getCount() - getLastVisiblePosition() > this.bnB) || ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.getState() == 5) && (!aqiw.isNetworkAvailable(getContext()))) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.getState() == 4) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.getState() == 1));
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.eW(1);
    } while (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewMyMemoriesListView$a == null);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewMyMemoriesListView$a.aSa();
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.mOnScrollListener != null) {
      this.mOnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
    if (paramInt == 0)
    {
      bpD();
      if ((getCount() - getLastVisiblePosition() <= this.bnB) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.getState() == 5))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.eW(1);
        if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewMyMemoriesListView$a != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewMyMemoriesListView$a.aSa();
        }
      }
    }
  }
  
  public void setListAdapter(qpx paramqpx)
  {
    super.setAdapter(paramqpx);
    this.jdField_a_of_type_Qpx = paramqpx;
  }
  
  public void setListener(a parama, b paramb)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewMyMemoriesListView$a = parama;
    this.jdField_a_of_type_Qpx.a(parama, paramb);
  }
  
  public void setLoadMoreState(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.eW(4);
        return;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.eW(3);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.eW(5);
  }
  
  public void setOnScrollListener(AbsListView.e parame)
  {
    this.mOnScrollListener = parame;
  }
  
  public static abstract interface a
    extends MemoriesInnerListView.a
  {
    public abstract void aSa();
    
    public abstract void onPullRefresh();
  }
  
  public static abstract interface b
  {
    public abstract void a(String paramString1, int paramInt, View paramView, String paramString2);
    
    public abstract void a(String paramString1, long paramLong, StoryVideoItem paramStoryVideoItem, int paramInt, String paramString2, List<String> paramList);
    
    public abstract void bpB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.MyMemoriesListView
 * JD-Core Version:    0.7.0.1
 */