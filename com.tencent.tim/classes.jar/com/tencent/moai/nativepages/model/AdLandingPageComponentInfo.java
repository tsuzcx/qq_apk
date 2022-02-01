package com.tencent.moai.nativepages.model;

public abstract class AdLandingPageComponentInfo
{
  public static final int ComponentLocalThumbType = 1000000001;
  public static final int HORIZONTAL_ALIGN_CENTER = 1;
  public static final int HORIZONTAL_ALIGN_LEFT = 0;
  public static final int HORIZONTAL_ALIGN_NON = -1;
  public static final int HORIZONTAL_ALIGN_RIGHT = 2;
  public static final int LAYOUT_HEIGHT_NON = 2147483647;
  public static final int LAYOUT_WIDTH_NON = 2147483647;
  public static final int VERTICAL_ALIGN_BOTTOM = 2;
  public static final int VERTICAL_ALIGN_CENTER = 1;
  public static final int VERTICAL_ALIGN_NON = -1;
  public static final int VERTICAL_ALIGN_TOP = 0;
  public int ComponentType;
  public String cId;
  public float height;
  public int horizontalAlignment;
  public boolean ifCondition;
  public boolean isCloseToWhite;
  public float layoutHeight = -2.0F;
  public float layoutWidth = -2.0F;
  public boolean noReport;
  public float paddingBottom;
  public float paddingLeft;
  public float paddingRight;
  public float paddingTop;
  public int subType;
  public int type;
  public int verticalAlignment;
  public float width;
  
  public String toString()
  {
    return "AdLandingPageComponentInfo{cId='" + this.cId + '\'' + ", ComponentType=" + this.ComponentType + ", paddingTop=" + this.paddingTop + ", paddingBottom=" + this.paddingBottom + ", paddingLeft=" + this.paddingLeft + ", paddingRight=" + this.paddingRight + ", layoutWidth=" + this.layoutWidth + ", layoutHeight=" + this.layoutHeight + ", isCloseToWhite=" + this.isCloseToWhite + ", subType=" + this.subType + ", type=" + this.type + ", width=" + this.width + ", height=" + this.height + ", verticalAlignment=" + this.verticalAlignment + ", horizontalAlignment=" + this.horizontalAlignment + ", ifCondition=" + this.ifCondition + ", noReport=" + this.noReport + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.model.AdLandingPageComponentInfo
 * JD-Core Version:    0.7.0.1
 */