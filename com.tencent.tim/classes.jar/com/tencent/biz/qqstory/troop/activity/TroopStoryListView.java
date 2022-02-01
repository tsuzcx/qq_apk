package com.tencent.biz.qqstory.troop.activity;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.biz.qqstory.view.widget.AbsEmptyView;
import com.tencent.widget.ListView;
import pqj;
import ptq;
import qye;
import qyk;
import qzx;
import rar;

public class TroopStoryListView
  extends SegmentList
  implements View.OnTouchListener
{
  private qye a;
  private boolean aGa;
  private Activity y;
  
  public TroopStoryListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TroopStoryListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TroopStoryListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(Activity paramActivity, qye paramqye)
  {
    this.a = paramqye;
    this.y = paramActivity;
    super.setOnTouchListener(this);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    super.a(paramInt, paramView, paramListView);
    if (paramInt == 0) {
      this.aGa = true;
    }
    while (paramInt != 1) {
      return true;
    }
    return true;
  }
  
  public void af(boolean paramBoolean, int paramInt)
  {
    super.af(paramBoolean, paramInt);
    if (this.aGa) {
      this.aGa = false;
    }
    if ((getEmptyView() instanceof AbsEmptyView)) {
      ((AbsEmptyView)getEmptyView()).xU(4);
    }
  }
  
  public void box()
  {
    super.setActTAG("list_qqstory_troop");
    qyk localqyk = new qyk(getContext(), this.y, 11, this.a, false);
    a(localqyk);
    a(new qzx(getContext(), "FeedSegment", "暂时没有小视频\n你可以在这里查看群内的小视频", 2130847493, 2130847493));
    localqyk.setDisplay(true);
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundColor(-1);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.a.a();
    int i;
    if (paramView.getVisibility() == 0)
    {
      ((InputMethodManager)this.y.getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      paramView.clearFocus();
      paramView.setVisibility(8);
      paramView = paramView.c.a;
      i = rar.a(paramView.getOwner());
      if (!paramView.getOwner().isMe()) {
        break label113;
      }
    }
    label113:
    for (paramView = "1";; paramView = "2")
    {
      rar.a("home_page", "cancel_reply", i, 0, new String[] { paramView, "3", "", "" });
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.activity.TroopStoryListView
 * JD-Core Version:    0.7.0.1
 */