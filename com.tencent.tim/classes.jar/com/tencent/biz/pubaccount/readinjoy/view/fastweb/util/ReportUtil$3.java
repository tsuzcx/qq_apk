package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import kxm;
import nns;
import org.json.JSONException;
import org.json.JSONObject;

public final class ReportUtil$3
  implements Runnable
{
  public ReportUtil$3(Context paramContext, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, long paramLong) {}
  
  public void run()
  {
    Context localContext = this.val$context;
    ArticleInfo localArticleInfo = this.d;
    int i = (int)this.d.mChannelID;
    Object localObject;
    if (this.c.FP()) {
      localObject = "2";
    }
    for (;;)
    {
      localObject = kxm.a(localContext, localArticleInfo, i, (String)localObject);
      try
      {
        ((JSONObject)localObject).put("sojourn_time", this.val$time);
        nns.c(this.d, "0X800A854", ((JSONObject)localObject).toString());
        return;
        localObject = "1";
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil.3
 * JD-Core Version:    0.7.0.1
 */