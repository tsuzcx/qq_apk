import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingData;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingView;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenManager;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams.FloatingBuilder;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nonnull;
import mqq.util.WeakReference;

public class aihr
{
  private static volatile aihr jdField_a_of_type_Aihr;
  private aihr.b jdField_a_of_type_Aihr$b;
  private arah jdField_a_of_type_Arah;
  private volatile WatchTogetherFloatingData jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData;
  private WatchTogetherFloatingView jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView;
  private WeakReference<aihr.a> aC;
  private WeakReference<IVideoOuterStatusListener> aH;
  private long abB;
  private WatchTogetherFloatingData b;
  private volatile boolean cko;
  
  public static aihr a()
  {
    if (jdField_a_of_type_Aihr == null) {}
    try
    {
      if (jdField_a_of_type_Aihr == null) {
        jdField_a_of_type_Aihr = new aihr();
      }
      return jdField_a_of_type_Aihr;
    }
    finally {}
  }
  
  private boolean ab(String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("WatchFloatingWindowController", 2, "closeFloatingWindow uin is empty or data==null");
      }
    }
    do
    {
      return false;
      if ((paramString.equals(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurUin())) && (paramInt == this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurType())) {
        break;
      }
    } while (!QLog.isColorLevel());
    StringBuilder localStringBuilder = new StringBuilder("closeFloatingWindow uin or type not match:");
    localStringBuilder.append("mCurType=").append(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurType()).append(" sessionType=").append(paramInt).append(" mCurUin=").append(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurUin()).append(" uin=").append(paramString);
    QLog.d("WatchFloatingWindowController", 2, localStringBuilder.toString());
    return false;
    return true;
  }
  
  private int e(Context paramContext, float paramFloat)
  {
    Object localObject = new FloatingScreenParams.FloatingBuilder();
    if (paramFloat < 1.0F) {}
    FloatingScreenManager localFloatingScreenManager;
    for (int i = 1;; i = 2)
    {
      localObject = ((FloatingScreenParams.FloatingBuilder)localObject).setShapeType(i).setCanMove(true).setRatio(paramFloat).setFloatingCenterX(300).setFloatingCenterY(-680).build();
      localFloatingScreenManager = FloatingScreenManager.getInstance();
      i = localFloatingScreenManager.enterWatchTogetherFloatingScreen(BaseApplicationImpl.context, this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView, (FloatingScreenParams)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("WatchFloatingWindowController", 2, new Object[] { "createFloatWindow: invoked. ", " result: ", Integer.valueOf(i) });
      }
      if (i != 1) {
        break;
      }
      aihl.i(paramContext, 4, this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurUin());
      return i;
    }
    this.aH = new WeakReference(localFloatingScreenManager.setFloatingVideoListener(new aihs(this), 2));
    localFloatingScreenManager.setWindowClickListener(2, new aiht(this, paramContext));
    return 0;
  }
  
  public void KZ(boolean paramBoolean)
  {
    if ((this.aC == null) || (this.aC.get() == null)) {
      return;
    }
    aihr.a locala = (aihr.a)this.aC.get();
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      locala.PO(i);
      return;
    }
  }
  
  public void PN(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData == null) {}
    do
    {
      return;
      if (this.cko) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("WatchFloatingWindowController", 2, "closeOrQuitBusiness, but isSuccessCreateFloatingView is false");
    return;
    ap(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurUin(), this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurType(), paramInt);
  }
  
  public void PP(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData == null);
        if (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getLoadingStatus() != paramInt) {
          break;
        }
      } while (paramInt != 2);
      anot.a(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_refresh_error", 0, 0, this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurUin(), "", "", "");
      return;
      if (QLog.isColorLevel()) {
        QLog.d("WatchFloatingWindowController", 2, "updateLoadingStatus mLoadingStatus=" + this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getLoadingStatus() + " status=" + paramInt);
      }
      this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.setLoadingStatus(paramInt);
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView.La(false);
        if (this.jdField_a_of_type_Aihr$b == null)
        {
          this.jdField_a_of_type_Aihr$b = new aihr.b(this.aH);
          ajat.a().requestMediaFocus(1, this.jdField_a_of_type_Aihr$b);
          return;
        }
        this.jdField_a_of_type_Aihr$b.a(this.aH);
        return;
      }
    } while (paramInt != 2);
    anot.a(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_refresh_error", 0, 0, this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurUin(), "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView.dsw();
  }
  
  public int a(Context paramContext, @Nonnull WatchTogetherFloatingData paramWatchTogetherFloatingData)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2131696272, 0).show();
      this.b = null;
      return 4;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData != null) && (paramWatchTogetherFloatingData != null) && (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurUin().equals(paramWatchTogetherFloatingData.getCurUin())) && (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurType() == this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurType()) && (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getLoadingStatus() == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WatchFloatingWindowController", 2, "showFloatingWindow:  duplicate show");
      }
      this.b = null;
      return 5;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView = new WatchTogetherFloatingView(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView.La(true);
      this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData = paramWatchTogetherFloatingData;
      if ((this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getVideoHeight() > 0.0D) && (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getVideoWidth() > 0.0D)) {
        break label202;
      }
    }
    label202:
    for (float f = 0.5625F;; f = (float)(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getVideoHeight() / this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getVideoWidth()))
    {
      int i = e(paramContext, f);
      if (i == 0) {
        break label222;
      }
      this.b = null;
      return i;
      this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView.Le(paramWatchTogetherFloatingData.getSmallUrl());
      break;
    }
    label222:
    this.cko = true;
    Intent localIntent = new Intent();
    localIntent.putExtra("web_view_module_from", 1);
    localIntent.putExtra("url", paramWatchTogetherFloatingData.getSmallUrl());
    this.jdField_a_of_type_Arah = new arah(localIntent, paramContext);
    this.jdField_a_of_type_Arah.onCreate();
    aihl.a(true, paramWatchTogetherFloatingData.getCurUin(), paramWatchTogetherFloatingData.getCurType(), true);
    arlc.y(BaseApplicationImpl.getContext(), 50, 0);
    this.b = null;
    return 0;
  }
  
  public void a(aihr.a parama)
  {
    this.aC = new WeakReference(parama);
  }
  
  public void a(WatchTogetherFloatingData paramWatchTogetherFloatingData)
  {
    this.b = paramWatchTogetherFloatingData;
  }
  
  public void ap(String paramString, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData == null) || (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView == null)) {}
    do
    {
      return;
      if ((this.aC != null) && (this.aC.get() != null)) {
        ((aihr.a)this.aC.get()).PN(paramInt2);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView.FC() == 1);
    p(paramString, paramInt1, true);
  }
  
  public boolean apa()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView == null) || (this.jdField_a_of_type_Arah == null)) {}
    TouchWebView localTouchWebView;
    do
    {
      return false;
      localTouchWebView = this.jdField_a_of_type_Arah.j;
    } while (localTouchWebView == null);
    return localTouchWebView.isShown();
  }
  
  public void b(aihr.a parama)
  {
    if ((this.aC != null) && (this.aC.get() != null) && (this.aC.get() == parama)) {
      this.aC = null;
    }
  }
  
  public void d(double paramDouble1, double paramDouble2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WatchFloatingWindowController", 2, "updateWindowSize videoWidth =" + paramDouble1 + " videoHeight=" + paramDouble2);
    }
    if ((paramDouble1 <= 0.0D) || (paramDouble2 <= 0.0D)) {
      if (QLog.isColorLevel()) {
        QLog.d("WatchFloatingWindowController", 2, "updateWindowSize params is invalid");
      }
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData == null);
      if ((paramDouble1 != this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getVideoWidth()) || (paramDouble2 != this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getVideoHeight())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("WatchFloatingWindowController", 2, "updateWindowSize params is equal");
    return;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.setVideoWidth(paramDouble1);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.setVideoHeight(paramDouble2);
    FloatingScreenManager localFloatingScreenManager = FloatingScreenManager.getInstance();
    float f = (float)(paramDouble2 / paramDouble1);
    localFloatingScreenManager.updateFloatingWindowRatio(f, 2);
    if (f < 1.0F) {}
    for (int i = 1;; i = 2)
    {
      localFloatingScreenManager.updateFloatingWindowShape(i, 2);
      return;
    }
  }
  
  public void dst()
  {
    int i = 2;
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData == null) {}
    do
    {
      return;
      if (this.cko) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("WatchFloatingWindowController", 2, "closeOrQuitBusiness, but isSuccessCreateFloatingView is false");
    return;
    String str = this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurUin();
    int j = this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurType();
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.isIsAdm()) {
      i = 1;
    }
    ap(str, j, i);
  }
  
  public void dsu()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WatchFloatingWindowController", 2, "closeFloatingWindow, oooo");
      }
      return;
    }
    p(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurUin(), this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurType(), true);
  }
  
  public void dsv()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView == null) || (this.jdField_a_of_type_Arah == null)) {}
    TouchWebView localTouchWebView;
    do
    {
      return;
      localTouchWebView = this.jdField_a_of_type_Arah.j;
    } while (localTouchWebView == null);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView.b(localTouchWebView);
    this.jdField_a_of_type_Arah.onResume();
  }
  
  public void ew(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WatchFloatingWindowController", 2, "showFloatingWindowByPendingData");
    }
    if (paramContext == null) {}
    while (this.b == null) {
      return;
    }
    a(paramContext, this.b);
  }
  
  public void p(String paramString, int paramInt, boolean paramBoolean)
  {
    if (!ab(paramString, paramInt)) {}
    do
    {
      return;
      if (this.cko) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("WatchFloatingWindowController", 2, "closeFloatingWindow, but isSuccessCreateFloatingView is false");
    return;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData = null;
    this.b = null;
    if (this.jdField_a_of_type_Arah != null)
    {
      this.jdField_a_of_type_Arah.onPause();
      this.jdField_a_of_type_Arah.onDestroy();
      this.jdField_a_of_type_Arah = null;
    }
    this.abB = 0L;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView = null;
    FloatingScreenManager.getInstance().quitFloatingScreen(2);
    aihl.a(false, paramString, paramInt, paramBoolean);
    if (this.jdField_a_of_type_Aihr$b != null)
    {
      ajat.a().abandonMediaFocus(this.jdField_a_of_type_Aihr$b);
      this.jdField_a_of_type_Aihr$b = null;
    }
    this.aH = null;
    FloatingScreenManager.getInstance().setFloatingVideoListener(null, 2);
  }
  
  public static abstract interface a
  {
    public abstract void PN(int paramInt);
    
    public abstract void PO(int paramInt);
  }
  
  public static class b
    implements ajat.c
  {
    private WeakReference<IVideoOuterStatusListener> aI;
    
    public b(WeakReference<IVideoOuterStatusListener> paramWeakReference)
    {
      this.aI = paramWeakReference;
    }
    
    private void yh(boolean paramBoolean)
    {
      if ((this.aI == null) || (this.aI.get() == null)) {
        return;
      }
      IVideoOuterStatusListener localIVideoOuterStatusListener = (IVideoOuterStatusListener)this.aI.get();
      if (paramBoolean)
      {
        localIVideoOuterStatusListener.onVideoStop();
        return;
      }
      localIVideoOuterStatusListener.onVideoStart(-1);
    }
    
    public void OC(int paramInt)
    {
      switch (paramInt)
      {
      case 0: 
      default: 
        return;
      case 1: 
        QLog.i("WatchFloatingWindowController", 1, "onFocusChange: MEDIAFOCUS_GAIN");
        aihr.a().KZ(false);
        yh(false);
        return;
      }
      QLog.i("WatchFloatingWindowController", 1, "onFocusChange: MEDIAFOCUS_LOSS");
      aihr.a().KZ(true);
      yh(true);
    }
    
    public void a(WeakReference<IVideoOuterStatusListener> paramWeakReference)
    {
      this.aI = paramWeakReference;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aihr
 * JD-Core Version:    0.7.0.1
 */