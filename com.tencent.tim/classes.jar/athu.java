import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.LruCache;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.cloudfile.CloudAIORecentFileExt;
import com.tencent.cloudfile.CloudDir;
import com.tencent.cloudfile.CloudFeed;
import com.tencent.cloudfile.CloudFile;
import com.tencent.cloudfile.CloudOnlineFileExt;
import com.tencent.cloudfile.CloudUploadFile;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.cloudfile.CloudFileUtils.1;
import com.tencent.tim.cloudfile.CloudFileUtils.MyLinkMovementMethod.1;
import com.tencent.tim.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.tim.teamwork.PadInfo;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class athu
{
  public static String cGO = "https://tim.qq.com/htdocs/vip/index.html?_wv=16777216&_wwv=12&isvip=";
  private static volatile LruCache<String, String> y = new LruCache(10);
  
  public static void X(FileManagerEntity paramFileManagerEntity)
  {
    if (!paramFileManagerEntity.fromCloudFile) {
      return;
    }
    if (!TextUtils.isEmpty(paramFileManagerEntity.Uuid))
    {
      QLog.i("CloudFileUtils", 1, "entity[" + paramFileManagerEntity.nSessionId + "] has uuid");
      return;
    }
    Object localObject = paramFileManagerEntity.cloudFile;
    if ((((CloudFile)localObject).fileSha != null) && (((CloudFile)localObject).fileSha.length > 0))
    {
      paramFileManagerEntity.Uuid = aqft.bytesToHexString(((CloudFile)localObject).fileSha);
      QLog.i("CloudFileUtils", 1, "entity[" + paramFileManagerEntity.nSessionId + "] use sha create uuid");
      return;
    }
    localObject = new byte[paramFileManagerEntity.pDirKey.length + paramFileManagerEntity.cloudId.length];
    System.arraycopy(paramFileManagerEntity.pDirKey, 0, localObject, 0, paramFileManagerEntity.pDirKey.length);
    System.arraycopy(paramFileManagerEntity.cloudId, 0, localObject, paramFileManagerEntity.pDirKey.length, paramFileManagerEntity.cloudId.length);
    paramFileManagerEntity.Uuid = MD5.toMD5((byte[])localObject);
    QLog.i("CloudFileUtils", 1, "entity[" + paramFileManagerEntity.nSessionId + "] use dirKey create uuid");
  }
  
  public static int a(QQAppInterface paramQQAppInterface, Context paramContext, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    int i;
    if (aqmj.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), "cloud_unfull_config_load_suc", 1) == 1)
    {
      i = 1;
      if (aqmj.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), "cloud_full_config_load_suc", 1) != 1) {
        break label64;
      }
    }
    label64:
    for (int j = 1;; j = 0)
    {
      if ((j != 0) && (i != 0)) {
        break label70;
      }
      i = -1;
      return i;
      i = 0;
      break;
    }
    label70:
    Object localObject = (atgc)paramQQAppInterface.getManager(373);
    long l1 = paramInt1;
    label130:
    long l2;
    long l3;
    int m;
    int k;
    if (aqmj.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), "cloud_key_file_count_limit", 30000) - l1 <= aqmj.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), "cloud_key_file_count_lower_limit", 100))
    {
      i = 1;
      l1 = (Math.ceil(paramFloat2 / 1024.0F / 1024.0F) - Math.ceil(paramFloat1 / 1024.0F / 1024.0F));
      l2 = aqmj.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), "cloud_key_space_alert_vip_1_size", 100);
      l3 = aqmj.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), "cloud_key_space_alert_vip_2_size", 1024);
      j = aqmj.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), "cloud_key_space_alert_vip_2_limit", 1);
      m = aqmj.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), "cloud_key_cloud_tab_interval", -1);
      k = aqmj.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), "cloud_key_receive_send_interval", -1);
      localObject = BaseApplication.getContext().getSharedPreferences("CloudFileSpaceConfigHandler", 0);
      if (!g(paramQQAppInterface, paramContext)) {
        break label456;
      }
      paramInt1 = 3;
      label263:
      if ((paramInt1 == 3) || (i == 0)) {
        break label774;
      }
      paramInt1 = 5;
    }
    label774:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CloudFile", 2, "getCloudSpaceAlertType : type = [" + paramInt1 + "]");
      }
      switch (paramInt1)
      {
      case 4: 
      default: 
        return paramInt1;
      case 1: 
        paramInt2 = ((SharedPreferences)localObject).getInt("cloud_key_space_limit_1_save_" + paramQQAppInterface.getAccount(), 0);
        l1 = ((SharedPreferences)localObject).getLong("cloud_key_space_limit_1_time_save_" + paramQQAppInterface.getAccount(), 0L);
        i = paramInt1;
        if (System.currentTimeMillis() - l1 >= 86400000L) {
          break;
        }
        i = paramInt1;
        if (paramInt2 < j) {
          break;
        }
        return -2;
        i = 0;
        break label130;
        if (l1 > 5120L)
        {
          paramInt1 = 0;
          ((SharedPreferences)localObject).edit().putInt("cloud_key_space_limit_2_save_" + paramQQAppInterface.getAccount(), 0).putInt("cloud_key_space_limit_1_save_" + paramQQAppInterface.getAccount(), 0).putLong("cloud_key_space_limit_1_time_save_" + paramQQAppInterface.getAccount(), 0L).putLong("cloud_key_cloud_tab_interval_save", 0L).putLong("cloud_key_receive_send_interval_save", 0L);
          break label263;
        }
        if (l1 > l3)
        {
          paramInt1 = 0;
          break label263;
        }
        if (l1 > l2)
        {
          paramInt1 = 1;
          break label263;
        }
        paramInt1 = 3;
        break;
      case 2: 
        i = paramInt1;
        if (((SharedPreferences)localObject).getInt("cloud_key_space_limit_2_save_" + paramQQAppInterface.getAccount(), 0) < 0) {
          break;
        }
        return -2;
      case 3: 
      case 5: 
        label456:
        l1 = ((SharedPreferences)localObject).getLong("cloud_key_cloud_tab_interval_save", 0L);
        l2 = ((SharedPreferences)localObject).getLong("cloud_key_receive_send_interval_save", 0L);
        j = paramInt1;
        if (paramInt2 == 1)
        {
          j = paramInt1;
          if (m != -1)
          {
            j = paramInt1;
            if (System.currentTimeMillis() - l1 < m * 3600 * 1000) {
              j = -2;
            }
          }
        }
        i = j;
        if (paramInt2 != 2) {
          break;
        }
        i = j;
        if (k == -1) {
          break;
        }
        i = j;
        if (System.currentTimeMillis() - l2 >= k * 3600 * 1000) {
          break;
        }
        return -2;
      }
    }
  }
  
  public static atin a(CloudDir paramCloudDir)
  {
    if (paramCloudDir == null) {
      return null;
    }
    return new atin(paramCloudDir);
  }
  
  public static atin a(com.tencent.mobileqq.filemanager.data.FileInfo paramFileInfo)
  {
    CloudDir localCloudDir = new CloudDir();
    localCloudDir.cloudId = paramFileInfo.Y();
    localCloudDir.pLogicDirKey = paramFileInfo.X();
    localCloudDir.showName = paramFileInfo.getName();
    return new atin(localCloudDir);
  }
  
  public static CloudAIORecentFileExt a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    localCloudAIORecentFileExt = new CloudAIORecentFileExt();
    localCloudAIORecentFileExt.uuid = paramFileManagerEntity.Uuid;
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramFileManagerEntity.peerUin)) {
          localCloudAIORecentFileExt.peerUin = Long.parseLong(paramFileManagerEntity.peerUin);
        }
        if (!TextUtils.isEmpty(paramFileManagerEntity.selfUin)) {
          localCloudAIORecentFileExt.creatorUin = Long.parseLong(paramFileManagerEntity.selfUin);
        }
        if ((paramFileManagerEntity.peerType != 3000) && (paramFileManagerEntity.peerType != 1))
        {
          if (!paramFileManagerEntity.bSend) {
            continue;
          }
          localCloudAIORecentFileExt.creatorUin = paramQQAppInterface.getLongAccountUin();
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("CloudFileUtils", 2, "entityToAIOFileExt invalid peerUin or selfUin");
        continue;
        int i = 2;
        continue;
        if (paramFileManagerEntity.peerType != 1) {
          continue;
        }
        localCloudAIORecentFileExt.fileSourceType = 4;
        continue;
        localCloudAIORecentFileExt.fileSourceType = 2;
        continue;
        paramQQAppInterface = paramFileManagerEntity.strFileMd5.getBytes();
        continue;
      }
      localCloudAIORecentFileExt.transferTime = paramFileManagerEntity.srvTime;
      if (!paramFileManagerEntity.bSend) {
        continue;
      }
      i = 1;
      localCloudAIORecentFileExt.fileTransferType = i;
      localCloudAIORecentFileExt.fileName = paramFileManagerEntity.fileName;
      if (paramFileManagerEntity.peerType != 3000) {
        continue;
      }
      localCloudAIORecentFileExt.fileSourceType = 3;
      localCloudAIORecentFileExt.fileSize = paramFileManagerEntity.fileSize;
      if (paramFileManagerEntity.strFileMd5 != null) {
        continue;
      }
      paramQQAppInterface = null;
      localCloudAIORecentFileExt.first10MMd5 = paramQQAppInterface;
      return localCloudAIORecentFileExt;
      if (!TextUtils.isEmpty(paramFileManagerEntity.peerUin)) {
        localCloudAIORecentFileExt.creatorUin = Long.parseLong(paramFileManagerEntity.peerUin);
      }
    }
  }
  
  public static CloudFile a(FileManagerEntity paramFileManagerEntity)
  {
    CloudFile localCloudFile = new CloudFile();
    localCloudFile.pLogicDirKey = paramFileManagerEntity.pDirKey;
    localCloudFile.cloudId = paramFileManagerEntity.cloudId;
    localCloudFile.finalPath = paramFileManagerEntity.getFilePath();
    localCloudFile.showName = paramFileManagerEntity.fileName;
    localCloudFile.type = 2;
    localCloudFile.fileSize = paramFileManagerEntity.fileSize;
    localCloudFile.height = paramFileManagerEntity.imgHeight;
    localCloudFile.width = paramFileManagerEntity.imgWidth;
    switch (paramFileManagerEntity.status)
    {
    case 2: 
    default: 
      localCloudFile.downloadStatus = 0;
      return localCloudFile;
    case 1: 
      localCloudFile.downloadStatus = 5;
      return localCloudFile;
    case 0: 
      localCloudFile.downloadStatus = 4;
      return localCloudFile;
    }
    localCloudFile.downloadStatus = 3;
    return localCloudFile;
  }
  
  public static CloudOnlineFileExt a(PadInfo paramPadInfo)
  {
    CloudOnlineFileExt localCloudOnlineFileExt = new CloudOnlineFileExt();
    if (paramPadInfo != null)
    {
      localCloudOnlineFileExt.fileName = paramPadInfo.title;
      localCloudOnlineFileExt.onlineListType = paramPadInfo.type_list;
      localCloudOnlineFileExt.onlineFileType = paramPadInfo.type;
      localCloudOnlineFileExt.domainId = paramPadInfo.domainId;
      localCloudOnlineFileExt.localId = paramPadInfo.padId;
      localCloudOnlineFileExt.url = paramPadInfo.pad_url;
      localCloudOnlineFileExt.thumbUrl = paramPadInfo.thumbUrl;
      localCloudOnlineFileExt.creatorUin = paramPadInfo.creatorUin;
      localCloudOnlineFileExt.onlineCreateTime = paramPadInfo.createTime;
      localCloudOnlineFileExt.lastModifierUin = paramPadInfo.lastEditorUin;
      localCloudOnlineFileExt.onlineModifyTime = paramPadInfo.lastEditTime;
      localCloudOnlineFileExt.previewTime = paramPadInfo.currentUserBrowseTime;
      localCloudOnlineFileExt.shareUin = paramPadInfo.shardUin;
      localCloudOnlineFileExt.lastShardTime = paramPadInfo.lastshardTime;
      localCloudOnlineFileExt.createSrcType = 0;
    }
    return localCloudOnlineFileExt;
  }
  
  public static com.tencent.cloudfile.FileInfo a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    byte[] arrayOfByte = null;
    if (paramFileManagerEntity == null) {
      return null;
    }
    com.tencent.cloudfile.FileInfo localFileInfo = new com.tencent.cloudfile.FileInfo();
    localFileInfo.fileName = paramFileManagerEntity.fileName;
    localFileInfo.localPath = paramFileManagerEntity.strFilePath;
    localFileInfo.fileSize = paramFileManagerEntity.fileSize;
    if (paramFileManagerEntity.strFileSHA == null)
    {
      localFileInfo.fileSha = arrayOfByte;
      if (!paramBoolean) {
        break label113;
      }
      localFileInfo.fileSrcType = 1;
    }
    for (;;)
    {
      localFileInfo.width = paramFileManagerEntity.imgWidth;
      localFileInfo.height = paramFileManagerEntity.imgHeight;
      if (!paramBoolean) {
        localFileInfo.aioRecentFileExt = a(paramQQAppInterface, paramFileManagerEntity);
      }
      return localFileInfo;
      arrayOfByte = paramFileManagerEntity.strFileSHA.getBytes();
      break;
      label113:
      if (paramFileManagerEntity.peerType == 3000) {
        localFileInfo.fileSrcType = 3;
      } else if (paramFileManagerEntity.peerType == 1) {
        localFileInfo.fileSrcType = 4;
      } else {
        localFileInfo.fileSrcType = 2;
      }
    }
  }
  
  public static FileManagerEntity a(CloudFeed paramCloudFeed)
  {
    if (paramCloudFeed == null) {
      return null;
    }
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    ArrayList localArrayList = new ArrayList();
    if (paramCloudFeed.combinePhotoList.size() > 0)
    {
      paramCloudFeed = paramCloudFeed.combinePhotoList.iterator();
      while (paramCloudFeed.hasNext()) {
        localArrayList.add(a((CloudFile)paramCloudFeed.next()));
      }
      localFileManagerEntity.combinePhotoList = localArrayList;
      localFileManagerEntity.cloudFeedType = 3;
    }
    return localFileManagerEntity;
  }
  
  public static FileManagerEntity a(CloudFile paramCloudFile)
  {
    if (paramCloudFile == null) {
      return null;
    }
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.setCloudFile(paramCloudFile);
    return localFileManagerEntity;
  }
  
  public static FileManagerEntity a(CloudUploadFile paramCloudUploadFile)
  {
    if (paramCloudUploadFile == null) {
      return null;
    }
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.uploadFile = paramCloudUploadFile;
    localFileManagerEntity.setCloudFile(paramCloudUploadFile.fileInfo);
    localFileManagerEntity.nFileType = ahav.getFileType(paramCloudUploadFile.uploadPath);
    localFileManagerEntity.cloudFeedType = 2;
    return localFileManagerEntity;
  }
  
  public static PadInfo a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      localObject = null;
    }
    PadInfo localPadInfo;
    do
    {
      do
      {
        return localObject;
        localPadInfo = new PadInfo();
        localPadInfo.title = paramFileManagerEntity.fileName;
        localObject = localPadInfo;
      } while (paramFileManagerEntity.cloudFile == null);
      localObject = localPadInfo;
    } while (paramFileManagerEntity.cloudFile.onlineFileExt == null);
    Object localObject = paramFileManagerEntity.cloudFile.onlineFileExt;
    localPadInfo.type_list = ((CloudOnlineFileExt)localObject).onlineListType;
    localPadInfo.type = ((CloudOnlineFileExt)localObject).onlineFileType;
    localPadInfo.domainId = ((CloudOnlineFileExt)localObject).domainId;
    localPadInfo.padId = ((CloudOnlineFileExt)localObject).localId;
    localPadInfo.pad_url = ((CloudOnlineFileExt)localObject).url;
    localPadInfo.thumbUrl = ((CloudOnlineFileExt)localObject).thumbUrl;
    localPadInfo.creatorUin = ((CloudOnlineFileExt)localObject).creatorUin;
    localPadInfo.createTime = ((CloudOnlineFileExt)localObject).onlineCreateTime;
    localPadInfo.lastEditorUin = ((CloudOnlineFileExt)localObject).lastModifierUin;
    localPadInfo.lastEditTime = ((CloudOnlineFileExt)localObject).onlineModifyTime;
    localPadInfo.currentUserBrowseTime = ((CloudOnlineFileExt)localObject).previewTime;
    localPadInfo.shardUin = ((CloudOnlineFileExt)localObject).shareUin;
    localPadInfo.lastshardTime = ((CloudOnlineFileExt)localObject).lastShardTime;
    localPadInfo.isCloudFile = true;
    localPadInfo.iCloudFileCreateTime = paramFileManagerEntity.cloudFile.createTime;
    localPadInfo.policy = la(paramFileManagerEntity.cloudFile.onlineFileExt.permissionType);
    return localPadInfo;
  }
  
  public static String a(CloudFile paramCloudFile)
  {
    String str2 = "";
    String str1 = str2;
    if (paramCloudFile != null)
    {
      str1 = str2;
      if (paramCloudFile.expireTime > 0)
      {
        int i = (int)Math.ceil((paramCloudFile.expireTime - (float)System.currentTimeMillis() / 1000.0F) / 3600.0F / 24.0F);
        if (i <= 0) {
          break label71;
        }
        str1 = String.format("%d天后过期", new Object[] { Integer.valueOf(i) });
      }
    }
    return str1;
    label71:
    QLog.i("CloudFileUtils", 2, "the expire day can not small than 0.");
    return "";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, Context paramContext, CloudAIORecentFileExt paramCloudAIORecentFileExt, boolean paramBoolean, int paramInt)
  {
    if (paramCloudAIORecentFileExt == null) {
      return paramContext.getResources().getString(2131691670);
    }
    String str1 = String.valueOf(paramCloudAIORecentFileExt.peerUin);
    String str2 = String.valueOf(paramCloudAIORecentFileExt.creatorUin);
    int i = paramCloudAIORecentFileExt.fileSourceType;
    int j = paramCloudAIORecentFileExt.fileTransferType;
    if ((TextUtils.isEmpty(str1)) || (i == 1)) {
      return paramContext.getResources().getString(2131691670);
    }
    if (i == 2)
    {
      if ((paramBoolean) && (paramInt > 0))
      {
        paramQQAppInterface = String.format(paramContext.getResources().getString(2131691668), new Object[] { aqgv.b(paramQQAppInterface, str1, true) });
        paramContext = String.format(paramContext.getResources().getString(2131691669), new Object[] { Integer.valueOf(paramInt + 1) });
        return paramQQAppInterface + paramContext;
      }
      if (j == 1) {
        return String.format(paramContext.getResources().getString(2131691657), new Object[] { aqgv.b(paramQQAppInterface, str1, true) });
      }
      if (j == 2) {
        return String.format(paramContext.getResources().getString(2131691668), new Object[] { aqgv.b(paramQQAppInterface, str1, true) });
      }
      if ((j == 0) && (!TextUtils.isEmpty(str2)))
      {
        if (paramQQAppInterface.getCurrentAccountUin().equals(str2)) {
          return String.format(paramContext.getResources().getString(2131691657), new Object[] { aqgv.b(paramQQAppInterface, str1, true) });
        }
        return String.format(paramContext.getResources().getString(2131691668), new Object[] { aqgv.b(paramQQAppInterface, str1, true) });
      }
    }
    else if (i == 3)
    {
      if (!TextUtils.isEmpty(str2))
      {
        if ((paramBoolean) && (paramInt > 0))
        {
          paramQQAppInterface = String.format(paramContext.getResources().getString(2131691668), new Object[] { aqgv.b(paramQQAppInterface, paramContext, str1) });
          paramContext = String.format(paramContext.getResources().getString(2131691669), new Object[] { Integer.valueOf(paramInt + 1) });
          return paramQQAppInterface + paramContext;
        }
        if (paramQQAppInterface.getCurrentAccountUin().equals(str2)) {
          return String.format(paramContext.getResources().getString(2131691657), new Object[] { aqgv.b(paramQQAppInterface, paramContext, str1) });
        }
        return String.format(paramContext.getResources().getString(2131691668), new Object[] { aqgv.b(paramQQAppInterface, paramContext, str1) });
      }
    }
    else if (i == 4)
    {
      if ((paramBoolean) && (paramInt > 0))
      {
        paramQQAppInterface = String.format(paramContext.getResources().getString(2131691668), new Object[] { aqgv.a(paramQQAppInterface, str1, true) });
        paramContext = String.format(paramContext.getResources().getString(2131691669), new Object[] { Integer.valueOf(paramInt + 1) });
        return paramQQAppInterface + paramContext;
      }
      if (paramQQAppInterface.getCurrentAccountUin().equals(str2)) {
        return String.format(paramContext.getResources().getString(2131691657), new Object[] { aqgv.a(paramQQAppInterface, str1, true) });
      }
      return String.format(paramContext.getResources().getString(2131691668), new Object[] { aqgv.a(paramQQAppInterface, str1, true) });
    }
    return paramContext.getResources().getString(2131691670);
  }
  
  public static ArrayList<String> a(QQAppInterface paramQQAppInterface, List<atiu> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (((atiu)localObject).getCloudFileType() == 0)
      {
        localObject = (FileManagerEntity)localObject;
        if (ahav.getFileType(((FileManagerEntity)localObject).fileName) == 0)
        {
          localArrayList.add(String.valueOf(((FileManagerEntity)localObject).nSessionId));
          paramQQAppInterface.a().v((FileManagerEntity)localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, atiu paramatiu)
  {
    if ((paramatiu instanceof FileManagerEntity)) {}
    for (paramQQAppInterface = a((FileManagerEntity)paramatiu);; paramQQAppInterface = (PadInfo)paramatiu)
    {
      int i = paramQQAppInterface.type_list;
      paramatiu = new Bundle();
      paramatiu.putString("url", jpa.r(paramQQAppInterface.pad_url, "_bid=2517"));
      paramatiu.putInt("key_team_work_edit_type", paramQQAppInterface.type);
      paramatiu.putString("key_team_work_title", paramQQAppInterface.title);
      paramatiu.putString("key_team_work_rul", paramQQAppInterface.pad_url);
      paramatiu.putInt("key_team_work_pad_list_type", paramQQAppInterface.type_list);
      TeamWorkDocEditBrowserActivity.a(paramActivity, paramatiu, true);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, atiu paramatiu, ArrayList<String> paramArrayList)
  {
    paramatiu = (FileManagerEntity)paramatiu;
    if (paramatiu.nSessionId == 0L) {
      paramatiu.nSessionId = ahav.d().longValue();
    }
    paramQQAppInterface.a().v(paramatiu);
    paramQQAppInterface = new ForwardFileInfo();
    if (paramatiu.cloudFile != null)
    {
      paramQQAppInterface.bg(paramatiu.cloudFile.pLogicDirKey);
      paramQQAppInterface.bf(paramatiu.cloudFile.cloudId);
    }
    paramQQAppInterface.Oj(9);
    paramQQAppInterface.setType(10001);
    paramQQAppInterface.setFileName(paramatiu.fileName);
    paramQQAppInterface.setFileSize(paramatiu.fileSize);
    paramQQAppInterface.p(paramatiu.nSessionId);
    paramatiu = new Intent(paramActivity, FileBrowserActivity.class);
    paramatiu.putExtra("fileinfo", paramQQAppInterface);
    if ((ahav.getFileType(paramQQAppInterface.getFileName()) == 0) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramQQAppInterface.setType(10014);
      paramatiu.putStringArrayListExtra("local_tim_cloud_sessionid_list", paramArrayList);
    }
    paramActivity.startActivityForResult(paramatiu, 102);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, FileManagerEntity paramFileManagerEntity, SessionInfo paramSessionInfo)
  {
    PadInfo localPadInfo = a(paramFileManagerEntity);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_flag_from_plugin", true);
    localIntent.putExtra("isFromShare", true);
    localIntent.putExtra("forward_type", 1001);
    localIntent.putExtra("pluginName", "web_share");
    localIntent.putExtra("req_type", 95);
    localIntent.putExtra("detail_url", localPadInfo.pad_url);
    if (localPadInfo.type == 1)
    {
      paramFileManagerEntity = aull.Az();
      if (TextUtils.isEmpty(paramFileManagerEntity)) {
        break label426;
      }
    }
    for (;;)
    {
      localIntent.putExtra("image_url_remote", paramFileManagerEntity);
      do
      {
        String str = localPadInfo.title;
        paramFileManagerEntity = str;
        if (str != null)
        {
          paramFileManagerEntity = str;
          if (str.length() > 45) {
            paramFileManagerEntity = str.substring(0, 45) + "…";
          }
        }
        localIntent.putExtra("title", paramFileManagerEntity);
        str = paramContext.getString(2131720968);
        if (localPadInfo.type == 2) {
          paramContext.getString(2131720969);
        }
        paramFileManagerEntity = str;
        if (str != null)
        {
          paramFileManagerEntity = str;
          if (str.length() > 60) {
            paramFileManagerEntity = str.substring(0, 60) + "…";
          }
        }
        localIntent.putExtra("desc", paramFileManagerEntity);
        localIntent.putExtra("forward_thumb", "");
        localIntent.putExtra("struct_share_key_content_action", "web");
        localIntent.putExtra("req_share_id", -1L);
        localIntent.putExtra("struct_share_key_source_action", " ");
        localIntent.putExtra("brief_key", paramContext.getString(2131698632, new Object[] { localPadInfo.title }));
        paramContext = anre.a(localIntent.getExtras());
        if (paramContext != null)
        {
          localIntent.putExtra("stuctmsg_bytes", paramContext.getBytes());
          aqmf.b(paramQQAppInterface, paramSessionInfo.aTl, paramSessionInfo.troopUin, paramSessionInfo.cZ, paramContext, null);
        }
        return;
      } while (localPadInfo.type != 2);
      paramFileManagerEntity = aull.AA();
      if (!TextUtils.isEmpty(paramFileManagerEntity)) {}
      for (;;)
      {
        localIntent.putExtra("image_url_remote", paramFileManagerEntity);
        break;
        paramFileManagerEntity = "https://pub.idqqimg.com/pc/misc/files/20180410/5349bc325950481ebde04c38208d9028.png";
      }
      label426:
      paramFileManagerEntity = "https://pub.idqqimg.com/pc/misc/files/20180410/1fce078ca2434b18bfec613961d526ff.png";
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, athu.a parama)
  {
    ThreadManager.post(new CloudFileUtils.1(paramQQAppInterface, parama), 8, null, true);
  }
  
  public static void a(AsyncImageView paramAsyncImageView, atkw paramatkw)
  {
    String str = null;
    int i = -1;
    if (paramatkw != null)
    {
      str = paramatkw.uZ();
      i = paramatkw.getFileType();
    }
    switch (i)
    {
    case 1: 
    case 3: 
    case 4: 
    default: 
      paramAsyncImageView.setImageResource(hL(i));
    }
    do
    {
      do
      {
        do
        {
          return;
          paramAsyncImageView.setDefaultImage(2130839386);
        } while (!aueh.fileExistsAndNotEmpty(str));
        paramAsyncImageView.setAsyncImage(str);
        return;
        paramAsyncImageView.setDefaultImage(2130845117);
      } while (!aueh.fileExistsAndNotEmpty(str));
      paramAsyncImageView.setApkIconAsyncImage(str);
      return;
      paramAsyncImageView.setDefaultImage(2130839393);
    } while (!aueh.fileExistsAndNotEmpty(str));
    paramAsyncImageView.setAsyncImage(str);
  }
  
  public static boolean a(atin paramatin1, atin paramatin2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramatin1 != null)
    {
      bool1 = bool2;
      if (paramatin2 != null)
      {
        bool1 = bool2;
        if (paramatin1.equals(paramatin2)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(FileManagerEntity paramFileManagerEntity, PadInfo paramPadInfo)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = bool3;
    if (paramFileManagerEntity != null)
    {
      bool1 = bool3;
      if (paramFileManagerEntity.cloudFile != null)
      {
        bool1 = bool3;
        if (paramFileManagerEntity.cloudFile.onlineFileExt != null)
        {
          if (paramPadInfo != null) {
            break label44;
          }
          bool1 = bool3;
        }
      }
    }
    label44:
    do
    {
      do
      {
        return bool1;
        paramFileManagerEntity = paramFileManagerEntity.cloudFile.onlineFileExt;
        bool1 = bool2;
        if (paramPadInfo.title != null)
        {
          bool1 = bool2;
          if (!paramPadInfo.title.equals(paramFileManagerEntity.fileName))
          {
            paramFileManagerEntity.fileName = paramPadInfo.title;
            bool1 = true;
          }
        }
        if (paramPadInfo.policy != la(paramFileManagerEntity.permissionType))
        {
          paramFileManagerEntity.permissionType = kZ(paramPadInfo.policy);
          bool1 = true;
        }
        bool2 = bool1;
        if (paramPadInfo.domainId != paramFileManagerEntity.domainId)
        {
          paramFileManagerEntity.domainId = paramPadInfo.domainId;
          bool2 = true;
        }
        bool1 = bool2;
        if (paramPadInfo.padId != null)
        {
          bool1 = bool2;
          if (!paramPadInfo.padId.equals(paramFileManagerEntity.localId))
          {
            paramFileManagerEntity.localId = paramPadInfo.padId;
            bool1 = true;
          }
        }
        bool2 = bool1;
        if (paramPadInfo.thumbUrl != null)
        {
          bool2 = bool1;
          if (!paramPadInfo.thumbUrl.equals(paramFileManagerEntity.thumbUrl))
          {
            paramFileManagerEntity.thumbUrl = paramPadInfo.thumbUrl;
            bool2 = true;
          }
        }
        bool1 = bool2;
        if (paramPadInfo.creatorUin != 0L)
        {
          bool1 = bool2;
          if (paramPadInfo.creatorUin != paramFileManagerEntity.creatorUin)
          {
            paramFileManagerEntity.creatorUin = paramPadInfo.creatorUin;
            bool1 = true;
          }
        }
        bool2 = bool1;
        if (paramPadInfo.createTime != 0L)
        {
          bool2 = bool1;
          if (paramPadInfo.createTime != paramFileManagerEntity.onlineCreateTime)
          {
            paramFileManagerEntity.onlineCreateTime = paramPadInfo.createTime;
            bool2 = true;
          }
        }
        bool1 = bool2;
        if (paramPadInfo.lastEditorUin != 0L)
        {
          bool1 = bool2;
          if (paramPadInfo.lastEditorUin != paramFileManagerEntity.lastModifierUin)
          {
            paramFileManagerEntity.lastModifierUin = paramPadInfo.lastEditorUin;
            bool1 = true;
          }
        }
        bool2 = bool1;
        if (paramPadInfo.lastEditTime != 0L)
        {
          bool2 = bool1;
          if (paramPadInfo.lastEditTime != paramFileManagerEntity.onlineModifyTime)
          {
            paramFileManagerEntity.onlineModifyTime = paramPadInfo.lastEditTime;
            bool2 = true;
          }
        }
        bool1 = bool2;
        if (paramPadInfo.shardUin != 0L)
        {
          bool1 = bool2;
          if (paramPadInfo.shardUin != paramFileManagerEntity.shareUin)
          {
            paramFileManagerEntity.shareUin = paramPadInfo.shardUin;
            bool1 = true;
          }
        }
        bool2 = bool1;
        if (paramPadInfo.lastshardTime != 0L)
        {
          bool2 = bool1;
          if (paramPadInfo.lastshardTime != paramFileManagerEntity.lastShardTime)
          {
            paramFileManagerEntity.lastShardTime = paramPadInfo.lastshardTime;
            bool2 = true;
          }
        }
        bool1 = bool2;
      } while (paramPadInfo.currentUserBrowseTime == 0L);
      bool1 = bool2;
    } while (paramPadInfo.currentUserBrowseTime == paramFileManagerEntity.previewTime);
    paramFileManagerEntity.previewTime = paramPadInfo.currentUserBrowseTime;
    return true;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    int i = 0;
    paramContext = BaseApplication.getContext().getSharedPreferences("CloudFileSpaceConfigHandler", 0);
    if (aqmj.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), "cloud_unfull_config_load_suc", 1) == 1) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (aqmj.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), "cloud_full_config_load_suc", 1) == 1) {
        i = 1;
      }
      if ((i != 0) && (paramInt != 0)) {
        break;
      }
      auds.JG("云文件容量不足，添加失败。");
      return;
    }
    aqmj.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), "cloud_key_full_dialog_interval", 1);
    paramContext.getLong("cloud_key_full_dialog_interval_save", 0L);
    System.currentTimeMillis();
    auds.JG("云文件容量不足，添加失败。");
    paramContext.edit().putLong("cloud_key_full_dialog_interval_save", System.currentTimeMillis());
  }
  
  public static String c(float paramFloat)
  {
    DecimalFormat localDecimalFormat = new DecimalFormat("#0.##");
    localDecimalFormat.setRoundingMode(RoundingMode.FLOOR);
    if (paramFloat < 1024.0F) {
      return localDecimalFormat.format(paramFloat) + "B";
    }
    paramFloat /= 1024.0F;
    if (paramFloat < 1024.0F) {
      return localDecimalFormat.format(paramFloat) + "KB";
    }
    paramFloat /= 1024.0F;
    if (paramFloat < 1024.0F) {
      return localDecimalFormat.format(paramFloat) + "MB";
    }
    paramFloat /= 1024.0F;
    return localDecimalFormat.format(paramFloat) + "GB";
  }
  
  public static void c(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    int k = 1;
    BaseApplication.getContext().getSharedPreferences("CloudFileSpaceConfigHandler", 0);
    int i;
    int j;
    if (aqmj.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), "cloud_unfull_config_load_suc", 1) == 1)
    {
      i = 1;
      if (aqmj.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), "cloud_full_config_load_suc", 1) != 1) {
        break label75;
      }
      j = 1;
      label54:
      if ((j != 0) && (i != 0)) {
        break label81;
      }
      auds.Zn("云文件容量不足，添加失败。");
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      label75:
      j = 0;
      break label54;
      label81:
      if (aqmj.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), "cloud_key_full_dialog_show", 1) == 1) {}
      for (i = k; i != 0; i = 0)
      {
        ((acff)paramQQAppInterface.getManager(51)).c(paramQQAppInterface.getCurrentAccountUin());
        new StringBuilder().append(cGO).append("0").toString();
        paramQQAppInterface = aqha.a(paramContext, 230, paramContext.getString(2131691579), paramContext.getString(2131691581), 2131721058, 2131721079, new athx(paramInt), null);
        switch (paramInt)
        {
        }
        paramQQAppInterface.show();
        return;
      }
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2)
  {
    paramContext = BaseApplication.getContext().getSharedPreferences("CloudFileSpaceConfigHandler", 0);
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
        paramInt1 = paramContext.getInt("cloud_key_space_limit_2_save_" + paramQQAppInterface.getAccount(), 0);
        paramContext.edit().putInt("cloud_key_space_limit_2_save_" + paramQQAppInterface.getAccount(), paramInt1 + 1);
        return;
        paramInt1 = paramContext.getInt("cloud_key_space_limit_1_save_" + paramQQAppInterface.getAccount(), 0);
        paramContext.edit().putInt("cloud_key_space_limit_1_save_" + paramQQAppInterface.getAccount(), paramInt1 + 1 + 1);
        paramContext.edit().putLong("cloud_key_space_limit_1_time_save_" + paramQQAppInterface.getAccount(), System.currentTimeMillis());
        return;
        if (paramInt2 == 1)
        {
          paramContext.edit().putLong("cloud_key_cloud_tab_interval_save", System.currentTimeMillis());
          return;
        }
      } while (paramInt2 != 2);
      paramContext.edit().putLong("cloud_key_receive_send_interval_save", System.currentTimeMillis());
      return;
      if (paramInt2 == 1)
      {
        paramContext.edit().putLong("cloud_key_cloud_tab_interval_save", System.currentTimeMillis());
        return;
      }
    } while (paramInt2 != 2);
    paramContext.edit().putLong("cloud_key_receive_send_interval_save", System.currentTimeMillis());
  }
  
  public static void c(AsyncImageView paramAsyncImageView, FileManagerEntity paramFileManagerEntity)
  {
    String str = null;
    int i = -1;
    if (paramFileManagerEntity != null)
    {
      str = j(paramFileManagerEntity);
      i = paramFileManagerEntity.nFileType;
    }
    switch (i)
    {
    case 1: 
    case 3: 
    case 4: 
    default: 
      paramAsyncImageView.setImageResource(kY(i));
    }
    do
    {
      do
      {
        do
        {
          return;
          paramAsyncImageView.setDefaultImage(2130839418);
        } while (!aueh.fileExistsAndNotEmpty(str));
        paramAsyncImageView.setAsyncImage(str);
        return;
        paramAsyncImageView.setDefaultImage(2130845117);
      } while (!aueh.fileExistsAndNotEmpty(str));
      paramAsyncImageView.setApkIconAsyncImage(str);
      return;
      paramAsyncImageView.setDefaultImage(2130839422);
    } while (!aueh.fileExistsAndNotEmpty(str));
    paramAsyncImageView.setAsyncImage(str);
  }
  
  public static boolean c(FileManagerEntity paramFileManagerEntity1, FileManagerEntity paramFileManagerEntity2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFileManagerEntity1.cloudId != null)
    {
      bool1 = bool2;
      if (paramFileManagerEntity2.cloudId != null)
      {
        bool1 = bool2;
        if (paramFileManagerEntity1.pDirKey != null)
        {
          bool1 = bool2;
          if (paramFileManagerEntity2.pDirKey != null)
          {
            bool1 = bool2;
            if (Arrays.equals(paramFileManagerEntity1.cloudId, paramFileManagerEntity2.cloudId))
            {
              bool1 = bool2;
              if (Arrays.equals(paramFileManagerEntity1.pDirKey, paramFileManagerEntity2.pDirKey)) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static String d(float paramFloat)
  {
    if (paramFloat < 1024.0F) {
      return (int)Math.floor(paramFloat) + "B";
    }
    paramFloat /= 1024.0F;
    if (paramFloat < 1024.0F) {
      return (int)Math.floor(paramFloat) + "KB";
    }
    paramFloat /= 1024.0F;
    if (paramFloat < 1024.0F) {
      return (int)Math.floor(paramFloat) + "MB";
    }
    paramFloat /= 1024.0F;
    return (int)Math.floor(paramFloat) + "GB";
  }
  
  public static void d(AsyncImageView paramAsyncImageView, FileManagerEntity paramFileManagerEntity)
  {
    String str = null;
    int i = -1;
    if (paramFileManagerEntity != null)
    {
      str = j(paramFileManagerEntity);
      i = paramFileManagerEntity.nFileType;
    }
    switch (i)
    {
    case 1: 
    case 3: 
    case 4: 
    default: 
      paramAsyncImageView.setImageResource(hL(i));
    }
    do
    {
      do
      {
        do
        {
          return;
          paramAsyncImageView.setDefaultImage(2130839386);
        } while (!aueh.fileExistsAndNotEmpty(str));
        paramAsyncImageView.setAsyncImage(str);
        return;
        paramAsyncImageView.setDefaultImage(2130845117);
      } while (!aueh.fileExistsAndNotEmpty(str));
      paramAsyncImageView.setApkIconAsyncImage(str);
      return;
      paramAsyncImageView.setDefaultImage(2130839393);
    } while (!aueh.fileExistsAndNotEmpty(str));
    paramAsyncImageView.setAsyncImage(str);
  }
  
  public static boolean g(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramQQAppInterface = ((atgc)paramQQAppInterface.getManager(373)).hg();
    return (paramQQAppInterface != null) && (!paramQQAppInterface.isEmpty());
  }
  
  public static void h(Context paramContext, Intent paramIntent, int paramInt)
  {
    if ((paramContext instanceof FragmentActivity))
    {
      Object localObject = ((FragmentActivity)paramContext).getSupportFragmentManager().getFragments();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramContext = ((List)localObject).iterator();
        while (paramContext.hasNext())
        {
          localObject = (Fragment)paramContext.next();
          if ((localObject != null) && (((Fragment)localObject).isVisible())) {
            ((Fragment)localObject).startActivityForResult(paramIntent, paramInt);
          }
        }
        return;
      }
      ((Activity)paramContext).startActivityForResult(paramIntent, paramInt);
      return;
    }
    if ((paramContext instanceof Activity))
    {
      ((Activity)paramContext).startActivityForResult(paramIntent, paramInt);
      return;
    }
    paramContext.startActivity(paramIntent);
  }
  
  public static int hL(int paramInt)
  {
    switch (paramInt)
    {
    case 11: 
    default: 
      return 2130839375;
    case 2: 
      return 2130839393;
    case 0: 
      return 2130839386;
    case 1: 
      return 2130839384;
    case 3: 
      return 2130839394;
    case 4: 
      return 2130839395;
    case 6: 
      return 2130839378;
    case 5: 
      return 2130845117;
    case 7: 
      return 2130839388;
    case 8: 
      return 2130845146;
    case 9: 
      return 2130839385;
    case 10: 
      return 2130839391;
    case 12: 
      return 2130839389;
    case 13: 
      return 2130851565;
    case 14: 
      return 2130851566;
    case 15: 
      return 2130851567;
    }
    return 2130851577;
  }
  
  public static String j(FileManagerEntity paramFileManagerEntity)
  {
    String str = paramFileManagerEntity.getFilePath();
    if (paramFileManagerEntity.nFileType == 0) {
      if (aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.strMiddleThumPath)) {
        str = paramFileManagerEntity.strMiddleThumPath;
      }
    }
    while (paramFileManagerEntity.nFileType != 2)
    {
      do
      {
        return str;
        if (aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.strLargeThumPath)) {
          return paramFileManagerEntity.strLargeThumPath;
        }
      } while (!aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.strThumbPath));
      return paramFileManagerEntity.strThumbPath;
    }
    if (aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.strLargeThumPath)) {
      return paramFileManagerEntity.strLargeThumPath;
    }
    return null;
  }
  
  public static int kY(int paramInt)
  {
    switch (paramInt)
    {
    case -1: 
    case 11: 
    case 12: 
    default: 
      return 2130839411;
    case 2: 
      return 2130839422;
    case 0: 
      return 2130839418;
    case 1: 
      return 2130839414;
    case 3: 
      return 2130839424;
    case 6: 
      return 2130839412;
    case 7: 
      return 2130839419;
    case 9: 
      return 2130839417;
    case 10: 
      return 2130839420;
    case 13: 
      return 2130839415;
    case 14: 
      return 2130839416;
    case 4: 
      return 2130839425;
    case 8: 
      return 2130845146;
    }
    return 2130845117;
  }
  
  public static int kZ(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      return 3;
    case 0: 
      return 1;
    case 1: 
      return 2;
    }
    return 4;
  }
  
  public static int la(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return 2;
    case 1: 
      return 0;
    case 2: 
      return 1;
    }
    return 4;
  }
  
  public static void nJ(List<? extends atiu> paramList)
  {
    Collections.sort(paramList, new athw());
  }
  
  public static boolean v(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && ((paramInt == 22081) || (paramInt == 1053) || (paramInt == -20001));
  }
  
  public static abstract interface a
  {
    public abstract void nH(List<FileManagerEntity> paramList);
  }
  
  public static class b
    extends LinkMovementMethod
  {
    public ForegroundColorSpan b;
    ForegroundColorSpan c;
    public View.OnClickListener gq;
    public Runnable ip;
    
    public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
    {
      int i = paramMotionEvent.getAction();
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      int m = paramTextView.getTotalPaddingLeft();
      int n = paramTextView.getTotalPaddingTop();
      int i1 = paramTextView.getScrollX();
      int i2 = paramTextView.getScrollY();
      Object localObject = paramTextView.getLayout();
      j = ((Layout)localObject).getOffsetForHorizontal(((Layout)localObject).getLineForVertical(k - n + i2), j - m + i1);
      localObject = (ForegroundColorSpan[])paramSpannable.getSpans(j, j, ForegroundColorSpan.class);
      if (localObject.length != 0)
      {
        if (this.ip != null) {
          return true;
        }
        j = paramSpannable.getSpanStart(localObject[0]);
        k = paramSpannable.getSpanEnd(localObject[0]);
        if (i == 0)
        {
          if (this.c != null)
          {
            paramSpannable.removeSpan(localObject[0]);
            paramSpannable.setSpan(this.c, j, k, 33);
            return true;
          }
        }
        else
        {
          if (i == 1)
          {
            this.ip = new CloudFileUtils.MyLinkMovementMethod.1(this, paramSpannable, localObject[0], j, k, paramTextView);
            new Handler().postDelayed(this.ip, 400L);
            return true;
          }
          if (this.b != null)
          {
            paramSpannable.removeSpan(localObject[0]);
            paramSpannable.setSpan(this.b, j, k, 33);
          }
          Selection.removeSelection(paramSpannable);
        }
      }
      for (;;)
      {
        return super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
        Selection.removeSelection(paramSpannable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     athu
 * JD-Core Version:    0.7.0.1
 */