package com.tencent.mobileqq.activity.recent;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.voip.VoipAddressBookActivity;
import com.tencent.mobileqq.activity.voip.VoipHistoryActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.sharealbum.QZoneShareAlbumAssistantItemData;
import com.tencent.mobileqq.sharealbum.QZoneShareAlbumAssistantManager;
import com.tencent.mobileqq.statistics.ReportController;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import eov;
import eow;

public class RecentOptionBar
{
  protected static final int[] a;
  protected static final int[] b;
  protected static final int[] c;
  protected static final int[] d;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new eow(this);
  private View jdField_a_of_type_AndroidViewView;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new eov(this);
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private View jdField_b_of_type_AndroidViewView;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  private View c;
  private View d;
  private View e;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131231436, 2131231437, 2131231438, 2131231439 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130837914, 2130837912, 2130837918, 2130837916 };
    jdField_c_of_type_ArrayOfInt = new int[] { 2131562415, 2131561857, 2131562912, 2131562815 };
    jdField_d_of_type_ArrayOfInt = new int[] { 2131558440, 2131558441, 2131558442, 2131558443 };
  }
  
  public RecentOptionBar(View paramView1, BaseActivity paramBaseActivity, View paramView2)
  {
    this.jdField_d_of_type_AndroidViewView = paramView2;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    a(paramView1, paramBaseActivity);
  }
  
  private void a(View paramView, BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131231433);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131231434);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131231435);
    int i = 0;
    if (i < 4)
    {
      paramView = (LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(jdField_a_of_type_ArrayOfInt[i]);
      if (paramView == null) {}
      for (;;)
      {
        i += 1;
        break;
        paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        Object localObject = (ImageView)paramView.findViewById(2131231440);
        if (localObject != null) {
          ((ImageView)localObject).setImageResource(jdField_b_of_type_ArrayOfInt[i]);
        }
        localObject = (TextView)paramView.findViewById(2131231441);
        if (localObject != null) {
          ((TextView)localObject).setText(jdField_c_of_type_ArrayOfInt[i]);
        }
        paramView.setContentDescription(paramBaseActivity.getString(jdField_d_of_type_ArrayOfInt[i]));
      }
    }
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(paramBaseActivity, 2130968628);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(paramBaseActivity, 2130968626);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.e = paramBaseActivity.findViewById(2131231914);
    this.e.setVisibility(8);
  }
  
  public void a()
  {
    this.jdField_d_of_type_AndroidViewView.setSelected(true);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.startAnimation(AnimationUtils.loadAnimation(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130968627));
    this.jdField_c_of_type_AndroidViewView.startAnimation(AnimationUtils.loadAnimation(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130968625));
    this.e.setVisibility(0);
    this.e.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.e.startAnimation(AnimationUtils.loadAnimation(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130968625));
  }
  
  public void a(boolean paramBoolean)
  {
    if (a())
    {
      if (paramBoolean)
      {
        this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
        this.jdField_c_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
        this.e.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
        this.jdField_d_of_type_AndroidViewView.setSelected(false);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.e.setVisibility(8);
    this.e.setOnClickListener(null);
    this.jdField_d_of_type_AndroidViewView.setSelected(false);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidViewView.getVisibility() == 0;
  }
  
  public void b()
  {
    Object localObject = QZoneShareAlbumAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b);
    String str2 = "";
    String str1 = "";
    if (localObject != null)
    {
      str2 = ((QZoneShareAlbumAssistantItemData)localObject).albumID;
      str1 = ((QZoneShareAlbumAssistantItemData)localObject).albumName;
    }
    localObject = QZoneHelper.UserInfo.a();
    ((QZoneHelper.UserInfo)localObject).a = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b.a();
    ((QZoneHelper.UserInfo)localObject).b = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b.e();
    ((QZoneHelper.UserInfo)localObject).c = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b.getSid();
    QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (QZoneHelper.UserInfo)localObject, str2, str1, 0);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.e(false);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b, "CliOper", "", "", "0X8004076", "0X8004076", 0, 0, "", "", "", "");
  }
  
  public void c()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1003);
    localIntent.putExtra("param_title", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131562415));
    localIntent.putExtra("param_done_button_wording", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131562548));
    localIntent.putExtra("param_done_button_highlight_wording", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131562967));
    localIntent.putExtra("param_max", 49);
    localIntent.putExtra("multi_chat", true);
    localIntent.setFlags(603979776);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, 1300);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b, "CliOper", "", "", "0X8004074", "0X8004074", 0, 0, "", "", "", "");
  }
  
  public void d()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ScannerActivity.class);
    localIntent.putExtra("from", "Conversation");
    localIntent.setFlags(67108864);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b, "CliOper", "", "", "0X8004077", "0X8004077", 0, 0, "", "", "", "");
  }
  
  public void e()
  {
    if (((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b.getManager(10)).b() >= 7)
    {
      int i = VoipHistoryActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext());
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b, "CliOper", "", "", "CallTab_external", "click_CallTab", 0, 1, 0, String.valueOf(i), "", "", "");
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, VoipHistoryActivity.class);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getBaseContext();
    localObject = ((BaseActivity)localObject).getSharedPreferences("VOIP_share", 0);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("voip_firstuse", 1);
      ((SharedPreferences.Editor)localObject).commit();
    }
    localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, VoipAddressBookActivity.class);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
  }
  
  protected void f()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1003);
    localIntent.putExtra("param_title", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131561857));
    localIntent.putExtra("param_done_button_wording", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131562539));
    localIntent.putExtra("param_done_button_highlight_wording", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131562550));
    localIntent.putExtra("param_entrance", 10);
    localIntent.putExtra("param_max", 49);
    localIntent.setFlags(603979776);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, 1400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentOptionBar
 * JD-Core Version:    0.7.0.1
 */