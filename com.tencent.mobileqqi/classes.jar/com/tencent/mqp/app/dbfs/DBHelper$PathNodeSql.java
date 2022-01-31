package com.tencent.mqp.app.dbfs;

class DBHelper$PathNodeSql
{
  public static final String a = "t_PathNode";
  public static final String b = "create table t_PathNode( ID_node\t\tinteger primary key autoincrement, ID_parent\tinteger default(-1), ID_blob\t\tinteger default(-1), name\t\t\tvarchar(64));";
  public static final String c = "create index i_pathIndex on t_PathNode (ID_parent, name);";
  public static final String d = " ID_parent=? and name=? ";
  public static final String e = " ID_parent=? ";
  public static final String f = " ID_node=?";
  public static final String g = "delete from t_PathNode where ID_node=? ";
  public static final String h = "DROP TABLE IF EXISTS t_PathNode";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mqp.app.dbfs.DBHelper.PathNodeSql
 * JD-Core Version:    0.7.0.1
 */