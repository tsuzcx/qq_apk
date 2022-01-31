package com.tencent.mobileqq.activity;

import ame;
import amf;
import amg;
import amh;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.ForwardSelectionFriendListAdapter;
import com.tencent.mobileqq.adapter.ForwardSelectionFriendListAdapter.ViewTag;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ForwardFriendListActivity
  extends BaseForwardSelectionActivity
  implements View.OnClickListener
{
  public static final int a = 1;
  public static final String a = "extra_choose_friend";
  public static final String b = "extra_choose_friend_uin";
  public static final String c = "extra_choose_friend_name";
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  public RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ForwardSelectionFriendListAdapter jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter;
  private PinnedHeaderExpandableListView jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      return;
    }
    Contacts.a += 1;
    this.jdField_a_of_type_AndroidAppDialog = new ame(this, this, this.app, paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
    paramInt = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -paramInt);
    localTranslateAnimation1.setDuration(200L);
    localTranslateAnimation1.setFillAfter(true);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -paramInt, 0.0F);
    localTranslateAnimation2.setDuration(200L);
    localTranslateAnimation1.setAnimationListener(new amf(this));
    localTranslateAnimation2.setAnimationListener(new amg(this, paramInt));
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new amh(this, paramInt, localTranslateAnimation2));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(localTranslateAnimation1);
  }
  
  private void c()
  {
    d();
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView = ((PinnedHeaderExpandableListView)findViewById(2131297142));
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setContentBackground(2130837635);
    this.jdField_b_of_type_Int = getIntent().getIntExtra("extra_choose_friend", 0);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296564));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131297141));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296891));
    this.jdField_a_of_type_AndroidWidgetTextView.setText("选择好友");
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296897));
    this.jdField_b_of_type_AndroidWidgetTextView.setText("选择好友");
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c = ((TextView)findViewById(2131296901));
    this.c.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296902));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838043);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("搜索");
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetImageView);
  }
  
  private void e()
  {
    c();
  }
  
  protected boolean c()
  {
    Object localObject1 = this.app;
    Object localObject2 = this.app;
    localObject1 = (FriendManager)((QQAppInterface)localObject1).getManager(8);
    if (localObject1 == null) {
      return false;
    }
    if (!((FriendManager)localObject1).b()) {
      return false;
    }
    localObject1 = ((FriendManager)localObject1).c();
    localObject2 = new ArrayList();
    QQAppInterface localQQAppInterface;
    if (this.jdField_b_of_type_Int == 1)
    {
      localObject3 = new Groups();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        ForwardSelectionFriendListAdapter.b(-1008);
        ((Groups)localObject3).group_id = ForwardSelectionFriendListAdapter.b();
        ((Groups)localObject3).group_name = "最近联系人";
        ((List)localObject2).add(0, localObject3);
        ((List)localObject2).addAll((Collection)localObject1);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter != null) {
        break label191;
      }
      localObject3 = this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView;
      localQQAppInterface = this.app;
      if (this.jdField_b_of_type_Int != 1) {
        break label186;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter = new ForwardSelectionFriendListAdapter(this, (ExpandableListView)localObject3, localQQAppInterface, (List)localObject2, this);
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter);
      return true;
      ForwardSelectionFriendListAdapter.b(0);
      ((Groups)localObject3).group_id = ForwardSelectionFriendListAdapter.b();
      break;
      label186:
      localObject2 = localObject1;
    }
    label191:
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter;
    if (this.jdField_b_of_type_Int == 1) {}
    for (;;)
    {
      ((ForwardSelectionFriendListAdapter)localObject3).a((List)localObject2, true);
      break;
      localObject2 = localObject1;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawable(null);
    setContentView(2130903203);
    c();
    e();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter.a();
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setAdapter((PinnedHeaderExpandableListView.ExpandableListAdapter)null);
    }
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    case 2131296898: 
    case 2131296899: 
    case 2131296900: 
    default: 
      localObject = (ForwardSelectionFriendListAdapter.ViewTag)paramView.getTag();
      if (localObject != null)
      {
        localObject = ((ForwardSelectionFriendListAdapter.ViewTag)localObject).a;
        if ((localObject != null) && ((localObject instanceof Friends)))
        {
          localObject = (Friends)localObject;
          if ((this.jdField_b_of_type_Int != 1) || (localObject == null)) {
            break;
          }
          paramView = new Intent();
          paramView.putExtra("extra_choose_friend_uin", ((Friends)localObject).uin);
          paramView.putExtra("extra_choose_friend_name", ((Friends)localObject).name);
          setResult(-1, paramView);
          finish();
        }
      }
      return;
    case 2131296902: 
      if (this.jdField_b_of_type_Int == 1)
      {
        a(12);
        return;
      }
      a(8);
      return;
    case 2131296897: 
      finish();
      return;
    case 2131296901: 
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.v == 11))
      {
        ForwardOperations.a(this, false, "shareToQQ", this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a);
        com.tencent.mobileqq.app.PhoneContactManagerImp.c = false;
      }
      setResult(1);
      finish();
      return;
    }
    paramView = (TextView)paramView.findViewById(16908308);
    if (paramView != null) {
      if (paramView.getText() != null) {
        paramView = paramView.getText().toString();
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.v == 1001) && (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.w == 13))
      {
        if (Utils.b(((Friends)localObject).uin))
        {
          QQToast.a(this, 1, "不能送书给此类好友", 0).b(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight());
          return;
          paramView = null;
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a(((Friends)localObject).uin, -1, "", "");
        }
      }
      else
      {
        setResult(1);
        this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a(((Friends)localObject).uin, 0, ((Friends)localObject).uin, paramView);
        return;
        paramView = "Ta";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardFriendListActivity
 * JD-Core Version:    0.7.0.1
 */