package com.tencent.ttpic.openapi.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CosmeticsDataTemplate
{
  public static final int PARAM_ATTACH = 3;
  public static final int PARAM_COLOR = 0;
  public static final int PARAM_ENUM = 2;
  public static final int PARAM_IMAGE = 1;
  public static final int PARAM_PALACE = 4;
  public ArrayList<CosmeticsParam> cosmetic_param = null;
  public final Map<String, ArrayList<CosmeticsParam>> eyebrowAttach = new HashMap();
  public String folder = null;
  public String respath = null;
  
  public static class CosmeticsParam
  {
    public int blend = 0;
    public int blend2 = -1;
    public int blue = 0;
    public int blue2 = 0;
    public String cosEnum = null;
    public ArrayList<Integer> cosIndex = null;
    public ArrayList<Integer> cosparam = null;
    public int enumAlpha = -1;
    public int enumAlpha2 = -1;
    public String enumId = null;
    public int enumRssWidth = 0;
    public int green = 0;
    public int green2 = 0;
    public int index = 0;
    public int paramtype = 0;
    public String portraitIcon = "";
    public int red = 0;
    public int red2 = 0;
    public String relicsIcon = "";
    public String relicsUrl = "";
    public String resname = null;
    public String resname2 = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.CosmeticsDataTemplate
 * JD-Core Version:    0.7.0.1
 */