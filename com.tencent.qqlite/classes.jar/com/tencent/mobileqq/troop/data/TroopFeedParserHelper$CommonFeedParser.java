package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.data.TroopFeedItem;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopFeedParserHelper$CommonFeedParser
  extends TroopFeedParserHelper.FeedParser
{
  public TroopFeedItem a(JSONObject paramJSONObject)
  {
    TroopFeedItem localTroopFeedItem = super.a(paramJSONObject);
    if (localTroopFeedItem == null) {
      return null;
    }
    localTroopFeedItem.type = 99;
    try
    {
      localTroopFeedItem.linkUrl = paramJSONObject.getString("open_url");
      if (paramJSONObject.has("app_id")) {
        localTroopFeedItem.ex_1 = ("" + paramJSONObject.getLong("app_id"));
      }
      paramJSONObject = paramJSONObject.getJSONObject("content");
      localTroopFeedItem.content = paramJSONObject.getString("body");
      localTroopFeedItem.title = paramJSONObject.getString("title");
      localTroopFeedItem.picPath = paramJSONObject.getString("pic_url");
      return localTroopFeedItem;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFeedParserHelper.CommonFeedParser
 * JD-Core Version:    0.7.0.1
 */