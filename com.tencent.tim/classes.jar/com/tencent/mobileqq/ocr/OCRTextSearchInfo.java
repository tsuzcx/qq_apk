package com.tencent.mobileqq.ocr;

import com.tencent.mobileqq.ocr.ui.SearchResultViewPagerAdapter.a;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x6ff.subcmd0x533.HttpMapItem;

public class OCRTextSearchInfo
{
  public static SougouSearchInfo a(List<subcmd0x533.HttpMapItem> paramList)
  {
    SougouSearchInfo localSougouSearchInfo = new SougouSearchInfo();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      subcmd0x533.HttpMapItem localHttpMapItem = (subcmd0x533.HttpMapItem)paramList.next();
      String str1 = localHttpMapItem.string_key.get();
      String str2 = localHttpMapItem.string_value.get();
      if (str1.equalsIgnoreCase("title"))
      {
        localSougouSearchInfo.title = str2;
        localSougouSearchInfo.titleKeyWords = localHttpMapItem.rpt_string_key_list.get();
      }
      else if (str1.equalsIgnoreCase("summary"))
      {
        localSougouSearchInfo.abstractStr = str2;
        localSougouSearchInfo.abstractStrKeyWords = localHttpMapItem.rpt_string_key_list.get();
      }
      else if (str1.equalsIgnoreCase("url"))
      {
        localSougouSearchInfo.jumpURL = str2;
      }
      else if (str1.equalsIgnoreCase("key"))
      {
        localSougouSearchInfo.keyWord = str2;
      }
      else if (str1.equalsIgnoreCase("category"))
      {
        localSougouSearchInfo.sourceFrom = str2;
      }
      else if (str1.equalsIgnoreCase("stype"))
      {
        localSougouSearchInfo.stype = str2;
      }
      else if (str1.equalsIgnoreCase("summaryPic"))
      {
        localSougouSearchInfo.summaryPic = str2;
      }
    }
    return localSougouSearchInfo;
  }
  
  public static class SougouSearchInfo
    implements Serializable
  {
    public String abstractStr = "";
    public List<String> abstractStrKeyWords;
    public String jumpURL = "";
    public String keyWord = "";
    public String sourceFrom = "";
    public String stype = "";
    public String summaryPic = "";
    public String title = "";
    public List<String> titleKeyWords;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("\nSougouSearchInfo");
      localStringBuilder.append("\n |-").append("title:").append(this.title);
      localStringBuilder.append("\n |-").append("jumpURL:").append(this.jumpURL);
      localStringBuilder.append("\n |-").append("summaryPic:").append(this.summaryPic);
      localStringBuilder.append("\n |-").append("titleKeyWords:").append(this.titleKeyWords);
      localStringBuilder.append("\n |-").append("abstractStrKeyWords:").append(this.abstractStrKeyWords);
      return localStringBuilder.toString();
    }
  }
  
  public static class a
  {
    public String bTQ;
    public List<OCRTextSearchInfo.b> cB = new ArrayList();
    public String groupName;
    public int groupType;
    public String moreUrl;
  }
  
  public static class b
  {
    public Object data;
  }
  
  public static class c
  {
    public List<SearchResultViewPagerAdapter.a> Eg;
    public boolean hasMore;
    public List<OCRTextSearchInfo.a> qT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRTextSearchInfo
 * JD-Core Version:    0.7.0.1
 */