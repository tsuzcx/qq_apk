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
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.agent.datamodel.FriendDataManager;
import com.tencent.open.agent.datamodel.ImageLoader.ImageLoadListener;
import com.tencent.widget.XListView;
import fdm;
import fdn;
import fdo;
import fdp;
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
  protected ImageView b;
  protected TextView b;
  public ArrayList b;
  protected View c;
  protected Button c;
  protected TextView c;
  protected String c;
  public int d;
  protected String d;
  protected int e;
  protected String e;
  
  public FriendChooser()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = null;
    this.jdField_d_of_type_Int = 99999;
    this.jdField_e_of_type_Int = 99999;
    this.jdField_a_of_type_AndroidOsHandler = new fdp(this);
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
      g();
      return;
      if (this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.c() >= this.jdField_d_of_type_Int)
      {
        j();
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
      IphoneTitleBarActivity.setLayerType(this.jdField_b_of_type_AndroidWidgetTextView);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString2);
  }
  
  protected boolean a()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0))
    {
      h();
      return true;
    }
    switch (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a())
    {
    default: 
      return super.a();
    }
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0);
    return true;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaUtilArrayList.size() + "/" + this.jdField_d_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(this.jdField_b_of_type_JavaUtilArrayList.size());
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams();
    localLayoutParams.width = ((int)((this.jdField_b_of_type_JavaUtilArrayList.size() * 36 + this.jdField_b_of_type_JavaUtilArrayList.size() * 10) * this.jdField_a_of_type_Float));
    this.jdField_a_of_type_AndroidWidgetGridView.setLayoutParams(localLayoutParams);
    if (this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.c() == this.jdField_d_of_type_Int) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    for (;;)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 200L);
      }
      this.jdField_a_of_type_ComTencentOpenAgentFriendChooser$GridViewAdapter.notifyDataSetChanged();
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public abstract String c();
  
  protected void c()
  {
    this.jdField_c_of_type_JavaLangString = super.getString(2131363980);
    this.jdField_d_of_type_JavaLangString = super.getString(2131362135);
    this.jdField_e_of_type_JavaLangString = super.getString(2131362135);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838062);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("搜索");
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  @SuppressLint({"NewApi"})
  protected void d()
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
    this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(new fdm(this));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void e()
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
  
  protected void f()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewStub.inflate());
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297962));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297955));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131298430));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131296866);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131296867));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131296868);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new FriendChooser.SearchTextWatcher(this));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130837660);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_a_of_type_ComTencentOpenAgentFriendChooser$SearchResultAdapter = new FriendChooser.SearchResultAdapter(this, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentOpenAgentFriendChooser$SearchResultAdapter);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new fdn(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new fdo(this));
  }
  
  public void g()
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaUtilArrayList.size() + "/" + this.jdField_d_of_type_Int);
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
    {
      a(true);
      return;
    }
    a(false);
  }
  
  protected void h()
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
  
  protected abstract void i();
  
  public abstract void j();
  
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
      f();
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
      a();
    }
    do
    {
      return;
      if (paramView == this.jdField_b_of_type_AndroidWidgetButton)
      {
        i();
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
        h();
        return;
      }
      if (paramView == this.jdField_b_of_type_AndroidViewView)
      {
        h();
        return;
      }
    } while (paramView != this.jdField_a_of_type_AndroidWidgetImageView);
    e();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setTheme(2131624276);
    super.requestWindowFeature(1);
    super.setContentView(2130903286);
    this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager = FriendDataManager.a();
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131297507);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131296892));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131296898));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131296903));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131297506));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)super.findViewById(2131297512));
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager = ((InnerFrameManager)super.findViewById(2131297508));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)super.findViewById(2131297514));
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)super.findViewById(2131297516));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131297519));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131297518));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297515));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131297517));
    c();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(this);
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.setAppIntf(this.app);
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0);
    d();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.open.agent.FriendChooser
 * JD-Core Version:    0.7.0.1
 */