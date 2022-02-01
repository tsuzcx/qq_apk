package com.tencent.mobileqq.vas.avatar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import aqsg;
import arge;
import arge.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.URLThemeImageView;

public class VasAvatar
  extends URLThemeImageView
  implements arge.a
{
  public aqsg a;
  private arge a;
  public Drawable dQ;
  private AvatarLayout i;
  private String uin;
  
  public VasAvatar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VasAvatar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public VasAvatar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setSupportMaskView(false);
  }
  
  public static boolean bv(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) || (paramInt1 == 103)) {}
    while ((paramInt1 == 32) && (paramInt2 == 200)) {
      return true;
    }
    return false;
  }
  
  public static String gl(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "small";
    case 640: 
      return "large";
    }
    return "medium";
  }
  
  public void aX(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public void aY(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Arge != null)
    {
      this.jdField_a_of_type_Arge.draw(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public void efn()
  {
    if (this.i != null) {
      this.i.setGoneBelow(1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.VasFaceManager", 2, "show vas avatar of " + this.uin);
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Arge != null)
    {
      this.jdField_a_of_type_Arge.onDraw(paramCanvas);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    super.onLoadSuccessed(paramURLDrawable);
    efn();
    paramURLDrawable = paramURLDrawable.getCurrDrawable();
    if ((ApngDrawable.class.isInstance(paramURLDrawable)) && ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))) {
      VasFaceManager.a(this.uin, (ApngDrawable)paramURLDrawable);
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    this.jdField_a_of_type_Aqsg = null;
  }
  
  public void setLoader(AvatarLayout paramAvatarLayout, aqsg paramaqsg)
  {
    this.dQ = paramaqsg.dQ;
    paramaqsg.dQ = null;
    setImageDrawable(this.dQ);
    this.i = paramAvatarLayout;
    this.jdField_a_of_type_Aqsg = paramaqsg;
    this.uin = paramaqsg.uin;
    paramaqsg.a(this);
  }
  
  public void setMosaicEffect(arge paramarge)
  {
    if (this.jdField_a_of_type_Arge != null) {
      this.jdField_a_of_type_Arge.setView(null);
    }
    this.jdField_a_of_type_Arge = paramarge;
    if (this.jdField_a_of_type_Arge != null) {
      this.jdField_a_of_type_Arge.setView(this);
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.avatar.VasAvatar
 * JD-Core Version:    0.7.0.1
 */