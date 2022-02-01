package com.tencent.qqmail.bottle.view;

import android.view.View;
import android.view.animation.Animation;
import android.widget.ListView;

public class BottleConversationReply
{
  private static final String TAG = BottleConversationReply.class.getSimpleName();
  
  public static void animateRemoval(ListView paramListView, Runnable paramRunnable)
  {
    View localView = paramListView.getChildAt(paramListView.getHeaderViewsCount() + paramListView.getFirstVisiblePosition());
    BottleConversationReply.1 local1 = new BottleConversationReply.1(localView.getMeasuredHeight(), localView);
    local1.setAnimationListener(new BottleConversationReply.2(paramRunnable, paramListView));
    paramListView.invalidate();
    paramListView.setEnabled(false);
    local1.setDuration('È');
    localView.startAnimation(local1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.view.BottleConversationReply
 * JD-Core Version:    0.7.0.1
 */