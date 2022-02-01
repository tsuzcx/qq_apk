package com.tencent.mobileqq.mini.entry.search.ui;

import NS_STORE_APP_CLIENT.STORE_APP_CLIENT.StUserInfo;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aqbn;
import aqnm;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.MiniAppModuleExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.comm.SearchInfo;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager.SearchResultDataChangedListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.util.WeakReference;

public class SearchResultAdapter
  extends BaseAdapter
  implements MiniAppSearchDataManager.SearchResultDataChangedListener
{
  private static final int HIGH_LIGHT_COLOR = -14763268;
  private static final String TAG = "SearchResultAdapter";
  private List<SearchInfo> appList = new ArrayList();
  private WeakReference<Activity> mActivityReference;
  private DataChangedListener mDataChangedListener;
  private String mKeyword;
  private int mRefer;
  
  public SearchResultAdapter(Activity paramActivity, int paramInt)
  {
    this.mActivityReference = new WeakReference(paramActivity);
    this.mRefer = paramInt;
  }
  
  public static Drawable getAvatarDrawable(Context paramContext, String paramString)
  {
    paramContext = paramContext.getResources().getDrawable(2130840645);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramContext;
    localURLDrawableOptions.mFailedDrawable = paramContext;
    int i = aqnm.dip2px(12.0F);
    localURLDrawableOptions.mRequestHeight = i;
    localURLDrawableOptions.mRequestWidth = i;
    paramContext = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramContext.setTag(aqbn.e(aqnm.dip2px(12.0F), aqnm.dip2px(12.0F)));
    paramContext.setDecodeHandler(aqbn.o);
    return paramContext;
  }
  
  public static SpannableString highLightKeyword(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = new SpannableString(paramString1);
    paramString2 = Pattern.compile(paramString2).matcher(paramString1);
    while (paramString2.find())
    {
      int i = paramString2.start();
      int j = paramString2.end();
      paramString1.setSpan(new ForegroundColorSpan(paramInt), i, j, 33);
    }
    return paramString1;
  }
  
  public int getCount()
  {
    return this.appList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.appList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    SearchResultViewHolder localSearchResultViewHolder;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext().getApplicationContext()).inflate(2131559607, paramViewGroup, false);
      localSearchResultViewHolder = new SearchResultViewHolder();
      localSearchResultViewHolder.icon = ((ImageView)paramView.findViewById(2131371701));
      localSearchResultViewHolder.name = ((TextView)paramView.findViewById(2131371702));
      localSearchResultViewHolder.category = ((TextView)paramView.findViewById(2131371703));
      localSearchResultViewHolder.desc = ((TextView)paramView.findViewById(2131371700));
      localSearchResultViewHolder.userNumDesc = ((TextView)paramView.findViewById(2131371713));
      localSearchResultViewHolder.divider = paramView.findViewById(2131371706);
      localSearchResultViewHolder.avatarContainer = ((LinearLayout)paramView.findViewById(2131371704));
      localSearchResultViewHolder.payingFriendsDesc = ((TextView)paramView.findViewById(2131371709));
      paramView.setTag(localSearchResultViewHolder);
    }
    for (;;)
    {
      SearchInfo localSearchInfo = (SearchInfo)this.appList.get(paramInt);
      try
      {
        localSearchResultViewHolder.update(paramView, localSearchInfo, (Activity)this.mActivityReference.get(), this.mKeyword, this.mRefer);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localSearchResultViewHolder = (SearchResultViewHolder)paramView.getTag();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("SearchResultAdapter", 1, "getView exception: " + Log.getStackTraceString(localException));
        }
      }
    }
  }
  
  public void onResultDataChanged()
  {
    setData(((MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(360)).getSearchResultData());
    notifyDataSetChanged();
    if (this.mDataChangedListener != null) {
      this.mDataChangedListener.onResultDataChanged(true);
    }
  }
  
  public void setData(List<SearchInfo> paramList)
  {
    this.appList.clear();
    this.appList.addAll(paramList);
  }
  
  public void setDataChangedListener(DataChangedListener paramDataChangedListener)
  {
    this.mDataChangedListener = paramDataChangedListener;
  }
  
  public void setKeyword(String paramString)
  {
    this.mKeyword = paramString;
  }
  
  public static abstract interface DataChangedListener
  {
    public abstract void onResultDataChanged(boolean paramBoolean);
    
    public abstract void onTextChanged(String paramString);
  }
  
  static class SearchResultViewHolder
  {
    LinearLayout avatarContainer;
    TextView category;
    TextView desc;
    View divider;
    ImageView icon;
    TextView name;
    TextView payingFriendsDesc;
    TextView userNumDesc;
    
    public void update(View paramView, SearchInfo paramSearchInfo, Activity paramActivity, String paramString, int paramInt)
    {
      MiniAppInfo localMiniAppInfo = paramSearchInfo.getMiniAppInfo();
      this.icon.setImageDrawable(MiniAppUtils.getIcon(paramView.getContext(), localMiniAppInfo.iconUrl, false, 0, 48));
      this.name.setText(SearchResultAdapter.highLightKeyword(-14763268, localMiniAppInfo.name, paramString));
      this.category.setText(paramSearchInfo.getCategoryDesc());
      this.desc.setText(localMiniAppInfo.desc);
      this.userNumDesc.setText(paramSearchInfo.getUseNumberDesc());
      this.payingFriendsDesc.setText(paramSearchInfo.playingFriendsDesc);
      if (paramSearchInfo.userInfoList.size() == 0)
      {
        this.avatarContainer.setVisibility(8);
        this.divider.setVisibility(8);
      }
      for (;;)
      {
        paramView.setOnClickListener(new SearchResultAdapter.SearchResultViewHolder.1(this, paramActivity, localMiniAppInfo, paramInt, paramString));
        paramView = (MiniAppExposureManager)MiniAppUtils.getAppInterface().getManager(322);
        paramSearchInfo = new MiniAppConfig(localMiniAppInfo);
        paramSearchInfo.launchParam.scene = paramInt;
        paramView.addSearchItemAndCheckReport(new MiniAppExposureManager.MiniAppModuleExposureData(paramSearchInfo, "page_view", "expo"));
        return;
        this.avatarContainer.removeAllViews();
        this.avatarContainer.setVisibility(0);
        this.divider.setVisibility(0);
        int i = 0;
        while ((i < 3) && (i < paramSearchInfo.userInfoList.size()))
        {
          Object localObject = ((STORE_APP_CLIENT.StUserInfo)paramSearchInfo.userInfoList.get(i)).avatar.get();
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            ImageView localImageView = new ImageView(paramView.getContext());
            localImageView.setImageDrawable(SearchResultAdapter.getAvatarDrawable(paramView.getContext(), (String)localObject));
            int j = aqnm.dpToPx(12.0F);
            localObject = new LinearLayout.LayoutParams(j, j);
            if (i > 0) {
              ((LinearLayout.LayoutParams)localObject).leftMargin = (-aqnm.dpToPx(2.0F));
            }
            localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
            this.avatarContainer.addView(localImageView);
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */