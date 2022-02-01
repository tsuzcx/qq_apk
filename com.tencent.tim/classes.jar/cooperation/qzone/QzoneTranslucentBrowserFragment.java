package cooperation.qzone;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import avrs;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.smtt.sdk.WebView;

public class QzoneTranslucentBrowserFragment
  extends QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
{
  private boolean doz = true;
  
  private void E(RelativeLayout paramRelativeLayout)
  {
    if ((paramRelativeLayout != null) && (getHostActivity() != null))
    {
      ImageView localImageView = new ImageView(getHostActivity());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = dpToPx(11.5F);
      localLayoutParams.rightMargin = dpToPx(15.0F);
      localLayoutParams.addRule(11);
      paramRelativeLayout.addView(localImageView, localLayoutParams);
      localImageView.setImageDrawable(getResources().getDrawable(2130849454));
      localImageView.setOnClickListener(new avrs(this));
    }
  }
  
  public static QzoneTranslucentBrowserFragment a(Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("intent", paramIntent);
    paramIntent = new QzoneTranslucentBrowserFragment();
    paramIntent.setArguments(localBundle);
    return paramIntent;
  }
  
  private int dpToPx(float paramFloat)
  {
    return (int)(getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public void aBB()
  {
    super.aBB();
    if (getHostActivity() != null) {
      getHostActivity().setResult(-1);
    }
  }
  
  public int o(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Arcd != null) {
      this.jdField_a_of_type_Arcd.cYk = true;
    }
    int i = super.o(paramBundle);
    if (this.intent != null)
    {
      int j = this.intent.getIntExtra("CONTENT_BACKGROUND_COLOR", 0);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.setBackgroundColor(j);
      this.doz = this.intent.getBooleanExtra("show_close_btn", true);
    }
    return i;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if (this.doz) {
      E(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.QzoneTranslucentBrowserFragment
 * JD-Core Version:    0.7.0.1
 */