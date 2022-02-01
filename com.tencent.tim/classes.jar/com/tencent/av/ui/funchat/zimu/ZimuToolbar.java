package com.tencent.av.ui.funchat.zimu;

import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase.a;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.BaseToolbar;
import com.tencent.av.ui.BaseToolbar.a;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.QavListItemBase.b;
import com.tencent.av.ui.QavListItemBase.c;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import igd;
import iiv;
import ijg;
import ijh;
import ikt;
import ilf;
import ilg;
import ilg.a;
import imm;
import iwu;
import iya.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import jcc;
import jcc.a;
import jcc.b;

public class ZimuToolbar
  extends BaseToolbar
  implements EffectConfigBase.a<ZimuItem>, jcc.b
{
  private static final String TAG = "ZimuToolbar";
  private static final int ZIMU_CPU_CORE_THRESHOLD = 8;
  private static final int ZIMU_CPU_FREQ_THRESHOLD = 1800000;
  private boolean mARZimuEnable;
  private b mAdapter;
  private a mItemEvent;
  private HorizontalListView mListView;
  private ikt mSupportManager;
  BaseToolbar.a mUIInfo = null;
  private ilg mZimuManager;
  
  public ZimuToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  private void cancleZimu(long paramLong, String paramString)
  {
    QLog.w("ZimuToolbar", 1, "cancleZimu, 取消字幕选择, seq[" + paramLong + "], isTranslation[" + this.mZimuManager.tQ() + "]");
    this.mZimuManager.p("onSelectZimuItem", paramLong);
    new iya.f(paramLong, "onSelectZimuItem", 3, paramString).n(this.mApp);
    ijh.a(this.mApp, "onSelectZimuItem", paramLong, "EMPTY_ITEM", false);
  }
  
  private boolean checkDimmStatus(String paramString)
  {
    igd.aJ("ZimuToolbar", "checkDimmStatus id = " + paramString);
    int i = this.mSupportManager.k(0, "735");
    int j = this.mSupportManager.k(0, "750");
    switch (i)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      paramString = (AVActivity)this.mActivity.get();
      if ((i != 0) && (paramString != null)) {
        iwu.b(this.mApp, 1010, i);
      }
      return false;
      if (j == 1) {
        break;
      }
      i = 2131697666;
      continue;
      i = 2131697665;
    }
  }
  
  private boolean checkNeedUpdateList()
  {
    boolean bool = this.mARZimuEnable;
    this.mARZimuEnable = ilf.tO();
    return (!bool) || (!this.mARZimuEnable);
  }
  
  public static boolean isShow(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface != null) {
      return ilg.isShow(paramVideoAppInterface);
    }
    return false;
  }
  
  public static boolean isSupport()
  {
    int i = imm.getNumCores();
    if (i >= 8) {}
    long l;
    do
    {
      return true;
      if (i < 4) {
        break;
      }
      l = imm.getMaxCpuFreq();
    } while ((l != 0L) && (l >= 1800000L));
    return false;
  }
  
  private void onSelectZimuItem(long paramLong, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (checkDimmStatus(paramString))) {
      return;
    }
    if ("0".equalsIgnoreCase(paramString))
    {
      cancleZimu(paramLong, paramString);
      return;
    }
    selectZimu(paramLong, paramString);
  }
  
  private void selectZimu(long paramLong, String paramString)
  {
    ZimuItem localZimuItem = (ZimuItem)this.mZimuManager.a();
    if (localZimuItem != null) {}
    for (String str = localZimuItem.getId();; str = null)
    {
      int i;
      if (!TextUtils.equals(str, paramString))
      {
        i = 1;
        if (i == 0) {
          break label241;
        }
        bool = ((ijg)this.mApp.getBusinessHandler(1)).tr();
        QLog.w("ZimuToolbar", 1, "selectZimu, 选择新字幕, id[" + str + "->" + paramString + "], isSuccessCreateTranslation[" + bool + "], seq[" + paramLong + "], isTranslation[" + this.mZimuManager.tQ() + "], ZimuItem[" + localZimuItem + "]");
        new iya.f(paramLong, "onSelectZimuItem", 1, paramString).n(this.mApp);
        if (!bool) {
          break label211;
        }
        ijh.a(this.mApp, "onSelectZimuItem", paramLong, paramString, true);
        this.mZimuManager.q("onSelectZimuItem_" + paramString, paramLong);
      }
      label211:
      label241:
      while (!QLog.isDevelopLevel())
      {
        boolean bool;
        return;
        i = 0;
        break;
        this.mZimuManager.a("onSelectZimuItem_" + paramString, true, paramLong, null);
        return;
      }
      QLog.w("ZimuToolbar", 1, "selectZimu, 字幕item无变更, same, id[" + paramString + "]");
      return;
    }
  }
  
  public static void sendSupportionToPeer(VideoController paramVideoController)
  {
    if (paramVideoController != null) {
      if (!isSupport()) {
        break label23;
      }
    }
    label23:
    for (String str = "SUPPORT_TRUE";; str = "SUPPORT_FALSE")
    {
      paramVideoController.d(7, str);
      return;
    }
  }
  
  ArrayList<QavListItemBase.c> convertItemInfo(List<ZimuItem> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (ZimuItem)localIterator.next();
        Object localObject;
        if ((paramList == null) || (TextUtils.equals(paramList.getId(), "liveshow")))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder().append("convertItemInfo, invalidate item, id[");
            if (paramList == null) {}
            for (paramList = "null";; paramList = paramList.getId())
            {
              QLog.i("ZimuToolbar", 2, paramList + "]");
              break;
            }
          }
        }
        else
        {
          localObject = new QavListItemBase.c();
          ((QavListItemBase.c)localObject).id = paramList.getId();
          ((QavListItemBase.c)localObject).iconurl = paramList.getIconurl();
          ((QavListItemBase.c)localObject).usable = paramList.isUsable();
          ((QavListItemBase.c)localObject).name = paramList.getId();
          ((QavListItemBase.c)localObject).desc = paramList.getDesc();
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public BaseToolbar.a getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new BaseToolbar.a();
      this.mUIInfo.avw = 6;
      this.mUIInfo.avy = 2131559978;
      this.mUIInfo.avx = 2130843142;
      this.mUIInfo.QZ = this.mApp.getApp().getString(2131698145);
    }
    return this.mUIInfo;
  }
  
  public String getUnableInfo()
  {
    if (this.mActivity.get() != null) {
      return ((AVActivity)this.mActivity.get()).getResources().getString(2131697656);
    }
    return "";
  }
  
  ArrayList<QavListItemBase.c> insertEmptyItem(ArrayList<QavListItemBase.c> paramArrayList)
  {
    QavListItemBase.c localc = new QavListItemBase.c();
    localc.id = "-1";
    paramArrayList.add(0, localc);
    localc = new QavListItemBase.c();
    localc.id = "0";
    localc.iconurl = String.valueOf(2130843045);
    localc.desc = acfp.m(2131716997);
    paramArrayList.add(1, localc);
    return paramArrayList;
  }
  
  public boolean isCreated()
  {
    return super.isCreated();
  }
  
  public boolean isEffectBtnEnable()
  {
    return isSupport();
  }
  
  protected void notifyEvent(Integer paramInteger, Object paramObject)
  {
    igd.aJ("ZimuToolbar", "notifyEvent :" + paramInteger + "|" + paramObject);
    this.mApp.l(new Object[] { paramInteger, paramObject });
  }
  
  public void onCreate(long paramLong, AVActivity paramAVActivity)
  {
    this.mSupportManager = ((ikt)this.mApp.a(5));
    this.mListView = ((HorizontalListView)this.toolbarView.findViewById(2131368682));
    this.mListView.setStayDisplayOffsetZero(true);
    this.mZimuManager = ((ilg)this.mApp.a(0));
    ArrayList localArrayList2 = convertItemInfo(this.mZimuManager.y(null));
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2.size() > 0) {
      localArrayList1 = insertEmptyItem(localArrayList2);
    }
    this.mAdapter = new b(this.mApp, paramAVActivity, localArrayList1, this.mListView, this);
    this.mItemEvent = new a();
    this.mAdapter.a(this.mItemEvent);
    this.mAdapter.a(this);
    this.mAdapter.jV(true);
    this.mListView.setAdapter(this.mAdapter);
  }
  
  public void onDestroy(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    this.mZimuManager.b(paramLong, this);
    this.mApp.kI(0);
    this.mListView = null;
    this.mAdapter = null;
  }
  
  public void onDownloadFinish(long paramLong, ZimuItem paramZimuItem, boolean paramBoolean)
  {
    if (this.mAdapter != null) {
      this.mAdapter.g(paramLong, paramZimuItem.getId(), paramBoolean);
    }
  }
  
  public void onHide(long paramLong)
  {
    this.mZimuManager.b(paramLong, this);
  }
  
  public void onItemSelectedChanged(long paramLong, ZimuItem paramZimuItem)
  {
    if (this.mAdapter == null) {
      return;
    }
    if (paramZimuItem == null) {}
    iiv localiiv;
    for (paramZimuItem = "0";; paramZimuItem = paramZimuItem.getId())
    {
      QLog.w("ZimuToolbar", 1, "onItemSelectedChanged begin, id[" + paramZimuItem + "], seq[" + paramLong + "]");
      this.mAdapter.f("onItemSelectedChanged", paramLong, paramZimuItem);
      localiiv = VideoController.a().b();
      if (!ilf.cu(paramZimuItem)) {
        break;
      }
      localiiv.b.set(4);
      return;
    }
    localiiv.b.clear(4);
  }
  
  public void onProgressUpdate(ZimuItem paramZimuItem, int paramInt)
  {
    if (this.mAdapter != null) {
      this.mAdapter.ao(paramZimuItem.getId(), paramInt);
    }
  }
  
  public void onShow(long paramLong, int paramInt, boolean paramBoolean)
  {
    Object localObject2;
    if (checkNeedUpdateList())
    {
      localObject1 = this.mZimuManager.y(null);
      if (!this.mARZimuEnable)
      {
        localObject2 = new ArrayList();
        Iterator localIterator = ((List)localObject1).iterator();
        while (localIterator.hasNext())
        {
          ZimuItem localZimuItem = (ZimuItem)localIterator.next();
          if (ilf.cu(localZimuItem.getId())) {
            ((List)localObject2).add(localZimuItem);
          }
        }
        ((List)localObject1).removeAll((Collection)localObject2);
      }
      localObject2 = convertItemInfo((List)localObject1);
      localObject1 = localObject2;
      if (((ArrayList)localObject2).size() > 0) {
        localObject1 = insertEmptyItem((ArrayList)localObject2);
      }
      this.mAdapter.bE((ArrayList)localObject1);
      this.mAdapter.notifyDataSetChanged();
      this.toolbarView.requestLayout();
    }
    Object localObject1 = (ZimuItem)this.mZimuManager.a();
    if (localObject1 == null) {}
    for (localObject1 = "0";; localObject1 = ((ZimuItem)localObject1).getId())
    {
      localObject2 = localObject1;
      if (ilf.cu((String)localObject1))
      {
        localObject2 = localObject1;
        if (!this.mARZimuEnable) {
          localObject2 = "0";
        }
      }
      this.mAdapter.f("onShow", paramLong, (String)localObject2);
      if (paramInt != getUIInfo().avw) {
        ilg.a.reportClickEvent("0X80085CA", "");
      }
      this.mZimuManager.a(paramLong, this);
      if (!((String)localObject2).equalsIgnoreCase("0")) {
        this.mZimuManager.a("onShow_" + (String)localObject2, false, paramLong, null);
      }
      return;
    }
  }
  
  public void startDownloadTemplate(AppInterface paramAppInterface, long paramLong, QavListItemBase.c paramc, QavListItemBase.b paramb)
  {
    paramAppInterface = (ZimuItem)this.mZimuManager.a(paramc.id);
    if (paramAppInterface != null)
    {
      this.mZimuManager.a(paramLong, paramAppInterface);
      return;
    }
    QLog.w("ZimuToolbar", 1, "startDownloadTemplate, item为空, seq[" + paramLong + "]");
    paramb.g(paramLong, paramc.id, false);
  }
  
  class a
    implements jcc.a
  {
    a() {}
    
    public void a(long paramLong, QavListItemBase.c paramc)
    {
      EffectSettingUi.a(ZimuToolbar.this.mApp, paramLong);
      QLog.w("ZimuToolbar", 1, "onEffectClick, 自己点击了字幕, id[" + paramc.id + "], seq[" + paramLong + "]");
      ZimuToolbar.this.onSelectZimuItem(paramLong, paramc.id);
      if ((!TextUtils.isEmpty(paramc.id)) && (!"0".equalsIgnoreCase(paramc.id)))
      {
        ilg.a.reportClickEvent("0X80085CD", paramc.id);
        if (ilf.cu(paramc.id))
        {
          paramc = ZimuToolbar.this.mApp.b().b().peerUin;
          String str = ZimuToolbar.this.mApp.getCurrentAccountUin();
          ilg.a.B("0X8009191", str, paramc);
          ilg.a.B("0X8009192", str, paramc);
        }
      }
    }
    
    public void dk(long paramLong)
    {
      EffectSettingUi.a(ZimuToolbar.this.mApp, paramLong);
    }
  }
  
  static final class b
    extends jcc
  {
    WeakReference<ZimuToolbar> bL;
    
    public b(AppInterface paramAppInterface, Context paramContext, ArrayList<QavListItemBase.c> paramArrayList, HorizontalListView paramHorizontalListView, ZimuToolbar paramZimuToolbar)
    {
      super(paramContext, paramArrayList, paramHorizontalListView);
      this.bL = new WeakReference(paramZimuToolbar);
    }
    
    public void f(String paramString1, long paramLong, String paramString2)
    {
      boolean bool1 = false;
      int j;
      int i;
      if (!TextUtils.isEmpty(paramString2))
      {
        j = getCount();
        i = 1;
        if (i < j)
        {
          QavListItemBase.c localc = a(i);
          if ((localc != null) && (paramString2.equals(localc.id))) {
            bool1 = true;
          }
        }
      }
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w("QAVPtvTemplateAdapter", 1, "setSelectedItem, id[" + paramString2 + "], find[" + bool1 + "], seq[" + paramLong + "], from[" + paramString1 + "], mCurSelectedPosition[" + this.awQ + "]");
        }
        j = this.awQ;
        boolean bool2 = cz(i);
        if (bool2) {
          K(paramLong, this.awQ);
        }
        QLog.w("QAVPtvTemplateAdapter", 1, "setSelectedItem end, from[" + paramString1 + "], seq[" + paramLong + "], id[" + paramString2 + "], find[" + bool1 + "], index[" + i + "], Pos[" + j + "->" + this.awQ + "], selectResult[" + bool2 + "]");
        return;
        i += 1;
        break;
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuToolbar
 * JD-Core Version:    0.7.0.1
 */