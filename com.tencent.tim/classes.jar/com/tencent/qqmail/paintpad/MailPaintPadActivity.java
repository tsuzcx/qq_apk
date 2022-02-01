package com.tencent.qqmail.paintpad;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.pb.paintpad.PaintPadActivity;
import com.tencent.pb.paintpad.drawings.DrawHistory;
import com.tencent.qqmail.BaseActivityImpl;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.model.readmail.ForwardMailHelper;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.InstallUtils;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.share.ShareUtil;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomGridSheetBuilder;
import com.tencent.qqmail.utilities.ui.QMShareFileDialogHelper;

public class MailPaintPadActivity
  extends PaintPadActivity
{
  public static final String EXTRA_RESULT_PATH = "EXTRA_RESULT_PATH";
  private static final String QQ_PACKAGE_NAME = "com.tencent.mobileqq";
  public static final int REQUEST_CODE_NORMAL = 1;
  public static final int REQUEST_COMPOSE_ATTACH_PREVIEW = 6;
  public static final int REQUEST_FORWARD = 5;
  public static final int REQUEST_NEW_MAIL = 2;
  public static final int REQUEST_REPLY = 3;
  public static final int REQUEST_REPLY_ALL = 4;
  public static final long SCREENSHOT_FILE_DELETE_PERIOD = 86400000L;
  private static final String TAG = "MailPaintPadActivity";
  private static final String WECHAT_PACKAGE_NAME = "com.tencent.mm";
  private static final String WEWORK_PACKAGE_NAME = "com.tencent.wework";
  public static MailUI extra_maildata;
  private boolean isAllImageCache;
  private boolean isImageLoad;
  private int mAccountID;
  private BaseActivityImpl mQMBaseActivityImpl;
  private MailUI mailData;
  private int mailType;
  private String paintImgPath;
  private boolean shareFlag = false;
  private TextView textViewBack;
  private View textViewDone;
  
  public static Intent createIntentForGallery(Context paramContext, int paramInt, Uri paramUri)
  {
    paramContext = new Intent(paramContext, MailPaintPadActivity.class);
    paramContext.putExtra("EXTRA_IF_SHARE", false);
    paramContext.putExtra("EXTRA_SELECTED_COUNT", paramInt);
    paramContext.setData(paramUri);
    return paramContext;
  }
  
  public static Intent createIntentForScreenShot(Context paramContext, Uri paramUri, MailUI paramMailUI, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    paramContext = new Intent(paramContext, MailPaintPadActivity.class);
    paramContext.putExtra("EXTRA_ACCOUNTID", paramInt1);
    paramContext.putExtra("EXTRA_IS_ALLIMAGECACHE", paramBoolean1);
    paramContext.putExtra("EXTRA_IS_IMAGELOAD", paramBoolean2);
    paramContext.putExtra("EXTRA_MAIL_TYPE", paramInt2);
    paramContext.putExtra("EXTRA_IF_SHARE", true);
    paramContext.setData(paramUri);
    extra_maildata = paramMailUI;
    return paramContext;
  }
  
  public void forward()
  {
    ForwardMailHelper.prepareToForwardMailWithContentImage(this, this.mAccountID, this.mailData, this.isAllImageCache, this.isImageLoad, this.paintImgPath);
  }
  
  public void handlerCancel()
  {
    if (!DrawHistory.canUndo())
    {
      DataCollector.logEvent("Event_Screenshot_Tag_Noting_Cancel");
      finish();
      return;
    }
    DataCollector.logEvent("Event_Screenshot_Tag_Cancel");
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this).setTitle(2131697345)).setMessage(2131719225).addAction(2131691246, new MailPaintPadActivity.11(this))).addAction(0, 2131719226, 2, new MailPaintPadActivity.10(this))).create().show();
  }
  
  public void newMail()
  {
    Intent localIntent = ComposeMailActivity.createIntentWithInlineImage(this.paintImgPath);
    localIntent.putExtra("toController", "CONTROLLER_SCREENSHOT_REPLY");
    startActivityForResult(localIntent, 2);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MailPaintPadActivity", "requestCode = " + paramInt1 + "resultCode = " + paramInt2);
    if ((paramInt2 == -1) || (paramInt2 == 1001)) {
      finish();
    }
  }
  
  public void onBackPressed()
  {
    handlerCancel();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QMLog.getTrace("t");
    this.mailData = extra_maildata;
    paramBundle = getIntent().getExtras();
    this.mAccountID = paramBundle.getInt("EXTRA_ACCOUNTID");
    this.isAllImageCache = paramBundle.getBoolean("EXTRA_IS_ALLIMAGECACHE");
    this.isImageLoad = paramBundle.getBoolean("EXTRA_IS_IMAGELOAD");
    this.mailType = paramBundle.getInt("EXTRA_MAIL_TYPE");
    this.textViewDone = findViewById(com.tencent.pb.paintpad.R.id.sdk_paintpad_tv_done);
    this.textViewBack = ((TextView)findViewById(com.tencent.pb.paintpad.R.id.sdk_paintpad_iv_cancel));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)getResources().getDimension(2131299664));
    ((RelativeLayout)findViewById(com.tencent.androidqqmail.R.id.sdk_paintpad_top_bar)).setLayoutParams(localLayoutParams);
    int i = (int)getResources().getDimension(2131299667);
    ((TextView)this.textViewDone).setTextSize(0, i);
    this.textViewBack.setTextSize(0, i);
    Threads.runInBackground(new MailPaintPadActivity.1(this));
    findViewById(com.tencent.pb.paintpad.R.id.sdk_paintpad_tv_load_image).setVisibility(8);
    this.textViewBack.setOnClickListener(new MailPaintPadActivity.2(this));
    if (!getIntent().getBooleanExtra("EXTRA_IF_SHARE", false))
    {
      if ((this.textViewDone instanceof TextView))
      {
        i = paramBundle.getInt("EXTRA_SELECTED_COUNT");
        paramBundle = getString(2131689701);
        if (i != 1) {
          break label268;
        }
        ((TextView)this.textViewDone).setText(paramBundle);
      }
      for (;;)
      {
        this.textViewDone.setOnClickListener(new MailPaintPadActivity.3(this));
        return;
        label268:
        ((TextView)this.textViewDone).setText(paramBundle + "(" + i + ")");
      }
    }
    if ((this.textViewDone instanceof TextView)) {
      ((TextView)this.textViewDone).setText(2131721840);
    }
    this.textViewDone.setOnClickListener(new MailPaintPadActivity.4(this));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    extra_maildata = null;
    this.mailData = null;
  }
  
  public void reply()
  {
    Intent localIntent = ComposeMailActivity.createIntentWithMail(ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLY, 0, this.mailData, this.paintImgPath, "CONTROLLER_SCREENSHOT_REPLY");
    localIntent.putExtra("fromController", "folder");
    startActivityForResult(localIntent, 3);
  }
  
  public void replyAll()
  {
    Intent localIntent = ComposeMailActivity.createIntentWithMail(ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLYALL, 0, this.mailData, this.paintImgPath, "CONTROLLER_SCREENSHOT_REPLY");
    localIntent.putExtra("fromController", "folder");
    startActivityForResult(localIntent, 4);
  }
  
  public void saveToGallery()
  {
    Threads.runInBackground(new MailPaintPadActivity.8(this));
  }
  
  public void shareImageToQQ(String paramString)
  {
    ShareUtil.shareImageToQQ(paramString);
  }
  
  public void shareImageToRTX(String paramString)
  {
    ShareUtil.shareImageToWeWork(paramString);
  }
  
  public void shareToOtherApp(String paramString)
  {
    new QMShareFileDialogHelper(this, getResources().getString(2131719232), paramString, QMShareFileDialogHelper.SHARE_TYPE_IMG, QMShareFileDialogHelper.FROM_SHARE_MAIL_OR_NOTE_CONTENT, new MailPaintPadActivity.9(this)).createDialog().show();
  }
  
  public void shareToTimeLine(String paramString)
  {
    ShareUtil.shareToTimeLine(paramString, new MailPaintPadActivity.6(this));
  }
  
  public void shareToWeChatFriend(String paramString)
  {
    ShareUtil.shareToWeChatFriend(paramString, new MailPaintPadActivity.7(this));
  }
  
  public void showShareMenu()
  {
    QMBottomDialog.BottomGridSheetBuilder localBottomGridSheetBuilder = new QMBottomDialog.BottomGridSheetBuilder(this);
    if (InstallUtils.isWeChatInstalled())
    {
      localBottomGridSheetBuilder.addItem(2130840799, getString(2131719238), getString(2131719238), 0);
      localBottomGridSheetBuilder.addItem(2130840798, getString(2131719229), getString(2131719229), 0);
    }
    if (InstallUtils.isQQInstalled()) {
      localBottomGridSheetBuilder.addItem(2130840795, getString(2131719233), getString(2131719233), 0);
    }
    if (InstallUtils.isWeWorkInstalled()) {
      localBottomGridSheetBuilder.addItem(2130840797, getString(2131719236), getString(2131719236), 0);
    }
    localBottomGridSheetBuilder.addItem(2130840791, getString(2131719237), getString(2131719237), 0);
    localBottomGridSheetBuilder.addItem(2130840793, getString(2131719231), getString(2131719231), 0);
    localBottomGridSheetBuilder.addItem(2130840774, getString(2131719230), getString(2131719230), 1);
    if (this.mailType == 0)
    {
      localBottomGridSheetBuilder.addItem(2130840785, getString(2131719234), getString(2131719234), 1);
      localBottomGridSheetBuilder.addItem(2130840786, getString(2131719235), getString(2131719235), 1);
      localBottomGridSheetBuilder.addItem(2130840775, getString(2131719228), getString(2131719228), 1);
    }
    localBottomGridSheetBuilder.setOnSheetItemClickListener(new MailPaintPadActivity.5(this));
    localBottomGridSheetBuilder.build().show();
  }
  
  public static final class EXTRA_KEY
  {
    public static final String EXTRA_ACCOUNTID = "EXTRA_ACCOUNTID";
    public static final String EXTRA_IF_SHARE = "EXTRA_IF_SHARE";
    public static final String EXTRA_IS_ALLIMAGECACHE = "EXTRA_IS_ALLIMAGECACHE";
    public static final String EXTRA_IS_IMAGELOAD = "EXTRA_IS_IMAGELOAD";
    public static final String EXTRA_MAIL_TYPE = "EXTRA_MAIL_TYPE";
    public static final String EXTRA_PAINTPAD_INDEX = "EXTRA_PAINTPAD_INDEX";
    public static final String EXTRA_SELECTED_COUNT = "EXTRA_SELECTED_COUNT";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.paintpad.MailPaintPadActivity
 * JD-Core Version:    0.7.0.1
 */