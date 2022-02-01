package com.tencent.qqmail.card;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.QMBaseSQLiteOpenHelper;
import com.tencent.qqmail.card.model.QMCardData;
import com.tencent.qqmail.card.model.QMCardFriendInfo;
import com.tencent.qqmail.card.model.QMCardPara;
import com.tencent.qqmail.card.model.QMCardType;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class QMCardSQLiteHelper
  extends QMBaseSQLiteOpenHelper
{
  protected static final String FIELD_CARD_BIRTHDAY_FRIEND_BIRTHDAY = "birthday";
  protected static final String FIELD_CARD_BIRTHDAY_FRIEND_EMAIL = "email";
  protected static final String FIELD_CARD_BIRTHDAY_FRIEND_ICON = "icon";
  protected static final String FIELD_CARD_BIRTHDAY_FRIEND_ID = "id";
  protected static final String FIELD_CARD_BIRTHDAY_FRIEND_IS_CHINESE = "isChinese";
  protected static final String FIELD_CARD_BIRTHDAY_FRIEND_IS_SEND = "isSend";
  protected static final String FIELD_CARD_BIRTHDAY_FRIEND_NICKNAME = "nickName";
  protected static final String FIELD_CARD_BIRTHDAY_FRIEND_TO_DAY_TO = "toDayTo";
  protected static final String FIELD_CARD_BIRTHDAY_FRIEND_UIN = "uin";
  protected static final String FIELD_CARD_DATA_CARD_ID = "cardId";
  protected static final String FIELD_CARD_DATA_CIRCLE_LIMIT = "circleLimit";
  protected static final String FIELD_CARD_DATA_CONTENT_CARD_URL = "cardUrl";
  protected static final String FIELD_CARD_DATA_CONTENT_CONTENT = "content";
  protected static final String FIELD_CARD_DATA_COVER_URL = "coverUrl";
  protected static final String FIELD_CARD_DATA_FRIEND_NUM = "friendnum";
  protected static final String FIELD_CARD_DATA_FRIEND_TYPE = "friendtype";
  protected static final String FIELD_CARD_DATA_IS_COMPLETE = "isComplete";
  protected static final String FIELD_CARD_DATA_MAIL_TITLE = "mailTitle";
  protected static final String FIELD_CARD_DATA_MAIL_URL = "mailUrl";
  protected static final String FIELD_CARD_DATA_MAIL_WORD = "mailWord";
  protected static final String FIELD_CARD_DATA_NAME = "name";
  protected static final String FIELD_CARD_DATA_ONE_PX_URL = "onePxUrl";
  protected static final String FIELD_CARD_DATA_PAGE_TYPE = "pagetype";
  protected static final String FIELD_CARD_DATA_PRIORITY = "priority";
  protected static final String FIELD_CARD_DATA_QQ_SHARE_LIMIT = "qqsharelimit";
  protected static final String FIELD_CARD_DATA_SEQ_TYPE = "seqtype";
  protected static final String FIELD_CARD_DATA_SHARE_TITLE = "shareTitle";
  protected static final String FIELD_CARD_DATA_SHARE_WORD = "shareWord";
  protected static final String FIELD_CARD_DATA_TAG = "tag";
  protected static final String FIELD_CARD_DATA_THANKS_COUNT = "thanksCount";
  protected static final String FIELD_CARD_DATA_THUMB_URL = "thumbUrl";
  protected static final String FIELD_CARD_DATA_TYPE_CARD_ID = "cardId";
  protected static final String FIELD_CARD_DATA_TYPE_TYPE_ID = "typeId";
  protected static final String FIELD_CARD_DATA_URL = "cardUrl";
  protected static final String FIELD_CARD_DATA_VIEW_COUNT = "viewCount";
  protected static final String FIELD_CARD_DATA_WX_SHARE_LIMIT = "wxsharelimit";
  protected static final String FIELD_CARD_PARA_CARD_ID = "cardId";
  protected static final String FIELD_CARD_PARA_DEFAULT_VALUE = "defaultValue";
  protected static final String FIELD_CARD_PARA_DOM_ID = "domId";
  protected static final String FIELD_CARD_PARA_KEY = "key";
  protected static final String FIELD_CARD_PARA_LIMIT_COUNT = "limitCount";
  protected static final String FIELD_CARD_PARA_NAME = "name";
  protected static final String FIELD_CARD_PARA_TYPE = "type";
  protected static final String FIELD_CARD_PARA_VALUE = "value";
  protected static final String FIELD_CARD_THANKS_FRIEND_CARD_ID = "cardId";
  protected static final String FIELD_CARD_THANKS_FRIEND_ICON = "icon";
  protected static final String FIELD_CARD_THANKS_FRIEND_ID = "id";
  protected static final String FIELD_CARD_THANKS_FRIEND_NICKNAME = "nickName";
  protected static final String FIELD_CARD_TYPE_AVATAR = "avatar";
  protected static final String FIELD_CARD_TYPE_EMPTY_TIP = "emptyTip";
  protected static final String FIELD_CARD_TYPE_IS_DEFAULT = "isDefault";
  protected static final String FIELD_CARD_TYPE_MAXID = "maxId";
  protected static final String FIELD_CARD_TYPE_NAME = "name";
  protected static final String FIELD_CARD_TYPE_PRIORITY = "priority";
  protected static final String FIELD_CARD_TYPE_SYNCKEY = "syncKey";
  protected static final String FIELD_CARD_TYPE_TYPE_ID = "typeId";
  protected static final String FILENAME = "QMCardDB";
  protected static final String TABLE_CARD_BIRTHDAY_FRIEND = "QM_CARD_BIRTHDAY_FRIEND";
  protected static final String TABLE_CARD_DATA = "QM_CARD_DATA";
  protected static final String TABLE_CARD_DATA_CONTENT = "QM_CARD_DATA_CONTENT";
  protected static final String TABLE_CARD_DATA_TYPE = "QM_CARD_DATA_TYPE";
  protected static final String TABLE_CARD_PARA = "QM_CARD_PARA";
  protected static final String TABLE_CARD_THANKS_FRIEND = "QM_CARD_THANKS_FRIEND";
  protected static final String TABLE_CARD_TYPE = "QM_CARD_TYPE";
  private static final String TAG = "CardSQLite";
  private static final String sqlCreateBirthdayFriend = "CREATE TABLE IF NOT EXISTS QM_CARD_BIRTHDAY_FRIEND(id varchar primary key, uin integer, email varchar, nickName varchar, birthday varchar, isChinese integer, toDayTo integer, icon varchar, isSend integer )";
  private static final String sqlCreateCardData = "CREATE TABLE IF NOT EXISTS QM_CARD_DATA(cardId varchar primary key, name varchar, cardUrl varchar, viewCount integer, thanksCount integer, thumbUrl varchar, mailUrl varchar, coverUrl varchar, onePxUrl varchar, isComplete integer, priority real, tag varchar, mailTitle varchar, mailWord varchar, shareTitle varchar, shareWord varchar, circleLimit integer default 1, pagetype integer default 0, friendtype integer default 0, seqtype integer default 0, friendnum integer default 0, wxsharelimit integer default 0, qqsharelimit integer default 0)";
  private static final String sqlCreateCardDataContent = "CREATE TABLE IF NOT EXISTS QM_CARD_DATA_CONTENT(cardUrl varchar primary key, content varchar )";
  private static final String sqlCreateCardDataType = "CREATE TABLE IF NOT EXISTS QM_CARD_DATA_TYPE(cardId integer, typeId integer )";
  private static final String sqlCreateCardPara = "CREATE TABLE IF NOT EXISTS QM_CARD_PARA(cardId integer, key varchar, name varchar, value varchar, defaultValue varchar, limitCount integer, domId varchar, type integer, primary key(cardId,key))";
  private static final String sqlCreateCardType = "CREATE TABLE IF NOT EXISTS QM_CARD_TYPE(typeId integer primary key, name varchar, avatar varchar, syncKey varchar, maxId integer, priority real, isDefault integer, emptyTip varchar )";
  private static final String sqlCreateThanksFriend = "CREATE TABLE IF NOT EXISTS QM_CARD_THANKS_FRIEND(id varchar, cardId integer, nickName varchar, icon varchar, primary key(cardId,id))";
  private static final String sqlDeleteBirthdayFriend = "DELETE FROM QM_CARD_BIRTHDAY_FRIEND";
  private static final String sqlDeleteCardContent = "DELETE FROM QM_CARD_DATA_CONTENT";
  private static final String sqlDeleteCardData = "DELETE FROM QM_CARD_DATA";
  private static final String sqlDeleteCardDataByByCardId = "DELETE FROM QM_CARD_DATA WHERE cardId = ?";
  private static final String sqlDeleteCardDataType = "DELETE FROM QM_CARD_DATA_TYPE";
  private static final String sqlDeleteCardDataTypeWithCardIdAndTypeId = "DELETE FROM QM_CARD_DATA_TYPE WHERE cardId = ? AND typeId = ?";
  private static final String sqlDeleteCardDataTypeWithTypeId = "DELETE FROM QM_CARD_DATA_TYPE WHERE typeId = ?";
  private static final String sqlDeleteCardPara = "DELETE FROM QM_CARD_PARA";
  private static final String sqlDeleteCardParaListByCardId = "DELETE FROM QM_CARD_PARA WHERE cardId = ?";
  private static final String sqlDeleteCardThankListByCardId = "DELETE FROM QM_CARD_THANKS_FRIEND WHERE cardId = ?";
  private static final String sqlDeleteCardType = "DELETE FROM QM_CARD_TYPE";
  private static final String sqlDeleteThanksFriend = "DELETE FROM QM_CARD_THANKS_FRIEND";
  private static final String sqlDropBirthdayFriend = "DROP TABLE IF EXISTS QM_CARD_BIRTHDAY_FRIEND";
  private static final String sqlDropCardContent = "DROP TABLE IF EXISTS QM_CARD_DATA_CONTENT";
  private static final String sqlDropCardData = "DROP TABLE IF EXISTS QM_CARD_DATA";
  private static final String sqlDropCardDataType = "DROP TABLE IF EXISTS QM_CARD_DATA_TYPE";
  private static final String sqlDropCardPara = "DROP TABLE IF EXISTS QM_CARD_PARA";
  private static final String sqlDropCardType = "DROP TABLE IF EXISTS QM_CARD_TYPE";
  private static final String sqlDropThanksFriend = "DROP TABLE IF EXISTS QM_CARD_THANKS_FRIEND";
  private static final String sqlInsertBirthdayFriend = "REPLACE INTO QM_CARD_BIRTHDAY_FRIEND(id , uin , email , nickName , birthday , isChinese , toDayTo , icon , isSend ) VALUES (?,?,?,?,?,?,?,?,?)";
  private static final String sqlInsertCardData = "REPLACE INTO QM_CARD_DATA (cardId , name , cardUrl , viewCount , thanksCount , thumbUrl , mailUrl , coverUrl , onePxUrl , isComplete , priority , tag , mailTitle , mailWord , shareTitle , shareWord , circleLimit , pagetype , friendtype , seqtype , friendnum, wxsharelimit, qqsharelimit) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
  private static final String sqlInsertCardDataContentContent = "REPLACE INTO QM_CARD_DATA_CONTENT(cardUrl , content ) VALUES (?,?)";
  private static final String sqlInsertCardDataType = "REPLACE INTO QM_CARD_DATA_TYPE(cardId , typeId ) VALUES (?,?)";
  private static final String sqlInsertCardPara = "REPLACE INTO QM_CARD_PARA(cardId , key , name , value , defaultValue , limitCount , domId , type ) VALUES (?,?,?,?,?,?,?,?)";
  private static final String sqlInsertCardType = "REPLACE INTO QM_CARD_TYPE (typeId , name , avatar , syncKey , maxId , priority , isDefault , emptyTip ) VALUES (?,?,?,?,?,?,?,?)";
  private static final String sqlInsertThanksFriend = "REPLACE INTO QM_CARD_THANKS_FRIEND(id , cardId , nickName , icon ) VALUES (?,?,?,?)";
  private static final String sqlQueryAllCardType = "SELECT * FROM QM_CARD_TYPE ORDER BY priority";
  private static final String sqlQueryBirthdayFriends = "SELECT * FROM QM_CARD_BIRTHDAY_FRIEND WHERE isSend = 0 AND toDayTo >= ? ORDER BY toDayTo";
  private static final String sqlQueryCardDataByCardId = "SELECT * FROM QM_CARD_DATA WHERE cardId = ?";
  private static final String sqlQueryCardDataByTypeId = "SELECT CD.*,CDT.* FROM QM_CARD_DATA AS CD,QM_CARD_DATA_TYPE AS CDT WHERE CD.cardId = CDT.cardId AND CDT.typeId = ? ORDER BY priority DESC";
  private static final String sqlQueryCardDataContent = "SELECT content FROM QM_CARD_DATA_CONTENT WHERE cardUrl = ?";
  private static final String sqlQueryCardParaByCardId = "SELECT * FROM QM_CARD_PARA WHERE cardId = ?";
  private static final String sqlQueryCardTypeByCardId = "SELECT typeId FROM QM_CARD_DATA_TYPE WHERE cardId = ?";
  private static final String sqlQueryExistCardDataByCardId = "SELECT cardId FROM QM_CARD_DATA WHERE cardId IN $cardIds$";
  private static final String sqlQueryHasBirthdayFriends = "SELECT COUNT(*) FROM QM_CARD_BIRTHDAY_FRIEND WHERE isSend = 0 AND toDayTo >= ?";
  private static final String sqlQuerySendBirthdayFriendIds = "SELECT id FROM QM_CARD_BIRTHDAY_FRIEND WHERE isSend = 1";
  private static final String sqlQueryThanksFriendIcon = "SELECT cardId,icon FROM QM_CARD_THANKS_FRIEND GROUP BY cardId";
  private static final String sqlQueryThanksFriendInfoByCardId = "SELECT * FROM QM_CARD_THANKS_FRIEND WHERE cardId = ?";
  private static final String sqlUpdateBirthdayFriendSend = "UPDATE QM_CARD_BIRTHDAY_FRIEND SET isSend = ? WHERE id = ?";
  private static final String sqlUpdateCardPara = "UPDATE QM_CARD_PARA SET value = ? WHERE cardId = ? AND key = ?";
  static final QMCardSQLiteDatabaseUpgradeManager upgradeManager = new QMCardSQLiteDatabaseUpgradeManager();
  
  public QMCardSQLiteHelper(Context paramContext)
  {
    super(paramContext, "QMCardDB", null, upgradeManager.getVersion());
  }
  
  private static void beginColumnIndex(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null) {
      paramArrayOfInt[0] = 0;
    }
  }
  
  public static QMCardFriendInfo fillBirthdayFriendInfo(Cursor paramCursor)
  {
    boolean bool2 = true;
    QMCardFriendInfo localQMCardFriendInfo = new QMCardFriendInfo();
    localQMCardFriendInfo.setId(paramCursor.getString(paramCursor.getColumnIndex("id")));
    localQMCardFriendInfo.setUin(paramCursor.getLong(paramCursor.getColumnIndex("uin")));
    localQMCardFriendInfo.setEmail(paramCursor.getString(paramCursor.getColumnIndex("email")));
    localQMCardFriendInfo.setBirthday(paramCursor.getString(paramCursor.getColumnIndex("birthday")));
    if (paramCursor.getInt(paramCursor.getColumnIndex("isChinese")) == 1)
    {
      bool1 = true;
      localQMCardFriendInfo.setIsChinese(bool1);
      localQMCardFriendInfo.setToDayTo(paramCursor.getLong(paramCursor.getColumnIndex("toDayTo")));
      localQMCardFriendInfo.setNickName(paramCursor.getString(paramCursor.getColumnIndex("nickName")));
      localQMCardFriendInfo.setIcon(paramCursor.getString(paramCursor.getColumnIndex("icon")));
      if (paramCursor.getInt(paramCursor.getColumnIndex("isSend")) != 1) {
        break label193;
      }
    }
    label193:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localQMCardFriendInfo.setIsSend(bool1);
      return localQMCardFriendInfo;
      bool1 = false;
      break;
    }
  }
  
  public static QMCardData fillCardData(Cursor paramCursor, int[] paramArrayOfInt)
  {
    boolean bool2 = true;
    beginColumnIndex(paramArrayOfInt);
    QMCardData localQMCardData = new QMCardData();
    localQMCardData.setCardId(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "cardId")));
    localQMCardData.setName(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "name")));
    localQMCardData.setCardUrl(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "cardUrl")));
    localQMCardData.setViewCount(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "viewCount")));
    localQMCardData.setThanksCount(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "thanksCount")));
    localQMCardData.setCardThumbUrl(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "thumbUrl")));
    localQMCardData.setCardMailUrl(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "mailUrl")));
    localQMCardData.setCardCoverUrl(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "coverUrl")));
    localQMCardData.setCardOnePxUrl(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "onePxUrl")));
    if (paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "isComplete")) == 1)
    {
      bool1 = true;
      localQMCardData.setIsComplete(bool1);
      localQMCardData.setPriority(paramCursor.getDouble(getColumnIndex(paramArrayOfInt, paramCursor, "priority")));
      localQMCardData.setTag(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "tag")));
      localQMCardData.setMailWord(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "mailWord")));
      localQMCardData.setMailTitle(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "mailTitle")));
      localQMCardData.setShareWord(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "shareWord")));
      localQMCardData.setShareTitle(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "shareTitle")));
      if (paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "circleLimit")) == 0) {
        break label462;
      }
      bool1 = true;
      label328:
      localQMCardData.setCirclelimit(bool1);
      localQMCardData.setPageType(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "pagetype")));
      localQMCardData.setFriendType(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "friendtype")));
      localQMCardData.setSeqType(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "seqtype")));
      localQMCardData.setFriendNum(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "friendnum")));
      if (paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "wxsharelimit")) == 0) {
        break label467;
      }
      bool1 = true;
      label424:
      localQMCardData.setWxShareLimit(bool1);
      if (paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "qqsharelimit")) == 0) {
        break label472;
      }
    }
    label462:
    label467:
    label472:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localQMCardData.setQqShareLimit(bool1);
      return localQMCardData;
      bool1 = false;
      break;
      bool1 = false;
      break label328;
      bool1 = false;
      break label424;
    }
  }
  
  public static QMCardPara fillCardPara(Cursor paramCursor)
  {
    QMCardPara localQMCardPara = new QMCardPara();
    localQMCardPara.setCardId(paramCursor.getString(paramCursor.getColumnIndex("cardId")));
    localQMCardPara.setKey(paramCursor.getString(paramCursor.getColumnIndex("key")));
    localQMCardPara.setValue(paramCursor.getString(paramCursor.getColumnIndex("value")));
    localQMCardPara.setName(paramCursor.getString(paramCursor.getColumnIndex("name")));
    localQMCardPara.setDefaultValue(paramCursor.getString(paramCursor.getColumnIndex("defaultValue")));
    localQMCardPara.setLimitCount(paramCursor.getInt(paramCursor.getColumnIndex("limitCount")));
    localQMCardPara.setDomId(paramCursor.getString(paramCursor.getColumnIndex("domId")));
    localQMCardPara.setType(paramCursor.getInt(paramCursor.getColumnIndex("type")));
    return localQMCardPara;
  }
  
  public static QMCardType fillCardType(Cursor paramCursor)
  {
    boolean bool = true;
    QMCardType localQMCardType = new QMCardType();
    localQMCardType.setTypeId(paramCursor.getInt(paramCursor.getColumnIndex("typeId")));
    localQMCardType.setTypeName(paramCursor.getString(paramCursor.getColumnIndex("name")));
    localQMCardType.setAvatar(paramCursor.getString(paramCursor.getColumnIndex("avatar")));
    localQMCardType.setSyncKey(paramCursor.getString(paramCursor.getColumnIndex("syncKey")));
    localQMCardType.setMaxId(paramCursor.getLong(paramCursor.getColumnIndex("maxId")));
    localQMCardType.setPriority(paramCursor.getDouble(paramCursor.getColumnIndex("priority")));
    if (paramCursor.getInt(paramCursor.getColumnIndex("isDefault")) == 1) {}
    for (;;)
    {
      localQMCardType.setIsDefault(bool);
      localQMCardType.setEmptyTip(paramCursor.getString(paramCursor.getColumnIndex("emptyTip")));
      return localQMCardType;
      bool = false;
    }
  }
  
  public static QMCardFriendInfo fillThanksFriendInfo(Cursor paramCursor)
  {
    QMCardFriendInfo localQMCardFriendInfo = new QMCardFriendInfo();
    localQMCardFriendInfo.setId(paramCursor.getString(paramCursor.getColumnIndex("id")));
    localQMCardFriendInfo.setNickName(paramCursor.getString(paramCursor.getColumnIndex("nickName")));
    localQMCardFriendInfo.setIcon(paramCursor.getString(paramCursor.getColumnIndex("icon")));
    return localQMCardFriendInfo;
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
  
  protected static String getInClause(ArrayList<String> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append((String)paramArrayList.get(i));
      if (i != j - 1) {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  static void upgradeTableFor5101(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_CARD_DATA_CONTENT");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_CARD_DATA_CONTENT(cardUrl varchar primary key, content varchar )");
  }
  
  static void upgradeTableFor5102(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_CARD_DATA ADD COLUMN circleLimit INTEGER DEFAULT 1");
  }
  
  static void upgradeTableFor5300(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_CARD_DATA ADD COLUMN pagetype INTEGER DEFAULT 0");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_CARD_DATA ADD COLUMN friendtype INTEGER DEFAULT 0");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_CARD_DATA ADD COLUMN seqtype INTEGER DEFAULT 0");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_CARD_DATA ADD COLUMN friendnum INTEGER DEFAULT 0");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_CARD_DATA ADD COLUMN wxsharelimit INTEGER DEFAULT 0");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_CARD_DATA ADD COLUMN qqsharelimit INTEGER DEFAULT 0");
  }
  
  public void createTable(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.beginTransactionNonExclusive();
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_CARD_DATA(cardId varchar primary key, name varchar, cardUrl varchar, viewCount integer, thanksCount integer, thumbUrl varchar, mailUrl varchar, coverUrl varchar, onePxUrl varchar, isComplete integer, priority real, tag varchar, mailTitle varchar, mailWord varchar, shareTitle varchar, shareWord varchar, circleLimit integer default 1, pagetype integer default 0, friendtype integer default 0, seqtype integer default 0, friendnum integer default 0, wxsharelimit integer default 0, qqsharelimit integer default 0)");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_CARD_DATA_CONTENT(cardUrl varchar primary key, content varchar )");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_CARD_TYPE(typeId integer primary key, name varchar, avatar varchar, syncKey varchar, maxId integer, priority real, isDefault integer, emptyTip varchar )");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_CARD_DATA_TYPE(cardId integer, typeId integer )");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_CARD_PARA(cardId integer, key varchar, name varchar, value varchar, defaultValue varchar, limitCount integer, domId varchar, type integer, primary key(cardId,key))");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_CARD_BIRTHDAY_FRIEND(id varchar primary key, uin integer, email varchar, nickName varchar, birthday varchar, isChinese integer, toDayTo integer, icon varchar, isSend integer )");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_CARD_THANKS_FRIEND(id varchar, cardId integer, nickName varchar, icon varchar, primary key(cardId,id))");
      paramSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  public void deleteAllBirthdayFriend(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DELETE FROM QM_CARD_BIRTHDAY_FRIEND");
  }
  
  public void deleteAllCardData(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DELETE FROM QM_CARD_DATA");
    paramSQLiteDatabase.execSQL("DELETE FROM QM_CARD_PARA");
    paramSQLiteDatabase.execSQL("DELETE FROM QM_CARD_TYPE");
    paramSQLiteDatabase.execSQL("DELETE FROM QM_CARD_DATA_TYPE");
    paramSQLiteDatabase.execSQL("DELETE FROM QM_CARD_THANKS_FRIEND");
    paramSQLiteDatabase.execSQL("DELETE FROM QM_CARD_DATA_CONTENT");
  }
  
  public void deleteAllCardType(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DELETE FROM QM_CARD_TYPE");
  }
  
  public void deleteCardDataById(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CARD_DATA WHERE cardId = ?", new Object[] { paramString });
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CARD_THANKS_FRIEND WHERE cardId = ?", new Object[] { paramString });
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CARD_PARA WHERE cardId = ?", new Object[] { paramString });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "CardSQLite", Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void deleteCardDataType(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    paramSQLiteDatabase.execSQL("DELETE FROM QM_CARD_DATA_TYPE WHERE typeId = ?", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void deleteCardDataType(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt)
  {
    paramSQLiteDatabase.execSQL("DELETE FROM QM_CARD_DATA_TYPE WHERE cardId = ? AND typeId = ?", new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  public void dropTable(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.beginTransactionNonExclusive();
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_CARD_DATA");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_CARD_DATA_CONTENT");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_CARD_PARA");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_CARD_TYPE");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_CARD_DATA_TYPE");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_CARD_BIRTHDAY_FRIEND");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_CARD_THANKS_FRIEND");
      paramSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  public String getCardDataContent(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    paramString = paramSQLiteDatabase.rawQuery("SELECT content FROM QM_CARD_DATA_CONTENT WHERE cardUrl = ?", new String[] { paramString });
    paramSQLiteDatabase = localObject2;
    if (paramString != null)
    {
      paramSQLiteDatabase = localObject1;
      if (paramString.moveToFirst()) {
        paramSQLiteDatabase = paramString.getString(0);
      }
      paramString.close();
    }
    return paramSQLiteDatabase;
  }
  
  public void insertBirthdayFriendList(SQLiteDatabase paramSQLiteDatabase, ArrayList<QMCardFriendInfo> paramArrayList)
  {
    for (;;)
    {
      try
      {
        paramSQLiteDatabase.beginTransactionNonExclusive();
        paramArrayList = paramArrayList.iterator();
        if (!paramArrayList.hasNext()) {
          continue;
        }
        localQMCardFriendInfo = (QMCardFriendInfo)paramArrayList.next();
        str1 = localQMCardFriendInfo.getId();
        l1 = localQMCardFriendInfo.getUin();
        str2 = localQMCardFriendInfo.getEmail();
        str3 = localQMCardFriendInfo.getNickName();
        str4 = localQMCardFriendInfo.getBirthday();
        if (!localQMCardFriendInfo.isChinese()) {
          continue;
        }
        i = 1;
      }
      catch (Exception paramArrayList)
      {
        QMCardFriendInfo localQMCardFriendInfo;
        String str1;
        long l1;
        String str2;
        String str3;
        String str4;
        long l2;
        String str5;
        QMLog.log(6, "CardSQLite", Log.getStackTraceString(paramArrayList));
        return;
        int i = 0;
        continue;
        int j = 0;
        continue;
        paramSQLiteDatabase.setTransactionSuccessful();
        return;
      }
      finally
      {
        paramSQLiteDatabase.endTransaction();
      }
      l2 = localQMCardFriendInfo.getToDayTo();
      str5 = localQMCardFriendInfo.getIcon();
      if (!localQMCardFriendInfo.isSend()) {
        continue;
      }
      j = 1;
      paramSQLiteDatabase.execSQL("REPLACE INTO QM_CARD_BIRTHDAY_FRIEND(id , uin , email , nickName , birthday , isChinese , toDayTo , icon , isSend ) VALUES (?,?,?,?,?,?,?,?,?)", new Object[] { str1, Long.valueOf(l1), str2, str3, str4, Integer.valueOf(i), Long.valueOf(l2), str5, Integer.valueOf(j) });
    }
  }
  
  public void insertCardData(SQLiteDatabase paramSQLiteDatabase, QMCardData paramQMCardData, int paramInt)
  {
    try
    {
      paramSQLiteDatabase.beginTransactionNonExclusive();
      paramSQLiteDatabase.execSQL("REPLACE INTO QM_CARD_DATA (cardId , name , cardUrl , viewCount , thanksCount , thumbUrl , mailUrl , coverUrl , onePxUrl , isComplete , priority , tag , mailTitle , mailWord , shareTitle , shareWord , circleLimit , pagetype , friendtype , seqtype , friendnum, wxsharelimit, qqsharelimit) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new Object[] { paramQMCardData.getCardId(), paramQMCardData.getName(), paramQMCardData.getCardUrl(), Integer.valueOf(paramQMCardData.getViewCount()), Integer.valueOf(paramQMCardData.getThanksCount()), paramQMCardData.getCardThumbUrl(), paramQMCardData.getCardMailUrl(), paramQMCardData.getCardCoverUrl(), paramQMCardData.getCardOnePxUrl(), Boolean.valueOf(paramQMCardData.isComplete()), Double.valueOf(paramQMCardData.getPriority()), paramQMCardData.getTag(), paramQMCardData.getMailTitle(), paramQMCardData.getMailWord(), paramQMCardData.getShareTitle(), paramQMCardData.getShareWord(), Boolean.valueOf(paramQMCardData.isCirclelimit()), Integer.valueOf(paramQMCardData.getPageType()), Integer.valueOf(paramQMCardData.getFriendType()), Integer.valueOf(paramQMCardData.getSeqType()), Integer.valueOf(paramQMCardData.getFriendNum()), Boolean.valueOf(paramQMCardData.isWxShareLimit()), Boolean.valueOf(paramQMCardData.isQqShareLimit()) });
      Object localObject = paramQMCardData.getCardParaList();
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          insertCardPara(paramSQLiteDatabase, (QMCardPara)((Iterator)localObject).next());
        }
      }
      QMCardFriendInfo localQMCardFriendInfo;
      insertCardDataType(paramSQLiteDatabase, paramQMCardData.getCardId(), paramInt);
    }
    catch (Exception paramQMCardData)
    {
      QMLog.log(6, "CardSQLite", Log.getStackTraceString(paramQMCardData));
      return;
      localObject = paramQMCardData.getThanksFriendList();
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localQMCardFriendInfo = (QMCardFriendInfo)((Iterator)localObject).next();
          insertThanksFriend(paramSQLiteDatabase, paramQMCardData.getCardId(), localQMCardFriendInfo);
        }
      }
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
    paramSQLiteDatabase.setTransactionSuccessful();
    paramSQLiteDatabase.endTransaction();
  }
  
  public void insertCardDataContent(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    paramSQLiteDatabase.execSQL("REPLACE INTO QM_CARD_DATA_CONTENT(cardUrl , content ) VALUES (?,?)", new Object[] { paramString1, paramString2 });
  }
  
  public void insertCardDataList(SQLiteDatabase paramSQLiteDatabase, ArrayList<QMCardData> paramArrayList, int paramInt)
  {
    for (;;)
    {
      try
      {
        paramSQLiteDatabase.beginTransactionNonExclusive();
        paramArrayList = paramArrayList.iterator();
        if (!paramArrayList.hasNext()) {
          break;
        }
        QMCardData localQMCardData = (QMCardData)paramArrayList.next();
        paramSQLiteDatabase.execSQL("REPLACE INTO QM_CARD_DATA (cardId , name , cardUrl , viewCount , thanksCount , thumbUrl , mailUrl , coverUrl , onePxUrl , isComplete , priority , tag , mailTitle , mailWord , shareTitle , shareWord , circleLimit , pagetype , friendtype , seqtype , friendnum, wxsharelimit, qqsharelimit) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new Object[] { localQMCardData.getCardId(), localQMCardData.getName(), localQMCardData.getCardUrl(), Integer.valueOf(localQMCardData.getViewCount()), Integer.valueOf(localQMCardData.getThanksCount()), localQMCardData.getCardThumbUrl(), localQMCardData.getCardMailUrl(), localQMCardData.getCardCoverUrl(), Boolean.valueOf(localQMCardData.isComplete()), Double.valueOf(localQMCardData.getPriority()), localQMCardData.getTag(), localQMCardData.getMailTitle(), localQMCardData.getMailWord(), localQMCardData.getShareTitle(), localQMCardData.getShareWord(), Integer.valueOf(localQMCardData.getPageType()), Integer.valueOf(localQMCardData.getFriendType()), Integer.valueOf(localQMCardData.getSeqType()), Integer.valueOf(localQMCardData.getFriendNum()), Boolean.valueOf(localQMCardData.isWxShareLimit()), Boolean.valueOf(localQMCardData.isQqShareLimit()) });
        Object localObject = localQMCardData.getCardParaList();
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          localObject = ((ArrayList)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            insertCardPara(paramSQLiteDatabase, (QMCardPara)((Iterator)localObject).next());
            continue;
          }
        }
        QMCardFriendInfo localQMCardFriendInfo;
        insertCardDataType(paramSQLiteDatabase, localQMCardData.getCardId(), paramInt);
      }
      catch (Exception paramArrayList)
      {
        QMLog.log(6, "CardSQLite", Log.getStackTraceString(paramArrayList));
        return;
        localObject = localQMCardData.getThanksFriendList();
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          localObject = ((ArrayList)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            localQMCardFriendInfo = (QMCardFriendInfo)((Iterator)localObject).next();
            insertThanksFriend(paramSQLiteDatabase, localQMCardData.getCardId(), localQMCardFriendInfo);
            continue;
          }
        }
      }
      finally
      {
        paramSQLiteDatabase.endTransaction();
      }
    }
    paramSQLiteDatabase.setTransactionSuccessful();
    paramSQLiteDatabase.endTransaction();
  }
  
  public void insertCardDataType(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt)
  {
    try
    {
      paramSQLiteDatabase.execSQL("REPLACE INTO QM_CARD_DATA_TYPE(cardId , typeId ) VALUES (?,?)", new Object[] { paramString, Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "CardSQLite", Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void insertCardPara(SQLiteDatabase paramSQLiteDatabase, QMCardPara paramQMCardPara)
  {
    String str1 = paramQMCardPara.getCardId();
    String str2 = paramQMCardPara.getKey();
    String str3 = paramQMCardPara.getName();
    String str4 = paramQMCardPara.getValue();
    String str5 = paramQMCardPara.getDefaultValue();
    int i = paramQMCardPara.getLimitCount();
    String str6 = paramQMCardPara.getDomId();
    int j = paramQMCardPara.getType();
    try
    {
      paramSQLiteDatabase.execSQL("REPLACE INTO QM_CARD_PARA(cardId , key , name , value , defaultValue , limitCount , domId , type ) VALUES (?,?,?,?,?,?,?,?)", new Object[] { str1, str2, str3, str4, str5, Integer.valueOf(i), str6, Integer.valueOf(j) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "CardSQLite", Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void insertCardTypeList(SQLiteDatabase paramSQLiteDatabase, ArrayList<QMCardType> paramArrayList)
  {
    for (;;)
    {
      try
      {
        paramSQLiteDatabase.beginTransactionNonExclusive();
        paramArrayList = paramArrayList.iterator();
        if (!paramArrayList.hasNext()) {
          continue;
        }
        localQMCardType = (QMCardType)paramArrayList.next();
        j = localQMCardType.getTypeId();
        str1 = localQMCardType.getTypeName();
        str2 = localQMCardType.getAvatar();
        str3 = localQMCardType.getSyncKey();
        l = localQMCardType.getMaxId();
        d = localQMCardType.getPriority();
        if (!localQMCardType.isDefault()) {
          continue;
        }
        i = 1;
      }
      catch (Exception paramArrayList)
      {
        QMCardType localQMCardType;
        int j;
        String str1;
        String str2;
        String str3;
        long l;
        double d;
        QMLog.log(6, "CardSQLite", Log.getStackTraceString(paramArrayList));
        return;
        int i = 0;
        continue;
        paramSQLiteDatabase.setTransactionSuccessful();
        return;
      }
      finally
      {
        paramSQLiteDatabase.endTransaction();
      }
      paramSQLiteDatabase.execSQL("REPLACE INTO QM_CARD_TYPE (typeId , name , avatar , syncKey , maxId , priority , isDefault , emptyTip ) VALUES (?,?,?,?,?,?,?,?)", new Object[] { Integer.valueOf(j), str1, str2, str3, Long.valueOf(l), Double.valueOf(d), Integer.valueOf(i), localQMCardType.getEmptyTip() });
    }
  }
  
  public void insertThanksFriend(SQLiteDatabase paramSQLiteDatabase, String paramString, QMCardFriendInfo paramQMCardFriendInfo)
  {
    String str1 = paramQMCardFriendInfo.getId();
    String str2 = paramQMCardFriendInfo.getNickName();
    paramQMCardFriendInfo = paramQMCardFriendInfo.getIcon();
    try
    {
      paramSQLiteDatabase.execSQL("REPLACE INTO QM_CARD_THANKS_FRIEND(id , cardId , nickName , icon ) VALUES (?,?,?,?)", new Object[] { str1, paramString, str2, paramQMCardFriendInfo });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "CardSQLite", Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  /* Error */
  public void insertThanksFriendList(SQLiteDatabase paramSQLiteDatabase, String paramString, ArrayList<QMCardFriendInfo> paramArrayList)
  {
    // Byte code:
    //   0: aload_3
    //   1: ifnull +62 -> 63
    //   4: aload_3
    //   5: invokevirtual 549	java/util/ArrayList:size	()I
    //   8: ifle +55 -> 63
    //   11: aload_1
    //   12: invokevirtual 594	com/tencent/moai/database/sqlite/SQLiteDatabase:beginTransactionNonExclusive	()V
    //   15: aload_3
    //   16: invokevirtual 654	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   19: astore_3
    //   20: aload_3
    //   21: invokeinterface 659 1 0
    //   26: ifeq +38 -> 64
    //   29: aload_0
    //   30: aload_1
    //   31: aload_2
    //   32: aload_3
    //   33: invokeinterface 663 1 0
    //   38: checkcast 345	com/tencent/qqmail/card/model/QMCardFriendInfo
    //   41: invokevirtual 791	com/tencent/qqmail/card/QMCardSQLiteHelper:insertThanksFriend	(Lcom/tencent/moai/database/sqlite/SQLiteDatabase;Ljava/lang/String;Lcom/tencent/qqmail/card/model/QMCardFriendInfo;)V
    //   44: goto -24 -> 20
    //   47: astore_2
    //   48: bipush 6
    //   50: ldc 178
    //   52: aload_2
    //   53: invokestatic 619	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   56: invokestatic 625	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   59: aload_1
    //   60: invokevirtual 600	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   63: return
    //   64: aload_1
    //   65: invokevirtual 597	com/tencent/moai/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   68: aload_1
    //   69: invokevirtual 600	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   72: return
    //   73: astore_2
    //   74: aload_1
    //   75: invokevirtual 600	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   78: aload_2
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	QMCardSQLiteHelper
    //   0	80	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	80	2	paramString	String
    //   0	80	3	paramArrayList	ArrayList<QMCardFriendInfo>
    // Exception table:
    //   from	to	target	type
    //   11	20	47	java/lang/Exception
    //   20	44	47	java/lang/Exception
    //   64	68	47	java/lang/Exception
    //   11	20	73	finally
    //   20	44	73	finally
    //   48	59	73	finally
    //   64	68	73	finally
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    createTable(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    QMLog.log(4, "CardSQLite", "Try Upgrade: from " + paramInt1 + " to " + paramInt2 + ", minVer:" + upgradeManager.getMinSupportVersion());
    if (paramInt1 < upgradeManager.getMinSupportVersion())
    {
      dropTable(paramSQLiteDatabase);
      createTable(paramSQLiteDatabase);
      return;
    }
    if (upgradeManager.upgrade(this, paramSQLiteDatabase, paramInt1))
    {
      QMLog.log(4, "CardSQLite", "Upgraded from " + paramInt1 + " to " + paramInt2);
      return;
    }
    QMLog.log(4, "CardSQLite", "No need upgrade from " + paramInt1 + " to " + paramInt2);
  }
  
  public ArrayList<QMCardType> queryAllCardType(SQLiteDatabase paramSQLiteDatabase)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_CARD_TYPE ORDER BY priority", null);
      if (paramSQLiteDatabase != null)
      {
        if (paramSQLiteDatabase.moveToFirst()) {
          do
          {
            localArrayList.add(fillCardType(paramSQLiteDatabase));
          } while (paramSQLiteDatabase.moveToNext());
        }
        paramSQLiteDatabase.close();
      }
      return localArrayList;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "CardSQLite", Log.getStackTraceString(paramSQLiteDatabase));
    }
    return localArrayList;
  }
  
  public Cursor queryBirthdayFriends(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    return paramSQLiteDatabase.rawQuery("SELECT * FROM QM_CARD_BIRTHDAY_FRIEND WHERE isSend = 0 AND toDayTo >= ? ORDER BY toDayTo", new String[] { String.valueOf(paramLong) });
  }
  
  public QMCardData queryCardDataByCardId(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    Object localObject4 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = localObject4;
    int[] arrayOfInt;
    if (!StringExtention.isNullOrEmpty(paramString))
    {
      arrayOfInt = new int[100];
      Arrays.fill(arrayOfInt, -2147483648);
      localObject1 = localObject2;
    }
    try
    {
      paramString = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_CARD_DATA WHERE cardId = ?", new String[] { paramString });
      localObject1 = localObject4;
      if (paramString != null)
      {
        paramSQLiteDatabase = localObject3;
        localObject1 = localObject2;
        if (paramString.moveToFirst())
        {
          localObject1 = localObject2;
          paramSQLiteDatabase = fillCardData(paramString, arrayOfInt);
        }
        localObject1 = paramSQLiteDatabase;
        paramString.close();
        localObject1 = paramSQLiteDatabase;
      }
      return localObject1;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "CardSQLite", Log.getStackTraceString(paramSQLiteDatabase));
    }
    return localObject1;
  }
  
  public ArrayList<QMCardPara> queryCardParaListByCardId(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_CARD_PARA WHERE cardId = ?", new String[] { paramString });
      if (paramSQLiteDatabase != null)
      {
        if (paramSQLiteDatabase.moveToFirst()) {
          do
          {
            localArrayList.add(fillCardPara(paramSQLiteDatabase));
          } while (paramSQLiteDatabase.moveToNext());
        }
        paramSQLiteDatabase.close();
      }
      return localArrayList;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "CardSQLite", Log.getStackTraceString(paramSQLiteDatabase));
    }
    return localArrayList;
  }
  
  public ArrayList<Integer> queryCardTypesByCardId(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    paramString = new ArrayList();
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT typeId FROM QM_CARD_DATA_TYPE WHERE cardId = ?", null);
      if (paramSQLiteDatabase != null)
      {
        if (paramSQLiteDatabase.moveToFirst()) {
          do
          {
            paramString.add(Integer.valueOf(paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("typeId"))));
          } while (paramSQLiteDatabase.moveToNext());
        }
        paramSQLiteDatabase.close();
      }
      return paramString;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "CardSQLite", Log.getStackTraceString(paramSQLiteDatabase));
    }
    return paramString;
  }
  
  public Cursor queryCardsByTypeId(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    return paramSQLiteDatabase.rawQuery("SELECT CD.*,CDT.* FROM QM_CARD_DATA AS CD,QM_CARD_DATA_TYPE AS CDT WHERE CD.cardId = CDT.cardId AND CDT.typeId = ? ORDER BY priority DESC", new String[] { String.valueOf(paramInt) });
  }
  
  public ArrayList<String> queryExistCardDataByCardIds(SQLiteDatabase paramSQLiteDatabase, ArrayList<String> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      paramArrayList = "SELECT cardId FROM QM_CARD_DATA WHERE cardId IN $cardIds$".replace("$cardIds$", getInClause(paramArrayList));
    }
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(paramArrayList, null);
      if (paramSQLiteDatabase != null)
      {
        if (paramSQLiteDatabase.moveToFirst()) {
          do
          {
            localArrayList.add(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("cardId")));
          } while (paramSQLiteDatabase.moveToNext());
        }
        paramSQLiteDatabase.close();
      }
      return localArrayList;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "CardSQLite", Log.getStackTraceString(paramSQLiteDatabase));
    }
    return localArrayList;
  }
  
  public int queryHasBirthdayFriends(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    int i = 0;
    int j = 0;
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT COUNT(*) FROM QM_CARD_BIRTHDAY_FRIEND WHERE isSend = 0 AND toDayTo >= ?", new String[] { String.valueOf(paramLong) });
    if (paramSQLiteDatabase != null)
    {
      i = j;
      if (paramSQLiteDatabase.moveToFirst()) {
        i = paramSQLiteDatabase.getInt(0);
      }
      paramSQLiteDatabase.close();
    }
    return i;
  }
  
  public ArrayList<Integer> querySendBirthdayFriendIds(SQLiteDatabase paramSQLiteDatabase)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT id FROM QM_CARD_BIRTHDAY_FRIEND WHERE isSend = 1", null);
      if (paramSQLiteDatabase != null)
      {
        if (paramSQLiteDatabase.moveToFirst()) {
          do
          {
            localArrayList.add(Integer.valueOf(paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("id"))));
          } while (paramSQLiteDatabase.moveToNext());
        }
        paramSQLiteDatabase.close();
      }
      return localArrayList;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "CardSQLite", Log.getStackTraceString(paramSQLiteDatabase));
    }
    return localArrayList;
  }
  
  public HashMap<String, ArrayList<String>> queryThanksFriendIconMap(SQLiteDatabase paramSQLiteDatabase)
  {
    localHashMap = new HashMap();
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT cardId,icon FROM QM_CARD_THANKS_FRIEND GROUP BY cardId", null);
      if (paramSQLiteDatabase != null)
      {
        if (paramSQLiteDatabase.moveToFirst()) {}
        for (;;)
        {
          String str1 = paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("cardId"));
          String str2 = paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("icon"));
          ArrayList localArrayList;
          if (localHashMap.containsKey(str1))
          {
            localArrayList = (ArrayList)localHashMap.get(str1);
            if (localArrayList.size() < 7)
            {
              localArrayList.add(str2);
              localHashMap.put(str1, localArrayList);
            }
          }
          while (!paramSQLiteDatabase.moveToNext())
          {
            paramSQLiteDatabase.close();
            return localHashMap;
            localArrayList = new ArrayList();
            localArrayList.add(str2);
            localHashMap.put(str1, localArrayList);
          }
        }
      }
      return localHashMap;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "CardSQLite", Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public Cursor queryThanksFriendInfoByCardId(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    return paramSQLiteDatabase.rawQuery("SELECT * FROM QM_CARD_THANKS_FRIEND WHERE cardId = ?", new String[] { paramString });
  }
  
  public boolean updateBirthdayFriendIsSend(SQLiteDatabase paramSQLiteDatabase, String paramString, boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean) {
      i = 1;
    }
    try
    {
      paramSQLiteDatabase.execSQL("UPDATE QM_CARD_BIRTHDAY_FRIEND SET isSend = ? WHERE id = ?", new Object[] { Integer.valueOf(i), paramString });
      return true;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "CardSQLite", Log.getStackTraceString(paramSQLiteDatabase));
    }
    return true;
  }
  
  /* Error */
  public boolean updateCardPara(SQLiteDatabase paramSQLiteDatabase, ArrayList<QMCardPara> paramArrayList)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 594	com/tencent/moai/database/sqlite/SQLiteDatabase:beginTransactionNonExclusive	()V
    //   4: aload_2
    //   5: invokevirtual 654	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   8: astore_2
    //   9: aload_2
    //   10: invokeinterface 659 1 0
    //   15: ifeq +66 -> 81
    //   18: aload_2
    //   19: invokeinterface 663 1 0
    //   24: checkcast 483	com/tencent/qqmail/card/model/QMCardPara
    //   27: astore_3
    //   28: aload_1
    //   29: ldc_w 319
    //   32: iconst_3
    //   33: anewarray 610	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: aload_3
    //   39: invokevirtual 807	com/tencent/qqmail/card/model/QMCardPara:getValue	()Ljava/lang/String;
    //   42: aastore
    //   43: dup
    //   44: iconst_1
    //   45: aload_3
    //   46: invokevirtual 800	com/tencent/qqmail/card/model/QMCardPara:getCardId	()Ljava/lang/String;
    //   49: aastore
    //   50: dup
    //   51: iconst_2
    //   52: aload_3
    //   53: invokevirtual 803	com/tencent/qqmail/card/model/QMCardPara:getKey	()Ljava/lang/String;
    //   56: aastore
    //   57: invokevirtual 613	com/tencent/moai/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   60: goto -51 -> 9
    //   63: astore_2
    //   64: bipush 6
    //   66: ldc 178
    //   68: aload_2
    //   69: invokestatic 619	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   72: invokestatic 625	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   75: aload_1
    //   76: invokevirtual 600	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   79: iconst_1
    //   80: ireturn
    //   81: aload_1
    //   82: invokevirtual 597	com/tencent/moai/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   85: aload_1
    //   86: invokevirtual 600	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   89: iconst_1
    //   90: ireturn
    //   91: astore_2
    //   92: aload_1
    //   93: invokevirtual 600	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   96: aload_2
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	QMCardSQLiteHelper
    //   0	98	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	98	2	paramArrayList	ArrayList<QMCardPara>
    //   27	26	3	localQMCardPara	QMCardPara
    // Exception table:
    //   from	to	target	type
    //   0	9	63	java/lang/Exception
    //   9	60	63	java/lang/Exception
    //   81	85	63	java/lang/Exception
    //   0	9	91	finally
    //   9	60	91	finally
    //   64	75	91	finally
    //   81	85	91	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.QMCardSQLiteHelper
 * JD-Core Version:    0.7.0.1
 */