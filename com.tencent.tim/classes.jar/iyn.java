import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.DoubleVideoMeetingCtrlUI;
import com.tencent.av.ui.DoubleVideoMeetingCtrlUI.2.1;
import com.tencent.av.ui.QavPanel;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class iyn
  extends iid
{
  public iyn(DoubleVideoMeetingCtrlUI paramDoubleVideoMeetingCtrlUI) {}
  
  protected void A(long paramLong1, long paramLong2)
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w(this.this$0.TAG, 1, "onMemberVideoIn, groupId[" + paramLong1 + "], friendUin[" + paramLong2 + "], seq[" + l + "]");
    }
    this.this$0.b(l, paramLong1, paramLong2, 1);
  }
  
  protected void B(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVShare", 2, "onMeetingNotifyTimeout, relationId[" + paramLong2 + "]");
    }
    iiv localiiv = this.this$0.jdField_a_of_type_ComTencentAvVideoController.b();
    if ((paramLong2 == this.this$0.ow) && (localiiv.ll == paramLong2)) {
      this.this$0.a(paramLong1, localiiv, 3);
    }
  }
  
  protected void a(long paramLong1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, int paramInt2)
  {
    if (this.this$0.isDestroyed()) {}
    label381:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.w(this.this$0.TAG, 1, "onGaOperationResult, result[" + paramInt1 + "], uin[" + paramLong2 + "], info[" + paramLong3 + "], groupId[" + paramLong4 + "], relationType[" + paramInt2 + "], mCameraNum[" + this.this$0.aoI + "], seq[" + paramLong1 + "]");
      }
      iiv localiiv = this.this$0.jdField_a_of_type_ComTencentAvVideoController.b();
      switch (paramInt1)
      {
      case 93: 
      case 94: 
      case 95: 
      case 97: 
      case 98: 
      default: 
        return;
      case 90: 
        if (paramLong3 == 3L) {
          if (this.this$0.jdField_a_of_type_ComTencentAvUiQavPanel != null)
          {
            if (this.this$0.aoI <= 1) {
              break label381;
            }
            this.this$0.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131374253, 0);
          }
        }
        break;
      case 96: 
        for (;;)
        {
          if ((!localiiv.PY) || (this.this$0.Wl))
          {
            this.this$0.Wl = false;
            this.this$0.da(paramLong1);
            paramInt1 = localiiv.b(this.this$0.mSelfUin, 1);
            boolean bool = false;
            if (paramInt1 != -1) {
              bool = ((ioa)localiiv.jdField_if.get(paramInt1)).Tp;
            }
            this.this$0.mApp.l(new Object[] { Integer.valueOf(105), Boolean.valueOf(bool), Long.valueOf(paramLong1) });
          }
          DoubleVideoMeetingCtrlUI.a(this.this$0, paramLong1);
          return;
          if ((paramLong3 != 1L) || (localiiv.Ra)) {
            break;
          }
          this.this$0.jI("onGaOperationResult->REQUEST_VIDEO_SUC");
          this.this$0.f(paramLong1, localiiv.jdField_if);
          return;
          this.this$0.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131374253, 8);
        }
      }
    } while ((paramLong3 == 2L) || (paramLong3 != 4L));
    return;
    this.this$0.s(paramLong1, true);
    this.this$0.df(paramLong1);
    this.this$0.mApp.l(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong1) });
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.this$0.TAG, 1, "onMemberVideoOut, groupId[" + paramLong2 + "], friendUin[" + paramLong3 + "], videoSrcType[" + paramInt + "], seq[" + paramLong1 + "]");
    }
    this.this$0.b(paramLong1, paramLong2, paramLong3, 2);
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w(this.this$0.TAG, 1, "onMemberJoin, groupId[" + paramLong1 + "], friendUin[" + paramLong2 + "], isRfresh[" + paramBoolean1 + "], isQQUser[" + paramBoolean2 + "], seq[" + l + "]");
    }
    if (paramLong2 == this.this$0.ow)
    {
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().anz = 1;
      this.this$0.b(l, paramLong1, paramLong2, 5);
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {}
  
  protected void amy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "onGAudioInviteResp");
    }
    AVActivity localAVActivity = (AVActivity)this.this$0.mContext.get();
    if ((localAVActivity != null) && (!localAVActivity.isFinishing())) {
      localAVActivity.runOnUiThread(new DoubleVideoMeetingCtrlUI.2.1(this));
    }
  }
  
  protected void b(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w(this.this$0.TAG, 1, "onMemberLeave, groupId[" + paramLong1 + "], friendUin[" + paramLong2 + "], isQQUser[" + paramBoolean + "], seq[" + l + "]");
    }
    this.this$0.b(l, paramLong1, paramLong2, 6);
  }
  
  protected void b(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w(this.this$0.TAG, 1, "onGaMemberShareSrcInOrOut, groupId[" + paramLong1 + "], groupId[" + paramLong1 + "], bIn[" + paramBoolean1 + "], isPPT[" + paramBoolean2 + "], seq[" + l + "]");
    }
    if (paramBoolean1) {
      this.this$0.b(l, paramLong1, paramLong2, 3);
    }
    for (;;)
    {
      this.this$0.Wk = paramBoolean2;
      return;
      this.this$0.b(l, paramLong1, paramLong2, 4);
    }
  }
  
  protected void bG(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "onDestory UI-->relationId = " + paramLong);
    }
    if (this.this$0.ow == paramLong) {
      this.this$0.jg(true);
    }
  }
  
  protected void n(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "onDestroyInviteUI-->GroupId = " + paramLong);
    }
    if (paramLong == this.this$0.ow)
    {
      super.bG(paramLong);
      this.this$0.jg(true);
    }
  }
  
  protected void p(long paramLong, int paramInt)
  {
    if (this.this$0.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w(this.this$0.TAG, 1, "onFirstFrameDataComeIn, uin[" + paramLong + "], videoSrcType[" + paramInt + "], seq[" + l + "]");
    }
    paramInt = this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().b(paramLong, paramInt);
    if ((paramInt != -1) && (((ioa)this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.get(paramInt)).Tp))
    {
      iwu.a(this.this$0.mApp, 1036);
      iwu.a(this.this$0.mApp, 1037);
    }
    DoubleVideoMeetingCtrlUI.b(this.this$0, l);
    this.this$0.kb("OnFirstFrameDataComeIn");
  }
  
  protected void y(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "onCreateRoomSuc-->relationId = " + paramLong2);
    }
    if (paramLong2 != this.this$0.ow) {
      return;
    }
    this.this$0.E(paramLong1, true);
  }
  
  protected void z(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "EnterRoomSuc-->GroupId = " + paramLong2);
    }
    if (paramLong2 == this.this$0.ow) {
      this.this$0.dC(paramLong1);
    }
    this.this$0.E(paramLong1, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iyn
 * JD-Core Version:    0.7.0.1
 */