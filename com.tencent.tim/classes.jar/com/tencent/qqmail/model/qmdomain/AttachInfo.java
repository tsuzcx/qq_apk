package com.tencent.qqmail.model.qmdomain;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachType;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.ImageScaleDegree;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.io.File;
import java.math.BigDecimal;

public class AttachInfo
  extends QMDomain
{
  private static final String TAG = "AttachInfo";
  private static final long serialVersionUID = -8893933549780983258L;
  private String absAttachPath;
  private Object attach;
  private String attachName;
  private String attachPath;
  private String attachSize;
  private boolean canCopyToSandBox;
  private String fid;
  private AttachType fileType;
  private long hashId = -1L;
  private double highSize;
  private boolean isBigAttach;
  private boolean isEditAttach;
  private boolean isForwardAttach;
  private boolean isFromFav;
  private boolean isFromOtherApp;
  private boolean isInBodyImage;
  private boolean isLocalAttach = false;
  private boolean isNeedFtnUpload;
  private boolean isNewAdded;
  private boolean isNewSameName;
  private boolean isProcessed;
  private boolean isProtocolAttach = false;
  private boolean isRemoved;
  private boolean isRename;
  private boolean isShareToContent = false;
  private boolean isShow;
  private boolean isTraceLog;
  private boolean loadError;
  private double lowSize;
  private double middleSize;
  private boolean needCopy;
  private String oriAbsAttachPath;
  private int orientationAngel = 0;
  private long realSize;
  private Object thumbnailData;
  private String thumbnailPath;
  public String uploadDataPath;
  
  public AttachInfo()
  {
    setForwardAttach(false);
    setBigAttach(false);
    setEditAttach(false);
    setFileType(AttachType.NONE);
    setFromOtherApp(false);
    setTraceLog(false);
    setAttachName("");
    setAttachPath("");
    setAbsAttachPath("");
    setThumbnailPath("");
    setInBodyImage(false);
    setRemoved(false);
    setNeedCopy(true);
    setNewAdded(true);
    setProcessed(false);
    setCanCopyToSandBox(true);
    setIsShow(true);
    setIsFromFav(false);
  }
  
  public boolean canCopyToSandBox()
  {
    return this.canCopyToSandBox;
  }
  
  public boolean canPreView()
  {
    return (!this.isFromOtherApp) && (this.fileType == AttachType.IMAGE);
  }
  
  public void deleteCache()
  {
    String str = getThumbnailPath();
    FileUtil.delFile(str);
    QMLog.log(4, "AttachInfo", "delele getThumbnailPath: " + str);
    str = getPreviewPath();
    QMLog.log(4, "AttachInfo", "delele getPreviewPath: " + str);
    FileUtil.delFile(str);
  }
  
  public void estimateAndSetSizeByRealSize(long paramLong)
  {
    setRealSize(paramLong);
    if (getFileType() == AttachType.VIDEO)
    {
      setLowSize(paramLong);
      setMiddleSize(paramLong);
      setHighSize(paramLong);
    }
    for (;;)
    {
      setAttachSize(StringExtention.getHumanReadable(paramLong));
      return;
      float f1 = 1.0F / ComposeMailUI.ImageScaleDegree.getSampleSize(ComposeMailUI.ImageScaleDegree.ImageScaleDegree_Low);
      float f2 = 1.0F / ComposeMailUI.ImageScaleDegree.getSampleSize(ComposeMailUI.ImageScaleDegree.ImageScaleDegree_Middle);
      float f3 = 1.0F / ComposeMailUI.ImageScaleDegree.getSampleSize(ComposeMailUI.ImageScaleDegree.ImageScaleDegree_High);
      if (getAttachPostFix().equalsIgnoreCase("png"))
      {
        setLowSize(f1 * f1 * (float)paramLong * 0.2D);
        setMiddleSize(f2 * f2 * (float)paramLong * 0.2D);
        setHighSize(f3 * f3 * (float)paramLong * 0.2D);
      }
      else
      {
        setLowSize(f1 * f1 * (float)paramLong * 1.6F);
        setMiddleSize(f2 * f2 * (float)paramLong * 1.6F);
        setHighSize(f3 * f3 * (float)paramLong * 1.6F);
      }
    }
  }
  
  public String genPreviewPath()
  {
    if (this.attachPath != null)
    {
      String str = this.attachPath.replace(this.attachName, "");
      return str + "view_" + this.attachName;
    }
    return "";
  }
  
  public String getAbsAttachPath()
  {
    return this.absAttachPath;
  }
  
  public Object getAttach()
  {
    return this.attach;
  }
  
  public String getAttachName()
  {
    return this.attachName;
  }
  
  public String getAttachNameWithoutPostFix()
  {
    return FileUtil.trimFileNameSufix(this.attachName).replaceAll(" ", "");
  }
  
  public String getAttachPath()
  {
    return this.attachPath;
  }
  
  public String getAttachPostFix()
  {
    return FileUtil.getFileNameSuffix(this.attachName);
  }
  
  public String getAttachSize()
  {
    return this.attachSize;
  }
  
  public String getFid()
  {
    return this.fid;
  }
  
  public AttachType getFileType()
  {
    return this.fileType;
  }
  
  public long getHashId()
  {
    return this.hashId;
  }
  
  public double getHighSize()
  {
    return this.highSize;
  }
  
  public boolean getIsShow()
  {
    return this.isShow;
  }
  
  public double getLowSize()
  {
    return this.lowSize;
  }
  
  public double getMiddleSize()
  {
    return this.middleSize;
  }
  
  public String getOriAbsAttachPath()
  {
    return this.oriAbsAttachPath;
  }
  
  public int getOrientationAngel()
  {
    return this.orientationAngel;
  }
  
  public String getPreviewPath()
  {
    if ((!FileUtil.hasSdcard()) || (!isPreviewPathDiff())) {
      return this.attachPath;
    }
    return genPreviewPath();
  }
  
  public long getRealSize()
  {
    if (this.realSize == 0L) {
      this.realSize = StringExtention.sizeStrToLong(this.attachSize);
    }
    return this.realSize;
  }
  
  public Object getThumbnailData()
  {
    return this.thumbnailData;
  }
  
  public String getThumbnailPath()
  {
    return this.thumbnailPath;
  }
  
  public String getUploadDataPath()
  {
    return this.uploadDataPath;
  }
  
  public boolean hasSavedToSandbox()
  {
    return (this.attachPath == null) || (this.attachPath.equals(""));
  }
  
  public int hashAttachPath()
  {
    if (this.attachPath == null) {
      return 0;
    }
    return this.attachPath.hashCode();
  }
  
  public boolean isBigAttach()
  {
    return this.isBigAttach;
  }
  
  public boolean isBinaryAttach()
  {
    return (!this.isBigAttach) && (!this.isForwardAttach);
  }
  
  public boolean isEditAttach()
  {
    return this.isEditAttach;
  }
  
  public boolean isForwardAttach()
  {
    return this.isForwardAttach;
  }
  
  public boolean isFromFav()
  {
    return this.isFromFav;
  }
  
  public boolean isFromOtherApp()
  {
    return this.isFromOtherApp;
  }
  
  public boolean isImage()
  {
    return this.fileType == AttachType.IMAGE;
  }
  
  public boolean isInBodyImage()
  {
    return this.isInBodyImage;
  }
  
  public boolean isLoadError()
  {
    return this.loadError;
  }
  
  public boolean isLocalAttach()
  {
    return this.isLocalAttach;
  }
  
  public boolean isNeedCopy()
  {
    return this.needCopy;
  }
  
  public boolean isNeedFtnUpload()
  {
    return this.isNeedFtnUpload;
  }
  
  public boolean isNewAdded()
  {
    return this.isNewAdded;
  }
  
  public boolean isNewSameName()
  {
    return this.isNewSameName;
  }
  
  public boolean isNullorBlankorNotEquals(String paramString1, String paramString2)
  {
    return (paramString1 == null) || (paramString1.equals("")) || (!paramString1.equals(paramString2));
  }
  
  public boolean isPreviewPathDiff()
  {
    return new File(genPreviewPath()).exists();
  }
  
  public boolean isProcessed()
  {
    return this.isProcessed;
  }
  
  public boolean isProtocolAttach()
  {
    return this.isProtocolAttach;
  }
  
  public boolean isRemoved()
  {
    return this.isRemoved;
  }
  
  public boolean isRename()
  {
    return this.isRename;
  }
  
  public boolean isShareToContent()
  {
    return this.isShareToContent;
  }
  
  public boolean isTraceLog()
  {
    return this.isTraceLog;
  }
  
  public boolean isVideo()
  {
    return this.fileType == AttachType.VIDEO;
  }
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    boolean bool4 = false;
    bool3 = false;
    boolean bool2 = bool3;
    bool1 = bool4;
    try
    {
      if (paramJSONObject.get("filetype") != null)
      {
        bool1 = bool4;
        i = paramJSONObject.getIntValue("filetype");
        bool1 = bool4;
        int j = getFileType().ordinal();
        bool2 = bool3;
        if (i == j) {}
      }
    }
    catch (Exception paramJSONObject)
    {
      int i;
      long l1;
      Object localObject1;
      Object localObject2;
      label1507:
      QMLog.log(5, "AttachInfo", paramJSONObject.getMessage());
      label1565:
      return bool1;
    }
    try
    {
      setFileType(AttachType.values()[i]);
      bool2 = true;
      bool3 = bool2;
      bool1 = bool2;
      if (paramJSONObject.get("hashId") != null)
      {
        bool1 = bool2;
        l1 = paramJSONObject.getLong("hashId").longValue();
        bool1 = bool2;
        long l2 = getHashId();
        bool3 = bool2;
        if (l1 != l2)
        {
          setHashId(l1);
          bool3 = true;
        }
      }
      bool1 = bool3;
      if (paramJSONObject.get("isProtocolAttach") == null)
      {
        bool1 = bool3;
        bool4 = ((Boolean)paramJSONObject.get("isProtocolAttach")).booleanValue();
        bool1 = bool3;
        boolean bool5 = isProtocolAttach();
        bool2 = bool3;
        if (bool4 == bool5) {}
      }
      else
      {
        setProtocolAttach(paramJSONObject.getBoolean("isProtocolAttach").booleanValue());
        bool2 = true;
      }
      bool1 = bool2;
      if (paramJSONObject.get("isBigAttach") == null)
      {
        bool1 = bool2;
        bool3 = ((Boolean)paramJSONObject.get("isBigAttach")).booleanValue();
        bool1 = bool2;
        bool4 = isBigAttach();
        if (bool3 == bool4) {}
      }
      else
      {
        setBigAttach(paramJSONObject.getBoolean("isBigAttach").booleanValue());
        bool2 = true;
      }
      bool1 = bool2;
      if (paramJSONObject.get("isEditAttach") == null)
      {
        bool1 = bool2;
        bool3 = ((Boolean)paramJSONObject.get("isEditAttach")).booleanValue();
        bool1 = bool2;
        bool4 = isEditAttach();
        if (bool3 == bool4) {}
      }
      else
      {
        setEditAttach(paramJSONObject.getBoolean("isEditAttach").booleanValue());
        bool2 = true;
      }
      bool1 = bool2;
      if (paramJSONObject.get("isForwardAttach") == null)
      {
        bool1 = bool2;
        bool3 = ((Boolean)paramJSONObject.get("isForwardAttach")).booleanValue();
        bool1 = bool2;
        bool4 = isForwardAttach();
        if (bool3 == bool4) {}
      }
      else
      {
        setForwardAttach(paramJSONObject.getBoolean("isForwardAttach").booleanValue());
        bool2 = true;
      }
      bool1 = bool2;
      localObject1 = paramJSONObject.get("isFromFav");
      if (localObject1 != null)
      {
        setIsFromFav(paramJSONObject.getBoolean("isFromFav").booleanValue());
        bool2 = true;
      }
      bool1 = bool2;
      if (paramJSONObject.get("isFromOtherApp") == null)
      {
        bool1 = bool2;
        bool3 = ((Boolean)paramJSONObject.get("isFromOtherApp")).booleanValue();
        bool1 = bool2;
        bool4 = isFromOtherApp();
        if (bool3 == bool4) {}
      }
      else
      {
        setFromOtherApp(paramJSONObject.getBoolean("isFromOtherApp").booleanValue());
        bool2 = true;
      }
      bool1 = bool2;
      if (paramJSONObject.get("isLocalAttach") == null)
      {
        bool1 = bool2;
        bool3 = ((Boolean)paramJSONObject.get("isLocalAttach")).booleanValue();
        bool1 = bool2;
        bool4 = isLocalAttach();
        if (bool3 == bool4) {}
      }
      else
      {
        setLocalAttach(paramJSONObject.getBoolean("isLocalAttach").booleanValue());
        bool2 = true;
      }
      bool1 = bool2;
      if (paramJSONObject.get("isInBodyImage") == null)
      {
        bool1 = bool2;
        bool3 = ((Boolean)paramJSONObject.get("isInBodyImage")).booleanValue();
        bool1 = bool2;
        bool4 = isInBodyImage();
        if (bool3 == bool4) {}
      }
      else
      {
        setInBodyImage(paramJSONObject.getBoolean("isInBodyImage").booleanValue());
        bool2 = true;
      }
      bool1 = bool2;
      if (paramJSONObject.get("isRemoved") == null)
      {
        bool1 = bool2;
        bool3 = ((Boolean)paramJSONObject.get("isRemoved")).booleanValue();
        bool1 = bool2;
        bool4 = isRemoved();
        if (bool3 == bool4) {}
      }
      else
      {
        setRemoved(paramJSONObject.getBoolean("isRemoved").booleanValue());
        bool2 = true;
      }
      bool1 = bool2;
      if (paramJSONObject.get("isLoadError") == null)
      {
        bool1 = bool2;
        bool3 = ((Boolean)paramJSONObject.get("isLoadError")).booleanValue();
        bool1 = bool2;
        bool4 = isLoadError();
        if (bool3 == bool4) {}
      }
      else
      {
        setLoadError(paramJSONObject.getBoolean("isLoadError").booleanValue());
        bool2 = true;
      }
      bool1 = bool2;
      if (paramJSONObject.get("needCopy") == null)
      {
        bool1 = bool2;
        bool3 = ((Boolean)paramJSONObject.get("needCopy")).booleanValue();
        bool1 = bool2;
        bool4 = isNeedCopy();
        if (bool3 == bool4) {}
      }
      else
      {
        setNeedCopy(paramJSONObject.getBoolean("needCopy").booleanValue());
        bool2 = true;
      }
      bool1 = bool2;
      if (paramJSONObject.get("isNeedFtnUpload") == null)
      {
        bool1 = bool2;
        bool3 = ((Boolean)paramJSONObject.get("isNeedFtnUpload")).booleanValue();
        bool1 = bool2;
        bool4 = isNeedFtnUpload();
        if (bool3 == bool4) {}
      }
      else
      {
        setNeedFtnUpload(paramJSONObject.getBoolean("isNeedFtnUpload").booleanValue());
        bool2 = true;
      }
      bool1 = bool2;
      if (paramJSONObject.get("isRename") == null)
      {
        bool1 = bool2;
        bool3 = ((Boolean)paramJSONObject.get("isRename")).booleanValue();
        bool1 = bool2;
        bool4 = isRename();
        if (bool3 == bool4) {}
      }
      else
      {
        setRename(paramJSONObject.getBoolean("isRename").booleanValue());
        bool2 = true;
      }
      bool1 = bool2;
      localObject1 = (String)paramJSONObject.get("attachName");
      bool3 = bool2;
      if (localObject1 != null)
      {
        bool1 = bool2;
        bool4 = isNullorBlankorNotEquals(getAttachName(), (String)localObject1);
        bool3 = bool2;
        if (bool4)
        {
          setAttachName((String)localObject1);
          bool3 = true;
        }
      }
      bool1 = bool3;
      localObject1 = (String)paramJSONObject.get("attachPath");
      bool2 = bool3;
      if (localObject1 != null)
      {
        bool1 = bool3;
        bool4 = isNullorBlankorNotEquals(getAttachPath(), (String)localObject1);
        bool2 = bool3;
        if (bool4)
        {
          setAttachPath((String)localObject1);
          bool2 = true;
        }
      }
      bool1 = bool2;
      localObject1 = (String)paramJSONObject.get("absAttachPath");
      bool3 = bool2;
      if (localObject1 != null)
      {
        bool1 = bool2;
        bool4 = isNullorBlankorNotEquals(getAbsAttachPath(), (String)localObject1);
        bool3 = bool2;
        if (bool4)
        {
          setAbsAttachPath((String)localObject1);
          bool3 = true;
        }
      }
      bool1 = bool3;
      localObject1 = (String)paramJSONObject.get("oriAbsAttachPath");
      bool2 = bool3;
      if (localObject1 != null)
      {
        bool1 = bool3;
        bool4 = isNullorBlankorNotEquals(getOriAbsAttachPath(), (String)localObject1);
        bool2 = bool3;
        if (bool4)
        {
          setOriAbsAttachPath((String)localObject1);
          bool2 = true;
        }
      }
      bool1 = bool2;
      localObject1 = (String)paramJSONObject.get("thumPath");
      bool3 = bool2;
      if (localObject1 != null)
      {
        bool1 = bool2;
        bool4 = isNullorBlankorNotEquals(getThumbnailPath(), (String)localObject1);
        bool3 = bool2;
        if (bool4)
        {
          setThumbnailPath((String)localObject1);
          bool3 = true;
        }
      }
      bool1 = bool3;
      localObject1 = (String)paramJSONObject.get("attachSz");
      bool2 = bool3;
      if (localObject1 != null)
      {
        bool1 = bool3;
        bool4 = isNullorBlankorNotEquals(getAttachSize(), (String)localObject1);
        bool2 = bool3;
        if (bool4)
        {
          setAttachSize((String)localObject1);
          bool2 = true;
        }
      }
      bool1 = bool2;
      localObject1 = (String)paramJSONObject.get("uploadPath");
      bool3 = bool2;
      if (localObject1 != null)
      {
        bool1 = bool2;
        bool4 = isNullorBlankorNotEquals(getUploadDataPath(), (String)localObject1);
        bool3 = bool2;
        if (bool4)
        {
          setUploadDataPath((String)localObject1);
          bool3 = true;
        }
      }
      bool1 = bool3;
      localObject1 = paramJSONObject.getJSONObject("attach");
      bool2 = bool3;
      if (localObject1 != null)
      {
        bool1 = bool3;
        localObject2 = getAttach();
        if (localObject2 != null) {
          break label1822;
        }
        setAttach(Attach.fromDictionary((JSONObject)localObject1, new Attach()));
        bool2 = true;
      }
      bool1 = bool2;
      localObject2 = paramJSONObject.getJSONObject("bigAttach");
      bool3 = bool2;
      if (localObject2 != null)
      {
        bool1 = bool2;
        Object localObject3 = getAttach();
        if (localObject3 != null) {
          break label1843;
        }
        setAttach(MailBigAttach.fromDictionary((JSONObject)localObject2, new MailBigAttach()));
        bool3 = true;
      }
      bool1 = bool3;
      if (paramJSONObject.get("lowSize") == null)
      {
        bool1 = bool3;
        d = getLowSize();
        if (-1.0D == d) {
          break label1573;
        }
      }
      if (!(paramJSONObject.get("lowSize") instanceof BigDecimal)) {
        break label1864;
      }
      d = ((BigDecimal)paramJSONObject.get("lowSize")).doubleValue();
    }
    catch (Exception paramJSONObject)
    {
      bool1 = true;
      break label1955;
      bool1 = bool3;
      break label1798;
      d = -1.0D;
      break label1697;
      d = -1.0D;
      break label1631;
      d = -1.0D;
      break label1565;
    }
    setLowSize(d);
    bool3 = true;
    label1573:
    bool1 = bool3;
    if (paramJSONObject.get("middlesize") == null)
    {
      bool1 = bool3;
      d = getMiddleSize();
      if (-1.0D == d) {}
    }
    else
    {
      if (!(paramJSONObject.get("middlesize") instanceof BigDecimal)) {
        break label1894;
      }
      d = ((BigDecimal)paramJSONObject.get("middlesize")).doubleValue();
      label1631:
      setMiddleSize(d);
      bool3 = true;
    }
    bool1 = bool3;
    if (paramJSONObject.get("highSize") == null)
    {
      bool1 = bool3;
      d = getHighSize();
      if (-1.0D == d) {}
    }
    else
    {
      if (!(paramJSONObject.get("highSize") instanceof BigDecimal)) {
        break label1924;
      }
    }
    for (d = ((BigDecimal)paramJSONObject.get("highSize")).doubleValue();; d = ((Double)paramJSONObject.get("highSize")).doubleValue())
    {
      label1697:
      setHighSize(d);
      bool3 = true;
      bool1 = bool3;
      if (paramJSONObject.get("realSize") == null)
      {
        bool1 = bool3;
        l1 = getRealSize();
        if (-1L == l1) {}
      }
      else
      {
        setRealSize(paramJSONObject.getLong("realSize").longValue());
        bool3 = true;
      }
      bool1 = bool3;
      if (paramJSONObject.get("orient") == null)
      {
        bool1 = bool3;
        i = this.orientationAngel;
        if (i == 0) {
          break label1979;
        }
      }
      setOrientationAngel(paramJSONObject.getIntValue("orient"));
      bool1 = true;
      try
      {
        label1798:
        if (paramJSONObject.get("fid") != null) {
          setFid(paramJSONObject.getString("fid"));
        }
        return bool1;
      }
      catch (Exception paramJSONObject)
      {
        label1822:
        break label1955;
      }
      bool1 = bool3;
      bool2 = ((Attach)getAttach()).parseWithDictionary((JSONObject)localObject1);
      break;
      label1843:
      bool1 = bool2;
      bool3 = ((MailBigAttach)getAttach()).parseWithDictionary((JSONObject)localObject1);
      break label1507;
      label1864:
      if (!(paramJSONObject.get("lowSize") instanceof Double)) {
        break label2000;
      }
      d = ((Double)paramJSONObject.get("lowSize")).doubleValue();
      break label1565;
      label1894:
      if (!(paramJSONObject.get("middlesize") instanceof Double)) {
        break label1993;
      }
      d = ((Double)paramJSONObject.get("middlesize")).doubleValue();
      break label1631;
      label1924:
      if (!(paramJSONObject.get("highSize") instanceof Double)) {
        break label1986;
      }
    }
  }
  
  public void setAbsAttachPath(String paramString)
  {
    this.absAttachPath = paramString;
  }
  
  public void setAttach(Object paramObject)
  {
    this.attach = paramObject;
  }
  
  public void setAttachName(String paramString)
  {
    this.attachName = paramString;
  }
  
  public void setAttachPath(String paramString)
  {
    this.attachPath = paramString;
  }
  
  public void setAttachSize(String paramString)
  {
    this.attachSize = paramString;
  }
  
  public void setBigAttach(boolean paramBoolean)
  {
    this.isBigAttach = paramBoolean;
  }
  
  public void setCanCopyToSandBox(boolean paramBoolean)
  {
    this.canCopyToSandBox = paramBoolean;
  }
  
  public void setEditAttach(boolean paramBoolean)
  {
    this.isEditAttach = paramBoolean;
  }
  
  public void setFid(String paramString)
  {
    this.fid = paramString;
  }
  
  public void setFileType(AttachType paramAttachType)
  {
    this.fileType = paramAttachType;
  }
  
  public void setForwardAttach(boolean paramBoolean)
  {
    this.isForwardAttach = paramBoolean;
  }
  
  public void setFromOtherApp(boolean paramBoolean)
  {
    this.isFromOtherApp = paramBoolean;
  }
  
  public void setHashId(long paramLong)
  {
    this.hashId = paramLong;
  }
  
  public void setHighSize(double paramDouble)
  {
    this.highSize = paramDouble;
  }
  
  public void setInBodyImage(boolean paramBoolean)
  {
    this.isInBodyImage = paramBoolean;
  }
  
  public void setIsFromFav(boolean paramBoolean)
  {
    this.isFromFav = paramBoolean;
  }
  
  public void setIsNewSameName(boolean paramBoolean)
  {
    this.isNewSameName = paramBoolean;
  }
  
  public void setIsShow(boolean paramBoolean)
  {
    this.isShow = paramBoolean;
  }
  
  public void setLoadError(boolean paramBoolean)
  {
    this.loadError = paramBoolean;
  }
  
  public void setLocalAttach(boolean paramBoolean)
  {
    this.isLocalAttach = paramBoolean;
  }
  
  public void setLowSize(double paramDouble)
  {
    this.lowSize = paramDouble;
  }
  
  public void setMiddleSize(double paramDouble)
  {
    this.middleSize = paramDouble;
  }
  
  public void setNeedCopy(boolean paramBoolean)
  {
    this.needCopy = paramBoolean;
  }
  
  public void setNeedFtnUpload(boolean paramBoolean)
  {
    this.isNeedFtnUpload = paramBoolean;
  }
  
  public void setNewAdded(boolean paramBoolean)
  {
    this.isNewAdded = paramBoolean;
  }
  
  public void setOriAbsAttachPath(String paramString)
  {
    this.oriAbsAttachPath = paramString;
  }
  
  public void setOrientationAngel(int paramInt)
  {
    this.orientationAngel = paramInt;
  }
  
  public void setPreviewPath(String paramString)
  {
    this.attachPath = paramString;
  }
  
  public void setProcessed(boolean paramBoolean)
  {
    this.isProcessed = paramBoolean;
  }
  
  public void setProtocolAttach(boolean paramBoolean)
  {
    this.isProtocolAttach = paramBoolean;
  }
  
  public void setRealSize(long paramLong)
  {
    this.realSize = paramLong;
  }
  
  public void setRemoved(boolean paramBoolean)
  {
    this.isRemoved = paramBoolean;
  }
  
  public void setRename(boolean paramBoolean)
  {
    this.isRename = paramBoolean;
  }
  
  public void setShareToContent(boolean paramBoolean)
  {
    this.isShareToContent = paramBoolean;
  }
  
  public void setThumbnailData(Object paramObject)
  {
    this.thumbnailData = paramObject;
  }
  
  public void setThumbnailPath(String paramString)
  {
    this.thumbnailPath = paramString;
  }
  
  public void setTraceLog(boolean paramBoolean)
  {
    this.isTraceLog = paramBoolean;
  }
  
  public void setUploadDataPath(String paramString)
  {
    this.uploadDataPath = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("\"class\":\"AttachInfo\",");
    localStringBuilder.append("\"hashId\":\"").append(getHashId()).append("\",");
    localStringBuilder.append("\"isProtocolAttach\":").append(isProtocolAttach()).append(",");
    if (getFileType() != null) {
      localStringBuilder.append("\"filetype\":\"").append(getFileType().ordinal()).append("\",");
    }
    Object localObject;
    if (getAttach() != null)
    {
      localObject = getAttach();
      if (!(localObject instanceof MailBigAttach)) {
        break label887;
      }
      localStringBuilder.append("\"bigAttach\":").append(localObject.toString()).append(",");
    }
    for (;;)
    {
      localStringBuilder.append("\"isBigAttach\":").append(isBigAttach()).append(",");
      localStringBuilder.append("\"isEditAttach\":").append(isEditAttach()).append(",");
      localStringBuilder.append("\"isForwardAttach\":").append(isForwardAttach()).append(",");
      localStringBuilder.append("\"isFromFav\":").append(isFromFav()).append(",");
      localStringBuilder.append("\"isTraceLog\":").append(isTraceLog()).append(",");
      localStringBuilder.append("\"isFromOtherApp\":").append(isFromOtherApp()).append(",");
      localStringBuilder.append("\"isLocalAttach\":").append(isLocalAttach()).append(",");
      localStringBuilder.append("\"isInBodyImage\":").append(isInBodyImage()).append(",");
      localStringBuilder.append("\"isRemoved\":").append(isRemoved()).append(",");
      localStringBuilder.append("\"isLoadError\":").append(isLoadError()).append(",");
      localStringBuilder.append("\"needCopy\":").append(isNeedCopy()).append(",");
      localStringBuilder.append("\"isNeedFtnUpload\":").append(isNeedFtnUpload()).append(",");
      localStringBuilder.append("\"isRename\":").append(isRename()).append(",");
      if (getAttachName() != null)
      {
        localObject = getAttachName().replaceAll("\\\\", "\\\\\\\\");
        localStringBuilder.append("\"attachName\":\"").append(((String)localObject).replaceAll("\"", "\\\\\"")).append("\",");
      }
      if (getAttachPath() != null)
      {
        localObject = getAttachPath().replaceAll("\\\\", "\\\\\\\\");
        localStringBuilder.append("\"attachPath\":\"").append(((String)localObject).replaceAll("\"", "\\\\\"")).append("\",");
      }
      if (getAbsAttachPath() != null)
      {
        localObject = getAbsAttachPath().replaceAll("\\\\", "\\\\\\\\");
        localStringBuilder.append("\"absAttachPath\":\"").append(((String)localObject).replaceAll("\"", "\\\\\"")).append("\",");
      }
      if (getOriAbsAttachPath() != null)
      {
        localObject = getOriAbsAttachPath().replaceAll("\\\\", "\\\\\\\\");
        localStringBuilder.append("\"oriAbsAttachPath\":\"").append(((String)localObject).replaceAll("\"", "\\\\\"")).append("\",");
      }
      if (getThumbnailPath() != null)
      {
        localObject = getThumbnailPath().replaceAll("\\\\", "\\\\\\\\");
        localStringBuilder.append("\"thumPath\":\"").append(((String)localObject).replaceAll("\"", "\\\\\"")).append("\",");
      }
      if (getAttachSize() != null) {
        localStringBuilder.append("\"attachSz\":\"").append(getAttachSize()).append("\",");
      }
      if (getUploadDataPath() != null)
      {
        localObject = getUploadDataPath().replaceAll("\\\\", "\\\\\\\\");
        localStringBuilder.append("\"uploadPath\":\"").append(((String)localObject).replaceAll("\"", "\\\\\"")).append("\",");
      }
      localStringBuilder.append("\"lowSize\":").append(getLowSize()).append(",");
      localStringBuilder.append("\"middlesize\":").append(getMiddleSize()).append(",");
      localStringBuilder.append("\"highSize\":").append(getHighSize()).append(",");
      localStringBuilder.append("\"realSize\":").append(getRealSize()).append(",");
      localStringBuilder.append("\"orient\":").append(getOrientationAngel()).append(",");
      if (getFid() != null) {
        localStringBuilder.append("\"fid\":\"").append(getFid()).append("\",");
      }
      localStringBuilder.append("\"isShow\":").append(getIsShow());
      localStringBuilder.append("}");
      return localStringBuilder.toString();
      label887:
      if ((localObject instanceof Attach)) {
        localStringBuilder.append("\"attach\":").append(localObject.toString()).append(",");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.AttachInfo
 * JD-Core Version:    0.7.0.1
 */