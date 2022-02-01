package cooperation.qqreader.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import avml;
import avoc;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;

public class ReaderSplashPageFragment
  extends WebViewFragment
{
  private avml b;
  
  private ViewGroup a(Context paramContext)
  {
    paramContext = new FrameLayout(paramContext);
    paramContext.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    return paramContext;
  }
  
  public static ReaderSplashPageFragment a(Intent paramIntent)
  {
    ReaderSplashPageFragment localReaderSplashPageFragment = new ReaderSplashPageFragment();
    paramIntent.putExtra("url", "https://im.qq.com");
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("intent", paramIntent);
    localReaderSplashPageFragment.setArguments(localBundle);
    return localReaderSplashPageFragment;
  }
  
  public void biT()
  {
    getActivity().finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    avoc.d("ReaderSplashPageFragment", "onCreate");
    paramBundle = getActivity();
    this.b = new avml(paramBundle);
    Intent localIntent = getIntent();
    if ((localIntent != null) && (localIntent.getExtras() != null))
    {
      this.b.ec(localIntent.getExtras());
      this.b.i(a(paramBundle));
      this.b.onCreate();
      return;
    }
    paramBundle.finish();
    avoc.e("ReaderSplashPageFragment", "onCreate: intent 数据为空，退出splash");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.b != null) {
      paramLayoutInflater = this.b.j();
    }
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    avoc.d("ReaderSplashPageFragment", "onDestroy");
    if (this.b != null) {
      this.b.onDestroy();
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.ui.ReaderSplashPageFragment
 * JD-Core Version:    0.7.0.1
 */