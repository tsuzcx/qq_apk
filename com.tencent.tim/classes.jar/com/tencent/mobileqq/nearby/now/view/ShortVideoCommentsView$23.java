package com.tencent.mobileqq.nearby.now.view;

import android.view.View;
import android.widget.ListView;
import com.tencent.mobileqq.nearby.now.model.Comments;
import java.util.List;
import jll;

class ShortVideoCommentsView$23
  implements Runnable
{
  ShortVideoCommentsView$23(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public void run()
  {
    int i = jll.getScreenHeight(this.this$0.getContext());
    if (ShortVideoCommentsView.GH() * this.this$0.a.commentList.size() + ShortVideoCommentsView.b(this.this$0).getMeasuredHeight() >= i)
    {
      ShortVideoCommentsView.a(this.this$0).setSelectionFromTop(1, ShortVideoCommentsView.GH() + ShortVideoCommentsView.b(this.this$0).getMeasuredHeight());
      return;
    }
    ShortVideoCommentsView.a(this.this$0).setSelection(this.this$0.a.commentList.size() + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.23
 * JD-Core Version:    0.7.0.1
 */