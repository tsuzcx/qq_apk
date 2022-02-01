package com.tencent.mobileqq.leba.mgr;

import acgw;
import acny;
import aeif;
import aekh;
import aers;
import aert;
import aimu;
import aimu.a;
import altq;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import anot;
import aqnm;
import auwd;
import auwd.a;
import com.tencent.biz.qqstory.widget.OverScrollRecyclerView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import zjp;
import zjq;

public class LebaTableMgrFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private RedTouch O;
  private zjp a;
  private aimu jdField_b_of_type_Aimu;
  private OverScrollRecyclerView jdField_b_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView;
  private ImageView gH;
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    ((altq)getQQAppInterface().getManager(36)).i(paramAppInfo);
  }
  
  private void bQI()
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((altq)getQQAppInterface().getManager(36)).getAppInfoByPath("150000.150100");
    if (this.O == null) {
      return;
    }
    this.O.a(53).a().e(localAppInfo);
    a(localAppInfo);
  }
  
  private void cmV()
  {
    if (this.gH == null) {
      this.gH = ((ImageView)this.titleRoot.findViewById(2131369602));
    }
    if (!aert.c().aht())
    {
      this.gH.setVisibility(8);
      return;
    }
    this.gH.setImageResource(2130851225);
    this.gH.setClickable(true);
    this.gH.setOnClickListener(this);
    this.gH.setVisibility(0);
    this.O = new RedTouch(getActivity(), this.gH).a(53).a();
    bQI();
  }
  
  public void Lf(boolean paramBoolean)
  {
    this.a = new zjp();
    this.a.BJ(paramBoolean);
    this.jdField_b_of_type_Aimu = new aimu(getActivity(), this.a);
    this.jdField_b_of_type_Aimu.BJ(paramBoolean);
    Object localObject = new GridLayoutManager(getActivity(), 3);
    ((GridLayoutManager)localObject).setSpanSizeLookup(new b(this.jdField_b_of_type_Aimu));
    this.jdField_b_of_type_Aimu.a((GridLayoutManager)localObject);
    auwd localauwd = new auwd(new c(this.jdField_b_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView, this.a, this.jdField_b_of_type_Aimu));
    localauwd.attachToRecyclerView(this.jdField_b_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView);
    this.jdField_b_of_type_Aimu.a(localauwd);
    this.jdField_b_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    localObject = new DefaultItemAnimator();
    ((DefaultItemAnimator)localObject).setSupportsChangeAnimations(false);
    this.jdField_b_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setItemAnimator((RecyclerView.ItemAnimator)localObject);
    this.jdField_b_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.addItemDecoration(new a(getActivity(), this.jdField_b_of_type_Aimu));
    this.jdField_b_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setAdapter(this.jdField_b_of_type_Aimu);
  }
  
  public boolean ape()
  {
    for (;;)
    {
      try
      {
        aekh localaekh = (aekh)aeif.a().o(614);
        if (localaekh == null)
        {
          QLog.i("leba_sort_LebaTableMgrFragment", 1, "configBean == null");
          return false;
        }
        int i = localaekh.cNG;
        if (i != 1) {
          continue;
        }
        bool = true;
        try
        {
          QLog.i("leba_sort_LebaTableMgrFragment", 1, "isSupportSort " + bool);
          return bool;
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2)
      {
        boolean bool = false;
        continue;
      }
      QLog.i("leba_sort_LebaTableMgrFragment", 1, "isSupportSort", localException1);
      return bool;
      bool = false;
    }
  }
  
  @Nullable
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QLog.i("leba_sort_LebaTableMgrFragment", 1, "doOnCreateView");
    setTitle(getString(2131695246));
    paramLayoutInflater = getQQAppInterface();
    if (paramLayoutInflater != null) {
      paramLayoutInflater.cLv();
    }
    paramLayoutInflater = this.mContentView.findViewById(2131370164);
    this.jdField_b_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView = ((OverScrollRecyclerView)this.mContentView.findViewById(2131376994));
    if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
      paramLayoutInflater.setBackgroundColor(getResources().getColor(2131165927));
    }
    for (;;)
    {
      Lf(ape());
      cmV();
      return;
      paramLayoutInflater.setBackgroundColor(getResources().getColor(2131165926));
    }
  }
  
  public void dsT()
  {
    Object localObject = getQQAppInterface();
    if (localObject == null) {
      QLog.i("leba_sort_LebaTableMgrFragment", 1, "updateDate appInterface == null");
    }
    do
    {
      return;
      List localList = zjq.a().dp();
      int i = acgw.C((QQAppInterface)localObject);
      localObject = new LebaTableMgrFragment.1(this, localList, acgw.a((QQAppInterface)localObject, i), i);
      if (Looper.myLooper() == Looper.getMainLooper()) {
        break;
      }
    } while (getActivity() == null);
    getActivity().runOnUiThread((Runnable)localObject);
    return;
    ((Runnable)localObject).run();
  }
  
  public int getContentLayoutId()
  {
    return 2131561406;
  }
  
  public QQAppInterface getQQAppInterface()
  {
    if (getActivity() == null) {
      return null;
    }
    return (QQAppInterface)getActivity().getAppInterface();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = wV();
      Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", ((String)localObject).replace("[uid]", "").replace("[lType]", "1"));
      startActivity(localIntent);
      localObject = getQQAppInterface();
      anot.a((QQAppInterface)localObject, "dc00898", "", "", "0X800AE51", "0X800AE51", acny.e((QQAppInterface)localObject, ((QQAppInterface)localObject).getCurrentUin(), false), 0, "0", "0", "", "");
      ((altq)((QQAppInterface)localObject).getManager(36)).OS("150000.150100");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QLog.i("leba_sort_LebaTableMgrFragment", 1, "doOnCreate");
    zjq.cdv |= 0x1;
    paramBundle = getQQAppInterface();
    if (paramBundle != null) {
      anot.a(paramBundle, "dc00898", "", "", "0X80098FB", "0X80098FB", 0, 0, "", "", "", "");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QLog.i("leba_sort_LebaTableMgrFragment", 1, "doOnDestroy");
    this.jdField_b_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView = null;
    this.jdField_b_of_type_Aimu = null;
    if (this.a != null)
    {
      this.a.br(getQQAppInterface());
      this.a = null;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    QLog.i("leba_sort_LebaTableMgrFragment", 1, "doOnResume");
    dsT();
  }
  
  public String wV()
  {
    String str2 = aert.c().tH();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = null;
    }
    return str1;
  }
  
  public static class a
    extends RecyclerView.ItemDecoration
  {
    aimu b;
    private Paint bv;
    int ddT = aqnm.dip2px(1.0F);
    
    public a(Context paramContext, aimu paramaimu)
    {
      this.b = paramaimu;
      this.bv = new Paint();
      this.bv.setAntiAlias(true);
      if (ThemeUtil.isNowThemeIsNight(null, false, null))
      {
        this.bv.setColor(paramContext.getResources().getColor(2131165929));
        return;
      }
      this.bv.setColor(paramContext.getResources().getColor(2131165928));
    }
    
    public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
    {
      super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
      if (this.b == null) {
        QLog.i("leba_sort_LebaTableMgrFragment", 1, "MyItemDecoration getItemOffsets mAdapter == null");
      }
      while (paramRecyclerView.getChildAdapterPosition(paramView) < 0) {
        return;
      }
      paramRect.bottom = this.ddT;
      paramRect.right = this.ddT;
    }
    
    public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
    {
      super.onDraw(paramCanvas, paramRecyclerView, paramState);
      int j = paramRecyclerView.getChildCount();
      int i = 0;
      while (i < j)
      {
        paramState = paramRecyclerView.getChildAt(i);
        Object localObject = paramState.getTag(2131370337);
        if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localObject).intValue() == 2)) {
          paramCanvas.drawRect(paramState.getLeft(), paramState.getTop(), paramState.getRight(), paramState.getBottom(), this.bv);
        }
        i += 1;
      }
    }
  }
  
  public static class b
    extends GridLayoutManager.SpanSizeLookup
  {
    aimu b;
    
    public b(aimu paramaimu)
    {
      this.b = paramaimu;
    }
    
    public int getSpanSize(int paramInt)
    {
      if (this.b == null) {
        QLog.i("leba_sort_LebaTableMgrFragment", 1, "MyLoopUp getSpanSize mAdapter == null");
      }
      while (this.b.getItemViewType(paramInt) != 1) {
        return 1;
      }
      return 3;
    }
  }
  
  public static class c
    extends auwd.a
  {
    zjp a;
    aimu b;
    OverScrollRecyclerView c;
    
    public c(OverScrollRecyclerView paramOverScrollRecyclerView, zjp paramzjp, aimu paramaimu)
    {
      this.c = paramOverScrollRecyclerView;
      this.a = paramzjp;
      this.b = paramaimu;
    }
    
    private void b(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
    {
      if ((paramViewHolder != null) && (paramViewHolder.itemView != null) && ((paramViewHolder instanceof aimu.a)) && (Build.VERSION.SDK_INT >= 21)) {}
      try
      {
        paramViewHolder.itemView.setOutlineProvider(ViewOutlineProvider.BOUNDS);
        paramViewHolder = paramViewHolder.itemView;
        if (paramBoolean) {}
        for (float f = 20.0F;; f = 0.0F)
        {
          paramViewHolder.setTranslationZ(f);
          return;
        }
        return;
      }
      catch (Exception paramViewHolder)
      {
        QLog.i("leba_sort_LebaTableMgrFragment", 1, "setItemShadow", paramViewHolder);
      }
    }
    
    public void clearView(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
    {
      super.clearView(paramRecyclerView, paramViewHolder);
      QLog.i("leba_sort_LebaTableMgrFragment", 1, "clearView");
      b(paramViewHolder, false);
    }
    
    public int getMovementFlags(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
    {
      return makeMovementFlags(15, 0);
    }
    
    public boolean isLongPressDragEnabled()
    {
      return false;
    }
    
    public boolean onMove(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
    {
      int i = paramViewHolder1.getAdapterPosition();
      int j = paramViewHolder2.getAdapterPosition();
      if (this.a != null) {
        return this.a.a(paramRecyclerView, i, j);
      }
      return false;
    }
    
    public void onSelectedChanged(RecyclerView.ViewHolder paramViewHolder, int paramInt)
    {
      QLog.i("leba_sort_LebaTableMgrFragment", 1, "onSelectedChanged" + paramInt);
      if (paramInt == 0)
      {
        if (this.c != null) {
          this.c.bwp();
        }
        if (this.a != null) {
          this.a.a(this.b);
        }
      }
      do
      {
        do
        {
          return;
        } while (paramInt != 2);
        b(paramViewHolder, true);
      } while (this.c == null);
      this.c.bwo();
    }
    
    public void onSwiped(RecyclerView.ViewHolder paramViewHolder, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.mgr.LebaTableMgrFragment
 * JD-Core Version:    0.7.0.1
 */