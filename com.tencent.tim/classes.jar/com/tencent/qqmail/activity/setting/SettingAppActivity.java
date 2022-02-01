package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import android.content.res.Resources;
import android.view.MotionEvent;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.marcos.ChannelDefine;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.businessfilter.FolderListItemFilter;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.Iterator;

public class SettingAppActivity
  extends BaseActivityEx
{
  public static final String TAG = "SettingAppActivity";
  private final UITableView.ClickListener appTableOnClickListener = new SettingAppActivity.1(this);
  private UITableView mAppTableView;
  private QMBaseView mSettingView;
  private ArrayList<UITableItemView> popularizeItemViewList;
  private ArrayList<Popularize> popularizeList;
  
  private void createAppTableView()
  {
    this.mAppTableView = new UITableView(this);
    this.mSettingView.addContentView(this.mAppTableView);
    this.mAppTableView.setClickListener(this.appTableOnClickListener);
    if ((this.popularizeList != null) && (this.popularizeList.size() > 0))
    {
      Iterator localIterator = this.popularizeList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Popularize)localIterator.next();
        localObject = this.mAppTableView.addItem(((Popularize)localObject).getSubject());
        ((UITableItemView)localObject).setDetail("");
        this.popularizeItemViewList.add(localObject);
      }
    }
    this.mAppTableView.commit();
  }
  
  public static Intent createIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), SettingAppActivity.class);
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle(2131690444);
    localQMTopBar.setButtonLeftBack();
  }
  
  public void initDataSource()
  {
    if (ChannelDefine.isGooglePlay()) {}
    for (this.popularizeList = new ArrayList();; this.popularizeList = PopularizeManager.sharedInstance().getPopularize(new FolderListItemFilter(3, 3)))
    {
      this.popularizeItemViewList = new ArrayList();
      return;
    }
  }
  
  public void initDom()
  {
    initTopBar();
    createAppTableView();
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
  
  public void refreshData()
  {
    if ((this.popularizeItemViewList != null) && (this.popularizeItemViewList.size() > 0) && (this.popularizeList != null) && (this.popularizeList.size() > 0))
    {
      int i = 0;
      if (i < Math.min(this.popularizeItemViewList.size(), this.popularizeList.size()))
      {
        UITableItemView localUITableItemView = (UITableItemView)this.popularizeItemViewList.get(i);
        Popularize localPopularize = (Popularize)this.popularizeList.get(i);
        if ((localUITableItemView != null) && (localPopularize != null))
        {
          if (!localPopularize.isOpen()) {
            break label116;
          }
          localUITableItemView.setDetail(getResources().getString(2131719917));
        }
        for (;;)
        {
          i += 1;
          break;
          label116:
          localUITableItemView.setDetail(getResources().getString(2131719718));
        }
      }
    }
  }
  
  public void render() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAppActivity
 * JD-Core Version:    0.7.0.1
 */