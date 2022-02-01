package com.tencent.qqmail.annotation.database;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface ORMClass
{
  public static final int ARG_TYPE_ARRAY = 2;
  public static final int ARG_TYPE_LIST = 3;
  public static final int ARG_TYPE_SINGLE = 1;
  public static final String INSERT = "INSERT";
  public static final String INSERT_OR_ABORT = "INSERT OR ABORT";
  public static final String INSERT_OR_FAIL = "INSERT OR FAIL";
  public static final String INSERT_OR_IGNORE = "INSERT OR IGNORE";
  public static final String INSERT_OR_REPLACE = "REPLACE";
  public static final String INSERT_OR_ROLLBACK = "INSERT OR ROLLBACK";
  public static final String UPDATE = "UPDATE";
  public static final String UPDATE_OR_ABORT = "UPDATE OR ABORT";
  public static final String UPDATE_OR_FAIL = "UPDATE OR FAIL";
  public static final String UPDATE_OR_IGNORE = "UPDATE OR IGNORE";
  public static final String UPDATE_OR_REPLACE = "UPDATE OR REPLACE";
  public static final String UPDATE_OR_ROLLBACK = "UPDATE OR ROLLBACK";
  
  int[] insertArgType() default {1};
  
  String[] insertStatement() default {"REPLACE"};
  
  boolean supportDistinct() default false;
  
  int[] updateArgType() default {1};
  
  String[] updateStatement() default {"UPDATE"};
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.annotation.database.ORMClass
 * JD-Core Version:    0.7.0.1
 */