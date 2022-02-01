package com.tencent.qqmail.annotation.table;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface SQLiteTableData
{
  boolean copyRow() default false;
  
  int[] insertArgType() default {1};
  
  String[] insertStatement() default {"REPLACE"};
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.annotation.table.SQLiteTableData
 * JD-Core Version:    0.7.0.1
 */