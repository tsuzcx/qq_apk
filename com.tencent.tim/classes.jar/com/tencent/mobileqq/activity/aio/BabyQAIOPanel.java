package com.tencent.mobileqq.activity.aio;

import acbs;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqcx;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import xys;

public class BabyQAIOPanel
  extends FrameLayout
  implements View.OnClickListener
{
  private GridView jdField_a_of_type_AndroidWidgetGridView;
  private c jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel$c;
  private xys jdField_a_of_type_Xys;
  private ArrayList<a> iM = new ArrayList();
  private QQAppInterface mApp;
  private Context mContext;
  
  public BabyQAIOPanel(@NonNull Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  public BabyQAIOPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  private void VG()
  {
    this.iM.clear();
    acbs localacbs = (acbs)this.mApp.getBusinessHandler(53);
    int i;
    String str2;
    Object localObject1;
    String str1;
    Object localObject2;
    if ((localacbs.gs != null) && (!localacbs.gs.isEmpty()) && (localacbs.sS != null) && (!localacbs.sS.isEmpty()))
    {
      Iterator localIterator = localacbs.sS.iterator();
      i = 1;
      while (localIterator.hasNext())
      {
        str2 = (String)localIterator.next();
        if (!TextUtils.isEmpty(str2))
        {
          localObject1 = (String[])localacbs.gs.get(str2);
          if ((localObject1 != null) && (localObject1.length == 2))
          {
            str1 = localObject1[0];
            localObject2 = localObject1[1];
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        int j = Integer.parseInt(str1);
        localObject1 = new a();
        ((a)localObject1).name = str2;
        ((a)localObject1).code = j;
        ((a)localObject1).bdk = "1".equalsIgnoreCase((String)localObject2);
        ((a)localObject1).drawable = localacbs.w(j);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("loadDatas | item.drawable is :");
          if (((a)localObject1).drawable != null) {
            break label303;
          }
          str1 = "null";
          QLog.d("Q.BabyQ", 2, str1 + ", itemCode : " + j);
        }
        if (((a)localObject1).drawable == null) {
          break label309;
        }
        this.iM.add(localObject1);
        i = 0;
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.BabyQ", 2, "initDatas|get item code error :  " + str1);
      break;
      label303:
      str1 = "not null";
      continue;
      label309:
      if (localException.equalsIgnoreCase(this.mApp.getApp().getResources().getString(2131691451)))
      {
        ((a)localObject1).drawable = this.mApp.getApp().getResources().getDrawable(2130839301);
        this.iM.add(localObject1);
        i = 0;
      }
      else if (localException.equalsIgnoreCase(this.mApp.getApp().getResources().getString(2131691448)))
      {
        ((a)localObject1).drawable = this.mApp.getApp().getResources().getDrawable(2130839299);
        this.iM.add(localObject1);
        i = 0;
      }
      else if (localException.equalsIgnoreCase(this.mApp.getApp().getResources().getString(2131691449)))
      {
        ((a)localObject1).drawable = this.mApp.getApp().getResources().getDrawable(2130839300);
        this.iM.add(localObject1);
        i = 0;
        continue;
        if (i != 0) {
          bYM();
        }
        return;
        bYM();
        return;
      }
    }
  }
  
  private void bYM()
  {
    a locala = new a();
    locala.bdk = false;
    locala.code = 1;
    locala.name = this.mApp.getApp().getResources().getString(2131691448);
    locala.drawable = this.mApp.getApp().getResources().getDrawable(2130839299);
    this.iM.add(locala);
    locala = new a();
    locala.bdk = false;
    locala.code = 2;
    locala.name = this.mApp.getApp().getResources().getString(2131691449);
    locala.drawable = this.mApp.getApp().getResources().getDrawable(2130839300);
    this.iM.add(locala);
    locala = new a();
    locala.bdk = false;
    locala.code = 3;
    locala.name = this.mApp.getApp().getResources().getString(2131691451);
    locala.drawable = this.mApp.getApp().getResources().getDrawable(2130839301);
    this.iM.add(locala);
  }
  
  public void a(xys paramxys)
  {
    this.mApp = paramxys.getApp();
    this.jdField_a_of_type_Xys = paramxys;
    setBackgroundColor(this.mContext.getResources().getColor(2131165785));
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131368143));
    this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(2);
    VG();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel$c = new c();
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel$c);
  }
  
  public void bYN()
  {
    VG();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel$c != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel$c.notifyDataSetChanged();
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof b)))
    {
      localObject = (b)paramView.getTag();
      String str = ((b)localObject).nameText.getText().toString();
      this.jdField_a_of_type_Xys.a.append(str);
      this.jdField_a_of_type_Xys.send();
      acbs localacbs = (acbs)this.mApp.getBusinessHandler(53);
      if (localacbs.jR(str))
      {
        localacbs.Dn(str);
        bYN();
      }
      anot.a(this.mApp, "dc00898", "", "", "0X800806D", "0X800806D", ((b)localObject).code, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  static class a
  {
    public boolean bdk;
    public int code;
    public Drawable drawable;
    public String name;
  }
  
  static class b
  {
    public RelativeLayout aN;
    public int code;
    public ImageView imageView;
    public TextView nameText;
    public ImageView rZ;
  }
  
  class c
    extends BaseAdapter
  {
    c() {}
    
    public BabyQAIOPanel.a a(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < BabyQAIOPanel.a(BabyQAIOPanel.this).size())) {
        return (BabyQAIOPanel.a)BabyQAIOPanel.a(BabyQAIOPanel.this).get(paramInt);
      }
      return new BabyQAIOPanel.a();
    }
    
    public int getCount()
    {
      return BabyQAIOPanel.a(BabyQAIOPanel.this).size();
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
        paramView = new BabyQAIOPanel.b();
        localView = LayoutInflater.from(BabyQAIOPanel.a(BabyQAIOPanel.this)).inflate(2131558638, paramViewGroup, false);
        paramView.aN = ((RelativeLayout)localView.findViewById(2131369468));
        paramView.imageView = ((ImageView)localView.findViewById(2131368724));
        paramView.nameText = ((TextView)localView.findViewById(2131379420));
        paramView.rZ = ((ImageView)localView.findViewById(2131372314));
        localView.setTag(paramView);
        localObject = (RelativeLayout.LayoutParams)paramView.aN.getLayoutParams();
        if (paramInt % 2 == 0) {
          break label271;
        }
        ((RelativeLayout.LayoutParams)localObject).leftMargin = aqcx.dip2px(BabyQAIOPanel.this.getContext(), 8.0F);
        ((RelativeLayout.LayoutParams)localObject).rightMargin = aqcx.dip2px(BabyQAIOPanel.this.getContext(), 12.0F);
        label145:
        paramView.aN.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = a(paramInt);
        paramView.code = ((BabyQAIOPanel.a)localObject).code;
        paramView.nameText.setText(((BabyQAIOPanel.a)localObject).name);
        paramView.imageView.setImageDrawable(((BabyQAIOPanel.a)localObject).drawable);
        if (!((BabyQAIOPanel.a)localObject).bdk) {
          break label308;
        }
        paramView.rZ.setVisibility(0);
      }
      for (;;)
      {
        localView.setOnClickListener(BabyQAIOPanel.this);
        if (AppSetting.enableTalkBack) {
          localView.setContentDescription(((BabyQAIOPanel.a)localObject).name);
        }
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localObject = (BabyQAIOPanel.b)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject;
        break;
        label271:
        ((RelativeLayout.LayoutParams)localObject).leftMargin = aqcx.dip2px(BabyQAIOPanel.this.getContext(), 12.0F);
        ((RelativeLayout.LayoutParams)localObject).rightMargin = aqcx.dip2px(BabyQAIOPanel.this.getContext(), 8.0F);
        break label145;
        label308:
        paramView.rZ.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BabyQAIOPanel
 * JD-Core Version:    0.7.0.1
 */