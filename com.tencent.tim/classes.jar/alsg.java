import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.qzonevip.gift.QzoneGiftManager.3;
import com.tencent.mobileqq.qzonevip.gift.particle.ParticleDropView;
import com.tencent.mobileqq.qzonevip.gift.particle.ParticleExplodeView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class alsg
  implements alsk.a, View.OnTouchListener, Manager
{
  public static final float DRAWABLE_SCALE = aqnm.getScreenWidth() / 720.0F;
  private static alsg jdField_a_of_type_Alsg;
  private ImageView CX;
  private ImageView CY;
  private ImageView CZ;
  private alsg.a jdField_a_of_type_Alsg$a;
  private alsg.b jdField_a_of_type_Alsg$b = new alsg.b(Looper.getMainLooper());
  private aqvv jdField_a_of_type_Aqvv;
  private ParticleDropView jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleDropView;
  private ParticleExplodeView jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleExplodeView;
  private FrameLayout bT;
  private DiniFlyAnimationView e;
  private Bitmap ga;
  private WeakReference<FrameLayout> hE;
  private awij m;
  private HashMap<String, aeoq.a> mD = new HashMap();
  private Downloader mDownloader = DownloaderFactory.getInstance(BaseApplicationImpl.getContext()).getCommonDownloader();
  private awij n;
  
  private void PV()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_GIFT_ANIMATION_START");
    dIY();
    if (this.n != null) {
      this.n.start();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleDropView != null) {
      this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleDropView.onStart();
    }
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.CY, "scaleX", new float[] { 0.0F, 1.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.CY, "scaleY", new float[] { 0.0F, 1.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.CY, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator3.setInterpolator(new DecelerateInterpolator());
    localAnimatorSet.setDuration(400L);
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3);
    localAnimatorSet.start();
    if (this.n != null) {
      jp(6, this.n.getDuration() + 2000);
    }
  }
  
  private void PW()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_GIFT_ANIMATION_STOP");
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.bT, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.addListener(new alsj(this));
    localObjectAnimator.start();
  }
  
  private void Th(int paramInt)
  {
    jp(paramInt, 0);
  }
  
  public static alsg a()
  {
    if (jdField_a_of_type_Alsg == null) {}
    try
    {
      if (jdField_a_of_type_Alsg == null) {
        jdField_a_of_type_Alsg = new alsg();
      }
      return jdField_a_of_type_Alsg;
    }
    finally {}
  }
  
  private void a(aeoq paramaeoq, String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder().append("loadVipARConfig bean == null ");
    boolean bool;
    if (paramaeoq == null)
    {
      bool = true;
      QLog.i("VipAR", 1, bool + " giftName = " + paramString1);
      if (paramaeoq != null) {
        break label65;
      }
      QLog.e("VipAR", 1, "checkARGift loadVipARConfig error VipARConfBean = null ");
    }
    for (;;)
    {
      return;
      bool = false;
      break;
      label65:
      if ((paramaeoq.cOk != 1) || (paramaeoq.vM == null)) {
        break label146;
      }
      paramaeoq = paramaeoq.vM.iterator();
      while (paramaeoq.hasNext())
      {
        localObject = (aeoq.a)paramaeoq.next();
        if ((localObject != null) && (!TextUtils.isEmpty(paramString1)) && (paramString1.equalsIgnoreCase(((aeoq.a)localObject).key))) {
          this.mD.put(paramString2, localObject);
        }
      }
    }
    label146:
    this.mD.remove(paramString2);
    QLog.i("VipAR", 1, "checkARGift not AR gift switch = " + paramaeoq.cOk + " configlist == null " + paramaeoq.vM);
  }
  
  private awij b(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("QzoneGiftManager", 1, "createAnimationDrawable mZipPath = null");
      return null;
    }
    awij localawij = new awij();
    String str = alsk.mW(paramString);
    if (QLog.isDevelopLevel()) {
      QLog.i("QzoneGiftManager", 4, "createAnimationDrawable mZipPath = " + paramString + " resUrl = " + str);
    }
    localawij.hb(str, paramInt);
    localawij.setScale(DRAWABLE_SCALE);
    localawij.eDG();
    return localawij;
  }
  
  private void dIR()
  {
    if ((this.mDownloader == null) || (!aus()))
    {
      QLog.e("QzoneGiftManager", 1, "preloadLottieZip error");
      return;
    }
    String str = QzoneZipCacheHelper.getBasePath("aio_lottie_gift", String.valueOf(this.jdField_a_of_type_Alsg$a.bYb.hashCode())) + ".zip";
    if (QLog.isColorLevel()) {
      QLog.i("QzoneGiftManager", 2, " preloadLottieZip local path = " + str + " zipUrl = " + this.jdField_a_of_type_Alsg$a.bYb);
    }
    this.mDownloader.download(this.jdField_a_of_type_Alsg$a.bYb, str, new alsh(this));
  }
  
  private void dIS()
  {
    aqvv localaqvv = new aqvv(null, BaseApplicationImpl.getContext());
    localaqvv.hx((int)(MemoryManager.eS() / 2L));
    this.jdField_a_of_type_Aqvv = localaqvv;
  }
  
  private void dIT()
  {
    this.e = new DiniFlyAnimationView(BaseApplicationImpl.getContext());
    this.e.loop(false);
    this.e.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.e.addAnimatorListener(new alsi(this));
  }
  
  private void dIU()
  {
    if (!aus()) {
      return;
    }
    dIS();
    dIT();
    String str = QzoneZipCacheHelper.getBasePath("aio_lottie_gift", String.valueOf(this.jdField_a_of_type_Alsg$a.bYb.hashCode())) + ".zip";
    this.jdField_a_of_type_Aqvv.a(this.e, this.jdField_a_of_type_Alsg$a.bYb, str, true);
    Th(1);
  }
  
  private void dIV()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_INIT_VIEW");
    if (this.bT == null)
    {
      QLog.e("QzoneGiftManager", 1, "mCotentLayout = null");
      return;
    }
    this.CZ = new ImageView(BaseApplicationImpl.getContext());
    this.bT.addView(this.CZ);
    this.CX = new ImageView(BaseApplicationImpl.getContext());
    this.CX.setImageDrawable(this.m);
    this.CY = new ImageView(BaseApplicationImpl.getContext());
    this.CY.setImageDrawable(this.n);
    this.CY.setAlpha(0);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(aqnm.dpToPx(200.0F), aqnm.dpToPx(200.0F));
    localLayoutParams.gravity = 17;
    this.bT.addView(this.CX, localLayoutParams);
    this.bT.addView(this.CY, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleExplodeView = new ParticleExplodeView(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleDropView = new ParticleDropView(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleDropView.setBitmap(this.ga);
    localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.bT.addView(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleExplodeView, localLayoutParams);
    this.bT.addView(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleDropView, localLayoutParams);
    Th(3);
  }
  
  private void dIW()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_BOX_ANIMATION_START");
    if (this.m != null)
    {
      this.m.start();
      jp(5, this.m.getDuration() - 330);
      jp(4, this.m.getDuration() - 300);
    }
    if (this.m == null) {
      jp(4, 0);
    }
  }
  
  private void dIX()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_GIFT_PARTICLE_EXPLODE");
    if (this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleExplodeView != null) {
      this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleExplodeView.onStart();
    }
  }
  
  private void dIY()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_SHADER_SHOW");
    if (this.CZ != null)
    {
      this.CZ.setBackgroundColor(Color.parseColor("#000000"));
      this.CZ.setAlpha(0);
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.CZ, "alpha", new float[] { 0.0F, 0.5F });
      localObjectAnimator.setDuration(300L);
      localObjectAnimator.start();
    }
  }
  
  private void dIZ()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_GIFT_LOTTIE_ANIMATION_SHOW");
    if ((this.e == null) || (this.bT == null)) {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.bT.addView(this.e, localLayoutParams);
  }
  
  private void dzk()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_RECYCLE_VIEW");
    if (this.m != null) {
      this.m.release();
    }
    if (this.n != null) {
      this.n.release();
    }
    if (this.jdField_a_of_type_Aqvv != null) {
      this.jdField_a_of_type_Aqvv.destroy();
    }
    if (this.e != null) {
      this.e.removeAllAnimatorListener();
    }
    if (this.hE == null) {}
    FrameLayout localFrameLayout;
    do
    {
      return;
      localFrameLayout = (FrameLayout)this.hE.get();
    } while ((localFrameLayout == null) || (this.bT == null));
    localFrameLayout.removeView(this.bT);
  }
  
  private void initContentView()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_INIT_CONTENT_VIEW");
    FrameLayout localFrameLayout;
    if (BaseActivity.sTopActivity != null)
    {
      this.hE = new WeakReference((FrameLayout)BaseActivity.sTopActivity.findViewById(16908290));
      localFrameLayout = (FrameLayout)this.hE.get();
      if (localFrameLayout == null) {
        QLog.e("QzoneGiftManager", 1, "mParentLayout = null");
      }
    }
    else
    {
      QLog.e("QzoneGiftManager", 1, "activity = null");
      return;
    }
    this.bT = new FrameLayout(BaseApplicationImpl.getContext());
    this.bT.setOnTouchListener(this);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localFrameLayout.addView(this.bT, localLayoutParams);
    if (aus())
    {
      this.jdField_a_of_type_Alsg$b.sendEmptyMessage(7);
      return;
    }
    Th(2);
  }
  
  private void jp(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Alsg$b == null) {
      return;
    }
    if (this.jdField_a_of_type_Alsg$b.hasMessages(paramInt1)) {
      this.jdField_a_of_type_Alsg$b.removeMessages(paramInt1);
    }
    this.jdField_a_of_type_Alsg$b.sendEmptyMessageDelayed(paramInt1, paramInt2);
  }
  
  private void removeAllMessage()
  {
    if (this.jdField_a_of_type_Alsg$b == null) {}
    for (;;)
    {
      return;
      int i = 1;
      while (i < 9)
      {
        if (this.jdField_a_of_type_Alsg$b.hasMessages(i)) {
          this.jdField_a_of_type_Alsg$b.removeMessages(i);
        }
        i += 1;
      }
    }
  }
  
  public void OL(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QzoneGiftManager", 2, " preload data = " + paramString);
    }
    this.jdField_a_of_type_Alsg$a = alsg.a.a(paramString);
    if (aus())
    {
      dIR();
      return;
    }
    if (this.jdField_a_of_type_Alsg$a != null)
    {
      alsk.a(null, this.jdField_a_of_type_Alsg$a.bXZ, this.jdField_a_of_type_Alsg$a.bYa, this.jdField_a_of_type_Alsg$a.QC);
      return;
    }
    QLog.e("QzoneGiftManager", 1, "preloadGiftData error with data = null");
  }
  
  public void OM(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = new JSONObject(paramString).optJSONObject("giftData");
        if (localObject != null)
        {
          paramString = ((JSONObject)localObject).optString("giftName");
          localObject = ((JSONObject)localObject).optString("giftZipUrl");
          ThreadManager.getFileThreadHandler().post(new QzoneGiftManager.3(this, paramString, (String)localObject));
          QLog.i("VipARGiftManager", 1, "checkIsNeedARGiftShow key gift = " + (String)localObject);
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        QLog.e("VipARGiftManager", 1, "checkIsNeedARGiftShow exception msg = " + paramString.getMessage());
      }
    }
  }
  
  public aeoq.a a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optString("giftZipUrl");
      if (QLog.isColorLevel()) {
        QLog.i("VipAR", 2, "isNeedARShow gift key = " + paramString + " map = " + this.mD.toString());
      }
      Iterator localIterator = this.mD.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((localEntry != null) && (!TextUtils.isEmpty((CharSequence)localEntry.getKey())) && (paramString.contains((CharSequence)localEntry.getKey())))
        {
          paramString = (aeoq.a)localEntry.getValue();
          return paramString;
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public boolean aus()
  {
    return (this.jdField_a_of_type_Alsg$a != null) && (this.jdField_a_of_type_Alsg$a.wl == 1) && (!TextUtils.isEmpty(this.jdField_a_of_type_Alsg$a.bYb));
  }
  
  public void bbs()
  {
    if (this.jdField_a_of_type_Alsg$a == null)
    {
      QLog.e("QzoneGiftManager", 1, "onFail show fail mGiftData = null");
      return;
    }
    QLog.e("QzoneGiftManager", 1, "onFail show fail mGiftData = " + this.jdField_a_of_type_Alsg$a.toString());
  }
  
  public void fJ(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QzoneGiftManager", 2, " startPlay data = " + paramString);
    }
    this.jdField_a_of_type_Alsg$a = alsg.a.a(paramString);
    if (aus())
    {
      dIU();
      return;
    }
    if (this.jdField_a_of_type_Alsg$a != null)
    {
      alsk.a(this, this.jdField_a_of_type_Alsg$a.bXZ, this.jdField_a_of_type_Alsg$a.bYa, this.jdField_a_of_type_Alsg$a.QC);
      return;
    }
    QLog.e("QzoneGiftManager", 1, "preloadGiftData error with data = null");
  }
  
  public void onDestroy()
  {
    removeAllMessage();
    Th(8);
  }
  
  public void onLoading()
  {
    QLog.i("QzoneGiftManager", 1, "onLoading");
  }
  
  public void onSuccess()
  {
    if ((this.jdField_a_of_type_Alsg$a == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Alsg$a.bYa)) || (TextUtils.isEmpty(this.jdField_a_of_type_Alsg$a.QC)))
    {
      QLog.e("QzoneGiftManager", 1, "onSuccess show fail : data = null ");
      return;
    }
    this.m = b(this.jdField_a_of_type_Alsg$a.bXZ, 10);
    this.n = b(this.jdField_a_of_type_Alsg$a.bYa, 10);
    if (this.n != null)
    {
      this.n.Xc(true);
      this.n.Xb(false);
    }
    String str = alsk.getLocalFilePath(this.jdField_a_of_type_Alsg$a.QC, "qzone_aio_gift");
    if (!TextUtils.isEmpty(str))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("QzoneGiftManager", 4, "show Gift giftLocalPath = " + str);
      }
      this.ga = BitmapFactory.decodeFile(str);
    }
    Th(1);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      removeAllMessage();
      Th(8);
    }
    return true;
  }
  
  public static class a
  {
    public String QC;
    public String bXZ;
    public String bYa;
    public String bYb;
    public int wl;
    
    public static a a(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      a locala = new a();
      try
      {
        paramString = new JSONObject(paramString);
        locala.wl = paramString.optInt("animationType");
        locala.bXZ = paramString.optString("boxZipUrl", null);
        locala.bYa = paramString.optString("giftZipUrl", null);
        locala.QC = paramString.optString("giftParticleUrl", null);
        locala.bYb = paramString.optString("lottieUrl", null);
        return locala;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        QLog.e("QzoneGiftManager", 1, "handleFlashChatConfig failed" + paramString);
      }
      return locala;
    }
    
    public String toString()
    {
      return " mBoxZipUrl = " + this.bXZ + " mGiftZipUrl = " + this.bYa + " mGiftUrl = " + this.QC;
    }
  }
  
  class b
    extends Handler
  {
    public b(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      try
      {
        switch (paramMessage.what)
        {
        case 1: 
          alsg.a(alsg.this);
          return;
        }
      }
      catch (Exception paramMessage)
      {
        paramMessage.printStackTrace();
        QLog.e("QzoneGiftManager", 1, "handleMessage exception = " + paramMessage.getMessage());
        return;
      }
      alsg.b(alsg.this);
      return;
      alsg.c(alsg.this);
      return;
      alsg.d(alsg.this);
      return;
      alsg.e(alsg.this);
      return;
      alsg.f(alsg.this);
      return;
      alsg.g(alsg.this);
      return;
      alsg.h(alsg.this);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alsg
 * JD-Core Version:    0.7.0.1
 */