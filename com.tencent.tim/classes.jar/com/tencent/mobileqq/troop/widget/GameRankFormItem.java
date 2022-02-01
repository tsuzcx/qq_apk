package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.widget.MultiImageTextView;

public class GameRankFormItem
  extends FormSimpleItem
{
  public int mRank;
  
  public GameRankFormItem(Context paramContext)
  {
    super(paramContext);
  }
  
  public void aXn()
  {
    if (this.b == null) {}
    label282:
    label319:
    label448:
    do
    {
      do
      {
        return;
        cVP();
        if (this.xt != null) {
          this.xt.setMaxWidth(this.efR);
        }
        if (this.mRank <= 0) {
          break;
        }
        if (this.aD == null) {
          this.aD = "";
        }
        this.b.setVisibility(0);
        if (this.mRank >= 4)
        {
          this.b.setText(this.aD + String.valueOf(this.mRank));
          this.b.setTextColor(d(getResources(), this.efQ));
          this.b.setContentDescription(this.aD + String.valueOf(this.mRank));
          this.b.setMaxWidth(this.efS);
          if ((this.mRightIcon == null) || (!this.mShowArrow)) {
            break label448;
          }
          if ((this.mRightIconWidth <= 0) || (this.mRightIconHeight <= 0)) {
            break label428;
          }
          this.ge.setBounds(0, 0, this.ge.getIntrinsicWidth(), this.ge.getIntrinsicHeight());
          this.mRightIcon.setBounds(0, 0, this.mRightIconWidth, this.mRightIconHeight);
          this.b.setCompoundDrawables(this.mRightIcon, null, this.ge, null);
        }
        for (;;)
        {
          this.b.setCompoundDrawablePadding(8);
          return;
          if (this.mRank <= 0) {
            break;
          }
          Object localObject = getResources();
          int i;
          CharSequence localCharSequence;
          TextPaint localTextPaint;
          int k;
          if (this.mRank == 1)
          {
            i = 2130844555;
            localObject = ((Resources)localObject).getDrawable(i);
            localCharSequence = this.aD;
            localTextPaint = this.b.getPaint();
            k = this.efS;
            if (this.mRightIcon != null) {
              break label412;
            }
            i = 0;
            if (!this.mShowArrow) {
              break label423;
            }
          }
          for (int j = this.ge.getIntrinsicWidth();; j = 0)
          {
            localCharSequence = TextUtils.ellipsize(localCharSequence, localTextPaint, k - i - j - ((Drawable)localObject).getIntrinsicWidth(), TextUtils.TruncateAt.END);
            this.b.setText(localCharSequence);
            this.b.a((Drawable)localObject, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight()).exh();
            break;
            if (this.mRank == 2)
            {
              i = 2130844556;
              break label282;
            }
            i = 2130844557;
            break label282;
            i = this.mRightIcon.getIntrinsicWidth();
            break label319;
          }
          this.b.setCompoundDrawablesWithIntrinsicBounds(this.mRightIcon, null, this.ge, null);
        }
        if ((this.mRightIcon != null) && (!this.mShowArrow))
        {
          if ((this.mRightIconWidth > 0) && (this.mRightIconHeight > 0))
          {
            this.mRightIcon.setBounds(0, 0, this.mRightIconWidth, this.mRightIconHeight);
            this.b.setCompoundDrawables(this.mRightIcon, null, null, null);
          }
          for (;;)
          {
            this.b.setCompoundDrawablePadding(8);
            return;
            this.b.setCompoundDrawablesWithIntrinsicBounds(this.mRightIcon, null, null, null);
          }
        }
        if ((this.mRightIcon == null) && (this.mShowArrow))
        {
          this.b.setCompoundDrawablesWithIntrinsicBounds(null, null, this.ge, null);
          this.b.setCompoundDrawablePadding(8);
          return;
        }
      } while ((this.mRightIcon != null) || (this.mShowArrow));
      this.b.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.b.setCompoundDrawablePadding(0);
      return;
      this.b.setText("");
      if ((this.mRightIcon != null) && (this.mShowArrow))
      {
        this.b.setVisibility(0);
        if ((this.mRightIconWidth > 0) && (this.mRightIconHeight > 0))
        {
          this.mRightIcon.setBounds(0, 0, this.mRightIconWidth, this.mRightIconHeight);
          this.ge.setBounds(0, 0, this.ge.getIntrinsicWidth(), this.ge.getIntrinsicHeight());
          this.b.setCompoundDrawables(this.mRightIcon, null, this.ge, null);
        }
        for (;;)
        {
          this.b.setCompoundDrawablePadding(8);
          return;
          this.b.setCompoundDrawablesWithIntrinsicBounds(this.mRightIcon, null, this.ge, null);
        }
      }
      if ((this.mRightIcon != null) && (!this.mShowArrow))
      {
        this.b.setVisibility(0);
        if ((this.mRightIconWidth > 0) && (this.mRightIconHeight > 0))
        {
          this.mRightIcon.setBounds(0, 0, this.mRightIconWidth, this.mRightIconHeight);
          this.b.setCompoundDrawables(this.mRightIcon, null, null, null);
        }
        for (;;)
        {
          this.b.setCompoundDrawablePadding(0);
          return;
          this.b.setCompoundDrawablesWithIntrinsicBounds(this.mRightIcon, null, null, null);
        }
      }
      if ((this.mRightIcon == null) && (this.mShowArrow))
      {
        this.b.setVisibility(0);
        this.b.setCompoundDrawablesWithIntrinsicBounds(null, null, this.ge, null);
        this.b.setCompoundDrawablePadding(0);
        return;
      }
    } while ((this.mRightIcon != null) || (this.mShowArrow));
    label412:
    label423:
    label428:
    this.b.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.GameRankFormItem
 * JD-Core Version:    0.7.0.1
 */