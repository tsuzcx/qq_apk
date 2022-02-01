package com.tencent.qqmail.activity.setting;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Environment;
import android.os.StatFs;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.QMSharedPreferenceManager;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.io.File;

public class SettingCacheClearActivity
  extends BaseActivityEx
{
  private static final long CACHE_WARNING_SIZE = 52428800L;
  public static final int CLEAN_ALL_ATTACHMENT = 3;
  public static final int CLEAN_BEFORE7D_ATTACHMENT = 2;
  public static final int CLEAN_MAILCONTENT = 4;
  public static final int CLEAN_MAILIMAGE = 8;
  public static final int CLEAN_RECENT7D_ATTACHMENT = 1;
  public static final int CLEAN_TMP_CACHE = 16;
  private static final long DAYLY_MILS = 86400000L;
  private static final long SD_AVAILABLE_WARNING_SIZE = 2147483648L;
  private static final String cacheSizeTips = "正在计算大小...";
  private UITableItemView cleanAllAttachesItemView;
  private UITableView cleanListTableView;
  private UITableItemView cleanMailConentItemView;
  private UITableItemView cleanMailImageItemView;
  private UITableItemView cleanTmpCacheItemView;
  private UITableItemView clearActionItemView;
  private UITableView clearActionTableView;
  private QMTips loadingView;
  private QMBaseView mSettingView;
  
  private static boolean SDAvailableWarning()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (FileUtil.hasSdcard()) {}
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l = localStatFs.getBlockSize();
      int i = localStatFs.getAvailableBlocks();
      bool1 = bool2;
      if (i * l < 2147483648L) {
        bool1 = true;
      }
      return bool1;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      QMLog.log(6, "FileUtil", "get SDAvailableWarning err: " + localIllegalArgumentException.getMessage());
    }
    return false;
  }
  
  private String calculateCacheSize(String paramString)
  {
    boolean bool = paramString.contains(",");
    String str = paramString;
    if (bool) {
      str = paramString.replace(",", ".");
    }
    double d;
    if (str.endsWith("K"))
    {
      d = Double.parseDouble(str.substring(0, str.length() - 1)) / 1000.0D;
      if (d < 0.01D) {
        paramString = "0.0M";
      }
    }
    for (;;)
    {
      str = paramString;
      if (bool) {
        str = paramString.replace(".", ",");
      }
      return str;
      paramString = trimSize(d) + "M";
      continue;
      if (str.endsWith("B"))
      {
        d = Double.parseDouble(str.substring(0, str.length() - 1)) / 1000.0D / 1000.0D;
        if (d < 0.01D) {
          paramString = "0.0M";
        } else {
          paramString = trimSize(d) + "M";
        }
      }
      else
      {
        paramString = str;
      }
    }
  }
  
  private void createCleanListTable()
  {
    this.cleanListTableView = new UITableView(this);
    this.mSettingView.addContentView(this.cleanListTableView);
    this.cleanAllAttachesItemView = this.cleanListTableView.addItem(2131719709);
    this.cleanAllAttachesItemView.setTailImage(2130850509);
    this.cleanAllAttachesItemView.setContent("正在计算大小...");
    this.cleanAllAttachesItemView.setChecked(true);
    this.cleanMailConentItemView = this.cleanListTableView.addItem(2131719713);
    this.cleanMailConentItemView.setTailImage(2130850509);
    this.cleanMailConentItemView.setContent("正在计算大小...");
    this.cleanMailConentItemView.setChecked(true);
    this.cleanMailImageItemView = this.cleanListTableView.addItem(2131719714);
    this.cleanMailImageItemView.setTailImage(2130850509);
    this.cleanMailImageItemView.setContent("正在计算大小...");
    this.cleanMailImageItemView.setChecked(true);
    this.cleanTmpCacheItemView = this.cleanListTableView.addItem(2131719715);
    this.cleanTmpCacheItemView.setTailImage(2130850509);
    this.cleanTmpCacheItemView.setContent("正在计算大小...");
    this.cleanTmpCacheItemView.setChecked(true);
    this.cleanListTableView.setClickListener(new SettingCacheClearActivity.3(this));
    this.cleanListTableView.commit();
  }
  
  private void createClearActionTable()
  {
    this.clearActionTableView = new UITableView(this);
    this.mSettingView.addContentView(this.clearActionTableView);
    this.clearActionItemView = this.clearActionTableView.addItem(2131719711);
    this.clearActionItemView.hideArrow();
    ViewGroup.LayoutParams localLayoutParams = this.clearActionItemView.getTitleView().getLayoutParams();
    localLayoutParams.width = -1;
    this.clearActionItemView.getTitleView().setLayoutParams(localLayoutParams);
    this.clearActionItemView.getTitleView().setGravity(17);
    this.clearActionItemView.getTitleView().setTextColor(getBaseContext().getResources().getColor(2131167535));
    this.clearActionTableView.setOnClickListener(new SettingCacheClearActivity.1(this));
    this.clearActionTableView.commit();
  }
  
  public static Intent createIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), SettingCacheClearActivity.class);
  }
  
  private void doClearCache()
  {
    this.clearActionItemView.setEnabled(false);
    if (this.loadingView == null) {
      this.loadingView = new QMTips(getActivity());
    }
    this.loadingView.showLoading(getString(2131719716));
    this.loadingView.setCanceledOnTouchOutside(true);
    Threads.runInBackground(new SettingCacheClearActivity.2(this));
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setButtonLeftBack();
    localQMTopBar.setTitle(getString(2131719710));
  }
  
  public static boolean remindToClearCache()
  {
    return ((QMSharedPreferenceManager.getInstance().getLastRemindClearCacheViewShowTime() == 0L) || (System.currentTimeMillis() - QMSharedPreferenceManager.getInstance().getLastRemindClearCacheViewShowTime() > 2592000000L)) && (SDAvailableWarning()) && (FileUtil.getCacheSize() > 52428800L);
  }
  
  private void showAllAttachCacheSize()
  {
    runInBackground(new SettingCacheClearActivity.4(this));
  }
  
  private void showCacheSize()
  {
    showAllAttachCacheSize();
    showMailContentSize();
    showImageCacheSize();
    showTmpCacheSize();
  }
  
  private void showImageCacheSize()
  {
    runInBackground(new SettingCacheClearActivity.5(this));
  }
  
  private void showMailContentSize()
  {
    runInBackground(new SettingCacheClearActivity.6(this));
  }
  
  public static void showRemindClearCacheDialog(Context paramContext, QMBaseView paramQMBaseView, ClickRemindClearCache paramClickRemindClearCache)
  {
    if (remindToClearCache())
    {
      QMSharedPreferenceManager.getInstance().setRemindClearCacheViewShowTime(System.currentTimeMillis());
      DataCollector.logEvent("Event_Show_Tip_To_Clear_Cache");
      View localView = paramQMBaseView.findViewById(2131371069);
      if (localView == null) {
        break label73;
      }
      paramContext = (RelativeLayout)localView;
    }
    for (;;)
    {
      paramContext.setVisibility(0);
      paramContext.setOnClickListener(new SettingCacheClearActivity.8(paramContext, paramClickRemindClearCache));
      paramContext.postDelayed(new SettingCacheClearActivity.9(paramContext), 10000L);
      return;
      label73:
      paramContext = (RelativeLayout)LayoutInflater.from(paramContext).inflate(2131558798, paramQMBaseView, false);
      paramContext.setId(2131371069);
      paramQMBaseView.addView(paramContext);
    }
  }
  
  private void showTmpCacheSize()
  {
    runInBackground(new SettingCacheClearActivity.7(this));
  }
  
  private double trimSize(double paramDouble)
  {
    return Math.round(paramDouble * 100.0D) / 100.0D;
  }
  
  public void initDataSource() {}
  
  public void initDom()
  {
    initTopBar();
  }
  
  public void initUI()
  {
    this.mSettingView = initScrollView(this);
    createCleanListTable();
    createClearActionTable();
    showCacheSize();
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onRelease() {}
  
  public void refreshData() {}
  
  public void render() {}
  
  public static abstract interface ClickRemindClearCache
  {
    public abstract void click();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCacheClearActivity
 * JD-Core Version:    0.7.0.1
 */