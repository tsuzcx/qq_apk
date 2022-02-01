package com.tencent.mobileqq.minigame.ui;

import aeaz.b;
import android.os.Bundle;
import asuh.a;
import com.tencent.qphone.base.util.QLog;

class GameActivity1$3
  extends aeaz.b
{
  GameActivity1$3(GameActivity1 paramGameActivity1) {}
  
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    super.onAddColorNote(paramBundle, paramBoolean);
    QLog.e("qqBaseActivity", 1, "[ColorNote exist]");
    if (GameActivity1.access$100(this.this$0) != null)
    {
      GameActivity1.access$100(this.this$0).onAddColorSign(paramBoolean);
      GameActivity1.access$102(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity1.3
 * JD-Core Version:    0.7.0.1
 */