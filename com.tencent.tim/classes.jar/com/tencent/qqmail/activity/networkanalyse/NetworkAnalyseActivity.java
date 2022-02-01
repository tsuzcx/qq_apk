package com.tencent.qqmail.activity.networkanalyse;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.List;

public class NetworkAnalyseActivity
  extends BaseActivityEx
{
  public static final String TAG = "NetworkAnalyse";
  public static final String sendrequest_http = "http://i.mail.qq.com";
  public static final String sendrequest_https = "https://i.mail.qq.com";
  final SocketInfo[] DEBUG_PROXY_SOCKET = { new SocketInfo("103.7.30.59", 80), new SocketInfo("103.7.30.59", 8080), new SocketInfo("103.7.30.59", 443), new SocketInfo("113.108.20.85", 80), new SocketInfo("113.108.20.85", 8080), new SocketInfo("113.108.20.85", 443), new SocketInfo("163.177.65.221", 80), new SocketInfo("163.177.65.221", 8080), new SocketInfo("163.177.65.221", 443), new SocketInfo("211.136.236.77", 80), new SocketInfo("211.136.236.77", 8080), new SocketInfo("211.136.236.77", 443) };
  final String[] DEBUG_TEST_ADDRESS = { "i.mail.qq.com", "qumas.mail.qq.com", "rescdn.qqmail.com", "umasocksproxy.mail.qq.com" };
  private String dnsResult = "";
  private String pingResult = "";
  private String proxySocketResult = "";
  private String sendRequestResult = "";
  private QMTopBar topBar;
  private List<String> traces = new ArrayList();
  
  private void addItemViewToResults(View paramView)
  {
    Threads.runOnMainThread(new NetworkAnalyseActivity.3(this, paramView));
  }
  
  private View createItemView(String paramString1, String paramString2)
  {
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(this).inflate(2131559210, null);
    TextView localTextView1 = (TextView)localLinearLayout.findViewById(2131379769);
    TextView localTextView2 = (TextView)localLinearLayout.findViewById(2131365755);
    localTextView1.setText(paramString1);
    localTextView2.setText(paramString2);
    ((ImageView)localLinearLayout.findViewById(2131362704)).setImageResource(2130840942);
    return localLinearLayout;
  }
  
  private void initTopBar()
  {
    this.topBar.setButtonLeftBack();
    this.topBar.getButtonLeft().setOnClickListener(new NetworkAnalyseActivity.1(this));
    this.topBar.getButtonLeft().setVisibility(0);
    this.topBar.setButtonRightBlue("开始检测");
    NetworkAnalyseActivity.2 local2 = new NetworkAnalyseActivity.2(this);
    this.topBar.getButtonRight().setOnClickListener(local2);
    this.topBar.getButtonRight().setVisibility(0);
  }
  
  private void modifyViewDetailContent(TextView paramTextView, String paramString, ImageView paramImageView, boolean paramBoolean)
  {
    if (paramTextView != null) {
      paramTextView.setText(paramString);
    }
    if (paramImageView != null)
    {
      if (paramBoolean) {
        paramImageView.setImageResource(2130840882);
      }
    }
    else {
      return;
    }
    paramImageView.setImageResource(2130840974);
  }
  
  private void removeAllResultViews()
  {
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131377217);
    localLinearLayout.getChildCount();
    localLinearLayout.removeAllViewsInLayout();
  }
  
  public void initDataSource() {}
  
  public void initDom() {}
  
  public void initUI()
  {
    setContentView(2131558501);
    this.topBar = ((QMTopBar)findViewById(2131374722));
    initTopBar();
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onRelease() {}
  
  public void refreshData() {}
  
  public void render() {}
  
  class SocketInfo
  {
    String ip;
    int port;
    
    SocketInfo(String paramString, int paramInt)
    {
      this.ip = paramString;
      this.port = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.networkanalyse.NetworkAnalyseActivity
 * JD-Core Version:    0.7.0.1
 */