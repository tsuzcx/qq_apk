import android.database.Cursor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class akvb
{
  private volatile boolean cuH;
  private ConcurrentHashMap<String, Integer> gv;
  
  public static MessageRecord a(Entity paramEntity)
  {
    if (paramEntity != null) {}
    try
    {
      paramEntity.postRead();
      paramEntity = (MessageRecord)paramEntity;
      return paramEntity;
    }
    catch (Exception paramEntity)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Cursor2EntityConvert", 2, "postRead exception = " + paramEntity.getMessage());
      }
      return null;
    }
    catch (OutOfMemoryError paramEntity)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Cursor2EntityConvert", 2, "postRead OutOfMemoryError");
        }
      }
    }
    catch (VerifyError paramEntity)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Cursor2EntityConvert", 2, "postRead VerifyError");
        }
      }
    }
  }
  
  private void a(List<Field> paramList, Cursor paramCursor)
  {
    if ((paramList == null) || (paramCursor == null)) {}
    for (;;)
    {
      return;
      if (this.gv == null) {
        this.gv = new ConcurrentHashMap();
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = ((Field)paramList.next()).getName();
        int i = paramCursor.getColumnIndex(str);
        this.gv.put(str, Integer.valueOf(i));
      }
    }
  }
  
  public void clean()
  {
    this.cuH = false;
    if (this.gv != null)
    {
      this.gv.clear();
      this.gv = null;
    }
  }
  
  public Entity cursor2Entity(Class<? extends Entity> paramClass, String paramString, Cursor paramCursor)
  {
    if (paramCursor.isBeforeFirst()) {
      paramCursor.moveToFirst();
    }
    try
    {
      if (paramCursor.getColumnIndex("_id") >= 0) {}
      for (l = paramCursor.getLong(paramCursor.getColumnIndex("_id"));; l = -1L)
      {
        try
        {
          if (paramClass.getName().equals(MessageRecord.class.getName()))
          {
            int i = paramCursor.getInt(paramCursor.getColumnIndex("msgtype"));
            byte[] arrayOfByte = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
            int j = paramCursor.getInt(paramCursor.getColumnIndex("extLong"));
            String str = paramCursor.getString(paramCursor.getColumnIndex("extStr"));
            int k = paramCursor.getInt(paramCursor.getColumnIndex("istroop"));
            paramClass = anbi.a(i, arrayOfByte, j, str, k);
            paramClass.msgData = arrayOfByte;
            paramClass._id = l;
            paramClass.extLong = j;
            paramClass.extStr = str;
            paramClass.istroop = k;
            if (!this.cuH)
            {
              this.cuH = true;
              a(TableBuilder.getAllField(paramClass), paramCursor);
            }
            paramClass.selfuin = paramCursor.getString(((Integer)this.gv.get("selfuin")).intValue());
            paramClass.frienduin = paramCursor.getString(((Integer)this.gv.get("frienduin")).intValue());
            paramClass.senderuin = paramCursor.getString(((Integer)this.gv.get("senderuin")).intValue());
            paramClass.time = paramCursor.getLong(((Integer)this.gv.get("time")).intValue());
            paramClass.msgtype = paramCursor.getInt(((Integer)this.gv.get("msgtype")).intValue());
            paramClass.issend = paramCursor.getInt(((Integer)this.gv.get("issend")).intValue());
            paramClass.msgseq = paramCursor.getLong(((Integer)this.gv.get("msgseq")).intValue());
            paramClass.shmsgseq = paramCursor.getLong(((Integer)this.gv.get("shmsgseq")).intValue());
            paramClass.msgId = paramCursor.getLong(((Integer)this.gv.get("msgId")).intValue());
            paramClass.msgUid = paramCursor.getLong(((Integer)this.gv.get("msgUid")).intValue());
            paramClass.uniseq = paramCursor.getLong(((Integer)this.gv.get("uniseq")).intValue());
            paramClass.versionCode = paramCursor.getInt(((Integer)this.gv.get("versionCode")).intValue());
            if (paramClass.versionCode <= 0) {
              paramClass.msg = paramCursor.getString(((Integer)this.gv.get("msg")).intValue());
            }
            if ((l != -1L) && (paramString != null)) {
              paramClass._status = 1001;
            } else {
              paramClass._status = 1002;
            }
          }
        }
        catch (Exception paramClass)
        {
          clean();
          return null;
        }
        catch (VerifyError paramClass)
        {
          clean();
          return null;
        }
        catch (OutOfMemoryError paramClass)
        {
          return null;
        }
        paramClass = null;
        break;
      }
      return paramClass;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l = -1L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     akvb
 * JD-Core Version:    0.7.0.1
 */