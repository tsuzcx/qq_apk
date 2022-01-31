package com.tencent.mobileqq.qcall;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.widget.XListView;
import gfk;
import gfn;
import gfp;
import gfq;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class QCallDetailActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, Observer
{
  private static final String jdField_a_of_type_JavaLangString = "0X8004069";
  private static final String jdField_b_of_type_JavaLangString = "0X8004068";
  private static final String jdField_c_of_type_JavaLangString = "QCallDetailActivity";
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new gfk(this);
  private Friends jdField_a_of_type_ComTencentMobileqqDataFriends;
  private QCallFacade jdField_a_of_type_ComTencentMobileqqQcallQCallFacade;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private gfq jdField_a_of_type_Gfq;
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString;
  private String e;
  private String f;
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "999";
    case 0: 
      return "0";
    case 1004: 
      return "1";
    case 2: 
      return "2";
    }
    return "3";
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      finish();
      return;
    }
    this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    this.e = paramIntent.getStringExtra("troop_uin");
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", 0);
    this.f = paramIntent.getStringExtra("uinname");
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null)) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
  
  private void d()
  {
    ThreadManager.b(new gfn(this));
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(this).inflate(2130903551, null));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131232301));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131231000));
    this.c = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131232615));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131232895));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131232896));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131232898));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131232901));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131232897);
    int i = getResources().getColor(2131362046);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(i);
    if (this.jdField_a_of_type_Int == 3000)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, 101, this.jdField_d_of_type_JavaLangString));
      localObject = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (localObject != null)
      {
        i = ((FriendManager)localObject).c(this.jdField_d_of_type_JavaLangString);
        if (i <= 0) {
          break label321;
        }
      }
    }
    label321:
    for (Object localObject = "(" + i + ")";; localObject = "")
    {
      this.c.setText((CharSequence)localObject);
      for (;;)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.f);
        localObject = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131232900);
        ((TextView)localObject).setContentDescription(getString(2131558469));
        ((TextView)localObject).setOnClickListener(this);
        f();
        return;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_d_of_type_JavaLangString));
      }
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataFriends = ((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(this.jdField_d_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqDataFriends != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType == 68104) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType == 65805))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    else {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 2) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 3) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 4) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 1))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 2)
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131563049);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 3)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131561566);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 4)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131561568);
        return;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838736);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131563051);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void g()
  {
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131232890);
    TextView localTextView1 = (TextView)localLinearLayout.findViewById(2131233040);
    localLinearLayout.setOnClickListener(this);
    localLinearLayout = (LinearLayout)findViewById(2131232888);
    TextView localTextView2 = (TextView)localLinearLayout.findViewById(2131233040);
    localLinearLayout.setOnClickListener(this);
    findViewById(2131232889).setBackgroundColor(getResources().getColor(2131362046));
    if (this.jdField_a_of_type_Int == 3000)
    {
      localTextView1.setText(2131561795);
      localTextView1.setContentDescription(getString(2131558428));
      localTextView1.setCompoundDrawablesWithIntrinsicBounds(2130839001, 0, 0, 0);
      localTextView2.setText(2131563190);
      localTextView2.setContentDescription(getString(2131558467));
      localTextView2.setCompoundDrawablesWithIntrinsicBounds(2130838995, 0, 0, 0);
      return;
    }
    localTextView1.setText(2131563190);
    localTextView1.setContentDescription(getString(2131558467));
    localTextView1.setCompoundDrawablesWithIntrinsicBounds(2130838995, 0, 0, 0);
    localTextView2.setText(2131563173);
    localTextView2.setContentDescription(getString(2131558468));
    localTextView2.setCompoundDrawablesWithIntrinsicBounds(2130839006, 0, 0, 0);
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131232892));
    this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade = ((QCallFacade)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36));
    this.jdField_a_of_type_Gfq = new gfq(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Gfq);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903550);
    setTitle(2131561730);
    h(2131561735);
    a(getIntent());
    e();
    g();
    h();
    this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.addObserver(this);
    a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    paramBundle = (FriendListHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
    if ((this.jdField_a_of_type_Int == 0) && (!paramBundle.a()) && (!paramBundle.b())) {
      paramBundle.c(this.jdField_d_of_type_JavaLangString, false);
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    String str1;
    String str2;
    if (this.jdField_a_of_type_Int == 1006)
    {
      str1 = this.jdField_d_of_type_JavaLangString;
      str2 = null;
    }
    for (;;)
    {
      switch (paramView.getId())
      {
      default: 
        return;
        str2 = this.jdField_d_of_type_JavaLangString;
        str1 = null;
      }
    }
    finish();
    return;
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_d_of_type_JavaLangString, "Two_call", "Tc_msg_dinfo", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.a(this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Int);
    a(true);
    this.jdField_a_of_type_Gfq.a.clear();
    this.jdField_a_of_type_Gfq.notifyDataSetChanged();
    return;
    if (this.jdField_a_of_type_Int == 3000)
    {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004069", "0X8004069", 0, 0, "", "", "", "");
      paramView = new Intent(this, ChatActivity.class);
      paramView.putExtra("uin", this.jdField_d_of_type_JavaLangString);
      paramView.putExtra("uintype", this.jdField_a_of_type_Int);
      paramView.putExtra("uinname", this.f);
      paramView.putExtra("entrance", 0);
      startActivity(paramView);
      return;
    }
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_d_of_type_JavaLangString, "Two_call", "Two_call_launch", 0, 0, "15", a(this.jdField_a_of_type_Int), "", "");
    ChatActivityUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_Int, str2, this.f, str1, true, this.e, true, true, null, "");
    return;
    if (this.jdField_a_of_type_Int == 3000)
    {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004068", "0X8004068", 0, 0, "", "", "", "");
      ChatActivityUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, str2, true, true, null);
      return;
    }
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_d_of_type_JavaLangString, "Two_video_call", "Tvc_msg_info_launch", 0, 0, "", "", "", "");
    ChatActivityUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_Int, str2, this.f, str1, false, this.e, true, true, null, "");
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Gfq.a = null;
    this.jdField_a_of_type_Gfq = null;
    this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.deleteObserver(this);
    b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  protected void onResume()
  {
    super.onResume();
    d();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    int k = 0;
    if (this.jdField_a_of_type_Gfq == null) {}
    label10:
    do
    {
      break label10;
      do
      {
        return;
      } while ((paramObservable == null) || (!(paramObservable instanceof QCallFacade)) || (paramObject == null) || (!(paramObject instanceof List)));
      paramObservable = (List)paramObject;
    } while ((paramObservable.isEmpty()) || (!(paramObservable.get(0) instanceof QCallRecord)));
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < paramObservable.size())
      {
        if (!(paramObservable.get(i) instanceof QCallRecord)) {
          break;
        }
        paramObject = (QCallRecord)paramObservable.get(i);
        if ((TextUtils.isEmpty(paramObject.friendUin)) || (!paramObject.friendUin.equals(this.jdField_d_of_type_JavaLangString)) || (paramObject.uinType != this.jdField_a_of_type_Int)) {
          break label157;
        }
        j = 1;
      }
      if (j == 0) {
        break;
      }
      runOnUiThread(new gfp(this, paramObservable));
      return;
      label157:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallDetailActivity
 * JD-Core Version:    0.7.0.1
 */