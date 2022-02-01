package com.tencent.mobileqq.troop.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import aozw;
import aqcx;
import aqfy;
import aqho;
import aqnt;
import aqnt.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.widget.CustomHorizontalScrollView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;

public class PublishItemContainer
  extends CustomHorizontalScrollView
  implements View.OnClickListener, aqnt.a
{
  protected View IU;
  public aozw a;
  private aqnt a;
  protected CharSequence az;
  protected LinearLayout bS;
  private boolean beY;
  private boolean cdU;
  protected ArrayList<String> cu = new ArrayList();
  private int dXb = 9;
  protected LinearLayout gC;
  protected Activity mActivity;
  private int mCurType = 0;
  protected Drawable mDefaultDrawable = getResources().getDrawable(2130848704);
  
  public PublishItemContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mActivity = ((Activity)paramContext);
    this.bS = new LinearLayout(paramContext);
    addView(this.bS);
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    this.bS.setOrientation(0);
    this.bS.setGravity(16);
    this.bS.setLayoutParams(paramAttributeSet);
    this.bS.setPadding(0, 0, 0, (int)aqho.convertDpToPixel(paramContext, 7.0F));
    this.gC = new LinearLayout(paramContext);
    this.bS.addView(this.gC);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    this.gC.setOrientation(0);
    this.gC.setGravity(16);
    this.gC.setLayoutParams(paramContext);
    this.IU = LayoutInflater.from(getContext()).inflate(2131560118, null);
    im(this.IU);
    this.IU.setVisibility(8);
    this.bS.addView(this.IU);
  }
  
  public boolean N(ArrayList<String> paramArrayList)
  {
    if (this.mCurType != 1) {
      this.gC.removeAllViews();
    }
    this.cu.clear();
    if (paramArrayList != null)
    {
      Object localObject = new ArrayList(paramArrayList);
      int j;
      int k;
      if ((paramArrayList.size() == this.dXb) || (paramArrayList.size() == 0))
      {
        this.IU.setVisibility(8);
        this.cu.addAll((Collection)localObject);
        j = this.gC.getChildCount();
        k = ((ArrayList)localObject).size();
        if (j <= k) {
          break label161;
        }
        this.gC.removeViews(k, j - k);
      }
      for (;;)
      {
        int i = 0;
        while (i < this.cu.size())
        {
          r(this.gC.getChildAt(i), (String)this.cu.get(i));
          i += 1;
        }
        this.IU.setVisibility(0);
        break;
        label161:
        if (j < k)
        {
          paramArrayList = LayoutInflater.from(this.mActivity);
          i = 0;
          while (i < k - j)
          {
            localObject = paramArrayList.inflate(2131560118, null);
            this.gC.addView((View)localObject);
            i += 1;
          }
        }
      }
      if (this.cu.size() > 0)
      {
        this.mCurType = 1;
        setVisibility(0);
        postDelayed(new PublishItemContainer.2(this), 200L);
      }
      return true;
    }
    this.gC.removeAllViews();
    this.IU.setVisibility(8);
    setVisibility(8);
    return false;
  }
  
  public void Sl(boolean paramBoolean)
  {
    N(this.cu);
    this.gC.setVisibility(0);
    this.bS.setVisibility(0);
    if (paramBoolean) {
      this.IU.setVisibility(0);
    }
    for (;;)
    {
      setVisibility(0);
      return;
      this.IU.setVisibility(8);
    }
  }
  
  public boolean a(int paramInt, aozw paramaozw)
  {
    if (this.mCurType == 1) {
      this.cu.clear();
    }
    if (paramaozw == null) {}
    for (View localView = null; localView == null; localView = paramaozw.getView(getContext(), this)) {
      return false;
    }
    this.beY = false;
    this.gC.removeAllViews();
    this.IU.setVisibility(8);
    this.gC.addView(localView);
    setVisibility(0);
    this.jdField_a_of_type_Aozw = paramaozw;
    this.mCurType = paramInt;
    return true;
  }
  
  public void c(int paramInt1, String paramString, int paramInt2)
  {
    stopAudio();
  }
  
  public void c(String paramString, int paramInt1, int paramInt2) {}
  
  public void d(String paramString, int paramInt1, int paramInt2) {}
  
  public int getCurType()
  {
    return this.mCurType;
  }
  
  protected void im(View paramView)
  {
    Object localObject = paramView.findViewById(2131369033);
    URLImageView localURLImageView = (URLImageView)paramView.findViewById(2131381359);
    localURLImageView.setImageResource(2130849421);
    ((View)localObject).setVisibility(8);
    localURLImageView.setAdjustViewBounds(false);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localURLImageView.getLayoutParams();
    localLayoutParams.width = ((int)aqho.convertDpToPixel(getContext(), 50.0F));
    localLayoutParams.height = ((int)aqho.convertDpToPixel(getContext(), 50.0F));
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    localURLImageView.setOnClickListener(this);
    localObject = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = aqcx.dip2px(getContext(), 2.0F);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = aqcx.dip2px(getContext(), 2.0F);
    localObject = new LinearLayout.LayoutParams((int)aqho.convertDpToPixel(getContext(), 60.0F), (int)aqho.convertDpToPixel(getContext(), 67.0F));
    ((LinearLayout.LayoutParams)localObject).rightMargin = aqcx.dip2px(getContext(), 2.0F);
    ((LinearLayout.LayoutParams)localObject).topMargin = aqcx.dip2px(getContext(), 4.0F);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      stopAudio();
      Object localObject = new Intent("key_audio_delete_action");
      BaseApplication.getContext().sendBroadcast((Intent)localObject);
      this.mCurType = 0;
      this.jdField_a_of_type_Aozw = null;
      continue;
      localObject = (String)paramView.getTag();
      int i = this.cu.indexOf(localObject);
      this.cu.remove(i);
      this.gC.removeViewAt(i);
      localObject = new Intent("key_photo_delete_action");
      ((Intent)localObject).putExtra("key_photo_delete_position", i);
      BaseApplication.getContext().sendBroadcast((Intent)localObject);
      if (this.cu.size() == 0)
      {
        setVisibility(8);
        this.IU.setVisibility(8);
        this.mCurType = 0;
      }
      else
      {
        this.IU.setVisibility(0);
        continue;
        if (paramView.getTag() != null)
        {
          localObject = (String)paramView.getTag();
          i = this.cu.indexOf(localObject);
          aqfy.clearCache();
          localObject = new Intent(this.mActivity, NewPhotoPreviewActivity.class);
          ((Intent)localObject).putExtra("ALBUM_ID", "$RecentAlbumId");
          ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
          ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.mActivity.getClass().getName());
          ((Intent)localObject).putExtra("back_btn_text", this.mActivity.getString(2131699469));
          ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.cu);
          ((Intent)localObject).putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
          ((Intent)localObject).putExtra("PhotoConst.MAXUM_SELECTED_NUM", this.cu.size());
          ((Intent)localObject).putExtra("PhotoConst.CURRENT_SELECTED_INDEX", i);
          ((Intent)localObject).putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
          ((Intent)localObject).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
          ((Intent)localObject).putExtra("from_tribe_class_name", this.mActivity.getClass().getSimpleName());
          ((Intent)localObject).putExtra("PhotoConst.IS_OVERLOAD", false);
          ((Intent)localObject).addFlags(603979776);
          getContext().startActivity((Intent)localObject);
          aqfy.anim(this.mActivity, false, true);
        }
        else
        {
          localObject = new Intent("key_photo_add_action");
          BaseApplication.getContext().sendBroadcast((Intent)localObject);
          continue;
          if (this.jdField_a_of_type_Aqnt == null)
          {
            playAudio();
            if (!this.beY)
            {
              localObject = new Intent("key_audio_play_action");
              BaseApplication.getContext().sendBroadcast((Intent)localObject);
              this.beY = true;
            }
          }
          else
          {
            stopAudio();
          }
        }
      }
    }
  }
  
  public void playAudio()
  {
    if ((this.mCurType != 2) || (!(this.jdField_a_of_type_Aozw instanceof AudioInfo))) {}
    AudioInfo localAudioInfo;
    do
    {
      return;
      localAudioInfo = (AudioInfo)this.jdField_a_of_type_Aozw;
      localAudioInfo.mAudioIcon.setImageResource(2130850974);
      localObject = new Intent("key_audio_playing_action");
      ((Intent)localObject).putExtra("audio_local_path", localAudioInfo.path);
      BaseApplication.getContext().sendBroadcast((Intent)localObject);
    } while (this.jdField_a_of_type_Aqnt != null);
    this.jdField_a_of_type_Aqnt = new aqnt(localAudioInfo.path, new Handler(), localAudioInfo.getAudioType());
    this.jdField_a_of_type_Aqnt.cf(getContext());
    this.jdField_a_of_type_Aqnt.aFk();
    this.jdField_a_of_type_Aqnt.a(this);
    this.jdField_a_of_type_Aqnt.start();
    this.cdU = true;
    Object localObject = (AnimationDrawable)BaseApplicationImpl.getApplication().getResources().getDrawable(2130772244);
    localAudioInfo.mAudioIcon.setImageDrawable((Drawable)localObject);
    ((AnimationDrawable)localObject).start();
  }
  
  protected void r(View paramView, String paramString)
  {
    View localView;
    URLImageView localURLImageView;
    RelativeLayout.LayoutParams localLayoutParams;
    Object localObject2;
    if ((paramView != null) && (!TextUtils.isEmpty(paramString)))
    {
      localView = paramView.findViewById(2131369033);
      localURLImageView = (URLImageView)paramView.findViewById(2131381359);
      localURLImageView.setAdjustViewBounds(false);
      localObject1 = (RelativeLayout.LayoutParams)localURLImageView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).width = ((int)aqho.convertDpToPixel(getContext(), 50.0F));
      ((RelativeLayout.LayoutParams)localObject1).height = ((int)aqho.convertDpToPixel(getContext(), 50.0F));
      ((RelativeLayout.LayoutParams)localObject1).addRule(9);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.topMargin = aqcx.dip2px(getContext(), 2.0F);
      localLayoutParams.rightMargin = aqcx.dip2px(getContext(), 2.0F);
      localObject2 = new File(paramString);
    }
    for (Object localObject1 = null;; localObject1 = localObject2)
    {
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        Drawable localDrawable = this.mDefaultDrawable;
        localURLDrawableOptions.mLoadingDrawable = localDrawable;
        localURLDrawableOptions.mFailedDrawable = localDrawable;
        localURLDrawableOptions.mPlayGifImage = true;
        localURLDrawableOptions.mRequestWidth = localLayoutParams.width;
        localURLDrawableOptions.mRequestHeight = localLayoutParams.height;
        if (!((File)localObject2).exists()) {
          break label347;
        }
        localObject2 = URLDrawable.getDrawable(((File)localObject2).toURL(), localURLDrawableOptions);
        localObject1 = localObject2;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        label207:
        label347:
        break label207;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.mDefaultDrawable;
      }
      ((Drawable)localObject2).setBounds(0, 0, localLayoutParams.width, localLayoutParams.height);
      localURLImageView.setImageDrawable((Drawable)localObject2);
      localURLImageView.setContentDescription(this.az);
      localView.setTag(paramString);
      localView.setOnClickListener(this);
      localURLImageView.setTag(paramString);
      localURLImageView.setOnClickListener(this);
      paramString = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      paramString.rightMargin = aqcx.dip2px(getContext(), 2.0F);
      paramString.topMargin = aqcx.dip2px(getContext(), 5.0F);
      paramString.width = ((int)aqho.convertDpToPixel(getContext(), 60.0F));
      paramString.height = ((int)aqho.convertDpToPixel(getContext(), 67.0F));
      paramView.setLayoutParams(paramString);
      return;
      localObject2 = this.mDefaultDrawable;
    }
  }
  
  public boolean rb(String paramString)
  {
    if (this.mCurType != 1) {
      this.gC.removeAllViews();
    }
    this.IU.setVisibility(0);
    if ((this.cu != null) && (!TextUtils.isEmpty(paramString)))
    {
      this.cu.add(paramString);
      View localView = LayoutInflater.from(getContext()).inflate(2131560118, null);
      this.gC.addView(localView);
      r(localView, paramString);
      this.mCurType = 1;
      if (this.cu.size() == this.dXb) {
        this.IU.setVisibility(8);
      }
      setVisibility(0);
      postDelayed(new PublishItemContainer.1(this), 200L);
      return true;
    }
    return false;
  }
  
  public void removeAllItem()
  {
    this.cu.clear();
    this.gC.removeAllViews();
    setVisibility(8);
    this.jdField_a_of_type_Aozw = null;
    this.mCurType = 0;
  }
  
  public void setCurType(int paramInt)
  {
    this.mCurType = paramInt;
  }
  
  public void setItemEnable(boolean paramBoolean)
  {
    this.gC.setEnabled(paramBoolean);
    if (this.mCurType == 2)
    {
      View localView2 = this.gC.getChildAt(0);
      View localView1 = localView2.findViewById(2131363086);
      localView2 = localView2.findViewById(2131363087);
      if ((localView1 != null) && (localView2 != null))
      {
        localView1.setEnabled(paramBoolean);
        localView2.setEnabled(paramBoolean);
      }
    }
    setEnabled(paramBoolean);
  }
  
  public void setMaxPicNum(int paramInt)
  {
    this.dXb = paramInt;
  }
  
  public void stopAudio()
  {
    if (this.jdField_a_of_type_Aqnt != null)
    {
      this.jdField_a_of_type_Aqnt.release();
      this.jdField_a_of_type_Aqnt = null;
      this.cdU = false;
      if ((this.jdField_a_of_type_Aozw instanceof AudioInfo)) {}
    }
    else
    {
      return;
    }
    AudioInfo localAudioInfo = (AudioInfo)this.jdField_a_of_type_Aozw;
    if ((localAudioInfo.mAudioIcon.getDrawable() instanceof AnimationDrawable)) {
      ((AnimationDrawable)localAudioInfo.mAudioIcon.getDrawable()).stop();
    }
    localAudioInfo.mAudioIcon.setImageResource(2130850974);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.PublishItemContainer
 * JD-Core Version:    0.7.0.1
 */