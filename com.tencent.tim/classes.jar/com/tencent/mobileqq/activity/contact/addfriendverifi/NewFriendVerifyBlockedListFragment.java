package com.tencent.mobileqq.activity.contact.addfriendverifi;

import acfp;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aqdf;
import aqdf.a;
import aqhu;
import aqiw;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import mqq.os.MqqHandler;
import yqv;
import yqy;
import yqz;
import yra;
import yrb;
import yrc;
import yrd;
import ysa;

public class NewFriendVerifyBlockedListFragment
  extends IphoneTitleBarFragment
  implements aqdf.a
{
  private TextView Lw;
  private aqdf jdField_a_of_type_Aqdf;
  private a jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiNewFriendVerifyBlockedListFragment$a;
  private yqy jdField_a_of_type_Yqy = new yra(this);
  private ListView b;
  private View lg;
  private FragmentActivity mActivity;
  private AbsListView.e n = new yrb(this);
  public MqqHandler q = new yqz(this);
  private List<AddFriendBlockedInfo> sZ = new ArrayList();
  
  public static void bv(Activity paramActivity)
  {
    PublicFragmentActivity.start(paramActivity, new Intent(), NewFriendVerifyBlockedListFragment.class);
  }
  
  private void ckS()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(getString(2131701429));
    localSpannableStringBuilder.setSpan(new yrd(this), 27, 31, 33);
    this.Lw.setText(localSpannableStringBuilder);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#4D94FF")), 27, 31, 33);
    this.Lw.setMovementMethod(LinkMovementMethod.getInstance());
    this.Lw.setText(localSpannableStringBuilder);
  }
  
  private void refreshData()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiNewFriendVerifyBlockedListFragment$a != null)
    {
      this.sZ.clear();
      this.sZ.addAll(yqv.a(this.mActivity.app).sY);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiNewFriendVerifyBlockedListFragment$a.notifyDataSetChanged();
      if (this.sZ.isEmpty())
      {
        this.Lw.setVisibility(8);
        this.lg.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    this.Lw.setVisibility(0);
    this.lg.setVisibility(8);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(this.mActivity.getString(2131701431));
    this.lg = this.mContentView.findViewById(2131366438);
    this.b = ((ListView)this.mContentView.findViewById(2131365077));
    this.b.setNeedCheckSpringback(true);
    this.b.setOverscrollHeader(null);
    this.b.setOnScrollListener(this.n);
    this.Lw = ((TextView)this.mContentView.findViewById(2131370540));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiNewFriendVerifyBlockedListFragment$a = new a(null);
    this.b.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiNewFriendVerifyBlockedListFragment$a);
    ckS();
    setRightButton(2131691523, new yrc(this));
    refreshData();
  }
  
  public int getContentLayoutId()
  {
    return 2131561730;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      this.q.removeMessages(1);
      this.q.sendEmptyMessage(1);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mActivity = getActivity();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mActivity.app.addObserver(this.jdField_a_of_type_Yqy);
    this.jdField_a_of_type_Aqdf = new aqdf(this.mActivity, this.mActivity.app);
    this.jdField_a_of_type_Aqdf.a(this);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      paramInt2 = this.b.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = this.b.getChildAt(paramInt1).getTag();
        if ((localObject != null) && ((localObject instanceof NewFriendVerifyBlockedListFragment.a.a)))
        {
          localObject = (NewFriendVerifyBlockedListFragment.a.a)localObject;
          if ((((NewFriendVerifyBlockedListFragment.a.a)localObject).a != null) && (paramString.equals(((NewFriendVerifyBlockedListFragment.a.a)localObject).a.friendUin))) {
            ((NewFriendVerifyBlockedListFragment.a.a)localObject).uw.setImageBitmap(paramBitmap);
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mActivity.app.removeObserver(this.jdField_a_of_type_Yqy);
    this.jdField_a_of_type_Aqdf.a(null);
    this.jdField_a_of_type_Aqdf.destory();
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.mActivity = null;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiNewFriendVerifyBlockedListFragment$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiNewFriendVerifyBlockedListFragment$a.ckU();
    }
    anot.a(null, "dc00898", "", "", "0X800A3A6", "0X800A3A6", 0, 0, "", "", "", "");
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiNewFriendVerifyBlockedListFragment$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiNewFriendVerifyBlockedListFragment$a.ckT();
    }
    yqv.a(this.mActivity.app).ckR();
  }
  
  public class a
    extends BaseAdapter
    implements View.OnClickListener
  {
    private a() {}
    
    private void C(View paramView, boolean paramBoolean)
    {
      if (paramView == null) {
        return;
      }
      if (paramBoolean)
      {
        paramView.setBackgroundResource(2130839644);
        return;
      }
      if (ThemeUtil.isDefaultTheme())
      {
        paramView.setBackgroundResource(2130839642);
        return;
      }
      paramView.setBackgroundResource(2130839639);
    }
    
    private void a(a parama, View.OnClickListener paramOnClickListener)
    {
      if (parama.a == null) {
        return;
      }
      if (TextUtils.isEmpty(parama.a.AI))
      {
        parama.Lx.setText(parama.a.friendUin);
        a(parama, parama.a.friendUin);
        parama.uw.setTag(parama);
        ysa.a(parama.LB, parama.a.sex, parama.a.age, null);
        paramOnClickListener = parama.a.aZx;
        if (TextUtils.isEmpty(paramOnClickListener)) {
          break label210;
        }
        paramOnClickListener = String.format(Locale.getDefault(), acfp.m(2131709048), new Object[] { paramOnClickListener });
        parama.Lz.setText(paramOnClickListener);
        parama.Lz.setVisibility(0);
        label128:
        int i = parama.a.caF;
        if (i <= 0) {
          break label222;
        }
        paramOnClickListener = String.format(Locale.getDefault(), "%d位共同好友", new Object[] { Integer.valueOf(i) });
        parama.Ly.setVisibility(0);
        parama.Ly.setText(paramOnClickListener);
      }
      for (;;)
      {
        parama.ej.setTag(parama);
        parama.ej.setOnClickListener(this);
        return;
        parama.Lx.setText(parama.a.AI);
        break;
        label210:
        parama.Lz.setVisibility(8);
        break label128;
        label222:
        parama.Ly.setVisibility(8);
      }
    }
    
    private void fI(View paramView)
    {
      if ((paramView instanceof ThemeImageView)) {
        ((ThemeImageView)paramView).setSupportMaskView(true);
      }
    }
    
    public AddFriendBlockedInfo a(int paramInt)
    {
      return (AddFriendBlockedInfo)NewFriendVerifyBlockedListFragment.a(NewFriendVerifyBlockedListFragment.this).get(paramInt);
    }
    
    public void a(a parama, String paramString)
    {
      if ((parama == null) || (parama.uw == null) || (TextUtils.isEmpty(paramString))) {
        return;
      }
      Bitmap localBitmap = NewFriendVerifyBlockedListFragment.a(NewFriendVerifyBlockedListFragment.this).b(1, paramString);
      if ((localBitmap == null) && (!NewFriendVerifyBlockedListFragment.a(NewFriendVerifyBlockedListFragment.this).isPausing())) {
        NewFriendVerifyBlockedListFragment.a(NewFriendVerifyBlockedListFragment.this).i(paramString, 1, true);
      }
      paramString = localBitmap;
      if (localBitmap == null) {
        paramString = aqhu.G();
      }
      parama.uw.setImageBitmap(paramString);
    }
    
    public void ckT()
    {
      NewFriendVerifyBlockedListFragment.a(NewFriendVerifyBlockedListFragment.this).edu();
      NewFriendVerifyBlockedListFragment.a(NewFriendVerifyBlockedListFragment.this).pause();
    }
    
    public void ckU()
    {
      if (NewFriendVerifyBlockedListFragment.a(NewFriendVerifyBlockedListFragment.this).isPausing()) {
        NewFriendVerifyBlockedListFragment.a(NewFriendVerifyBlockedListFragment.this).resume();
      }
    }
    
    public void ckV()
    {
      int j = NewFriendVerifyBlockedListFragment.a(NewFriendVerifyBlockedListFragment.this).getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject = NewFriendVerifyBlockedListFragment.a(NewFriendVerifyBlockedListFragment.this).getChildAt(i).getTag();
        if ((localObject instanceof a))
        {
          localObject = (a)localObject;
          a((a)localObject, ((a)localObject).a.friendUin);
        }
        i += 1;
      }
    }
    
    public int getCount()
    {
      if (NewFriendVerifyBlockedListFragment.a(NewFriendVerifyBlockedListFragment.this) == null) {
        return 0;
      }
      return NewFriendVerifyBlockedListFragment.a(NewFriendVerifyBlockedListFragment.this).size();
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      Object localObject;
      if (paramView == null)
      {
        paramView = new a();
        localView = LayoutInflater.from(NewFriendVerifyBlockedListFragment.a(NewFriendVerifyBlockedListFragment.this)).inflate(2131561729, null);
        paramView.uw = ((ImageView)localView.findViewById(2131361802));
        paramView.Lx = ((TextView)localView.findViewById(2131372384));
        paramView.Ly = ((TextView)localView.findViewById(2131377214));
        paramView.LB = ((TextView)localView.findViewById(2131362339));
        paramView.Lz = ((TextView)localView.findViewById(2131378586));
        paramView.LA = ((TextView)localView.findViewById(2131377211));
        paramView.ej = ((Button)localView.findViewById(2131377201));
        paramView.rootView = localView;
        localView.setOnClickListener(this);
        fI(paramView.uw);
        localView.setTag(paramView);
        localObject = a(paramInt);
        paramView.a = ((AddFriendBlockedInfo)localObject);
        if (((AddFriendBlockedInfo)localObject).isRead) {
          break label233;
        }
        C(paramView.rootView, true);
      }
      for (;;)
      {
        a(paramView, this);
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localObject = (a)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject;
        break;
        label233:
        C(paramView.rootView, false);
      }
    }
    
    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject1 = paramView.getTag();
        if ((localObject1 != null) && ((localObject1 instanceof a)))
        {
          localObject1 = ((a)localObject1).a;
          if (localObject1 != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("BlockedListFragment", 2, "onClick rlSystemMsg， friendtype=" + 109);
            }
            localObject2 = new ProfileActivity.AllInOne(((AddFriendBlockedInfo)localObject1).friendUin, 109);
            if (!TextUtils.isEmpty(((AddFriendBlockedInfo)localObject1).AI)) {}
            for (((ProfileActivity.AllInOne)localObject2).nickname = ((AddFriendBlockedInfo)localObject1).AI;; ((ProfileActivity.AllInOne)localObject2).nickname = ((AddFriendBlockedInfo)localObject1).friendUin)
            {
              ((ProfileActivity.AllInOne)localObject2).bJa = 120;
              ProfileActivity.a(NewFriendVerifyBlockedListFragment.a(NewFriendVerifyBlockedListFragment.this), (ProfileActivity.AllInOne)localObject2, 100);
              anot.a(null, "dc00898", "", "", "0X800A3A8", "0X800A3A8", 0, 0, "", "", "", "");
              break;
            }
            localObject1 = paramView.getTag();
            if ((localObject1 != null) && ((localObject1 instanceof a)))
            {
              if (aqiw.isNetworkAvailable(NewFriendVerifyBlockedListFragment.a(NewFriendVerifyBlockedListFragment.this))) {
                break;
              }
              QQToast.a(NewFriendVerifyBlockedListFragment.a(NewFriendVerifyBlockedListFragment.this), NewFriendVerifyBlockedListFragment.a(NewFriendVerifyBlockedListFragment.this).getResources().getString(2131693404), 0).show(NewFriendVerifyBlockedListFragment.a(NewFriendVerifyBlockedListFragment.this).getTitleBarHeight());
            }
          }
        }
      }
      Object localObject2 = ((a)localObject1).a;
      if (!TextUtils.isEmpty(((AddFriendBlockedInfo)localObject2).AI)) {}
      for (Object localObject1 = ((AddFriendBlockedInfo)localObject2).AI;; localObject1 = ((AddFriendBlockedInfo)localObject2).friendUin)
      {
        localObject1 = AddFriendLogicActivity.a(NewFriendVerifyBlockedListFragment.a(NewFriendVerifyBlockedListFragment.this), 1, ((AddFriendBlockedInfo)localObject2).friendUin, null, 3041, 15, (String)localObject1, null, null, NewFriendVerifyBlockedListFragment.a(NewFriendVerifyBlockedListFragment.this).getString(2131721053), null);
        NewFriendVerifyBlockedListFragment.a(NewFriendVerifyBlockedListFragment.this).startActivityForResult((Intent)localObject1, 100);
        anot.a(null, "dc00898", "", "", "0X800A3A7", "0X800A3A7", 0, 0, "", "", "", "");
        break;
      }
    }
    
    public class a
    {
      public TextView LA;
      public TextView LB;
      public TextView Lx;
      public TextView Ly;
      public TextView Lz;
      public AddFriendBlockedInfo a;
      public Button ej;
      public View rootView;
      public ImageView uw;
      
      public a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addfriendverifi.NewFriendVerifyBlockedListFragment
 * JD-Core Version:    0.7.0.1
 */