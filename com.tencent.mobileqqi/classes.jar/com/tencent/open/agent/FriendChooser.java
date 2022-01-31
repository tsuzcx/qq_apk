package com.tencent.open.agent;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.agent.datamodel.FriendDataManager;
import com.tencent.open.agent.datamodel.ImageLoader.ImageLoadListener;
import com.tencent.widget.XListView;
import hix;
import hiy;
import hiz;
import hja;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class FriendChooser
  extends BaseActivity
  implements View.OnClickListener, Animation.AnimationListener, ImageLoader.ImageLoadListener
{
  protected static final int a = 0;
  public static final String a = "RESULT_BUDDIES_SELECTED";
  protected static final int b = 1;
  public static final String b = "BuddiesSelected";
  protected static final int c = 100;
  protected float a;
  final Handler a;
  protected View a;
  protected ViewStub a;
  protected AlphaAnimation a;
  protected TranslateAnimation a;
  public InputMethodManager a;
  protected Button a;
  public EditText a;
  public GridView a;
  public HorizontalScrollView a;
  protected ImageButton a;
  protected ImageView a;
  protected LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  public InnerFrameManager a;
  public FriendChooser.GridViewAdapter a;
  protected FriendChooser.SearchResultAdapter a;
  public FriendDataManager a;
  protected XListView a;
  protected ArrayList a;
  public List a;
  public boolean a;
  protected View b;
  protected TranslateAnimation b;
  protected Button b;
  protected TextView b;
  public ArrayList b;
  protected View c;
  protected Button c;
  protected TextView c;
  protected String c;
  public int d;
  protected TextView d;
  protected String d;
  protected int e;
  protected TextView e;
  protected String e;
  
  public FriendChooser()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = null;
    this.jdField_d_of_type_Int = 99999;
    this.jdField_e_of_type_Int = 99999;
    this.jdField_a_of_type_AndroidOsHandler = new hja(this);
  }
  
  protected void a(Friend paramFriend)
  {
    boolean bool;
    if (this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(paramFriend.a))
    {
      bool = false;
      this.jdField_b_of_type_JavaUtilArrayList.remove(paramFriend);
      this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.b(paramFriend.a);
    }
    for (;;)
    {
      b(bool);
      i();
      return;
      if (this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.c() >= this.jdField_d_of_type_Int)
      {
        l();
        return;
      }
      bool = true;
      this.jdField_b_of_type_JavaUtilArrayList.add(paramFriend);
      this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(paramFriend.a);
    }
  }
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramString.equals("")) || (paramString.trim().length() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentOpenAgentFriendChooser$SearchResultAdapter.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.jdField_a_of_type_JavaUtilList.clear();
      Object localObject = ((OpenFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).a();
      if (localObject != null)
      {
        paramString = paramString.toLowerCase();
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Friend localFriend = (Friend)((Iterator)localObject).next();
          if ((paramString.equals(localFriend.jdField_e_of_type_JavaLangString)) || (paramString.equals(localFriend.f)) || (paramString.equals(localFriend.jdField_c_of_type_JavaLangString)) || (paramString.equals(localFriend.b))) {
            localArrayList1.add(localFriend);
          } else if (((localFriend.jdField_c_of_type_JavaLangString != null) && (localFriend.jdField_c_of_type_JavaLangString.indexOf(paramString) >= 0)) || ((localFriend.b != null) && (localFriend.b.indexOf(paramString) >= 0)) || (localFriend.jdField_e_of_type_JavaLangString.indexOf(paramString) >= 0) || (localFriend.f.indexOf(paramString) >= 0)) {
            localArrayList2.add(localFriend);
          }
        }
        Collections.sort(localArrayList2, new FriendChooser.MyComparator(this));
        this.jdField_a_of_type_JavaUtilList.addAll(localArrayList1);
        this.jdField_a_of_type_JavaUtilList.addAll(localArrayList2);
      }
      if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      } else {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentOpenAgentFriendChooser$SearchResultAdapter.notifyDataSetChanged();
  }
  
  protected void a(boolean paramBoolean)
  {
    int i = this.jdField_b_of_type_JavaUtilArrayList.size();
    if (i <= 1) {}
    for (String str = this.jdField_d_of_type_JavaLangString; paramBoolean; str = MessageFormat.format(this.jdField_e_of_type_JavaLangString, new Object[] { Integer.valueOf(i) }))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setText(str);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setText(str);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(4);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    if (paramBoolean1)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString1);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      IphoneTitleBarActivity.b(this.jdField_b_of_type_AndroidWidgetTextView);
      if (!paramBoolean2) {
        break label76;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      break;
      label76:
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaUtilArrayList.size() + "/" + this.jdField_d_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(this.jdField_b_of_type_JavaUtilArrayList.size());
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams();
    localLayoutParams.width = ((int)((this.jdField_b_of_type_JavaUtilArrayList.size() * 36 + this.jdField_b_of_type_JavaUtilArrayList.size() * 10) * this.jdField_a_of_type_Float));
    this.jdField_a_of_type_AndroidWidgetGridView.setLayoutParams(localLayoutParams);
    if (this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.c() == this.jdField_d_of_type_Int) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    for (;;)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 200L);
      }
      this.jdField_a_of_type_ComTencentOpenAgentFriendChooser$GridViewAdapter.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  protected boolean b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0))
    {
      j();
      return true;
    }
    switch (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a())
    {
    default: 
      return super.b();
    }
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0);
    return true;
  }
  
  public abstract String c();
  
  protected void d()
  {
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131232158);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131231376));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131231456));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131231457));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131231380));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131232157));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)super.findViewById(2131232163));
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager = ((InnerFrameManager)super.findViewById(2131232159));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)super.findViewById(2131232165));
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)super.findViewById(2131232167));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131232170));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131232169));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131232166));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131232168));
  }
  
  protected void e()
  {
    this.jdField_c_of_type_JavaLangString = super.getString(2131562456);
    this.jdField_d_of_type_JavaLangString = super.getString(2131560046);
    this.jdField_e_of_type_JavaLangString = super.getString(2131560046);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(2131560039);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  @SuppressLint({"NewApi"})
  protected void f()
  {
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_ComTencentOpenAgentFriendChooser$GridViewAdapter = new FriendChooser.GridViewAdapter(this);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentOpenAgentFriendChooser$GridViewAdapter);
    this.jdField_a_of_type_AndroidWidgetGridView.setSmoothScrollbarEnabled(false);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_d_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetButton.setText(this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(new hix(this));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager == null) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)super.getSystemService("input_method"));
    }
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.jdField_a_of_type_AndroidViewView.getHeight());
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, this.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight() + this.jdField_a_of_type_AndroidViewView.getHeight());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.toggleSoftInput(0, 0);
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected void h()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewStub.inflate());
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131233087));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131233088));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131233086));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131231401);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131231402));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131231403);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new FriendChooser.SearchTextWatcher(this));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130837729);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_a_of_type_ComTencentOpenAgentFriendChooser$SearchResultAdapter = new FriendChooser.SearchResultAdapter(this, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentOpenAgentFriendChooser$SearchResultAdapter);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new hiy(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new hiz(this));
  }
  
  public void i()
  {
    this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaUtilArrayList.size() + "/" + this.jdField_d_of_type_Int);
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
    {
      a(true);
      return;
    }
    a(false);
  }
  
  protected void j()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -this.jdField_a_of_type_AndroidViewView.getHeight(), 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected abstract void k();
  
  public abstract void l();
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation)
    {
      paramAnimation = new FrameLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramAnimation);
    }
    while (paramAnimation != this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      h();
    }
    this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_b_of_type_AndroidWidgetTextView) {
      b();
    }
    do
    {
      return;
      if (paramView == this.jdField_d_of_type_AndroidWidgetTextView)
      {
        super.finish();
        return;
      }
      if (paramView == this.jdField_b_of_type_AndroidWidgetButton)
      {
        k();
        return;
      }
      if (paramView == this.jdField_a_of_type_AndroidWidgetImageButton)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setText("");
        this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 0);
        return;
      }
      if (paramView == this.jdField_c_of_type_AndroidWidgetButton)
      {
        j();
        return;
      }
    } while (paramView != this.jdField_b_of_type_AndroidViewView);
    j();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setTheme(2131624539);
    super.requestWindowFeature(1);
    super.setContentView(2130903343);
    OpenAppClient.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager = FriendDataManager.a();
    d();
    e();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(this);
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.setAppIntf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0);
    f();
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    ChnToSpell.a(this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.d();
    if (this.jdField_a_of_type_ComTencentOpenAgentFriendChooser$SearchResultAdapter != null) {
      this.jdField_a_of_type_ComTencentOpenAgentFriendChooser$SearchResultAdapter = null;
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.b();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a();
  }
  
  protected void onStart()
  {
    super.onStart();
    getWindow().setSoftInputMode(16);
  }
  
  protected void onStop()
  {
    super.onStop();
    super.getWindow().setSoftInputMode(48);
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.agent.FriendChooser
 * JD-Core Version:    0.7.0.1
 */