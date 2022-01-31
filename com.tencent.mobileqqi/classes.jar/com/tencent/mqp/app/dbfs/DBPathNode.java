package com.tencent.mqp.app.dbfs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DBPathNode
{
  public long a;
  DBFSPath jdField_a_of_type_ComTencentMqpAppDbfsDBFSPath;
  DBHelper jdField_a_of_type_ComTencentMqpAppDbfsDBHelper;
  DBSecurity jdField_a_of_type_ComTencentMqpAppDbfsDBSecurity;
  public long b = -1L;
  
  public DBPathNode(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentMqpAppDbfsDBHelper = new DBHelper(paramContext);
    this.jdField_a_of_type_ComTencentMqpAppDbfsDBSecurity = new DBSecurity(paramContext);
    this.jdField_a_of_type_ComTencentMqpAppDbfsDBFSPath = new DBFSPath(paramString);
    c();
  }
  
  private DBFSPath a()
  {
    for (DBFSPath localDBFSPath = this.jdField_a_of_type_ComTencentMqpAppDbfsDBFSPath; localDBFSPath.jdField_a_of_type_ComTencentMqpAppDbfsDBFSPath != null; localDBFSPath = localDBFSPath.jdField_a_of_type_ComTencentMqpAppDbfsDBFSPath) {}
    return localDBFSPath;
  }
  
  private void c()
  {
    this.jdField_a_of_type_Long = -1L;
    this.b = -1L;
    for (DBFSPath localDBFSPath = a(); localDBFSPath != null; localDBFSPath = localDBFSPath.b)
    {
      long l = this.jdField_a_of_type_ComTencentMqpAppDbfsDBHelper.a(this.jdField_a_of_type_Long, localDBFSPath.c);
      if (l == -1L)
      {
        this.jdField_a_of_type_Long = -1L;
        this.b = -1L;
        return;
      }
      this.jdField_a_of_type_Long = l;
    }
    this.b = this.jdField_a_of_type_ComTencentMqpAppDbfsDBHelper.a(this.jdField_a_of_type_Long);
  }
  
  public int a(byte[] paramArrayOfByte)
  {
    int i = 0;
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMqpAppDbfsDBHelper.getWritableDatabase();
    localSQLiteDatabase.beginTransaction();
    try
    {
      b();
      this.b = this.jdField_a_of_type_ComTencentMqpAppDbfsDBHelper.a(this.jdField_a_of_type_ComTencentMqpAppDbfsDBSecurity.a(paramArrayOfByte));
      if (this.b != -1L)
      {
        this.jdField_a_of_type_ComTencentMqpAppDbfsDBHelper.a(this.jdField_a_of_type_Long, this.b);
        i = paramArrayOfByte.length;
      }
      localSQLiteDatabase.setTransactionSuccessful();
      return i;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }
  
  public void a()
  {
    if (-1L == this.jdField_a_of_type_Long) {
      return;
    }
    this.jdField_a_of_type_ComTencentMqpAppDbfsDBHelper.a(this.jdField_a_of_type_Long);
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_Long = -1L;
    this.b = -1L;
    DBFSPath localDBFSPath = a();
    while (localDBFSPath != null)
    {
      long l2 = this.jdField_a_of_type_ComTencentMqpAppDbfsDBHelper.a(this.jdField_a_of_type_Long, localDBFSPath.c);
      long l1 = l2;
      if (l2 == -1L) {
        l1 = this.jdField_a_of_type_ComTencentMqpAppDbfsDBHelper.a(this.jdField_a_of_type_Long, -1L, localDBFSPath.c);
      }
      localDBFSPath = localDBFSPath.b;
      this.jdField_a_of_type_Long = l1;
      this.b = this.jdField_a_of_type_ComTencentMqpAppDbfsDBHelper.a(this.jdField_a_of_type_Long);
      if ((this.b != -1L) && (localDBFSPath != null)) {
        return false;
      }
    }
    return this.jdField_a_of_type_ComTencentMqpAppDbfsDBHelper.a(this.jdField_a_of_type_Long) == null;
  }
  
  public byte[] a()
  {
    if (-1L == this.b) {
      return null;
    }
    byte[] arrayOfByte = this.jdField_a_of_type_ComTencentMqpAppDbfsDBHelper.a(this.b);
    return this.jdField_a_of_type_ComTencentMqpAppDbfsDBSecurity.b(arrayOfByte);
  }
  
  public String[] a()
  {
    if (-1L == this.jdField_a_of_type_Long) {}
    while (-1L != this.b) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMqpAppDbfsDBHelper.a(this.jdField_a_of_type_Long);
  }
  
  public void b()
  {
    if (-1L == this.b) {
      return;
    }
    this.jdField_a_of_type_ComTencentMqpAppDbfsDBHelper.b(this.b);
    this.b = -1L;
    this.jdField_a_of_type_ComTencentMqpAppDbfsDBHelper.a(this.jdField_a_of_type_Long, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mqp.app.dbfs.DBPathNode
 * JD-Core Version:    0.7.0.1
 */