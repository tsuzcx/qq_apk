package com.tencent.biz.pubaccount.weishi_new.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import ankt;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.d;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import ooz;
import ota;

public class WSTabLayout
  extends TabLayoutCompat
{
  public static float lC = ankt.dip2px(22.0F);
  public static float lD = ankt.dip2px(15.0F);
  public static float lE = ankt.dip2px(2.0F);
  private a a;
  private ArrayList<String> mg = new ArrayList();
  
  public WSTabLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WSTabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WSTabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    setSelectedTabIndicatorHeight(0);
  }
  
  private static boolean isEquals(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) < 1.0E-013D;
  }
  
  public void setTabContentClickListener(a parama)
  {
    this.a = parama;
  }
  
  public void x(List<String> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("WSTabLayout2", 2, "createTab infos: null");
      }
      ooz.i("WSTabLayout2", "initData list: null");
    }
    label196:
    for (;;)
    {
      return;
      this.mg.clear();
      this.mg.addAll(paramList);
      removeAllTabs();
      label76:
      int i;
      if (this.mg.size() <= 3)
      {
        setTabMode(1);
        setTabGravity(0);
        i = 0;
      }
      for (;;)
      {
        if (i >= this.mg.size()) {
          break label196;
        }
        paramList = a();
        if (paramList == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("WSTabLayout2", 2, "createTab newTab: null");
          return;
          setTabMode(0);
          setTabGravity(1);
          break label76;
        }
        paramList.b(2131560212);
        b localb = new b(paramList.getCustomView());
        localb.setPosition(i);
        paramList.a(localb);
        localb.pU((String)this.mg.get(i));
        d(paramList);
        if (paramInt == i) {
          localb.bgV();
        }
        i += 1;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void uC(int paramInt);
  }
  
  public class b
  {
    private int bfO;
    private TextView fe;
    private int position;
    private TextView vA;
    
    public b(@NonNull View paramView)
    {
      this.fe = ((TextView)paramView.findViewById(2131382353));
      this.vA = ((TextView)paramView.findViewById(2131382350));
      this.fe.setOnClickListener(new ota(this, WSTabLayout.this));
    }
    
    private String bN(int paramInt)
    {
      if (paramInt > 99) {
        return "99+";
      }
      return paramInt + "";
    }
    
    public void bgV()
    {
      this.fe.setTextSize(0, WSTabLayout.lC);
    }
    
    public void bgW()
    {
      this.fe.setTextSize(0, WSTabLayout.lD);
    }
    
    public void d(float paramFloat, boolean paramBoolean)
    {
      if ((paramBoolean) && (WSTabLayout.u(paramFloat, 0.0F))) {
        return;
      }
      float f1 = WSTabLayout.lD;
      float f2 = WSTabLayout.lC;
      float f3 = WSTabLayout.lD;
      this.fe.setTextSize(0, f1 + (f2 - f3) * paramFloat);
    }
    
    public void e(float paramFloat, boolean paramBoolean)
    {
      if ((paramBoolean) && (WSTabLayout.u(paramFloat, 0.0F))) {
        return;
      }
      float f1 = WSTabLayout.lD;
      float f2 = WSTabLayout.lC;
      float f3 = WSTabLayout.lD;
      this.fe.setTextSize(0, f1 + (f2 - f3) * (1.0F - paramFloat));
    }
    
    public void pU(String paramString)
    {
      this.fe.setText(paramString);
    }
    
    public int rR()
    {
      return this.bfO;
    }
    
    public void setPosition(int paramInt)
    {
      this.position = paramInt;
    }
    
    public void uX(int paramInt)
    {
      this.bfO = paramInt;
      if (paramInt > 0)
      {
        this.vA.setVisibility(0);
        String str = bN(paramInt);
        this.vA.setText(str);
        return;
      }
      this.vA.setVisibility(8);
    }
    
    public void uY(int paramInt)
    {
      this.fe.setTextColor(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.WSTabLayout
 * JD-Core Version:    0.7.0.1
 */