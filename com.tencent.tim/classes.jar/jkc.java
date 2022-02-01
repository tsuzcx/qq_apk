import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.b;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class jkc
  extends BroadcastReceiver
{
  jkc(jkb paramjkb) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    jkb.b localb;
    if (paramIntent.getAction().equals("tencent.video.q2v.getNearByProfile"))
    {
      paramContext = paramIntent.getStringExtra("uin");
      localb = new jkb.b(this.c);
      localb.uin = paramContext;
      localb.nickname = paramIntent.getStringExtra("nickname");
      localb.gender = paramIntent.getIntExtra("gender", -1);
      localb.age = paramIntent.getIntExtra("age", 0);
      localb.constellation = paramIntent.getByteExtra("constellation", (byte)-1);
      paramIntent = igv.a().c(this.c.mSessionId);
      if (paramIntent != null) {
        break label98;
      }
    }
    label98:
    do
    {
      return;
      if (this.c.a != null)
      {
        VideoController.b localb1 = this.c.a.a(paramContext);
        if (localb1 != null)
        {
          this.c.a.h(paramContext, localb.nickname, false);
          localb1.gender = localb.gender;
        }
        if (paramContext.equals(this.c.mApp.getAccount()))
        {
          paramIntent.a.anC = localb.gender;
          paramIntent.a.Nd = localb.nickname;
        }
        if (paramContext.equals(paramIntent.peerUin))
        {
          paramIntent.a.anB = localb.gender;
          paramIntent.a.nickName = localb.nickname;
        }
      }
    } while ((this.c.b == null) || (!this.c.fG.contains(paramContext)));
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPeopleProfileHelper", 2, "onGetNearbyPeopleProfile uin :" + paramContext + ", nickname:" + localb.nickname + ", gender:" + localb.gender);
    }
    this.c.b.a(paramContext, localb);
    this.c.fG.remove(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jkc
 * JD-Core Version:    0.7.0.1
 */