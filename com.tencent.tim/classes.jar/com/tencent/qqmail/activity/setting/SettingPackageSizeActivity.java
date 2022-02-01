package com.tencent.qqmail.activity.setting;

import alkx;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SettingPackageSizeActivity
  extends BaseActivityEx
{
  private UITableView mAppSizeView;
  private QMBaseView mBaseView;
  private UITableItemView mCacheItemView;
  private UITableItemView mCodeItemView;
  private UITableView mCompView;
  private UITableItemView mDataItemView;
  private String mEvent;
  private UITableItemView mExternalCacheItemView;
  private UITableItemView mExternalCodeItemView;
  private UITableItemView mExternalDataItemView;
  private UITableItemView mExternalMediaItemView;
  private UITableItemView mExternalObbItemView;
  private List<Map.Entry<PackageStats, Long>> mList;
  private PackageStats mMailPackageStats;
  private Map<PackageStats, Long> mMap = new HashMap();
  private long mSTime;
  private ThreadPoolExecutor mThreadPoolExecutor;
  private UITableView mTopView;
  private UITableItemView mTotalSizeItemView;
  private UITableView mTotalSizeView;
  
  private String cal(float paramFloat)
  {
    int i = 0;
    while (paramFloat / 1024.0F > 1.0F)
    {
      paramFloat /= 1024.0F;
      i += 1;
    }
    String str = "";
    switch (i)
    {
    }
    for (;;)
    {
      return String.format(Locale.getDefault(), "%.2f%s", new Object[] { Float.valueOf(paramFloat), str });
      str = "B";
      continue;
      str = "K";
      continue;
      str = "M";
      continue;
      str = "G";
    }
  }
  
  private void checkGetAll()
  {
    runInBackground(new SettingPackageSizeActivity.4(this), 5000L);
  }
  
  private void createAppSizeView()
  {
    this.mAppSizeView = new UITableView(this);
    this.mAppSizeView.setCaption("QQ邮箱各部分所占大小");
    this.mCodeItemView = this.mAppSizeView.addItem("代码");
    this.mCodeItemView.hideArrow();
    this.mCodeItemView.setContent("codeSize: apk");
    this.mCodeItemView.setDetail("0");
    this.mExternalCodeItemView = this.mAppSizeView.addItem("外部代码");
    this.mExternalCodeItemView.hideArrow();
    this.mExternalCodeItemView.setContent("externalCodeSize");
    this.mExternalCodeItemView.setDetail("0");
    this.mDataItemView = this.mAppSizeView.addItem("数据");
    this.mDataItemView.hideArrow();
    this.mDataItemView.setContent("dataSize: /data/data/");
    this.mDataItemView.setDetail("0");
    this.mExternalDataItemView = this.mAppSizeView.addItem("外部数据");
    this.mExternalDataItemView.hideArrow();
    this.mExternalDataItemView.setContent("externalDataSize: /Android/data/");
    this.mExternalDataItemView.setDetail("0");
    this.mCacheItemView = this.mAppSizeView.addItem("缓存");
    this.mCacheItemView.hideArrow();
    this.mCacheItemView.setContent("cacheSize: /data/data//cache");
    this.mCacheItemView.setDetail("0");
    this.mExternalCacheItemView = this.mAppSizeView.addItem("外部缓存");
    this.mExternalCacheItemView.hideArrow();
    this.mExternalCacheItemView.setContent("externalCache: sdcard");
    this.mExternalCacheItemView.setDetail("0");
    this.mExternalMediaItemView = this.mAppSizeView.addItem("外部媒体");
    this.mExternalMediaItemView.hideArrow();
    this.mExternalMediaItemView.setContent("externalMedia");
    this.mExternalMediaItemView.setDetail("0");
    this.mExternalObbItemView = this.mAppSizeView.addItem("Obb");
    this.mExternalObbItemView.hideArrow();
    this.mExternalObbItemView.setContent("obbSize");
    this.mExternalObbItemView.setDetail("0");
    this.mAppSizeView.commit();
    this.mBaseView.addContentView(this.mAppSizeView);
  }
  
  @SuppressLint({"NewApi"})
  private void createCompView(PackageStats paramPackageStats1, PackageStats paramPackageStats2)
  {
    int i = Build.VERSION.SDK_INT;
    this.mCompView = new UITableView(this);
    this.mCompView.setCaption(getAppName(paramPackageStats1.packageName) + " vs " + getAppName(paramPackageStats2.packageName));
    UITableItemView localUITableItemView = this.mCompView.addItem("代码");
    localUITableItemView.hideArrow();
    localUITableItemView.setContent("codeSize: apk");
    localUITableItemView.setDetail(cal((float)paramPackageStats1.codeSize) + " : " + cal((float)paramPackageStats2.codeSize));
    localUITableItemView = this.mCompView.addItem("外部代码");
    localUITableItemView.hideArrow();
    localUITableItemView.setContent("externalCodeSize");
    if (i >= 14) {
      localUITableItemView.setDetail(cal((float)paramPackageStats1.externalCodeSize) + " : " + cal((float)paramPackageStats2.externalCodeSize));
    }
    for (;;)
    {
      localUITableItemView = this.mCompView.addItem("数据");
      localUITableItemView.hideArrow();
      localUITableItemView.setContent("dataSize: /data/data");
      localUITableItemView.setDetail(cal((float)paramPackageStats1.dataSize) + " : " + cal((float)paramPackageStats2.dataSize));
      localUITableItemView = this.mCompView.addItem("外部数据");
      localUITableItemView.hideArrow();
      localUITableItemView.setContent("externalDataSize: /Android/data/");
      localUITableItemView.setDetail(cal((float)paramPackageStats1.externalDataSize) + " : " + cal((float)paramPackageStats2.externalDataSize));
      localUITableItemView = this.mCompView.addItem("缓存");
      localUITableItemView.hideArrow();
      localUITableItemView.setContent("cacheSize: /data/data//cache");
      localUITableItemView.setDetail(cal((float)paramPackageStats1.cacheSize) + " : " + cal((float)paramPackageStats2.cacheSize));
      localUITableItemView = this.mCompView.addItem("外部缓存");
      localUITableItemView.hideArrow();
      localUITableItemView.setContent("externalCache: sdcard");
      localUITableItemView.setDetail(cal((float)paramPackageStats1.externalCacheSize) + " : " + cal((float)paramPackageStats2.externalCacheSize));
      localUITableItemView = this.mCompView.addItem("外部媒体");
      localUITableItemView.hideArrow();
      localUITableItemView.setContent("externalMedia");
      localUITableItemView.setDetail(cal((float)paramPackageStats1.externalMediaSize) + " : " + cal((float)paramPackageStats2.externalMediaSize));
      localUITableItemView = this.mCompView.addItem("Obb");
      localUITableItemView.hideArrow();
      localUITableItemView.setContent("obbSize");
      localUITableItemView.setDetail(cal((float)paramPackageStats1.externalObbSize) + " : " + cal((float)paramPackageStats2.externalObbSize));
      this.mCompView.commit();
      this.mBaseView.addContentView(this.mCompView);
      return;
      localUITableItemView.setDetail("0 : 0");
    }
  }
  
  public static Intent createCompareIntent(PackageStats paramPackageStats1, PackageStats paramPackageStats2)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), SettingPackageSizeActivity.class);
    localIntent.addFlags(268435456);
    localIntent.putExtra("event", "comp");
    localIntent.putExtra("other", paramPackageStats1);
    localIntent.putExtra("mail", paramPackageStats2);
    return localIntent;
  }
  
  public static Intent createInitIntent()
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), SettingPackageSizeActivity.class);
    localIntent.addFlags(268435456);
    localIntent.putExtra("event", "init");
    return localIntent;
  }
  
  private void createThreadPool()
  {
    if (this.mThreadPoolExecutor != null) {
      this.mThreadPoolExecutor.shutdownNow();
    }
    this.mThreadPoolExecutor = new ThreadPoolExecutor(50, 50, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  }
  
  private void createTopView()
  {
    QMLog.log(4, "PackageSize", "getAllPackage, elapsed: " + (SystemClock.elapsedRealtime() - this.mSTime) + "ms");
    this.mTopView = new UITableView(this);
    this.mTopView.setCaption("应用大小Top100排行榜");
    Iterator localIterator = this.mList.iterator();
    int i = 0;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        PackageStats localPackageStats = (PackageStats)((Map.Entry)localObject).getKey();
        long l = ((Long)((Map.Entry)localObject).getValue()).longValue();
        String str = getAppName(localPackageStats.packageName);
        localObject = str;
        if (getPackageName().equals(localPackageStats.packageName))
        {
          localObject = str + " (^_^)";
          this.mTotalSizeItemView.setTitle("总计（排行第" + (i + 1) + "）");
        }
        localObject = this.mTopView.addItem((String)localObject);
        ((UITableItemView)localObject).setDetail(cal((float)l));
        ((UITableItemView)localObject).setTag(localPackageStats);
        i += 1;
        if (i != 100) {}
      }
      else
      {
        this.mTopView.setClickListener(new SettingPackageSizeActivity.3(this));
        this.mTopView.commit();
        this.mBaseView.addContentView(this.mTopView);
        destroyThreadPool();
        return;
      }
    }
  }
  
  private void createTotalSizeView()
  {
    this.mTotalSizeView = new UITableView(this);
    this.mTotalSizeItemView = this.mTotalSizeView.addItem("总计");
    this.mTotalSizeItemView.hideArrow();
    this.mTotalSizeItemView.setDetail("0");
    this.mTotalSizeView.commit();
    this.mBaseView.addContentView(this.mTotalSizeView);
  }
  
  private void destroyThreadPool()
  {
    if (this.mThreadPoolExecutor != null) {
      this.mThreadPoolExecutor.shutdownNow();
    }
  }
  
  private void getAllPackageSize()
  {
    Object localObject = alkx.a(getPackageManager(), 0);
    if (localObject == null) {}
    for (int i = -1;; i = ((List)localObject).size())
    {
      QMLog.log(4, "PackageSize", "pkg num: " + i);
      if (i <= 0) {
        break;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PackageInfo localPackageInfo = (PackageInfo)((Iterator)localObject).next();
        this.mThreadPoolExecutor.execute(new SettingPackageSizeActivity.5(this, localPackageInfo, i));
      }
    }
  }
  
  private String getAppName(String paramString)
  {
    Object localObject = getPackageManager();
    try
    {
      localObject = (String)((PackageManager)localObject).getApplicationLabel(((PackageManager)localObject).getApplicationInfo(paramString, 0));
      return localObject;
    }
    catch (Exception localException) {}
    return paramString;
  }
  
  @SuppressLint({"NewApi"})
  private long getTotalSize(PackageStats paramPackageStats)
  {
    int i = Build.VERSION.SDK_INT;
    long l2 = paramPackageStats.codeSize;
    if (i >= 14) {}
    for (long l1 = paramPackageStats.externalCodeSize;; l1 = 0L) {
      return l1 + l2 + paramPackageStats.dataSize + paramPackageStats.externalDataSize + paramPackageStats.externalCacheSize + paramPackageStats.externalMediaSize + paramPackageStats.externalObbSize;
    }
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle("应用大小");
    localQMTopBar.setButtonLeftBack();
  }
  
  public void initDataSource()
  {
    if ("init".equals(this.mEvent))
    {
      createThreadPool();
      runInBackground(new SettingPackageSizeActivity.1(this));
      runInBackground(new SettingPackageSizeActivity.2(this));
    }
  }
  
  public void initDom() {}
  
  public void initUI()
  {
    this.mBaseView = initScrollView(this);
    initTopBar();
    Intent localIntent = getIntent();
    this.mEvent = localIntent.getStringExtra("event");
    if ("init".equals(this.mEvent))
    {
      createAppSizeView();
      createTotalSizeView();
    }
    while (!"comp".equals(this.mEvent)) {
      return;
    }
    createCompView((PackageStats)localIntent.getParcelableExtra("other"), (PackageStats)localIntent.getParcelableExtra("mail"));
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onRelease()
  {
    destroyThreadPool();
  }
  
  public void refreshData() {}
  
  public void render() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingPackageSizeActivity
 * JD-Core Version:    0.7.0.1
 */