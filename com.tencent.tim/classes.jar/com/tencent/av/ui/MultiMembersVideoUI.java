package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqgv;
import aqhu;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.b;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import iiv;
import jai;
import jai.a;
import jai.b;
import jaj;
import jak;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import jka;
import jkm;
import jll;
import mqq.app.BaseActivity;

public class MultiMembersVideoUI
  extends RelativeLayout
  implements jai
{
  boolean Xe = false;
  boolean Xf = false;
  HorizontalScrollView jdField_a_of_type_AndroidWidgetHorizontalScrollView = null;
  VideoController jdField_a_of_type_ComTencentAvVideoController = null;
  a jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI$a = null;
  public jka a;
  public int aqx = 0;
  LayoutInflater jdField_d_of_type_AndroidViewLayoutInflater = null;
  GridView jdField_d_of_type_AndroidWidgetGridView = null;
  View.OnTouchListener f = new jak(this);
  public ArrayList<jai.b> iG = new ArrayList();
  int itemWidth = 0;
  VideoAppInterface mApp = null;
  WeakReference<Context> mContext = null;
  AdapterView.OnItemClickListener mItemClickListener = new jaj(this);
  View mRootView = null;
  long md = 0L;
  
  public MultiMembersVideoUI(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Jka = null;
  }
  
  @TargetApi(9)
  public MultiMembersVideoUI(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Jka = null;
    this.mContext = new WeakReference(paramContext);
    paramContext = (BaseActivity)this.mContext.get();
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersVideoUI", 2, "MVMembersContolUI-->can not get activity");
      }
      return;
    }
    this.mApp = ((VideoAppInterface)paramContext.getAppRuntime());
    if (this.mApp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersVideoUI", 2, "MVMembersContolUI-->can not get AppRuntime");
      }
      paramContext.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.mApp.b();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersVideoUI", 2, "MVMembersContolUI-->can not get videoControl");
      }
      paramContext.finish();
      return;
    }
    this.jdField_d_of_type_AndroidViewLayoutInflater = LayoutInflater.from((Context)this.mContext.get());
    this.mRootView = this.jdField_d_of_type_AndroidViewLayoutInflater.inflate(2131559940, null);
    this.mRootView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.jdField_d_of_type_AndroidWidgetGridView = ((GridView)this.mRootView.findViewById(2131372146));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)this.mRootView.findViewById(2131372144));
    this.jdField_d_of_type_AndroidWidgetGridView.setNumColumns(-1);
    this.jdField_d_of_type_AndroidWidgetGridView.setGravity(17);
    this.jdField_d_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setOverScrollMode(2);
      this.jdField_d_of_type_AndroidWidgetGridView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI$a = new a();
    this.jdField_d_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI$a);
    this.jdField_d_of_type_AndroidWidgetGridView.setOnItemClickListener(this.mItemClickListener);
    this.jdField_d_of_type_AndroidWidgetGridView.setOnTouchListener(this.f);
    super.addView(this.mRootView);
  }
  
  public void asZ()
  {
    boolean bool2 = false;
    int i = lW();
    if (i < 0) {
      i = 0;
    }
    for (;;)
    {
      int k = Math.min(i + 4, this.iG.size());
      int j = i;
      for (;;)
      {
        boolean bool1 = bool2;
        if (j < k)
        {
          if (!((jai.b)this.iG.get(j)).Wv) {
            bool1 = true;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("MultiMembersVideoUI", 2, "refreshHeadbitmap-->minIndex=" + i + ",maxIndex=" + k + ",needRefresh=" + bool1);
          }
          if (bool1) {
            this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI$a.notifyDataSetChanged();
          }
          return;
        }
        j += 1;
      }
    }
  }
  
  void ata()
  {
    int i = this.iG.size();
    if (((this.aqx == 1) || (this.aqx == 2)) && (i > 8)) {
      i = this.itemWidth * 8;
    }
    for (;;)
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetGridView.getLayoutParams();
      localLayoutParams.width = i;
      this.jdField_d_of_type_AndroidWidgetGridView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI$a.notifyDataSetChanged();
      return;
      i *= this.itemWidth;
    }
  }
  
  void atb()
  {
    int j = 0;
    Object localObject = (BaseActivity)this.mContext.get();
    if (localObject == null) {
      return;
    }
    int i = this.iG.size();
    int k = jll.getScreenWidth(((BaseActivity)localObject).getApplicationContext());
    this.itemWidth = ((BaseActivity)localObject).getResources().getDimensionPixelSize(2131298193);
    this.jdField_d_of_type_AndroidWidgetGridView.setColumnWidth(this.itemWidth);
    if (this.Xe) {
      if (i <= 4)
      {
        i = (k - this.itemWidth * i) / 2;
        if (i >= 0) {
          break label218;
        }
        i = j;
      }
    }
    label218:
    for (;;)
    {
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = i;
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      this.itemWidth = ((int)(k / 4.5D));
      this.jdField_d_of_type_AndroidWidgetGridView.setColumnWidth(this.itemWidth);
      i = 0;
      break;
      if (i <= 6)
      {
        i = ((BaseActivity)localObject).getResources().getDimensionPixelSize(2131298195);
        this.itemWidth = ((k - i * 2) / 6);
        this.jdField_d_of_type_AndroidWidgetGridView.setColumnWidth(this.itemWidth);
        break;
      }
      this.itemWidth = ((int)(k / 6.5D));
      this.jdField_d_of_type_AndroidWidgetGridView.setColumnWidth(this.itemWidth);
      i = 0;
      break;
    }
  }
  
  public void b(long paramLong, int paramInt, boolean paramBoolean)
  {
    this.md = paramLong;
    this.aqx = paramInt;
    this.Xe = paramBoolean;
  }
  
  public void bC(ArrayList<VideoController.b> paramArrayList)
  {
    if (paramArrayList != null)
    {
      bD(paramArrayList);
      atb();
      ata();
    }
  }
  
  void bD(ArrayList<VideoController.b> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMembersVideoUI", 2, "refreshDataSource");
    }
    if (paramArrayList == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMembersVideoUI", 2, "refreshDataSource-->friends list is null");
      }
    }
    for (;;)
    {
      return;
      this.iG.clear();
      int i = 0;
      while (i < paramArrayList.size())
      {
        VideoController.b localb = (VideoController.b)paramArrayList.get(i);
        jai.b localb1 = new jai.b();
        localb1.uin = localb.uin;
        localb1.awz = localb.alV;
        localb1.Xc = localb.Ph;
        localb1.Wu = localb.Pg;
        localb1.Xd = localb.Pi;
        localb1.accountType = localb.accountType;
        localb1.b = localb.a;
        localb1.Pk = localb.Pk;
        localb1.Ww = localb.Pn;
        this.iG.add(localb1);
        i += 1;
      }
    }
  }
  
  int lW()
  {
    long l = this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getScrollX();
    if (this.itemWidth > 0) {
      return (int)l / this.itemWidth;
    }
    return 0;
  }
  
  public void setOnItemClickListener(jka paramjka)
  {
    this.jdField_a_of_type_Jka = paramjka;
  }
  
  class a
    extends BaseAdapter
  {
    a() {}
    
    jai.a a(View paramView)
    {
      jai.a locala = new jai.a();
      locala.aE = ((ViewGroup)paramView.findViewById(2131374009));
      locala.E = ((ImageView)paramView.findViewById(2131374006));
      locala.name = ((TextView)paramView.findViewById(2131374022));
      locala.gt = ((ImageView)paramView.findViewById(2131374024));
      locala.mG = ((TextView)paramView.findViewById(2131374008));
      locala.gw = ((ImageView)paramView.findViewById(2131374021));
      locala.gx = ((ImageView)paramView.findViewById(2131374007));
      if ((MultiMembersVideoUI.this.Xf) && (locala.name != null) && (locala.E != null))
      {
        float f = MultiMembersVideoUI.a(MultiMembersVideoUI.this).getDisplayMetrics().density;
        locala.name.setTextSize(12.0F);
        int i = (int)(f * 1.5D);
        locala.E.setPadding(i, i, i, i);
      }
      if (locala.name != null)
      {
        if (MultiMembersVideoUI.this.Xe) {
          locala.name.setTextColor(MultiMembersVideoUI.this.getResources().getColor(2131166294));
        }
      }
      else if (locala.aE != null)
      {
        paramView = (RelativeLayout.LayoutParams)locala.aE.getLayoutParams();
        if (!MultiMembersVideoUI.this.Xe) {
          break label312;
        }
        paramView.width = MultiMembersVideoUI.this.getResources().getDimensionPixelSize(2131298240);
      }
      for (paramView.height = MultiMembersVideoUI.this.getResources().getDimensionPixelSize(2131298239);; paramView.height = MultiMembersVideoUI.this.getResources().getDimensionPixelSize(2131298244))
      {
        locala.aE.setLayoutParams(paramView);
        return locala;
        locala.name.setTextColor(MultiMembersVideoUI.this.getResources().getColor(2131166294));
        break;
        label312:
        paramView.width = MultiMembersVideoUI.this.getResources().getDimensionPixelSize(2131298246);
      }
    }
    
    public int getCount()
    {
      if (((MultiMembersVideoUI.this.aqx == 1) || (MultiMembersVideoUI.this.aqx == 2)) && (MultiMembersVideoUI.this.iG.size() > 8)) {
        return 8;
      }
      return MultiMembersVideoUI.this.iG.size();
    }
    
    public Object getItem(int paramInt)
    {
      return MultiMembersVideoUI.this.iG.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject1;
      if ((paramInt == 0) && (paramView != null) && (paramViewGroup.getChildCount() != paramInt))
      {
        localObject1 = paramView;
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
        return paramView;
      }
      if (paramView == null)
      {
        paramView = MultiMembersVideoUI.this.d.inflate(2131559939, null);
        localObject1 = a(paramView);
        paramView.setTag(localObject1);
      }
      label67:
      label452:
      label461:
      label476:
      label498:
      label632:
      label1272:
      for (;;)
      {
        jai.b localb = (jai.b)MultiMembersVideoUI.this.iG.get(paramInt);
        Object localObject2;
        if ((localb.name == null) || (localb.faceBitmap == null) || (!localb.Wv))
        {
          if (localb.accountType != 0) {
            break label476;
          }
          localObject2 = String.valueOf(localb.uin);
          localb.name = MultiMembersVideoUI.this.a.d((String)localObject2, String.valueOf(MultiMembersVideoUI.this.md), MultiMembersVideoUI.this.aqx);
          if (localb.name.compareTo((String)localObject2) == 0) {
            break label452;
          }
          localb.Wv = true;
          localObject2 = MultiMembersVideoUI.this.a.a((String)localObject2, String.valueOf(MultiMembersVideoUI.this.md), MultiMembersVideoUI.this.aqx, false, true);
          if (localObject2 == null) {
            break label461;
          }
          localb.faceBitmap = ((Bitmap)localObject2);
        }
        for (;;)
        {
          if (((MultiMembersVideoUI.this.aqx != 1) && (MultiMembersVideoUI.this.aqx != 2)) || (paramInt != 7) || (MultiMembersVideoUI.this.iG.size() <= 8)) {
            break label727;
          }
          ((jai.a)localObject1).Wx = false;
          localObject2 = new GradientDrawable();
          ((GradientDrawable)localObject2).setShape(1);
          ((GradientDrawable)localObject2).setColor(Color.parseColor("#4C000000"));
          ((jai.a)localObject1).E.setImageDrawable((Drawable)localObject2);
          ((jai.a)localObject1).mG = ((TextView)paramView.findViewById(2131374008));
          localObject2 = new StringBuilder("");
          ((StringBuilder)localObject2).append(MultiMembersVideoUI.this.iG.size() - 8 + 1);
          ((StringBuilder)localObject2).append("+");
          ((jai.a)localObject1).mG.setText(((StringBuilder)localObject2).toString());
          ((jai.a)localObject1).mG.setTextColor(-1);
          ((jai.a)localObject1).mG.setVisibility(0);
          ((jai.a)localObject1).name.setText("");
          paramView.setContentDescription(MultiMembersVideoUI.d(MultiMembersVideoUI.this).getString(2131694560));
          localObject1 = paramView;
          break;
          localObject1 = (jai.a)paramView.getTag();
          if (localObject1 != null) {
            break label1272;
          }
          localObject1 = a(paramView);
          break label67;
          localb.Wv = false;
          break label178;
          localb.faceBitmap = null;
          localb.Wv = false;
        }
        long l = localb.uin;
        if (localb.b != null)
        {
          localObject2 = localb.b;
          if ((localObject2 == null) || (((AVPhoneUserInfo)localObject2).telInfo.mobile == null)) {
            break label658;
          }
          localb.name = ((AVPhoneUserInfo)localObject2).telInfo.mobile;
          String str = MultiMembersVideoUI.this.a.dd(((AVPhoneUserInfo)localObject2).telInfo.mobile);
          if (str == null) {
            break label632;
          }
          localb.Ro = aqgv.ps(str);
          localb.name = str;
        }
        for (;;)
        {
          localb.faceBitmap = ((BitmapDrawable)MultiMembersVideoUI.c(MultiMembersVideoUI.this).getDrawable(2130842980)).getBitmap();
          localb.Wv = true;
          break;
          localObject2 = MultiMembersVideoUI.this.a.a(l, MultiMembersVideoUI.this.a.b().ii);
          break label498;
          localb.Ro = null;
          localb.name = jkm.v(((AVPhoneUserInfo)localObject2).telInfo.mobile, 4);
          continue;
          if ((localObject2 != null) && (QLog.isColorLevel())) {
            QLog.d("MultiMembersVideoUI", 2, "getView --> can not get Open Id. PhoneInfo = " + ((AVPhoneUserInfo)localObject2).toString());
          }
          localb.Ro = null;
          localb.name = MultiMembersVideoUI.b(MultiMembersVideoUI.this).getString(2131694561);
        }
        ((jai.a)localObject1).Wx = true;
        ((jai.a)localObject1).uin = localb.uin;
        if (localb.name != null)
        {
          ((jai.a)localObject1).name.setText(localb.name);
          label764:
          if (localb.faceBitmap == null) {
            break label1150;
          }
          if ((localb.accountType == 0) || (localb.Ro == null)) {
            break label1124;
          }
          ((jai.a)localObject1).mG.setVisibility(0);
          ((jai.a)localObject1).mG.setText(localb.Ro);
          localObject2 = ((BitmapDrawable)MultiMembersVideoUI.e(MultiMembersVideoUI.this).getDrawable(2130842937)).getBitmap();
          ((jai.a)localObject1).E.setImageBitmap((Bitmap)localObject2);
          if (((MultiMembersVideoUI.this.a.b().relationType == 1) && (MultiMembersVideoUI.this.a.b().anb == 10)) || (MultiMembersVideoUI.this.a.b().relationType == 2))
          {
            if (!localb.Pk) {
              break label1174;
            }
            if (((jai.a)localObject1).gw.getVisibility() != 0) {
              ((jai.a)localObject1).gw.setVisibility(0);
            }
            if (((jai.a)localObject1).gt.getVisibility() == 0) {
              ((jai.a)localObject1).gt.setVisibility(8);
            }
            localb.Wu = false;
          }
          ((jai.a)localObject1).Pg = localb.Wu;
          if (!((jai.a)localObject1).Pg) {
            break label1198;
          }
          ((jai.a)localObject1).gt.setVisibility(0);
          if (localb.awz != 2) {
            break label1211;
          }
          ((jai.a)localObject1).awy = 5;
        }
        for (;;)
        {
          if ((((jai.a)localObject1).E != null) && (((MultiMembersVideoUI.this.a.b().relationType == 1) && (MultiMembersVideoUI.this.a.b().anb == 10)) || ((MultiMembersVideoUI.this.aqx == 2) && (!localb.Ww))))
          {
            localObject2 = ((jai.a)localObject1).E.getDrawable();
            if ((localObject2 != null) && ((localObject2 instanceof BitmapDrawable)))
            {
              localObject2 = aqhu.b(((BitmapDrawable)localObject2).getBitmap(), true);
              ((jai.a)localObject1).E.setImageBitmap((Bitmap)localObject2);
            }
          }
          localObject1 = paramView;
          break;
          ((jai.a)localObject1).name.setText(String.valueOf(localb.uin));
          break label764;
          ((jai.a)localObject1).mG.setVisibility(8);
          ((jai.a)localObject1).E.setImageBitmap(localb.faceBitmap);
          break label841;
          label1150:
          ((jai.a)localObject1).mG.setVisibility(8);
          ((jai.a)localObject1).E.setImageResource(2130840645);
          break label841;
          if (((jai.a)localObject1).gw.getVisibility() != 0) {
            break label948;
          }
          ((jai.a)localObject1).gw.setVisibility(8);
          break label948;
          ((jai.a)localObject1).gt.setVisibility(8);
          break label975;
          if (localb.Xd) {
            ((jai.a)localObject1).awy = 3;
          } else if (localb.awz == 1) {
            ((jai.a)localObject1).awy = 2;
          } else if (localb.Xc) {
            ((jai.a)localObject1).awy = 1;
          } else {
            ((jai.a)localObject1).awy = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.MultiMembersVideoUI
 * JD-Core Version:    0.7.0.1
 */