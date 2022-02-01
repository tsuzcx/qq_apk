package com.tencent.qqmail.activity.compose;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.qqmail.activity.compose.richeditor.ColorStyleView;
import com.tencent.qqmail.activity.compose.richeditor.QMUIRichEditor.OnDecorationStateListener;
import com.tencent.qqmail.activity.compose.richeditor.QMUIRichEditorState;
import java.util.List;

public class ComposeToolBar
  extends FrameLayout
  implements QMUIRichEditor.OnDecorationStateListener
{
  private static final int DURATION = 160;
  private static final String TAG = "ComposeToolBar";
  private ImageView formatBoldIv;
  private ImageView formatBulletIv;
  private ImageView formatCenterIv;
  private ImageView formatColorTv;
  private ImageView formatFontIv;
  private ImageView formatQuoteIv;
  private ImageView formatStrikeThroughIv;
  private ActionListener mActionListener;
  private ValueAnimator mCurrentAnimator;
  private TextView mFontBigTv;
  private ColorStyleView mFontColorBlackView;
  private ColorStyleView mFontColorBlueView;
  private ColorStyleView mFontColorGrayView;
  private ColorStyleView mFontColorRedView;
  private TextView mFontDefaultTv;
  private TextView mFontSmallTv;
  private View mFuncDivider;
  private boolean mIsAnimating = false;
  private int mPointOne;
  private int mPointOneRightWidth;
  private int mPointTwo;
  private int mPointTwoRightWidth;
  
  public ComposeToolBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ComposeToolBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(getContext()).inflate(2131559046, this);
    setBackgroundResource(2130841305);
    this.formatFontIv = ((ImageView)findViewById(2131366273));
    this.formatColorTv = ((ImageView)findViewById(2131366272));
    this.formatBoldIv = ((ImageView)findViewById(2131366271));
    this.formatStrikeThroughIv = ((ImageView)findViewById(2131366275));
    this.formatCenterIv = ((ImageView)findViewById(2131366277));
    this.formatBulletIv = ((ImageView)findViewById(2131366274));
    this.formatQuoteIv = ((ImageView)findViewById(2131366276));
    this.mFuncDivider = findViewById(2131367820);
    this.mFontSmallTv = ((TextView)findViewById(2131367442));
    this.mFontDefaultTv = ((TextView)findViewById(2131367426));
    this.mFontBigTv = ((TextView)findViewById(2131367416));
    this.mFontColorBlackView = ((ColorStyleView)findViewById(2131364928));
    this.mFontColorBlueView = ((ColorStyleView)findViewById(2131364929));
    this.mFontColorRedView = ((ColorStyleView)findViewById(2131364931));
    this.mFontColorGrayView = ((ColorStyleView)findViewById(2131364930));
    paramContext = new ComposeToolBar.1(this);
    this.formatBoldIv.setOnClickListener(paramContext);
    this.formatStrikeThroughIv.setOnClickListener(paramContext);
    this.formatCenterIv.setOnClickListener(paramContext);
    this.formatBulletIv.setOnClickListener(paramContext);
    this.formatQuoteIv.setOnClickListener(paramContext);
    this.formatFontIv.setOnClickListener(new ComposeToolBar.2(this));
    this.formatColorTv.setOnClickListener(new ComposeToolBar.3(this));
    paramContext = new ComposeToolBar.4(this);
    this.mFontSmallTv.setOnClickListener(paramContext);
    this.mFontDefaultTv.setOnClickListener(paramContext);
    this.mFontBigTv.setOnClickListener(paramContext);
    this.mFontColorBlackView.setOnClickListener(paramContext);
    this.mFontColorBlueView.setOnClickListener(paramContext);
    this.mFontColorRedView.setOnClickListener(paramContext);
    this.mFontColorGrayView.setOnClickListener(paramContext);
  }
  
  private void extendColorPanel()
  {
    if (this.mIsAnimating) {
      return;
    }
    this.mCurrentAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.mCurrentAnimator.setDuration(160L);
    this.mCurrentAnimator.addListener(new ComposeToolBar.9(this));
    this.mCurrentAnimator.addUpdateListener(new ComposeToolBar.10(this));
    this.formatColorTv.setSelected(true);
    this.mCurrentAnimator.start();
  }
  
  private void extendFontPanel()
  {
    if (this.mIsAnimating) {
      return;
    }
    this.mCurrentAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.mCurrentAnimator.setDuration(160L);
    this.mCurrentAnimator.addListener(new ComposeToolBar.5(this));
    this.mCurrentAnimator.addUpdateListener(new ComposeToolBar.6(this));
    this.formatFontIv.setSelected(true);
    this.mCurrentAnimator.start();
  }
  
  private void offsetColor(int paramInt)
  {
    int i = this.mPointTwo - this.mPointOne;
    int j = this.mPointOneRightWidth / 5;
    int k = (j - i) * paramInt / this.mPointTwoRightWidth;
    this.mFontColorBlackView.offsetLeftAndRight(k);
    k = (j * 2 - i) * paramInt / this.mPointTwoRightWidth;
    this.mFontColorBlueView.offsetLeftAndRight(k);
    k = (j * 3 - i) * paramInt / this.mPointTwoRightWidth;
    this.mFontColorRedView.offsetLeftAndRight(k);
    paramInt = (j * 4 - i) * paramInt / this.mPointTwoRightWidth;
    this.mFontColorGrayView.offsetLeftAndRight(paramInt);
  }
  
  private void offsetFont(int paramInt)
  {
    int i = this.mPointOneRightWidth / 4;
    int j = (i - this.mFontSmallTv.getWidth() / 2) * paramInt / this.mPointOneRightWidth;
    this.mFontSmallTv.offsetLeftAndRight(j);
    j = (i * 2 - this.mFontDefaultTv.getWidth() / 2) * paramInt / this.mPointOneRightWidth;
    this.mFontDefaultTv.offsetLeftAndRight(j);
    paramInt = (i * 3 - this.mFontBigTv.getWidth() / 2) * paramInt / this.mPointOneRightWidth;
    this.mFontBigTv.offsetLeftAndRight(paramInt);
  }
  
  private void onColorAnimationUpdate(float paramFloat)
  {
    if (!this.mIsAnimating) {
      return;
    }
    this.mFontColorBlackView.setAlpha(paramFloat);
    this.mFontColorBlueView.setAlpha(paramFloat);
    this.mFontColorRedView.setAlpha(paramFloat);
    this.mFontColorGrayView.setAlpha(paramFloat);
    this.mFuncDivider.setAlpha(paramFloat);
    float f = 1.0F - paramFloat;
    this.formatBoldIv.setAlpha(f);
    this.formatCenterIv.setAlpha(f);
    this.formatBulletIv.setAlpha(f);
    this.formatQuoteIv.setAlpha(f);
    this.formatFontIv.setAlpha(f);
    int i = (int)(this.mPointTwoRightWidth * paramFloat + this.mPointTwo) - this.formatBoldIv.getLeft();
    this.formatBoldIv.offsetLeftAndRight(i);
    this.formatCenterIv.offsetLeftAndRight(i);
    this.formatBulletIv.offsetLeftAndRight(i);
    this.formatQuoteIv.offsetLeftAndRight(i);
    int j = (int)(this.mPointOne * (1.0F - paramFloat) - this.formatColorTv.getLeft());
    this.formatColorTv.offsetLeftAndRight(j);
    this.formatFontIv.offsetLeftAndRight(j);
    offsetColor(i);
  }
  
  private void onFontAnimationUpdate(float paramFloat)
  {
    if (!this.mIsAnimating) {
      return;
    }
    this.mFontSmallTv.setAlpha(paramFloat);
    this.mFontDefaultTv.setAlpha(paramFloat);
    this.mFontBigTv.setAlpha(paramFloat);
    this.mFuncDivider.setAlpha(paramFloat);
    float f = 1.0F - paramFloat;
    this.formatColorTv.setAlpha(f);
    this.formatBoldIv.setAlpha(f);
    this.formatCenterIv.setAlpha(f);
    this.formatBulletIv.setAlpha(f);
    this.formatQuoteIv.setAlpha(f);
    int i = (int)(this.mPointOneRightWidth * paramFloat + this.mPointOne) - this.formatColorTv.getLeft();
    this.formatColorTv.offsetLeftAndRight(i);
    this.formatBoldIv.offsetLeftAndRight(i);
    this.formatCenterIv.offsetLeftAndRight(i);
    this.formatBulletIv.offsetLeftAndRight(i);
    this.formatQuoteIv.offsetLeftAndRight(i);
    offsetFont(i);
  }
  
  private void packUpColorPanel()
  {
    if (this.mIsAnimating) {
      return;
    }
    this.mCurrentAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.mCurrentAnimator.setDuration(160L);
    this.mCurrentAnimator.addListener(new ComposeToolBar.11(this));
    this.mCurrentAnimator.addUpdateListener(new ComposeToolBar.12(this));
    this.formatColorTv.setSelected(false);
    this.mCurrentAnimator.start();
  }
  
  private void packUpFontPanel()
  {
    if (this.mIsAnimating) {
      return;
    }
    this.mCurrentAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.mCurrentAnimator.setDuration(160L);
    this.mCurrentAnimator.addListener(new ComposeToolBar.7(this));
    this.mCurrentAnimator.addUpdateListener(new ComposeToolBar.8(this));
    this.formatFontIv.setSelected(false);
    this.mCurrentAnimator.start();
  }
  
  private void resetFontColorStyle()
  {
    this.mFontColorBlackView.setSelected(false);
    this.mFontColorBlueView.setSelected(false);
    this.mFontColorRedView.setSelected(false);
    this.mFontColorGrayView.setSelected(false);
  }
  
  private void resetFontSizeStyle()
  {
    this.mFontSmallTv.setSelected(false);
    this.mFontDefaultTv.setSelected(false);
    this.mFontBigTv.setSelected(false);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mCurrentAnimator != null)
    {
      this.mCurrentAnimator.end();
      this.mCurrentAnimator = null;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt4 = paramInt3 - paramInt1;
    if (paramInt4 == 0) {}
    do
    {
      do
      {
        return;
        paramInt2 = 0;
        if (this.formatFontIv.getVisibility() == 0) {
          paramInt2 = 1;
        }
        paramInt1 = paramInt2;
        if (this.formatColorTv.getVisibility() == 0) {
          paramInt1 = paramInt2 + 1;
        }
        paramInt2 = paramInt1;
        if (this.formatBoldIv.getVisibility() == 0) {
          paramInt2 = paramInt1 + 1;
        }
        paramInt1 = paramInt2;
        if (this.formatStrikeThroughIv.getVisibility() == 0) {
          paramInt1 = paramInt2 + 1;
        }
        paramInt2 = paramInt1;
        if (this.formatCenterIv.getVisibility() == 0) {
          paramInt2 = paramInt1 + 1;
        }
        paramInt1 = paramInt2;
        if (this.formatBulletIv.getVisibility() == 0) {
          paramInt1 = paramInt2 + 1;
        }
        paramInt2 = paramInt1;
        if (this.formatQuoteIv.getVisibility() == 0) {
          paramInt2 = paramInt1 + 1;
        }
        this.mPointOne = (paramInt4 / paramInt2);
        this.mPointOneRightWidth = (paramInt3 - this.mPointOne);
        this.mPointTwo = (this.mPointOne * 2);
        this.mPointTwoRightWidth = (paramInt3 - this.mPointTwo);
        this.mFuncDivider.layout(this.mPointOne, this.mFuncDivider.getTop(), this.mPointOne + this.mFuncDivider.getWidth(), this.mFuncDivider.getBottom());
        this.mFontSmallTv.layout(this.mPointOne, this.mFontSmallTv.getTop(), this.mPointOne + this.mFontSmallTv.getWidth(), this.mFontSmallTv.getBottom());
        this.mFontDefaultTv.layout(this.mPointOne, this.mFontDefaultTv.getTop(), this.mPointOne + this.mFontDefaultTv.getWidth(), this.mFontDefaultTv.getBottom());
        this.mFontBigTv.layout(this.mPointOne, this.mFontBigTv.getTop(), this.mPointOne + this.mFontBigTv.getWidth(), this.mFontBigTv.getBottom());
        paramInt1 = this.mFontColorBlackView.getWidth() / 2;
        this.mFontColorBlackView.layout(this.mPointTwo - paramInt1, this.mFontColorBlackView.getTop(), this.mPointTwo + paramInt1, this.mFontColorBlackView.getBottom());
        this.mFontColorBlueView.layout(this.mPointTwo - paramInt1, this.mFontColorBlueView.getTop(), this.mPointTwo + paramInt1, this.mFontColorBlueView.getBottom());
        this.mFontColorRedView.layout(this.mPointTwo - paramInt1, this.mFontColorRedView.getTop(), this.mPointTwo + paramInt1, this.mFontColorRedView.getBottom());
        this.mFontColorGrayView.layout(this.mPointTwo - paramInt1, this.mFontColorGrayView.getTop(), paramInt1 + this.mPointTwo, this.mFontColorGrayView.getBottom());
      } while (this.mIsAnimating);
      if (this.formatFontIv.isSelected()) {
        if (this.formatColorTv.getLeft() == this.mPointOne) {
          extendFontPanel();
        }
      }
      while (this.formatColorTv.isSelected()) {
        if (this.formatColorTv.getLeft() == this.mPointOne)
        {
          extendColorPanel();
          return;
          offsetFont(this.mPointOneRightWidth);
          continue;
          if (this.mFontSmallTv.getVisibility() == 0) {
            packUpFontPanel();
          }
        }
        else
        {
          offsetColor(this.mPointTwoRightWidth);
          return;
        }
      }
    } while (this.mFontColorBlackView.getVisibility() != 0);
    packUpColorPanel();
  }
  
  public void onStateChangeListener(String paramString, @NonNull List<QMUIRichEditorState> paramList)
  {
    boolean bool8 = true;
    Log.i("ComposeToolBar", "onStateChangeListener types = " + paramList);
    int j = 0;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    int i = 0;
    boolean bool1 = false;
    boolean bool6;
    boolean bool7;
    if (j < paramList.size())
    {
      paramString = (QMUIRichEditorState)paramList.get(j);
      if (paramString == QMUIRichEditorState.BOLD)
      {
        bool6 = bool5;
        bool7 = true;
        bool5 = bool1;
        bool4 = bool2;
        bool2 = bool7;
        bool1 = bool6;
      }
    }
    for (;;)
    {
      j += 1;
      bool6 = bool5;
      bool7 = bool4;
      bool5 = bool1;
      bool4 = bool2;
      bool2 = bool7;
      bool1 = bool6;
      break;
      if (paramString == QMUIRichEditorState.STRIKETHROUGH)
      {
        bool2 = bool5;
        bool5 = bool1;
        bool6 = true;
        bool1 = bool2;
        bool2 = bool4;
        bool4 = bool6;
      }
      else if (paramString == QMUIRichEditorState.JUSTIFYCENTER)
      {
        bool7 = true;
        bool5 = bool2;
        bool6 = bool1;
        bool1 = bool7;
        bool2 = bool4;
        bool4 = bool5;
        bool5 = bool6;
      }
      else if ((paramString == QMUIRichEditorState.ORDEREDLIST) || (paramString == QMUIRichEditorState.UNORDEREDLIST))
      {
        bool1 = bool5;
        bool5 = bool2;
        bool6 = true;
        bool2 = bool4;
        bool4 = bool5;
        bool5 = bool6;
      }
      else
      {
        if (paramString == QMUIRichEditorState.FONTSIZE)
        {
          paramString = paramString.getCustomContent();
          resetFontSizeStyle();
          if ("SMALL".equals(paramString))
          {
            this.mFontSmallTv.setSelected(true);
            bool6 = bool2;
            bool7 = bool1;
            bool1 = bool5;
            bool2 = bool4;
            bool4 = bool6;
            bool5 = bool7;
            continue;
          }
          if ("NORMAL".equals(paramString))
          {
            this.mFontDefaultTv.setSelected(true);
            bool6 = bool2;
            bool7 = bool1;
            bool1 = bool5;
            bool2 = bool4;
            bool4 = bool6;
            bool5 = bool7;
            continue;
          }
          if ("BIG".equals(paramString))
          {
            this.mFontBigTv.setSelected(true);
            bool6 = bool2;
            bool7 = bool1;
            bool1 = bool5;
            bool2 = bool4;
            bool4 = bool6;
            bool5 = bool7;
          }
        }
        else if (paramString == QMUIRichEditorState.COLOR)
        {
          paramString = paramString.getCustomContent();
          resetFontColorStyle();
          if ("#000000".equalsIgnoreCase(paramString))
          {
            this.mFontColorBlackView.setSelected(true);
            bool6 = bool2;
            bool7 = bool1;
            bool1 = bool5;
            bool2 = bool4;
            bool4 = bool6;
            bool5 = bool7;
            continue;
          }
          if ("#198dd9".equalsIgnoreCase(paramString))
          {
            this.mFontColorBlueView.setSelected(true);
            bool6 = bool2;
            bool7 = bool1;
            bool1 = bool5;
            bool2 = bool4;
            bool4 = bool6;
            bool5 = bool7;
            continue;
          }
          if ("#f64e4f".equalsIgnoreCase(paramString))
          {
            this.mFontColorRedView.setSelected(true);
            bool6 = bool2;
            bool7 = bool1;
            bool1 = bool5;
            bool2 = bool4;
            bool4 = bool6;
            bool5 = bool7;
            continue;
          }
          if ("#A6A7AC".equalsIgnoreCase(paramString))
          {
            this.mFontColorGrayView.setSelected(true);
            bool6 = bool2;
            bool7 = bool1;
            bool1 = bool5;
            bool2 = bool4;
            bool4 = bool6;
            bool5 = bool7;
          }
        }
        else
        {
          if (paramString.isTitle())
          {
            bool6 = bool5;
            bool5 = bool1;
            bool7 = bool2;
            i = 1;
            bool1 = bool6;
            bool2 = bool4;
            bool4 = bool7;
            continue;
          }
          if (paramString.isQuote())
          {
            bool3 = bool5;
            bool5 = bool2;
            bool2 = bool4;
            bool4 = true;
            bool6 = bool1;
            bool1 = bool3;
            bool3 = bool4;
            bool4 = bool5;
            bool5 = bool6;
            continue;
            if (i != 0)
            {
              this.formatBoldIv.setSelected(false);
              this.formatBoldIv.setAlpha(0.5F);
              paramString = this.formatBoldIv;
              if (i != 0) {
                break label771;
              }
            }
            label771:
            for (bool4 = bool8;; bool4 = false)
            {
              paramString.setEnabled(bool4);
              this.formatStrikeThroughIv.setSelected(bool2);
              this.formatCenterIv.setSelected(bool5);
              this.formatBulletIv.setSelected(bool1);
              this.formatQuoteIv.setSelected(bool3);
              return;
              this.formatBoldIv.setAlpha(1.0F);
              this.formatBoldIv.setSelected(bool4);
              break;
            }
          }
        }
        bool6 = bool2;
        bool7 = bool1;
        bool1 = bool5;
        bool2 = bool4;
        bool4 = bool6;
        bool5 = bool7;
      }
    }
  }
  
  public void packUpFontAndColorPane()
  {
    if (this.formatFontIv.isSelected()) {
      packUpFontPanel();
    }
    while (!this.formatColorTv.isSelected()) {
      return;
    }
    packUpColorPanel();
  }
  
  public void setActionListener(ActionListener paramActionListener)
  {
    this.mActionListener = paramActionListener;
  }
  
  public static abstract interface ActionListener
  {
    public abstract void onClick(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeToolBar
 * JD-Core Version:    0.7.0.1
 */