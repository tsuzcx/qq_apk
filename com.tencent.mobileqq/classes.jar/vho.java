import android.database.Cursor;
import android.os.Parcel;
import com.tencent.biz.qqcircle.bizparts.danmaku.model.QzoneBarrageEffectData;
import com.tencent.component.app.common.ParcelableWrapper;
import cooperation.qzone.util.QZLog;

public final class vho
  implements bjvx<QzoneBarrageEffectData>
{
  public int a()
  {
    return 1;
  }
  
  public QzoneBarrageEffectData a(Cursor paramCursor)
  {
    Object localObject1 = paramCursor.getBlob(paramCursor.getColumnIndex("barrage_effect_data"));
    paramCursor = Parcel.obtain();
    try
    {
      paramCursor.unmarshall((byte[])localObject1, 0, localObject1.length);
      paramCursor.setDataPosition(0);
      localObject1 = (QzoneBarrageEffectData)ParcelableWrapper.createDataFromParcel(paramCursor);
      return localObject1;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QZLog.w("QzoneBarrageEffectData", "QzoneBarrageEffectData createFromCursor Error");
      return null;
    }
    catch (Exception localException)
    {
      return null;
    }
    finally
    {
      if (paramCursor != null) {
        paramCursor.recycle();
      }
    }
    return null;
  }
  
  public String a()
  {
    return null;
  }
  
  public bjvy[] a()
  {
    return new bjvy[] { new bjvy("uin", "INTEGER UNIQUE"), new bjvy("barrage_effect_data", "BLOB") };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vho
 * JD-Core Version:    0.7.0.1
 */