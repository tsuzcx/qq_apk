package com.tencent.mobileqq.troop.data;

import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;

public class TroopBarPostLayoutFactory
{
  public static final int a = 0;
  protected static final SparseArray a = new SparseArray();
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 7;
  public static final int g = -1001;
  public static final int h = -1002;
  public static final int i = -1003;
  public static final int j = -1004;
  public static final int k = 1;
  public static final int l = 2;
  public static final int m = 3;
  protected static final int n = 1;
  
  static
  {
    a.append(-1001, TroopBarPostLayoutBanner.class);
    a.append(-1002, TroopBarPostLayoutRelativeGroup.class);
    a.append(-1003, TroopBarPostLayoutTab.class);
    a.append(-1004, TroopBarPostLayoutTop.class);
    a.append(1, TroopBarPostLayout1.class);
    a.append(2, TroopBarPostLayout2.class);
    a.append(3, TroopBarPostLayout3.class);
  }
  
  public static TroopBarPostAbsLayout a(int paramInt)
  {
    Class localClass = (Class)a.get(paramInt);
    if (localClass != null) {}
    for (;;)
    {
      try
      {
        TroopBarPostAbsLayout localTroopBarPostAbsLayout1 = (TroopBarPostAbsLayout)localClass.newInstance();
        if (localClass == null)
        {
          if (!QLog.isColorLevel()) {
            break label317;
          }
          QLog.e("TroopBar", 2, "Not supported element");
          return localTroopBarPostAbsLayout1;
        }
        if ((localTroopBarPostAbsLayout1 != null) || (!QLog.isColorLevel())) {
          break label317;
        }
        QLog.e("TroopBar", 2, "New instance " + localClass.getSimpleName() + " failure.");
        return localTroopBarPostAbsLayout1;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopBar", 2, "TroopBarPostLayoutFactory createItemLayout IllegalAccessException");
        }
        if (localClass == null)
        {
          if (QLog.isColorLevel())
          {
            QLog.e("TroopBar", 2, "Not supported element");
            return null;
          }
        }
        else if ((0 == 0) && (QLog.isColorLevel()))
        {
          QLog.e("TroopBar", 2, "New instance " + localClass.getSimpleName() + " failure.");
          return null;
        }
      }
      catch (InstantiationException localInstantiationException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopBar", 2, "TroopBarPostLayoutFactory createItemLayout InstantiationException");
        }
        if (localClass == null)
        {
          if (QLog.isColorLevel())
          {
            QLog.e("TroopBar", 2, "Not supported element");
            return null;
          }
        }
        else if ((0 == 0) && (QLog.isColorLevel()))
        {
          QLog.e("TroopBar", 2, "New instance " + localClass.getSimpleName() + " failure.");
          return null;
        }
      }
      finally
      {
        if (localClass == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopBar", 2, "Not supported element");
          }
          throw localTroopBarPostAbsLayout2;
        }
        if ((0 != 0) || (!QLog.isColorLevel())) {
          continue;
        }
        QLog.e("TroopBar", 2, "New instance " + localClass.getSimpleName() + " failure.");
        continue;
      }
      return null;
      label317:
      return localTroopBarPostAbsLayout2;
      Object localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopBarPostLayoutFactory
 * JD-Core Version:    0.7.0.1
 */