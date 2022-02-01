package com.tencent.mobileqq.activity;

import acbn;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Editable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aqcl;
import aqdf;
import aqdf.a;
import aqhu;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.CustomGridView;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.ResultRecord.a;
import com.tencent.mobileqq.widget.CustomHorizontalScrollView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import vtf;
import vtg;
import vth;
import vti;
import vtj;
import vtk;
import vtl;
import wja;

public class SelectedAndSearchBar
  extends RelativeLayout
  implements aqdf.a
{
  private ImageView Q;
  private aqdf jdField_a_of_type_Aqdf;
  private a jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar$a;
  private CustomGridView jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCustomGridView;
  private final ResultRecord.a jdField_a_of_type_ComTencentMobileqqActivitySelectmemberResultRecord$a = new ResultRecord.a();
  private b jdField_b_of_type_ComTencentMobileqqActivitySelectedAndSearchBar$b;
  private CustomHorizontalScrollView jdField_b_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView;
  private boolean bal;
  private Context mContext;
  private float mDensity;
  private EditText mEditText;
  private View mRootView;
  private List<ResultRecord> rc = new ArrayList();
  private ImageView rf;
  
  public SelectedAndSearchBar(Context paramContext)
  {
    super(paramContext);
    initViews();
    initData();
  }
  
  public SelectedAndSearchBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initViews();
    initData();
  }
  
  public SelectedAndSearchBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initViews();
    initData();
  }
  
  private void initData()
  {
    this.mDensity = getResources().getDisplayMetrics().density;
    this.mContext = getContext();
  }
  
  private void initViews()
  {
    this.mRootView = LayoutInflater.from(getContext()).inflate(2131563074, this);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCustomGridView = ((CustomGridView)this.mRootView.findViewById(2131377967));
    this.mEditText = ((EditText)this.mRootView.findViewById(2131377838));
    this.rf = ((ImageView)this.mRootView.findViewById(2131369095));
    this.Q = ((ImageView)this.mRootView.findViewById(2131377832));
    this.jdField_b_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView = ((CustomHorizontalScrollView)this.mRootView.findViewById(2131377766));
    aqcl.Q(this.jdField_b_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView, false);
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView.setOverScrollMode(2);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCustomGridView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCustomGridView.setOnItemClickListener(new vtf(this));
    this.mEditText.setOnKeyListener(new vtg(this));
    this.mEditText.addTextChangedListener(new vth(this));
    this.mEditText.setOnFocusChangeListener(new vti(this));
  }
  
  public boolean QG()
  {
    return this.mEditText.hasFocus();
  }
  
  public void X(List<ResultRecord> paramList, boolean paramBoolean)
  {
    Collections.sort(paramList, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberResultRecord$a);
    this.rc = paramList;
    cz(paramBoolean);
  }
  
  public Editable a()
  {
    return this.mEditText.getText();
  }
  
  public void a(List<ResultRecord> paramList, aqdf paramaqdf, b paramb)
  {
    if (paramList != null) {
      this.rc = paramList;
    }
    this.jdField_a_of_type_Aqdf = paramaqdf;
    this.jdField_b_of_type_ComTencentMobileqqActivitySelectedAndSearchBar$b = paramb;
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar$a = new a();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCustomGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar$a);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCustomGridView.setSmoothScrollbarEnabled(false);
    this.jdField_a_of_type_Aqdf.a(this);
  }
  
  public void bLX()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)(this.mDensity * 40.0F));
    int i = (int)(this.mDensity * 40.0F);
    int j = (int)(this.mDensity * 10.0F);
    if (this.rc.size() > 0) {
      if (this.rc.size() < 5)
      {
        i = (int)((this.rc.size() * 40 + this.rc.size() * 10) * this.mDensity) + (int)(this.mDensity * 10.0F);
        this.Q.setVisibility(8);
      }
    }
    for (;;)
    {
      localLayoutParams.addRule(15);
      localLayoutParams.setMargins(i, 0, j, 0);
      this.mEditText.setLayoutParams(localLayoutParams);
      return;
      i = (int)(230.0F * this.mDensity);
      break;
      this.Q.setVisibility(0);
    }
  }
  
  public void bVl()
  {
    this.mEditText.setText("");
  }
  
  public void bVm()
  {
    this.mEditText.clearFocus();
  }
  
  public void bVn()
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView.scrollTo(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCustomGridView.getLayoutParams().width, 0);
  }
  
  public void cz(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCustomGridView.setNumColumns(this.rc.size());
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCustomGridView.getLayoutParams();
    localLayoutParams.width = ((int)((this.rc.size() * 40 + this.rc.size() * 10) * this.mDensity));
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCustomGridView.setLayoutParams(localLayoutParams);
    bLX();
    if (paramBoolean) {
      postDelayed(new SelectedAndSearchBar.6(this), 200L);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar$a.notifyDataSetChanged();
  }
  
  public void fN(long paramLong)
  {
    int i = wja.dp2px(60.0F, getResources());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mRootView.getLayoutParams();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { -i, 0 });
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.addUpdateListener(new vtk(this, localLayoutParams));
    localValueAnimator.start();
  }
  
  public void fO(long paramLong)
  {
    int i = wja.dp2px(60.0F, getResources());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mRootView.getLayoutParams();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, -i });
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.addUpdateListener(new vtl(this, localLayoutParams));
    localValueAnimator.start();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCustomGridView == null) {}
    for (;;)
    {
      return;
      paramInt1 = 0;
      while (paramInt1 < this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCustomGridView.getChildCount())
      {
        View localView = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCustomGridView.getChildAt(paramInt1);
        Object localObject = localView.getTag();
        if ((localObject != null) && ((localObject instanceof ResultRecord)))
        {
          localObject = (ResultRecord)localObject;
          if ((paramString.equals(((ResultRecord)localObject).uin)) && (((ResultRecord)localObject).type == paramInt2)) {
            ((ImageView)localView.findViewById(2131366624)).setBackgroundDrawable(new BitmapDrawable(getResources(), paramBitmap));
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void v(View.OnClickListener paramOnClickListener)
  {
    this.mEditText.setOnClickListener(new vtj(this, paramOnClickListener));
  }
  
  public class a
    extends BaseAdapter
  {
    private boolean aUL;
    private Bitmap dk = aqhu.G();
    private Drawable dy = SelectedAndSearchBar.a(SelectedAndSearchBar.this).getResources().getDrawable(2130845851);
    
    public a() {}
    
    private int eR(int paramInt)
    {
      int i = 4;
      if (paramInt == 4) {
        i = 11;
      }
      while (paramInt == 1) {
        return i;
      }
      if (paramInt == 3000) {
        return 101;
      }
      return 1;
    }
    
    public void bLZ()
    {
      if (this.aUL)
      {
        if ((SelectedAndSearchBar.a(SelectedAndSearchBar.this) != null) && (SelectedAndSearchBar.a(SelectedAndSearchBar.this).size() > 0))
        {
          ResultRecord localResultRecord = (ResultRecord)SelectedAndSearchBar.a(SelectedAndSearchBar.this).get(SelectedAndSearchBar.a(SelectedAndSearchBar.this).size() - 1);
          if (SelectedAndSearchBar.a(SelectedAndSearchBar.this) != null) {
            SelectedAndSearchBar.a(SelectedAndSearchBar.this).a(localResultRecord);
          }
          SelectedAndSearchBar.this.cz(false);
          this.aUL = false;
        }
        return;
      }
      this.aUL = true;
      super.notifyDataSetChanged();
    }
    
    public int getCount()
    {
      return SelectedAndSearchBar.a(SelectedAndSearchBar.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return SelectedAndSearchBar.a(SelectedAndSearchBar.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject = null;
      ResultRecord localResultRecord = (ResultRecord)getItem(paramInt);
      if (paramView == null) {
        paramView = LayoutInflater.from(SelectedAndSearchBar.a(SelectedAndSearchBar.this)).inflate(2131559454, null);
      }
      for (;;)
      {
        paramView.setTag(localResultRecord);
        ImageView localImageView = (ImageView)paramView.findViewById(2131366624);
        int i;
        label97:
        int j;
        if (paramInt == getCount() - 1)
        {
          if (this.aUL) {
            localObject = this.dy;
          }
          localImageView.setImageDrawable((Drawable)localObject);
          if (localResultRecord.uinType != -1) {
            break label179;
          }
          i = localResultRecord.type;
          if (localResultRecord.type != -1) {
            break label193;
          }
          j = i;
          label110:
          localResultRecord.type = j;
          if (!acbn.bkw.equals(localResultRecord.uin)) {
            break label203;
          }
          localImageView.setBackgroundResource(2130845074);
        }
        for (;;)
        {
          if (AppSetting.enableTalkBack) {
            localImageView.setContentDescription(localResultRecord.name);
          }
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
          localImageView.setImageDrawable(null);
          break;
          label179:
          i = eR(localResultRecord.uinType);
          break label97;
          label193:
          j = localResultRecord.type;
          break label110;
          label203:
          if (acbn.bkx.equals(localResultRecord.uin))
          {
            localImageView.setBackgroundResource(2130845071);
          }
          else if (acbn.bky.equals(localResultRecord.uin))
          {
            localImageView.setBackgroundResource(2130845077);
          }
          else if (acbn.bkv.equals(localResultRecord.uin))
          {
            localImageView.setBackgroundResource(2130840081);
          }
          else
          {
            if (localResultRecord.type != 5) {
              break label294;
            }
            localImageView.setImageResource(2130842937);
          }
        }
        label294:
        String str = localResultRecord.uin;
        localObject = SelectedAndSearchBar.a(SelectedAndSearchBar.this).b(i, str);
        if (localObject == null)
        {
          SelectedAndSearchBar.a(SelectedAndSearchBar.this).i(str, i, true);
          localObject = this.dk;
        }
        for (;;)
        {
          localImageView.setBackgroundDrawable(new BitmapDrawable(SelectedAndSearchBar.a(SelectedAndSearchBar.this).getResources(), (Bitmap)localObject));
          break;
        }
      }
    }
    
    public void notifyDataSetChanged()
    {
      this.aUL = false;
      super.notifyDataSetChanged();
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(ResultRecord paramResultRecord);
    
    public abstract void afterTextChanged(Editable paramEditable);
    
    public abstract void xf(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SelectedAndSearchBar
 * JD-Core Version:    0.7.0.1
 */