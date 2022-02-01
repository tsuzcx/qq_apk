package com.tencent.mobileqq.ar.view;

import adbu;
import adby;
import adca;
import adcc;
import adkw;
import adkw.c;
import adkx;
import adla;
import adla.a;
import adla.b;
import adla.c;
import adla.e;
import adlt;
import adlw;
import admh;
import admi;
import admk;
import adml;
import adml.a;
import akqx;
import akqx.a;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import anot;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo.a;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.olympic.activity.PromotionEntry;
import com.tencent.mobileqq.olympic.activity.PromotionEntry.a;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

@TargetApi(11)
public class ScanEntryProviderContainerView
  extends FrameLayout
  implements adkw.c, admh, akqx.a, PromotionEntry.a
{
  private adla.b jdField_a_of_type_Adla$b;
  private adml jdField_a_of_type_Adml;
  private PromotionConfigInfo.a jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo$a;
  private a jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView$a = new admk(this);
  private ScanEntryProviderView jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView;
  private PromotionEntry jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry;
  private adkw jdField_b_of_type_Adkw;
  private adkx jdField_b_of_type_Adkx;
  private adlw jdField_b_of_type_Adlw = new adlw();
  private akqx jdField_b_of_type_Akqx;
  private Rect bA;
  private boolean bPI = true;
  private boolean bPJ = true;
  private boolean bPK;
  private boolean bPL;
  private boolean bPM;
  private boolean bPN;
  private boolean bPO;
  private boolean bPP = true;
  private boolean bPQ;
  private boolean bPo;
  FrameLayout bw;
  private int cIM = -1;
  private Handler cf;
  private ARCommonConfigInfo d;
  View hH;
  LinearLayout iq;
  private long iu;
  private HashMap<Integer, ScanEntryProviderView> jx = new HashMap();
  protected AppInterface mApp;
  protected Context mContext;
  private View.OnTouchListener z = new admi(this);
  
  public ScanEntryProviderContainerView(Context paramContext)
  {
    super(paramContext);
    initUI();
  }
  
  public ScanEntryProviderContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initUI();
  }
  
  public ScanEntryProviderContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initUI();
  }
  
  private void a(adla.b paramb)
  {
    QLog.d("ScanEntryProviderContainerView", 2, "preparePromotionResource");
    this.jdField_a_of_type_Adla$b = paramb;
    if ((!adbu.adu()) || (!this.bPJ))
    {
      if ((this.jdField_a_of_type_Adla$b instanceof adla.a)) {
        ThreadManager.getUIHandler().postDelayed(new ScanEntryProviderContainerView.2(this), 1000L);
      }
      QLog.d("ScanEntryProviderContainerView", 2, "doTransferDoor device not support");
      return;
    }
    if (this.jdField_b_of_type_Akqx == null)
    {
      this.jdField_b_of_type_Akqx = new akqx((ScanTorchActivity)this.mContext);
      this.jdField_b_of_type_Akqx.a(this);
      this.jdField_b_of_type_Akqx.setAppInterface(this.mApp);
    }
    if ((this.jdField_a_of_type_Adla$b instanceof adla.a))
    {
      paramb = ((adla.a)this.jdField_a_of_type_Adla$b).buw;
      b("doTransferDoor", null, false);
    }
    for (;;)
    {
      this.jdField_b_of_type_Akqx.j(this.mApp, paramb);
      return;
      paramb = null;
    }
  }
  
  private void cTr()
  {
    if (this.iq != null) {
      this.iq.setVisibility(8);
    }
  }
  
  private void initUI()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131561215, null);
    addView(localView);
    this.hH = localView;
    this.bw = ((FrameLayout)localView.findViewById(2131377680));
    this.iq = ((LinearLayout)localView.findViewById(2131363645));
    this.jdField_a_of_type_Adml = new adml(1);
    this.cf = new Handler();
  }
  
  public boolean BJ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanEntryProviderContainerView", 2, "isEngineReady = ");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView == null) {}
    while (!(this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView instanceof ARScanEntryView)) {
      return false;
    }
    return ((ARScanEntryView)this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView).afg();
  }
  
  public void C(int paramInt, Bundle paramBundle)
  {
    paramBundle.getBoolean("COLD_START", false);
    int i = paramBundle.getInt("fromSource", 1);
    int j = this.jdField_a_of_type_Adml.gQ(paramInt);
    QLog.i("ScanEntryProviderContainerView", 1, "showProviderEntry index=" + j);
    if (this.cIM == j) {
      QLog.i("ScanEntryProviderContainerView", 1, "showProviderEntry value equal return");
    }
    label392:
    label405:
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView.cSS();
        this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView.Gs(false);
        this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView.setVisibility(8);
      }
      Object localObject;
      if (this.jx.containsKey(Integer.valueOf(j)))
      {
        localObject = (ScanEntryProviderView)this.jx.get(Integer.valueOf(j));
        if ((localObject != null) && (!((ScanEntryProviderView)localObject).mInited))
        {
          ((ScanEntryProviderView)localObject).setAppInterface(this.mApp);
          ((ScanEntryProviderView)localObject).onCreate(paramBundle);
          ((ScanEntryProviderView)localObject).setRectAreas(this.bA);
          if (paramInt == 1) {
            ((QRScanEntryView)localObject).setVoiceScanStatusListener(this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView$a);
          }
        }
        this.cIM = j;
        this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView = ((ScanEntryProviderView)localObject);
        if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView.cSR();
          if (this.d != null) {
            this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView.b(this.d);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo$a != null) && ((this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView instanceof ARScanEntryView))) {
            ((ARScanEntryView)this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView).a(this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo$a);
          }
          if ((paramInt == 2) || (!this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView.afl())) {
            break label392;
          }
          Gz(true);
        }
      }
      for (;;)
      {
        if (this.cIM != 1) {
          break label405;
        }
        anot.a(null, "CliOper", "", "", "0X8008F23", "0X8008F23", 0, 0, Integer.toString(i), "0", "0", "");
        return;
        ScanEntryProviderView localScanEntryProviderView = this.jdField_a_of_type_Adml.a(paramInt, this.mContext, this);
        localObject = localScanEntryProviderView;
        if (localScanEntryProviderView == null) {
          break;
        }
        this.jx.put(Integer.valueOf(j), localScanEntryProviderView);
        this.bw.addView(localScanEntryProviderView);
        localObject = localScanEntryProviderView;
        break;
        if (paramInt == 2) {
          Gz(false);
        }
      }
    } while (this.cIM != 2);
    anot.a(null, "dc00898", "", "", "0X8009C7B", "0X8009C7B", 0, 0, "", "0", "0", "");
  }
  
  public void GA(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanEntryProviderContainerView", 2, "onNotifyBottomControllerPanelVisiable enable" + paramBoolean);
    }
    if ((this.bPQ) || (this.bPo) || (this.bPP == paramBoolean)) {
      return;
    }
    this.bPP = paramBoolean;
    ScanEntryProviderContainerView.7 local7 = new ScanEntryProviderContainerView.7(this, paramBoolean);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      local7.run();
      return;
    }
    this.cf.post(local7);
  }
  
  public void GB(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView.Gz(paramString);
    }
  }
  
  public void Gz(boolean paramBoolean)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("ScanEntryProviderContainerView", 2, "onAllowShowEntryChange enable " + paramBoolean);
    }
    if (!this.bPJ) {
      QLog.d("ScanEntryProviderContainerView", 1, "onAllowShowEntryChange refuse ,becauseof h5 not allowed show entry");
    }
    do
    {
      do
      {
        do
        {
          return;
          if (!this.bPL)
          {
            this.bPK = paramBoolean;
            return;
          }
          if ((!this.bPM) || ((this.bPM) && (!this.bPN) && (this.cIM != 2)) || (this.cIM == 1)) {
            paramBoolean = false;
          }
        } while ((this.bPK == paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry != null));
        this.bPK = paramBoolean;
        if ((!this.bPK) || (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry != null) || (this.bPo)) {
          break;
        }
      } while (this.jdField_b_of_type_Akqx == null);
      this.jdField_b_of_type_Akqx.x(this.mApp);
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry == null);
    PromotionEntry localPromotionEntry = this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry;
    if (this.bPo) {}
    for (paramBoolean = bool;; paramBoolean = this.bPK)
    {
      localPromotionEntry.showEntry(paramBoolean);
      return;
    }
  }
  
  public adkw a()
  {
    return this.jdField_b_of_type_Adkw;
  }
  
  public akqx a()
  {
    return this.jdField_b_of_type_Akqx;
  }
  
  public void a(adla.b paramb, boolean paramBoolean)
  {
    QLog.i("ScanEntryProviderContainerView", 1, "showProviderEntry with bundle");
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("COLD_START", true);
    boolean bool;
    if (!this.bPI)
    {
      bool = true;
      localBundle.putBoolean("hide_album", bool);
      if ((!paramBoolean) && (((paramb instanceof adla.a)) || ((paramb instanceof adla.c)))) {
        a(paramb);
      }
      if ((!paramBoolean) || (paramb == null) || (!(paramb instanceof adla.e))) {
        break label119;
      }
      if (paramBoolean)
      {
        ((ViewGroup)this.hH).removeView(this.iq);
        this.bPQ = true;
      }
      C(2, localBundle);
    }
    label119:
    do
    {
      return;
      bool = false;
      break;
      if ((paramBoolean) || (paramb == null) || ((paramb != null) && (!paramb.bOP)))
      {
        if (paramBoolean)
        {
          ((ViewGroup)this.hH).removeView(this.iq);
          this.bPQ = true;
        }
        C(1, localBundle);
        return;
      }
      paramBoolean = paramb.bOP;
      if ((paramb instanceof adla.a))
      {
        localBundle.putInt("fromSource", 2);
        C(3, adla.i(localBundle));
        anot.a(null, "dc00898", "", "", "0X80098C7", "0X80098C7", 3, 0, "", "", "", "");
        return;
      }
    } while (!paramBoolean);
    localBundle.putLong("recognitionMask", paramb.UX);
    localBundle.putBoolean("NoLimitParams", false);
    localBundle.putBoolean("enableARCloud", paramb.bOO);
    ((ViewGroup)this.hH).removeView(this.iq);
    this.bPQ = true;
    localBundle.putInt("fromSource", 2);
    C(3, localBundle);
  }
  
  public void a(PromotionConfigInfo.a parama, boolean paramBoolean)
  {
    QLog.d("ScanEntryProviderContainerView", 1, "onPromotionResComplete, promotionItem[" + parama + "], ready[" + paramBoolean + "]isAlreadyEnterPromotion=" + afk());
    if ((this.bPO) || (!afk())) {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo$a = parama;
      }
    }
    do
    {
      return;
      if (paramBoolean)
      {
        parama = new ScanEntryProviderContainerView.4(this, parama);
        if (Thread.currentThread() == Looper.getMainLooper().getThread())
        {
          parama.run();
          return;
        }
        ThreadManager.getUIHandler().post(parama);
        return;
      }
      if ((parama == null) && (afk()))
      {
        ThreadManager.getUIHandler().postDelayed(new ScanEntryProviderContainerView.5(this), 1000L);
        return;
      }
    } while ((!afk()) || (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView == null) || (!(this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView instanceof ARScanEntryView)));
    ((ARScanEntryView)this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView).Gw(true);
  }
  
  public boolean afj()
  {
    return this.bPK;
  }
  
  public boolean afk()
  {
    if (adbu.adu())
    {
      if ((this.jdField_a_of_type_Adla$b instanceof adla.a)) {
        return true;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry != null) && (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry.cui))
      {
        QLog.d("ScanEntryProviderContainerView", 1, "autoEnterTransferDoorMode, 已经点过入口");
        return true;
      }
    }
    return false;
  }
  
  public adkx b()
  {
    return this.jdField_b_of_type_Adkx;
  }
  
  public void b(PromotionConfigInfo.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanEntryProviderContainerView", 2, "notifyPromotionEntryReady");
    }
    if (afk()) {
      cTr();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry = new PromotionEntry(this);
        this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry.a(this.mApp, parama);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry.showEntry(true);
    } while (!QLog.isColorLevel());
    QLog.d("ScanEntryProviderContainerView", 2, "PromotionEntry has already exist");
  }
  
  public void b(ARCommonConfigInfo paramARCommonConfigInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView.b(paramARCommonConfigInfo);
    }
    this.d = paramARCommonConfigInfo;
  }
  
  public void b(String paramString, PromotionConfigInfo.a parama, boolean paramBoolean)
  {
    QLog.d("ScanEntryProviderContainerView", 1, "enterTransferDoorMode[" + paramString + "], mIsTransferDoorMode[" + this.bPo + "], ready[" + paramBoolean + "]");
    this.bPo = true;
    cTr();
  }
  
  public void bP(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanEntryProviderContainerView", 2, "updatePromotionEntryVisiableInfo");
    }
    this.bPL = true;
    this.bPM = paramBoolean1;
    this.bPN = paramBoolean2;
    this.cf.post(new ScanEntryProviderContainerView.6(this));
  }
  
  public ARCommonConfigInfo c()
  {
    return this.d;
  }
  
  public void c(PromotionConfigInfo.a parama)
  {
    Object localObject = new StringBuilder().append("onPromotionEntryClick ");
    if (parama != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ScanEntryProviderContainerView", 1, bool);
      if ((this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView != null) && (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry != null) && (parama != null)) {
        break;
      }
      return;
    }
    if (adby.a(false, this.mApp.getCurrentAccountUin(), parama) != null) {
      if (this.jdField_b_of_type_Akqx == null)
      {
        QLog.d("ScanEntryProviderContainerView", 1, "operateBtnOnClick, 资源还没准备好");
        adca.a(this.mApp).d(this.mApp, parama.id);
        bool = false;
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView instanceof ARScanEntryView))
      {
        localObject = (ARScanEntryView)this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView;
        if (!((ARScanEntryView)localObject).afg())
        {
          QLog.d("ScanEntryProviderContainerView", 1, "onPromotionEntryClick refuse,AREngine not ready");
          return;
          QLog.w("ScanEntryProviderContainerView", 1, "operateBtnOnClick, 资源还没准备好, TotalProgress[" + this.jdField_b_of_type_Akqx.sp() + "], isDownloading[" + this.jdField_b_of_type_Akqx.isDownloading() + "], isDownloadError[" + this.jdField_b_of_type_Akqx.asE() + "]");
          this.jdField_b_of_type_Akqx.u(this.mApp);
          bool = false;
          continue;
          bool = true;
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo$a != null) {
            ((ARScanEntryView)localObject).a(this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo$a);
          }
          ((ARScanEntryView)localObject).a("onPromotionEntryClick", parama, bool);
          anot.a(null, "dc00898", "", "", "0X80098C7", "0X80098C7", 2, 0, "", "", "", "");
          if (!bool)
          {
            if (this.jdField_b_of_type_Akqx != null) {
              this.jdField_b_of_type_Akqx.Nc(true);
            }
            ((ARScanEntryView)localObject).bW("operateBtnOnClick1", true);
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry.a(false, parama);
      if (this.jdField_b_of_type_Akqx != null) {
        this.jdField_b_of_type_Akqx.Nc(true);
      }
      b("onClickOperateEntry", parama, bool);
      return;
      int i = this.jdField_a_of_type_Adml.gQ(3);
      if (this.jx.containsKey(Integer.valueOf(i)))
      {
        localObject = (ARScanEntryView)this.jx.get(Integer.valueOf(i));
        ((ScanEntryProviderView)localObject).cSS();
        ((ScanEntryProviderView)localObject).Gs(true);
        this.jx.remove(Integer.valueOf(i));
      }
      localObject = adla.i(null);
      ((Bundle)localObject).putString("Title", parama.title);
      C(3, (Bundle)localObject);
      anot.a(null, "dc00898", "", "", "0X80098C7", "0X80098C7", 1, 0, "", "", "", "");
    }
  }
  
  public void cSv()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView != null) && ((this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView instanceof ARScanEntryView))) {
      ((ARScanEntryView)this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView).cSv();
    }
  }
  
  public void cTq()
  {
    QLog.i("ScanEntryProviderContainerView", 1, "doOnWindowFocusFirstTimeVisiable");
    if ((!this.bPo) && (this.bPJ)) {
      Gz(true);
    }
  }
  
  public void ces()
  {
    this.jdField_a_of_type_Adml.ie();
    int[] arrayOfInt = this.jdField_a_of_type_Adml.O();
    String[] arrayOfString = this.jdField_a_of_type_Adml.L();
    int k = this.jdField_a_of_type_Adml.BR();
    int i = 0;
    while (i < arrayOfInt.length)
    {
      adml.a locala = this.jdField_a_of_type_Adml.a(i);
      ImageView localImageView = (ImageView)findViewById(arrayOfInt[i]);
      Object localObject = this.jdField_a_of_type_Adml.k(i);
      if (localObject == null)
      {
        i += 1;
      }
      else
      {
        if (locala.cdN == 1) {}
        for (int j = k - 1;; j = 0)
        {
          localObject = new adlt((int[])localObject, localImageView, j);
          localImageView.setTag(Integer.valueOf(locala.cdN));
          localImageView.setOnTouchListener(this.z);
          localImageView.setContentDescription(arrayOfString[i]);
          this.jdField_b_of_type_Adlw.a(locala.cdN, (adlt)localObject);
          break;
        }
      }
    }
  }
  
  public void eh(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanEntryProviderContainerView", 2, "updatePromotionResProgress Progress:" + paramInt);
    }
    if (!afk()) {
      if (QLog.isColorLevel()) {
        QLog.d("ScanEntryProviderContainerView", 2, "updatePromotionResProgress not show,because not under promotion mode");
      }
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView == null) || (!(this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView instanceof ARScanEntryView))) {
      return;
    }
    ((ARScanEntryView)this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView).bW(paramString, true);
  }
  
  public void i(Rect paramRect)
  {
    if ((paramRect != null) && (!paramRect.equals(this.bA)))
    {
      this.bA = paramRect;
      Iterator localIterator = this.jx.entrySet().iterator();
      while (localIterator.hasNext())
      {
        ScanEntryProviderView localScanEntryProviderView = (ScanEntryProviderView)((Map.Entry)localIterator.next()).getValue();
        if ((localScanEntryProviderView != null) && (localScanEntryProviderView.mInited)) {
          localScanEntryProviderView.setRectAreas(paramRect);
        }
      }
    }
  }
  
  public RelativeLayout l()
  {
    return (RelativeLayout)this.hH;
  }
  
  public void onDestroy()
  {
    Iterator localIterator = this.jx.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ScanEntryProviderView)((Map.Entry)localIterator.next()).getValue()).onDestroy();
    }
    if (this.jdField_b_of_type_Akqx != null)
    {
      this.jdField_b_of_type_Akqx.t(this.mApp);
      this.jdField_b_of_type_Akqx = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry.t(this.mApp);
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry = null;
    }
    if (this.jdField_b_of_type_Adlw != null) {
      this.jdField_b_of_type_Adlw.doDestroy();
    }
    this.bPO = true;
  }
  
  public void onPause()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView.onPause();
    }
  }
  
  public void onResume()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView.onResume();
    }
  }
  
  public void setInitEnv(AppInterface paramAppInterface, Context paramContext)
  {
    this.mApp = paramAppInterface;
    this.mContext = paramContext;
  }
  
  public void setRenderEngine(adkx paramadkx)
  {
    this.jdField_b_of_type_Adkx = paramadkx;
  }
  
  public void setScanRect(Rect paramRect, boolean paramBoolean)
  {
    this.bA = paramRect;
    this.bPI = paramBoolean;
  }
  
  public void setUniformResManager(adkw paramadkw)
  {
    this.jdField_b_of_type_Adkw = paramadkw;
    this.jdField_b_of_type_Adkw.a(this);
  }
  
  public static abstract interface a
  {
    public abstract void Lo(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ScanEntryProviderContainerView
 * JD-Core Version:    0.7.0.1
 */