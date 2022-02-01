import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.TraeHelper;
import com.tencent.qphone.base.util.QLog;

class jew
  extends iiz
{
  jew(jeu paramjeu) {}
  
  protected void U(String paramString, boolean paramBoolean)
  {
    super.U(paramString, paramBoolean);
    QLog.d("VideoInviteFloatBarUICtr", 1, "onDestroyUI  peerUin: " + this.this$0.mPeerUin + ", isQuit : " + paramBoolean);
    if ((this.this$0.mPeerUin != null) && (paramString != null) && (this.this$0.mPeerUin.equals(paramString)) && (paramBoolean)) {
      this.this$0.onDestroy();
    }
  }
  
  protected void bQ(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w("VideoInviteFloatBarUICtr", 1, "onConnected, seq[" + paramLong + "]");
    }
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.alx();
    ivm.a(this.this$0.mApp).x(paramLong, false);
    if (this.this$0.jdField_a_of_type_Jet != null) {
      this.this$0.jdField_a_of_type_Jet.avn();
    }
    this.this$0.mApp.getHandler().postDelayed(this.this$0.bf, 1000L);
    if (this.this$0.e.amI == 1) {
      this.this$0.QK = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
    }
    TraeHelper.a().startService(this.this$0.QK);
  }
  
  protected void c(long paramLong, int paramInt, String paramString)
  {
    QLog.d("VideoInviteFloatBarUICtr", 1, "onClose  reason = " + paramInt + ",peerUin =  " + paramString);
    if (TextUtils.equals(this.this$0.mPeerUin, paramString))
    {
      QLog.d("VideoInviteFloatBarUICtr", 1, "onClose  wrong uin: " + this.this$0.mPeerUin + ", " + paramString);
      this.this$0.onDestroy();
    }
    while ((this.this$0.jdField_a_of_type_ComTencentAvVideoController == null) || (this.this$0.e.tc())) {
      return;
    }
  }
  
  protected void f(String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFloatBarUICtr", 2, "onGetStrangeFace uin = " + this.this$0.mPeerUin);
    }
    if ((this.this$0.mUinType == 25) && (this.this$0.jdField_a_of_type_Jet != null)) {
      this.this$0.jdField_a_of_type_Jet.setImg(paramBitmap);
    }
    super.f(paramString, paramBitmap);
  }
  
  protected void in(String paramString)
  {
    super.in(paramString);
    if (this.this$0.mUinType == 25)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoInviteFloatBarUICtr", 2, "VideoInviteActivity onGetQCallNickName nickName:" + paramString);
      }
      this.this$0.OE = paramString;
      if (this.this$0.jdField_a_of_type_Jet != null) {
        this.this$0.jdField_a_of_type_Jet.setName(this.this$0.OE);
      }
    }
  }
  
  protected void kJ(int paramInt) {}
  
  protected void kn(int paramInt) {}
  
  protected void onServiceConnected()
  {
    super.onServiceConnected();
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFloatBarUICtr", 2, "onServiceConnected uin = " + this.this$0.mPeerUin);
    }
    if (this.this$0.mApp != null)
    {
      this.this$0.mApp.h(this.this$0.mUinType, this.this$0.mPeerUin, this.this$0.OD);
      this.this$0.mApp.U(this.this$0.e.bindType, this.this$0.e.MX);
    }
    this.this$0.jw(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jew
 * JD-Core Version:    0.7.0.1
 */