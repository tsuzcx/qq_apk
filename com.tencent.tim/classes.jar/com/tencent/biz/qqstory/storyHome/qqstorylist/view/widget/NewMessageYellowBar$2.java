package com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget;

import android.widget.TextView;
import java.util.Locale;

class NewMessageYellowBar$2
  implements Runnable
{
  NewMessageYellowBar$2(NewMessageYellowBar paramNewMessageYellowBar, int paramInt) {}
  
  public void run()
  {
    this.this$0.mTextView.setText(String.format(Locale.getDefault(), "%d个小视频更新", new Object[] { Integer.valueOf(this.val$count) }));
    this.this$0.mTextView.startAnimation(this.this$0.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.NewMessageYellowBar.2
 * JD-Core Version:    0.7.0.1
 */