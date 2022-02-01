package com.tencent.mobileqq.activity.aio.doodle.control;

import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import anot;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo;
import com.tencent.mobileqq.scribble.ScribbleResMgr.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;
import wja;
import wrq;
import wsk;
import wsm;
import wso;

public class ColorPicker
  extends RDBaseListLayout<a, c>
  implements View.OnClickListener, ScribbleResMgr.b
{
  private b a;
  private final int[] hr = { -16777216, -5789785, -845543, -27392, -274353, -10233288, -9576193, -6989057 };
  
  public ColorPicker(Context paramContext)
  {
    super(paramContext);
    cn(1);
  }
  
  public ColorPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    cn(1);
  }
  
  public ColorPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    cn(1);
  }
  
  public static String cB(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case -16777216: 
      return acfp.m(2131704174);
    case -5789785: 
      return acfp.m(2131704166);
    case -2148308: 
    case -845543: 
      return acfp.m(2131704170);
    case -1009097: 
    case -27392: 
      return acfp.m(2131704173);
    case -274353: 
      return acfp.m(2131704165);
    case -10233288: 
    case -8136876: 
      return acfp.m(2131704171);
    case -13338378: 
    case -9576193: 
      return acfp.m(2131704172);
    case -6989057: 
      return acfp.m(2131704167);
    }
    return acfp.m(2131704168);
  }
  
  private void cbu()
  {
    int i = 0;
    while (i < this.hr.length)
    {
      c(new a(0, -1, this.hr[i]), false);
      i += 1;
    }
  }
  
  private void cbv()
  {
    Object localObject = wrq.a().D(0);
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        if (!wrq.a().ay(0, localInteger.intValue()))
        {
          wrq.a().a(0, localInteger.intValue(), this, this);
          wrq.a().b(0, localInteger.intValue(), this, this);
        }
        else
        {
          c(new a(1, localInteger.intValue(), -1), false);
        }
      }
    }
  }
  
  public boolean RI()
  {
    cbv();
    cbu();
    return true;
  }
  
  public c a(int paramInt, a parama)
  {
    c localc = new c();
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(wja.dp2px(32.0F, getResources()), -1));
    paramInt = wja.dp2px(4.0F, getResources());
    int i = wja.dp2px(9.5F, getResources());
    localRelativeLayout.setPadding(paramInt, i, paramInt, i);
    localc.eW(localRelativeLayout);
    localRelativeLayout.setOnClickListener(this);
    localc.sB = new ImageView(getContext());
    Object localObject = getContext().getResources().getDrawable(2130838073);
    localc.sB.setBackgroundDrawable((Drawable)localObject);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    localc.sB.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (parama.isSelected()) {
      localc.sB.setVisibility(0);
    }
    for (;;)
    {
      localc.a = new ColorView(getContext(), null);
      localObject = new RelativeLayout.LayoutParams(wja.dp2px(18.0F, getResources()), wja.dp2px(18.0F, getResources()));
      paramInt = wja.dp2px(3.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject).setMargins(paramInt, paramInt, paramInt, paramInt);
      ((RelativeLayout)localc.y()).addView(localc.a);
      localRelativeLayout.addView(localc.sB);
      localc.a.setListener(new wsk(this, localc));
      localc.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (parama.mType != 0) {
        break;
      }
      localc.a.setColor(parama.mValue);
      return localc;
      localc.sB.setVisibility(4);
    }
    parama = wrq.a().d(0, parama.mID);
    localc.a.setBtmap(parama);
    return localc;
  }
  
  public void a(int paramInt, a parama)
  {
    if ((parama != null) && (this.a != null)) {
      this.a.b(parama);
    }
  }
  
  public void a(int paramInt, a parama, c paramc)
  {
    if ((paramc == null) || (parama == null)) {}
    label138:
    label147:
    for (;;)
    {
      return;
      Object localObject = "";
      if (parama.mType == 0)
      {
        paramc.a.setColor(parama.mValue);
        localObject = cB(parama.mValue);
        if (paramc.sB != null)
        {
          if (!parama.isSelected()) {
            break label138;
          }
          paramc.sB.setVisibility(0);
        }
      }
      for (;;)
      {
        if (!AppSetting.enableTalkBack) {
          break label147;
        }
        paramc.a.setContentDescription((CharSequence)localObject);
        return;
        if (parama.mType != 1) {
          break;
        }
        localObject = wrq.a().d(0, parama.mID);
        paramc.a.setBtmap((Bitmap)localObject);
        localObject = acfp.m(2131704169) + (paramInt + 1);
        break;
        paramc.sB.setVisibility(4);
      }
    }
  }
  
  public void a(View paramView, int paramInt1, ScribbleResMgr.ResInfo paramResInfo, int paramInt2)
  {
    if (paramInt1 == 3) {
      if (1 == paramInt2) {
        yW(false);
      }
    }
    do
    {
      do
      {
        RI();
        do
        {
          return;
        } while (4 == paramInt2);
        QLog.d("ColorPicker", 2, "ScribbleResMgr down error:" + paramInt2);
        return;
      } while (paramInt1 != 1);
      if (1 == paramInt2)
      {
        update();
        return;
      }
    } while (4 != paramInt2);
  }
  
  public void cbt()
  {
    this.a = null;
  }
  
  public void onClick(View paramView)
  {
    int i = o(paramView);
    Q(i, false);
    a locala = (a)i(i);
    QQAppInterface localQQAppInterface;
    if (locala != null)
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (1 != locala.mType) {
        break label83;
      }
      anot.a(localQQAppInterface, "dc00898", "", "", "0X80081BA", "0X80081BA", 1, locala.mID, "", "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label83:
      if (locala.mType == 0) {
        anot.a(localQQAppInterface, "dc00898", "", "", "0X80081BA", "0X80081BA", 1, locala.mValue, "", "", "", "");
      }
    }
  }
  
  public void setListener(b paramb)
  {
    this.a = paramb;
  }
  
  public static class a
    extends wsm
  {
    public int mID;
    public int mType;
    public int mValue;
    
    public a(int paramInt1, int paramInt2, int paramInt3)
    {
      this.mType = paramInt1;
      this.mID = paramInt2;
      this.mValue = paramInt3;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == null) {}
      do
      {
        do
        {
          return false;
        } while (!(paramObject instanceof a));
        paramObject = (a)paramObject;
      } while ((this.mType != paramObject.mType) || (this.mValue != paramObject.mValue) || (this.mID != paramObject.mID));
      return true;
    }
  }
  
  public static abstract interface b
  {
    public abstract void b(ColorPicker.a parama);
  }
  
  public static class c
    extends wso
  {
    public ColorView a;
    ImageView sB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.ColorPicker
 * JD-Core Version:    0.7.0.1
 */