package com.tencent.mobileqq.activity.voip;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.statistics.ReportController;
import eyc;
import eyd;

public class VoipDetailActivity$VoipQQLabel
  extends FrameLayout
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean jdField_a_of_type_Boolean;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  
  public VoipDetailActivity$VoipQQLabel(VoipDetailActivity paramVoipDetailActivity, Context paramContext, AttributeSet paramAttributeSet, String paramString)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(2130904056, this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131234680));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131234679));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131234681));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131234682));
    if ((VoipDetailActivity.a().relationship == 0) || (VoipDetailActivity.a().relationship == 1) || (VoipDetailActivity.a().relationship == 4)) {}
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840403);
      }
      if ((VoipDetailActivity.a().uin != null) && (!VoipDetailActivity.a().uin.equals("")))
      {
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131234677));
        paramContext = paramVoipDetailActivity.b.c(VoipDetailActivity.a().uin);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramContext);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new eyc(this, paramVoipDetailActivity));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new eyd(this, paramVoipDetailActivity));
      return;
    }
  }
  
  public VoipDetailActivity$VoipQQLabel(VoipDetailActivity paramVoipDetailActivity, Context paramContext, String paramString)
  {
    this(paramVoipDetailActivity, paramContext, null, paramString);
  }
  
  public void a()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void b()
  {
    boolean bool = false;
    if (VoipDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDetailActivity).jdField_a_of_type_Int == 1006)
    {
      if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDetailActivity.b, VoipDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDetailActivity))) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDetailActivity.b, "CliOper", "", VoipDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDetailActivity).jdField_a_of_type_JavaLangString, "Manage_stranger", "Manage_str_add", 0, 0, "", "", "", "");
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDetailActivity;
      localObject2 = VoipDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDetailActivity);
      String str = VoipDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDetailActivity);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDetailActivity.getIntent().getStringExtra("param_return_addr") != null) {
        bool = true;
      }
      ChatActivityUtils.a((Activity)localObject1, (SessionInfo)localObject2, str, bool);
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDetailActivity.b, "CliOper", "", "", "CallTab_external", "Book_Details", 0, 1, 0, "", "", "", "1");
    Object localObject1 = new ProfileActivity.AllInOne(VoipDetailActivity.a().uin + "", 35);
    Object localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDetailActivity, FriendProfileCardActivity.class);
    ((Intent)localObject2).putExtra("param_return_addr", VoipDetailActivity.class);
    ((Intent)localObject2).putExtra("AllInOne", (Parcelable)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDetailActivity.startActivity((Intent)localObject2);
  }
  
  public void c()
  {
    QCallRecent localQCallRecent = this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDetailActivity.a;
    int i;
    String str1;
    String str2;
    if (localQCallRecent != null)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDetailActivity.b, "CliOper", "", "", "CallTab_external", "Book_Details", 0, 1, 0, "", "1", "", "");
      i = localQCallRecent.type;
      str1 = null;
      str2 = null;
      if (i != 1006) {
        break label116;
      }
      str2 = localQCallRecent.uin;
    }
    String str3;
    String str4;
    for (;;)
    {
      str3 = localQCallRecent.troopUin;
      str4 = localQCallRecent.displayName;
      if (localQCallRecent.type != 3000) {
        break;
      }
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDetailActivity.b, this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDetailActivity.a(), str1, true, true, null);
      return;
      label116:
      str1 = localQCallRecent.uin;
    }
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDetailActivity.b, this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDetailActivity.a(), i, str1, str4, str2, false, str3, true, true, null, "from_internal");
  }
  
  public void d()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDetailActivity.b, "CliOper", "", "", "CallTab_external", "Book_Details", 0, 1, 0, "0", "", "1", "");
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDetailActivity, ChatActivity.class);
    localIntent.putExtra("PREVIOUS_WINDOW", VoipDetailActivity.class.getName());
    localIntent.putExtra("PREVIOUS_UIN", this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDetailActivity.b.a());
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDetailActivity.a.uin);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDetailActivity.a.type);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDetailActivity.a.displayName);
    this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDetailActivity.startActivity(localIntent);
  }
  
  public void setTextViewText(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.VoipDetailActivity.VoipQQLabel
 * JD-Core Version:    0.7.0.1
 */