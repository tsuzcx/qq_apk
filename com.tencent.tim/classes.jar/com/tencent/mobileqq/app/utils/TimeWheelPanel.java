package com.tencent.mobileqq.app.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.widget.VerticalGallery;

public class TimeWheelPanel
  extends LinearLayout
  implements NumberWheelView.b
{
  private TextView Qu;
  private TextView Qv;
  private TextView Qw;
  private TextView Qx;
  private a a;
  private NumberWheelView b;
  private boolean bKG;
  private boolean bKH;
  private String brw;
  private NumberWheelView c;
  private final int cBb = 30;
  private final int cBc = 24;
  private final int cBd = 60;
  private final int cBe = 60;
  private int cBf;
  private int cBg;
  private int cBh;
  private int cBi;
  public int cBj;
  public int cBk;
  public int cBl;
  private int cBm;
  private int cBn;
  private int cBo;
  private NumberWheelView d;
  private Context mContext;
  private LayoutInflater mInflater;
  
  public TimeWheelPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  private void initUI()
  {
    if ((this.mInflater == null) || (this.b == null) || (this.c == null) || (this.d == null))
    {
      this.mInflater = LayoutInflater.from(this.mContext);
      this.mInflater.inflate(2131561237, this);
      this.b = ((NumberWheelView)findViewById(2131365629));
      this.c = ((NumberWheelView)findViewById(2131368678));
      this.d = ((NumberWheelView)findViewById(2131371861));
      this.Qu = ((TextView)findViewById(2131365630));
      this.Qv = ((TextView)findViewById(2131368679));
      this.Qw = ((TextView)findViewById(2131371862));
      this.Qx = ((TextView)findViewById(2131366460));
      this.b.setScrollStateListener(this);
      this.c.setScrollStateListener(this);
      this.d.setScrollStateListener(this);
      this.b.setmMaxRotationAngle(0);
      this.c.setmMaxRotationAngle(0);
      this.d.setmMaxRotationAngle(0);
      this.b.setRange(0, this.cBf - 1);
      this.c.setRange(0, 23);
      this.d.setRange(0, 59);
    }
    setValues(true);
  }
  
  public int Bq()
  {
    return ((this.cBj * 24 + this.cBk) * 60 + this.cBl) * 60;
  }
  
  public void FP(boolean paramBoolean)
  {
    this.bKG = paramBoolean;
  }
  
  public void a(NumberWheelView paramNumberWheelView, VerticalGallery paramVerticalGallery)
  {
    this.cBj = this.b.Bp();
    this.cBk = this.c.Bp();
    this.cBl = this.d.Bp();
    setValues(false);
    if (this.a != null) {
      this.a.a(paramNumberWheelView, paramVerticalGallery);
    }
  }
  
  public void init(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt4 > 0)
    {
      this.cBf = paramInt4;
      if ((paramInt1 < 0) || (paramInt1 >= this.cBf)) {
        break label109;
      }
      label23:
      this.cBg = paramInt1;
      if ((paramInt2 < 0) || (paramInt2 >= 24)) {
        break label114;
      }
      label38:
      this.cBh = paramInt2;
      if ((paramInt3 < 0) || (paramInt3 >= 60)) {
        break label119;
      }
    }
    for (;;)
    {
      this.cBi = paramInt3;
      this.cBj = this.cBg;
      this.cBk = this.cBh;
      this.cBl = this.cBi;
      this.cBm = 1;
      this.cBn = 1;
      this.cBo = 1;
      initUI();
      return;
      paramInt4 = 30;
      break;
      label109:
      paramInt1 = 0;
      break label23;
      label114:
      paramInt2 = 0;
      break label38;
      label119:
      paramInt3 = 0;
    }
  }
  
  public void setEndTime(String paramString)
  {
    setEndTime(paramString, null);
  }
  
  public void setEndTime(String paramString1, String paramString2)
  {
    this.brw = paramString2;
    if (paramString2 == null)
    {
      this.Qx.setText(paramString1);
      this.bKH = false;
      return;
    }
    if (this.bKH) {
      this.Qx.setText(paramString2);
    }
    for (;;)
    {
      this.Qx.post(new TimeWheelPanel.1(this));
      return;
      this.Qx.setText(paramString1);
    }
  }
  
  public void setScrollerStateListener(a parama)
  {
    this.a = parama;
  }
  
  public void setValues(boolean paramBoolean)
  {
    if ((this.cBm != 1) || (this.cBn != 1) || (this.cBo != 1)) {}
    do
    {
      return;
      if ((this.cBj == 0) && (this.cBk == 0) && (this.cBl == 0) && (!this.bKG))
      {
        this.cBl = 1;
        this.d.setValue(this.cBl);
      }
    } while (!paramBoolean);
    this.b.setValue(this.cBj);
    this.c.setValue(this.cBk);
    this.d.setValue(this.cBl);
  }
  
  public void setViewVisibility(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      findViewById(2131365625).setVisibility(paramInt2);
    }
    do
    {
      return;
      if (paramInt1 == 1)
      {
        findViewById(2131368674).setVisibility(paramInt2);
        return;
      }
      if (paramInt1 == 2)
      {
        findViewById(2131371858).setVisibility(paramInt2);
        return;
      }
    } while (paramInt1 != 3);
    this.Qx.setVisibility(paramInt2);
  }
  
  public static abstract interface a
  {
    public abstract void a(NumberWheelView paramNumberWheelView, VerticalGallery paramVerticalGallery);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.TimeWheelPanel
 * JD-Core Version:    0.7.0.1
 */