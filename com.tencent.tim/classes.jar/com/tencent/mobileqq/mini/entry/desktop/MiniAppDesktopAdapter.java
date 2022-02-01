package com.tencent.mobileqq.mini.entry.desktop;

import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE.StFriendRanking;
import NS_MINI_INTERFACE.INTERFACE.StModuleInfo;
import NS_MINI_INTERFACE.INTERFACE.StRankingList;
import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import acfp;
import aekv;
import afzj;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import anlm;
import aqbn;
import aqnm;
import aqqx;
import aute;
import auvj;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.cache.MiniCacheFreeManager;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.BaseExposureReport;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.CardModuleExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.MiniAppModuleExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.MiniAppRedDotExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.TianShuExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppGroupInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppModuleInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.DataChangeListener;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDittoInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopEmptyGuideInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopEmptyInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopFriendsPkModuleInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopPopularModuleInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopRecommendModuleInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopSearchInfo;
import com.tencent.mobileqq.mini.entry.desktop.widget.DesktopDittoAreaView;
import com.tencent.mobileqq.mini.entry.desktop.widget.DragAdapter;
import com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView;
import com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView.DragDeleteListener;
import com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView.OnItemChangeListener;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class MiniAppDesktopAdapter
  extends DragAdapter
  implements MiniAppDesktopLayout.DesktopChangeListener, DesktopDataManager.DataChangeListener, DragRecyclerView.OnItemChangeListener
{
  private static final String DEVELOP = acfp.m(2131708361);
  private static final long DRAG_INSERT_DURA = 200L;
  private static final String EXPERIENCE = acfp.m(2131708370);
  public static final int REFER_CONTACTS = 1;
  public static final int REFER_CONVERSATION = 0;
  public static final int REFER_LEBA = 2;
  private static final String TAG = "MiniAppDesktopAdapter";
  private static final int TYPE_MIMI_APP_SPECIAL = 3;
  private static final int TYPE_MINI_APP_NORMAL = 1;
  private static final int TYPE_MINI_APP_TOP = 2;
  int currDragMoveLeft;
  int currDragMoveTop;
  boolean isDesktopOpened;
  int lastDragLeft;
  int lastDragMoveLeft;
  int lastDragMoveTop;
  int lastDragTop;
  private WeakReference<Activity> mActivity;
  private OnAnimationListener mAnimListener;
  private boolean mCanShowRedDot;
  private Context mContext;
  private boolean mDeletePrepared;
  private RecyclerView.ViewHolder mDragViewHolder;
  private IntertItemRunnable mInsertItemRunnable = new IntertItemRunnable(null);
  private int mIntertFrom = -1;
  private int mIntertTarget = -1;
  private Handler mMainHandler = new Handler(Looper.getMainLooper());
  private MoveItemRunnable mMoveItemRunnable = new MoveItemRunnable(null);
  private List<MiniAppInfo> mOrigData = new ArrayList();
  private Map<String, Integer> mRedDotData = new HashMap();
  private int mRedDotSwitchState;
  private int mRefer = 0;
  private GridLayoutManager.SpanSizeLookup mSpanSizeLookup;
  private Vibrator mVibrator;
  private int startDragX;
  private int startDragY;
  
  public MiniAppDesktopAdapter(Activity paramActivity, int paramInt, DragRecyclerView paramDragRecyclerView)
  {
    super(paramActivity.getApplicationContext(), paramDragRecyclerView);
    this.mContext = paramActivity.getApplicationContext();
    this.mActivity = new WeakReference(paramActivity);
    this.mRefer = paramInt;
    this.mSpanSizeLookup = new MiniAppDesktopAdapter.1(this);
    registerAdapterDataObserver(new MiniAppDesktopAdapter.2(this));
    this.mirrorZoomAnimation.setFillAfter(true);
    this.mirrorZoomAnimation.setDuration(200L);
    this.mirrorRevertAnimation.setDuration(200L);
    DittoUIEngine.g().init(this.mContext, new DesktopLog());
  }
  
  private void collectAdReport(ImageView paramImageView, TextView paramTextView, MiniAppInfo paramMiniAppInfo, int paramInt)
  {
    paramImageView.addOnAttachStateChangeListener(new MiniAppDesktopAdapter.5(this, paramMiniAppInfo, paramInt));
    paramTextView.addOnAttachStateChangeListener(new MiniAppDesktopAdapter.6(this, paramMiniAppInfo, paramInt));
  }
  
  private void deleteMiniApp(MiniAppInfo paramMiniAppInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MiniAppDesktopAdapter", 2, "deleteMiniApp, delete miniAppInfo: " + paramMiniAppInfo.toString());
    }
    Object localObject = (Activity)this.mActivity.get();
    if (localObject == null) {
      return;
    }
    ((Activity)localObject).getResources();
    localObject = (BaseActivity)localObject;
    MiniAppUserAppInfoListManager localMiniAppUserAppInfoListManager = (MiniAppUserAppInfoListManager)((BaseActivity)localObject).app.getManager(309);
    if (localMiniAppUserAppInfoListManager != null) {
      localMiniAppUserAppInfoListManager.sendDelUserAppRequest(paramMiniAppInfo);
    }
    MiniCacheFreeManager.freeCache(((BaseActivity)localObject).app.getCurrentUin(), paramMiniAppInfo);
  }
  
  private void doVibrate()
  {
    try
    {
      if (this.mVibrator == null) {
        this.mVibrator = ((Vibrator)this.mContext.getSystemService("vibrator"));
      }
      this.mVibrator.vibrate(50L);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniAppDesktopAdapter", 1, "exception when doVibrate.", localThrowable);
    }
  }
  
  private void gdtAdReport()
  {
    try
    {
      ((DesktopDataManager)MiniAppUtils.getAppInterface().getManager(336)).miniAppAdReport();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MiniAppDesktopAdapter", 1, "gdtAdReport, exception: " + Log.getStackTraceString(localException));
    }
  }
  
  private int getRedDotCount(String paramString)
  {
    paramString = (Integer)this.mRedDotData.get(paramString);
    if (paramString != null) {
      return paramString.intValue();
    }
    return 0;
  }
  
  private boolean isSameModule(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= getItemCount()) || (paramInt2 < 0) || (paramInt2 >= getItemCount())) {
      return false;
    }
    DesktopItemInfo localDesktopItemInfo1 = (DesktopItemInfo)this.mData.get(paramInt1);
    DesktopItemInfo localDesktopItemInfo2 = (DesktopItemInfo)this.mData.get(paramInt2);
    return localDesktopItemInfo1.mModuleType == localDesktopItemInfo2.mModuleType;
  }
  
  private void setAnimationListener(OnAnimationListener paramOnAnimationListener)
  {
    this.mAnimListener = paramOnAnimationListener;
  }
  
  private void setTopMiniApp(MiniAppInfo paramMiniAppInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MiniAppDesktopAdapter", 2, "setTopMiniApp, miniAppInfo: " + paramMiniAppInfo.toString());
    }
    Object localObject = (Activity)this.mActivity.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = (MiniAppUserAppInfoListManager)((BaseActivity)localObject).app.getManager(309);
    } while (localObject == null);
    if (paramMiniAppInfo.topType == 0)
    {
      paramMiniAppInfo.topType = 1;
      paramMiniAppInfo.updateTimeStamp();
    }
    for (;;)
    {
      ((MiniAppUserAppInfoListManager)localObject).sendSetUserAppTopRequest(paramMiniAppInfo);
      return;
      paramMiniAppInfo.topType = 0;
    }
  }
  
  protected void doUpdateHolder(MicroAppViewHolder paramMicroAppViewHolder, DesktopAppInfo paramDesktopAppInfo, int paramInt)
  {
    paramMicroAppViewHolder.desktopAppInfo = paramDesktopAppInfo;
    paramMicroAppViewHolder.itemView.setVisibility(0);
    if (paramDesktopAppInfo.isTemp)
    {
      paramMicroAppViewHolder.imageView.setImageResource(2130841781);
      paramMicroAppViewHolder.textView.setVisibility(4);
      paramMicroAppViewHolder.versionTypeMark.setVisibility(4);
      paramMicroAppViewHolder.recommendBadge.setVisibility(4);
      paramMicroAppViewHolder.redDot.setVisibility(4);
      return;
    }
    MiniAppInfo localMiniAppInfo = paramDesktopAppInfo.mMiniAppInfo;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (((localMiniAppInfo.motionPics == null) || (localMiniAppInfo.motionPics.size() <= 0)) && (!TextUtils.isEmpty(localMiniAppInfo.apngUrl)))
    {
      paramMicroAppViewHolder.anpgImagView.setVisibility(0);
      localObject1 = paramMicroAppViewHolder.anpgImagView;
      localObject2 = localMiniAppInfo.apngUrl;
      localObject3 = new ColorDrawable(Color.parseColor("#00000000"));
      ((ImageView)localObject1).setImageDrawable(aqqx.a((String)localObject2, new int[] { 32 }, (Drawable)localObject3));
      paramMicroAppViewHolder.imageView.setImageDrawable(MiniAppUtils.getIcon(this.mContext, localMiniAppInfo.iconUrl, true));
      paramMicroAppViewHolder.textView.setVisibility(0);
      paramMicroAppViewHolder.textView.setText(localMiniAppInfo.name);
      paramMicroAppViewHolder.setMiniAppInfo(localMiniAppInfo);
      paramMicroAppViewHolder.setModuleType(paramDesktopAppInfo.getModuleType());
      if (!localMiniAppInfo.isSpecialMiniApp()) {
        break label981;
      }
      paramMicroAppViewHolder.itemView.setTag(Integer.valueOf(3));
      label228:
      if ((localMiniAppInfo.verType != 0) && (localMiniAppInfo.verType != 4)) {
        break label1018;
      }
      paramMicroAppViewHolder.versionTypeMark.setVisibility(0);
      paramMicroAppViewHolder.versionTypeMark.setText(DEVELOP);
      label263:
      if (paramDesktopAppInfo.getModuleType() != 2) {
        break label1071;
      }
      paramMicroAppViewHolder.recommendBadge.setVisibility(0);
      if (TextUtils.isEmpty(localMiniAppInfo.recommendAppIconUrl)) {
        break label1060;
      }
      paramMicroAppViewHolder.recommendBadge.setImageDrawable(MiniAppUtils.getDrawable(localMiniAppInfo.recommendAppIconUrl, null));
      label306:
      if ((!TextUtils.isEmpty(localMiniAppInfo.amsAdInfo)) && (!paramDesktopAppInfo.isFromCache())) {
        collectAdReport(paramMicroAppViewHolder.imageView, paramMicroAppViewHolder.textView, localMiniAppInfo, paramInt);
      }
      label339:
      localObject1 = (Integer)this.mRedDotData.get(localMiniAppInfo.appId);
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppDesktopAdapter", 2, "onBindViewHolder, canShowRedDot: " + this.mCanShowRedDot + ", redDotNum : " + localObject1 + ", name : " + localMiniAppInfo.name + ", mRedDotSwitchState: " + this.mRedDotSwitchState);
      }
      if ((!this.mCanShowRedDot) || (this.mRedDotSwitchState != 1) || (localObject1 == null) || (((Integer)localObject1).intValue() <= 0)) {
        break label1083;
      }
      paramMicroAppViewHolder.redDot.setVisibility(0);
      aute.updateCustomNoteTxt(paramMicroAppViewHolder.redDot, 7, ((Integer)localObject1).intValue(), 0);
      label482:
      if (paramDesktopAppInfo.getModuleType() != 1) {
        break label1095;
      }
      paramInt = 3001;
    }
    for (;;)
    {
      label494:
      localObject3 = MiniAppUtils.getAppInterface();
      localObject1 = null;
      if (localObject3 != null)
      {
        localObject2 = (MiniAppExposureManager)((AppInterface)localObject3).getManager(322);
        localObject1 = (DesktopDataManager)((AppInterface)localObject3).getManager(336);
      }
      for (;;)
      {
        if (localObject2 != null)
        {
          localObject3 = new MiniAppConfig(localMiniAppInfo);
          ((MiniAppConfig)localObject3).launchParam.scene = paramInt;
          paramInt = getRedDotCount(localMiniAppInfo.appId);
          MiniAppExposureManager.MiniAppModuleExposureData localMiniAppModuleExposureData = new MiniAppExposureManager.MiniAppModuleExposureData((MiniAppConfig)localObject3, "page_view", "expo");
          MiniAppExposureManager.MiniAppRedDotExposureData localMiniAppRedDotExposureData = new MiniAppExposureManager.MiniAppRedDotExposureData((MiniAppConfig)localObject3, "page_view", "expo_scene", paramInt);
          localObject3 = null;
          if (localMiniAppInfo.tianshuAdId > 0) {
            localObject3 = new MiniAppExposureManager.TianShuExposureData("tianshu.78", "tianshu.78", String.valueOf(localMiniAppInfo.tianshuAdId), 101);
          }
          Object localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(localMiniAppInfo.appId).append("_").append(localMiniAppInfo.verType).append("_").append(paramDesktopAppInfo.getModuleType());
          localObject4 = ((StringBuilder)localObject4).toString();
          ((MiniAppExposureManager)localObject2).putReportDataToMap((String)localObject4, localMiniAppModuleExposureData);
          ((MiniAppExposureManager)localObject2).putReportDataToMap((String)localObject4 + "_redDot", localMiniAppRedDotExposureData);
          if (localObject3 != null) {
            ((MiniAppExposureManager)localObject2).putReportDataToMap((String)localObject4 + "_tianshu", (MiniAppExposureManager.BaseExposureReport)localObject3);
          }
        }
        if ((localObject1 != null) && (paramDesktopAppInfo.getModuleType() == 2) && (!paramDesktopAppInfo.mMiniAppInfo.isSpecialMiniApp())) {
          ((DesktopDataManager)localObject1).updateRecommendExposureNumber(paramDesktopAppInfo.mMiniAppInfo.appId);
        }
        if (paramMicroAppViewHolder.textView != null) {
          paramMicroAppViewHolder.textView.setTextColor(BaseApplicationImpl.getContext().getResources().getColor(2131167311));
        }
        if ((paramMicroAppViewHolder.imageView instanceof ThemeImageView))
        {
          ((ThemeImageView)paramMicroAppViewHolder.imageView).setSupportMaskView(true);
          paramMicroAppViewHolder.imageView.setBackgroundDrawable(null);
        }
        if ((localMiniAppInfo.motionPics != null) && (localMiniAppInfo.motionPics.size() > 0))
        {
          setAnimationListener(paramMicroAppViewHolder);
          paramDesktopAppInfo = localMiniAppInfo.motionPics.iterator();
          for (;;)
          {
            if (paramDesktopAppInfo.hasNext())
            {
              localObject1 = (String)paramDesktopAppInfo.next();
              localObject2 = new ImageView(this.mContext);
              ((ImageView)localObject2).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
              ((ImageView)localObject2).setImageDrawable(MiniAppUtils.getIcon(this.mContext, (String)localObject1, true));
              ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER);
              paramMicroAppViewHolder.viewFlipper.addView((View)localObject2);
              continue;
              paramMicroAppViewHolder.anpgImagView.setVisibility(8);
              break;
              label981:
              if (localMiniAppInfo.topType == 1)
              {
                paramMicroAppViewHolder.itemView.setTag(Integer.valueOf(2));
                break label228;
              }
              paramMicroAppViewHolder.itemView.setTag(Integer.valueOf(1));
              break label228;
              label1018:
              if (localMiniAppInfo.verType == 1)
              {
                paramMicroAppViewHolder.versionTypeMark.setVisibility(0);
                paramMicroAppViewHolder.versionTypeMark.setText(EXPERIENCE);
                break label263;
              }
              paramMicroAppViewHolder.versionTypeMark.setVisibility(8);
              break label263;
              label1060:
              paramMicroAppViewHolder.recommendBadge.setImageDrawable(null);
              break label306;
              label1071:
              paramMicroAppViewHolder.recommendBadge.setVisibility(8);
              break label339;
              label1083:
              paramMicroAppViewHolder.redDot.setVisibility(8);
              break label482;
              label1095:
              if (paramDesktopAppInfo.getModuleType() == 2)
              {
                paramInt = 3002;
                break label494;
              }
              if (paramDesktopAppInfo.getModuleType() != 3) {
                break label1174;
              }
              paramInt = 3003;
              break label494;
            }
          }
          paramMicroAppViewHolder.picCount = localMiniAppInfo.motionPics.size();
        }
        paramMicroAppViewHolder.itemView.setOnClickListener(new MiniAppDesktopAdapter.3(this));
        paramMicroAppViewHolder.itemView.setOnLongClickListener(new MiniAppDesktopAdapter.4(this));
        return;
        localObject2 = null;
      }
      label1174:
      paramInt = 9999;
    }
  }
  
  public int getItemCount()
  {
    return this.mData.size();
  }
  
  public MiniAppInfo getItemForPosition(int paramInt)
  {
    return null;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mData.size())) {}
    do
    {
      return 3;
      if ((this.mData.get(paramInt) instanceof DesktopAppModuleInfo)) {
        return 1;
      }
      if ((this.mData.get(paramInt) instanceof DesktopAppGroupInfo)) {
        return 6;
      }
    } while ((this.mData.get(paramInt) instanceof DesktopEmptyInfo));
    if ((this.mData.get(paramInt) instanceof DesktopEmptyGuideInfo)) {
      return 4;
    }
    if ((this.mData.get(paramInt) instanceof DesktopSearchInfo)) {
      return 5;
    }
    if ((this.mData.get(paramInt) instanceof DesktopRecommendModuleInfo)) {
      return 8;
    }
    if ((this.mData.get(paramInt) instanceof DesktopPopularModuleInfo)) {
      return 9;
    }
    if ((this.mData.get(paramInt) instanceof DesktopFriendsPkModuleInfo)) {
      return 10;
    }
    if ((this.mData.get(paramInt) instanceof DesktopDittoInfo)) {
      return 11;
    }
    return 2;
  }
  
  public Map<String, Integer> getRedDotDataMap()
  {
    return this.mRedDotData;
  }
  
  public GridLayoutManager.SpanSizeLookup getSpanSizeLookup()
  {
    return this.mSpanSizeLookup;
  }
  
  public boolean isItemDeleteable(int paramInt)
  {
    if (paramInt < 0) {
      return false;
    }
    return ((DesktopItemInfo)this.mData.get(paramInt)).deleteEnable;
  }
  
  public boolean isItemDragable(int paramInt)
  {
    if (paramInt < 0) {
      return false;
    }
    return ((DesktopItemInfo)this.mData.get(paramInt)).dragEnable;
  }
  
  public boolean isItemDropable(int paramInt)
  {
    if (paramInt < 0) {
      return false;
    }
    return ((DesktopItemInfo)this.mData.get(paramInt)).dropEnable;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.mData.size() <= 0) {
      QLog.e("MiniAppDesktopAdapter", 1, "[MiniAppUserAppInfoListManager].onBindViewHolder, size = " + this.mData.size());
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      switch (getItemViewType(paramInt))
      {
      case 3: 
      case 7: 
      default: 
        break;
      case 1: 
        ((ModuleViewHolder)paramViewHolder).update((DesktopAppModuleInfo)this.mData.get(paramInt));
        break;
      case 2: 
        updateHolder((MicroAppViewHolder)paramViewHolder, (DesktopAppInfo)this.mData.get(paramInt), paramInt);
        break;
      case 4: 
        ((ModuleGuideViewHolder)paramViewHolder).update();
        break;
      case 5: 
        ((SearchViewHolder)paramViewHolder).update((DesktopSearchInfo)this.mData.get(paramInt));
        break;
      case 6: 
        ((DesktopModuleListViewHolder)paramViewHolder).bindView((DesktopAppGroupInfo)this.mData.get(paramInt), 0);
        break;
      case 8: 
        ((RecommendModuleViewHolder)paramViewHolder).bindView((Activity)this.mActivity.get(), (DesktopRecommendModuleInfo)this.mData.get(paramInt));
        break;
      case 10: 
        ((FriendsPkViewHolder)paramViewHolder).bindView((Activity)this.mActivity.get(), (DesktopFriendsPkModuleInfo)this.mData.get(paramInt));
        break;
      case 9: 
        PopularityListModuleViewHolder localPopularityListModuleViewHolder = (PopularityListModuleViewHolder)paramViewHolder;
        DesktopPopularModuleInfo localDesktopPopularModuleInfo = (DesktopPopularModuleInfo)this.mData.get(paramInt);
        Activity localActivity = (Activity)this.mActivity.get();
        if (localActivity != null) {
          localPopularityListModuleViewHolder.update(localDesktopPopularModuleInfo, localActivity);
        }
        break;
      case 11: 
        ((DittoViewHolder)paramViewHolder).bindView((DesktopDittoInfo)this.mData.get(paramInt));
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    case 7: 
    default: 
      return null;
    case 1: 
      return new ModuleViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562582, paramViewGroup, false), (Activity)this.mActivity.get());
    case 2: 
      return new MicroAppViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562580, paramViewGroup, false));
    case 3: 
      return new MicroAppViewHolder(new View(paramViewGroup.getContext()));
    case 4: 
      return new ModuleGuideViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559584, paramViewGroup, false));
    case 5: 
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559587, paramViewGroup, false);
      return new SearchViewHolder(this.mActivity, paramViewGroup);
    case 6: 
      return new DesktopModuleListViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559583, paramViewGroup, false), this.mContext, this.mRecyclerView.getDragDeleteListener());
    case 8: 
      return new RecommendModuleViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559586, paramViewGroup, false));
    case 9: 
      return new PopularityListModuleViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559585, paramViewGroup, false));
    case 10: 
      return new FriendsPkViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559581, paramViewGroup, false));
    }
    return new DittoViewHolder(new DesktopDittoAreaView((Context)this.mActivity.get()));
  }
  
  public void onCustomMove(RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    int i = 0;
    RecyclerView.ViewHolder localViewHolder;
    if (i < getItemCount())
    {
      localViewHolder = this.mRecyclerView.findViewHolderForAdapterPosition(i);
      if ((localViewHolder != null) && ((localViewHolder instanceof MicroAppViewHolder))) {}
    }
    for (;;)
    {
      i += 1;
      break;
      int j = ((View)localViewHolder.itemView.getParent()).getLeft();
      int k = ((View)localViewHolder.itemView.getParent()).getTop();
      int m = localViewHolder.itemView.getLeft();
      int n = localViewHolder.itemView.getTop();
      if ((Math.abs(paramInt1 - (j + m)) <= aqnm.dpToPx(20.0F)) && (Math.abs(paramInt2 - (k + n)) <= aqnm.dpToPx(20.0F)))
      {
        if (this.mMoveItemRunnable.pendingMoveTargetIndex == i) {
          return;
        }
        QLog.i("XXX", 1, "target:" + i);
        this.mMainHandler.removeCallbacks(this.mInsertItemRunnable);
        this.mInsertItemRunnable.setMoveAction((MicroAppViewHolder)paramViewHolder, i);
        this.mMainHandler.postDelayed(this.mInsertItemRunnable, 200L);
      }
    }
  }
  
  public void onDataChanged()
  {
    setData(((DesktopDataManager)MiniAppUtils.getAppInterface().getManager(336)).getData());
  }
  
  public void onDesktopClosed()
  {
    this.isDesktopOpened = false;
    QLog.d("MiniAppDesktopAdapter", 2, "onDesktopClosed");
  }
  
  public void onDesktopOpened()
  {
    this.isDesktopOpened = true;
    QLog.d("MiniAppDesktopAdapter", 2, "onDesktopOpened");
    gdtAdReport();
  }
  
  public void onDesktopResume()
  {
    QLog.d("MiniAppDesktopAdapter", 2, "onDesktopResume");
    ThreadManager.getUIHandler().postDelayed(new MiniAppDesktopAdapter.7(this), 300L);
  }
  
  public void onDragFinish(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.onDragFinish(paramViewHolder, paramInt);
  }
  
  public void onItemDelete(int paramInt)
  {
    super.onItemDelete(paramInt);
  }
  
  public void onItemDraw(RecyclerView.ViewHolder paramViewHolder, float paramFloat1, float paramFloat2)
  {
    for (;;)
    {
      try
      {
        Object localObject;
        if ((this.mDragMirrorLayout != null) && (this.mDragMirrorImage != null) && (this.mDragViewHolder != null))
        {
          localObject = this.mDragViewHolder;
          if (localObject != paramViewHolder) {}
        }
        try
        {
          j = ((View)paramViewHolder.itemView.getParent()).getLeft();
          i = ((View)paramViewHolder.itemView.getParent()).getTop();
          localObject = (FrameLayout.LayoutParams)this.mDragMirrorLayout.getLayoutParams();
          k = paramViewHolder.itemView.getLeft();
          j = (int)paramFloat1 + (j + k);
          i = paramViewHolder.itemView.getTop() + i + (int)paramFloat2 - aqnm.dpToPx(8.0F);
          this.currDragMoveLeft = j;
          this.currDragMoveTop = i;
          ((FrameLayout.LayoutParams)localObject).setMargins(j, i, 0, 0);
          this.mDragMirrorLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        catch (Throwable paramViewHolder)
        {
          try
          {
            if (this.mIntertTarget < 0)
            {
              paramViewHolder = this.mRecyclerView.findViewHolderForAdapterPosition(getItemCount() - 1);
              if ((paramViewHolder != null) && (Math.abs(j - paramViewHolder.itemView.getLeft()) >= aqnm.dpToPx(20.0F)) && (i - paramViewHolder.itemView.getTop() >= aqnm.dpToPx(30.0F)))
              {
                paramViewHolder = (DesktopItemInfo)this.mData.get(getItemCount() - 1);
                if ((paramViewHolder.dropEnable) && (!paramViewHolder.isTemp) && (!isSameModule(this.mDragIndex, getItemCount() - 1)))
                {
                  QLog.i("MiniAppDesktopAdapter", 1, "Desktop-Drag into tail blank area from:" + this.mDragIndex);
                  localObject = (DesktopAppInfo)this.mData.get(this.mDragIndex);
                  new DesktopAppInfo(paramViewHolder.mModuleType, ((DesktopAppInfo)localObject).mMiniAppInfo).setIsTemp(true);
                  this.lastDragMoveLeft = j;
                  this.lastDragMoveTop = i;
                  this.mMainHandler.removeCallbacks(this.mMoveItemRunnable);
                  this.mMoveItemRunnable.setMoveTailAction(this.mDragIndex);
                  this.mMainHandler.postDelayed(this.mMoveItemRunnable, 200L);
                }
              }
            }
            return;
          }
          catch (Throwable paramViewHolder)
          {
            int j;
            int i;
            int k;
            QLog.e("MiniAppDesktopAdapter", 1, paramViewHolder, new Object[0]);
          }
          paramViewHolder = paramViewHolder;
          paramViewHolder = (FrameLayout.LayoutParams)this.mDragMirrorLayout.getLayoutParams();
          this.currDragMoveLeft = ((int)(this.currDragMoveLeft + paramFloat1));
          this.currDragMoveTop = ((int)(this.currDragMoveTop + paramFloat2));
          j = this.currDragMoveLeft;
          i = this.currDragMoveTop;
          paramViewHolder.setMargins(this.currDragMoveLeft, this.currDragMoveTop, 0, 0);
          this.mDragMirrorLayout.setLayoutParams(paramViewHolder);
          continue;
        }
        if (this.mIntertTarget > 0)
        {
          k = 1;
          if ((k != 0) && (this.mDragMirrorMarkImage != null)) {
            this.mDragMirrorMarkImage.setVisibility(0);
          }
          if ((Math.abs(j - this.lastDragLeft) > aqnm.dpToPx(25.0F)) || (Math.abs(i - this.lastDragTop) > aqnm.dpToPx(25.0F)))
          {
            QLog.i("MiniAppDesktopAdapter", 1, "Desktop-Drag DragMirror left:" + j + " top:" + i);
            this.lastDragLeft = j;
            this.lastDragTop = i;
          }
        }
        k = 0;
      }
      catch (Throwable paramViewHolder)
      {
        QLog.e("MiniAppDesktopAdapter", 1, "onItemDraw exception!", paramViewHolder);
        return;
      }
    }
  }
  
  public void onItemMoved(int paramInt1, int paramInt2)
  {
    int j = -1;
    if ((this.mMoveItemRunnable.moveFromIndex == paramInt1) && (this.mMoveItemRunnable.pendingMoveTargetIndex == paramInt2)) {}
    label220:
    label240:
    for (;;)
    {
      return;
      int i;
      if (this.mDragMirrorLayout != null)
      {
        i = this.mDragMirrorLayout.getLeft();
        if (this.mDragMirrorLayout == null) {
          break label220;
        }
        j = this.mDragMirrorLayout.getTop();
      }
      for (;;)
      {
        if ((Math.abs(j - this.lastDragMoveLeft) <= aqnm.dpToPx(20.0F)) && (Math.abs(j - this.lastDragMoveTop) <= aqnm.dpToPx(20.0F))) {
          break label240;
        }
        this.lastDragMoveLeft = i;
        this.lastDragMoveTop = j;
        QLog.i("MiniAppDesktopAdapter", 1, "Desktop-Drag Moved from " + paramInt1 + " target " + paramInt2 + " dragPos:" + this.mDragViewHolder.getAdapterPosition());
        this.mMainHandler.removeCallbacks(this.mMoveItemRunnable);
        this.mMoveItemRunnable.setMoveAction(paramInt1, paramInt2);
        this.mMainHandler.postDelayed(this.mMoveItemRunnable, 200L);
        return;
        if (this.mDragViewHolder != null)
        {
          i = this.mDragViewHolder.itemView.getLeft();
          break;
        }
        i = -1;
        break;
        if (this.mDragViewHolder != null) {
          j = this.mDragViewHolder.itemView.getTop();
        }
      }
    }
  }
  
  public void onItemPrepared(int paramInt)
  {
    super.onItemPrepared(paramInt);
  }
  
  public void setData(List<DesktopItemInfo> paramList)
  {
    this.mData.clear();
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniAppDesktopAdapter", 2, "updateData. data = " + paramList);
      }
      return;
    }
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      Object localObject;
      if ((paramList.get(i) instanceof DesktopAppGroupInfo))
      {
        localObject = (DesktopAppGroupInfo)paramList.get(i);
        if (((DesktopAppGroupInfo)localObject).datas != null)
        {
          int j = ((DesktopAppGroupInfo)localObject).datas.size() - 1;
          while (j >= 0)
          {
            DesktopAppInfo localDesktopAppInfo = (DesktopAppInfo)((DesktopAppGroupInfo)localObject).datas.get(j);
            if ((localDesktopAppInfo != null) && (localDesktopAppInfo.isTemp)) {
              ((DesktopAppGroupInfo)localObject).datas.remove(j);
            }
            j -= 1;
          }
        }
      }
      else if ((paramList.get(i) instanceof DesktopAppInfo))
      {
        localObject = (DesktopAppInfo)paramList.get(i);
        if ((localObject != null) && (((DesktopAppInfo)localObject).isTemp)) {
          paramList.remove(i);
        }
      }
      i -= 1;
    }
    this.mData.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void setData(List<DesktopItemInfo> paramList, Map<String, Integer> paramMap)
  {
    this.mData.clear();
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniAppDesktopAdapter", 2, "updateData. data = " + paramList);
      }
      return;
    }
    this.mData.addAll(paramList);
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
  
  public void updateHolder(MicroAppViewHolder paramMicroAppViewHolder, DesktopAppInfo paramDesktopAppInfo, int paramInt)
  {
    doUpdateHolder(paramMicroAppViewHolder, paramDesktopAppInfo, paramInt);
  }
  
  public class DesktopModuleListViewHolder
    extends RecyclerView.ViewHolder
  {
    protected MiniAppAdapter mAdapter;
    protected DesktopAppGroupInfo mModuleInfo;
    protected DragRecyclerView mRecycleView;
    
    public DesktopModuleListViewHolder(View paramView, Context paramContext, DragRecyclerView.DragDeleteListener paramDragDeleteListener)
    {
      super();
      this.mRecycleView = ((DragRecyclerView)paramView.findViewById(2131376994));
      MiniAppDesktopAdapter.this.mRecyclerView.addChildDragRecycleView(this.mRecycleView);
      this.mAdapter = new MiniAppAdapter(paramContext, this.mRecycleView);
      this.mAdapter.setParentRecyclerView(MiniAppDesktopAdapter.this.mRecyclerView);
      this.mRecycleView.setAdapter(this.mAdapter);
      this.mRecycleView.setDragChangeListener(this.mAdapter);
      this.mRecycleView.setDragDeleteListener(paramDragDeleteListener);
      this.mAdapter.setDragMirrorView(MiniAppDesktopAdapter.this.mDragMirrorLayout);
      this.mAdapter.registerAdapterDataObserver(new MiniAppDesktopAdapter.DesktopModuleListViewHolder.1(this, MiniAppDesktopAdapter.this));
      paramView = new afzj(MiniAppDesktopAdapter.this.mContext, 0, false);
      paramView.setAutoMeasureEnabled(true);
      this.mRecycleView.setLayoutManager(paramView);
      this.mRecycleView.addOnScrollListener(new MiniAppDesktopAdapter.DesktopModuleListViewHolder.2(this, MiniAppDesktopAdapter.this));
    }
    
    private void updateOrigDataList()
    {
      if ((this.mAdapter == null) || (this.mAdapter.origList == null)) {}
      for (;;)
      {
        return;
        List localList = this.mAdapter.getData();
        this.mAdapter.origList.clear();
        int i = 0;
        while (i < localList.size())
        {
          DesktopItemInfo localDesktopItemInfo = (DesktopItemInfo)localList.get(i);
          if ((localDesktopItemInfo instanceof DesktopAppInfo)) {
            this.mAdapter.origList.add((DesktopAppInfo)localDesktopItemInfo);
          }
          i += 1;
        }
      }
    }
    
    public void bindView(DesktopAppGroupInfo paramDesktopAppGroupInfo, int paramInt)
    {
      if (paramDesktopAppGroupInfo == null) {
        return;
      }
      this.mModuleInfo = paramDesktopAppGroupInfo;
      this.mAdapter.setData(paramDesktopAppGroupInfo.datas);
      if (this.mModuleInfo.getModuleType() == 3)
      {
        this.mRecycleView.setAutoScrollEnable(true);
        return;
      }
      this.mRecycleView.setAutoScrollEnable(false);
    }
    
    public void update() {}
    
    public class MiniAppAdapter
      extends DragAdapter
    {
      private DragAdapter mMoveTargetAdapter;
      public List<DesktopAppInfo> origList;
      
      public MiniAppAdapter(Context paramContext, DragRecyclerView paramDragRecyclerView)
      {
        super(paramDragRecyclerView);
      }
      
      public void doDragMove(int paramInt1, int paramInt2)
      {
        super.doDragMove(paramInt1, paramInt2 - this.mRecyclerView.getTop());
      }
      
      public int getDragParentLeft(RecyclerView.ViewHolder paramViewHolder)
      {
        int i = ((View)paramViewHolder.itemView.getParent()).getLeft();
        return ((View)paramViewHolder.itemView.getParent().getParent()).getLeft() + i;
      }
      
      public int getDragParentTop(RecyclerView.ViewHolder paramViewHolder)
      {
        int i = ((View)paramViewHolder.itemView.getParent()).getTop();
        return ((View)paramViewHolder.itemView.getParent().getParent()).getTop() + i;
      }
      
      public int getItemCount()
      {
        return this.mData.size();
      }
      
      public boolean isItemDeleteable(int paramInt)
      {
        if ((paramInt < 0) || (paramInt >= this.mData.size())) {
          return false;
        }
        return ((DesktopItemInfo)this.mData.get(paramInt)).deleteEnable;
      }
      
      public boolean isItemDragable(int paramInt)
      {
        if ((paramInt < 0) || (paramInt >= this.mData.size())) {
          return false;
        }
        return ((DesktopItemInfo)this.mData.get(paramInt)).dragEnable;
      }
      
      public boolean isItemDropable(int paramInt)
      {
        if ((paramInt < 0) || (paramInt >= this.mData.size())) {
          return false;
        }
        return ((DesktopItemInfo)this.mData.get(paramInt)).dropEnable;
      }
      
      public boolean isMoveToDeleteArea(int paramInt1, int paramInt2)
      {
        return MiniAppDesktopAdapter.DesktopModuleListViewHolder.this.mRecycleView.getTop() + paramInt2 >= MiniAppDesktopAdapter.this.mRecyclerView.getBottom() - aqnm.dip2px(60.0F);
      }
      
      public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
      {
        updateHolder((MiniAppDesktopAdapter.MicroAppViewHolder)paramViewHolder, (DesktopAppInfo)this.mData.get(paramInt), paramInt);
        EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      }
      
      public MiniAppDesktopAdapter.MicroAppViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
      {
        return new MiniAppDesktopAdapter.MicroAppViewHolder(LayoutInflater.from(MiniAppDesktopAdapter.this.mContext).inflate(2131562580, paramViewGroup, false));
      }
      
      public void onDragFinish(RecyclerView.ViewHolder paramViewHolder, int paramInt)
      {
        if ((isDragCancel()) || (this.mDeleteTarget >= 0)) {}
        for (boolean bool = true;; bool = false)
        {
          MiniAppDesktopAdapter.this.setOutsideDragCancel(bool);
          MiniAppDesktopAdapter.this.onDragFinish(paramViewHolder, paramInt);
          if (this.mMoveTargetAdapter != null)
          {
            this.mMoveTargetAdapter.setOutsideDragCancel(bool);
            this.mMoveTargetAdapter.onDragFinish(paramViewHolder, paramInt);
            this.mMoveTargetAdapter = null;
          }
          super.onDragFinish(paramViewHolder, paramInt);
          return;
        }
      }
      
      public void onDragMove(int paramInt1, int paramInt2)
      {
        if (paramInt2 >= 0) {}
        for (;;)
        {
          try
          {
            if (paramInt2 > this.mRecyclerView.getBottom() - this.mRecyclerView.getTop())
            {
              this.mRecyclerView.stopAutoScroll();
              int i;
              if (paramInt1 > 0)
              {
                i = paramInt1;
                localObject1 = MiniAppDesktopAdapter.this.mRecyclerView.findChildViewUnder(i, MiniAppDesktopAdapter.DesktopModuleListViewHolder.this.mRecycleView.getTop() + paramInt2);
                if ((localObject1 == null) || (!(localObject1 instanceof DragRecyclerView))) {
                  break label386;
                }
                localObject1 = MiniAppDesktopAdapter.this.mRecyclerView.getChildViewHolder((View)localObject1);
                if (!(localObject1 instanceof MiniAppDesktopAdapter.DesktopModuleListViewHolder)) {
                  break label386;
                }
                localObject1 = ((MiniAppDesktopAdapter.DesktopModuleListViewHolder)localObject1).mAdapter;
                if ((localObject1 != null) && (((MiniAppAdapter)localObject1).isDropable()))
                {
                  if (this.mMoveTargetAdapter != null) {
                    this.mMoveTargetAdapter.setDragAppInfo(-1, -1, -1, -1, 0, null);
                  }
                  this.mMoveTargetAdapter = ((DragAdapter)localObject1);
                  this.mMoveTargetAdapter.setOutsideDragCancel(false);
                  DesktopAppInfo localDesktopAppInfo = (DesktopAppInfo)this.mData.get(this.mDragIndex);
                  i = ((MiniAppAdapter)localObject1).mRecyclerView.getTop();
                  int j = this.mRecyclerView.getTop();
                  ((MiniAppAdapter)localObject1).setDragAppInfo(this.startDragX, this.startDragY, this.moveStartX, this.moveStartY, i - j, localDesktopAppInfo);
                  ((MiniAppAdapter)localObject1).onDragMove(paramInt1, this.mRecyclerView.getTop() + paramInt2 - ((MiniAppAdapter)localObject1).mRecyclerView.getTop());
                }
              }
              else
              {
                i = aqnm.dip2px(30.0F) + paramInt1;
                continue;
              }
              Object localObject1 = (DesktopAppInfo)this.mData.get(this.mDragIndex);
              MiniAppDesktopAdapter.this.setDragAppInfo(this.startDragX, this.startDragY, this.moveStartX, this.moveStartY, 0, (DesktopAppInfo)localObject1);
              MiniAppDesktopAdapter.this.onDragMove(paramInt1, paramInt2);
              if (this.mMoveTargetAdapter == null) {
                break;
              }
              this.mMoveTargetAdapter.setOutsideDragCancel(true);
              return;
            }
          }
          catch (Throwable localThrowable)
          {
            QLog.e("MiniAppDesktopAdapter", 1, "onDragMove exception!", localThrowable);
            return;
          }
          if (this.mMoveTargetAdapter != null) {
            this.mMoveTargetAdapter.setOutsideDragCancel(true);
          }
          MiniAppDesktopAdapter.this.setDragAppInfo(-1, -1, -1, -1, 0, null);
          super.onDragMove(paramInt1, paramInt2);
          return;
          label386:
          Object localObject2 = null;
        }
      }
      
      public void onItemDelete(int paramInt)
      {
        MiniAppDesktopAdapter.this.setOutsideDragCancel(true);
        if (this.mMoveTargetAdapter != null) {
          this.mMoveTargetAdapter.setOutsideDragCancel(true);
        }
        DesktopAppInfo localDesktopAppInfo = (DesktopAppInfo)this.mData.get(paramInt);
        this.mDeleteTarget = paramInt;
        super.onItemDelete(paramInt);
        ((DesktopDataManager)MiniAppUtils.getAppInterface().getManager(336)).onItemDeleted(localDesktopAppInfo);
      }
      
      public void setData(List<DesktopAppInfo> paramList)
      {
        if (paramList != null)
        {
          this.mData.clear();
          this.mData.addAll(paramList);
          this.origList = paramList;
          notifyDataSetChanged();
        }
      }
      
      public void updateHolder(MiniAppDesktopAdapter.MicroAppViewHolder paramMicroAppViewHolder, DesktopAppInfo paramDesktopAppInfo, int paramInt)
      {
        MiniAppDesktopAdapter.this.doUpdateHolder(paramMicroAppViewHolder, paramDesktopAppInfo, paramInt);
      }
    }
  }
  
  static class DittoViewHolder
    extends RecyclerView.ViewHolder
  {
    public DittoViewHolder(View paramView)
    {
      super();
    }
    
    public void bindView(DesktopDittoInfo paramDesktopDittoInfo)
    {
      String str = paramDesktopDittoInfo.dittoDls;
      if ((!TextUtils.isEmpty(str)) && ((this.itemView instanceof DesktopDittoAreaView)))
      {
        DesktopDittoAreaView localDesktopDittoAreaView = (DesktopDittoAreaView)this.itemView;
        localDesktopDittoAreaView.setContentAreaForJsonFile(str, true);
        localDesktopDittoAreaView.setDittoData(paramDesktopDittoInfo);
        this.itemView.setPadding(0, aqnm.dpToPx(20.0F), 0, 0);
        localDesktopDittoAreaView.handleExposureReport();
      }
    }
  }
  
  static class FriendsPkViewHolder
    extends RecyclerView.ViewHolder
  {
    private final ImageView mBackground;
    private final ImageView mMoreIcon;
    private final ImageView mPkButton;
    private final ArrayList<Item> mRanking = new ArrayList();
    private final TextView mTitle;
    private final ImageView mTitleIcon;
    private final TextView mTopAppDesc;
    private final ImageView mTopAppIcon;
    private final TextView mTopAppName;
    
    public FriendsPkViewHolder(View paramView)
    {
      super();
      this.mBackground = ((ImageView)paramView.findViewById(2131371584));
      this.mTitleIcon = ((ImageView)paramView.findViewById(2131371593));
      this.mTitle = ((TextView)paramView.findViewById(2131371592));
      this.mMoreIcon = ((ImageView)paramView.findViewById(2131371594));
      this.mPkButton = ((ImageView)paramView.findViewById(2131371586));
      this.mTopAppIcon = ((ImageView)paramView.findViewById(2131371595));
      this.mTopAppName = ((TextView)paramView.findViewById(2131371598));
      this.mTopAppDesc = ((TextView)paramView.findViewById(2131371597));
      this.mRanking.add(new Item(paramView.findViewById(2131371588)));
      this.mRanking.add(new Item(paramView.findViewById(2131371589)));
      this.mRanking.add(new Item(paramView.findViewById(2131371590)));
      this.mRanking.add(new Item(paramView.findViewById(2131371591)));
      ((Item)this.mRanking.get(0)).mCrown.setVisibility(0);
      ((Item)this.mRanking.get(3)).setOutOfRankStyle();
    }
    
    public void bindView(Activity paramActivity, DesktopFriendsPkModuleInfo paramDesktopFriendsPkModuleInfo)
    {
      Object localObject1 = paramDesktopFriendsPkModuleInfo.moduleInfo;
      Object localObject2 = paramDesktopFriendsPkModuleInfo.ranking;
      Object localObject3 = URLDrawable.URLDrawableOptions.obtain();
      Drawable localDrawable = this.itemView.getContext().getResources().getDrawable(2130849265);
      ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = false;
      try
      {
        this.mBackground.setImageDrawable(MiniAppUtils.getDrawable(((INTERFACE.StModuleInfo)localObject1).backgroundPic.get(), (URLDrawable.URLDrawableOptions)localObject3));
        MiniAppUtils.setImage(this.mTitleIcon, ((INTERFACE.StModuleInfo)localObject1).titleIcon.get());
        this.mTitle.setText(((INTERFACE.StModuleInfo)localObject1).title.get());
        MiniAppUtils.setImage(this.mPkButton, ((INTERFACE.StFriendRanking)localObject2).animationPic.get());
        this.mTopAppName.setText(((INTERFACE.StFriendRanking)localObject2).gameInfo.appInfo.appName.get());
        this.mTopAppIcon.setImageDrawable(MiniAppUtils.getIcon(this.itemView.getContext(), ((INTERFACE.StFriendRanking)localObject2).gameInfo.appInfo.icon.get(), true));
        this.mTopAppDesc.setText(((INTERFACE.StFriendRanking)localObject2).friendsNum.get() + acfp.m(2131708372));
        int i = 0;
        int j;
        for (;;)
        {
          j = i;
          if (i >= ((INTERFACE.StFriendRanking)localObject2).rankingList.size()) {
            break;
          }
          j = i;
          if (i >= this.mRanking.size()) {
            break;
          }
          ((Item)this.mRanking.get(i)).setData((INTERFACE.StRankingList)((INTERFACE.StFriendRanking)localObject2).rankingList.get(i));
          i += 1;
        }
        while (j < this.mRanking.size())
        {
          ((Item)this.mRanking.get(j)).gone();
          j += 1;
        }
        MiniAppUtils.setJump(paramActivity, this.mMoreIcon, paramDesktopFriendsPkModuleInfo.jumpMoreInfo, 3009);
        MiniAppUtils.setJump(paramActivity, this.itemView, paramDesktopFriendsPkModuleInfo.appInfo, 3009);
        paramActivity = MiniAppUtils.getAppInterface();
        if (paramActivity != null)
        {
          paramActivity = (MiniAppExposureManager)paramActivity.getManager(322);
          if (paramActivity != null)
          {
            localObject1 = new MiniAppConfig(paramDesktopFriendsPkModuleInfo.appInfo);
            ((MiniAppConfig)localObject1).launchParam.scene = 3009;
            localObject1 = new MiniAppExposureManager.MiniAppModuleExposureData((MiniAppConfig)localObject1, "page_view", "expo");
            localObject2 = new MiniAppExposureManager.CardModuleExposureData("desktop", "pk", "expo", null);
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(paramDesktopFriendsPkModuleInfo.appInfo.appId).append("_").append(paramDesktopFriendsPkModuleInfo.appInfo.verType).append("_").append(paramDesktopFriendsPkModuleInfo.getModuleType());
            paramActivity.putReportDataToMap(((StringBuilder)localObject3).toString(), (MiniAppExposureManager.BaseExposureReport)localObject1);
            paramActivity.putReportDataToMap("pk", (MiniAppExposureManager.BaseExposureReport)localObject2);
          }
          return;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          continue;
          paramActivity = null;
        }
      }
    }
    
    class Item
    {
      final View mContainer;
      final ImageView mCrown;
      final ImageView mIcon;
      final TextView mName;
      final TextView mRanking;
      final TextView mScore;
      final TextView mUnit;
      
      Item(View paramView)
      {
        this.mContainer = paramView;
        this.mIcon = ((ImageView)paramView.findViewById(2131371600));
        this.mCrown = ((ImageView)paramView.findViewById(2131371601));
        this.mName = ((TextView)paramView.findViewById(2131371603));
        this.mRanking = ((TextView)paramView.findViewById(2131371604));
        this.mScore = ((TextView)paramView.findViewById(2131371605));
        this.mUnit = ((TextView)paramView.findViewById(2131371596));
      }
      
      public void gone()
      {
        this.mContainer.setVisibility(8);
      }
      
      public void setData(INTERFACE.StRankingList paramStRankingList)
      {
        this.mContainer.setVisibility(0);
        try
        {
          Object localObject = MiniAppDesktopAdapter.FriendsPkViewHolder.this.itemView.getResources().getDrawable(2130840645);
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
          localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
          int i = aqnm.dip2px(30.0F);
          localURLDrawableOptions.mRequestHeight = i;
          localURLDrawableOptions.mRequestWidth = i;
          localObject = URLDrawable.getDrawable(paramStRankingList.avatar.get(), localURLDrawableOptions);
          ((URLDrawable)localObject).setTag(aqbn.e(aqnm.dip2px(30.0F), aqnm.dip2px(30.0F)));
          ((URLDrawable)localObject).setDecodeHandler(aqbn.o);
          this.mIcon.setImageDrawable((Drawable)localObject);
          label104:
          this.mName.setText(paramStRankingList.nick.get());
          this.mScore.setText("" + paramStRankingList.score.get());
          this.mUnit.setText(paramStRankingList.unit.get());
          this.mRanking.setText(paramStRankingList.ranks.get() + "");
          return;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          break label104;
        }
      }
      
      public void setOutOfRankStyle()
      {
        this.mRanking.setTextColor(-1605504);
        this.mRanking.setTypeface(Typeface.create("sans-serif-condensed", 2));
        this.mRanking.setScaleX(0.8F);
      }
    }
  }
  
  class IntertItemRunnable
    implements Runnable
  {
    public MiniAppDesktopAdapter.MicroAppViewHolder fromVh;
    public int moveTargetIndex = -1;
    public int oldMoveTargetIndex = -1;
    public int pendingMoveTargetIndex = -1;
    
    private IntertItemRunnable() {}
    
    public void reset()
    {
      this.fromVh = null;
      this.moveTargetIndex = -1;
      this.oldMoveTargetIndex = -1;
      this.pendingMoveTargetIndex = -1;
    }
    
    public void run()
    {
      if ((this.fromVh == null) || (this.pendingMoveTargetIndex < 0)) {}
      while ((this.pendingMoveTargetIndex == this.moveTargetIndex) || (MiniAppDesktopAdapter.this.mDeletePrepared)) {
        return;
      }
      this.moveTargetIndex = this.pendingMoveTargetIndex;
      QLog.i("MiniAppDesktopAdapter", 1, "XXX Desktop-Drag MoveReady1 from:" + this.fromVh + " target:" + this.moveTargetIndex + " oldTarget:" + this.oldMoveTargetIndex);
      int i = this.moveTargetIndex;
      MiniAppDesktopAdapter.access$302(MiniAppDesktopAdapter.this, i);
      MiniAppDesktopAdapter.this.doVibrate();
      DesktopAppInfo localDesktopAppInfo1 = this.fromVh.desktopAppInfo;
      if (i >= MiniAppDesktopAdapter.this.getItemCount())
      {
        QLog.i("MiniAppDesktopAdapter", 1, "XXX Desktop-Drag OP_INSERT_BLANK1 from:" + MiniAppDesktopAdapter.this.mDragIndex + " target:" + MiniAppDesktopAdapter.this.getItemCount());
        localDesktopAppInfo1 = new DesktopAppInfo(3, localDesktopAppInfo1.mMiniAppInfo);
        localDesktopAppInfo1.setIsTemp(true);
        MiniAppDesktopAdapter.this.mData.add(i, localDesktopAppInfo1);
        this.oldMoveTargetIndex = (MiniAppDesktopAdapter.this.mData.size() - 1);
        MiniAppDesktopAdapter.this.notifyItemInserted(i);
        return;
      }
      DesktopAppInfo localDesktopAppInfo2 = (DesktopAppInfo)MiniAppDesktopAdapter.this.mData.get(i);
      QLog.i("MiniAppDesktopAdapter", 1, "XXX Desktop-Drag OP_INSERT1 from:" + MiniAppDesktopAdapter.this.mDragIndex + " target:" + i);
      if (localDesktopAppInfo2.isTemp)
      {
        QLog.i("MiniAppDesktopAdapter", 1, "XXX Desktop-Drag OP_INSERT1 insert into temp item, invalid!");
        this.oldMoveTargetIndex = i;
        return;
      }
      localDesktopAppInfo1 = new DesktopAppInfo(localDesktopAppInfo2.mModuleType, localDesktopAppInfo1.mMiniAppInfo);
      localDesktopAppInfo1.setIsTemp(true);
      MiniAppDesktopAdapter.this.mData.add(i, localDesktopAppInfo1);
      this.oldMoveTargetIndex = i;
      MiniAppDesktopAdapter.this.notifyItemInserted(i);
    }
    
    public void setMoveAction(MiniAppDesktopAdapter.MicroAppViewHolder paramMicroAppViewHolder, int paramInt)
    {
      this.fromVh = paramMicroAppViewHolder;
      this.pendingMoveTargetIndex = paramInt;
    }
    
    public void setMoveTailAction(MiniAppDesktopAdapter.MicroAppViewHolder paramMicroAppViewHolder)
    {
      this.fromVh = paramMicroAppViewHolder;
      this.pendingMoveTargetIndex = MiniAppDesktopAdapter.this.getItemCount();
    }
  }
  
  public static class MicroAppViewHolder
    extends RecyclerView.ViewHolder
    implements MiniAppDesktopAdapter.OnAnimationListener
  {
    ImageView anpgImagView;
    DesktopAppInfo desktopAppInfo;
    ImageView imageView;
    boolean isPlayAnim;
    MiniAppInfo miniAppInfo;
    int moduleType;
    int picCount;
    ImageView recommendBadge;
    TextView redDot;
    TextView textView;
    TextView versionTypeMark;
    ViewFlipper viewFlipper;
    
    public MicroAppViewHolder(View paramView)
    {
      super();
      try
      {
        ViewGroup localViewGroup = (ViewGroup)paramView.findViewById(2131371612);
        int i = (int)((aqnm.getScreenWidth() - aqnm.dip2px(10.0F)) / 4.5F);
        LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)localViewGroup.getLayoutParams();
        LinearLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
        if (localLayoutParams2 == null) {
          localLayoutParams1 = new LinearLayout.LayoutParams(i, -2);
        }
        localLayoutParams1.width = i;
        localViewGroup.setLayoutParams(localLayoutParams1);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("MiniAppDesktopAdapter", 1, localThrowable, new Object[0]);
        }
      }
      this.imageView = ((ImageView)paramView.findViewById(2131371822));
      if ((this.imageView instanceof ThemeImageView)) {
        ((ThemeImageView)this.imageView).setMaskShape(auvj.euM);
      }
      this.textView = ((TextView)paramView.findViewById(2131371823));
      this.versionTypeMark = ((TextView)paramView.findViewById(2131371824));
      this.recommendBadge = ((ImageView)paramView.findViewById(2131371676));
      this.viewFlipper = ((ViewFlipper)paramView.findViewById(2131371716));
      this.anpgImagView = ((ImageView)paramView.findViewById(2131371714));
      this.redDot = ((TextView)paramView.findViewById(2131371681));
    }
    
    private void startSwitchAnimation()
    {
      QLog.d("MiniAppDesktopAdapter", 1, "[mini_app_anim].startSwitchAnimation, picCount = " + this.picCount + ", isPlayAnim: " + this.isPlayAnim);
      this.viewFlipper.setVisibility(0);
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
      localTranslateAnimation.setDuration(700L);
      localTranslateAnimation.setInterpolator(new MiniAppDesktopAdapter.SpringTranslationInterpolator(0.4F));
      this.viewFlipper.setInAnimation(localTranslateAnimation);
      localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F);
      localTranslateAnimation.setDuration(100L);
      localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
      this.viewFlipper.setOutAnimation(localTranslateAnimation);
      this.viewFlipper.setFlipInterval(2200);
      this.viewFlipper.startFlipping();
    }
    
    public void setMiniAppInfo(MiniAppInfo paramMiniAppInfo)
    {
      this.miniAppInfo = paramMiniAppInfo;
    }
    
    public void setModuleType(int paramInt)
    {
      this.moduleType = paramInt;
    }
    
    public void startAnimation()
    {
      if ((this.miniAppInfo.motionPics != null) && (this.miniAppInfo.motionPics.size() > 0))
      {
        this.isPlayAnim = true;
        Drawable localDrawable = MiniAppUtils.getIcon(this.imageView.getContext(), this.miniAppInfo.appStoreAnimPicUrl, true, 2130841825, 48);
        this.imageView.setImageDrawable(localDrawable);
        this.imageView.invalidate();
        QLog.d("MiniAppDesktopAdapter", 1, "[mini_app_anim].startAnimation, picCount = " + this.picCount + ", pic Url = " + this.miniAppInfo.appStoreAnimPicUrl + ", drawable = " + localDrawable + ", appId: " + this.miniAppInfo.appId);
        startSwitchAnimation();
      }
    }
    
    public void stopAnimation()
    {
      QLog.d("MiniAppDesktopAdapter", 1, "[mini_app_anim].stopAnimation, isPlayAnim: " + this.isPlayAnim);
      if (!this.isPlayAnim) {
        return;
      }
      this.isPlayAnim = false;
      this.viewFlipper.stopFlipping();
      this.imageView.setImageDrawable(MiniAppUtils.getIcon(this.imageView.getContext(), this.miniAppInfo.iconUrl, true));
      this.viewFlipper.setVisibility(8);
    }
  }
  
  public static class ModuleGuideViewHolder
    extends RecyclerView.ViewHolder
  {
    private RelativeLayout emptyGuideLayout;
    private TextView emptyGuideTextView;
    
    public ModuleGuideViewHolder(View paramView)
    {
      super();
      this.emptyGuideLayout = ((RelativeLayout)paramView.findViewById(2131371575));
      this.emptyGuideTextView = ((TextView)paramView.findViewById(2131371576));
    }
    
    public void update()
    {
      if (MiniAppUtils.getAppInterface() != null)
      {
        if (this.emptyGuideLayout != null) {
          this.emptyGuideLayout.setBackgroundResource(2130841781);
        }
        if (this.emptyGuideTextView != null) {
          this.emptyGuideTextView.setTextColor(BaseApplicationImpl.getContext().getResources().getColor(2131167383));
        }
      }
    }
  }
  
  static class ModuleViewHolder
    extends RecyclerView.ViewHolder
  {
    private WeakReference<Activity> mActivityReference;
    private MiniAppInfo mAppStoreInfo;
    private TextView mModuleText;
    private ImageView mMoreMiniApp;
    
    public ModuleViewHolder(View paramView, Activity paramActivity)
    {
      super();
      this.mActivityReference = new WeakReference(paramActivity);
      this.mModuleText = ((TextView)paramView.findViewById(2131371620));
      this.mMoreMiniApp = ((ImageView)paramView.findViewById(2131371619));
    }
    
    public void update(DesktopAppModuleInfo paramDesktopAppModuleInfo)
    {
      this.mModuleText.setText(paramDesktopAppModuleInfo.moduleTitle);
      AppInterface localAppInterface = MiniAppUtils.getAppInterface();
      if (localAppInterface != null)
      {
        this.mModuleText.setTextColor(BaseApplicationImpl.getContext().getResources().getColor(2131167383));
        this.mMoreMiniApp.setImageResource(2130851155);
      }
      int j = paramDesktopAppModuleInfo.getModuleType();
      if ((j == 1) || (j == 2))
      {
        int i;
        if (paramDesktopAppModuleInfo.appStoreInfo != null)
        {
          this.mAppStoreInfo = paramDesktopAppModuleInfo.appStoreInfo;
          this.mMoreMiniApp.setVisibility(0);
          paramDesktopAppModuleInfo = new MiniAppConfig(paramDesktopAppModuleInfo.appStoreInfo);
          Object localObject = paramDesktopAppModuleInfo.launchParam;
          if (j == 1)
          {
            i = 3005;
            ((LaunchParam)localObject).scene = i;
            localObject = new MiniAppExposureManager.MiniAppModuleExposureData(paramDesktopAppModuleInfo, "page_view", "expo");
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.mAppStoreInfo.appId).append("_").append(this.mAppStoreInfo.verType).append("_").append(j).append("_").append(paramDesktopAppModuleInfo.launchParam.scene);
            paramDesktopAppModuleInfo = localStringBuilder.toString();
            ((MiniAppExposureManager)localAppInterface.getManager(322)).putReportDataToMap(paramDesktopAppModuleInfo, (MiniAppExposureManager.BaseExposureReport)localObject);
          }
        }
        for (;;)
        {
          this.mMoreMiniApp.setOnClickListener(new MiniAppDesktopAdapter.ModuleViewHolder.1(this, j));
          return;
          i = 3004;
          break;
          this.mMoreMiniApp.setVisibility(8);
        }
      }
      this.mMoreMiniApp.setVisibility(8);
    }
  }
  
  class MoveItemRunnable
    implements Runnable
  {
    public int moveFromIndex = -1;
    public int moveTargetIndex = -1;
    public int oldMoveTargetIndex = -1;
    public int pendingMoveTargetIndex = -1;
    
    private MoveItemRunnable() {}
    
    public void reset()
    {
      this.moveFromIndex = -1;
      this.moveTargetIndex = -1;
      this.oldMoveTargetIndex = -1;
    }
    
    public void run()
    {
      if ((this.moveFromIndex < 0) || (this.pendingMoveTargetIndex < 0)) {}
      while ((this.pendingMoveTargetIndex == this.moveTargetIndex) || (MiniAppDesktopAdapter.this.mDeletePrepared)) {
        return;
      }
      this.moveTargetIndex = this.pendingMoveTargetIndex;
      QLog.i("MiniAppDesktopAdapter", 1, "Desktop-Drag MoveReady from:" + this.moveFromIndex + " target:" + this.moveTargetIndex + " oldTarget:" + this.oldMoveTargetIndex);
      int i = this.moveFromIndex;
      int k = this.moveTargetIndex;
      MiniAppDesktopAdapter.access$1102(MiniAppDesktopAdapter.this, i);
      MiniAppDesktopAdapter.access$302(MiniAppDesktopAdapter.this, k);
      MiniAppDesktopAdapter.this.doVibrate();
      DesktopAppInfo localDesktopAppInfo1 = (DesktopAppInfo)MiniAppDesktopAdapter.this.mData.get(i);
      if (k >= MiniAppDesktopAdapter.this.getItemCount())
      {
        QLog.i("MiniAppDesktopAdapter", 1, "Desktop-Drag OP_INSERT_BLANK from:" + MiniAppDesktopAdapter.this.mDragIndex + " target:" + MiniAppDesktopAdapter.this.getItemCount());
        localDesktopAppInfo1 = new DesktopAppInfo(3, localDesktopAppInfo1.mMiniAppInfo);
        localDesktopAppInfo1.setIsTemp(true);
        MiniAppDesktopAdapter.this.mData.add(k, localDesktopAppInfo1);
        this.oldMoveTargetIndex = (MiniAppDesktopAdapter.this.mData.size() - 1);
        MiniAppDesktopAdapter.this.notifyItemInserted(k);
        return;
      }
      DesktopAppInfo localDesktopAppInfo2 = (DesktopAppInfo)MiniAppDesktopAdapter.this.mData.get(k);
      if (localDesktopAppInfo1.mModuleType == localDesktopAppInfo2.mModuleType)
      {
        QLog.i("MiniAppDesktopAdapter", 1, "Desktop-Drag OP_SWAP from:" + i + " target:" + k);
        if (i < k)
        {
          j = i;
          while (j < k)
          {
            Collections.swap(MiniAppDesktopAdapter.this.mData, j, j + 1);
            j += 1;
          }
        }
        int j = i;
        while (j > k)
        {
          Collections.swap(MiniAppDesktopAdapter.this.mData, j, j - 1);
          j -= 1;
        }
        MiniAppDesktopAdapter.this.notifyItemMoved(i, k);
        this.oldMoveTargetIndex = 0;
        return;
      }
      if (this.oldMoveTargetIndex > 0)
      {
        if (this.oldMoveTargetIndex < k)
        {
          i = this.oldMoveTargetIndex;
          while (i < k)
          {
            Collections.swap(MiniAppDesktopAdapter.this.mData, i, i + 1);
            i += 1;
          }
        }
        i = this.oldMoveTargetIndex;
        while (i > k)
        {
          Collections.swap(MiniAppDesktopAdapter.this.mData, i, i - 1);
          i -= 1;
        }
        QLog.i("MiniAppDesktopAdapter", 1, "Desktop-Drag OP_SWAP fromOld:" + this.oldMoveTargetIndex + " target:" + k);
        MiniAppDesktopAdapter.this.notifyItemMoved(this.oldMoveTargetIndex, k);
        this.oldMoveTargetIndex = k;
        return;
      }
      QLog.i("MiniAppDesktopAdapter", 1, "Desktop-Drag OP_INSERT from:" + i + " target:" + k);
      if (localDesktopAppInfo2.isTemp)
      {
        QLog.i("MiniAppDesktopAdapter", 1, "Desktop-Drag OP_INSERT insert into temp item, invalid!");
        this.oldMoveTargetIndex = k;
        return;
      }
      localDesktopAppInfo1 = new DesktopAppInfo(localDesktopAppInfo2.mModuleType, localDesktopAppInfo1.mMiniAppInfo);
      localDesktopAppInfo1.setIsTemp(true);
      MiniAppDesktopAdapter.this.mData.add(k, localDesktopAppInfo1);
      this.oldMoveTargetIndex = k;
      MiniAppDesktopAdapter.this.notifyItemInserted(k);
    }
    
    public void setMoveAction(int paramInt1, int paramInt2)
    {
      this.moveFromIndex = paramInt1;
      this.pendingMoveTargetIndex = paramInt2;
    }
    
    public void setMoveTailAction(int paramInt)
    {
      this.moveFromIndex = paramInt;
      this.pendingMoveTargetIndex = MiniAppDesktopAdapter.this.getItemCount();
    }
  }
  
  static abstract interface OnAnimationListener
  {
    public abstract void startAnimation();
    
    public abstract void stopAnimation();
  }
  
  static class PopularityListModuleViewHolder
    extends RecyclerView.ViewHolder
    implements View.OnClickListener
  {
    private WeakReference<Activity> activityWeakRef;
    private ImageView firstAppIconImg;
    private ImageView firstAppOpenImg;
    private TextView firstAppTitleTv;
    private ImageView moreAppImg;
    private MiniAppInfo moreAppInfo;
    private DesktopPopularModuleInfo popularModuleInfo;
    private View rootView;
    private ImageView secondAppIconImg;
    private ImageView secondAppOpenImg;
    private TextView secondAppTitleTv;
    private ImageView thirdAppIconImg;
    private ImageView thirdAppOpenImg;
    private TextView thirdAppTitleTv;
    private ImageView titleIconImg;
    private TextView titleTv;
    
    public PopularityListModuleViewHolder(View paramView)
    {
      super();
      this.rootView = paramView.findViewById(2131371659);
      this.titleIconImg = ((ImageView)paramView.findViewById(2131371667));
      this.titleTv = ((TextView)paramView.findViewById(2131371666));
      this.moreAppImg = ((ImageView)paramView.findViewById(2131371658));
      this.firstAppIconImg = ((ImageView)paramView.findViewById(2131371655));
      this.secondAppIconImg = ((ImageView)paramView.findViewById(2131371660));
      this.thirdAppIconImg = ((ImageView)paramView.findViewById(2131371663));
      this.firstAppTitleTv = ((TextView)paramView.findViewById(2131371657));
      this.secondAppTitleTv = ((TextView)paramView.findViewById(2131371662));
      this.thirdAppTitleTv = ((TextView)paramView.findViewById(2131371665));
      this.firstAppOpenImg = ((ImageView)paramView.findViewById(2131371656));
      this.secondAppOpenImg = ((ImageView)paramView.findViewById(2131371661));
      this.thirdAppOpenImg = ((ImageView)paramView.findViewById(2131371664));
      this.firstAppIconImg.setOnClickListener(this);
      this.secondAppIconImg.setOnClickListener(this);
      this.thirdAppIconImg.setOnClickListener(this);
      this.firstAppOpenImg.setOnClickListener(this);
      this.secondAppOpenImg.setOnClickListener(this);
      this.thirdAppOpenImg.setOnClickListener(this);
      this.moreAppImg.setOnClickListener(this);
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
        Object localObject;
        Activity localActivity;
        try
        {
          if (this.popularModuleInfo.popularAppList.size() <= 2) {
            break label179;
          }
          MiniAppInfo localMiniAppInfo1 = (MiniAppInfo)this.popularModuleInfo.popularAppList.get(0);
          localObject = new LaunchParam();
          ((LaunchParam)localObject).scene = 3010;
          localActivity = (Activity)this.activityWeakRef.get();
          if ((localActivity == null) || (localMiniAppInfo1 == null)) {
            continue;
          }
          MiniAppController.launchMiniAppByAppInfo(localActivity, localMiniAppInfo1, (LaunchParam)localObject);
        }
        catch (Exception localException1)
        {
          QLog.e("MiniAppDesktopAdapter", 1, "PopularityListModuleViewHolder, exception:" + Log.getStackTraceString(localException1));
        }
        continue;
        label179:
        QLog.e("MiniAppDesktopAdapter", 1, "PopularityListModuleViewHolder, size : " + this.popularModuleInfo.popularAppList.size());
        continue;
        try
        {
          if (this.popularModuleInfo.popularAppList.size() <= 2) {
            break label325;
          }
          MiniAppInfo localMiniAppInfo2 = (MiniAppInfo)this.popularModuleInfo.popularAppList.get(1);
          localObject = new LaunchParam();
          ((LaunchParam)localObject).scene = 3010;
          localActivity = (Activity)this.activityWeakRef.get();
          if (localActivity == null) {
            continue;
          }
          MiniAppController.launchMiniAppByAppInfo(localActivity, localMiniAppInfo2, (LaunchParam)localObject);
        }
        catch (Exception localException2)
        {
          QLog.e("MiniAppDesktopAdapter", 1, "PopularityListModuleViewHolder, exception:" + Log.getStackTraceString(localException2));
        }
        continue;
        label325:
        QLog.e("MiniAppDesktopAdapter", 1, "PopularityListModuleViewHolder, size : " + this.popularModuleInfo.popularAppList.size());
        continue;
        try
        {
          if (this.popularModuleInfo.popularAppList.size() <= 2) {
            break label471;
          }
          MiniAppInfo localMiniAppInfo3 = (MiniAppInfo)this.popularModuleInfo.popularAppList.get(2);
          localObject = new LaunchParam();
          ((LaunchParam)localObject).scene = 3010;
          localActivity = (Activity)this.activityWeakRef.get();
          if (localActivity == null) {
            continue;
          }
          MiniAppController.launchMiniAppByAppInfo(localActivity, localMiniAppInfo3, (LaunchParam)localObject);
        }
        catch (Exception localException3)
        {
          QLog.e("MiniAppDesktopAdapter", 1, "PopularityListModuleViewHolder, exception:" + Log.getStackTraceString(localException3));
        }
        continue;
        label471:
        QLog.e("MiniAppDesktopAdapter", 1, "PopularityListModuleViewHolder, size : " + this.popularModuleInfo.popularAppList.size());
        continue;
        LaunchParam localLaunchParam = new LaunchParam();
        localLaunchParam.scene = 3010;
        try
        {
          localObject = (Activity)this.activityWeakRef.get();
          if ((localObject != null) && (this.moreAppInfo != null)) {
            MiniAppController.launchMiniAppByAppInfo((Activity)localObject, this.moreAppInfo, localLaunchParam);
          }
        }
        catch (MiniAppException localMiniAppException)
        {
          localMiniAppException.printStackTrace();
        }
      }
    }
    
    public void update(DesktopPopularModuleInfo paramDesktopPopularModuleInfo, Activity paramActivity)
    {
      int i = 0;
      this.activityWeakRef = new WeakReference(paramActivity);
      List localList = paramDesktopPopularModuleInfo.popularAppList;
      if (!TextUtils.isEmpty(paramDesktopPopularModuleInfo.titleIconUrl)) {
        this.titleIconImg.setImageDrawable(MiniAppUtils.getDrawable(paramDesktopPopularModuleInfo.titleIconUrl, null));
      }
      if (!TextUtils.isEmpty(paramDesktopPopularModuleInfo.title)) {
        this.titleTv.setText(paramDesktopPopularModuleInfo.title);
      }
      paramActivity = URLDrawable.URLDrawableOptions.obtain();
      Object localObject = this.itemView.getContext().getResources().getDrawable(2130849265);
      paramActivity.mFailedDrawable = ((Drawable)localObject);
      paramActivity.mLoadingDrawable = ((Drawable)localObject);
      paramActivity.mPlayGifImage = false;
      this.rootView.setBackgroundDrawable(MiniAppUtils.getDrawable(paramDesktopPopularModuleInfo.backgroundUrl, paramActivity));
      this.moreAppInfo = paramDesktopPopularModuleInfo.moreAppInfo;
      this.popularModuleInfo = paramDesktopPopularModuleInfo;
      if ((localList != null) && (localList.size() > 2))
      {
        this.firstAppIconImg.setImageDrawable(MiniAppUtils.getIcon(this.firstAppIconImg.getContext(), ((MiniAppInfo)localList.get(0)).iconUrl, true));
        this.firstAppTitleTv.setText(((MiniAppInfo)localList.get(0)).name);
        this.secondAppIconImg.setImageDrawable(MiniAppUtils.getIcon(this.firstAppIconImg.getContext(), ((MiniAppInfo)localList.get(1)).iconUrl, true));
        this.secondAppTitleTv.setText(((MiniAppInfo)localList.get(1)).name);
        this.thirdAppIconImg.setImageDrawable(MiniAppUtils.getIcon(this.firstAppIconImg.getContext(), ((MiniAppInfo)localList.get(2)).iconUrl, true));
        this.thirdAppTitleTv.setText(((MiniAppInfo)localList.get(2)).name);
        paramActivity = MiniAppUtils.getAppInterface();
        if (paramActivity == null) {
          break label490;
        }
      }
      label490:
      for (paramActivity = (MiniAppExposureManager)paramActivity.getManager(322);; paramActivity = null)
      {
        if (paramActivity != null)
        {
          while ((i < localList.size()) && (i < 3))
          {
            localObject = new MiniAppConfig((MiniAppInfo)localList.get(i));
            ((MiniAppConfig)localObject).launchParam.scene = 3010;
            MiniAppExposureManager.MiniAppModuleExposureData localMiniAppModuleExposureData = new MiniAppExposureManager.MiniAppModuleExposureData((MiniAppConfig)localObject, "page_view", "expo");
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(((MiniAppConfig)localObject).config.appId).append("_").append(((MiniAppConfig)localObject).config.verType).append("_").append(paramDesktopPopularModuleInfo.getModuleType());
            paramActivity.putReportDataToMap(localStringBuilder.toString(), localMiniAppModuleExposureData);
            i += 1;
          }
          paramActivity.putReportDataToMap("ranking", new MiniAppExposureManager.CardModuleExposureData("desktop", "ranking", "expo", null));
        }
        return;
      }
    }
  }
  
  static class RecommendModuleViewHolder
    extends RecyclerView.ViewHolder
  {
    private final List<ImageView> mApps = new ArrayList();
    private final ImageView mBackGroundImage;
    private final TextView mRecommendDesc;
    private final TextView mRecommendNumber;
    private final TextView mTitle;
    private final ImageView mTitleIcon;
    
    public RecommendModuleViewHolder(View paramView)
    {
      super();
      this.mBackGroundImage = ((ImageView)paramView.findViewById(2131371674));
      this.mTitleIcon = ((ImageView)paramView.findViewById(2131371679));
      this.mTitle = ((TextView)paramView.findViewById(2131371678));
      this.mRecommendNumber = ((TextView)paramView.findViewById(2131371677));
      this.mRecommendDesc = ((TextView)paramView.findViewById(2131371675));
      this.mApps.add(paramView.findViewById(2131371668));
      this.mApps.add(paramView.findViewById(2131371669));
      this.mApps.add(paramView.findViewById(2131371670));
      this.mApps.add(paramView.findViewById(2131371671));
      this.mApps.add(paramView.findViewById(2131371672));
    }
    
    public void bindView(Activity paramActivity, DesktopRecommendModuleInfo paramDesktopRecommendModuleInfo)
    {
      INTERFACE.StModuleInfo localStModuleInfo = paramDesktopRecommendModuleInfo.moduleInfo;
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        Drawable localDrawable = this.itemView.getContext().getResources().getDrawable(2130849265);
        localURLDrawableOptions.mFailedDrawable = localDrawable;
        localURLDrawableOptions.mLoadingDrawable = localDrawable;
        this.mBackGroundImage.setImageDrawable(MiniAppUtils.getDrawable(localStModuleInfo.backgroundPic.get(), localURLDrawableOptions));
        label62:
        MiniAppUtils.setImage(this.mTitleIcon, localStModuleInfo.titleIcon.get());
        this.mTitle.setText(localStModuleInfo.title.get());
        this.mRecommendNumber.setText(localStModuleInfo.appTotalNum.get() + "");
        this.mRecommendDesc.setText(localStModuleInfo.desc.get());
        int i = 0;
        int j;
        for (;;)
        {
          j = i;
          if (i >= this.mApps.size()) {
            break;
          }
          j = i;
          if (i >= localStModuleInfo.userAppList.size()) {
            break;
          }
          ((ImageView)this.mApps.get(i)).setVisibility(0);
          ((ImageView)this.mApps.get(i)).setImageDrawable(MiniAppUtils.getIcon(this.itemView.getContext(), ((INTERFACE.StUserAppInfo)localStModuleInfo.userAppList.get(i)).appInfo.icon.get(), true));
          i += 1;
        }
        while (j < this.mApps.size())
        {
          ((ImageView)this.mApps.get(j)).setImageDrawable(null);
          ((ImageView)this.mApps.get(j)).setVisibility(4);
          j += 1;
        }
        MiniAppUtils.setJump(paramActivity, this.itemView, paramDesktopRecommendModuleInfo.jumpMoreInfo, 3008);
        paramActivity = MiniAppUtils.getAppInterface();
        if (paramActivity != null) {
          ((MiniAppExposureManager)paramActivity.getManager(322)).putReportDataToMap("featured", new MiniAppExposureManager.CardModuleExposureData("desktop", "featured", "expo", null));
        }
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        break label62;
      }
    }
  }
  
  static class SearchViewHolder
    extends RecyclerView.ViewHolder
  {
    private View container;
    private TextView keywordTv;
    private DesktopSearchInfo searchInfo;
    
    public SearchViewHolder(WeakReference<Activity> paramWeakReference, View paramView)
    {
      super();
      this.keywordTv = ((TextView)paramView.findViewById(2131371690));
      this.container = paramView.findViewById(2131371686);
      this.container.setPadding(0, 0, 0, 0);
      paramView.setOnClickListener(new MiniAppDesktopAdapter.SearchViewHolder.1(this, paramWeakReference));
    }
    
    public void update(DesktopSearchInfo paramDesktopSearchInfo)
    {
      Object localObject2 = MiniAppUtils.getAppInterface();
      if (localObject2 != null)
      {
        if ((ThemeUtil.isDefaultTheme()) || (ThemeUtil.isGoldenTheme()) || (DisplayUtil.isWhiteModeTheme()) || (anlm.pq(ThemeUtil.getCurrentThemeId())))
        {
          this.container.setBackgroundResource(2130841815);
          localObject1 = BaseApplicationImpl.getContext().getResources().getDrawable(2130851339);
          ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getMinimumWidth(), ((Drawable)localObject1).getMinimumHeight());
          this.keywordTv.setCompoundDrawables((Drawable)localObject1, null, null, null);
          this.keywordTv.setTextColor(BaseApplicationImpl.getContext().getResources().getColor(2131167396));
        }
      }
      else
      {
        this.container.setPadding(0, 0, 0, 0);
        this.searchInfo = paramDesktopSearchInfo;
        if ((paramDesktopSearchInfo == null) || (paramDesktopSearchInfo.keyword == null) || (paramDesktopSearchInfo.keyword.size() <= 0)) {
          break label304;
        }
        localObject1 = (String)paramDesktopSearchInfo.keyword.get(0);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label289;
        }
        this.keywordTv.setText((CharSequence)localObject1);
        label167:
        if (this.keywordTv.getText() == null) {
          break label319;
        }
      }
      label289:
      label304:
      label319:
      for (Object localObject1 = this.keywordTv.getText().toString();; localObject1 = acfp.m(2131708374))
      {
        if (localObject2 != null)
        {
          localObject2 = (MiniAppExposureManager)((AppInterface)localObject2).getManager(322);
          ((MiniAppExposureManager)localObject2).putReportDataToMap("search", new MiniAppExposureManager.CardModuleExposureData("desktop", "search", "expo_search", (String)localObject1));
          if ((paramDesktopSearchInfo != null) && (paramDesktopSearchInfo.mAppInfo != null) && (paramDesktopSearchInfo.mAppInfo.tianshuAdId > 0))
          {
            paramDesktopSearchInfo = String.valueOf(paramDesktopSearchInfo.mAppInfo.tianshuAdId);
            ((MiniAppExposureManager)localObject2).putReportDataToMap(paramDesktopSearchInfo, new MiniAppExposureManager.TianShuExposureData("tianshu.78", "tianshu.78", paramDesktopSearchInfo, 101));
          }
        }
        return;
        this.container.setBackgroundResource(2130851343);
        break;
        this.keywordTv.setText(acfp.m(2131708366));
        break label167;
        this.keywordTv.setText(acfp.m(2131708369));
        break label167;
      }
    }
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
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter
 * JD-Core Version:    0.7.0.1
 */