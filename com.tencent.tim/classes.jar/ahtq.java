import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.protocol.GetArkTailRsp;
import com.tencent.mobileqq.gamecenter.share.GameShareNetHelper.2.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;

public class ahtq
  implements BusinessObserver
{
  ahtq(ahto paramahto, MessageRecord paramMessageRecord, WeakReference paramWeakReference) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = (GetArkTailRsp)paramBundle.getSerializable("rsp");
    if (QLog.isColorLevel()) {
      QLog.d("GameShare.NetHelper", 2, "GetArkTailRsp reportObserver:" + paramBoolean + "|" + paramBundle + "|msghashcode:" + this.p.hashCode());
    }
    if ((paramBoolean) && (paramBundle != null))
    {
      ahtr.b("game_source_aio_txt", paramBundle.desc, this.p);
      ahtr.b("game_source_aio_url", paramBundle.jump_url, this.p);
      ahtr.b("game_source_type_aio", paramBundle.type + "", this.p);
      ahtr.b("game_source_subtype_aio", paramBundle.sub_type + "", this.p);
      paramBundle = (QQAppInterface)this.eJ.get();
      if (paramBundle != null)
      {
        MqqHandler localMqqHandler = paramBundle.getHandler(ChatActivity.class);
        if (localMqqHandler != null)
        {
          Message localMessage = new Message();
          localMessage.what = 78;
          localMessage.arg1 = 891;
          Bundle localBundle = new Bundle();
          localBundle.putLong("messageUniseq", this.p.uniseq);
          localMessage.setData(localBundle);
          localMqqHandler.sendMessage(localMessage);
        }
        ThreadManager.excute(new GameShareNetHelper.2.1(this, paramBundle), 32, null, false);
      }
    }
    ahto.a(this.b).remove(this.p);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahtq
 * JD-Core Version:    0.7.0.1
 */