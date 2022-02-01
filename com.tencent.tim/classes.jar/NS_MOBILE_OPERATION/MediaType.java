package NS_MOBILE_OPERATION;

import java.io.Serializable;

public final class MediaType
  implements Serializable
{
  public static final MediaType ENUM_MEDIA_AUDIO;
  public static final MediaType ENUM_MEDIA_LINK;
  public static final MediaType ENUM_MEDIA_PIC;
  public static final MediaType ENUM_MEDIA_TEXT;
  public static final MediaType ENUM_MEDIA_VEDIO;
  public static final int _ENUM_MEDIA_AUDIO = 4;
  public static final int _ENUM_MEDIA_LINK = 2;
  public static final int _ENUM_MEDIA_PIC = 1;
  public static final int _ENUM_MEDIA_TEXT = 0;
  public static final int _ENUM_MEDIA_VEDIO = 3;
  private static MediaType[] __values;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!MediaType.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      __values = new MediaType[5];
      ENUM_MEDIA_TEXT = new MediaType(0, 0, "ENUM_MEDIA_TEXT");
      ENUM_MEDIA_PIC = new MediaType(1, 1, "ENUM_MEDIA_PIC");
      ENUM_MEDIA_LINK = new MediaType(2, 2, "ENUM_MEDIA_LINK");
      ENUM_MEDIA_VEDIO = new MediaType(3, 3, "ENUM_MEDIA_VEDIO");
      ENUM_MEDIA_AUDIO = new MediaType(4, 4, "ENUM_MEDIA_AUDIO");
      return;
    }
  }
  
  private MediaType(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static MediaType convert(int paramInt)
  {
    int i = 0;
    while (i < __values.length)
    {
      if (__values[i].value() == paramInt) {
        return __values[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static MediaType convert(String paramString)
  {
    int i = 0;
    while (i < __values.length)
    {
      if (__values[i].toString().equals(paramString)) {
        return __values[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public String toString()
  {
    return this.__T;
  }
  
  public int value()
  {
    return this.__value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_OPERATION.MediaType
 * JD-Core Version:    0.7.0.1
 */