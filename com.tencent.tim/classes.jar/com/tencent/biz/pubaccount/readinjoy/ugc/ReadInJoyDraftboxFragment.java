package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import aqfo;
import aqnm;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.widget.SwipListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.List;
import lbz;
import liq;
import mjp;
import mqq.os.MqqHandler;

public class ReadInJoyDraftboxFragment
  extends IphoneTitleBarFragment
{
  private liq a = lbz.a().a();
  private mjp b;
  private List<ReadInJoyDraftboxItem> itemList = new ArrayList();
  
  private static boolean a(ReadInJoyDraftboxItem paramReadInJoyDraftboxItem)
  {
    return (paramReadInJoyDraftboxItem.type != 1) && (paramReadInJoyDraftboxItem.type != 3) && (paramReadInJoyDraftboxItem.type != 2);
  }
  
  private void aPz()
  {
    ThreadManager.getSubThreadHandler().post(new ReadInJoyDraftboxFragment.1(this));
  }
  
  public void aDb()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      return;
    }
    if ((localFragmentActivity.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      localFragmentActivity.getWindow().addFlags(67108864);
      ImmersiveUtils.clearCoverForStatus(localFragmentActivity.getWindow(), localFragmentActivity.isClearCoverLayer);
      if (localFragmentActivity.mSystemBarComp == null) {
        localFragmentActivity.mSystemBarComp = new SystemBarCompact(localFragmentActivity, true, -1);
      }
      localFragmentActivity.mSystemBarComp.init();
      if (!ThemeUtil.isInNightMode(localFragmentActivity.app)) {
        break label166;
      }
      if ((aqfo.isMIUI()) || (aqfo.isFlyme())) {
        break label146;
      }
      localFragmentActivity.mSystemBarComp.setStatusBarColor(-7829368);
    }
    for (;;)
    {
      this.leftView.setTextColor(-14408926);
      this.leftView.setBackgroundResource(2130850369);
      if (this.centerView != null) {
        this.centerView.setTextColor(-16777216);
      }
      this.vg.setBackgroundColor(-1);
      return;
      label146:
      localFragmentActivity.mSystemBarComp.setStatusBarColor(-7829368);
      localFragmentActivity.mSystemBarComp.setStatusBarDarkMode(true);
      continue;
      label166:
      if ((Build.VERSION.SDK_INT >= 23) && (!aqfo.isMIUI()) && (!aqfo.isFlyme()))
      {
        localFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
        localFragmentActivity.mSystemBarComp.setStatusBarColor(-1);
      }
      else if (!aqfo.isFlyme())
      {
        localFragmentActivity.mSystemBarComp.setStatusBarColor(-2368549);
      }
      else
      {
        localFragmentActivity.mSystemBarComp.setStatusBarColor(-1);
        localFragmentActivity.mSystemBarComp.setStatusBarDarkMode(true);
      }
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.b = new mjp(getActivity(), this.itemList);
    if (this.mContentView != null)
    {
      paramLayoutInflater = (SwipListView)this.mContentView.findViewById(2131366120);
      paramLayoutInflater.setAdapter(this.b);
      paramLayoutInflater.setDragEnable(true);
      paramLayoutInflater.setDivider(new ColorDrawable(Color.parseColor("#FFF2F2F2")));
      paramLayoutInflater.setDividerHeight(aqnm.dip2px(0.5F));
      paramLayoutInflater.setEmptyView(this.mContentView.findViewById(2131366119));
    }
    if (this.leftView != null) {}
    aDb();
  }
  
  public int getContentLayoutId()
  {
    return 2131560355;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onResume()
  {
    super.onResume();
    aPz();
  }
  
  public static abstract interface a
  {
    public abstract void notify(List<ReadInJoyDraftboxItem> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDraftboxFragment
 * JD-Core Version:    0.7.0.1
 */