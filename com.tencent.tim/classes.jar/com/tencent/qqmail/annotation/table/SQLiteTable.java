package com.tencent.qqmail.annotation.table;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface SQLiteTable
{
  SQLiteForeignKey[] foreignKeys() default {};
  
  String openHelperName();
  
  String[] primaryKey();
  
  String tableName();
  
  public static @interface SQLiteForeignKey
  {
    public static final String ACTION_NO_ACTION = "";
    public static final String ACTION_ON_DELETE_CASCADE = "ON DELETE CASCADE";
    public static final String ACTION_ON_DELETE_RESTRICT = "ON DELETE RESTRICT";
    public static final String ACTION_ON_DELETE_SET_DEFAULT = "ON DELETE SET DEFAULT";
    public static final String ACTION_ON_DELETE_SET_NULL = "ON DELETE SET NULL";
    public static final String ACTION_ON_UPDATE_CASCADE = "ON UPDATE CASCADE";
    public static final String ACTION_ON_UPDATE_RESTRICT = "ON UPDATE RESTRICT";
    public static final String ACTION_ON_UPDATE_SET_DEFAULT = "ON UPDATE SET DEFAULT";
    public static final String ACTION_ON_UPDATE_SET_NULL = "ON UPDATE  SET NULL";
    
    String deleteAction() default "";
    
    String[] keys();
    
    String[] referencesFields();
    
    String referencesTableName();
    
    String updateAction() default "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.annotation.table.SQLiteTable
 * JD-Core Version:    0.7.0.1
 */