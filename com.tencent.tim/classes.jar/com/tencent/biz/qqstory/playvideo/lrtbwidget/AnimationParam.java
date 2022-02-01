package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import pmb;
import qih;
import ram;
import rop;
import rpq;

public class AnimationParam
  implements Parcelable
{
  public static final Parcelable.Creator<AnimationParam> CREATOR = new qih();
  private boolean aDx;
  private String axt;
  private Drawable drawable;
  public int positionX;
  public int positionY;
  public int viewHeight;
  public int viewWidth;
  
  public AnimationParam(Parcel paramParcel)
  {
    this.positionX = paramParcel.readInt();
    this.positionY = paramParcel.readInt();
    this.viewWidth = paramParcel.readInt();
    this.viewHeight = paramParcel.readInt();
    this.axt = paramParcel.readString();
  }
  
  public AnimationParam(@NonNull View paramView)
  {
    this(paramView, true);
  }
  
  public AnimationParam(@NonNull View paramView, boolean paramBoolean)
  {
    this.aDx = paramBoolean;
    Object localObject2 = new Rect();
    paramView.getGlobalVisibleRect((Rect)localObject2);
    Object localObject1;
    if ((paramView instanceof ImageView))
    {
      localObject1 = ((ImageView)paramView).getDrawable();
      if (localObject1 != null)
      {
        localObject1 = ((Drawable)localObject1).getConstantState();
        if (localObject1 != null)
        {
          this.positionX = (((Rect)localObject2).left + paramView.getPaddingLeft());
          this.positionY = (((Rect)localObject2).top + paramView.getPaddingTop());
          this.viewWidth = (paramView.getWidth() - paramView.getPaddingLeft() - paramView.getPaddingRight());
          this.viewHeight = (paramView.getHeight() - paramView.getPaddingTop() - paramView.getPaddingBottom());
        }
      }
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        this.positionX = ((Rect)localObject2).left;
        this.positionY = ((Rect)localObject2).top;
        this.viewWidth = paramView.getWidth();
        this.viewHeight = paramView.getHeight();
      }
      label231:
      Drawable localDrawable;
      if (((Rect)localObject2).bottom < rpq.getWindowScreenHeight(paramView.getContext()))
      {
        if (localObject1 != null) {
          this.positionY = (((Rect)localObject2).bottom - paramView.getHeight() + paramView.getPaddingTop());
        }
      }
      else
      {
        if (((Rect)localObject2).right < rpq.getWindowScreenWidth(paramView.getContext()))
        {
          if (localObject1 == null) {
            break label411;
          }
          this.positionX = (((Rect)localObject2).right - paramView.getWidth() + paramView.getPaddingLeft());
        }
        localObject2 = (pmb)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(181);
        if (localObject1 != null)
        {
          localDrawable = ((Drawable.ConstantState)localObject1).newDrawable();
          if (!(localDrawable instanceof URLDrawable)) {
            break label428;
          }
          if (((URLDrawable)localDrawable).getCurrDrawable() != null)
          {
            ((pmb)localObject2).cZ = ((Drawable.ConstantState)localObject1).newDrawable().mutate();
            this.axt = String.valueOf(System.identityHashCode(((pmb)localObject2).cZ));
            ram.b("Q.qqstory.playernew.AnimationParam", "getDrawableFromView, imageKey=%s, drawable=%s", this.axt, localDrawable);
          }
        }
      }
      for (;;)
      {
        if (this.axt == null)
        {
          paramView = rop.a(paramView, this.viewWidth, this.viewHeight, 0, 0);
          if (paramView != null)
          {
            ((pmb)localObject2).cZ = new BitmapDrawable(paramView);
            this.axt = String.valueOf(System.identityHashCode(((pmb)localObject2).cZ));
            ram.a("Q.qqstory.playernew.AnimationParam", "getBitmapFromView, imageKey=%s, bitmap=%s, byteCount=%d", this.axt, paramView, Integer.valueOf(paramView.getByteCount()));
          }
        }
        return;
        this.positionY = (((Rect)localObject2).bottom - this.viewHeight);
        break;
        label411:
        this.positionX = (((Rect)localObject2).right - this.viewWidth);
        break label231;
        label428:
        ((pmb)localObject2).cZ = ((Drawable.ConstantState)localObject1).newDrawable().mutate();
        this.axt = String.valueOf(System.identityHashCode(((pmb)localObject2).cZ));
        ram.b("Q.qqstory.playernew.AnimationParam", "getDrawableFromView, imageKey=%s, drawable=%s", this.axt, localDrawable);
      }
      localObject1 = null;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Drawable getAnimationDrawable()
  {
    if (!this.aDx) {
      return null;
    }
    if (this.drawable != null) {
      return this.drawable;
    }
    Object localObject = (pmb)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(181);
    this.drawable = ((pmb)localObject).cZ;
    if (TextUtils.equals(String.valueOf(System.identityHashCode(this.drawable)), this.axt)) {
      ((pmb)localObject).cZ = null;
    }
    while (this.drawable != null)
    {
      return this.drawable;
      this.drawable = null;
    }
    localObject = new ColorDrawable(-13421773);
    this.drawable = ((Drawable)localObject);
    return localObject;
  }
  
  public String toString()
  {
    return "AnimationParam{positionX=" + this.positionX + ", positionY=" + this.positionY + ", viewWidth=" + this.viewWidth + ", viewHeight=" + this.viewHeight + ", imageKey='" + this.axt + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.positionX);
    paramParcel.writeInt(this.positionY);
    paramParcel.writeInt(this.viewWidth);
    paramParcel.writeInt(this.viewHeight);
    paramParcel.writeString(this.axt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationParam
 * JD-Core Version:    0.7.0.1
 */