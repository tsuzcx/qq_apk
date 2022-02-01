package com.tencent.qqmail.ftn.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.activity.media.QMMediaBottom;
import com.tencent.qqmail.ftn.FtnLogicStorage;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.ftn.model.FtnComposeInfo;
import com.tencent.qqmail.ftn.model.FtnUI;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.model.media.QMAlbumManager.QMMediaIntentType;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.view.QMContentLoadingView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ComposeFtnListActivity
  extends BaseActivityEx
{
  public static final String ARG_FROM_CHOOSE_ACTION = "from_choose_action";
  public static final String TAG = "ComposeFtnListActivity";
  private ComposeFtnListAdapter adapter;
  private List<String> checkedFids = new ArrayList();
  private QMMediaBottom fixedBottom;
  private FtnUI ftnUI;
  private QMAlbumManager.QMMediaIntentType intentType = QMAlbumManager.QMMediaIntentType.QMMediaIntentType_NORMAIL;
  private boolean isFromChooseAttach;
  private QMContentLoadingView listEmptyView;
  private ListView listView;
  private List<MailBigAttach> mBigAttachesNotInList = new ArrayList();
  private List<MailBigAttach> mCheckInfo = new ArrayList();
  private int mLastIndex = -1;
  private int mLastTop = -1;
  private IObserver observerGetListError = new ComposeFtnListActivity.3(this, null);
  private IObserver observerGetListSuccess = new ComposeFtnListActivity.2(this, null);
  private final IObserver observerWebPush = new ComposeFtnListActivity.1(this, null);
  private QMTopBar topBar;
  
  private void buildComposeData()
  {
    ArrayList localArrayList = FtnLogicStorage.getComposeInfos();
    if (localArrayList == null) {}
    for (;;)
    {
      return;
      localArrayList.clear();
      if (this.isFromChooseAttach) {
        this.mCheckInfo.addAll(this.mBigAttachesNotInList);
      }
      Iterator localIterator = this.mCheckInfo.iterator();
      while (localIterator.hasNext())
      {
        MailBigAttach localMailBigAttach = (MailBigAttach)localIterator.next();
        if (localMailBigAttach != null) {
          localArrayList.add(FtnCommonUtils.mailBigAttach2FtnComposeInfo(localMailBigAttach));
        }
      }
    }
  }
  
  private void changeShowStatus(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      renderNormal();
      return;
    case 2: 
      renderEmpty();
      return;
    case 4: 
      renderError();
      return;
    }
    renderLoading();
  }
  
  private void handleCancel()
  {
    Intent localIntent = new Intent(this, ComposeMailActivity.class);
    if (this.isFromChooseAttach)
    {
      setResult(0, localIntent);
      FtnLogicStorage.fetchOutComposeInfos();
    }
    for (;;)
    {
      finish();
      return;
      startActivity(localIntent);
    }
  }
  
  private void handleDone()
  {
    buildComposeData();
    Intent localIntent = ComposeMailActivity.createIntentFromFtn(null);
    if (this.isFromChooseAttach) {
      setResult(-1, localIntent);
    }
    for (;;)
    {
      finish();
      return;
      startActivity(localIntent);
    }
  }
  
  private void initAddButton()
  {
    if (this.fixedBottom != null) {
      return;
    }
    this.fixedBottom = ((QMMediaBottom)findViewById(2131365160));
    this.fixedBottom.init(this);
    ComposeFtnListActivity.6 local6 = new ComposeFtnListActivity.6(this);
    this.fixedBottom.addButton.setOnClickListener(local6);
    this.fixedBottom.updateAddButton(this.intentType, this.mCheckInfo.size());
  }
  
  private void initListView()
  {
    this.adapter = new ComposeFtnListAdapter(this, this.listView, this.checkedFids);
    this.adapter.setFtnUI(this.ftnUI);
    this.listView.setAdapter(this.adapter);
    this.listView.setChoiceMode(2);
    this.listView.setOnItemClickListener(new ComposeFtnListActivity.5(this));
  }
  
  private void initTopBar()
  {
    this.topBar.setTitle(2131694073);
    this.topBar.setButtonLeftNormal(2131691246);
    this.topBar.getButtonLeft().setOnClickListener(new ComposeFtnListActivity.4(this));
  }
  
  private void renderEmpty()
  {
    this.listView.setVisibility(8);
    this.listEmptyView.showTips(2131694064);
  }
  
  private void renderError()
  {
    this.listView.setVisibility(8);
    this.listEmptyView.showTips(2131694065);
    this.listEmptyView.showTipsReload(2131694065, new ComposeFtnListActivity.7(this));
  }
  
  private void renderLoading()
  {
    this.listView.setVisibility(8);
    this.listEmptyView.showLoading(true);
  }
  
  private void renderNormal()
  {
    this.listView.setVisibility(0);
    this.listEmptyView.hide();
  }
  
  private void restorePosition()
  {
    if (this.mLastIndex > -1) {
      this.listView.setSelectionFromTop(this.mLastIndex, this.mLastTop);
    }
  }
  
  private void savePosition()
  {
    int i = 0;
    View localView;
    if (this.listView != null)
    {
      this.mLastIndex = this.listView.getFirstVisiblePosition();
      localView = this.listView.getChildAt(0);
      if (localView != null) {
        break label39;
      }
    }
    for (;;)
    {
      this.mLastTop = i;
      return;
      label39:
      i = localView.getTop();
    }
  }
  
  private void updateFtnList(boolean paramBoolean)
  {
    if (this.ftnUI.getCount() > 0)
    {
      savePosition();
      this.adapter.setFtnUI(this.ftnUI);
      this.adapter.notifyDataSetChanged();
      restorePosition();
      changeShowStatus(3);
      return;
    }
    if (paramBoolean)
    {
      FtnManager.sharedInstance().getList();
      changeShowStatus(1);
      return;
    }
    changeShowStatus(2);
  }
  
  public void initDataSource()
  {
    this.isFromChooseAttach = getIntent().getBooleanExtra("from_choose_action", false);
    this.ftnUI = FtnManager.sharedInstance().getFtnList();
    if (this.isFromChooseAttach)
    {
      Object localObject1 = FtnLogicStorage.getComposeInfos();
      if (localObject1 != null)
      {
        Object localObject2 = new ArrayList();
        Object localObject3 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          FtnComposeInfo localFtnComposeInfo = (FtnComposeInfo)((Iterator)localObject3).next();
          if (localFtnComposeInfo.getFid() != null) {
            ((List)localObject2).add(localFtnComposeInfo.getFid());
          }
        }
        localObject2 = FtnManager.sharedInstance().getFidsByFids((List)localObject2);
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = ((FtnComposeInfo)((Iterator)localObject1).next()).getMailAttach();
          if (localObject3 != null) {
            if (((Set)localObject2).contains(((MailBigAttach)localObject3).getFid()))
            {
              this.checkedFids.add(((MailBigAttach)localObject3).getFid());
              this.mCheckInfo.add(localObject3);
            }
            else
            {
              this.mBigAttachesNotInList.add(localObject3);
            }
          }
        }
      }
    }
  }
  
  public void initDom()
  {
    initTopBar();
    initListView();
    initAddButton();
  }
  
  public void initTips(QMTips paramQMTips)
  {
    paramQMTips.setCanceledOnTouchOutside(true);
  }
  
  public void initUI()
  {
    setContentView(2131559048);
    this.topBar = ((QMTopBar)findViewById(2131374722));
    this.listEmptyView = ((QMContentLoadingView)findViewById(2131370545));
    this.listView = ((ListView)findViewById(2131370573));
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    FtnLogicStorage.fetchOutComposeInfos();
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QMNotification.registNotification("actiongetlistsucc", this.observerGetListSuccess);
      QMNotification.registNotification("actiongetlisterror", this.observerGetListError);
      QMNotification.registNotification("receivePushFTN", this.observerWebPush);
      return;
    }
    QMNotification.unregistNotification("actiongetlistsucc", this.observerGetListSuccess);
    QMNotification.unregistNotification("actiongetlisterror", this.observerGetListError);
    QMNotification.unregistNotification("receivePushFTN", this.observerWebPush);
  }
  
  public void onRelease() {}
  
  public void refreshData()
  {
    this.ftnUI = FtnManager.sharedInstance().getFtnList();
  }
  
  public void render()
  {
    updateFtnList(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.ComposeFtnListActivity
 * JD-Core Version:    0.7.0.1
 */