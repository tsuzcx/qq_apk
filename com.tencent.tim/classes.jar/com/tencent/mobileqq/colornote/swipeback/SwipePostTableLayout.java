package com.tencent.mobileqq.colornote.swipeback;

import aeax;
import aeaz;
import aeaz.b;
import aebf;
import aebs;
import aebu;
import aedo;
import aeeg;
import aeek;
import aeel;
import aeem;
import aeem.a;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import anot;
import aqcx;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.colornote.data.ColorNote;

public class SwipePostTableLayout
  extends SwipeBackLayout
  implements aeem.a
{
  private aeeg jdField_a_of_type_Aeeg = new aeek(this);
  private aeem jdField_a_of_type_Aeem;
  public boolean bTl;
  public boolean bTm;
  private boolean bTn = true;
  private boolean bTo = true;
  private boolean bTp;
  private boolean bTq;
  private aeaz mColorNoteCurd;
  private aedo mColorNoteStateNotice;
  private boolean mFirstShow = true;
  private PostTable mPostTable;
  private boolean mPostTableVisible;
  private aebf mServiceInfo;
  private aeel mTouchStateDetector;
  private Vibrator mVibrator;
  
  public SwipePostTableLayout(Context paramContext)
  {
    super(paramContext);
    this.mPostTable = new PostTable(paramContext);
    this.mTouchStateDetector = new aeel(paramContext);
    this.mColorNoteCurd = new aeaz();
    this.mColorNoteCurd.setOnColorNoteCurdListener(new aeaz.b());
    this.mColorNoteStateNotice = new aedo();
    this.mColorNoteStateNotice.a(this.mColorNoteCurd);
    this.mVibrator = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.mGestureDetector = new GestureDetector(paramContext, new b());
    aebu.a().a(this.jdField_a_of_type_Aeeg);
    cMk = aqcx.dip2px(paramContext, 18.0F);
  }
  
  public void Ha(boolean paramBoolean)
  {
    if (this.bTp)
    {
      this.bTp = false;
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipeBackLayout$c.sendEmptyMessage(1);
    }
    if (this.bTq)
    {
      this.bTq = false;
      bdP();
    }
  }
  
  public void attachToActivity(Activity paramActivity)
  {
    super.attachToActivity(paramActivity);
    ((ViewGroup)paramActivity.getWindow().getDecorView()).addView(this.mPostTable);
    this.mPostTable.setVisibility(4);
    this.mPostTable.A(0.0D);
    this.mPostTableVisible = false;
  }
  
  public void cVy()
  {
    this.bTn = false;
    this.mColorNoteStateNotice.Hl(false);
  }
  
  public void cVz()
  {
    this.bTn = true;
    this.mColorNoteStateNotice.Hl(true);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mColorNoteStateNotice.cVR();
  }
  
  public void onPause()
  {
    super.onPause();
    this.mColorNoteStateNotice.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.mColorNoteStateNotice.onResume();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mColorNoteCurd.getSyncState()) {
      cVy();
    }
    double d = this.mTouchStateDetector.a(paramMotionEvent);
    this.mColorNoteCurd.canAddColorNote();
    if (this.mServiceInfo == null) {
      return super.onTouchEvent(paramMotionEvent);
    }
    ColorNote localColorNote = this.mServiceInfo.getColorNote();
    if ((localColorNote == null) || (this.mContentView.getScrollX() == 0) || (TextUtils.isEmpty(localColorNote.mSubType))) {
      return super.onTouchEvent(paramMotionEvent);
    }
    boolean bool = this.mColorNoteCurd.u(localColorNote.getServiceType(), localColorNote.getSubType());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.mFirstShow = true;
      this.bTo = true;
      int j = 0;
      int i = j;
      if (this.bTn)
      {
        i = j;
        if (this.allowedSliding)
        {
          i = j;
          if (this.mTouchStateDetector.a(paramMotionEvent, getContext()))
          {
            i = j;
            if (!bool)
            {
              i = j;
              if (localColorNote != null)
              {
                i = j;
                if (aebs.g(localColorNote))
                {
                  if (!this.mColorNoteCurd.canAddColorNote()) {
                    break label556;
                  }
                  aebs.p(localColorNote);
                  Bundle localBundle = localColorNote.parseBundle();
                  localBundle.putInt("color_note_curd_from_type", 1);
                  this.mColorNoteCurd.cm(localBundle);
                  this.bTm = true;
                  if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout$a != null) {
                    this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout$a.On();
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("SwipePostTableLayout", 1, "add colornote from swipe entrance:\n" + localColorNote.mServiceType + "\n" + localColorNote.mSubType + "\n" + localColorNote.mMainTitle + "\n" + localColorNote.mSubTitle + "\n" + localColorNote.mPicUrl);
                  }
                  anot.a(null, "dc00898", "", "", "0X800A742", "0X800A742", aeax.gT(this.mServiceInfo.getColorNote().mServiceType), 0, "", "", "", "");
                  i = 1;
                }
              }
            }
          }
        }
      }
      if (aebu.a().a().x < this.screenWidth / 2) {
        cWw();
      }
      if (this.mPostTable != null)
      {
        this.mPostTable.setVisibility(4);
        this.mPostTableVisible = false;
      }
      if (paramMotionEvent.getRawX() - this.downX >= this.screenWidth / 2)
      {
        this.bTl = true;
        if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout$a != null) {
          this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout$a.On();
        }
      }
      if (((i != 0) || (bool)) && (paramMotionEvent.getRawX() - this.downX >= this.screenWidth / 2))
      {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipeBackLayout$c.sendEmptyMessage(1);
        postInvalidate();
        return true;
        label556:
        this.mPostTable.A(0.0D);
        bdQ();
        aebs.ed(getContext());
        anot.a(null, "dc00898", "", "", "0X800A6CF", "0X800A6CF", 1, 0, "", "", "", "");
        return true;
        if ((this.allowedSliding) && (aebs.g(localColorNote)))
        {
          if (!this.mTouchStateDetector.a(paramMotionEvent, getContext()))
          {
            this.bTo = true;
            label645:
            if ((!this.bTn) || (!this.allowedSliding)) {
              break label899;
            }
            if (d <= 1.0E-008D) {
              break label921;
            }
            if (bool) {
              continue;
            }
            i = (int)paramMotionEvent.getRawX();
            if ((i - this.downX > this.mTouchSlop) && (Math.abs((int)paramMotionEvent.getRawY() - this.downY) < this.mTouchSlop)) {
              this.awE = true;
            }
            if ((i - this.downX <= 0) || (!this.awE)) {
              continue;
            }
            if (!this.mPostTableVisible)
            {
              this.mPostTable.setVisibility(0);
              this.mPostTableVisible = true;
            }
            if (!this.mColorNoteCurd.canAddColorNote()) {
              break label911;
            }
            if (!this.mTouchStateDetector.a(paramMotionEvent, getContext())) {
              break label901;
            }
            this.mPostTable.cWs();
          }
          for (;;)
          {
            this.mPostTable.A(d);
            if (!this.mFirstShow) {
              break;
            }
            anot.a(null, "dc00898", "", "", "0X800A741", "0X800A741", aeax.gT(this.mServiceInfo.getColorNote().mServiceType), 0, "", "", "", "");
            this.mFirstShow = false;
            break;
            if ((!this.bTn) || (!this.allowedSliding) || (!this.bTo) || (bool)) {
              break label645;
            }
            this.mVibrator.vibrate(50L);
            this.bTo = false;
            break label645;
            label899:
            break;
            label901:
            this.mPostTable.cWr();
            continue;
            label911:
            this.mPostTable.cWt();
          }
          label921:
          this.mPostTable.setVisibility(4);
          this.mPostTableVisible = false;
        }
      }
    }
  }
  
  public void setOnColorNoteCurdListener(aeaz.b paramb)
  {
    this.mColorNoteCurd.setOnColorNoteCurdListener(paramb);
  }
  
  public void setOnPageSwipeListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout$a = parama;
  }
  
  public void setServiceInfo(aebf paramaebf)
  {
    if (paramaebf != null)
    {
      this.mServiceInfo = paramaebf;
      this.mColorNoteStateNotice.setServiceInfo(paramaebf);
      paramaebf = paramaebf.getColorNote();
      if ((paramaebf != null) && (paramaebf.mServiceType == 16908288)) {
        cMj = cMk;
      }
    }
  }
  
  public void setTranslucentConvertor(aeem paramaeem)
  {
    this.jdField_a_of_type_Aeem = paramaeem;
    paramaeem.a(this);
  }
  
  public static abstract interface a
  {
    public abstract void On();
    
    public abstract void Oo();
  }
  
  public class b
    extends GestureDetector.SimpleOnGestureListener
  {
    protected b() {}
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      int i = 0;
      if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
        return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      }
      ColorNote localColorNote;
      if ((SwipePostTableLayout.a(SwipePostTableLayout.this) != null) && (SwipePostTableLayout.a(SwipePostTableLayout.this).getColorNote() != null)) {
        localColorNote = SwipePostTableLayout.a(SwipePostTableLayout.this).getColorNote();
      }
      for (boolean bool = SwipePostTableLayout.a(SwipePostTableLayout.this).u(localColorNote.getServiceType(), localColorNote.getSubType());; bool = false)
      {
        float f1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
        float f2 = paramMotionEvent1.getY();
        float f3 = paramMotionEvent2.getY();
        if ((f1 == 0.0F) || (!SwipePostTableLayout.this.allowedSliding) || (paramFloat1 < 200.0F)) {
          return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        }
        f2 = Math.abs((f2 - f3) / f1);
        if ((SwipePostTableLayout.a(SwipePostTableLayout.this) == null) || (SwipePostTableLayout.a(SwipePostTableLayout.this).agx())) {
          i = 1;
        }
        if ((f1 < 0.0F) && (f2 < 0.5F))
        {
          if (!bool) {
            break label276;
          }
          if (i == 0) {
            break label254;
          }
          SwipePostTableLayout.this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipeBackLayout$c.sendEmptyMessage(1);
          SwipePostTableLayout.this.postInvalidate();
        }
        for (;;)
        {
          if (SwipePostTableLayout.this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout$a != null) {
            SwipePostTableLayout.this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackSwipePostTableLayout$a.On();
          }
          return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
          label254:
          SwipePostTableLayout.a(SwipePostTableLayout.this, true);
          SwipePostTableLayout.a(SwipePostTableLayout.this).cWx();
          break;
          label276:
          if ((SwipePostTableLayout.this.mContext instanceof Activity))
          {
            SwipePostTableLayout.this.acn = true;
            if (i != 0)
            {
              SwipePostTableLayout.this.bdP();
            }
            else
            {
              SwipePostTableLayout.b(SwipePostTableLayout.this, true);
              SwipePostTableLayout.a(SwipePostTableLayout.this).cWx();
            }
          }
          else if (i != 0)
          {
            SwipePostTableLayout.this.bdP();
          }
          else
          {
            SwipePostTableLayout.b(SwipePostTableLayout.this, true);
            SwipePostTableLayout.a(SwipePostTableLayout.this).cWx();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.swipeback.SwipePostTableLayout
 * JD-Core Version:    0.7.0.1
 */