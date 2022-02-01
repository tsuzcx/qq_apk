package com.tencent.qqmail.attachment.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.UrlQuerySanitizer;
import android.os.Handler;
import android.view.View;
import android.widget.ListAdapter;
import androidx.fragment.app.FragmentActivity;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.activity.media.MediaItemInfo;
import com.tencent.qqmail.activity.sdcardfileexplorer.SdcardFileExplorer;
import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.sendmail.SendMailHelper;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.ui.PopupAdapter;
import com.tencent.qqmail.utilities.ui.QMPopupWindow;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AttachOperateMore
{
  public static final int RESULT_CODE_SAVEAS = 200;
  private static final String TAG = "AttachOperateMore";
  private Context mContext;
  private MediaItemInfo mFileInfo;
  private Handler mFtnOperateHandler = new AttachOperateMore.4(this);
  private boolean mIsActivity = true;
  private Handler mSaveFileHandler = new AttachOperateMore.3(this);
  private QMTips mTips;
  private IObserver observerSaveFileError = new AttachOperateMore.2(this, null);
  private IObserver observerSaveFileSuccess = new AttachOperateMore.1(this, null);
  
  public AttachOperateMore(Context paramContext, QMTips paramQMTips, MediaItemInfo paramMediaItemInfo, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.mTips = paramQMTips;
    this.mFileInfo = paramMediaItemInfo;
    this.mIsActivity = paramBoolean;
  }
  
  private int copyFileAndSync(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new File(paramString1);
    paramString2 = new File(paramString2 + paramString3);
    try
    {
      int i = FileUtil.copyFile(paramString1, paramString2);
      return i;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return -1;
  }
  
  public static void doForwardAttaches(Context paramContext, long[] paramArrayOfLong)
  {
    paramContext.startActivity(ComposeMailActivity.createIntentForForwardAttaches(paramContext, paramArrayOfLong));
  }
  
  public static void doMailSend(Context paramContext, int paramInt, long paramLong, Attach paramAttach)
  {
    ComposeMailUI localComposeMailUI = SendMailHelper.getComposeMail(paramLong, ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_FORWARD);
    if (localComposeMailUI != null)
    {
      Object localObject = localComposeMailUI.getInformation();
      ((MailInformation)localObject).setToList(null);
      ((MailInformation)localObject).setCcList(null);
      ((MailInformation)localObject).setSendContact(null);
      ((MailInformation)localObject).setSendContact(new MailContact());
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramAttach);
      localComposeMailUI.getInformation().setSubject(paramAttach.getName());
      localComposeMailUI.getInformation().setAttachList((ArrayList)localObject);
      localComposeMailUI.getInformation().setBigAttachList((ArrayList)localObject);
      paramContext.startActivity(ComposeMailActivity.createIntentForFwdAttach(paramAttach.getHashId(), paramLong, paramInt, paramContext.getClass().getName()));
      return;
    }
    QMLog.log(6, "AttachOperateMore", "doMailSend failed, mailid:" + paramLong + ",accountId:" + paramInt);
  }
  
  private void doSaveAs(MediaItemInfo paramMediaItemInfo)
  {
    Attach localAttach = new Attach(false);
    localAttach.setName(paramMediaItemInfo.getFileName());
    Intent localIntent = new Intent(this.mContext, SdcardFileExplorer.class);
    localIntent.putExtra("type", 1);
    localIntent.putExtra("iscomplete", 1);
    localIntent.putExtra("attachfile", localAttach);
    localIntent.putExtra("url", paramMediaItemInfo.getSourcePath());
    localIntent.putExtra("savelastDownLoadPath", true);
    if (this.mIsActivity)
    {
      ((BaseActivityEx)this.mContext).startActivityForResult(localIntent, 200);
      return;
    }
    ((FragmentActivity)this.mContext).startActivityForResult(localIntent, 200);
  }
  
  private void doSaveFile(long paramLong, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    int i = copyFileAndSync(paramLong, paramString1, paramString2, FileUtil.rename(paramString2, paramString3));
    paramString1 = this.mSaveFileHandler.obtainMessage();
    if (i == 0) {}
    for (paramString1.what = 0;; paramString1.what = 1)
    {
      paramString1.obj = new SaveInfo(paramString2, paramString3, i, paramBoolean);
      this.mSaveFileHandler.sendMessage(paramString1);
      return;
    }
  }
  
  private void doStoreToFtn(MediaItemInfo paramMediaItemInfo, ArrayList<String> paramArrayList)
  {
    FtnManager localFtnManager = FtnManager.sharedInstance();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    UrlQuerySanitizer localUrlQuerySanitizer = new UrlQuerySanitizer();
    localUrlQuerySanitizer.setAllowUnregisteredParamaters(true);
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      paramMediaItemInfo = (MailBigAttach)paramMediaItemInfo.getAttach();
      if ((paramMediaItemInfo.getKey() == null) || (paramMediaItemInfo.getCode() == null))
      {
        localUrlQuerySanitizer.parseUrl(QMAttachUtils.removeIllegalString(paramMediaItemInfo.getPreview().getDownloadUrl()));
        paramMediaItemInfo.setKey(localUrlQuerySanitizer.getValue("k"));
        paramMediaItemInfo.setCode(localUrlQuerySanitizer.getValue("code"));
      }
      paramArrayList = paramMediaItemInfo.getKey();
      paramMediaItemInfo = paramMediaItemInfo.getCode();
      if ((!StringExtention.isNullOrEmpty(paramArrayList)) && (!StringExtention.isNullOrEmpty(paramMediaItemInfo)))
      {
        localArrayList1.add(paramArrayList);
        localArrayList2.add(paramMediaItemInfo);
      }
    }
    while ((localArrayList1.size() > 0) && (localArrayList1.size() == localArrayList2.size()))
    {
      this.mTips.showLoading(2131718594);
      localFtnManager.saveFile(localArrayList1, localArrayList2);
      return;
      int i = 0;
      while (i < paramArrayList.size())
      {
        localUrlQuerySanitizer.parseUrl(QMAttachUtils.removeIllegalString((String)paramArrayList.get(i)));
        paramMediaItemInfo = localUrlQuerySanitizer.getValue("k");
        String str = localUrlQuerySanitizer.getValue("code");
        if ((!StringExtention.isNullOrEmpty(paramMediaItemInfo)) && (!StringExtention.isNullOrEmpty(str)))
        {
          localArrayList1.add(paramMediaItemInfo);
          localArrayList2.add(str);
        }
        i += 1;
      }
    }
    this.mTips.showError(this.mContext.getString(2131718938));
  }
  
  public static void doWriteMailWithFavAttaches(Context paramContext, long[] paramArrayOfLong)
  {
    paramContext.startActivity(ComposeMailActivity.createIntentForFavAttaches(paramContext, paramArrayOfLong));
  }
  
  private void endSaveFile(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("savePath", paramString1 + paramString2);
    if (paramInt == 0) {
      if (this.mIsActivity)
      {
        ((BaseActivityEx)this.mContext).setResult(0, localIntent);
        QMUIHelper.showToast(this.mContext, 2131696497, "文件已保存至:" + paramString1 + paramString2);
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        if (!this.mIsActivity) {
          break label214;
        }
        ((BaseActivityEx)this.mContext).finish();
      }
      return;
      ((FragmentActivity)this.mContext).setResult(0, localIntent);
      break;
      if (this.mIsActivity) {
        ((BaseActivityEx)this.mContext).setResult(-1, localIntent);
      }
      for (;;)
      {
        if (paramInt != -2) {
          break label198;
        }
        QMUIHelper.showToast(this.mContext, 2131696497, this.mContext.getString(2131718596));
        break;
        ((FragmentActivity)this.mContext).setResult(-1, localIntent);
      }
      label198:
      QMUIHelper.showToast(this.mContext, 2131696497, "文件保存失败");
    }
    label214:
    ((FragmentActivity)this.mContext).finish();
  }
  
  private boolean isShowSaveToWeiYun()
  {
    boolean bool2 = false;
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(this.mFileInfo.getAccountId());
    boolean bool1 = bool2;
    if (localAccount != null)
    {
      bool1 = bool2;
      if (localAccount.isQQMail())
      {
        bool1 = bool2;
        if (!localAccount.isBizMail()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static void setResultWithAttaches(Context paramContext, long[] paramArrayOfLong)
  {
    paramArrayOfLong = ComposeMailActivity.createIntentForFavAttaches(paramContext, paramArrayOfLong);
    ((Activity)paramContext).setResult(-1, paramArrayOfLong);
  }
  
  public void bindEvent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QMNotification.registNotification("actionsavefilesucc", this.observerSaveFileSuccess);
      QMNotification.registNotification("actionsavefileerror", this.observerSaveFileError);
      return;
    }
    QMNotification.unregistNotification("actionsavefilesucc", this.observerSaveFileSuccess);
    QMNotification.unregistNotification("actionsavefileerror", this.observerSaveFileError);
  }
  
  public void handleSaveAsResult(String paramString1, String paramString2)
  {
    this.mTips.showLoading(2131718597);
    new Thread(new AttachOperateMore.5(this, paramString2, paramString1)).start();
  }
  
  public void topBarMoreClickPopup(View paramView, int paramInt, long paramLong, ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof View))) {
      paramView = (View)paramView.getTag();
    }
    for (;;)
    {
      Object localObject1 = new ArrayList();
      Object localObject2 = FtnManager.sharedInstance();
      if ((localObject2 != null) && (((FtnManager)localObject2).hasFtnAccount()) && (this.mFileInfo.getAttach().isBigAttach()))
      {
        ((List)localObject1).add(this.mContext.getString(2131690570));
        if ((paramArrayList != null) && (paramArrayList.size() > 1)) {
          ((List)localObject1).add(this.mContext.getString(2131690566));
        }
      }
      if ((this.mFileInfo.getAttach().isExist()) && (IntentUtil.isExistFileBrowser(this.mContext))) {
        ((List)localObject1).add(this.mContext.getString(2131690558));
      }
      ((List)localObject1).add(this.mContext.getString(2131690582));
      ((List)localObject1).add(this.mContext.getString(2131690550));
      if (paramBoolean)
      {
        if (QMAttachManager.sharedInstance().isAttachFavorite(paramLong)) {
          break label362;
        }
        ((List)localObject1).add(this.mContext.getString(2131690532));
      }
      for (;;)
      {
        localObject2 = QMAttachManager.sharedInstance().getAttachCopyDisk(this.mFileInfo.getAttach().getHashId(), 0);
        if ((this.mFileInfo.getAttach().isExist()) || (!((String)localObject2).equals(""))) {
          ((List)localObject1).add(this.mContext.getString(2131690586));
        }
        if ((isShowSaveToWeiYun()) && (DeviceUtil.isQCloudInstalled())) {
          ((List)localObject1).add(this.mContext.getString(2131690572));
        }
        localObject1 = new PopupAdapter(this.mContext, 2131559771, 2131373495, (List)localObject1);
        new AttachOperateMore.6(this, this.mContext, paramView, (ListAdapter)localObject1, paramArrayList, paramLong, (String)localObject2).show();
        return;
        label362:
        ((List)localObject1).add(this.mContext.getString(2131690535));
      }
    }
  }
  
  public static class SaveInfo
  {
    boolean finish = false;
    String name;
    String path;
    int result;
    
    public SaveInfo(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
    {
      this.path = paramString1;
      this.name = paramString2;
      this.result = paramInt;
      this.finish = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.util.AttachOperateMore
 * JD-Core Version:    0.7.0.1
 */