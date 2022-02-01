package com.tencent.mobileqq.gamecenter.view;

import ahta;
import android.os.Handler;
import com.tencent.TMG.utils.QLog;
import java.util.List;
import mqq.app.AppRuntime;

class GameSessionView$2
  implements Runnable
{
  GameSessionView$2(GameSessionView paramGameSessionView) {}
  
  public void run()
  {
    if (GameSessionView.a(this.this$0) == null) {}
    ahta localahta;
    List localList;
    do
    {
      return;
      localahta = (ahta)GameSessionView.a(this.this$0).getManager(358);
      localList = localahta.fi();
      if (localahta.anX()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(GameSessionView.TAG, 0, "[setData] gray is not open. return.");
    return;
    if (!GameSessionView.a(this.this$0))
    {
      GameSessionView.a(this.this$0, 1);
      GameSessionView.a(this.this$0, localahta.cif);
      GameSessionView.b(this.this$0, true);
    }
    GameSessionView.a(this.this$0).post(new GameSessionView.2.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GameSessionView.2
 * JD-Core Version:    0.7.0.1
 */