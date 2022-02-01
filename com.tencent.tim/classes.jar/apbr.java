import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Comparator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyGetFileListRspBody.FileInfo;
import tencent.im.cs.group_file_common.group_file_common.FileInfo;
import tencent.im.cs.group_file_common.group_file_common.FolderInfo;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetFileListRspBody.Item;

public final class apbr
{
  public int ErrorCode;
  public UUID Id;
  public boolean IsNewStatus;
  public String LocalFile;
  public String NickName;
  public long ProgressValue;
  public int Status = 7;
  public final String TAG = "TroopFileInfo";
  public transient String ThumbnailFile_Large;
  public transient String ThumbnailFile_Small;
  public String _sStatus;
  public long aqT;
  public long aqU;
  public boolean cPL;
  public boolean cPM;
  public boolean cPN;
  public String coa;
  public String cob;
  public transient String coc;
  public String cod;
  public String coe;
  public int dTg;
  public int dTh;
  private int dTi;
  public int dTj;
  public int dTk;
  public int dTl;
  public String mFileId;
  public String mParentId;
  public Map<String, apbr> nA = new ConcurrentHashMap();
  public String str_file_name;
  public int uint32_upload_time;
  public long uint64_file_size;
  public long uint64_uploaded_size;
  
  public apbr()
  {
    this.cPM = true;
  }
  
  public apbr(cmd0x383.ApplyGetFileListRspBody.FileInfo paramFileInfo)
  {
    a(paramFileInfo);
  }
  
  public apbr(group_file_common.FolderInfo paramFolderInfo)
  {
    a(paramFolderInfo);
  }
  
  public apbr(oidb_0x6d8.GetFileListRspBody.Item paramItem)
  {
    a(paramItem);
  }
  
  private String a(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean)
  {
    int n = 1;
    int m = 0;
    if (!paramBoolean) {}
    for (;;)
    {
      int i;
      try
      {
        if (this.NickName == null)
        {
          break label301;
          if (i != 0)
          {
            this.NickName = aqgv.a(paramQQAppInterface, AW(), paramLong + "", 1, 0);
            if (this.NickName.length() <= 10)
            {
              i = n;
              break label307;
              if (j >= this.NickName.length()) {
                break label292;
              }
              if (Character.isDigit(this.NickName.charAt(j))) {
                continue;
              }
              i = m;
              if ((TextUtils.isEmpty(this.NickName)) || (i != 0)) {
                this.NickName = this.cob;
              }
              this.aqU = SystemClock.uptimeMillis();
            }
          }
          else
          {
            paramQQAppInterface = this.NickName;
            return paramQQAppInterface;
          }
        }
        else
        {
          if (SystemClock.uptimeMillis() - this.aqU > 300000L)
          {
            i = 1;
            continue;
          }
          if (this.NickName.length() <= 10)
          {
            i = 1;
            break label318;
            k = i;
            if (j < this.NickName.length())
            {
              if (!Character.isDigit(this.NickName.charAt(j))) {
                k = 0;
              }
            }
            else
            {
              if (k == 0) {
                break label295;
              }
              long l1 = SystemClock.uptimeMillis();
              long l2 = this.aqU;
              if (l1 - l2 <= 3000L) {
                break label295;
              }
              i = 1;
            }
          }
          else
          {
            i = 0;
            break label318;
          }
          j += 1;
          continue;
        }
        i = 0;
        break label307;
        j += 1;
        continue;
        continue;
      }
      finally {}
      label292:
      label295:
      label301:
      label307:
      do
      {
        i = 0;
        break;
        i = 1;
        break;
      } while (i == 0);
      int j = 0;
      continue;
      label318:
      int k = i;
      if (i != 0) {
        j = 0;
      }
    }
  }
  
  public static String h(Context paramContext, long paramLong)
  {
    String str = aqmu.n(paramContext, paramLong);
    paramContext = str;
    int i;
    int j;
    if (str != null)
    {
      i = aqmu.al(paramLong);
      j = str.indexOf(" ");
      paramContext = str;
      if (j != -1)
      {
        paramContext = str;
        if (j < str.length() - 1)
        {
          if (i != 1) {
            break label70;
          }
          paramContext = str.substring(j + 1);
        }
      }
    }
    label70:
    do
    {
      return paramContext;
      str = str.substring(0, j);
      paramContext = str;
    } while (i != 5);
    return str.substring(2);
  }
  
  public String AV()
  {
    return apsv.getFileSizeDesc(this.uint64_file_size);
  }
  
  public String AW()
  {
    return this.aqT + "";
  }
  
  public String AX()
  {
    return this.cob;
  }
  
  public int Lg()
  {
    return this.uint32_upload_time;
  }
  
  public void WB(int paramInt)
  {
    this.uint32_upload_time = paramInt;
    this.cod = h(BaseApplicationImpl.getApplication(), this.uint32_upload_time * 1000L);
  }
  
  public String a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return aqgv.a(paramQQAppInterface, AW(), paramLong + "", 1, 0);
  }
  
  public void a(apbr paramapbr)
  {
    if (paramapbr != null)
    {
      if ((paramapbr.Status != 8) && (paramapbr.Status != 9)) {
        break label45;
      }
      if (paramapbr.mFileId != null) {
        this.nA.put(paramapbr.mFileId, paramapbr);
      }
    }
    label45:
    while (((paramapbr.Status != 11) && (paramapbr.Status != 10) && (paramapbr.Status != 12)) || (paramapbr.mFileId == null)) {
      return;
    }
    this.nA.remove(paramapbr.mFileId);
  }
  
  public void a(apcy paramapcy, QQAppInterface paramQQAppInterface)
  {
    this.ThumbnailFile_Small = paramapcy.ThumbnailFile_Small;
    this.ThumbnailFile_Large = paramapcy.ThumbnailFile_Large;
    this.coc = paramapcy.coc;
    this.Status = paramapcy.Status;
    this.LocalFile = paramapcy.LocalFile;
    this.ProgressValue = paramapcy.ProgressValue;
    this.ErrorCode = paramapcy.ErrorCode;
    this.IsNewStatus = paramapcy.IsNewStatus;
    if (this.uint32_upload_time == 0)
    {
      this.uint32_upload_time = paramapcy.UploadTime;
      this.cod = h(BaseApplicationImpl.getApplication(), this.uint32_upload_time * 1000L);
    }
    if (this.mFileId == null) {
      this.mFileId = paramapcy.FilePath;
    }
    if (this.mParentId == null) {
      this.mParentId = paramapcy.mParentId;
    }
    if (this.uint64_file_size == 0L) {
      this.uint64_file_size = paramapcy.ProgressTotal;
    }
    if (this.str_file_name == null) {
      this.str_file_name = paramapcy.FileName;
    }
    if ((this.dTg == 0) || (apbr.a.lY(paramapcy.Status))) {
      this.dTg = paramapcy.BusId;
    }
    if ((this.aqT == 0L) && (apbr.a.lY(paramapcy.Status))) {}
    try
    {
      this.aqT = Long.parseLong(paramQQAppInterface.getCurrentAccountUin());
      return;
    }
    catch (NumberFormatException paramapcy)
    {
      QLog.e("TroopFileInfo", 4, "updateItemStatus NumberFormatException");
    }
  }
  
  public void a(cmd0x383.ApplyGetFileListRspBody.FileInfo paramFileInfo)
  {
    if (paramFileInfo == null) {
      return;
    }
    this.cPM = false;
    this.mFileId = paramFileInfo.str_file_path.get();
    this.str_file_name = paramFileInfo.str_file_name.get();
    this.uint64_file_size = paramFileInfo.uint64_file_size.get();
    this.dTg = paramFileInfo.uint32_bus_id.get();
    this.aqT = paramFileInfo.uint32_upload_uin.get();
    this.uint64_uploaded_size = paramFileInfo.uint64_uploaded_size.get();
    this.uint32_upload_time = paramFileInfo.uint32_upload_time.get();
    this.dTh = paramFileInfo.uint32_dead_time.get();
    this.dTi = paramFileInfo.uint32_modify_time.get();
    this.dTj = paramFileInfo.uint32_download_times.get();
    this.cob = paramFileInfo.str_uploader_name.get();
    this.coa = new String(paramFileInfo.bytes_sha.get().toByteArray());
    this.coe = h(BaseApplicationImpl.getApplication(), this.dTi * 1000L);
    this.cod = h(BaseApplicationImpl.getApplication(), this.uint32_upload_time * 1000L);
    this.cPN = false;
  }
  
  public void a(group_file_common.FolderInfo paramFolderInfo)
  {
    if (paramFolderInfo == null) {
      return;
    }
    this.cPN = true;
    this.mFileId = paramFolderInfo.str_folder_id.get();
    this.str_file_name = paramFolderInfo.str_folder_name.get();
    this.uint32_upload_time = paramFolderInfo.uint32_create_time.get();
    this.dTi = paramFolderInfo.uint32_modify_time.get();
    this.aqT = paramFolderInfo.uint64_create_uin.get();
    this.mParentId = "/";
    this.dTl = paramFolderInfo.uint32_total_file_count.get();
    this.cod = h(BaseApplicationImpl.getApplication(), this.uint32_upload_time * 1000L);
    this.coe = h(BaseApplicationImpl.getApplication(), this.dTi * 1000L);
  }
  
  public void a(oidb_0x6d8.GetFileListRspBody.Item paramItem)
  {
    if (paramItem == null) {
      return;
    }
    this.cPM = false;
    switch (paramItem.uint32_type.get())
    {
    default: 
      return;
    case 1: 
      this.cPN = false;
      paramItem = (group_file_common.FileInfo)paramItem.file_info.get();
      this.mFileId = paramItem.str_file_id.get();
      this.str_file_name = paramItem.str_file_name.get();
      this.uint64_file_size = paramItem.uint64_file_size.get();
      this.dTg = paramItem.uint32_bus_id.get();
      this.aqT = paramItem.uint64_uploader_uin.get();
      this.uint64_uploaded_size = paramItem.uint64_uploaded_size.get();
      this.uint32_upload_time = paramItem.uint32_upload_time.get();
      this.dTh = paramItem.uint32_dead_time.get();
      this.dTi = paramItem.uint32_modify_time.get();
      this.dTj = paramItem.uint32_download_times.get();
      this.cob = paramItem.str_uploader_name.get();
      this.coa = new String(paramItem.bytes_sha.get().toByteArray());
      this.mParentId = paramItem.str_parent_folder_id.get();
      this.cod = h(BaseApplicationImpl.getApplication(), this.uint32_upload_time * 1000L);
      this.coe = h(BaseApplicationImpl.getApplication(), this.dTi * 1000L);
      return;
    }
    this.cPN = true;
    paramItem = (group_file_common.FolderInfo)paramItem.folder_info.get();
    this.mFileId = paramItem.str_folder_id.get();
    this.str_file_name = paramItem.str_folder_name.get();
    this.dTi = paramItem.uint32_modify_time.get();
    this.uint32_upload_time = paramItem.uint32_create_time.get();
    this.aqT = paramItem.uint64_create_uin.get();
    this.mParentId = paramItem.str_parent_folder_id.get();
    this.dTl = paramItem.uint32_total_file_count.get();
    this.cod = h(BaseApplicationImpl.getApplication(), this.uint32_upload_time * 1000L);
    this.coe = h(BaseApplicationImpl.getApplication(), this.dTi * 1000L);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean)
  {
    boolean bool1 = paramQQAppInterface.getCurrentAccountUin().equals(AW());
    boolean bool2 = apsv.n(paramQQAppInterface, paramLong);
    switch (this.Status)
    {
    }
    do
    {
      do
      {
        return false;
        if (this.cPN) {
          return bool2;
        }
      } while ((!bool2) && (!bool1));
      return true;
      if (this.cPN) {
        return bool2;
      }
      return true;
    } while (!paramBoolean);
    if (this.cPN) {
      return bool2;
    }
    return true;
  }
  
  public void b(apbr paramapbr)
  {
    if (paramapbr == null) {
      return;
    }
    this.cPM = false;
    this.mFileId = paramapbr.mFileId;
    this.mParentId = paramapbr.mParentId;
    this.str_file_name = paramapbr.str_file_name;
    this.dTg = paramapbr.dTg;
    this.aqT = paramapbr.aqT;
    this.uint64_uploaded_size = paramapbr.uint64_uploaded_size;
    this.uint64_file_size = paramapbr.uint64_file_size;
    this.uint32_upload_time = paramapbr.uint32_upload_time;
    this.dTh = paramapbr.dTh;
    this.dTi = paramapbr.dTi;
    this.dTj = paramapbr.dTj;
    this.cob = paramapbr.cob;
    this.dTl = paramapbr.dTl;
    this.coa = paramapbr.coa;
    this.cPN = paramapbr.cPN;
    this.cod = paramapbr.cod;
    this.coe = paramapbr.coe;
  }
  
  public boolean b(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean)
  {
    return (apsv.n(paramQQAppInterface, paramLong)) && (!this.cPN) && (!paramBoolean) && (!apbr.a.lY(this.Status)) && (!apbr.a.lZ(this.Status));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (!(paramObject instanceof apbr))) {
      return false;
    }
    paramObject = (apbr)paramObject;
    return this.Id.equals(paramObject.Id);
  }
  
  public boolean m(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return (apsv.n(paramQQAppInterface, paramLong)) && (this.cPN);
  }
  
  public void setModifyTime(int paramInt)
  {
    this.dTi = paramInt;
    this.coe = h(BaseApplicationImpl.getApplication(), this.dTi * 1000L);
  }
  
  public String toString()
  {
    return "TroopFileInfo{TAG='TroopFileInfo', Id=" + this.Id + ", str_file_path='" + this.mFileId + '\'' + ", str_file_name='" + this.str_file_name + '\'' + ", uint64_file_size=" + this.uint64_file_size + ", uint32_bus_id=" + this.dTg + ", uint32_upload_uin=" + this.aqT + ", uint64_uploaded_size=" + this.uint64_uploaded_size + ", uint32_upload_time=" + this.uint32_upload_time + ", uint32_dead_time=" + this.dTh + ", uint32_modify_time=" + this.dTi + ", uint32_download_times=" + this.dTj + ", str_uploader_name='" + this.cob + '\'' + ", Status=" + this.Status + ", _sStatus='" + this._sStatus + '\'' + ", ProgressValue=" + this.ProgressValue + ", ErrorCode=" + this.ErrorCode + ", LocalFile='" + this.LocalFile + '\'' + ", UploadCreateTime=" + this.dTk + ", Unread=" + this.cPL + ", ThumbnailFile_Small='" + this.ThumbnailFile_Small + '\'' + ", ThumbnailFile_Large='" + this.ThumbnailFile_Large + '\'' + ", IsGhost=" + this.cPM + ", IsNewStatus=" + this.IsNewStatus + ", NickName='" + this.NickName + '\'' + ", lastNickNameUpdateMS=" + this.aqU + '}';
  }
  
  public void x(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.cob = a(paramQQAppInterface, paramLong, false);
  }
  
  public static class a
  {
    public static int ao(String paramString)
    {
      int i = -1;
      if (paramString.equals("SCANNING")) {
        i = 0;
      }
      do
      {
        return i;
        if (paramString.equals("UPLOADING")) {
          return 1;
        }
        if (paramString.equals("UPLOAD_SUSPEND")) {
          return 2;
        }
        if (paramString.equals("UPLOAD_INTERRUPT")) {
          return 3;
        }
        if (paramString.equals("FORWARDING")) {
          return 4;
        }
        if (paramString.equals("FORWARD_FAILED")) {
          return 5;
        }
        if (paramString.equals("UPLOADED")) {
          return 6;
        }
        if (paramString.equals("NOT_DOWNLOAD")) {
          return 7;
        }
        if (paramString.equals("DOWNLOADING")) {
          return 8;
        }
        if (paramString.equals("DOWNLOAD_SUSPEND")) {
          return 9;
        }
        if (paramString.equals("DOWNLOAD_INTERRUPT")) {
          return 10;
        }
        if (paramString.equals("DOWNLOADED")) {
          return 11;
        }
        if (paramString.equals("DELETED")) {
          return 12;
        }
      } while (!paramString.equals("OTHER_UPLOADING"));
      return 13;
    }
    
    public static boolean lY(int paramInt)
    {
      return (paramInt == 0) || (paramInt == 1) || (paramInt == 2) || (paramInt == 3);
    }
    
    public static boolean lZ(int paramInt)
    {
      return (paramInt == 8) || (paramInt == 10) || (paramInt == 9);
    }
    
    public static String name(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return "";
      case 0: 
        return "SCANNING";
      case 1: 
        return "UPLOADING";
      case 2: 
        return "UPLOAD_SUSPEND";
      case 3: 
        return "UPLOAD_INTERRUPT";
      case 4: 
        return "FORWARDING";
      case 5: 
        return "FORWARD_FAILED";
      case 6: 
        return "UPLOADED";
      case 7: 
        return "NOT_DOWNLOAD";
      case 8: 
        return "DOWNLOADING";
      case 9: 
        return "DOWNLOAD_SUSPEND";
      case 10: 
        return "DOWNLOAD_INTERRUPT";
      case 11: 
        return "DOWNLOADED";
      case 12: 
        return "DELETED";
      }
      return "OTHER_UPLOADING";
    }
  }
  
  public static class b
    implements Comparator<apbr>
  {
    public int a(apbr paramapbr1, apbr paramapbr2)
    {
      if (paramapbr1.uint32_upload_time < paramapbr2.uint32_upload_time) {
        return 1;
      }
      if (paramapbr1.uint32_upload_time == paramapbr2.uint32_upload_time) {
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apbr
 * JD-Core Version:    0.7.0.1
 */