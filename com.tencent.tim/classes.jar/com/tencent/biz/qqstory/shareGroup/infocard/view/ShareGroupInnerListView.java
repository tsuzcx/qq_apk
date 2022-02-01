package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.BaseAdapter;
import aqcx;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import java.util.ArrayList;
import java.util.List;
import qpz;
import quf;
import rsn.a;

public class ShareGroupInnerListView
  extends StoryHomeHorizontalListView
{
  public a a;
  protected quf a;
  protected rsn.a a;
  public String mKey;
  
  public ShareGroupInnerListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ShareGroupInnerListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.bnG = aqcx.dip2px(paramContext, 82.0F);
    this.jdField_a_of_type_Quf = new quf(paramContext);
    setAdapter(this.jdField_a_of_type_Quf);
    setOnItemClickListener(this.jdField_a_of_type_Quf);
    this.jdField_a_of_type_Rsn$a = new qpz(this);
    setOnLoadMoreListener(this.jdField_a_of_type_Rsn$a);
  }
  
  public BaseAdapter getAdapter()
  {
    return this.jdField_a_of_type_Quf;
  }
  
  public void setData(VideoCollectionItem paramVideoCollectionItem)
  {
    this.mKey = paramVideoCollectionItem.collectionId;
    if (paramVideoCollectionItem.collectionCount > paramVideoCollectionItem.videoVidList.size()) {}
    for (boolean bool = true;; bool = false)
    {
      setLoadMoreComplete(bool);
      this.jdField_a_of_type_Quf.setData(paramVideoCollectionItem.collectionVideoUIItemList, paramVideoCollectionItem.collectionId);
      int i = this.mScreenWidth / this.bnG;
      if (paramVideoCollectionItem.collectionVideoUIItemList.size() < i) {
        break;
      }
      setOverScrollMode(0);
      return;
    }
    setOverScrollMode(1);
  }
  
  public void setLoadMoreDataListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView$a = parama;
  }
  
  public static abstract interface a
  {
    public abstract boolean fm(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupInnerListView
 * JD-Core Version:    0.7.0.1
 */