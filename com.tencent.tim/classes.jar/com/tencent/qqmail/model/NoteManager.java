package com.tencent.qqmail.model;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.ManagerLifecycle;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.activity.watcher.AppStatusWatcher;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.model.qmdomain.QMComposeNote;
import com.tencent.qqmail.model.qmdomain.QMNNote;
import com.tencent.qqmail.model.qmdomain.QMNNoteCategory;
import com.tencent.qqmail.model.qmdomain.QMNNoteInformation;
import com.tencent.qqmail.model.qmdomain.QMNNoteStatus;
import com.tencent.qqmail.model.qmdomain.QMNoteAttachList;
import com.tencent.qqmail.model.qmnote.storage.QMNoteTask;
import com.tencent.qqmail.model.uidomain.NoteUI;
import com.tencent.qqmail.note.NoteListActivity.NoteDeleteCallback;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.trd.guava.Maps;
import com.tencent.qqmail.utilities.ByteConvert;
import com.tencent.qqmail.utilities.dateextension.DateExtension;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.CGIManager;
import com.tencent.qqmail.utilities.qmnetwork.CGIRequest;
import com.tencent.qqmail.utilities.qmnetwork.NetworkManager;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkConfig;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest.QMHttpMethod;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.template.Template;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import moai.core.watcher.Watchers;
import org.apache.commons.lang3.StringUtils;

public class NoteManager
  extends ManagerLifecycle
{
  public static final String CLOUDS = "CLOUDS";
  public static final String CLOUD_PREFIX = "_";
  public static final int CONST_PAGESIZE = 5;
  public static final String LOCALS = "LOCALS";
  public static final String LOCAL_PREFIX = "compose";
  public static final String NOTE_CATEGORY_UPDATE = "NOTE_CATEGORY_UPDATE";
  protected static final String NOTE_LIST_ERROR = "NOTE_LIST_ERROR";
  private static final long NOTE_LIST_SYNC_INTERVAL = 5000L;
  public static final String NOTE_LIST_UPDATE = "NOTE_LIST_UPDATE";
  public static final int NOTE_STATUS_CONFLICT = 3;
  public static final int NOTE_STATUS_MODIFY = 2;
  public static final int NOTE_STATUS_NEWADD = 1;
  public static final int NOTE_STATUS_PENDING_DELETE = 9;
  public static final int NOTE_STATUS_SENDING = 5;
  public static final int NOTE_STATUS_UNVERIFY = 6;
  public static final int NOTE_STATUS_VERIFIED = 0;
  public static final String SEP = "___";
  private static final String TAG = "NoteManager";
  private static volatile NoteManager _instance;
  private static long mLastLoadNoteListTime = 0L;
  public int mCurAccountId;
  public String mCurrentNoteUin = null;
  private HashMap<String, String> mIdSeqMaps = new HashMap();
  private List<String> mSearchIds = new ArrayList();
  private AppStatusWatcher mWatcher = new NoteManager.1(this);
  private final NoteCache noteCache;
  
  private NoteManager(Context paramContext, QQMailAccount paramQQMailAccount)
  {
    String str = paramQQMailAccount.getUin();
    ValidateHelper.notNull(paramContext);
    ValidateHelper.notNullAndNotEmpty(str);
    this.mCurrentNoteUin = str;
    this.mCurAccountId = paramQQMailAccount.getId();
    this.noteCache = new NoteCache(paramContext, str);
    bindWatcher(true);
  }
  
  private String _encodeNoteListUTCParam()
  {
    ArrayList localArrayList = this.noteCache.readCreateUTC("desc");
    if (localArrayList.size() == 0) {
      return "&create=&update=0";
    }
    double d1 = this.noteCache.readLastUpdateUTC();
    double d2 = ((Double)localArrayList.get(0)).doubleValue();
    int i = 0;
    int k = localArrayList.size();
    int j = 0;
    if (j < k) {
      if (j == 0)
      {
        if (d2 >= 2147483648L) {
          return null;
        }
        i += 4;
      }
    }
    for (;;)
    {
      j += 1;
      break;
      int m = (int)(((Double)localArrayList.get(j - 1)).doubleValue() - ((Double)localArrayList.get(j)).doubleValue());
      if (m < 1073741824L) {
        if (m < 32768L)
        {
          i += 2;
        }
        else
        {
          i += 4;
          continue;
          byte[] arrayOfByte1 = new byte[i];
          i = 0;
          k = localArrayList.size();
          j = 0;
          if (j < k) {
            if (j == 0)
            {
              System.arraycopy(ByteConvert.intToBytes((int)d2), 0, arrayOfByte1, i, 4);
              i += 4;
            }
          }
          for (;;)
          {
            j += 1;
            break;
            m = (int)(((Double)localArrayList.get(j - 1)).doubleValue() - ((Double)localArrayList.get(j)).doubleValue());
            if (m < 1073741824L)
            {
              byte[] arrayOfByte2 = ByteConvert.intToBytes(m);
              if (m < 32768L)
              {
                System.arraycopy(arrayOfByte2, 2, arrayOfByte1, i, 2);
                i += 2;
              }
              else
              {
                arrayOfByte2[0] = ((byte)(arrayOfByte2[0] | 0xFFFFFF80));
                System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i, 4);
                i += 4;
                continue;
                return "&create=" + StringExtention.base64Encode(arrayOfByte1, i) + "&update=" + d1;
              }
            }
          }
        }
      }
    }
  }
  
  private String _getNoteIdParams(List<String> paramList)
  {
    Object localObject;
    if ((paramList == null) || (paramList.size() == 0))
    {
      localObject = "";
      return localObject;
    }
    int j = paramList.size();
    String str = "";
    int i = 0;
    for (;;)
    {
      localObject = str;
      if (i >= j) {
        break;
      }
      str = str + "&noteid=" + (String)paramList.get(i);
      i += 1;
    }
  }
  
  private String _getNoteSendParamEncodeURI(HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    int i = 0;
    Object localObject1 = new StringBuilder("t=note_send.json&contenttype=html&subject=$subject$&content=$content$");
    if (paramHashMap.get("conv") != null)
    {
      if (!StringExtention.strictEmpty(paramHashMap, "rly")) {
        ((StringBuilder)localObject1).append("&s=convrly&conv=$conv$");
      }
      if (!StringExtention.strictEmpty(paramHashMap, "fwd")) {
        ((StringBuilder)localObject1).append("&s=convfwd&conv=$conv$");
      }
    }
    Object localObject3;
    for (;;)
    {
      localObject2 = new String[7];
      localObject2[0] = "noteid";
      localObject2[1] = "update";
      localObject2[2] = "star";
      localObject2[3] = "catid";
      localObject2[4] = "createtime";
      localObject2[5] = "modifytime";
      localObject2[6] = "type";
      int j = localObject2.length;
      while (i < j)
      {
        localObject3 = localObject2[i];
        if (!StringExtention.strictEmpty(paramHashMap, localObject3)) {
          ((StringBuilder)localObject1).append("&").append((String)localObject3).append("=$").append((String)localObject3).append("$");
        }
        i += 1;
      }
      ((StringBuilder)localObject1).append("&s=send");
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = paramHashMap.entrySet().iterator();
    paramHashMap = (HashMap<String, String>)localObject1;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      localObject1 = (String)((Map.Entry)localObject3).getKey();
      localObject3 = (String)((Map.Entry)localObject3).getValue();
      if (!paramBoolean) {}
      for (paramHashMap = StringExtention.replace(paramHashMap, (String)localObject1, (String)localObject3);; paramHashMap = StringExtention.replaceWithEncodeURIValue(paramHashMap, (String)localObject1, (String)localObject3)) {
        break;
      }
    }
    return paramHashMap;
  }
  
  private void _loadNoteListSuccessWithOptionsWithCallback(QMNetworkResponse paramQMNetworkResponse, int paramInt)
  {
    paramQMNetworkResponse = (JSONObject)paramQMNetworkResponse.getResponseJson();
    this.noteCache.parseNoteOtherInformation(paramQMNetworkResponse, paramInt);
    this.noteCache.parseNoteList(paramQMNetworkResponse);
  }
  
  private void _loadNoteSuccessWithOptionsWithNoteIdWithNotification(QMNetworkResponse paramQMNetworkResponse, String paramString1, String paramString2)
  {
    paramQMNetworkResponse = (JSONObject)paramQMNetworkResponse.getResponseJson();
    String str = this.noteCache.parseNote(paramQMNetworkResponse);
    paramQMNetworkResponse = paramString1;
    if (paramString1 == null) {
      paramQMNetworkResponse = str;
    }
    paramString1 = Maps.newHashMap();
    if (StringUtils.equals(paramString2, "true")) {
      paramString1.put("fromNetwork", paramString2);
    }
    paramString1.put("data", this.noteCache.readNoteData(paramQMNetworkResponse));
    QMNotification.postNotification("N_LOADNOTE_SUCC", paramString1);
  }
  
  private String _noteListSynURL(boolean paramBoolean)
  {
    if (paramBoolean) {
      return String.format("%s%s%s", new Object[] { "ef=js&t=note_data.json", "&s=sync&sync=1", _encodeNoteListUTCParam() });
    }
    return String.format("%s%s", new Object[] { "ef=js&t=note_data.json", "&s=sync&sync=1" });
  }
  
  private void bindWatcher(boolean paramBoolean)
  {
    Watchers.bind(this.mWatcher, paramBoolean);
  }
  
  private String detectConflictParam(String paramString)
  {
    QMNNote localQMNNote = this.noteCache.readNoteData(paramString);
    paramString = "";
    if (localQMNNote != null) {
      paramString = "&conflictqueue=" + localQMNNote.information.noteId + "," + new DecimalFormat("#").format(localQMNNote.status.sequence);
    }
    return String.format("%s%s%s", new Object[] { "ef=js&t=note_data.json", "&s=sync&sync=0&conflict=1", paramString });
  }
  
  public static HashMap<String, List<String>> filterNote(List<String> paramList)
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (str.contains("compose")) {
        localArrayList1.add(str);
      } else if (str.startsWith("_")) {
        localArrayList2.add(str);
      } else {
        QMLog.log(3, "NoteManager", String.format("noteid invalid (%s)", new Object[] { str }));
      }
    }
    localHashMap.put("LOCALS", localArrayList1);
    localHashMap.put("CLOUDS", localArrayList2);
    return localHashMap;
  }
  
  public static String formatBigAttachs(ArrayList<Object> paramArrayList)
  {
    String str2 = Template.getTemplateSectionWithName(QMApplicationContext.sharedInstance(), Template.CONTENT_HTML_TEMPLATE, "bigattachItemWrapper");
    String str1 = "";
    int i = 0;
    while (i < paramArrayList.size())
    {
      Object localObject = (MailBigAttach)paramArrayList.get(i);
      String str3 = Template.getTemplateSectionWithName(QMApplicationContext.sharedInstance(), Template.CONTENT_HTML_TEMPLATE, "bigattachItem");
      HashMap localHashMap = new HashMap();
      localHashMap.put("size", ((MailBigAttach)localObject).getSize());
      localHashMap.put("download", ((MailBigAttach)localObject).getPreview().getDownloadUrl());
      localHashMap.put("name", ((MailBigAttach)localObject).getName());
      Date localDate = ((MailBigAttach)localObject).getExpire();
      localObject = "";
      if (localDate != null) {
        localObject = DateExtension.fullDateName_yyyyMMddHHmm(localDate);
      }
      localHashMap.put("expire", localObject);
      localHashMap.put("expireTime", FtnCommonUtils.generateExpireTime(localDate));
      str1 = str1 + StringExtention.replaceWithDictionary(str3, localHashMap);
      i += 1;
    }
    return StringExtention.replace(str2, "content", str1);
  }
  
  public static boolean getNeedUpdate()
  {
    return true;
  }
  
  @Nullable
  public static NoteManager getSharedInstance()
  {
    QQMailAccount localQQMailAccount = AccountManager.shareInstance().getAccountList().getDefaultNoteAccount();
    if (localQQMailAccount == null) {
      return null;
    }
    if ((_instance == null) || (_instance.mCurAccountId != localQQMailAccount.getId())) {}
    try
    {
      if ((_instance == null) || (_instance.mCurAccountId != localQQMailAccount.getId())) {
        _instance = new NoteManager(QMApplicationContext.sharedInstance(), localQQMailAccount);
      }
      return _instance;
    }
    finally {}
  }
  
  /* Error */
  private QMNNoteCategory parseAddNoteCatalogResponse(String paramString, QMNetworkResponse paramQMNetworkResponse)
  {
    // Byte code:
    //   0: iconst_3
    //   1: ldc 47
    //   3: aload_2
    //   4: invokevirtual 539	com/tencent/qqmail/utilities/qmnetwork/QMNetworkResponse:toString	()Ljava/lang/String;
    //   7: invokestatic 441	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   10: aload_2
    //   11: invokevirtual 291	com/tencent/qqmail/utilities/qmnetwork/QMNetworkResponse:getResponseJson	()Ljava/lang/Object;
    //   14: checkcast 293	com/alibaba/fastjson/JSONObject
    //   17: astore_2
    //   18: new 541	com/tencent/qqmail/model/qmdomain/QMNNoteCategory
    //   21: dup
    //   22: aload_2
    //   23: ldc_w 543
    //   26: invokevirtual 546	com/alibaba/fastjson/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   29: aload_1
    //   30: aload_0
    //   31: invokevirtual 550	com/tencent/qqmail/model/NoteManager:readAllCategory	()Ljava/util/ArrayList;
    //   34: invokevirtual 133	java/util/ArrayList:size	()I
    //   37: iconst_1
    //   38: isub
    //   39: invokespecial 553	com/tencent/qqmail/model/qmdomain/QMNNoteCategory:<init>	(Ljava/lang/String;Ljava/lang/String;I)V
    //   42: astore_1
    //   43: aload_0
    //   44: getfield 119	com/tencent/qqmail/model/NoteManager:noteCache	Lcom/tencent/qqmail/model/NoteCache;
    //   47: aload_1
    //   48: invokevirtual 557	com/tencent/qqmail/model/NoteCache:saveNoteCategory	(Lcom/tencent/qqmail/model/qmdomain/QMNNoteCategory;)Z
    //   51: pop
    //   52: aload_1
    //   53: areturn
    //   54: astore_2
    //   55: aconst_null
    //   56: astore_1
    //   57: bipush 6
    //   59: ldc 47
    //   61: aload_2
    //   62: invokevirtual 560	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   65: invokestatic 441	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   68: aload_1
    //   69: areturn
    //   70: astore_2
    //   71: goto -14 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	NoteManager
    //   0	74	1	paramString	String
    //   0	74	2	paramQMNetworkResponse	QMNetworkResponse
    // Exception table:
    //   from	to	target	type
    //   18	43	54	java/lang/Exception
    //   43	52	70	java/lang/Exception
  }
  
  public static QMNNote parseNoteList(JSONObject paramJSONObject)
  {
    try
    {
      Object localObject1 = paramJSONObject.getJSONArray("nts");
      if ((localObject1 == null) || (((JSONArray)localObject1).size() <= 0)) {
        break label125;
      }
      paramJSONObject = new ArrayList(1);
      localObject1 = ((JSONArray)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = ((Iterator)localObject1).next();
        QMNNote localQMNNote = new QMNNote();
        localQMNNote.parseWithDictionary((JSONObject)localObject3);
        paramJSONObject.add(localQMNNote);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(6, "NoteManager", "parseNoteList error1! " + paramJSONObject.toString(), localException);
        Object localObject2 = null;
      }
    }
    return (QMNNote)paramJSONObject.get(0);
    label125:
    QMLog.log(6, "NoteManager", "parseNoteList error2! " + paramJSONObject.toString());
    return null;
  }
  
  private NoteUI searchNote(String paramString, List<String> paramList)
  {
    paramString = this.noteCache.searchNoteIdWithKey(paramString);
    ArrayList localArrayList = Lists.newArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("searchNote svrIds:");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (paramString.indexOf(str) == -1)
      {
        localArrayList.add(str);
        localStringBuilder.append(str).append(";");
      }
    }
    QMLog.log(3, "NoteManager", localStringBuilder.toString());
    return this.noteCache.readNoteUIByMergeIds(paramString, localArrayList);
  }
  
  private void setExpired()
  {
    bindWatcher(false);
  }
  
  public static NoteManager sharedInstance()
  {
    return getSharedInstance();
  }
  
  public void _loadSendConflictArraySuccess(QMNetworkResponse paramQMNetworkResponse, MailListOption paramMailListOption, MailManagerDelegate paramMailManagerDelegate)
  {
    paramMailListOption = (JSONObject)paramQMNetworkResponse.getResponseJson();
    if (paramMailManagerDelegate != null)
    {
      paramQMNetworkResponse = new HashMap();
      paramMailListOption = paramMailListOption.entrySet().iterator();
      while (paramMailListOption.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMailListOption.next();
        paramQMNetworkResponse.put(localEntry.getKey(), localEntry.getValue());
      }
      paramMailManagerDelegate.handleSuccess(null, paramQMNetworkResponse);
    }
  }
  
  public QMNNote _readNoteDataNeedContent(String paramString)
  {
    return this.noteCache.readNoteDataNeedContent(paramString);
  }
  
  public void addIdMapping(String paramString1, String paramString2, String paramString3)
  {
    this.mIdSeqMaps.put(paramString1, paramString2 + "___" + paramString3);
  }
  
  public void addNoteCatalog(String paramString, MailManagerDelegate paramMailManagerDelegate)
  {
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new NoteManager.27(this, paramString, paramMailManagerDelegate));
    localQMCallback.setOnError(new NoteManager.28(this, paramMailManagerDelegate));
    paramMailManagerDelegate = null;
    try
    {
      paramString = StringExtention.urlEncode(paramString);
      paramString = "t=note_data.json&s=mgr" + StringExtention.replace("&fun=new&name=$name$", "name", paramString);
      CGIManager.httpGet(this.mCurAccountId, "catalog_mgr", paramString, localQMCallback);
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = paramMailManagerDelegate;
      }
    }
  }
  
  public void changeDefaultCatalog(String paramString, MailManagerDelegate paramMailManagerDelegate)
  {
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new NoteManager.29(this, paramString, paramMailManagerDelegate));
    localQMCallback.setOnError(new NoteManager.30(this, paramMailManagerDelegate));
    paramString = "t=note_data.json&s=mgr" + StringExtention.replace("&fun=setdefaultid&catid=$catid$", "catid", paramString);
    CGIManager.httpGet(this.mCurAccountId, "catalog_mgr", paramString, localQMCallback);
  }
  
  public String collectInfoFromNote(QMComposeNote paramQMComposeNote)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    HashMap localHashMap = new HashMap();
    if (paramQMComposeNote.content != null) {
      localStringBuilder.append(paramQMComposeNote.content);
    }
    if ((paramQMComposeNote.bigAttachList != null) && (paramQMComposeNote.bigAttachList.size() != 0))
    {
      localObject1 = formatBigAttachs((ArrayList)paramQMComposeNote.bigAttachList);
      localStringBuilder.append("<br/>").append((String)localObject1);
    }
    Object localObject1 = new StringBuilder();
    Object localObject2;
    if ((paramQMComposeNote.attachList.attachListInfo != null) && (paramQMComposeNote.attachList.attachListInfo.size() > 0))
    {
      localObject2 = paramQMComposeNote.attachList.attachListInfo.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ((StringBuilder)localObject1).append(((Attach)((Iterator)localObject2).next()).getName());
        ((StringBuilder)localObject1).append("|");
      }
      if (((StringBuilder)localObject1).length() > 1) {
        ((StringBuilder)localObject1).delete(((StringBuilder)localObject1).length() - 1, ((StringBuilder)localObject1).length());
      }
    }
    localHashMap.put("attLst", ((StringBuilder)localObject1).toString());
    if (paramQMComposeNote.status.starred)
    {
      localObject1 = "1";
      localHashMap.put("star", localObject1);
      localHashMap.put("catid", paramQMComposeNote.information.category.getCatalogId());
      localHashMap.put("createtime", String.format("%f", new Object[] { Double.valueOf(paramQMComposeNote.status.createUTC) }));
      localHashMap.put("modifytime", String.format("%f", new Object[] { Double.valueOf(paramQMComposeNote.status.updateUTC) }));
      QMLog.log(3, "NoteManager", "conflict send1 noteId:" + paramQMComposeNote.information.noteId + " status:" + paramQMComposeNote.status.status);
      localObject1 = paramQMComposeNote.information.noteId;
      localObject2 = getIdMapping((String)localObject1);
      QMLog.log(3, "NoteManager", "conflict replaceId onsending local:" + (String)localObject1 + " cache:" + (String)localObject2);
      if ((localObject2 == null) || (!((String)localObject2).contains("___"))) {
        break label640;
      }
      QMLog.log(3, "NoteManager", "conflict yes replace");
      localObject1 = localObject2.split("___")[0];
      QMLog.log(3, "NoteManager", "conflict3 onsending replace local id:" + paramQMComposeNote.information.noteId + " newid:" + (String)localObject1);
      localHashMap.put("update", String.format("%f", new Object[] { Double.valueOf(this.noteCache.getSeq((String)localObject1)) }));
      localHashMap.put("noteid", localObject1);
      label513:
      QMLog.log(3, "NoteManager", "conflict send noteId:" + (String)localHashMap.get("noteid") + " seq:" + (String)localHashMap.get("update") + " map:" + localHashMap.toString());
      if ("".equals(paramQMComposeNote.information.subject)) {
        break label744;
      }
      localHashMap.put("subject", paramQMComposeNote.information.subject);
    }
    for (;;)
    {
      localHashMap.put("content", localStringBuilder.toString());
      return _getNoteSendParamEncodeURI(localHashMap, true);
      localObject1 = "0";
      break;
      label640:
      QMLog.log(3, "NoteManager", "conflict no noneedreplace");
      localHashMap.put("update", String.format("%f", new Object[] { Double.valueOf(this.noteCache.getSeq(paramQMComposeNote.information.noteId)) }));
      if ("".equals(paramQMComposeNote.information.noteId)) {
        break label513;
      }
      if (paramQMComposeNote.status.status == 2)
      {
        localHashMap.put("noteid", paramQMComposeNote.information.noteId);
        break label513;
      }
      localHashMap.put("noteid", "");
      break label513;
      label744:
      localHashMap.put("subject", "");
    }
  }
  
  public boolean delLocalNotes(List<String> paramList)
  {
    paramList = paramList.iterator();
    boolean bool = true;
    if (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((bool) && (this.noteCache.deleteUnsendNote(str))) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    return bool;
  }
  
  public boolean deleteDatabase()
  {
    boolean bool = this.noteCache.deleteDatabase();
    _instance = null;
    return bool;
  }
  
  public void deleteNotesWithNotification(List<String> paramList, NoteListActivity.NoteDeleteCallback paramNoteDeleteCallback)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    QMLog.log(4, "NoteManager", "deleteNotesWithNotification:" + Arrays.toString(paramList.toArray()));
    paramList = filterNote(paramList);
    Object localObject = (List)paramList.get("LOCALS");
    paramList = (List)paramList.get("CLOUDS");
    this.noteCache.saveNotesStatus(9, paramList);
    delLocalNotes((List)localObject);
    if (paramNoteDeleteCallback == null) {
      QMNotification.postNotification("NOTE_LIST_DELETE_DONE", null);
    }
    QMNotification.postNotification("N_NOTEDELETE_SUCC", null);
    localObject = "ef=js&t=note_mgr.json&opr=del&catid=$catid$&error=app&f=xhtml" + _getNoteIdParams(paramList);
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new NoteManager.21(this, paramList, paramNoteDeleteCallback));
    localQMCallback.setOnError(new NoteManager.22(this));
    localQMCallback.setOnComplete(new NoteManager.23(this));
    CGIManager.httpPost(this.mCurAccountId, "note_mgr", (String)localObject, localQMCallback);
  }
  
  public boolean deleteUnsendNote(String paramString)
  {
    return this.noteCache.deleteUnsendNote(paramString);
  }
  
  public String findCategoryNameByCid(String paramString)
  {
    return this.noteCache.findCategoryNameByCid(paramString);
  }
  
  public boolean fixNoteData()
  {
    return this.noteCache.fixNoteData();
  }
  
  public void getCatalogList(MailManagerDelegate paramMailManagerDelegate)
  {
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new NoteManager.31(this, paramMailManagerDelegate));
    localQMCallback.setOnError(new NoteManager.32(this, paramMailManagerDelegate));
    localQMCallback.setOnComplete(new NoteManager.33(this, paramMailManagerDelegate));
    CGIManager.httpGet(this.mCurAccountId, "cataloglist", "t=cataloglist.json", localQMCallback);
  }
  
  public String getIdMapping(String paramString)
  {
    if (this.mIdSeqMaps.containsKey(paramString)) {
      return (String)this.mIdSeqMaps.get(paramString);
    }
    return "";
  }
  
  public NoteUI getLastSearchNoteUI()
  {
    return this.noteCache.readNoteUIByNoteids(this.mSearchIds);
  }
  
  public NoteCache getNoteCache()
  {
    return this.noteCache;
  }
  
  public QMNoteTask getNoteTask()
  {
    return QMNoteTask.sharedInstance();
  }
  
  public NoteUI getSearchCategoryNoteList(String paramString)
  {
    paramString = this.noteCache.readNoteUIByCategoryId(paramString);
    this.mSearchIds.clear();
    if (paramString != null)
    {
      int i = 0;
      while (i < paramString.size())
      {
        paramString.moveToPosition(i);
        this.mSearchIds.add(paramString.getNoteId());
        i += 1;
      }
    }
    return paramString;
  }
  
  public double getSeq(String paramString)
  {
    return this.noteCache.getSeq(paramString);
  }
  
  public String getThumbUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ValidateHelper.assertInDebug("", false);
      return "";
    }
    paramString = Pattern.compile("<img[^<>]*?src=[\"']?[^\"']?(https?:[^'\"]*?cgi-bin/attdownload[^\"]*|file://[^\"]*?composemail_\\d+[^\"]*)").matcher(paramString);
    if (paramString.find())
    {
      String str = paramString.group(1);
      if (str.contains("&mode=0"))
      {
        str.replace("&mode=0", "&mode=1");
        paramString = str;
      }
      for (;;)
      {
        return paramString.replace("file://localhost/", "file:///");
        if (str.contains("?"))
        {
          paramString = str + "&mode=1";
        }
        else
        {
          paramString = str;
          if (str.indexOf("file:/") != 0) {
            paramString = str + "?mode=1";
          }
        }
      }
    }
    return "";
  }
  
  public String isAudio(String paramString)
  {
    if (paramString == null) {
      return "0";
    }
    if (Pattern.compile("<audio[^<>]*?>[^<>]*?</audio>").matcher(paramString).find()) {
      return "1";
    }
    return "0";
  }
  
  public void loadNoteList()
  {
    long l = System.currentTimeMillis();
    if (l - mLastLoadNoteListTime < 5000L)
    {
      QMNotification.postNotification("NOTE_LIST_UPDATE", "network");
      return;
    }
    mLastLoadNoteListTime = l;
    List localList = this.noteCache.getPendingDeleteIds();
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (localList != null)
    {
      localObject1 = localObject2;
      if (localList.size() > 0) {
        localObject1 = "" + "&delete=" + StringUtils.join(localList, ",");
      }
    }
    boolean bool = false;
    localObject2 = new QMCallback();
    ((QMCallback)localObject2).setOnError(new NoteManager.9(this));
    ((QMCallback)localObject2).setOnSuccess(new NoteManager.10(this, localList));
    if (!this.noteCache.isNoteDatabaseEmpty())
    {
      QMNotification.postNotification("NOTE_LIST_UPDATE", null);
      bool = true;
    }
    localObject1 = _noteListSynURL(bool) + (String)localObject1;
    CGIManager.httpPost(this.mCurAccountId, "note_sync", (String)localObject1, (QMCallback)localObject2);
  }
  
  public void loadNoteWithNotification(HashMap<String, String> paramHashMap)
  {
    Object localObject1 = (String)paramHashMap.get("NoteId");
    paramHashMap = (String)paramHashMap.get("fromNetwork");
    Object localObject2 = readNoteDataNeedContent((String)localObject1);
    if ((localObject2 != null) && (((QMNNote)localObject2).content != null))
    {
      localObject1 = Maps.newHashMap();
      if (StringUtils.equals(paramHashMap, "true")) {
        ((HashMap)localObject1).put("fromNetwork", paramHashMap);
      }
      ((HashMap)localObject1).put("data", localObject2);
      QMNotification.postNotification("N_LOADNOTE_SUCC", localObject1);
      return;
    }
    QMNotification.postNotification("N_LOADNOTE_PREFETCH", this.noteCache.readPrefetchNoteData((String)localObject1));
    localObject2 = new QMCallback();
    ((QMCallback)localObject2).setOnBeforeSend(new NoteManager.15(this));
    ((QMCallback)localObject2).setOnComplete(new NoteManager.16(this));
    ((QMCallback)localObject2).setOnSuccess(new NoteManager.17(this, (String)localObject1, paramHashMap));
    ((QMCallback)localObject2).setOnError(new NoteManager.18(this, (String)localObject1));
    paramHashMap = String.format("%s%s&noteid=%s", new Object[] { "ef=js&t=note_data.json", "&s=read", localObject1 });
    CGIManager.httpGet(this.mCurAccountId, "read_note", paramHashMap, (QMCallback)localObject2);
  }
  
  public void loadSendConflictArray(String paramString, MailOption paramMailOption, MailManagerDelegate paramMailManagerDelegate)
  {
    paramMailOption = new QMCallback();
    paramMailOption.setOnComplete(new NoteManager.6(this, paramMailManagerDelegate));
    paramMailOption.setOnSuccess(new NoteManager.7(this, paramMailManagerDelegate));
    paramMailOption.setOnError(new NoteManager.8(this, paramMailManagerDelegate));
    paramString = detectConflictParam(paramString);
    QMLog.log(3, "NoteManager", "conflict param:" + paramString);
    CGIManager.httpPost(this.mCurAccountId, "note_sync", paramString, paramMailOption);
  }
  
  public boolean moveLocalNotes(List<String> paramList, String paramString)
  {
    return this.noteCache.moveUnsendNotes(paramList, paramString);
  }
  
  public void moveNotesWithNotifications(List<String> paramList, String paramString)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    Object localObject1 = filterNote(paramList);
    Object localObject2 = (List)((Map)localObject1).get("LOCALS");
    localObject1 = (List)((Map)localObject1).get("CLOUDS");
    this.noteCache.moveNotes((List)localObject1, paramString);
    moveLocalNotes((List)localObject2, paramString);
    QMNotification.postNotification("N_MOVENOTE_SUCC", null);
    localObject2 = StringExtention.replaceWithEncodeURIValue("ef=js&t=note_mgr.json&opr=move&destcatid=$destcatid$&error=app&f=xhtml", "destcatid", paramString);
    localObject2 = (String)localObject2 + _getNoteIdParams((List)localObject1);
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new NoteManager.19(this, paramString, paramList));
    localQMCallback.setOnError(new NoteManager.20(this, (List)localObject1, paramString));
    CGIManager.httpPost(this.mCurAccountId, "note_mgr", (String)localObject2, localQMCallback);
  }
  
  public ArrayList<QMComposeNote> newAddedAllUnsendNotes()
  {
    try
    {
      ArrayList localArrayList = this.noteCache.newAddedAllUnsendNotes();
      return localArrayList;
    }
    finally {}
  }
  
  public void onTerminate()
  {
    this.noteCache.terminate();
  }
  
  protected void parseAndSaveNewSeq(QMNetworkResponse paramQMNetworkResponse)
  {
    QMLog.log(3, "NoteManager", paramQMNetworkResponse.toString());
    paramQMNetworkResponse = (JSONObject)paramQMNetworkResponse.getResponseJson();
    if (StringExtention.containInheritKey(paramQMNetworkResponse, new String[] { "notes" })) {
      try
      {
        paramQMNetworkResponse = paramQMNetworkResponse.getJSONArray("notes").iterator();
        while (paramQMNetworkResponse.hasNext())
        {
          Object localObject = (JSONObject)paramQMNetworkResponse.next();
          String str = ((JSONObject)localObject).getString("noteid");
          localObject = ((JSONObject)localObject).getString("sequence");
          QMLog.log(3, "NoteManager", "conflict parse noteId:" + str + " seq:" + (String)localObject);
          setSeq(str, Double.parseDouble((String)localObject));
        }
        return;
      }
      catch (Exception paramQMNetworkResponse) {}
    }
  }
  
  protected void postSearch(QMNetworkResponse paramQMNetworkResponse, String paramString)
  {
    paramQMNetworkResponse = (JSONObject)paramQMNetworkResponse.getResponseJson();
    try
    {
      paramQMNetworkResponse = paramQMNetworkResponse.getJSONArray("nts");
      this.mSearchIds.clear();
      if ((paramQMNetworkResponse != null) && (paramQMNetworkResponse.size() > 0))
      {
        paramQMNetworkResponse = paramQMNetworkResponse.iterator();
        while (paramQMNetworkResponse.hasNext())
        {
          QMNNote localQMNNote = (QMNNote)QMNNote.fromDictionary((JSONObject)paramQMNetworkResponse.next(), new QMNNote());
          if (localQMNNote != null) {
            this.mSearchIds.add(localQMNNote.information.noteId);
          }
        }
      }
    }
    catch (Exception paramQMNetworkResponse)
    {
      for (;;)
      {
        QMLog.log(6, "NoteManager", "search json parse error");
        paramQMNetworkResponse = null;
      }
      paramQMNetworkResponse = new HashMap();
      paramQMNetworkResponse.put("keyword", paramString);
      QMNotification.postNotification("searchnote_succ", paramQMNetworkResponse);
    }
  }
  
  protected void preSearch()
  {
    if (this.mSearchIds != null)
    {
      this.mSearchIds.clear();
      return;
    }
    this.mSearchIds = new ArrayList();
  }
  
  protected void purgeNoteIds(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      this.noteCache.deleteNotes(paramList);
    }
  }
  
  public ArrayList<QMNNoteCategory> readAllCategory()
  {
    return this.noteCache.readAllCategory();
  }
  
  public ArrayList<String> readAllUnsendNote()
  {
    return this.noteCache.readAllUnsendNote();
  }
  
  public QMNNote readNoteData(String paramString)
  {
    return this.noteCache.readNoteData(paramString);
  }
  
  public QMNNote readNoteDataNeedContent(String paramString)
  {
    return _readNoteDataNeedContent(paramString);
  }
  
  public NoteUI readNoteUIByCategoryId(String paramString)
  {
    return this.noteCache.readNoteUIByCategoryId(paramString);
  }
  
  public QMComposeNote readUnsendNote(String paramString)
  {
    return this.noteCache.readUnsendNote(paramString);
  }
  
  public QMNNote replaceLocalNote(JSONObject paramJSONObject)
  {
    return this.noteCache.replaceLocalNote(paramJSONObject);
  }
  
  public boolean saveUnsendNote(QMComposeNote paramQMComposeNote)
  {
    this.noteCache.saveUnsendNote(paramQMComposeNote);
    return true;
  }
  
  public NoteUI searchNote(String paramString)
  {
    NoteUI localNoteUI = this.noteCache.searchNoteWithCallback(paramString);
    QMLog.log(3, "NoteManager", "searchNote key:" + paramString + " size:" + localNoteUI.size());
    return localNoteUI;
  }
  
  public void searchNoteWithNotifications(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    String str = String.format("%s%s%s", new Object[] { "ef=js&t=note_data.json", "&s=sync&sync=1", "&keyword=" + StringExtention.encodeURI(paramString) });
    QMCallback localQMCallback = new QMCallback();
    preSearch();
    localQMCallback.setOnSuccess(new NoteManager.24(this, paramString));
    localQMCallback.setOnError(new NoteManager.25(this));
    localQMCallback.setOnBeforeSend(new NoteManager.26(this));
    CGIManager.httpPost(this.mCurAccountId, "note_sync", str, localQMCallback);
  }
  
  public NoteUI searchNoteWithServerResult(String paramString)
  {
    return searchNote(paramString, this.mSearchIds);
  }
  
  public QMNetworkRequest sendNoteWithCallback(QMComposeNote paramQMComposeNote, MailManagerDelegate paramMailManagerDelegate)
  {
    if (paramMailManagerDelegate != null) {
      paramMailManagerDelegate.handleBeforeSend(null);
    }
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new NoteManager.2(this, paramMailManagerDelegate));
    localQMCallback.setOnError(new NoteManager.3(this, paramMailManagerDelegate));
    localQMCallback.setOnComplete(new NoteManager.4(this, paramMailManagerDelegate));
    localQMCallback.setOnSendData(new NoteManager.5(this, paramMailManagerDelegate));
    paramMailManagerDelegate = collectInfoFromNote(paramQMComposeNote);
    List localList = paramQMComposeNote.getContentEntities();
    QMLog.log(4, "NoteManager", "size of fileentity : " + localList.size());
    if (localList.size() > 0)
    {
      int i = this.mCurAccountId;
      StringBuilder localStringBuilder = new StringBuilder();
      if (QMSettingManager.sharedInstance().isEnableHttpsDomain()) {}
      for (paramQMComposeNote = QMNetworkConfig.getCgiRequestHostHttps(this.mCurAccountId);; paramQMComposeNote = QMNetworkConfig.getCgiRequestHost(this.mCurAccountId))
      {
        paramQMComposeNote = new CGIRequest(i, paramQMComposeNote + "/cgi-bin/" + "note_edit", QMNetworkRequest.QMHttpMethod.QMHttpMethod_MULTIPART);
        paramQMComposeNote.setFileParams(localList);
        paramQMComposeNote.setRequestParams(paramMailManagerDelegate);
        paramQMComposeNote.setRequestCallback(CGIManager.wrapCGICallback(localQMCallback));
        NetworkManager.sharedInstance().sendRequest(paramQMComposeNote);
        return paramQMComposeNote;
      }
    }
    return CGIManager.httpPost(this.mCurAccountId, "note_edit", paramMailManagerDelegate, localQMCallback);
  }
  
  public boolean setSeq(String paramString, double paramDouble)
  {
    return this.noteCache.setSeq(paramString, paramDouble);
  }
  
  public void starLocalNotes(List<String> paramList, boolean paramBoolean)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      QMComposeNote localQMComposeNote = readUnsendNote((String)paramList.next());
      if ((localQMComposeNote != null) && (localQMComposeNote.status != null))
      {
        localQMComposeNote.status.starred = paramBoolean;
        this.noteCache.saveUnsendNote(localQMComposeNote);
      }
    }
  }
  
  public void starNoteWithNotification(String paramString, boolean paramBoolean)
  {
    if (paramString != null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramString);
      starNotesWithNotification(localArrayList, paramBoolean);
    }
  }
  
  public void starNotesWithNotification(List<String> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    Object localObject = filterNote(paramList);
    paramList = (List)((Map)localObject).get("LOCALS");
    localObject = (List)((Map)localObject).get("CLOUDS");
    this.noteCache.starNotes((List)localObject, paramBoolean);
    starLocalNotes(paramList, paramBoolean);
    QMNotification.postNotification("NOTE_LIST_UPDATE", null);
    paramList = new HashMap();
    paramList.put("star", Boolean.valueOf(paramBoolean));
    QMNotification.postNotification("N_STARNOTE_SUCC", paramList);
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnBeforeSend(new NoteManager.11(this));
    localQMCallback.setOnComplete(new NoteManager.12(this));
    localQMCallback.setOnSuccess(new NoteManager.13(this));
    localQMCallback.setOnError(new NoteManager.14(this, (List)localObject, paramBoolean));
    if (paramBoolean) {}
    for (paramList = "1";; paramList = "0")
    {
      paramList = String.format("%s%s", new Object[] { "ef=js&t=note_mgr.json", StringExtention.replace("&opr=star&flag=$flag$", "flag", paramList) });
      paramList = paramList + _getNoteIdParams((List)localObject);
      CGIManager.httpGet(this.mCurAccountId, "note_mgr", paramList, localQMCallback);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.NoteManager
 * JD-Core Version:    0.7.0.1
 */