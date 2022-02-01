import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.RoamSetting;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.OGAbstractDao;

public class akvv
  extends OGAbstractDao
{
  public akvv()
  {
    this.columnLen = 2;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    paramEntity = (RoamSetting)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.path = paramCursor.getString(paramCursor.getColumnIndex("path"));
      paramEntity.value = paramCursor.getString(paramCursor.getColumnIndex("value"));
      return paramEntity;
    }
    int i = paramCursor.getColumnIndex("path");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("path", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("value");
      if (i != -1) {
        break;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("value", String.class));
      return paramEntity;
      paramEntity.path = paramCursor.getString(i);
    }
    paramEntity.value = paramCursor.getString(i);
    return paramEntity;
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (RoamSetting)paramEntity;
    paramContentValues.put("path", paramEntity.path);
    paramContentValues.put("value", paramEntity.value);
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,path TEXT UNIQUE ,value TEXT)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     akvv
 * JD-Core Version:    0.7.0.1
 */