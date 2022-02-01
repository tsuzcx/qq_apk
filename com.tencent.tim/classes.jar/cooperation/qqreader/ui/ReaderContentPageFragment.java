package cooperation.qqreader.ui;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import aqzl;
import araz;
import arbt;
import arcd.a;
import auru;
import avna;
import avoh;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import svi;
import tzd;

public class ReaderContentPageFragment
  extends ReaderBaseFragment
  implements Handler.Callback
{
  private String GY;
  private auru a;
  
  public ReaderContentPageFragment()
  {
    this.jdField_a_of_type_Auru = new auru(Looper.getMainLooper(), this);
  }
  
  public static WebViewFragment b(Intent paramIntent)
  {
    ReaderContentPageFragment localReaderContentPageFragment = new ReaderContentPageFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("intent", paramIntent);
    localReaderContentPageFragment.setArguments(localBundle);
    return localReaderContentPageFragment;
  }
  
  private void eBm()
  {
    svi localsvi = a();
    localsvi.bw(avoh.rK(localsvi.getShareUrl()));
  }
  
  private void goBack()
  {
    if (this.jdField_a_of_type_Aqzl.rightViewImg != null) {
      this.jdField_a_of_type_Aqzl.rightViewImg.setVisibility(8);
    }
    if (this.jdField_a_of_type_Aqzl.rightViewText != null) {
      this.jdField_a_of_type_Aqzl.rightViewText.setVisibility(8);
    }
    if (this.j != null)
    {
      this.j.goBack();
      this.j.invalidate();
    }
  }
  
  private void ov(List<String> paramList)
  {
    if (paramList == null) {}
    do
    {
      return;
      if (!paramList.contains("menuItem:openWithQQBrowser")) {
        paramList.add("menuItem:openWithQQBrowser");
      }
      if (!paramList.contains("menuItem:openWithSafari")) {
        paramList.add("menuItem:openWithSafari");
      }
      if (!paramList.contains("menuItem:favorite")) {
        paramList.add("menuItem:favorite");
      }
      if (!paramList.contains("menuItem:screenLongShotShare")) {
        paramList.add("menuItem:screenLongShotShare");
      }
    } while (paramList.contains("menuItem:exposeArticle"));
    paramList.add("menuItem:exposeArticle");
  }
  
  public void Qq()
  {
    arbt localarbt = (arbt)this.jdField_a_of_type_Araz.q(4);
    if (localarbt != null)
    {
      eBm();
      ov(localarbt.qo);
      localarbt.a(a(), this.jdField_a_of_type_Arcd$a.gK);
    }
  }
  
  public void a(ImageView paramImageView, TextView paramTextView, String paramString1, String paramString2, String paramString3)
  {
    int j = 0;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramTextView.setVisibility(0);
      paramTextView.setText(paramString2);
      paramTextView.setTypeface(Typeface.DEFAULT_BOLD);
      paramTextView.bringToFront();
      paramImageView.setImageResource(0);
      paramImageView.setBackgroundColor(0);
      paramImageView.setVisibility(8);
    }
    int i;
    if (paramString3 != null)
    {
      i = j;
      if (paramString3.length() <= 0) {}
    }
    try
    {
      i = Color.parseColor(paramString3);
      paramImageView.setBackgroundColor(i);
      if (paramString1 != null)
      {
        this.GY = paramString1.trim();
        return;
      }
      this.GY = null;
      return;
    }
    catch (Exception paramTextView)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  public void a(ImageView paramImageView, TextView paramTextView, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, View.OnClickListener paramOnClickListener)
  {
    if (paramInt == 0) {
      a(paramImageView, paramTextView, paramString1, paramString2, paramString3);
    }
    for (;;)
    {
      if (paramBoolean) {
        paramImageView.setVisibility(8);
      }
      return;
      paramTextView.setVisibility(8);
      paramImageView.setVisibility(0);
      switch (paramInt)
      {
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 10: 
      case 11: 
      default: 
        paramImageView.setVisibility(8);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramString2)) {
          paramImageView.setContentDescription(paramString2);
        }
        if (paramString1 == null) {
          break label193;
        }
        this.GY = paramString1.trim();
        break;
        paramImageView.setImageResource(2130844670);
        continue;
        paramImageView.setImageResource(2130844669);
        continue;
        paramImageView.setImageResource(2130840663);
        continue;
        paramImageView.setImageResource(2130847821);
        continue;
        paramImageView.setImageResource(2130847831);
        continue;
        paramImageView.setImageResource(2130838990);
      }
      label193:
      this.GY = null;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener, tzd paramtzd)
  {
    if ((this.jdField_a_of_type_Aqzl != null) && (this.jdField_a_of_type_Aqzl.rightViewImg != null) && (this.jdField_a_of_type_Aqzl.rightViewText != null)) {
      a(this.jdField_a_of_type_Aqzl.rightViewImg, this.jdField_a_of_type_Aqzl.rightViewText, paramString1, paramString2, paramString3, paramBoolean, paramInt1, paramOnClickListener);
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    return false;
  }
  
  public int b(Bundle paramBundle)
  {
    int i = super.b(paramBundle);
    paramBundle = getActivity();
    if ((paramBundle instanceof ReaderBaseWebActivity))
    {
      paramBundle = ((ReaderBaseWebActivity)paramBundle).a(this.j);
      if ((paramBundle != null) && (this.jdField_a_of_type_Aqzl.rightViewText != null)) {
        paramBundle.setRightButton(this.jdField_a_of_type_Aqzl.rightViewText);
      }
    }
    return i;
  }
  
  public void biT() {}
  
  public boolean bw(String paramString)
  {
    return false;
  }
  
  public void eBl()
  {
    if (this.dnC) {
      if (this.j != null) {
        this.j.stopLoading();
      }
    }
    do
    {
      return;
      if ((this.j != null) && (this.j.canGoBack()))
      {
        goBack();
        return;
      }
    } while (WJ());
    super.getActivity().finish();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return handleMessageImp(paramMessage);
  }
  
  public void initWebView()
  {
    setHandler(this.jdField_a_of_type_Auru);
    super.initWebView();
    if (this.intent != null)
    {
      Bundle localBundle = this.intent.getBundleExtra("theme");
      if (localBundle != null) {
        this.j.setBackgroundColor(localBundle.getInt("readerBgColor", -1));
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView == this.jdField_a_of_type_Aqzl.rightViewImg) || (paramView == this.jdField_a_of_type_Aqzl.rightViewText)) {
      if ((this.j != null) && (this.GY != null)) {
        this.j.callJs(this.GY, new String[] { "" });
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.jdField_a_of_type_Aqzl.leftView) {
        eBl();
      } else {
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
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Auru.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.ui.ReaderContentPageFragment
 * JD-Core Version:    0.7.0.1
 */