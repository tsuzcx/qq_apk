package com.tencent.mobileqq.data;

import acbn;
import akvm;
import anbi;
import android.annotation.TargetApi;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.os.Environment;
import aqhq;
import auqt;
import com.dataline.mpfile.MpfileTaskRecord;
import com.tencent.biz.pubaccount.AccountDetail.bean.DynamicInfoEntity;
import com.tencent.biz.pubaccount.ecshopassit.EcShopData;
import com.tencent.biz.pubaccount.readinjoy.data.ReadInJoyActivityDAUInfo;
import com.tencent.biz.pubaccount.readinjoy.question.bean.QuestionSquareBean;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.monitor.APIQuotaEntity;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecommendEntity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecommendSortEntity;
import com.tencent.mobileqq.activity.bless.BlessPtvModule;
import com.tencent.mobileqq.activity.bless.BlessTask;
import com.tencent.mobileqq.activity.bless.BlessWording;
import com.tencent.mobileqq.addon.DiyPendantEntity;
import com.tencent.mobileqq.apollo.data.ApolloActionRecentData;
import com.tencent.mobileqq.apollo.data.ApolloGameRedDot;
import com.tencent.mobileqq.apollo.data.ApolloPreDownloadData;
import com.tencent.mobileqq.apollo.data.ApolloWhiteFaceID;
import com.tencent.mobileqq.apollo.data.CmGamePushItem;
import com.tencent.mobileqq.apollo.trace.sdk.data.TraceData;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.qqdaily.FrontBackData;
import com.tencent.mobileqq.applets.data.AppletsAccountInfo;
import com.tencent.mobileqq.ar.model.ArDownloadInfo;
import com.tencent.mobileqq.bubble.BubbleDiyEntity;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.confess.ConfessConvInfo;
import com.tencent.mobileqq.config.operation.QQOperationTaskRecord;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.config.operation.QQOperationVoipTipsTaskExcuteRecord;
import com.tencent.mobileqq.data.fts.FTSNewTroopSync;
import com.tencent.mobileqq.data.fts.FTSTroopSync;
import com.tencent.mobileqq.data.fts.FTSTroopTime;
import com.tencent.mobileqq.data.qzone.FeedInfo;
import com.tencent.mobileqq.doutu.DoutuData;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.gamecenter.data.GameNoticeInfo;
import com.tencent.mobileqq.gamecenter.data.PadFaceAd;
import com.tencent.mobileqq.gamecenter.message.UinToTinyId;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.HotPicSendData;
import com.tencent.mobileqq.hotpic.HotPicTagInfo;
import com.tencent.mobileqq.hotpic.HotVideoData;
import com.tencent.mobileqq.microapp.apkg.AppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppEntity;
import com.tencent.mobileqq.mini.entry.desktop.item.DeskTopAppEntity;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopCardEntity;
import com.tencent.mobileqq.multimsg.MultiMsgNick;
import com.tencent.mobileqq.nearby.gameroom.RecentInviteUser;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManagerFactory.SQLiteOpenHelperImpl;
import com.tencent.mobileqq.persistence.OGEntityManager;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo;
import com.tencent.mobileqq.shortvideo.redbag.VideoRedbagData;
import com.tencent.mobileqq.statistics.Reporting;
import com.tencent.mobileqq.tofumsg.TofuItem;
import com.tencent.mobileqq.troop.data.NotificationRecommendTroopItem;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.data.TroopAioKeyBlackRule;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;
import com.tencent.mobileqq.troop.data.TroopAioTopADInfo;
import com.tencent.mobileqq.troop.data.TroopGiftBagInfo;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.mobileqq.trooponline.data.TroopAllOnlineData;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.vashealth.TracePathData;
import com.tencent.mobileqq.vashealth.TracePointsData;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qidian.data.PubAccountNavigationMenu;
import com.tencent.qidian.data.QidianCorpInfo;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qidian.data.QidianInternalInfo;
import com.tencent.qidian.data.QidianPAForWpa;
import com.tencent.qidian.data.QidianProfileUiInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import cooperation.qzone.contentbox.model.QZoneMsgEntityNew;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import wir;

@TargetApi(11)
public class QQEntityManagerFactory
  extends EntityManagerFactory
{
  private static final Class[] EXTRA_CLASSES = { MultiMsgNick.class, FTSTroopSync.class, Reporting.class, BusinessCard.class, FTSTroopTime.class, DoutuData.class, QQOperationViopTipTask.class, HotPicTagInfo.class, BmqqAccountType.class, QQOperationTaskRecord.class, QQOperationVoipTipsTaskExcuteRecord.class, TroopNotificationCache.class, TroopAIOAppInfo.class, ReadInJoyActivityDAUInfo.class, HotPicData.class, HotVideoData.class, ProfileShoppingPhotoInfo.class, DrawerPushItem.class, TroopAioKeyBlackRule.class, TroopAioKeywordTipInfo.class, TroopAllOnlineData.class, DynamicInfoEntity.class, DiyPendantEntity.class, ApolloObtainedActionData.class, RecentInviteUser.class, ApolloGameRedDot.class, InterestTagInfo.class, OcrRecogResult.class, ArDownloadInfo.class, BlessPtvModule.class, BlessWording.class, QQStoryUserInfo.class, HotPicSendData.class, TroopTipsEntity.class, BubbleDiyEntity.class, TroopGiftBagInfo.class, HotChatInfo.class, ApolloGameData.class, EmoticonKeywords.class, BlessTask.class, VideoRedbagData.class, ApolloActionRecentData.class, TroopAioTopADInfo.class, NotificationRecommendTroopItem.class, FTSNewTroopSync.class, GuideData.class, FeedInfo.class, BeancurdMsg.class, APIQuotaEntity.class, AppInfo.class, QuestionSquareBean.class, CmGamePushItem.class, ApolloActionData.class, QZoneMsgEntityNew.class, ApolloPreDownloadData.class, ApolloBaseInfo.class, TraceData.class, PadFaceAd.class, GameNoticeInfo.class, ExtensionInfo.class, ApolloWhiteFaceID.class, MiniAppEntity.class, ColorNote.class, DesktopCardEntity.class, FrontBackData.class, DeskTopAppEntity.class, StickerRecommendEntity.class, StickerRecommendSortEntity.class, TofuItem.class };
  private static final String[] FORCE_IGNORED_TABLE = { "PAReportInfo", "CircleBuddy ", "CircleGroup ", "Sticker", "TopicInfo", "FriendMore", "FreshNewsNotify", "QQCardFolder", "bubble_diytext", "ApolloGameBtnData", "ApolloGameActivityConfig", "CardProfilev2", "SecMsgSession" };
  private static final String[] NO_ENTITY_TABLE = { "msg_sync_log", "msg_upgrade_log" };
  private static final String[] SYSTEM_TABLE;
  private static final String[] TABLE_TO_DROP = { "WhiteListItem", "TroopAIOCommonAppInfo", "TroopVideoUrlEntity", "FreshNewsInfo", "GodListConfig", "GodEntity", "DatingSig", "DatingFeedInfo", "OpenTroopInfo", "TroopStorySnapListEntity", "SearchHistoryEntity", "TroopTopicDetailInfo", "MiniAppInfo" };
  protected static boolean isUpdateFromLowV74;
  private static Class[] mVerifyClasses = { MessageRecord.class, RecentUser.class, Friends.class, TroopInfo.class };
  protected boolean bUpdated;
  
  static
  {
    SYSTEM_TABLE = new String[] { "android_metadata", "sqlite_sequence" };
  }
  
  public QQEntityManagerFactory(String paramString)
  {
    super(paramString);
    this.name = paramString;
    this.TAG = "QQEntityManagerFactory";
  }
  
  public static void checkColumnChange(String paramString, android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    Cursor localCursor1 = paramSQLiteDatabase.rawQuery("select distinct tbl_name from Sqlite_master", null);
    ArrayList localArrayList = new ArrayList();
    String str;
    Object localObject1;
    label830:
    label843:
    Class localClass;
    if (localCursor1 != null)
    {
      localObject2 = null;
      for (;;)
      {
        if (localCursor1.moveToNext())
        {
          str = SecurityUtile.decode(localCursor1.getString(0));
          Cursor localCursor2 = paramSQLiteDatabase.rawQuery("select sql from sqlite_master where type=? and name=?", new String[] { "table", str });
          if (localCursor2 != null)
          {
            if (str.equals("mr_fileManager")) {
              localObject1 = FileManagerEntity.class;
            }
            for (;;)
            {
              if (localObject1 != null) {
                OGEntityManager.extractedStatementByReflect(localArrayList, str, localCursor2, (Class)localObject1);
              }
              localCursor2.close();
              break;
              if (str.equals(DataLineMsgRecord.tableName()))
              {
                localObject1 = DataLineMsgRecord.class;
              }
              else if (str.equals(MpfileTaskRecord.tableName()))
              {
                localObject1 = MpfileTaskRecord.class;
              }
              else if (str.equals(PrinterItemMsgRecord.tableName()))
              {
                localObject1 = PrinterItemMsgRecord.class;
              }
              else if (str.startsWith(RouterMsgRecord.tableBasicName()))
              {
                localObject1 = RouterMsgRecord.class;
              }
              else if (str.startsWith("mr_"))
              {
                localObject1 = MessageRecord.class;
              }
              else if (str.equals("recent"))
              {
                localObject1 = RecentUser.class;
              }
              else if (str.equals("recent_call"))
              {
                localObject1 = QCallRecent.class;
              }
              else if (str.equals(ConversationInfo.getConversationInfoTableName()))
              {
                localObject1 = ConversationInfo.class;
              }
              else if (str.equals(TroopBarData.class.getSimpleName()))
              {
                localObject1 = TroopBarData.class;
              }
              else if (str.equals("EcShopData"))
              {
                localObject1 = EcShopData.class;
              }
              else if (str.equals(TracePointsData.class.getSimpleName()))
              {
                localObject1 = TracePointsData.class;
              }
              else if (str.equals(TracePathData.class.getSimpleName()))
              {
                localObject1 = TracePathData.class;
              }
              else if (str.equals(QidianExternalInfo.class.getSimpleName()))
              {
                localObject1 = QidianExternalInfo.class;
              }
              else if (str.equals(QidianProfileUiInfo.class.getSimpleName()))
              {
                localObject1 = QidianProfileUiInfo.class;
              }
              else if (str.equals(BmqqAccountType.class.getSimpleName()))
              {
                localObject1 = BmqqAccountType.class;
              }
              else if (str.equals(PubAccountNavigationMenu.class.getSimpleName()))
              {
                localObject1 = PubAccountNavigationMenu.class;
              }
              else if (str.equals(QidianCorpInfo.class.getSimpleName()))
              {
                localObject1 = QidianCorpInfo.class;
              }
              else if (str.equals(QidianInternalInfo.class.getSimpleName()))
              {
                localObject1 = QidianInternalInfo.class;
              }
              else if (str.equals(QidianPAForWpa.class.getSimpleName()))
              {
                localObject1 = QidianPAForWpa.class;
              }
              else if (str.startsWith("TroopFileTansferItemEntity"))
              {
                localObject1 = TroopFileTansferItemEntity.class;
              }
              else if (str.startsWith("qc_"))
              {
                localObject1 = QCallRecord.class;
              }
              else if (str.equals("MessageRoamDate"))
              {
                localObject1 = RoamDate.class;
              }
              else if (str.equals(CardProfile.tableName()))
              {
                localObject1 = CardProfile.class;
              }
              else if (str.equals(TroopAIOAppInfo.class.getSimpleName()))
              {
                localObject1 = TroopAIOAppInfo.class;
              }
              else if (str.equals("TroopInfoV2"))
              {
                localObject1 = TroopInfo.class;
              }
              else if (str.equals(VideoRedbagData.class.getSimpleName()))
              {
                localObject1 = VideoRedbagData.class;
              }
              else if ((auqt.contains(SYSTEM_TABLE, str)) || (auqt.contains(NO_ENTITY_TABLE, str)))
              {
                if (!QLog.isColorLevel()) {
                  break label1098;
                }
                QLog.d("QQEntityManagerFactory", 2, "check table with " + str + " is system or no entity table");
                localObject1 = null;
              }
              else if (auqt.contains(FORCE_IGNORED_TABLE, str))
              {
                if (!QLog.isColorLevel()) {
                  break label1098;
                }
                QLog.d("QQEntityManagerFactory", 2, "check table with " + str + " is force ignored");
                localObject1 = null;
              }
              else if (str.equals(ConfessConvInfo.getConversationInfoTableName()))
              {
                localObject1 = ConfessConvInfo.class;
              }
              else if (str.equals(UinToTinyId.getTinyTableName()))
              {
                localObject1 = UinToTinyId.class;
              }
              else
              {
                if (!needToDrop(str, paramInt1, paramInt2)) {
                  break label830;
                }
                paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(str));
                localObject1 = null;
              }
            }
            if (localObject2 != null) {
              break label1091;
            }
            localObject1 = generateExtraClassMap(EXTRA_CLASSES);
            if (!((Map)localObject1).containsKey(str)) {
              break label1104;
            }
            localClass = (Class)((Map)localObject1).get(str);
            localObject2 = localClass;
            if (QLog.isColorLevel()) {
              QLog.d("QQEntityManagerFactory", 2, "check table: " + str + " / " + localClass.getName());
            }
          }
        }
      }
    }
    label1091:
    label1098:
    label1104:
    for (Object localObject2 = localClass;; localObject2 = null)
    {
      for (;;)
      {
        if (localObject2 == null) {
          try
          {
            localClass = Class.forName(paramString + "." + str);
            localObject2 = localObject1;
            localObject1 = localClass;
          }
          catch (ClassNotFoundException localClassNotFoundException)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQEntityManagerFactory", 2, "find unknown table: " + str);
            }
          }
        }
      }
      Object localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
      break;
      localCursor1.close();
      com.tencent.mobileqq.app.SQLiteDatabase.beginTransactionLog();
      paramSQLiteDatabase.beginTransaction();
      try
      {
        paramString = localArrayList.iterator();
        while (paramString.hasNext()) {
          paramSQLiteDatabase.execSQL((String)paramString.next());
        }
        paramSQLiteDatabase.setTransactionSuccessful();
      }
      finally
      {
        paramSQLiteDatabase.endTransaction();
        com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
      }
      paramSQLiteDatabase.endTransaction();
      com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
      return;
      localObject1 = localObject2;
      break label843;
      localObject1 = null;
      break;
    }
  }
  
  private static Map<String, Class> generateExtraClassMap(Class[] paramArrayOfClass)
  {
    HashMap localHashMap = new HashMap(paramArrayOfClass.length);
    int j = paramArrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      Class localClass = paramArrayOfClass[i];
      localHashMap.put(localClass.getSimpleName(), localClass);
      i += 1;
    }
    return localHashMap;
  }
  
  private static boolean needToDrop(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramString.startsWith("RedPacketData_")) && (paramInt1 < 214)) {}
    while (auqt.contains(TABLE_TO_DROP, paramString)) {
      return true;
    }
    return false;
  }
  
  private void verifyDBVersion() {}
  
  public SQLiteOpenHelper build(String paramString)
  {
    verifyDBVersion();
    if (this.dbHelper == null)
    {
      if (!VersionUtils.isHoneycomb()) {
        break label187;
      }
      this.mInnerDbHelper = new EntityManagerFactory.SQLiteOpenHelperImpl(this, paramString + ".db", null, 313, new a());
    }
    for (;;)
    {
      paramString = BaseApplicationImpl.getApplication();
      if ((paramString != null) && (paramString.getQQProcessName().equalsIgnoreCase(paramString.getPackageName()))) {
        paramString = new File(SQLiteOpenHelper.WAL_FLAG_FILE_PATH);
      }
      try
      {
        if (paramString.exists())
        {
          SQLiteOpenHelper.WAL_ENABLE = true;
          aqhq.deleteFile(SQLiteOpenHelper.WAL_FLAG_FILE_PATH);
        }
        QLog.d(this.TAG, 1, "walFlag: " + SQLiteOpenHelper.WAL_ENABLE);
        this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
        QLog.d(this.TAG, 1, new Object[] { "new SQLiteOpenHelper = : ", this.dbHelper });
        return this.dbHelper;
        label187:
        this.mInnerDbHelper = new EntityManagerFactory.SQLiteOpenHelperImpl(this, paramString + ".db", null, 313);
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          QLog.e(this.TAG, 1, "build error", paramString);
        }
      }
    }
  }
  
  public void cleanOverDueCorruptDatabase()
  {
    File localFile = new File(Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/corruptInfo");
    if ((localFile.exists()) && (System.currentTimeMillis() - localFile.lastModified() > 604800000L)) {
      localFile.delete();
    }
  }
  
  public void createDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new Groups()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new Friends()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new RecentUser()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new Ability()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new TroopInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new Card()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new DiscussionInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new PhoneContact()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new DataLineMsgRecord()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new DataLineMsgRecord(1)));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new EmoticonPackage()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new Emoticon()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new EmoticonTab()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new RoamSetting()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new TroopMemberInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new TroopRemindSettingData()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ShieldListInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ContactCard()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new QZoneCover()));
    MessageRecord localMessageRecord = anbi.d(-1000);
    localMessageRecord.frienduin = String.valueOf(acbn.bkE);
    localMessageRecord.istroop = 1001;
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(localMessageRecord));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new SearchHistory()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ExtensionInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new CommonlyUsedTroop()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ExpiredPushBanner()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new HotChatInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new SpecialCareInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ApolloBaseInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ApolloPandora()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new FileManagerEntity()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ReportedBanner()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MedalInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new TempMsgInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new PushSwitchGrayTipsInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new AppletsAccountInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ColorNote()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new FrontBackData()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new TofuItem()));
  }
  
  public EntityManager createMessageRecordEntityManager()
  {
    if (this.closed) {
      throw new IllegalStateException("The EntityManagerFactory has been already closed");
    }
    akvm localakvm = new akvm(this.dbHelper, this.mName);
    this.closed = false;
    return localakvm;
  }
  
  public void doAfterUpgradeDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  public String getPackageName()
  {
    return "com.tencent.mobileqq.data";
  }
  
  public boolean isUpdated()
  {
    return this.bUpdated;
  }
  
  public void upgradeDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 20)
    {
      this.mInnerDbHelper.dropAllTable();
      return;
    }
    if (paramInt1 < 112) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new DataLineMsgRecord(1)));
    }
    if (paramInt1 < 70) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ExtensionInfo()));
    }
    if (paramInt1 < 34)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(DiscussionInfo.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new DiscussionInfo()));
    }
    if (paramInt1 < 115) {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(TroopAppInfo.class.getSimpleName()));
    }
    if (paramInt1 < 29) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new Ability()));
    }
    if (paramInt1 < 35) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new PhoneContact()));
    }
    if (paramInt1 < 36)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement("TroopSelfInfo"));
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(TroopInfo.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new TroopInfo()));
      this.bUpdated = true;
    }
    if (paramInt1 < 41)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(Card.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new Card()));
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(ResourcePluginInfo.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ResourcePluginInfo()));
    }
    if (paramInt1 < 48)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(Setting.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new Setting()));
    }
    if (paramInt1 <= 66) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new SearchHistory()));
    }
    if (paramInt1 < 74) {
      isUpdateFromLowV74 = true;
    }
    if (paramInt1 <= 84)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ExpiredPushBanner()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ShortVideoUpInfo()));
    }
    if (paramInt1 <= 89) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new HotChatInfo()));
    }
    if (paramInt1 <= 98) {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(DatingInfo.class.getSimpleName()));
    }
    if (paramInt1 < 102) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new SpecialCareInfo()));
    }
    if (paramInt1 < 103) {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement("RecommendMessage"));
    }
    if (paramInt1 < 125)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ApolloBaseInfo()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ApolloPandora()));
    }
    if (paramInt1 < 113)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(DatingInfo.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(DateEventMsg.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(DatingRecentDetail.class.getSimpleName()));
    }
    if (paramInt1 < 125) {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement("t_qqcard_item"));
    }
    if (paramInt1 < 137) {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(MessageRecord.getTableName(acbn.bkJ, 0)));
    }
    if (paramInt1 < 145) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ContactCard()));
    }
    if (paramInt1 < 184)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(TroopInfo.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new TroopInfo()));
      if (QLog.isColorLevel()) {
        QLog.d(".troop.qidian_private_troop", 2, "upgradeDatabase, change troopInfo table, newVer=" + paramInt2 + ", oldVer=" + paramInt1);
      }
    }
    if (paramInt1 < 185) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ReportedBanner()));
    }
    if (paramInt1 < 188)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement("CircleBuddy"));
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement("CircleGroup"));
    }
    if (paramInt1 < 189) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MedalInfo()));
    }
    if (paramInt1 < 217) {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(TableBuilder.getTableNameSafe(TroopAIOAppInfo.class)));
    }
    if (paramInt1 < 233)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(TableBuilder.getTableNameSafe(MayKnowRecommend.class)));
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(TableBuilder.getTableNameSafe(PushRecommend.class)));
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(TableBuilder.getTableNameSafe(MayKnowExposure.class)));
    }
    if (paramInt1 < 238) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new TempMsgInfo()));
    }
    if (paramInt1 < 241) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new PushSwitchGrayTipsInfo()));
    }
    if (paramInt1 < 242) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new AppletsAccountInfo()));
    }
    if (paramInt1 < 242) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new OcrRecogResult()));
    }
    if (paramInt1 < 282) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ColorNote()));
    }
    if (paramInt1 < 300) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new FrontBackData()));
    }
    if (paramInt1 < 307)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(DeskTopAppEntity.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new DeskTopAppEntity()));
    }
    if (paramInt1 < 309) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new TofuItem()));
    }
    checkColumnChange(getPackageName(), paramSQLiteDatabase, paramInt1, paramInt2);
  }
  
  public boolean verifyAuthentication()
  {
    return super.verifyAuthentication();
  }
  
  class a
    implements DatabaseErrorHandler
  {
    private DefaultDatabaseErrorHandler a = new DefaultDatabaseErrorHandler();
    
    @TargetApi(11)
    public a() {}
    
    /* Error */
    public void onCorruption(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
    {
      // Byte code:
      //   0: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   3: ifeq +36 -> 39
      //   6: aload_0
      //   7: getfield 19	com/tencent/mobileqq/data/QQEntityManagerFactory$a:b	Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
      //   10: invokestatic 47	com/tencent/mobileqq/data/QQEntityManagerFactory:access$000	(Lcom/tencent/mobileqq/data/QQEntityManagerFactory;)Ljava/lang/String;
      //   13: iconst_2
      //   14: new 49	java/lang/StringBuilder
      //   17: dup
      //   18: invokespecial 50	java/lang/StringBuilder:<init>	()V
      //   21: ldc 52
      //   23: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   26: aload_1
      //   27: invokevirtual 62	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
      //   30: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   33: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   36: invokestatic 69	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   39: invokestatic 75	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
      //   42: invokevirtual 79	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
      //   45: astore 17
      //   47: aload 17
      //   49: invokevirtual 84	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
      //   52: getstatic 90	com/tencent/mobileqq/database/corrupt/DBFixManager:bCE	Ljava/lang/String;
      //   55: iconst_0
      //   56: invokevirtual 96	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
      //   59: astore 18
      //   61: aload 17
      //   63: invokevirtual 84	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
      //   66: new 49	java/lang/StringBuilder
      //   69: dup
      //   70: invokespecial 50	java/lang/StringBuilder:<init>	()V
      //   73: aload 17
      //   75: invokevirtual 99	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
      //   78: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   81: ldc 101
      //   83: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   86: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   89: invokevirtual 105	mqq/app/MobileQQ:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
      //   92: astore 15
      //   94: aload 15
      //   96: invokevirtual 110	java/io/File:exists	()Z
      //   99: ifeq +13 -> 112
      //   102: aload 15
      //   104: invokevirtual 114	java/io/File:length	()J
      //   107: lconst_0
      //   108: lcmp
      //   109: ifne +66 -> 175
      //   112: new 116	java/util/HashMap
      //   115: dup
      //   116: invokespecial 117	java/util/HashMap:<init>	()V
      //   119: astore 16
      //   121: aload 15
      //   123: invokevirtual 110	java/io/File:exists	()Z
      //   126: ifeq +895 -> 1021
      //   129: ldc 119
      //   131: astore 14
      //   133: aload 16
      //   135: ldc 121
      //   137: aload 14
      //   139: invokevirtual 125	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   142: pop
      //   143: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
      //   146: invokestatic 136	anpc:a	(Landroid/content/Context;)Lanpc;
      //   149: aconst_null
      //   150: getstatic 139	com/tencent/mobileqq/database/corrupt/DBFixManager:bCO	Ljava/lang/String;
      //   153: iconst_1
      //   154: ldc2_w 140
      //   157: lconst_0
      //   158: aload 16
      //   160: aconst_null
      //   161: iconst_0
      //   162: invokevirtual 145	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
      //   165: aload 15
      //   167: invokevirtual 146	java/io/File:getPath	()Ljava/lang/String;
      //   170: invokestatic 152	aqhq:deleteFile	(Ljava/lang/String;)Z
      //   173: pop
      //   174: return
      //   175: aload 18
      //   177: new 49	java/lang/StringBuilder
      //   180: dup
      //   181: invokespecial 50	java/lang/StringBuilder:<init>	()V
      //   184: aload 17
      //   186: invokevirtual 99	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
      //   189: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   192: getstatic 155	com/tencent/mobileqq/database/corrupt/DBFixManager:bCJ	Ljava/lang/String;
      //   195: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   198: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   201: invokeinterface 160 2 0
      //   206: ifne +377 -> 583
      //   209: aload 18
      //   211: invokeinterface 164 1 0
      //   216: new 49	java/lang/StringBuilder
      //   219: dup
      //   220: invokespecial 50	java/lang/StringBuilder:<init>	()V
      //   223: aload 17
      //   225: invokevirtual 99	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
      //   228: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   231: getstatic 155	com/tencent/mobileqq/database/corrupt/DBFixManager:bCJ	Ljava/lang/String;
      //   234: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   237: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   240: iconst_1
      //   241: invokeinterface 170 3 0
      //   246: invokeinterface 173 1 0
      //   251: pop
      //   252: invokestatic 178	java/lang/System:currentTimeMillis	()J
      //   255: putstatic 184	com/tencent/mobileqq/persistence/EntityManagerFactory:corruptedTime	J
      //   258: iconst_0
      //   259: istore 5
      //   261: lconst_0
      //   262: lstore 8
      //   264: lconst_0
      //   265: lstore 10
      //   267: lload 10
      //   269: lstore 6
      //   271: iload 5
      //   273: istore 4
      //   275: aload 17
      //   277: instanceof 186
      //   280: ifeq +167 -> 447
      //   283: aload 15
      //   285: invokevirtual 114	java/io/File:length	()J
      //   288: lstore 12
      //   290: lload 10
      //   292: lstore 6
      //   294: lload 12
      //   296: lstore 8
      //   298: iload 5
      //   300: istore 4
      //   302: aload 15
      //   304: invokevirtual 110	java/io/File:exists	()Z
      //   307: ifeq +140 -> 447
      //   310: lload 10
      //   312: lstore 6
      //   314: lload 12
      //   316: lstore 8
      //   318: iload 5
      //   320: istore 4
      //   322: aload 15
      //   324: invokevirtual 114	java/io/File:length	()J
      //   327: lconst_0
      //   328: lcmp
      //   329: ifle +118 -> 447
      //   332: lload 10
      //   334: lstore 6
      //   336: lload 12
      //   338: lstore 8
      //   340: iload 5
      //   342: istore 4
      //   344: invokestatic 191	aqfo:isExistSDCard	()Z
      //   347: ifeq +100 -> 447
      //   350: lload 10
      //   352: lstore 6
      //   354: lload 12
      //   356: lstore 8
      //   358: iload 5
      //   360: istore 4
      //   362: invokestatic 194	aqfo:getSDCardAvailableSize	()J
      //   365: aload 15
      //   367: invokevirtual 114	java/io/File:length	()J
      //   370: lcmp
      //   371: ifle +76 -> 447
      //   374: new 107	java/io/File
      //   377: dup
      //   378: new 49	java/lang/StringBuilder
      //   381: dup
      //   382: invokespecial 50	java/lang/StringBuilder:<init>	()V
      //   385: invokestatic 200	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
      //   388: invokevirtual 146	java/io/File:getPath	()Ljava/lang/String;
      //   391: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   394: ldc 202
      //   396: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   399: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   402: invokespecial 205	java/io/File:<init>	(Ljava/lang/String;)V
      //   405: astore 14
      //   407: lload 10
      //   409: lstore 6
      //   411: lload 12
      //   413: lstore 8
      //   415: iload 5
      //   417: istore 4
      //   419: aload 14
      //   421: invokevirtual 110	java/io/File:exists	()Z
      //   424: ifne +23 -> 447
      //   427: aload 15
      //   429: aload 14
      //   431: invokestatic 209	aqhq:copyFile	(Ljava/io/File;Ljava/io/File;)Z
      //   434: istore 4
      //   436: aload 14
      //   438: invokevirtual 114	java/io/File:length	()J
      //   441: lstore 6
      //   443: lload 12
      //   445: lstore 8
      //   447: invokestatic 212	com/tencent/mobileqq/persistence/EntityManagerFactory:getSqliteLibraryVersion	()Ljava/lang/String;
      //   450: astore 14
      //   452: new 116	java/util/HashMap
      //   455: dup
      //   456: invokespecial 117	java/util/HashMap:<init>	()V
      //   459: astore 15
      //   461: aload 15
      //   463: ldc 214
      //   465: invokestatic 219	aqgz:getRomInfo	()Ljava/lang/String;
      //   468: invokevirtual 125	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   471: pop
      //   472: aload 15
      //   474: ldc 221
      //   476: iload 4
      //   478: invokestatic 227	java/lang/String:valueOf	(Z)Ljava/lang/String;
      //   481: invokevirtual 125	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   484: pop
      //   485: aload 15
      //   487: ldc 229
      //   489: lload 8
      //   491: invokestatic 232	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   494: invokevirtual 125	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   497: pop
      //   498: aload 15
      //   500: ldc 234
      //   502: lload 6
      //   504: invokestatic 232	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   507: invokevirtual 125	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   510: pop
      //   511: aload 15
      //   513: ldc 236
      //   515: aload 14
      //   517: invokevirtual 125	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   520: pop
      //   521: aload_0
      //   522: getfield 19	com/tencent/mobileqq/data/QQEntityManagerFactory$a:b	Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
      //   525: invokestatic 239	com/tencent/mobileqq/data/QQEntityManagerFactory:access$100	(Lcom/tencent/mobileqq/data/QQEntityManagerFactory;)Ljava/lang/String;
      //   528: iconst_1
      //   529: ldc 241
      //   531: iconst_3
      //   532: anewarray 4	java/lang/Object
      //   535: dup
      //   536: iconst_0
      //   537: lload 8
      //   539: invokestatic 246	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   542: aastore
      //   543: dup
      //   544: iconst_1
      //   545: lload 6
      //   547: invokestatic 246	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   550: aastore
      //   551: dup
      //   552: iconst_2
      //   553: aload 14
      //   555: aastore
      //   556: invokestatic 250	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   559: invokestatic 69	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   562: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
      //   565: invokestatic 136	anpc:a	(Landroid/content/Context;)Lanpc;
      //   568: aconst_null
      //   569: ldc 252
      //   571: iconst_1
      //   572: ldc2_w 140
      //   575: lconst_0
      //   576: aload 15
      //   578: aconst_null
      //   579: iconst_0
      //   580: invokevirtual 145	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
      //   583: new 107	java/io/File
      //   586: dup
      //   587: aload_1
      //   588: invokevirtual 62	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
      //   591: invokespecial 205	java/io/File:<init>	(Ljava/lang/String;)V
      //   594: invokevirtual 255	java/io/File:getName	()Ljava/lang/String;
      //   597: astore 19
      //   599: aload 19
      //   601: new 49	java/lang/StringBuilder
      //   604: dup
      //   605: invokespecial 50	java/lang/StringBuilder:<init>	()V
      //   608: aload 17
      //   610: invokevirtual 99	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
      //   613: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   616: ldc 101
      //   618: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   621: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   624: invokevirtual 259	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   627: istore 5
      //   629: aconst_null
      //   630: astore 15
      //   632: aload 17
      //   634: sipush 205
      //   637: invokevirtual 263	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
      //   640: checkcast 86	com/tencent/mobileqq/database/corrupt/DBFixManager
      //   643: astore 14
      //   645: aload 14
      //   647: invokevirtual 266	com/tencent/mobileqq/database/corrupt/DBFixManager:aiF	()Z
      //   650: istore 4
      //   652: aconst_null
      //   653: astore 15
      //   655: iconst_0
      //   656: istore_2
      //   657: iload 4
      //   659: ifeq +95 -> 754
      //   662: iload 5
      //   664: ifeq +90 -> 754
      //   667: aload_1
      //   668: invokevirtual 269	android/database/sqlite/SQLiteDatabase:close	()V
      //   671: aload 14
      //   673: aconst_null
      //   674: iconst_1
      //   675: invokevirtual 273	com/tencent/mobileqq/database/corrupt/DBFixManager:C	(Landroid/content/Context;Z)V
      //   678: return
      //   679: astore 14
      //   681: aload_0
      //   682: getfield 27	com/tencent/mobileqq/data/QQEntityManagerFactory$a:a	Landroid/database/DefaultDatabaseErrorHandler;
      //   685: aload_1
      //   686: invokevirtual 275	android/database/DefaultDatabaseErrorHandler:onCorruption	(Landroid/database/sqlite/SQLiteDatabase;)V
      //   689: return
      //   690: astore 16
      //   692: aload 15
      //   694: astore 14
      //   696: aload 16
      //   698: astore 15
      //   700: aload_0
      //   701: getfield 19	com/tencent/mobileqq/data/QQEntityManagerFactory$a:b	Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
      //   704: invokestatic 278	com/tencent/mobileqq/data/QQEntityManagerFactory:access$200	(Lcom/tencent/mobileqq/data/QQEntityManagerFactory;)Ljava/lang/String;
      //   707: iconst_1
      //   708: ldc_w 280
      //   711: aload 15
      //   713: invokestatic 284	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   716: getstatic 288	com/tencent/mobileqq/database/corrupt/DBFixManager:cPY	I
      //   719: istore_2
      //   720: aload 15
      //   722: invokestatic 294	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   725: astore 15
      //   727: iconst_0
      //   728: istore 4
      //   730: goto -73 -> 657
      //   733: astore 15
      //   735: aload_0
      //   736: getfield 19	com/tencent/mobileqq/data/QQEntityManagerFactory$a:b	Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
      //   739: invokestatic 297	com/tencent/mobileqq/data/QQEntityManagerFactory:access$300	(Lcom/tencent/mobileqq/data/QQEntityManagerFactory;)Ljava/lang/String;
      //   742: iconst_1
      //   743: ldc_w 299
      //   746: aload 15
      //   748: invokestatic 284	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   751: goto -80 -> 671
      //   754: aload 18
      //   756: new 49	java/lang/StringBuilder
      //   759: dup
      //   760: invokespecial 50	java/lang/StringBuilder:<init>	()V
      //   763: aload 17
      //   765: invokevirtual 99	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
      //   768: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   771: getstatic 302	com/tencent/mobileqq/database/corrupt/DBFixManager:bCI	Ljava/lang/String;
      //   774: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   777: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   780: iconst_0
      //   781: invokeinterface 306 3 0
      //   786: istore_3
      //   787: aload_0
      //   788: getfield 19	com/tencent/mobileqq/data/QQEntityManagerFactory$a:b	Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
      //   791: invokestatic 309	com/tencent/mobileqq/data/QQEntityManagerFactory:access$400	(Lcom/tencent/mobileqq/data/QQEntityManagerFactory;)Ljava/lang/String;
      //   794: iconst_1
      //   795: bipush 6
      //   797: anewarray 4	java/lang/Object
      //   800: dup
      //   801: iconst_0
      //   802: ldc_w 311
      //   805: aastore
      //   806: dup
      //   807: iconst_1
      //   808: aload 19
      //   810: aastore
      //   811: dup
      //   812: iconst_2
      //   813: ldc_w 313
      //   816: aastore
      //   817: dup
      //   818: iconst_3
      //   819: iload 5
      //   821: invokestatic 318	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   824: aastore
      //   825: dup
      //   826: iconst_4
      //   827: ldc_w 320
      //   830: aastore
      //   831: dup
      //   832: iconst_5
      //   833: iload_3
      //   834: invokestatic 325	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   837: aastore
      //   838: invokestatic 329	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
      //   841: iload_3
      //   842: getstatic 332	com/tencent/mobileqq/database/corrupt/DBFixManager:cPV	I
      //   845: if_icmpge +8 -> 853
      //   848: iload 5
      //   850: ifne +170 -> 1020
      //   853: aload_0
      //   854: getfield 27	com/tencent/mobileqq/data/QQEntityManagerFactory$a:a	Landroid/database/DefaultDatabaseErrorHandler;
      //   857: aload_1
      //   858: invokevirtual 275	android/database/DefaultDatabaseErrorHandler:onCorruption	(Landroid/database/sqlite/SQLiteDatabase;)V
      //   861: aload 18
      //   863: invokeinterface 164 1 0
      //   868: getstatic 155	com/tencent/mobileqq/database/corrupt/DBFixManager:bCJ	Ljava/lang/String;
      //   871: invokeinterface 336 2 0
      //   876: invokeinterface 173 1 0
      //   881: pop
      //   882: invokestatic 341	anaz:dOT	()V
      //   885: aload 18
      //   887: invokeinterface 164 1 0
      //   892: ldc_w 343
      //   895: iconst_0
      //   896: invokeinterface 170 3 0
      //   901: invokeinterface 173 1 0
      //   906: pop
      //   907: aload_0
      //   908: getfield 19	com/tencent/mobileqq/data/QQEntityManagerFactory$a:b	Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
      //   911: invokestatic 346	com/tencent/mobileqq/data/QQEntityManagerFactory:access$500	(Lcom/tencent/mobileqq/data/QQEntityManagerFactory;)Ljava/lang/String;
      //   914: iconst_1
      //   915: ldc_w 348
      //   918: invokestatic 350	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   921: iload_2
      //   922: istore_3
      //   923: iload_2
      //   924: ifne +12 -> 936
      //   927: iload 5
      //   929: ifeq +79 -> 1008
      //   932: getstatic 353	com/tencent/mobileqq/database/corrupt/DBFixManager:cPX	I
      //   935: istore_3
      //   936: new 116	java/util/HashMap
      //   939: dup
      //   940: invokespecial 117	java/util/HashMap:<init>	()V
      //   943: astore 14
      //   945: aload 14
      //   947: ldc_w 355
      //   950: iload_3
      //   951: invokestatic 358	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   954: invokevirtual 125	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   957: pop
      //   958: aload 14
      //   960: ldc_w 360
      //   963: aload 19
      //   965: invokevirtual 125	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   968: pop
      //   969: aload 15
      //   971: ifnull +14 -> 985
      //   974: aload 14
      //   976: ldc_w 362
      //   979: aload 15
      //   981: invokevirtual 125	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   984: pop
      //   985: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
      //   988: invokestatic 136	anpc:a	(Landroid/content/Context;)Lanpc;
      //   991: aconst_null
      //   992: getstatic 365	com/tencent/mobileqq/database/corrupt/DBFixManager:bCM	Ljava/lang/String;
      //   995: iconst_1
      //   996: ldc2_w 140
      //   999: lconst_0
      //   1000: aload 14
      //   1002: aconst_null
      //   1003: iconst_0
      //   1004: invokevirtual 145	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
      //   1007: return
      //   1008: getstatic 368	com/tencent/mobileqq/database/corrupt/DBFixManager:cPW	I
      //   1011: istore_3
      //   1012: goto -76 -> 936
      //   1015: astore 15
      //   1017: goto -317 -> 700
      //   1020: return
      //   1021: ldc_w 370
      //   1024: astore 14
      //   1026: goto -893 -> 133
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1029	0	this	a
      //   0	1029	1	paramSQLiteDatabase	android.database.sqlite.SQLiteDatabase
      //   656	268	2	i	int
      //   786	226	3	j	int
      //   273	456	4	bool1	boolean
      //   259	669	5	bool2	boolean
      //   269	277	6	l1	long
      //   262	276	8	l2	long
      //   265	143	10	l3	long
      //   288	156	12	l4	long
      //   131	541	14	localObject1	Object
      //   679	1	14	localStackOverflowError	java.lang.StackOverflowError
      //   694	331	14	localObject2	Object
      //   92	634	15	localObject3	Object
      //   733	247	15	localSQLiteException	android.database.sqlite.SQLiteException
      //   1015	1	15	localThrowable1	java.lang.Throwable
      //   119	40	16	localHashMap	HashMap
      //   690	7	16	localThrowable2	java.lang.Throwable
      //   45	719	17	localAppRuntime	mqq.app.AppRuntime
      //   59	827	18	localSharedPreferences	android.content.SharedPreferences
      //   597	367	19	str	String
      // Exception table:
      //   from	to	target	type
      //   0	39	679	java/lang/StackOverflowError
      //   39	112	679	java/lang/StackOverflowError
      //   112	129	679	java/lang/StackOverflowError
      //   133	174	679	java/lang/StackOverflowError
      //   175	258	679	java/lang/StackOverflowError
      //   275	290	679	java/lang/StackOverflowError
      //   302	310	679	java/lang/StackOverflowError
      //   322	332	679	java/lang/StackOverflowError
      //   344	350	679	java/lang/StackOverflowError
      //   362	407	679	java/lang/StackOverflowError
      //   419	443	679	java/lang/StackOverflowError
      //   447	583	679	java/lang/StackOverflowError
      //   583	629	679	java/lang/StackOverflowError
      //   632	645	679	java/lang/StackOverflowError
      //   645	652	679	java/lang/StackOverflowError
      //   667	671	679	java/lang/StackOverflowError
      //   671	678	679	java/lang/StackOverflowError
      //   700	727	679	java/lang/StackOverflowError
      //   735	751	679	java/lang/StackOverflowError
      //   754	848	679	java/lang/StackOverflowError
      //   853	921	679	java/lang/StackOverflowError
      //   932	936	679	java/lang/StackOverflowError
      //   936	969	679	java/lang/StackOverflowError
      //   974	985	679	java/lang/StackOverflowError
      //   985	1007	679	java/lang/StackOverflowError
      //   1008	1012	679	java/lang/StackOverflowError
      //   632	645	690	java/lang/Throwable
      //   667	671	733	android/database/sqlite/SQLiteException
      //   645	652	1015	java/lang/Throwable
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQEntityManagerFactory
 * JD-Core Version:    0.7.0.1
 */