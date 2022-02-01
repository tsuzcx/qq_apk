package com.tencent.qqmail.model.mail;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.calendar.model.CCalendar;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.model.qmdomain.MailContent;
import com.tencent.qqmail.model.qmdomain.MailEditAttach;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.model.qmdomain.SubscribeMail;
import com.tencent.qqmail.protocol.calendar.CalendarServiceRouter;
import com.tencent.qqmail.utilities.common.QMMailContentParser;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class QMMailParser
{
  private static final String TAG = "QMMailParser";
  
  protected static final boolean isGroupMailParent(String paramString)
  {
    return (paramString.startsWith("@")) && (paramString.split("_").length < 2);
  }
  
  public static ArrayList<MailBigAttach> parseBigAttachList(String paramString)
  {
    return QMMailContentParser.findBigAttach(paramString);
  }
  
  public static ArrayList<MailEditAttach> parseEditAttachList(String paramString)
  {
    return QMMailContentParser.findEditAttach(paramString);
  }
  
  public static ArrayList<QMFolder> parseFolder(int paramInt, JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    JSONObject localJSONObject1 = paramJSONObject.getJSONObject("fo");
    JSONObject localJSONObject2 = paramJSONObject.getJSONObject("lock");
    if (localJSONObject1 == null) {
      return localArrayList;
    }
    paramJSONObject = null;
    try
    {
      ValidateHelper.notNullAndNotEmpty((String)localJSONObject1.get("sub"));
      String str = (String)localJSONObject1.get("sub");
      paramJSONObject = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    parseFolders(paramInt, parseFolders(paramInt, parseFolders(paramInt, parseFolders(paramInt, parseFolders(paramInt, parseFolders(paramInt, 0, 11, false, paramJSONObject, localArrayList, localJSONObject1.getJSONObject("sys")), 12, localJSONObject2.get("fldmy").equals("1"), paramJSONObject, localArrayList, localJSONObject1.getJSONObject("user")), 13, localJSONObject2.get("fldpop").equals("1"), paramJSONObject, localArrayList, localJSONObject1.getJSONObject("pop")), 14, false, paramJSONObject, localArrayList, localJSONObject1.getJSONObject("tag")), 17, false, paramJSONObject, localArrayList, localJSONObject1.getJSONObject("addrvip")), 18, false, paramJSONObject, localArrayList, localJSONObject1.getJSONObject("unreadlist"));
    return localArrayList;
  }
  
  private static int parseFolders(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString, ArrayList<QMFolder> paramArrayList, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      QMLog.log(6, "QMMailParser", paramInt1 + ";" + "parseFolders err:dictItems is null");
      j = paramInt2;
    }
    int i;
    do
    {
      return j;
      paramJSONObject = paramJSONObject.getJSONArray("itms");
      i = 0;
      j = paramInt2;
    } while (i >= paramJSONObject.size());
    Object localObject = paramJSONObject.getJSONObject(i);
    JSONObject localJSONObject = ((JSONObject)localObject).getJSONObject("inf");
    int j = paramInt2;
    QMFolder localQMFolder;
    if (localJSONObject != null)
    {
      localQMFolder = new QMFolder();
      localQMFolder.setAccountId(paramInt1);
      localQMFolder.parseWithDictionary((JSONObject)localObject);
      localObject = (String)localJSONObject.get("idx");
      if (!"all_star_".equals(localObject)) {
        break label347;
      }
      localQMFolder.setRemoteId(String.valueOf(16));
      label148:
      j = Integer.parseInt(localQMFolder.getRemoteId());
      if (paramInt3 != 11) {
        break label412;
      }
      switch (j)
      {
      case 2: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
      case 15: 
      default: 
        if (localQMFolder.getRemoteId().equals(paramString))
        {
          localQMFolder.setType(15);
          label264:
          localQMFolder.setParentId(-6);
        }
        break;
      }
    }
    for (;;)
    {
      localQMFolder.setSequence(paramInt3 * 10000 + paramInt2);
      if (localJSONObject.containsKey("toppos"))
      {
        j = localJSONObject.getIntValue("toppos");
        localQMFolder.setSequence(j);
        localQMFolder.setTopPos(j);
      }
      localQMFolder.setLocked(paramBoolean);
      paramArrayList.add(localQMFolder);
      j = paramInt2 + 1;
      i += 1;
      paramInt2 = j;
      break;
      label347:
      if ("addrvip_addrvip_".equals(localObject))
      {
        localQMFolder.setRemoteId(String.valueOf(17));
        break label148;
      }
      if (!"unreadlist_unreadlist_".equals(localObject)) {
        break label148;
      }
      localQMFolder.setRemoteId(String.valueOf(18));
      break label148;
      localQMFolder.setType(j);
      break label264;
      localQMFolder.setType(paramInt3);
      break label264;
      label412:
      localQMFolder.setType(paramInt3);
      switch (paramInt3)
      {
      case 14: 
      case 15: 
      case 16: 
      default: 
        break;
      case 12: 
        localQMFolder.setParentId(-7);
        break;
      case 13: 
        localQMFolder.setParentId(-8);
        break;
      case 17: 
        localQMFolder.setParentId(-6);
        break;
      case 18: 
        localQMFolder.setParentId(-17);
      }
    }
  }
  
  public static String parseIndexSinceRemoteId(JSONObject paramJSONObject)
  {
    Object localObject1 = null;
    Object localObject2 = paramJSONObject.getJSONArray("idx");
    paramJSONObject = localObject1;
    if (localObject2 != null)
    {
      paramJSONObject = localObject1;
      if (((JSONArray)localObject2).size() != 0)
      {
        localObject2 = new ArrayList(((JSONArray)localObject2).getJSONObject(0).getJSONArray("itms"));
        paramJSONObject = localObject1;
        if (localObject2 != null)
        {
          paramJSONObject = localObject1;
          if (((ArrayList)localObject2).size() != 0) {
            paramJSONObject = (String)((ArrayList)localObject2).get(((ArrayList)localObject2).size() - 1);
          }
        }
      }
    }
    return paramJSONObject;
  }
  
  public static HashMap<String, String[]> parseIndexes(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    paramJSONObject = paramJSONObject.getJSONArray("idx");
    if ((paramJSONObject != null) && (paramJSONObject.size() != 0))
    {
      int i = 0;
      while (i < paramJSONObject.size())
      {
        Object localObject = paramJSONObject.getJSONObject(i);
        String str = (String)((JSONObject)localObject).get("idx");
        localObject = new ArrayList(((JSONObject)localObject).getJSONArray("itms"));
        if ((localObject != null) && (((ArrayList)localObject).size() != 0))
        {
          String[] arrayOfString = new String[((ArrayList)localObject).size()];
          int j = 0;
          while (j < ((ArrayList)localObject).size())
          {
            arrayOfString[j] = ((String)((ArrayList)localObject).get(j));
            j += 1;
          }
          localHashMap.put(str, arrayOfString);
        }
        i += 1;
      }
    }
    return localHashMap;
  }
  
  public static HashMap<String, Boolean> parseLockState(int paramInt, JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.getJSONObject("lock");
    if (localObject == null) {
      return null;
    }
    paramJSONObject = new HashMap();
    localObject = ((JSONObject)localObject).entrySet().iterator();
    if (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if (!localEntry.getValue().toString().equals("0")) {}
      for (boolean bool = true;; bool = false)
      {
        paramJSONObject.put(localEntry.getKey(), Boolean.valueOf(bool));
        break;
      }
    }
    return paramJSONObject;
  }
  
  public static ArrayList<Mail> parseMails(int paramInt, JSONObject paramJSONObject)
  {
    ArrayList localArrayList1 = new ArrayList();
    if (paramJSONObject == null) {
      return localArrayList1;
    }
    JSONArray localJSONArray1 = paramJSONObject.getJSONArray("mls");
    JSONArray localJSONArray2 = paramJSONObject.getJSONArray("idxSt");
    if ((localJSONArray1 != null) && (localJSONArray1.size() != 0))
    {
      int j = 0;
      if (j < localJSONArray1.size())
      {
        paramJSONObject = localJSONArray1.getJSONObject(j);
        JSONObject localJSONObject2 = paramJSONObject.getJSONObject("st");
        JSONObject localJSONObject1 = paramJSONObject.getJSONObject("inf");
        Mail localMail = (Mail)Mail.fromDictionary(paramJSONObject, new Mail());
        MailInformation localMailInformation = localMail.getInformation();
        MailStatus localMailStatus = localMail.getStatus();
        paramJSONObject = localMail.getContent().getBody();
        Object localObject;
        if (paramJSONObject != null)
        {
          ArrayList localArrayList3 = parseBigAttachList(paramJSONObject);
          ArrayList localArrayList2 = parseEditAttachList(paramJSONObject);
          String str = removeMailEditAttachArea(removeFoxmailContentAttachArea(removeNtesContentAttachArea(paramJSONObject)));
          if ((localArrayList3 != null) && (localArrayList3.size() > 0))
          {
            localObject = localMail.getInformation().getBigAttachList();
            paramJSONObject = (JSONObject)localObject;
            if (localObject == null) {
              paramJSONObject = new ArrayList();
            }
            paramJSONObject.addAll(localArrayList3);
            localMail.getInformation().setBigAttachList(paramJSONObject);
          }
          if ((localArrayList2 != null) && (localArrayList2.size() > 0))
          {
            localObject = localMail.getInformation().getEditAttachList();
            paramJSONObject = (JSONObject)localObject;
            if (localObject == null) {
              paramJSONObject = new ArrayList();
            }
            paramJSONObject.addAll(localArrayList2);
            localMail.getInformation().setEditAttachList(paramJSONObject);
          }
          localMail.getContent().setBody(str);
        }
        if ((localJSONObject2 != null) && (localJSONObject2.get("admail") != null)) {
          localMailInformation.setQQmailAdType(Integer.parseInt((String)localJSONObject2.get("admail")));
        }
        if (localJSONObject1 != null) {
          if (!localMailStatus.hasAttach())
          {
            paramJSONObject = localJSONObject1.getString("hasattach");
            if ((!"1".equalsIgnoreCase(paramJSONObject)) && (!"true".equalsIgnoreCase(paramJSONObject)) && ((localMail.getInformation().getBigAttachList() == null) || (localMail.getInformation().getBigAttachList().size() <= 0)) && ((localMail.getInformation().getEditAttachList() == null) || (localMail.getInformation().getEditAttachList().size() <= 0))) {
              break label573;
            }
          }
        }
        int i;
        label573:
        for (boolean bool = true;; bool = false)
        {
          localMailStatus.setHasAttach(bool);
          paramJSONObject = (String)localJSONObject1.get("groupoff");
          if ((paramJSONObject != null) && (paramJSONObject.equals("1"))) {
            localMailStatus.setIsGroupOff(true);
          }
          paramJSONObject = (String)localJSONObject1.get("groupadmin");
          if ((paramJSONObject != null) && (paramJSONObject.equals("1"))) {
            localMailStatus.setIsGroupAdmin(true);
          }
          if ((localJSONArray2 == null) || (localJSONArray2.size() == 0)) {
            break;
          }
          i = 0;
          while (i < localJSONArray2.size())
          {
            paramJSONObject = localJSONArray2.getJSONObject(i);
            if ((paramJSONObject != null) && (localMail.getInformation().getRemoteId().equals(paramJSONObject.get("idx"))))
            {
              if (paramJSONObject.get("cnt") != null) {
                localMailInformation.setConvCount(paramJSONObject.getIntValue("cnt"));
              }
              if (paramJSONObject.get("urCnt") != null) {
                localMailInformation.setConvUrCnt(paramJSONObject.getIntValue("urCnt"));
              }
            }
            i += 1;
          }
        }
        localMailInformation.setFolderId(QMFolder.generateId(paramInt, String.valueOf(localMailInformation.getFolderId()), false));
        paramJSONObject = localMailInformation.getRemoteId();
        if ((paramJSONObject.startsWith("@")) && (paramJSONObject.split("_").length == 2))
        {
          localObject = localMailInformation.getRemoteId().split("_")[0];
          localMailStatus.setGroupChild(true);
          label643:
          localMailInformation.setAccountId(paramInt);
          localMailInformation.setId(Mail.generateId(paramInt, paramJSONObject));
          localMail.updateConvHash();
          i = 0;
          if (!localMailStatus.isConversationChild()) {
            break label798;
          }
          if (QMFolderManager.sharedInstance().canConvFolderIds(paramInt, localMailInformation.getFolderId())) {
            i = -1;
          }
        }
        for (;;)
        {
          localMailInformation.setConvType(i);
          if (i != -1) {
            localMailStatus.setNeedSync(true);
          }
          if (localJSONObject1 != null)
          {
            localObject = localJSONObject1.getString("calendar");
            if ((localObject != null) && (!((String)localObject).trim().equals("")))
            {
              localObject = CalendarServiceRouter.parseICS((String)localObject);
              QMMailManager.sharedInstance().saveIcsEvent(paramInt, paramJSONObject, (CCalendar)localObject);
              localMailStatus.setIcs(true);
            }
          }
          localArrayList1.add(localMail);
          j += 1;
          break;
          if (!paramJSONObject.startsWith("@")) {
            break label643;
          }
          localMailStatus.setGroupMail(true);
          break label643;
          label798:
          if (localMailStatus.isGroupChild()) {
            i = localMailInformation.getConvType();
          } else if (isGroupMailParent(localMailInformation.getRemoteId())) {
            i = 0;
          } else if (localMailStatus.isConversation()) {
            i = 1;
          }
        }
      }
    }
    return localArrayList1;
  }
  
  public static ArrayList<QMFolder> parseStatus(int paramInt, JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    paramJSONObject = paramJSONObject.getJSONArray("idxSt");
    int i = 0;
    JSONObject localJSONObject;
    String str;
    QMFolder localQMFolder;
    boolean bool2;
    boolean bool3;
    boolean bool4;
    for (;;)
    {
      if (i < paramJSONObject.size())
      {
        localJSONObject = paramJSONObject.getJSONObject(i);
        str = (String)localJSONObject.get("idx");
        if ((!str.startsWith("all_tag_")) && (!str.startsWith("all_star_")) && (!str.startsWith("unreadlist_unreadlist_")) && (!str.startsWith("addrvip_addrvip_")) && (!str.endsWith("__")))
        {
          i += 1;
        }
        else
        {
          localQMFolder = new QMFolder();
          localQMFolder.setAccountId(paramInt);
          boolean bool1 = str.startsWith("all_tag_");
          bool2 = str.equals("all_star_");
          bool3 = str.equals("unreadlist_unreadlist_");
          bool4 = str.equals("addrvip_addrvip_");
          if (bool1)
          {
            localQMFolder.setType(14);
            localQMFolder.setRemoteId(str.split("all_tag_")[1]);
            label184:
            if (localJSONObject.get("urCnt") == null) {
              break label394;
            }
          }
        }
      }
    }
    label394:
    for (int j = Integer.valueOf(localJSONObject.get("urCnt").toString()).intValue();; j = -1)
    {
      if (localJSONObject.get("cnt") != null) {}
      for (int k = Integer.valueOf(localJSONObject.get("cnt").toString()).intValue();; k = -1)
      {
        if (localJSONObject.get("personalcnt") != null) {}
        for (int m = Integer.valueOf(localJSONObject.get("personalcnt").toString()).intValue();; m = -1)
        {
          localQMFolder.setCliUnreadCount(j);
          localQMFolder.setCliConvUnreadCount(j);
          localQMFolder.setSvrUnreadCount(j);
          localQMFolder.setSvrCount(k);
          localQMFolder.setPersonalCount(m);
          localArrayList.add(localQMFolder);
          break;
          if (bool2)
          {
            localQMFolder.setType(16);
            break label184;
          }
          if (bool3)
          {
            localQMFolder.setType(18);
            break label184;
          }
          if (bool4)
          {
            localQMFolder.setType(17);
            break label184;
          }
          localQMFolder.setRemoteId(str.split("__")[0]);
          break label184;
          return localArrayList;
        }
      }
    }
  }
  
  public static ArrayList<SubscribeMail> parseSubscribeMail(JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    paramJSONObject = paramJSONObject.getJSONArray("mls");
    int i;
    Object localObject3;
    Object localObject2;
    Object localObject1;
    String str1;
    Object localObject4;
    if ((paramJSONObject != null) && (paramJSONObject.size() != 0))
    {
      i = 0;
      if (i < paramJSONObject.size())
      {
        localObject3 = paramJSONObject.getJSONObject(i);
        localObject2 = ((JSONObject)localObject3).getJSONObject("inf");
        localObject1 = ((JSONObject)localObject2).getJSONObject("from");
        str1 = (String)((JSONObject)localObject2).get("id");
        localObject4 = (String)((JSONObject)localObject2).get("cid");
        if ((localObject4 == null) || ("".equals(localObject4))) {
          break label627;
        }
      }
    }
    label627:
    for (int j = Integer.parseInt((String)localObject4);; j = 0)
    {
      localObject3 = ((JSONObject)localObject3).getJSONObject("content");
      if (localObject3 != null)
      {
        localObject3 = ((JSONObject)localObject3).getJSONObject("sps");
        if (localObject3 != null)
        {
          localObject2 = new SubscribeMail();
          ((SubscribeMail)localObject2).setRemoteId(str1);
          ((SubscribeMail)localObject2).setColId(j);
          if (localObject1 != null)
          {
            ((SubscribeMail)localObject2).setFromName((String)((JSONObject)localObject1).get("name"));
            ((SubscribeMail)localObject2).setFromAddress((String)((JSONObject)localObject1).get("addr"));
          }
          ((SubscribeMail)localObject2).setAbstract((String)((JSONObject)localObject3).get("digest"));
          ((SubscribeMail)localObject2).setSubject((String)((JSONObject)localObject3).get("title"));
          ((SubscribeMail)localObject2).setLink((String)((JSONObject)localObject3).get("link"));
          ((SubscribeMail)localObject2).setIcon((String)((JSONObject)localObject3).get("url"));
          ((SubscribeMail)localObject2).setIndex(SubscribeMail.INDEX_ENTRANCE_MAIL);
          localArrayList.add(localObject2);
          localObject1 = ((JSONObject)localObject3).getJSONArray("item");
          if ((localObject1 != null) && (((JSONArray)localObject1).size() != 0))
          {
            int k = 0;
            if (k < ((JSONArray)localObject1).size())
            {
              localObject3 = ((JSONArray)localObject1).getJSONObject(k);
              if ((((JSONObject)localObject3).get("url") == null) || (((JSONObject)localObject3).get("link") == null)) {}
              for (;;)
              {
                k += 1;
                break;
                localObject4 = new SubscribeMail();
                ((SubscribeMail)localObject4).setRemoteId(str1);
                ((SubscribeMail)localObject4).setColId(j);
                ((SubscribeMail)localObject4).setIndex(k);
                ((SubscribeMail)localObject4).setAbstract((String)((JSONObject)localObject3).get("digest"));
                ((SubscribeMail)localObject4).setSubject((String)((JSONObject)localObject3).get("title"));
                ((SubscribeMail)localObject4).setLink((String)((JSONObject)localObject3).get("link"));
                if (((JSONObject)localObject3).get("apppic") != null)
                {
                  String str2 = (String)((JSONObject)localObject3).get("apppic");
                  ((SubscribeMail)localObject4).setBigIcon(str2);
                  if (((SubscribeMail)localObject2).getBigIcon() == null) {
                    ((SubscribeMail)localObject2).setBigIcon(str2);
                  }
                }
                ((SubscribeMail)localObject4).setIcon((String)((JSONObject)localObject3).get("url"));
                localArrayList.add(localObject4);
              }
            }
          }
        }
        else if (Mail.isSubscribeByColid(str1, j))
        {
          localObject3 = new SubscribeMail();
          ((SubscribeMail)localObject3).setRemoteId(str1);
          ((SubscribeMail)localObject3).setColId(j);
          ((SubscribeMail)localObject3).setAbstract((String)((JSONObject)localObject2).get("abs"));
          ((SubscribeMail)localObject3).setSubject((String)((JSONObject)localObject2).get("subj"));
          if (localObject1 != null)
          {
            ((SubscribeMail)localObject3).setFromName((String)((JSONObject)localObject1).get("name"));
            ((SubscribeMail)localObject3).setFromAddress((String)((JSONObject)localObject1).get("addr"));
          }
          ((SubscribeMail)localObject3).setIndex(SubscribeMail.INDEX_ENTRANCE_MAIL);
          localArrayList.add(localObject3);
        }
      }
      i += 1;
      break;
      return localArrayList;
    }
  }
  
  public static String removeContentAttachArea(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramString1 != null) && (paramString1.contains(paramString3))) {
      paramString1 = StringExtention.removeHtmlLableByName(paramString1, paramString2, paramString3);
    }
    for (;;)
    {
      paramString3 = paramString1;
      if (paramString1 != null)
      {
        paramString3 = paramString1;
        if (paramString1.contains("netease-attDown")) {
          paramString3 = StringExtention.removeHtmlLableByName(paramString1, paramString2, paramString4);
        }
      }
      return paramString3;
    }
  }
  
  public static String removeFoxmailContentAttachArea(String paramString)
  {
    return removeContentAttachArea(paramString, "div", "FoxmailClientBigAttach", "");
  }
  
  public static String removeMailEditAttachArea(String paramString)
  {
    return removeContentAttachArea(paramString, "div", "QQMailEditAttach", "");
  }
  
  public static String removeNtesContentAttachArea(String paramString)
  {
    return removeContentAttachArea(paramString, "div", "QQMailBigAttach", "class=\"netease-attDown\"");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailParser
 * JD-Core Version:    0.7.0.1
 */