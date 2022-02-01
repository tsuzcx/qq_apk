package dov.com.qq.im.capture.view;

import acfp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import aqgz;
import aqha;
import aqju;
import auru;
import awte;
import axov;
import axoz;
import axpr;
import axpr.a;
import axqc;
import axqd;
import axqf;
import axqm;
import axrf;
import axrh;
import axrk;
import axro;
import axsf;
import axtq;
import axwu;
import axwv;
import axww;
import axwx;
import axwy;
import axwz;
import axxa;
import axxb;
import axxj;
import axyb;
import ayva.a;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.GridView;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.adapter.MusicProviderPagerAdapter;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.music.QIMMusicConfigManager.a;
import dov.com.qq.im.capture.music.humrecognition.HummingActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.BaseActivity;
import rma;
import rpw;

public class MusicProviderView
  extends ProviderView
  implements Handler.Callback, ViewPager.OnPageChangeListener, axpr.a, AdapterView.c, QIMSlidingTabView.a
{
  public static boolean dwS;
  axrh jdField_a_of_type_Axrh = new axwv(this);
  axrk jdField_a_of_type_Axrk = new axww(this);
  private axro jdField_a_of_type_Axro;
  MusicProviderPagerAdapter jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter;
  QIMMusicConfigManager.a jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager$a = new axwx(this);
  public auru b;
  public axrf b;
  QQViewPager b;
  public int bjK = 0;
  private boolean dvG;
  public boolean dwT = true;
  private boolean dwU;
  private boolean dwV = true;
  private boolean dwW;
  int dzH = 0;
  public MusicItemInfo e;
  public int eIu = -1;
  public int eIv = -1;
  private int eIw = -1;
  public MusicItemInfo i;
  private MusicItemInfo j;
  List<axqd> lI;
  public long mLastUpdateTime;
  
  public MusicProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Auru = new auru(Looper.getMainLooper(), this);
    this.jdField_b_of_type_Axrf = new axwu(this);
  }
  
  public static MusicItemInfo a(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      localObject = null;
      return localObject;
    }
    ArrayList localArrayList = ((QIMMusicConfigManager)axov.a(2)).eJ();
    if (localArrayList != null)
    {
      int k = 0;
      for (;;)
      {
        if (k >= localArrayList.size()) {
          break label129;
        }
        axqd localaxqd = (axqd)localArrayList.get(k);
        if ((localaxqd != null) && (localaxqd.Fv != null))
        {
          int m = 0;
          for (;;)
          {
            if (m >= localaxqd.Fv.size()) {
              break label122;
            }
            MusicItemInfo localMusicItemInfo = (MusicItemInfo)localaxqd.Fv.get(m);
            if (localMusicItemInfo != null)
            {
              localObject = localMusicItemInfo;
              if (paramString.equals(localMusicItemInfo.getLocalPath())) {
                break;
              }
            }
            m += 1;
          }
        }
        label122:
        k += 1;
      }
    }
    label129:
    return null;
  }
  
  private List<axqd> bE(List<axqd> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder(64);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      axqd localaxqd = (axqd)paramList.next();
      if (localaxqd.enabled)
      {
        localArrayList.add(localaxqd);
        localStringBuilder.append(localaxqd.categoryName).append(",");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, new Object[] { "filterMusicList, ", localStringBuilder.toString() });
    }
    return localArrayList;
  }
  
  private void d(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    aqju localaqju = aqha.a((Activity)getContext(), 2131700437);
    localaqju.setNegativeButton(2131721058, new axwy(this));
    localaqju.setPositiveButton(2131721079, new axwz(this, paramAdapterView, paramView, paramInt, paramLong));
    localaqju.show();
  }
  
  private void ePa()
  {
    if (this.jdField_a_of_type_Axro != null) {
      this.jdField_a_of_type_Axro.eOq();
    }
    if (this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a != null) {
      this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a.r(110, new Object[0]);
    }
  }
  
  private void initData(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, "initData");
    }
    Object localObject = (QIMMusicConfigManager)axov.a(2);
    if ((axsf.ON) && (this.eCJ == 2))
    {
      ((QIMMusicConfigManager)localObject).YT(true);
      localObject = ((QIMMusicConfigManager)localObject).eJ();
      if (localObject == null) {
        break label350;
      }
      localObject = bE((List)localObject);
    }
    label151:
    label324:
    label350:
    for (;;)
    {
      if (paramBundle != null) {}
      for (paramBundle = paramBundle.getBundle(MusicProviderView.class.getSimpleName());; paramBundle = null)
      {
        if ((paramBundle != null) && (localObject != null))
        {
          this.bjK = paramBundle.getInt("capture_mode", 0);
          MusicItemInfo localMusicItemInfo = (MusicItemInfo)paramBundle.getParcelable("select_music");
          paramBundle = paramBundle.getString("select_music_local_path");
          if ((localMusicItemInfo != null) && (!TextUtils.isEmpty(paramBundle))) {
            localMusicItemInfo.setPath(paramBundle);
          }
          int k;
          if (this.bjK == 5)
          {
            this.i = localMusicItemInfo;
            paramBundle = localMusicItemInfo;
            if (localMusicItemInfo != null)
            {
              if (QLog.isColorLevel()) {
                QLog.i("MusicProviderView", 2, "restore music" + localMusicItemInfo.mMusicName);
              }
              k = 0;
            }
          }
          else
          {
            for (;;)
            {
              paramBundle = localMusicItemInfo;
              if (k >= ((List)localObject).size()) {
                break label324;
              }
              axqd localaxqd = (axqd)((List)localObject).get(k);
              if (localaxqd.categoryName.equals(localMusicItemInfo.mTagName))
              {
                int m = 0;
                for (;;)
                {
                  paramBundle = localMusicItemInfo;
                  if (m >= localaxqd.Fv.size()) {
                    break;
                  }
                  if (localMusicItemInfo.equals((MusicItemInfo)localaxqd.Fv.get(m)))
                  {
                    this.eIu = k;
                    this.eIv = m;
                  }
                  m += 1;
                }
                ((QIMMusicConfigManager)localObject).YT(false);
                break;
                this.i = null;
                break label151;
              }
              k += 1;
            }
          }
        }
        else
        {
          paramBundle = null;
        }
        if (paramBundle == null) {
          new MusicItemInfo().mType = 2;
        }
        this.dwT = true;
        return;
      }
    }
  }
  
  private void k(MusicItemInfo paramMusicItemInfo)
  {
    if (this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a != null) {
      this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a.r(109, new Object[] { paramMusicItemInfo });
    }
  }
  
  public static int lU(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 3) {
      return 5;
    }
    if ((paramInt == 4) || (paramInt == 12) || (paramInt == 8)) {
      return 3;
    }
    if (paramInt == 10) {
      return 4;
    }
    return 2;
  }
  
  private void updateUI()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter == null) {}
    long l;
    do
    {
      return;
      l = SystemClock.uptimeMillis();
      int n = this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter.wu();
      int k = 0;
      if (k < n)
      {
        GridView localGridView = this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter.b(k);
        if (localGridView == null) {}
        for (;;)
        {
          k += 1;
          break;
          int i1 = localGridView.getChildCount();
          int m = 0;
          while (m < i1)
          {
            View localView = localGridView.getChildAt(m);
            ((axoz)localGridView.getAdapter()).jx(localView);
            m += 1;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("MusicProviderView", 2, "updateUI cost " + (SystemClock.uptimeMillis() - l));
  }
  
  protected Bundle D()
  {
    Bundle localBundle = new Bundle();
    if (this.jdField_a_of_type_Axro != null)
    {
      this.j = this.jdField_a_of_type_Axro.b();
      if (this.j != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MusicProviderView", 2, "save music" + this.j.mMusicName);
        }
        localBundle.putParcelable("select_music", this.j);
      }
      boolean bool = this.jdField_a_of_type_Axro.isMute();
      if (bool) {
        localBundle.putBoolean("select_mute", bool);
      }
    }
    return localBundle;
  }
  
  protected int QW()
  {
    return 2131561125;
  }
  
  public void TX(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.lI.size())) {
      return;
    }
    if (paramInt != 0) {
      ePc();
    }
    this.dzH = paramInt;
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(paramInt);
  }
  
  public void Xe(boolean paramBoolean)
  {
    if (!isInit())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MusicProviderView", 2, "updateData MusicProviderView not init");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, "updateData");
    }
    Object localObject = (QIMMusicConfigManager)axov.a(2);
    int m = this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem();
    int k;
    label113:
    QIMSlidingItemView.a locala;
    if ((axsf.ON) && (this.eCJ == 2))
    {
      ((QIMMusicConfigManager)localObject).YT(true);
      this.lI = ((QIMMusicConfigManager)localObject).c(paramBoolean);
      this.lI = bE(this.lI);
      localObject = new ArrayList();
      this.eIw = -1;
      k = 0;
      if (k >= this.lI.size()) {
        break label238;
      }
      locala = new QIMSlidingItemView.a();
      locala.mText = ((axqd)this.lI.get(k)).categoryName;
      if (((axqd)this.lI.get(k)).cVe != 999) {
        break label223;
      }
      this.eIw = k;
      locala.eIE = 2130845439;
    }
    for (locala.eIF = 2130845440;; locala.eIF = 0)
    {
      ((ArrayList)localObject).add(locala);
      k += 1;
      break label113;
      ((QIMMusicConfigManager)localObject).YT(false);
      break;
      label223:
      locala.eIE = 0;
    }
    label238:
    this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.fE((ArrayList)localObject);
    this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter.lV(this.lI);
    this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter.notifyDataSetChanged();
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter);
    this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.TX(m);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(m);
  }
  
  public void Zb(boolean paramBoolean)
  {
    if ((this.dwT) && (!paramBoolean)) {
      this.dwT = false;
    }
    do
    {
      return;
      this.jdField_a_of_type_Axro = ((axro)axov.a().c(8));
    } while (this.jdField_a_of_type_Axro == null);
    MusicItemInfo localMusicItemInfo = this.jdField_a_of_type_Axro.b();
    this.jdField_a_of_type_Axro.a(localMusicItemInfo, true, this.eCJ);
  }
  
  public void a(axqc paramaxqc) {}
  
  public void a(axqc paramaxqc, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_Axro != null)) {
      this.jdField_a_of_type_Axro.eOr();
    }
  }
  
  public void a(axqf paramaxqf, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(axqm paramaxqm, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(ayva.a parama) {}
  
  public boolean aPD()
  {
    if (this.jdField_a_of_type_Axro == null) {
      return false;
    }
    return this.jdField_a_of_type_Axro.aPD();
  }
  
  public boolean aPT()
  {
    return this.dwV;
  }
  
  public void apk()
  {
    super.apk();
    if (this.jdField_a_of_type_Axro != null) {
      this.jdField_a_of_type_Axro.aeH(this.eCJ);
    }
    this.e = null;
    this.i = null;
    dwS = false;
  }
  
  public void aq(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, "selectCategoryAndItem category= " + paramInt + " categoryName= " + paramString1 + ",itemId=" + paramString2);
    }
    int k = 0;
    if (k < this.lI.size()) {
      if ((paramInt != -1) && (((axqd)this.lI.get(k)).cVe == paramInt)) {
        paramInt = k;
      }
    }
    for (;;)
    {
      a().TX(paramInt);
      axqd localaxqd = (axqd)this.lI.get(this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem());
      try
      {
        k = Integer.valueOf(paramString2).intValue();
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          label216:
          k = -1;
          label362:
          paramString1.printStackTrace();
          int m = k;
          continue;
          label373:
          k += 1;
        }
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("MusicProviderView", 2, "selectCategoryAndItem itemID= " + k);
        }
        m = k;
        k = 0;
        if (k >= localaxqd.Fv.size()) {
          break label386;
        }
        paramString1 = (MusicItemInfo)localaxqd.Fv.get(k);
        if (paramString1.mItemId != m) {
          break label373;
        }
      }
      catch (Exception paramString1)
      {
        break label362;
        label386:
        k = 0;
        paramString1 = null;
        break label216;
      }
      if ((paramString1 != null) && (QLog.isColorLevel())) {
        QLog.d("MusicProviderView", 2, hashCode() + "selectCategoryAndItem itemInfo= " + paramString1.mMusicName + ",index=" + paramInt + ",pos=" + k);
      }
      if (paramString1 != null)
      {
        postDelayed(new MusicProviderView.5(this, k), 500L);
        l(paramString1);
        updateUI();
      }
      return;
      if ((paramString1 != null) && (paramString1.equals(((axqd)this.lI.get(k)).categoryName)))
      {
        paramInt = k;
      }
      else
      {
        k += 1;
        break;
        paramInt = 0;
      }
    }
  }
  
  public void b(MusicItemInfo paramMusicItemInfo, boolean paramBoolean)
  {
    if (paramMusicItemInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MusicProviderView", 2, "startMusic itemInfo=null");
      }
    }
    label77:
    do
    {
      return;
      if (this.jdField_a_of_type_Axro == null) {
        this.jdField_a_of_type_Axro = ((axro)axov.a().c(8));
      }
      if (this.jdField_a_of_type_Axro.b(paramMusicItemInfo))
      {
        if ((this.eCJ == 0) && (!paramBoolean)) {
          this.jdField_a_of_type_Axro.a(paramMusicItemInfo, this.eCJ);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("MusicProviderView", 2, "startMusic checkMusicCanPlay mCaptureScene" + this.eCJ);
          return;
          this.jdField_a_of_type_Axro.a(paramMusicItemInfo);
          if (this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a != null)
          {
            paramMusicItemInfo = this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a;
            if (paramBoolean) {
              break label150;
            }
          }
        }
        for (paramBoolean = true;; paramBoolean = false)
        {
          paramMusicItemInfo.uZ(paramBoolean);
          break label77;
          break;
        }
      }
      this.e = paramMusicItemInfo;
      this.jdField_a_of_type_Axro.a(paramMusicItemInfo, this.jdField_a_of_type_Axrh);
      this.jdField_b_of_type_Auru.removeCallbacksAndMessages(paramMusicItemInfo);
      Message localMessage = Message.obtain(this.jdField_b_of_type_Auru, 6, paramMusicItemInfo);
      this.jdField_b_of_type_Auru.sendMessageDelayed(localMessage, 60000L);
      axxj.a(paramMusicItemInfo).start();
    } while (!QLog.isColorLevel());
    label150:
    QLog.d("MusicProviderView", 2, "startMusic requestDownLoadMusicInfo" + this.eCJ);
  }
  
  public void dKI()
  {
    super.dKI();
    if (QLog.isColorLevel()) {
      QLog.i("MusicProviderView", 2, "onProviderShow isAccountChange=" + this.dwU + " isInit=" + isInit());
    }
    if ((this.dwU) && (isInit())) {
      Xe(false);
    }
    for (;;)
    {
      this.dwU = false;
      return;
      updateUI();
    }
  }
  
  public void dLs()
  {
    super.dLs();
  }
  
  public void ePb()
  {
    if (this.jdField_a_of_type_Axro == null) {
      this.jdField_a_of_type_Axro = ((axro)axov.a().c(8));
    }
    this.jdField_a_of_type_Axro.a(this.jdField_a_of_type_Axrk);
  }
  
  public void ex(Bundle paramBundle)
  {
    super.ex(paramBundle);
    initData(paramBundle);
    ((axpr)axov.a(5)).a(this);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      if ((getContext() instanceof AppActivity))
      {
        if (((AppActivity)getContext()).isResume()) {
          break label264;
        }
        bool = true;
      }
      break;
    }
    for (;;)
    {
      b(this.e, bool);
      updateUI();
      return false;
      if (((getContext() instanceof BaseActivity)) && (!((BaseActivity)getContext()).isResume()))
      {
        bool = true;
        continue;
        updateUI();
        return false;
        Xe(false);
        return false;
        if (paramMessage.obj == null) {
          break;
        }
        k((MusicItemInfo)paramMessage.obj);
        return false;
        QQToast.a(this.mContext, acfp.m(2131708608), 0).show();
        updateUI();
        return false;
        paramMessage = (MusicItemInfo)paramMessage.obj;
        if (!paramMessage.isFileExist())
        {
          if (!paramMessage.isDownloading()) {
            break;
          }
          if (this.jdField_a_of_type_Axro != null) {
            this.jdField_a_of_type_Axro.h(paramMessage);
          }
          if ((this.e != null) && (TextUtils.equals(this.e.mMusicName, paramMessage.mMusicName))) {
            QQToast.a(BaseApplicationImpl.sApplication, acfp.m(2131708609), 0).show();
          }
          updateUI();
          return false;
        }
        axxj.a(paramMessage).ePh();
        return false;
      }
      label264:
      bool = false;
    }
  }
  
  public void l(MusicItemInfo paramMusicItemInfo)
  {
    b(paramMusicItemInfo, false);
  }
  
  public void m(MusicItemInfo paramMusicItemInfo)
  {
    aqju localaqju = aqha.a((Activity)getContext(), 2131700437);
    localaqju.setNegativeButton(2131721058, new axxa(this));
    localaqju.setPositiveButton(2131721079, new axxb(this, paramMusicItemInfo));
    localaqju.show();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = false;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      bool1 = bool2;
      if (paramIntent.getBooleanExtra("story_video_publishing", false)) {
        bool1 = true;
      }
    }
    this.dwW = bool1;
    if (paramInt1 == 1001) {
      if (QLog.isColorLevel()) {
        QLog.d("MusicProviderView", 2, "doOnActivityResult qqMusic resultCode = " + paramInt2 + ", data = " + paramIntent);
      }
    }
    do
    {
      do
      {
        return;
        if ((paramInt1 == 131) && (paramInt2 == -1) && (paramIntent != null))
        {
          if (this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a != null) {
            this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a.O(104, Integer.valueOf(1001));
          }
          l((MusicItemInfo)paramIntent.getParcelableExtra("EXTRA_HUM_RECOGNITION_RESULT"));
        }
      } while ((paramInt2 != 0) || (this.eCJ != 0) || (this.jdField_a_of_type_Axro == null));
      if (this.j == null)
      {
        this.jdField_a_of_type_Axro.aeH(this.eCJ);
        return;
      }
    } while (this.j == null);
    if ((this.dwV) && (!this.dvG))
    {
      this.jdField_a_of_type_Axro.a(this.j, this.eCJ);
      return;
    }
    this.jdField_a_of_type_Axro.a(this.j);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.setIndicateColor(getContext().getResources().getColor(2131166534));
    if (this.mContentView == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)LayoutInflater.from(getContext()).inflate(2131561125, this, false));
      this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter = new MusicProviderPagerAdapter(this.mContext, this);
      this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter.lV(new ArrayList());
      this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter.b(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter);
      addContentView(this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager);
      new axyb(this.mContext).c(this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager);
      Xe(false);
      onShow();
      this.mApp.registObserver(this.jdField_b_of_type_Axrf);
      paramBundle = (QIMMusicConfigManager)axov.a(2);
      paramBundle.a(this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager$a);
      paramBundle.eOo();
      ((axpr)axov.a(5)).a(this);
      if (this.jdField_a_of_type_Axro == null) {
        this.jdField_a_of_type_Axro = ((axro)axov.a().c(8));
      }
      this.jdField_a_of_type_Axro.a(this.jdField_a_of_type_Axrk);
      paramBundle = this.jdField_a_of_type_Axro;
      if (this.eCJ != 0) {
        break label265;
      }
    }
    label265:
    for (int k = awte.eCR;; k = awte.eCS)
    {
      paramBundle.aeJ(k);
      return;
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)this.mContentView);
      break;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mApp != null) {
      this.mApp.unRegistObserver(this.jdField_b_of_type_Axrf);
    }
    ((QIMMusicConfigManager)axov.a(2)).b(this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager$a);
    if ((this.eCJ == 0) && (this.jdField_a_of_type_Axro != null)) {
      this.jdField_a_of_type_Axro.eOq();
    }
    if (this.jdField_a_of_type_Axro != null)
    {
      this.jdField_a_of_type_Axro.b(this.jdField_a_of_type_Axrk);
      this.jdField_a_of_type_Axro = null;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem() >= this.lI.size()) {}
    do
    {
      return;
      localObject = (axqd)this.lI.get(this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem());
    } while (paramInt >= ((axqd)localObject).Fv.size());
    ((QIMMusicConfigManager)axov.a(2)).b = ((axqd)localObject);
    MusicItemInfo localMusicItemInfo = (MusicItemInfo)((axqd)localObject).Fv.get(paramInt);
    Object localObject = null;
    if (this.jdField_a_of_type_Axro != null) {
      localObject = this.jdField_a_of_type_Axro.b();
    }
    if ((dwS) && (localObject != null) && (((MusicItemInfo)localObject).mItemId != localMusicItemInfo.mItemId) && (((MusicItemInfo)localObject).mType == 5))
    {
      d(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    ((axtq)axov.a(14)).hk(String.valueOf(localMusicItemInfo.mItemId), 2);
    if (localMusicItemInfo.mType == 4)
    {
      paramAdapterView = (Activity)getContext();
      paramView = new Intent(paramAdapterView, QQBrowserActivity.class);
      paramInt = lU(this.busType);
      paramView.putExtra("url", String.format("https://ti.qq.com/music/index.html?_wv=5&_bid=2831&device_id=%s&client_ip=%s&bustype=%s", new Object[] { aqgz.getIMEI(), "", Integer.valueOf(paramInt) }));
      if (QLog.isColorLevel()) {
        QLog.d("MusicProviderView", 1, new Object[] { "music busType:", Integer.valueOf(paramInt) });
      }
      if (rma.a().tG() == 22) {
        LpReportInfo_pf00064.allReport(680, 3, 3);
      }
      paramView.putExtra("finish_animation_up_down", true);
      paramAdapterView.startActivityForResult(paramView, 1001);
      paramAdapterView.overridePendingTransition(2130771991, 0);
      return;
    }
    if (localMusicItemInfo.mType == 6)
    {
      paramAdapterView = (Activity)getContext();
      paramAdapterView.startActivityForResult(new Intent(paramAdapterView, HummingActivity.class), 131);
      return;
    }
    if (localMusicItemInfo.mType == 8) {
      ePa();
    }
    for (;;)
    {
      paramAdapterView = null;
      if (this.jdField_a_of_type_Axro != null) {
        paramAdapterView = this.jdField_a_of_type_Axro.c();
      }
      if ((localMusicItemInfo.mType != 5) || ((!localMusicItemInfo.equals(paramAdapterView)) && (localMusicItemInfo.isFileExist()))) {
        break;
      }
      k(localMusicItemInfo);
      return;
      if (localMusicItemInfo.isWsBanner())
      {
        rpw.a(this.mContext, localMusicItemInfo);
        return;
      }
      if (localMusicItemInfo.mType == 3)
      {
        if (rma.a().tG() == 22) {
          LpReportInfo_pf00064.allReport(680, 3, 2);
        }
      }
      else if ((localMusicItemInfo.mType == 1) && (rma.a().tG() == 22)) {
        LpReportInfo_pf00064.allReport(680, 3, 4);
      }
    }
    paramView.setSelected(true);
    if ((localMusicItemInfo.mType == 2) && (this.bjK == 5) && (this.i != null)) {}
    for (this.e = this.i;; this.e = localMusicItemInfo)
    {
      l(this.e);
      updateUI();
      ((axpr)axov.a(5)).a(this.eCJ, (Activity)this.mContext);
      ePc();
      return;
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.TX(paramInt);
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, "music tab onResume");
    }
    ((axpr)axov.a(5)).a(this);
    Object localObject;
    if (this.jdField_a_of_type_Axro != null)
    {
      this.jdField_a_of_type_Axro.a(this.jdField_a_of_type_Axrk);
      localObject = this.jdField_a_of_type_Axro;
      if (this.eCJ != 0) {
        break label154;
      }
    }
    label154:
    for (int k = awte.eCR;; k = awte.eCS)
    {
      ((axro)localObject).aeJ(k);
      if ((this.eCJ == 0) && (this.jdField_a_of_type_Axro != null) && (this.dwV) && (!this.dwW))
      {
        localObject = this.jdField_a_of_type_Axro.b();
        if ((localObject != null) && (((MusicItemInfo)localObject).mRecognitionOffset == -1.0F) && (!this.dvG)) {
          this.jdField_a_of_type_Axro.resumeMusic();
        }
      }
      if ((this.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager != null)) {
        Xe(true);
      }
      return;
    }
  }
  
  public void onShow()
  {
    if (this.eIu != -1)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(this.eIu);
      this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.TX(this.eIu);
    }
  }
  
  public void onStop()
  {
    if (axov.a().oq(5)) {
      ((axpr)axov.a().c(5)).b(this);
    }
    StringBuilder localStringBuilder;
    if ((this.eCJ == 0) && (this.jdField_a_of_type_Axro != null))
    {
      this.j = this.jdField_a_of_type_Axro.b();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("onStop  mSaveMusicInfo=");
        if (this.j != null) {
          break label107;
        }
      }
    }
    label107:
    for (Object localObject = this.j;; localObject = this.j.mMusicName)
    {
      QLog.d("MusicProviderView", 2, localObject);
      this.jdField_a_of_type_Axro.aeI(this.eCJ);
      return;
    }
  }
  
  public void setChangeMusicEnabled(boolean paramBoolean)
  {
    this.dwV = paramBoolean;
  }
  
  public void setIsGuideMode(boolean paramBoolean)
  {
    this.dvG = paramBoolean;
  }
  
  public void setPreSelectTagIndex(int paramInt)
  {
    this.eIu = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.MusicProviderView
 * JD-Core Version:    0.7.0.1
 */