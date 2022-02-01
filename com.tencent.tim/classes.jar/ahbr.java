import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.filemanager.util.QFileUtils.2;
import com.tencent.mobileqq.filemanager.util.QFileUtils.5;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ahbr
{
  public static String D(String paramString1, String paramString2, String paramString3)
  {
    int i = paramString1.indexOf(paramString3);
    if (i < 0) {}
    do
    {
      int j;
      do
      {
        return paramString2;
        j = paramString1.indexOf("\n");
      } while (j <= i);
      paramString1 = paramString1.substring(i + paramString3.length(), j);
    } while ((paramString1.contains(paramString2)) || (paramString1.length() >= paramString2.length()));
    paramString2 = new StringBuilder(paramString2);
    paramString2.insert(paramString1.length(), "\n");
    return paramString2.toString();
  }
  
  public static String E(int paramInt, String paramString)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "x-dsc-";
    }
    for (;;)
    {
      return str + paramString;
      str = "micro-dsc-";
      continue;
      str = "minni-dsc-";
      continue;
      str = "small-dsc-";
      continue;
      str = "middle-dsc-";
      continue;
      str = "large-dsc-";
      continue;
      str = "qlarge-dsc-";
      continue;
      str = "xlarge-dsc-";
      continue;
      str = "qxlarge-dsc-";
      continue;
      str = "screen-dsc-";
    }
  }
  
  public static int EL()
  {
    int i = getIPStackType();
    if (1 == i) {
      return 1;
    }
    if (3 == i) {
      return 2;
    }
    if (2 == i) {
      return 3;
    }
    return 0;
  }
  
  public static int EM()
  {
    int i = MsfServiceSdk.get().getConnectedIPFamily();
    if (2 == i) {
      return 2;
    }
    if (1 == i) {
      return 1;
    }
    return 0;
  }
  
  public static String F(int paramInt, String paramString)
  {
    return paramInt + "@" + paramString;
  }
  
  public static boolean T(Context paramContext, String paramString)
  {
    if (ahav.getFileSizes(paramString) <= 10485760L) {
      return true;
    }
    ahal.a(paramContext, "", 2131700306, new ahbw(paramContext, paramString));
    return false;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (paramInt == 0) {}
    do
    {
      return 1;
      if (paramInt == 3000) {
        return 101;
      }
    } while (paramInt != 1);
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(52)).c(paramString);
    if (paramQQAppInterface != null)
    {
      if (paramQQAppInterface.isNewTroop) {
        return 113;
      }
      return 4;
    }
    return 4;
  }
  
  public static Intent a(QQAppInterface paramQQAppInterface, Activity paramActivity, FileManagerEntity paramFileManagerEntity)
  {
    int i = ahhq.e(paramFileManagerEntity);
    paramActivity = ahhq.a(paramFileManagerEntity);
    paramActivity.setType(i);
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putInt("forward_type", 0);
    paramQQAppInterface.putParcelable("fileinfo", paramActivity);
    paramQQAppInterface.putBoolean("not_forward", true);
    paramActivity = new Intent();
    paramActivity.putExtras(paramQQAppInterface);
    paramActivity.putExtra("destroy_last_activity", true);
    paramActivity.putExtra("forward_type", 0);
    paramActivity.putExtra("forward_filepath", paramFileManagerEntity.getFilePath());
    paramActivity.putExtra("forward_text", acfp.m(2131711127) + ahav.kY(paramFileManagerEntity.fileName) + acfp.m(2131711139) + ahbj.g(paramFileManagerEntity.fileSize) + "。");
    paramActivity.putExtra("k_favorites", ahav.q(paramFileManagerEntity));
    if ((!ahbj.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath())) && ((paramFileManagerEntity.getCloudType() == 6) || (paramFileManagerEntity.getCloudType() == 7)) && (paramFileManagerEntity.nFileType == 0)) {
      paramActivity.putExtra("forward_type", 0);
    }
    if ((paramFileManagerEntity.getCloudType() == 8) && (paramFileManagerEntity.nFileType == 0)) {
      paramActivity.putExtra("forward_type", 1);
    }
    return paramActivity;
  }
  
  public static Intent a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = ahav.d().longValue();
    localFileManagerEntity.status = 2;
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a().v(localFileManagerEntity);
    }
    apcy localapcy = apsv.a(paramQQAppInterface, localFileManagerEntity);
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.p(localFileManagerEntity.nSessionId);
    if (!TextUtils.isEmpty(localFileManagerEntity.getFilePath())) {
      localForwardFileInfo.setLocalPath(localapcy.LocalFile);
    }
    localForwardFileInfo.setFileName(localapcy.FileName);
    localForwardFileInfo.setFileSize(localapcy.ProgressTotal);
    localForwardFileInfo.jA(localFileManagerEntity.TroopUin);
    paramFileManagerEntity = localapcy.coc;
    paramQQAppInterface = paramFileManagerEntity;
    if (TextUtils.isEmpty(paramFileManagerEntity)) {
      paramQQAppInterface = localapcy.ThumbnailFile_Large;
    }
    localForwardFileInfo.aA(paramQQAppInterface);
    if (localFileManagerEntity.isZipInnerFile)
    {
      localForwardFileInfo.setType(10000);
      localForwardFileInfo.Oj(3);
    }
    for (;;)
    {
      localForwardFileInfo.Oh(2);
      paramQQAppInterface = new Bundle();
      paramQQAppInterface.putInt("forward_type", 0);
      paramQQAppInterface.putParcelable("fileinfo", localForwardFileInfo);
      paramQQAppInterface.putBoolean("not_forward", true);
      paramFileManagerEntity = new Intent();
      paramFileManagerEntity.putExtras(paramQQAppInterface);
      paramFileManagerEntity.putExtra("forward_text", localapcy.FileName);
      paramFileManagerEntity.putExtra("forward_from_troop_file", true);
      return paramFileManagerEntity;
      if (localapcy.Id != null) {
        localForwardFileInfo.Ja(localapcy.Id.toString());
      }
      localForwardFileInfo.setType(10006);
      localForwardFileInfo.Oj(4);
    }
  }
  
  public static Rect a(View paramView, String paramString)
  {
    if ((paramView != null) && (!TextUtils.isEmpty(paramString)))
    {
      int i = ahav.getFileType(paramString);
      if ((i == 2) || (i == 0)) {
        return sxx.getViewRect(paramView);
      }
    }
    return null;
  }
  
  public static SpannableString a(String paramString1, String paramString2, ahav.d paramd)
  {
    int k = paramString1.indexOf(paramString2);
    if (k < 0) {
      return new SpannableString(paramString1);
    }
    int m = paramString2.length();
    int j = Color.parseColor("#4799DF");
    if (paramd != null) {}
    for (int i = Color.parseColor("#A3CCEF");; i = j)
    {
      paramString2 = new int[0];
      paramString2 = new ColorStateList(new int[][] { { 16842919 }, paramString2 }, new int[] { i, j });
      paramString1 = new SpannableString(paramString1);
      paramString1.setSpan(new ahcz(new ahbs(paramd), paramString2), k, k + m, 33);
      return paramString1;
    }
  }
  
  public static apcy a(QQAppInterface paramQQAppInterface, long paramLong, apbr paramapbr)
  {
    apcy localapcy2 = TroopFileTransferManager.a(paramQQAppInterface, paramLong).a(paramapbr.mFileId);
    apcy localapcy1 = localapcy2;
    if (localapcy2 == null)
    {
      localapcy1 = apsv.a(paramQQAppInterface, paramLong, paramapbr.Id.toString(), paramapbr.mFileId, paramapbr.str_file_name, paramapbr.uint64_file_size, paramapbr.dTg);
      localapcy1.ThumbnailFile_Large = paramapbr.ThumbnailFile_Large;
      localapcy1.coc = paramapbr.coc;
      localapcy1.ThumbnailFile_Small = paramapbr.ThumbnailFile_Small;
    }
    return localapcy1;
  }
  
  public static ShareActionSheetBuilder.ActionSheetItem a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = ShareActionSheetBuilder.ActionSheetItem.build(paramInt);
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.listener = paramOnClickListener;
    localActionSheetItem.argus = "";
    return localActionSheetItem;
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, TextView paramTextView1, TextView paramTextView2, String paramString1, String paramString2)
  {
    paramTextView1 = paramTextView1.getPaint();
    paramTextView2 = paramTextView2.getPaint();
    int i = wja.dp2px(7.0F, paramContext.getResources());
    int j = (int)paramTextView2.measureText(paramString2);
    int k = wja.dp2px(15.0F, paramContext.getResources());
    switch (paramInt1)
    {
    case 1: 
    default: 
      return paramString1;
    }
    return (String)TextUtils.ellipsize(paramString1, paramTextView1, paramInt2 - i * 2 - j - k, TextUtils.TruncateAt.END);
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramString1)) {
      localStringBuilder.append(paramString1);
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(paramContext.getString(2131693588));
      }
      localStringBuilder.append("来自");
      localStringBuilder.append(paramString2);
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(paramContext.getString(2131693588));
      }
      localStringBuilder.append(paramString3);
    }
    if (!TextUtils.isEmpty(paramString4))
    {
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(paramContext.getString(2131693588));
      }
      localStringBuilder.append(paramString4);
    }
    return localStringBuilder.toString();
  }
  
  private static String a(AppInterface paramAppInterface, MessageForFile paramMessageForFile)
  {
    String str1 = "select * from " + FileManagerEntity.tableName() + " where  uniseq = " + paramMessageForFile.uniseq;
    paramAppInterface = paramAppInterface.getEntityManagerFactory().createEntityManager().rawQuery(FileManagerEntity.class, str1, null);
    if (paramAppInterface == null) {
      paramAppInterface = null;
    }
    String str2;
    do
    {
      return paramAppInterface;
      paramAppInterface = (FileManagerEntity)paramAppInterface.get(0);
      str2 = paramAppInterface.getFilePath();
      if (ahav.mI(str2))
      {
        if (QLog.isDebugVersion()) {
          QLog.i("FileClean", 1, "find file[" + str2 + "] for msg:" + paramMessageForFile.uniseq);
        }
        return str2;
      }
      str1 = ahaf.a().wa();
      if (paramAppInterface.Uuid == null) {
        break;
      }
      String str3 = MD5.toMD5(paramAppInterface.Uuid);
      str3 = str1 + str3;
      if (ahav.mI(str3))
      {
        if (QLog.isDebugVersion()) {
          QLog.i("FileClean", 1, "find tmp file[" + str2 + "] for msg:" + paramMessageForFile.uniseq);
        }
        return str3;
      }
      str1 = str1 + "dsc-" + String.valueOf(paramAppInterface.Uuid.replace("/", ""));
      if (!ahav.mI(str1)) {
        break;
      }
      paramAppInterface = str1;
    } while (!QLog.isDebugVersion());
    QLog.i("FileClean", 1, "find tmp file[" + str2 + "] for msg:" + paramMessageForFile.uniseq);
    return str1;
    return null;
  }
  
  private static String a(AppInterface paramAppInterface, MessageForTroopFile paramMessageForTroopFile)
  {
    String str1 = acbn.bmj;
    Object localObject = new TroopFileTansferItemEntity();
    ((TroopFileTansferItemEntity)localObject).troopuin = Long.parseLong(paramMessageForTroopFile.frienduin);
    String str2 = "select * from " + ((TroopFileTansferItemEntity)localObject).getTableName() + " where troopuin = ? and _sId = ?";
    paramAppInterface = paramAppInterface.getEntityManagerFactory().createEntityManager().rawQuery(TroopFileTansferItemEntity.class, str2, new String[] { "" + ((TroopFileTansferItemEntity)localObject).troopuin, SecurityUtile.encode(paramMessageForTroopFile.uuid) });
    if (paramAppInterface == null)
    {
      if (QLog.isDebugVersion()) {
        QLog.i("FileClean", 1, "find troop file result is null, for msg:" + paramMessageForTroopFile.uniseq);
      }
      return null;
    }
    localObject = paramAppInterface.iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramAppInterface = (TroopFileTansferItemEntity)((Iterator)localObject).next();
      if (paramAppInterface.Id.equals(UUID.fromString(paramMessageForTroopFile.uuid)))
      {
        localObject = paramAppInterface.LocalFile;
        paramAppInterface = paramAppInterface.FilePath;
      }
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (ahav.mI((String)localObject)))
      {
        if (QLog.isDebugVersion()) {
          QLog.i("FileClean", 1, "find troop file[" + (String)localObject + "] for msg:" + paramMessageForTroopFile.uniseq);
        }
        return localObject;
      }
      if (TextUtils.isEmpty(paramAppInterface))
      {
        if (!QLog.isDebugVersion()) {
          break;
        }
        QLog.i("FileClean", 1, "find troop file but filePath is null, for msg:" + paramMessageForTroopFile.uniseq);
        return null;
      }
      localObject = MD5.toMD5(paramAppInterface);
      localObject = str1 + (String)localObject;
      str1 = str1 + aqhs.bytes2HexStr(paramAppInterface.getBytes()) + ".tmp";
      if (ahbj.getFileSize(str1) > 0L) {
        localObject = str1;
      }
      for (;;)
      {
        if (ahav.mI((String)localObject))
        {
          if (QLog.isDebugVersion()) {
            QLog.i("FileClean", 1, "find tmp file[" + (String)localObject + "] for msg:" + paramMessageForTroopFile.uniseq);
          }
          return localObject;
        }
        paramAppInterface = ahaf.a().wa() + atad.toMD5(paramAppInterface);
        if (!ahav.mI(paramAppInterface)) {
          break;
        }
        if (QLog.isDebugVersion()) {
          QLog.i("FileClean", 1, "find tmp2 file[" + paramAppInterface + "] for msg:" + paramMessageForTroopFile.uniseq);
        }
        return paramAppInterface;
      }
      paramAppInterface = null;
      localObject = null;
    }
  }
  
  public static String a(AppInterface paramAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      if (QLog.isColorLevel()) {
        QLog.i("FileClean", 1, "queryFilePathForMessage, msg is null");
      }
    }
    do
    {
      return null;
      if (MessageForFile.class.isInstance(paramMessageRecord))
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileClean", 1, "queryFilePathForMessage, msg is MessageForFile");
        }
        return a(paramAppInterface, (MessageForFile)paramMessageRecord);
      }
      if (MessageForTroopFile.class.isInstance(paramMessageRecord))
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileClean", 1, "queryFilePathForMessage, msg is MessageForTroopFile");
        }
        return a(paramAppInterface, (MessageForTroopFile)paramMessageRecord);
      }
    } while (!QLog.isColorLevel());
    QLog.i("FileClean", 1, "queryFilePathForMessage, msg is :" + paramMessageRecord.msgtype);
    return null;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    Object localObject = (apsw)paramQQAppInterface.getManager(48);
    if (localObject != null)
    {
      if (((apsw)localObject).bg(String.valueOf(paramLong1), String.valueOf(paramLong2))) {
        return acfp.m(2131711128);
      }
      localObject = ((apsw)localObject).a(String.valueOf(paramLong1));
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
      if ((localObject != null) && (((apsw.f)localObject).gagTimeStamp != 0L))
      {
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.b(String.valueOf(paramLong1));
          if ((paramQQAppInterface != null) && ((paramQQAppInterface.isTroopOwner(String.valueOf(paramLong2))) || (paramQQAppInterface.isTroopAdmin(String.valueOf(paramLong2))))) {
            return "";
          }
        }
        return acfp.m(2131711140);
      }
    }
    return "";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramMessageRecord == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mrUniseq[").append(paramMessageRecord.uniseq).append("] ");
    localStringBuilder.append("mrSeq[").append(paramMessageRecord.msgseq).append("] ");
    localStringBuilder.append("mrUid[").append(paramMessageRecord.msgUid).append("] ");
    if (paramBoolean)
    {
      if (!(paramMessageRecord instanceof MessageForFile)) {
        break label160;
      }
      paramQQAppInterface = paramQQAppInterface.a().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
      if (paramQQAppInterface != null)
      {
        localStringBuilder.append("offFileName[").append(paramQQAppInterface.fileName).append("] ");
        localStringBuilder.append("offFileUuid[").append(paramQQAppInterface.Uuid).append("] ");
      }
    }
    for (;;)
    {
      return localStringBuilder.toString();
      label160:
      if ((paramMessageRecord instanceof MessageForTroopFile))
      {
        paramQQAppInterface = apsv.a(paramQQAppInterface, (MessageForTroopFile)paramMessageRecord);
        if (paramQQAppInterface != null)
        {
          localStringBuilder.append("troopFileName[").append(paramQQAppInterface.FileName).append("] ");
          localStringBuilder.append("troopFileId").append(paramQQAppInterface.FilePath).append("] ");
        }
      }
    }
  }
  
  public static void a(Context paramContext, Rect paramRect, ChatMessage paramChatMessage, SessionInfo paramSessionInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramContext, paramRect, paramChatMessage, paramSessionInfo, paramBoolean1, paramBoolean2, false, null);
  }
  
  public static void a(Context paramContext, Rect paramRect, ChatMessage paramChatMessage, SessionInfo paramSessionInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, MessageForReplyText paramMessageForReplyText)
  {
    i = 1;
    Bundle localBundle = new Bundle();
    if (paramRect != null) {
      localBundle.putParcelable("KEY_THUMBNAL_BOUND", paramRect);
    }
    localBundle.putBoolean("muate_play", paramBoolean1);
    localBundle.putBoolean("is_one_item", paramBoolean2);
    localBundle.putBoolean(avfp.cKr, paramBoolean3);
    if (paramSessionInfo.cZ == 1)
    {
      localBundle.putBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", true);
      localBundle.putString("extra.GROUP_UIN", paramSessionInfo.aTl);
      localBundle.putString("extra.GROUP_CODE", paramSessionInfo.troopUin);
    }
    localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
    if ((paramSessionInfo.cZ == 1) || (paramSessionInfo.cZ == 3000)) {
      localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 2);
    }
    localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramChatMessage.isMultiMsg);
    if (paramMessageForReplyText != null) {
      localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForReplyText.isMultiMsg);
    }
    localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramChatMessage.isMultiMsg);
    localBundle.putInt("extra.MOBILE_QQ_PROCESS_ID", Process.myPid());
    paramRect = paramChatMessage.selfuin;
    if ((paramChatMessage.isMultiMsg) || (paramChatMessage.isReplySource)) {}
    for (;;)
    {
      try
      {
        AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        paramMessageForReplyText = paramRect;
        if ((localAppRuntime instanceof QQAppInterface)) {
          paramMessageForReplyText = localAppRuntime.getAccount();
        }
        paramRect = paramMessageForReplyText;
      }
      catch (Exception paramMessageForReplyText)
      {
        continue;
        i = 2;
        continue;
      }
      paramBoolean1 = aklr.ae(BaseApplicationImpl.sApplication.getRuntime().getAccount(), 1);
      localBundle.putBoolean("extra.OCR", paramBoolean1);
      if (paramBoolean1)
      {
        paramMessageForReplyText = aklr.mw(BaseApplicationImpl.sApplication.getRuntime().getAccount());
        if (!TextUtils.isEmpty(paramMessageForReplyText)) {
          localBundle.putString("extra.OCR_TEXT", paramMessageForReplyText);
        }
      }
      localBundle.putInt("forward_source_uin_type", paramSessionInfo.cZ);
      localBundle.putString("uin", paramChatMessage.frienduin);
      try
      {
        paramMessageForReplyText = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(paramRect);
        if ((paramChatMessage instanceof MessageForFile))
        {
          if ((paramContext instanceof SplashActivity))
          {
            localBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
            avfp.a(paramContext, localBundle, new AIOImageProviderService(paramRect, paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage), xtm.a(paramChatMessage, paramMessageForReplyText), -1, i);
            return;
          }
          if (((paramContext instanceof ChatHistoryActivity)) || ((paramContext instanceof ChatHistory))) {
            continue;
          }
          if ((paramContext instanceof PublicFragmentActivity))
          {
            if ((((PublicFragmentActivity)paramContext).b() instanceof ChatHistoryBubbleListForTroopFragment)) {
              i = 2;
            }
          }
          else if ((paramContext instanceof MultiForwardActivity))
          {
            i = 5;
            continue;
          }
        }
        else
        {
          localBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
          avfp.a(paramContext, localBundle, new AIOImageProviderService(paramRect, paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage), xtm.a(paramChatMessage, paramMessageForReplyText), -1, paramSessionInfo.entrance);
          return;
        }
      }
      catch (AccountNotMatchException paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
      i = -1;
    }
  }
  
  public static void a(Context paramContext, TextView paramTextView, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, ahav.d paramd)
  {
    String str = a(paramContext, paramString1, paramString2, paramString3, paramString4);
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramString2))) {
      if (paramTextView.getWidth() == 0) {
        paramTextView.post(new QFileUtils.2(paramContext, paramTextView, paramString1, paramString2, paramString3, paramString4, paramString5, paramBoolean, paramd));
      }
    }
    while (TextUtils.isEmpty(str.replace(" ", "")))
    {
      return;
      b(paramContext, paramTextView, paramString1, paramString2, paramString3, paramString4, paramString5, paramBoolean, paramd);
      return;
    }
    paramTextView.setText(paramString5 + str);
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, String paramString7, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramContext, ScannerActivity.class);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString1);
    localIntent.putExtra("detectType", paramInt2);
    localIntent.putExtra("QRDecode", true);
    localIntent.putExtra("QRDecodeResult", paramString1);
    paramString1 = null;
    paramIntent = null;
    paramInt2 = 0;
    switch (paramInt1)
    {
    default: 
      if (paramBoolean) {
        paramInt1 = 3;
      }
      break;
    }
    for (;;)
    {
      try
      {
        if (!TextUtils.equals(paramString2, paramString6)) {
          continue;
        }
        paramString6 = paramString7;
        if (TextUtils.isEmpty(paramString4)) {
          continue;
        }
        int i = aoji.KI();
        if (paramInt2 == 0) {
          continue;
        }
        paramString7 = "gchat.qpic.cn";
        if (TextUtils.isEmpty(paramString7)) {
          continue;
        }
        if (i == 80) {
          continue;
        }
        paramString1 = paramString7 + ":" + i + paramString4;
      }
      catch (Throwable paramString1)
      {
        continue;
        continue;
        paramString1 = null;
        continue;
        paramString1 = null;
        continue;
        paramString1 = null;
        continue;
      }
      localIntent.putExtra("report_params", rvx.a(paramString3, paramString1, paramString5, paramString2, paramString6, paramInt1));
      paramContext.startActivity(localIntent);
      return;
      if (paramBoolean)
      {
        paramInt1 = 4;
        paramString6 = paramIntent;
      }
      else
      {
        paramInt1 = 2;
        paramInt2 = 1;
        paramString6 = paramIntent;
        continue;
        paramInt1 = 1;
        continue;
        continue;
        paramString7 = "c2cpicdw.qpic.cn";
        continue;
        paramString1 = paramString7 + paramString4;
        continue;
        if (TextUtils.isEmpty(paramString5)) {
          continue;
        }
        switch (paramInt1)
        {
        case 2: 
          paramString1 = "gchat.qpic.cn/gchatpic_new";
          if (!TextUtils.isEmpty(paramString2)) {
            paramString1 = "gchat.qpic.cn/gchatpic_new" + "/" + paramString2;
          }
          if (paramString5.startsWith("/")) {
            paramString1 = paramString1 + "0-0-" + paramString5.replace(".jpg", "") + "/0";
          } else {
            paramString1 = paramString1 + "/0-0-" + paramString5.replace(".jpg", "") + "/0";
          }
          break;
        case 1: 
          paramString1 = "c2cpicdw.qpic.cn/offpic_new";
          if (!TextUtils.isEmpty(paramString2)) {
            paramString1 = "c2cpicdw.qpic.cn/offpic_new" + "/" + paramString2;
          }
          if (paramString5.startsWith("/")) {
            paramString1 = paramString1 + paramString5 + "/0";
          } else {
            paramString1 = paramString1 + "/" + paramString5 + "/0";
          }
          break;
        }
      }
    }
  }
  
  public static void a(Context paramContext, String paramString, agst paramagst)
  {
    if (!aqhq.fileExistsAndNotEmpty(paramString)) {
      return;
    }
    ThreadManagerV2.executeOnSubThread(new QFileUtils.5(paramContext, paramString, paramagst));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, FileManagerEntity paramFileManagerEntity)
  {
    a(paramQQAppInterface, paramActivity, paramFileManagerEntity, false, null, -1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, FileManagerEntity paramFileManagerEntity, boolean paramBoolean, String paramString, int paramInt)
  {
    if (aqiw.getSystemNetwork(paramActivity) == 0)
    {
      apsd.ck(paramActivity, paramActivity.getString(2131699827));
      return;
    }
    paramQQAppInterface = a(paramQQAppInterface, paramFileManagerEntity);
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (paramInt != -1))
    {
      paramQQAppInterface.putExtra("key_req", ForwardRecentActivity.bGS);
      paramQQAppInterface.putExtra("key_direct_show_uin_type", paramInt);
      paramQQAppInterface.putExtra("key_direct_show_uin", paramString);
    }
    ahgq.a(paramActivity, paramQQAppInterface, ForwardRecentTranslucentActivity.class, 103);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, int paramInt)
  {
    if (TroopFileTransferManager.a(paramQQAppInterface, paramLong1) == null) {}
    do
    {
      return;
      paramString2 = apsv.a(paramQQAppInterface, paramLong1, paramString1, paramString2, paramString3, paramLong2, paramInt);
    } while (paramString2 == null);
    paramString1 = new Bundle();
    paramString1.putInt("dataline_forward_type", 100);
    if (aqhq.fileExistsAndNotEmpty(paramString2.LocalFile)) {
      paramString1.putString("dataline_forward_path", paramString2.LocalFile);
    }
    for (;;)
    {
      paramQQAppInterface = (acde)paramQQAppInterface.getBusinessHandler(8);
      paramString2 = new ahbz(paramContext);
      paramInt = paramQQAppInterface.a().b(acbn.bkw, paramString1, paramString2);
      if ((paramString2.bu) && (paramInt != 0)) {
        break;
      }
      ci.k(paramContext, paramInt);
      return;
      paramString3 = ahav.a(paramString2);
      paramString3.status = 2;
      paramString3.nOpType = 24;
      paramString3 = ahhq.a(paramString3);
      paramString3.Oj(1);
      paramString3.setType(10006);
      paramString3.Oh(1);
      paramString3.jA(paramLong1);
      if (paramString2.Id != null) {
        paramString3.Ja(paramString2.Id.toString());
      }
      paramString1.putParcelable("fileinfo", paramString3);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, long paramLong1, apcy paramapcy, String paramString, long paramLong2, int paramInt1, int paramInt2, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramChatMessage, paramLong1, paramapcy, paramString, paramLong2, paramInt1, paramInt2, paramRect, paramBoolean1, paramBoolean2, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, long paramLong1, apcy paramapcy, String paramString, long paramLong2, int paramInt1, int paramInt2, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramContext instanceof BasePluginActivity)) {
      paramContext = ((BasePluginActivity)paramContext).getOutActivity();
    }
    for (;;)
    {
      paramapcy = new agvr(paramQQAppInterface, paramContext, paramLong1, paramapcy, paramInt1);
      paramapcy.jO(paramLong2);
      paramapcy.Jm(paramString);
      paramapcy.setSessionInfo(paramSessionInfo);
      paramapcy.T(paramChatMessage);
      paramapcy.setMute(paramBoolean1);
      paramapcy.JD(paramBoolean3);
      if ((paramBoolean2) && ((ChatMessage)paramQQAppInterface.b().c(paramSessionInfo.aTl, paramSessionInfo.cZ, paramChatMessage.shmsgseq) == null)) {
        paramapcy.JG(false);
      }
      paramContext = new agvn(paramContext, paramapcy);
      paramContext.Oy(paramInt2);
      if (paramRect != null) {
        paramContext.k(paramRect);
      }
      paramContext.g(TroopFileDetailBrowserActivity.class);
      paramContext.JE(aM(paramQQAppInterface));
      paramContext.JF(aM(paramQQAppInterface));
      paramContext.djN();
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, Rect paramRect, int paramInt1, int paramInt2, FileManagerEntity paramFileManagerEntity, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramQQAppInterface = new agvl(paramQQAppInterface, paramContext, paramFileManagerEntity, paramInt2);
    new Bundle();
    paramQQAppInterface.setSessionInfo(paramSessionInfo);
    paramQQAppInterface.T(paramChatMessage);
    paramQQAppInterface.setMute(paramBoolean1);
    paramQQAppInterface.JD(paramBoolean2);
    paramQQAppInterface = new agvn(paramContext, paramQQAppInterface);
    paramQQAppInterface.Oy(paramInt1);
    paramQQAppInterface.k(paramRect);
    paramQQAppInterface.JE(true);
    paramQQAppInterface.djN();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    ahbx localahbx;
    int i;
    do
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 0);
      localBundle.putBoolean("not_forward", true);
      localBundle.putInt("dataline_forward_type", 100);
      localBundle.putString("dataline_forward_path", paramFileManagerEntity.getFilePath());
      localBundle.putParcelable("fileinfo", ahhq.a(paramFileManagerEntity));
      paramFileManagerEntity = (acde)paramQQAppInterface.getBusinessHandler(8);
      localahbx = new ahbx(paramContext);
      i = paramFileManagerEntity.a().b(acbn.bkw, localBundle, localahbx);
    } while ((localahbx.bu) && (i != 0));
    ci.k(paramContext, i);
    anot.a(paramQQAppInterface, "CliOper", "", "", "0X800644B", "0X800644B", 0, 0, "6", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    if ((paramMessageRecord1 == null) || (!ahav.ax(paramMessageRecord1))) {}
    int i;
    do
    {
      String str;
      do
      {
        do
        {
          return;
          str = paramMessageRecord2.getExtInfoFromExtStr("_m_ForwardFileType");
        } while (TextUtils.isEmpty(str));
        i = Integer.parseInt(str);
        paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
        str = paramMessageRecord2.getExtInfoFromExtStr("_m_ForwardReceiverUin");
        paramMessageRecord2 = paramMessageRecord2.getExtInfoFromExtStr("_m_ForwardSenderUin");
        if (i != 1) {
          break;
        }
        paramMessageRecord1.istroop = 0;
      } while ((TextUtils.isEmpty(paramQQAppInterface)) || (TextUtils.isEmpty(str)) || (!paramQQAppInterface.equals(str)));
      paramMessageRecord1.frienduin = paramMessageRecord2;
      return;
    } while (i != 2);
    paramMessageRecord1.istroop = 3000;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity, MessageRecord paramMessageRecord)
  {
    if (paramFileManagerEntity == null) {}
    int i;
    do
    {
      String str;
      do
      {
        do
        {
          return;
          str = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileType");
        } while (TextUtils.isEmpty(str));
        i = Integer.parseInt(str);
        paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
        str = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardReceiverUin");
        paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSenderUin");
        if (i != 1) {
          break;
        }
        paramFileManagerEntity.peerType = 0;
      } while ((TextUtils.isEmpty(paramQQAppInterface)) || (TextUtils.isEmpty(str)) || (!paramQQAppInterface.equals(str)));
      paramFileManagerEntity.peerUin = paramMessageRecord;
      return;
    } while (i != 2);
    paramFileManagerEntity.peerType = 3000;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<apbr> paramList, Activity paramActivity, long paramLong)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    while (paramLong == 0L) {
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramList = paramList.iterator();
    long l1 = 0L;
    if (paramList.hasNext())
    {
      apcy localapcy = a(paramQQAppInterface, paramLong, (apbr)paramList.next());
      FileManagerEntity localFileManagerEntity = ahav.a(localapcy);
      localFileManagerEntity.status = 2;
      localFileManagerEntity.nOpType = 24;
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.p(localFileManagerEntity.nSessionId);
      localForwardFileInfo.setType(10006);
      if (!TextUtils.isEmpty(localFileManagerEntity.getFilePath())) {
        localForwardFileInfo.setLocalPath(localapcy.LocalFile);
      }
      localForwardFileInfo.setFileName(localapcy.FileName);
      localForwardFileInfo.setFileSize(localapcy.ProgressTotal);
      localForwardFileInfo.jA(paramLong);
      if (localapcy.Id != null) {
        localForwardFileInfo.Ja(localapcy.Id.toString());
      }
      if (!TextUtils.isEmpty(localapcy.ThumbnailFile_Large))
      {
        localForwardFileInfo.aA(localapcy.ThumbnailFile_Large);
        label209:
        localForwardFileInfo.Oj(1);
        localForwardFileInfo.Oh(3);
        if (!aqhq.fileExistsAndNotEmpty(localapcy.LocalFile)) {
          break label295;
        }
        localArrayList2.add(Uri.parse(localapcy.LocalFile));
      }
      for (;;)
      {
        long l2 = localapcy.ProgressTotal;
        localArrayList1.add(localForwardFileInfo);
        l1 = l2 + l1;
        break;
        if (TextUtils.isEmpty(localapcy.coc)) {
          break label209;
        }
        localForwardFileInfo.aA(localapcy.coc);
        break label209;
        label295:
        localArrayList2.add(Uri.parse(""));
      }
    }
    paramQQAppInterface = new Bundle();
    paramList = new Intent();
    paramQQAppInterface.putInt("forward_type", 0);
    paramQQAppInterface.putParcelableArrayList("fileinfo_array", localArrayList1);
    paramQQAppInterface.putBoolean("not_forward", true);
    paramQQAppInterface.putBoolean("support_multi_forward", true);
    paramList.putExtra("sendMultiple", true);
    paramQQAppInterface.putParcelableArrayList("android.intent.extra.STREAM", localArrayList2);
    paramList.putExtras(paramQQAppInterface);
    paramList.putExtra("foward_editbar", true);
    paramList.putExtra("forward_type", 0);
    paramQQAppInterface = acfp.m(2131711129);
    if (localArrayList1.size() == 1) {
      paramQQAppInterface = acfp.m(2131711137) + ahav.kY(((ForwardFileInfo)localArrayList1.get(0)).getFileName()) + acfp.m(2131711138) + ahbj.g(((ForwardFileInfo)localArrayList1.get(0)).getFileSize()) + "。";
    }
    for (;;)
    {
      paramList.putExtra("forward_text", paramQQAppInterface);
      paramList.putExtra("k_favorites", false);
      ahgq.f(paramActivity, paramList, 103);
      return;
      if (localArrayList1.size() > 1) {
        paramQQAppInterface = acfp.m(2131711133) + ahav.kY(((ForwardFileInfo)localArrayList1.get(0)).getFileName()) + acfp.m(2131711132) + localArrayList1.size() + acfp.m(2131711135) + ahbj.g(l1) + "。";
      }
    }
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString, Uri paramUri)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: iconst_0
    //   7: istore 6
    //   9: iconst_0
    //   10: istore 4
    //   12: aload_1
    //   13: invokestatic 980	aqhq:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   16: ifne +10 -> 26
    //   19: iload 4
    //   21: istore 5
    //   23: iload 5
    //   25: ireturn
    //   26: iload 4
    //   28: istore 5
    //   30: aload_2
    //   31: ifnull -8 -> 23
    //   34: iconst_1
    //   35: istore 5
    //   37: aload_0
    //   38: invokevirtual 1263	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   41: aload_2
    //   42: ldc_w 1265
    //   45: invokevirtual 1271	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   48: astore_2
    //   49: aload_2
    //   50: ifnonnull +64 -> 114
    //   53: iconst_0
    //   54: ifeq +11 -> 65
    //   57: new 1273	java/lang/NullPointerException
    //   60: dup
    //   61: invokespecial 1274	java/lang/NullPointerException:<init>	()V
    //   64: athrow
    //   65: iconst_0
    //   66: ifeq +11 -> 77
    //   69: new 1273	java/lang/NullPointerException
    //   72: dup
    //   73: invokespecial 1274	java/lang/NullPointerException:<init>	()V
    //   76: athrow
    //   77: iload 4
    //   79: istore 5
    //   81: aload_2
    //   82: ifnull -59 -> 23
    //   85: aload_2
    //   86: invokevirtual 1279	android/os/ParcelFileDescriptor:close	()V
    //   89: iconst_0
    //   90: ireturn
    //   91: astore_0
    //   92: aload_0
    //   93: invokevirtual 1280	java/io/IOException:printStackTrace	()V
    //   96: iconst_0
    //   97: ireturn
    //   98: astore_0
    //   99: aload_0
    //   100: invokevirtual 1280	java/io/IOException:printStackTrace	()V
    //   103: goto -38 -> 65
    //   106: astore_0
    //   107: aload_0
    //   108: invokevirtual 1280	java/io/IOException:printStackTrace	()V
    //   111: goto -34 -> 77
    //   114: new 1282	java/io/FileOutputStream
    //   117: dup
    //   118: aload_2
    //   119: invokevirtual 1286	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   122: invokespecial 1289	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   125: astore 7
    //   127: new 1291	java/io/FileInputStream
    //   130: dup
    //   131: aload_1
    //   132: invokespecial 1292	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   135: astore_0
    //   136: invokestatic 1298	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   139: sipush 4096
    //   142: invokevirtual 1302	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   145: astore_1
    //   146: aload_0
    //   147: aload_1
    //   148: invokevirtual 1306	java/io/FileInputStream:read	([B)I
    //   151: istore_3
    //   152: iload_3
    //   153: iconst_m1
    //   154: if_icmpeq +70 -> 224
    //   157: aload 7
    //   159: aload_1
    //   160: iconst_0
    //   161: iload_3
    //   162: invokevirtual 1310	java/io/FileOutputStream:write	([BII)V
    //   165: goto -19 -> 146
    //   168: astore 8
    //   170: aload_0
    //   171: astore_1
    //   172: aload 7
    //   174: astore_0
    //   175: aload_1
    //   176: astore 7
    //   178: aload 8
    //   180: astore_1
    //   181: aload_1
    //   182: invokevirtual 1311	java/lang/Exception:printStackTrace	()V
    //   185: aload 7
    //   187: ifnull +8 -> 195
    //   190: aload 7
    //   192: invokevirtual 1312	java/io/FileInputStream:close	()V
    //   195: aload_0
    //   196: ifnull +7 -> 203
    //   199: aload_0
    //   200: invokevirtual 1313	java/io/FileOutputStream:close	()V
    //   203: iload 4
    //   205: istore 5
    //   207: aload_2
    //   208: ifnull -185 -> 23
    //   211: aload_2
    //   212: invokevirtual 1279	android/os/ParcelFileDescriptor:close	()V
    //   215: iconst_0
    //   216: ireturn
    //   217: astore_0
    //   218: aload_0
    //   219: invokevirtual 1280	java/io/IOException:printStackTrace	()V
    //   222: iconst_0
    //   223: ireturn
    //   224: invokestatic 1298	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   227: aload_1
    //   228: invokevirtual 1317	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   231: aload 7
    //   233: invokevirtual 1320	java/io/FileOutputStream:flush	()V
    //   236: iload 5
    //   238: istore 4
    //   240: aload_0
    //   241: ifnull +11 -> 252
    //   244: aload_0
    //   245: invokevirtual 1312	java/io/FileInputStream:close	()V
    //   248: iload 5
    //   250: istore 4
    //   252: aload 7
    //   254: ifnull +8 -> 262
    //   257: aload 7
    //   259: invokevirtual 1313	java/io/FileOutputStream:close	()V
    //   262: iload 4
    //   264: istore 5
    //   266: aload_2
    //   267: ifnull -244 -> 23
    //   270: aload_2
    //   271: invokevirtual 1279	android/os/ParcelFileDescriptor:close	()V
    //   274: iload 4
    //   276: ireturn
    //   277: astore_0
    //   278: aload_0
    //   279: invokevirtual 1280	java/io/IOException:printStackTrace	()V
    //   282: iload 4
    //   284: ireturn
    //   285: astore_0
    //   286: aload_0
    //   287: invokevirtual 1280	java/io/IOException:printStackTrace	()V
    //   290: iconst_0
    //   291: istore 4
    //   293: goto -41 -> 252
    //   296: astore_0
    //   297: aload_0
    //   298: invokevirtual 1280	java/io/IOException:printStackTrace	()V
    //   301: iload 6
    //   303: istore 4
    //   305: goto -43 -> 262
    //   308: astore_1
    //   309: aload_1
    //   310: invokevirtual 1280	java/io/IOException:printStackTrace	()V
    //   313: goto -118 -> 195
    //   316: astore_0
    //   317: aload_0
    //   318: invokevirtual 1280	java/io/IOException:printStackTrace	()V
    //   321: goto -118 -> 203
    //   324: astore_0
    //   325: aconst_null
    //   326: astore_2
    //   327: aconst_null
    //   328: astore_1
    //   329: aload 8
    //   331: ifnull +8 -> 339
    //   334: aload 8
    //   336: invokevirtual 1312	java/io/FileInputStream:close	()V
    //   339: aload_1
    //   340: ifnull +7 -> 347
    //   343: aload_1
    //   344: invokevirtual 1313	java/io/FileOutputStream:close	()V
    //   347: aload_2
    //   348: ifnull +7 -> 355
    //   351: aload_2
    //   352: invokevirtual 1279	android/os/ParcelFileDescriptor:close	()V
    //   355: aload_0
    //   356: athrow
    //   357: astore 7
    //   359: aload 7
    //   361: invokevirtual 1280	java/io/IOException:printStackTrace	()V
    //   364: goto -25 -> 339
    //   367: astore_1
    //   368: aload_1
    //   369: invokevirtual 1280	java/io/IOException:printStackTrace	()V
    //   372: goto -25 -> 347
    //   375: astore_1
    //   376: aload_1
    //   377: invokevirtual 1280	java/io/IOException:printStackTrace	()V
    //   380: goto -25 -> 355
    //   383: astore_0
    //   384: aconst_null
    //   385: astore_1
    //   386: goto -57 -> 329
    //   389: astore_0
    //   390: aload 7
    //   392: astore_1
    //   393: goto -64 -> 329
    //   396: astore_1
    //   397: aload_0
    //   398: astore 8
    //   400: aload_1
    //   401: astore_0
    //   402: aload 7
    //   404: astore_1
    //   405: goto -76 -> 329
    //   408: astore 8
    //   410: aload_0
    //   411: astore_1
    //   412: aload 8
    //   414: astore_0
    //   415: aload 7
    //   417: astore 8
    //   419: goto -90 -> 329
    //   422: astore_1
    //   423: aconst_null
    //   424: astore_2
    //   425: aconst_null
    //   426: astore_0
    //   427: aload 9
    //   429: astore 7
    //   431: goto -250 -> 181
    //   434: astore_1
    //   435: aconst_null
    //   436: astore_0
    //   437: aload 9
    //   439: astore 7
    //   441: goto -260 -> 181
    //   444: astore_1
    //   445: aload 7
    //   447: astore_0
    //   448: aload 9
    //   450: astore 7
    //   452: goto -271 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	455	0	paramContext	Context
    //   0	455	1	paramString	String
    //   0	455	2	paramUri	Uri
    //   151	11	3	i	int
    //   10	294	4	bool1	boolean
    //   21	244	5	bool2	boolean
    //   7	295	6	bool3	boolean
    //   125	133	7	localObject1	Object
    //   357	59	7	localIOException	java.io.IOException
    //   429	22	7	localObject2	Object
    //   1	1	8	localObject3	Object
    //   168	167	8	localException	Exception
    //   398	1	8	localContext	Context
    //   408	5	8	localObject4	Object
    //   417	1	8	localObject5	Object
    //   4	445	9	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   85	89	91	java/io/IOException
    //   57	65	98	java/io/IOException
    //   69	77	106	java/io/IOException
    //   136	146	168	java/lang/Exception
    //   146	152	168	java/lang/Exception
    //   157	165	168	java/lang/Exception
    //   224	236	168	java/lang/Exception
    //   211	215	217	java/io/IOException
    //   270	274	277	java/io/IOException
    //   244	248	285	java/io/IOException
    //   257	262	296	java/io/IOException
    //   190	195	308	java/io/IOException
    //   199	203	316	java/io/IOException
    //   37	49	324	finally
    //   334	339	357	java/io/IOException
    //   343	347	367	java/io/IOException
    //   351	355	375	java/io/IOException
    //   114	127	383	finally
    //   127	136	389	finally
    //   136	146	396	finally
    //   146	152	396	finally
    //   157	165	396	finally
    //   224	236	396	finally
    //   181	185	408	finally
    //   37	49	422	java/lang/Exception
    //   114	127	434	java/lang/Exception
    //   127	136	444	java/lang/Exception
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean, ahbl paramahbl)
  {
    int j = 2;
    boolean bool1;
    if (!aqiw.bW(BaseApplicationImpl.getContext()))
    {
      ahao.OS(2131694663);
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      Activity localActivity = (Activity)paramContext;
      if (!paramBoolean) {
        break;
      }
      i = 3;
      bool2 = aqux.a(localActivity, i, new ahbt(paramahbl), "");
      bool1 = bool2;
    } while (!bool2);
    paramContext = (Activity)paramContext;
    if (paramBoolean) {}
    for (int i = j;; i = 1)
    {
      return armm.a(paramContext, i, new ahbu(paramahbl));
      i = 2;
      break;
    }
  }
  
  public static boolean a(boolean paramBoolean, long paramLong, String paramString)
  {
    if (!aqiw.isNetSupport(BaseApplicationImpl.getContext())) {}
    long l;
    do
    {
      return false;
      if (!ahav.amK())
      {
        QLog.i("QFileUtils", 1, "checkShowFlowDialog. do not show with Wi-Fi.");
        return false;
      }
      l = agmx.fJ();
      agmx.fK();
      QLog.i("QFileUtils", 1, "checkShowFlowDialog. fileSize[" + paramLong + "] limit[" + l + "]");
    } while (paramLong < l);
    if (paramBoolean)
    {
      QLog.i("QFileUtils", 1, "checkShowFlowDialog. download so show.");
      return true;
    }
    if (aqhq.fileExistsAndNotEmpty(paramString))
    {
      QLog.i("QFileUtils", 1, "checkShowFlowDialog. is not local File do not show.");
      return false;
    }
    QLog.i("QFileUtils", 1, "checkShowFlowDialog. show flow dialog");
    return true;
  }
  
  public static int aD(int paramInt1, int paramInt2)
  {
    if (paramInt1 * 1.0F / paramInt2 >= 1.777778F) {
      return 2;
    }
    return 1;
  }
  
  public static int aE(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      paramInt2 = 4;
    }
    do
    {
      return paramInt2;
      if (paramInt1 == 3) {
        return 3;
      }
      if (paramInt1 == 0) {
        return 4;
      }
      if (paramInt1 == 2) {
        return 4;
      }
    } while (paramInt1 != 4);
    return 12;
  }
  
  public static boolean aM(QQAppInterface paramQQAppInterface)
  {
    int i = VipUtils.a(paramQQAppInterface, null);
    paramQQAppInterface = (agiq)paramQQAppInterface.getManager(317);
    if (i >> 8 == 2)
    {
      if (((i & 0xF) == 1) && (paramQQAppInterface.alj())) {
        return true;
      }
      if (paramQQAppInterface.ali()) {
        return true;
      }
    }
    else if (paramQQAppInterface.alh())
    {
      return true;
    }
    return false;
  }
  
  public static boolean amL()
  {
    int i = NetConnInfoCenter.getActiveNetIpFamily(true);
    return (i == 2) || (i == 3);
  }
  
  public static boolean ay(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    while (((!paramMessageRecord.isMultiMsg) && (!paramMessageRecord.isReplySource)) || (TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileType")))) {
      return false;
    }
    return true;
  }
  
  public static String b(long paramLong, int paramInt, String paramString)
  {
    if (paramInt == 128) {
      return "[Thumb]" + paramLong + "-" + paramString;
    }
    if (paramInt == 383) {
      return "[Thumb]320" + paramLong + "-" + paramString;
    }
    return "[Thumb]" + paramInt + paramLong + "-" + paramString;
  }
  
  public static void b(Context paramContext, TextView paramTextView, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, ahav.d paramd)
  {
    String str = a(paramContext, paramString1, paramString2, paramString3, paramString4);
    paramString2 = ahav.a(paramTextView, 2, paramString5 + str, paramString2);
    if (!TextUtils.isEmpty(paramString2))
    {
      paramContext = a(paramContext, paramString1, paramString2, paramString3, paramString4);
      paramContext = ahav.a(paramTextView, paramString5 + paramContext);
      paramString1 = D(paramContext, paramString2, acfp.m(2131711134));
      if (paramBoolean) {
        paramContext = a(paramContext, paramString1, paramd);
      }
    }
    for (;;)
    {
      if (aesm.d().isEnable())
      {
        paramString1 = VipUtils.K((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
        aesm.d().a(paramContext, paramString4, paramString1);
      }
      if ((paramContext != null) && (paramContext.length() > 0))
      {
        paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
        paramTextView.setText(paramContext);
        paramTextView.setFocusable(false);
        paramTextView.setClickable(false);
        paramTextView.setLongClickable(false);
      }
      return;
      paramContext = new SpannableString(paramContext);
      continue;
      paramContext = null;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, FileManagerEntity paramFileManagerEntity)
  {
    b(paramQQAppInterface, paramActivity, paramFileManagerEntity, false, null, -1);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, FileManagerEntity paramFileManagerEntity, boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramActivity == null)) {}
    while (paramFileManagerEntity == null) {
      return;
    }
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = ahav.d().longValue();
    paramQQAppInterface.a().v(localFileManagerEntity);
    paramQQAppInterface = a(paramQQAppInterface, paramActivity, paramFileManagerEntity);
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (paramInt != -1))
    {
      paramQQAppInterface.putExtra("key_req", ForwardRecentActivity.bGS);
      paramQQAppInterface.putExtra("key_direct_show_uin_type", paramInt);
      paramQQAppInterface.putExtra("key_direct_show_uin", paramString);
    }
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      ahao.OS(2131693819);
      return;
    }
    if (agzy.a(localFileManagerEntity).bd(false))
    {
      ahal.a(paramActivity, 2131693826, 2131693832, new ahbv(paramActivity, paramQQAppInterface));
      return;
    }
    ahgq.a(paramActivity, paramQQAppInterface, ForwardRecentTranslucentActivity.class, 103);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    if ((paramMessageRecord1 == null) || (!ahav.ax(paramMessageRecord1))) {}
    while ((paramMessageRecord2 == null) || (!ahav.ax(paramMessageRecord2))) {
      return;
    }
    paramQQAppInterface.a().a().b(paramMessageRecord1, paramMessageRecord2);
  }
  
  public static boolean b(int paramInt1, int paramInt2, long paramLong)
  {
    if (paramInt1 * paramInt2 >= 350000000L) {}
    while ((Math.max(paramInt1, paramInt2) > 30000L) || (paramLong >= 31457280L)) {
      return true;
    }
    return false;
  }
  
  public static String br(long paramLong)
  {
    if (paramLong <= 0L) {
      return "00:00:00";
    }
    paramLong /= 1000L;
    String str1;
    String str2;
    if (paramLong / 3600L > 9L)
    {
      str1 = paramLong / 3600L + "";
      if (paramLong % 3600L / 60L <= 9L) {
        break label205;
      }
      str2 = paramLong % 3600L / 60L + "";
      label96:
      if (paramLong % 3600L % 60L <= 9L) {
        break label237;
      }
    }
    label205:
    label237:
    for (String str3 = paramLong % 3600L % 60L + "";; str3 = "0" + paramLong % 3600L % 60L)
    {
      return str1 + ":" + str2 + ":" + str3;
      str1 = "0" + paramLong / 3600L;
      break;
      str2 = "0" + paramLong % 3600L / 60L;
      break label96;
    }
  }
  
  public static String bs(long paramLong)
  {
    float f;
    String str;
    if (paramLong > 1048576L)
    {
      f = (float)paramLong / 1048576.0F;
      str = new DecimalFormat("0.00").format(f);
      return acfp.m(2131711131) + str + "MB/s";
    }
    if (paramLong > 1024L)
    {
      f = (float)paramLong / 1024.0F;
      str = new DecimalFormat("0.00").format(f);
      return acfp.m(2131711130) + str + "KB/s";
    }
    return acfp.m(2131711136) + paramLong + "KB/s";
  }
  
  public static String c(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return "";
    }
    return a(paramQQAppInterface, paramMessageRecord, true);
  }
  
  public static void c(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("preResult", paramString2);
    a(paramContext, Uri.parse("file://" + paramString1).getPath(), -1, false, null, paramString3, null, null, paramInt, null, null, localIntent);
  }
  
  public static int de(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return -1;
        paramString = paramString.split("@");
      } while ((paramString == null) || (paramString.length <= 0));
      paramString = paramString[0];
    } while (TextUtils.isEmpty(paramString));
    return Integer.parseInt(paramString);
  }
  
  public static int df(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return 0;
      if (Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$").matcher(paramString).matches()) {
        return 1;
      }
      paramString = paramString.replaceAll("[\\[\\]]", "");
    } while ((TextUtils.isEmpty(paramString)) || (!aoln.qc(paramString)));
    return 2;
  }
  
  public static int dg(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    try
    {
      int i = df(new URL(paramString).getHost());
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static int getIPStackType()
  {
    int i = 1;
    switch (NetConnInfoCenter.getActiveNetIpFamily(true))
    {
    default: 
      i = 0;
    case 1: 
      return i;
    case 3: 
      return 2;
    }
    return 3;
  }
  
  public static int hO(int paramInt)
  {
    switch (paramInt)
    {
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    default: 
      return -1;
    case 1: 
    case 2: 
      return 0;
    case 5: 
    case 6: 
      return 3000;
    }
    return 1;
  }
  
  public static int hP(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    case 8: 
    default: 
      return 10;
    case 0: 
      return 7;
    case 2: 
      return 8;
    case 4: 
      return 6;
    case 1: 
      return 9;
    case 10: 
      return 5;
    case 3: 
      return 1;
    case 6: 
      return 2;
    case 7: 
      return 3;
    }
    return 4;
  }
  
  public static int hQ(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    case 8: 
    default: 
      return 6;
    case 3: 
      return 1;
    case 6: 
      return 3;
    case 7: 
      return 2;
    case 9: 
      return 4;
    }
    return 5;
  }
  
  public static String lg(String paramString)
  {
    Object localObject1;
    if (!aqhq.fileExistsAndNotEmpty(paramString)) {
      localObject1 = "";
    }
    Object localObject2;
    do
    {
      return localObject1;
      if (ahav.getFileSizes(paramString) > 3145728L) {
        QLog.i("<QFile>", 1, "copyFileToQFileFolder: source file is too big. copy failed");
      }
      localObject1 = ahaf.a().vZ();
      localObject2 = new File((String)localObject1);
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdir();
      }
      localObject2 = ahav.getFileName(paramString);
      localObject2 = (String)localObject1 + "/" + System.currentTimeMillis() + "_" + (String)localObject2;
      localObject1 = localObject2;
    } while (aqhq.copyFile(paramString, (String)localObject2));
    return "";
  }
  
  public static boolean v(FileManagerEntity paramFileManagerEntity)
  {
    int i;
    int j;
    if (paramFileManagerEntity != null)
    {
      i = paramFileManagerEntity.nOpType;
      j = paramFileManagerEntity.status;
    }
    return ((i != 21) && (i != 22) && (i != 24) && (i != 25) && (i != 28) && (i != 30)) || ((j != 0) && (j != 2));
  }
  
  public static boolean w(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    while ((6 != paramFileManagerEntity.getCloudType()) || (ahbj.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath()))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahbr
 * JD-Core Version:    0.7.0.1
 */