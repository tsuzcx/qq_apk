package com.tencent.mobileqq.emoticonview;

import acbn;
import acfp;
import afgw;
import afkr;
import aflk;
import afmf;
import afmh;
import afmk;
import afmn;
import afmt;
import afmu;
import afmv;
import afmw;
import afna;
import afnh;
import afnn;
import afno;
import afnp;
import afnt;
import afnt.a;
import afnu;
import afoo;
import afoq;
import afos;
import afqm;
import ahyj;
import ajdg;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Handler;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import anot;
import aqmq;
import aqmr;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.model.QueryTask;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class EmoticonPanelController
  implements ViewPager.OnPageChangeListener, EmotionPanelListView.a
{
  public static boolean bZh = true;
  static boolean bZl = true;
  public static int cSe = -1;
  public static int cSf = 3;
  View BP;
  private afmh jdField_a_of_type_Afmh;
  private afmk jdField_a_of_type_Afmk;
  private afmn jdField_a_of_type_Afmn;
  private afmw jdField_a_of_type_Afmw;
  private afna jdField_a_of_type_Afna;
  private afnh jdField_a_of_type_Afnh;
  private afnn jdField_a_of_type_Afnn;
  private afno jdField_a_of_type_Afno;
  public afnp a;
  public afnt a;
  private afqm jdField_a_of_type_Afqm;
  public EmoticonPanelViewPager a;
  public EmotionPanelViewPagerAdapter a;
  public HorizontalListViewEx a;
  boolean ajo = false;
  public QQAppInterface app;
  public a b;
  public boolean bYX = true;
  public boolean bZi;
  public boolean bZj = true;
  boolean bZk;
  private boolean bZm;
  public boolean bZn;
  public boolean bZo = false;
  public boolean bZp;
  public int businessType = 0;
  public boolean bwe;
  public int cSd = 0;
  int cSg;
  public final Context context;
  float density;
  public volatile boolean detached = false;
  public ahyj e = new ahyj("emoticon_panel", "com.tencent.mobileqq:tool");
  public afmf f;
  private EmoticonMainPanel f;
  RelativeLayout hA;
  private int[] kY;
  public BaseChatPie mBaseChatPie;
  int mOrientation;
  public int sessionType = 0;
  public ImageView yP;
  List<EmoticonPackage> zY = new ArrayList();
  public List<afoo> zZ;
  
  protected EmoticonPanelController(Context paramContext, EmoticonMainPanel paramEmoticonMainPanel)
  {
    this.jdField_f_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = paramEmoticonMainPanel;
    this.context = paramContext;
    this.b = new a(paramEmoticonMainPanel);
    this.mOrientation = paramContext.getResources().getConfiguration().orientation;
    this.density = paramContext.getResources().getDisplayMetrics().density;
    this.bZo = false;
    this.jdField_a_of_type_Afmh = new afmh(this);
    this.jdField_a_of_type_Afmw = ((afmw)a(1));
    this.jdField_a_of_type_Afna = ((afna)a(2));
    this.jdField_a_of_type_Afmn = ((afmn)a(3));
    this.jdField_a_of_type_Afno = ((afno)a(4));
    this.jdField_a_of_type_Afnh = ((afnh)a(5));
    this.jdField_a_of_type_Afnn = ((afnn)a(6));
    this.jdField_a_of_type_Afnp = ((afnp)a(8));
  }
  
  private void aH(long paramLong, int paramInt)
  {
    this.BP.setVisibility(0);
    Object localObject = this.zZ;
    int i;
    if ((localObject != null) && (paramInt >= 0))
    {
      i = paramInt;
      if (paramInt < ((List)localObject).size()) {}
    }
    else
    {
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "switchTabMode selectIndex = " + i);
    }
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("clubContentVersion", 0);
    if (localSharedPreferences.getBoolean("force_to_recommend_panel_sp", false)) {
      if ((localObject == null) || ((((List)localObject).size() > cSf) && (((afoo)((List)localObject).get(cSf)).type == 8)))
      {
        cSe = cSf;
        i = cSf;
        localSharedPreferences.edit().putBoolean("force_to_recommend_panel_sp", false).apply();
        label169:
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelController", 2, "switchTabMode after recommend calculate, selectIndex = " + i);
        }
        if (!this.jdField_f_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.bZe) {
          MJ(i);
        }
        if ((localObject != null) && (((List)localObject).size() != 0)) {
          break label317;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager.setAdapter(null);
      }
    }
    for (;;)
    {
      aqmq.track("AIO_EmoticonPanel_EnterSecond", null);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelController", 2, "[Performance] switchTabMode to , duration:" + (System.currentTimeMillis() - paramLong) + ",mSecondTabInited:" + this.jdField_f_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.bZe);
      }
      return;
      cSe = i;
      break;
      cSe = i;
      break label169;
      label317:
      paramInt = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.getSelectedItemPosition();
      if ((paramInt != i) || (paramInt == 0))
      {
        if (i == cSf) {
          this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("isClickRecommendRedpoint", true).apply();
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setSelection(i);
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.setData((List)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager.getAdapter() != this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter);
      }
      long l = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelController", 2, "[Performance] switchTabMode to , setAdapter duration: " + (System.currentTimeMillis() - l));
      }
      if (i < ((List)localObject).size()) {
        this.jdField_a_of_type_Afnh.a((afoo)((List)localObject).get(i), true);
      }
      MI(i);
      if ((this.bZk) && (i == 0))
      {
        localObject = (afoo)((List)localObject).get(i);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.e((afoo)localObject);
      }
    }
  }
  
  private int cO(String paramString)
  {
    return this.jdField_a_of_type_Afnh.a(this.app, paramString, this.zZ);
  }
  
  private void initGestureDetector()
  {
    int j = 0;
    if (this.jdField_a_of_type_Afqm == null)
    {
      if (this.mBaseChatPie != null)
      {
        int i = j;
        if (this.mBaseChatPie.mAIORootView != null)
        {
          GestureDetector localGestureDetector = ((TopGestureLayout)this.mBaseChatPie.mAIORootView).getGestureDetector();
          i = j;
          if ((localGestureDetector instanceof afqm))
          {
            i = 1;
            this.jdField_a_of_type_Afqm = ((afqm)localGestureDetector);
          }
        }
        if (i == 0)
        {
          this.jdField_a_of_type_Afqm = new afqm(this.context, ((TopGestureLayout)this.mBaseChatPie.mAIORootView).getGestureListener(), this.mBaseChatPie);
          ((TopGestureLayout)this.mBaseChatPie.mAIORootView).setGestureDetector(this.jdField_a_of_type_Afqm);
        }
      }
      return;
    }
    this.jdField_a_of_type_Afqm.caj = false;
    this.jdField_a_of_type_Afqm.cak = false;
    this.jdField_a_of_type_Afqm.mBottom = this.mBaseChatPie.mAIORootView.getBottom();
  }
  
  public void HX(boolean paramBoolean)
  {
    if (this.jdField_f_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.bZe) {}
    while (this.jdField_a_of_type_Afmk == null) {
      return;
    }
    this.zZ = this.jdField_a_of_type_Afnp.be(this.jdField_a_of_type_Afmk.c(paramBoolean, this.b.bYY));
  }
  
  public void Ia(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "initEmoticonView 1");
    }
    this.jdField_a_of_type_Afnp.daS();
    cm(cSe, paramString);
    this.jdField_a_of_type_Afmw.daA();
  }
  
  public void MC(int paramInt)
  {
    paramInt = this.jdField_a_of_type_Afnp.hq(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "switchTabMode selectIndex = " + paramInt);
    }
    if (this.app == null) {
      return;
    }
    long l = System.currentTimeMillis();
    aqmq.track(null, "AIO_EmoticonPanel_EnterSecond");
    if (!this.jdField_f_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.bZe)
    {
      this.jdField_a_of_type_Afnh.a(this.bYX, new afmt(this, paramInt, l));
      return;
    }
    aH(l, paramInt);
  }
  
  public void MD(int paramInt)
  {
    cSe = hp(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "initEmoticonView panelType: " + paramInt + " selectIndex: " + cSe);
    }
    this.jdField_a_of_type_Afnp.daS();
    cm(cSe, null);
    this.bZo = true;
    this.jdField_a_of_type_Afmw.daA();
  }
  
  public void MI(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "showPanelByTabIndex tabIndex = " + paramInt);
    }
    afoo localafoo = null;
    List localList = this.zZ;
    if (paramInt < localList.size()) {
      localafoo = (afoo)localList.get(paramInt);
    }
    if (localafoo != null)
    {
      this.jdField_a_of_type_Afnn.b(localafoo);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager.setCurrentItem(paramInt, false);
      this.jdField_a_of_type_Afmn.a(localafoo);
    }
  }
  
  public void MJ(int paramInt)
  {
    if (this.jdField_f_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.bZe) {}
    long l;
    List localList;
    do
    {
      return;
      l = System.currentTimeMillis();
      localList = this.zZ;
    } while ((localList == null) || (localList.size() == 0));
    if (paramInt == cSf) {
      this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("isClickRecommendRedpoint", true).apply();
    }
    Object localObject1 = "";
    int j = localList.size();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    label101:
    Object localObject2;
    afnt.a locala;
    if (i < j)
    {
      localObject2 = (afoo)localList.get(i);
      locala = new afnt.a();
      locala.type = ((afoo)localObject2).type;
      if (((afoo)localObject2).type == 8) {
        localObject1 = acfp.m(2131705811);
      }
    }
    for (;;)
    {
      locala.description = ((String)localObject1);
      localArrayList.add(locala);
      i += 1;
      break label101;
      if (((afoo)localObject2).type == 9)
      {
        localObject1 = acfp.m(2131705813);
      }
      else if (((afoo)localObject2).type == 4)
      {
        localObject1 = acfp.m(2131705835);
      }
      else if (((afoo)localObject2).type == 7)
      {
        localObject1 = acfp.m(2131705834);
      }
      else if ((((afoo)localObject2).type == 6) || (((afoo)localObject2).type == 10))
      {
        if (((afoo)localObject2).d != null)
        {
          EmoticonPackage localEmoticonPackage = ((afoo)localObject2).d;
          localObject2 = localEmoticonPackage.name + acfp.m(2131705854);
          localObject1 = localObject2;
          if (localEmoticonPackage.status != 2) {
            localObject1 = (String)localObject2 + acfp.m(2131705856);
          }
          locala.epId = localEmoticonPackage.epId;
          locala.subType = localEmoticonPackage.subType;
          if (localEmoticonPackage.status == 2) {}
          for (boolean bool = true;; bool = false)
          {
            locala.completed = bool;
            break;
          }
        }
      }
      else if (((afoo)localObject2).type == 11)
      {
        localObject1 = acfp.m(2131705799);
      }
      else if (((afoo)localObject2).type == 13)
      {
        localObject1 = this.context.getResources().getString(2131693109);
      }
      else if (((afoo)localObject2).type == 14)
      {
        localObject1 = this.context.getResources().getString(2131693117);
      }
      else if (((afoo)localObject2).type == 12)
      {
        localObject1 = this.context.getResources().getString(2131690141);
        continue;
        if (localArrayList.size() > 0)
        {
          if (this.bZj) {
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.resetCurrentX(paramInt);
          }
          this.bZj = true;
          this.jdField_a_of_type_Afnt.bJ(localArrayList);
        }
        this.jdField_f_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.bZe = true;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("EmoticonPanelController", 2, "[Performance] initSecondTabView duration:" + (System.currentTimeMillis() - l));
        return;
      }
    }
  }
  
  public <T extends aflk> T a(int paramInt)
  {
    return this.jdField_a_of_type_Afmh.a(paramInt);
  }
  
  public boolean ajw()
  {
    return this.bZm;
  }
  
  public boolean ajx()
  {
    return this.jdField_a_of_type_Afmw.ajx();
  }
  
  public boolean ajy()
  {
    return this.jdField_a_of_type_Afmw.ajy();
  }
  
  public EmoticonMainPanel b()
  {
    return this.jdField_f_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  }
  
  public int cN(String paramString)
  {
    return this.jdField_a_of_type_Afnh.a(paramString, this.zZ, bZh);
  }
  
  public void cZu()
  {
    this.jdField_a_of_type_Afmw.cZu();
  }
  
  public void cZv()
  {
    this.jdField_a_of_type_Afmw.cZv();
  }
  
  void cm(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "initEmoticonView 2, selectIndex = " + paramInt + ", defaultEpId = " + paramString);
    }
    int i = this.jdField_a_of_type_Afnp.hq(paramInt);
    initGestureDetector();
    this.jdField_f_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.isHiden = false;
    long l = System.currentTimeMillis();
    Object localObject = (afgw)this.app.getManager(334);
    int j;
    String str;
    if ((localObject != null) && (this.jdField_a_of_type_Afnt != null) && (((afgw)localObject).ajk()) && (i == hp(11)))
    {
      j = 1;
      if (!afnu.ju(this.sessionType))
      {
        this.yP.setVisibility(8);
        this.bYX = false;
      }
      localObject = this.context.getSharedPreferences("mobileQQ", 0);
      str = ((SharedPreferences)localObject).getString("LAST_ADD_EMO_PACKAGE", "");
      if (TextUtils.isEmpty(str)) {
        break label317;
      }
      this.jdField_f_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.bZe = false;
      this.bZi = false;
      ((SharedPreferences)localObject).edit().remove("LAST_ADD_EMO_PACKAGE").apply();
      ((SharedPreferences)localObject).edit().remove("LAST_ADD_EMO_PACKAGE_MAGIC").apply();
      paramInt = 0;
      label231:
      if (paramString == null) {
        break label359;
      }
      localObject = paramString;
      label238:
      if ((j == 0) || (paramString != null)) {
        break label377;
      }
      paramString = null;
    }
    for (;;)
    {
      new QueryTask(new afmu(this, i), new afmv(this, l)).bq(paramString);
      VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "ep_mall", "show_mine", "", 0, 0, 0, "", "", "");
      return;
      j = 0;
      break;
      label317:
      if ((this.bYX) && (this.bZi))
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelController", 2, "new pkg downloaded in panel, refresh");
        }
        this.jdField_f_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.bZe = false;
      }
      paramInt = i;
      break label231;
      label359:
      localObject = str;
      if (!TextUtils.isEmpty(str)) {
        break label238;
      }
      localObject = null;
      break label238;
      label377:
      paramString = (String)localObject;
      i = paramInt;
    }
  }
  
  public void dak()
  {
    this.jdField_a_of_type_Afna.dak();
  }
  
  public void dal()
  {
    this.jdField_a_of_type_Afno.dal();
  }
  
  public void dam()
  {
    this.jdField_a_of_type_Afno.dam();
  }
  
  public void dan()
  {
    if (this.jdField_f_of_type_Afmf != null) {
      this.jdField_f_of_type_Afmf.delete();
    }
    afoo localafoo;
    if ((this.zZ != null) && (cSe >= 0) && (cSe < this.zZ.size()))
    {
      localafoo = (afoo)this.zZ.get(cSe);
      if (localafoo.type != 7) {
        break label106;
      }
      anot.a(this.app, "dc00898", "", "", "0X800A845", "0X800A845", 1, 0, "", "", "", "");
    }
    label106:
    while (localafoo.type != 10) {
      return;
    }
    anot.a(this.app, "dc00898", "", "", "0X800A845", "0X800A845", 2, 0, "", "", "", "");
  }
  
  public void dao()
  {
    this.jdField_a_of_type_Afnh.dao();
  }
  
  public void dap()
  {
    this.jdField_a_of_type_Afnh.dap();
  }
  
  public void daq()
  {
    if (this.jdField_f_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel == null) {}
    View localView;
    do
    {
      return;
      localView = this.jdField_f_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.findViewById(2131379177);
    } while (localView == null);
    localView.setVisibility(8);
  }
  
  public void daw()
  {
    int i = this.jdField_f_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getMeasuredWidth();
    DisplayMetrics localDisplayMetrics = this.context.getResources().getDisplayMetrics();
    EmotionPanelViewPagerAdapter localEmotionPanelViewPagerAdapter;
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null)
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.cSL;
      if (i != j)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelController", 2, "onMeasure: oldWidth=" + j + " newWidth=" + i);
        }
        afos.a().destory();
        afos.widthPixels = i;
        localEmotionPanelViewPagerAdapter = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter;
        if (i / localDisplayMetrics.widthPixels >= 0.66F) {
          break label146;
        }
      }
    }
    label146:
    for (boolean bool = true;; bool = false)
    {
      localEmotionPanelViewPagerAdapter.bZX = bool;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.cSL = i;
      ThreadManagerV2.getUIHandlerV2().post(new EmoticonPanelController.8(this));
      return;
    }
  }
  
  public void dax()
  {
    if (this.jdField_f_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel == null) {}
    View localView;
    do
    {
      return;
      localView = this.jdField_f_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.findViewById(2131379177);
    } while (localView == null);
    localView.setVisibility(0);
  }
  
  void dispatchDraw(Canvas paramCanvas)
  {
    if (EmoticonMainPanel.XA == -1L) {}
    long l;
    do
    {
      return;
      l = System.currentTimeMillis() - EmoticonMainPanel.XA;
    } while (l <= 0L);
    paramCanvas = new HashMap(2);
    if (bZl)
    {
      i = 1;
      paramCanvas.put("panelMode", "2");
      paramCanvas.put("duration", String.valueOf(l));
      ThreadManager.post(new EmoticonPanelController.5(this, i, l, paramCanvas), 5, null, true);
      aqmq.track("AIO_EmoticonPanel_OpenDuration", null);
      if (QLog.isColorLevel())
      {
        QLog.d("EmoticonPanelController", 2, "[Performance] dispatchDraw over, duration=" + l + ",openCondition=" + i + ",panelMode=" + "2");
        QLog.d("StressTesting.Emoticon.PanelCreate", 2, "open EmoticonPanel duration=" + l);
      }
      EmoticonMainPanel.XA = -1L;
      this.bZk = false;
      bZl = false;
      return;
    }
    if (this.bZk) {}
    for (int i = 2;; i = 3) {
      break;
    }
  }
  
  public void hO(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Afno.hO(paramInt1, paramInt2);
  }
  
  public int hp(int paramInt)
  {
    if ((this.zZ == null) || (this.zZ.isEmpty())) {}
    for (;;)
    {
      return 0;
      Iterator localIterator = this.zZ.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        afoo localafoo = (afoo)localIterator.next();
        if ((localafoo != null) && (localafoo.type == paramInt)) {
          return i;
        }
        i += 1;
      }
    }
  }
  
  public void init()
  {
    this.jdField_a_of_type_Afmh.CS(1);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager = ((EmoticonPanelViewPager)this.jdField_f_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.findViewById(2131381896));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter = new EmotionPanelViewPagerAdapter(this.app, this.context, this.jdField_f_of_type_Afmf, this.mBaseChatPie, this.businessType, this.bZn);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.bZY = this.b.bZq;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.la = this.kY;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.bZr = ajw();
    this.hA = ((RelativeLayout)this.jdField_f_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.findViewById(2131366380));
    this.BP = this.jdField_f_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.findViewById(2131365353);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx = ((HorizontalListViewEx)this.jdField_f_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.findViewById(2131379163));
    this.jdField_f_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setOnItemClickListener(this.jdField_a_of_type_Afnh.i);
    this.jdField_a_of_type_Afnt = new afnt(this.app, this.context, this.businessType);
    this.jdField_a_of_type_Afnt.Ic(ajx());
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setTabAnimateEnable(ajx());
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setAdapter(this.jdField_a_of_type_Afnt);
    this.yP = ((ImageView)this.jdField_f_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.findViewById(2131366346));
    this.hA.setBackgroundColor(this.context.getResources().getColor(2131165785));
    this.BP.setBackgroundColor(this.context.getResources().getColor(2131165784));
    this.jdField_f_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.findViewById(2131379127).setBackgroundColor(this.context.getResources().getColor(2131165783));
    this.bZk = true;
    if (this.b.bED != -1) {
      MD(this.b.bED);
    }
    for (;;)
    {
      this.jdField_a_of_type_Afmh.CS(2);
      return;
      Ia(this.b.aLB);
    }
  }
  
  void onAttachedToWindow()
  {
    this.jdField_a_of_type_Afmh.CS(9);
  }
  
  public void onDestory()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "OnDestory");
    }
    this.jdField_a_of_type_Afmh.CS(8);
    HorizontalListViewEx.dbq();
    afkr.a().destory();
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.onDestroy();
    }
    Object localObject = this.zZ;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    this.jdField_f_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.bZe = false;
    if (this.app != null)
    {
      localObject = this.app.getApplication().getSharedPreferences("commonUsedSystemEmoji_sp", 0);
      long l = ((SharedPreferences)localObject).getLong("lastRequestTime", 0L);
      if ((System.currentTimeMillis() - l > 43200000L) || (System.currentTimeMillis() - l < 0L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelController", 2, "onDestroy commonused send");
        }
        ThreadManagerV2.excute(new EmoticonPanelController.3(this, (SharedPreferences)localObject), 64, null, true);
      }
      localObject = (ajdg)this.app.getManager(14);
      if (localObject != null) {
        ((ajdg)localObject).dwm();
      }
    }
    this.e.end();
    this.jdField_f_of_type_Afmf = null;
    if ((this.jdField_a_of_type_Afqm != null) && (this.mBaseChatPie != null) && (this.mBaseChatPie.mAIORootView != null))
    {
      localObject = (TopGestureLayout)this.mBaseChatPie.mAIORootView;
      GestureDetector localGestureDetector = ((TopGestureLayout)localObject).getGestureDetector();
      if ((localGestureDetector instanceof afqm))
      {
        ThreadManagerV2.getUIHandlerV2().post(new EmoticonPanelController.4(this, (TopGestureLayout)localObject, localGestureDetector));
        com.tencent.mobileqq.emoticon.EmojiStickerManager.bYA = false;
        this.mBaseChatPie.wj(false);
        this.mBaseChatPie.wj(false);
      }
      ((TopGestureLayout)localObject).restoreGestureDetector();
      this.jdField_a_of_type_Afqm = null;
    }
  }
  
  void onDetachedFromWindow()
  {
    this.detached = true;
    afoq.a().destory();
    afos.a().destory();
    this.jdField_a_of_type_Afmh.CS(10);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    long l = System.currentTimeMillis();
    aqmq.track(null, "AIO_EmoticonPanel_PageScroll");
    Object localObject = this.zZ;
    if (localObject == null) {
      break label22;
    }
    label22:
    while (this.jdField_a_of_type_Afnp.jv(paramInt)) {
      return;
    }
    localObject = (afoo)((List)localObject).get(paramInt);
    int i;
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.e((afoo)localObject);
      if (((afoo)localObject).type != 7) {
        break label336;
      }
      i = 1;
    }
    for (;;)
    {
      label80:
      if (i > 0) {
        anot.a(this.app, "dc00898", "", "", "0x800a572", "0x800a572", 0, 0, i + "", i + "", i + "", "");
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelController", 2, "onPageSelected, position=" + paramInt + "panelInfo = " + localObject);
      }
      this.jdField_a_of_type_Afnn.c((afoo)localObject);
      if (cSe != paramInt)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setSelection(paramInt);
        if (paramInt == cSf) {
          this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("isClickRecommendRedpoint", true).apply();
        }
      }
      for (;;)
      {
        cSe = paramInt;
        this.jdField_a_of_type_Afmh.z(3, paramInt, false);
        aqmq.track("AIO_EmoticonPanel_PageScroll", null);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("EmoticonPanelController", 2, "[Performance] onPageSelected, handle duration=" + (System.currentTimeMillis() - l));
        return;
        label336:
        if ((((afoo)localObject).type == 5) || (((afoo)localObject).type == 4))
        {
          i = 2;
          break label80;
        }
        if (((afoo)localObject).type == 11)
        {
          i = 3;
          break label80;
        }
        if (((afoo)localObject).type == 8)
        {
          i = 4;
          break label80;
        }
        if (((afoo)localObject).type == 9)
        {
          i = 5;
          break label80;
        }
        if ((((afoo)localObject).d == null) || (aqmr.isEmpty(((afoo)localObject).d.epId))) {
          break label535;
        }
        i = 6;
        break label80;
        if ((localObject != null) && (((afoo)localObject).type == 8))
        {
          anot.a(this.app, "CliOper", "", "", "ep_mall", "0X8005813", 0, 0, "", paramInt + "", "", "");
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonPanelController", 2, "view times report. cur page:" + paramInt);
          }
        }
      }
      label535:
      i = -1;
    }
  }
  
  public void onPause()
  {
    if (this.app == null) {
      return;
    }
    this.ajo = false;
    this.jdField_a_of_type_Afmh.CS(7);
  }
  
  public void onResume()
  {
    aqmq.track(null, "AIO_EmoticonPanel_OnResume");
    this.ajo = true;
    if ((this.jdField_f_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getVisibility() == 0) && (this.bwe))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelController", 2, "onResume, Emoticon pkg moved、added or deleted, refresh");
      }
      this.jdField_f_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.bZe = false;
      cSe -= this.cSd;
      if (cSe < 0) {
        cSe = this.jdField_a_of_type_Afnp.Dl();
      }
      cm(cSe, null);
      this.cSd = 0;
      this.bwe = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_Afmh.CS(6);
      aqmq.track("AIO_EmoticonPanel_OnResume", null);
      return;
      if (this.jdField_f_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.isShown())
      {
        if ((afnu.ju(this.sessionType)) && (!TextUtils.isEmpty(this.context.getSharedPreferences("mobileQQ", 0).getString("LAST_ADD_EMO_PACKAGE", ""))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonPanelController", 2, "download in market, initEmoticonView");
          }
          cm(0, null);
        }
        dak();
        this.jdField_a_of_type_Afmn.dau();
      }
    }
  }
  
  public void onShow()
  {
    this.jdField_a_of_type_Afmh.CS(5);
  }
  
  public void preloadWebProcess()
  {
    this.jdField_a_of_type_Afnh.preloadWebProcess();
  }
  
  public void setCallBack(afmf paramafmf)
  {
    this.jdField_f_of_type_Afmf = paramafmf;
    this.b.jdField_f_of_type_Afmf = paramafmf;
  }
  
  public void setCurType(int paramInt)
  {
    this.sessionType = paramInt;
    switch (paramInt)
    {
    case 100000: 
    default: 
      this.businessType = 0;
      return;
    case 99999: 
      this.businessType = 1;
      return;
    case 100001: 
      this.businessType = 2;
      return;
    case 100002: 
      this.businessType = 3;
      return;
    }
    this.businessType = 4;
  }
  
  @Deprecated
  public void setEmoSettingVisibility(int paramInt)
  {
    if (paramInt != 0) {
      this.jdField_a_of_type_Afnp.daT();
    }
    this.jdField_a_of_type_Afnn.setEmoSettingVisibility(paramInt);
  }
  
  public void setFilterSysFaceBeyond255Enable(boolean paramBoolean)
  {
    this.bZm = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.bZr = paramBoolean;
    }
  }
  
  public void setHideAllSettingTabs(boolean paramBoolean)
  {
    this.bZp = paramBoolean;
  }
  
  public void setOnlySysEmotionEnable(boolean paramBoolean)
  {
    this.b.bZq = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.bZY = this.b.bZq;
    }
  }
  
  public void setSysEmotionOrder(int[] paramArrayOfInt)
  {
    this.kY = paramArrayOfInt;
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.la = this.kY;
    }
  }
  
  public void setVisibility(int paramInt)
  {
    long l = System.currentTimeMillis();
    if (paramInt != this.jdField_f_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getVisibility())
    {
      if (paramInt != 0) {
        break label215;
      }
      paramInt = this.context.getResources().getConfiguration().orientation;
      if (!this.bwe) {
        break label199;
      }
      this.jdField_f_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.bZe = false;
      cSe -= this.cSd;
      if (cSe < 0) {
        cSe = this.jdField_a_of_type_Afnp.Dl();
      }
      Ia(null);
      this.cSd = 0;
      this.bwe = false;
    }
    for (;;)
    {
      this.mOrientation = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelController", 2, "[Performance] reopen in aio, duration=" + (System.currentTimeMillis() - l));
      }
      this.jdField_a_of_type_Afno.daQ();
      File localFile = new File(acbn.bmM);
      if (!localFile.exists())
      {
        boolean bool = localFile.mkdirs();
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelController", 2, "root dir not exist. try to make it. success:" + bool);
        }
      }
      return;
      label199:
      this.jdField_f_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.bZe = false;
      Ia(null);
    }
    label215:
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonPanelController.1(this), 1L);
  }
  
  public void yQ(boolean paramBoolean)
  {
    this.jdField_a_of_type_Afmh.z(4, -1, paramBoolean);
  }
  
  public int z(boolean paramBoolean)
  {
    int j = 3;
    if (this.sessionType != -1)
    {
      int i = j;
      switch (Integer.valueOf(ChatActivityUtils.cs(this.sessionType)).intValue())
      {
      case 2: 
      default: 
        i = j;
        if (paramBoolean) {
          i = 4;
        }
      case 1: 
        return i;
      case 0: 
        return 1;
      }
      return 2;
    }
    return 0;
  }
  
  public static class a
  {
    String aLB;
    QQAppInterface app;
    afmk b;
    int bED;
    boolean bYX = true;
    boolean bYY = false;
    public boolean bYZ = false;
    public boolean bZa = false;
    public boolean bZb = false;
    public boolean bZc = false;
    public boolean bZn = false;
    boolean bZq = false;
    boolean bZr = false;
    public boolean bZs = false;
    boolean bZt = false;
    int cSg;
    afmf f;
    EmoticonMainPanel g;
    BaseChatPie mBaseChatPie;
    int sessionType = 0;
    
    public a() {}
    
    public a(EmoticonMainPanel paramEmoticonMainPanel)
    {
      this.g = paramEmoticonMainPanel;
      if (paramEmoticonMainPanel != null)
      {
        paramEmoticonMainPanel = paramEmoticonMainPanel.a();
        if (paramEmoticonMainPanel != null)
        {
          this.f = paramEmoticonMainPanel.f;
          this.bZn = paramEmoticonMainPanel.bZn;
          this.app = paramEmoticonMainPanel.app;
          this.bYX = paramEmoticonMainPanel.bYX;
          this.b = EmoticonPanelController.a(paramEmoticonMainPanel);
          this.mBaseChatPie = paramEmoticonMainPanel.mBaseChatPie;
          this.bZr = EmoticonPanelController.a(paramEmoticonMainPanel);
          this.bZt = paramEmoticonMainPanel.bZp;
        }
      }
    }
    
    public void apply()
    {
      if (this.g == null) {}
      EmoticonPanelController localEmoticonPanelController;
      do
      {
        return;
        localEmoticonPanelController = this.g.a();
      } while (localEmoticonPanelController == null);
      this.bZc = false;
      localEmoticonPanelController.b = this;
      localEmoticonPanelController.f = this.f;
      localEmoticonPanelController.bZn = this.bZn;
      localEmoticonPanelController.app = this.app;
      localEmoticonPanelController.bYX = this.bYX;
      EmoticonPanelController.a(localEmoticonPanelController, this.b);
      localEmoticonPanelController.mBaseChatPie = this.mBaseChatPie;
      EmoticonPanelController.a(localEmoticonPanelController, this.bZr);
      localEmoticonPanelController.bZp = this.bZt;
      localEmoticonPanelController.setCurType(this.sessionType);
    }
    
    public void show()
    {
      if ((this.g == null) || (this.g.a() == null)) {
        return;
      }
      apply();
      this.g.a().init();
    }
  }
  
  public static abstract interface b
  {
    public abstract void day();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelController
 * JD-Core Version:    0.7.0.1
 */