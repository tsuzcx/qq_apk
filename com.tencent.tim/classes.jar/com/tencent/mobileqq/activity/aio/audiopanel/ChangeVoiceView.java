package com.tencent.mobileqq.activity.aio.audiopanel;

import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqcx;
import aqxo;
import aqxo.a;
import aqxp;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ChangeVoiceView
  extends RelativeLayout
{
  public static String aTP = acfp.m(2131703562);
  private TextView Gy;
  private long Im;
  public aqxo a;
  private CircleProgressView a;
  public int aeE;
  private int bQc;
  private boolean beW;
  private VolumeIndicateSquareView c;
  ImageView mFlagFeetype;
  public int mState = 0;
  private TextView mText;
  public int mType;
  private ImageView ss;
  ImageView st;
  
  public ChangeVoiceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void Cu(int paramInt)
  {
    if (this.jdField_a_of_type_Aqxo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
    if (paramInt == 2)
    {
      setContentDescription(aTP);
      label28:
      if (this.mState == paramInt) {
        break label180;
      }
      this.mState = paramInt;
      if (paramInt != 0) {
        break label204;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setVisibility(8);
      this.Gy.setVisibility(8);
      this.c.setVisibility(8);
      this.mText.setBackgroundResource(2130838474);
      if (this.jdField_a_of_type_Aqxo.status != 1) {
        break label182;
      }
      this.mText.setTextColor(2137417318);
    }
    for (;;)
    {
      this.mText.setPadding(this.bQc, 0, this.bQc, 0);
      return;
      if (paramInt == 1)
      {
        setContentDescription(getContext().getString(2131692132) + " " + this.jdField_a_of_type_Aqxo.contentDescription);
        break label28;
      }
      setContentDescription(this.jdField_a_of_type_Aqxo.contentDescription);
      break label28;
      label180:
      break;
      label182:
      this.mText.setTextColor(getContext().getResources().getColor(2131165308));
      continue;
      label204:
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setVisibility(8);
        this.Gy.setVisibility(8);
        this.c.setVisibility(8);
        if (this.beW)
        {
          this.mText.setBackgroundResource(2130848657);
          this.mText.setTextColor(-16777216);
        }
        else
        {
          this.mText.setBackgroundResource(2130838475);
          this.mText.setTextColor(-1);
        }
      }
      else if (paramInt == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setVisibility(0);
        this.Gy.setVisibility(0);
        this.c.reset();
        this.c.setVisibility(0);
        if (this.beW)
        {
          this.mText.setBackgroundResource(2130848657);
          this.mText.setTextColor(-16777216);
        }
        else
        {
          this.mText.setBackgroundResource(2130838475);
          this.mText.setTextColor(-1);
        }
      }
    }
  }
  
  public void a(aqxo paramaqxo)
  {
    int i = 1;
    if (paramaqxo != null) {}
    for (boolean bool = true;; bool = false)
    {
      super.setEnabled(bool);
      this.mFlagFeetype = ((ImageView)super.findViewById(2131367210));
      this.st = ((ImageView)super.findViewById(2131367211));
      this.ss = ((ImageView)super.findViewById(2131364434));
      this.mText = ((TextView)super.findViewById(2131364436));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView = ((CircleProgressView)super.findViewById(2131364435));
      this.Gy = ((TextView)super.findViewById(2131364439));
      this.c = ((VolumeIndicateSquareView)super.findViewById(2131364440));
      if (paramaqxo != null) {
        break;
      }
      this.ss.setBackgroundDrawable(null);
      this.ss.setVisibility(4);
      this.mText.setText(null);
      super.setContentDescription(null);
      this.st.setVisibility(8);
      this.mFlagFeetype.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setVisibility(8);
      this.Gy.setVisibility(8);
      this.c.setVisibility(8);
      this.mText.setBackgroundResource(2130838474);
      return;
    }
    this.bQc = aqcx.dip2px(getContext(), 4.0F);
    this.mType = paramaqxo.type;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setStrokeWidth(4);
    this.jdField_a_of_type_Aqxo = paramaqxo;
    this.ss.setVisibility(0);
    label295:
    Object localObject1;
    label326:
    Object localObject3;
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if (paramaqxo.a.imgId > 0)
    {
      this.ss.setBackgroundResource(paramaqxo.a.imgId);
      if (paramaqxo.edy == 0) {
        break label805;
      }
      this.st.setVisibility(0);
      if (paramaqxo.edy != 1) {
        break label792;
      }
      this.st.setImageResource(2130848235);
      if (paramaqxo.feeType == 1) {
        break label857;
      }
      this.mFlagFeetype.setVisibility(0);
      if (paramaqxo.feeType != 4) {
        break label817;
      }
      localObject1 = aqxp.ig[0];
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label874;
      }
      localObject3 = new File(aqxp.CD() + ((String)localObject1).substring(((String)localObject1).lastIndexOf("/") + 1));
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      if ((!((File)localObject3).exists()) || (!((File)localObject3).isFile())) {
        break label845;
      }
      localObject1 = URLDrawable.getDrawable((File)localObject3, localURLDrawableOptions);
    }
    for (;;)
    {
      label406:
      this.mFlagFeetype.setImageDrawable((Drawable)localObject1);
      label415:
      localObject3 = paramaqxo.name;
      localObject1 = localObject3;
      if (localObject3 != null)
      {
        localObject1 = localObject3;
        if (((String)localObject3).length() > 4) {
          localObject1 = ((String)localObject3).substring(0, 3) + "...";
        }
      }
      this.mText.setText((CharSequence)localObject1);
      super.setContentDescription(paramaqxo.contentDescription);
      if (paramaqxo.type == this.aeE) {}
      for (;;)
      {
        for (;;)
        {
          this.mState = (i + 1);
          Cu(i);
          return;
          localObject3 = super.getResources();
          try
          {
            localObject1 = paramaqxo.a.cyz;
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
              localURLDrawableOptions.mFailedDrawable = ((Resources)localObject3).getDrawable(2130848343);
              localURLDrawableOptions.mLoadingDrawable = ((Resources)localObject3).getDrawable(2130848343);
              File localFile = new File(aqxp.CD() + ((String)localObject1).substring(((String)localObject1).lastIndexOf("/") + 1));
              if ((localFile.exists()) && (localFile.isFile())) {
                localObject1 = URLDrawable.getDrawable(localFile, localURLDrawableOptions);
              }
            }
            for (;;)
            {
              if ((localObject1 instanceof URLDrawable))
              {
                localObject3 = (URLDrawable)localObject1;
                if (((URLDrawable)localObject3).getStatus() == 2) {
                  ((URLDrawable)localObject3).restartDownload();
                }
              }
              if (paramaqxo.status != 1) {
                break label781;
              }
              ((Drawable)localObject1).setAlpha(127);
              paramaqxo.a.drawable = ((Drawable)localObject1);
              this.ss.setBackgroundDrawable((Drawable)localObject1);
              break;
              localObject1 = URLDrawable.getDrawable((String)localObject1, localURLDrawableOptions);
              continue;
              QLog.d("ChangeVoiceView", 2, "init drawable url = null, name=" + paramaqxo.name + ",type=" + paramaqxo.type);
              localObject1 = ((Resources)localObject3).getDrawable(2130848343);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localObject2 = ((Resources)localObject3).getDrawable(2130848343);
              continue;
              label781:
              ((Drawable)localObject2).setAlpha(255);
            }
          }
        }
        label792:
        this.st.setImageResource(2130848234);
        break label295;
        label805:
        this.st.setVisibility(8);
        break label295;
        label817:
        if (paramaqxo.feeType == 5)
        {
          localObject2 = aqxp.ig[1];
          break label326;
        }
        localObject2 = aqxp.ig[2];
        break label326;
        label845:
        localObject2 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
        break label406;
        label857:
        this.mFlagFeetype.setVisibility(8);
        break label415;
        i = 0;
      }
      label874:
      Object localObject2 = null;
    }
  }
  
  public void as(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(paramInt1);
    if (this.Im == 0L) {
      this.Im = SystemClock.uptimeMillis();
    }
    while (SystemClock.uptimeMillis() - this.Im >= 75L)
    {
      this.Im = SystemClock.uptimeMillis();
      StringBuilder localStringBuilder = new StringBuilder();
      paramInt2 /= 1000;
      paramInt1 = paramInt2 / 60;
      paramInt2 %= 60;
      localStringBuilder.append(paramInt1).append(":");
      if (paramInt2 < 10) {
        localStringBuilder.append("0");
      }
      localStringBuilder.append(paramInt2);
      if (!localStringBuilder.equals(this.Gy.getText())) {
        this.Gy.setText(localStringBuilder);
      }
      this.c.CB(paramInt3);
      return;
    }
  }
  
  public void cao()
  {
    this.beW = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setRingWidth(10);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setRingColor(getResources().getColor(2131167292));
    }
  }
  
  public int getState()
  {
    return this.mState;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ChangeVoiceView
 * JD-Core Version:    0.7.0.1
 */