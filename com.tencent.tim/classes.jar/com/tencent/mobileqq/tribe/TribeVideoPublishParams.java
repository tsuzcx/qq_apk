package com.tencent.mobileqq.tribe;

import java.io.Serializable;

public class TribeVideoPublishParams
  implements Serializable
{
  public static final String BUNDLE_EXTRA_KEY = TribeVideoPublishParams.class.getName();
  public int beauty;
  public ChangeFace changeFace;
  public ComboInfo combo0Info;
  public Filter filter;
  public boolean hasFace;
  public boolean hasGraffiti;
  public boolean hasText;
  public boolean isSoundOn;
  public Music music;
  
  public static class ChangeFace
    implements Serializable
  {
    public String id;
    public String type;
  }
  
  public static class ComboInfo
    implements Serializable
  {
    public String id;
    public String name;
    public String type;
  }
  
  public static class Filter
    implements Serializable
  {
    public String id;
    public String name;
    public String typeId;
  }
  
  public static class Music
    implements Serializable
  {
    public String name;
    public String type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.TribeVideoPublishParams
 * JD-Core Version:    0.7.0.1
 */