package com.tencent.mobileqq.activity.aio.item;

import adqu;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ark.ArkTextureView;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModel;
import com.tencent.ark.ArkViewModelBase.Size;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import wja;
import wyw;
import wyw.c;
import wzu;
import xad;

public class ArkAppView
  extends ArkTextureView
  implements wyw.c
{
  private a jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView$a;
  private b jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView$b;
  xad jdField_a_of_type_Xad = null;
  public ArkAppLoadLayout b;
  
  public ArkAppView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ArkAppCenter.setupArkEnvironment(true);
    adqu.cTQ();
    this.jdField_a_of_type_Xad = new xad(this);
    setInputCallback(this.jdField_a_of_type_Xad);
  }
  
  private void U(View paramView, int paramInt)
  {
    paramView = (RelativeLayout)paramView.getParent();
    if (paramView != null)
    {
      paramView = paramView.findViewById(2131362955);
      if (paramView != null) {
        paramView.setVisibility(paramInt);
      }
    }
  }
  
  private void cdC()
  {
    Object localObject = this.mViewImpl.getViewModel();
    int j;
    int i;
    int k;
    if (localObject != null) {
      if ((localObject instanceof wyw))
      {
        ArkViewModelBase.Size localSize = ((wyw)localObject).a();
        if ((localSize != null) && (localSize.height > 0))
        {
          j = localSize.height;
          if ((localSize == null) || (localSize.width <= 0)) {
            break label287;
          }
          i = localSize.width;
          k = j;
          label72:
          j = k;
          if (k <= 0) {
            j = (int)(((ArkViewModel)localObject).getHeight() * this.mViewImpl.mScale);
          }
          if (i > 0) {
            break label327;
          }
          i = (int)(((ArkViewModel)localObject).getWidth() * this.mViewImpl.mScale);
        }
      }
    }
    for (;;)
    {
      k = j;
      if (j <= 0) {
        k = wja.dp2px(352.0F, this.b.getResources());
      }
      j = i;
      if (i <= 0) {
        j = BaseChatItemLayout.bNT;
      }
      i = j;
      int m;
      if (this.mViewImpl.mBorderType == 2)
      {
        i = j;
        if (j > BaseChatItemLayout.bNX)
        {
          m = BaseChatItemLayout.bNX / 2;
          i = j - m;
          if (!this.mViewImpl.mAlignLeft) {
            break label294;
          }
          this.b.setPadding(m, this.b.getPaddingTop(), this.b.getPaddingRight(), this.b.getPaddingBottom());
        }
      }
      for (;;)
      {
        localObject = this.b.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = k;
        ((ViewGroup.LayoutParams)localObject).width = i;
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, String.format(Locale.CHINA, "resizeLoadingView.view.%h.w.%d.h.%d", new Object[] { this, Integer.valueOf(i), Integer.valueOf(k) }));
        }
        return;
        j = 0;
        break;
        label287:
        i = 0;
        k = j;
        break label72;
        label294:
        this.b.setPadding(this.b.getPaddingLeft(), this.b.getPaddingTop(), m, this.b.getPaddingBottom());
      }
      label327:
      continue;
      i = 0;
      k = 0;
      break label72;
      i = 0;
      j = 0;
    }
  }
  
  public void a(wyw paramwyw, ArkAppLoadLayout paramArkAppLoadLayout)
  {
    if (paramwyw == null) {
      return;
    }
    this.b = paramArkAppLoadLayout;
    if (this.b != null) {
      this.b.setArkView(this.mViewImpl);
    }
    super.initArkView(paramwyw);
  }
  
  public Rect getInputRect()
  {
    Rect localRect = super.getInputRect();
    if (this.jdField_a_of_type_Xad != null) {
      localRect.bottom = (this.jdField_a_of_type_Xad.wo() + localRect.bottom);
    }
    return localRect;
  }
  
  public void onFirstPaint()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView$a.bCR();
    }
  }
  
  public void onLoadFailed(String paramString, int paramInt, boolean paramBoolean)
  {
    if (this.b == null) {}
    Object localObject1;
    label179:
    do
    {
      Object localObject2;
      do
      {
        return;
        localObject2 = this.mViewImpl.getViewModel();
        if ((localObject2 != null) && (((ArkViewModel)localObject2).GetAppScriptType() == 2) && (!ArkAppCenter.afv()))
        {
          QLog.i(TAG, 2, "onLoadFailed.ARKAPP_TYPE_RELOAD");
          onLoading();
          return;
        }
        localObject1 = this.b;
        if (!paramBoolean) {
          break;
        }
        ((View)localObject1).setOnClickListener(new wzu(this, (ArkViewModel)localObject2));
        cdC();
        setVisibility(8);
        ((View)localObject1).setVisibility(0);
        View localView = ((View)localObject1).findViewById(2131370787);
        localObject2 = ((View)localObject1).findViewById(2131377028);
        U((View)localObject1, 0);
        requestLayout();
        if (localView != null) {
          localView.setVisibility(4);
        }
      } while (localObject2 == null);
      ((View)localObject2).setVisibility(0);
      localObject1 = (TextView)((View)localObject2).findViewById(2131377042);
      if (localObject1 != null)
      {
        if (paramString != null) {
          break label222;
        }
        ((TextView)localObject1).setText(getResources().getString(2131690522));
      }
      paramString = ((View)localObject2).findViewById(2131377034);
    } while (paramString == null);
    if (paramBoolean) {}
    for (paramInt = 2130838756;; paramInt = 2130838755)
    {
      paramString.setBackgroundDrawable(paramString.getResources().getDrawable(paramInt));
      return;
      ((View)localObject1).setOnClickListener(null);
      break;
      label222:
      ((TextView)localObject1).setText(paramString);
      break label179;
    }
  }
  
  public void onLoadSuccess()
  {
    super.onLoadSuccess();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView$a != null) && (this.mViewImpl.mRectView.isEmpty())) {}
    do
    {
      return;
      if (this.b != null)
      {
        ArkAppLoadLayout localArkAppLoadLayout = this.b;
        localArkAppLoadLayout.setVisibility(8);
        U(localArkAppLoadLayout, 8);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView$a == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView$a.loadSucc();
  }
  
  public void onLoading()
  {
    setVisibility(8);
    if (this.b == null) {}
    View localView2;
    do
    {
      return;
      ArkAppLoadLayout localArkAppLoadLayout = this.b;
      cdC();
      localArkAppLoadLayout.setVisibility(0);
      View localView1 = localArkAppLoadLayout.findViewById(2131370787);
      localView2 = localArkAppLoadLayout.findViewById(2131377028);
      U(localArkAppLoadLayout, 0);
      requestLayout();
      if (localView1 != null) {
        localView1.setVisibility(0);
      }
    } while (localView2 == null);
    localView2.setVisibility(4);
  }
  
  public void setCallback(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView$a = parama;
  }
  
  public void setInputHolderAnchor(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Xad != null) {
      this.jdField_a_of_type_Xad.setInputHolderAnchor(paramViewGroup);
    }
  }
  
  public void setOnVisibleChangeListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView$b = paramb;
  }
  
  public void setVisibility(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView$b != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView$b.gv(paramInt)) {
        break label34;
      }
      this.b.setVisibility(4);
    }
    for (;;)
    {
      super.setVisibility(paramInt);
      return;
      label34:
      this.b.setVisibility(0);
    }
  }
  
  public static abstract interface a
  {
    public abstract void bCR();
    
    public abstract void loadSucc();
  }
  
  public static abstract interface b
  {
    public abstract boolean gv(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppView
 * JD-Core Version:    0.7.0.1
 */