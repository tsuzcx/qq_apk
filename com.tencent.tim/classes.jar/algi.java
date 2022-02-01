import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public class algi
  implements Handler.Callback
{
  public algi(ProfileHeaderView paramProfileHeaderView) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(ProfileHeaderView.TAG, 4, String.format(Locale.getDefault(), "mUICallback [%d]", new Object[] { Integer.valueOf(paramMessage.what) }));
    }
    if (ProfileHeaderView.dti == paramMessage.what)
    {
      if (QLog.isColorLevel()) {
        QLog.d(ProfileHeaderView.TAG, 2, "ProfileHeaderView handleMessage msg what is check tips time=" + this.this$0.dth);
      }
      if ((this.this$0.dA.get()) && (this.this$0.dz.get())) {
        this.this$0.p(this.this$0.a);
      }
    }
    do
    {
      do
      {
        return true;
      } while (ProfileHeaderView.dtj != paramMessage.what);
      localObject = (View)this.this$0.mt.get("map_key_avatar_pendant");
    } while (!(localObject instanceof ImageView));
    Object localObject = (ImageView)localObject;
    paramMessage = (ExtensionInfo)paramMessage.obj;
    if ((paramMessage != null) && (paramMessage.isPendantValid()))
    {
      this.this$0.pendantId = paramMessage.pendantId;
      AvatarPendantManager localAvatarPendantManager = (AvatarPendantManager)this.this$0.app.getManager(46);
      ((ImageView)localObject).setVisibility(0);
      if (aqgm.cT(this.this$0.pendantId))
      {
        localAvatarPendantManager.a(this.this$0.pendantId).a((View)localObject, 2, PendantInfo.ebM, paramMessage.uin, paramMessage.pendantDiyId);
        return true;
      }
      localAvatarPendantManager.a(this.this$0.pendantId).a((View)localObject, 1, PendantInfo.ebM, paramMessage.uin, paramMessage.pendantDiyId);
      return true;
    }
    ((ImageView)localObject).setVisibility(4);
    this.this$0.pendantId = 0L;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     algi
 * JD-Core Version:    0.7.0.1
 */