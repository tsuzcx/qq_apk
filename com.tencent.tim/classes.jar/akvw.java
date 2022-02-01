import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.OGAbstractDao;

public class akvw
  extends OGAbstractDao
{
  public akvw()
  {
    this.columnLen = 8;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    paramEntity = (SearchHistory)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.key = paramCursor.getString(paramCursor.getColumnIndex("key"));
      paramEntity.type = paramCursor.getInt(paramCursor.getColumnIndex("type"));
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      paramEntity.displayName = paramCursor.getString(paramCursor.getColumnIndex("displayName"));
      paramEntity.extralInfo = paramCursor.getString(paramCursor.getColumnIndex("extralInfo"));
      paramEntity.count = paramCursor.getInt(paramCursor.getColumnIndex("count"));
      paramEntity.time = paramCursor.getLong(paramCursor.getColumnIndex("time"));
      return paramEntity;
    }
    int i = paramCursor.getColumnIndex("key");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("key", String.class));
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label448;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("type", Integer.TYPE));
      label225:
      i = paramCursor.getColumnIndex("uin");
      if (i != -1) {
        break label463;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uin", String.class));
      label259:
      i = paramCursor.getColumnIndex("troopUin");
      if (i != -1) {
        break label478;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopUin", String.class));
      label293:
      i = paramCursor.getColumnIndex("displayName");
      if (i != -1) {
        break label493;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("displayName", String.class));
      label327:
      i = paramCursor.getColumnIndex("extralInfo");
      if (i != -1) {
        break label508;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("extralInfo", String.class));
      label361:
      i = paramCursor.getColumnIndex("count");
      if (i != -1) {
        break label523;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("count", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("time");
      if (i != -1) {
        break label538;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("time", Long.TYPE));
      return paramEntity;
      paramEntity.key = paramCursor.getString(i);
      break;
      label448:
      paramEntity.type = paramCursor.getInt(i);
      break label225;
      label463:
      paramEntity.uin = paramCursor.getString(i);
      break label259;
      label478:
      paramEntity.troopUin = paramCursor.getString(i);
      break label293;
      label493:
      paramEntity.displayName = paramCursor.getString(i);
      break label327;
      label508:
      paramEntity.extralInfo = paramCursor.getString(i);
      break label361;
      label523:
      paramEntity.count = paramCursor.getInt(i);
    }
    label538:
    paramEntity.time = paramCursor.getLong(i);
    return paramEntity;
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (SearchHistory)paramEntity;
    paramContentValues.put("key", paramEntity.key);
    paramContentValues.put("type", Integer.valueOf(paramEntity.type));
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("troopUin", paramEntity.troopUin);
    paramContentValues.put("displayName", paramEntity.displayName);
    paramContentValues.put("extralInfo", paramEntity.extralInfo);
    paramContentValues.put("count", Integer.valueOf(paramEntity.count));
    paramContentValues.put("time", Long.valueOf(paramEntity.time));
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,key TEXT UNIQUE ,type INTEGER ,uin TEXT ,troopUin TEXT ,displayName TEXT ,extralInfo TEXT ,count INTEGER ,time INTEGER)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     akvw
 * JD-Core Version:    0.7.0.1
 */