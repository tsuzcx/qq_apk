package me.ele.uetool.base.item;

import me.ele.uetool.base.Element;

public class ElementItem
  extends TitleItem
{
  private ChangeCallBack callBack;
  private Element element;
  
  public ElementItem(String paramString, Element paramElement)
  {
    super(paramString);
    this.element = paramElement;
  }
  
  public ChangeCallBack getCallBack()
  {
    return this.callBack;
  }
  
  public Element getElement()
  {
    return this.element;
  }
  
  public void setCallBack(ChangeCallBack paramChangeCallBack)
  {
    this.callBack = paramChangeCallBack;
  }
  
  public static abstract interface ChangeCallBack
  {
    public abstract void callBack(Element paramElement, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.base.item.ElementItem
 * JD-Core Version:    0.7.0.1
 */