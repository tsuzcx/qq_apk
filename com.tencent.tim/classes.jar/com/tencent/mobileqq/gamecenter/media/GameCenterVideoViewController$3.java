package com.tencent.mobileqq.gamecenter.media;

import ahty;
import android.os.Handler;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import java.util.concurrent.atomic.AtomicInteger;
import kwz;

class GameCenterVideoViewController$3
  implements Runnable
{
  GameCenterVideoViewController$3(GameCenterVideoViewController paramGameCenterVideoViewController) {}
  
  public void run()
  {
    QLog.e("GameCenterVideoViewController", 1, "[onVideoPrepared] status:" + GameCenterVideoViewController.a(this.this$0).get() + ",sPlayCount = " + GameCenterVideoViewController.daZ + ",ConfigCount=" + ahty.dbb);
    if (GameCenterVideoViewController.a(this.this$0).get() == 5) {
      return;
    }
    this.this$0.setCurrentStatus(2);
    this.this$0.start();
    if (GameCenterVideoViewController.a(this.this$0) == 2)
    {
      int i = GameCenterVideoViewController.daZ + 1;
      GameCenterVideoViewController.daZ = i;
      if ((i >= ahty.dbb) && (ahty.mR(GameCenterVideoViewController.a(this.this$0).gameInfo.gameAppId)))
      {
        GameCenterVideoViewController.daZ = 0;
        GameCenterVideoViewController.a(this.this$0).sendEmptyMessageDelayed(14, ahty.dbc - GameCenterVideoViewController.a(this.this$0));
      }
    }
    long l = GameCenterVideoViewController.a(this.this$0).getDurationMs();
    GameCenterVideoViewController.a(this.this$0).setMax((int)l);
    GameCenterVideoViewController.a(this.this$0).setText(kwz.ba((int)l / 1000));
    this.this$0.dpM();
    if (GameCenterVideoViewController.a(this.this$0).type == 2) {
      GameCenterVideoViewController.a(this.this$0).sendEmptyMessage(5);
    }
    this.this$0.dpQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.3
 * JD-Core Version:    0.7.0.1
 */