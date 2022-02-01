package com.tencent.av.ui;

import acfp;
import android.content.res.Resources;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import anhs;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase.a;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import igd;
import iiv;
import iju;
import ijv;
import ike;
import ikh;
import ikl;
import iov;
import iow;
import iwu;
import iyz;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import jcc;
import jcc.a;
import jcc.b;
import jcs;

public class EffectToolbar
  extends BaseToolbar
  implements View.OnClickListener, EffectConfigBase.a<PendantItem>, jcc.b
{
  private static final String TAG = "EffectToolbar";
  jcc mAdapter;
  public Button mEarbackBtn = null;
  jcc.a mEffectClickCallback = new iyz(this);
  HorizontalListView mListView;
  protected a mObserver;
  private ikl mPendantManager;
  public Map<String, PendantItem> mPtvTemplateInfoMap = new HashMap();
  ArrayList<QavListItemBase.c> mTemplateList = null;
  BaseToolbar.a mUIInfo = null;
  
  public EffectToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  private ArrayList<QavListItemBase.c> addItem_with_Double_Video_type()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new QavListItemBase.c();
    ((QavListItemBase.c)localObject).id = "-1";
    localArrayList.add(localObject);
    localObject = new QavListItemBase.c();
    ((QavListItemBase.c)localObject).id = "0";
    ((QavListItemBase.c)localObject).iconurl = String.valueOf(2130843045);
    ((QavListItemBase.c)localObject).desc = acfp.m(2131705766);
    localArrayList.add(localObject);
    this.mPtvTemplateInfoMap.clear();
    localObject = this.mPendantManager.y(null);
    boolean bool;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      bool = iju.tw();
      if ((!bool) || (AEFilterSupport.uP())) {
        break label284;
      }
      bool = anhs.a().axd();
    }
    label284:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EffectToolbar", 2, "addItem_with_Double_Video_type, isSupportGesture[" + bool + "], size[" + ((List)localObject).size() + "]");
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PendantItem localPendantItem = (PendantItem)((Iterator)localObject).next();
        if ((localPendantItem.isShow()) && (iju.a(localPendantItem)) && ((!localPendantItem.hasGesture()) || (bool)) && ((!PendantItem.isPanorama(localPendantItem.getKind())) || ((EffectSettingUi.a(this.mApp, false)) && (ike.tA()))))
        {
          localArrayList.add(jcs.a(0, localPendantItem));
          this.mPtvTemplateInfoMap.put(localPendantItem.getId(), localPendantItem);
        }
      }
      return localArrayList;
    }
  }
  
  @Nullable
  private String getCurrentPendantId()
  {
    Object localObject;
    if (this.mPendantManager.Ny != null)
    {
      localObject = this.mPendantManager.Ny;
      this.mPendantManager.Ny = null;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w("EffectToolbar", 1, "getCurrentPendantId, id[" + (String)localObject + "]");
      }
      return localObject;
      localObject = (PendantItem)this.mPendantManager.a();
      if ((localObject == null) || (!((PendantItem)localObject).isShow())) {
        localObject = null;
      } else {
        localObject = ((PendantItem)localObject).getId();
      }
    }
  }
  
  private void handlerObserver(Observable paramObservable, Object paramObject)
  {
    paramObservable = (Object[])paramObject;
    switch (((Integer)paramObservable[0]).intValue())
    {
    case 169: 
    case 170: 
    default: 
      return;
    case 168: 
      paramObject = (FaceItem)paramObservable[1];
      StringBuilder localStringBuilder = new StringBuilder().append("TYPE_NOTIFY_FACE_ITEM_STATE_CHANGE :");
      if (paramObject == null) {}
      for (paramObservable = "null";; paramObservable = paramObject.getId())
      {
        igd.aK("EffectToolbar", paramObservable);
        if (paramObject == null) {
          break;
        }
        setLastItem();
        return;
      }
    }
    setLastItem();
  }
  
  private void postSetCurrentItemById(long paramLong, String paramString)
  {
    notifyEvent(Integer.valueOf(6101), null, Boolean.valueOf(true));
    this.mApp.getHandler().post(new EffectToolbar.2(this, paramString, paramLong));
    boolean bool;
    if (this.mApp.ch(3))
    {
      paramString = (FaceItem)((ijv)this.mApp.a(3)).a();
      if ((paramString != null) && (TextUtils.isEmpty(paramString.getId()))) {
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w("EffectToolbar", 1, "postSetCurrentItemById, isInDoubleScreenPendant[" + bool + "], seq[" + paramLong + "]");
      }
      if (bool) {
        VideoController.a().d(3, "START_0");
      }
      return;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  private void setLastItem()
  {
    Object localObject1;
    if (this.mApp.ch(3))
    {
      localObject1 = (FaceItem)((ijv)this.mApp.a(3)).a();
      if (localObject1 != null) {
        if ((((FaceItem)localObject1).isSameType("pendant")) || (((FaceItem)localObject1).isSameType("creativecop"))) {
          localObject1 = null;
        }
      }
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "0";
      }
      setLastSelectedIndex((String)localObject2, this.mTemplateList, this.mAdapter, this.mListView);
      do
      {
        return;
      } while ((((FaceItem)localObject1).isSameType("face")) || (((FaceItem)localObject1).isSameType("voicesticker")));
      localObject1 = null;
      continue;
      localObject1 = getCurrentPendantId();
      continue;
      localObject1 = getCurrentPendantId();
    }
  }
  
  static int setLastSelectedIndex(String paramString, ArrayList<QavListItemBase.c> paramArrayList, jcc paramjcc, HorizontalListView paramHorizontalListView)
  {
    if ((paramArrayList == null) || (paramjcc == null) || (paramHorizontalListView == null)) {
      return -1;
    }
    int i = 1;
    if (i < paramArrayList.size()) {
      if (!((QavListItemBase.c)paramArrayList.get(i)).id.equals(paramString)) {}
    }
    for (;;)
    {
      setSelectedListViewItemAndShow(paramHorizontalListView, paramjcc, i);
      return i;
      i += 1;
      break;
      i = -1;
    }
  }
  
  private void updateEarbackBtn()
  {
    int i = 2130843159;
    if (this.mApp.b().b().Rm) {
      i = 2130843160;
    }
    this.mEarbackBtn.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
  }
  
  protected BaseToolbar.a getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new BaseToolbar.a();
      this.mUIInfo.avw = 1;
      this.mUIInfo.avy = 2131559980;
      this.mUIInfo.avx = 2130843138;
      this.mUIInfo.QZ = this.mApp.getApp().getString(2131698142);
    }
    return this.mUIInfo;
  }
  
  public String getUnableInfo()
  {
    if (this.mActivity.get() != null) {
      return ((AVActivity)this.mActivity.get()).getResources().getString(2131697655);
    }
    return "";
  }
  
  public boolean isEffectBtnEnable()
  {
    if (!iow.uW()) {
      return false;
    }
    boolean bool = iow.uZ();
    if (QLog.isDevelopLevel()) {
      QLog.d("EffectEnable", 4, String.format("特效按钮可用, bSuc[%s]", new Object[] { Boolean.valueOf(bool) }));
    }
    return bool;
  }
  
  protected void notifyEvent(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    igd.aJ("EffectToolbar", "notifyEvent :" + paramInteger + "|" + paramObject1);
    this.mApp.l(new Object[] { paramInteger, paramObject1, paramObject2 });
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    iiv localiiv = this.mApp.b().b();
    if (!this.mApp.b().b().Rm) {}
    for (boolean bool = true;; bool = false)
    {
      localiiv.Rm = bool;
      if (this.mApp.b().b().YN != 0) {
        this.mApp.b().enableLoopback(this.mApp.b().b().Rm);
      }
      updateEarbackBtn();
      if (!this.mApp.b().b().Rm) {
        iwu.b(this.mApp, 1017);
      }
      EffectSettingUi.a(this.mApp, -1009L);
      break;
    }
  }
  
  protected void onCreate(long paramLong, AVActivity paramAVActivity)
  {
    this.mPendantManager = ((ikl)this.mApp.a(2));
    this.mObserver = new a(this);
    this.mListView = ((HorizontalListView)this.toolbarView.findViewById(2131368682));
    this.mListView.setStayDisplayOffsetZero(true);
    this.mTemplateList = addItem_with_Double_Video_type();
    this.mAdapter = new jcc(this.mApp, paramAVActivity, this.mTemplateList, this.mListView);
    this.mAdapter.jV(true);
    this.mAdapter.a(this.mEffectClickCallback);
    this.mAdapter.a(this);
    this.mListView.setAdapter(this.mAdapter);
    setLastItem();
    this.mEarbackBtn = ((Button)this.toolbarView.findViewById(2131364433));
    this.mEarbackBtn.setOnClickListener(this);
    ikh.anp();
  }
  
  protected void onDestroy(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    this.mPendantManager.b(paramLong, this);
    this.mListView = null;
    this.mAdapter = null;
  }
  
  public void onDownloadFinish(long paramLong, PendantItem paramPendantItem, boolean paramBoolean)
  {
    if (this.mAdapter != null) {
      this.mAdapter.g(paramLong, paramPendantItem.getId(), paramBoolean);
    }
  }
  
  protected void onHide(long paramLong)
  {
    this.mApp.deleteObserver(this.mObserver);
    this.mPendantManager.b(paramLong, this);
  }
  
  public void onItemSelectedChanged(long paramLong, PendantItem paramPendantItem)
  {
    int i = 1;
    QLog.w("EffectToolbar", 1, "onItemSelectedChanged, current[" + paramPendantItem + "], seq[" + paramLong + "]");
    if (paramPendantItem == null)
    {
      paramPendantItem = VideoController.a().a(((AVActivity)this.mActivity.get()).getApplicationContext());
      if (paramPendantItem != null) {
        paramPendantItem.cp(paramLong);
      }
    }
    paramPendantItem = (EffectOperateManager)this.mApp.a(8);
    String str;
    if ((paramPendantItem != null) && (paramPendantItem.tv()))
    {
      str = paramPendantItem.getEffectId();
      setLastSelectedIndex(str, this.mTemplateList, this.mAdapter, this.mListView);
      paramPendantItem.ie(false);
      if (str != null) {}
    }
    else
    {
      return;
    }
    if (i < this.mTemplateList.size()) {
      if (!((QavListItemBase.c)this.mTemplateList.get(i)).id.equals(str)) {}
    }
    for (paramPendantItem = (QavListItemBase.c)this.mTemplateList.get(i);; paramPendantItem = null)
    {
      if ((!str.isEmpty()) && (paramPendantItem != null) && (paramPendantItem.voiceid > 0))
      {
        QLog.i("EffectToolbar", 2, "onItemSelectedChanged voiceid : " + paramPendantItem.voiceid);
        this.mApp.b().b().anp = paramPendantItem.voiceid;
        this.mEarbackBtn.setVisibility(0);
        updateEarbackBtn();
      }
      for (;;)
      {
        this.mApp.b().alV();
        return;
        i += 1;
        break;
        this.mApp.b().b().anp = 0;
        this.mEarbackBtn.setVisibility(4);
      }
    }
  }
  
  public void onProgressUpdate(PendantItem paramPendantItem, int paramInt)
  {
    if (this.mAdapter != null) {
      this.mAdapter.ao(paramPendantItem.getId(), paramInt);
    }
  }
  
  protected void onShow(long paramLong, int paramInt, boolean paramBoolean)
  {
    setLastItem();
    this.mApp.addObserver(this.mObserver);
    this.mPendantManager.a(paramLong, this);
    if (this.mEarbackBtn.isShown()) {
      updateEarbackBtn();
    }
    if (QLog.isColorLevel()) {
      QLog.i("EffectToolbar", 2, String.format("onShow", new Object[0]));
    }
    ikh.anp();
  }
  
  public void startDownloadTemplate(AppInterface paramAppInterface, long paramLong, QavListItemBase.c paramc, QavListItemBase.b paramb)
  {
    paramAppInterface = (PendantItem)this.mPendantManager.a(paramc.id);
    if (paramAppInterface != null)
    {
      this.mPendantManager.a(paramLong, paramAppInterface);
      return;
    }
    QLog.w("EffectToolbar", 1, "startDownloadTemplate, item为空, seq[" + paramLong + "]");
    paramb.g(paramLong, paramc.id, false);
  }
  
  static class a
    implements Observer
  {
    private WeakReference<EffectToolbar> bk;
    
    a(EffectToolbar paramEffectToolbar)
    {
      this.bk = new WeakReference(paramEffectToolbar);
    }
    
    public void update(Observable paramObservable, Object paramObject)
    {
      EffectToolbar localEffectToolbar = (EffectToolbar)this.bk.get();
      if (localEffectToolbar == null) {
        return;
      }
      localEffectToolbar.handlerObserver(paramObservable, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.EffectToolbar
 * JD-Core Version:    0.7.0.1
 */