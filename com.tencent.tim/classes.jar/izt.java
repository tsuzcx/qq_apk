import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiIncomingCallUICtr.3.1;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class izt
  extends iid
{
  izt(izr paramizr) {}
  
  protected void bJ(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiIncomingCallUICtr", 2, "notifyCloseAllGroupVideoInviteMsgBox-->GroupID=" + paramLong);
    }
    if (this.this$0.mGroupId != paramLong) {
      this.this$0.cx(0);
    }
    this.this$0.onDestroy();
  }
  
  protected void bK(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiIncomingCallUICtr", 2, "notifyCloseGroupVideoInviteMsgBox-->GroupID=" + paramLong);
    }
    if (this.this$0.mGroupId == paramLong) {
      this.this$0.onDestroy();
    }
  }
  
  protected void d(long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiIncomingCallUICtr.troopgroup_vedio.invite", 2, "groupId:" + paramLong1 + ", memUin:" + paramLong2 + ",invitedId:" + paramString + ", mInviterUin:" + this.this$0.mf + ", mGroupId:" + this.this$0.mGroupId);
    }
    if ((paramLong2 == this.this$0.mf) && (paramLong1 == this.this$0.mGroupId)) {
      this.this$0.onDestroy();
    }
  }
  
  protected void l(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiIncomingCallUICtr", 2, "notifyCloseGroupVideoInviteMsgBoxByInviteId-->GroupID=" + paramLong);
    }
    if ((this.this$0.mGroupId == paramLong) && (this.this$0.OG.equals(paramString))) {
      this.this$0.onDestroy();
    }
  }
  
  protected void n(long paramLong, int paramInt)
  {
    if (this.this$0.Td)
    {
      long l = AudioHelper.hG();
      if (QLog.isColorLevel()) {
        QLog.w("MultiIncomingCallUICtr", 1, "onDestroyInviteUI, groupId[" + paramLong + "], mPeerUin[" + this.this$0.mPeerUin + "], seq[" + l + "]");
      }
      if ((this.this$0.mPeerUin != null) && (this.this$0.mPeerUin.equals(String.valueOf(paramLong))))
      {
        this.this$0.H(l, paramInt);
        this.this$0.onDestroy();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiIncomingCallUICtr", 2, "onDestroyInviteUI, groupId:" + paramLong + ", reason:" + paramInt + ", mGroupId:" + this.this$0.mGroupId);
      }
      return;
      if ((this.this$0.mGroupId == paramLong) || (0L == paramLong)) {
        this.this$0.onDestroy();
      }
    }
  }
  
  protected void y(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiIncomingCallUICtr", 2, "onCreateRoomSuc-->GroupID=" + paramLong2);
    }
    this.this$0.e.QX = true;
    if (this.this$0.mUinType == 1) {
      this.this$0.mApp.ak(paramLong2);
    }
  }
  
  protected void z(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.w("MultiIncomingCallUICtr", 1, "onEnterRoomSuc, groupId[" + paramLong2 + "], seq[" + paramLong1 + "]");
    }
    this.this$0.mApp.getHandler().postDelayed(new MultiIncomingCallUICtr.3.1(this, paramLong2), 500L);
    this.this$0.asW();
    ivm.a(this.this$0.mApp).x(paramLong1, false);
    if (this.this$0.a != null) {
      this.this$0.a.avn();
    }
    this.this$0.mApp.getHandler().postDelayed(this.this$0.bf, 1000L);
    TraeHelper.a().startService(this.this$0.QK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     izt
 * JD-Core Version:    0.7.0.1
 */