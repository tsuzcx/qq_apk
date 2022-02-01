package com.tencent.qqmail.card;

import android.util.Log;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.card.cursor.QMBirthdayFriendListCursor;
import com.tencent.qqmail.card.cursor.QMCardListCursor;
import com.tencent.qqmail.card.cursor.QMCardThanksFriendListCursor;
import com.tencent.qqmail.card.model.QMCardData;
import com.tencent.qqmail.card.model.QMCardFriendInfo;
import com.tencent.qqmail.card.model.QMCardPara;
import com.tencent.qqmail.card.model.QMCardType;
import com.tencent.qqmail.card.util.CardUtil;
import com.tencent.qqmail.model.MailManagerDefines;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.businessfilter.card.BirthdayCardFilter;
import com.tencent.qqmail.popularize.businessfilter.card.CardFilter;
import com.tencent.qqmail.popularize.businessfilter.card.CardRedPointFilter;
import com.tencent.qqmail.popularize.businessfilter.card.FestivalCardFilter;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.model.PopularizeSubItem;
import com.tencent.qqmail.popularize.view.PopularizeUIHelper;
import com.tencent.qqmail.protobuf.ByteString;
import com.tencent.qqmail.protocol.CloudProtocolHelper;
import com.tencent.qqmail.protocol.CloudProtocolInfo;
import com.tencent.qqmail.protocol.CloudProtocolService;
import com.tencent.qqmail.protocol.UMA.AckCardReq;
import com.tencent.qqmail.protocol.UMA.BatchGetCardsReq;
import com.tencent.qqmail.protocol.UMA.CardData;
import com.tencent.qqmail.protocol.UMA.GetCardListReq;
import com.tencent.qqmail.protocol.UMA.GetThanksListReq;
import com.tencent.qqmail.protocol.UMA.SaveCardReq;
import com.tencent.qqmail.protocol.UMA.SyncCardReq;
import com.tencent.qqmail.trd.guava.Maps;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.CGIManager;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMHttpUtil;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest.QMHttpMethod;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class QMCardManager
{
  public static final double DELTA = 1.0E-006D;
  private static final String JSON_ADDR = "addr";
  private static final String JSON_LIST = "list";
  private static final String JSON_NICK = "nick";
  private static final String JSON_UIN = "uin";
  private static final long ONE_WEEK_TIME_MILL = 604800000L;
  private static final String PARAM_NUM = "num";
  private static final String TAG = "QMCardManager";
  public static final int TYPE_ID_ALL = -1;
  private static HashMap<String, ArrayList<String>> thanksFriendIconCache = ;
  private QMCardSQLiteHelper mSqLiteHelper;
  
  private QMCardManager(QMCardSQLiteHelper paramQMCardSQLiteHelper)
  {
    this.mSqLiteHelper = paramQMCardSQLiteHelper;
  }
  
  private void logDataPB(CardData paramCardData, int paramInt)
  {
    Log.d("QMCardManager", String.format("synccardlist: add_list id[%s], type[%d], name[%s], pics[%d], url[%s], viewcount[%d], thankscount[%d], iscomplete[%b], cardpara_size[%d], priority[%f], tag[%s], mailtitle[%s], mailword[%s], sharetitle[%s], shareword[%s]pagetype[%d], friendnum[%d]friendtype[%d], seqtype[%d]wxsharelimit[%b], qqsharelimit[%b]", new Object[] { paramCardData.cardid.toString(), Integer.valueOf(paramInt), paramCardData.cardname.toString(), Integer.valueOf(paramCardData.pictures.size()), paramCardData.cardurl.toString(), Integer.valueOf(paramCardData.viewcount), Integer.valueOf(paramCardData.thankscount), Boolean.valueOf(paramCardData.iscomplete), Integer.valueOf(paramCardData.cardpara.size()), Double.valueOf(paramCardData.priority), paramCardData.cardtag.toString(), paramCardData.mailtitle.toString(), paramCardData.mailword.toString(), paramCardData.sharetitle.toString(), paramCardData.shareword.toString(), Integer.valueOf(paramCardData.pagetype), Integer.valueOf(paramCardData.friendnum), Integer.valueOf(paramCardData.friendtype), Integer.valueOf(paramCardData.seqtype), Boolean.valueOf(paramCardData.wxsharelimit), Boolean.valueOf(paramCardData.qqsharelimit) }));
  }
  
  public static QMCardManager shareInstance()
  {
    return SingleTon._instance;
  }
  
  public void batchSyncCardByCardIds(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      QMLog.log(6, "QMCardManager", "batch sync card list empty");
      return;
    }
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    Object localObject = paramArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add((String)((Iterator)localObject).next());
    }
    localObject = this.mSqLiteHelper.queryExistCardDataByCardIds(this.mSqLiteHelper.getReadableDatabase(), paramArrayList);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.remove((String)((Iterator)localObject).next());
      }
    }
    if (localArrayList.size() == 0)
    {
      QMWatcherCenter.triggerBatchLoadCardListSuccess(paramArrayList);
      return;
    }
    localObject = CloudProtocolHelper.getCommonInfo();
    if (localObject == null)
    {
      QMLog.log(6, "QMCardManager", "batch sync card null");
      return;
    }
    BatchGetCardsReq localBatchGetCardsReq = new BatchGetCardsReq();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext()) {
      localLinkedList.add(new ByteString(((String)localIterator.next()).getBytes()));
    }
    localBatchGetCardsReq.cardid = localLinkedList;
    ((CloudProtocolInfo)localObject).get_cards_req_ = localBatchGetCardsReq;
    QMWatcherCenter.triggerBatchLoadCardListBefore();
    CloudProtocolService.GetGreetingCards((CloudProtocolInfo)localObject, new QMCardManager.2(this, localArrayList, paramArrayList));
  }
  
  public void clearBirthdayShouldShow()
  {
    CardUtil.setBirthdayRedDotClick(0L);
    Object localObject1 = PopularizeManager.sharedInstance().getPopularizeByType(6);
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      localObject1 = (Popularize)((ArrayList)localObject1).get(0);
      PopularizeManager.sharedInstance().updatePopularizeCancel(((Popularize)localObject1).getId(), false);
      Object localObject2 = PopularizeUIHelper.getAllPopularizeSubItems(((Popularize)localObject1).getId());
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          PopularizeSubItem localPopularizeSubItem = (PopularizeSubItem)((Iterator)localObject2).next();
          PopularizeManager.sharedInstance().updatePopularizeSubItemCancel(((Popularize)localObject1).getId(), localPopularizeSubItem.getId(), false);
        }
      }
    }
  }
  
  public void clearCardCache()
  {
    deleteAllCardDatas();
    clearThanksFriendCahce();
  }
  
  public void clearThanksFriendCahce()
  {
    thanksFriendIconCache.clear();
  }
  
  public void deleteAllBirthdayFriends()
  {
    this.mSqLiteHelper.deleteAllBirthdayFriend(this.mSqLiteHelper.getWritableDatabase());
    QMLog.log(4, "QMCardManager", "delete all birthdayFriends");
  }
  
  public void deleteAllCardDatas()
  {
    this.mSqLiteHelper.deleteAllCardData(this.mSqLiteHelper.getWritableDatabase());
    QMLog.log(4, "QMCardManager", "delete all cardDatas");
  }
  
  public void deleteAllCardTypes()
  {
    this.mSqLiteHelper.deleteAllCardType(this.mSqLiteHelper.getWritableDatabase());
    QMLog.log(4, "QMCardManager", "delete all cardTypes");
  }
  
  public void deleteMyCard(String paramString)
  {
    if (StringExtention.isNullOrEmpty(paramString)) {
      return;
    }
    Object localObject = this.mSqLiteHelper.queryCardTypesByCardId(this.mSqLiteHelper.getReadableDatabase(), paramString);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0) && ((((ArrayList)localObject).size() > 1) || (((Integer)((ArrayList)localObject).get(0)).intValue() != 1)))
    {
      QMLog.log(6, "QMCardManager", "delete not only myself");
      return;
    }
    this.mSqLiteHelper.deleteCardDataById(this.mSqLiteHelper.getWritableDatabase(), paramString);
    this.mSqLiteHelper.deleteCardDataType(this.mSqLiteHelper.getWritableDatabase(), paramString, 1);
    thanksFriendIconCache.remove(paramString);
    QMLog.log(4, "QMCardManager", "delete card cardId: " + paramString);
    localObject = CloudProtocolHelper.getCommonInfo();
    if (localObject == null)
    {
      QMLog.log(6, "QMCardManager", "delete card info null");
      return;
    }
    ((CloudProtocolInfo)localObject).delete_card_req_ = paramString;
    CloudProtocolService.DeleteGreetingCard((CloudProtocolInfo)localObject, new QMCardManager.7(this, paramString));
  }
  
  public ArrayList<QMCardType> getAllCardTypeList()
  {
    return this.mSqLiteHelper.queryAllCardType(this.mSqLiteHelper.getReadableDatabase());
  }
  
  public QMBirthdayFriendListCursor getBirthdayFriendList()
  {
    return new QMBirthdayFriendListCursor(this.mSqLiteHelper);
  }
  
  public QMCardData getCardDataByCardId(String paramString)
  {
    return this.mSqLiteHelper.queryCardDataByCardId(this.mSqLiteHelper.getReadableDatabase(), paramString);
  }
  
  public String getCardDataContent(String paramString)
  {
    return this.mSqLiteHelper.getCardDataContent(this.mSqLiteHelper.getReadableDatabase(), paramString);
  }
  
  public QMCardListCursor getCardListByTypeId(int paramInt)
  {
    return new QMCardListCursor(this.mSqLiteHelper, paramInt);
  }
  
  public ArrayList<QMCardPara> getCardParaListByCardId(String paramString)
  {
    return this.mSqLiteHelper.queryCardParaListByCardId(this.mSqLiteHelper.getReadableDatabase(), paramString);
  }
  
  public QMCardThanksFriendListCursor getCardThanksFriendListByCardId(String paramString)
  {
    return new QMCardThanksFriendListCursor(this.mSqLiteHelper, paramString);
  }
  
  public Account getDefaultAccount()
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getDefaultMailAccount();
    if (localAccount == null) {}
    return localAccount;
  }
  
  public int getJumpCardDefaulType()
  {
    Object localObject = PopularizeManager.sharedInstance().getPopularize(new CardFilter());
    if (((List)localObject).size() > 0) {}
    int i;
    for (localObject = (Popularize)((List)localObject).get(0);; localObject = null)
    {
      i = PopularizeUIHelper.handleCardPopularize((Popularize)localObject);
      localObject = getRedDotCarTypeList();
      if ((i != 2) && ((localObject == null) || (((ArrayList)localObject).indexOf(Integer.valueOf(2)) == -1))) {
        break;
      }
      CardUtil.setBirthdayCakeRedDot(true);
      return i;
    }
    CardUtil.setBirthdayCakeRedDot(false);
    return i;
  }
  
  public ArrayList<Integer> getRedDotCarTypeList()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = PopularizeManager.sharedInstance().getPopularize(new CardRedPointFilter());
    SparseBooleanArray localSparseBooleanArray = new SparseBooleanArray();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      switch (((Popularize)((Iterator)localObject).next()).getType())
      {
      default: 
        break;
      case 6: 
        if ((CardUtil.shouldShowBirthdayRedDot()) && (localSparseBooleanArray.indexOfKey(2) < 0))
        {
          localSparseBooleanArray.append(2, true);
          localArrayList.add(Integer.valueOf(2));
        }
        break;
      case 7: 
        if (localSparseBooleanArray.indexOfKey(3) < 0)
        {
          localSparseBooleanArray.append(3, true);
          localArrayList.add(Integer.valueOf(3));
        }
        break;
      }
    }
    return localArrayList;
  }
  
  public int getSaveCardKey(String paramString, ArrayList<QMCardPara> paramArrayList)
  {
    int i = paramString.hashCode();
    int j = i;
    if (paramArrayList != null)
    {
      j = i;
      if (paramArrayList.size() > 0)
      {
        paramString = paramArrayList.iterator();
        if (paramString.hasNext())
        {
          paramArrayList = (QMCardPara)paramString.next();
          j = i;
          if (paramArrayList.getKey() != null) {
            j = i ^ paramArrayList.getKey().hashCode();
          }
          if (paramArrayList.getValue() == null) {
            break label121;
          }
        }
      }
    }
    label121:
    for (i = paramArrayList.getValue().hashCode() ^ j;; i = j)
    {
      break;
      j = i;
      QMLog.log(4, "QMCardManager", "save card key:" + j);
      return j;
    }
  }
  
  public ArrayList<String> getThanksFriendList(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (thanksFriendIconCache.size() == 0) {
      thanksFriendIconCache = this.mSqLiteHelper.queryThanksFriendIconMap(this.mSqLiteHelper.getReadableDatabase());
    }
    if (thanksFriendIconCache.containsKey(paramString)) {
      localArrayList = (ArrayList)thanksFriendIconCache.get(paramString);
    }
    return localArrayList;
  }
  
  public void handleTypeListRedDot(int paramInt)
  {
    ArrayList localArrayList = null;
    if (paramInt == 2) {
      localArrayList = PopularizeManager.sharedInstance().getPopularize(new BirthdayCardFilter());
    }
    for (;;)
    {
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        PopularizeUIHelper.handleCardPopularize((Popularize)localArrayList.get(0));
      }
      return;
      if (paramInt == 3) {
        localArrayList = PopularizeManager.sharedInstance().getPopularize(new FestivalCardFilter());
      }
    }
  }
  
  public void insertBirthdayFriendList(ArrayList<QMCardFriendInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      QMLog.log(4, "QMCardManager", "insert birthdayFriendList:" + paramArrayList.size());
      this.mSqLiteHelper.insertBirthdayFriendList(this.mSqLiteHelper.getWritableDatabase(), paramArrayList);
      return;
    }
    QMLog.log(4, "QMCardManager", "insert cardTypeList null");
  }
  
  public void insertCardDataList(ArrayList<QMCardData> paramArrayList, int paramInt)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      QMLog.log(4, "QMCardManager", "insert cardDataList:" + paramArrayList.size());
      this.mSqLiteHelper.insertCardDataList(this.mSqLiteHelper.getWritableDatabase(), paramArrayList, paramInt);
      return;
    }
    QMLog.log(4, "QMCardManager", "insert cardDataList null");
  }
  
  public void insertCardTypeList(ArrayList<QMCardType> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      QMLog.log(4, "QMCardManager", "insert cardTypeList:" + paramArrayList.size());
      this.mSqLiteHelper.insertCardTypeList(this.mSqLiteHelper.getWritableDatabase(), paramArrayList);
      return;
    }
    QMLog.log(4, "QMCardManager", "insert cardTypeList null");
  }
  
  public void laodMoreCardList(int paramInt)
  {
    
    if (paramInt != -1) {
      throw new IllegalArgumentException("load more error: " + paramInt);
    }
  }
  
  public void loadCardDataContent(String paramString1, String paramString2)
  {
    paramString1 = new QMNetworkRequest(paramString2, QMNetworkRequest.QMHttpMethod.QMHttpMethod_GET);
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new QMCardManager.4(this, paramString2));
    localQMCallback.setOnError(new QMCardManager.5(this, paramString2));
    paramString1.setRequestCallback(localQMCallback);
    QMHttpUtil.asyncSend(paramString1);
  }
  
  public void loadQQHotFriend(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    ConcurrentHashMap localConcurrentHashMap = SharedPreferenceUtil.getCardSendContactHashMap();
    int i = paramInt2 * 2 + localConcurrentHashMap.size();
    QMLog.log(4, "QMCardManager", "loadQQHotFriend doLoadNum:" + i);
    localStringBuilder.append(StringExtention.replaceWithEncodeURIValue(MailManagerDefines.PARAM_QQHOT_FRIEND, "num", String.valueOf(i)));
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new QMCardManager.10(this, localConcurrentHashMap, paramInt1, paramInt2));
    localQMCallback.setOnError(new QMCardManager.11(this, paramInt1));
    CGIManager.httpPost(paramInt1, "get_hotfriend", localStringBuilder.toString(), localQMCallback);
  }
  
  public void saveCard(String paramString, ArrayList<QMCardPara> paramArrayList, @Nullable Account paramAccount)
  {
    if (paramAccount == null) {
      return;
    }
    Object localObject1 = new StringBuilder();
    if (paramArrayList != null)
    {
      localObject2 = paramArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (QMCardPara)((Iterator)localObject2).next();
        if (!((QMCardPara)localObject3).getKey().equals("icon")) {
          ((StringBuilder)localObject1).append(((QMCardPara)localObject3).toString()).append(";");
        }
      }
    }
    Object localObject2 = new StringBuilder().append("save card cardid: ").append(paramString).append(",cardParas:");
    if (paramArrayList != null)
    {
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(",email:");
      if (paramAccount == null) {
        break label186;
      }
    }
    label186:
    for (localObject1 = paramAccount.getEmail();; localObject1 = "null")
    {
      QMLog.log(4, "QMCardManager", (String)localObject1);
      localObject2 = CloudProtocolHelper.getCommonInfo();
      if (localObject2 != null) {
        break label194;
      }
      QMLog.log(6, "QMCardManager", "save card info null");
      return;
      localObject1 = "null";
      break;
    }
    label194:
    Object localObject3 = new SaveCardReq();
    ((SaveCardReq)localObject3).cardid = ByteString.copyFrom(paramString.getBytes());
    LinkedList localLinkedList = new LinkedList();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Iterator localIterator = paramArrayList.iterator();
      if (localIterator.hasNext())
      {
        localObject1 = (QMCardPara)localIterator.next();
        if (((QMCardPara)localObject1).getType() == 1) {}
        for (localObject1 = QMCardPara.parseTo((QMCardPara)localObject1, "");; localObject1 = QMCardPara.parseTo((QMCardPara)localObject1, null))
        {
          localLinkedList.add(localObject1);
          break;
        }
      }
    }
    ((SaveCardReq)localObject3).cardpara = localLinkedList;
    ((SaveCardReq)localObject3).email = ByteString.copyFromUtf8(paramAccount.getEmail());
    int i;
    if (paramAccount.isQQMail())
    {
      ((SaveCardReq)localObject3).uin = Long.valueOf(paramAccount.getUin()).longValue();
      if (paramAccount.isBizMail()) {
        i = 2;
      }
    }
    for (;;)
    {
      ((SaveCardReq)localObject3).type = i;
      ((CloudProtocolInfo)localObject2).save_card_req_ = ((SaveCardReq)localObject3);
      QMWatcherCenter.triggerSaveCardBefore();
      CloudProtocolService.SaveGreetingCard((CloudProtocolInfo)localObject2, new QMCardManager.6(this, (SaveCardReq)localObject3, paramString, paramArrayList));
      return;
      i = 1;
      continue;
      i = 3;
    }
  }
  
  public boolean shouldShowBirthdayCake()
  {
    int i = this.mSqLiteHelper.queryHasBirthdayFriends(this.mSqLiteHelper.getReadableDatabase(), CardUtil.getTodayZeroSec());
    QMLog.log(4, "QMCardManager", "calculate no send birth friend:" + i);
    if ((AccountManager.shareInstance().getAccountList().hasQQNotBizAccounts()) && (i > 0))
    {
      QMLog.log(4, "QMCardManager", "should show birthday cake");
      return true;
    }
    return false;
  }
  
  public void syncBirthFriendList()
  {
    CloudProtocolInfo localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    if (localCloudProtocolInfo == null)
    {
      QMLog.log(6, "QMCardManager", "get birth friend list info null");
      return;
    }
    QMWatcherCenter.triggerLoadBirthdayFriendListBefore();
    CloudProtocolService.GetBirthFriendList(localCloudProtocolInfo, new QMCardManager.8(this));
  }
  
  public void syncCardList(int paramInt)
  {
    ValidateHelper.notMainThread();
    QMLog.log(4, "QMCardManager", "sync card list typeid: " + paramInt);
    CloudProtocolInfo localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    if (localCloudProtocolInfo == null)
    {
      QMLog.log(6, "QMCardManager", "sync card list info null");
      return;
    }
    localCloudProtocolInfo.sync_card_req_ = new SyncCardReq();
    ArrayList localArrayList = this.mSqLiteHelper.queryAllCardType(this.mSqLiteHelper.getReadableDatabase());
    Iterator localIterator = localArrayList.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      QMCardType localQMCardType = (QMCardType)localIterator.next();
      if ((paramInt == -1) || (localQMCardType.getTypeId() == paramInt))
      {
        GetCardListReq localGetCardListReq = new GetCardListReq();
        localGetCardListReq.type = localQMCardType.getTypeId();
        if (localQMCardType.getSyncKey() == null) {}
        for (localObject = "";; localObject = localQMCardType.getSyncKey())
        {
          localGetCardListReq.synkey = ByteString.copyFromUtf8((String)localObject);
          localGetCardListReq.count = 100;
          localGetCardListReq.maxid = localQMCardType.getMaxId();
          localCloudProtocolInfo.sync_card_req_.syncdata.add(localGetCardListReq);
          break;
        }
      }
    }
    if ((localArrayList.size() > 0) && (paramInt != -1) && (localCloudProtocolInfo.sync_card_req_.syncdata.size() == 0))
    {
      localObject = new GetCardListReq();
      ((GetCardListReq)localObject).type = paramInt;
      ((GetCardListReq)localObject).count = 100;
      localCloudProtocolInfo.sync_card_req_.syncdata.add(localObject);
    }
    Log.d("QMCardManager", "sync card syncdata: " + localCloudProtocolInfo.sync_card_req_.syncdata.size());
    QMWatcherCenter.triggerLoadCardListBefore(paramInt);
    CloudProtocolService.SyncGreetingCardList(localCloudProtocolInfo, new QMCardManager.1(this, localArrayList, paramInt));
  }
  
  public void syncThankList(String paramString)
  {
    if (StringExtention.isNullOrEmpty(paramString))
    {
      QMLog.log(6, "QMCardManager", "sync thank list error cardId empty");
      return;
    }
    CloudProtocolInfo localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    if (localCloudProtocolInfo == null)
    {
      QMLog.log(6, "QMCardManager", "sync thank list null");
      return;
    }
    GetThanksListReq localGetThanksListReq = new GetThanksListReq();
    localGetThanksListReq.cardid = new ByteString(paramString.getBytes());
    localCloudProtocolInfo.get_thank_list_req_ = localGetThanksListReq;
    QMWatcherCenter.triggerLoadThankListBefore();
    CloudProtocolService.GetThankFriendList(localCloudProtocolInfo, new QMCardManager.3(this, paramString));
  }
  
  public void thankGreetingCard(String paramString1, long paramLong, String paramString2)
  {
    CloudProtocolInfo localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    if (localCloudProtocolInfo == null)
    {
      QMLog.log(6, "QMCardManager", "thank card info null");
      return;
    }
    AckCardReq localAckCardReq = new AckCardReq();
    localAckCardReq.cardid = new ByteString(paramString1.getBytes());
    localAckCardReq.from = 3;
    localAckCardReq.email = new ByteString(paramString2.getBytes());
    localAckCardReq.uin = paramLong;
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountByEmail(paramString2);
    if (localAccount == null)
    {
      QMLog.log(6, "QMCardManager", paramString2 + " account null");
      return;
    }
    if (localAccount.isQQMail()) {
      if (localAccount.isBizMail()) {
        localAckCardReq.type = 2;
      }
    }
    for (;;)
    {
      localCloudProtocolInfo.thank_card_req_ = localAckCardReq;
      QMWatcherCenter.triggerThankCardBefore();
      CloudProtocolService.ThankGreetingCard(localCloudProtocolInfo, new QMCardManager.9(this, paramString1, paramLong));
      return;
      localAckCardReq.type = 1;
      continue;
      localAckCardReq.type = 3;
    }
  }
  
  public void updateBirthdayFriendSend(String paramString, boolean paramBoolean)
  {
    if (StringExtention.isNullOrEmpty(paramString)) {
      return;
    }
    this.mSqLiteHelper.updateBirthdayFriendIsSend(this.mSqLiteHelper.getWritableDatabase(), paramString, paramBoolean);
  }
  
  public void updateCardParaList(ArrayList<QMCardPara> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      this.mSqLiteHelper.updateCardPara(this.mSqLiteHelper.getWritableDatabase(), paramArrayList);
      return;
    }
    QMLog.log(4, "QMCardManager", "update cardParas null");
  }
  
  static class SingleTon
  {
    private static QMCardManager _instance = new QMCardManager(new QMCardSQLiteHelper(QMApplicationContext.sharedInstance()), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.QMCardManager
 * JD-Core Version:    0.7.0.1
 */