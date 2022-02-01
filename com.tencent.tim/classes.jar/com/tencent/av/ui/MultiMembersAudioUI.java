package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import iiv;
import jaf;
import jag;
import jah;
import jai;
import jai.a;
import jai.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import jka;
import jkm;
import jll;
import mqq.app.BaseActivity;
import wja;

public class MultiMembersAudioUI
  extends LinearLayout
  implements jai
{
  boolean WY = false;
  boolean WZ = false;
  VideoController jdField_a_of_type_ComTencentAvVideoController = null;
  a jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI$a;
  public jka a;
  public int aqx = 0;
  int awx = 0;
  MultiMembersAudioIndicator b;
  final int[] cH = { 2131371220, 2131371221, 2131371222, 2131371223, 2131371224, 2131371225, 2131371226, 2131371227 };
  public ArrayList<jai.b> iG = new ArrayList();
  VideoAppInterface mApp = null;
  WeakReference<Context> mContext = null;
  View.OnClickListener mOnClickListener = new jaf(this);
  ViewPager mViewPager;
  long md = 0L;
  
  @TargetApi(9)
  public MultiMembersAudioUI(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Jka = null;
    super.setOrientation(1);
    this.mContext = new WeakReference(paramContext);
    paramContext = (BaseActivity)this.mContext.get();
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersAudioUI", 2, "MVMembersContolUI-->can not get activity");
      }
      return;
    }
    this.mApp = ((VideoAppInterface)paramContext.getAppRuntime());
    if (this.mApp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersAudioUI", 2, "MVMembersContolUI-->can not get AppRuntime");
      }
      paramContext.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.mApp.b();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersAudioUI", 2, "MVMembersContolUI-->can not get videoControl");
      }
      paramContext.finish();
      return;
    }
    int i = (int)jll.dp2px(getContext(), 170.0F);
    this.mViewPager = new ViewPager(super.getContext());
    paramContext = new LinearLayout.LayoutParams(-1, i);
    this.mViewPager.setLayoutParams(paramContext);
    this.mViewPager.setFocusable(false);
    this.mViewPager.setFocusableInTouchMode(false);
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI$a = new a();
    this.mViewPager.setAdapter(this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI$a);
    super.addView(this.mViewPager);
    this.b = new MultiMembersAudioIndicator(super.getContext());
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    this.b.setLayoutParams(paramContext);
    this.b.setViewPager(this.mViewPager);
    super.addView(this.b);
  }
  
  private void b(ImageView paramImageView, int paramInt)
  {
    if (paramImageView != null) {
      paramImageView.setVisibility(paramInt);
    }
  }
  
  private boolean cy(int paramInt)
  {
    if ((paramInt >= 8) || ((this.iG.size() == 8) && (paramInt == 7)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersAudioUI", 2, "[random room owner] member is null index=" + paramInt + ",uin=");
      }
      return true;
    }
    return false;
  }
  
  public void H(long paramLong, boolean paramBoolean)
  {
    int i = v(paramLong);
    if (i == -1) {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersAudioUI", 2, "notifyDataSetChanged-->this member not in infoList.uin=" + paramLong + ",bSpeak=" + paramBoolean);
      }
    }
    label330:
    label507:
    for (;;)
    {
      return;
      jai.b localb = (jai.b)this.iG.get(i);
      if (localb.Wu != paramBoolean)
      {
        localb.Wu = paramBoolean;
        Object localObject = t(i);
        if (localObject != null) {
          if (((View)localObject).getTag() == null)
          {
            if (QLog.isColorLevel()) {
              QLog.e("MultiMembersAudioUI", 2, "notifyDataSetChanged-->can not get tag from uin-->index=" + i + ",uin=" + paramLong + ",isSpeak=" + paramBoolean);
            }
          }
          else
          {
            localObject = (jai.a)((View)localObject).getTag();
            if (localObject != null)
            {
              boolean bool;
              if ((this.jdField_a_of_type_ComTencentAvVideoController.b().relationType != 1) || (this.jdField_a_of_type_ComTencentAvVideoController.b().anb != 10))
              {
                bool = paramBoolean;
                if (this.jdField_a_of_type_ComTencentAvVideoController.b().relationType != 2) {}
              }
              else
              {
                if (!localb.Pk) {
                  break label402;
                }
                if (((jai.a)localObject).gw.getVisibility() != 0) {
                  ((jai.a)localObject).gw.setVisibility(0);
                }
                if (((jai.a)localObject).gt.getVisibility() == 0)
                {
                  ((jai.a)localObject).gt.setVisibility(8);
                  b(((jai.a)localObject).gu, 8);
                }
                localb.Wu = false;
                bool = false;
              }
              if ((bool) && (((jai.a)localObject).Wx))
              {
                if (((jai.a)localObject).gt.getVisibility() != 0)
                {
                  ((jai.a)localObject).gt.setVisibility(0);
                  b(((jai.a)localObject).gu, 0);
                }
                if (this.aqx != 7) {
                  continue;
                }
                ((jai.a)localObject).alX = localb.alX;
                switch (((jai.a)localObject).alX)
                {
                }
              }
              for (;;)
              {
                if (((jai.a)localObject).alX == 0) {
                  break label507;
                }
                ((jai.a)localObject).gv.setVisibility(0);
                return;
                bool = paramBoolean;
                if (((jai.a)localObject).gw.getVisibility() != 0) {
                  break;
                }
                ((jai.a)localObject).gw.setVisibility(8);
                bool = paramBoolean;
                break;
                if (((jai.a)localObject).gt.getVisibility() != 0) {
                  break label330;
                }
                ((jai.a)localObject).gt.setVisibility(8);
                b(((jai.a)localObject).gu, 8);
                break label330;
                ((jai.a)localObject).gv.setImageResource(2130842757);
                continue;
                ((jai.a)localObject).gv.setImageResource(2130842761);
                continue;
                ((jai.a)localObject).gv.setImageResource(2130842759);
              }
            }
          }
        }
      }
    }
  }
  
  int K(int paramInt1, int paramInt2)
  {
    if (paramInt2 > paramInt1 - 1) {
      return -1;
    }
    switch (paramInt1)
    {
    default: 
      return -1;
    case 1: 
      return this.cH[0];
    case 2: 
      return this.cH[paramInt2];
    case 3: 
      return this.cH[paramInt2];
    case 4: 
      if (paramInt2 < 2) {
        return this.cH[paramInt2];
      }
      return this.cH[(paramInt2 + 2)];
    case 5: 
      if (paramInt2 < 3) {
        return this.cH[paramInt2];
      }
      return this.cH[(paramInt2 + 1)];
    case 6: 
      if (paramInt2 < 3) {
        return this.cH[paramInt2];
      }
      return this.cH[(paramInt2 + 1)];
    }
    return this.cH[paramInt2];
  }
  
  jai.a a(View paramView)
  {
    jai.a locala = new jai.a();
    locala.E = ((ImageView)paramView.findViewById(2131374006));
    locala.name = ((TextView)paramView.findViewById(2131374022));
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().relationType == 7) {
      locala.name.setVisibility(4);
    }
    boolean bool;
    if (this.WZ)
    {
      bool = ThemeUtil.isInNightMode(this.mApp);
      if (!bool) {
        break label262;
      }
      locala.name.setTextColor(Color.parseColor("#A8A8A8"));
    }
    for (;;)
    {
      if (bool)
      {
        locala.gu = ((ImageView)paramView.findViewById(2131374025));
        int i = wja.dp2px(15.0F, getResources());
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setShape(1);
        localGradientDrawable.setColor(Color.parseColor("#4C000000"));
        localGradientDrawable.setSize(i, i);
        locala.gu.setBackgroundDrawable(localGradientDrawable);
      }
      locala.gt = ((ImageView)paramView.findViewById(2131374024));
      locala.gv = ((ImageView)paramView.findViewById(2131374012));
      locala.mG = ((TextView)paramView.findViewById(2131374008));
      locala.gw = ((ImageView)paramView.findViewById(2131374021));
      locala.ed = ((RelativeLayout)paramView.findViewById(2131374159));
      locala.gx = ((ImageView)paramView.findViewById(2131374007));
      return locala;
      label262:
      locala.name.setTextColor(Color.parseColor("#445a6c"));
    }
  }
  
  public void asZ()
  {
    int k = 0;
    if (this.iG == null) {
      return;
    }
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.awx)
      {
        if (!((jai.b)this.iG.get(i)).Wv) {
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI$a.notifyDataSetChanged();
        return;
      }
      i += 1;
    }
  }
  
  public void b(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMembersAudioUI", 2, "initMVMLayout relationUin: " + paramLong + ", relationType: " + paramInt + ", bEnterPage: " + paramBoolean);
    }
    this.md = paramLong;
    this.aqx = paramInt;
  }
  
  public void bC(ArrayList<VideoController.b> paramArrayList)
  {
    bD(paramArrayList);
    this.b.refreshIndicator();
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI$a.notifyDataSetChanged();
  }
  
  void bD(ArrayList<VideoController.b> paramArrayList)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("refreshDataSource, friends[");
      if (paramArrayList == null) {
        break label211;
      }
    }
    label211:
    for (int i = paramArrayList.size();; i = -1)
    {
      QLog.w("MultiMembersAudioUI", 1, i + "], mInfoList[" + this.iG.size() + "]");
      this.iG.clear();
      if (paramArrayList == null) {
        break;
      }
      i = 0;
      while (i < paramArrayList.size())
      {
        localObject = (VideoController.b)paramArrayList.get(i);
        jai.b localb = new jai.b();
        localb.uin = ((VideoController.b)localObject).uin;
        localb.awz = ((VideoController.b)localObject).alV;
        localb.Xc = ((VideoController.b)localObject).Ph;
        localb.Wu = ((VideoController.b)localObject).Pg;
        localb.Xd = ((VideoController.b)localObject).Pi;
        localb.accountType = ((VideoController.b)localObject).accountType;
        localb.b = ((VideoController.b)localObject).a;
        localb.Pk = ((VideoController.b)localObject).Pk;
        localb.alX = ((VideoController.b)localObject).alX;
        localb.Ww = ((VideoController.b)localObject).Pn;
        this.iG.add(localb);
        i += 1;
      }
    }
    this.awx = this.iG.size();
    if (((this.aqx == 1) || (this.aqx == 2)) && (this.iG.size() > 8)) {
      this.awx = 8;
    }
  }
  
  public void c(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    QLog.d("MultiMembersAudioUI", 2, "refreshMemMicState. uin = " + paramLong + ", accType = " + paramInt1 + ", pstnStatus = " + paramInt2 + ", isMicOff = " + paramBoolean);
    paramInt1 = v(paramLong);
    if (paramInt1 == -1) {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersAudioUI", 2, "notifyDataSetChanged-->this member not in infoList.uin=" + paramLong + ",isMicOff=" + paramBoolean);
      }
    }
    jai.b localb;
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              localb = (jai.b)this.iG.get(paramInt1);
            } while (localb.Pk == paramBoolean);
            localb.Pk = paramBoolean;
            localObject = t(paramInt1);
          } while (localObject == null);
          if (((View)localObject).getTag() != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("MultiMembersAudioUI", 2, "notifyDataSetChanged-->can not get tag from uin-->index=" + paramInt1 + ",uin=" + paramLong + ",isMicOff=" + paramBoolean);
        return;
        localObject = (jai.a)((View)localObject).getTag();
      } while (localObject == null);
      if (!paramBoolean) {
        break;
      }
      if (((jai.a)localObject).gt.getVisibility() == 0)
      {
        ((jai.a)localObject).gt.setVisibility(8);
        b(((jai.a)localObject).gu, 8);
      }
    } while (((jai.a)localObject).gw.getVisibility() == 0);
    ((jai.a)localObject).gw.setVisibility(0);
    return;
    if (((jai.a)localObject).gw.getVisibility() == 0) {
      ((jai.a)localObject).gw.setVisibility(8);
    }
    if (localb.Wu)
    {
      ((jai.a)localObject).gt.setVisibility(0);
      b(((jai.a)localObject).gu, 0);
      return;
    }
    ((jai.a)localObject).gt.setVisibility(8);
    b(((jai.a)localObject).gu, 8);
  }
  
  public void setIsEnterpage(boolean paramBoolean)
  {
    this.WZ = paramBoolean;
  }
  
  public void setOnItemClickListener(jka paramjka)
  {
    this.jdField_a_of_type_Jka = paramjka;
  }
  
  public void setRandomMultiIsMask(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMembersAudioUI", 2, "setRandomMultiIsMask isMask: " + paramBoolean);
    }
    this.WY = paramBoolean;
  }
  
  View t(int paramInt)
  {
    if (this.iG == null) {}
    while ((cy(paramInt)) || (paramInt < 0) || (paramInt >= this.awx) || (this.mViewPager == null) || (this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI$a == null)) {
      return null;
    }
    int j = (paramInt + 1) / 8;
    int i;
    if ((paramInt + 1) % 8 == 0)
    {
      i = 0;
      label61:
      j = i + j - 1;
      i = 8;
      if (j == this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI$a.getCount() - 1) {
        i = this.awx - j * 8;
      }
    }
    for (;;)
    {
      for (;;)
      {
        View localView;
        Object localObject;
        try
        {
          localView = this.mViewPager.findViewWithTag("MemberPagerAdapter_" + j);
          if (localView != null) {
            localView = localView.findViewById(K(i, paramInt + 1 - j * 8 - 1));
          }
        }
        catch (Exception localException1)
        {
          boolean bool;
          localView = null;
        }
        try
        {
          localObject = (jai.a)localView.getTag();
          if (localObject == null) {
            break;
          }
          bool = ((jai.a)localObject).Xa;
          if (bool) {
            break;
          }
          localObject = localView;
          return localObject;
        }
        catch (Exception localException2)
        {
          label214:
          break label214;
        }
      }
      i = 1;
      break label61;
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersAudioUI", 2, "[random room owner] page is null");
      }
      localObject = null;
      continue;
      localObject = localView;
      if (QLog.isColorLevel())
      {
        QLog.e("MultiMembersAudioUI", 2, "[random room owner] " + localException1.getMessage());
        localObject = localView;
      }
    }
  }
  
  public int v(long paramLong)
  {
    int j;
    if (this.iG == null)
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.awx) {
        break label52;
      }
      j = i;
      if (((jai.b)this.iG.get(i)).uin == paramLong) {
        break;
      }
      i += 1;
    }
    label52:
    return -1;
  }
  
  void x(View paramView, int paramInt)
  {
    if (paramView == null) {}
    View localView1;
    View localView2;
    View localView3;
    View localView4;
    View localView5;
    View localView6;
    View localView7;
    View localView8;
    View localView9;
    do
    {
      return;
      localView1 = paramView.findViewById(2131364939);
      localView2 = paramView.findViewById(2131364940);
      localView3 = paramView.findViewById(2131371220);
      localView4 = paramView.findViewById(2131371221);
      localView5 = paramView.findViewById(2131371222);
      localView6 = paramView.findViewById(2131371223);
      localView7 = paramView.findViewById(2131371224);
      localView8 = paramView.findViewById(2131371225);
      localView9 = paramView.findViewById(2131371226);
      paramView = paramView.findViewById(2131371227);
    } while ((localView1 == null) || (localView2 == null) || (localView3 == null) || (localView4 == null) || (localView5 == null) || (localView6 == null) || (localView7 == null) || (localView8 == null) || (localView9 == null) || (paramView == null));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView1.getLayoutParams();
    switch (paramInt)
    {
    default: 
      localView1.setVisibility(8);
      localView2.setVisibility(8);
      return;
    case 1: 
      localView1.setVisibility(0);
      localView3.setVisibility(0);
      localView4.setVisibility(8);
      localView5.setVisibility(8);
      localView6.setVisibility(8);
      localLayoutParams.addRule(15);
      localLayoutParams.addRule(10, 0);
      localView1.setLayoutParams(localLayoutParams);
      localView2.setVisibility(8);
      return;
    case 2: 
      localView1.setVisibility(0);
      localView3.setVisibility(0);
      localView4.setVisibility(0);
      localView5.setVisibility(8);
      localView6.setVisibility(8);
      localLayoutParams.addRule(15);
      localLayoutParams.addRule(10, 0);
      localView1.setLayoutParams(localLayoutParams);
      localView2.setVisibility(8);
      return;
    case 3: 
      localView1.setVisibility(0);
      localView3.setVisibility(0);
      localView4.setVisibility(0);
      localView5.setVisibility(0);
      localView6.setVisibility(8);
      localLayoutParams.addRule(15);
      localLayoutParams.addRule(10, 0);
      localView1.setLayoutParams(localLayoutParams);
      localView2.setVisibility(8);
      return;
    case 4: 
      localView1.setVisibility(0);
      localView3.setVisibility(0);
      localView4.setVisibility(0);
      localView5.setVisibility(8);
      localView6.setVisibility(8);
      localLayoutParams.addRule(15, 0);
      localLayoutParams.addRule(10);
      localView1.setLayoutParams(localLayoutParams);
      localView2.setVisibility(0);
      localView7.setVisibility(0);
      localView8.setVisibility(0);
      localView9.setVisibility(8);
      paramView.setVisibility(8);
      return;
    case 5: 
      localView1.setVisibility(0);
      localView3.setVisibility(0);
      localView4.setVisibility(0);
      localView5.setVisibility(0);
      localView6.setVisibility(8);
      localLayoutParams.addRule(15, 0);
      localLayoutParams.addRule(10);
      localView1.setLayoutParams(localLayoutParams);
      localView2.setVisibility(0);
      localView7.setVisibility(0);
      localView8.setVisibility(0);
      localView9.setVisibility(8);
      paramView.setVisibility(8);
      return;
    case 6: 
      localView1.setVisibility(0);
      localView3.setVisibility(0);
      localView4.setVisibility(0);
      localView5.setVisibility(0);
      localView6.setVisibility(8);
      localLayoutParams.addRule(15, 0);
      localLayoutParams.addRule(10);
      localView1.setLayoutParams(localLayoutParams);
      localView2.setVisibility(0);
      localView7.setVisibility(0);
      localView8.setVisibility(0);
      localView9.setVisibility(0);
      paramView.setVisibility(8);
      return;
    case 7: 
      localView1.setVisibility(0);
      localView3.setVisibility(0);
      localView4.setVisibility(0);
      localView5.setVisibility(0);
      localView6.setVisibility(0);
      localLayoutParams.addRule(15, 0);
      localLayoutParams.addRule(10);
      localView1.setLayoutParams(localLayoutParams);
      localView2.setVisibility(0);
      localView7.setVisibility(0);
      localView8.setVisibility(0);
      localView9.setVisibility(0);
      paramView.setVisibility(8);
      return;
    }
    localView1.setVisibility(0);
    localView3.setVisibility(0);
    localView4.setVisibility(0);
    localView5.setVisibility(0);
    localView6.setVisibility(0);
    localLayoutParams.addRule(15, 0);
    localLayoutParams.addRule(10);
    localView1.setLayoutParams(localLayoutParams);
    localView2.setVisibility(0);
    localView7.setVisibility(0);
    localView8.setVisibility(0);
    localView9.setVisibility(0);
    paramView.setVisibility(0);
  }
  
  public class a
    extends PagerAdapter
  {
    a() {}
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      paramViewGroup.removeView((View)paramObject);
    }
    
    public int getCount()
    {
      int i = 0;
      if (MultiMembersAudioUI.this.iG == null) {
        return 0;
      }
      int j = MultiMembersAudioUI.this.awx / 8;
      if (MultiMembersAudioUI.this.awx % 8 == 0) {}
      for (;;)
      {
        return i + j;
        i = 1;
      }
    }
    
    public int getItemPosition(Object paramObject)
    {
      return -2;
    }
    
    @TargetApi(11)
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      if ((!QLog.isColorLevel()) || ((MultiMembersAudioUI.this.iG == null) || (MultiMembersAudioUI.this.awx == 0)))
      {
        if (QLog.isColorLevel()) {}
        return null;
      }
      View localView1 = View.inflate(paramViewGroup.getContext(), 2131559936, null);
      Object localObject1;
      if (AudioHelper.jY(0) == 1)
      {
        localView1.setBackgroundColor(2130706687);
        localView1.addOnLayoutChangeListener(new jag(this));
        if (paramViewGroup.getTag(2131368926) == null)
        {
          paramViewGroup.setBackgroundColor(-553615360);
          localObject1 = new jah(this);
          paramViewGroup.addOnLayoutChangeListener((View.OnLayoutChangeListener)localObject1);
          paramViewGroup.setTag(2131368926, localObject1);
        }
      }
      if (paramInt == getCount() - 1) {}
      for (int i = MultiMembersAudioUI.this.awx - paramInt * 8;; i = 8)
      {
        MultiMembersAudioUI.this.x(localView1, i);
        int j = 0;
        int k;
        if (j < i)
        {
          k = paramInt * 8 + j;
          if (k <= MultiMembersAudioUI.this.awx - 1) {}
        }
        else
        {
          localView1.setTag("MemberPagerAdapter_" + paramInt);
          paramViewGroup.addView(localView1);
          return localView1;
        }
        jai.b localb = (jai.b)MultiMembersAudioUI.this.iG.get(k);
        if (localb == null) {}
        View localView2;
        do
        {
          int m;
          do
          {
            j += 1;
            break;
            m = MultiMembersAudioUI.this.K(i, j);
          } while (m == -1);
          localView2 = localView1.findViewById(m);
        } while (localView2 == null);
        jai.a locala = MultiMembersAudioUI.this.a(localView2);
        locala.Xb = localb.Ww;
        localView2.setTag(locala);
        if (MultiMembersAudioUI.this.mOnClickListener != null) {
          localView2.setOnClickListener(MultiMembersAudioUI.this.mOnClickListener);
        }
        Object localObject2;
        if ((localb.name == null) || (localb.faceBitmap == null) || (!localb.Wv))
        {
          if (localb.accountType != 0) {
            break label967;
          }
          localObject1 = String.valueOf(localb.uin);
          if (MultiMembersAudioUI.this.aqx != 7) {
            break label870;
          }
          localObject2 = MultiMembersAudioUI.this.a.a((String)localObject1);
          if (localObject2 != null)
          {
            if (!MultiMembersAudioUI.this.WY) {
              break label857;
            }
            localb.name = ((VideoController.b)localObject2).MB;
            label417:
            if ((((String)localObject1).equals(MultiMembersAudioUI.this.mApp.getCurrentAccountUin())) && (localb.name != null)) {
              localb.name += MultiMembersAudioUI.this.getResources().getString(2131697951);
            }
          }
          label481:
          if (localb.name == null) {
            localb.name = ((String)localObject1);
          }
          if (localb.name.compareTo((String)localObject1) == 0) {
            break label907;
          }
          localb.Wv = true;
          label515:
          if (MultiMembersAudioUI.this.aqx != 7) {
            break label916;
          }
          localObject2 = MultiMembersAudioUI.this.a.b((String)localObject1, MultiMembersAudioUI.this.WY);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject2 = new BitmapFactory.Options();
            ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
            localObject1 = BitmapFactory.decodeResource(MultiMembersAudioUI.this.getResources(), 2130843072, (BitmapFactory.Options)localObject2);
            ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
          }
        }
        try
        {
          localObject2 = BitmapFactory.decodeResource(MultiMembersAudioUI.this.getResources(), 2130843072, (BitmapFactory.Options)localObject2);
          localObject1 = localObject2;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          label614:
          label620:
          long l;
          break label614;
        }
        localb.Wv = false;
        if (localObject1 != null) {
          localb.faceBitmap = ((Bitmap)localObject1);
        }
        for (;;)
        {
          if (((MultiMembersAudioUI.this.aqx != 1) && (MultiMembersAudioUI.this.aqx != 2) && (MultiMembersAudioUI.this.aqx != 7)) || (k != 7) || (MultiMembersAudioUI.this.iG.size() <= 8)) {
            break label1218;
          }
          locala.Wx = false;
          localObject1 = new GradientDrawable();
          ((GradientDrawable)localObject1).setShape(1);
          ((GradientDrawable)localObject1).setColor(Color.parseColor("#4C000000"));
          locala.E.setImageDrawable((Drawable)localObject1);
          locala.mG = ((TextView)localView2.findViewById(2131374008));
          localObject1 = new StringBuilder("");
          ((StringBuilder)localObject1).append(MultiMembersAudioUI.this.iG.size() - 8 + 1);
          ((StringBuilder)localObject1).append("+");
          locala.mG.setText(((StringBuilder)localObject1).toString());
          locala.mG.setTextColor(-1);
          locala.mG.setVisibility(0);
          locala.name.setText("");
          locala.Xa = true;
          localView2.setContentDescription(MultiMembersAudioUI.this.getResources().getString(2131694560));
          break;
          label857:
          localb.name = ((VideoController.b)localObject2).name;
          break label417;
          label870:
          localb.name = MultiMembersAudioUI.this.a.d((String)localObject1, String.valueOf(MultiMembersAudioUI.this.md), MultiMembersAudioUI.this.aqx);
          break label481;
          label907:
          localb.Wv = false;
          break label515;
          label916:
          localObject1 = MultiMembersAudioUI.this.a.a((String)localObject1, String.valueOf(MultiMembersAudioUI.this.md), MultiMembersAudioUI.this.aqx, false, true);
          break label620;
          localb.faceBitmap = null;
          localb.Wv = false;
        }
        label967:
        l = localb.uin;
        if (localb.b != null)
        {
          localObject1 = localb.b;
          label989:
          if ((localObject1 == null) || (((AVPhoneUserInfo)localObject1).telInfo.mobile == null)) {
            break label1149;
          }
          localb.name = ((AVPhoneUserInfo)localObject1).telInfo.mobile;
          localObject2 = MultiMembersAudioUI.this.a.dd(((AVPhoneUserInfo)localObject1).telInfo.mobile);
          if (localObject2 == null) {
            break label1123;
          }
          localb.Ro = aqgv.ps((String)localObject2);
          localb.name = ((String)localObject2);
        }
        for (;;)
        {
          localb.faceBitmap = ((BitmapDrawable)MultiMembersAudioUI.this.getResources().getDrawable(2130842980)).getBitmap();
          localb.Wv = true;
          break;
          localObject1 = MultiMembersAudioUI.this.a.a(l, MultiMembersAudioUI.this.a.b().ii);
          break label989;
          label1123:
          localb.Ro = null;
          localb.name = jkm.v(((AVPhoneUserInfo)localObject1).telInfo.mobile, 4);
          continue;
          label1149:
          if ((localObject1 != null) && (QLog.isColorLevel())) {
            QLog.d("MemberPagerAdapter", 2, "getView --> can not get Open Id. PhoneInfo = " + ((AVPhoneUserInfo)localObject1).toString());
          }
          localb.Ro = null;
          localb.name = MultiMembersAudioUI.this.getResources().getString(2131694561);
        }
        label1218:
        if (MultiMembersAudioUI.this.aqx == 7) {
          locala.alX = localb.alX;
        }
        switch (locala.alX)
        {
        case 3: 
        default: 
          label1276:
          if (locala.alX != 0) {
            locala.gv.setVisibility(0);
          }
          if (String.valueOf(localb.uin).endsWith(MultiMembersAudioUI.this.mApp.getCurrentAccountUin()))
          {
            locala.name.setTextColor(MultiMembersAudioUI.this.getResources().getColor(2131165563));
            label1338:
            locala.Wx = true;
            locala.uin = localb.uin;
            l = localb.uin;
            if (localb.name == null) {
              break label1966;
            }
            locala.name.setText(localb.name);
            if ((MultiMembersAudioUI.this.a.b().relationType == 7) && (!locala.name.isShown()) && (!localb.name.equals(String.valueOf(l)))) {
              locala.name.setVisibility(0);
            }
            label1436:
            if (localb.faceBitmap == null) {
              break label2049;
            }
            if ((localb.accountType == 0) || (localb.Ro == null)) {
              break label2023;
            }
            locala.mG.setVisibility(0);
            locala.mG.setText(localb.Ro);
            localObject1 = ((BitmapDrawable)MultiMembersAudioUI.this.getResources().getDrawable(2130842937)).getBitmap();
            locala.E.setImageBitmap((Bitmap)localObject1);
            label1513:
            if (((MultiMembersAudioUI.this.a.b().relationType == 1) && (MultiMembersAudioUI.this.a.b().anb == 10)) || (MultiMembersAudioUI.this.a.b().relationType == 2) || (MultiMembersAudioUI.this.a.b().relationType == 7))
            {
              if (!localb.Pk) {
                break label2073;
              }
              if (locala.gw.getVisibility() != 0) {
                locala.gw.setVisibility(0);
              }
              if (locala.gt.getVisibility() == 0)
              {
                locala.gt.setVisibility(8);
                MultiMembersAudioUI.a(MultiMembersAudioUI.this, locala.gu, 8);
              }
              localb.Wu = false;
            }
            label1652:
            locala.Pg = localb.Wu;
            if (!locala.Pg) {
              break label2097;
            }
            locala.gt.setVisibility(0);
            MultiMembersAudioUI.a(MultiMembersAudioUI.this, locala.gu, 0);
            label1692:
            if (localb.awz != 2) {
              break label2124;
            }
            locala.awy = 5;
          }
          break;
        }
        for (;;)
        {
          if ((MultiMembersAudioUI.this.WZ) && (ThemeUtil.isInNightMode(MultiMembersAudioUI.this.mApp)) && (locala.E != null))
          {
            localObject1 = locala.E.getDrawable();
            if ((localObject1 != null) && ((localObject1 instanceof BitmapDrawable)))
            {
              localObject1 = jll.a(((BitmapDrawable)localObject1).getBitmap(), "#4C000000", true);
              locala.E.setImageBitmap((Bitmap)localObject1);
            }
          }
          if ((locala.E == null) || (((MultiMembersAudioUI.this.a.b().relationType != 1) || (MultiMembersAudioUI.this.a.b().anb != 10)) && ((MultiMembersAudioUI.this.aqx != 2) || (locala.Xb)))) {
            break;
          }
          localObject1 = locala.E.getDrawable();
          if ((localObject1 == null) || (!(localObject1 instanceof BitmapDrawable))) {
            break;
          }
          localObject1 = aqhu.b(((BitmapDrawable)localObject1).getBitmap(), true);
          locala.E.setImageBitmap((Bitmap)localObject1);
          break;
          locala.gv.setImageResource(2130842757);
          break label1276;
          locala.gv.setImageResource(2130842761);
          break label1276;
          locala.gv.setImageResource(2130842759);
          break label1276;
          locala.name.setTextColor(MultiMembersAudioUI.this.getResources().getColor(2131167654));
          break label1338;
          label1966:
          if ((MultiMembersAudioUI.this.a.b().relationType == 7) && (locala.name.isShown())) {
            locala.name.setVisibility(4);
          }
          locala.name.setText(String.valueOf(localb.uin));
          break label1436;
          label2023:
          locala.mG.setVisibility(8);
          locala.E.setImageBitmap(localb.faceBitmap);
          break label1513;
          label2049:
          locala.mG.setVisibility(8);
          locala.E.setImageResource(2130840645);
          break label1513;
          label2073:
          if (locala.gw.getVisibility() != 0) {
            break label1652;
          }
          locala.gw.setVisibility(8);
          break label1652;
          label2097:
          locala.gt.setVisibility(8);
          MultiMembersAudioUI.a(MultiMembersAudioUI.this, locala.gu, 8);
          break label1692;
          label2124:
          if (localb.Xd) {
            locala.awy = 3;
          } else if (localb.awz == 1) {
            locala.awy = 2;
          } else if (localb.Xc) {
            locala.awy = 1;
          } else {
            locala.awy = 0;
          }
        }
      }
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.MultiMembersAudioUI
 * JD-Core Version:    0.7.0.1
 */