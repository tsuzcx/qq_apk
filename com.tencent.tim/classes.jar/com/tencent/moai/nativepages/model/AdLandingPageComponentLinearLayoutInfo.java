package com.tencent.moai.nativepages.model;

import java.util.ArrayList;
import java.util.List;

public class AdLandingPageComponentLinearLayoutInfo
  extends AdLandingPageComponentInfo
{
  public static final int HorizontalLinearLayout = 1;
  public static final int VerticalLinearLayout = 0;
  public int bgColor;
  public List<AdLandingPageComponentInfo> componentList = new ArrayList();
  public int linearLayoutOrientation = 0;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.model.AdLandingPageComponentLinearLayoutInfo
 * JD-Core Version:    0.7.0.1
 */