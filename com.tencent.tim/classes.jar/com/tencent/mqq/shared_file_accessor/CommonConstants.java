package com.tencent.mqq.shared_file_accessor;

import java.util.Set;

public class CommonConstants
{
  static final String CMD_CLR = "3";
  static final String CMD_COMMIT = "5";
  static final String CMD_DEL = "2";
  static final String CMD_GET = "0";
  static final String CMD_LOG = "101";
  static final String CMD_PUT = "1";
  static final String CMD_SYNC_FILENAME = "4";
  static final String KEY_FOR_DELETE_ALL = "*";
  static final String KEY_FOR_GET_ALL = "*";
  static final boolean NOT_USE_CP_IF_POSSIBLE = true;
  static final String URI_PARAM_CMD = "cmd";
  static final String URI_PARAM_KEY_DEFAULT_VALUE = "default";
  static final String URI_PARAM_KEY_FILE = "file";
  static final String URI_PARAM_KEY_KEY = "key";
  static final String URI_PARAM_KEY_LOG = "log";
  static final String URI_PARAM_KEY_PROCESS = "process";
  static final String URI_PARAM_KEY_VALUE_TYPE = "value_type";
  public static final ValueType VALUE_TYPE_ANY = new ValueType(0, "*", null);
  public static final ValueType VALUE_TYPE_BOOLEAN = new ValueType(5, Boolean.class.getName(), null);
  public static final ValueType VALUE_TYPE_FLOAT;
  public static final ValueType VALUE_TYPE_INT = new ValueType(1, Integer.class.getName(), null);
  public static final ValueType VALUE_TYPE_LONG = new ValueType(2, Long.class.getName(), null);
  public static final ValueType VALUE_TYPE_STRING;
  public static final ValueType VALUE_TYPE_STRSET = new ValueType(6, Set.class.getName(), null);
  
  static
  {
    VALUE_TYPE_FLOAT = new ValueType(3, Float.class.getName(), null);
    VALUE_TYPE_STRING = new ValueType(4, String.class.getName(), null);
  }
  
  public static class ValueType
  {
    public static final int VALUE_TYPE_ENUM_ANY = 0;
    public static final int VALUE_TYPE_ENUM_BOOLEAN = 5;
    public static final int VALUE_TYPE_ENUM_FLOAT = 3;
    public static final int VALUE_TYPE_ENUM_INT = 1;
    public static final int VALUE_TYPE_ENUM_LONG = 2;
    public static final int VALUE_TYPE_ENUM_STRING = 4;
    public static final int VALUE_TYPE_ENUM_STRSET = 6;
    public int mEnumValue = 0;
    public String mTypeName = null;
    
    private ValueType(int paramInt, String paramString)
    {
      this.mEnumValue = paramInt;
      this.mTypeName = paramString;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == null) {}
      do
      {
        return false;
        if (!(paramObject instanceof Integer)) {
          break;
        }
      } while (this.mEnumValue != ((Integer)paramObject).intValue());
      return true;
      if ((paramObject instanceof String)) {
        return this.mTypeName.equals(paramObject);
      }
      return super.equals(paramObject);
    }
    
    public String toString()
    {
      return this.mTypeName;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.CommonConstants
 * JD-Core Version:    0.7.0.1
 */