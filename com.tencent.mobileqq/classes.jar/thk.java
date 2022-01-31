import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.util.WeakReference;

public class thk
  extends Handler
{
  private final WeakReference<WSPlayerManager> a;
  
  public thk(WSPlayerManager paramWSPlayerManager, Looper paramLooper)
  {
    super(paramLooper);
    this.a = new WeakReference(paramWSPlayerManager);
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    WSPlayerManager localWSPlayerManager = (WSPlayerManager)this.a.get();
    if ((localWSPlayerManager == null) || (WSPlayerManager.e(localWSPlayerManager))) {}
    do
    {
      return;
      if (!(paramMessage.obj instanceof thl)) {
        break;
      }
    } while (!WSPlayerManager.a(localWSPlayerManager, (thl)paramMessage.obj));
    super.dispatchMessage(paramMessage);
    return;
    super.dispatchMessage(paramMessage);
  }
  
  public void handleMessage(Message paramMessage)
  {
    WSPlayerManager localWSPlayerManager = (WSPlayerManager)this.a.get();
    if (localWSPlayerManager == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case -4: 
      localObject = new StringBuilder().append("[WSPlayerManager.java][handleMessage] MSG_PLAY_BY_URL_FAILED. playerStartByUrl failed, retry again. RetryVideoUrl:");
      if (WSPlayerManager.b(localWSPlayerManager).jdField_a_of_type_Thp == null) {
        break;
      }
    case -3: 
      for (paramMessage = WSPlayerManager.b(localWSPlayerManager).jdField_a_of_type_Thp.b;; paramMessage = "videoInfo is null.")
      {
        tlo.d("WS_VIDEO_PLAYER", paramMessage);
        if (WSPlayerManager.a(localWSPlayerManager) == 1) {
          break;
        }
        WSPlayerManager.b(localWSPlayerManager).jdField_a_of_type_Boolean = false;
        WSPlayerManager.a(localWSPlayerManager, WSPlayerManager.b(localWSPlayerManager));
        WSPlayerManager.a(localWSPlayerManager, WSPlayerManager.b(localWSPlayerManager), false);
        WSPlayerManager.b(localWSPlayerManager);
        return;
        tlo.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][handleMessage] MSG_PRE_PLAY_TIME_OUT. prePlay timeout, try rePlay");
        paramMessage = WSPlayerManager.a(localWSPlayerManager, WSPlayerManager.b(localWSPlayerManager));
        if ((paramMessage != null) && (paramMessage.d()) && (paramMessage.a() == WSPlayerManager.b(localWSPlayerManager).jdField_a_of_type_Thp))
        {
          tlo.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][handleMessage] MSG_PRE_PLAY_TIME_OUT. startVideoAfterPrepared!");
          WSPlayerManager.a(localWSPlayerManager).a();
          return;
        }
        WSPlayerManager.b(localWSPlayerManager).jdField_a_of_type_Boolean = false;
        WSPlayerManager.a(localWSPlayerManager, WSPlayerManager.b(localWSPlayerManager));
        WSPlayerManager.a(localWSPlayerManager, WSPlayerManager.b(localWSPlayerManager), false);
        return;
      }
    }
    paramMessage = WSPlayerManager.a(localWSPlayerManager);
    Object localObject = WSPlayerManager.b(localWSPlayerManager);
    long l1;
    boolean bool;
    if ((paramMessage != null) && (paramMessage.b()) && ((((thl)localObject).jdField_a_of_type_Thf == null) || (!((thl)localObject).jdField_a_of_type_Thf.a((thl)localObject))) && (!paramMessage.e()))
    {
      l1 = paramMessage.a();
      long l2 = paramMessage.b();
      if (((thl)localObject).jdField_a_of_type_Thf != null) {
        ((thl)localObject).jdField_a_of_type_Thf.a((thl)localObject, l1, l2);
      }
      if (l1 < l2 - 300L) {
        break label508;
      }
      WSPlayerManager.e(localWSPlayerManager, true);
      int i = (int)(l2 - l1);
      tlo.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][handleMessage] MSG_FOR_UPDATE_VIDEO_PLAY_POSITION onVideoEndSoon pos:" + l1 + ", duration:" + l2 + ", remainDuration:" + i + ", mHasCallEndingSoon:" + WSPlayerManager.f(localWSPlayerManager));
      if ((!WSPlayerManager.f(localWSPlayerManager)) && (WSPlayerManager.a(localWSPlayerManager) != null))
      {
        WSPlayerManager.f(localWSPlayerManager, true);
        if ((((thl)localObject).jdField_a_of_type_Thf != null) && (!WSPlayerManager.g(localWSPlayerManager)))
        {
          if ((!WSPlayerManager.h(localWSPlayerManager)) && (!WSPlayerManager.i(localWSPlayerManager))) {
            break label502;
          }
          bool = true;
          ((thl)localObject).jdField_a_of_type_Thf.a(WSPlayerManager.b(localWSPlayerManager), i, bool);
        }
      }
    }
    for (;;)
    {
      WSPlayerManager.a(localWSPlayerManager).sendEmptyMessageDelayed(-2, 100L);
      return;
      label502:
      bool = false;
      break;
      label508:
      if ((l1 <= 500L) && (l1 >= 0L) && (WSPlayerManager.j(localWSPlayerManager)))
      {
        tlo.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][handleMessage] MSG_FOR_UPDATE_VIDEO_PLAY_POSITION onVideoReplayOnLoop pos:" + l1);
        WSPlayerManager.g(localWSPlayerManager, false);
        WSPlayerManager.f(localWSPlayerManager, false);
        WSPlayerManager.e(localWSPlayerManager, false);
        WSPlayerManager.c(localWSPlayerManager);
        paramMessage.i();
        paramMessage.j();
        if (WSPlayerManager.a(localWSPlayerManager) != null)
        {
          paramMessage = WSPlayerManager.a(localWSPlayerManager).iterator();
          while (paramMessage.hasNext()) {
            ((thm)paramMessage.next()).a(WSPlayerManager.b(localWSPlayerManager), WSPlayerManager.d(localWSPlayerManager));
          }
        }
      }
    }
  }
  
  public boolean sendMessageAtTime(Message paramMessage, long paramLong)
  {
    WSPlayerManager localWSPlayerManager = (WSPlayerManager)this.a.get();
    if ((localWSPlayerManager == null) || (WSPlayerManager.e(localWSPlayerManager))) {
      return false;
    }
    if ((Looper.myLooper() == Looper.getMainLooper()) && (paramLong <= SystemClock.uptimeMillis()))
    {
      if (paramMessage.getCallback() != null) {
        paramMessage.getCallback().run();
      }
      for (;;)
      {
        return true;
        handleMessage(paramMessage);
      }
    }
    if (paramMessage.obj == null) {
      paramMessage.obj = WSPlayerManager.b(localWSPlayerManager);
    }
    return super.sendMessageAtTime(paramMessage, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     thk
 * JD-Core Version:    0.7.0.1
 */