import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public abstract class afrl
{
  public static afrl a(Bundle paramBundle)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int i;
    if (paramBundle != null)
    {
      localObject1 = localObject2;
      if (paramBundle.containsKey("cur_data_source_type"))
      {
        QLog.d("EmoticonPreviewData", 1, "restoreSaveInstanceState execute");
        i = paramBundle.getInt("cur_data_source_type");
        if (i != 0) {
          break label53;
        }
        localObject1 = new afrt(null).b(paramBundle);
      }
    }
    label53:
    do
    {
      return localObject1;
      localObject1 = localObject2;
    } while (i != 1);
    return new afrr(null).b(paramBundle);
  }
  
  public abstract afmi a();
  
  public abstract CustomEmotionData a();
  
  public abstract boolean a(afrl paramafrl);
  
  public abstract boolean ajO();
  
  public abstract boolean ajP();
  
  public abstract boolean ajQ();
  
  public abstract boolean ajR();
  
  public void b(Bundle paramBundle, int paramInt)
  {
    paramBundle.putInt("cur_data_source_type", paramInt);
  }
  
  public abstract Drawable e(Context paramContext);
  
  public abstract long getUniqueId();
  
  public abstract int t(List<afrl> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afrl
 * JD-Core Version:    0.7.0.1
 */