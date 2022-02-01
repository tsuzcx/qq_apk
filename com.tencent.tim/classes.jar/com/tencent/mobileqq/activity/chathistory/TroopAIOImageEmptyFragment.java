package com.tencent.mobileqq.activity.chathistory;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import aoop;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import wja;

public class TroopAIOImageEmptyFragment
  extends IphoneTitleBarFragment
{
  String mText;
  String mThumbUrl;
  String mTitle;
  
  public static void f(Activity paramActivity, String paramString1, @Nullable String paramString2, String paramString3)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("title", paramString1);
    if (paramString2 != null) {
      localIntent.putExtra("url", paramString2);
    }
    localIntent.putExtra("text", paramString3);
    PublicFragmentActivity.start(paramActivity, localIntent, TroopAIOImageEmptyFragment.class);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(this.mTitle);
    if (!TextUtils.isEmpty(this.mThumbUrl))
    {
      paramLayoutInflater = this.mContentView.getContext().getResources();
      paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
      paramViewGroup.mRequestWidth = wja.dp2px(321.0F, paramLayoutInflater);
      paramViewGroup.mRequestHeight = wja.dp2px(200.0F, paramLayoutInflater);
      paramViewGroup.mLoadingDrawable = aoop.TRANSPARENT;
      paramViewGroup.mFailedDrawable = aoop.TRANSPARENT;
      paramLayoutInflater = URLDrawable.getDrawable(this.mThumbUrl, paramViewGroup);
      ((ImageView)this.mContentView.findViewById(2131379638)).setImageDrawable(paramLayoutInflater);
    }
    ((TextView)this.mContentView.findViewById(2131379419)).setText(this.mText);
  }
  
  public int getContentLayoutId()
  {
    return 2131560776;
  }
  
  public void init(Bundle paramBundle)
  {
    super.init(paramBundle);
    this.mTitle = paramBundle.getString("title");
    this.mThumbUrl = paramBundle.getString("url");
    this.mText = paramBundle.getString("text");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.TroopAIOImageEmptyFragment
 * JD-Core Version:    0.7.0.1
 */