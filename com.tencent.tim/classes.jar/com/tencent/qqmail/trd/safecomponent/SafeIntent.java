package com.tencent.qqmail.trd.safecomponent;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.Serializable;
import java.util.ArrayList;

public class SafeIntent
  extends Intent
{
  private static final String TAG = "SafeIntent";
  
  public SafeIntent(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public static Intent createSafeIntet(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    return new SafeIntent(paramIntent);
  }
  
  public boolean[] getBooleanArrayExtra(String paramString)
  {
    try
    {
      paramString = super.getBooleanArrayExtra(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      QMLog.log(6, "SafeIntent", paramString.getMessage());
    }
    return null;
  }
  
  public boolean getBooleanExtra(String paramString, boolean paramBoolean)
  {
    try
    {
      paramBoolean = super.getBooleanExtra(paramString, paramBoolean);
      return paramBoolean;
    }
    catch (Throwable paramString)
    {
      QMLog.log(6, "SafeIntent", paramString.getMessage());
    }
    return false;
  }
  
  public Bundle getBundleExtra(String paramString)
  {
    try
    {
      paramString = super.getBundleExtra(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      QMLog.log(6, "SafeIntent", paramString.getMessage());
    }
    return null;
  }
  
  public byte[] getByteArrayExtra(String paramString)
  {
    try
    {
      paramString = super.getByteArrayExtra(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      QMLog.log(6, "SafeIntent", paramString.getMessage());
    }
    return null;
  }
  
  public byte getByteExtra(String paramString, byte paramByte)
  {
    try
    {
      paramByte = super.getByteExtra(paramString, paramByte);
      return paramByte;
    }
    catch (Throwable paramString)
    {
      QMLog.log(6, "SafeIntent", paramString.getMessage());
    }
    return 0;
  }
  
  public char[] getCharArrayExtra(String paramString)
  {
    try
    {
      paramString = super.getCharArrayExtra(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      QMLog.log(6, "SafeIntent", paramString.getMessage());
    }
    return null;
  }
  
  public char getCharExtra(String paramString, char paramChar)
  {
    try
    {
      paramChar = super.getCharExtra(paramString, paramChar);
      return paramChar;
    }
    catch (Throwable paramString)
    {
      QMLog.log(6, "SafeIntent", paramString.getMessage());
    }
    return '\000';
  }
  
  public CharSequence[] getCharSequenceArrayExtra(String paramString)
  {
    try
    {
      paramString = super.getCharSequenceArrayExtra(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      QMLog.log(6, "SafeIntent", paramString.getMessage());
    }
    return null;
  }
  
  public ArrayList<CharSequence> getCharSequenceArrayListExtra(String paramString)
  {
    try
    {
      paramString = super.getCharSequenceArrayListExtra(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      QMLog.log(6, "SafeIntent", paramString.getMessage());
    }
    return null;
  }
  
  public CharSequence getCharSequenceExtra(String paramString)
  {
    try
    {
      paramString = super.getCharSequenceExtra(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      QMLog.log(6, "SafeIntent", paramString.getMessage());
    }
    return null;
  }
  
  public double[] getDoubleArrayExtra(String paramString)
  {
    try
    {
      paramString = super.getDoubleArrayExtra(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      QMLog.log(6, "SafeIntent", paramString.getMessage());
    }
    return null;
  }
  
  public double getDoubleExtra(String paramString, double paramDouble)
  {
    try
    {
      paramDouble = super.getDoubleExtra(paramString, paramDouble);
      return paramDouble;
    }
    catch (Throwable paramString)
    {
      QMLog.log(6, "SafeIntent", paramString.getMessage());
    }
    return 0.0D;
  }
  
  public float[] getFloatArrayExtra(String paramString)
  {
    try
    {
      paramString = super.getFloatArrayExtra(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      QMLog.log(6, "SafeIntent", paramString.getMessage());
    }
    return null;
  }
  
  public float getFloatExtra(String paramString, float paramFloat)
  {
    try
    {
      paramFloat = super.getFloatExtra(paramString, paramFloat);
      return paramFloat;
    }
    catch (Throwable paramString)
    {
      QMLog.log(6, "SafeIntent", paramString.getMessage());
    }
    return 0.0F;
  }
  
  public int[] getIntArrayExtra(String paramString)
  {
    try
    {
      paramString = super.getIntArrayExtra(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      QMLog.log(6, "SafeIntent", paramString.getMessage());
    }
    return null;
  }
  
  public int getIntExtra(String paramString, int paramInt)
  {
    try
    {
      paramInt = super.getIntExtra(paramString, paramInt);
      return paramInt;
    }
    catch (Throwable paramString)
    {
      QMLog.log(6, "SafeIntent", paramString.getMessage());
    }
    return 0;
  }
  
  public ArrayList<Integer> getIntegerArrayListExtra(String paramString)
  {
    try
    {
      paramString = super.getIntegerArrayListExtra(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      QMLog.log(6, "SafeIntent", paramString.getMessage());
    }
    return null;
  }
  
  public long[] getLongArrayExtra(String paramString)
  {
    try
    {
      paramString = super.getLongArrayExtra(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      QMLog.log(6, "SafeIntent", paramString.getMessage());
    }
    return null;
  }
  
  public long getLongExtra(String paramString, long paramLong)
  {
    try
    {
      paramLong = super.getLongExtra(paramString, paramLong);
      return paramLong;
    }
    catch (Throwable paramString)
    {
      QMLog.log(6, "SafeIntent", paramString.getMessage());
    }
    return 0L;
  }
  
  public Parcelable[] getParcelableArrayExtra(String paramString)
  {
    try
    {
      paramString = super.getParcelableArrayExtra(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      QMLog.log(6, "SafeIntent", paramString.getMessage());
    }
    return null;
  }
  
  public <T extends Parcelable> ArrayList<T> getParcelableArrayListExtra(String paramString)
  {
    try
    {
      paramString = super.getParcelableArrayListExtra(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      QMLog.log(6, "SafeIntent", paramString.getMessage());
    }
    return null;
  }
  
  public <T extends Parcelable> T getParcelableExtra(String paramString)
  {
    try
    {
      paramString = super.getParcelableExtra(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      QMLog.log(6, "SafeIntent", paramString.getMessage());
    }
    return null;
  }
  
  public Serializable getSerializableExtra(String paramString)
  {
    try
    {
      paramString = super.getSerializableExtra(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      QMLog.log(6, "SafeIntent", paramString.getMessage());
    }
    return null;
  }
  
  public short[] getShortArrayExtra(String paramString)
  {
    try
    {
      paramString = super.getShortArrayExtra(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      QMLog.log(6, "SafeIntent", paramString.getMessage());
    }
    return null;
  }
  
  public short getShortExtra(String paramString, short paramShort)
  {
    try
    {
      paramShort = super.getShortExtra(paramString, paramShort);
      return paramShort;
    }
    catch (Throwable paramString)
    {
      QMLog.log(6, "SafeIntent", paramString.getMessage());
    }
    return 0;
  }
  
  public String[] getStringArrayExtra(String paramString)
  {
    try
    {
      paramString = super.getStringArrayExtra(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      QMLog.log(6, "SafeIntent", paramString.getMessage());
    }
    return null;
  }
  
  public ArrayList<String> getStringArrayListExtra(String paramString)
  {
    try
    {
      paramString = super.getStringArrayListExtra(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      QMLog.log(6, "SafeIntent", paramString.getMessage());
    }
    return null;
  }
  
  public String getStringExtra(String paramString)
  {
    try
    {
      paramString = super.getStringExtra(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      QMLog.log(6, "SafeIntent", paramString.getMessage());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.trd.safecomponent.SafeIntent
 * JD-Core Version:    0.7.0.1
 */