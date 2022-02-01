import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import com.tencent.mobileqq.troopgift.TroopGiftActionButton;
import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.1;
import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.3;
import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.5;
import com.tencent.qphone.base.util.QLog;

public class apxr
{
  public TroopChatPie a;
  public TroopGiftActionButton a;
  public boolean aYG = true;
  protected MessageForDeliverGiftTips b;
  public SpriteVideoView c;
  public ViewGroup cV;
  public int dXR;
  protected int dXS;
  protected SoundPool mSoundPool;
  public Handler mUIHandler = new Handler(Looper.getMainLooper());
  
  public apxr()
  {
    try
    {
      this.mSoundPool = new SoundPool(5, 3, 0);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("TroopInteractGiftAnimationController", 2, QLog.getStackTraceString(localUnsatisfiedLinkError));
      return;
    }
    catch (ExceptionInInitializerError localExceptionInInitializerError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("TroopInteractGiftAnimationController", 2, QLog.getStackTraceString(localExceptionInInitializerError));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("TroopInteractGiftAnimationController", 2, QLog.getStackTraceString(localException));
    }
  }
  
  public void a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips, long paramLong)
  {
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    this.mUIHandler.postDelayed(new TroopInteractGiftAnimationController.3(this, paramMessageForDeliverGiftTips), l);
  }
  
  protected void a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips, String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie != null) {
      ((apsz)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.app.getManager(113)).a(paramString1, paramString2, paramInt1, paramInt2, new apye(this, paramInt2, paramString2, paramMessageForDeliverGiftTips, paramBoolean));
    }
    this.dXR = 0;
  }
  
  public void a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips, String paramString, boolean paramBoolean, anyo.a parama)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie == null) {
      return;
    }
    this.b = paramMessageForDeliverGiftTips;
    if (QLog.isColorLevel()) {
      QLog.d("TroopInteractGiftAnimationController", 2, "TroopInteractGiftAnimationController: showAnimation" + this.b.interactId);
    }
    if (this.mSoundPool != null) {
      this.dXS = this.mSoundPool.load(aptj.oS(paramString) + "sound.wav", 1);
    }
    ThreadManager.post(new TroopInteractGiftAnimationController.1(this, paramString, paramMessageForDeliverGiftTips, paramBoolean, parama, (apsz)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.app.getManager(113)), 8, null, true);
  }
  
  public boolean aBG()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton != null;
  }
  
  public void b(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie != null) {
      ((apsz)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.app.getManager(113)).a(paramMessageForDeliverGiftTips.frienduin, paramMessageForDeliverGiftTips.interactId, paramMessageForDeliverGiftTips.animationPackageId, new apyf(this, paramMessageForDeliverGiftTips));
    }
  }
  
  public void ecD()
  {
    if ((this.c == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopInteractGiftAnimationController", 2, "TroopInteractGiftAnimationController: dismissAnimation" + this.b.interactId);
      }
      this.c.dTU();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.mActivity.runOnUiThread(new TroopInteractGiftAnimationController.5(this));
    } while (this.mSoundPool == null);
    this.mSoundPool.unload(this.dXS);
  }
  
  protected void ecE()
  {
    if (this.mSoundPool != null)
    {
      AudioManager localAudioManager = (AudioManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.mContext.getSystemService("audio");
      float f = localAudioManager.getStreamMaxVolume(3);
      f = localAudioManager.getStreamVolume(3) / f;
      this.mSoundPool.play(this.dXS, f, f, 1, 0, 1.0F);
    }
  }
  
  public void g(TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie = paramTroopChatPie;
    this.cV = ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.mAIORootView.findViewById(2131364469));
  }
  
  public boolean isPlaying()
  {
    return this.c != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apxr
 * JD-Core Version:    0.7.0.1
 */