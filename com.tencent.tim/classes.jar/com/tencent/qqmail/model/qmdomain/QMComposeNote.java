package com.tencent.qqmail.model.qmdomain;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.loader.MailContentLoader;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.ImageScaleDegree;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeState;
import com.tencent.qqmail.note.NoteUtil;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.trd.guava.Maps;
import com.tencent.qqmail.utilities.QMMath;
import com.tencent.qqmail.utilities.common.CommUtils;
import com.tencent.qqmail.utilities.common.QMMailContentParser;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMFileEntity;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

public class QMComposeNote
  extends QMNNote
{
  public static final String NOTE_KEY_PREFIX = "composenote_";
  public List<Object> addAttachInfoList;
  public List<Object> bigAttachList;
  public String composeCacheFilePath;
  public String composeKey;
  public Integer contentLength;
  public float imageScale;
  public Integer retryCount;
  public ComposeMailUI.QMComposeState sendState;
  
  public QMComposeNote() {}
  
  public QMComposeNote(QMNNote paramQMNNote)
  {
    this.information = paramQMNNote.information;
    this.status = paramQMNNote.status;
    this.content = paramQMNNote.content;
    this.attachList = paramQMNNote.attachList;
    this.read = paramQMNNote.read;
    this.edit = paramQMNNote.edit;
    this.offline = paramQMNNote.offline;
  }
  
  public static QMComposeNote NoteWithMailUI(ComposeMailUI paramComposeMailUI)
  {
    if (paramComposeMailUI == null) {
      return null;
    }
    QMComposeNote localQMComposeNote = new QMComposeNote();
    localQMComposeNote.composeKey = paramComposeMailUI.getComposeId();
    localQMComposeNote.composeCacheFilePath = paramComposeMailUI.getComposeCacheFilePath();
    Object localObject = new ArrayList();
    int j;
    int i;
    if (paramComposeMailUI.getAddAttachInfoList() != null)
    {
      j = paramComposeMailUI.getAddAttachInfoList().size();
      i = 0;
      while (i < j)
      {
        ((ArrayList)localObject).add(paramComposeMailUI.getAddAttachInfoList().get(i));
        i += 1;
      }
    }
    localQMComposeNote.addAttachInfoList = ((List)localObject);
    localObject = paramComposeMailUI.getInformation();
    QMNoteAttachList localQMNoteAttachList = new QMNoteAttachList();
    ArrayList localArrayList = new ArrayList();
    if (((MailInformation)localObject).getAttachList() != null)
    {
      j = ((MailInformation)localObject).getAttachList().size();
      i = 0;
      while (i < j)
      {
        localArrayList.add((Attach)((MailInformation)localObject).getAttachList().get(i));
        i += 1;
      }
    }
    localQMNoteAttachList.attachListInfo = localArrayList;
    localQMComposeNote.attachList = localQMNoteAttachList;
    localQMComposeNote.bigAttachList = ((MailInformation)localObject).getBigAttachList();
    localQMComposeNote.retryCount = Integer.valueOf(paramComposeMailUI.getRetryCount());
    localQMComposeNote.information.subject = ((MailInformation)localObject).getSubject();
    localQMComposeNote.content = paramComposeMailUI.getContent().getBody();
    localQMComposeNote.contentLength = paramComposeMailUI.getContentLength();
    localQMComposeNote.information.subject = ((MailInformation)localObject).getSubject();
    localQMComposeNote.information.noteId = ((MailInformation)localObject).getRemoteId();
    localQMComposeNote.information.category.setCatalogId("1");
    if (paramComposeMailUI.noteCreateUTC < 10L)
    {
      localQMComposeNote.status.createUTC = (System.currentTimeMillis() / 1000L);
      if (paramComposeMailUI.noteUpdateUTC >= 10L) {
        break label361;
      }
    }
    label361:
    for (localQMComposeNote.status.updateUTC = (System.currentTimeMillis() / 1000L);; localQMComposeNote.status.updateUTC = paramComposeMailUI.noteUpdateUTC)
    {
      localQMComposeNote.sendState = paramComposeMailUI.getSendState();
      localQMComposeNote.status.status = paramComposeMailUI.noteStatus;
      localQMComposeNote.status.sequence = paramComposeMailUI.noteSequence;
      return localQMComposeNote;
      localQMComposeNote.status.createUTC = paramComposeMailUI.noteCreateUTC;
      break;
    }
  }
  
  public static ComposeMailUI generateMailFromNote(QMComposeNote paramQMComposeNote)
  {
    if (paramQMComposeNote == null) {
      return null;
    }
    ComposeMailUI localComposeMailUI = new ComposeMailUI();
    Object localObject = localComposeMailUI.getInformation();
    localComposeMailUI.setType(ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_NOTE);
    ((MailInformation)localObject).setAccountId(QMSettingManager.sharedInstance().getDefaultNoteAccountID());
    ((MailInformation)localObject).setSubject(paramQMComposeNote.information.subject);
    ((MailInformation)localObject).setAbstractContent(paramQMComposeNote.information.abs);
    ArrayList localArrayList = new ArrayList();
    int j;
    int i;
    if ((paramQMComposeNote.attachList != null) && (paramQMComposeNote.attachList.attachListInfo != null))
    {
      j = paramQMComposeNote.attachList.attachListInfo.size();
      i = 0;
      while (i < j)
      {
        localArrayList.add(paramQMComposeNote.attachList.attachListInfo.get(i));
        i += 1;
      }
    }
    ((MailInformation)localObject).setAttachList(localArrayList);
    localArrayList = new ArrayList();
    if (paramQMComposeNote.bigAttachList != null)
    {
      j = paramQMComposeNote.bigAttachList.size();
      i = 0;
      while (i < j)
      {
        localArrayList.add(paramQMComposeNote.bigAttachList.get(i));
        i += 1;
      }
    }
    ((MailInformation)localObject).setBigAttachList(localArrayList);
    ((MailInformation)localObject).setMessageId(paramQMComposeNote.information.noteId);
    localComposeMailUI.setComposeCacheFilePath(paramQMComposeNote.composeCacheFilePath);
    localObject = new ArrayList();
    if (paramQMComposeNote.addAttachInfoList != null)
    {
      j = paramQMComposeNote.addAttachInfoList.size();
      i = 0;
      while (i < j)
      {
        ((ArrayList)localObject).add((AttachInfo)paramQMComposeNote.addAttachInfoList.get(i));
        i += 1;
      }
    }
    localComposeMailUI.setAddAttachInfoList((ArrayList)localObject);
    if (paramQMComposeNote.information.noteId.startsWith("composemail_")) {
      localComposeMailUI.setComposeId(paramQMComposeNote.information.noteId);
    }
    localComposeMailUI.setComposeCacheFilePath(paramQMComposeNote.composeCacheFilePath);
    localComposeMailUI.getContent().setBody(paramQMComposeNote.content);
    localComposeMailUI.noteStatus = paramQMComposeNote.status.status;
    localComposeMailUI.noteSequence = (paramQMComposeNote.status.sequence);
    if (paramQMComposeNote.status.createUTC > 10.0D)
    {
      localComposeMailUI.noteCreateUTC = (paramQMComposeNote.status.createUTC);
      if (paramQMComposeNote.status.updateUTC <= 10.0D) {
        break label422;
      }
    }
    label422:
    for (localComposeMailUI.noteUpdateUTC = (paramQMComposeNote.status.updateUTC);; localComposeMailUI.noteUpdateUTC = (System.currentTimeMillis() / 1000L))
    {
      return localComposeMailUI;
      localComposeMailUI.noteCreateUTC = (System.currentTimeMillis() / 1000L);
      break;
    }
  }
  
  public static String getMailIdWithComposeId(String paramString)
  {
    String str = paramString;
    if (paramString.indexOf("composenote_") != -1)
    {
      String[] arrayOfString = paramString.split("#");
      str = paramString;
      if (arrayOfString.length > 1) {
        str = arrayOfString[1];
      }
    }
    return str;
  }
  
  public byte[] ConvertToByte()
  {
    new ObjectSerializable();
    try
    {
      byte[] arrayOfByte = ObjectSerializable.toByte(this);
      return arrayOfByte;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public void checkCompleteAndReplaceLocalFile(List<String> paramList, HashMap<String, String> paramHashMap, Runnable paramRunnable)
  {
    if (paramHashMap.size() == paramList.size()) {
      paramRunnable.run();
    }
  }
  
  public void compressAllLocalFile()
  {
    NoteUtil.compressNoteAttach(this);
  }
  
  public void compressAndReplaceAllLocalImages()
  {
    Object localObject = QMMailContentParser.findAllLocalImages(this.content);
    String str1 = this.composeCacheFilePath + File.separator + CommUtils.COMPOSE_CACHE + File.separator;
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str3 = (String)((Iterator)localObject).next();
      String str2 = NoteUtil.addProtocal(NoteUtil.compressLocalFile(NoteUtil.removeProtocol(str3), str1, this.imageScale));
      if (!StringUtils.equals(str3, str2)) {
        this.content = this.content.replaceAll(str3, str2);
      }
      str3 = str2.replaceFirst("^.*/", "");
      this.content = this.content.replace(str2, str2 + "\" qmtitle=\"" + str3);
    }
  }
  
  public void deleteComposeCache()
  {
    FileUtil.delFolder(this.composeCacheFilePath);
  }
  
  public void downloadAllCids(long paramLong, Runnable paramRunnable)
  {
    HashMap localHashMap = Maps.newHashMap();
    Object localObject = QMMailManager.sharedInstance().readMail(paramLong, true);
    List localList = QMMailContentParser.findAllCidsAndViewfile(this.content);
    if ((localList != null) && (localList.size() > 0) && (localObject != null))
    {
      paramRunnable = new QMComposeNote.1(this, localHashMap, localList, paramRunnable);
      localObject = new MailContentLoader((Mail)localObject, localList);
      ((MailContentLoader)localObject).setCallback(paramRunnable);
      ((MailContentLoader)localObject).start();
      return;
    }
    paramRunnable.run();
  }
  
  public String getComposeMailKey()
  {
    if ((this.composeKey != null) && (!this.composeKey.equals(""))) {
      return this.composeKey;
    }
    String str3 = this.information.noteId;
    if ((str3 != null) && (str3.length() != 0) && (str3.indexOf("composenote_") != -1))
    {
      this.composeKey = str3;
      return str3;
    }
    String str2 = new DecimalFormat("#").format(System.currentTimeMillis());
    String str1 = str2;
    if (str3 != null)
    {
      str1 = str2;
      if (str3.length() > 0) {
        str1 = String.format("%s#%s", new Object[] { str2, str3 });
      }
    }
    str1 = String.format("%s%s", new Object[] { "composenote_", str1 });
    this.composeKey = str1;
    return str1;
  }
  
  public ComposeMailUI.ImageScaleDegree getCompressDegree()
  {
    return ComposeMailUI.ImageScaleDegree.ImageScaleDegree_Undecide;
  }
  
  public List<QMFileEntity> getContentEntities()
  {
    ArrayList localArrayList = Lists.newArrayList();
    Iterator localIterator = QMMailContentParser.findAllEntities(this.content).iterator();
    while (localIterator.hasNext())
    {
      String str = NoteUtil.removeProtocol((String)localIterator.next());
      File localFile = new File(str);
      if (localFile.exists())
      {
        localArrayList.add(new QMFileEntity(localFile, "application/octet-stream", localFile.getName()));
        QMLog.log(4, "alger", "localentity:" + localFile.getAbsolutePath() + " name:" + localFile.getName());
      }
      else
      {
        QMLog.log(6, "alger", "ignore local files :" + str);
      }
    }
    return localArrayList;
  }
  
  public String getId()
  {
    return this.information.noteId;
  }
  
  public void modifyWithMailUI(ComposeMailUI paramComposeMailUI)
  {
    if (paramComposeMailUI == null) {
      return;
    }
    this.composeKey = this.information.noteId;
    this.contentLength = paramComposeMailUI.getContentLength();
    this.composeCacheFilePath = paramComposeMailUI.getComposeCacheFilePath();
    ArrayList localArrayList = new ArrayList();
    int j;
    int i;
    if (paramComposeMailUI.getAddAttachInfoList() != null)
    {
      j = paramComposeMailUI.getAddAttachInfoList().size();
      i = 0;
      while (i < j)
      {
        localArrayList.add(paramComposeMailUI.getAddAttachInfoList().get(i));
        i += 1;
      }
    }
    this.addAttachInfoList = localArrayList;
    localArrayList = new ArrayList();
    MailInformation localMailInformation = paramComposeMailUI.getInformation();
    if (localMailInformation.getAttachList() != null)
    {
      j = localMailInformation.getAttachList().size();
      i = 0;
      while (i < j)
      {
        localArrayList.add((Attach)localMailInformation.getAttachList().get(i));
        i += 1;
      }
    }
    this.attachList.attachListInfo = localArrayList;
    this.bigAttachList = localMailInformation.getBigAttachList();
    this.retryCount = Integer.valueOf(paramComposeMailUI.getRetryCount());
    this.information.subject = localMailInformation.getSubject();
    this.content = paramComposeMailUI.getContent().getBody();
    this.contentLength = paramComposeMailUI.getContentLength();
    this.status.updateUTC = (System.currentTimeMillis() / 1000L);
    this.information.abs = localMailInformation.getAbstractContent();
    this.sendState = paramComposeMailUI.getSendState();
  }
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    boolean bool1 = false;
    if (StringExtention.containInheritKey(paramJSONObject, new String[] { "prototype" })) {
      bool1 = super.parseWithDictionary(paramJSONObject.getJSONObject("prototype"));
    }
    boolean bool2 = bool1;
    ArrayList localArrayList;
    if (paramJSONObject != null)
    {
      bool2 = bool1;
      if (paramJSONObject.get("addAttachInfoList") != null)
      {
        bool2 = bool1;
        if (paramJSONObject.get("addAttachInfoList") != null)
        {
          bool2 = bool1;
          if (((List)paramJSONObject.get("addAttachInfoList")).size() > 0)
          {
            Object localObject = paramJSONObject.getJSONArray("addAttachInfoList");
            localArrayList = new ArrayList();
            localObject = ((JSONArray)localObject).iterator();
            while (((Iterator)localObject).hasNext()) {
              localArrayList.add((AttachInfo)AttachInfo.fromDictionary((JSONObject)((Iterator)localObject).next(), new AttachInfo()));
            }
            if ((this.addAttachInfoList != null) && (this.addAttachInfoList.size() == localArrayList.size())) {
              break label212;
            }
            bool1 = true;
          }
        }
      }
    }
    label212:
    for (;;)
    {
      this.addAttachInfoList = localArrayList;
      bool2 = bool1;
      if ((paramJSONObject != null) && (paramJSONObject.get("composeCacheFilePath") != null)) {
        this.composeCacheFilePath = ((String)paramJSONObject.get("composeCacheFilePath"));
      }
      return bool2;
    }
  }
  
  public void replaceAsLocalFile(HashMap<String, String> paramHashMap)
  {
    Object localObject = paramHashMap;
    if (paramHashMap == null) {
      localObject = Maps.newHashMap();
    }
    paramHashMap = ((HashMap)localObject).keySet().iterator();
    while (paramHashMap.hasNext())
    {
      String str1 = (String)paramHashMap.next();
      String str2 = (String)((HashMap)localObject).get(str1);
      if (!StringUtils.isEmpty(str2)) {
        this.content.replace(str1, str2);
      }
    }
  }
  
  public void replaceContentCid(String paramString1, String paramString2)
  {
    this.content = this.content.replace(paramString1, paramString2);
  }
  
  public String saveCidFileToLocal(String paramString1, String paramString2)
  {
    String str = this.composeCacheFilePath;
    paramString1 = new File(paramString1);
    str = FileUtil.createPhotoDirAtRootPath(str);
    paramString2 = new File(str + String.valueOf(QMMath.hashInt(paramString2)).replace("-", "") + ".jpg");
    FileUtil.copyFile(paramString1, paramString2);
    return paramString2.getAbsolutePath();
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("{\"prototype\":" + super.toString());
    if ((this.addAttachInfoList != null) && (this.addAttachInfoList.size() > 0))
    {
      localStringBuffer.append(",\"addAttachInfoList\":[");
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.addAttachInfoList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if ((localObject instanceof AttachInfo)) {
          localArrayList.add(localObject.toString());
        }
      }
      localStringBuffer.append(StringExtention.join(localArrayList, ","));
      localStringBuffer.append("]");
    }
    if (this.composeCacheFilePath != null) {
      localStringBuffer.append(",\"composeCacheFilePath\":\"" + this.composeCacheFilePath + "\"");
    }
    localStringBuffer.append("}");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.QMComposeNote
 * JD-Core Version:    0.7.0.1
 */