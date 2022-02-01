import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation.9;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.UUID;

public class apca
{
  public Activity mActivity;
  public QQAppInterface mApp;
  public long mTroopUin;
  
  public apca(long paramLong, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.mTroopUin = paramLong;
    this.mApp = paramQQAppInterface;
    this.mActivity = paramActivity;
  }
  
  private int K(boolean paramBoolean)
  {
    if (paramBoolean) {
      return apsv.a(this.mApp, this.mActivity, this.mTroopUin);
    }
    return apsv.aH(this.mActivity);
  }
  
  private int Lh()
  {
    return K(true);
  }
  
  private void Q(FileManagerEntity paramFileManagerEntity)
  {
    TroopFileTransferManager.a(this.mApp, this.mTroopUin).f(paramFileManagerEntity);
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, long paramLong1, apcy paramapcy, String paramString, long paramLong2, int paramInt)
  {
    FileInfo localFileInfo = new FileInfo();
    if (!ahbj.isFileExists(paramapcy.LocalFile)) {
      TroopFileTransferManager.a(paramQQAppInterface, paramLong1).aBu();
    }
    switch (paramapcy.Status)
    {
    default: 
      if (TextUtils.isEmpty(paramapcy.FileName)) {
        break;
      }
    }
    for (String str = paramapcy.FileName;; str = "")
    {
      apsf.a(paramQQAppInterface, paramLong1).d(paramapcy.Id);
      localFileInfo.setName(str);
      localFileInfo.setPath(paramapcy.LocalFile);
      localFileInfo.setSize(paramapcy.ProgressTotal);
      Object localObject = new apcy();
      ((apcy)localObject).FileName = str;
      ((apcy)localObject).LocalFile = paramapcy.LocalFile;
      ((apcy)localObject).ProgressTotal = paramapcy.ProgressTotal;
      ((apcy)localObject).ProgressValue = paramapcy.ProgressValue;
      ((apcy)localObject).Id = paramapcy.Id;
      ((apcy)localObject).TroopUin = paramLong1;
      ((apcy)localObject).BusId = paramapcy.BusId;
      ((apcy)localObject).FilePath = paramapcy.FilePath;
      ((apcy)localObject).sha1 = paramapcy.sha1;
      ((apcy)localObject).ThumbnailFile_Small = paramapcy.ThumbnailFile_Small;
      ((apcy)localObject).ThumbnailFile_Large = paramapcy.ThumbnailFile_Large;
      ((apcy)localObject).coc = paramapcy.coc;
      ((apcy)localObject).Status = paramapcy.Status;
      FileManagerEntity localFileManagerEntity = ahav.a((apcy)localObject);
      localFileManagerEntity.selfUin = paramString;
      localFileManagerEntity.lastTime = paramLong2;
      localFileManagerEntity.bSend = paramQQAppInterface.getAccount().equals(localFileManagerEntity.selfUin);
      localObject = new ForwardFileInfo();
      ((ForwardFileInfo)localObject).p(localFileManagerEntity.nSessionId);
      ((ForwardFileInfo)localObject).Oj(4);
      ((ForwardFileInfo)localObject).setType(10006);
      ((ForwardFileInfo)localObject).setLocalPath(localFileInfo.getPath());
      ((ForwardFileInfo)localObject).setFileName(localFileInfo.getName());
      ((ForwardFileInfo)localObject).setFileSize(localFileInfo.getSize());
      ((ForwardFileInfo)localObject).jA(paramLong1);
      if ((paramActivity instanceof BasePluginActivity)) {}
      for (paramString = ((BasePluginActivity)paramActivity).getOutActivity();; paramString = paramActivity)
      {
        paramString = new Intent(paramString, TroopFileDetailBrowserActivity.class);
        if (paramInt == 1)
        {
          paramapcy = apsf.a(paramQQAppInterface, paramLong1).a(paramapcy.mParentId);
          if (paramapcy != null) {
            paramString.putExtra("leftViewText", paramapcy.str_file_name);
          }
        }
        if (paramInt == 1)
        {
          paramString.putExtra("file_enter_file_browser_type", 4);
          paramString.putExtra("fileinfo", (Parcelable)localObject);
          paramString.putExtra("removemementity", true);
          paramString.putExtra("forward_from_troop_file", true);
          paramString.putExtra("not_forward", true);
          paramString.putExtra("last_time", paramLong2);
          paramString.putExtra("from_type_troop", paramInt);
          if (!(paramActivity instanceof BasePluginActivity)) {
            break label727;
          }
          ((BasePluginActivity)paramActivity).startActivityForResult(paramString, 102);
        }
        for (;;)
        {
          if ((str != null) && (str.endsWith(".mp4")))
          {
            paramString = "3";
            paramapcy = paramString;
            if (paramActivity != null)
            {
              paramapcy = paramString;
              if ((paramActivity instanceof SplashActivity)) {
                paramapcy = "1";
              }
            }
            ShortVideoUtils.d(paramQQAppInterface.getCurrentAccountUin(), String.valueOf(paramLong1), String.valueOf(0), 1, "3", paramapcy);
          }
          return;
          paramQQAppInterface = "";
          paramInt = paramapcy.LocalFile.lastIndexOf("/") + 1;
          if (paramInt < paramapcy.LocalFile.length()) {
            paramQQAppInterface = paramapcy.LocalFile.substring(paramInt, paramapcy.LocalFile.length() - 1);
          }
          apsd.ck(paramActivity, b(2131699524, new Object[] { apsv.oR(paramQQAppInterface) }));
          return;
          if (paramInt == 3)
          {
            paramString.putExtra("file_enter_file_browser_type", 3);
            break;
          }
          if (paramInt == 0)
          {
            paramString.putExtra("file_enter_file_browser_type", 4);
            break;
          }
          if (paramInt == 2)
          {
            paramString.putExtra("file_enter_file_browser_type", 4);
            break;
          }
          if (paramInt != 4) {
            break;
          }
          paramString.putExtra("file_enter_file_browser_type", 12);
          break;
          label727:
          paramActivity.startActivityForResult(paramString, 102);
        }
      }
    }
  }
  
  private static String b(int paramInt, Object... paramVarArgs)
  {
    return String.format(getString(paramInt), paramVarArgs);
  }
  
  private static String getString(int paramInt)
  {
    return BaseApplicationImpl.getContext().getResources().getString(paramInt);
  }
  
  public void P(FileManagerEntity paramFileManagerEntity)
  {
    int i = Lh();
    if (i == 0) {
      return;
    }
    if ((i == 1) && (paramFileManagerEntity.fileSize > 3145728L))
    {
      Object localObject = new apck(this, paramFileManagerEntity);
      paramFileManagerEntity = b(2131699605, new Object[] { apsv.oR(paramFileManagerEntity.fileName), apsv.getFileSizeDesc(paramFileManagerEntity.fileSize) });
      localObject = aqha.a(this.mActivity, 230, getString(2131699824), paramFileManagerEntity, 2131721058, 2131720231, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
      paramFileManagerEntity = aiyw.a(this.mActivity, this.mApp, 2, paramFileManagerEntity);
      if ((paramFileManagerEntity instanceof SpannableString)) {
        ((aqju)localObject).setMessageWithoutAutoLink(paramFileManagerEntity);
      }
      ((aqju)localObject).show();
      return;
    }
    Q(paramFileManagerEntity);
  }
  
  public int a(apbr paramapbr)
  {
    if ("/".equals(paramapbr.mParentId)) {
      return 0;
    }
    return 1;
  }
  
  public apcy a(apbr paramapbr)
  {
    apcy localapcy2 = TroopFileTransferManager.a(this.mApp, this.mTroopUin).a(paramapbr.mFileId);
    apcy localapcy1 = localapcy2;
    if (localapcy2 == null)
    {
      localapcy1 = apsv.a(this.mApp, this.mTroopUin, paramapbr.Id.toString(), paramapbr.mFileId, paramapbr.str_file_name, paramapbr.uint64_file_size, paramapbr.dTg);
      localapcy1.ThumbnailFile_Large = paramapbr.ThumbnailFile_Large;
      localapcy1.coc = paramapbr.coc;
      localapcy1.ThumbnailFile_Small = paramapbr.ThumbnailFile_Small;
    }
    if ((localapcy1 != null) && (localapcy1.ProgressTotal == 0L)) {
      localapcy1.ProgressTotal = paramapbr.uint64_file_size;
    }
    return localapcy1;
  }
  
  public void a(apbr paramapbr, String paramString1, String paramString2)
  {
    aqju localaqju = aqha.b(this.mActivity, 230);
    localaqju.setTitle(paramString1).setMessage(paramString2);
    paramString1 = (LinearLayout.LayoutParams)localaqju.getMessageTextView().getLayoutParams();
    paramString1.gravity = 17;
    localaqju.getMessageTextView().setLayoutParams(paramString1);
    localaqju.setPositiveButton(this.mActivity.getResources().getString(2131721079), new apch(this, paramapbr));
    localaqju.show();
  }
  
  public void a(apcy paramapcy, String paramString, long paramLong, int paramInt)
  {
    a(this.mActivity, this.mApp, this.mTroopUin, paramapcy, paramString, paramLong, paramInt);
  }
  
  public void a(UUID paramUUID)
  {
    if (Lh() == 0) {
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.mApp, this.mTroopUin);
    if (ahav.amK())
    {
      apcb localapcb = new apcb(this, localTroopFileTransferManager, paramUUID);
      paramUUID = localTroopFileTransferManager.a(paramUUID);
      if (paramUUID != null) {}
      for (paramUUID = b(2131699610, new Object[] { apsv.oR(paramUUID.FileName), apsv.getFileSizeDesc(paramUUID.ProgressTotal) });; paramUUID = getString(2131699609))
      {
        aqha.a(this.mActivity, 230, getString(2131699824), paramUUID, 2131721058, 2131699917, localapcb, localapcb).show();
        return;
      }
    }
    localTroopFileTransferManager.b(paramUUID);
  }
  
  public void b(UUID paramUUID)
  {
    int i = Lh();
    if (i == 0) {
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.mApp, this.mTroopUin);
    if (i == 1)
    {
      apcy localapcy = localTroopFileTransferManager.a(paramUUID);
      long l;
      Object localObject;
      if (localapcy != null)
      {
        l = localapcy.ProgressTotal;
        localObject = b(2131699608, new Object[] { apsv.oR(localapcy.FileName), apsv.getFileSizeDesc(localapcy.ProgressTotal) });
      }
      while (l > ((agiq)this.mApp.getManager(317)).a(apqz.lb(localapcy.FileName)).cOv)
      {
        paramUUID = new apcl(this, localTroopFileTransferManager, paramUUID);
        paramUUID = aqha.a(this.mActivity, 230, getString(2131699824), (String)localObject, 2131721058, 2131699913, paramUUID, paramUUID);
        localObject = aiyw.a(this.mActivity, this.mApp, 2, (String)localObject);
        if ((localObject instanceof SpannableString)) {
          paramUUID.setMessageWithoutAutoLink((CharSequence)localObject);
        }
        paramUUID.show();
        return;
        localObject = getString(2131699607);
        l = 0L;
      }
      localTroopFileTransferManager.c(paramUUID);
      return;
    }
    localTroopFileTransferManager.c(paramUUID);
  }
  
  public void c(apbr paramapbr)
  {
    paramapbr = new apcm(this, paramapbr);
    aqha.a(this.mActivity, 230, getString(2131699502), getString(2131699501), 2131721058, 2131721079, paramapbr, paramapbr).show();
  }
  
  public void d(apbr paramapbr)
  {
    paramapbr = new apcn(this, paramapbr);
    aqha.a(this.mActivity, 230, getString(2131699498), getString(2131699497), 2131721058, 2131721079, paramapbr, paramapbr).show();
  }
  
  public void e(apbr paramapbr)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.mApp, this.mTroopUin);
    ThreadManager.post(new TroopFileItemOperation.9(this, localTroopFileTransferManager), 8, new apcc(this, localTroopFileTransferManager, paramapbr), false);
  }
  
  public void f(apbr paramapbr)
  {
    int i = K(false);
    Object localObject = new apce(this, paramapbr);
    if (i == 1) {}
    for (paramapbr = b(2131699608, new Object[] { apsv.oR(paramapbr.str_file_name), paramapbr.AV() });; paramapbr = b(2131699915, new Object[] { apsv.oR(paramapbr.str_file_name) }))
    {
      localObject = aqha.a(this.mActivity, 230, getString(2131699914), paramapbr, 2131721058, 2131699913, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
      if (i == 1)
      {
        paramapbr = aiyw.a(this.mActivity, this.mApp, 2, paramapbr);
        if ((paramapbr instanceof SpannableString)) {
          ((aqju)localObject).setMessageWithoutAutoLink(paramapbr);
        }
      }
      ((aqju)localObject).show();
      return;
    }
  }
  
  public void g(apbr paramapbr)
  {
    boolean bool2 = false;
    ausj localausj = (ausj)auss.a(this.mActivity, null);
    String[] arrayOfString = this.mActivity.getResources().getStringArray(2130969882);
    boolean bool1 = bool2;
    if (paramapbr.Status == 11)
    {
      bool1 = bool2;
      if (ahbj.fileExistsAndNotEmpty(paramapbr.LocalFile))
      {
        localausj.addButton(arrayOfString[0], 1);
        bool1 = true;
      }
    }
    if ((apsv.n(this.mApp, this.mTroopUin)) || (this.mApp.getCurrentAccountUin().equals(paramapbr.AW()))) {
      localausj.addButton(arrayOfString[1], 1);
    }
    localausj.a(new apcf(this, bool1, paramapbr, localausj));
    localausj.addCancelButton(2131721058);
    localausj.show();
  }
  
  public void h(apbr paramapbr)
  {
    String str1 = this.mActivity.getString(2131699552);
    String str2 = String.format(this.mActivity.getString(2131699539), new Object[] { apsv.oR(paramapbr.str_file_name) });
    aqju localaqju = aqha.b(this.mActivity, 230);
    localaqju.setTitle(str1).setMessage(str2);
    localaqju.setPositiveButton(this.mActivity.getString(2131721079), new apcg(this, paramapbr));
    localaqju.show();
  }
  
  public void i(apbr paramapbr)
  {
    if (Lh() != 0)
    {
      apsf.a(this.mApp, this.mTroopUin).c(paramapbr);
      anot.a(this.mApp, "CliOper", "", "", "Grp", "Clk_trans_save", 0, 0, "", this.mTroopUin + "", "", "");
    }
  }
  
  public void i(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    if (Lh() == 0) {}
    TroopFileTransferManager localTroopFileTransferManager;
    do
    {
      return;
      localTroopFileTransferManager = TroopFileTransferManager.a(this.mApp, this.mTroopUin);
      Object localObject = apqz.lb(paramString2);
      localObject = ((agiq)this.mApp.getManager(317)).a((String)localObject);
      if ((!ahav.amK()) || (paramLong <= ((aepv.a)localObject).cOv)) {
        break;
      }
    } while (!armm.a(this.mActivity, 1, new apci(this, localTroopFileTransferManager, paramString1, paramString2, paramLong, paramInt)));
    paramString1 = new apcj(this, localTroopFileTransferManager, paramString1, paramString2, paramLong, paramInt);
    paramString2 = b(2131699606, new Object[] { apsv.oR(paramString2), apsv.getFileSizeDesc(paramLong) });
    paramString1 = aqha.a(this.mActivity, 230, getString(2131699824), paramString2, 2131721058, 2131699542, paramString1, paramString1);
    paramString2 = aiyw.a(this.mActivity, this.mApp, 2, paramString2);
    if ((paramString2 instanceof SpannableString)) {
      paramString1.setMessageWithoutAutoLink(paramString2);
    }
    paramString1.show();
    return;
    localTroopFileTransferManager.a(paramString1, paramString2, paramLong, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apca
 * JD-Core Version:    0.7.0.1
 */