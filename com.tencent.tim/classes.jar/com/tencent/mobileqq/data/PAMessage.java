package com.tencent.mobileqq.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PAMessage
  implements Serializable
{
  private static final long serialVersionUID = 243242567575L;
  public String grayTips;
  public ArrayList<Item> items;
  public long mMsgId;
  public String moreText;
  public String msg;
  public long sendTime;
  public int type;
  
  public static class Item
    implements Serializable
  {
    private static final long serialVersionUID = 3414344565L;
    public String a_actionData;
    public String a_rankListUrl;
    public String actionData;
    public String actionUrl;
    public String androidUrl;
    public long appId;
    public String cover;
    public String desc;
    public List<String> digestList;
    public long flag;
    public String i_actionData;
    public String i_rankListUrl;
    public String icon;
    public String iconsString;
    public String iosUrl;
    public String isAd;
    public int mVideoFlag;
    public String nativeJumpString;
    public boolean needLogin;
    public String nowTime;
    public String oneWeather;
    public String rankListDownload;
    public String rankListName;
    public String rankListSchema;
    public String senderEmail;
    public String senderName;
    public String source;
    public long time;
    public String title;
    public String twoWeather;
    public String type;
    public String url;
    public String weaArea;
    public String weaExposeUrl;
    public String weaJumpUrl;
    public String weaTemper;
    public String weather;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.PAMessage
 * JD-Core Version:    0.7.0.1
 */