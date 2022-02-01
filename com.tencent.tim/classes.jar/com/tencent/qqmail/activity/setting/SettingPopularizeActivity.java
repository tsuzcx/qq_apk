package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import android.view.MotionEvent;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;

public class SettingPopularizeActivity
  extends BaseActivityEx
{
  private static final String EXTRA_POPULARIZE_ID = "popularizeId";
  private static final String TAG = "SettingPopularizeActivity";
  private boolean checked;
  private QMBaseView mSettingView;
  private UITableView mShowTable;
  private UITableView mStatusTable;
  private Popularize popularize;
  private UITableItemView showItemView;
  private UITableView.ClickListener showTableClickListener = new SettingPopularizeActivity.2(this);
  private UITableItemView statusItemView;
  private UITableView.ClickListener statusTableClickListener = new SettingPopularizeActivity.1(this);
  private String title;
  
  public static Intent createIntent(int paramInt)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), SettingPopularizeActivity.class);
    localIntent.putExtra("popularizeId", paramInt);
    return localIntent;
  }
  
  private void createShowTable()
  {
    this.mShowTable = new UITableView(this);
    this.mSettingView.addContentView(this.mShowTable);
    this.mShowTable.setClickListener(this.showTableClickListener);
    this.showItemView = this.mShowTable.addItem(2131719652);
    if (this.popularize != null) {
      if (this.popularize.getMove() == 0) {
        if (this.popularize.getPage() == 0) {
          this.showItemView.setChecked(true);
        }
      }
    }
    for (;;)
    {
      this.mShowTable.commit();
      return;
      if (this.popularize.getPage() == 10)
      {
        this.showItemView.setChecked(false);
        continue;
        if (this.popularize.getMove() == 1)
        {
          this.showItemView.setChecked(true);
        }
        else if (this.popularize.getMove() == 2)
        {
          this.showItemView.setChecked(false);
          continue;
          this.showItemView.setChecked(false);
        }
      }
    }
  }
  
  private void createStatusTable()
  {
    this.mStatusTable = new UITableView(this);
    this.mSettingView.addContentView(this.mStatusTable);
    if (this.popularize != null) {}
    for (this.checked = this.popularize.isOpen();; this.checked = false)
    {
      this.statusItemView = this.mStatusTable.addItem(this.title);
      this.statusItemView.setChecked(this.checked);
      this.mStatusTable.setClickListener(this.statusTableClickListener);
      this.mStatusTable.commit();
      return;
    }
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle(this.title);
    localQMTopBar.setButtonLeftBack();
  }
  
  public void initDataSource()
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      int i = localIntent.getIntExtra("popularizeId", -1);
      this.popularize = PopularizeManager.sharedInstance().getPopularizeById(i);
      if (this.popularize != null) {
        this.title = this.popularize.getSubject();
      }
    }
    else
    {
      return;
    }
    this.title = "";
  }
  
  public void initDom()
  {
    initTopBar();
    createStatusTable();
    createShowTable();
  }
  
  public void initUI()
  {
    this.mSettingView = initScrollView(this);
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onRelease() {}
  
  public void refreshData() {}
  
  public void render()
  {
    if (this.checked)
    {
      this.mShowTable.setVisibility(0);
      return;
    }
    this.mShowTable.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingPopularizeActivity
 * JD-Core Version:    0.7.0.1
 */