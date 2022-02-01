package com.tencent.mobileqq.vip.diy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.ViewGroup;
import aoop;
import aqvx.a;
import aqvx.b;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.widget.ProfileNameView;
import rpq;

public class ProfileTemplateNickNameContainer
  extends ViewGroup
{
  private aqvx.b jdField_a_of_type_Aqvx$b = new aqvx.b();
  private ProfileNameView jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView;
  private boolean cWE;
  private String cyd;
  private int edg;
  private int edh;
  private int edi;
  
  public ProfileTemplateNickNameContainer(Context paramContext, ProfileNameView paramProfileNameView)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView = paramProfileNameView;
    addView(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView);
  }
  
  protected URLDrawable a(@NonNull String paramString, DownloadParams.DecodeHandler paramDecodeHandler)
    throws IllegalArgumentException
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = aoop.TRANSPARENT;
    localURLDrawableOptions.mFailedDrawable = aoop.TRANSPARENT;
    localURLDrawableOptions.mPlayGifImage = false;
    if (paramDecodeHandler != null) {
      localURLDrawableOptions.mMemoryCacheKeySuffix = paramDecodeHandler.toString();
    }
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setDecodeHandler(paramDecodeHandler);
    return paramString;
  }
  
  public ETTextViewPlus a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.b();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int n = this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.MJ();
    int k = this.edg;
    int m = this.edg + n;
    int j;
    int i;
    if (m > paramInt3 - paramInt1)
    {
      j = Math.max(0, paramInt3 - n);
      i = paramInt3 - paramInt1;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.layout(j, 0, i, paramInt4 - paramInt2);
      if (TextUtils.isEmpty(this.cyd)) {
        break;
      }
      this.jdField_a_of_type_Aqvx$b.setSize(i - j, paramInt4 - paramInt2);
      URLDrawable localURLDrawable = a(this.cyd, this.jdField_a_of_type_Aqvx$b);
      aqvx.a.a(localURLDrawable, this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setBackgroundDrawable(localURLDrawable);
      return;
      i = m;
      j = k;
      if (this.cWE)
      {
        j = (paramInt3 - paramInt1) / 2 - (m - k) / 2;
        i = j + n;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setBackgroundDrawable(null);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.measure(paramInt2, paramInt2);
    setMeasuredDimension(getMeasuredWidth(), this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.getMeasuredHeight());
  }
  
  public void setTextBgUrl(String paramString)
  {
    this.cyd = paramString;
    if (!TextUtils.isEmpty(this.cyd))
    {
      int i = rpq.getScreenWidth(getContext());
      this.edh = ((int)(i * 0.005D));
      this.edi = ((int)(i * 0.03D));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.b().setPadding(this.edi, this.edh, this.edi, this.edh);
      return;
      this.edh = 0;
      this.edi = 0;
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setBackgroundDrawable(null);
    }
  }
  
  public void setTextCenter()
  {
    this.cWE = true;
  }
  
  public void setTextViewX(int paramInt)
  {
    this.edg = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.ProfileTemplateNickNameContainer
 * JD-Core Version:    0.7.0.1
 */