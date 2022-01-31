package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class EmojiUiPlugin$2
  implements View.OnClickListener
{
  EmojiUiPlugin$2(EmojiUiPlugin paramEmojiUiPlugin) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.this$0.activity, EmosmActivity.class);
    paramView.putExtra("key_emojimall_detail_chat_type", this.this$0.getInfoIntent().getIntExtra("key_emojimall_detail_chat_type", -1));
    paramView.putExtra("key_emojimall_detail_chat_uin", this.this$0.getInfoIntent().getStringExtra("key_emojimall_detail_chat_uin"));
    paramView.putExtra("emojimall_src", this.this$0.mSrcFromType);
    this.this$0.activity.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiUiPlugin.2
 * JD-Core Version:    0.7.0.1
 */