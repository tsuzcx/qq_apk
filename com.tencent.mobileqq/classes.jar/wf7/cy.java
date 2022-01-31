package wf7;

import android.text.TextUtils;
import com.tencent.qqpimsecure.wificore.api.recognize.monitor.Dog;
import com.tencent.qqpimsecure.wificore.api.recognize.monitor.DogFood;
import com.tencent.qqpimsecure.wificore.api.recognize.monitor.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class cy
  implements a
{
  private static String TAG = "WifiRecognizeWatchDog";
  public static final HashMap<Long, Boolean> jA = new HashMap();
  private static final HashMap<Long, Dog> jB = new HashMap();
  
  public void a(long paramLong, DogFood paramDogFood)
  {
    Dog localDog;
    synchronized (jB)
    {
      localDog = (Dog)jB.get(Long.valueOf(paramLong));
      if (localDog == null) {
        return;
      }
      ??? = localDog.fD.iterator();
      while (((Iterator)???).hasNext()) {
        if (TextUtils.equals(((DogFood)((Iterator)???).next()).fE, paramDogFood.fE)) {
          return;
        }
      }
    }
    localDog.fD.add(paramDogFood);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.cy
 * JD-Core Version:    0.7.0.1
 */