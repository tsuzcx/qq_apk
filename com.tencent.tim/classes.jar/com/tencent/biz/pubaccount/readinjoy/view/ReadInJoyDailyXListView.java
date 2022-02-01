package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import auuo;
import awit;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import kbp;
import kge;
import kvs;
import kvx;
import kxm;
import kxm.b;
import kys;
import ndi;
import neo;
import nep;
import ngm;
import npi;
import npy;
import org.json.JSONException;

public class ReadInJoyDailyXListView
  extends ReadInJoyXListView
  implements ngm
{
  private boolean akN;
  private boolean canLoadMore;
  private ColorDrawable colorDrawable = new ColorDrawable(-1);
  private Container h;
  public List<auuo> jV;
  
  public ReadInJoyDailyXListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyDailyXListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ReadInJoyDailyXListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void KR()
  {
    if (this.akN) {
      return;
    }
    kxm.b localb = kxm.a();
    String str2 = "0";
    String str1;
    if (kge.getMode() == 1) {
      str1 = "1";
    }
    for (;;)
    {
      localb.b("is_jump", str1);
      localb.b("cmd", awit.Hf());
      if ("1".equals(str1)) {
        localb.b("jump_src", kys.ja());
      }
      this.akN = true;
      kbp.a(null, "", "0X8009882", "0X8009882", 0, 0, "", "", "", localb.build(), false);
      return;
      str1 = str2;
      if (!TextUtils.isEmpty(kys.getJumpUrl()))
      {
        str1 = str2;
        if (kge.getMode() == 3) {
          str1 = "1";
        }
      }
    }
  }
  
  private boolean yv()
  {
    if (getAdapter() == null) {}
    while (getLastVisiblePosition() < getAdapter().getCount() - 1) {
      return false;
    }
    return true;
  }
  
  public npy a(int paramInt)
  {
    return super.a(paramInt);
  }
  
  public void a(int paramInt1, View paramView, ListView paramListView, int paramInt2)
  {
    if (paramInt1 == 0) {
      super.a(paramInt1, paramView, paramListView, paramInt2);
    }
  }
  
  public void a(View paramView, ListView paramListView, int paramInt) {}
  
  public void a(auuo paramauuo)
  {
    if (this.jV == null)
    {
      this.jV = new ArrayList();
      super.setOverScrollListener(new nep(this));
    }
    this.jV.add(paramauuo);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if ((this.canLoadMore) && (paramInt == 1))
    {
      ts(2);
      return true;
    }
    if (paramInt == 0) {
      return super.a(paramInt, paramView, paramListView);
    }
    return false;
  }
  
  public void aWg()
  {
    super.aWg();
  }
  
  public void aWh()
  {
    super.aWh();
  }
  
  public void aWi()
  {
    QLog.d("ReadInJoyDailyXListView", 2, "scroll2TopAndRefresh : ");
  }
  
  public void aWj()
  {
    TemplateBean localTemplateBean = null;
    try
    {
      npi localnpi = npi.a("default_feeds", true);
      if (localnpi != null) {
        localTemplateBean = localnpi.getTemplateBean(kys.z());
      }
      if ((localTemplateBean != null) && (this.h != null))
      {
        if (kxm.isInMainThread())
        {
          kvx.bindDynamicValueWithoutRecursion(this.h, null, localTemplateBean);
          return;
        }
        kxm.p().post(new ReadInJoyDailyXListView.2(this, localTemplateBean));
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      QLog.e("ReadInJoyDailyXListView", 1, "onRefreshFooterView, e = " + localJSONException);
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    super.b(paramInt, paramView, paramListView);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
  }
  
  protected void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    super.init(paramContext, paramAttributeSet);
    setNeedShowHeaderView(true);
    a(this);
    if (kge.getMode() != 2)
    {
      c(this);
      return;
    }
    setCanLoadMore(true);
  }
  
  public void lA(boolean paramBoolean)
  {
    super.lA(paramBoolean);
    removeFooterView(this.ey);
    this.aYh = 0;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.canLoadMore) {
      if (yv()) {
        KR();
      }
    }
    while ((this.ey == null) || (this.aYh >= 0) || (this.aDC == 1) || (paramInt1 < paramInt3 - paramInt2 * 2) || (this.arG)) {
      return;
    }
    ts(2);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      kvs.oT(8);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
  }
  
  public void pu(boolean paramBoolean)
  {
    super.pu(paramBoolean);
  }
  
  public int qz()
  {
    return this.mTouchMode;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
    if ((paramListAdapter != null) && ((paramListAdapter instanceof ndi))) {
      ((ndi)paramListAdapter).a(new neo(this));
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    super.setBackgroundColor(-1);
  }
  
  public void setCanLoadMore(boolean paramBoolean)
  {
    this.canLoadMore = paramBoolean;
    setOverScrollTouchMode(1);
    if ((paramBoolean) && (this.ey == null)) {
      initFooterView();
    }
  }
  
  public void setChannelId(int paramInt)
  {
    this.mChannelId = paramInt;
  }
  
  public void setContentBackground(Drawable paramDrawable, boolean paramBoolean)
  {
    super.setContentBackground(this.colorDrawable, false);
  }
  
  public void setFooterView(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramBoolean) {
      bool = this.canLoadMore;
    }
    super.setFooterView(bool);
  }
  
  public void setNeedShowFootView(boolean paramBoolean) {}
  
  public void setNeedShowHeaderView(boolean paramBoolean)
  {
    super.setNeedShowHeaderView(paramBoolean);
  }
  
  public void setNoMoreData(boolean paramBoolean) {}
  
  public void setOverScrollListener(auuo paramauuo)
  {
    if (paramauuo != null) {
      this.jV.add(paramauuo);
    }
  }
  
  public void setPTSFooterView(Container paramContainer)
  {
    this.h = paramContainer;
  }
  
  public void ts(int paramInt)
  {
    if (!this.canLoadMore) {
      return;
    }
    if (paramInt != 4)
    {
      setFooterView(true);
      if (this.a != null)
      {
        this.ey.setVisibility(0);
        this.nI.setText(2131718674);
        this.z.setVisibility(0);
        this.aDC = 1;
        this.a.b(this, paramInt);
      }
    }
    for (;;)
    {
      QLog.d("ReadInJoyDailyXListView", 1, new Object[] { "loadingMore mCurrentStatus = ", Integer.valueOf(this.aDC), ", type = ", Integer.valueOf(paramInt) });
      return;
      setFooterView(true);
      this.ey.setVisibility(0);
      this.nI.setText(2131718674);
      this.z.setVisibility(0);
      if (this.a != null)
      {
        this.aDC = 1;
        this.a.b(this, paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDailyXListView
 * JD-Core Version:    0.7.0.1
 */