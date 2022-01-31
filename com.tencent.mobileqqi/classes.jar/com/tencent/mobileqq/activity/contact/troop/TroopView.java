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
import android.widget.EditText;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
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
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import elt;
import elu;
import elv;
import elw;
import elx;
import ely;

public class TroopView
  extends BaseTroopView
  implements View.OnClickListener, TroopListAdapter2.OnTroopListClickListener, OverScrollViewListener
{
  private static final String jdField_a_of_type_JavaLangString = "rec_last_troop_list_refresh_time";
  static final int c = 101;
  static final int d = 103;
  static final int jdField_e_of_type_Int = 1000;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  public TroopListAdapter2 a;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new elv(this);
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  public SlideDetectListView a;
  private elw jdField_a_of_type_Elw = new elw(this, null);
  private elx jdField_a_of_type_Elx = new elx(this, null);
  private ely jdField_a_of_type_Ely = new ely(this, null);
  int b;
  public boolean c = false;
  private View jdField_e_of_type_AndroidViewView;
  
  public TroopView(Context paramContext)
  {
    super(paramContext);
    this.e = null;
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
    switch (localTroopListItem.i)
    {
    default: 
      label108:
      if (paramInt < this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.getCount())
      {
        localObject2 = (TroopListAdapter2.TroopListItem)this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.getItem(paramInt);
        if ((((TroopListAdapter2.TroopListItem)localObject2).i != 6) && (((TroopListAdapter2.TroopListItem)localObject2).i != 4) && (((TroopListAdapter2.TroopListItem)localObject2).i != 2)) {
          break label358;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(0);
        if (localObject2 != null)
        {
          paramInt = ((View)localObject2).getBottom();
          localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
          if (paramInt >= this.b) {
            break label350;
          }
          ((RelativeLayout.LayoutParams)localObject2).topMargin = (paramInt - this.b);
          this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
        }
      }
      label203:
      break;
    }
    while (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      return;
      localObject1 = ((Activity)localObject2).getString(2131560390, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.g) });
      break label108;
      localObject1 = ((Activity)localObject2).getString(2131560393, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.f) });
      break label108;
      localObject1 = ((Activity)localObject2).getString(2131560391, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.d) });
      break label108;
      localObject1 = ((Activity)localObject2).getString(2131560392, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.e) });
      break label108;
      label350:
      ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
      break label203;
      label358:
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
      ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).a();
      this.c = true;
      return true;
    }
    return false;
  }
  
  private void k()
  {
    this.b = getResources().getDimensionPixelSize(2131427610);
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131232648));
    LayoutInflater localLayoutInflater = LayoutInflater.from(a());
    this.e = localLayoutInflater.inflate(2130903942, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false);
    this.e.findViewById(2131233084).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232379));
    EditText localEditText = (EditText)this.e.findViewById(2131233085);
    localEditText.setFocusableInTouchMode(false);
    localEditText.setOnClickListener(this);
    localEditText.setCursorVisible(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localLayoutInflater.inflate(2130903323, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setTranscriptMode(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setContentBackground(2130837729);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollListener(this);
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a()) {}
  }
  
  private void m()
  {
    long l = System.currentTimeMillis();
    a().getSharedPreferences("rec_last_troop_list_refresh_time", 0).edit().putLong("rec_last_troop_list_refresh_time", l).commit();
  }
  
  protected Dialog a()
  {
    return new elu(this, a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a());
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
    a(2130903458);
    l();
    k();
    a(this.jdField_a_of_type_Elw);
    a(this.jdField_a_of_type_Elx);
    a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    a(this.jdField_a_of_type_Ely);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a())
    {
      this.jdField_a_of_type_Int = 6;
      return;
    }
    this.jdField_a_of_type_Int = 1;
  }
  
  public void a(TroopInfo paramTroopInfo, int paramInt)
  {
    if (paramTroopInfo != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a()) {
        break label168;
      }
      ForwardOperations localForwardOperations = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a();
      if (localForwardOperations != null) {
        localForwardOperations.a(paramTroopInfo.troopuin, 1, "", paramTroopInfo.troopname);
      }
      switch (paramInt)
      {
      case 2: 
      case 4: 
      case 6: 
      default: 
        paramInt = 0;
      }
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "choose_grp", "turn", 0, 0, paramTroopInfo.troopuin + "", String.valueOf(paramInt), "", "");
      return;
      paramInt = 0;
      continue;
      paramInt = 1;
      continue;
      paramInt = 2;
      continue;
      paramInt = 3;
    }
    switch (paramInt)
    {
    case 2: 
    case 4: 
    case 6: 
    default: 
      label168:
      paramInt = 0;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "choose_grp", "grplist", 0, 0, paramTroopInfo.troopuin + "", String.valueOf(paramInt), "", "");
      a(paramTroopInfo.troopuin, paramTroopInfo.troopname);
      return;
      paramInt = 0;
      continue;
      paramInt = 1;
      continue;
      paramInt = 2;
      continue;
      paramInt = 3;
    }
  }
  
  void a(String paramString1, String paramString2)
  {
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
      b(2131562097);
    }
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2 == null) {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a()) {
        break label85;
      }
    }
    label85:
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2 = new TroopListAdapter2(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, i, false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollGroupFloatingListener(new elt(this));
      this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.notifyDataSetChanged();
      return;
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(a());
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  protected void h()
  {
    super.h();
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2 != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.b();
    }
    b(this.jdField_a_of_type_Elw);
    b(this.jdField_a_of_type_Elx);
    b(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    b(this.jdField_a_of_type_Ely);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopView
 * JD-Core Version:    0.7.0.1
 */