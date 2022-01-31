package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import clf;
import clg;
import clh;
import cli;
import com.tencent.mobileqq.adapter.ForwardSelectionFriendListAdapter;
import com.tencent.mobileqq.adapter.ForwardSelectionFriendListAdapter.ViewTag;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ForwardFriendListActivity
  extends BaseForwardSelectionActivity
  implements View.OnClickListener
{
  public static final int a = 1;
  public static final String a = "extra_choose_friend";
  public static final String b = "extra_choose_friend_uin";
  private static final int jdField_c_of_type_Int = 0;
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
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private TextView d;
  
  private List a(List paramList)
  {
    if (paramList == null) {
      return paramList;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Entity localEntity = (Entity)paramList.next();
      if (((localEntity instanceof Groups)) && (((Groups)localEntity).group_id != -1006)) {
        localArrayList.add(localEntity);
      }
    }
    return localArrayList;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      return;
    }
    Contacts.a += 1;
    this.jdField_a_of_type_AndroidAppDialog = new clf(this, this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
    paramInt = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -paramInt);
    localTranslateAnimation1.setDuration(200L);
    localTranslateAnimation1.setFillAfter(true);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -paramInt, 0.0F);
    localTranslateAnimation2.setDuration(200L);
    localTranslateAnimation1.setAnimationListener(new clg(this));
    localTranslateAnimation2.setAnimationListener(new clh(this, paramInt));
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new cli(this, paramInt, localTranslateAnimation2));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(localTranslateAnimation1);
  }
  
  private void d()
  {
    e();
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView = ((PinnedHeaderExpandableListView)findViewById(2131231724));
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setContentBackground(2130837729);
    Object localObject = LayoutInflater.from(a()).inflate(2130903944, this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView, false);
    ((View)localObject).findViewById(2131233086).setVisibility(8);
    localObject = (EditText)((View)localObject).findViewById(2131233087);
    ((EditText)localObject).setFocusable(false);
    ((EditText)localObject).setOnClickListener(this);
    ((EditText)localObject).setCursorVisible(false);
    this.jdField_b_of_type_Int = getIntent().getIntExtra("extra_choose_friend", 0);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131231116));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131231374));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231376));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131559063));
    if (getSupportActionBar() != null) {
      getSupportActionBar().setTitle(this.jdField_a_of_type_AndroidWidgetTextView.getText());
    }
    this.c = ((TextView)findViewById(2131231456));
    this.c.setVisibility(0);
    this.c.setOnClickListener(this);
    this.c.setText(2131561692);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231457));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.d = ((TextView)findViewById(2131231380));
    this.d.setVisibility(0);
    this.d.setText(2131561746);
    this.d.setContentDescription("取消本次转发");
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131231461));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    IphoneTitleBarActivity.b(this.jdField_a_of_type_AndroidWidgetImageView);
    IphoneTitleBarActivity.b(this.jdField_b_of_type_AndroidWidgetTextView);
  }
  
  private void f()
  {
    c();
  }
  
  protected boolean c()
  {
    Object localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject1 = (FriendManager)((QQAppInterface)localObject1).getManager(8);
    if (localObject1 == null) {
      return false;
    }
    if (!((FriendManager)localObject1).b()) {
      return false;
    }
    localObject1 = a(((FriendManager)localObject1).c());
    localObject2 = new ArrayList();
    QQAppInterface localQQAppInterface;
    if (this.jdField_b_of_type_Int == 1)
    {
      localObject3 = new Groups();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        ForwardSelectionFriendListAdapter.b(-1008);
        ((Groups)localObject3).group_id = ForwardSelectionFriendListAdapter.b();
        ((Groups)localObject3).group_name = getResources().getString(2131559064);
        ((List)localObject2).add(0, localObject3);
        ((List)localObject2).addAll((Collection)localObject1);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter != null) {
        break label203;
      }
      localObject3 = this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView;
      localQQAppInterface = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.jdField_b_of_type_Int != 1) {
        break label198;
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
      label198:
      localObject2 = localObject1;
    }
    label203:
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
    setContentView(2130903238);
    d();
    f();
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
    case 2131233087: 
      if (this.jdField_b_of_type_Int == 1)
      {
        a(12);
        return;
      }
      a(8);
      return;
    case 2131231456: 
      finish();
      return;
    case 2131231380: 
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.u == 11))
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
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.u == 1001) && (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.v == 13))
      {
        if (Utils.b(((Friends)localObject).uin))
        {
          QQToast.a(this, 1, getResources().getString(2131559065), 0).b(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight());
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
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      if (this.jdField_b_of_type_Int == 1) {
        a(12);
      } else {
        a(8);
      }
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    paramMenu.clear();
    MenuItem localMenuItem = paramMenu.add(0, 0, 0, getString(2131562830));
    localMenuItem.setIcon(2130839698);
    MenuItemCompat.setShowAsAction(localMenuItem, 1);
    return super.onPrepareOptionsMenu(paramMenu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardFriendListActivity
 * JD-Core Version:    0.7.0.1
 */