package com.tencent.beacon.a.a;

import java.util.Locale;

public final class b
{
  public static final String[][] a = new String[3][];
  
  static
  {
    a[0] = { "t_event", String.format(Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s int , %s int , %s int , %s int , %s blob)", new Object[] { "t_event", "_id", "_time", "_type", "_prority", "_length", "_datas" }) };
    a[1] = { "t_count_event", String.format(Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s varchar(255) unique  , %s int , %s int , %s int , %s int , %s int , %s text)", new Object[] { "t_count_event", "_id", "_countid", "_prority", "_local", "_stime", "_utime", "_ctime", "_cparams" }) };
    a[2] = { "t_strategy", String.format(Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s int unique , %s int , %s blob)", new Object[] { "t_strategy", "_id", "_key", "_ut", "_datas" }) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.beacon.a.a.b
 * JD-Core Version:    0.7.0.1
 */