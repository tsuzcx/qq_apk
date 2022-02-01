package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;
import qyd;
import ram;
import rsh;
import rsi;
import rsj;

public class InnerListView
  extends LinearLayout
{
  private a jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView$a;
  private b jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView$b;
  private rsj jdField_a_of_type_Rsj;
  private LayoutInflater mInflater;
  private List<qyd> pj;
  private List<View> pk;
  
  public InnerListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public InnerListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InnerListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mInflater = LayoutInflater.from(paramContext);
    this.pj = new ArrayList();
  }
  
  public void addFooterView(View paramView)
  {
    if (this.pk == null) {
      this.pk = new ArrayList();
    }
    this.pk.add(paramView);
    addView(paramView);
  }
  
  public void ev(int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis();
    int i = 0;
    while (i < paramInt2)
    {
      qyd localqyd = new qyd(this.mInflater.inflate(paramInt1, this, false));
      this.pj.add(localqyd);
      i += 1;
    }
    ram.e("DEBUG_TIME", "InnerListView initVHCaches:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  public void setAdapter(rsj paramrsj)
  {
    this.jdField_a_of_type_Rsj = paramrsj;
    updateUI();
  }
  
  public void setFooterView(int paramInt, View paramView)
  {
    if ((this.pk == null) || (this.pk.size() <= paramInt))
    {
      addFooterView(paramView);
      return;
    }
    this.pk.set(paramInt, paramView);
    paramInt = getChildCount() - tT() + paramInt;
    removeViewAt(paramInt);
    addView(paramView, paramInt);
  }
  
  public void setOnItemClickListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView$a = parama;
  }
  
  public void setOnItemLongClickListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView$b = paramb;
  }
  
  public int tT()
  {
    if (this.pk != null) {
      return this.pk.size();
    }
    return 0;
  }
  
  public void updateUI()
  {
    if (this.jdField_a_of_type_Rsj != null)
    {
      if ((this.jdField_a_of_type_Rsj.getDatas() != null) && (!this.jdField_a_of_type_Rsj.getDatas().isEmpty()))
      {
        int j = this.jdField_a_of_type_Rsj.getDatas().size();
        if (j < getChildCount() - tT()) {
          removeViews(j, getChildCount() - j - tT());
        }
        int i = 0;
        if (i < j)
        {
          Object localObject;
          if (this.pj.size() - 1 >= i) {
            localObject = (qyd)this.pj.get(i);
          }
          for (;;)
          {
            this.jdField_a_of_type_Rsj.c(i, (qyd)localObject);
            localObject = ((qyd)localObject).getItemView();
            if (((View)localObject).getParent() == null) {
              addView((View)localObject, getChildCount() - tT());
            }
            ((View)localObject).setOnClickListener(new rsh(this, i));
            ((View)localObject).setOnLongClickListener(new rsi(this, i));
            i += 1;
            break;
            localObject = new qyd(this.mInflater.inflate(this.jdField_a_of_type_Rsj.tU(), this, false));
            this.pj.add(localObject);
          }
        }
      }
      else
      {
        removeViews(0, getChildCount() - tT());
      }
      return;
    }
    removeViews(0, getChildCount() - tT());
  }
  
  public static abstract interface a
  {
    public abstract void a(InnerListView paramInnerListView, View paramView, int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract boolean a(InnerListView paramInnerListView, View paramView, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.InnerListView
 * JD-Core Version:    0.7.0.1
 */