import android.os.Handler;
import android.os.SystemClock;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherManager.RunnableShowForKey;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aino
  implements aipt
{
  public aino(ListenTogetherManager paramListenTogetherManager) {}
  
  public void Lj(boolean paramBoolean)
  {
    QLog.i("ListenTogether.Manager", 1, "onNetChanged: " + paramBoolean);
    if (paramBoolean) {
      ListenTogetherManager.b(this.this$0);
    }
  }
  
  public void cf(boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.i("ListenTogether.Manager", 1, "onFocusChanged: " + paramBoolean1 + " isTransient:" + paramBoolean2);
    ListenTogetherManager.a(this.this$0, paramBoolean1);
    if (paramBoolean1)
    {
      ListenTogetherManager.a(this.this$0).removeCallbacks(ListenTogetherManager.a(this.this$0));
      ListenTogetherManager.a(this.this$0).postDelayed(ListenTogetherManager.a(this.this$0), ListenTogetherManager.a(this.this$0));
      ListenTogetherManager.b(this.this$0).setKey(ListenTogetherManager.b(this.this$0));
      ListenTogetherManager.a(this.this$0).postDelayed(ListenTogetherManager.b(this.this$0), ListenTogetherManager.a(this.this$0));
      ListenTogetherManager.a(this.this$0, 0L);
      return;
    }
    ListenTogetherManager.a(this.this$0).removeCallbacks(ListenTogetherManager.a(this.this$0));
    ListenTogetherManager.a(this.this$0).removeCallbacks(ListenTogetherManager.b(this.this$0));
    ListenTogetherManager.a(this.this$0).setKey(ListenTogetherManager.b(this.this$0));
    ListenTogetherManager.a(this.this$0).postDelayed(ListenTogetherManager.a(this.this$0), ListenTogetherManager.a(this.this$0));
    if (paramBoolean2)
    {
      ListenTogetherManager.a(this.this$0, 0L);
      return;
    }
    ListenTogetherManager.a(this.this$0, SystemClock.elapsedRealtime());
  }
  
  public void eS(String paramString, int paramInt)
  {
    QLog.d("ListenTogether.Manager", 1, new Object[] { "onPlayStateChanged: " + aipo.bA(paramInt), " songId:", paramString, " curSongID:", QQMusicPlayService.a().getId() });
    HashMap localHashMap = new HashMap();
    if (paramInt == 8)
    {
      ListenTogetherManager.a(this.this$0);
      if (paramInt != 2) {
        break label302;
      }
      if (ListenTogetherManager.a(this.this$0).isPlaying())
      {
        ListenTogetherManager.a(this.this$0).Zx();
        ListenTogetherManager.a(this.this$0).resetState();
      }
      ListenTogetherManager.a(this.this$0).removeCallbacks(ListenTogetherManager.a(this.this$0));
      ListenTogetherManager.b(this.this$0).setKey(ListenTogetherManager.b(this.this$0));
      ListenTogetherManager.a(this.this$0).postDelayed(ListenTogetherManager.b(this.this$0), ListenTogetherManager.a(this.this$0));
      localHashMap.put("status", String.valueOf(paramInt));
      label190:
      if (paramInt != 2) {
        break label381;
      }
      ListenTogetherManager.a(this.this$0).removeMessages(1001);
      ListenTogetherManager.a(this.this$0).sendEmptyMessageDelayed(1001, aini.a().abL);
    }
    for (;;)
    {
      ListenTogetherManager.a(this.this$0, paramString, paramInt);
      if (!localHashMap.isEmpty()) {
        anpc.a(BaseApplication.getContext()).collectPerformance("", "listen_together_player_status", true, 0L, 0L, localHashMap, "");
      }
      if (QQMusicPlayService.a() != null) {
        akum.b().Sn(paramInt);
      }
      return;
      if ((paramInt != 5) && (paramInt != 7)) {
        break;
      }
      localHashMap.put("status", String.valueOf(paramInt));
      break;
      label302:
      if ((paramInt != 4) && (paramInt != 5) && (paramInt != 7)) {
        break label190;
      }
      ListenTogetherManager.a(this.this$0).removeCallbacks(ListenTogetherManager.b(this.this$0));
      ListenTogetherManager.a(this.this$0).setKey(ListenTogetherManager.b(this.this$0));
      ListenTogetherManager.a(this.this$0).postDelayed(ListenTogetherManager.a(this.this$0), ListenTogetherManager.a(this.this$0));
      break label190;
      label381:
      ListenTogetherManager.a(this.this$0).removeMessages(1001);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aino
 * JD-Core Version:    0.7.0.1
 */