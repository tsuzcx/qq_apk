package com.tencent.mqp.app.dbfs;

class DBHelper$BlobNodeSql
{
  public static final String a = "t_BlobNode";
  public static final String b = "create table t_BlobNode( ID_blob\t\tinteger primary key autoincrement, Content\t\tblob, hash\t\t\tchar(20) , ctime\t\tTIMESTAMP, mtime\t\tTIMESTAMP, atime\t\tTIMESTAMP );";
  public static final String c = " ID_blob=? ";
  public static final String d = "delete from t_BlobNode where ID_blob=? ";
  public static final String e = "DROP TABLE IF EXISTS t_BlobNode";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mqp.app.dbfs.DBHelper.BlobNodeSql
 * JD-Core Version:    0.7.0.1
 */