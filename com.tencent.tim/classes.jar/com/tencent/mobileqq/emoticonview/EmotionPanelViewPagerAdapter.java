package com.tencent.mobileqq.emoticonview;

import acdz;
import afll;
import aflm;
import afmf;
import afnd;
import afnm;
import afns;
import afol;
import afom;
import afoo;
import afop;
import afoq;
import afos;
import afpr;
import afpu;
import afqq;
import afqr;
import ajdg;
import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aqnm;
import auts;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import com.tencent.widget.XEditTextEx;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class EmotionPanelViewPagerAdapter
  extends PagerAdapter
  implements View.OnClickListener
{
  public QQAppInterface app;
  public afoo b;
  public boolean bZX;
  boolean bZY = false;
  public boolean bZn;
  boolean bZr = false;
  public HashSet<String> bd = new HashSet();
  public int businessType = 0;
  public int cSL;
  public SparseArray<ImageButton> cz;
  public List<afoo> data;
  public float density;
  public afmf f;
  public Map<Integer, afll> kl;
  public Map<String, afll> km;
  int[] la = null;
  public BaseChatPie mBaseChatPie;
  public Context mContext;
  
  public EmotionPanelViewPagerAdapter(QQAppInterface paramQQAppInterface, Context paramContext, afmf paramafmf, BaseChatPie paramBaseChatPie, int paramInt, boolean paramBoolean)
  {
    this.mBaseChatPie = paramBaseChatPie;
    this.businessType = paramInt;
    this.app = paramQQAppInterface;
    this.mContext = paramContext;
    this.f = paramafmf;
    this.bZn = paramBoolean;
    this.density = paramContext.getResources().getDisplayMetrics().density;
    this.data = new ArrayList();
    this.kl = new HashMap();
    this.cz = new SparseArray();
    this.km = new HashMap();
  }
  
  @NotNull
  private RelativeLayout a(int paramInt, EmotionPanelListView paramEmotionPanelListView, afll paramafll)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
    localRelativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
    localRelativeLayout.addView(paramEmotionPanelListView, new RelativeLayout.LayoutParams(-1, -1));
    paramEmotionPanelListView = new RelativeLayout.LayoutParams(-2, -2);
    ImageButton localImageButton = new ImageButton(this.mContext);
    localImageButton.setContentDescription(this.mContext.getString(2131690134));
    localImageButton.setBackgroundResource(2130838084);
    localImageButton.setOnClickListener(this);
    if (TextUtils.isEmpty(this.mBaseChatPie.a.getText())) {}
    for (int i = 8;; i = 0)
    {
      localImageButton.setVisibility(i);
      paramEmotionPanelListView.rightMargin = aqnm.dip2px(5.0F);
      paramEmotionPanelListView.bottomMargin = aqnm.dip2px(7.0F);
      paramEmotionPanelListView.addRule(11);
      paramEmotionPanelListView.addRule(12);
      localRelativeLayout.addView(localImageButton, paramEmotionPanelListView);
      this.cz.put(paramInt, localImageButton);
      localImageButton.measure(0, 0);
      if ((paramafll instanceof afqq)) {
        ((afqq)paramafll).Na(localImageButton.getMeasuredHeight());
      }
      return localRelativeLayout;
    }
  }
  
  private void a(int paramInt, afoo paramafoo, afll paramafll, ListView paramListView)
  {
    if (paramInt == 14)
    {
      dbd();
      return;
    }
    ThreadManager.post(new EmotionPanelViewPagerAdapter.1(this, paramInt, paramafll, paramafoo, paramListView), 5, null, true);
  }
  
  private void a(afll paramafll)
  {
    if ((this.mBaseChatPie != null) && (this.mBaseChatPie.a() != null) && ((paramafll instanceof afqq)))
    {
      ((afqq)paramafll).cRX = this.mBaseChatPie.a().cRX;
      ((afqq)paramafll).cdX = this.mBaseChatPie.a().cdX;
      this.mBaseChatPie.a().cRX = -1;
      this.mBaseChatPie.a().cdX = -1;
    }
  }
  
  private void a(EmoticonPackage paramEmoticonPackage, afll paramafll, List<afom> paramList)
  {
    Object localObject;
    if (paramEmoticonPackage != null)
    {
      localObject = afns.a(paramEmoticonPackage.epId, false);
      if ((localObject == null) || (System.currentTimeMillis() - ((afns)localObject).XD > afns.XC)) {
        ((acdz)this.app.getBusinessHandler(12)).IT(Integer.parseInt(paramEmoticonPackage.epId));
      }
      if (!(paramafll instanceof aflm)) {
        break label86;
      }
      a((ajdg)this.app.getManager(14), Collections.singleton(paramEmoticonPackage), false);
    }
    label86:
    while ((!(paramafll instanceof afpr)) || (paramList == null)) {
      return;
    }
    paramEmoticonPackage = (ajdg)this.app.getManager(14);
    paramafll = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (afom)paramList.next();
      if ((localObject instanceof afpu))
      {
        localObject = (afpu)localObject;
        if (((afpu)localObject).e != null)
        {
          localObject = paramEmoticonPackage.b(((afpu)localObject).e.epId);
          if (localObject != null) {
            paramafll.add(localObject);
          }
        }
      }
    }
    a(paramEmoticonPackage, paramafll, true);
  }
  
  private void a(List<afom> paramList, ListView paramListView)
  {
    if ((paramListView != null) && (paramList != null) && (paramList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionPanelViewPagerAdapter", 2, "onScrollStateChanged preload systemEmotion");
      }
      int k = paramListView.getFirstVisiblePosition();
      int j = (paramListView.getLastVisiblePosition() + 1) * 7;
      int i = j;
      while ((i < j + 35) && (i < paramList.size()))
      {
        paramListView = (afom)paramList.get(i);
        if ((paramListView instanceof afqr))
        {
          paramListView = (afqr)paramListView;
          if ((paramListView.type != 3) && (paramListView.code != -1))
          {
            paramListView = paramListView.b(false);
            if ((paramListView instanceof URLDrawable))
            {
              paramListView = (URLDrawable)paramListView;
              if ((paramListView != null) && (paramListView.getStatus() != 1)) {
                paramListView.startDownload();
              }
            }
          }
        }
        i += 1;
      }
      j = k * 7 - 1;
      i = j;
      while ((i >= 0) && (i > j - 35) && (i < paramList.size()))
      {
        paramListView = (afom)paramList.get(i);
        if ((paramListView instanceof afqr))
        {
          paramListView = (afqr)paramListView;
          if ((paramListView.type != 3) && (paramListView.code != -1))
          {
            paramListView = paramListView.b(this.mContext, this.density);
            if ((paramListView instanceof URLDrawable))
            {
              paramListView = (URLDrawable)paramListView;
              if ((paramListView != null) && (paramListView.getStatus() != 1)) {
                paramListView.startDownload();
              }
            }
          }
        }
        i -= 1;
      }
    }
  }
  
  public void If(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.bd.add(paramString);
    }
  }
  
  public afll a(afoo paramafoo)
  {
    if (paramafoo == null) {}
    do
    {
      do
      {
        return null;
        if (QLog.isColorLevel()) {
          QLog.d("EmotionPanelViewPagerAdapter", 2, "getAdapterFromCache type = " + paramafoo.type);
        }
        if ((paramafoo.type != 6) && (paramafoo.type != 10)) {
          break;
        }
        paramafoo = paramafoo.d;
      } while ((paramafoo == null) || (TextUtils.isEmpty(paramafoo.epId)) || (!this.km.containsKey(paramafoo.epId)));
      return (afll)this.km.get(paramafoo.epId);
    } while (!this.kl.containsKey(Integer.valueOf(paramafoo.type)));
    return (afll)this.kl.get(Integer.valueOf(paramafoo.type));
  }
  
  public ImageButton a(int paramInt)
  {
    if (this.cz == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelViewPagerAdapter", 2, "getDeleteButtonFromCache position = " + paramInt);
    }
    return (ImageButton)this.cz.get(paramInt);
  }
  
  protected RelativeLayout a(EmotionPanelListView paramEmotionPanelListView, int paramInt, afll paramafll)
  {
    if (paramInt == 14)
    {
      RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
      localRelativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      localRelativeLayout.addView(paramEmotionPanelListView, new RelativeLayout.LayoutParams(-1, -1));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.topMargin = aqnm.dip2px(60.0F);
      localLayoutParams.addRule(12);
      View localView = View.inflate(this.mContext, 2131558648, null);
      localRelativeLayout.addView(localView, localLayoutParams);
      a(paramEmotionPanelListView, paramafll, localView, paramInt);
      return localRelativeLayout;
    }
    b(paramEmotionPanelListView);
    return null;
  }
  
  protected void a(int paramInt, afoo paramafoo, afll paramafll, ListView paramListView, List<afom> paramList)
  {
    ThreadManager.getUIHandler().post(new EmotionPanelViewPagerAdapter.2(this, paramInt, paramafoo, paramListView, paramList, paramafll));
  }
  
  public void a(ajdg paramajdg, Collection<EmoticonPackage> paramCollection, boolean paramBoolean)
  {
    long l2 = System.currentTimeMillis();
    acdz localacdz = (acdz)this.app.getBusinessHandler(12);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)paramCollection.next();
      if (localEmoticonPackage.status == 2)
      {
        if (localEmoticonPackage.richIPReqTime == 0L) {}
        for (long l1 = 86400L;; l1 = localEmoticonPackage.richIPReqTime)
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmotionPanelViewPagerAdapter", 2, "rich ip emoticon, richReqTime = " + l1 + " epId = " + localEmoticonPackage.epId);
          }
          if (l2 - localEmoticonPackage.richIPLastReqTime <= l1 * 1000L) {
            break;
          }
          localEmoticonPackage.richIPLastReqTime = l2;
          localacdz.bB(localEmoticonPackage.epId, paramBoolean);
          paramajdg.m(localEmoticonPackage);
          break;
        }
      }
    }
  }
  
  protected void a(EmotionPanelListView paramEmotionPanelListView, afll paramafll, View paramView, int paramInt)
  {
    if ((paramEmotionPanelListView == null) || (this.mBaseChatPie == null) || (this.mBaseChatPie.a() == null)) {
      return;
    }
    afnd localafnd = (afnd)this.mBaseChatPie.a().a().a(7);
    localafnd.a(paramEmotionPanelListView, paramafll, paramInt);
    localafnd.setEmptyView(paramView);
    paramEmotionPanelListView.addOnScrollListener(localafnd);
  }
  
  protected void b(EmotionPanelListView paramEmotionPanelListView)
  {
    if ((paramEmotionPanelListView == null) || (this.mBaseChatPie == null) || (this.mBaseChatPie.a() == null)) {
      return;
    }
    afnd localafnd = (afnd)this.mBaseChatPie.a().a().a(7);
    localafnd.b(paramEmotionPanelListView);
    paramEmotionPanelListView.removeOnScrollListener(localafnd);
  }
  
  public void d(afoo paramafoo)
  {
    if (paramafoo == null) {}
    do
    {
      return;
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        QLog.e("EmotionPanelViewPagerAdapter", 1, "refreshListViewAdapter error not in main thread");
        return;
      }
      int i = afol.a(this.app, paramafoo);
      if (QLog.isColorLevel()) {
        QLog.d("EmotionPanelViewPagerAdapter", 2, "refreshListViewAdapter panelType = " + i);
      }
      paramafoo = a(paramafoo);
    } while (paramafoo == null);
    paramafoo.dag();
    notifyDataSetChanged();
  }
  
  protected void dbd()
  {
    if ((this.mBaseChatPie == null) || (this.mBaseChatPie.a() == null)) {
      return;
    }
    ((afnd)this.mBaseChatPie.a().a().a(7)).daI();
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelViewPagerAdapter", 2, "destroyItem position = " + paramInt);
    }
    if ((paramView == null) || (paramObject == null))
    {
      QLog.e("EmotionPanelViewPagerAdapter", 1, "container or object = null");
      return;
    }
    ((ViewGroup)paramView).removeView((View)paramObject);
    label113:
    int i;
    if ((paramObject instanceof RelativeLayout))
    {
      paramView = (EmotionPanelListView)((RelativeLayout)paramObject).getChildAt(0);
      ((RelativeLayout)paramObject).removeViewAt(0);
      paramObject = paramView.getAdapter();
      if (!(paramObject instanceof auts)) {
        break label251;
      }
      paramObject = (afll)((auts)paramObject).getWrappedAdapter();
      paramView.setAdapter(null);
      paramView.setOnScrollListener(null);
      paramView.setEnableExtendPanle(false);
      paramView.setPullAndFastScrollListener(null);
      b(paramView);
      if (paramObject != null)
      {
        i = paramObject.ahx;
        if ((i != 6) && (i != 10)) {
          break label259;
        }
        EmoticonPackage localEmoticonPackage = paramObject.a();
        if ((localEmoticonPackage != null) && (!TextUtils.isEmpty(localEmoticonPackage.epId)) && (this.km.containsKey(localEmoticonPackage.epId))) {
          this.km.remove(localEmoticonPackage.epId);
        }
      }
    }
    for (;;)
    {
      if (this.cz != null) {
        this.cz.remove(paramInt);
      }
      paramObject.destory();
      afoq.a().c(paramView);
      return;
      paramView = (EmotionPanelListView)paramObject;
      break;
      label251:
      paramObject = (afll)paramObject;
      break label113;
      label259:
      if (this.kl.containsKey(Integer.valueOf(i))) {
        this.kl.remove(Integer.valueOf(i));
      }
    }
  }
  
  public void e(afoo paramafoo)
  {
    this.b = paramafoo;
    if (paramafoo == null) {}
    do
    {
      return;
      int i = afol.a(this.app, paramafoo);
      if (QLog.isColorLevel()) {
        QLog.d("EmotionPanelViewPagerAdapter", 2, "onPageSelected panelType = " + i);
      }
      paramafoo = a(paramafoo);
    } while (paramafoo == null);
    paramafoo.a = this.b;
    paramafoo.dah();
  }
  
  public int getCount()
  {
    if (this.data != null) {
      return this.data.size();
    }
    QLog.e("EmotionPanelViewPagerAdapter", 1, "getCount count = 0");
    return 0;
  }
  
  public int getItemPosition(Object paramObject)
  {
    if ((paramObject instanceof View))
    {
      View localView = (View)paramObject;
      afoo localafoo = (afoo)localView.getTag();
      if (localafoo != null)
      {
        if ((localafoo.d != null) && (this.bd.contains(localafoo.d.epId)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmotionPanelViewPagerAdapter", 2, "getItemPosition destroy " + localView.getTag());
          }
          return -2;
        }
        int j = this.data.indexOf(localafoo);
        int i = j;
        if (j < 0) {
          i = -2;
        }
        return i;
      }
    }
    return super.getItemPosition(paramObject);
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelViewPagerAdapter", 2, "instantiateItem position = " + paramInt);
    }
    EmotionPanelListView localEmotionPanelListView = afoq.a().a(this.mContext);
    if (localEmotionPanelListView == null)
    {
      QLog.e("EmotionPanelViewPagerAdapter", 1, "instantiateItem listView is null");
      paramView = null;
      return paramView;
    }
    localEmotionPanelListView.setDivider(null);
    localEmotionPanelListView.setEdgeEffectEnabled(false);
    localEmotionPanelListView.setSelector(2130851773);
    afoo localafoo = (afoo)this.data.get(paramInt);
    int k = afol.a(this.app, localafoo);
    int j = localafoo.TL;
    int i = j;
    if (this.bZX)
    {
      j = Math.max(1, j * 4 / 7);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("EmotionPanelViewPagerAdapter", 2, "multiWindowMode: " + localafoo.TL + "->" + j);
        i = j;
      }
    }
    afll localafll = afop.a().a(this.app, this.mContext, i, k, localafoo.type, localafoo.d, this.f, this.mBaseChatPie, this.businessType, this.bZn);
    if (localafll == null)
    {
      QLog.e("EmotionPanelViewPagerAdapter", 1, "instantiateItem adapter is null, panelType = " + k);
      return null;
    }
    a(localafll);
    if ((localafll instanceof afqq)) {
      ((afqq)localafll).bZY = this.bZY;
    }
    EmoticonPackage localEmoticonPackage = null;
    Object localObject = localEmoticonPackage;
    if (this.mBaseChatPie != null)
    {
      localObject = localEmoticonPackage;
      if (this.mBaseChatPie.a() != null)
      {
        localObject = localEmoticonPackage;
        if (this.mBaseChatPie.a != null)
        {
          localObject = localEmoticonPackage;
          if (this.mBaseChatPie.a().ajx())
          {
            localEmotionPanelListView.setEnableExtendPanle(true);
            localEmotionPanelListView.setPullAndFastScrollListener(this.mBaseChatPie.a());
            localObject = localEmotionPanelListView.getOnScrollListener();
            if (!(localObject instanceof afnm)) {
              localEmotionPanelListView.setOnScrollListener(new afnm(localEmotionPanelListView, this.mBaseChatPie.a(), (AbsListView.e)localObject));
            }
            if ((k != 1) && (k != 2)) {
              break label640;
            }
            localObject = a(paramInt, localEmotionPanelListView, localafll);
          }
        }
      }
    }
    label438:
    localafll.widthPixels = this.cSL;
    localafll.a = this.b;
    localafll.a(localEmotionPanelListView);
    localEmotionPanelListView.setAdapter(localafll);
    QLog.d("EmotionPanelViewPagerAdapter", 1, "instantiateItem start get data, panelType = " + k + ", position = " + paramInt + ", panelInfo = " + localafoo);
    if ((localafoo.type == 6) || (localafoo.type == 10))
    {
      localEmoticonPackage = localafoo.d;
      if ((localEmoticonPackage != null) && (!TextUtils.isEmpty(localEmoticonPackage.epId)))
      {
        this.km.put(localEmoticonPackage.epId, localafll);
        label579:
        if ((localObject == null) || (((RelativeLayout)localObject).getParent() == paramView) || (paramInt >= getCount())) {
          break label691;
        }
        ((ViewGroup)paramView).addView((View)localObject);
      }
    }
    for (;;)
    {
      localEmotionPanelListView.setTag(localafoo);
      a(k, localafoo, localafll, localEmotionPanelListView);
      paramView = (View)localObject;
      if (localObject != null) {
        break;
      }
      return localEmotionPanelListView;
      label640:
      localObject = a(localEmotionPanelListView, k, localafll);
      break label438;
      QLog.e("EmotionPanelViewPagerAdapter", 1, "instantiateItem put adapter to map error");
      break label579;
      this.kl.put(Integer.valueOf(localafoo.type), localafll);
      break label579;
      label691:
      if ((localEmotionPanelListView.getParent() != paramView) && (paramInt < getCount())) {
        ((ViewGroup)paramView).addView(localEmotionPanelListView);
      }
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void onClick(View paramView)
  {
    if ((this.mBaseChatPie != null) && (this.mBaseChatPie.a() != null)) {
      this.mBaseChatPie.a().dan();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelViewPagerAdapter", 2, "onDestroy");
    }
    if (this.data != null) {
      this.data.clear();
    }
    if (this.f != null) {
      this.f = null;
    }
    if (this.kl != null) {
      this.kl.clear();
    }
    if (this.cz != null) {
      this.cz.clear();
    }
    if (this.km != null) {
      this.km.clear();
    }
    afoq.a().destory();
    afos.a().destory();
  }
  
  public void setData(List<afoo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelViewPagerAdapter", 2, "setData justDownload:" + this.bd.toString());
    }
    this.data = paramList;
    notifyDataSetChanged();
    this.bd.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */