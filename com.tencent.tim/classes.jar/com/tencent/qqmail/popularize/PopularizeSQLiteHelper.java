package com.tencent.qqmail.popularize;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteDatabase.CursorFactory;
import com.tencent.qqmail.QMBaseSQLiteOpenHelper;
import com.tencent.qqmail.model.cache.PopularizeCache;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.model.PopularizeAppConfig;
import com.tencent.qqmail.popularize.model.PopularizeSubItem;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class PopularizeSQLiteHelper
  extends QMBaseSQLiteOpenHelper
{
  private static final String FIELD_POPULARIZE_ABSTRACTS = "abstracts";
  private static final String FIELD_POPULARIZE_ACTION = "action";
  private static final String FIELD_POPULARIZE_AD_AVATAR_URL = "avatar_url";
  private static final String FIELD_POPULARIZE_AD_AVATAR_URL_MD5 = "avatar_url_md5";
  private static final String FIELD_POPULARIZE_AD_IS_POP_BY_NEW_MAIL = "isPop";
  private static final String FIELD_POPULARIZE_AD_IS_STOP = "isStop";
  private static final String FIELD_POPULARIZE_AD_SUB_ABSTRACTS = "sub_abstracts";
  private static final String FIELD_POPULARIZE_AD_SUB_FROMNICK = "sub_fromnick";
  private static final String FIELD_POPULARIZE_AD_SUB_SUBJECT = "sub_subject";
  private static final String FIELD_POPULARIZE_AD_XML = "adXml";
  private static final String FIELD_POPULARIZE_APP_INSTALL_ACTION = "appInstallAction";
  private static final String FIELD_POPULARIZE_APP_NAME = "popularizeAppName";
  private static final String FIELD_POPULARIZE_APP_VERSION = "popularizeAppVersion";
  private static final String FIELD_POPULARIZE_BANNER_HEIGHT = "bannerHeight";
  private static final String FIELD_POPULARIZE_BANNER_POSITION = "bannerPosition";
  private static final String FIELD_POPULARIZE_COMMERCIAL_CONFIG_HEAD = "commercialConfigHead";
  private static final String FIELD_POPULARIZE_COMMERCIAL_CONFIG_LIST = "commercialConfigList";
  private static final String FIELD_POPULARIZE_COMMERCIAL_CONFIG_MARK = "commercialConfigMark";
  private static final String FIELD_POPULARIZE_COMMERCIAL_CONFIG_TOOL = "commercialConfigTool";
  private static final String FIELD_POPULARIZE_COMMERCIAL_FROM_EMAIL = "commercialFromEmail";
  private static final String FIELD_POPULARIZE_COMMERCIAL_FROM_NICK = "commercialFromNick";
  private static final String FIELD_POPULARIZE_CONDITION = "condition";
  private static final String FIELD_POPULARIZE_CONTENT = "content";
  private static final String FIELD_POPULARIZE_DURATION = "duration";
  private static final String FIELD_POPULARIZE_END_TIME = "endTime";
  private static final String FIELD_POPULARIZE_ID = "id";
  private static final String FIELD_POPULARIZE_IMAGE_MD5 = "imageMd5";
  private static final String FIELD_POPULARIZE_IMAGE_URL = "imageUrl";
  private static final String FIELD_POPULARIZE_IS_CANCEL = "isCancel";
  private static final String FIELD_POPULARIZE_IS_CLICK = "isClick";
  private static final String FIELD_POPULARIZE_IS_OPEN = "isOpen";
  private static final String FIELD_POPULARIZE_IS_READ = "isRead";
  private static final String FIELD_POPULARIZE_IS_RENDER = "isRender";
  private static final String FIELD_POPULARIZE_LAST_RENDER_TIME = "lastRenderTime";
  private static final String FIELD_POPULARIZE_MOVE = "move";
  private static final String FIELD_POPULARIZE_NEED_QQ_ACCOUNT = "needQQAccount";
  private static final String FIELD_POPULARIZE_NEED_WIFI = "needWifi";
  private static final String FIELD_POPULARIZE_OPEN_URL = "openUrl";
  private static final String FIELD_POPULARIZE_PAGE = "page";
  private static final String FIELD_POPULARIZE_PRIORITY = "priority";
  private static final String FIELD_POPULARIZE_PRODUCT_ID = "product_id";
  private static final String FIELD_POPULARIZE_RELATEDID = "relatedId";
  private static final String FIELD_POPULARIZE_REPORT_ID = "reportId";
  private static final String FIELD_POPULARIZE_RESOURCE_TYPE = "resourceType";
  private static final String FIELD_POPULARIZE_SERVER_ID = "serverId";
  private static final String FIELD_POPULARIZE_SESSION_TYPE = "sessionType";
  private static final String FIELD_POPULARIZE_SHOW_TYPE = "showType";
  private static final String FIELD_POPULARIZE_START_TIME = "startTime";
  private static final String FIELD_POPULARIZE_SUBJECT = "subject";
  private static final String FIELD_POPULARIZE_SUB_IMAGE_MD5 = "subImageMd5";
  private static final String FIELD_POPULARIZE_SUB_IMAGE_URL = "subImageUrl";
  private static final String FIELD_POPULARIZE_SUB_INFOMATION = "subInformation";
  private static final String FIELD_POPULARIZE_SUB_INFOMATION_DATA = "subInformationData";
  private static final String FIELD_POPULARIZE_SUB_ITEM_ACTION = "action";
  private static final String FIELD_POPULARIZE_SUB_ITEM_BOTTOM_RADIO = "bottomRadio";
  private static final String FIELD_POPULARIZE_SUB_ITEM_CONDITION = "condition";
  private static final String FIELD_POPULARIZE_SUB_ITEM_ID = "id";
  private static final String FIELD_POPULARIZE_SUB_ITEM_IMAGE_MD5 = "imageMd5";
  private static final String FIELD_POPULARIZE_SUB_ITEM_IMAGE_URL = "imageUrl";
  private static final String FIELD_POPULARIZE_SUB_ITEM_IS_CANCEL = "isCancel";
  private static final String FIELD_POPULARIZE_SUB_ITEM_IS_CLICK = "isClick";
  private static final String FIELD_POPULARIZE_SUB_ITEM_IS_CLICK_MYAPP = "isClickMyApp";
  private static final String FIELD_POPULARIZE_SUB_ITEM_IS_RELATED = "isRelated";
  private static final String FIELD_POPULARIZE_SUB_ITEM_IS_RENDER = "isRender";
  private static final String FIELD_POPULARIZE_SUB_ITEM_LAST_RENDER_TIME = "lastRenderTime";
  private static final String FIELD_POPULARIZE_SUB_ITEM_OPEN_URL = "openUrl";
  private static final String FIELD_POPULARIZE_SUB_ITEM_POPULARIZE_ID = "popularizeId";
  private static final String FIELD_POPULARIZE_SUB_ITEM_POSITION = "position";
  private static final String FIELD_POPULARIZE_SUB_ITEM_SEQUENCE = "sequence";
  private static final String FIELD_POPULARIZE_SUB_ITEM_SERVER_ID = "serverId";
  private static final String FIELD_POPULARIZE_SUB_ITEM_SHOW_TYPE = "showType";
  private static final String FIELD_POPULARIZE_SUB_ITEM_TEXT = "text";
  private static final String FIELD_POPULARIZE_TURN_ID = "turn_id";
  private static final String FIELD_POPULARIZE_TYPE = "type";
  private static final String FIELD_POPULARIZE_WEIGHT = "weight";
  private static final String FILENAME = "QMPopularizeDB";
  private static final String TABLE_POPULARIZE = "QM_POPULARIZE";
  private static final String TABLE_POPULARIZE_SUB_ITEM = "QM_POPULARIZE_SUBITEM";
  private static final String TAG = "PopularizeSQLite";
  private static final SQLiteDatabase.CursorFactory cursorFactory = null;
  private static final String sqlCreate = "CREATE TABLE IF NOT EXISTS QM_POPULARIZE(id integer primary key, serverId integer, reportId integer, type integer, page integer, bannerPosition integer, bannerHeight real, showType integer, action integer, imageUrl varchar, imageMd5 varchar, openUrl varchar, startTime real, endTime real, duration real, subject varchar, abstracts varchar, content varchar, subInformation varchar, subInformationData varchar, subImageUrl varchar, subImageMd5 varchar, needQQAccount integer, isRender integer, isClick integer, isCancel integer, popularizeAppName varchar, appInstallAction integer, weight integer, lastRenderTime integer, condition integer, relatedId integer, move integer, priority integer, isOpen integer, popularizeAppVersion varchar, resourceType integer, commercialFromEmail varchar, commercialFromNick varchar, commercialConfigHead integer, commercialConfigTool integer, commercialConfigList integer, commercialConfigMark integer, isRead integer default 0, sessionType integer, needWifi integer, adXml varchar, sub_fromnick varchar, sub_subject varchar, sub_abstracts varchar, avatar_url varchar, avatar_url_md5 varchar, isStop integer, isPop integer, product_id integer, turn_id integer )";
  private static final String sqlCreateSubItem = "CREATE TABLE IF NOT EXISTS QM_POPULARIZE_SUBITEM(id integer primary key, serverId integer, popularizeId integer, text varchar, imageUrl varchar, imageMd5 varchar, position integer, sequence integer, showType integer, condition integer, action integer, openUrl varchar, bottomRadio integer, lastRenderTime integer, isRender integer, isClick integer, isCancel integer, isRelated integer, isClickMyApp integer )";
  private static final String sqlDelete = "DELETE FROM QM_POPULARIZE";
  private static final String sqlDeleteSubItem = "DELETE FROM QM_POPULARIZE_SUBITEM";
  private static final String sqlDrop = "DROP TABLE IF EXISTS QM_POPULARIZE";
  private static final String sqlDropSubItem = "DROP TABLE IF EXISTS QM_POPULARIZE_SUBITEM";
  private static final String sqlInsert = "REPLACE INTO QM_POPULARIZE (id , serverId , reportId , type , page , bannerPosition , bannerHeight , showType , action , imageUrl , imageMd5 , openUrl , startTime , endTime , duration , subject , abstracts , content , subInformation , subInformationData , subImageUrl , subImageMd5 , needQQAccount , isRender , isClick , isCancel , popularizeAppName , appInstallAction , weight , lastRenderTime , condition , relatedId , move , priority , isOpen , popularizeAppVersion , resourceType , commercialFromEmail , commercialFromNick , commercialConfigHead , commercialConfigTool , commercialConfigList , commercialConfigMark , isRead , sessionType , needWifi , adXml , sub_fromnick , sub_subject , sub_abstracts , avatar_url , avatar_url_md5 , isStop , isPop , product_id , turn_id  ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
  private static final String sqlInsertSubItem = "REPLACE INTO QM_POPULARIZE_SUBITEM (id , serverId , popularizeId , text , imageUrl , imageMd5 , position , sequence , showType , condition , action , openUrl , bottomRadio , lastRenderTime , isRender , isClick , isCancel , isRelated , isClickMyApp ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
  private static final String sqlQuery = "SELECT * FROM QM_POPULARIZE ORDER BY type, weight DESC";
  private static final String sqlQuerySubItemByPopularizeId = "SELECT * FROM QM_POPULARIZE_SUBITEM WHERE isRelated=? AND popularizeId=?";
  private static final String sqlUpdatePopularizeReadState = "UPDATE QM_POPULARIZE SET isRead =?  WHERE id =? ";
  private static final PopularizeSQLiteDatabaseUpgradeManager upgradeManager = new PopularizeSQLiteDatabaseUpgradeManager();
  private PopularizeCache memoryStore = new PopularizeCache();
  
  public PopularizeSQLiteHelper(Context paramContext)
  {
    super(paramContext, "QMPopularizeDB", cursorFactory, upgradeManager.getVersion());
  }
  
  private static void beginColumnIndex(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null) {
      paramArrayOfInt[0] = 0;
    }
  }
  
  private void createTable(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_POPULARIZE(id integer primary key, serverId integer, reportId integer, type integer, page integer, bannerPosition integer, bannerHeight real, showType integer, action integer, imageUrl varchar, imageMd5 varchar, openUrl varchar, startTime real, endTime real, duration real, subject varchar, abstracts varchar, content varchar, subInformation varchar, subInformationData varchar, subImageUrl varchar, subImageMd5 varchar, needQQAccount integer, isRender integer, isClick integer, isCancel integer, popularizeAppName varchar, appInstallAction integer, weight integer, lastRenderTime integer, condition integer, relatedId integer, move integer, priority integer, isOpen integer, popularizeAppVersion varchar, resourceType integer, commercialFromEmail varchar, commercialFromNick varchar, commercialConfigHead integer, commercialConfigTool integer, commercialConfigList integer, commercialConfigMark integer, isRead integer default 0, sessionType integer, needWifi integer, adXml varchar, sub_fromnick varchar, sub_subject varchar, sub_abstracts varchar, avatar_url varchar, avatar_url_md5 varchar, isStop integer, isPop integer, product_id integer, turn_id integer )");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_POPULARIZE_SUBITEM(id integer primary key, serverId integer, popularizeId integer, text varchar, imageUrl varchar, imageMd5 varchar, position integer, sequence integer, showType integer, condition integer, action integer, openUrl varchar, bottomRadio integer, lastRenderTime integer, isRender integer, isClick integer, isCancel integer, isRelated integer, isClickMyApp integer )");
  }
  
  private void dropTable(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_POPULARIZE");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_POPULARIZE_SUBITEM");
  }
  
  private static int getColumnIndex(int[] paramArrayOfInt, Cursor paramCursor, String paramString)
  {
    if (paramArrayOfInt == null) {
      return paramCursor.getColumnIndex(paramString);
    }
    int i = paramArrayOfInt[0] + 1;
    paramArrayOfInt[0] = i;
    if (paramArrayOfInt[i] > -2147483648) {
      return paramArrayOfInt[i];
    }
    int j = paramCursor.getColumnIndex(paramString);
    paramArrayOfInt[i] = j;
    return j;
  }
  
  private ArrayList<Popularize> queryPopularize(SQLiteDatabase paramSQLiteDatabase)
  {
    localObject2 = null;
    localObject1 = null;
    localArrayList = new ArrayList();
    int[] arrayOfInt = new int[100];
    Arrays.fill(arrayOfInt, -2147483648);
    try
    {
      localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_POPULARIZE ORDER BY type, weight DESC", null);
      if (localCursor != null)
      {
        localObject1 = localCursor;
        localObject2 = localCursor;
        int j = localCursor.getCount();
        int i = 0;
        if (i < j)
        {
          localObject1 = localCursor;
          localObject2 = localCursor;
          localCursor.moveToPosition(i);
          localObject1 = localCursor;
          localObject2 = localCursor;
          Popularize localPopularize = new Popularize();
          localObject1 = localCursor;
          localObject2 = localCursor;
          beginColumnIndex(arrayOfInt);
          localObject1 = localCursor;
          localObject2 = localCursor;
          localPopularize.setId(localCursor.getInt(getColumnIndex(arrayOfInt, localCursor, "id")));
          localObject1 = localCursor;
          localObject2 = localCursor;
          localPopularize.setServerId(localCursor.getInt(getColumnIndex(arrayOfInt, localCursor, "serverId")));
          localObject1 = localCursor;
          localObject2 = localCursor;
          localPopularize.setReportId(localCursor.getInt(getColumnIndex(arrayOfInt, localCursor, "reportId")));
          localObject1 = localCursor;
          localObject2 = localCursor;
          localPopularize.setType(localCursor.getInt(getColumnIndex(arrayOfInt, localCursor, "type")));
          localObject1 = localCursor;
          localObject2 = localCursor;
          localPopularize.setPage(localCursor.getInt(getColumnIndex(arrayOfInt, localCursor, "page")));
          localObject1 = localCursor;
          localObject2 = localCursor;
          localPopularize.setBannerPosition(localCursor.getInt(getColumnIndex(arrayOfInt, localCursor, "bannerPosition")));
          localObject1 = localCursor;
          localObject2 = localCursor;
          localPopularize.setBannerHeight(localCursor.getInt(getColumnIndex(arrayOfInt, localCursor, "bannerHeight")));
          localObject1 = localCursor;
          localObject2 = localCursor;
          localPopularize.setShowType(localCursor.getInt(getColumnIndex(arrayOfInt, localCursor, "showType")));
          localObject1 = localCursor;
          localObject2 = localCursor;
          localPopularize.setAction(localCursor.getInt(getColumnIndex(arrayOfInt, localCursor, "action")));
          localObject1 = localCursor;
          localObject2 = localCursor;
          localPopularize.setImageUrl(localCursor.getString(getColumnIndex(arrayOfInt, localCursor, "imageUrl")));
          localObject1 = localCursor;
          localObject2 = localCursor;
          localPopularize.setImageMd5(localCursor.getString(getColumnIndex(arrayOfInt, localCursor, "imageMd5")));
          localObject1 = localCursor;
          localObject2 = localCursor;
          localPopularize.setOpenUrl(localCursor.getString(getColumnIndex(arrayOfInt, localCursor, "openUrl")));
          localObject1 = localCursor;
          localObject2 = localCursor;
          localPopularize.setStartTime(localCursor.getLong(getColumnIndex(arrayOfInt, localCursor, "startTime")));
          localObject1 = localCursor;
          localObject2 = localCursor;
          localPopularize.setEndTime(localCursor.getLong(getColumnIndex(arrayOfInt, localCursor, "endTime")));
          localObject1 = localCursor;
          localObject2 = localCursor;
          localPopularize.setDuration(localCursor.getLong(getColumnIndex(arrayOfInt, localCursor, "duration")));
          localObject1 = localCursor;
          localObject2 = localCursor;
          localPopularize.setSubject(localCursor.getString(getColumnIndex(arrayOfInt, localCursor, "subject")));
          localObject1 = localCursor;
          localObject2 = localCursor;
          localPopularize.setAbstracts(localCursor.getString(getColumnIndex(arrayOfInt, localCursor, "abstracts")));
          localObject1 = localCursor;
          localObject2 = localCursor;
          localPopularize.setContent(localCursor.getString(getColumnIndex(arrayOfInt, localCursor, "content")));
          localObject1 = localCursor;
          localObject2 = localCursor;
          localPopularize.setSubInformation(localCursor.getString(getColumnIndex(arrayOfInt, localCursor, "subInformation")));
          localObject1 = localCursor;
          localObject2 = localCursor;
          localPopularize.setSubInformationData(localCursor.getString(getColumnIndex(arrayOfInt, localCursor, "subInformationData")));
          localObject1 = localCursor;
          localObject2 = localCursor;
          localPopularize.setSubImageUrl(localCursor.getString(getColumnIndex(arrayOfInt, localCursor, "subImageUrl")));
          localObject1 = localCursor;
          localObject2 = localCursor;
          localPopularize.setSubImageMd5(localCursor.getString(getColumnIndex(arrayOfInt, localCursor, "subImageMd5")));
          localObject1 = localCursor;
          localObject2 = localCursor;
          if (localCursor.getInt(getColumnIndex(arrayOfInt, localCursor, "needQQAccount")) == 1)
          {
            bool = true;
            label786:
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setNeedQQAccount(bool);
            localObject1 = localCursor;
            localObject2 = localCursor;
            if (localCursor.getInt(getColumnIndex(arrayOfInt, localCursor, "isRender")) != 1) {
              break label2071;
            }
            bool = true;
            label832:
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setRender(bool);
            localObject1 = localCursor;
            localObject2 = localCursor;
            if (localCursor.getInt(getColumnIndex(arrayOfInt, localCursor, "isClick")) != 1) {
              break label2077;
            }
            bool = true;
            label878:
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setClick(bool);
            localObject1 = localCursor;
            localObject2 = localCursor;
            if (localCursor.getInt(getColumnIndex(arrayOfInt, localCursor, "isCancel")) != 1) {
              break label2083;
            }
            bool = true;
            label924:
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setCancel(bool);
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setPopularizeAppName(localCursor.getString(getColumnIndex(arrayOfInt, localCursor, "popularizeAppName")));
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setPopularizeAppVersion(localCursor.getString(getColumnIndex(arrayOfInt, localCursor, "popularizeAppVersion")));
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setAppInstallAction(localCursor.getInt(getColumnIndex(arrayOfInt, localCursor, "appInstallAction")));
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setWeight(localCursor.getInt(getColumnIndex(arrayOfInt, localCursor, "weight")));
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setLastRenderTime(localCursor.getLong(getColumnIndex(arrayOfInt, localCursor, "lastRenderTime")));
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setSubItems(querySubItem(paramSQLiteDatabase, localPopularize.getId(), false));
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setCondition(localCursor.getInt(getColumnIndex(arrayOfInt, localCursor, "condition")));
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setRelatedId(localCursor.getInt(getColumnIndex(arrayOfInt, localCursor, "relatedId")));
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setMove(localCursor.getInt(getColumnIndex(arrayOfInt, localCursor, "move")));
            localObject1 = localCursor;
            localObject2 = localCursor;
            if (localCursor.getInt(getColumnIndex(arrayOfInt, localCursor, "isOpen")) != 1) {
              break label2089;
            }
            bool = true;
            label1226:
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setIsOpen(bool);
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setResourceType(localCursor.getInt(getColumnIndex(arrayOfInt, localCursor, "resourceType")));
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setCommercialFromEmail(localCursor.getString(getColumnIndex(arrayOfInt, localCursor, "commercialFromEmail")));
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setCommercialFromNick(localCursor.getString(getColumnIndex(arrayOfInt, localCursor, "commercialFromNick")));
            localObject1 = localCursor;
            localObject2 = localCursor;
            if (localCursor.getInt(getColumnIndex(arrayOfInt, localCursor, "commercialConfigHead")) != 1) {
              break label2095;
            }
            bool = true;
            label1359:
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setCommercialConfigHead(bool);
            localObject1 = localCursor;
            localObject2 = localCursor;
            if (localCursor.getInt(getColumnIndex(arrayOfInt, localCursor, "commercialConfigTool")) != 1) {
              break label2101;
            }
            bool = true;
            label1405:
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setCommercialConfigTool(bool);
            localObject1 = localCursor;
            localObject2 = localCursor;
            if (localCursor.getInt(getColumnIndex(arrayOfInt, localCursor, "commercialConfigList")) != 1) {
              break label2107;
            }
            bool = true;
            label1451:
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setCommercialConfigList(bool);
            localObject1 = localCursor;
            localObject2 = localCursor;
            if (localCursor.getInt(getColumnIndex(arrayOfInt, localCursor, "commercialConfigMark")) != 1) {
              break label2113;
            }
            bool = true;
            label1497:
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setCommercialConfigMark(bool);
            localObject1 = localCursor;
            localObject2 = localCursor;
            if (localCursor.getInt(getColumnIndex(arrayOfInt, localCursor, "isRead")) != 1) {
              break label2119;
            }
            bool = true;
            label1543:
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setIsRead(bool);
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setSessionType(localCursor.getInt(getColumnIndex(arrayOfInt, localCursor, "sessionType")));
            localObject1 = localCursor;
            localObject2 = localCursor;
            if (localCursor.getInt(getColumnIndex(arrayOfInt, localCursor, "needWifi")) != 1) {
              break label2125;
            }
            bool = true;
            label1618:
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setNeedWifi(bool);
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setAdXml(localCursor.getString(getColumnIndex(arrayOfInt, localCursor, "adXml")));
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setSub_fromnick(localCursor.getString(getColumnIndex(arrayOfInt, localCursor, "sub_fromnick")));
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setSub_subject(localCursor.getString(getColumnIndex(arrayOfInt, localCursor, "sub_subject")));
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setSub_abstracts(localCursor.getString(getColumnIndex(arrayOfInt, localCursor, "sub_abstracts")));
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setAvatar_url(localCursor.getString(getColumnIndex(arrayOfInt, localCursor, "avatar_url")));
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setAvatar_url_md5(localCursor.getString(getColumnIndex(arrayOfInt, localCursor, "avatar_url_md5")));
            localObject1 = localCursor;
            localObject2 = localCursor;
            if (localCursor.getInt(getColumnIndex(arrayOfInt, localCursor, "isStop")) != 1) {
              break label2131;
            }
            bool = true;
            label1838:
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setStop(bool);
            localObject1 = localCursor;
            localObject2 = localCursor;
            if (localCursor.getInt(getColumnIndex(arrayOfInt, localCursor, "isPop")) != 1) {
              break label2137;
            }
          }
          label2071:
          label2077:
          label2083:
          label2089:
          label2095:
          label2101:
          label2107:
          label2113:
          label2119:
          label2125:
          label2131:
          label2137:
          for (boolean bool = true;; bool = false)
          {
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setPopByNewMail(bool);
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setTurnId(localCursor.getInt(getColumnIndex(arrayOfInt, localCursor, "turn_id")));
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setProductId(localCursor.getInt(getColumnIndex(arrayOfInt, localCursor, "product_id")));
            localObject1 = localCursor;
            localObject2 = localCursor;
            PopularizeAppConfig localPopularizeAppConfig = new PopularizeAppConfig();
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularizeAppConfig.setPriority(localCursor.getInt(getColumnIndex(arrayOfInt, localCursor, "priority")));
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularizeAppConfig.setSubitems(querySubItem(paramSQLiteDatabase, localPopularize.getId(), true));
            localObject1 = localCursor;
            localObject2 = localCursor;
            localPopularize.setAppConfig(localPopularizeAppConfig);
            localObject1 = localCursor;
            localObject2 = localCursor;
            localArrayList.add(localPopularize);
            i += 1;
            break;
            bool = false;
            break label786;
            bool = false;
            break label832;
            bool = false;
            break label878;
            bool = false;
            break label924;
            bool = false;
            break label1226;
            bool = false;
            break label1359;
            bool = false;
            break label1405;
            bool = false;
            break label1451;
            bool = false;
            break label1497;
            bool = false;
            break label1543;
            bool = false;
            break label1618;
            bool = false;
            break label1838;
          }
        }
      }
    }
    catch (Exception paramSQLiteDatabase)
    {
      Cursor localCursor;
      localObject2 = localObject1;
      QMLog.log(6, "PopularizeSQLite", paramSQLiteDatabase.getMessage());
      return localArrayList;
    }
    finally
    {
      if (localObject2 == null) {
        break label2202;
      }
      localObject2.close();
    }
    return localArrayList;
  }
  
  public void deleteAllPopularize(SQLiteDatabase paramSQLiteDatabase)
  {
    this.memoryStore.clear();
    paramSQLiteDatabase.execSQL("DELETE FROM QM_POPULARIZE");
    paramSQLiteDatabase.execSQL("DELETE FROM QM_POPULARIZE_SUBITEM");
  }
  
  public void deletePopularizeById(int paramInt, SQLiteDatabase paramSQLiteDatabase)
  {
    this.memoryStore.deleteByKey(Integer.valueOf(paramInt), new PopularizeSQLiteHelper.2(this, paramInt, paramSQLiteDatabase));
  }
  
  public void initCache(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase = queryPopularize(paramSQLiteDatabase).iterator();
    while (paramSQLiteDatabase.hasNext())
    {
      Popularize localPopularize = (Popularize)paramSQLiteDatabase.next();
      this.memoryStore.insert(Integer.valueOf(localPopularize.getId()), localPopularize);
    }
    QMLog.log(4, "PopularizeSQLite", "init cache size " + this.memoryStore.size());
  }
  
  /* Error */
  public void insertPopularize(SQLiteDatabase paramSQLiteDatabase, ArrayList<Popularize> paramArrayList)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +82 -> 83
    //   4: aload_2
    //   5: invokevirtual 619	java/util/ArrayList:size	()I
    //   8: ifle +75 -> 83
    //   11: aload_1
    //   12: invokevirtual 622	com/tencent/moai/database/sqlite/SQLiteDatabase:beginTransactionNonExclusive	()V
    //   15: aload_2
    //   16: invokevirtual 584	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   19: astore_2
    //   20: aload_2
    //   21: invokeinterface 590 1 0
    //   26: ifeq +58 -> 84
    //   29: aload_2
    //   30: invokeinterface 594 1 0
    //   35: checkcast 327	com/tencent/qqmail/popularize/model/Popularize
    //   38: astore_3
    //   39: aload_0
    //   40: getfield 282	com/tencent/qqmail/popularize/PopularizeSQLiteHelper:memoryStore	Lcom/tencent/qqmail/model/cache/PopularizeCache;
    //   43: aload_3
    //   44: invokevirtual 444	com/tencent/qqmail/popularize/model/Popularize:getId	()I
    //   47: invokestatic 568	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   50: aload_3
    //   51: new 624	com/tencent/qqmail/popularize/PopularizeSQLiteHelper$1
    //   54: dup
    //   55: aload_0
    //   56: aload_3
    //   57: aload_1
    //   58: invokespecial 627	com/tencent/qqmail/popularize/PopularizeSQLiteHelper$1:<init>	(Lcom/tencent/qqmail/popularize/PopularizeSQLiteHelper;Lcom/tencent/qqmail/popularize/model/Popularize;Lcom/tencent/moai/database/sqlite/SQLiteDatabase;)V
    //   61: invokevirtual 630	com/tencent/qqmail/model/cache/PopularizeCache:insert	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Runnable;)V
    //   64: goto -44 -> 20
    //   67: astore_2
    //   68: bipush 6
    //   70: ldc 218
    //   72: aload_2
    //   73: invokevirtual 548	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   76: invokestatic 554	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   79: aload_1
    //   80: invokevirtual 633	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   83: return
    //   84: aload_1
    //   85: invokevirtual 636	com/tencent/moai/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   88: aload_1
    //   89: invokevirtual 633	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   92: return
    //   93: astore_2
    //   94: aload_1
    //   95: invokevirtual 633	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   98: aload_2
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	PopularizeSQLiteHelper
    //   0	100	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	100	2	paramArrayList	ArrayList<Popularize>
    //   38	19	3	localPopularize	Popularize
    // Exception table:
    //   from	to	target	type
    //   11	20	67	java/lang/Exception
    //   20	64	67	java/lang/Exception
    //   84	88	67	java/lang/Exception
    //   11	20	93	finally
    //   20	64	93	finally
    //   68	79	93	finally
    //   84	88	93	finally
  }
  
  public void insertPopularizeSubItem(SQLiteDatabase paramSQLiteDatabase, ArrayList<PopularizeSubItem> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    if (paramArrayList.hasNext())
    {
      PopularizeSubItem localPopularizeSubItem = (PopularizeSubItem)paramArrayList.next();
      int i1 = localPopularizeSubItem.getId();
      int i2 = localPopularizeSubItem.getServerId();
      int i3 = localPopularizeSubItem.getPopularizeId();
      String str1 = localPopularizeSubItem.getText();
      String str2 = localPopularizeSubItem.getImageUrl();
      String str3 = localPopularizeSubItem.getImageMd5();
      int i4 = localPopularizeSubItem.getPosition();
      int i5 = localPopularizeSubItem.getSequence();
      int i6 = localPopularizeSubItem.getShowType();
      int i7 = localPopularizeSubItem.getCondition();
      int i8 = localPopularizeSubItem.getAction();
      String str4 = localPopularizeSubItem.getOpenUrl();
      int i9 = localPopularizeSubItem.getBottomRatio();
      long l = localPopularizeSubItem.getLastRenderTime();
      int i;
      label133:
      int j;
      label144:
      int k;
      label155:
      int m;
      if (localPopularizeSubItem.isRender())
      {
        i = 1;
        if (!localPopularizeSubItem.isClick()) {
          break label348;
        }
        j = 1;
        if (!localPopularizeSubItem.isCancel()) {
          break label354;
        }
        k = 1;
        if (!localPopularizeSubItem.isRelated()) {
          break label360;
        }
        m = 1;
        label166:
        if (!localPopularizeSubItem.isClickMyApp()) {
          break label366;
        }
      }
      label348:
      label354:
      label360:
      label366:
      for (int n = 1;; n = 0)
      {
        paramSQLiteDatabase.execSQL("REPLACE INTO QM_POPULARIZE_SUBITEM (id , serverId , popularizeId , text , imageUrl , imageMd5 , position , sequence , showType , condition , action , openUrl , bottomRadio , lastRenderTime , isRender , isClick , isCancel , isRelated , isClickMyApp ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), str1, str2, str3, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), str4, Integer.valueOf(i9), Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n) });
        break;
        i = 0;
        break label133;
        j = 0;
        break label144;
        k = 0;
        break label155;
        m = 0;
        break label166;
      }
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    createTable(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    QMLog.log(4, "SQLiteDatabase", "Try Upgrade: from " + paramInt1 + " to " + paramInt2 + ", minVer:" + upgradeManager.getMinSupportVersion());
    if (paramInt1 < upgradeManager.getMinSupportVersion())
    {
      dropTable(paramSQLiteDatabase);
      createTable(paramSQLiteDatabase);
      return;
    }
    if (upgradeManager.upgrade(this, paramSQLiteDatabase, paramInt1))
    {
      QMLog.log(4, "SQLiteDatabase", "Upgraded from " + paramInt1 + " to " + paramInt2);
      return;
    }
    QMLog.log(4, "SQLiteDatabase", "No need upgrade from " + paramInt1 + " to " + paramInt2);
  }
  
  public Popularize queryPopularizeById(int paramInt)
  {
    return (Popularize)this.memoryStore.get(Integer.valueOf(paramInt));
  }
  
  public Popularize queryPopularizeBySvrId(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    this.memoryStore.select(new PopularizeSQLiteHelper.6(this, paramInt, localArrayList));
    if (localArrayList.size() > 0) {
      return (Popularize)localArrayList.get(0);
    }
    return null;
  }
  
  public ArrayList<Popularize> queryPopularizeList()
  {
    ArrayList localArrayList = new ArrayList();
    this.memoryStore.select(new PopularizeSQLiteHelper.5(this, localArrayList));
    return localArrayList;
  }
  
  public ArrayList<Popularize> queryPopularizeList(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    this.memoryStore.select(new PopularizeSQLiteHelper.3(this, paramInt, localArrayList));
    return localArrayList;
  }
  
  @NonNull
  public ArrayList<Popularize> queryPopularizeListByType(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    this.memoryStore.select(new PopularizeSQLiteHelper.4(this, paramInt, localArrayList));
    return localArrayList;
  }
  
  public PopularizeSubItem queryPopularizeSubItemById(int paramInt1, int paramInt2)
  {
    Object localObject = (Popularize)this.memoryStore.get(Integer.valueOf(paramInt1));
    if (localObject != null)
    {
      localObject = ((Popularize)localObject).getSubItems();
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          PopularizeSubItem localPopularizeSubItem = (PopularizeSubItem)((Iterator)localObject).next();
          if (localPopularizeSubItem.getId() == paramInt2) {
            return localPopularizeSubItem;
          }
        }
      }
    }
    return null;
  }
  
  public ArrayList<PopularizeSubItem> querySubItem(SQLiteDatabase paramSQLiteDatabase, int paramInt, boolean paramBoolean)
  {
    localArrayList = new ArrayList();
    int[] arrayOfInt = new int[100];
    Arrays.fill(arrayOfInt, -2147483648);
    localObject = null;
    localSQLiteDatabase = null;
    int i;
    if (paramBoolean) {
      i = 1;
    }
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_POPULARIZE_SUBITEM WHERE isRelated=? AND popularizeId=?", new String[] { String.valueOf(i), String.valueOf(paramInt) });
      label543:
      label582:
      if (paramSQLiteDatabase != null)
      {
        localSQLiteDatabase = paramSQLiteDatabase;
        localObject = paramSQLiteDatabase;
        i = paramSQLiteDatabase.getCount();
        paramInt = 0;
        label82:
        if (paramInt < i)
        {
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          paramSQLiteDatabase.moveToPosition(paramInt);
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          PopularizeSubItem localPopularizeSubItem = new PopularizeSubItem();
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          beginColumnIndex(arrayOfInt);
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          localPopularizeSubItem.setId(paramSQLiteDatabase.getInt(getColumnIndex(arrayOfInt, paramSQLiteDatabase, "id")));
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          localPopularizeSubItem.setServerId(paramSQLiteDatabase.getInt(getColumnIndex(arrayOfInt, paramSQLiteDatabase, "serverId")));
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          localPopularizeSubItem.setPopularizeId(paramSQLiteDatabase.getInt(getColumnIndex(arrayOfInt, paramSQLiteDatabase, "popularizeId")));
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          localPopularizeSubItem.setText(paramSQLiteDatabase.getString(getColumnIndex(arrayOfInt, paramSQLiteDatabase, "text")));
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          localPopularizeSubItem.setImageUrl(paramSQLiteDatabase.getString(getColumnIndex(arrayOfInt, paramSQLiteDatabase, "imageUrl")));
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          localPopularizeSubItem.setImageMd5(paramSQLiteDatabase.getString(getColumnIndex(arrayOfInt, paramSQLiteDatabase, "imageMd5")));
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          localPopularizeSubItem.setPosition(paramSQLiteDatabase.getInt(getColumnIndex(arrayOfInt, paramSQLiteDatabase, "position")));
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          localPopularizeSubItem.setSequence(paramSQLiteDatabase.getInt(getColumnIndex(arrayOfInt, paramSQLiteDatabase, "sequence")));
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          localPopularizeSubItem.setShowType(paramSQLiteDatabase.getInt(getColumnIndex(arrayOfInt, paramSQLiteDatabase, "showType")));
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          localPopularizeSubItem.setCondition(paramSQLiteDatabase.getInt(getColumnIndex(arrayOfInt, paramSQLiteDatabase, "condition")));
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          localPopularizeSubItem.setAction(paramSQLiteDatabase.getInt(getColumnIndex(arrayOfInt, paramSQLiteDatabase, "action")));
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          localPopularizeSubItem.setOpenUrl(paramSQLiteDatabase.getString(getColumnIndex(arrayOfInt, paramSQLiteDatabase, "openUrl")));
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          localPopularizeSubItem.setBottomRatio(paramSQLiteDatabase.getInt(getColumnIndex(arrayOfInt, paramSQLiteDatabase, "bottomRadio")));
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          localPopularizeSubItem.setLastRenderTime(paramSQLiteDatabase.getLong(getColumnIndex(arrayOfInt, paramSQLiteDatabase, "lastRenderTime")));
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          if (paramSQLiteDatabase.getInt(getColumnIndex(arrayOfInt, paramSQLiteDatabase, "isRender")) != 0)
          {
            bool = true;
            label504:
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            localPopularizeSubItem.setIsRender(bool);
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            if (paramSQLiteDatabase.getInt(getColumnIndex(arrayOfInt, paramSQLiteDatabase, "isCancel")) == 0) {
              break label679;
            }
            bool = true;
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            localPopularizeSubItem.setIsCancel(bool);
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            if (paramSQLiteDatabase.getInt(getColumnIndex(arrayOfInt, paramSQLiteDatabase, "isClick")) == 0) {
              break label685;
            }
            bool = true;
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            localPopularizeSubItem.setIsClick(bool);
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            if (paramSQLiteDatabase.getInt(getColumnIndex(arrayOfInt, paramSQLiteDatabase, "isClickMyApp")) == 0) {
              break label691;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            localPopularizeSubItem.setIsClickMyApp(bool);
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            localPopularizeSubItem.setIsRelated(paramBoolean);
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            localArrayList.add(localPopularizeSubItem);
            paramInt += 1;
            break label82;
            i = 0;
            break;
            bool = false;
            break label504;
            bool = false;
            break label543;
            bool = false;
            break label582;
          }
        }
      }
      label679:
      label685:
      label691:
      if (paramSQLiteDatabase != null) {
        paramSQLiteDatabase.close();
      }
    }
    catch (Exception paramSQLiteDatabase)
    {
      do
      {
        localObject = localSQLiteDatabase;
        QMLog.log(6, "PopularizeSQLite", paramSQLiteDatabase.getMessage());
      } while (localSQLiteDatabase == null);
      localSQLiteDatabase.close();
      return localArrayList;
    }
    finally
    {
      if (localObject == null) {
        break label754;
      }
      ((Cursor)localObject).close();
    }
    return localArrayList;
  }
  
  public void updateIsCancel(SQLiteDatabase paramSQLiteDatabase, int paramInt, boolean paramBoolean)
  {
    this.memoryStore.updateByKey(Integer.valueOf(paramInt), new PopularizeSQLiteHelper.13(this, paramBoolean), new PopularizeSQLiteHelper.14(this, paramBoolean, paramSQLiteDatabase, paramInt));
  }
  
  public void updateIsClick(SQLiteDatabase paramSQLiteDatabase, int paramInt, boolean paramBoolean)
  {
    this.memoryStore.updateByKey(Integer.valueOf(paramInt), new PopularizeSQLiteHelper.11(this, paramBoolean), new PopularizeSQLiteHelper.12(this, paramBoolean, paramSQLiteDatabase, paramInt));
  }
  
  public void updateIsOpen(SQLiteDatabase paramSQLiteDatabase, int paramInt, boolean paramBoolean)
  {
    this.memoryStore.updateByKey(Integer.valueOf(paramInt), new PopularizeSQLiteHelper.19(this, paramBoolean), new PopularizeSQLiteHelper.20(this, paramBoolean, paramSQLiteDatabase, paramInt));
  }
  
  public void updateIsPopByNewMail(SQLiteDatabase paramSQLiteDatabase, int paramInt, boolean paramBoolean)
  {
    this.memoryStore.updateByKey(Integer.valueOf(paramInt), new PopularizeSQLiteHelper.15(this, paramBoolean), new PopularizeSQLiteHelper.16(this, paramBoolean, paramSQLiteDatabase, paramInt));
  }
  
  public void updateMove(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    this.memoryStore.updateByKey(Integer.valueOf(paramInt1), new PopularizeSQLiteHelper.17(this, paramInt2), new PopularizeSQLiteHelper.18(this, paramInt2, paramSQLiteDatabase, paramInt1));
  }
  
  public void updatePopularizeIsRead(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {}
    for (String str = "1";; str = "0") {
      try
      {
        paramSQLiteDatabase.execSQL("UPDATE QM_POPULARIZE SET isRead =?  WHERE id =? ", new Object[] { str, String.valueOf(paramInt) });
        return;
      }
      catch (Exception paramSQLiteDatabase)
      {
        QMLog.log(6, "PopularizeSQLite", Log.getStackTraceString(paramSQLiteDatabase));
      }
    }
  }
  
  public void updatePopularizeListIsRender(SQLiteDatabase paramSQLiteDatabase, ArrayList<Popularize> paramArrayList, boolean paramBoolean)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramSQLiteDatabase.beginTransaction();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Popularize localPopularize = (Popularize)paramArrayList.next();
        this.memoryStore.updateByKey(Integer.valueOf(localPopularize.getId()), new PopularizeSQLiteHelper.9(this, paramBoolean), new PopularizeSQLiteHelper.10(this, paramBoolean, paramSQLiteDatabase, localPopularize));
      }
      paramSQLiteDatabase.setTransactionSuccessful();
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  public void updatePopularizeListRenderTime(SQLiteDatabase paramSQLiteDatabase, ArrayList<Popularize> paramArrayList, long paramLong)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramSQLiteDatabase.beginTransaction();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Popularize localPopularize = (Popularize)paramArrayList.next();
        this.memoryStore.updateByKey(Integer.valueOf(localPopularize.getId()), new PopularizeSQLiteHelper.7(this, paramLong), new PopularizeSQLiteHelper.8(this, paramLong, paramSQLiteDatabase, localPopularize));
      }
      paramSQLiteDatabase.setTransactionSuccessful();
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  public void updateSubInfomationData(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    this.memoryStore.update(new PopularizeSQLiteHelper.31(this, paramString1, paramString2), new PopularizeSQLiteHelper.32(this, paramString2, paramSQLiteDatabase, paramString1));
  }
  
  public void updateSubItemIsCancel(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.memoryStore.updateByKey(Integer.valueOf(paramInt1), new PopularizeSQLiteHelper.29(this, paramInt1, paramInt2, paramBoolean), new PopularizeSQLiteHelper.30(this, paramBoolean, paramSQLiteDatabase, paramInt2));
  }
  
  public void updateSubItemIsClick(SQLiteDatabase paramSQLiteDatabase, ArrayList<PopularizeSubItem> paramArrayList, boolean paramBoolean)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramSQLiteDatabase.beginTransaction();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        PopularizeSubItem localPopularizeSubItem = (PopularizeSubItem)paramArrayList.next();
        this.memoryStore.updateByKey(Integer.valueOf(localPopularizeSubItem.getPopularizeId()), new PopularizeSQLiteHelper.25(this, localPopularizeSubItem, paramBoolean), new PopularizeSQLiteHelper.26(this, paramBoolean, paramSQLiteDatabase, localPopularizeSubItem));
      }
      paramSQLiteDatabase.setTransactionSuccessful();
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  public void updateSubItemIsClickMyApp(SQLiteDatabase paramSQLiteDatabase, ArrayList<PopularizeSubItem> paramArrayList, boolean paramBoolean)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramSQLiteDatabase.beginTransaction();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        PopularizeSubItem localPopularizeSubItem = (PopularizeSubItem)paramArrayList.next();
        this.memoryStore.updateByKey(Integer.valueOf(localPopularizeSubItem.getPopularizeId()), new PopularizeSQLiteHelper.27(this, localPopularizeSubItem, paramBoolean), new PopularizeSQLiteHelper.28(this, paramBoolean, paramSQLiteDatabase, localPopularizeSubItem));
      }
      paramSQLiteDatabase.setTransactionSuccessful();
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  public void updateSubItemIsRender(SQLiteDatabase paramSQLiteDatabase, ArrayList<PopularizeSubItem> paramArrayList, boolean paramBoolean)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramSQLiteDatabase.beginTransaction();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        PopularizeSubItem localPopularizeSubItem = (PopularizeSubItem)paramArrayList.next();
        this.memoryStore.updateByKey(Integer.valueOf(localPopularizeSubItem.getPopularizeId()), new PopularizeSQLiteHelper.21(this, localPopularizeSubItem, paramBoolean), new PopularizeSQLiteHelper.22(this, paramBoolean, paramSQLiteDatabase, localPopularizeSubItem));
      }
      paramSQLiteDatabase.setTransactionSuccessful();
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  public void updateSubItemLastRenderTime(SQLiteDatabase paramSQLiteDatabase, ArrayList<PopularizeSubItem> paramArrayList, long paramLong)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramSQLiteDatabase.beginTransaction();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        PopularizeSubItem localPopularizeSubItem = (PopularizeSubItem)paramArrayList.next();
        this.memoryStore.updateByKey(Integer.valueOf(localPopularizeSubItem.getPopularizeId()), new PopularizeSQLiteHelper.23(this, localPopularizeSubItem, paramLong), new PopularizeSQLiteHelper.24(this, paramLong, paramSQLiteDatabase, localPopularizeSubItem));
      }
      paramSQLiteDatabase.setTransactionSuccessful();
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  public void upgradeForTableFor5250(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_POPULARIZE ADD COLUMN adXml VARCHAR");
  }
  
  public void upgradeForTableFor5270(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_POPULARIZE ADD COLUMN sub_fromnick VARCHAR");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_POPULARIZE ADD COLUMN sub_subject VARCHAR");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_POPULARIZE ADD COLUMN sub_abstracts VARCHAR");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_POPULARIZE ADD COLUMN avatar_url VARCHAR");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_POPULARIZE ADD COLUMN avatar_url_md5 VARCHAR");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_POPULARIZE ADD COLUMN isStop INTEGER");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_POPULARIZE ADD COLUMN isPop INTEGER");
  }
  
  public void upgradeForTableFor5330(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_POPULARIZE ADD COLUMN product_id INTEGER");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_POPULARIZE ADD COLUMN turn_id INTEGER");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.PopularizeSQLiteHelper
 * JD-Core Version:    0.7.0.1
 */