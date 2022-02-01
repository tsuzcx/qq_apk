import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherPlayFragment;
import com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel.4;
import com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel.5;
import com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel.6;
import com.tencent.mobileqq.listentogether.ui.MusicPanelView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class aiqd
  implements View.OnClickListener, wvs
{
  long IJ = 0L;
  aiod jdField_a_of_type_Aiod;
  aioe jdField_a_of_type_Aioe;
  aiqd.a jdField_a_of_type_Aiqd$a;
  aiqd.b jdField_a_of_type_Aiqd$b = new aiqd.b();
  private yit jdField_a_of_type_Yit;
  public FrameLayout bL;
  ainv c = new aiqe(this);
  boolean clu = false;
  boolean clv = true;
  boolean clw = false;
  public ViewGroup e;
  private Runnable gO = new BaseListenTogetherPanel.6(this);
  public PopupWindow h;
  public BaseActivity mActivity;
  BaseChatPie mBaseChatPie;
  boolean zR = false;
  
  public aiqd(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "oncreate");
    }
    this.mBaseChatPie = paramBaseChatPie;
    this.mActivity = paramBaseChatPie.a();
    this.e = this.mBaseChatPie.mAIORootView;
    aogk.a().QO(isAdmin());
  }
  
  private boolean J(int paramInt, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Aiqd$b.mCurUin.equals(paramString))
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Aiqd$b.mCurType == paramInt) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "checkTypeAndUin, result=" + bool1 + ",type=" + paramInt + ",uin=" + paramString);
    }
    return bool1;
  }
  
  private void S(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onListenTogetherJoinedCountChange");
    }
    if (!J(paramInt, paramString1)) {
      return;
    }
    this.jdField_a_of_type_Aiqd$b.bPu = paramString2;
    ccU();
    a(this.jdField_a_of_type_Aiqd$b);
  }
  
  private yit a()
  {
    if (this.jdField_a_of_type_Yit == null)
    {
      this.jdField_a_of_type_Yit = new yit(this.mBaseChatPie, this);
      if (this.mBaseChatPie.a() != null) {
        this.mBaseChatPie.a().a(this.jdField_a_of_type_Yit);
      }
    }
    return this.jdField_a_of_type_Yit;
  }
  
  private void a(aiqd.b paramb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "freshUI, isListenTogetherTime=" + apu() + ",isPanelShow=" + Si());
    }
    MusicPanelView localMusicPanelView = a();
    if ((!apu()) || (localMusicPanelView == null)) {}
    Object localObject;
    int i;
    label207:
    label232:
    do
    {
      return;
      localObject = paramb.a;
      i = paramb.status;
      localObject = ((ListenTogetherSession)localObject).b();
      if (paramb.deR == 2)
      {
        if (i == 4)
        {
          localMusicPanelView.iz(8, i);
          localMusicPanelView.Qf(0);
          localMusicPanelView.Qd(0);
          localMusicPanelView.LT("");
          localMusicPanelView.Qe(8);
          localMusicPanelView.eX(this.mActivity.getResources().getString(2131695343), 2131167288);
          localMusicPanelView.di(8, "");
          localMusicPanelView.Q(0, 0);
          localMusicPanelView.dtK();
        }
        for (;;)
        {
          localMusicPanelView.Qg(8);
          if (i == 4) {
            localMusicPanelView.iz(8, i);
          }
          localMusicPanelView.postInvalidate();
          return;
          if (paramb.clx)
          {
            localMusicPanelView.iz(0, i);
            if (localObject == null) {
              break label360;
            }
            localMusicPanelView.LT(((MusicInfo)localObject).album);
            localMusicPanelView.eX(aiob.a((MusicInfo)localObject), 2131167286);
            localMusicPanelView.Qd(0);
            localMusicPanelView.Qf(0);
            localMusicPanelView.updateProgress(0);
            if (i != 2) {
              break label398;
            }
            localMusicPanelView.Qe(0);
          }
          for (;;)
          {
            if (this.jdField_a_of_type_Aiqd$b.clz)
            {
              localMusicPanelView.Q(0, paramb.deS);
              localMusicPanelView.di(0, aiob.bv(paramb.abP) + " / " + aiob.bv(paramb.duration));
              localMusicPanelView.dtK();
              this.jdField_a_of_type_Aiqd$b.clz = false;
            }
            if (i != 1) {
              break label408;
            }
            localMusicPanelView.dtJ();
            break;
            localMusicPanelView.iz(8, i);
            break label207;
            localMusicPanelView.LT("");
            localMusicPanelView.eX(this.mActivity.getResources().getString(2131695343), 2131167288);
            localMusicPanelView.di(8, "");
            break label232;
            localMusicPanelView.Qe(8);
          }
          if (i == 2) {
            localMusicPanelView.dtL();
          }
        }
      }
    } while ((paramb.deR != 1) && (paramb.deR != 3));
    label360:
    localMusicPanelView.Qe(8);
    label398:
    label408:
    localMusicPanelView.Qf(8);
    localMusicPanelView.iz(8, i);
    localMusicPanelView.Qg(0);
    localMusicPanelView.Qd(8);
    localMusicPanelView.Q(0, 0);
    localMusicPanelView.dtK();
    if (i == 4)
    {
      localMusicPanelView.LT("");
      localMusicPanelView.eX(this.mActivity.getResources().getString(2131695343), 2131167288);
      localMusicPanelView.di(8, "");
    }
    for (;;)
    {
      if (i == 4) {
        localMusicPanelView.iz(8, i);
      }
      localMusicPanelView.postInvalidate();
      return;
      if (localObject != null)
      {
        localMusicPanelView.LT(((MusicInfo)localObject).album);
        localMusicPanelView.eX(aiob.a((MusicInfo)localObject), 2131167286);
        localObject = xb();
        paramb = (aiqd.b)localObject;
        if (localObject == null) {
          paramb = "";
        }
        localMusicPanelView.di(0, paramb);
      }
      else
      {
        localMusicPanelView.LT("");
        localMusicPanelView.eX(this.mActivity.getResources().getString(2131695343), 2131167288);
        localMusicPanelView.di(8, "");
      }
    }
  }
  
  private boolean a(ListenTogetherSession paramListenTogetherSession)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramListenTogetherSession != null)
    {
      bool1 = bool2;
      if (paramListenTogetherSession.uin.equals(this.jdField_a_of_type_Aiqd$b.mCurUin))
      {
        bool1 = bool2;
        if (paramListenTogetherSession.type == this.jdField_a_of_type_Aiqd$b.mCurType) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void aSc()
  {
    boolean bool = aiob.aT(this.mActivity.app);
    if ((!bool) && ((this.h == null) || (!this.h.isShowing())) && (Si()) && (this.mBaseChatPie.r() != null))
    {
      this.mBaseChatPie.r().postDelayed(this.gO, 500L);
      aiob.dc(this.mActivity.app);
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "showGuide, hasShow=" + bool);
    }
  }
  
  private void b(aiqd.b paramb)
  {
    MusicPanelView localMusicPanelView = a();
    if ((!apu()) || (localMusicPanelView == null)) {
      return;
    }
    localMusicPanelView.Q(0, paramb.deS);
    localMusicPanelView.di(0, aiob.bv(paramb.abP) + " / " + aiob.bv(paramb.duration));
  }
  
  private void ciw()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "destroyUI()");
    }
    if (this.mBaseChatPie.r() != null) {
      this.mBaseChatPie.r().removeCallbacks(this.gO);
    }
    if (this.h != null)
    {
      this.h.dismiss();
      this.h = null;
    }
    if (this.mBaseChatPie.a != null) {
      this.mBaseChatPie.a.a(null);
    }
    this.jdField_a_of_type_Aiqd$b.reset();
    this.IJ = 0L;
    this.clu = false;
    ccU();
  }
  
  private void dtF()
  {
    if (!aqiw.isNetworkAvailable(this.mActivity))
    {
      QQToast.a(this.mActivity, 1, this.mActivity.getString(2131696664), 0).show();
      return;
    }
    int i = this.jdField_a_of_type_Aiqd$b.mCurType;
    String str = this.jdField_a_of_type_Aiqd$b.mCurUin;
    this.jdField_a_of_type_Aioe = new aiqg(this, i, str);
    ListenTogetherManager.a(this.mBaseChatPie.app).a(this.mActivity, i, str, this.jdField_a_of_type_Aioe);
  }
  
  private void dtH()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "jumpWeb, isLaunchingWeb=" + this.clu);
    }
    if (this.clu) {
      return;
    }
    this.clu = true;
    aiob.b(this.mBaseChatPie.app, this.mActivity, this.jdField_a_of_type_Aiqd$b.mCurType, this.jdField_a_of_type_Aiqd$b.mCurUin, 1);
  }
  
  private void f(ListenTogetherSession paramListenTogetherSession)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.i("BaseListenTogetherPanel", 2, "updateCurUiData");
    }
    MusicInfo localMusicInfo = null;
    if (this.jdField_a_of_type_Aiqd$b.a != null) {
      localMusicInfo = this.jdField_a_of_type_Aiqd$b.a.b();
    }
    Object localObject = paramListenTogetherSession.b();
    if ((localMusicInfo == null) || (localObject == null) || (localMusicInfo.id != ((MusicInfo)localObject).id))
    {
      this.jdField_a_of_type_Aiqd$b.deS = 0;
      this.jdField_a_of_type_Aiqd$b.abP = 0L;
      this.jdField_a_of_type_Aiqd$b.duration = 0L;
      this.jdField_a_of_type_Aiqd$b.clz = true;
    }
    this.jdField_a_of_type_Aiqd$b.status = paramListenTogetherSession.status;
    this.jdField_a_of_type_Aiqd$b.deR = paramListenTogetherSession.deR;
    this.jdField_a_of_type_Aiqd$b.a = paramListenTogetherSession;
    localObject = this.jdField_a_of_type_Aiqd$b;
    if (!paramListenTogetherSession.cbN) {
      bool = true;
    }
    ((aiqd.b)localObject).cly = bool;
    this.jdField_a_of_type_Aiqd$b.baZ = paramListenTogetherSession.ckN;
    this.jdField_a_of_type_Aiqd$b.creatorNick = paramListenTogetherSession.creatorNick;
    this.jdField_a_of_type_Aiqd$b.isAdmin = isAdmin();
    this.jdField_a_of_type_Aiqd$b.clx = apk();
    this.jdField_a_of_type_Aiqd$b.playMode = paramListenTogetherSession.playMode;
    if (localMusicInfo != null)
    {
      if (localMusicInfo.abP >= 0L) {
        this.jdField_a_of_type_Aiqd$b.abP = localMusicInfo.abP;
      }
      if ((this.jdField_a_of_type_Aiqd$b.duration == 0L) && (localMusicInfo.duration != 0L)) {
        this.jdField_a_of_type_Aiqd$b.clz = true;
      }
      this.jdField_a_of_type_Aiqd$b.duration = (localMusicInfo.duration * 1000L);
    }
    aogk.a().QO(this.jdField_a_of_type_Aiqd$b.isAdmin);
  }
  
  public static void gX(View paramView)
  {
    ((View)paramView.getParent()).post(new BaseListenTogetherPanel.5(paramView));
  }
  
  public static void i(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ((View)paramView.getParent()).post(new BaseListenTogetherPanel.4(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  private String xb()
  {
    try
    {
      String str4 = ex(0);
      String str3 = this.jdField_a_of_type_Aiqd$b.bPu;
      if ((TextUtils.isEmpty(str3)) || (acfp.m(2131695344).equalsIgnoreCase(str3))) {
        return ex(0);
      }
      String str1 = str3;
      if (this.jdField_a_of_type_Aiqd$b.mCurType == 1)
      {
        int i = str4.indexOf(this.mActivity.getResources().getString(2131695367));
        if (i > 0)
        {
          str1 = str4.substring(0, i);
          return str3 + " | 发起人 " + str1;
        }
        str1 = str3 + " | " + str4;
        return str1;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.d("BaseListenTogetherPanel", 1, localThrowable.getMessage(), localThrowable);
      String str2 = "";
      return str2;
    }
  }
  
  public int[] C()
  {
    return new int[] { 3, 5, 9, 10, 13 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 6: 
    case 7: 
    case 8: 
    case 11: 
    case 12: 
    default: 
      return;
    case 3: 
      onCreate();
      return;
    case 5: 
      onResume();
      return;
    case 9: 
      onPause();
      return;
    case 10: 
      onStop();
      return;
    }
    onDestroy();
  }
  
  public boolean Si()
  {
    if ((this.mBaseChatPie.a() == null) || (this.jdField_a_of_type_Yit == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("BaseListenTogetherPanel", 2, "tipManager is null or together is null");
      }
    }
    while (this.mBaseChatPie.a().a() != this.jdField_a_of_type_Yit) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "curTip is togetherTip");
    }
    return true;
  }
  
  public MusicPanelView a()
  {
    if (this.jdField_a_of_type_Yit != null) {
      return (MusicPanelView)this.jdField_a_of_type_Yit.aR();
    }
    return null;
  }
  
  public void a(int paramInt, yjf paramyjf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onOtherTipsHide tip=" + paramyjf + " type=" + paramInt);
    }
    if (!apu()) {
      if (QLog.isColorLevel()) {
        QLog.d("BaseListenTogetherPanel", 2, "onOtherTipsHide mUIData is null or session is null");
      }
    }
    while ((paramInt != 1) || (this.jdField_a_of_type_Yit == null) || (this.jdField_a_of_type_Yit == paramyjf)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onOtherTipsHide tip not equal TogetherTip");
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onOtherTipsHide expand=" + this.jdField_a_of_type_Aiqd$b.cly);
    }
    if (this.jdField_a_of_type_Aiqd$b.cly) {
      apv();
    }
    ccU();
  }
  
  public abstract boolean apk();
  
  public boolean apu()
  {
    return (this.jdField_a_of_type_Aiqd$b.status != 0) && (this.jdField_a_of_type_Aiqd$b.status != 3) && (this.jdField_a_of_type_Aiqd$b.a != null);
  }
  
  public boolean apv()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "showTogetherTip");
    }
    a();
    if (this.mBaseChatPie.a() == null) {
      if (QLog.isColorLevel()) {
        QLog.d("BaseListenTogetherPanel", 2, "tipManager is null");
      }
    }
    do
    {
      return false;
      yjf localyjf = this.mBaseChatPie.a().a();
      if ((localyjf == null) || (localyjf == this.jdField_a_of_type_Yit)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("BaseListenTogetherPanel", 2, "currTip is other");
    return false;
    this.mBaseChatPie.a().a(this.jdField_a_of_type_Yit, new Object[0]);
    return true;
  }
  
  public boolean apw()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "dismissTogetherTip");
    }
    if ((this.jdField_a_of_type_Yit == null) || (this.mBaseChatPie.a() == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("BaseListenTogetherPanel", 2, "tipManager is null or together is null");
      }
    }
    yjf localyjf;
    do
    {
      return false;
      localyjf = this.mBaseChatPie.a().a();
    } while ((localyjf == null) || (localyjf != this.jdField_a_of_type_Yit));
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "currTip is togetherTip");
    }
    this.mBaseChatPie.a().ciA();
    return true;
  }
  
  protected void as(String paramString, int paramInt1, int paramInt2)
  {
    if ((!apu()) || (this.jdField_a_of_type_Aiqd$b.deR != 2)) {}
    do
    {
      do
      {
        return;
        MusicInfo localMusicInfo = this.jdField_a_of_type_Aiqd$b.a.b();
        if ((localMusicInfo == null) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(localMusicInfo.id))) {
          break;
        }
        int i = paramInt1;
        try
        {
          if (this.jdField_a_of_type_Aiqd$b.deS > 97)
          {
            i = paramInt1;
            if (paramInt1 < 0) {
              i = paramInt2;
            }
          }
          paramInt1 = (int)(i * 1.0F / paramInt2 * 100.0F);
          this.jdField_a_of_type_Aiqd$b.abP = i;
          this.jdField_a_of_type_Aiqd$b.duration = paramInt2;
          this.jdField_a_of_type_Aiqd$b.deS = paramInt1;
          b(this.jdField_a_of_type_Aiqd$b);
          return;
        }
        catch (Exception paramString) {}
      } while (!QLog.isColorLevel());
      QLog.e("BaseListenTogetherPanel", 2, "onPlayProgressChange, exception:", paramString);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("BaseListenTogetherPanel", 2, "onPlayProgressChange, music id is not same");
  }
  
  public void b(int paramInt, yjf paramyjf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onOtherTipsShow tip=" + paramyjf + " type=" + paramInt);
    }
    if (paramInt == 1) {}
  }
  
  public void cV(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onExitListenTogetherFail");
    }
    if (!J(paramInt, paramString)) {
      return;
    }
    QQToast.a(this.mActivity, acfp.m(2131703116), 1).show();
  }
  
  public abstract void ccU();
  
  public void d(ListenTogetherSession paramListenTogetherSession)
  {
    if (!a(paramListenTogetherSession))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseListenTogetherPanel", 2, "onUIModuleNeedRefresh, checkSession is false");
      }
      return;
    }
    f(paramListenTogetherSession);
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onUIModuleNeedRefresh, uidata=" + this.jdField_a_of_type_Aiqd$b);
    }
    aogk.a().gc(paramListenTogetherSession.uin, paramListenTogetherSession.type);
    if (this.jdField_a_of_type_Aiqd$b.status == 3)
    {
      String str;
      if (apu())
      {
        str = this.jdField_a_of_type_Aiqd$a.mainAction;
        if (!Si()) {
          break label200;
        }
      }
      label200:
      for (paramListenTogetherSession = "clk_expand";; paramListenTogetherSession = "clk_fold")
      {
        anot.a(null, "dc00899", str, "", "music_tab", paramListenTogetherSession, 0, 0, this.jdField_a_of_type_Aiqd$a.bPt, "", this.jdField_a_of_type_Aiqd$a.deQ + "", "");
        anot.a(null, "dc00898", "", "", "qq_vip", "0X800A5BD", 0, 0, "", "", "", "");
        apw();
        return;
      }
    }
    aogk.a().QO(isAdmin());
    boolean bool = this.jdField_a_of_type_Aiqd$b.cly;
    if (Si() != bool)
    {
      if (!bool) {
        break label282;
      }
      apv();
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Aiqd$b);
      ccU();
      if ((!bool) || (this.clw) || (this.clv)) {
        break;
      }
      this.clw = true;
      dtI();
      return;
      label282:
      apw();
    }
  }
  
  protected void db(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onLyricModuleCloseByFloat");
    }
    if (!J(paramInt, paramString)) {
      return;
    }
    aSc();
  }
  
  public void dtG()
  {
    if ((!apu()) || (Math.abs(System.currentTimeMillis() - this.IJ) < 500L)) {
      return;
    }
    boolean bool = Si();
    if (bool) {
      apw();
    }
    for (;;)
    {
      ccU();
      ListenTogetherManager.a(this.mBaseChatPie.app).n(bool, this.jdField_a_of_type_Aiqd$b.mCurType, this.jdField_a_of_type_Aiqd$b.mCurUin);
      this.IJ = System.currentTimeMillis();
      return;
      apv();
    }
  }
  
  protected void dtI() {}
  
  public String ex(int paramInt)
  {
    String str = this.jdField_a_of_type_Aiqd$b.creatorNick;
    if (str == null) {
      return this.mActivity.getResources().getString(2131695321);
    }
    if (TextUtils.isEmpty(str)) {
      return this.mActivity.getResources().getString(2131695337);
    }
    str = aoij.M(paramInt, str);
    return str + this.mActivity.getResources().getString(2131695367);
  }
  
  public abstract boolean isAdmin();
  
  public void onClick(View paramView)
  {
    int i = 1;
    int j = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.i("BaseListenTogetherPanel", 2, "onClick, id = " + j);
    }
    switch (j)
    {
    default: 
    case 2131378718: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if ((this.jdField_a_of_type_Aiqd$b.deR == 2) && (apk()))
        {
          if (aqiw.isNetworkAvailable(this.mActivity)) {
            break;
          }
          QQToast.a(this.mActivity, 1, this.mActivity.getString(2131696664), 0).show();
        }
      }
      j = this.jdField_a_of_type_Aiqd$b.status;
      if (j == 1)
      {
        ListenTogetherManager.a(this.mBaseChatPie.app).cN(this.jdField_a_of_type_Aiqd$b.mCurType, this.jdField_a_of_type_Aiqd$b.mCurUin);
        this.jdField_a_of_type_Aiqd$b.status = 2;
        anot.a(null, "dc00899", this.jdField_a_of_type_Aiqd$a.mainAction, "", "music_tab", "clk_pause", 0, 0, this.jdField_a_of_type_Aiqd$a.bPt, "", this.jdField_a_of_type_Aiqd$a.deQ + "", "");
      }
      break;
    }
    while (i != 0)
    {
      a(this.jdField_a_of_type_Aiqd$b);
      break;
      if (j == 2)
      {
        ListenTogetherManager.a(this.mBaseChatPie.app).cO(this.jdField_a_of_type_Aiqd$b.mCurType, this.jdField_a_of_type_Aiqd$b.mCurUin);
        this.jdField_a_of_type_Aiqd$b.status = 1;
        continue;
        if (!aqiw.isNetworkAvailable(this.mActivity))
        {
          QQToast.a(this.mActivity, 1, this.mActivity.getString(2131696664), 0).show();
          break;
        }
        this.jdField_a_of_type_Aiod = new aiqf(this);
        ListenTogetherManager.a(this.mBaseChatPie.app).a(this.jdField_a_of_type_Aiqd$b.mCurType, this.jdField_a_of_type_Aiqd$b.mCurUin, this.jdField_a_of_type_Aiod);
        break;
        if (this.jdField_a_of_type_Aiqd$b.deR == 2)
        {
          ListenTogetherSession localListenTogetherSession = ListenTogetherManager.a(this.mActivity.app).a(this.jdField_a_of_type_Aiqd$b.mCurType, this.jdField_a_of_type_Aiqd$b.mCurUin);
          if ((this.jdField_a_of_type_Aiqd$b.status == 1) || (this.jdField_a_of_type_Aiqd$b.status == 2)) {}
          for (i = 1;; i = 0)
          {
            if ((localListenTogetherSession != null) && (i != 0))
            {
              MusicInfo localMusicInfo = localListenTogetherSession.b();
              ListenTogetherPlayFragment.a(this.mActivity, localListenTogetherSession, localMusicInfo, this.jdField_a_of_type_Aiqd$b.isAdmin, null);
            }
            anot.a(null, "dc00899", this.jdField_a_of_type_Aiqd$a.mainAction, "", "music_tab", "clk_detail", 0, 0, this.jdField_a_of_type_Aiqd$a.bPt, "", this.jdField_a_of_type_Aiqd$a.deQ + "", "");
            break;
          }
        }
        if ((this.jdField_a_of_type_Aiqd$b.deR != 1) && (this.jdField_a_of_type_Aiqd$b.deR != 3)) {
          break;
        }
        dtF();
        break;
        dtF();
        break;
        dtH();
        anot.a(null, "dc00899", this.jdField_a_of_type_Aiqd$a.mainAction, "", "music_tab", "clk_list", 0, 0, this.jdField_a_of_type_Aiqd$a.bPt, "", this.jdField_a_of_type_Aiqd$a.deQ + "", "");
        break;
      }
      i = 0;
    }
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onCreate()");
    }
    this.mBaseChatPie.app.addObserver(this.c);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onDestroy()");
    }
    aogk.a().leave();
    this.mBaseChatPie.app.removeObserver(this.c);
    ListenTogetherManager.a(this.mBaseChatPie.app).M(this.jdField_a_of_type_Aiqd$b.mCurType, this.jdField_a_of_type_Aiqd$b.mCurUin, this.mBaseChatPie.hashCode());
    ciw();
  }
  
  public void onPause()
  {
    this.zR = false;
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onPause()");
    }
    yjh localyjh = this.mBaseChatPie.a();
    if (localyjh != null) {
      localyjh.h(1003, new Object[0]);
    }
    ListenTogetherManager.a(this.mBaseChatPie.app).K(this.jdField_a_of_type_Aiqd$b.mCurType, this.jdField_a_of_type_Aiqd$b.mCurUin, this.mBaseChatPie.hashCode());
  }
  
  public void onResume()
  {
    this.zR = true;
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onResume()");
    }
    this.clu = false;
    ListenTogetherManager.a(this.mBaseChatPie.app).J(this.jdField_a_of_type_Aiqd$b.mCurType, this.jdField_a_of_type_Aiqd$b.mCurUin, this.mBaseChatPie.hashCode());
    ChatFragment localChatFragment = ((FragmentActivity)this.mBaseChatPie.a()).getChatFragment();
    aogk.a().a(localChatFragment, String.valueOf(this.jdField_a_of_type_Aiqd$b.mCurUin), this.jdField_a_of_type_Aiqd$b.mCurType);
  }
  
  public void onStop()
  {
    this.zR = false;
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onStop()");
    }
    this.clu = false;
    String str2;
    if (apu())
    {
      str2 = this.jdField_a_of_type_Aiqd$a.mainAction;
      if (!Si()) {
        break label104;
      }
    }
    label104:
    for (String str1 = "clk_expand";; str1 = "clk_fold")
    {
      anot.a(null, "dc00899", str2, "", "music_tab", str1, 0, 0, this.jdField_a_of_type_Aiqd$a.bPt, "", this.jdField_a_of_type_Aiqd$a.deQ + "", "");
      return;
    }
  }
  
  public void s(int paramInt, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onJoinListenTogetherFail");
    }
    if (!J(paramInt, paramString)) {
      return;
    }
    QQToast.a(this.mActivity, acfp.m(2131703115), 1).show();
    this.jdField_a_of_type_Aiqd$b.deR = 1;
    a(this.jdField_a_of_type_Aiqd$b);
  }
  
  public String u(boolean paramBoolean)
  {
    if (acfp.m(2131695344).equals(this.jdField_a_of_type_Aiqd$b.bPu)) {}
    for (String str = ex(16);; str = this.jdField_a_of_type_Aiqd$b.bPu)
    {
      if (paramBoolean) {
        str = acfp.m(2131695371);
      }
      return str;
    }
  }
  
  public static class a
  {
    public String bPt;
    public int deQ;
    public String mainAction;
  }
  
  public static class b
  {
    ListenTogetherSession a;
    long abP;
    String bPu = "";
    String baZ = "";
    boolean clx;
    boolean cly = true;
    boolean clz = false;
    String creatorNick = null;
    int deR;
    int deS;
    long duration;
    boolean isAdmin;
    int mCurType = -1;
    String mCurUin = "";
    int playMode;
    int status;
    
    public void reset()
    {
      this.status = 0;
      this.deR = -1;
      this.deS = 0;
      this.cly = true;
      this.a = null;
      this.abP = 0L;
      this.duration = 0L;
      this.clz = false;
      this.baZ = "";
      this.creatorNick = null;
      this.bPu = "";
      this.playMode = 1;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append("UiData{mCurType=").append(this.mCurType).append(", mCurUin='").append(this.mCurUin).append(", status=").append(this.status).append(", userState=").append(this.deR).append(", changeMusic=").append(this.clz).append(", isAdmin=").append(this.isAdmin).append(", canOper=").append(this.clx).append(", playMode=").append(this.playMode).append(", creatorUin=").append(this.baZ).append(", creatorNick=");
      if (this.creatorNick == null) {}
      for (String str = "null";; str = this.creatorNick) {
        return str + ", isShowPanel=" + this.cly + ", progres=" + this.deS + ", titleMsg=" + this.bPu + ", session=\n" + this.a + '}';
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiqd
 * JD-Core Version:    0.7.0.1
 */