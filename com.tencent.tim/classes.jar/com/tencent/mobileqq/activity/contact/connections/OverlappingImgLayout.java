package com.tencent.mobileqq.activity.contact.connections;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import aqdf;
import aqdf.a;
import aqho;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.List;
import yrq;

public class OverlappingImgLayout
  extends LinearLayout
{
  aqdf.a jdField_a_of_type_Aqdf$a = new yrq(this);
  private aqdf jdField_a_of_type_Aqdf;
  private int bNa;
  private String[] bh;
  private int caL;
  private int caM;
  private List<ThemeImageView> tb = new ArrayList();
  
  public OverlappingImgLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public OverlappingImgLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public OverlappingImgLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private Bitmap getFaceBitmap(String paramString)
  {
    Object localObject;
    if (this.jdField_a_of_type_Aqdf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("OverlappingImgLayout", 2, "mFaceDecoder null");
      }
      localObject = null;
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      localBitmap = this.jdField_a_of_type_Aqdf.a(1, paramString, 0, (byte)4);
      localObject = localBitmap;
    } while (localBitmap != null);
    if (!this.jdField_a_of_type_Aqdf.isPausing()) {
      this.jdField_a_of_type_Aqdf.a(paramString, 200, false, 1, true, (byte)0, 4);
    }
    return null;
  }
  
  public static boolean isNightMode()
  {
    return ("1103".equals(ThemeUtil.curThemeId)) || ("2920".equals(ThemeUtil.curThemeId));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String[] paramArrayOfString, aqdf paramaqdf)
  {
    this.bNa = ((int)aqho.convertDpToPixel(getContext(), paramInt1));
    this.caL = ((int)aqho.convertDpToPixel(getContext(), paramInt2));
    this.caM = paramInt3;
    setOrientation(0);
    this.bh = paramArrayOfString;
    this.jdField_a_of_type_Aqdf = paramaqdf;
    if (paramaqdf != null) {
      paramaqdf.a(this.jdField_a_of_type_Aqdf$a);
    }
    setImgs();
    cla();
  }
  
  public void a(int paramInt1, int paramInt2, String[] paramArrayOfString, aqdf paramaqdf)
  {
    a(paramInt1, paramInt2, (int)aqho.convertDpToPixel(getContext(), 4.0F), paramArrayOfString, paramaqdf);
  }
  
  public void cla()
  {
    removeAllViews();
    if (this.tb.size() == 0) {
      return;
    }
    int i = 0;
    int j = 0;
    label21:
    ThemeImageView localThemeImageView;
    if (i < this.tb.size())
    {
      localThemeImageView = (ThemeImageView)this.tb.get(i);
      int k = (int)aqho.convertDpToPixel(getContext(), 1.0F);
      localThemeImageView.setPadding(k, k, k, k);
      if (isNightMode()) {
        break label134;
      }
      localThemeImageView.setBackgroundResource(2130837703);
    }
    for (;;)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.caL, this.bNa);
      localLayoutParams.setMargins(j * -1, 0, 0, 0);
      localThemeImageView.setLayoutParams(localLayoutParams);
      addView(localThemeImageView);
      j = this.caM;
      i += 1;
      break label21;
      break;
      label134:
      localThemeImageView.setBackgroundResource(2130837704);
    }
  }
  
  public void setImgs()
  {
    this.tb.clear();
    if ((this.bh == null) || (this.bh.length == 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.bh.length)
      {
        if (i < 3)
        {
          ThemeImageView localThemeImageView = new ThemeImageView(getContext());
          localThemeImageView.setImageBitmap(getFaceBitmap(this.bh[i]));
          this.tb.add(localThemeImageView);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.OverlappingImgLayout
 * JD-Core Version:    0.7.0.1
 */