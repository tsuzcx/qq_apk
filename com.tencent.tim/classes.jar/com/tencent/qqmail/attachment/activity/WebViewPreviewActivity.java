package com.tencent.qqmail.attachment.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.activity.sdcardfileexplorer.SdcardFileExplorer;
import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.model.AttachType;
import com.tencent.qqmail.attachment.util.AttachToolbox;
import com.tencent.qqmail.attachment.util.IntentUtil;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.download.util.DownloadUtil;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.model.qmdomain.MailContent;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.sendmail.SendMailHelper;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.FileCharsetDetector;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.ui.PopupAdapter;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMPopupWindow;
import com.tencent.qqmail.utilities.ui.QMShareFileDialogHelper;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import com.tencent.qqmail.view.QMWebView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import moai.core.utilities.Utils;
import moai.oss.OssHelper;

public class WebViewPreviewActivity
  extends BaseActivityEx
{
  private static final String ARG_ATTACH = "attach";
  private static final String ARG_FROM_COMPOSE = "fromCompose";
  private static final String ARG_FROM_FOLDER = "fromFolder";
  private static final String ARG_FROM_READMAIL = "fromReadMail";
  private static final int REQUEST_CODE_ATTACH_SAVE_AS = 100;
  public static final String TAG = "WebViewPreviewActivity";
  private int accountId;
  private QMBaseView baseView;
  private boolean fromCompose;
  private int fromFolder;
  private boolean fromReadMail;
  private Attach mailAttach;
  private QMTopBar topBar;
  private ViewFlipper viewFlipper;
  private WebView webView;
  
  public static Intent createIntent(Context paramContext, Attach paramAttach, int paramInt, boolean paramBoolean)
  {
    paramContext = new Intent(paramContext, WebViewPreviewActivity.class);
    paramContext.putExtra("attach", paramAttach);
    paramContext.putExtra("fromFolder", paramInt);
    paramContext.putExtra("fromReadMail", paramBoolean);
    return paramContext;
  }
  
  public static Intent createIntentForCompose(Context paramContext, Attach paramAttach)
  {
    paramContext = new Intent(paramContext, WebViewPreviewActivity.class);
    paramContext.putExtra("attach", paramAttach);
    paramContext.putExtra("fromCompose", true);
    return paramContext;
  }
  
  private int getInitialScale()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getActivity().getWindowManager().getDefaultDisplay();
    switch (localDisplayMetrics.densityDpi)
    {
    }
    return 150;
  }
  
  private void initData(Intent paramIntent)
  {
    this.mailAttach = ((Attach)paramIntent.getSerializableExtra("attach"));
    if (this.mailAttach == null)
    {
      finish();
      return;
    }
    this.fromFolder = paramIntent.getIntExtra("fromFolder", -1);
    this.fromReadMail = paramIntent.getBooleanExtra("fromReadMail", false);
    this.fromCompose = paramIntent.getBooleanExtra("fromCompose", false);
    this.accountId = this.mailAttach.getAccountId();
  }
  
  private void initTopBar()
  {
    this.topBar = getTopBar();
    QMTopBar localQMTopBar = this.topBar;
    if (this.mailAttach == null) {}
    for (String str = "";; str = this.mailAttach.getName())
    {
      localQMTopBar.setTitle(str);
      this.topBar.setButtonLeftBack();
      this.topBar.setButtonLeftOnclickListener(new WebViewPreviewActivity.2(this));
      if ((this.fromReadMail) || (this.fromCompose))
      {
        this.topBar.setButtonRightIcon(2130841095);
        this.topBar.setButtonRightOnclickListener(new WebViewPreviewActivity.3(this));
      }
      return;
    }
  }
  
  private void initView()
  {
    if (this.mailAttach == null)
    {
      finish();
      return;
    }
    initTopBar();
    this.viewFlipper = ((ViewFlipper)findViewById(2131381892));
    this.viewFlipper.setBackgroundResource(2131167682);
  }
  
  private void initWebView(AttachType paramAttachType, String paramString)
  {
    this.webView = new QMWebView(getActivity());
    QMUIHelper.setZoomControlGone(this.webView);
    this.webView.setHorizontalScrollBarEnabled(true);
    this.webView.setVisibility(0);
    this.webView.setWebViewClient(new WebViewPreviewActivity.1(this));
    this.webView.getSettings().setAllowFileAccess(true);
    this.webView.getSettings().setLoadsImagesAutomatically(true);
    this.webView.getSettings().setSavePassword(false);
    this.webView.getSettings().setSaveFormData(false);
    this.webView.getSettings().setJavaScriptEnabled(false);
    this.webView.getSettings().setDefaultTextEncodingName(paramString);
    this.webView.getSettings().setSupportZoom(true);
    this.webView.getSettings().setBuiltInZoomControls(true);
    this.webView.getSettings().setAppCacheEnabled(false);
    this.webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
    this.webView.getSettings().setUseWideViewPort(true);
    if (paramAttachType == AttachType.HTML) {
      this.webView.setInitialScale(getInitialScale());
    }
    if (Utils.hasHoneycomb()) {
      this.webView.setLayerType(1, null);
    }
    if (Build.VERSION.SDK_INT >= 11) {
      this.webView.removeJavascriptInterface("searchBoxJavaBridge_");
    }
    if (this.webView.getParent() == null) {
      this.viewFlipper.addView(this.webView, 0);
    }
    this.viewFlipper.setDisplayedChild(0);
  }
  
  private boolean isShowFavorite()
  {
    return (this.fromFolder != 4) && (this.fromFolder != 5) && (this.fromFolder != 6) && (this.fromFolder != 102) && (this.fromFolder != -1);
  }
  
  private void openFilePath()
  {
    if (StringExtention.isNullOrEmpty(this.mailAttach.getPreview().getMyDisk()))
    {
      Toast.makeText(getActivity(), getString(2131692956), 0).show();
      return;
    }
    IntentUtil.openAttachFileLocation(getActivity(), this.mailAttach.getPreview().getMyDisk());
  }
  
  private void saveAttachAs()
  {
    Intent localIntent = new Intent(getActivity(), SdcardFileExplorer.class);
    localIntent.putExtra("type", 1);
    localIntent.putExtra("getSavePath", true);
    localIntent.putExtra("savelastDownLoadPath", true);
    startActivityForResult(localIntent, 100);
  }
  
  private void sendMailWithAttach()
  {
    QMLog.log(4, "WebViewPreviewActivity", "send mail attach:" + this.mailAttach.getName());
    Object localObject2 = SendMailHelper.getComposeMail(this.mailAttach.getBelongMailId(), ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_COMPOSE);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ComposeMailUI();
    }
    localObject2 = ((ComposeMailUI)localObject1).getInformation();
    if (localObject2 == null)
    {
      localObject1 = new ComposeMailUI();
      localObject2 = ((ComposeMailUI)localObject1).getInformation();
    }
    for (;;)
    {
      ((MailInformation)localObject2).setToList(null);
      ((MailInformation)localObject2).setCcList(null);
      ((MailInformation)localObject2).setSendContact(null);
      ((ComposeMailUI)localObject1).setContent(new MailContent());
      ((ComposeMailUI)localObject1).getInformation().setSubject(this.mailAttach.getName());
      localObject2 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      if (this.mailAttach.isBigAttach()) {
        localArrayList.add(this.mailAttach);
      }
      for (;;)
      {
        ((ComposeMailUI)localObject1).getInformation().setAttachList((ArrayList)localObject2);
        ((ComposeMailUI)localObject1).getInformation().setBigAttachList(localArrayList);
        startActivity(ComposeMailActivity.createIntentForFwdAttach(this.mailAttach.getHashId(), this.mailAttach.getBelongMailId(), this.accountId, getClass().getName()));
        return;
        ((ArrayList)localObject2).add(this.mailAttach);
      }
    }
  }
  
  private void shareAttach()
  {
    if (this.mailAttach.isBigAttach())
    {
      new QMShareFileDialogHelper(getActivity(), getString(2131692325), this.mailAttach.getPreview().getDownloadUrl(), QMShareFileDialogHelper.SHARE_TYPE_BIG_ATT, this.mailAttach.getHashId()).createDialog().show();
      DataCollector.logEvent("Event_Share_Big_Attach_From_AttachDetail");
      return;
    }
    Activity localActivity = getActivity();
    String str1 = getString(2131690586);
    String str2 = this.mailAttach.getPreview().getMyDisk();
    if (isAttachImage(this.mailAttach)) {}
    for (int i = QMShareFileDialogHelper.SHARE_TYPE_IMG;; i = QMShareFileDialogHelper.SHARE_TYPE_NORMAL_ATT)
    {
      new QMShareFileDialogHelper(localActivity, str1, str2, i).createDialog().show();
      DataCollector.logEvent("Event_Share_Normal_Attach_From_Favorite");
      return;
    }
  }
  
  private void showMoreAction(View paramView)
  {
    View localView = paramView;
    if (paramView.getTag() != null)
    {
      localView = paramView;
      if ((paramView.getTag() instanceof View)) {
        localView = (View)paramView.getTag();
      }
    }
    paramView = new ArrayList();
    paramView.add(getString(2131690550));
    if ((!this.mailAttach.isBigAttach()) && (isShowFavorite()))
    {
      if (QMAttachManager.sharedInstance().isAttachFavorite(this.mailAttach.getHashId())) {
        break label219;
      }
      paramView.add(getString(2131690532));
    }
    for (;;)
    {
      if ((this.mailAttach.isExist()) || (this.mailAttach.isBigAttach())) {
        paramView.add(getString(2131690586));
      }
      if (this.mailAttach.isExist()) {
        paramView.add(getString(2131690582));
      }
      if ((this.mailAttach.isExist()) && (IntentUtil.isExistFileBrowser(getActivity()))) {
        paramView.add(getString(2131690558));
      }
      new WebViewPreviewActivity.4(this, this, localView, new PopupAdapter(this, 2131559771, 2131373495, paramView)).show();
      return;
      label219:
      paramView.add(getString(2131690535));
    }
  }
  
  private void toPreviewInWebView()
  {
    if ((this.mailAttach != null) && (FileUtil.hasSdcard()))
    {
      String str = this.mailAttach.getPreview().getMyDisk();
      if (!FileUtil.isFileExist(str))
      {
        if ((this.mailAttach instanceof MailBigAttach))
        {
          OssHelper.bigattachOpenFail(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "WebViewPreviewActivity", FileUtil.getFileNameSuffix(this.mailAttach.getName()), "file not exist" });
          return;
        }
        OssHelper.attachOpenFail(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "WebViewPreviewActivity", FileUtil.getFileNameSuffix(this.mailAttach.getName()), "file not exist" });
        return;
      }
      try
      {
        Object localObject1 = new File(str);
        Object localObject3 = FileUtil.getFileNameSuffix(this.mailAttach.getName());
        Object localObject2 = new FileCharsetDetector().guestFileEncoding((File)localObject1);
        localObject1 = localObject2;
        if (!((String)localObject2).equalsIgnoreCase("UTF-8")) {
          localObject1 = "GBK";
        }
        initWebView(AttachToolbox.getAttachType(this.mailAttach), (String)localObject1);
        localObject1 = str;
        if (localObject3 != null)
        {
          localObject1 = str;
          if (((String)localObject3).equalsIgnoreCase("xml"))
          {
            localObject2 = new File(str);
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(str);
            ((StringBuilder)localObject3).append(".txt");
            localObject1 = str;
            if (FileUtil.copyFile((File)localObject2, new File(((StringBuilder)localObject3).toString())) == 0) {
              localObject1 = ((StringBuilder)localObject3).toString();
            }
          }
        }
        this.webView.loadUrl("file://" + StringExtention.replaceIllegalUrl((String)localObject1));
        QMLog.log(4, "WebViewPreviewActivity", "Preview local file path: " + StringExtention.replaceIllegalUrl((String)localObject1));
        if ((this.mailAttach instanceof MailBigAttach))
        {
          OssHelper.bigattachOpenSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "WebViewPreviewActivity", FileUtil.getFileNameSuffix(this.mailAttach.getName()), "" });
          return;
        }
      }
      catch (Exception localException)
      {
        QMUIHelper.showToast(this, 2131696497, "文件过大，请重新加载！");
        if ((this.mailAttach instanceof MailBigAttach))
        {
          OssHelper.bigattachOpenFail(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "WebViewPreviewActivity", FileUtil.getFileNameSuffix(this.mailAttach.getName()), localException.getMessage() });
          return;
          OssHelper.attachOpenSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "WebViewPreviewActivity", FileUtil.getFileNameSuffix(this.mailAttach.getName()), "" });
          return;
        }
        OssHelper.attachOpenFail(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "WebViewPreviewActivity", FileUtil.getFileNameSuffix(this.mailAttach.getName()), localException.getMessage() });
        return;
      }
    }
    if ((this.mailAttach instanceof MailBigAttach))
    {
      OssHelper.bigattachOpenFail(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "WebViewPreviewActivity", FileUtil.getFileNameSuffix(this.mailAttach.getName()), "has no sdcard" });
      return;
    }
    OssHelper.attachOpenFail(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "WebViewPreviewActivity", FileUtil.getFileNameSuffix(this.mailAttach.getName()), "has no sdcard" });
  }
  
  private void toggleAttachFavourite(boolean paramBoolean)
  {
    QMAttachManager.sharedInstance().favoriteAttach(new long[] { this.mailAttach.getHashId() }, paramBoolean);
    if (paramBoolean)
    {
      getTips().showSuccess(2131689776);
      return;
    }
    getTips().showSuccess(2131691250);
  }
  
  public void initDataSource()
  {
    initData(getIntent());
  }
  
  public void initDom()
  {
    initView();
    toPreviewInWebView();
  }
  
  public void initUI()
  {
    this.baseView = initBaseView(this, 2131558523);
    setContentView(this.baseView);
  }
  
  public boolean isAttachImage(Attach paramAttach)
  {
    return AttachType.valueOf(QMAttachUtils.attachFileType(FileUtil.getFileNameSuffix(paramAttach.getName()))) == AttachType.IMAGE;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramIntent == null);
    paramIntent = paramIntent.getStringExtra("savePath");
    Toast.makeText(QMApplicationContext.sharedInstance(), QMApplicationContext.sharedInstance().getString(2131690569) + paramIntent, 0).show();
    DownloadUtil.existFileSaveAs(this.mailAttach, paramIntent, false);
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    overridePendingTransition(2130772421, 2130772420);
    return true;
  }
  
  public void onRelease()
  {
    if (this.webView != null)
    {
      this.webView.removeAllViews();
      this.webView.destroy();
      this.webView = null;
    }
  }
  
  public void refreshData() {}
  
  public void render() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.WebViewPreviewActivity
 * JD-Core Version:    0.7.0.1
 */