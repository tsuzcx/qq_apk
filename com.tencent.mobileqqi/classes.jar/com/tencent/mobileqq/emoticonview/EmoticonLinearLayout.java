package com.tencent.mobileqq.emoticonview;

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
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.statistics.ReportController;
import fsr;
import fss;
import fst;
import java.util.ArrayList;
import java.util.List;

public class EmoticonLinearLayout
  extends LinearLayout
{
  private static Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private static final String jdField_a_of_type_JavaLangString = "EmoticonLinearLayout";
  float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 6;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private AudioPlayer jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer;
  private EmoticonCallback jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback;
  private EmoticonInfo jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo;
  EmoticonLinearLayout.DataObserver jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$DataObserver = new fsr(this);
  public EmoticonLinearLayout.EmoticonAdapter a;
  private fst jdField_a_of_type_Fst;
  private Runnable jdField_a_of_type_JavaLangRunnable = new fss(this);
  public List a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private boolean jdField_b_of_type_Boolean = false;
  
  public EmoticonLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_Int = getResources().getColor(2131361825);
    setOrientation(1);
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    setClickable(true);
    setLongClickable(true);
  }
  
  private View a(float paramFloat1, float paramFloat2)
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      LinearLayout localLinearLayout = (LinearLayout)getChildAt(i);
      float f1 = getScrollX() + paramFloat1 - localLinearLayout.getLeft();
      float f2 = getScrollY() + paramFloat2 - localLinearLayout.getTop();
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
  
  private void a(View paramView)
  {
    paramView = (EmoticonInfo)paramView.getTag();
    if (paramView != null)
    {
      sendAccessibilityEvent(1);
      playSoundEffect(0);
      if ((!"delete".equals(paramView.a)) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback != null))
      {
        if (!"setting".equals(paramView.a)) {
          break label63;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback.u_();
      }
    }
    return;
    label63:
    if ("add".equals(paramView.a))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback.d();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback.a(paramView);
  }
  
  private void a(View paramView, EmoticonInfo paramEmoticonInfo)
  {
    Drawable localDrawable = paramEmoticonInfo.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float);
    if (localDrawable == null) {
      return;
    }
    paramView.getGlobalVisibleRect(jdField_a_of_type_AndroidGraphicsRect);
    int i = paramEmoticonInfo.jdField_b_of_type_Int;
    if (this.jdField_b_of_type_AndroidWidgetFrameLayout == null)
    {
      this.jdField_b_of_type_AndroidWidgetFrameLayout = new FrameLayout(getContext());
      this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(getContext());
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
      this.jdField_a_of_type_AndroidWidgetImageView.setAdjustViewBounds(false);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
    }
    if (localDrawable != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
    }
    float f = getContext().getResources().getDisplayMetrics().density;
    int k = (int)(5.0F * f);
    paramView = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    int j;
    if ((i == 1) || (i == 2) || (i == 7))
    {
      j = (int)(64.0F * f);
      i = (int)(71.0F * f);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837635);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setPadding(k, k, k, k);
      paramView.width = ((int)(28.0F * f));
      paramView.height = ((int)(28.0F * f));
      paramView.bottomMargin = ((int)(6.0F * f));
      paramView.gravity = 17;
      label263:
      paramView = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      paramView.gravity = 51;
      paramView.leftMargin = (jdField_a_of_type_AndroidGraphicsRect.left - (j - jdField_a_of_type_AndroidGraphicsRect.width()) / 2);
      paramView.topMargin = (jdField_a_of_type_AndroidGraphicsRect.top - i - (int)(15.0F * f));
      paramView.width = j;
      paramView.height = i;
      if (!this.jdField_b_of_type_Boolean) {
        break label665;
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.requestLayout();
    }
    for (;;)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo = paramEmoticonInfo;
      if ((paramView != null) && (paramView.jdField_b_of_type_Int == 6) && ((paramView instanceof PicEmoticonInfo)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a();
      }
      if ((paramEmoticonInfo.jdField_b_of_type_Int == 6) && ((paramEmoticonInfo instanceof PicEmoticonInfo)) && ((localDrawable instanceof URLDrawable)))
      {
        localObject = (PicEmoticonInfo)paramEmoticonInfo;
        if (((PicEmoticonInfo)localObject).a())
        {
          String str = EmosmUtils.getEmoticonSoundPath(((PicEmoticonInfo)localObject).a.epId, ((PicEmoticonInfo)localObject).a.eId);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer == null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new AudioPlayer(getContext(), null);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(str);
          PicEmoticonInfo.a((URLDrawable)localDrawable);
        }
        if (2 == ((PicEmoticonInfo)localObject).a.jobType) {
          ReportController.b(null, "CliOper", "", "", "MbYulan", "MbChangan", 0, 0, ((PicEmoticonInfo)localObject).a.epId, "", "", "");
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback.a(paramView, paramEmoticonInfo, localDrawable);
      return;
      j = (int)(110.0F * f);
      i = (int)(110.0F * f);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837634);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setPadding(k, k, k, k);
      paramView.bottomMargin = 0;
      paramView.width = ((int)(100.0F * f));
      paramView.height = ((int)(100.0F * f));
      ReportController.b(null, "CliOper", "", "", "ep_mall", "ep_preview", 0, 0, "", "", "", "");
      break label263;
      label665:
      paramView = (WindowManager)getContext().getSystemService("window");
      Object localObject = new WindowManager.LayoutParams(-1, -1, 2, 24, -3);
      paramView.addView(this.jdField_b_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_Boolean = true;
    }
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
  
  public EmoticonLinearLayout.EmoticonAdapter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter;
  }
  
  public void a() {}
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_b_of_type_Boolean))
    {
      ((WindowManager)getContext().getSystemService("window")).removeViewImmediate(this.jdField_b_of_type_AndroidWidgetFrameLayout);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo);
      }
      this.jdField_b_of_type_Boolean = false;
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
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Fst != null)) {
        removeCallbacks(this.jdField_a_of_type_Fst);
      }
      if ((this.jdField_a_of_type_AndroidViewView != null) && (!this.jdField_a_of_type_Boolean)) {
        a(this.jdField_a_of_type_AndroidViewView);
      }
      b();
      this.jdField_a_of_type_AndroidViewView = null;
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      continue;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidViewView = a(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        if (this.jdField_a_of_type_Fst == null) {
          this.jdField_a_of_type_Fst = new fst(this);
        }
        this.jdField_a_of_type_Fst.a();
        postDelayed(this.jdField_a_of_type_Fst, ViewConfiguration.getLongPressTimeout());
        paramMotionEvent = (EmoticonInfo)this.jdField_a_of_type_AndroidViewView.getTag();
        if ((paramMotionEvent != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback != null) && ("delete".equals(paramMotionEvent.a)))
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback.a();
          continue;
          setPressed(false);
          if (this.jdField_a_of_type_Fst != null) {
            removeCallbacks(this.jdField_a_of_type_Fst);
          }
          removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          b();
          this.jdField_a_of_type_AndroidViewView = null;
          continue;
          if ((this.jdField_a_of_type_Boolean) && ((!a(this.jdField_a_of_type_AndroidViewView, jdField_a_of_type_AndroidGraphicsRect)) || (!jdField_a_of_type_AndroidGraphicsRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))))
          {
            this.jdField_a_of_type_AndroidViewView = a(paramMotionEvent.getX(), paramMotionEvent.getY());
            if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getTag() != null))
            {
              paramMotionEvent = (EmoticonInfo)this.jdField_a_of_type_AndroidViewView.getTag();
              if ((paramMotionEvent != null) && (!"delete".equals(paramMotionEvent.a)) && (!"add".equals(paramMotionEvent.a)) && (!"setting".equals(paramMotionEvent.a))) {
                a(this.jdField_a_of_type_AndroidViewView, (EmoticonInfo)this.jdField_a_of_type_AndroidViewView.getTag());
              }
            }
            else
            {
              b();
            }
          }
          else if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView != null) && ((!a(this.jdField_a_of_type_AndroidViewView, jdField_a_of_type_AndroidGraphicsRect)) || (!jdField_a_of_type_AndroidGraphicsRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))))
          {
            this.jdField_a_of_type_AndroidViewView = null;
          }
        }
      }
    }
  }
  
  public void setAdapter(EmoticonLinearLayout.EmoticonAdapter paramEmoticonAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter = paramEmoticonAdapter;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$DataObserver);
  }
  
  public void setCallBack(EmoticonCallback paramEmoticonCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = paramEmoticonCallback;
  }
  
  public void setPanelViewType(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonLinearLayout
 * JD-Core Version:    0.7.0.1
 */