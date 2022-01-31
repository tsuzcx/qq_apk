package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class PanelIconLinearLayout
  extends LinearLayout
  implements View.OnClickListener
{
  public static int b = 0;
  public int a;
  public Context a;
  private PanelIconLinearLayout.PanelIconCallback jdField_a_of_type_ComTencentMobileqqActivityAioPanelIconLinearLayout$PanelIconCallback;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ArrayList a;
  private int c = -1;
  
  public PanelIconLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 100;
    setOrientation(0);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setBackgroundResource(2130839230);
    b = AIOUtils.a(40.0F, paramContext.getResources());
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    removeAllViews();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      RedDotImageView localRedDotImageView = new RedDotImageView(this.jdField_a_of_type_AndroidContentContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.weight = 1.0F;
      localLayoutParams.gravity = 16;
      localRedDotImageView.setTag(Integer.valueOf(((int[])this.jdField_a_of_type_JavaUtilArrayList.get(i))[0]));
      localRedDotImageView.setImageResource(((int[])this.jdField_a_of_type_JavaUtilArrayList.get(i))[2]);
      localRedDotImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(((int[])this.jdField_a_of_type_JavaUtilArrayList.get(i))[1]));
      localRedDotImageView.setOnClickListener(this);
      localRedDotImageView.setSelected(false);
      addView(localRedDotImageView, localLayoutParams);
      i += 1;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    int i = paramSessionInfo.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d("PanelIcon", 2, "loadData curType=" + i);
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    int j = paramSessionInfo.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d("PlusPanel", 2, "reload(): type=" + j);
    }
    if (j == 3000)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.a);
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.c);
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.d);
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.f);
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.b);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
        break label1023;
      }
      setCustomHeight(0);
    }
    for (;;)
    {
      a();
      this.c = i;
      return;
      if (j == 1)
      {
        a(AnonymousChatHelper.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString));
        break;
      }
      if ((j == 0) || (ChatActivityUtils.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        if ((1024 == paramSessionInfo.jdField_a_of_type_Int) && (CrmUtils.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.c);
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.d);
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.b);
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.f);
          break;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.a);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.c);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.f);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.e);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.b);
        if (!ChatActivityUtils.a(paramQQAppInterface, paramSessionInfo)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PanelIcon", 2, "loadData curType=" + i + "isSingleWayFriend");
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.a);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.c);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.f);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.b);
        break;
      }
      if ((j == 1000) || (j == 1004) || (j == 1006))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.a);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.c);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.f);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.b);
        break;
      }
      if (j == 1008) {
        break;
      }
      if (j == 1005)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.c);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.f);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.b);
        break;
      }
      if (j == 1003)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.c);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.f);
        break;
      }
      if ((j == 1001) || (j == 1010))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.a);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.c);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.b);
        break;
      }
      if ((j == 1022) || (j == 1023) || (j == 1009) || (j == 1024))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.c);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.f);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.b);
        break;
      }
      if (j == 6000)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.c);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.i);
        if ((((RegisterProxySvcPackHandler)paramQQAppInterface.a(9)).a() == 0) || (!NetworkUtil.g(paramQQAppInterface.a()))) {
          break;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.j);
        break;
      }
      if (j == 1025)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.a);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.c);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.f);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.b);
        break;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.c);
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.d);
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.b);
      break;
      label1023:
      setCustomHeight(b);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.a);
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.c);
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.d);
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.h);
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.b);
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.a);
    this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.c);
    this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.d);
    this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
    this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.f);
    this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.h);
    this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.b);
  }
  
  public void a(boolean paramBoolean, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    a(paramBoolean);
    a();
    if (paramSessionInfo != null)
    {
      this.c = paramSessionInfo.jdField_a_of_type_Int;
      return;
    }
    this.c = 1;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject == null) || (!(localObject instanceof Integer))) {
      return;
    }
    ((Integer)localObject).intValue();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelIconLinearLayout$PanelIconCallback.a(paramView.getTag());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_Int, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), this.jdField_a_of_type_Int);
  }
  
  public void setAllAlpha(float paramFloat)
  {
    int i = 0;
    if (i < getChildCount())
    {
      if (Build.VERSION.SDK_INT >= 11) {
        getChildAt(i).setAlpha(paramFloat);
      }
      for (;;)
      {
        i += 1;
        break;
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
        localAlphaAnimation.setDuration(0L);
        localAlphaAnimation.setFillAfter(true);
        getChildAt(i).startAnimation(localAlphaAnimation);
      }
    }
  }
  
  public void setAllEnable(boolean paramBoolean)
  {
    int i = 0;
    while (i < getChildCount())
    {
      getChildAt(i).setEnabled(paramBoolean);
      i += 1;
    }
  }
  
  public void setAllUnSelected()
  {
    int i = 0;
    while (i < getChildCount())
    {
      getChildAt(i).setSelected(false);
      i += 1;
    }
  }
  
  public void setChildAlpha(int paramInt, float paramFloat)
  {
    View localView = findViewWithTag(Integer.valueOf(paramInt));
    if (localView != null)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        localView.setAlpha(paramFloat);
      }
    }
    else {
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
    localAlphaAnimation.setDuration(0L);
    localAlphaAnimation.setFillAfter(true);
    localView.startAnimation(localAlphaAnimation);
  }
  
  public void setChildContentDescription(int paramInt, String paramString)
  {
    View localView = findViewWithTag(Integer.valueOf(paramInt));
    if (localView != null) {
      localView.setContentDescription(paramString);
    }
  }
  
  public void setChildImageSource(int paramInt1, int paramInt2)
  {
    ImageView localImageView = (ImageView)findViewWithTag(Integer.valueOf(paramInt1));
    if (localImageView != null) {
      localImageView.setImageResource(paramInt2);
    }
  }
  
  public void setChildVisible(int paramInt1, int paramInt2)
  {
    View localView = findViewWithTag(Integer.valueOf(paramInt1));
    if (localView != null) {
      localView.setVisibility(paramInt2);
    }
  }
  
  public void setCustomHeight(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    requestLayout();
  }
  
  public void setEnable(int paramInt, boolean paramBoolean)
  {
    View localView = findViewWithTag(Integer.valueOf(paramInt));
    if (localView != null) {
      localView.setEnabled(paramBoolean);
    }
  }
  
  public void setPanelIconListener(PanelIconLinearLayout.PanelIconCallback paramPanelIconCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelIconLinearLayout$PanelIconCallback = paramPanelIconCallback;
  }
  
  public void setSelected(int paramInt)
  {
    int i = 0;
    if (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (localView.getTag().equals(Integer.valueOf(paramInt))) {
        localView.setSelected(true);
      }
      for (;;)
      {
        i += 1;
        break;
        localView.setSelected(false);
      }
    }
  }
  
  public void setShowRed(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      if (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (localView.getTag().equals(Integer.valueOf(paramInt))) {
          ((RedDotImageView)localView).a(paramBoolean);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public void setUnSelected(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      if (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (localView.getTag().equals(Integer.valueOf(paramInt))) {
          localView.setSelected(false);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PanelIconLinearLayout
 * JD-Core Version:    0.7.0.1
 */