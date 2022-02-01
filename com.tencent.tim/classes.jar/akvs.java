import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.OGAbstractDao;

public class akvs
  extends OGAbstractDao
{
  public akvs()
  {
    this.columnLen = 5;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    paramEntity = (QZoneCover)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.type = paramCursor.getString(paramCursor.getColumnIndex("type"));
      paramEntity.jigsaw = paramCursor.getInt(paramCursor.getColumnIndex("jigsaw"));
      paramEntity.vCoverInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vCoverInfo"));
      paramEntity.vPhotoInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vPhotoInfo"));
      return paramEntity;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label290;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("type", String.class));
      label170:
      i = paramCursor.getColumnIndex("jigsaw");
      if (i != -1) {
        break label305;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("jigsaw", Integer.TYPE));
      label205:
      i = paramCursor.getColumnIndex("vCoverInfo");
      if (i != -1) {
        break label320;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vCoverInfo", [B.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("vPhotoInfo");
      if (i != -1) {
        break label335;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vPhotoInfo", [B.class));
      return paramEntity;
      paramEntity.uin = paramCursor.getString(i);
      break;
      label290:
      paramEntity.type = paramCursor.getString(i);
      break label170;
      label305:
      paramEntity.jigsaw = paramCursor.getInt(i);
      break label205;
      label320:
      paramEntity.vCoverInfo = paramCursor.getBlob(i);
    }
    label335:
    paramEntity.vPhotoInfo = paramCursor.getBlob(i);
    return paramEntity;
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (QZoneCover)paramEntity;
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("type", paramEntity.type);
    paramContentValues.put("jigsaw", Integer.valueOf(paramEntity.jigsaw));
    paramContentValues.put("vCoverInfo", paramEntity.vCoverInfo);
    paramContentValues.put("vPhotoInfo", paramEntity.vPhotoInfo);
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,type TEXT ,jigsaw INTEGER ,vCoverInfo BLOB ,vPhotoInfo BLOB)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     akvs
 * JD-Core Version:    0.7.0.1
 */