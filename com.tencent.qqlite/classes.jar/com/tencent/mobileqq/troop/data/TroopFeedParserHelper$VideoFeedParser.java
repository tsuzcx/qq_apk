package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.data.TroopFeedItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopFeedParserHelper$VideoFeedParser
  extends TroopFeedParserHelper.FeedParser
{
  public TroopFeedItem a(JSONObject paramJSONObject)
  {
    TroopFeedItem localTroopFeedItem = super.a(paramJSONObject);
    if (localTroopFeedItem == null) {
      return null;
    }
    localTroopFeedItem.type = 10;
    try
    {
      paramJSONObject = paramJSONObject.getJSONArray("content");
      if (paramJSONObject.length() > 0)
      {
        paramJSONObject = paramJSONObject.getJSONObject(0);
        localTroopFeedItem.linkUrl = paramJSONObject.getString("videourl");
        localTroopFeedItem.title = paramJSONObject.getString("videointro");
        localTroopFeedItem.picPath = paramJSONObject.getString("videoid");
      }
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
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFeedParserHelper.VideoFeedParser
 * JD-Core Version:    0.7.0.1
 */