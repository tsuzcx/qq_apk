package com.tencent.mobileqq.widget.datepicker;

import acfp;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.security.InvalidParameterException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import rpq;

public class SimpleMonthView
  extends View
{
  protected static int DEFAULT_HEIGHT = 32;
  protected static int MIN_HEIGHT = 10;
  protected static int ejh;
  protected static int eji = 1;
  protected static int ejj;
  protected static int ejk;
  protected static int ejl;
  protected static int ejm;
  protected int DR;
  protected ArrayList<MessageRecord> Ds;
  private final Calendar F = Calendar.getInstance();
  protected int JE;
  private CalendarDay jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay;
  private a jdField_a_of_type_ComTencentMobileqqWidgetDatepickerSimpleMonthView$a;
  private DateFormatSymbols jdField_a_of_type_JavaTextDateFormatSymbols = new DateFormatSymbols();
  protected Boolean aP;
  private final Boolean aQ;
  private CalendarDay b;
  private String cAE;
  private String cAF;
  protected Paint cL;
  protected Paint cM;
  protected Paint cN;
  protected Paint cO;
  private boolean cZX;
  int colorBlack = -16777216;
  int colorBlue = -15550475;
  int colorWhite = -1;
  protected boolean dcb;
  protected boolean dcc;
  final Time e = new Time(Time.getCurrentTimezone());
  protected int ejA = -1;
  protected int ejB = 1;
  protected int ejC = 7;
  protected int ejD = this.ejC;
  private int ejE;
  protected int ejF = DEFAULT_HEIGHT;
  int ejG = -4473925;
  int ejH = -394757;
  int ejI = 2131933173;
  int ejJ;
  int ejK;
  int ejL;
  int ejM;
  int ejN;
  int ejO;
  int ejP;
  private int ejQ;
  protected int ejn;
  protected int ejo;
  protected int ejp;
  protected int ejq;
  protected int ejr;
  protected int ejs;
  protected int ejt;
  protected int eju = -1;
  protected int ejv = -1;
  protected int ejw = -1;
  protected int ejx = -1;
  protected int ejy = -1;
  protected int ejz = -1;
  private final Calendar mCalendar = Calendar.getInstance();
  private int mNumRows = 6;
  protected int mPadding;
  protected int mWidth;
  
  public SimpleMonthView(Context paramContext, TypedArray paramTypedArray)
  {
    super(paramContext);
    this.e.setToNow();
    this.cAE = "sans-serif";
    this.cAF = "sans-serif";
    if (ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null))
    {
      this.colorBlack = -9004613;
      this.ejH = -16115667;
      this.ejG = -8947849;
    }
    this.ejn = paramTypedArray.getColor(1, this.colorBlack);
    this.ejo = paramTypedArray.getColor(3, this.colorBlue);
    this.ejp = paramTypedArray.getColor(2, this.colorBlack);
    this.ejq = paramTypedArray.getColor(4, this.colorBlack);
    this.ejs = paramTypedArray.getColor(5, this.colorBlack);
    this.ejt = paramTypedArray.getColor(6, this.colorBlue);
    this.ejr = paramTypedArray.getColor(7, this.colorWhite);
    this.ejJ = rpq.dip2px(paramContext, 16.0F);
    this.ejK = rpq.dip2px(paramContext, 10.0F);
    this.ejL = rpq.dip2px(paramContext, 50.0F);
    this.ejM = rpq.dip2px(paramContext, 342.0F);
    this.ejN = rpq.dip2px(paramContext, 12.5F);
    this.ejO = rpq.dip2px(paramContext, 14.0F);
    this.ejP = rpq.dip2px(paramContext, 17.5F);
    ejj = paramTypedArray.getDimensionPixelSize(15, this.ejJ);
    ejm = paramTypedArray.getDimensionPixelSize(17, this.ejJ);
    ejk = paramTypedArray.getDimensionPixelSize(16, this.ejK);
    ejl = paramTypedArray.getDimensionPixelOffset(12, this.ejL);
    ejh = paramTypedArray.getDimensionPixelSize(14, this.ejP);
    this.ejF = ((paramTypedArray.getDimensionPixelSize(0, this.ejM) - ejl) / 6);
    this.aQ = Boolean.valueOf(paramTypedArray.getBoolean(10, true));
    this.aP = Boolean.valueOf(paramTypedArray.getBoolean(9, false));
    cnb();
  }
  
  private String CW()
  {
    long l = this.mCalendar.getTimeInMillis();
    return DateUtils.formatDateRange(getContext(), l, l, 52);
  }
  
  private int MU()
  {
    int i = MV();
    int j = (this.ejD + i) / this.ejC;
    if ((i + this.ejD) % this.ejC > 0) {}
    for (i = 1;; i = 0) {
      return i + j;
    }
  }
  
  private int MV()
  {
    if (this.ejE < this.ejB) {}
    for (int i = this.ejE + this.ejC;; i = this.ejE) {
      return i - this.ejB;
    }
  }
  
  private boolean a(int paramInt, Time paramTime)
  {
    return (this.DR < paramTime.year) || ((this.DR == paramTime.year) && (this.JE < paramTime.month)) || ((this.JE == paramTime.month) && (paramInt < paramTime.monthDay));
  }
  
  private void b(CalendarDay paramCalendarDay)
  {
    int i;
    MessageRecord localMessageRecord;
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerSimpleMonthView$a != null) && (this.Ds != null) && ((this.aQ.booleanValue()) || (paramCalendarDay.month != this.e.month) || (paramCalendarDay.year != this.e.year) || (paramCalendarDay.day >= this.e.monthDay)))
    {
      i = 0;
      if (i >= this.Ds.size()) {
        break label136;
      }
      localMessageRecord = (MessageRecord)this.Ds.get(i);
      if (new CalendarDay(localMessageRecord.time * 1000L).day != paramCalendarDay.day) {
        break label129;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerSimpleMonthView$a.a(this, paramCalendarDay, localMessageRecord);
      return;
      label129:
      i += 1;
      break;
      label136:
      localMessageRecord = null;
    }
  }
  
  private void bI(Canvas paramCanvas)
  {
    int i = ((this.mWidth - this.mPadding * 2) / this.ejC - ejk) / 2;
    int m = ejm + this.ejO;
    paramCanvas.drawText(CW(), i, m, this.cN);
    int j = this.mWidth;
    int k = this.mPadding;
    m = m + this.ejN + 6;
    this.cM.setColor(-2171170);
    paramCanvas.drawLine(i, m, k * 2 + j, m, this.cM);
  }
  
  public CalendarDay a(float paramFloat1, float paramFloat2)
  {
    int i = this.mPadding;
    if ((paramFloat1 < i) || (paramFloat1 > this.mWidth - this.mPadding)) {}
    do
    {
      return null;
      int j = (int)(paramFloat2 - ejl) / this.ejF;
      i = (int)((paramFloat1 - i) * this.ejC / (this.mWidth - i - this.mPadding)) - MV() + 1 + j * this.ejC;
    } while ((this.JE > 11) || (this.JE < 0) || (CalendarDay.getDaysInMonth(this.DR, this.JE) < i) || (i < 1));
    return new CalendarDay(this.DR, this.JE, i);
  }
  
  protected void bJ(Canvas paramCanvas)
  {
    int j = (this.ejF + ejj) / 2 - eji + ejl;
    int i3 = (this.mWidth - this.mPadding * 2) / (this.ejC * 2);
    int i1 = MV();
    int i;
    int m;
    label88:
    int n;
    label91:
    label107:
    Object localObject;
    int k;
    if ((this.DR == this.b.year) && (this.JE == this.b.month))
    {
      i = 1;
      if (i == 0) {
        break label622;
      }
      m = this.b.day;
      n = 1;
      if (n > m) {
        break label841;
      }
      if (this.Ds == null) {
        break label856;
      }
      i = 0;
      if (i >= this.Ds.size()) {
        break label856;
      }
      localObject = (MessageRecord)this.Ds.get(i);
      if (new CalendarDay(((MessageRecord)localObject).time * 1000L).day != n) {
        break label631;
      }
      if (!QLog.isColorLevel()) {
        break label850;
      }
      QLog.d("DatePickerView", 2, "hasMessage : " + this.DR + "-" + (this.JE + 1) + "-" + n + " , MessageRecord:" + localObject);
      k = 1;
    }
    for (;;)
    {
      int i4 = (i1 * 2 + 1) * i3 + this.mPadding;
      label274:
      int i2;
      if (this.ejQ == n)
      {
        localObject = this.cO;
        if (this.cZX)
        {
          i = this.ejI;
          ((Paint)localObject).setColor(i);
          paramCanvas.drawCircle(i4, j - ejj / 3, ejh, this.cO);
        }
      }
      else
      {
        if (((this.JE != this.ejw) || (this.eju != n) || (this.ejy != this.DR)) && ((this.JE != this.ejx) || (this.ejv != n) || (this.ejz != this.DR))) {
          break label646;
        }
        i2 = 1;
        label368:
        if (i2 != 0)
        {
          localObject = this.cO;
          if (k == 0) {
            break label652;
          }
          i = this.ejt;
          ((Paint)localObject).setColor(i);
          if (!this.aP.booleanValue()) {
            break label668;
          }
          paramCanvas.drawRoundRect(new RectF(i4 - ejh, j - ejj / 3 - ejh, ejh + i4, j - ejj / 3 + ejh), 10.0F, 10.0F, this.cO);
        }
        label389:
        label462:
        if ((!this.dcb) || (this.ejA != n)) {
          break label731;
        }
        this.cM.setColor(this.ejn);
        if (i2 == 0) {
          break label710;
        }
        if (k == 0) {
          break label694;
        }
        i = this.ejt;
        label504:
        this.cO.setColor(i);
        paramCanvas.drawText(acfp.m(2131714598), i4, ejh + j + ejj / 2, this.cO);
        label541:
        if (i2 == 0) {
          break label745;
        }
        this.cM.setColor(this.ejr);
        label557:
        paramCanvas.drawText(Integer.toString(n), i4, j, this.cM);
        k = i1 + 1;
        if (k != this.ejC) {
          break label842;
        }
        k = 0;
        i = this.ejF + j;
      }
      for (j = k;; j = k)
      {
        n += 1;
        i1 = j;
        j = i;
        break label91;
        i = 0;
        break;
        label622:
        m = this.ejD;
        break label88;
        label631:
        i += 1;
        break label107;
        i = this.ejH;
        break label274;
        label646:
        i2 = 0;
        break label368;
        label652:
        i = this.ejt & 0xFFFFFF | 0x7F000000;
        break label389;
        label668:
        paramCanvas.drawCircle(i4, j - ejj / 3, ejh, this.cO);
        break label462;
        label694:
        i = this.ejt & 0xFFFFFF | 0x7F000000;
        break label504;
        label710:
        if (k != 0)
        {
          i = this.ejq;
          break label504;
        }
        i = this.ejG;
        break label504;
        label731:
        this.cM.setColor(this.ejq);
        break label541;
        label745:
        if (k == 0)
        {
          this.cM.setColor(this.ejG);
          break label557;
        }
        if ((this.aQ.booleanValue()) || (!a(n, this.e)) || (this.e.month != this.JE) || (this.e.year != this.DR)) {
          break label557;
        }
        this.cM.setColor(this.ejs);
        this.cM.setTypeface(Typeface.defaultFromStyle(2));
        break label557;
        label841:
        return;
        label842:
        i = j;
      }
      label850:
      k = 1;
      continue;
      label856:
      k = 0;
    }
  }
  
  protected void cnb()
  {
    this.cN = new Paint();
    this.cN.setFakeBoldText(true);
    this.cN.setAntiAlias(true);
    this.cN.setTextSize(ejm);
    this.cN.setColor(this.ejo);
    this.cN.setTextAlign(Paint.Align.LEFT);
    this.cN.setStyle(Paint.Style.FILL);
    this.cO = new Paint();
    this.cO.setFakeBoldText(true);
    this.cO.setAntiAlias(true);
    this.cO.setColor(this.ejt);
    this.cO.setTextAlign(Paint.Align.CENTER);
    this.cO.setStyle(Paint.Style.FILL);
    this.cO.setTextSize(this.ejN);
    this.cL = new Paint();
    this.cL.setAntiAlias(true);
    this.cL.setTextSize(ejk);
    this.cL.setColor(this.ejp);
    this.cL.setTypeface(Typeface.create(this.cAE, 0));
    this.cL.setStyle(Paint.Style.FILL);
    this.cL.setTextAlign(Paint.Align.CENTER);
    this.cL.setFakeBoldText(true);
    this.cM = new Paint();
    this.cM.setFakeBoldText(false);
    this.cM.setAntiAlias(true);
    this.cM.setTextSize(ejj);
    this.cM.setStyle(Paint.Style.FILL);
    this.cM.setTextAlign(Paint.Align.CENTER);
  }
  
  public void ejB()
  {
    this.mNumRows = 6;
    requestLayout();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    bI(paramCanvas);
    bJ(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), this.ejF * this.mNumRows + ejl + this.ejK);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mWidth = paramInt1;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      CalendarDay localCalendarDay = a(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (localCalendarDay != null)
      {
        this.cZX = true;
        this.ejQ = localCalendarDay.day;
        invalidate();
      }
    }
    for (;;)
    {
      if (paramMotionEvent.getAction() == 1)
      {
        paramMotionEvent = a(paramMotionEvent.getX(), paramMotionEvent.getY());
        if (paramMotionEvent != null) {
          b(paramMotionEvent);
        }
      }
      return true;
      if ((this.cZX) && (paramMotionEvent.getAction() != 2))
      {
        this.cZX = false;
        invalidate();
      }
    }
  }
  
  public void setMessageRecords(ArrayList<MessageRecord> paramArrayList)
  {
    this.Ds = paramArrayList;
  }
  
  public void setMonthParams(HashMap<String, Integer> paramHashMap)
  {
    int i = 0;
    if ((!paramHashMap.containsKey("month")) && (!paramHashMap.containsKey("year"))) {
      throw new InvalidParameterException("You must specify month and year for this view");
    }
    setTag(paramHashMap);
    if (paramHashMap.containsKey("height"))
    {
      this.ejF = ((Integer)paramHashMap.get("height")).intValue();
      if (this.ejF < MIN_HEIGHT) {
        this.ejF = MIN_HEIGHT;
      }
    }
    if (paramHashMap.containsKey("selected_begin_day")) {
      this.eju = ((Integer)paramHashMap.get("selected_begin_day")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_day")) {
      this.ejv = ((Integer)paramHashMap.get("selected_last_day")).intValue();
    }
    if (paramHashMap.containsKey("selected_begin_month")) {
      this.ejw = ((Integer)paramHashMap.get("selected_begin_month")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_month")) {
      this.ejx = ((Integer)paramHashMap.get("selected_last_month")).intValue();
    }
    if (paramHashMap.containsKey("selected_begin_year")) {
      this.ejy = ((Integer)paramHashMap.get("selected_begin_year")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_year")) {
      this.ejz = ((Integer)paramHashMap.get("selected_last_year")).intValue();
    }
    this.JE = ((Integer)paramHashMap.get("month")).intValue();
    this.DR = ((Integer)paramHashMap.get("year")).intValue();
    this.dcb = false;
    this.ejA = -1;
    this.mCalendar.set(2, this.JE);
    this.mCalendar.set(1, this.DR);
    this.mCalendar.set(5, 1);
    this.ejE = this.mCalendar.get(7);
    if (paramHashMap.containsKey("week_start")) {}
    int j;
    for (this.ejB = ((Integer)paramHashMap.get("week_start")).intValue();; this.ejB = this.mCalendar.getFirstDayOfWeek())
    {
      j = CalendarDay.getDaysInMonth(this.DR, this.JE);
      while (i < j)
      {
        int k = i + 1;
        if ((this.DR == this.e.year) && (this.JE == this.e.month) && (k == this.e.monthDay))
        {
          this.dcb = true;
          this.ejA = k;
        }
        this.dcc = a(k, this.e);
        i += 1;
      }
    }
    i = j;
    if (this.dcb) {
      i = this.ejA;
    }
    this.ejD = i;
    this.mNumRows = MU();
  }
  
  public void setOnDayClickListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerSimpleMonthView$a = parama;
  }
  
  public void setStartAndEndDate(CalendarDay paramCalendarDay1, CalendarDay paramCalendarDay2)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = paramCalendarDay1;
    this.b = paramCalendarDay2;
  }
  
  public static abstract interface a
  {
    public abstract void a(SimpleMonthView paramSimpleMonthView, CalendarDay paramCalendarDay, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.datepicker.SimpleMonthView
 * JD-Core Version:    0.7.0.1
 */