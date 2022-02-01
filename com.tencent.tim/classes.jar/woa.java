import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.BoatAnimDirector.1;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.BoatAnimDirector.2;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.FriendShipLayout;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat.FriendShipWaveView;
import com.tencent.qphone.base.util.QLog;

public class woa
  extends wol
{
  Context N;
  private anyq.a jdField_a_of_type_Anyq$a = new wob(this);
  FriendShipWaveView jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBoatFriendShipWaveView;
  String aTA = "aio_ship_blink.png";
  String aTB = "aio_ship_close.png";
  String aTC = "aio_ship_star1.png";
  String aTD = "aio_ship_star2.png";
  String aTE = "aio_ship_star3.png";
  String aTF = "aio_ship_star4.png";
  String aTG = "aio_ship_wave1.png";
  String aTH = "aio_ship_wave2.png";
  String aTI = "aio_ship_wave3.png";
  String aTJ = "aio_ship_wording.png";
  String aTy = "aio_ship_ship.png";
  String aTz = "aio_ship_banner.png";
  boolean beJ = false;
  Bitmap dE;
  Bitmap dF;
  Bitmap dG;
  Bitmap dH;
  Bitmap dI;
  Bitmap dJ;
  Bitmap dK;
  Bitmap dL;
  Bitmap dM;
  Bitmap dN;
  Bitmap dO;
  Bitmap dP;
  boolean isPlaying = false;
  public ImageView so;
  
  public woa(Activity paramActivity)
  {
    super(paramActivity);
    this.N = paramActivity;
  }
  
  private void fo(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBoatFriendShipWaveView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBoatFriendShipWaveView.a(paramInt1, paramInt2, this.N, this.jdField_a_of_type_Anyq$a, this.dE, this.dF, this.dG, this.dH, this.dI, this.dJ, this.dK, this.dL, this.dM, this.dN, this.dO, this.dP);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBoatFriendShipWaveView.bZU();
    }
  }
  
  @TargetApi(9)
  public void a(wop.a parama)
  {
    String str = ajol.xv();
    if (aqhq.fileExists(str)) {}
    for (;;)
    {
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inScaled = true;
        localOptions.inDensity = 320;
        localOptions.inTargetDensity = this.N.getResources().getDisplayMetrics().densityDpi;
        this.dE = aqhu.d(str + this.aTy, localOptions);
        this.dF = aqhu.d(str + this.aTz, localOptions);
        this.dG = aqhu.d(str + this.aTA, localOptions);
        this.dH = aqhu.d(str + this.aTB, localOptions);
        this.dI = aqhu.d(str + this.aTC, localOptions);
        this.dJ = aqhu.d(str + this.aTD, localOptions);
        this.dK = aqhu.d(str + this.aTE, localOptions);
        this.dL = aqhu.d(str + this.aTF, localOptions);
        this.dM = aqhu.d(str + this.aTG, localOptions);
        this.dN = aqhu.d(str + this.aTH, localOptions);
        this.dO = aqhu.d(str + this.aTI, localOptions);
        this.dP = aqhu.d(str + this.aTJ, localOptions);
        if ((this.dE != null) && (this.dF != null) && (this.dH != null) && (this.dM != null) && (this.dN != null) && (this.dO != null))
        {
          this.beJ = true;
          if (QLog.isColorLevel()) {
            QLog.d("FriendShipViewManager", 2, "checkImageRes isResOk=" + this.beJ);
          }
          super.a(parama);
          parama.yH(this.beJ);
          return;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendShipViewManager", 2, "checkImageRes bitmap is null");
        continue;
      }
      catch (Exception localException)
      {
        this.beJ = false;
        QLog.e("FriendShipViewManager", 4, localException, new Object[0]);
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.d("FriendShipViewManager", 2, "checkImageRes bitmap failed");
        continue;
      }
      this.beJ = false;
    }
  }
  
  public void cancel()
  {
    this.isPlaying = false;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBoatFriendShipWaveView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBoatFriendShipWaveView.cac();
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBoatFriendShipWaveView;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBoatFriendShipWaveView.postDelayed(new BoatAnimDirector.1(this, (FriendShipWaveView)localObject), 300L);
    }
    if (this.so != null)
    {
      localObject = new AlphaAnimation(1.0F, 0.0F);
      ((AlphaAnimation)localObject).setDuration(300L);
      this.so.startAnimation((Animation)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBoatFriendShipWaveView = null;
    this.so = null;
    super.cancel();
  }
  
  public void doOnDestroy()
  {
    if (this.isPlaying) {
      cancel();
    }
  }
  
  public void doOnPause()
  {
    if (this.isPlaying) {
      setVisibility(4);
    }
  }
  
  public void doOnResume()
  {
    if (this.isPlaying) {
      setVisibility(0);
    }
  }
  
  public void fn(int paramInt1, int paramInt2)
  {
    fo(paramInt1, paramInt2);
    if (this.so != null) {
      this.so.postDelayed(new BoatAnimDirector.2(this), 1000L);
    }
  }
  
  public int getType()
  {
    return 1;
  }
  
  public void play()
  {
    super.play();
    if (!this.isPlaying)
    {
      FriendShipLayout localFriendShipLayout = a();
      if (localFriendShipLayout != null)
      {
        if (localFriendShipLayout.getChildCount() > 0) {
          localFriendShipLayout.removeAllViews();
        }
        setVisibility(0);
        this.so = new ImageView(this.N);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBoatFriendShipWaveView = new FriendShipWaveView(this.N, null);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
        localFriendShipLayout.addView(this.so, localLayoutParams);
        localFriendShipLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBoatFriendShipWaveView);
        fn(ankt.SCREEN_WIDTH, ankt.cIE);
        this.isPlaying = true;
      }
    }
    anot.a(null, "dc00898", "", "", "0X8007777", "0X8007777", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     woa
 * JD-Core Version:    0.7.0.1
 */