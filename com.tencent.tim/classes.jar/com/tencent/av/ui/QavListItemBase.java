package com.tencent.av.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class QavListItemBase
  extends LinearLayout
  implements View.OnClickListener
{
  final String TAG;
  a b;
  Context mContext;
  protected int mPosition;
  
  public QavListItemBase(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.TAG = (getClass().getSimpleName() + "_" + AudioHelper.hG());
  }
  
  public void a(int paramInt, a parama)
  {
    this.mPosition = paramInt;
    this.b = parama;
  }
  
  public abstract void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, c paramc, a parama);
  
  public void a(c paramc, int paramInt) {}
  
  public abstract void bX(int paramInt1, int paramInt2);
  
  public int getPosition()
  {
    return this.mPosition;
  }
  
  public void mE(int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.b != null)
    {
      long l = AudioHelper.hG();
      QLog.w(this.TAG, 1, "onClick, seq[" + l + "], mPosition[" + this.mPosition + "]");
      this.b.a(l, this.mPosition, this);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public abstract void setHighlight(boolean paramBoolean);
  
  public abstract void updateSize(int paramInt1, int paramInt2);
  
  public static abstract interface a
  {
    public abstract void a(long paramLong, int paramInt, QavListItemBase paramQavListItemBase);
  }
  
  public static abstract interface b
  {
    public abstract void g(long paramLong, String paramString, boolean paramBoolean);
  }
  
  public static class c
  {
    public boolean XB;
    public boolean XC;
    public Object ax;
    public String desc;
    public boolean downloading;
    public String iconurl;
    public String id;
    public String name;
    public int type = 0;
    public boolean usable;
    public int vipLevel;
    public int voiceid;
    
    public String toString()
    {
      return "id[" + this.id + "], name[" + this.name + "], desc[" + this.desc + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.QavListItemBase
 * JD-Core Version:    0.7.0.1
 */