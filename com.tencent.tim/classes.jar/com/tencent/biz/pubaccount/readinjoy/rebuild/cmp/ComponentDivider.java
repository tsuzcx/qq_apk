package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import lie;
import lwl;
import lwm.a;
import mas;
import mde;

public class ComponentDivider
  extends View
  implements lwl
{
  mas a;
  
  public ComponentDivider(Context paramContext)
  {
    super(paramContext);
    bY(paramContext);
  }
  
  public ComponentDivider(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    bY(paramContext);
  }
  
  public ComponentDivider(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    bY(paramContext);
  }
  
  public ComponentDivider(Context paramContext, Object paramObject)
  {
    super(paramContext);
    b(paramContext, paramObject);
  }
  
  private void b(Context paramContext, Object paramObject)
  {
    bY(paramContext);
    if ((paramObject instanceof lie))
    {
      this.a.setModel((lie)paramObject);
      aNf();
    }
  }
  
  private void bY(Context paramContext)
  {
    this.a = new mas();
    init(paramContext);
    aHq();
  }
  
  public void P(Object paramObject)
  {
    if ((paramObject instanceof lie))
    {
      this.a.setModel((lie)paramObject);
      if ((((lie)paramObject).getCellType() == 53) && ((getLayoutParams() instanceof LinearLayout.LayoutParams)))
      {
        paramObject = (LinearLayout.LayoutParams)getLayoutParams();
        paramObject.leftMargin = Utils.dp2px(6.0D);
        paramObject.rightMargin = Utils.dp2px(6.0D);
        setBackgroundColor(getContext().getResources().getColor(2131165819));
      }
      if (this.a.a.Ct()) {
        setVisibility(0);
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
  
  public void aNf()
  {
    lie locallie = this.a.a;
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
    mde.a(getContext(), locallie, localLayoutParams);
    setLayoutParams(localLayoutParams);
  }
  
  public void init(Context paramContext)
  {
    setBackgroundColor(getContext().getResources().getColor(2131167152));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentDivider
 * JD-Core Version:    0.7.0.1
 */