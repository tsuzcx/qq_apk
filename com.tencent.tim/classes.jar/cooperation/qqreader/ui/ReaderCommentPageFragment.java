package cooperation.qqreader.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import aqzl;
import avoe;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebHistoryItem;
import com.tencent.smtt.sdk.WebView;

public class ReaderCommentPageFragment
  extends ReaderBaseFragment
{
  private static String cMl = "";
  private long mBookId;
  private String mFrom;
  private int mStyle = -1;
  
  private static String a(int paramInt, String paramString, long paramLong)
  {
    String str1 = "";
    if (paramInt > 0) {
      str1 = "" + "&chapterId=" + paramInt;
    }
    String str2 = str1;
    if (!TextUtils.isEmpty(paramString)) {
      str2 = str1 + "&commentId=" + paramString;
    }
    return avoe.av("qqreaderComment") + "&id=" + paramLong + str2;
  }
  
  private static String a(Bundle paramBundle, boolean paramBoolean, String paramString1, String paramString2)
  {
    int i = 0;
    String str2 = null;
    if (paramBundle != null)
    {
      str2 = paramBundle.getString("from");
      i = paramBundle.getInt("CompleteState");
    }
    String str1 = "";
    if (!TextUtils.isEmpty(str2)) {
      str1 = "" + "&_from=" + str2;
    }
    paramBundle = str1;
    if (!TextUtils.isEmpty(str2))
    {
      paramBundle = str1;
      if (str2.equals("readover")) {
        if (i == 1) {
          break label164;
        }
      }
    }
    label164:
    for (paramBundle = str1 + "&noEnd=1";; paramBundle = str1 + "&noEnd=0")
    {
      paramString2 = paramString2 + paramBundle;
      paramBundle = paramString1 + paramBundle;
      cMl = paramBundle;
      if (!paramBoolean) {
        break;
      }
      return paramString2;
    }
    return paramBundle;
  }
  
  private boolean aKO()
  {
    String str;
    if ((this.j != null) && (this.j.canGoBack())) {
      str = this.j.copyBackForwardList().getCurrentItem().getUrl();
    }
    return (!str.equals(cMl)) && (!str.contains("error.html"));
  }
  
  public static WebViewFragment b(Intent paramIntent)
  {
    ReaderCommentPageFragment localReaderCommentPageFragment = new ReaderCommentPageFragment();
    Bundle localBundle = new Bundle();
    paramIntent.putExtra("url", h(paramIntent));
    localBundle.putParcelable("intent", paramIntent);
    localReaderCommentPageFragment.setArguments(localBundle);
    return localReaderCommentPageFragment;
  }
  
  private void goBack()
  {
    if (this.j != null)
    {
      this.j.goBack();
      this.j.invalidate();
    }
  }
  
  private static String h(Intent paramIntent)
  {
    long l1 = 0L;
    boolean bool2 = false;
    String str = null;
    boolean bool1 = true;
    Bundle localBundle = paramIntent.getExtras();
    long l2;
    int i;
    if (localBundle != null)
    {
      l2 = localBundle.getLong("bookid");
      i = localBundle.getInt("chapterId", 0);
      paramIntent = localBundle.getString("commentId", "");
      bool2 = localBundle.getBoolean("night");
      bool1 = localBundle.getBoolean("comment");
      l1 = localBundle.getLong("recommend_bid");
    }
    for (;;)
    {
      str = avoe.av("qqreaderReadover") + "&recommend_bid=" + l1;
      paramIntent = a(i, paramIntent, l2);
      if (bool2)
      {
        str = str + "&night=1";
        paramIntent = paramIntent + "&night=1";
      }
      for (;;)
      {
        return a(localBundle, bool1, str, paramIntent);
      }
      i = 0;
      l2 = 0L;
      paramIntent = str;
    }
  }
  
  private void handleBack()
  {
    if (aKO())
    {
      goBack();
      return;
    }
    switch (this.mStyle)
    {
    }
    for (;;)
    {
      getActivity().finish();
      return;
      getActivity().overridePendingTransition(0, 2130772321);
      continue;
      getActivity().overridePendingTransition(0, 2130772319);
    }
  }
  
  public void d(Intent paramIntent, String paramString)
  {
    super.d(paramIntent, paramString);
    if ("readmenu".equals(this.mFrom))
    {
      this.a.leftView.setVisibility(8);
      this.a.rightViewText.setVisibility(0);
      this.a.rightViewText.setText("关闭");
      this.a.rightViewText.setTypeface(Typeface.DEFAULT_BOLD);
    }
    do
    {
      return;
      if (("readover".equals(this.mFrom)) || ("chaptercomment".equals(this.mFrom)))
      {
        this.a.leftView.setVisibility(0);
        this.a.rightViewText.setText("");
        this.a.rightViewText.setVisibility(8);
        return;
      }
    } while (!"chapterover".equals(this.mFrom));
    this.a.leftView.setVisibility(0);
    this.a.centerView.setText("章节评论");
    this.a.rightViewText.setVisibility(0);
    this.a.rightViewText.setText("书友交流");
    this.a.rightViewText.setTypeface(Typeface.DEFAULT_BOLD);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.a.leftView) {
      handleBack();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.a.rightViewText)
      {
        if ("chapterover".equals(this.mFrom))
        {
          if (this.j != null) {
            this.j.loadUrl("jsbridge://JSTopRightButton/handleCommentPageRightButton/500/" + this.mBookId);
          }
        }
        else {
          handleBack();
        }
      }
      else {
        super.onClick(paramView);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = this.intent.getParcelableExtra("defaultResultData");
    if ((paramBundle instanceof Intent)) {
      getActivity().setResult(0, (Intent)paramBundle);
    }
    paramBundle = this.intent.getExtras();
    if (paramBundle != null)
    {
      this.mStyle = paramBundle.getInt("style");
      this.mFrom = paramBundle.getString("from");
      this.mBookId = paramBundle.getLong("bookid");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    cMl = "";
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    super.onReceivedTitle(paramWebView, paramString);
    if ("chapterover".equals(this.mFrom)) {
      this.a.centerView.setText("章节评论");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.ui.ReaderCommentPageFragment
 * JD-Core Version:    0.7.0.1
 */