package com.tencent.biz.qqstory.msgTabNode.view;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.views.RoundBorderImageView;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.playvideo.StoryPlayerActivity.a;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationParam;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.dispatch.Dispatcher;
import pmi;
import puy;
import pvv;
import pvz;
import ram;
import wja;

public class MsgTabStoryNodeDelegate$3
  implements Runnable
{
  public MsgTabStoryNodeDelegate$3(pvv parampvv, String paramString) {}
  
  public void run()
  {
    int j = this.this$0.a.a.mRecyclerView.getChildCount();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Object localObject = this.this$0.a.a.mRecyclerView.getChildAt(i);
        if ((TextUtils.equals(this.atK, String.valueOf(((View)localObject).getTag()))) && ((localObject instanceof StoryMsgNodeFrameLayout)))
        {
          localObject = (StoryMsgNodeFrameLayout)localObject;
          if (localObject != null)
          {
            Rect localRect = new Rect();
            ((StoryMsgNodeFrameLayout)localObject).getGlobalVisibleRect(localRect);
            puy localpuy = (puy)this.this$0.mApp.getManager(251);
            localpuy.bkx = (localRect.left + ((StoryMsgNodeFrameLayout)localObject).getWidth() / 2);
            localpuy.bky = (localRect.top + ((StoryMsgNodeFrameLayout)localObject).getHeight() / 2);
            ram.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "handlePlayModeSwitchNode findView. x=%d, y=%d, rect=%s", Integer.valueOf(localpuy.bkx), Integer.valueOf(localpuy.bky), String.valueOf(localRect));
            RoundBorderImageView localRoundBorderImageView = ((StoryMsgNodeFrameLayout)localObject).a;
            localRoundBorderImageView.getGlobalVisibleRect(localRect);
            localpuy.bkz = (localRect.top + localRoundBorderImageView.getPaddingTop());
            localpuy.bkA = (localRect.left + localRoundBorderImageView.getPaddingLeft());
            localpuy.bkB = (localRect.width() - localRoundBorderImageView.getPaddingLeft() - localRoundBorderImageView.getPaddingRight());
            localpuy.bkC = (localRect.height() - localRoundBorderImageView.getPaddingTop() - localRoundBorderImageView.getPaddingBottom());
            localpuy.bkD = wja.dp2px(8.0F, this.this$0.a.a.getResources());
            pmi.a().dispatch(new StoryPlayerActivity.a(new AnimationParam(((StoryMsgNodeFrameLayout)localObject).a, false), null));
          }
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate.3
 * JD-Core Version:    0.7.0.1
 */