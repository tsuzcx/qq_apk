package com.tencent.mobileqq.troop.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import aoop;
import apqw;
import aqbn;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.util.WeakReference;
import zri;
import zti;

public class AvatarWallViewPagerAdapter
  extends PagerAdapter
{
  protected View IQ;
  protected View IR;
  protected boolean Yp;
  protected AvatarWallViewPager c;
  protected boolean cSr;
  protected String crC;
  protected Handler dE;
  protected int dWI;
  protected int dsn;
  protected WeakReference<Activity> mActivity;
  protected QQAppInterface mApp;
  protected Handler mMainHandler = new Handler(Looper.getMainLooper());
  protected int mMaskColor = 637534208;
  protected String mTroopUin;
  protected List<zri> sH = new ArrayList(0);
  
  public AvatarWallViewPagerAdapter(WeakReference<Activity> paramWeakReference, AvatarWallViewPager paramAvatarWallViewPager, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface, String paramString1, boolean paramBoolean, Handler paramHandler, String paramString2)
  {
    this.dWI = paramInt1;
    this.dsn = paramInt2;
    this.mActivity = paramWeakReference;
    this.dE = paramHandler;
    this.c = paramAvatarWallViewPager;
    this.mApp = paramQQAppInterface;
    this.mTroopUin = paramString1;
    this.crC = paramString2;
    this.cSr = paramBoolean;
    if (ThemeUtil.isInNightMode(paramQQAppInterface)) {
      this.mMaskColor = -1308622848;
    }
    if (((paramWeakReference == null) || (paramWeakReference.get() == null) || (paramQQAppInterface == null)) && (QLog.isColorLevel())) {
      QLog.e("AvatarWallViewPagerAdapter", 2, "AvatarWallAdapter Construct error, Activity or QQAppInterface is null !!!!");
    }
  }
  
  private URLDrawable a(String paramString, zri paramzri)
  {
    paramString = zti.f(paramString);
    if (paramString == null) {
      return null;
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aoop.TRANSPARENT;
    paramString = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
    localObject = new Rect();
    zti.a((Rect)localObject, paramzri.clipInfo);
    paramString.setTag(aqbn.a(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).width(), ((Rect)localObject).height(), this.dWI, this.dsn));
    paramString.setDecodeHandler(aqbn.x);
    return paramString;
  }
  
  public boolean ax(List<zri> paramList)
  {
    if (this.Yp) {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarWallViewPagerAdapter", 2, "the adapter of AvatarWallViewPager is destroyed ...");
      }
    }
    do
    {
      return false;
      if (!zri.i(paramList, this.sH)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("AvatarWallViewPagerAdapter", 2, String.format("setAvatarList equal return", new Object[0]));
    return false;
    if (QLog.isColorLevel()) {
      QLog.i("AvatarWallViewPagerAdapter", 2, String.format("setAvatarList %s", new Object[] { Arrays.deepToString(paramList.toArray()) }));
    }
    this.sH.clear();
    this.sH.addAll(paramList);
    this.IR = null;
    this.IQ = null;
    notifyDataSetChanged();
    this.c.baF();
    return true;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public List<zri> gF()
  {
    return this.sH;
  }
  
  public int getCount()
  {
    int i = ju();
    if (i <= 1) {
      return i;
    }
    return i + 2;
  }
  
  public int getItemPosition(Object paramObject)
  {
    paramObject = (View)paramObject;
    int i = paramObject.getId();
    if ((i < 0) || (i >= this.sH.size())) {
      return -2;
    }
    if (paramObject.getTag() == null) {
      return -2;
    }
    paramObject = (zri)paramObject.getTag();
    zri localzri = (zri)this.sH.get(i);
    if ((!paramObject.baF.equals(localzri.baF)) || (paramObject.fromType != localzri.fromType) || (paramObject.aYK != localzri.aYK)) {
      return -2;
    }
    return -1;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = null;
    int i = ju();
    if ((this.mActivity == null) || (this.mActivity.get() == null) || (i == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarWallViewPagerAdapter", 2, "instantiateItem activity is null or data list count is 0");
      }
      return null;
    }
    if (i > 1) {
      if (paramInt == 1)
      {
        if (paramViewGroup == null)
        {
          if ((this.IQ != null) && (this.IQ.getParent() == null)) {
            return this.IQ;
          }
        }
        else
        {
          if ((this.IQ == null) || (this.IQ.getParent() != null)) {
            this.IQ = ((View)instantiateItem(null, paramInt));
          }
          paramViewGroup.addView(this.IQ);
          return this.IQ;
        }
      }
      else if (paramInt == i) {
        if (paramViewGroup == null)
        {
          if ((this.IR != null) && (this.IR.getParent() == null)) {
            return this.IR;
          }
        }
        else
        {
          if ((this.IR == null) || (this.IR.getParent() != null)) {
            this.IR = ((View)instantiateItem(null, paramInt));
          }
          paramViewGroup.addView(this.IR);
          return this.IR;
        }
      }
    }
    if (i > 1) {
      if (paramInt == 0) {
        i -= 1;
      }
    }
    for (;;)
    {
      View localView = LayoutInflater.from((Context)this.mActivity.get()).inflate(2131560066, null);
      a locala = new a();
      locala.aw = ((URLImageView)localView.findViewById(2131368846));
      locala.aw.setScaleType(ImageView.ScaleType.FIT_XY);
      if (ju() <= i) {
        i = 0;
      }
      for (;;)
      {
        zri localzri = (zri)this.sH.get(i);
        int j;
        if (localzri != null)
        {
          j = localzri.fromType;
          if ((j == 1) && ((localzri.baE == null) || (!new File(localzri.baE).exists())))
          {
            localObject = apqw.oL(apqw.p(localzri.baF, this.mTroopUin, 1));
            label358:
            if (this.mActivity != null) {
              localView.setContentDescription(((Activity)this.mActivity.get()).getString(2131698296));
            }
            if (localObject != null)
            {
              URLDrawable localURLDrawable = a((String)localObject, localzri);
              if (localURLDrawable != null)
              {
                localURLDrawable.setColorFilter(this.mMaskColor, PorterDuff.Mode.SRC_ATOP);
                locala.aw.setImageDrawable(localURLDrawable);
              }
              if (QLog.isColorLevel()) {
                QLog.i("AvatarWallViewPagerAdapter", 2, String.format("viewFactory: FROM_OTHERS, path=" + (String)localObject, new Object[0]));
              }
            }
            if (!localzri.aYK) {
              break label661;
            }
            if (locala.IP == null)
            {
              locala.IP = ((ViewStub)localView.findViewById(2131381497)).inflate();
              localObject = (FrameLayout.LayoutParams)locala.IP.getLayoutParams();
              ((FrameLayout.LayoutParams)localObject).height = -1;
              ((FrameLayout.LayoutParams)localObject).width = -1;
              locala.IP.setLayoutParams((ViewGroup.LayoutParams)localObject);
            }
            locala.IP.setVisibility(0);
          }
        }
        else
        {
          label547:
          localView.setTag(localzri);
          localView.setId(i);
          if (paramViewGroup == null) {
            break label682;
          }
          paramViewGroup.addView(localView);
        }
        for (;;)
        {
          return localView;
          if (paramInt == i + 1)
          {
            i = 0;
            break;
          }
          i = paramInt - 1;
          break;
          if ((j == 2) || ((localzri.baE != null) && (new File(localzri.baE).exists())))
          {
            localObject = localzri.baE;
            break label358;
          }
          if (j != 3) {
            break label358;
          }
          localObject = apqw.oL(apqw.p(localzri.baF, this.mTroopUin, 0));
          break label358;
          label661:
          if (locala.IP == null) {
            break label547;
          }
          locala.IP.setVisibility(8);
          break label547;
          label682:
          i = getCount();
          if (i > 1) {
            if (paramInt == 1) {
              this.IQ = localView;
            } else if (paramInt == i - 2) {
              this.IR = localView;
            }
          }
        }
      }
      i = 0;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public int ju()
  {
    return this.sH.size();
  }
  
  public class a
  {
    View IP;
    URLImageView aw;
    
    protected a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AvatarWallViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */