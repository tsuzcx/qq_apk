package com.tencent.feedback.proguard;

import java.util.Locale;

public final class m
{
  public static final String[][] a = new String[5][];
  
  static
  {
    a[0] = { "ao", String.format(Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY , %s int , %s int , %s int , %s int , %s blob , %s text , %s int ,%s int , %s int)", new Object[] { "ao", "_id", "_time", "_type", "_prority", "_length", "_datas", "_key", "_upCounts", "_count", "_state" }) };
    a[1] = { "count", String.format(Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY , %s text unique  , %s int , %s int , %s int , %s int , %s int , %s text)", new Object[] { "count", "_id", "_countid", "_prority", "_local", "_stime", "_utime", "_ctime", "_cparams" }) };
    a[2] = { "gray", String.format(Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY , %s int , %s text unique )", new Object[] { "gray", "_id", "_time", "_uid" }) };
    a[3] = { "file", String.format(Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY , %s text , %s int , %s int , %s text , %s int , %s text )", new Object[] { "file", "_id", "_n", "_ut", "_sz", "_sa", "_t", "_ac" }) };
    a[4] = { "strategy", String.format(Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY , %s int unique , %s int , %s blob)", new Object[] { "strategy", "_id", "_key", "_ut", "_datas" }) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.m
 * JD-Core Version:    0.7.0.1
 */