package com.tencent.qqmini.minigame;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

class GamePage$3
  implements Runnable
{
  GamePage$3(GamePage paramGamePage, String paramString1, String paramString2, boolean paramBoolean) {}
  
  public void run()
  {
    int i = 0;
    GamePage.access$500(this.this$0);
    if ((GamePage.access$600(this.this$0) != null) && (!TextUtils.isEmpty(this.val$debuggerTxt))) {
      GamePage.access$600(this.this$0).setText(this.val$debuggerTxt);
    }
    if (!TextUtils.isEmpty(this.val$debuggerToast)) {
      Toast.makeText(GamePage.access$000(this.this$0), this.val$debuggerToast, 0).show();
    }
    View localView;
    if (GamePage.access$700(this.this$0) != null)
    {
      localView = GamePage.access$700(this.this$0);
      if (!this.val$showBreakPoint) {
        break label102;
      }
    }
    for (;;)
    {
      localView.setVisibility(i);
      return;
      label102:
      i = 8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GamePage.3
 * JD-Core Version:    0.7.0.1
 */