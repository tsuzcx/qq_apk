import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop.TroopFileProxyActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class agjt
  extends agjs
{
  private boolean cdF = true;
  private boolean cdG;
  private MessageForTroopFile d;
  
  public agjt(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
  }
  
  private void a(int paramInt, apcy paramapcy, ArrayList<Integer> paramArrayList)
  {
    long l = ahav.d(this.mApp, paramapcy.FileName);
    paramArrayList.add(Integer.valueOf(9));
    paramArrayList.add(Integer.valueOf(10));
    if ((this.d != null) && (this.d.fileSize <= l) && (a(paramapcy, false))) {
      paramArrayList.add(Integer.valueOf(21));
    }
    paramArrayList.add(Integer.valueOf(20));
    if ((this.d.extraflag != 32768) && (!this.mApp.a().aR(this.d))) {
      paramArrayList.add(Integer.valueOf(14));
    }
    if (paramInt == 1) {
      paramArrayList.add(Integer.valueOf(19));
    }
    paramArrayList.add(Integer.valueOf(15));
    if (wja.eU(5) == 1) {
      paramArrayList.add(Integer.valueOf(17));
    }
    paramArrayList.add(Integer.valueOf(11));
    if (augo.g(this.mApp, this.d)) {
      paramArrayList.add(Integer.valueOf(25));
    }
  }
  
  private void a(long paramLong, Activity paramActivity, UUID paramUUID)
  {
    paramUUID = new agju(this, paramLong, paramUUID, paramActivity);
    aqha.a(paramActivity, 230, this.mContext.getString(2131699498), this.mContext.getString(2131699520), 2131699496, 2131699507, paramUUID, paramUUID).show();
  }
  
  private void a(long paramLong, Activity paramActivity, UUID paramUUID, ChatMessage paramChatMessage)
  {
    paramUUID = new agjv(this, paramLong, paramUUID, paramChatMessage, paramActivity);
    aqha.a(paramActivity, 230, this.mContext.getString(2131699502), this.mContext.getString(2131699521), 2131699500, 2131699509, paramUUID, paramUUID).show();
  }
  
  private void a(apcy paramapcy, int paramInt)
  {
    if (paramInt == 0)
    {
      apsd.ck(this.mContext, this.mContext.getString(2131699827));
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 0);
    Object localObject = ahav.a(paramapcy);
    ((FileManagerEntity)localObject).status = 2;
    ((FileManagerEntity)localObject).nOpType = 24;
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.p(((FileManagerEntity)localObject).nSessionId);
    localForwardFileInfo.setType(10006);
    if (!TextUtils.isEmpty(((FileManagerEntity)localObject).getFilePath())) {
      localForwardFileInfo.setLocalPath(paramapcy.LocalFile);
    }
    localForwardFileInfo.setFileName(paramapcy.FileName);
    localForwardFileInfo.setFileSize(paramapcy.ProgressTotal);
    localForwardFileInfo.jA(Long.parseLong(this.d.frienduin));
    if (paramapcy.Id != null) {
      localForwardFileInfo.Ja(paramapcy.Id.toString());
    }
    if (!TextUtils.isEmpty(paramapcy.ThumbnailFile_Large)) {
      localForwardFileInfo.aA(paramapcy.ThumbnailFile_Large);
    }
    for (;;)
    {
      localForwardFileInfo.Oj(1);
      localForwardFileInfo.Oh(1);
      localBundle.putParcelable("fileinfo", localForwardFileInfo);
      localBundle.putBoolean("not_forward", true);
      localObject = new Intent();
      ((Intent)localObject).putExtras(localBundle);
      ((Intent)localObject).putExtra("forward_text", paramapcy.FileName);
      ((Intent)localObject).putExtra("forward_from_troop_file", true);
      localBundle.putInt("forward_source_uin_type", this.h.cZ);
      ((Intent)localObject).putExtra("direct_send_if_dataline_forward", true);
      ((Intent)localObject).putExtra("forward _key_nojump", true);
      ((Intent)localObject).putExtra("sender_uin", this.d.senderuin);
      ((Intent)localObject).putExtra("last_time", this.d.lastTime);
      ahgq.f((Activity)this.mContext, (Intent)localObject, 21);
      if (this.d.isMultiMsg) {
        anot.a(this.mApp, "dc00898", "", "", "0X8009D66", "0X8009D66", 8, 0, "8", "", "", "");
      }
      anot.a(this.mApp, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
      return;
      if (!TextUtils.isEmpty(paramapcy.coc)) {
        localForwardFileInfo.aA(paramapcy.coc);
      }
    }
  }
  
  private void a(TroopFileTransferManager paramTroopFileTransferManager, apcy paramapcy, int paramInt)
  {
    if (paramInt == 0) {
      apsd.ck(this.mContext, this.mContext.getString(2131699827));
    }
    while ((paramapcy.Status != 1) && (paramapcy.Status != 0) && (paramapcy.Status != 2) && (paramapcy.Status != 3)) {
      return;
    }
    paramTroopFileTransferManager.a(paramapcy.Id);
    a(paramapcy.TroopUin, (Activity)this.mContext, paramapcy.Id, this.d);
  }
  
  private boolean a(apcy paramapcy, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (this.cdF)
    {
      this.cdG = aetq.a().ahT();
      this.cdF = false;
    }
    long l1 = ahav.d(this.mApp, paramapcy.FileName);
    String str2 = aeuc.a().ud();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = aobw.cjR;
    }
    long l2 = ahav.getFileSizes(paramapcy.FilePath);
    boolean bool1 = bool2;
    int i;
    if (this.cdG)
    {
      bool1 = bool2;
      if (aobw.v(paramapcy.FilePath, paramapcy.FileName, str1))
      {
        bool1 = bool2;
        if (l2 <= l1)
        {
          if (!paramBoolean) {
            break label196;
          }
          if (TextUtils.isEmpty(paramapcy.FilePath)) {
            break label191;
          }
          if (aqhq.fileExistsAndNotEmpty(paramapcy.FilePath)) {
            break label196;
          }
          i = 0;
        }
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i != 0)
      {
        anot.a(this.mApp, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
        bool1 = true;
      }
      return bool1;
      label191:
      i = 0;
      continue;
      label196:
      i = 1;
    }
  }
  
  private boolean a(MessageForTroopFile paramMessageForTroopFile)
  {
    boolean bool2 = false;
    apcy localapcy = apsv.a(this.mApp, paramMessageForTroopFile);
    if (localapcy == null) {}
    boolean bool1;
    do
    {
      return true;
      bool1 = bool2;
      if (paramMessageForTroopFile.lastTime != 0L)
      {
        bool1 = bool2;
        if (paramMessageForTroopFile.lastTime <= NetConnInfoCenter.getServerTime()) {
          bool1 = true;
        }
      }
    } while (localapcy.Status == 12);
    return bool1;
  }
  
  private void b(int paramInt, apcy paramapcy, ArrayList<Integer> paramArrayList)
  {
    long l = ahav.d(this.mApp, paramapcy.FileName);
    paramArrayList.add(Integer.valueOf(9));
    if ((this.d != null) && (this.d.fileSize <= l) && (a(paramapcy, false))) {
      paramArrayList.add(Integer.valueOf(21));
    }
    if ((this.d.extraflag != 32768) && (!this.mApp.a().aR(this.d))) {
      paramArrayList.add(Integer.valueOf(14));
    }
    paramArrayList.add(Integer.valueOf(20));
    paramArrayList.add(Integer.valueOf(10));
    paramArrayList.add(Integer.valueOf(11));
    if (paramInt == 1) {
      paramArrayList.add(Integer.valueOf(19));
    }
    paramArrayList.add(Integer.valueOf(15));
    if (wja.eU(5) == 1) {
      paramArrayList.add(Integer.valueOf(17));
    }
    if (augo.g(this.mApp, this.d)) {
      paramArrayList.add(Integer.valueOf(25));
    }
  }
  
  private void b(apcy paramapcy)
  {
    FileManagerEntity localFileManagerEntity = ahav.a(paramapcy);
    paramapcy = apsf.a(this.mApp, paramapcy.TroopUin).a(localFileManagerEntity.strTroopFilePath);
    if (paramapcy != null)
    {
      localFileManagerEntity.lastTime = paramapcy.dTh;
      localFileManagerEntity.selfUin = String.valueOf(paramapcy.aqT);
    }
    new aviz(3).a(this.mApp, (Activity)this.mContext, localFileManagerEntity, this.d, false);
    if (this.d.isMultiMsg) {
      anot.a(this.mApp, "dc00898", "", "", "0X8009D67", "0X8009D67", 8, 0, "8", "", "", "");
    }
  }
  
  private void c(int paramInt, apcy paramapcy, ArrayList<Integer> paramArrayList)
  {
    long l = ahav.d(this.mApp, paramapcy.FileName);
    if (!ahbj.isFileExists(paramapcy.LocalFile)) {
      TroopFileTransferManager.a(this.mApp, Long.parseLong(this.d.frienduin)).aBu();
    }
    do
    {
      return;
      if ((!TextUtils.isEmpty(paramapcy.LocalFile)) && (aqhq.rr(paramapcy.LocalFile))) {
        paramArrayList.add(Integer.valueOf(13));
      }
      paramArrayList.add(Integer.valueOf(9));
      paramArrayList.add(Integer.valueOf(10));
      paramArrayList.add(Integer.valueOf(11));
      if ((this.d != null) && (this.d.fileSize <= l) && (a(paramapcy, false))) {
        paramArrayList.add(Integer.valueOf(21));
      }
      if ((this.d.extraflag != 32768) && (!this.mApp.a().aR(this.d))) {
        paramArrayList.add(Integer.valueOf(14));
      }
      paramArrayList.add(Integer.valueOf(20));
      if (paramInt == 1) {
        paramArrayList.add(Integer.valueOf(19));
      }
      paramArrayList.add(Integer.valueOf(15));
      if (wja.eU(5) == 1) {
        paramArrayList.add(Integer.valueOf(17));
      }
    } while (!augo.g(this.mApp, this.d));
    paramArrayList.add(Integer.valueOf(25));
  }
  
  private void c(apcy paramapcy)
  {
    if (paramapcy == null) {}
    do
    {
      return;
      TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
      localTeamWorkFileImportInfo.filePath = paramapcy.LocalFile;
      localTeamWorkFileImportInfo.fileName = paramapcy.FileName;
      localTeamWorkFileImportInfo.dNS = ahav.getFileType(paramapcy.FileName);
      localTeamWorkFileImportInfo.isFromAIO = true;
      localTeamWorkFileImportInfo.dNQ = 1;
      localTeamWorkFileImportInfo.fileSize = this.d.fileSize;
      localTeamWorkFileImportInfo.cjE = paramapcy.FilePath;
      localTeamWorkFileImportInfo.dNP = paramapcy.BusId;
      localTeamWorkFileImportInfo.troopUin = this.h.troopUin;
      localTeamWorkFileImportInfo.peerUin = this.h.aTl;
      if (paramapcy.Status != 12) {
        localTeamWorkFileImportInfo.cKX = true;
      }
      localTeamWorkFileImportInfo.peerType = 1;
      aoag.a(localTeamWorkFileImportInfo, this.mContext, this.mApp, localTeamWorkFileImportInfo.dNQ);
      anot.a(this.mApp, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
    } while (!this.d.isMultiMsg);
    anot.a(this.mApp, "dc00898", "", "", "0X8009D69", "0X8009D69", 0, 0, "", "", "", "");
  }
  
  private void d(int paramInt, apcy paramapcy, ArrayList<Integer> paramArrayList)
  {
    paramArrayList.add(Integer.valueOf(9));
    if (wja.eU(5) == 1) {
      paramArrayList.add(Integer.valueOf(17));
    }
  }
  
  private void dgZ()
  {
    anot.a(this.mApp, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, this.d.frienduin + "", "", "", "");
    Object localObject = apsv.a(this.mApp, this.d);
    if (((apcy)localObject).Status == 12)
    {
      localObject = String.format(this.mContext.getString(2131699539), new Object[] { apsv.oR(((apcy)localObject).FileName) });
      apsd.y(this.mContext, (String)localObject, 1);
      return;
    }
    Intent localIntent = new Intent();
    if (avlx.a().L(((apcy)localObject).LocalFile, this.d.fileSize))
    {
      avlx.a().L(this.mContext, ((apcy)localObject).LocalFile, true);
      return;
    }
    switch (((apcy)localObject).Status)
    {
    case 0: 
    case 4: 
    case 5: 
    default: 
      return;
    case 1: 
    case 2: 
    case 3: 
      localIntent.putExtra(TroopFileProxyActivity.cjr, this.d.frienduin);
      TroopFileProxyActivity.b((Activity)this.mContext, localIntent, this.mApp.getCurrentAccountUin());
      return;
    }
    long l = Long.valueOf(this.h.aTl).longValue();
    ahbr.a(this.mApp, this.mContext, this.h, this.d, l, (apcy)localObject, this.d.senderuin, this.d.lastTime, 3, 3, null, false, false);
  }
  
  private void dhf()
  {
    TroopInfo localTroopInfo = ((TroopManager)this.mApp.getManager(52)).b(this.h.aTl);
    String str2 = "2";
    String str1 = str2;
    if (localTroopInfo != null)
    {
      if ((localTroopInfo.troopowneruin != null) && (localTroopInfo.troopowneruin.equals(this.mApp.getCurrentAccountUin()))) {
        str1 = "1";
      }
    }
    else
    {
      if (ahav.getFileType(this.d.fileName) != 0) {
        break label150;
      }
      str2 = "1";
    }
    for (;;)
    {
      anot.a(this.mApp, "dc00899", "Grp_files", "", "remove_file", "remove_clk", 0, 0, this.h.aTl, "", str1, str2);
      return;
      str1 = str2;
      if (localTroopInfo.Administrator == null) {
        break;
      }
      str1 = str2;
      if (!localTroopInfo.Administrator.equals(this.mApp.getCurrentAccountUin())) {
        break;
      }
      str1 = "2";
      break;
      label150:
      if (ahav.getFileType(this.d.fileName) == 2) {
        str2 = "2";
      } else {
        str2 = "3";
      }
    }
  }
  
  private void e(int paramInt, apcy paramapcy, ArrayList<Integer> paramArrayList)
  {
    long l = ahav.d(this.mApp, paramapcy.FileName);
    paramArrayList.add(Integer.valueOf(9));
    if ((this.d != null) && (this.d.fileSize <= l) && (a(paramapcy, false))) {
      paramArrayList.add(Integer.valueOf(21));
    }
    if (wja.eU(5) == 1) {
      paramArrayList.add(Integer.valueOf(17));
    }
  }
  
  private void f(int paramInt, apcy paramapcy, ArrayList<Integer> paramArrayList)
  {
    long l = ahav.d(this.mApp, paramapcy.FileName);
    paramArrayList.add(Integer.valueOf(9));
    if ((this.d != null) && (this.d.fileSize <= l) && (a(paramapcy, false))) {
      paramArrayList.add(Integer.valueOf(21));
    }
    if (wja.eU(5) == 1) {
      paramArrayList.add(Integer.valueOf(17));
    }
  }
  
  private void g(int paramInt, apcy paramapcy, ArrayList<Integer> paramArrayList)
  {
    long l = ahav.d(this.mApp, paramapcy.FileName);
    if (!ahbj.isFileExists(paramapcy.LocalFile)) {
      TroopFileTransferManager.a(this.mApp, Long.parseLong(this.d.frienduin)).aBu();
    }
    do
    {
      return;
      paramArrayList.add(Integer.valueOf(9));
      if ((this.d != null) && (this.d.fileSize <= l) && (a(paramapcy, false))) {
        paramArrayList.add(Integer.valueOf(21));
      }
    } while (wja.eU(5) != 1);
    paramArrayList.add(Integer.valueOf(17));
  }
  
  private void gH(View paramView)
  {
    if ((this.d.isMultiMsg) && (!ahav.a(this.d, this.mApp, this.mContext))) {}
    apcy localapcy;
    apca localapca;
    long l;
    do
    {
      return;
      localapcy = apsv.a(this.mApp, this.d);
      if (localapcy == null)
      {
        QLog.e("TroopFileBubbleModel", 1, "item click class but can not find.");
        return;
      }
      localapca = new apca(Long.parseLong(this.d.frienduin), this.mApp, (Activity)this.mContext);
      l = Long.valueOf(this.d.frienduin).longValue();
      paramView = sxx.getViewRect(paramView);
      if (localapcy.Status == 12)
      {
        paramView = String.format(this.mContext.getString(2131699539), new Object[] { apsv.oR(localapcy.FileName) });
        apsd.y(this.mContext, paramView, 1);
        return;
      }
    } while ((localapcy.Status == 4) || (localapcy.Status == 5) || (localapcy.Status == 13));
    if (((localapcy.Status == 3) || (localapcy.Status == 2)) && (!ahav.amK()))
    {
      localapca.a(localapcy.Id);
      return;
    }
    anot.a(this.mApp, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, this.d.frienduin + "", "", "", "");
    anot.a(this.mApp, "dc00899", "Grp_files", "", "Grp_AIO", "clk_videoBubble", 0, 0, this.d.frienduin + "", "", "", "");
    if (a(this.d))
    {
      paramView = String.format(this.mContext.getString(2131699539), new Object[] { apsv.oR(localapcy.FileName) });
      apsd.y(this.mContext, paramView, 1);
      return;
    }
    ahbr.a(this.mApp, this.mContext, this.h, this.d, l, localapcy, this.d.senderuin, this.d.lastTime, 3, 3, paramView, false, false);
  }
  
  private void gI(View paramView)
  {
    if ((this.d.isMultiMsg) && (!ahav.a(this.d, this.mApp, this.mContext))) {
      return;
    }
    apcy localapcy = apsv.a(this.mApp, this.d);
    if (localapcy == null)
    {
      QLog.e("TroopFileBubbleModel", 1, "item click class but can not find.");
      return;
    }
    switch (localapcy.Status)
    {
    case 4: 
    case 5: 
    default: 
      anot.a(this.mApp, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, this.d.frienduin + "", "", "", "");
      anot.a(this.mApp, "dc00899", "Grp_files", "", "Grp_AIO", "clk_picBubble", 0, 0, this.d.frienduin + "", "", "", "");
      xkl.a(this.mApp, this.mContext, paramView, this.d, this.h, false, true, true, null);
      return;
    }
    paramView = new Intent();
    paramView.putExtra(TroopFileProxyActivity.cjr, this.d.frienduin);
    TroopFileProxyActivity.b((Activity)this.mContext, paramView, this.mApp.getCurrentAccountUin());
  }
  
  public int Eh()
  {
    if (this.d == null) {
      return 0;
    }
    return this.d.width;
  }
  
  public int Ei()
  {
    if (this.d == null) {
      return 0;
    }
    return this.d.height;
  }
  
  public int Ej()
  {
    if (this.d == null) {
      return -1;
    }
    boolean bool = this.d.isSend();
    if (this.d.isMultiMsg) {
      bool = ahav.c(this.mApp, this.d);
    }
    apcy localapcy = apsv.a(this.mApp, this.d);
    switch (localapcy.Status)
    {
    case 2: 
    case 4: 
    case 5: 
    case 7: 
    case 9: 
    default: 
    case 0: 
    case 1: 
    case 6: 
    case 8: 
    case 11: 
      do
      {
        do
        {
          do
          {
            return 0;
            return 1;
          } while (!aqhq.fileExistsAndNotEmpty(localapcy.LocalFile));
          return 2;
          return 4;
          if (!bool) {
            break;
          }
        } while (!aqhq.fileExistsAndNotEmpty(localapcy.LocalFile));
        return 2;
      } while (!aqhq.fileExistsAndNotEmpty(localapcy.LocalFile));
      return 5;
    case 3: 
      return 3;
    }
    return 6;
  }
  
  public int Ek()
  {
    if (this.d == null) {}
    apcy localapcy;
    do
    {
      return 0;
      localapcy = apsv.a(this.mApp, this.d);
    } while (localapcy == null);
    return apsv.h(localapcy.ProgressValue, localapcy.ProgressTotal);
  }
  
  public int El()
  {
    apcy localapcy = apsv.a(this.mApp, this.d);
    if (localapcy == null) {}
    while (localapcy.genThumb_Middle_OnGettedLargeOrOrigPic) {
      return 0;
    }
    if (ahbr.b(localapcy.dTo, localapcy.dTp, localapcy.ProgressTotal)) {
      return 1;
    }
    if (localapcy.thumbInvalidCode == 1) {
      return 1;
    }
    if (localapcy.thumbInvalidCode == 2) {
      return 2;
    }
    return super.El();
  }
  
  public void NU(int paramInt)
  {
    if (this.d == null) {}
    TroopFileTransferManager localTroopFileTransferManager;
    apcy localapcy;
    int i;
    apca localapca;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              localTroopFileTransferManager = TroopFileTransferManager.a(this.mApp, Long.parseLong(this.d.frienduin));
            } while (localTroopFileTransferManager == null);
            localapcy = apsv.a(this.mApp, this.d);
          } while (localapcy == null);
          i = aqiw.getSystemNetwork(this.mContext);
          localapca = new apca(Long.parseLong(this.d.frienduin), this.mApp, (Activity)this.mContext);
          switch (paramInt)
          {
          default: 
            return;
          }
        } while ((localapcy.Status != 8) && (localapcy.Status != 9) && (localapcy.Status != 10));
        localTroopFileTransferManager.d(localapcy.Id);
        a(localapcy.TroopUin, (Activity)this.mContext, localapcy.Id);
        return;
        if (i == 0)
        {
          apsd.ck(this.mContext, this.mContext.getString(2131699827));
          return;
        }
        anot.a(this.mApp, "CliOper", "", "", "Grp", "Up_pause_upload", 0, 0, "", this.d.frienduin, "", "");
      } while ((localapcy.Status != 0) && (localapcy.Status != 1));
      localTroopFileTransferManager.a(localapcy.Id);
      return;
    } while ((localapcy.Status != 2) && (localapcy.Status != 3));
    localapca.a(localapcy.Id);
    return;
    a(localTroopFileTransferManager, localapcy, i);
    return;
    a(localapcy, i);
    return;
    apsv.d((Activity)this.mContext, this.mApp, this.d);
    return;
    ahav.by((Activity)this.mContext, localapcy.LocalFile);
    return;
    anot.a(null, "dc00898", "", "", "0X800A60C", "0X800A60C", 0, 0, "", "", "", "");
    apsv.c(this.mContext, this.mApp, this.d);
    return;
    b(localapcy);
    return;
    dhf();
    return;
    c(localapcy);
    return;
    anot.a(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 3, 0, "", "", "", "");
    ahbr.a(this.mApp, this.mContext, this.h, this.d, localapcy.TroopUin, localapcy, this.d.senderuin, this.d.lastTime, 3, 3, null, true, false);
    return;
    ((augo)this.mApp.getManager(374)).B(this.d);
  }
  
  protected void R(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForTroopFile))
    {
      QLog.e("TroopFileBubbleModel", 1, "setBubbleModelData. is not a MessageForTroopFile");
      return;
    }
    this.d = ((MessageForTroopFile)paramChatMessage);
  }
  
  public aghj a()
  {
    return new aghn(this.mApp, this.mContext);
  }
  
  public aghl a()
  {
    return new agho(this.mApp, this.mContext);
  }
  
  public List<Integer> ab(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.d == null) {
      return localArrayList;
    }
    apcy localapcy = apsv.a(this.mApp, this.d);
    if (localapcy == null) {
      return localArrayList;
    }
    if (((ahbr.aM(this.mApp)) || (ahbj.fileExistsAndNotEmpty(localapcy.LocalFile))) && (localapcy.Status != 12) && (ahav.getFileType(this.d.fileName) == 2)) {
      localArrayList.add(Integer.valueOf(12));
    }
    ahav.d(this.mApp, localapcy.FileName);
    Boolean localBoolean2 = Boolean.valueOf(false);
    Boolean localBoolean1 = localBoolean2;
    switch (localapcy.Status)
    {
    default: 
      localBoolean1 = localBoolean2;
    case 4: 
      if (localBoolean1.booleanValue()) {
        anot.a(this.mApp, "CliOper", "", "", "Grp", "Up_press_files", 0, 0, "", this.d.frienduin, "", "");
      }
      break;
    }
    for (;;)
    {
      localArrayList.add(Integer.valueOf(18));
      return localArrayList;
      localArrayList.add(Integer.valueOf(7));
      localArrayList.add(Integer.valueOf(6));
      localBoolean1 = Boolean.valueOf(true);
      break;
      localArrayList.add(Integer.valueOf(8));
      localArrayList.add(Integer.valueOf(6));
      localBoolean1 = Boolean.valueOf(true);
      break;
      localArrayList.add(Integer.valueOf(8));
      localArrayList.add(Integer.valueOf(6));
      localBoolean1 = Boolean.valueOf(true);
      break;
      localArrayList.add(Integer.valueOf(9));
      localArrayList.add(Integer.valueOf(10));
      if ((this.d.extraflag != 32768) && (!this.mApp.a().aR(this.d))) {
        localArrayList.add(Integer.valueOf(14));
      }
      localArrayList.add(Integer.valueOf(20));
      localArrayList.add(Integer.valueOf(15));
      localBoolean1 = localBoolean2;
      if (wja.eU(5) != 1) {
        break;
      }
      localArrayList.add(Integer.valueOf(17));
      localBoolean1 = localBoolean2;
      break;
      localArrayList.add(Integer.valueOf(3));
      localArrayList.add(Integer.valueOf(9));
      localArrayList.add(Integer.valueOf(10));
      if ((this.d.extraflag != 32768) && (!this.mApp.a().aR(this.d))) {
        localArrayList.add(Integer.valueOf(14));
      }
      localArrayList.add(Integer.valueOf(20));
      localArrayList.add(Integer.valueOf(15));
      localBoolean1 = localBoolean2;
      if (wja.eU(5) != 1) {
        break;
      }
      localArrayList.add(Integer.valueOf(17));
      localBoolean1 = localBoolean2;
      break;
      localArrayList.add(Integer.valueOf(3));
      localArrayList.add(Integer.valueOf(10));
      if ((this.d.extraflag != 32768) && (!this.mApp.a().aR(this.d))) {
        localArrayList.add(Integer.valueOf(14));
      }
      localArrayList.add(Integer.valueOf(15));
      localBoolean1 = localBoolean2;
      break;
      b(paramInt, localapcy, localArrayList);
      localBoolean1 = Boolean.valueOf(true);
      break;
      c(paramInt, localapcy, localArrayList);
      localBoolean1 = localBoolean2;
      break;
      a(paramInt, localapcy, localArrayList);
      localBoolean1 = localBoolean2;
      break;
      localArrayList.add(Integer.valueOf(15));
      localBoolean1 = localBoolean2;
      break;
      localArrayList.add(Integer.valueOf(15));
      localBoolean1 = localBoolean2;
      break;
      anot.a(this.mApp, "CliOper", "", "", "Grp", "Down_press_files", 0, 0, "", this.d.frienduin, "", "");
    }
  }
  
  public List<Integer> ac(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.d == null) {}
    apcy localapcy;
    do
    {
      do
      {
        return localArrayList;
        localapcy = apsv.a(this.mApp, this.d);
      } while (localapcy == null);
      if (((ahbr.aM(this.mApp)) || (ahbj.fileExistsAndNotEmpty(localapcy.LocalFile))) && (localapcy != null) && (localapcy.Status != 12) && (ahav.getFileType(localapcy.FileName) == 2)) {
        localArrayList.add(Integer.valueOf(12));
      }
      ahav.d(this.mApp, localapcy.FileName);
      switch (localapcy.Status)
      {
      case 0: 
      case 1: 
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 10: 
      case 12: 
      default: 
        return localArrayList;
      case 6: 
        e(paramInt, localapcy, localArrayList);
        return localArrayList;
      case 8: 
        localArrayList.add(Integer.valueOf(9));
      }
    } while (wja.eU(5) != 1);
    localArrayList.add(Integer.valueOf(17));
    return localArrayList;
    d(paramInt, localapcy, localArrayList);
    return localArrayList;
    g(paramInt, localapcy, localArrayList);
    return localArrayList;
    f(paramInt, localapcy, localArrayList);
    return localArrayList;
  }
  
  public boolean alo()
  {
    if (this.d == null) {
      return false;
    }
    return this.d.isSend();
  }
  
  public boolean alp()
  {
    if (this.d == null) {}
    while (apsv.a(this.mApp, this.d).Status != 3) {
      return false;
    }
    return true;
  }
  
  public boolean alq()
  {
    boolean bool = true;
    if (this.d == null) {}
    apcy localapcy;
    do
    {
      return false;
      localapcy = apsv.a(this.mApp, this.d);
    } while ((localapcy == null) || (this.d.isMultiMsg));
    int i = ahav.getFileType(localapcy.FileName);
    if ((i == 2) || (i == 0))
    {
      if (!this.d.isSend()) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
    return true;
  }
  
  public int bF()
  {
    int i = 3;
    if (this.d == null) {
      return 0;
    }
    apcy localapcy = apsv.a(this.mApp, this.d);
    if ((this.d.lastTime != 0L) && (this.d.lastTime <= NetConnInfoCenter.getServerTime())) {
      return 6;
    }
    if (localapcy.Status == 12) {
      return 1;
    }
    switch (localapcy.Status)
    {
    case 4: 
    default: 
      i = 0;
    }
    for (;;)
    {
      return i;
      i = 0;
      continue;
      i = 2;
      continue;
      i = 4;
      continue;
      i = 5;
      continue;
      i = 2;
      continue;
      i = 2;
    }
  }
  
  public void dgX()
  {
    int j = 383;
    if (this.cdE)
    {
      dhe();
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileBubbleModel", 1, "fetchFileThumb.");
      }
      if (this.d != null) {
        break label39;
      }
    }
    label39:
    TroopFileTransferManager localTroopFileTransferManager;
    apcy localapcy;
    int i;
    for (;;)
    {
      return;
      localTroopFileTransferManager = TroopFileTransferManager.a(this.mApp, Long.parseLong(this.d.frienduin));
      localapcy = apsv.a(this.mApp, this.d);
      if (localapcy != null)
      {
        if (ahbj.fileExistsAndNotEmpty(localapcy.LocalFile)) {
          i = j;
        }
        while (localapcy.Status != 12)
        {
          if (localapcy.Id == null) {
            break label160;
          }
          localTroopFileTransferManager.a(localapcy.Id, i);
          return;
          i = j;
          if (ahbh.aY(this.d.width, this.d.height))
          {
            i = j;
            if (!ahbj.fileExistsAndNotEmpty(localapcy.ThumbnailFile_Large)) {
              i = 640;
            }
          }
        }
      }
    }
    label160:
    localTroopFileTransferManager.e(localapcy.FilePath, localapcy.FileName, localapcy.BusId, i);
  }
  
  public void dgY()
  {
    if (this.d == null) {
      return;
    }
    String str = this.d.fileName + this.d.url;
    if (!this.mApp.a().mA(str))
    {
      anot.a(null, "dc00898", "", "", "0X800A685", "0X800A685", 0, 0, "", "", "", "");
      this.mApp.a().IZ(str);
    }
    this.mApp.a().a().dgD();
  }
  
  public void dha()
  {
    if (this.d == null) {}
    do
    {
      return;
      localObject = apsv.a(this.mApp, this.d);
    } while ((localObject == null) || (((apcy)localObject).Status != 3));
    Object localObject = (Activity)this.mContext;
    Intent localIntent = new Intent();
    localIntent.putExtra(TroopFileProxyActivity.cjr, this.d.frienduin);
    TroopFileProxyActivity.b((Activity)localObject, localIntent, this.mApp.getCurrentAccountUin());
  }
  
  public void dhd()
  {
    if (this.d == null) {
      return;
    }
    Activity localActivity = (Activity)this.mContext;
    Intent localIntent = new Intent();
    localIntent.putExtra(TroopFileProxyActivity.cjr, this.d.frienduin);
    TroopFileProxyActivity.a(localActivity, localIntent, this.mApp.getCurrentAccountUin());
  }
  
  public long fE()
  {
    if (this.d == null) {}
    long l;
    do
    {
      return 0L;
      if (apsv.a(this.mApp, this.d).Status == 12) {
        return -1L;
      }
      l = this.d.lastTime;
    } while (l == 0L);
    l -= anaz.gQ();
    if (l > 0L) {
      return l;
    }
    return -1L;
  }
  
  public String getFileName()
  {
    if (this.d == null) {
      return "";
    }
    apcy localapcy = apsv.a(this.mApp, this.d);
    if (localapcy == null) {
      return "";
    }
    return localapcy.FileName;
  }
  
  public long getFileSize()
  {
    if (this.d == null) {}
    apcy localapcy;
    do
    {
      return 0L;
      localapcy = apsv.a(this.mApp, this.d);
    } while (localapcy == null);
    return localapcy.ProgressTotal;
  }
  
  public void ia(int paramInt1, int paramInt2)
  {
    super.ia(paramInt1, paramInt2);
  }
  
  public void u(int paramInt, View paramView)
  {
    if (this.d == null) {
      return;
    }
    apcy localapcy = apsv.a(this.mApp, this.d);
    if (localapcy == null)
    {
      QLog.e("TroopFileBubbleModel", 1, "item click class but can not find.");
      return;
    }
    int i = 11;
    switch (ahav.getFileType(localapcy.FileName))
    {
    }
    for (;;)
    {
      anot.a(this.mApp, "dc00898", "", "", "0X800A68A", "0X800A68A", i, 0, "4", "", "", "");
      if (paramInt != 1) {
        break;
      }
      dgZ();
      return;
      i = 0;
      continue;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 5;
      continue;
      i = 6;
      continue;
      i = 7;
      continue;
      i = 8;
      continue;
      i = 9;
      continue;
      i = 10;
    }
    if (paramInt == 2)
    {
      gI(paramView);
      return;
    }
    if (paramInt == 3)
    {
      gH(paramView);
      return;
    }
    dgZ();
  }
  
  public String uZ()
  {
    apcy localapcy = apsv.a(this.mApp, this.d);
    if (localapcy == null) {
      return "";
    }
    if (!TextUtils.isEmpty(localapcy.coc)) {
      return localapcy.coc;
    }
    if (!TextUtils.isEmpty(localapcy.ThumbnailFile_Large)) {
      return localapcy.ThumbnailFile_Large;
    }
    return "";
  }
  
  public String va()
  {
    return this.mContext.getString(2131699437);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agjt
 * JD-Core Version:    0.7.0.1
 */