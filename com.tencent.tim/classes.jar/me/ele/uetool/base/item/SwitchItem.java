package me.ele.uetool.base.item;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import me.ele.uetool.base.Element;

public class SwitchItem
  extends ElementItem
{
  private boolean isChecked;
  private int type;
  
  public SwitchItem(String paramString, Element paramElement, int paramInt)
  {
    super(paramString, paramElement);
    this.type = paramInt;
  }
  
  public SwitchItem(String paramString, Element paramElement, int paramInt, boolean paramBoolean)
  {
    super(paramString, paramElement);
    this.type = paramInt;
    this.isChecked = paramBoolean;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof SwitchItem)) {
      return (this.isChecked == ((SwitchItem)paramObject).isChecked) && (getName().equals(((SwitchItem)paramObject).getName()));
    }
    return false;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public int hashCode()
  {
    int j = getName().hashCode();
    if (this.isChecked) {}
    for (int i = 1;; i = 0) {
      return i + j;
    }
  }
  
  public boolean isChecked()
  {
    return this.isChecked;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.isChecked = paramBoolean;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Type
  {
    public static final int TYPE_IS_BOLD = 1;
    public static final int TYPE_MOVE = 2;
    public static final int TYPE_MULT_CHOSEN = 6;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_REMOVE = 7;
    public static final int TYPE_SHOW_LAYERS = 5;
    public static final int TYPE_SHOW_REASON = 4;
    public static final int TYPE_SHOW_VALID_VIEWS = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.base.item.SwitchItem
 * JD-Core Version:    0.7.0.1
 */