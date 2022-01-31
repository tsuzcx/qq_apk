package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cch;
import cci;
import cck;
import ccl;
import com.tencent.mobileqq.activity.BaseForwardSelectionActivity;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.Observable;
import java.util.Observer;

public class NewFriendActivity
  extends BaseForwardSelectionActivity
  implements View.OnClickListener, Observer
{
  public static final int a = 0;
  public static final String a = "_key_mode";
  public static final int b = 1;
  public static final String b = "enter_cricle_view";
  static final boolean jdField_b_of_type_Boolean = true;
  public static final int c = 2;
  private static final String jdField_c_of_type_JavaLangString = "NewFriendManager";
  public static final int d = 3;
  private static final String jdField_d_of_type_JavaLangString = "newfriend_";
  public static final int e = 0;
  public static final int f = -1000;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  public RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseNewFriendView.INewFriendContext jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext;
  private BaseNewFriendView jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView;
  private SystemMsgListView jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  boolean jdField_c_of_type_Boolean;
  boolean jdField_d_of_type_Boolean;
  private int g = 0;
  private int h = 0;
  private int i = 3;
  private int j;
  
  private int a()
  {
    return getSharedPreferences("newfriend_" + this.app.a(), 0).getInt("_key_mode", -1000);
  }
  
  private void a(int paramInt)
  {
    getSharedPreferences("newfriend_" + this.app.a(), 0).edit().putInt("_key_mode", paramInt).commit();
  }
  
  private void a(boolean paramBoolean)
  {
    NewFriendManager localNewFriendManager = (NewFriendManager)this.app.getManager(31);
    if (paramBoolean)
    {
      this.app.a().addObserver(this);
      localNewFriendManager.addObserver(this);
    }
    do
    {
      return;
      localNewFriendManager.deleteObserver(this);
    } while (this.app.a() == null);
    this.app.a().deleteObserver(this);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = getWindow().getDecorView().findViewById(2131296564);
        } while (localObject == null);
        localObject = ((View)localObject).getParent();
      } while ((localObject == null) || (!(localObject instanceof FrameLayout)));
      localObject = (FrameLayout)localObject;
      if (paramBoolean1) {
        ((FrameLayout)localObject).addView(this.jdField_a_of_type_AndroidViewView, new FrameLayout.LayoutParams(-1, -1));
      }
    } while (!paramBoolean2);
    ((FrameLayout)localObject).removeView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.b.setCompoundDrawablePadding(this.j);
      this.b.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      return true;
    }
    return false;
  }
  
  private boolean d()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130837914);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = this.b.getCompoundDrawables();
      this.j = this.b.getCompoundDrawablePadding();
      this.b.setCompoundDrawablePadding(10);
      this.b.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      bool = true;
    }
    return bool;
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext = new cch(this);
  }
  
  private void f()
  {
    setContentView(2130903523);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296564));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131297596));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131297145));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296895));
    this.b = ((TextView)findViewById(2131296901));
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296906));
    this.c = ((TextView)findViewById(2131296905));
    c();
    this.i = 3;
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText());
      if (this.jdField_a_of_type_Boolean) {
        this.c.setContentDescription("取消本次转发");
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131363498));
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText("新朋友");
      this.b.setText("新朋友");
      a(true);
      this.c.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838044);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ccl(this));
    }
  }
  
  View a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView;
  }
  
  void a(BaseNewFriendView paramBaseNewFriendView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView != paramBaseNewFriendView)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView != null)
      {
        if (isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView.f();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView.g();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView = paramBaseNewFriendView;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView.d();
        if (isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView.e();
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView);
      }
    }
  }
  
  void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView = new SystemMsgListView(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.a(getIntent(), this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext);
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView);
  }
  
  public void d()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(getString(2131363251), 0, false);
    localActionSheet.a(new cci(this, localActionSheet));
    localActionSheet.d(2131362790);
    localActionSheet.show();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void doOnBackPressed()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      getSharedPreferences(this.app.a(), 0).edit().putLong("newfriend_enter_time", System.currentTimeMillis()).commit();
    }
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    setContentView(2130903523);
    d(2130837633);
    e();
    f();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.h();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView = null;
    }
    a(false);
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
  }
  
  protected void doOnPause()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView.f();
    }
    this.d = false;
    a(this.i);
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView.e();
    }
    this.d = true;
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView.d();
    }
  }
  
  protected void doOnStop()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView.g();
    }
    super.doOnStop();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      finish();
      return;
    } while (!this.jdField_a_of_type_Boolean);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.v == 11))
    {
      ForwardOperations.a(this, false, "shareToQQ", this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a);
      com.tencent.mobileqq.app.PhoneContactManagerImp.c = false;
    }
    setResult(1);
    finish();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      int m = 1;
      int k = m;
      if ((paramObject instanceof ChatMessage))
      {
        k = m;
        if (((MessageRecord)paramObject).isSendFromLocal()) {
          k = 0;
        }
      }
      if (k != 0) {
        runOnUiThread(new cck(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity
 * JD-Core Version:    0.7.0.1
 */