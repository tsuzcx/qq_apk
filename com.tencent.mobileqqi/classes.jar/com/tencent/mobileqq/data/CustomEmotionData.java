package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class CustomEmotionData
  extends Entity
{
  public String eId;
  @unique
  public int emoId;
  public String emoPath;
  public boolean isMarkFace = false;
  public String uin;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.CustomEmotionData
 * JD-Core Version:    0.7.0.1
 */