import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;

public class ci
{
  static String TAG = "DirectForwarder";
  QQAppInterface app;
  
  public ci(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private int a(String paramString, int paramInt, boolean paramBoolean, ci.a parama)
  {
    anpb.F(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_forwardin_image");
    if ((paramString == null) || (paramString.equals("")))
    {
      QLog.e(TAG, 2, "forwardPhoto. path=null");
      return 4;
    }
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = paramString.split(";");
    int j = 0;
    int i = 0;
    if (j < arrayOfString.length)
    {
      if (ahbj.fileExistsAndNotEmpty(arrayOfString[j]))
      {
        paramString = arrayOfString[j];
        label94:
        if (TextUtils.isEmpty(paramString)) {
          break label257;
        }
        if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))) {
          break label247;
        }
        anot.a(this.app, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.e("qqdataline", 2, "shareFromMigSdk|report send link:0X800492E.");
        }
        if (d(paramString, paramInt, paramBoolean, parama) == 0) {
          i = 1;
        }
      }
      for (;;)
      {
        for (;;)
        {
          j += 1;
          break;
          try
          {
            paramString = URLDecoder.decode(arrayOfString[j], "UTF-8");
          }
          catch (UnsupportedEncodingException paramString)
          {
            if (QLog.isColorLevel()) {
              QLog.e("qqdataline", 2, "forwardImage. decode exp. imageUrls[i]=" + arrayOfString[j]);
            }
          }
          catch (IllegalArgumentException paramString)
          {
            paramString = arrayOfString[j];
          }
        }
        break label94;
        label247:
        localArrayList.add(paramString);
        continue;
        label257:
        if (QLog.isColorLevel()) {
          QLog.e("qqdataline", 2, "forwardImage|file path invalid. path=" + paramString);
        }
      }
    }
    if (!localArrayList.isEmpty())
    {
      if (paramBoolean)
      {
        if (localArrayList.size() <= 1) {
          break label374;
        }
        anot.a(this.app, "CliOper", "", "", "0X8004930", "0X8004930", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.e("qqdataline", 2, "forwardImage shareFromMigSdk|report send multi pic:0X8004930.");
        }
      }
      while ((a(localArrayList, 1, paramInt, paramBoolean, parama) == 0) || (i != 0))
      {
        return 0;
        label374:
        if (localArrayList.size() == 1)
        {
          anot.a(this.app, "CliOper", "", "", "0X800492F", "0X800492F", 0, 0, "", "", "", "");
          if (QLog.isColorLevel()) {
            QLog.e("qqdataline", 2, "forwardImage shareFromMigSdk|report single pics:0X800492F.");
          }
        }
      }
      return 8;
    }
    if (i != 0) {
      return 0;
    }
    return 4;
  }
  
  private int a(ArrayList<String> paramArrayList, int paramInt1, int paramInt2, boolean paramBoolean, ci.a parama)
  {
    if (paramArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "sendMultipleFile paths is null !!!!!!");
      }
      if (parama != null) {
        parama.cb();
      }
      return 268;
    }
    if (paramBoolean)
    {
      int i = 0;
      localObject = "";
      while (i < paramArrayList.size())
      {
        anot.a(this.app, "CliOper", "", "", "0X800492D", "0X800492D", 0, 0, "", "", "", "");
        localObject = (String)localObject + "sendMultipleFile shareFromMigSdk|report send one from sdk:0X800492D.";
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.e("qqdataline", 2, (String)localObject);
      }
    }
    Object localObject = new cj(this, paramArrayList, paramInt2);
    long l = a(paramArrayList);
    if (l == 0L)
    {
      if (parama != null) {
        parama.ca();
      }
      return 128;
    }
    if ((aqiw.isNetworkAvailable(this.app.getApp())) && (!aqiw.isWifiConnected(this.app.getApp())) && (l > 3145728L))
    {
      if (parama != null) {
        parama.a((AsyncTask)localObject, paramInt1);
      }
      return 512;
    }
    ((AsyncTask)localObject).execute(new Integer[] { Integer.valueOf(paramInt1) });
    return 0;
  }
  
  private long a(ArrayList<String> paramArrayList)
  {
    if (paramArrayList == null) {
      return 0L;
    }
    paramArrayList = paramArrayList.iterator();
    long l = 0L;
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (str != null) {
        l = new VFSFile(str).length() + l;
      }
    }
    return l;
  }
  
  public static void a(Context paramContext, AsyncTask<Integer, Integer, String> paramAsyncTask, int paramInt, ahal.a parama)
  {
    ahal.a(paramContext, 2131693826, 2131693832, new ck(paramAsyncTask, paramInt, parama));
  }
  
  private boolean a(Bundle paramBundle, ForwardFileInfo paramForwardFileInfo, int paramInt1, int paramInt2)
  {
    if (paramForwardFileInfo == null) {}
    boolean bool;
    do
    {
      do
      {
        return false;
        paramBundle = this.app.a().b(paramForwardFileInfo.fR());
      } while (paramBundle == null);
      QLog.i(TAG, 1, "ForwardOfflineFile forwardFileType: " + paramInt1 + " devType:" + paramInt2);
      int i = acde.a(paramBundle);
      switch (i)
      {
      case 4: 
      case 5: 
      default: 
        QLog.w(TAG, 1, "ForwardOfflineFile fileFrom " + i + " is not handled");
        return false;
      case 3: 
        if (paramInt1 != 101) {
          break label186;
        }
        bool = true;
        paramBundle = b(paramForwardFileInfo, bool, paramInt2);
      }
    } while (paramBundle == null);
    ((acde)this.app.getBusinessHandler(8)).a(paramBundle, false);
    for (;;)
    {
      return true;
      label186:
      bool = false;
      break;
      this.app.a().n(3, paramForwardFileInfo.fR(), paramInt2);
      continue;
      paramInt1 = 7;
      if (paramInt2 == 1) {
        paramInt1 = 6003;
      }
      this.app.a().a(paramForwardFileInfo.fR(), paramForwardFileInfo.vj(), paramForwardFileInfo.getFriendUin(), Long.parseLong(this.app.getCurrentAccountUin()), paramInt1, paramForwardFileInfo.Et());
      continue;
      this.app.a().a(paramBundle, "7", 6000, paramForwardFileInfo.forwardID);
    }
  }
  
  private int b(String paramString, int paramInt, boolean paramBoolean, ci.a parama)
  {
    anpb.F(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_forwardin_file");
    if ((paramString == null) || (paramString.equals("")))
    {
      QLog.e(TAG, 2, "forwardFile. path=null");
      return 4;
    }
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = paramString.split(";");
    int j = 0;
    int i = 0;
    if (j < arrayOfString.length)
    {
      if (ahbj.fileExistsAndNotEmpty(arrayOfString[j]))
      {
        paramString = arrayOfString[j];
        label96:
        if (TextUtils.isEmpty(paramString)) {
          break label219;
        }
        if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))) {
          break label209;
        }
        if (d(paramString, paramInt, paramBoolean, parama) == 0) {
          i = 1;
        }
      }
      for (;;)
      {
        for (;;)
        {
          j += 1;
          break;
          try
          {
            paramString = URLDecoder.decode(arrayOfString[j], "UTF-8");
          }
          catch (UnsupportedEncodingException paramString)
          {
            if (QLog.isColorLevel()) {
              QLog.e("qqdataline", 2, "forwardFile|decode exp. imageUrls[i]=" + arrayOfString[j]);
            }
          }
          catch (IllegalArgumentException paramString)
          {
            paramString = arrayOfString[j];
          }
        }
        break label96;
        label209:
        localArrayList.add(paramString);
        continue;
        label219:
        if (QLog.isColorLevel()) {
          QLog.e("qqdataline", 2, "forwardFile|file path invalid. path=" + paramString);
        }
      }
    }
    if (!localArrayList.isEmpty())
    {
      if (paramBoolean)
      {
        anot.a(this.app, "CliOper", "", "", "0X8004932", "0X8004932", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.e("qqdataline", 2, "forwardFile shareFromMigSdk|report send file:0X8004932.");
        }
      }
      if ((a(localArrayList, 0, paramInt, paramBoolean, parama) == 0) || (i != 0)) {
        return 0;
      }
      return 8;
    }
    if (i != 0) {
      return 0;
    }
    return 4;
  }
  
  private DataLineMsgRecord b(ForwardFileInfo paramForwardFileInfo, boolean paramBoolean, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = this.app.a().b(paramForwardFileInfo.fR());
    if (localFileManagerEntity == null) {}
    int k;
    do
    {
      return null;
      k = acde.a(localFileManagerEntity);
    } while (!acde.ir(k));
    int j = acde.i(paramForwardFileInfo.getFileName(), paramBoolean);
    int i = j;
    if (!paramBoolean)
    {
      i = j;
      if (j == 1) {
        i = 0;
      }
    }
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.msgtype = acde.gu(i);
    localDataLineMsgRecord.sessionid = ((acde)this.app.getBusinessHandler(8)).a(0, paramInt).longValue();
    localDataLineMsgRecord.filename = paramForwardFileInfo.getFileName();
    localDataLineMsgRecord.filesize = paramForwardFileInfo.getFileSize();
    localDataLineMsgRecord.fileUuid = paramForwardFileInfo.getUuid();
    localDataLineMsgRecord.fileFrom = k;
    localDataLineMsgRecord.thumbPath = paramForwardFileInfo.getThumbPath();
    if (!TextUtils.isEmpty(localFileManagerEntity.strFileMd5)) {
      localDataLineMsgRecord.md5 = aqhs.hexStr2Bytes(localFileManagerEntity.strFileMd5);
    }
    if (!TextUtils.isEmpty(localFileManagerEntity.peerUin)) {
      localDataLineMsgRecord.uOwnerUin = Long.parseLong(localFileManagerEntity.peerUin.replace("+", ""));
    }
    if (TextUtils.isEmpty(paramForwardFileInfo.getLocalPath())) {}
    for (localDataLineMsgRecord.path = paramForwardFileInfo.getFileName();; localDataLineMsgRecord.path = paramForwardFileInfo.getLocalPath()) {
      return localDataLineMsgRecord;
    }
  }
  
  private int c(String paramString, int paramInt, boolean paramBoolean, ci.a parama)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      if (aqjb.WEB_URL.matcher(paramString).find()) {
        anpb.F(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_forwardin_link");
      }
      for (;;)
      {
        return d(paramString, paramInt, paramBoolean, parama);
        anpb.F(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_forwardin_text");
      }
    }
    return 4;
  }
  
  private int d(String paramString, int paramInt, boolean paramBoolean, ci.a parama)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (parama != null) {
        parama.cf();
      }
      return 32;
    }
    if (paramString.length() > 3478)
    {
      if (parama != null) {
        parama.ce();
      }
      return 64;
    }
    if (paramBoolean)
    {
      anot.a(this.app, "CliOper", "", "", "0X800492D", "0X800492D", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.e("qqdataline", 2, "sendTextMessage shareFromMigSdk|report send one from sdk:0X800492D.");
      }
    }
    ((acde)this.app.getBusinessHandler(8)).a(paramString, paramInt);
    return 0;
  }
  
  public static void d(String paramString, int paramInt)
  {
    Context localContext = BaseApplicationImpl.getApplication().getBaseContext();
    QQToast.a(localContext, paramInt, paramString, 1).show(localContext.getResources().getDimensionPixelSize(2131299627) - (int)aqho.convertDpToPixel(localContext, 5.0F));
  }
  
  public static void j(Context paramContext, int paramInt)
  {
    QQToast localQQToast = new QQToast(paramContext);
    localQQToast.setToastIcon(2130840061);
    localQQToast.setDuration(2000);
    localQQToast.setToastMsg(paramInt);
    localQQToast.show(paramContext.getResources().getDimensionPixelSize(2131299627) - (int)aqho.convertDpToPixel(paramContext, 5.0F));
  }
  
  public static void k(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return;
    case 2: 
    case 4: 
      j(paramContext, 2131695437);
      return;
    case 8: 
      d(acfp.m(2131705121), 1);
      return;
    case 0: 
      p(2131693980, 2);
      return;
    }
    p(2131696348, 0);
  }
  
  public static void p(int paramInt1, int paramInt2)
  {
    String str = BaseApplicationImpl.getApplication().getBaseContext().getResources().getString(paramInt1);
    if ((str != null) && (str.length() > 0)) {
      d(str, paramInt2);
    }
  }
  
  public int a(String paramString, Bundle paramBundle, ci.a parama)
  {
    int j = 0;
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      j = 9;
      return j;
    }
    int m = paramBundle.getInt("dataline_forward_type", -1);
    Object localObject = paramBundle.getStringArrayList("dataline_forward_pathlist");
    ArrayList localArrayList = paramBundle.getParcelableArrayList("fileinfo_array");
    boolean bool = paramBundle.getBoolean("isMigSdkShare", false);
    acde localacde = (acde)this.app.getBusinessHandler(8);
    if (acbn.bkw.equalsIgnoreCase(paramString)) {
      localacde.aR = acbn.bkw;
    }
    int k;
    for (localacde.cuM = 0;; localacde.cuM = 1)
    {
      k = localacde.cuM;
      if (m != -1) {
        break label140;
      }
      return 2;
      if (!acbn.bkx.equalsIgnoreCase(paramString)) {
        break;
      }
      localacde.aR = acbn.bkx;
    }
    return 8;
    label140:
    if (m == 100) {}
    for (int i = 0;; i = 1)
    {
      if (localObject == null)
      {
        paramString = null;
        if (localArrayList != null) {}
        try
        {
          paramString = (ArrayList)localArrayList;
          if (paramString == null) {
            return 4;
          }
        }
        catch (ClassCastException paramString)
        {
          for (;;)
          {
            paramString = null;
          }
          parama = new ArrayList();
          paramString = paramString.iterator();
          i = 0;
          while (paramString.hasNext())
          {
            localObject = (ForwardFileInfo)paramString.next();
            if (a(paramBundle, (ForwardFileInfo)localObject, m, k))
            {
              i = 1;
            }
            else
            {
              localObject = b((ForwardFileInfo)localObject, false, k);
              if (localObject != null) {
                if (DataLineMsgSet.isSingle((DataLineMsgRecord)localObject))
                {
                  localArrayList = new ArrayList();
                  localArrayList.add(localObject);
                  localacde.z(localArrayList, false);
                  i = 1;
                }
              }
              for (;;)
              {
                break;
                parama.add(localObject);
              }
            }
          }
          if (parama.size() > 0)
          {
            localacde.z(parama, false);
            return 0;
          }
        }
        if (i != 0) {
          break;
        }
        return 4;
      }
      paramString = ((ArrayList)localObject).iterator();
      while (paramString.hasNext())
      {
        paramBundle = (String)paramString.next();
        if ((paramBundle == null) || (paramBundle.equals("/"))) {
          paramString.remove();
        }
      }
      if (!((ArrayList)localObject).isEmpty())
      {
        if (a((ArrayList)localObject, i, k, bool, parama) != 0) {
          break;
        }
        return 0;
      }
      return 4;
    }
  }
  
  public boolean a(DataLineMsgRecord paramDataLineMsgRecord, int paramInt1, int paramInt2)
  {
    boolean bool2;
    if (paramDataLineMsgRecord == null)
    {
      QLog.e(TAG, 1, "reForwardOfflineFile msg=null ");
      bool2 = false;
      return bool2;
    }
    boolean bool1 = false;
    if (paramDataLineMsgRecord.nOpType == 31)
    {
      TroopFileTransferManager.a(this.app, paramDataLineMsgRecord.uOwnerUin).a(paramInt2, paramDataLineMsgRecord.uOwnerUin, paramDataLineMsgRecord.busId, Long.valueOf(paramDataLineMsgRecord.selfuin).longValue(), paramDataLineMsgRecord.istroop, paramDataLineMsgRecord.filename, paramDataLineMsgRecord.thumbPath, paramDataLineMsgRecord.filesize, paramDataLineMsgRecord.fileUuid, true, paramDataLineMsgRecord.sessionid, ahav.a(this.app, paramInt1));
      paramDataLineMsgRecord.fileMsgStatus = 0L;
      paramDataLineMsgRecord.issuc = true;
      bool1 = true;
    }
    for (;;)
    {
      bool2 = bool1;
      if (3 != paramDataLineMsgRecord.fileFrom) {
        break;
      }
      bool2 = bool1;
      if (TextUtils.isEmpty(paramDataLineMsgRecord.fileUuid)) {
        break;
      }
      ((acde)this.app.getBusinessHandler(8)).a(paramDataLineMsgRecord, true);
      return true;
      if (paramDataLineMsgRecord.nOpType == 29)
      {
        if (this.app.a().a(3, paramDataLineMsgRecord.trans2Entity(), paramInt1))
        {
          paramDataLineMsgRecord.fileMsgStatus = 0L;
          paramDataLineMsgRecord.issuc = true;
        }
        bool1 = true;
      }
    }
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 0);
    localBundle.putBoolean("not_forward", true);
    localBundle.putInt("dataline_forward_type", 100);
    localBundle.putString("dataline_forward_path", paramFileManagerEntity.getFilePath());
    localBundle.putParcelable("fileinfo", ahhq.a(paramFileManagerEntity));
    return b(acbn.bkw, localBundle, null) == 0;
  }
  
  public int b(String paramString, Bundle paramBundle, ci.a parama)
  {
    if (!aqiw.isNetSupport(BaseApplication.getContext())) {
      return 9;
    }
    int i = paramBundle.getInt("dataline_forward_type", -1);
    String str1 = paramBundle.getString("dataline_forward_path");
    String str2 = paramBundle.getString("dataline_forward_text");
    boolean bool = paramBundle.getBoolean("isMigSdkShare", false);
    ForwardFileInfo localForwardFileInfo = (ForwardFileInfo)paramBundle.getParcelable("fileinfo");
    acde localacde = (acde)this.app.getBusinessHandler(8);
    if (acbn.bkw.equalsIgnoreCase(paramString)) {
      localacde.aR = acbn.bkw;
    }
    int j;
    for (localacde.cuM = 0;; localacde.cuM = 1)
    {
      j = localacde.cuM;
      if (i != -1) {
        break label145;
      }
      return 2;
      if (!acbn.bkx.equalsIgnoreCase(paramString)) {
        break;
      }
      localacde.aR = acbn.bkx;
    }
    return 8;
    label145:
    if (a(paramBundle, localForwardFileInfo, i, j)) {
      return 0;
    }
    if (paramBundle.getBoolean("filepath_copy", false)) {}
    for (paramString = ahbr.lg(str1);; paramString = str1)
    {
      switch (i)
      {
      default: 
        anpb.F(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_forwardin_other");
        return 4;
      case 101: 
        return a(paramString, j, bool, parama);
      case 100: 
        return b(paramString, j, bool, parama);
      }
      return c(str2, j, bool, parama);
    }
  }
  
  public void onDestroy()
  {
    this.app = null;
  }
  
  public static class a
  {
    public boolean bu;
    
    protected void a(AsyncTask<Integer, Integer, String> paramAsyncTask, int paramInt)
    {
      this.bu = true;
    }
    
    protected void ca()
    {
      ci.p(2131695398, 1);
    }
    
    protected void cb()
    {
      ci.d(acfp.m(2131705122), 1);
    }
    
    protected void ce()
    {
      ci.d(acfp.m(2131705120), 1);
    }
    
    protected void cf()
    {
      ci.d(acfp.m(2131705119), 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ci
 * JD-Core Version:    0.7.0.1
 */