package com.tencent.mobileqq.emoticonview;

import afmf;
import afqs;
import android.content.Context;
import android.view.View;

public class SystemAndEmojiEmoticonPanelWithActionBar
  extends SystemAndEmojiEmoticonPanel
{
  protected View BY;
  public afmf g;
  
  public SystemAndEmojiEmoticonPanelWithActionBar(Context paramContext, afmf paramafmf)
  {
    super(paramContext, paramafmf);
  }
  
  protected void a(Context paramContext, afmf paramafmf)
  {
    super.a(paramContext, paramafmf);
    this.g = paramafmf;
    this.BY = findViewById(2131377990);
    this.BY.setOnClickListener(new afqs(this));
  }
  
  protected int getLayoutId()
  {
    return 2131559297;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanelWithActionBar
 * JD-Core Version:    0.7.0.1
 */