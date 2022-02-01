package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import java.net.URLEncoder;
import kxm;
import nlu.a;

public class WebFastLikeDislikeCreator$ViewHolder$1
  implements Runnable
{
  public WebFastLikeDislikeCreator$ViewHolder$1(nlu.a parama, ArticleInfo paramArticleInfo) {}
  
  public void run()
  {
    String str3 = "https://post.mp.qq.com/jubao/index?";
    String str1 = str3;
    if (this.d != null) {}
    try
    {
      str1 = "https://post.mp.qq.com/jubao/index?" + "articleId=" + this.d.mArticleID + "&puin=" + this.d.mSubscribeID + "&url=" + URLEncoder.encode(this.d.mArticleContentUrl, "utf-8") + "&key=" + this.d.innerUniqueID + "&type=7&_wv=3";
      kxm.aJ(this.b.itemView.getContext(), str1);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        String str2 = str3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastLikeDislikeCreator.ViewHolder.1
 * JD-Core Version:    0.7.0.1
 */