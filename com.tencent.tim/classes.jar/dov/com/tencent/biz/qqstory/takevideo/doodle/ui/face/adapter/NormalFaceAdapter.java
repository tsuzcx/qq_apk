package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import aqqx;
import axqg;
import axwb;
import axwb.a;
import aykk;
import aykm;
import ayne;
import aynh;
import aynh.a;
import aynn;
import ayom;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage;
import java.io.File;
import ram;
import rar;

public class NormalFaceAdapter
  extends aynh<ayne>
  implements View.OnClickListener
{
  private aynh.a<String, Drawable> b = new aynh.a();
  
  public NormalFaceAdapter(Context paramContext, FaceListPage paramFaceListPage)
  {
    super(paramContext, paramFaceListPage);
  }
  
  private void a(ayne paramayne, Drawable paramDrawable, ImageView paramImageView, String paramString1, String paramString2, int paramInt)
  {
    int i;
    int k;
    int j;
    if (paramDrawable.getIntrinsicWidth() > paramDrawable.getIntrinsicHeight())
    {
      i = paramDrawable.getIntrinsicWidth();
      k = paramImageView.getWidth();
      if (paramImageView.getPaddingLeft() <= paramImageView.getPaddingTop()) {
        break label136;
      }
      j = paramImageView.getPaddingLeft();
      label40:
      if (k <= i) {
        break label145;
      }
    }
    label136:
    label145:
    for (float f = (((k - i) / 2 - j) * 2 + i) / i;; f = (i - (j + (i - k) / 2) * 2) / i)
    {
      f = (float)(f * paramayne.scale);
      paramayne = new aykk(paramayne.name, paramString2, paramDrawable, paramInt);
      paramDrawable = axwb.a();
      this.f.a(paramayne, paramDrawable.x, paramDrawable.y, f, paramString1, null);
      return;
      i = paramDrawable.getIntrinsicHeight();
      break;
      j = paramImageView.getPaddingTop();
      break label40;
    }
  }
  
  private void jB(View paramView)
  {
    ImageView localImageView = (ImageView)paramView;
    int k = ((Integer)localImageView.getTag(2131379225)).intValue();
    ayne localayne = (ayne)this.c;
    rar.b((Activity)paramView.getContext(), "sticker_element", ((ayne)this.c).id, String.valueOf(k));
    int j = localayne.ma(k);
    paramView = Uri.parse(localayne.cc(k)).getPath();
    String str = new File(paramView).getName();
    Object localObject1 = paramView;
    int i = j;
    if (j == 1)
    {
      localObject1 = paramView;
      i = j;
      if ((this.context instanceof EditPicActivity))
      {
        localObject2 = localayne.hc(k);
        localObject1 = paramView;
        i = j;
        if (localObject2 != null)
        {
          localObject1 = Uri.parse((String)localObject2).getPath();
          i = 0;
        }
      }
    }
    paramView = (Drawable)this.b.get(localObject1);
    if (paramView == null) {
      if (i != 1)
      {
        try
        {
          localObject2 = Drawable.createFromPath((String)localObject1);
          paramView = (View)localObject2;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            ram.e("NormalFaceAdapter", "createFromPath error", localOutOfMemoryError);
          }
        }
        localObject2 = paramView;
        if (paramView != null) {
          this.b.h(localObject1, paramView);
        }
      }
    }
    Object localObject3;
    for (Object localObject2 = paramView;; localObject3 = paramView)
    {
      if (localObject2 == null) {
        break label405;
      }
      ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
      a(localayne, (Drawable)localObject2, localImageView, (String)localObject1, str, i);
      return;
      localObject3 = aqqx.a(BaseApplicationImpl.sApplication.getRuntime(), (String)localObject1, "-Dynamic-", null, new int[] { 13 }, "-Dynamic-", null);
      if (localObject3 != null)
      {
        j = ((URLDrawable)localObject3).getStatus();
        if (j != 1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("NormalFaceAdapter", 2, "urlDrawable is not  SUCCESSED :" + j);
          }
          if (j == 2)
          {
            ((URLDrawable)localObject3).restartDownload();
            label336:
            ((URLDrawable)localObject3).setURLDrawableListener(new aynn(this, (String)localObject1, localayne, localImageView, str));
          }
        }
        for (;;)
        {
          break;
          ((URLDrawable)localObject3).startDownload();
          break label336;
          paramView = (View)localObject3;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("NormalFaceAdapter", 2, "urlDrawable apng error");
      }
      break;
      this.b.eSR();
    }
    label405:
    ram.e("NormalFaceAdapter", "can create drawable from path:" + (String)localObject1);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.c == null)
    {
      localObject = paramView;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
    if (paramView == null) {}
    for (Object localObject = new NormalItemLayout(this.context, paramViewGroup.getWidth(), ((ayne)this.c).tu(), ((ayne)this.c).az(), this, this);; localObject = (NormalItemLayout)paramView)
    {
      ((NormalItemLayout)localObject).a((ayne)this.c, paramInt, getCount(), aQR());
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    ThreadManager.postImmediately(new NormalFaceAdapter.1(this, paramView), null, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  static class NormalItemLayout
    extends LinearLayout
  {
    private aynh b;
    private int bsd;
    private int mCount;
    private View.OnClickListener mListener;
    private int mPadding;
    private int mParentWidth;
    
    public NormalItemLayout(Context paramContext, int paramInt1, int paramInt2, float paramFloat, View.OnClickListener paramOnClickListener, aynh paramaynh)
    {
      super();
      this.mListener = paramOnClickListener;
      this.mParentWidth = paramInt1;
      this.mCount = paramInt2;
      this.b = paramaynh;
      paramInt1 /= this.mCount;
      this.mPadding = ((int)(paramInt1 * paramFloat));
      this.bsd = (paramInt1 - this.mPadding * 2);
      buQ();
    }
    
    private void buQ()
    {
      int i = 0;
      setOrientation(0);
      setGravity(17);
      int j = this.mParentWidth / this.mCount;
      while (i < this.mCount)
      {
        URLImageView localURLImageView = new URLImageView(getContext());
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(j, j);
        if (i == 0) {
          localLayoutParams.leftMargin = ayom.dip2px(getContext(), 7.0F);
        }
        if (i == this.mCount - 1) {
          localLayoutParams.rightMargin = ayom.dip2px(getContext(), 7.0F);
        }
        localURLImageView.setLayoutParams(localLayoutParams);
        localURLImageView.setPadding(this.mPadding, this.mPadding, this.mPadding, this.mPadding);
        localURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        addView(localURLImageView);
        i += 1;
      }
    }
    
    private void xB(int paramInt)
    {
      int i = 0;
      int j;
      for (;;)
      {
        j = paramInt;
        if (i >= paramInt) {
          break;
        }
        j = paramInt;
        if (i >= getChildCount()) {
          break;
        }
        getChildAt(i).setVisibility(0);
        i += 1;
      }
      while ((j < this.mCount) && (j < getChildCount()))
      {
        getChildAt(j).setVisibility(4);
        j += 1;
      }
    }
    
    public void a(ayne paramayne, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      int i = paramInt1 * this.mCount;
      label31:
      ImageView localImageView;
      Object localObject;
      if (paramInt1 == paramInt2 - 1)
      {
        paramInt1 = paramayne.getFaceCount();
        xB(paramInt1 - i);
        paramInt2 = i;
        if (paramInt2 >= paramInt1) {
          return;
        }
        localImageView = (ImageView)getChildAt(paramInt2 - i);
        localImageView.setOnClickListener(this.mListener);
        localObject = paramayne.cc(paramInt2);
        localImageView.setTag(2131379238, localObject);
        localImageView.setTag(2131379225, Integer.valueOf(paramInt2));
        if (paramayne.ma(paramInt2) != 1) {
          break label252;
        }
        if (!(getContext() instanceof EditPicActivity)) {
          break label158;
        }
        localObject = paramayne.hc(paramInt2);
        localImageView.setTag(2131379238, localObject);
        aykm.a().a(localImageView, (String)localObject, this.bsd, this.bsd, paramBoolean);
      }
      for (;;)
      {
        paramInt2 += 1;
        break label31;
        paramInt1 = this.mCount + i;
        break;
        label158:
        localObject = Uri.parse((String)localObject).getPath();
        localObject = aqqx.a(BaseApplicationImpl.sApplication.getRuntime(), (String)localObject, "-Dynamic-", null, new int[] { 13 }, "-Dynamic-", null);
        if (localObject != null)
        {
          if (((URLDrawable)localObject).getStatus() == 2) {
            ((URLDrawable)localObject).restartDownload();
          }
          if (paramBoolean) {}
          for (;;)
          {
            localImageView.setImageDrawable((Drawable)localObject);
            break;
            localObject = null;
          }
        }
        if (QLog.isColorLevel())
        {
          QLog.d("NormalFaceAdapter", 2, "urlDrawable apng error");
          continue;
          label252:
          aykm.a().a(localImageView, (String)localObject, this.bsd, this.bsd, paramBoolean);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.NormalFaceAdapter
 * JD-Core Version:    0.7.0.1
 */