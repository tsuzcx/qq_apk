package com.tencent.qqmail.model.qmdomain;

import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachProtocol;
import com.tencent.qqmail.attachment.model.AttachType;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.protocol.ItemBodyStructureHelper.MailItemBodyStructureInfo;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class MailInformation
  extends QMDomain
{
  public static final Date EMPTY_DATE = new Date();
  private static final String TAG = "MailInformation";
  private static final long serialVersionUID = -6955751666214625070L;
  private String abstractContent;
  private int accountId = -1;
  private MailAttachList attachList_ = new MailAttachList();
  private ContactBccList bccList_ = new ContactBccList();
  private MailBigAttachList bigAttachList_ = new MailBigAttachList();
  private ItemBodyStructureHelper.MailItemBodyStructureInfo[] bodyStructureInfos;
  private ContactCcList ccList_ = new ContactCcList();
  private String colId;
  private int convContactHash = 0;
  private int convCount = -1;
  private int convHash = 0;
  private int convReferenceHash = 0;
  private int convType;
  private int convUrCnt = -1;
  private Date date;
  private MailEditAttachList editAttachList_ = new MailEditAttachList();
  private int folderId;
  private MailContact from;
  private MailGroupContact groupContact;
  private String groupId;
  private String groupMailId;
  private long id;
  private Date lastOptTime;
  private int localCount = -1;
  private String messageId;
  private String pId;
  private int qqmailAdType = 0;
  private String reSubject;
  private String references;
  private String remoteId;
  private MailContact reply;
  private ContactRlyAllCCList replyAllCCList_ = new ContactRlyAllCCList();
  private ContactRlyAllList replyAllList_ = new ContactRlyAllList();
  private MailContact sendContact;
  private long sendUtc;
  private MailContact sender;
  private ContactSenderList senderList_ = new ContactSenderList();
  private String separateCopy;
  private String sequence;
  private double size;
  private String subject;
  private String svrKey;
  private MailTagList tagList_ = new MailTagList();
  private String tid;
  private ContactToList toList_ = new ContactToList();
  private Date utc;
  
  private boolean isAttachImage(String paramString)
  {
    return AttachType.valueOf(QMAttachUtils.attachFileType(FileUtil.getFileNameSuffix(paramString))) == AttachType.IMAGE;
  }
  
  private boolean isAttachInline(Attach paramAttach)
  {
    return (paramAttach.getProtocol().getType() != null) && (paramAttach.getProtocol().getType().equals("inline"));
  }
  
  private boolean isGroup()
  {
    return (this.messageId != null) && (this.messageId.startsWith("@"));
  }
  
  public static long parseSendUTC(JSONObject paramJSONObject)
  {
    if (paramJSONObject.get("sendutc") == null) {
      return 0L;
    }
    return new Date(paramJSONObject.getLong("sendutc").longValue() * 1000L).getTime();
  }
  
  public static long parseUTC(JSONObject paramJSONObject)
  {
    if (paramJSONObject.get("UTC") == null) {
      return 0L;
    }
    return new Date(paramJSONObject.getLong("UTC").longValue() * 1000L).getTime();
  }
  
  public Object clone()
  {
    MailInformation localMailInformation = new MailInformation();
    localMailInformation.setAccountId(getAccountId());
    localMailInformation.setAbstractContent(getAbstractContent());
    localMailInformation.setAttachList(getAttachList());
    localMailInformation.setBccList(getBccList());
    localMailInformation.setBigAttachList(getBigAttachList());
    localMailInformation.setBodyStructureInfos(getBodyStructureInfos());
    localMailInformation.setCcList(getCcList());
    localMailInformation.setColId(getColId());
    localMailInformation.setConvContactHash(getConvContactHash());
    localMailInformation.setConvCount(getConvCount());
    localMailInformation.setConvHash(getConvHash());
    localMailInformation.setConvReferencHash(getConvReferenceHash());
    localMailInformation.setConvType(getConvType());
    localMailInformation.setConvUrCnt(getConvUrCnt());
    localMailInformation.setDate(getDate());
    localMailInformation.setEditAttachList(getEditAttachList());
    localMailInformation.setFolderId(getFolderId());
    localMailInformation.setFrom(getFrom());
    localMailInformation.setSender(getSender());
    localMailInformation.setGroupContact(getGroupContact());
    localMailInformation.setGroupId(getGroupId());
    localMailInformation.setGroupMailId(getGroupMailId());
    localMailInformation.setId(getId());
    localMailInformation.setLastOptTime(getLastOptTime());
    localMailInformation.setLocalCount(getLocalCount());
    localMailInformation.setMessageId(getMessageId());
    localMailInformation.setQQmailAdType(getQQmailAdType());
    localMailInformation.setQQTid(getQQTid());
    localMailInformation.setReferences(getReferences());
    localMailInformation.setRemoteId(getRemoteId());
    localMailInformation.setReply(getReply());
    localMailInformation.setReplyAllCCList(getReplyAllCCList());
    localMailInformation.setReplyAllList(getReplyAllList());
    localMailInformation.setReSubject(getReSubject());
    localMailInformation.setSendContact(getSendContact());
    localMailInformation.setSenderList(getSenderList());
    localMailInformation.setSendUtc(getSendUtc());
    localMailInformation.setSeparateCopy(getSeparateCopy());
    localMailInformation.setSequence(getSequence());
    localMailInformation.setSize(getSize());
    localMailInformation.setSvrKey(getSvrKey());
    localMailInformation.setSize(getSize());
    localMailInformation.setToList(getToList());
    localMailInformation.setTagList(getTagList());
    localMailInformation.setUtc(getUtc());
    return localMailInformation;
  }
  
  public String getAbstractContent()
  {
    return this.abstractContent;
  }
  
  public int getAccountId()
  {
    return this.accountId;
  }
  
  public ArrayList<Object> getAttachInlineImgList()
  {
    if ((this.attachList_ == null) || (this.attachList_.list == null)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.attachList_.list.iterator();
    while (localIterator.hasNext())
    {
      Attach localAttach = (Attach)localIterator.next();
      if (isAttachInline(localAttach)) {
        localArrayList.add(localAttach);
      }
    }
    return localArrayList;
  }
  
  public ArrayList<Object> getAttachList()
  {
    return this.attachList_.list;
  }
  
  public ArrayList<Object> getAttachListNoInlineImg()
  {
    if ((this.attachList_ == null) || (this.attachList_.list == null)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.attachList_.list.iterator();
    while (localIterator.hasNext())
    {
      Attach localAttach = (Attach)localIterator.next();
      String str = localAttach.getProtocol().getType();
      if (((str == null) || (!str.equals("inline"))) && (!QMAttachUtils.isAttachVirtual(localAttach))) {
        localArrayList.add(localAttach);
      }
    }
    return localArrayList;
  }
  
  public ArrayList<Object> getBccList()
  {
    return this.bccList_.list;
  }
  
  public ArrayList<Object> getBigAttachList()
  {
    return this.bigAttachList_.list;
  }
  
  public ItemBodyStructureHelper.MailItemBodyStructureInfo[] getBodyStructureInfos()
  {
    return this.bodyStructureInfos;
  }
  
  public ArrayList<Object> getCcList()
  {
    return this.ccList_.list;
  }
  
  public String getColId()
  {
    return this.colId;
  }
  
  public int getConvContactHash()
  {
    return this.convContactHash;
  }
  
  public int getConvCount()
  {
    return this.convCount;
  }
  
  public int getConvHash()
  {
    return this.convHash;
  }
  
  public int getConvReferenceHash()
  {
    return this.convReferenceHash;
  }
  
  public int getConvType()
  {
    return this.convType;
  }
  
  public int getConvUrCnt()
  {
    return this.convUrCnt;
  }
  
  @NonNull
  public Date getDate()
  {
    if (this.date == null)
    {
      QMLog.log(5, "MailInformation", "date is null!! Nonnull is expected!!");
      this.date = EMPTY_DATE;
    }
    return this.date;
  }
  
  public ArrayList<Object> getEditAttachList()
  {
    return this.editAttachList_.list;
  }
  
  public int getFolderId()
  {
    return this.folderId;
  }
  
  public MailContact getFrom()
  {
    return this.from;
  }
  
  public MailGroupContact getGroupContact()
  {
    return this.groupContact;
  }
  
  public String getGroupId()
  {
    return this.groupId;
  }
  
  public String getGroupMailId()
  {
    return this.groupMailId;
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public ArrayList<Object> getImageAttachListNoInlineImg()
  {
    if ((this.attachList_ == null) || (this.attachList_.list == null)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.attachList_.list.iterator();
    while (localIterator.hasNext())
    {
      Attach localAttach = (Attach)localIterator.next();
      if ((!isAttachInline(localAttach)) && (isAttachImage(localAttach.getName())) && (!FileUtil.isFileTypeTiff(localAttach.getName()))) {
        localArrayList.add(localAttach);
      }
    }
    return localArrayList;
  }
  
  public ArrayList<Object> getImageBigAttachList()
  {
    if ((this.bigAttachList_ == null) || (this.bigAttachList_.list == null)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.bigAttachList_.list.iterator();
    while (localIterator.hasNext())
    {
      MailBigAttach localMailBigAttach = (MailBigAttach)localIterator.next();
      if ((isAttachImage(localMailBigAttach.getName())) && (!FileUtil.isFileTypeTiff(localMailBigAttach.getName()))) {
        localArrayList.add(localMailBigAttach);
      }
    }
    return localArrayList;
  }
  
  public Date getLastOptTime()
  {
    return this.lastOptTime;
  }
  
  public int getLocalCount()
  {
    return this.localCount;
  }
  
  public String getMessageId()
  {
    return this.messageId;
  }
  
  public String getQQTid()
  {
    return this.tid;
  }
  
  public int getQQmailAdType()
  {
    return this.qqmailAdType;
  }
  
  public String getReSubject()
  {
    return this.reSubject;
  }
  
  public ArrayList<MailContact> getReceiverList()
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    int i;
    MailContact localMailContact;
    if (this.toList_.list != null)
    {
      i = 0;
      while (i < this.toList_.list.size())
      {
        localMailContact = (MailContact)this.toList_.list.get(i);
        localMailContact.setMailContactType("to");
        localArrayList.add(localMailContact);
        i += 1;
      }
    }
    if (this.ccList_.list != null)
    {
      i = 0;
      while (i < this.ccList_.list.size())
      {
        localMailContact = (MailContact)this.ccList_.list.get(i);
        localMailContact.setMailContactType("cc");
        localArrayList.add(localMailContact);
        i += 1;
      }
    }
    if (this.bccList_.list != null)
    {
      i = 0;
      while (i < this.bccList_.list.size())
      {
        localMailContact = (MailContact)this.bccList_.list.get(i);
        localMailContact.setMailContactType("bcc");
        localArrayList.add(localMailContact);
        i += 1;
      }
    }
    if (this.senderList_.list != null)
    {
      i = j;
      while (i < this.senderList_.list.size())
      {
        localMailContact = (MailContact)this.senderList_.list.get(i);
        localMailContact.setMailContactType("sender_list");
        localArrayList.add(localMailContact);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public String getReferences()
  {
    return this.references;
  }
  
  public String getRemoteId()
  {
    return this.remoteId;
  }
  
  public MailContact getReply()
  {
    return this.reply;
  }
  
  public ArrayList<Object> getReplyAllCCList()
  {
    return this.replyAllCCList_.list;
  }
  
  public ArrayList<Object> getReplyAllList()
  {
    return this.replyAllList_.list;
  }
  
  public MailContact getSendContact()
  {
    return this.sendContact;
  }
  
  public long getSendUtc()
  {
    return this.sendUtc;
  }
  
  public MailContact getSender()
  {
    return this.sender;
  }
  
  public ArrayList<Object> getSenderList()
  {
    return this.senderList_.list;
  }
  
  public String getSeparateCopy()
  {
    return this.separateCopy;
  }
  
  public String getSequence()
  {
    return this.sequence;
  }
  
  public double getSize()
  {
    return this.size;
  }
  
  public String getSubject()
  {
    return this.subject;
  }
  
  public String getSvrKey()
  {
    return this.svrKey;
  }
  
  public ArrayList<Object> getTagList()
  {
    return this.tagList_.list;
  }
  
  public ArrayList<MailContact> getToAndCCAndBCCList()
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    int i;
    MailContact localMailContact;
    if (this.toList_.list != null)
    {
      i = 0;
      while (i < this.toList_.list.size())
      {
        localMailContact = (MailContact)this.toList_.list.get(i);
        localMailContact.setMailContactType("to");
        localArrayList.add(localMailContact);
        i += 1;
      }
    }
    if (this.ccList_.list != null)
    {
      i = 0;
      while (i < this.ccList_.list.size())
      {
        localMailContact = (MailContact)this.ccList_.list.get(i);
        localMailContact.setMailContactType("cc");
        localArrayList.add(localMailContact);
        i += 1;
      }
    }
    if (this.bccList_.list != null)
    {
      i = j;
      while (i < this.bccList_.list.size())
      {
        localMailContact = (MailContact)this.bccList_.list.get(i);
        localMailContact.setMailContactType("bcc");
        localArrayList.add(localMailContact);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public ArrayList<Object> getToList()
  {
    return this.toList_.list;
  }
  
  @Deprecated
  public Date getUtc()
  {
    return this.utc;
  }
  
  public boolean isSeparateCopy()
  {
    return (this.separateCopy != null) && (this.separateCopy.equalsIgnoreCase("true"));
  }
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    return parseWithDictionary(paramJSONObject, true);
  }
  
  public boolean parseWithDictionary(JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (paramJSONObject == null) {
      return false;
    }
    Object localObject = (String)paramJSONObject.get("accountId");
    int i;
    if (localObject != null)
    {
      i = Integer.parseInt((String)localObject);
      if (getAccountId() != i) {
        setAccountId(i);
      }
    }
    label291:
    label1063:
    label1109:
    label1368:
    label1385:
    label1643:
    for (int j = 1;; j = 0)
    {
      localObject = (String)paramJSONObject.get("id");
      i = j;
      if (localObject != null) {
        if (getRemoteId() != null)
        {
          i = j;
          if (getRemoteId().equals(localObject)) {}
        }
        else
        {
          setRemoteId((String)localObject);
          i = 1;
        }
      }
      localObject = (String)paramJSONObject.get("fid");
      j = i;
      if (localObject != null)
      {
        j = i;
        if (!((String)localObject).equals(String.valueOf(getFolderId())))
        {
          setFolderId(Integer.parseInt((String)localObject));
          j = 1;
        }
      }
      localObject = (String)paramJSONObject.get("gmid");
      i = j;
      if (localObject != null) {
        if (getGroupMailId() != null)
        {
          i = j;
          if (getGroupMailId().equals(localObject)) {}
        }
        else
        {
          setGroupMailId((String)localObject);
          i = 1;
        }
      }
      localObject = (String)paramJSONObject.get("gid");
      j = i;
      if (localObject != null) {
        if (this.groupId != null)
        {
          j = i;
          if (this.groupId.equals(localObject)) {}
        }
        else
        {
          this.groupId = ((String)localObject);
          j = 1;
        }
      }
      localObject = paramJSONObject.getJSONObject("groupContact");
      i = j;
      if (localObject != null)
      {
        if (getGroupContact() == null)
        {
          setGroupContact((MailGroupContact)MailGroupContactList.fromDictionary((JSONObject)localObject, new MailGroupContact()));
          i = 1;
        }
      }
      else
      {
        localObject = (String)paramJSONObject.get("tid");
        j = i;
        if (localObject != null) {
          if (getQQTid() != null)
          {
            j = i;
            if (getQQTid().equals(localObject)) {}
          }
          else
          {
            setQQTid((String)localObject);
            j = 1;
          }
        }
        localObject = (String)paramJSONObject.get("colmail");
        if (localObject == null) {
          break label1519;
        }
        localObject = localObject.split("@")[0];
        if ((getColId() == null) || (!getColId().equals(localObject)))
        {
          setColId((String)localObject);
          j = 1;
        }
        localObject = (String)paramJSONObject.get("seq");
        i = j;
        if (localObject != null) {
          if (getSequence() != null)
          {
            i = j;
            if (getSequence().equals(localObject)) {}
          }
          else
          {
            setSequence((String)localObject);
            i = 1;
          }
        }
        j = i;
        if (paramBoolean)
        {
          localObject = (String)paramJSONObject.get("re");
          j = i;
          if (localObject != null) {
            if (getReSubject() != null)
            {
              j = i;
              if (getReSubject().equals(localObject)) {}
            }
            else
            {
              setReSubject((String)localObject);
              j = 1;
            }
          }
          localObject = (String)paramJSONObject.get("subj");
          i = j;
          if (localObject != null) {
            if (getSubject() != null)
            {
              i = j;
              if (getSubject().equals(localObject)) {}
            }
            else
            {
              setSubject((String)localObject);
              i = 1;
            }
          }
          localObject = (String)paramJSONObject.get("abs");
          j = i;
          if (localObject != null) {
            if (getAbstractContent() != null)
            {
              j = i;
              if (getAbstractContent().equals(localObject)) {}
            }
            else
            {
              setAbstractContent((String)localObject);
              j = 1;
            }
          }
        }
        localObject = (String)paramJSONObject.get("references");
        i = j;
        if (localObject != null) {
          if (getReferences() != null)
          {
            i = j;
            if (getReferences().equals(localObject)) {}
          }
          else
          {
            setReferences((String)localObject);
            i = 1;
          }
        }
        localObject = (String)paramJSONObject.get("messageId");
        j = i;
        if (localObject != null) {
          if (getMessageId() != null)
          {
            j = i;
            if (getMessageId().equals(localObject)) {}
          }
          else
          {
            setMessageId((String)localObject);
            j = 1;
          }
        }
        localObject = (String)paramJSONObject.get("remoteId");
        i = j;
        if (localObject != null) {
          if (getRemoteId() != null)
          {
            i = j;
            if (getRemoteId().equals(localObject)) {}
          }
          else
          {
            setRemoteId((String)localObject);
            i = 1;
          }
        }
        localObject = (String)paramJSONObject.get("sz");
        j = i;
        if (localObject != null)
        {
          localObject = "" + StringExtention.sizeStrToLong((String)localObject);
          if (getSize() != 0.0D)
          {
            j = i;
            if (getSize() == Double.valueOf((String)localObject).doubleValue()) {}
          }
          else
          {
            setSize(Double.valueOf((String)localObject).doubleValue());
            j = 1;
          }
        }
        localObject = (String)paramJSONObject.get("sepcpy");
        if (localObject != null) {
          setSeparateCopy((String)localObject);
        }
        new Date(0L);
        i = j;
        if (paramJSONObject.get("date") != null)
        {
          l = paramJSONObject.getLong("date").longValue();
          i = j;
          if (l > 0L)
          {
            localObject = new Date(l * 1000L);
            if (getDate() != null)
            {
              i = j;
              if (getDate().getTime() == ((Date)localObject).getTime()) {}
            }
            else
            {
              setDate((Date)localObject);
              i = 1;
            }
          }
        }
        long l = parseUTC(paramJSONObject);
        j = i;
        if (l > 0L) {
          if (getUtc() != null)
          {
            j = i;
            if (getUtc().getTime() == l) {}
          }
          else
          {
            setUtc(new Date(l));
            j = 1;
          }
        }
        localObject = paramJSONObject.getJSONObject("from");
        i = j;
        if (localObject != null)
        {
          if (getFrom() != null) {
            break label1548;
          }
          setFrom((MailContact)MailContact.fromDictionary((JSONObject)localObject, new MailContact()));
          i = 1;
        }
        localObject = paramJSONObject.getJSONObject("sender");
        j = i;
        if (localObject != null)
        {
          if (getSender() != null) {
            break label1564;
          }
          setSender((MailContact)MailContact.fromDictionary((JSONObject)localObject, new MailContact()));
          j = 1;
        }
        localObject = paramJSONObject.getJSONObject("rly");
        int k = j;
        if (localObject != null)
        {
          if (getReply() != null) {
            break label1580;
          }
          setReply((MailContact)MailContact.fromDictionary((JSONObject)localObject, new MailContact()));
          k = 1;
        }
        localObject = paramJSONObject.getJSONObject("sendCon");
        i = k;
        if (localObject != null)
        {
          if (getSendContact() != null) {
            break label1597;
          }
          setSendContact((MailContact)MailContact.fromDictionary((JSONObject)localObject, new MailContact()));
          i = 1;
        }
        localObject = (String)paramJSONObject.get("localcount");
        j = i;
        if (localObject != null)
        {
          j = i;
          if (!((String)localObject).equals(""))
          {
            int m = Integer.parseInt((String)localObject);
            j = i;
            if (getLocalCount() != m)
            {
              setLocalCount(m);
              j = 1;
            }
          }
        }
        l = parseSendUTC(paramJSONObject);
        i = j;
        if (l > 0L)
        {
          i = j;
          if (getSendUtc() != l)
          {
            setSendUtc(l);
            i = 1;
          }
        }
        if ((!this.toList_.parseWithDictionary(paramJSONObject)) && (i == 0)) {
          break label1613;
        }
        i = 1;
        if ((!this.ccList_.parseWithDictionary(paramJSONObject)) && (i == 0)) {
          break label1618;
        }
        i = 1;
        if ((!this.bccList_.parseWithDictionary(paramJSONObject)) && (i == 0)) {
          break label1623;
        }
        i = 1;
        if ((!this.replyAllList_.parseWithDictionary(paramJSONObject)) && (i == 0)) {
          break label1628;
        }
        i = 1;
        if ((!this.replyAllCCList_.parseWithDictionary(paramJSONObject)) && (i == 0)) {
          break label1633;
        }
        i = 1;
        if ((!this.senderList_.parseWithDictionary(paramJSONObject)) && (i == 0)) {
          break label1638;
        }
        i = 1;
        label1402:
        if ((!this.tagList_.parseWithDictionary(paramJSONObject)) && (i == 0)) {
          break label1643;
        }
        i = 1;
        this.attachList_.setMailId(getId());
        if ((!this.attachList_.parseWithDictionary(paramJSONObject)) && (i == 0)) {
          break label1648;
        }
        i = 1;
        this.bigAttachList_.setMailId(getId());
        if ((!this.bigAttachList_.parseWithDictionary(paramJSONObject)) && (i == 0)) {
          break label1653;
        }
      }
      boolean bool1;
      label1519:
      label1648:
      label1653:
      for (i = 1;; bool1 = false)
      {
        this.editAttachList_.setMailId(getId());
        if ((!this.editAttachList_.parseWithDictionary(paramJSONObject)) && (i == 0)) {
          break;
        }
        return true;
        bool1 = j | getGroupContact().parseWithDictionary((JSONObject)localObject);
        break label291;
        localObject = (String)paramJSONObject.get("cid");
        if (localObject == null) {
          break label398;
        }
        setColId((String)localObject);
        j = 1;
        break label398;
        bool1 = j | getFrom().parseWithDictionary((JSONObject)localObject);
        break label1063;
        j = bool1 | getSender().parseWithDictionary((JSONObject)localObject);
        break label1109;
        boolean bool2 = j | getReply().parseWithDictionary((JSONObject)localObject);
        break label1156;
        bool1 = bool2 | getSendContact().parseWithDictionary((JSONObject)localObject);
        break label1201;
        bool1 = false;
        break label1317;
        bool1 = false;
        break label1334;
        bool1 = false;
        break label1351;
        bool1 = false;
        break label1368;
        bool1 = false;
        break label1385;
        bool1 = false;
        break label1402;
        bool1 = false;
        break label1419;
        bool1 = false;
        break label1447;
      }
    }
  }
  
  public void setAbstractContent(String paramString)
  {
    this.abstractContent = paramString;
  }
  
  public void setAccountId(int paramInt)
  {
    this.accountId = paramInt;
  }
  
  public void setAttachList(ArrayList<Object> paramArrayList)
  {
    this.attachList_.list = paramArrayList;
  }
  
  public void setBccList(ArrayList<Object> paramArrayList)
  {
    this.bccList_.list = paramArrayList;
  }
  
  public void setBigAttachList(ArrayList<Object> paramArrayList)
  {
    this.bigAttachList_.list = paramArrayList;
  }
  
  public void setBodyStructureInfos(ItemBodyStructureHelper.MailItemBodyStructureInfo[] paramArrayOfMailItemBodyStructureInfo)
  {
    this.bodyStructureInfos = paramArrayOfMailItemBodyStructureInfo;
  }
  
  public void setCcList(ArrayList<Object> paramArrayList)
  {
    this.ccList_.list = paramArrayList;
  }
  
  public void setColId(String paramString)
  {
    this.colId = paramString;
  }
  
  public void setConvContactHash(int paramInt)
  {
    this.convContactHash = paramInt;
  }
  
  public void setConvCount(int paramInt)
  {
    this.convCount = paramInt;
  }
  
  public void setConvHash(int paramInt)
  {
    this.convHash = paramInt;
  }
  
  public void setConvReferencHash(int paramInt)
  {
    this.convReferenceHash = paramInt;
  }
  
  public void setConvType(int paramInt)
  {
    this.convType = paramInt;
  }
  
  public void setConvUrCnt(int paramInt)
  {
    this.convUrCnt = paramInt;
  }
  
  public void setDate(Date paramDate)
  {
    this.date = paramDate;
  }
  
  public void setEditAttachList(ArrayList<Object> paramArrayList)
  {
    this.editAttachList_.list = paramArrayList;
  }
  
  public void setFolderId(int paramInt)
  {
    this.folderId = paramInt;
  }
  
  public void setFrom(MailContact paramMailContact)
  {
    this.from = paramMailContact;
  }
  
  public void setGroupContact(MailGroupContact paramMailGroupContact)
  {
    this.groupContact = paramMailGroupContact;
  }
  
  public void setGroupId(String paramString)
  {
    this.groupId = paramString;
  }
  
  public void setGroupMailId(String paramString)
  {
    this.groupMailId = paramString;
  }
  
  public void setId(long paramLong)
  {
    this.id = paramLong;
  }
  
  public void setLastOptTime(Date paramDate)
  {
    this.lastOptTime = paramDate;
  }
  
  public void setLocalCount(int paramInt)
  {
    this.localCount = paramInt;
  }
  
  public void setMessageId(String paramString)
  {
    this.messageId = paramString;
  }
  
  public void setQQTid(String paramString)
  {
    this.tid = paramString;
  }
  
  public void setQQmailAdType(int paramInt)
  {
    this.qqmailAdType = paramInt;
  }
  
  public void setReSubject(String paramString)
  {
    this.reSubject = paramString;
  }
  
  public void setReferences(String paramString)
  {
    this.references = paramString;
  }
  
  public void setRemoteId(String paramString)
  {
    this.remoteId = paramString;
  }
  
  public void setReply(MailContact paramMailContact)
  {
    this.reply = paramMailContact;
  }
  
  public void setReplyAllCCList(ArrayList<Object> paramArrayList)
  {
    this.replyAllCCList_.list = paramArrayList;
  }
  
  public void setReplyAllList(ArrayList<Object> paramArrayList)
  {
    this.replyAllList_.list = paramArrayList;
  }
  
  public void setSendContact(MailContact paramMailContact)
  {
    this.sendContact = paramMailContact;
  }
  
  public void setSendUtc(long paramLong)
  {
    this.sendUtc = paramLong;
  }
  
  public void setSender(MailContact paramMailContact)
  {
    this.sender = paramMailContact;
  }
  
  public void setSenderList(ArrayList<Object> paramArrayList)
  {
    this.senderList_.list = paramArrayList;
  }
  
  public void setSeparateCopy(String paramString)
  {
    this.separateCopy = paramString;
  }
  
  public void setSequence(String paramString)
  {
    this.sequence = paramString;
  }
  
  public void setSize(double paramDouble)
  {
    this.size = paramDouble;
  }
  
  public void setSubject(String paramString)
  {
    this.subject = paramString;
  }
  
  public void setSvrKey(String paramString)
  {
    this.svrKey = paramString;
  }
  
  public void setTagList(ArrayList<Object> paramArrayList)
  {
    this.tagList_.list = paramArrayList;
  }
  
  public void setToList(ArrayList<Object> paramArrayList)
  {
    this.toList_.list = paramArrayList;
  }
  
  public void setUtc(Date paramDate)
  {
    this.utc = paramDate;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("{");
    localStringBuffer.append("\"class\":\"MailInformation\",");
    localStringBuffer.append("\"accountId\":\"" + getAccountId() + "\",");
    if (getGroupMailId() != null) {
      localStringBuffer.append("\"gmid\":\"" + getGroupMailId() + "\",");
    }
    if (getQQTid() != null) {
      localStringBuffer.append("\"tid\":\"" + getQQTid() + "\",");
    }
    if (getColId() != null) {
      localStringBuffer.append("\"colmail\":\"" + getColId() + "\",");
    }
    if (getGroupId() != null) {
      localStringBuffer.append("\"gid\":\"" + getGroupId() + "\",");
    }
    if (getGroupContact() != null) {
      localStringBuffer.append("\"groupContact\":" + getGroupContact() + ",");
    }
    String str;
    if (getSequence() != null)
    {
      str = getSequence().replaceAll("\\\\", "\\\\\\\\");
      localStringBuffer.append("\"seq\":\"" + str.replaceAll("\"", "\\\\\"") + "\",");
    }
    if (getReSubject() != null)
    {
      str = getReSubject().replaceAll("\\\\", "\\\\\\\\");
      localStringBuffer.append("\"re\":\"" + str.replaceAll("\"", "\\\\\"") + "\",");
    }
    localStringBuffer.append("\"fid\":\"" + getFolderId() + "\",");
    if (getSubject() != null)
    {
      str = getSubject().replaceAll("\\\\", "\\\\\\\\");
      localStringBuffer.append("\"subj\":\"" + str.replaceAll("\"", "\\\\\"") + "\",");
    }
    if (getAbstractContent() != null)
    {
      str = getAbstractContent().replaceAll("\\\\", "\\\\\\\\");
      localStringBuffer.append("\"abs\":\"" + str.replaceAll("\"", "\\\\\"") + "\",");
    }
    for (;;)
    {
      if (getDate() != null) {
        localStringBuffer.append("\"date\":" + getDate().getTime() / 1000L + ",");
      }
      if (getFrom() != null) {
        localStringBuffer.append("\"from\":" + getFrom().toString() + ",");
      }
      if (getSender() != null) {
        localStringBuffer.append("\"sender\":" + getSender().toString() + ",");
      }
      if (getUtc() != null) {
        localStringBuffer.append("\"UTC\":" + getUtc().getTime() / 1000L + ",");
      }
      localStringBuffer.append("\"sz\":\"" + getSize() + "\",");
      if (getSeparateCopy() != null)
      {
        str = getSeparateCopy().replaceAll("\\\\", "\\\\\\\\");
        localStringBuffer.append("\"sepcpy\":\"" + str.replaceAll("\"", "\\\\\"") + "\",");
      }
      if (getReply() != null) {
        localStringBuffer.append("\"rly\":" + getReply().toString() + ",");
      }
      if (getSendContact() != null) {
        localStringBuffer.append("\"sendCon\":" + getSendContact().toString() + ",");
      }
      if (getReferences() != null) {
        localStringBuffer.append("\"references\":\"" + getReferences() + "\",");
      }
      if (getMessageId() != null) {
        localStringBuffer.append("\"messageId\":\"" + getMessageId() + "\",");
      }
      if (getRemoteId() != null) {
        localStringBuffer.append("\"remoteId\":\"" + getRemoteId() + "\",");
      }
      if (this.toList_ != null)
      {
        str = this.toList_.toString();
        localStringBuffer.append(str);
        if (str.length() > 0) {
          localStringBuffer.append(',');
        }
      }
      if (this.ccList_ != null)
      {
        str = this.ccList_.toString();
        localStringBuffer.append(str);
        if (str.length() > 0) {
          localStringBuffer.append(',');
        }
      }
      if (this.bccList_ != null)
      {
        str = this.bccList_.toString();
        localStringBuffer.append(str);
        if (str.length() > 0) {
          localStringBuffer.append(',');
        }
      }
      if (this.replyAllList_ != null)
      {
        str = this.replyAllList_.toString();
        localStringBuffer.append(str);
        if (str.length() > 0) {
          localStringBuffer.append(',');
        }
      }
      if (this.replyAllCCList_ != null)
      {
        str = this.replyAllCCList_.toString();
        localStringBuffer.append(str);
        if (str.length() > 0) {
          localStringBuffer.append(',');
        }
      }
      if (this.tagList_ != null)
      {
        str = this.tagList_.toString();
        localStringBuffer.append(str);
        if (str.length() > 0) {
          localStringBuffer.append(',');
        }
      }
      if (this.attachList_ != null)
      {
        str = this.attachList_.toString();
        localStringBuffer.append(str);
        if (str.length() > 0) {
          localStringBuffer.append(',');
        }
      }
      if (this.bigAttachList_ != null)
      {
        str = this.bigAttachList_.toString();
        localStringBuffer.append(str);
        if (str.length() > 0) {
          localStringBuffer.append(',');
        }
      }
      if (this.editAttachList_ != null)
      {
        str = this.editAttachList_.toString();
        localStringBuffer.append(str);
        if (str.length() > 0) {
          localStringBuffer.append(',');
        }
      }
      int i = localStringBuffer.length() - 1;
      if (localStringBuffer.charAt(i) == ',') {
        localStringBuffer.deleteCharAt(i);
      }
      localStringBuffer.append("}");
      return localStringBuffer.toString();
      localStringBuffer.append("\"abs\":\"\",");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.MailInformation
 * JD-Core Version:    0.7.0.1
 */