package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.drawable.RoundedDrawable;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp;

public class NativeButtonImp
  extends NativeTextImp
  implements IView
{
  private static final String TAG = "NativeButtonImp";
  
  public NativeButtonImp(Context paramContext)
  {
    super(paramContext);
    setGravity(17);
  }
  
  private void updateAttrs(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    for (;;)
    {
      return;
      if ((paramDrawable instanceof RoundedDrawable))
      {
        ((RoundedDrawable)paramDrawable).setScaleType(ImageView.ScaleType.FIT_XY).setBorderWidth(this.mBorderWidth).setBorderColor(this.mBorderColor);
        ((RoundedDrawable)paramDrawable).setCornerRadius(100.0F, 0.0F, 0.0F, 0.0F);
        return;
      }
      if ((paramDrawable instanceof LayerDrawable))
      {
        paramDrawable = (LayerDrawable)paramDrawable;
        int i = 0;
        int j = paramDrawable.getNumberOfLayers();
        while (i < j)
        {
          updateAttrs(paramDrawable.getDrawable(i));
          i += 1;
        }
      }
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    updateAttrs(paramDrawable);
    super.setBackgroundDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButtonImp
 * JD-Core Version:    0.7.0.1
 */