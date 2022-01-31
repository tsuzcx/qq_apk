package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cog;
import coh;
import coi;
import cok;
import col;
import com;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.ViewHolder;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import coo;
import cop;
import coq;
import cor;
import cos;
import cot;
import cou;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DiscussionMemberActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, View.OnTouchListener, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener, AdapterView.OnItemClickListener
{
  private final int jdField_a_of_type_Int = 1;
  public View a;
  public EditText a;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  public PinnedDividerListView a;
  public XListView a;
  private cor jdField_a_of_type_Cor;
  public cot a;
  private String jdField_a_of_type_JavaLangString;
  public List a;
  private View jdField_b_of_type_AndroidViewView;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  private String jdField_b_of_type_JavaLangString;
  private List jdField_b_of_type_JavaUtilList = new ArrayList();
  private View c;
  private View d;
  
  public DiscussionMemberActivity()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131234428));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131234429));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131361815);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131230734));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setTextView(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.jdField_b_of_type_AndroidViewView = new View(this);
    this.jdField_a_of_type_AndroidViewView = new View(this);
    setTitle(getString(2131559054));
    Object localObject = (LinearLayout)getLayoutInflater().inflate(2130903942, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    ((LinearLayout)localObject).setPadding(0, 0, 40, 0);
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)((LinearLayout)localObject).findViewById(2131233085));
    this.jdField_b_of_type_AndroidWidgetEditText.setFocusable(false);
    this.jdField_b_of_type_AndroidWidgetEditText.setOnTouchListener(this);
    ((Button)((LinearLayout)localObject).findViewById(2131233084)).setVisibility(8);
    this.d = getLayoutInflater().inflate(2130903204, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    TroopMemberListActivity.ViewHolder localViewHolder = new TroopMemberListActivity.ViewHolder();
    localViewHolder.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localViewHolder.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.d.findViewById(2131231567));
    localViewHolder.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    localViewHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.d.findViewById(2131231411));
    localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e();
    TextView localTextView = localViewHolder.jdField_c_of_type_AndroidWidgetTextView;
    if ((localObject != null) && (((String)localObject).trim().length() > 0)) {}
    for (;;)
    {
      localTextView.setText((CharSequence)localObject);
      this.d.setTag(localViewHolder);
      this.d.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.a(this.d);
      return;
      localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    }
  }
  
  private void e()
  {
    FriendManager localFriendManager = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (localFriendManager != null)
    {
      Object localObject1 = localFriendManager.a(this.jdField_a_of_type_JavaLangString);
      if (localObject1 != null)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (DiscussionMemberInfo)((Iterator)localObject1).next();
          if (((DiscussionMemberInfo)localObject2).memberUin.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()))
          {
            this.jdField_b_of_type_JavaLangString = ContactUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, (DiscussionMemberInfo)localObject2);
          }
          else
          {
            coq localcoq = new coq(this, null);
            localcoq.jdField_a_of_type_JavaLangString = ((DiscussionMemberInfo)localObject2).memberUin;
            localcoq.jdField_b_of_type_JavaLangString = ContactUtils.a((DiscussionMemberInfo)localObject2, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
            localObject2 = localFriendManager.c(localcoq.jdField_a_of_type_JavaLangString);
            if (localObject2 != null) {}
            for (localcoq.jdField_a_of_type_Short = ((Friends)localObject2).faceid;; localcoq.jdField_a_of_type_Short = 0)
            {
              localcoq.jdField_d_of_type_JavaLangString = ChnToSpell.a(localcoq.jdField_b_of_type_JavaLangString, 1);
              localcoq.c = ChnToSpell.a(localcoq.jdField_b_of_type_JavaLangString, 2);
              this.jdField_a_of_type_JavaUtilList.add(localcoq);
              break;
            }
          }
        }
      }
    }
  }
  
  private void f()
  {
    Dialog localDialog = new Dialog(this);
    localDialog.setCanceledOnTouchOutside(true);
    localDialog.requestWindowFeature(1);
    localDialog.getWindow().setSoftInputMode(36);
    localDialog.setContentView(2130903945);
    Object localObject1 = localDialog.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject1).x = 0;
    ((WindowManager.LayoutParams)localObject1).y = 0;
    ((WindowManager.LayoutParams)localObject1).width = -1;
    ((WindowManager.LayoutParams)localObject1).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject1).gravity = 51;
    localDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
    int i = this.jdField_b_of_type_AndroidViewView.getHeight();
    Object localObject3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i);
    ((TranslateAnimation)localObject3).setDuration(300L);
    ((TranslateAnimation)localObject3).setFillAfter(true);
    Object localObject2 = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
    ((TranslateAnimation)localObject2).setDuration(300L);
    localObject1 = (InputMethodManager)getSystemService("input_method");
    cog localcog = new cog(this, (TranslateAnimation)localObject3, localDialog);
    ((TranslateAnimation)localObject3).setAnimationListener(localcog);
    ((TranslateAnimation)localObject2).setAnimationListener(localcog);
    this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject3);
    localObject3 = new coh(this);
    a((BusinessObserver)localObject3);
    localDialog.setOnDismissListener(new coi(this, (TranslateAnimation)localObject2, (InputMethodManager)localObject1, (FriendListObserver)localObject3));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)localDialog.findViewById(2131233085));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new cou(this, null));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)localDialog.findViewById(2131233086));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new cok(this));
    localObject2 = (Button)localDialog.findViewById(2131233084);
    ((Button)localObject2).setVisibility(0);
    ((Button)localObject2).setOnClickListener(new col(this, localDialog));
    this.c = localDialog.findViewById(2131231403);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localDialog.findViewById(2131231401));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new com(this, localDialog));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localDialog.findViewById(2131234405));
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundDrawable(getResources().getDrawable(2130837729));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Cot = new cot(this, this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Cot);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new coo(this, (InputMethodManager)localObject1));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new cop(this, localDialog));
  }
  
  public void a(View paramView)
  {
    paramView = (FacePreloadBaseAdapter.ViewHolder)paramView.getTag();
    if ((paramView != null) && (paramView.jdField_a_of_type_JavaLangString != null))
    {
      paramView = paramView.jdField_a_of_type_JavaLangString;
      if (paramView.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()))
      {
        paramView = new ProfileActivity.AllInOne(paramView, 0);
        paramView.jdField_e_of_type_Int = 5;
        ProfileActivity.a(this, paramView, 1);
      }
    }
    else
    {
      return;
    }
    if (((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(paramView))
    {
      localAllInOne = new ProfileActivity.AllInOne(paramView, 1);
      localAllInOne.g = ContactUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramView, 0);
      localAllInOne.jdField_e_of_type_Int = 5;
      ProfileActivity.a(this, localAllInOne, 1);
      return;
    }
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(paramView, 46);
    localAllInOne.g = ContactUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramView, 0);
    localAllInOne.jdField_e_of_type_JavaLangString = paramView;
    localAllInOne.jdField_d_of_type_Int = 3000;
    localAllInOne.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localAllInOne.jdField_e_of_type_Int = 5;
    ProfileActivity.a(this, localAllInOne, 1);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.q() > 0) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.q() == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount() < this.jdField_a_of_type_Cor.getCount() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.k()))) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
    }
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a(paramView);
  }
  
  public void a(String paramString)
  {
    if ("$".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_Cor.a(paramString);
    } while (i == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.k());
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaUtilList.clear();
    if ((paramString.equals("")) || (paramString.trim().length() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.c.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_Cot.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        coq localcoq = (coq)localIterator.next();
        if (localcoq != null) {
          if ((localcoq.jdField_b_of_type_JavaLangString.equals(paramString)) || (localcoq.jdField_a_of_type_JavaLangString.equals(paramString)) || (localcoq.jdField_d_of_type_JavaLangString.equals(paramString.toLowerCase())) || (localcoq.c.equals(paramString.toLowerCase()))) {
            localArrayList1.add(localcoq);
          } else if ((localcoq.jdField_b_of_type_JavaLangString.indexOf(paramString) == 0) || (localcoq.jdField_a_of_type_JavaLangString.indexOf(paramString) == 0) || (localcoq.c.indexOf(paramString.toLowerCase()) == 0) || (localcoq.jdField_d_of_type_JavaLangString.indexOf(paramString.toLowerCase()) == 0)) {
            localArrayList2.add(localcoq);
          } else if ((localcoq.jdField_b_of_type_JavaLangString.indexOf(paramString) > 0) || (localcoq.jdField_a_of_type_JavaLangString.indexOf(paramString) > 0) || (localcoq.c.indexOf(paramString.toLowerCase()) > 0) || (localcoq.jdField_d_of_type_JavaLangString.indexOf(paramString.toLowerCase()) > 0)) {
            localArrayList3.add(localcoq);
          }
        }
      }
      Collections.sort(localArrayList2, new cos(this, null));
      this.jdField_b_of_type_JavaUtilList.addAll(localArrayList1);
      this.jdField_b_of_type_JavaUtilList.addAll(localArrayList2);
      this.jdField_b_of_type_JavaUtilList.addAll(localArrayList3);
      if (this.jdField_b_of_type_JavaUtilList.isEmpty()) {
        this.c.setVisibility(0);
      } else {
        this.c.setVisibility(8);
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((-1 == paramInt2) && (paramInt2 == 1)) {
      this.jdField_a_of_type_Cor.notifyDataSetChanged();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.d) {
      a(paramView);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903951);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("uin");
    d();
    e();
    ((TroopMemberListActivity.ViewHolder)this.d.getTag()).jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Cor = new cor(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Cor);
  }
  
  protected void onDestroy()
  {
    this.jdField_a_of_type_Cor.b();
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  protected void onStart()
  {
    super.onStart();
    getWindow().setSoftInputMode(48);
  }
  
  protected void onStop()
  {
    super.onStop();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      f();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionMemberActivity
 * JD-Core Version:    0.7.0.1
 */