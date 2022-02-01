package com.tencent.mobileqq.mini.entry;

import acfp;
import aekv;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import android.widget.ViewFlipper;
import aqft;
import aqgq;
import aqoa;
import aute;
import auvj;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.cache.MiniCacheFreeManager;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MiniAppEntryAdapter
  extends RecyclerView.Adapter<MicroAppViewHolder>
{
  private static final String DEVELOP = acfp.m(2131708382);
  private static final String EXPERIENCE = acfp.m(2131708377);
  public static final int REFER_CONTACTS = 1;
  public static final int REFER_CONVERSATION = 0;
  public static final int REFER_LEBA = 2;
  private static final String TAG = "MiniAppEntryAdapter";
  private static final int TYPE_MIMI_APP_SPECIAL = 3;
  private static final int TYPE_MINI_APP_NORMAL = 1;
  private static final int TYPE_MINI_APP_TOP = 2;
  private Activity mActivity;
  private OnAnimationListener mAnimListener;
  private boolean mCanShowRedDot;
  private List<MiniAppInfo> mData = new ArrayList();
  protected BubblePopupWindow mMenuPop;
  private Map<String, Integer> mRedDotData = new HashMap();
  private int mRedDotSwitchState;
  private int mRefer = 0;
  private List<MiniAppInfo> mSpecialData = new ArrayList();
  private List<MiniAppInfo> mTopData = new ArrayList();
  View.OnClickListener onMenuItemSelected = new MiniAppEntryAdapter.3(this);
  private int topAppNum;
  
  public MiniAppEntryAdapter(Activity paramActivity, int paramInt)
  {
    this.mActivity = paramActivity;
    this.mRefer = paramInt;
  }
  
  private void deleteMiniApp(MiniAppInfo paramMiniAppInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MiniAppEntryAdapter", 2, "deleteMiniApp, delete miniAppInfo: " + paramMiniAppInfo.toString());
    }
    BaseActivity localBaseActivity = (BaseActivity)this.mActivity;
    MiniAppUserAppInfoListManager localMiniAppUserAppInfoListManager = (MiniAppUserAppInfoListManager)localBaseActivity.app.getManager(309);
    if (localMiniAppUserAppInfoListManager != null) {
      localMiniAppUserAppInfoListManager.sendDelUserAppRequest(paramMiniAppInfo);
    }
    MiniCacheFreeManager.freeCache(localBaseActivity.app.getCurrentUin(), paramMiniAppInfo);
  }
  
  private List<String> getMenuItems(MiniAppInfo paramMiniAppInfo)
  {
    Resources localResources = this.mActivity.getResources();
    ArrayList localArrayList = new ArrayList();
    if (paramMiniAppInfo != null)
    {
      if (paramMiniAppInfo.topType != 0) {
        break label55;
      }
      localArrayList.add(localResources.getString(2131695939));
      localArrayList.add(localResources.getString(2131695903));
    }
    label55:
    while (paramMiniAppInfo.topType != 1) {
      return localArrayList;
    }
    localArrayList.add(localResources.getString(2131695902));
    localArrayList.add(localResources.getString(2131695903));
    return localArrayList;
  }
  
  private int getRedDotCount(String paramString)
  {
    paramString = (Integer)this.mRedDotData.get(paramString);
    if (paramString != null) {
      return paramString.intValue();
    }
    return 0;
  }
  
  private void onMenuItemClick(String paramString, MiniAppInfo paramMiniAppInfo)
  {
    Resources localResources = this.mActivity.getResources();
    String str = "message";
    int i = 1001;
    if (this.mRefer == 1) {
      str = "contact";
    }
    MiniAppConfig localMiniAppConfig;
    do
    {
      i = 2006;
      for (;;)
      {
        localMiniAppConfig = new MiniAppConfig(paramMiniAppInfo);
        localMiniAppConfig.launchParam.scene = i;
        if (!aqft.equalsWithNullCheck(paramString, localResources.getString(2131695903))) {
          break;
        }
        deleteMiniApp(paramMiniAppInfo);
        MiniProgramLpReportDC04239.reportDropDown(localMiniAppConfig, str, "delete");
        return;
        if (this.mRefer == 2)
        {
          str = "more";
          i = 2007;
        }
      }
      if (aqft.equalsWithNullCheck(paramString, localResources.getString(2131695939)))
      {
        if (((this.mSpecialData != null) || (this.mTopData != null)) && (this.topAppNum >= 11))
        {
          QQToast.a(this.mActivity, "最多仅支持置顶10个小程序", 0).show();
          return;
        }
        setTopMiniApp(paramMiniAppInfo);
        MiniProgramLpReportDC04239.reportDropDown(localMiniAppConfig, str, "settop_on");
        return;
      }
    } while (!aqft.equalsWithNullCheck(paramString, localResources.getString(2131695902)));
    setTopMiniApp(paramMiniAppInfo);
    MiniProgramLpReportDC04239.reportDropDown(localMiniAppConfig, str, "settop_off");
  }
  
  private void setAnimationListener(OnAnimationListener paramOnAnimationListener)
  {
    this.mAnimListener = paramOnAnimationListener;
  }
  
  private void setDividerLineColor(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      paramViewGroup = paramViewGroup.getChildAt(0);
      if ((paramViewGroup instanceof ImageView))
      {
        paramViewGroup = (ImageView)paramViewGroup;
        if (!MiniAppUtils.isNightMode()) {
          break label36;
        }
        paramViewGroup.setImageResource(2130841809);
      }
    }
    return;
    label36:
    paramViewGroup.setImageResource(2130849275);
  }
  
  private void setTopMiniApp(MiniAppInfo paramMiniAppInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MiniAppEntryAdapter", 2, "setTopMiniApp, miniAppInfo: " + paramMiniAppInfo.toString());
    }
    MiniAppUserAppInfoListManager localMiniAppUserAppInfoListManager = (MiniAppUserAppInfoListManager)((BaseActivity)this.mActivity).app.getManager(309);
    if (localMiniAppUserAppInfoListManager != null)
    {
      if (paramMiniAppInfo.topType != 0) {
        break label81;
      }
      paramMiniAppInfo.topType = 1;
      paramMiniAppInfo.updateTimeStamp();
    }
    for (;;)
    {
      localMiniAppUserAppInfoListManager.sendSetUserAppTopRequest(paramMiniAppInfo);
      return;
      label81:
      paramMiniAppInfo.topType = 0;
    }
  }
  
  private static void updateMiniAppStorePlayAnimationTime()
  {
    AppInterface localAppInterface = MiniAppUtils.getAppInterface();
    if (localAppInterface != null) {
      localAppInterface.getPreferences().edit().putLong("key_mini_app_store_show_animation_time", System.currentTimeMillis()).apply();
    }
  }
  
  public int getItemCount()
  {
    if ((this.mData == null) || (this.mData.size() == 0)) {
      return 1;
    }
    return this.mData.size();
  }
  
  public MiniAppInfo getItemForPosition(int paramInt)
  {
    if ((paramInt < this.mData.size()) && (paramInt >= 0)) {
      return (MiniAppInfo)this.mData.get(paramInt);
    }
    return null;
  }
  
  public Map<String, Integer> getRedDotDataMap()
  {
    return this.mRedDotData;
  }
  
  public void handleLongClick(View paramView, MiniAppInfo paramMiniAppInfo, int paramInt)
  {
    paramMiniAppInfo = getMenuItems(paramMiniAppInfo);
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.size() > 0))
    {
      aqoa localaqoa = new aqoa();
      int i = 0;
      while (i < paramMiniAppInfo.size())
      {
        localaqoa.dV(paramInt, (String)paramMiniAppInfo.get(i));
        i += 1;
      }
      this.mMenuPop = aqgq.a(paramView, localaqoa, this.onMenuItemSelected, null);
    }
  }
  
  public void onBindViewHolder(MicroAppViewHolder paramMicroAppViewHolder, int paramInt)
  {
    if (this.mData.size() <= 0)
    {
      QLog.e("MiniAppEntryAdapter", 1, "[MiniAppUserAppInfoListManager].onBindViewHolder, size = " + this.mData.size());
      EventCollector.getInstance().onRecyclerBindViewHolder(paramMicroAppViewHolder, paramInt, getItemId(paramInt));
      return;
    }
    MiniAppInfo localMiniAppInfo = (MiniAppInfo)this.mData.get(paramInt);
    paramMicroAppViewHolder.imageView.setImageDrawable(MiniAppUtils.getIcon(this.mActivity, localMiniAppInfo.iconUrl, true));
    paramMicroAppViewHolder.textView.setText(localMiniAppInfo.name);
    paramMicroAppViewHolder.setMiniAppInfo(localMiniAppInfo);
    Object localObject2 = MiniAppUtils.getAppInterface();
    if (localObject2 != null)
    {
      if (paramMicroAppViewHolder.textView != null) {
        paramMicroAppViewHolder.textView.setTextColor(BaseApplicationImpl.getContext().getResources().getColor(2131167311));
      }
      if ((paramMicroAppViewHolder.imageView instanceof ThemeImageView)) {
        ((ThemeImageView)paramMicroAppViewHolder.imageView).setSupportMaskView(true);
      }
    }
    label224:
    Object localObject1;
    label271:
    label320:
    label450:
    int i;
    if (localMiniAppInfo.isSpecialMiniApp())
    {
      paramMicroAppViewHolder.itemView.setTag(Integer.valueOf(3));
      if ((localMiniAppInfo.verType != 0) && (localMiniAppInfo.verType != 4)) {
        break label707;
      }
      paramMicroAppViewHolder.versionTypeMark.setVisibility(0);
      paramMicroAppViewHolder.versionTypeMark.setText(DEVELOP);
      if (localMiniAppInfo.recommend != 1) {
        break label762;
      }
      paramMicroAppViewHolder.recommendBadge.setVisibility(0);
      if (TextUtils.isEmpty(localMiniAppInfo.recommendAppIconUrl)) {
        break label749;
      }
      paramMicroAppViewHolder.recommendBadge.setImageDrawable(MiniAppUtils.getRecommendIconDrawable(this.mActivity, localMiniAppInfo.recommendAppIconUrl));
      if ((this.topAppNum <= 0) || (paramInt != this.topAppNum - 1) || (this.mData.size() <= this.topAppNum)) {
        break label774;
      }
      paramMicroAppViewHolder.dividerLine.setVisibility(0);
      setDividerLineColor(paramMicroAppViewHolder.dividerLine);
      localObject1 = (Integer)this.mRedDotData.get(localMiniAppInfo.appId);
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppEntryAdapter", 1, "onBindViewHolder, canShowRedDot: " + this.mCanShowRedDot + ", redDotNum : " + localObject1 + ", name : " + localMiniAppInfo.name);
      }
      if ((!this.mCanShowRedDot) || (this.mRedDotSwitchState != 1) || (localObject1 == null) || (((Integer)localObject1).intValue() <= 0)) {
        break label786;
      }
      paramMicroAppViewHolder.redDot.setVisibility(0);
      aute.updateCustomNoteTxt(paramMicroAppViewHolder.redDot, 7, ((Integer)localObject1).intValue(), 0);
      if (this.mRefer != 0) {
        break label798;
      }
      if (localMiniAppInfo.recommend != 1) {
        break label969;
      }
      localMiniAppInfo.via = "1001_1";
      i = 1001;
    }
    for (;;)
    {
      localObject1 = null;
      if (localObject2 != null) {
        localObject1 = (MiniAppExposureManager)((AppInterface)localObject2).getManager(322);
      }
      if (localObject1 != null)
      {
        localObject2 = new MiniAppConfig(localMiniAppInfo);
        ((MiniAppConfig)localObject2).launchParam.scene = i;
        ((MiniAppExposureManager)localObject1).addReportItem(new MiniAppExposureManager.MiniAppExposureData((MiniAppConfig)localObject2, paramInt, String.valueOf(getRedDotCount(localMiniAppInfo.appId))));
      }
      if ((localMiniAppInfo.motionPics != null) && (localMiniAppInfo.motionPics.size() > 0))
      {
        setAnimationListener(paramMicroAppViewHolder);
        localObject1 = localMiniAppInfo.motionPics.iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            ImageView localImageView = new ImageView(this.mActivity);
            localImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            localImageView.setImageDrawable(MiniAppUtils.getIcon(this.mActivity, (String)localObject2, true));
            localImageView.setScaleType(ImageView.ScaleType.CENTER);
            paramMicroAppViewHolder.viewFlipper.addView(localImageView);
            continue;
            if (localMiniAppInfo.topType == 1)
            {
              paramMicroAppViewHolder.itemView.setTag(Integer.valueOf(2));
              break;
            }
            paramMicroAppViewHolder.itemView.setTag(Integer.valueOf(1));
            break;
            label707:
            if (localMiniAppInfo.verType == 1)
            {
              paramMicroAppViewHolder.versionTypeMark.setVisibility(0);
              paramMicroAppViewHolder.versionTypeMark.setText(EXPERIENCE);
              break label224;
            }
            paramMicroAppViewHolder.versionTypeMark.setVisibility(8);
            break label224;
            label749:
            paramMicroAppViewHolder.recommendBadge.setImageResource(2130841814);
            break label271;
            label762:
            paramMicroAppViewHolder.recommendBadge.setVisibility(8);
            break label271;
            label774:
            paramMicroAppViewHolder.dividerLine.setVisibility(8);
            break label320;
            label786:
            paramMicroAppViewHolder.redDot.setVisibility(8);
            break label450;
            label798:
            if (this.mRefer == 1)
            {
              if (localMiniAppInfo.recommend == 1) {
                localMiniAppInfo.via = "2006_1";
              }
              for (;;)
              {
                i = 2006;
                break;
                if (localMiniAppInfo.topType == 1) {
                  localMiniAppInfo.via = "2006_2";
                } else {
                  localMiniAppInfo.via = "2006_3";
                }
              }
            }
            if (this.mRefer != 2) {
              break label969;
            }
            if (localMiniAppInfo.recommend == 1) {
              localMiniAppInfo.via = "2007_1";
            }
            for (;;)
            {
              i = 2007;
              break;
              if (localMiniAppInfo.topType == 1) {
                localMiniAppInfo.via = "2007_2";
              } else {
                localMiniAppInfo.via = "2007_3";
              }
            }
          }
        }
        paramMicroAppViewHolder.picCount = localMiniAppInfo.motionPics.size();
      }
      paramMicroAppViewHolder.itemView.setOnClickListener(new MiniAppEntryAdapter.1(this));
      paramMicroAppViewHolder.itemView.setOnLongClickListener(new MiniAppEntryAdapter.2(this));
      break;
      label969:
      i = 1001;
    }
  }
  
  public MicroAppViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new MicroAppViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562580, paramViewGroup, false));
  }
  
  public void setData(List<MiniAppInfo> paramList, Map<String, Integer> paramMap)
  {
    this.mData.clear();
    this.mTopData.clear();
    this.mSpecialData.clear();
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniAppEntryAdapter", 2, "setData. data = " + paramList);
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MiniAppInfo localMiniAppInfo = (MiniAppInfo)paramList.next();
      if (localMiniAppInfo.isSpecialMiniApp())
      {
        if (localMiniAppInfo.topType != 1) {
          localMiniAppInfo.topType = 1;
        }
        this.mSpecialData.add(localMiniAppInfo);
      }
      else if (localMiniAppInfo.topType == 1)
      {
        this.mTopData.add(localMiniAppInfo);
      }
      else
      {
        localArrayList.add(localMiniAppInfo);
      }
    }
    this.mData.addAll(this.mSpecialData);
    this.mData.addAll(this.mTopData);
    this.mData.addAll(localArrayList);
    this.topAppNum = (this.mSpecialData.size() + this.mTopData.size());
    this.mRedDotData.clear();
    this.mRedDotData.putAll(paramMap);
    this.mCanShowRedDot = aekv.agW();
  }
  
  public void setRedDotSwitchState(int paramInt)
  {
    this.mRedDotSwitchState = paramInt;
  }
  
  public void startAnimation()
  {
    if (this.mAnimListener != null) {
      this.mAnimListener.startAnimation();
    }
  }
  
  public void stopAnimation()
  {
    if (this.mAnimListener != null) {
      this.mAnimListener.stopAnimation();
    }
  }
  
  static class MicroAppViewHolder
    extends RecyclerView.ViewHolder
    implements MiniAppEntryAdapter.OnAnimationListener
  {
    ViewGroup dividerLine;
    ImageView imageView;
    boolean isPlayAnim;
    MiniAppInfo miniAppInfo;
    int picCount;
    ImageView recommendBadge;
    TextView redDot;
    TextView textView;
    TextView versionTypeMark;
    ViewFlipper viewFlipper;
    
    public MicroAppViewHolder(View paramView)
    {
      super();
      this.imageView = ((ImageView)paramView.findViewById(2131371822));
      if ((this.imageView instanceof ThemeImageView)) {
        ((ThemeImageView)this.imageView).setMaskShape(auvj.euM);
      }
      this.textView = ((TextView)paramView.findViewById(2131371823));
      this.versionTypeMark = ((TextView)paramView.findViewById(2131371824));
      this.dividerLine = ((ViewGroup)paramView.findViewById(2131371816));
      this.recommendBadge = ((ImageView)paramView.findViewById(2131371676));
      this.viewFlipper = ((ViewFlipper)paramView.findViewById(2131371716));
      this.redDot = ((TextView)paramView.findViewById(2131371681));
    }
    
    private void startSwitchAnimation()
    {
      long l = this.picCount * 2200;
      QLog.d("MiniAppEntryAdapter", 1, "[mini_app_anim].startSwitchAnimation, picCount = " + this.picCount + ", isPlayAnim: " + this.isPlayAnim + ", duration: " + l);
      this.viewFlipper.setVisibility(0);
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
      localTranslateAnimation.setDuration(700L);
      localTranslateAnimation.setInterpolator(new MiniAppEntryAdapter.SpringTranslationInterpolator(0.4F));
      localTranslateAnimation.setFillAfter(true);
      this.viewFlipper.setInAnimation(localTranslateAnimation);
      localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F);
      localTranslateAnimation.setDuration(700L);
      localTranslateAnimation.setInterpolator(new LinearInterpolator());
      localTranslateAnimation.setFillAfter(false);
      this.viewFlipper.setOutAnimation(localTranslateAnimation);
      this.viewFlipper.setFlipInterval(2200);
      this.viewFlipper.setAnimateFirstView(true);
      this.viewFlipper.startFlipping();
      AppBrandTask.runTaskOnUiThreadDelay(new MiniAppEntryAdapter.MicroAppViewHolder.1(this), l);
    }
    
    public void setMiniAppInfo(MiniAppInfo paramMiniAppInfo)
    {
      this.miniAppInfo = paramMiniAppInfo;
    }
    
    public void startAnimation()
    {
      this.isPlayAnim = true;
      Drawable localDrawable = MiniAppUtils.getIcon(this.imageView.getContext(), this.miniAppInfo.appStoreAnimPicUrl, true, 2130841825, 48);
      this.imageView.setImageDrawable(localDrawable);
      this.imageView.invalidate();
      QLog.d("MiniAppEntryAdapter", 1, "[mini_app_anim].startAnimation, picCount = " + this.picCount + ", pic Url = " + this.miniAppInfo.appStoreAnimPicUrl + ", drawable = " + localDrawable);
      startSwitchAnimation();
    }
    
    public void stopAnimation()
    {
      QLog.d("MiniAppEntryAdapter", 1, "[mini_app_anim].stopAnimation, isPlayAnim: " + this.isPlayAnim);
      this.isPlayAnim = false;
      this.viewFlipper.stopFlipping();
      this.imageView.setImageDrawable(MiniAppUtils.getIcon(this.imageView.getContext(), this.miniAppInfo.iconUrl, true));
      this.viewFlipper.setVisibility(8);
    }
  }
  
  static abstract interface OnAnimationListener
  {
    public abstract void startAnimation();
    
    public abstract void stopAnimation();
  }
  
  public static class SpringTranslationInterpolator
    implements Interpolator
  {
    private float factor;
    
    public SpringTranslationInterpolator(float paramFloat)
    {
      this.factor = paramFloat;
    }
    
    public float getInterpolation(float paramFloat)
    {
      return (float)(Math.pow(2.0D, -10.0F * paramFloat) * Math.sin((paramFloat - this.factor / 4.0F) * 6.283185307179586D / this.factor) + 1.0D);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppEntryAdapter
 * JD-Core Version:    0.7.0.1
 */