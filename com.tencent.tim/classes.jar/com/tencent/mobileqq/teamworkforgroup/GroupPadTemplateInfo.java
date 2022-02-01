package com.tencent.mobileqq.teamworkforgroup;

import com.tencent.mobileqq.persistence.Entity;

public class GroupPadTemplateInfo
  extends Entity
{
  public static final int TEMPLATE_TYPE_COLLECT = 3;
  public static final int TEMPLATE_TYPE_DOC = 1;
  public static final int TEMPLATE_TYPE_SHEET = 2;
  public int docOrSheetType = 2;
  public long groupCode;
  public String mobPrevUrl;
  public String mobThumbUrl;
  public int templateID;
  public String templateName;
  public int templateType;
  public String templateUrl;
  public String webPrevUrl;
  public String webThumUrl;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupPadTemplateInfo
 * JD-Core Version:    0.7.0.1
 */