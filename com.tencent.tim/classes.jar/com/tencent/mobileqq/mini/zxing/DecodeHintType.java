package com.tencent.mobileqq.mini.zxing;

import java.util.List;

public class DecodeHintType
{
  public static final DecodeHintType ALLOWED_EAN_EXTENSIONS = new DecodeHintType("ALLOWED_EAN_EXTENSIONS", [I.class);
  public static final DecodeHintType ALLOWED_LENGTHS;
  public static final DecodeHintType ASSUME_CODE_39_CHECK_DIGIT;
  public static final DecodeHintType ASSUME_GS1;
  public static final DecodeHintType CHARACTER_SET;
  public static final DecodeHintType NEED_RESULT_POINT_CALLBACK;
  public static final DecodeHintType OTHER = new DecodeHintType("OTHER", Object.class);
  public static final DecodeHintType POSSIBLE_FORMATS;
  public static final DecodeHintType PURE_BARCODE = new DecodeHintType("PURE_BARCODE", Void.class);
  public static final DecodeHintType RETURN_CODABAR_START_END;
  public static final DecodeHintType TRY_HARDER;
  public final String name;
  private final Class<?> valueType;
  
  static
  {
    POSSIBLE_FORMATS = new DecodeHintType("POSSIBLE_FORMATS", List.class);
    TRY_HARDER = new DecodeHintType("TRY_HARDER", Void.class);
    CHARACTER_SET = new DecodeHintType("CHARACTER_SET", String.class);
    ALLOWED_LENGTHS = new DecodeHintType("ALLOWED_LENGTHS", [I.class);
    ASSUME_CODE_39_CHECK_DIGIT = new DecodeHintType("ASSUME_CODE_39_CHECK_DIGIT", Void.class);
    ASSUME_GS1 = new DecodeHintType("ASSUME_GS1", Void.class);
    RETURN_CODABAR_START_END = new DecodeHintType("RETURN_CODABAR_START_END", Void.class);
    NEED_RESULT_POINT_CALLBACK = new DecodeHintType("NEED_RESULT_POINT_CALLBACK", ResultPointCallback.class);
  }
  
  private DecodeHintType(String paramString, Class<?> paramClass)
  {
    this.name = paramString;
    this.valueType = paramClass;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (DecodeHintType)paramObject;
    } while ((this.valueType.equals(paramObject.valueType)) && (this.name.equals(paramObject.name)));
    return false;
  }
  
  public Class<?> getValueType()
  {
    return this.valueType;
  }
  
  public int hashCode()
  {
    return this.name.hashCode() * 31 + this.valueType.hashCode();
  }
  
  public String toString()
  {
    return "DecodeHintType{valueType=" + this.valueType + ", name='" + this.name + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.DecodeHintType
 * JD-Core Version:    0.7.0.1
 */