package com.tencent.mobileqq.activity.contact.troop;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cec;
import ced;
import cee;
import cef;
import ceg;
import ceh;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.adapter.TroopListAdapter2;
import com.tencent.mobileqq.adapter.TroopListAdapter2.OnTroopListClickListener;
import com.tencent.mobileqq.adapter.TroopListAdapter2.TroopListItem;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.OnSlideListener;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

public class TroopView
  extends BaseTroopView
  implements View.OnClickListener, TroopListAdapter2.OnTroopListClickListener, SlideDetectListView.OnSlideListener, OverScrollViewListener
{
  private static final String jdField_a_of_type_JavaLangString = "rec_last_troop_list_refresh_time";
  static final int c = 101;
  static final int d = 103;
  static final int e = 1000;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private cef jdField_a_of_type_Cef = new cef(this, null);
  private ceg jdField_a_of_type_Ceg = new ceg(this, null);
  private ceh jdField_a_of_type_Ceh = new ceh(this, null);
  public TroopListAdapter2 a;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new cee(this);
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  public SlideDetectListView a;
  int b;
  public boolean c = false;
  protected boolean d = false;
  
  public TroopView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.d = paramBoolean;
  }
  
  private long a()
  {
    return a().getSharedPreferences("rec_last_troop_list_refresh_time", 0).getLong("rec_last_troop_list_refresh_time", 0L);
  }
  
  private void c(int paramInt)
  {
    Object localObject2 = a();
    if ((localObject2 == null) || (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2 == null)) {}
    do
    {
      return;
      if (paramInt == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        return;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.getItem(paramInt - 1);
    } while (!(localObject1 instanceof TroopListAdapter2.TroopListItem));
    TroopListAdapter2.TroopListItem localTroopListItem = (TroopListAdapter2.TroopListItem)localObject1;
    Object localObject1 = null;
    switch (localTroopListItem.g)
    {
    default: 
      label100:
      if (paramInt < this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.getCount())
      {
        localObject2 = (TroopListAdapter2.TroopListItem)this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.getItem(paramInt);
        if ((((TroopListAdapter2.TroopListItem)localObject2).g != 6) && (((TroopListAdapter2.TroopListItem)localObject2).g != 4) && (((TroopListAdapter2.TroopListItem)localObject2).g != 2)) {
          break label323;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(0);
        if (localObject2 != null)
        {
          paramInt = ((View)localObject2).getBottom();
          localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
          if (paramInt >= this.b) {
            break label315;
          }
          ((RelativeLayout.LayoutParams)localObject2).topMargin = (paramInt - this.b);
          this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
        }
      }
      label195:
      break;
    }
    while (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      return;
      localObject1 = ((Activity)localObject2).getString(2131362303, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.f) });
      break label100;
      localObject1 = ((Activity)localObject2).getString(2131362301, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.d) });
      break label100;
      localObject1 = ((Activity)localObject2).getString(2131362302, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.e) });
      break label100;
      label315:
      ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
      break label195;
      label323:
      localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      if (((RelativeLayout.LayoutParams)localObject2).topMargin != 0)
      {
        ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
      }
    }
  }
  
  private boolean c()
  {
    if (NetworkUtil.f(a()))
    {
      ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(17)).a();
      this.c = true;
      return true;
    }
    return false;
  }
  
  private void k()
  {
    this.b = getResources().getDimensionPixelSize(2131493074);
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131297870));
    LayoutInflater localLayoutInflater = LayoutInflater.from(a());
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297668));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localLayoutInflater.inflate(2130903274, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setTranscriptMode(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setContentBackground(2130837635);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollListener(this);
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnSlideListener(this);
    }
  }
  
  private void m()
  {
    long l = System.currentTimeMillis();
    a().getSharedPreferences("rec_last_troop_list_refresh_time", 0).edit().putLong("rec_last_troop_list_refresh_time", l).commit();
  }
  
  protected Dialog a()
  {
    return new ced(this, a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a());
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2 != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(a());
  }
  
  protected void a(Intent paramIntent, BaseTroopView.ITroopContext paramITroopContext)
  {
    super.a(paramIntent, paramITroopContext);
    a(2130903375);
    l();
    k();
    a(this.jdField_a_of_type_Cef);
    a(this.jdField_a_of_type_Ceg);
    a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    a(this.jdField_a_of_type_Ceh);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a())
    {
      this.jdField_a_of_type_Int = 6;
      return;
    }
    this.jdField_a_of_type_Int = 1;
  }
  
  public void a(TroopInfo paramTroopInfo, int paramInt)
  {
    if (this.d) {}
    while (paramTroopInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a())
    {
      ForwardOperations localForwardOperations = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a();
      if (localForwardOperations != null) {
        localForwardOperations.a(paramTroopInfo.troopuin, 1, paramTroopInfo.troopuin, paramTroopInfo.troopname);
      }
      switch (paramInt)
      {
      case 4: 
      case 6: 
      default: 
        paramInt = 0;
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "choose_grp", "turn", 0, 0, paramTroopInfo.troopuin + "", String.valueOf(paramInt), "", "");
        return;
        paramInt = 1;
        continue;
        paramInt = 2;
        continue;
        paramInt = 3;
      }
    }
    switch (paramInt)
    {
    case 4: 
    case 6: 
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "choose_grp", "grplist", 0, 0, paramTroopInfo.troopuin + "", String.valueOf(paramInt), "", "");
      a(paramTroopInfo.troopuin, paramTroopInfo.troopname);
      return;
      paramInt = 1;
      continue;
      paramInt = 2;
      continue;
      paramInt = 3;
    }
  }
  
  public void a(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    if (this.d) {}
    while (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.a(paramInt) != null) {
      return;
    }
  }
  
  void a(String paramString1, String paramString2)
  {
    ThreadPriorityManager.a(true);
    Intent localIntent = new Intent(a(), ChatActivity.class);
    localIntent.putExtra("uin", paramString1);
    paramString1 = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramString1);
    if ((paramString1 != null) && (paramString1.troopcode != null)) {
      localIntent.putExtra("troop_uin", paramString1.troopcode);
    }
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("uinname", paramString2);
    a(localIntent);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(a());
    if (!c()) {
      a(103, 1000L);
    }
    return true;
  }
  
  public boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.B();
      continue;
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.B();
      b(2131363356);
    }
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2 == null) {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a()) {
        break label89;
      }
    }
    label89:
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2 = new TroopListAdapter2(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, i, false, this.d);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollGroupFloatingListener(new cec(this));
      this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.notifyDataSetChanged();
      return;
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(a());
  }
  
  public void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.a(paramInt) == null) {}
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  protected void h()
  {
    super.h();
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2 != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.b();
    }
    b(this.jdField_a_of_type_Cef);
    b(this.jdField_a_of_type_Ceg);
    b(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    b(this.jdField_a_of_type_Ceh);
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2 != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.b();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopView
 * JD-Core Version:    0.7.0.1
 */