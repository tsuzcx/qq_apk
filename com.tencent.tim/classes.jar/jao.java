import android.content.Intent;
import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion.6.1;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion.AutoCheckVideoRunnable;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase.InviteUserNoticeRunnable;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class jao
  extends iid
{
  public jao(MultiVideoCtrlLayerUI4Discussion paramMultiVideoCtrlLayerUI4Discussion) {}
  
  protected void R(int paramInt, String paramString)
  {
    super.R(paramInt, paramString);
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "onInviteUserNotice --> Count = " + paramInt + " ,firstName = " + paramString);
    }
    if (this.this$0.mApp != null)
    {
      if (aqjl.cW(this.this$0.mApp.w(String.valueOf(this.this$0.md)))) {
        paramString = this.this$0.jdField_a_of_type_ComTencentAvVideoController.d(this.this$0.mApp.getCurrentAccountUin(), String.valueOf(this.this$0.md), this.this$0.aqx);
      }
      this.this$0.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$InviteUserNoticeRunnable.ag(paramInt, paramString);
      this.this$0.mApp.getHandler().postDelayed(this.this$0.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$InviteUserNoticeRunnable, 500L);
    }
  }
  
  protected void amA()
  {
    if (this.this$0.aqx != 2) {
      return;
    }
    this.this$0.O(0L, 65535);
  }
  
  protected void amB()
  {
    super.amB();
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "onUpdatePstnInfo --> Start");
    }
    AVActivity localAVActivity = (AVActivity)this.this$0.mContext.get();
    if (localAVActivity != null) {
      localAVActivity.runOnUiThread(new MultiVideoCtrlLayerUI4Discussion.6.1(this));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e(this.this$0.TAG, 2, "onUpdatePstnInfo-->Can not get AVActivity");
  }
  
  protected void b(String paramString, String[] paramArrayOfString)
  {
    super.b(paramString, paramArrayOfString);
    long l = this.this$0.mApp.w(String.valueOf(this.this$0.md));
    if (QLog.isColorLevel())
    {
      String str = this.this$0.jdField_a_of_type_ComTencentAvVideoController.d(paramString, String.valueOf(this.this$0.md), this.this$0.aqx);
      QLog.d(this.this$0.TAG, 2, "onOtherMemberInvited --> l= " + String.valueOf(l) + "inviterName=" + str);
    }
    if (aqjl.cW(l))
    {
      this.this$0.d(paramString, paramArrayOfString);
      return;
    }
    this.this$0.c(paramString, paramArrayOfString);
  }
  
  protected void l(long paramLong, int paramInt1, int paramInt2)
  {
    this.this$0.v(paramLong, paramInt1, paramInt2);
  }
  
  protected void o(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.this$0.TAG, 1, "onInviteSomeoneEnter, firstUin[" + paramLong + "], length[" + paramInt + "]");
    }
    super.o(paramLong, paramInt);
    this.this$0.awE = paramInt;
    this.this$0.a(paramLong, 68, true, -1, 0);
  }
  
  protected void onServiceConnected()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "onServiceConnected");
    }
    super.onServiceConnected();
    if (this.this$0.md != 0L)
    {
      int i = this.this$0.mUinType;
      Object localObject = String.valueOf(this.this$0.md);
      this.this$0.mApp.T(i, (String)localObject);
      if ((this.this$0.awD == 0) && (this.this$0.jdField_a_of_type_ComTencentAvVideoController != null))
      {
        Intent localIntent = this.this$0.getIntent();
        if ((localIntent == null) || (!localIntent.hasExtra("invitelist")))
        {
          localObject = this.this$0.mApp.a((String)localObject);
          if (localObject != null)
          {
            this.this$0.jdField_a_of_type_ComTencentAvVideoController.a((long[])localObject);
            this.this$0.jdField_a_of_type_ComTencentAvVideoController.a((long[])localObject, false);
          }
        }
      }
    }
  }
  
  protected void y(long paramLong1, long paramLong2)
  {
    if (this.this$0.isDestroyed()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w(this.this$0.TAG, 1, "onCreateRoomSuc, groupId[" + paramLong2 + "], isVideo[" + this.this$0.isVideo + "], seq[" + paramLong1 + "]");
    }
    if (this.this$0.isVideo)
    {
      i = 2;
      anon.aj(i, this.this$0.jdField_a_of_type_ComTencentAvVideoController.bw() + "");
      if (!this.this$0.isVideo) {
        break label245;
      }
    }
    label245:
    for (int i = 4;; i = 3)
    {
      jfq.aj(i, this.this$0.jdField_a_of_type_ComTencentAvVideoController.bw() + "");
      this.this$0.atn();
      this.this$0.dq(paramLong1);
      this.this$0.jdField_a_of_type_Jkz.lj(true);
      this.this$0.jdField_a_of_type_Jkz.li(true);
      this.this$0.jdField_a_of_type_Jkz.onConnected();
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().QX = true;
      this.this$0.p(true, paramLong2);
      return;
      i = 1;
      break;
    }
  }
  
  protected void z(long paramLong1, long paramLong2)
  {
    if (this.this$0.isDestroyed()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w(this.this$0.TAG, 1, "onEnterRoomSuc, groupId[" + paramLong2 + "], seq[" + paramLong1 + "]");
    }
    if (this.this$0.isVideo)
    {
      i = 4;
      jfq.aj(i, this.this$0.jdField_a_of_type_ComTencentAvVideoController.bw() + "");
      if (!this.this$0.isVideo) {
        break label269;
      }
    }
    label269:
    for (int i = 2;; i = 1)
    {
      anon.aj(i, this.this$0.jdField_a_of_type_ComTencentAvVideoController.bw() + "");
      this.this$0.atn();
      this.this$0.dq(paramLong1);
      this.this$0.jdField_a_of_type_Jkz.lj(true);
      this.this$0.jdField_a_of_type_Jkz.li(true);
      this.this$0.jdField_a_of_type_Jkz.onConnected();
      this.this$0.mApp.getHandler().postDelayed(new MultiVideoCtrlLayerUI4Discussion.AutoCheckVideoRunnable(this.this$0), 500L);
      this.this$0.atp();
      this.this$0.p(false, paramLong2);
      this.this$0.O(paramLong1, 65535);
      this.this$0.asB();
      return;
      i = 3;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jao
 * JD-Core Version:    0.7.0.1
 */