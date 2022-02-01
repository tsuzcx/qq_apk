package com.tencent.mobileqq.emoticonview;

import afmf;
import afmi;
import afmj;
import afnu;
import afpu;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import anot;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;

public class EmoticonLinearLayout
  extends LinearLayout
{
  private static Rect tmp = new Rect();
  View AV;
  private CheckForLongPress jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$CheckForLongPress;
  a jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$a = new afmj(this);
  private afmi b;
  public b b;
  private boolean bGy;
  private FrameLayout bq;
  private FrameLayout br;
  public int cRT;
  public int cRV = 6;
  public Context context;
  float density;
  private AudioPlayer e;
  afmf f;
  Runnable gr = new EmoticonLinearLayout.2(this);
  boolean mHasPerformedLongPress;
  private ImageView yN;
  public List<RelativeLayout> zW = new ArrayList();
  
  public EmoticonLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    this.cRT = super.getResources().getColor(2131166787);
    setOrientation(1);
    this.density = paramContext.getResources().getDisplayMetrics().density;
    super.setClickable(true);
    super.setLongClickable(true);
  }
  
  private boolean a(View paramView, Rect paramRect)
  {
    if (paramView == null) {
      return false;
    }
    paramView.getDrawingRect(paramRect);
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    paramRect.offset(paramView.getLeft() - localViewGroup.getScrollX(), paramView.getTop() - localViewGroup.getScrollY());
    paramView = (ViewGroup)localViewGroup.getParent();
    paramRect.offset(localViewGroup.getLeft() - paramView.getScrollX(), localViewGroup.getTop() - paramView.getScrollY());
    return true;
  }
  
  private View b(float paramFloat1, float paramFloat2)
  {
    int i = super.getChildCount() - 1;
    while (i >= 0)
    {
      LinearLayout localLinearLayout = (LinearLayout)super.getChildAt(i);
      float f1 = super.getScrollX() + paramFloat1 - localLinearLayout.getLeft();
      float f2 = super.getScrollY() + paramFloat2 - localLinearLayout.getTop();
      if ((f1 >= 0.0F) && (f1 <= localLinearLayout.getWidth()) && (f2 >= 0.0F) && (f2 < localLinearLayout.getHeight()))
      {
        int j = localLinearLayout.getChildCount() - 1;
        while (j >= 0)
        {
          View localView = localLinearLayout.getChildAt(j);
          float f3 = localLinearLayout.getScrollX() + f1 - localView.getLeft();
          float f4 = localLinearLayout.getScrollY() + f2 - localView.getTop();
          if ((f3 >= 0.0F) && (f3 <= localView.getWidth()) && (f4 >= 0.0F) && (f4 < localView.getHeight())) {
            return localView;
          }
          j -= 1;
        }
      }
      i -= 1;
    }
    return null;
  }
  
  private void gl(View paramView)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof afmi)))
    {
      paramView = (afmi)paramView.getTag();
      if (paramView != null)
      {
        super.sendAccessibilityEvent(1);
        super.playSoundEffect(0);
        this.f.a(paramView);
      }
    }
  }
  
  void a(View paramView, afmi paramafmi)
  {
    Drawable localDrawable = paramafmi.c(this.context, this.density);
    if (localDrawable == null) {
      return;
    }
    paramView.getGlobalVisibleRect(tmp);
    int i = paramafmi.type;
    if (this.br == null)
    {
      this.br = new FrameLayout(getContext());
      this.bq = new FrameLayout(getContext());
      this.yN = new ImageView(getContext());
      this.yN.setAdjustViewBounds(false);
      this.yN.setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.br.addView(this.bq);
      this.bq.addView(this.yN);
    }
    this.yN.setImageDrawable(localDrawable);
    float f1 = getContext().getResources().getDisplayMetrics().density;
    int k = (int)(5.0F * f1);
    paramView = (FrameLayout.LayoutParams)this.yN.getLayoutParams();
    int j;
    if ((i == 1) || (i == 2) || (i == 7) || (i == 10))
    {
      j = (int)(64.0F * f1);
      i = (int)(71.0F * f1);
      this.bq.setBackgroundResource(2130838103);
      this.bq.setPadding(k, k, k, k);
      paramView.width = ((int)(28.0F * f1));
      paramView.height = ((int)(28.0F * f1));
      paramView.bottomMargin = ((int)(6.0F * f1));
      paramView.gravity = 17;
      label267:
      paramView = (FrameLayout.LayoutParams)this.bq.getLayoutParams();
      paramView.gravity = 51;
      paramView.leftMargin = (tmp.left - (j - tmp.width()) / 2);
      paramView.topMargin = (tmp.top - i - (int)(15.0F * f1));
      paramView.width = j;
      paramView.height = i;
      if (!this.bGy) {
        break label681;
      }
      this.bq.requestLayout();
    }
    for (;;)
    {
      paramView = this.jdField_b_of_type_Afmi;
      this.jdField_b_of_type_Afmi = paramafmi;
      if ((paramView != null) && (paramView.type == 6) && ((paramView instanceof afpu)) && (this.e != null)) {
        this.e.stop();
      }
      if ((paramafmi.type == 6) && ((paramafmi instanceof afpu)) && ((localDrawable instanceof URLDrawable)))
      {
        localObject = (afpu)paramafmi;
        if (((afpu)localObject).ajH())
        {
          String str = afnu.bEr.replace("[epId]", ((afpu)localObject).e.epId).replace("[eId]", ((afpu)localObject).e.eId);
          if (this.e == null) {
            this.e = new AudioPlayer(getContext(), null);
          }
          this.e.play(str);
          afpu.o((URLDrawable)localDrawable);
        }
        if (2 == ((afpu)localObject).e.jobType) {
          anot.a(null, "CliOper", "", "", "MbYulan", "MbChangan", 0, 0, ((afpu)localObject).e.epId, "", "", "");
        }
      }
      if (this.f == null) {
        break;
      }
      this.f.a(paramView, paramafmi, localDrawable);
      return;
      j = (int)(110.0F * f1);
      i = (int)(110.0F * f1);
      this.bq.setBackgroundResource(2130838102);
      this.bq.setPadding(k, k, k, k);
      paramView.bottomMargin = 0;
      paramView.width = ((int)(100.0F * f1));
      paramView.height = ((int)(100.0F * f1));
      anot.a(null, "CliOper", "", "", "ep_mall", "ep_preview", 0, 0, "", "", "", "");
      break label267;
      label681:
      paramView = (WindowManager)getContext().getSystemService("window");
      i = 24;
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        i = 67108888;
      }
      Object localObject = new WindowManager.LayoutParams(-1, -1, 2, i, -3);
      paramView.addView(this.br, (ViewGroup.LayoutParams)localObject);
      this.bGy = true;
    }
  }
  
  public void cGz()
  {
    if ((this.bq != null) && (this.bGy))
    {
      ((WindowManager)getContext().getSystemService("window")).removeViewImmediate(this.br);
      if (this.e != null) {
        this.e.stop();
      }
      if (this.f != null) {
        this.f.b(this.jdField_b_of_type_Afmi);
      }
      this.bGy = false;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      if ((!this.mHasPerformedLongPress) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$CheckForLongPress != null)) {
        removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$CheckForLongPress);
      }
      if ((this.AV != null) && (!this.mHasPerformedLongPress)) {
        gl(this.AV);
      }
      cGz();
      this.AV = null;
      super.removeCallbacks(this.gr);
      continue;
      this.mHasPerformedLongPress = false;
      this.AV = b(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (this.AV != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$CheckForLongPress == null) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$CheckForLongPress = new CheckForLongPress();
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$CheckForLongPress.cCe();
        postDelayed(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$CheckForLongPress, ViewConfiguration.getLongPressTimeout());
        paramMotionEvent = (afmi)this.AV.getTag();
        if ((paramMotionEvent != null) && (this.f != null) && ("delete".equals(paramMotionEvent.action)))
        {
          this.f.delete();
          continue;
          setPressed(false);
          if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$CheckForLongPress != null) {
            removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$CheckForLongPress);
          }
          removeCallbacks(this.gr);
          cGz();
          this.AV = null;
          continue;
          if ((this.mHasPerformedLongPress) && ((!a(this.AV, tmp)) || (!tmp.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))))
          {
            this.AV = b(paramMotionEvent.getX(), paramMotionEvent.getY());
            if ((this.AV != null) && (this.AV.getTag() != null))
            {
              paramMotionEvent = (afmi)this.AV.getTag();
              if ((paramMotionEvent != null) && (!"delete".equals(paramMotionEvent.action)) && (!"add".equals(paramMotionEvent.action)) && (!"setting".equals(paramMotionEvent.action))) {
                a(this.AV, (afmi)this.AV.getTag());
              }
            }
            else
            {
              cGz();
            }
          }
          else if ((!this.mHasPerformedLongPress) && (this.AV != null) && ((!a(this.AV, tmp)) || (!tmp.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))))
          {
            this.AV = null;
          }
        }
      }
    }
  }
  
  public void setAdapter(b paramb)
  {
    this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$b = paramb;
    this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$b.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$a);
  }
  
  public void setCallBack(afmf paramafmf)
  {
    this.f = paramafmf;
  }
  
  public void setPanelViewType(int paramInt)
  {
    this.cRV = paramInt;
  }
  
  class CheckForLongPress
    implements Runnable
  {
    private int cpb;
    
    CheckForLongPress() {}
    
    public void cCe()
    {
      this.cpb = EmoticonLinearLayout.b(EmoticonLinearLayout.this);
    }
    
    public void run()
    {
      afmi localafmi;
      if ((EmoticonLinearLayout.this.getParent() != null) && (this.cpb == EmoticonLinearLayout.a(EmoticonLinearLayout.this)) && (EmoticonLinearLayout.this.AV != null))
      {
        localafmi = (afmi)EmoticonLinearLayout.this.AV.getTag();
        if (localafmi != null)
        {
          if ((EmoticonLinearLayout.this.f != null) && (EmoticonLinearLayout.this.f.a(localafmi))) {
            break label172;
          }
          EmoticonLinearLayout.this.mHasPerformedLongPress = true;
          EmoticonLinearLayout.this.getParent().requestDisallowInterceptTouchEvent(true);
          EmoticonLinearLayout.this.sendAccessibilityEvent(2);
          if (!"delete".equals(localafmi.action)) {
            break label132;
          }
          EmoticonLinearLayout.this.gr.run();
        }
      }
      label132:
      while (("setting".equals(localafmi.action)) || ("add".equals(localafmi.action))) {
        return;
      }
      EmoticonLinearLayout.this.a(EmoticonLinearLayout.this.AV, localafmi);
      return;
      label172:
      EmoticonLinearLayout.this.AV = null;
    }
  }
  
  public static abstract interface a
  {
    public abstract void hM(int paramInt1, int paramInt2);
    
    public abstract void onDataChanged();
  }
  
  public static abstract class b
  {
    int TL;
    EmoticonLinearLayout.a b;
    public String bEb = "init";
    int bPm;
    boolean bYR;
    boolean bYS;
    boolean bYT;
    boolean bYU;
    boolean bYV;
    boolean bYW;
    afmi c;
    int cRW;
    afmi d;
    afmi e;
    afmi f;
    afmi g;
    afmi h;
    List<afmi> list;
    int page;
    
    public void HT(boolean paramBoolean)
    {
      this.bYR = paramBoolean;
    }
    
    public void HU(boolean paramBoolean)
    {
      this.bYS = paramBoolean;
    }
    
    public void HV(boolean paramBoolean)
    {
      this.bYT = paramBoolean;
    }
    
    public void Mh()
    {
      if (this.b != null) {
        this.b.onDataChanged();
      }
    }
    
    public afmi a(int paramInt)
    {
      paramInt = er(paramInt);
      if (paramInt == -1) {
        return this.c;
      }
      if (paramInt == -2) {
        return this.e;
      }
      if (paramInt == -3) {
        return this.d;
      }
      if (paramInt == -4) {
        return this.f;
      }
      if (paramInt == -5) {
        return this.g;
      }
      if (paramInt == -6) {
        return this.h;
      }
      if ((this.list != null) && (paramInt < this.list.size())) {
        return (afmi)this.list.get(paramInt);
      }
      return null;
    }
    
    public abstract void a(int paramInt, RelativeLayout paramRelativeLayout, ViewGroup paramViewGroup);
    
    void a(EmoticonLinearLayout.a parama)
    {
      this.b = parama;
    }
    
    public void bF(List<afmi> paramList)
    {
      this.list = paramList;
    }
    
    public void c(afmi paramafmi)
    {
      this.c = paramafmi;
    }
    
    public int er(int paramInt)
    {
      int j = 1;
      int i = 0;
      int k = 0;
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonLinearLayout", 2, "getRealIndex, position:" + paramInt + ",pageTotalNum:" + this.cRW + ",page:" + this.page);
      }
      if (this.bYR) {
        if ((paramInt + 1) % this.cRW == 0) {
          paramInt = -1;
        }
      }
      int m;
      label237:
      label242:
      do
      {
        do
        {
          return paramInt;
          return paramInt + this.page * (this.cRW - 1);
          if (this.bYV)
          {
            if ((paramInt == 0) && (this.page == 0)) {
              return -5;
            }
            if (this.bYW) {
              i = 1;
            }
            if ((paramInt == 1) && (this.page == 0) && (this.bYW)) {
              return -6;
            }
            if (this.page == 0) {
              return paramInt - 1 - i;
            }
            return this.cRW - 1 + (this.page - 1) * this.cRW + paramInt - i;
          }
          m = this.list.size();
          if (this.bYU)
          {
            i = 1;
            if (!this.bYT) {
              break label237;
            }
          }
          for (;;)
          {
            if (this.page + paramInt != 0) {
              break label270;
            }
            if (!this.bYU) {
              break label242;
            }
            return -4;
            i = 0;
            break;
            j = 0;
          }
          paramInt = k;
        } while (this.list.size() != 0);
        paramInt = k;
      } while (!this.bYT);
      return -2;
      label270:
      if (this.page * this.cRW + paramInt == i + (m - 1) + j)
      {
        if (this.bYT) {
          return -2;
        }
        return this.list.size() - 1;
      }
      if (this.bYU) {
        return this.page * this.cRW + paramInt - 1;
      }
      return paramInt + this.page * this.cRW;
    }
    
    public int getColumnNum()
    {
      return this.TL;
    }
    
    public int getRowNum()
    {
      return this.bPm;
    }
    
    public void hN(int paramInt1, int paramInt2)
    {
      this.bPm = paramInt1;
      this.TL = paramInt2;
      this.cRW = (paramInt2 * paramInt1);
      this.b.hM(paramInt1, paramInt2);
    }
    
    public void setPage(int paramInt)
    {
      this.page = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonLinearLayout
 * JD-Core Version:    0.7.0.1
 */