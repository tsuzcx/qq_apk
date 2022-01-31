package com.tencent.biz.widgets;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.webkit.URLUtil;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.text.QQText;

public class PubAccountQQText
  extends QQText
{
  public String a;
  public String b;
  
  public PubAccountQQText(CharSequence paramCharSequence, int paramInt)
  {
    super(paramCharSequence, paramInt);
  }
  
  protected void a(View paramView, String paramString)
  {
    Context localContext = paramView.getContext();
    Intent localIntent = new Intent(localContext, PublicAccountBrowser.class);
    localIntent.putExtra("uin", this.a);
    paramView = null;
    int i = paramString.lastIndexOf("#");
    if (i > 0) {
      paramView = paramString.substring(i);
    }
    String str = URLUtil.guessUrl(paramString);
    if (paramView != null) {}
    for (paramView = str + paramView;; paramView = str)
    {
      localIntent.putExtra("url", paramView);
      localIntent.putExtra("assignBackText", localContext.getResources().getString(2131561692));
      localIntent.putExtra("puin", this.b);
      localIntent.putExtra("key_isReadModeEnabled", true);
      PublicAccountUtil.a(localIntent, paramString);
      localContext.startActivity(localIntent);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.widgets.PubAccountQQText
 * JD-Core Version:    0.7.0.1
 */