import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.video.bandwidth.VideoBufferRangeController.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class mzz
  implements Comparator<Integer[]>
{
  private static mzz a;
  
  public static mzz a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new mzz();
      }
      return a;
    }
    finally {}
  }
  
  private List<Integer[]> decodeConfigs(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = Aladdin.getConfig(288).getString(paramString, null);
    if (QLog.isColorLevel()) {
      QLog.d("VideoBufferRangeController", 2, "decodeConfigs: key=" + paramString + ", configStr=" + (String)localObject);
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return localArrayList;
    }
    paramString = ((String)localObject).split("\\|");
    int j = paramString.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        localObject = paramString[i].split(",");
        if (localObject.length == 2) {}
        try
        {
          localArrayList.add(new Integer[] { Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]) });
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("VideoBufferRangeController", 2, "getConfigs: ", localException);
            }
          }
        }
      }
    }
    Collections.sort(localArrayList, this);
    return localArrayList;
  }
  
  private int[] getConfigsForUnPeekPeriod()
  {
    Object localObject = decodeConfigs("uneffective_time_config");
    if (((List)localObject).size() > 0) {
      localObject = (Integer[])((List)localObject).get(0);
    }
    for (;;)
    {
      return new int[] { localObject[0].intValue(), localObject[1].intValue() };
      localObject = new Integer[2];
      localObject[0] = Integer.valueOf(0);
      localObject[1] = Integer.valueOf(0);
    }
  }
  
  private List<Integer[]> getEffectiveTimeConfigs()
  {
    return decodeConfigs("effective_time");
  }
  
  private List<Integer[]> getEmergencyTimeConfigs()
  {
    return decodeConfigs("emergency_time_config");
  }
  
  private List<Integer[]> getSafePlayTimeConfigs()
  {
    return decodeConfigs("safe_play_time_config");
  }
  
  private boolean isPeakPeriod(List<Integer[]> paramList)
  {
    int i = Calendar.getInstance().get(11);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Integer[] arrayOfInteger = (Integer[])paramList.next();
      if ((i >= arrayOfInteger[0].intValue()) && (i < arrayOfInteger[1].intValue())) {
        return true;
      }
    }
    return false;
  }
  
  private int judgeStrategy(List<Integer[]> paramList, long paramLong, int paramInt)
  {
    if ((paramLong > 0L) && (paramInt > 0))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Integer[] arrayOfInteger = (Integer[])localIterator.next();
        if (paramLong > arrayOfInteger[0].intValue() * paramInt / 8) {
          return arrayOfInteger[1].intValue();
        }
      }
    }
    if (!paramList.isEmpty())
    {
      paramList = (Integer[])paramList.get(paramList.size() - 1);
      if (paramList[0].intValue() <= 0) {
        return paramList[1].intValue();
      }
    }
    return 0;
  }
  
  public void a(myi parammyi, int paramInt, long paramLong)
  {
    muj.runOnUIThread(new VideoBufferRangeController.1(this, parammyi, a().computeBufferange(paramInt, paramLong)));
  }
  
  public int compare(Integer[] paramArrayOfInteger1, Integer[] paramArrayOfInteger2)
  {
    return paramArrayOfInteger2[0].intValue() - paramArrayOfInteger1[0].intValue();
  }
  
  public int[] computeBufferange(long paramLong1, long paramLong2)
  {
    long l = mzs.a().getCurrentPrediction();
    if ((paramLong2 > 0L) && (paramLong1 > 0L)) {}
    for (int i = (int)(paramLong2 / 1024L * 8L / paramLong1);; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoBufferRangeController", 2, "getBufferRange: fileSize=" + paramLong2 + ", duration=" + paramLong1);
      }
      if (!isPeakPeriod(getEffectiveTimeConfigs()))
      {
        localObject = getConfigsForUnPeekPeriod();
        if (QLog.isColorLevel()) {
          QLog.d("VideoBufferRangeController", 2, "computeBufferange: no peak period，use defaultConfig, range=" + localObject[0] + ", " + localObject[1]);
        }
        return localObject;
      }
      Object localObject = getEmergencyTimeConfigs();
      List localList = getSafePlayTimeConfigs();
      int j = judgeStrategy((List)localObject, l, i);
      int k = judgeStrategy(localList, l, i);
      if (QLog.isColorLevel()) {
        QLog.d("VideoBufferRangeController", 2, "getBufferRange: bandwidth=" + l + ", bitrate=" + i + ", range=" + j + ", " + k);
      }
      return new int[] { j, k };
    }
  }
  
  public String kC()
  {
    return Aladdin.getConfig(288).getString("buffer_range_report_tag", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mzz
 * JD-Core Version:    0.7.0.1
 */