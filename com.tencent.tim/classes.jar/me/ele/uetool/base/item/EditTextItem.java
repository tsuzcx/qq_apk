package me.ele.uetool.base.item;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import me.ele.uetool.base.Element;

public class EditTextItem
  extends ElementItem
{
  private String detail;
  private int type;
  
  public EditTextItem(String paramString1, Element paramElement, int paramInt, String paramString2)
  {
    super(paramString1, paramElement);
    this.type = paramInt;
    this.detail = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof EditTextItem))
    {
      paramObject = (EditTextItem)paramObject;
      bool1 = bool2;
      if (getName().equals(paramObject.getName()))
      {
        bool1 = bool2;
        if (paramObject.getDetail().equals(getDetail())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public String getDetail()
  {
    return this.detail;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public int hashCode()
  {
    return this.detail.hashCode() | getName().hashCode();
  }
  
  public void setDetail(String paramString)
  {
    this.detail = paramString;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Type
  {
    public static final int TYPE_HEIGHT = 5;
    public static final int TYPE_MARGIN_LEFT = 11;
    public static final int TYPE_MARGIN_TOP = 10;
    public static final int TYPE_NONE = -1;
    public static final int TYPE_PADDING_BOTTOM = 9;
    public static final int TYPE_PADDING_LEFT = 6;
    public static final int TYPE_PADDING_RIGHT = 7;
    public static final int TYPE_PADDING_TOP = 8;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_TEXT_COLOR = 3;
    public static final int TYPE_TEXT_SIZE = 2;
    public static final int TYPE_WIDTH = 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.base.item.EditTextItem
 * JD-Core Version:    0.7.0.1
 */