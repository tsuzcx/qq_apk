package com.tencent.mobileqq.minigame.ui;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;

class GameActivity$18
  implements Runnable
{
  GameActivity$18(GameActivity paramGameActivity) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param_proc_name", BaseApplicationImpl.getApplication().getQQProcessName());
    localBundle.putString("param_proc_modulename", "mini_app_client_module");
    this.this$0.onProcessBackground(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.18
 * JD-Core Version:    0.7.0.1
 */