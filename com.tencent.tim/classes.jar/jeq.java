import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.utils.TraeHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.lang.ref.WeakReference;

public class jeq
  extends iiz
{
  public jeq(VideoInviteActivity paramVideoInviteActivity) {}
  
  protected void U(String paramString, boolean paramBoolean)
  {
    if ((this.this$0.mPeerUin != null) && (this.this$0.mPeerUin.equals(paramString)))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i(this.this$0.TAG, 4, "onDestroyUI, peer[" + paramString + "], isQuit[" + paramBoolean + "]");
      }
      if (paramBoolean)
      {
        TraeHelper.t(this.this$0.mApp);
        if ((!this.this$0.mIsResume) || (this.this$0.jdField_a_of_type_Jcr == null) || (this.this$0.wP())) {
          break label187;
        }
        if (QLog.isDevelopLevel()) {
          QLog.i(this.this$0.TAG, 4, "onDestroyUI, outAnim, peer[" + paramString + "], isQuit[" + paramBoolean + "]");
        }
        this.this$0.jdField_a_of_type_Jcr.a(new jes(this));
      }
    }
    return;
    label187:
    if (QLog.isDevelopLevel()) {
      QLog.i(this.this$0.TAG, 4, "onDestroyUI, noAnim, peer[" + paramString + "], isQuit[" + paramBoolean + "]");
    }
    this.this$0.Ox = paramBoolean;
    this.this$0.finish();
  }
  
  protected void c(long paramLong, int paramInt, String paramString)
  {
    if (TextUtils.equals(this.this$0.mPeerUin, paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG, 2, "onClose  wrong uin: " + this.this$0.mPeerUin + ", " + paramString);
      }
    }
    while (this.this$0.e.tc()) {
      return;
    }
    TraeHelper.t(this.this$0.mApp);
    if ((this.this$0.mIsResume) && (this.this$0.jdField_a_of_type_Jcr != null) && (!this.this$0.wP()))
    {
      this.this$0.jdField_a_of_type_Jcr.a(new jer(this, paramInt));
      return;
    }
    this.this$0.b().O(this.this$0.mPeerUin, 251);
    this.this$0.b().ko(251);
    this.this$0.b().P(this.this$0.mPeerUin, paramInt);
    this.this$0.Ox = true;
    QLog.d(this.this$0.TAG, 1, "onClose()-> else ->finish  ");
    this.this$0.finish();
  }
  
  protected void f(String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "onGetStrangeFace uin = " + paramString);
    }
    if ((this.this$0.gL != null) && (this.this$0.mUinType == 25)) {
      this.this$0.gL.setImageBitmap(paramBitmap);
    }
    super.f(paramString, paramBitmap);
  }
  
  protected void in(String paramString)
  {
    super.in(paramString);
    if (this.this$0.mUinType == 25)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG, 2, "VideoInviteActivity onGetQCallNickName nickName:" + paramString);
      }
      if (this.this$0.mNameView != null)
      {
        this.this$0.OE = paramString;
        this.this$0.mNameView.setText(this.this$0.OE);
      }
    }
  }
  
  protected void kJ(int paramInt)
  {
    QLog.w(this.this$0.TAG, 1, "onPlayAnnimate, id[" + paramInt + "], mFunCallId[" + this.this$0.axR + "]");
    if (paramInt != this.this$0.axR) {}
    do
    {
      return;
      int i = aqwu.getResourceType();
      String str = aqwu.a(this.this$0.mApp, paramInt, i, null);
      File localFile = new File(str);
      int j = this.this$0.e.amI;
      if ((localFile != null) && (localFile.exists()) && (this.this$0.e.state != 4) && ((j == 1) || (j == 0)) && (this.this$0.et != null))
      {
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView == null) {
          this.this$0.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = aqwu.a((Activity)this.this$0.mActivity.get(), this.this$0.et, false);
        }
        if (aqwu.a(this.this$0.mApp.getApp().getApplicationContext(), this.this$0.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView, str, i, null, paramInt, false))
        {
          this.this$0.jA(true);
          ImmersiveUtils.setStatusTextColor(false, this.this$0.getWindow());
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.this$0.TAG, 2, "VideoInviteFull onPlayAnnimate finish id:" + paramInt);
  }
  
  protected void kn(int paramInt)
  {
    this.this$0.nb(paramInt);
  }
  
  protected void onServiceConnected()
  {
    super.onServiceConnected();
    this.this$0.refreshUI();
    if (this.this$0.mApp != null)
    {
      this.this$0.mApp.h(this.this$0.mUinType, this.this$0.mPeerUin, this.this$0.OD);
      this.this$0.mApp.U(this.this$0.e.bindType, this.this$0.e.MX);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jeq
 * JD-Core Version:    0.7.0.1
 */