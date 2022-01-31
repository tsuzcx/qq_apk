package com.tencent.mobileqq.activity;

import aje;
import ajf;
import ajg;
import ajh;
import ajj;
import ajk;
import ajl;
import ajm;
import ajn;
import ajo;
import ajp;
import ajq;
import ajr;
import ajs;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DiscussionMemberActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener, AdapterView.OnItemClickListener
{
  private final int jdField_a_of_type_Int = 1;
  private ajp jdField_a_of_type_Ajp;
  public ajr a;
  public View a;
  public EditText a;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  public PinnedDividerListView a;
  public XListView a;
  private String jdField_a_of_type_JavaLangString;
  public List a;
  private View jdField_b_of_type_AndroidViewView;
  private String jdField_b_of_type_JavaLangString;
  private List jdField_b_of_type_JavaUtilList = new ArrayList();
  private View c;
  private View d;
  
  public DiscussionMemberActivity()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131298716));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131298717));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131427345);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.jdField_b_of_type_AndroidViewView = ((View)findViewById(2131296890).getParent());
    this.jdField_a_of_type_AndroidViewView = ((View)this.jdField_b_of_type_AndroidViewView.getParent());
    setTitle("讨论组成员");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296902));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("搜索");
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838043);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aje(this));
    this.d = getLayoutInflater().inflate(2130903177, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    TroopMemberListActivity.ViewHolder localViewHolder = new TroopMemberListActivity.ViewHolder();
    localViewHolder.jdField_a_of_type_JavaLangString = this.app.a();
    localViewHolder.b = ((ImageView)this.d.findViewById(2131297011));
    localViewHolder.b.setBackgroundDrawable(this.app.b(this.app.a()));
    localViewHolder.c = ((TextView)this.d.findViewById(2131296875));
    String str = this.app.c();
    TextView localTextView = localViewHolder.c;
    if ((str != null) && (str.trim().length() > 0)) {}
    for (;;)
    {
      localTextView.setText(str);
      this.d.setTag(localViewHolder);
      this.d.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.a(this.d);
      return;
      str = this.app.a();
    }
  }
  
  private void d()
  {
    FriendManager localFriendManager = (FriendManager)this.app.getManager(8);
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
          if (((DiscussionMemberInfo)localObject2).memberUin.equals(this.app.a()))
          {
            this.jdField_b_of_type_JavaLangString = ContactUtils.a(this.app, (DiscussionMemberInfo)localObject2);
          }
          else
          {
            ajo localajo = new ajo(this, null);
            localajo.jdField_a_of_type_JavaLangString = ((DiscussionMemberInfo)localObject2).memberUin;
            localajo.jdField_b_of_type_JavaLangString = ContactUtils.a((DiscussionMemberInfo)localObject2, this.app);
            localObject2 = localFriendManager.c(localajo.jdField_a_of_type_JavaLangString);
            if (localObject2 != null) {}
            for (localajo.jdField_a_of_type_Short = ((Friends)localObject2).faceid;; localajo.jdField_a_of_type_Short = 0)
            {
              localajo.d = ChnToSpell.a(localajo.jdField_b_of_type_JavaLangString, 1);
              localajo.c = ChnToSpell.a(localajo.jdField_b_of_type_JavaLangString, 2);
              this.jdField_a_of_type_JavaUtilList.add(localajo);
              break;
            }
          }
        }
      }
    }
  }
  
  private void e()
  {
    Dialog localDialog = new Dialog(this);
    localDialog.setCanceledOnTouchOutside(true);
    localDialog.requestWindowFeature(1);
    localDialog.getWindow().setSoftInputMode(36);
    localDialog.setContentView(2130903604);
    Object localObject1 = localDialog.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject1).x = 0;
    ((WindowManager.LayoutParams)localObject1).y = 0;
    ((WindowManager.LayoutParams)localObject1).width = -1;
    ((WindowManager.LayoutParams)localObject1).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject1).gravity = 51;
    localDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
    int i = this.jdField_b_of_type_AndroidViewView.getHeight();
    Object localObject2 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i);
    ((TranslateAnimation)localObject2).setDuration(300L);
    ((TranslateAnimation)localObject2).setFillAfter(true);
    localObject1 = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
    ((TranslateAnimation)localObject1).setDuration(300L);
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    ajf localajf = new ajf(this, (TranslateAnimation)localObject2, localDialog);
    ((TranslateAnimation)localObject2).setAnimationListener(localajf);
    ((TranslateAnimation)localObject1).setAnimationListener(localajf);
    this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject2);
    localObject2 = new ajg(this);
    addObserver((BusinessObserver)localObject2);
    localDialog.setOnDismissListener(new ajh(this, (TranslateAnimation)localObject1, localInputMethodManager, (FriendListObserver)localObject2));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)localDialog.findViewById(2131297957));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new ajs(this, null));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)localDialog.findViewById(2131297950));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new ajj(this));
    ((Button)localDialog.findViewById(2131298408)).setOnClickListener(new ajk(this, localDialog));
    this.c = localDialog.findViewById(2131296867);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localDialog.findViewById(2131296865));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new ajl(this, localDialog));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localDialog.findViewById(2131298704));
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundDrawable(getResources().getDrawable(2130837635));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Ajr = new ajr(this, this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ajr);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new ajm(this, localInputMethodManager));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new ajn(this, localDialog));
  }
  
  public void a(View paramView)
  {
    paramView = (FacePreloadBaseAdapter.ViewHolder)paramView.getTag();
    if ((paramView != null) && (paramView.jdField_a_of_type_JavaLangString != null))
    {
      paramView = paramView.jdField_a_of_type_JavaLangString;
      if (paramView.equals(this.app.a()))
      {
        paramView = new ProfileActivity.AllInOne(paramView, 0);
        paramView.jdField_f_of_type_Int = 5;
        ProfileActivity.a(this, paramView, 1);
      }
    }
    else
    {
      return;
    }
    if (((FriendManager)this.app.getManager(8)).b(paramView))
    {
      localAllInOne = new ProfileActivity.AllInOne(paramView, 1);
      localAllInOne.h = ContactUtils.a(this.app, paramView, 0);
      localAllInOne.jdField_f_of_type_Int = 5;
      ProfileActivity.a(this, localAllInOne, 1);
      return;
    }
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(paramView, 46);
    localAllInOne.h = ContactUtils.a(this.app, paramView, 0);
    localAllInOne.jdField_f_of_type_JavaLangString = paramView;
    localAllInOne.jdField_e_of_type_Int = 3000;
    localAllInOne.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localAllInOne.jdField_f_of_type_Int = 5;
    ProfileActivity.a(this, localAllInOne, 1);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.q() > 0) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.q() == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount() < this.jdField_a_of_type_Ajp.getCount() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.k()))) {
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
      i = this.jdField_a_of_type_Ajp.a(paramString);
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
      this.jdField_a_of_type_Ajr.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ajo localajo = (ajo)localIterator.next();
        if (localajo != null) {
          if ((localajo.jdField_b_of_type_JavaLangString.equals(paramString)) || (localajo.jdField_a_of_type_JavaLangString.equals(paramString)) || (localajo.d.equals(paramString.toLowerCase())) || (localajo.c.equals(paramString.toLowerCase()))) {
            localArrayList1.add(localajo);
          } else if ((localajo.jdField_b_of_type_JavaLangString.indexOf(paramString) == 0) || (localajo.jdField_a_of_type_JavaLangString.indexOf(paramString) == 0) || (localajo.c.indexOf(paramString.toLowerCase()) == 0) || (localajo.d.indexOf(paramString.toLowerCase()) == 0)) {
            localArrayList2.add(localajo);
          } else if ((localajo.jdField_b_of_type_JavaLangString.indexOf(paramString) > 0) || (localajo.jdField_a_of_type_JavaLangString.indexOf(paramString) > 0) || (localajo.c.indexOf(paramString.toLowerCase()) > 0) || (localajo.d.indexOf(paramString.toLowerCase()) > 0)) {
            localArrayList3.add(localajo);
          }
        }
      }
      Collections.sort(localArrayList2, new ajq(this, null));
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
      this.jdField_a_of_type_Ajp.notifyDataSetChanged();
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
    setContentView(2130903608);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("uin");
    c();
    d();
    ((TroopMemberListActivity.ViewHolder)this.d.getTag()).c.setText(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Ajp = new ajp(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Ajp);
  }
  
  protected void onDestroy()
  {
    this.jdField_a_of_type_Ajp.b();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionMemberActivity
 * JD-Core Version:    0.7.0.1
 */