package com.tencent.qqmail.utilities;

import android.text.TextUtils;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class VmDetectUtil
{
  static
  {
    System.loadLibrary("detect_vm");
  }
  
  public static String detect()
  {
    int j = 0;
    ValidateHelper.assertInDebug("must run in main process", QMApplicationContext.sharedInstance().isMainProcess());
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    int i = 0;
    Object localObject2;
    if (i < 3)
    {
      localObject2 = nativeDetect();
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = ((String)localObject2).split("\\|");
        if (localObject1.length == 4)
        {
          localHashMap1.put(localObject1[1], localObject2);
          localObject2 = (Integer)localHashMap2.get(localObject1[1]);
          if (localObject2 != null) {
            break label114;
          }
          localHashMap2.put(localObject1[1], Integer.valueOf(1));
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label114:
        localHashMap2.put(localObject1[1], Integer.valueOf(((Integer)localObject2).intValue() + 1));
      }
    }
    Object localObject1 = null;
    Iterator localIterator = localHashMap2.keySet().iterator();
    i = j;
    if (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      j = ((Integer)localHashMap2.get(localObject2)).intValue();
      if (j <= i) {
        break label215;
      }
      i = j;
      localObject1 = localObject2;
    }
    label215:
    for (;;)
    {
      break;
      return (String)localHashMap1.get(localObject1);
    }
  }
  
  private static synchronized native String nativeDetect();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.VmDetectUtil
 * JD-Core Version:    0.7.0.1
 */