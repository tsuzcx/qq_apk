package com.tencent.qqmail.attachment.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.activity.media.ImagePagerAdapter;
import com.tencent.qqmail.activity.media.MediaItemInfo;
import com.tencent.qqmail.activity.sdcardfileexplorer.SdcardFileExplorer;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.PopupAdapter;
import com.tencent.qqmail.utilities.ui.QMPopupWindow;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.List;

public class AttachImagePagerActivity
  extends BaseActivityEx
{
  private static final String ARG_DEFAULT_ACCOUNT_ID = "arg_default_id";
  private static final String ARG_SELECTED_POSITION = "arg_selected_position";
  private static final int REQUEST_CODE_SAVE = 2;
  public static final String RESULT_CURRENT_POSITION = "result_current_position";
  public static final String TAG = "AttachImagePagerActivity";
  private static List<MediaItemInfo> sAttachments = null;
  private int accountId;
  private ImagePagerAdapter imagePageAdapter;
  private ViewPager imageViewPager;
  private List<MediaItemInfo> mailAttachments = null;
  private int position;
  private QMTopBar topBar;
  
  public static Intent createIntent(int paramInt1, List<MediaItemInfo> paramList, int paramInt2)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), AttachImagePagerActivity.class);
    localIntent.putExtra("arg_selected_position", paramInt1);
    localIntent.putExtra("arg_default_id", paramInt2);
    sAttachments = paramList;
    return localIntent;
  }
  
  private void doAttachSaveAs()
  {
    Attach localAttach = new Attach(false);
    int i = this.imageViewPager.getCurrentItem();
    localAttach.setName(((MediaItemInfo)this.mailAttachments.get(i)).getFileName());
    Intent localIntent = new Intent(this, SdcardFileExplorer.class);
    localIntent.putExtra("type", 1);
    localIntent.putExtra("iscomplete", 1);
    localIntent.putExtra("attachfile", localAttach);
    localIntent.putExtra("url", ((MediaItemInfo)this.mailAttachments.get(i)).getDataPath());
    localIntent.putExtra("savelastDownLoadPath", true);
    startActivityForResult(localIntent, 2);
  }
  
  private void handleBack()
  {
    Intent localIntent = new Intent();
    if (this.imageViewPager != null) {}
    for (int i = this.imageViewPager.getCurrentItem();; i = 0)
    {
      localIntent.putExtra("result_current_position", i);
      setResult(2, localIntent);
      overridePendingTransition(0, 2130772402);
      finish();
      return;
    }
  }
  
  private void initImageViewPageer()
  {
    this.imagePageAdapter = new ImagePagerAdapter(this, this.accountId, new AttachImagePagerActivity.5(this), new AttachImagePagerActivity.6(this), null);
    this.imagePageAdapter.change(this.mailAttachments, new boolean[this.mailAttachments.size()]);
    this.imageViewPager = ((ViewPager)findViewById(2131368921));
    this.imageViewPager.setAdapter(this.imagePageAdapter);
    this.imageViewPager.setPageMargin((int)getResources().getDimension(2131297468));
    this.imageViewPager.setOffscreenPageLimit(1);
    this.imageViewPager.setOnPageChangeListener(new AttachImagePagerActivity.7(this));
    this.imageViewPager.setCurrentItem(this.position);
  }
  
  private void initTopBar()
  {
    this.topBar = ((QMTopBar)findViewById(2131374722));
    this.topBar.setButtonLeftBack();
    this.topBar.getButtonLeft().setOnClickListener(new AttachImagePagerActivity.2(this));
    this.topBar.setButtonRightIcon(2130841095);
    this.topBar.getButtonRight().setOnClickListener(new AttachImagePagerActivity.3(this));
  }
  
  private void openSaveDialogOptPopup(View paramView)
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(getString(2131690567));
    localObject = new AttachImagePagerActivity.4(this, this, paramView, new PopupAdapter(this, 2131559771, 2131373495, (List)localObject));
    ((QMPopupWindow)localObject).setAnchor(paramView);
    ((QMPopupWindow)localObject).showDown();
  }
  
  private void updateTopBarTitle()
  {
    this.topBar.setTitle(((MediaItemInfo)this.mailAttachments.get(this.imageViewPager.getCurrentItem())).getFileName());
  }
  
  public void initDataSource()
  {
    this.mailAttachments = sAttachments;
    this.accountId = getIntent().getIntExtra("arg_default_id", 0);
    this.position = getIntent().getIntExtra("arg_selected_position", 0);
  }
  
  public void initDom()
  {
    initTopBar();
    if ((this.mailAttachments != null) && (this.mailAttachments.size() > 0))
    {
      initImageViewPageer();
      updateTopBarTitle();
    }
  }
  
  public void initUI()
  {
    setContentView(2131558473);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramIntent != null) && (paramInt1 == 2)) {
      Threads.runInBackground(new AttachImagePagerActivity.1(this, paramIntent.getStringExtra("filePath"), paramIntent.getStringExtra("sourcePath")));
    }
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onButtonBackClick()
  {
    handleBack();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      handleBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onOverridePendingTransitionInFinish(Intent paramIntent)
  {
    overridePendingTransition(0, 2130772402);
  }
  
  public void onRelease()
  {
    if (this.imageViewPager != null) {
      this.imageViewPager.setAdapter(null);
    }
    this.mailAttachments = null;
  }
  
  public void refreshData() {}
  
  public void render() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachImagePagerActivity
 * JD-Core Version:    0.7.0.1
 */