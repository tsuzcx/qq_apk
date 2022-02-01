package com.tencent.mobileqq.activity.aio.doodle.control;

import acfp;
import android.content.Context;
import android.content.res.Resources;
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
import wsm;
import wso;

public class GifTemplatePicker
  extends RDBaseListLayout<a, c>
  implements View.OnClickListener, ScribbleResMgr.b
{
  private b a;
  
  public GifTemplatePicker(Context paramContext)
  {
    super(paramContext);
    cn(1);
  }
  
  public GifTemplatePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    cn(1);
  }
  
  public GifTemplatePicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    cn(1);
  }
  
  private void yV(boolean paramBoolean)
  {
    c(new a(2130838077, 0), false);
    Object localObject = wrq.a().D(1);
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        if (!wrq.a().aw(1, localInteger.intValue()))
        {
          if (paramBoolean) {
            wrq.a().a(1, localInteger.intValue(), this, this);
          }
        }
        else {
          c(new a(localInteger.intValue(), 1), false);
        }
      }
    }
  }
  
  public boolean RI()
  {
    yV(true);
    update();
    return true;
  }
  
  public c a(int paramInt, a parama)
  {
    c localc = new c();
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setOnClickListener(this);
    localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(wja.dp2px(50.0F, getResources()), wja.dp2px(37.0F, getResources())));
    localc.eW(localRelativeLayout);
    localc.sC = new ImageView(getContext());
    Object localObject = new RelativeLayout.LayoutParams(wja.dp2px(40.0F, getResources()), wja.dp2px(27.0F, getResources()));
    paramInt = wja.dp2px(5.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject).leftMargin = paramInt;
    ((RelativeLayout.LayoutParams)localObject).topMargin = paramInt;
    localc.sC.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = null;
    if (parama.mType == 1) {
      localObject = wrq.a().c(1, parama.mID);
    }
    for (;;)
    {
      localc.sC.setOnClickListener(this);
      localc.sC.setImageDrawable((Drawable)localObject);
      localRelativeLayout.addView(localc.sC);
      localc.wu = new View(getContext());
      localc.wu.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      localc.wu.setBackgroundColor(-1427313428);
      localc.wu.setClickable(false);
      localRelativeLayout.addView(localc.wu, 0);
      return localc;
      if (parama.mType == 0) {
        localObject = getContext().getResources().getDrawable(parama.mID);
      }
    }
  }
  
  public void a(int paramInt, a parama)
  {
    if ((this.a != null) && (parama != null))
    {
      if (parama.mType == 0) {
        this.a.CI(-1);
      }
    }
    else {
      return;
    }
    this.a.CI(parama.mID);
  }
  
  public void a(int paramInt, a parama, c paramc)
  {
    if (paramc.sC != null)
    {
      localObject = null;
      if (parama.mType != 1) {
        break label89;
      }
      localObject = wrq.a().c(1, parama.mID);
      paramc.sC.setImageDrawable((Drawable)localObject);
      if (AppSetting.enableTalkBack) {
        if (paramInt != 0) {
          break label115;
        }
      }
    }
    label89:
    label115:
    for (Object localObject = acfp.m(2131706961);; localObject = acfp.m(2131706960) + paramInt)
    {
      paramc.sC.setContentDescription((CharSequence)localObject);
      if (paramc.wu != null)
      {
        if (!parama.isSelected()) {
          break label142;
        }
        paramc.wu.setVisibility(0);
      }
      return;
      if (parama.mType != 0) {
        break;
      }
      localObject = getContext().getResources().getDrawable(parama.mID);
      break;
    }
    label142:
    paramc.wu.setVisibility(8);
  }
  
  public void a(View paramView, int paramInt1, ScribbleResMgr.ResInfo paramResInfo, int paramInt2)
  {
    if (paramInt1 == 4)
    {
      if (1 != paramInt2) {
        break label26;
      }
      yW(false);
      yV(false);
      update();
    }
    label26:
    while (4 == paramInt2) {
      return;
    }
    QLog.d("GifTemplatePicker", 2, "ScribbleResMgr down error:" + paramInt2);
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
        break label89;
      }
      anot.a(localQQAppInterface, "dc00898", "", "", "0X80081B4", "0X80081B4", 1, locala.mID, "", "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label89:
      anot.a(localQQAppInterface, "dc00898", "", "", "0X80081B4", "0X80081B4", 1, 0, "", "", "", "");
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
    
    public a(int paramInt1, int paramInt2)
    {
      this.mID = paramInt1;
      this.mType = paramInt2;
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
      } while ((this.mID != paramObject.mID) || (this.mType != paramObject.mType));
      return true;
    }
  }
  
  public static abstract interface b
  {
    public abstract void CI(int paramInt);
  }
  
  public static class c
    extends wso
  {
    public ImageView sC;
    public View wu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.GifTemplatePicker
 * JD-Core Version:    0.7.0.1
 */