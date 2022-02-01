package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.mobileqq.app.ThreadManager;
import kys;
import lie;
import lwl;
import lwm.a;
import mas;
import mct;

public class ComponentLastRead
  extends LinearLayout
  implements lwl
{
  public mas a;
  private Context context;
  private Container g;
  private View kQ;
  
  public ComponentLastRead(Context paramContext)
  {
    super(paramContext);
    bY(paramContext);
  }
  
  public ComponentLastRead(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    bY(paramContext);
  }
  
  public ComponentLastRead(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    bY(paramContext);
  }
  
  private void bY(Context paramContext)
  {
    this.a = new mas();
    init(paramContext);
    aHq();
  }
  
  private void g(lie paramlie)
  {
    if (this.g != null) {}
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            int i;
            do
            {
              return;
              i = paramlie.nh();
            } while ((i != 0) && (!kys.dv(i)));
            paramlie = paramlie.a();
          } while (paramlie == null);
          localObject = paramlie.getTemplateFactory();
        } while ((localObject == null) || (!((BaseTemplateFactory)localObject).hasTemplate("ReadInjoy_last_read_cell")));
        localObject = ((BaseTemplateFactory)localObject).getTemplate("ReadInjoy_last_read_cell");
      } while (localObject == null);
      this.g = paramlie.getViewFactory().inflate(paramlie, (TemplateBean)localObject);
    } while (this.g == null);
    removeAllViews();
    paramlie = this.g.getVirtualView().getComLayoutParams();
    paramlie = new RelativeLayout.LayoutParams(paramlie.mLayoutWidth, paramlie.mLayoutHeight);
    addView(this.g, paramlie);
  }
  
  public void P(Object paramObject)
  {
    if ((paramObject instanceof lie))
    {
      this.a.setModel((lie)paramObject);
      aNf();
      if (this.a.a.Cv())
      {
        g((lie)paramObject);
        if ((this.g == null) && (this.context != null) && (this.kQ == null))
        {
          this.kQ = LayoutInflater.from(this.context).inflate(2131560324, null, false);
          setBackgroundResource(2131167158);
          addView(this.kQ);
        }
        setVisibility(0);
        setOnClickListener(new mct(this));
        ThreadManager.executeOnSubThread(new ComponentLastRead.2(this));
      }
    }
    else
    {
      return;
    }
    setVisibility(8);
  }
  
  public void a(lwm.a parama)
  {
    this.a.b(parama);
  }
  
  public void aHq() {}
  
  public void aNf() {}
  
  public void init(Context paramContext)
  {
    this.context = paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentLastRead
 * JD-Core Version:    0.7.0.1
 */