package com.tencent.ad.tangram.protocol;

import android.support.annotation.Keep;

@Keep
public final class landing_page_collect_data
{
  public static final int ACTION_ARK_LOAD_START = 61;
  public static final int ACTION_ARK_LOAD_SUCCESS = 62;
  public static final int ACTION_CLICK_CGI_REDIRECT_FAIL = 2;
  public static final int ACTION_CLICK_CGI_REDIRECT_SUCCESS = 1;
  public static final int ACTION_CLOSE_POPSHEET = 49;
  public static final int ACTION_FOREIGN_APP_STORE_FAILED = 38;
  public static final int ACTION_FOREIGN_IOS_DOWNLOAD_WINDOW_CLICK_ABANDON = 41;
  public static final int ACTION_FOREIGN_IOS_DOWNLOAD_WINDOW_CLICK_ALLOW = 40;
  public static final int ACTION_FOREIGN_IOS_DOWNLOAD_WINDOW_IMPRESSION = 39;
  public static final int ACTION_INFOFLOW_VIEW_NUM = 47;
  public static final int ACTION_LANDINGPAGE_APP_DATA_FAILED = 37;
  public static final int ACTION_LANDINGPAGE_APP_DATA_SUCCESS = 36;
  public static final int ACTION_LANDINGPAGE_APP_DOWNLOAD_CLICK = 33;
  public static final int ACTION_LANDINGPAGE_BROWSING_PERCENT = 11;
  public static final int ACTION_LANDINGPAGE_BROWSING_TIME = 10;
  public static final int ACTION_LANDINGPAGE_DWELL_TIME = 42;
  public static final int ACTION_LANDINGPAGE_FORMS_COMMIT_FAILED = 23;
  public static final int ACTION_LANDINGPAGE_FORMS_COMMIT_SUCCESS = 22;
  public static final int ACTION_LANDINGPAGE_LANDING_USER_EXIT = 6;
  public static final int ACTION_LANDINGPAGE_LANDING_USER_RETURN = 5;
  public static final int ACTION_LANDINGPAGE_LOAD_FAIL = 4;
  public static final int ACTION_LANDINGPAGE_LOAD_SUCCESS = 3;
  public static final int ACTION_LANDINGPAGE_MORE_CONTENT_CLICK = 35;
  public static final int ACTION_LANDINGPAGE_PRODUCT_CLICK = 13;
  public static final int ACTION_LANDINGPAGE_PRODUCT_DEEPLINK = 14;
  public static final int ACTION_LANDINGPAGE_PRODUCT_DELAY_DEEPLINK = 16;
  public static final int ACTION_LANDINGPAGE_PRODUCT_DOWNLOAD = 15;
  public static final int ACTION_LANDINGPAGE_PRODUCT_VIEW = 12;
  public static final int ACTION_LANDINGPAGE_RECOMMEND_CLICK = 18;
  public static final int ACTION_LANDINGPAGE_RECOMMEND_DEEPLINK = 19;
  public static final int ACTION_LANDINGPAGE_RECOMMEND_DELAY_DEEPLINK = 21;
  public static final int ACTION_LANDINGPAGE_RECOMMEND_DOWNLOAD = 20;
  public static final int ACTION_LANDINGPAGE_RECOMMEND_VIEW = 17;
  public static final int ACTION_LANDINGPAGE_USER_CLICK = 8;
  public static final int ACTION_LANDINGPAGE_USER_EXIT = 7;
  public static final int ACTION_LANDINGPAGE_VIEW = 9;
  public static final int ACTION_LANDINGPAGE_ZHEDIE_BROWSING_PERCENT = 34;
  public static final int ACTION_MINI_PROGRAM_OPEN_FAILED = 52;
  public static final int ACTION_MINI_PROGRAM_OPEN_SUCCESS = 51;
  public static final int ACTION_NEWS_LOAD_IMAGE = 25;
  public static final int ACTION_NEWS_LOAD_IOS_APPSTORE = 29;
  public static final int ACTION_NEWS_LOAD_LANDINGPAGE = 28;
  public static final int ACTION_NEWS_LOAD_VIDEO = 26;
  public static final int ACTION_NEWS_PLAY_VIDEO = 27;
  public static final int ACTION_NEWS_REPORT_CLICK_CGI = 30;
  public static final int ACTION_NEWS_REPORT_CONV_CGI = 32;
  public static final int ACTION_NEWS_REPORT_IMPRESSION_CGI = 31;
  public static final int ACTION_SUBMIT_POPSHEET = 48;
  public static final int ACTION_SUBMIT_POPSHEET_FAILED = 50;
  public static final int ACTION_XJ_LANDINGPAGE_BOTTOM_IMAGE = 71;
  public static final int ACTION_XJ_LANDINGPAGE_BOTTOM_IMAGE_BUTTON = 73;
  public static final int ACTION_XJ_LANDINGPAGE_BROWSING_PERCENT = 44;
  public static final int ACTION_XJ_LANDINGPAGE_BROWSING_TIME = 45;
  public static final int ACTION_XJ_LANDINGPAGE_CANVAS_JSON_FETCH_START = 74;
  public static final int ACTION_XJ_LANDINGPAGE_CANVAS_JSON_FETCH_SUCC = 75;
  public static final int ACTION_XJ_LANDINGPAGE_CANVAS_JSON_READ_CACHE_START = 76;
  public static final int ACTION_XJ_LANDINGPAGE_CANVAS_JSON_READ_CACHE_SUCC = 77;
  public static final int ACTION_XJ_LANDINGPAGE_FIRSTSCREEN = 54;
  public static final int ACTION_XJ_LANDINGPAGE_FORM_AUTO_FILL_SUCCESS = 58;
  public static final int ACTION_XJ_LANDINGPAGE_INITEND = 53;
  public static final int ACTION_XJ_LANDINGPAGE_LIVE_VIEW = 70;
  public static final int ACTION_XJ_LANDINGPAGE_LIVE_VIEW_BUTTON = 72;
  public static final int ACTION_XJ_LANDINGPAGE_ONLOAD = 55;
  public static final int ACTION_XJ_LANDINGPAGE_OPPO_MARKET_VIEW_CONTENT = 63;
  public static final int ACTION_XJ_LANDINGPAGE_OPPO_YYB_VIEW_CONTENT = 64;
  public static final int ACTION_XJ_LANDINGPAGE_PAGE_LOAD_TIME = 60;
  public static final int ACTION_XJ_LANDINGPAGE_QUICAPP_FAILED = 57;
  public static final int ACTION_XJ_LANDINGPAGE_QUICAPP_SUCCESS = 56;
  public static final int ACTION_XJ_LANDINGPAGE_USER_CLICK = 43;
  public static final int ACTION_XJ_LANDINGPAGE_USER_EXIT = 46;
  public static final int ACTION_XJ_LANDINGPAGE_VIEW_CONTENT = 69;
  public static final int ACTION_XJ_LANDINGPAGE_VIVO_JUMP_MARKET = 67;
  public static final int ACTION_XJ_LANDINGPAGE_VIVO_JUMP_YYB = 68;
  public static final int ACTION_XJ_LANDINGPAGE_VIVO_MARKET_VIEW_CONTENT = 65;
  public static final int ACTION_XJ_LANDINGPAGE_VIVO_YYB_VIEW_CONTENT = 66;
  public static final int ACTION_XJ_LANDINGPAGE_WEBVIEW_INIT_TIME = 59;
  
  public static final class LandingPageCollectData
  {
    public int avail_height = 0;
    public int browsing_percent = 0;
    public int browsing_percent_end = 0;
    public int browsing_percent_start = 0;
    public int browsing_time = 0;
    public int browsing_time_on_area = 0;
    public int click_offset_x = 0;
    public int click_offset_y = 0;
    public int client_height = 0;
    public int landing_error_code = 0;
    public int landing_page_action_type = 0;
    public long latency_ms = 0L;
    public String schemeid;
    public String screen_height;
    public String screen_width;
    public int scroll_top = 0;
    public SubordinateProductInfo subordinate_product_info = new SubordinateProductInfo();
    public int xj_page_id = 0;
    
    public int getAvail_height()
    {
      return this.avail_height;
    }
    
    public int getBrowsing_percent()
    {
      return this.browsing_percent;
    }
    
    public int getBrowsing_percent_end()
    {
      return this.browsing_percent_end;
    }
    
    public int getBrowsing_percent_start()
    {
      return this.browsing_percent_start;
    }
    
    public int getBrowsing_time()
    {
      return this.browsing_time;
    }
    
    public int getBrowsing_time_on_area()
    {
      return this.browsing_time_on_area;
    }
    
    public int getClick_offset_x()
    {
      return this.click_offset_x;
    }
    
    public int getClick_offset_y()
    {
      return this.click_offset_y;
    }
    
    public int getClient_height()
    {
      return this.client_height;
    }
    
    public String getId()
    {
      return this.subordinate_product_info.id;
    }
    
    public int getLanding_error_code()
    {
      return this.landing_error_code;
    }
    
    public int getLanding_page_action_type()
    {
      return this.landing_page_action_type;
    }
    
    public long getLatency_ms()
    {
      return this.latency_ms;
    }
    
    public String getPkg_md5()
    {
      return this.subordinate_product_info.pkg_md5;
    }
    
    public String getPkg_url()
    {
      return this.subordinate_product_info.pkg_url;
    }
    
    public String getReal_id()
    {
      return this.subordinate_product_info.real_id;
    }
    
    public String getSchemeid()
    {
      return this.schemeid;
    }
    
    public String getScreen_height()
    {
      return this.screen_height;
    }
    
    public String getScreen_width()
    {
      return this.screen_width;
    }
    
    public int getScroll_top()
    {
      return this.scroll_top;
    }
    
    public SubordinateProductInfo getSubordinate_product_info()
    {
      return this.subordinate_product_info;
    }
    
    public int getXj_page_id()
    {
      return this.xj_page_id;
    }
    
    public void setAvail_height(int paramInt)
    {
      this.avail_height = paramInt;
    }
    
    public void setBrowsing_percent(int paramInt)
    {
      this.browsing_percent = paramInt;
    }
    
    public void setBrowsing_percent_end(int paramInt)
    {
      this.browsing_percent_end = paramInt;
    }
    
    public void setBrowsing_percent_start(int paramInt)
    {
      this.browsing_percent_start = paramInt;
    }
    
    public void setBrowsing_time(int paramInt)
    {
      this.browsing_time = paramInt;
    }
    
    public void setBrowsing_time_on_area(int paramInt)
    {
      this.browsing_time_on_area = paramInt;
    }
    
    public void setClick_offset_x(int paramInt)
    {
      this.click_offset_x = paramInt;
    }
    
    public void setClick_offset_y(int paramInt)
    {
      this.click_offset_y = paramInt;
    }
    
    public void setClient_height(int paramInt)
    {
      this.client_height = paramInt;
    }
    
    public void setId(String paramString)
    {
      this.subordinate_product_info.id = paramString;
    }
    
    public void setLanding_error_code(int paramInt)
    {
      this.landing_error_code = paramInt;
    }
    
    public void setLanding_page_action_type(int paramInt)
    {
      this.landing_page_action_type = paramInt;
    }
    
    public void setLatency_ms(long paramLong)
    {
      this.latency_ms = paramLong;
    }
    
    public void setPkg_md5(String paramString)
    {
      this.subordinate_product_info.pkg_md5 = paramString;
    }
    
    public void setPkg_url(String paramString)
    {
      this.subordinate_product_info.pkg_url = paramString;
    }
    
    public void setReal_id(String paramString)
    {
      this.subordinate_product_info.real_id = paramString;
    }
    
    public void setSchemeid(String paramString)
    {
      this.schemeid = paramString;
    }
    
    public void setScreen_height(String paramString)
    {
      this.screen_height = paramString;
    }
    
    public void setScreen_width(String paramString)
    {
      this.screen_width = paramString;
    }
    
    public void setScroll_top(int paramInt)
    {
      this.scroll_top = paramInt;
    }
    
    public void setSubordinate_product_info(SubordinateProductInfo paramSubordinateProductInfo)
    {
      this.subordinate_product_info = paramSubordinateProductInfo;
    }
    
    public void setXj_page_id(int paramInt)
    {
      this.xj_page_id = paramInt;
    }
    
    public static final class SubordinateProductInfo
    {
      public String id;
      public String pkg_md5;
      public String pkg_url;
      public String real_id;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.protocol.landing_page_collect_data
 * JD-Core Version:    0.7.0.1
 */