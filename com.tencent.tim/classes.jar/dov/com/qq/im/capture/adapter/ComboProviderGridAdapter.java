package dov.com.qq.im.capture.adapter;

import acfp;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqmj;
import aqnm;
import axov;
import axpn;
import axpr;
import axpz;
import axqc;
import axxj;
import ayva;
import azbx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.item.DetectableAnimationDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.GridView;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import java.util.List;
import rpw;

public class ComboProviderGridAdapter
  extends BaseAdapter
  implements Handler.Callback
{
  float Eo;
  float Ep;
  int eCJ;
  public GridView i;
  private Context mContext;
  List<QIMFilterCategoryItem> mData;
  public Handler mHandler = new Handler(this);
  float qT;
  
  public ComboProviderGridAdapter(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.eCJ = paramInt;
  }
  
  public static void a(ImageView paramImageView, axpn paramaxpn, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    ayva.a();
    boolean bool1 = ayva.needShowRedDot(3, paramQIMFilterCategoryItem.categoryId, paramQIMFilterCategoryItem.id);
    int j = paramaxpn.outState;
    boolean bool2 = ((axpr)axov.a(5)).a().ui(paramQIMFilterCategoryItem.id);
    if ((bool2) || (paramQIMFilterCategoryItem.dwd) || (bool1))
    {
      paramImageView.setVisibility(0);
      if (bool2)
      {
        paramImageView.setImageResource(2130845446);
        return;
      }
      if (bool1)
      {
        paramImageView.setImageResource(2130846850);
        return;
      }
      switch (j)
      {
      default: 
        return;
      case 1: 
      case 3: 
        paramImageView.setVisibility(8);
        return;
      }
      paramImageView.setImageResource(2130846849);
      return;
    }
    paramImageView.setVisibility(8);
  }
  
  private View cL()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
    Object localObject1 = new RelativeLayout(this.mContext);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    int j = aqnm.dpToPx(5.0F);
    ((RelativeLayout.LayoutParams)localObject2).setMargins(j, j, j, j);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new URLImageView(this.mContext);
    ((URLImageView)localObject2).setId(2131368698);
    ((URLImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new ImageView(this.mContext);
    ((ImageView)localObject2).setId(2131369118);
    ((ImageView)localObject2).setVisibility(8);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    ((ImageView)localObject2).setImageResource(2130845335);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new LinearLayout(this.mContext);
    ((LinearLayout)localObject2).setId(2131372104);
    ((LinearLayout)localObject2).setOrientation(0);
    Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(13, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject3 = new ImageView(this.mContext);
    ((ImageView)localObject3).setImageResource(2130845336);
    Object localObject4 = new LinearLayout.LayoutParams(aqnm.dpToPx(11.0F), aqnm.dpToPx(4.5F));
    ((LinearLayout.LayoutParams)localObject4).gravity = 16;
    ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    localObject3 = new TextView(this.mContext);
    ((TextView)localObject3).setId(2131372126);
    ((TextView)localObject3).setTextSize(2, 12.0F);
    ((TextView)localObject3).setTextColor(this.mContext.getResources().getColor(2131167654));
    ((TextView)localObject3).setMaxLines(1);
    ((TextView)localObject3).setLines(1);
    ((TextView)localObject3).setShadowLayer(3.0F, 0.0F, 0.0F, Color.parseColor("#7F000000"));
    localObject4 = new LinearLayout.LayoutParams(-2, -2);
    j = aqnm.dpToPx(5.0F);
    ((LinearLayout.LayoutParams)localObject4).leftMargin = j;
    ((LinearLayout.LayoutParams)localObject4).rightMargin = j;
    ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    localObject3 = new ImageView(this.mContext);
    ((ImageView)localObject3).setImageResource(2130845336);
    localObject4 = new LinearLayout.LayoutParams(aqnm.dpToPx(11.0F), aqnm.dpToPx(4.5F));
    ((LinearLayout.LayoutParams)localObject4).gravity = 16;
    ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    localObject2 = new RelativeLayout(this.mContext);
    ((RelativeLayout)localObject2).setId(2131369428);
    ((RelativeLayout)localObject2).setBackgroundResource(2130845415);
    ((RelativeLayout)localObject2).setVisibility(8);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject3).topMargin = aqnm.dpToPx(16.0F);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject3 = new TextView(this.mContext);
    ((TextView)localObject3).setCompoundDrawables(null, null, this.mContext.getResources().getDrawable(2130845416), null);
    ((TextView)localObject3).setCompoundDrawablePadding(aqnm.dpToPx(4.0F));
    ((TextView)localObject3).setText(acfp.m(2131704178));
    ((TextView)localObject3).setTextSize(2, 12.0F);
    ((TextView)localObject3).setTextColor(this.mContext.getResources().getColor(2131167654));
    localObject4 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject4).addRule(13, -1);
    ((RelativeLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    localObject2 = new TextView(this.mContext);
    ((TextView)localObject2).setId(2131367090);
    ((TextView)localObject2).setTextSize(2, 12.0F);
    ((TextView)localObject2).setTextColor(this.mContext.getResources().getColor(2131167654));
    ((TextView)localObject2).setMaxLines(1);
    ((TextView)localObject2).setLines(1);
    ((TextView)localObject2).setShadowLayer(3.0F, 0.0F, 0.0F, Color.parseColor("#7F000000"));
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).bottomMargin = aqnm.dpToPx(5.0F);
    ((RelativeLayout.LayoutParams)localObject3).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject3).addRule(12, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject2 = new QIMCommonLoadingView(this.mContext);
    ((QIMCommonLoadingView)localObject2).setId(2131367093);
    ((QIMCommonLoadingView)localObject2).setVisibility(8);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject1 = new ImageView(this.mContext);
    ((ImageView)localObject1).setId(2131365459);
    ((ImageView)localObject1).setImageResource(2130846849);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new ImageView(this.mContext);
    ((ImageView)localObject1).setId(2131382330);
    ((ImageView)localObject1).setVisibility(8);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    return localRelativeLayout;
  }
  
  public void a(ImageView paramImageView, AnimationDrawable paramAnimationDrawable, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ComboProviderGridAdapter", 2, "showUnlockAnimation ");
    }
    ImageView localImageView = new ImageView(paramImageView.getContext());
    PopupWindow localPopupWindow = new PopupWindow(localImageView, -2, -2, true);
    localPopupWindow.setTouchable(true);
    localPopupWindow.setClippingEnabled(false);
    localPopupWindow.setOutsideTouchable(true);
    localPopupWindow.setBackgroundDrawable(new ColorDrawable(16777215));
    int[] arrayOfInt = new int[2];
    paramImageView.getLocationOnScreen(arrayOfInt);
    if (QLog.isColorLevel()) {
      QLog.i("ComboProviderGridAdapter", 2, "showUnlockAnimation " + arrayOfInt[0] + "," + arrayOfInt[1]);
    }
    int j = azbx.dip2px(60.0F) - paramImageView.getWidth();
    localPopupWindow.showAtLocation(paramImageView, 8388659, arrayOfInt[0] - j / 2, arrayOfInt[1] - j / 2);
    paramAnimationDrawable.setOneShot(true);
    paramAnimationDrawable = new LockAnimationDrawable(paramAnimationDrawable, localImageView, localPopupWindow, paramImageView, paramQIMFilterCategoryItem);
    this.mHandler.postDelayed(new ComboProviderGridAdapter.1(this, paramImageView), 200L);
    localImageView.setImageDrawable(paramAnimationDrawable);
    paramAnimationDrawable.start();
  }
  
  public void aeB(int paramInt)
  {
    QIMFilterCategoryItem localQIMFilterCategoryItem = ((axpr)axov.a(5)).a().f;
    if ((localQIMFilterCategoryItem != null) && (localQIMFilterCategoryItem.categoryId == paramInt)) {
      eNE();
    }
  }
  
  public void eNE()
  {
    this.mHandler.sendEmptyMessageDelayed(9, 600L);
  }
  
  public int getCount()
  {
    return this.mData.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.mData.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((this.Eo <= 0.0F) && (paramViewGroup != null))
    {
      this.Eo = paramViewGroup.getMeasuredWidth();
      this.qT = ((this.Eo - FilterProviderPagerAdapter.dyo * 3 - paramViewGroup.getPaddingLeft() - paramViewGroup.getPaddingRight()) / 4.0F + 0.5F);
      this.Ep = (12.0F * this.qT / 160.0F);
    }
    if (paramView == null) {
      paramView = cL();
    }
    for (;;)
    {
      TextView localTextView1 = (TextView)paramView.findViewById(2131367090);
      ImageView localImageView3 = (ImageView)paramView.findViewById(2131369118);
      ImageView localImageView1 = (ImageView)paramView.findViewById(2131368698);
      ImageView localImageView2 = (ImageView)paramView.findViewById(2131365459);
      TextView localTextView2 = (TextView)paramView.findViewById(2131372126);
      View localView = paramView.findViewById(2131372104);
      QIMCommonLoadingView localQIMCommonLoadingView = (QIMCommonLoadingView)paramView.findViewById(2131367093);
      QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)this.mData.get(paramInt);
      axpr localaxpr = (axpr)axov.a(5);
      Object localObject1 = ayva.a().a[this.eCJ];
      if (localObject1 != null) {}
      for (localObject1 = (QIMFilterCategoryItem)((axqc)localObject1).target;; localObject1 = null)
      {
        boolean bool = false;
        if (localObject1 != null) {
          bool = TextUtils.equals(((QIMFilterCategoryItem)localObject1).id, localQIMFilterCategoryItem.id);
        }
        if (!bool) {
          if (((localObject1 == null) || (((QIMFilterCategoryItem)localObject1).auG())) && (localQIMFilterCategoryItem.auG())) {
            bool = true;
          }
        }
        for (;;)
        {
          paramView.setTag(localQIMFilterCategoryItem);
          Object localObject2 = (AbsListView.LayoutParams)paramView.getLayoutParams();
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new AbsListView.LayoutParams(-1, -1);
            paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
          ((AbsListView.LayoutParams)localObject1).height = ((int)this.qT);
          if (localQIMFilterCategoryItem.auG())
          {
            localImageView3.setVisibility(8);
            if (bool)
            {
              localImageView1.setImageDrawable(this.mContext.getResources().getDrawable(2130845338));
              label349:
              localImageView2.setVisibility(8);
              localTextView1.setVisibility(0);
              localTextView1.setText(acfp.m(2131704179));
              localView.setVisibility(8);
            }
          }
          for (;;)
          {
            if ((localaxpr.a().f != null) && (!this.mHandler.hasMessages(9))) {}
            EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
            return paramView;
            bool = false;
            break;
            localImageView1.setImageDrawable(this.mContext.getResources().getDrawable(2130845339));
            break label349;
            localTextView1.setVisibility(8);
            localObject1 = localaxpr.a(localQIMFilterCategoryItem);
            if (!TextUtils.isEmpty(localQIMFilterCategoryItem.name))
            {
              localView.setVisibility(0);
              localTextView2.setText(localQIMFilterCategoryItem.name);
              label489:
              if (!bool) {
                break label702;
              }
              localImageView3.setImageResource(2130845337);
              localImageView3.setVisibility(0);
              localTextView1.setShadowLayer(0.0F, 0.0F, 0.0F, this.mContext.getResources().getColor(2131167250));
              label529:
              localObject2 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.mContext.getResources().getDrawable(2130845334);
              ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.mContext.getResources().getDrawable(2130845334);
              ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
              localQIMCommonLoadingView.setMax(10000);
              localObject2 = URLDrawable.getDrawable(localQIMFilterCategoryItem.iconUrl, (URLDrawable.URLDrawableOptions)localObject2);
              if (((URLDrawable)localObject2).getStatus() == 2) {
                ((URLDrawable)localObject2).restartDownload();
              }
              localImageView1.setImageDrawable((Drawable)localObject2);
              localTextView1.setText(localQIMFilterCategoryItem.name);
              if (!localQIMFilterCategoryItem.isWsBanner()) {
                break label745;
              }
              localImageView2.setVisibility(8);
              localObject1 = (ImageView)paramView.findViewById(2131382330);
              if (!localQIMFilterCategoryItem.isDovItem()) {
                break label734;
              }
              ((ImageView)localObject1).setImageResource(2130846843);
            }
            for (;;)
            {
              ((ImageView)localObject1).setVisibility(0);
              rpw.aq(localQIMFilterCategoryItem);
              break;
              localTextView2.setText("");
              localView.setVisibility(8);
              break label489;
              label702:
              localImageView3.setVisibility(8);
              localTextView1.setShadowLayer(3.0F, 0.0F, 0.0F, this.mContext.getResources().getColor(2131167250));
              break label529;
              label734:
              ((ImageView)localObject1).setImageResource(2130846856);
            }
            label745:
            ((ImageView)paramView.findViewById(2131382330)).setVisibility(8);
            localQIMCommonLoadingView.setVisibility(0);
            localQIMCommonLoadingView.setBgCorner(this.Ep);
            localQIMCommonLoadingView.a(axxj.a(localObject1));
            a(localImageView2, (axpn)localObject1, localQIMFilterCategoryItem);
          }
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 9)
    {
      if ((this.i == null) || (!this.i.isShown()))
      {
        QLog.i("ComboLockManager", 1, "checkAnim err, ignore");
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ComboLockManager", 2, "checkAnim");
      }
      int k = this.i.getChildCount();
      paramMessage = (axpr)axov.a(5);
      QIMFilterCategoryItem localQIMFilterCategoryItem = paramMessage.a().f;
      int j;
      if (localQIMFilterCategoryItem != null) {
        j = 0;
      }
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        if (j < k)
        {
          localObject1 = this.i.getChildAt(j);
          localObject2 = ((View)localObject1).getTag();
          if ((!QIMFilterCategoryItem.class.isInstance(localObject2)) || (!((QIMFilterCategoryItem)localObject2).id.equals(localQIMFilterCategoryItem.id))) {}
        }
        else
        {
          try
          {
            localObject1 = (ImageView)((View)localObject1).findViewById(2131365459);
            localObject2 = (AnimationDrawable)((ImageView)localObject1).getContext().getResources().getDrawable(2130845565);
            paramMessage.a().f = null;
            a((ImageView)localObject1, (AnimationDrawable)localObject2, localQIMFilterCategoryItem);
            return true;
          }
          catch (Exception paramMessage)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.i("ComboProviderGridAdapter", 2, "showUnlockAnimation err", paramMessage);
              }
            }
          }
        }
        j += 1;
      }
    }
    return false;
  }
  
  public void setData(List<QIMFilterCategoryItem> paramList)
  {
    this.mData = paramList;
  }
  
  public static class LockAnimationDrawable
    extends DetectableAnimationDrawable
  {
    ImageView Ix = null;
    ImageView Iy = null;
    QIMFilterCategoryItem e = null;
    PopupWindow mPopupWindow = null;
    
    public LockAnimationDrawable(AnimationDrawable paramAnimationDrawable, ImageView paramImageView1, PopupWindow paramPopupWindow, ImageView paramImageView2, QIMFilterCategoryItem paramQIMFilterCategoryItem)
    {
      super();
      this.mPopupWindow = paramPopupWindow;
      this.Ix = paramImageView1;
      this.Iy = paramImageView2;
      this.e = paramQIMFilterCategoryItem;
    }
    
    public void onAnimationFinish()
    {
      this.mPopupWindow.dismiss();
      this.Ix.setImageDrawable(null);
      this.Ix = null;
      this.mPopupWindow = null;
      Object localObject = (axpr)axov.a(5);
      ((axpr)localObject).a().adj(this.e.id);
      aqmj.y(BaseApplicationImpl.getApplication(), this.e.id, false);
      ayva.a().I(3, this.e.categoryId, this.e.id);
      Bundle localBundle = new Bundle();
      localBundle.putInt("apply_source", 1);
      localBundle.putInt("capture_scene", 0);
      ((axpr)localObject).a(this.e, (Activity)this.Iy.getContext(), localBundle);
      this.Iy.setVisibility(8);
      localObject = ((axpr)localObject).a(this.e);
      ComboProviderGridAdapter.a(this.Iy, (axpn)localObject, this.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.ComboProviderGridAdapter
 * JD-Core Version:    0.7.0.1
 */