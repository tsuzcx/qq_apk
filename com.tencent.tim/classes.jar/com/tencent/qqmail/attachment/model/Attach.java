package com.tencent.qqmail.attachment.model;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.attachment.util.AttachToolbox;
import com.tencent.qqmail.download.util.DownloadUtil;
import com.tencent.qqmail.model.qmdomain.QMDomain;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.QMMath;
import com.tencent.qqmail.utilities.common.CommUtils;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

public class Attach
  extends QMDomain
{
  public static final int ATTACH_ATTR_FAVLOCAL = 64;
  public static final int ATTACH_BIG = 1;
  public static final int ATTACH_NORMAL = 0;
  public static final String BYTE_CHARACTER = "字节";
  public static final String BYTE_LETTER = "B";
  private static final String TAG_ACCOUNT_ID = "accountId";
  private static final String TAG_ATTACH_FOLDER = "attachfolder";
  private static final String TAG_BELONG_MAIL_ID = "belongMailId";
  private static final String TAG_CLASS_NAME = "Attach";
  private static final String TAG_COMPOSE_PATH = "composepath";
  private static final String TAG_DOWNLOAD_KEY = "downloadkey";
  private static final String TAG_FROM = "from";
  private static final String TAG_FROM_ADDR = "fromaddr";
  private static final String TAG_HASH_ID = "hashId";
  private static final String TAG_IS_DEL = "isdel";
  private static final String TAG_IS_FAVORITE = "isfavorite";
  private static final String TAG_IS_PROTOCOL = "isProtocol";
  private static final String TAG_KEY = "key";
  private static final String TAG_MAIL_ID = "mailid";
  private static final String TAG_NAME = "name";
  private static final String TAG_PROTOCOL = "protocol";
  private static final String TAG_SUBJECT = "subject";
  private static final String TAG_SUFFIX = "suffix";
  private static final String TAG_SZ = "sz";
  private static final String TAG_SZ_BYTE = "szbyte";
  private static final String TAG_TIMESTAMP = "timestamp";
  private static final String TAG_URL_ENCODE_NAME = "urlencodename";
  private static final String TAG_VIEW_MODE = "viewmode";
  private static final String TAG_VIEW_URL = "viewurl";
  private static final long serialVersionUID = 8848392651821929474L;
  private int accountId;
  private String alias;
  private long belongMailId;
  private long bytes = 0L;
  private String displayName;
  private String downloadKey;
  private long favTime;
  private int folderId;
  private int folderKey;
  private long hashId = 0L;
  private String httpUrl;
  private boolean isFav;
  private boolean isInline;
  private boolean isProtocol;
  private String mailSender;
  private String mailSenderAddr;
  private String mailSubject;
  private String name;
  private int orderIndex;
  private AttachPreview preview = new AttachPreview();
  private String previewUrl;
  private AttachProtocol protocol = new AttachProtocol();
  private int rank;
  private long refMailId;
  private String remoteId;
  private String size = "0";
  private AttachState state = new AttachState();
  private String suffix;
  private String urlEncodeName;
  private String viewMode;
  
  public Attach() {}
  
  public Attach(boolean paramBoolean)
  {
    this.isProtocol = paramBoolean;
  }
  
  public static int generateHashId(long paramLong, String paramString1, String paramString2)
  {
    return QMMath.hashPositivetInt(paramLong + "_" + paramString1 + "" + paramString2);
  }
  
  public static int generateHashId(Attach paramAttach, boolean paramBoolean)
  {
    if (paramAttach == null) {
      return -1;
    }
    int j = 0;
    String str2 = "";
    String str3 = paramAttach.preview.getDownloadUrl();
    String str1 = str2;
    if (!StringExtention.isNullOrEmpty(str3))
    {
      boolean bool = str3.contains("cgi-bin/groupattachment");
      str1 = str2;
      j = bool;
      if (bool)
      {
        str1 = AttachToolbox.getGroupMailAttFromUrl(str3);
        j = bool;
      }
    }
    str2 = String.valueOf(paramAttach.getBytes());
    if (paramBoolean) {
      return generateHashId(paramAttach.getBelongMailId(), str2, paramAttach.getName());
    }
    if (j != 0) {
      return generateHashId(paramAttach.getBelongMailId(), "0", str1);
    }
    if ((paramAttach.isProtocol()) && (!paramAttach.isBigAttach()))
    {
      int i = paramAttach.protocol.getProtocolType();
      if (i == 1)
      {
        if (paramAttach.protocol.getBodyInfo() != null) {}
        for (str1 = paramAttach.protocol.getBodyInfo().bodyId;; str1 = paramAttach.getName()) {
          return generateHashId(paramAttach.getBelongMailId(), str2, str1);
        }
      }
      if ((i == 4) || (i == 3)) {
        return generateHashId(paramAttach.getBelongMailId(), str2, paramAttach.protocol.getExchangeFileUid());
      }
      if (i == 0) {
        return generateHashId(paramAttach.getBelongMailId(), str2, paramAttach.preview.getMyDisk());
      }
      return generateHashId(paramAttach.getBelongMailId(), str2, paramAttach.getName());
    }
    return generateHashId(paramAttach.getBelongMailId(), paramAttach.getSize(), paramAttach.getName());
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof Attach))) {}
    do
    {
      return false;
      paramObject = (Attach)paramObject;
    } while (getHashId() != paramObject.getHashId());
    return true;
  }
  
  public int getAccountId()
  {
    return this.accountId;
  }
  
  public String getAlias()
  {
    return this.alias;
  }
  
  public long getBelongMailId()
  {
    return this.belongMailId;
  }
  
  public long getBytes()
  {
    return this.bytes;
  }
  
  public String getDisplayName()
  {
    return this.displayName;
  }
  
  public String getDownloadKey()
  {
    return this.downloadKey;
  }
  
  public long getFavTime()
  {
    return this.favTime;
  }
  
  public int getFolderId()
  {
    return this.folderId;
  }
  
  public int getFolderKey()
  {
    return this.folderKey;
  }
  
  public long getHashId()
  {
    return this.hashId;
  }
  
  public String getHttpUrl()
  {
    return this.httpUrl;
  }
  
  public String getMailSender()
  {
    return this.mailSender;
  }
  
  public String getMailSenderAddr()
  {
    return this.mailSenderAddr;
  }
  
  public String getMailSubject()
  {
    return this.mailSubject;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getOrderIndex()
  {
    return this.orderIndex;
  }
  
  public AttachPreview getPreview()
  {
    return this.preview;
  }
  
  public String getPreviewUrl()
  {
    return this.previewUrl;
  }
  
  public AttachProtocol getProtocol()
  {
    return this.protocol;
  }
  
  public int getRank()
  {
    return this.rank;
  }
  
  public long getRefMailId()
  {
    return this.refMailId;
  }
  
  public String getRemoteId()
  {
    return this.remoteId;
  }
  
  public String getSize()
  {
    return this.size;
  }
  
  public AttachState getState()
  {
    return this.state;
  }
  
  public String getSuffix()
  {
    return this.suffix;
  }
  
  public String getUrlEncodeName()
  {
    return this.urlEncodeName;
  }
  
  public String getViewMode()
  {
    return this.viewMode;
  }
  
  public boolean isBigAttach()
  {
    return false;
  }
  
  public boolean isExist()
  {
    Object localObject = QMAttachManager.sharedInstance();
    long l = this.hashId;
    if (isBigAttach()) {}
    for (int i = 1;; i = 0)
    {
      localObject = ((QMAttachManager)localObject).getAttachMyDisk(l, i);
      if (!FileUtil.isFileExist((String)localObject)) {
        break;
      }
      this.preview.setMyDisk((String)localObject);
      return true;
    }
    if (((this.isProtocol) && (this.protocol.getProtocolType() == 0)) || (isFromEml()))
    {
      localObject = this.preview.getCopyDiskList();
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = (String)((ArrayList)localObject).get(0);
        if (FileUtil.isFileExist((String)localObject))
        {
          String str = DownloadUtil.fileCopyTo((String)localObject, FileUtil.getAttachDownloadDir(), this.name);
          if (!StringExtention.isNullOrEmpty(str))
          {
            QMLog.log(4, "ATTACH", "copy from data to:" + str);
            QMAttachManager.sharedInstance().updateAttachDisk(this.hashId, this.name, str, (String)localObject, 0);
            this.preview.setMyDisk(str);
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public boolean isFav()
  {
    return this.isFav;
  }
  
  public boolean isFromEml()
  {
    return QMAttachManager.sharedInstance().isAttachFromEml(this.belongMailId);
  }
  
  public boolean isInline()
  {
    return this.isInline;
  }
  
  public boolean isProtocol()
  {
    return this.isProtocol;
  }
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.getString("isdel");
    if (str != null) {
      if (Integer.parseInt(str) == 1)
      {
        if (!isFav()) {
          break label1062;
        }
        setIsFav(false);
      }
    }
    label1032:
    label1062:
    for (boolean bool1 = true;; bool1 = false)
    {
      paramJSONObject = paramJSONObject.getString("key");
      boolean bool2 = bool1;
      int i;
      if (paramJSONObject != null)
      {
        i = Integer.parseInt(paramJSONObject);
        bool2 = bool1;
        if (getFolderKey() != i)
        {
          setFolderKey(i);
          bool2 = true;
        }
      }
      label77:
      return bool2;
      if (!isFav()) {
        setIsFav(true);
      }
      for (int j = 1;; j = 0)
      {
        str = paramJSONObject.getString("name");
        i = j;
        if (str != null)
        {
          i = j;
          if (CommUtils.isNullorBlankorNotEquals(getName(), str))
          {
            setName(str);
            setDisplayName(str);
            i = 1;
          }
        }
        str = paramJSONObject.getString("composepath");
        j = i;
        if (str != null)
        {
          j = i;
          if (CommUtils.isNullorBlankorNotEquals(getAlias(), str))
          {
            setAlias(str);
            j = 1;
          }
        }
        str = paramJSONObject.getString("sz");
        if ((str != null) && (CommUtils.isNullorBlankorNotEquals(getSize(), str)))
        {
          setSize(str);
          j = 1;
        }
        for (;;)
        {
          str = (String)paramJSONObject.get("suffix");
          i = j;
          if (str != null)
          {
            i = j;
            if (CommUtils.isNullorBlankorNotEquals(getSuffix(), str))
            {
              setSuffix(str);
              i = 1;
            }
          }
          str = paramJSONObject.getString("hashId");
          j = i;
          long l;
          if (!StringUtils.isBlank(str))
          {
            l = Long.parseLong(str);
            j = i;
            if (getHashId() != l)
            {
              setHashId(l);
              j = 1;
            }
          }
          str = paramJSONObject.getString("belongMailId");
          i = j;
          if (!StringUtils.isBlank(str))
          {
            l = Long.parseLong(str);
            i = j;
            if (getBelongMailId() != l)
            {
              setBelongMailId(l);
              i = 1;
            }
          }
          str = paramJSONObject.getString("accountId");
          j = i;
          if (!StringUtils.isBlank(str))
          {
            k = Integer.parseInt(str);
            j = i;
            if (getAccountId() != k)
            {
              setAccountId(k);
              j = 1;
            }
          }
          i = j;
          if (paramJSONObject.get("isProtocol") != null)
          {
            i = j;
            if (paramJSONObject.getBoolean("isProtocol").booleanValue() != isProtocol())
            {
              setIsProtocol(((Boolean)paramJSONObject.get("isProtocol")).booleanValue());
              i = 1;
            }
          }
          str = paramJSONObject.getString("viewmode");
          j = i;
          if (str != null)
          {
            j = i;
            if (CommUtils.isNullorBlankorNotEquals(getViewMode(), str))
            {
              setViewMode(str);
              j = 1;
            }
          }
          str = paramJSONObject.getString("viewurl");
          i = j;
          if (str != null)
          {
            i = j;
            if (CommUtils.isNullorBlankorNotEquals(getPreviewUrl(), str))
            {
              setPreviewUrl(str);
              i = 1;
            }
          }
          str = paramJSONObject.getString("szbyte");
          j = i;
          if (!StringUtils.isBlank(str))
          {
            l = Long.parseLong(str);
            j = i;
            if (getBytes() != l)
            {
              setBytes(l);
              j = 1;
            }
          }
          str = paramJSONObject.getString("fromaddr");
          int k = j;
          if (str != null)
          {
            k = j;
            if (CommUtils.isNullorBlankorNotEquals(getMailSenderAddr(), str))
            {
              setMailSenderAddr(str);
              k = 1;
            }
          }
          str = paramJSONObject.getString("subject");
          i = k;
          if (str != null)
          {
            i = k;
            if (CommUtils.isNullorBlankorNotEquals(getMailSubject(), str))
            {
              setMailSubject(str);
              i = 1;
            }
          }
          j = i;
          if (!isBigAttach())
          {
            str = paramJSONObject.getString("key");
            j = i;
            if (!StringUtils.isBlank(str))
            {
              j = i;
              if (StringUtils.isNumeric(str))
              {
                k = Integer.parseInt(str);
                j = i;
                if (getFolderKey() != k)
                {
                  setFolderKey(k);
                  j = 1;
                }
              }
            }
          }
          str = paramJSONObject.getString("timestamp");
          i = j;
          if (str != null)
          {
            l = Long.parseLong(str) * 1000L;
            i = j;
            if (getFavTime() != l)
            {
              setFavTime(l);
              i = 1;
            }
          }
          str = paramJSONObject.getString("from");
          j = i;
          if (str != null)
          {
            j = i;
            if (CommUtils.isNullorBlankorNotEquals(getMailSender(), str))
            {
              setMailSender(str);
              j = 1;
            }
          }
          str = paramJSONObject.getString("mailid");
          k = j;
          if (str != null)
          {
            k = j;
            if (CommUtils.isNullorBlankorNotEquals(getRemoteId(), str))
            {
              setRemoteId(str);
              k = 1;
            }
          }
          str = paramJSONObject.getString("urlencodename");
          i = k;
          if (str != null)
          {
            i = k;
            if (CommUtils.isNullorBlankorNotEquals(getUrlEncodeName(), str))
            {
              setUrlEncodeName(str);
              i = 1;
            }
          }
          str = paramJSONObject.getString("attachfolder");
          j = i;
          if (!StringUtils.isBlank(str))
          {
            k = QMFolder.generateId(getAccountId(), str, false);
            j = i;
            if (getFolderId() != k)
            {
              setFolderId(k);
              j = 1;
            }
          }
          bool1 = this.preview.parseWithDictionary(paramJSONObject);
          bool2 = this.state.parseWithDictionary(paramJSONObject);
          bool2 = this.protocol.parseWithDictionary((JSONObject)paramJSONObject.get("protocol")) | bool2 | bool1 | j;
          str = paramJSONObject.getString("isfavorite");
          bool1 = bool2;
          if (!StringUtils.isBlank(str))
          {
            if (Integer.parseInt(str) != 1) {
              break label1032;
            }
            bool1 = bool2;
            if (!isFav())
            {
              setIsFav(true);
              bool1 = true;
            }
          }
          for (;;)
          {
            paramJSONObject = paramJSONObject.getString("downloadkey");
            bool2 = bool1;
            if (paramJSONObject == null) {
              break label77;
            }
            bool2 = bool1;
            if (!CommUtils.isNullorBlankorNotEquals(getDownloadKey(), paramJSONObject)) {
              break label77;
            }
            setDownloadKey(paramJSONObject);
            break;
            bool1 = bool2;
            if (isFav())
            {
              setIsFav(false);
              bool1 = true;
            }
          }
        }
      }
    }
  }
  
  public void setAccountId(int paramInt)
  {
    this.accountId = paramInt;
  }
  
  public void setAlias(String paramString)
  {
    this.alias = paramString;
  }
  
  public void setBelongMailId(long paramLong)
  {
    this.belongMailId = paramLong;
  }
  
  public void setBytes(long paramLong)
  {
    this.bytes = paramLong;
  }
  
  public void setDisplayName(String paramString)
  {
    this.displayName = paramString;
  }
  
  public void setDownloadKey(String paramString)
  {
    this.downloadKey = paramString;
  }
  
  public void setFavTime(long paramLong)
  {
    this.favTime = paramLong;
  }
  
  public void setFolderId(int paramInt)
  {
    this.folderId = paramInt;
  }
  
  public void setFolderKey(int paramInt)
  {
    this.folderKey = paramInt;
  }
  
  public void setHashId(long paramLong)
  {
    this.hashId = paramLong;
  }
  
  public void setHttpUrl(String paramString)
  {
    this.httpUrl = paramString;
  }
  
  public void setIsFav(boolean paramBoolean)
  {
    this.isFav = paramBoolean;
  }
  
  public void setIsInline(boolean paramBoolean)
  {
    this.isInline = paramBoolean;
  }
  
  public void setIsProtocol(boolean paramBoolean)
  {
    this.isProtocol = paramBoolean;
  }
  
  public void setMailSender(String paramString)
  {
    this.mailSender = paramString;
  }
  
  public void setMailSenderAddr(String paramString)
  {
    this.mailSenderAddr = paramString;
  }
  
  public void setMailSubject(String paramString)
  {
    this.mailSubject = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setOrderIndex(int paramInt)
  {
    this.orderIndex = paramInt;
  }
  
  public void setPreview(AttachPreview paramAttachPreview)
  {
    this.preview = paramAttachPreview;
  }
  
  public void setPreviewUrl(String paramString)
  {
    this.previewUrl = paramString;
  }
  
  public void setProtocol(AttachProtocol paramAttachProtocol)
  {
    this.protocol = paramAttachProtocol;
  }
  
  public void setRank(int paramInt)
  {
    this.rank = paramInt;
  }
  
  public void setRefMailId(long paramLong)
  {
    this.refMailId = paramLong;
  }
  
  public void setRemoteId(String paramString)
  {
    this.remoteId = paramString;
  }
  
  public void setSize(String paramString)
  {
    this.size = paramString;
  }
  
  public void setState(AttachState paramAttachState)
  {
    this.state = paramAttachState;
  }
  
  public void setSuffix(String paramString)
  {
    this.suffix = paramString;
  }
  
  public void setUrlEncodeName(String paramString)
  {
    this.urlEncodeName = paramString;
  }
  
  public void setViewMode(String paramString)
  {
    this.viewMode = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("\"class\":\"Attach\",");
    if (getName() != null) {
      localStringBuilder.append("\"name\":\"" + StringExtention.safeStringLiteral(getName()) + "\",");
    }
    if (getSize() != null) {
      localStringBuilder.append("\"sz\":\"" + StringExtention.safeStringLiteral(getSize()) + "\",");
    }
    if (getSuffix() != null) {
      localStringBuilder.append("\"suffix\":\"" + StringExtention.safeStringLiteral(getSuffix()) + "\",");
    }
    localStringBuilder.append("\"mailid\":\"" + getRemoteId() + "\",");
    localStringBuilder.append("\"composepath\":\"" + getAlias() + "\",");
    localStringBuilder.append("\"hashId\":\"" + getHashId() + "\",");
    localStringBuilder.append("\"belongMailId\":\"" + getBelongMailId() + "\",");
    localStringBuilder.append("\"accountId\":\"" + getAccountId() + "\",");
    localStringBuilder.append("\"isProtocol\":" + isProtocol() + ",");
    if (!this.state.toPlainString().equals("")) {
      localStringBuilder.append(this.state.toPlainString() + ",");
    }
    if (!this.protocol.toPlainString().equals(""))
    {
      localStringBuilder.append("\"protocol\":");
      localStringBuilder.append("{");
      localStringBuilder.append(this.protocol.toPlainString());
      localStringBuilder.append("},");
    }
    if (!this.preview.toPlainString().equals("")) {
      localStringBuilder.append(this.preview.toPlainString() + ",");
    }
    int i = localStringBuilder.length() - 1;
    if (localStringBuilder.charAt(i) == ',') {
      localStringBuilder.deleteCharAt(i);
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.model.Attach
 * JD-Core Version:    0.7.0.1
 */