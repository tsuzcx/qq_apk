package com.tencent.qqmail.annotation.table;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface SQLiteField
{
  public static final String JAVA_TYPE_BOOLEAN = "boolean";
  public static final String JAVA_TYPE_BYTE_ARRAY = "byte[]";
  public static final String JAVA_TYPE_DOUBLE = "double";
  public static final String JAVA_TYPE_FLOAT = "float";
  public static final String JAVA_TYPE_INT = "int";
  public static final String JAVA_TYPE_LONG = "long";
  public static final String JAVA_TYPE_STRING = "String";
  public static final String TYPE_BLOB = "BLOB";
  public static final String TYPE_INTEGER = "INTEGER";
  public static final String TYPE_NUMERIC = "NUMERIC";
  public static final String TYPE_REAL = "REAL";
  public static final String TYPE_TEXT = "TEXT";
  public static final String TYPE_VARCHAR = "VARCHAR";
  
  String javaDefaultType();
  
  String type();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.annotation.table.SQLiteField
 * JD-Core Version:    0.7.0.1
 */