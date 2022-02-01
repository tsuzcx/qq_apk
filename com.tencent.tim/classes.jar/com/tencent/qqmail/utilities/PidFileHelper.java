package com.tencent.qqmail.utilities;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmail.QMApplicationContext;

@Deprecated
public class PidFileHelper
{
  public static void deletePidFile()
  {
    SharedPreferences.Editor localEditor = QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).edit();
    localEditor.putInt("pid", -1);
    localEditor.commit();
  }
  
  public static int getPid()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).getInt("pid", -1);
  }
  
  public static void savePid(int paramInt)
  {
    SharedPreferences.Editor localEditor = QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).edit();
    localEditor.putInt("pid", paramInt);
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.PidFileHelper
 * JD-Core Version:    0.7.0.1
 */