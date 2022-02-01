package com.tencent.qqmail.activity.networkanalyse;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.log.NetworkAnalyseGeneralCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.log.TracerouteWithPing;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class NetworkAnalyseActivity$2
  implements View.OnClickListener
{
  NetworkAnalyseActivity$2(NetworkAnalyseActivity paramNetworkAnalyseActivity) {}
  
  private void beginAnalyse()
  {
    checkDNS();
  }
  
  private void checkDNS()
  {
    networkType();
    View localView = NetworkAnalyseActivity.access$000(this.this$0, "dns检查", "");
    NetworkAnalyseActivity.access$100(this.this$0, localView);
    AtomicInteger localAtomicInteger = new AtomicInteger();
    localAtomicInteger.getAndSet(0);
    NetworkAnalyseActivity.2.1 local1 = new NetworkAnalyseActivity.2.1(this, localAtomicInteger);
    NetworkAnalyseHelper.debugDNS(this.this$0.DEBUG_TEST_ADDRESS[localAtomicInteger.intValue()], local1, (TextView)localView.findViewById(2131365755), (ImageView)localView.findViewById(2131362704));
  }
  
  private void doTraceroute(String paramString, NetworkAnalyseGeneralCallback paramNetworkAnalyseGeneralCallback, TextView paramTextView, ImageView paramImageView)
  {
    NetworkAnalyseActivity.access$1100(this.this$0).add("begin traceroute" + paramString);
    new TracerouteWithPing().executeTraceroute(paramString, 40, paramNetworkAnalyseGeneralCallback, paramTextView, paramImageView);
  }
  
  private void networkType()
  {
    String str = QMNetworkUtils.getNetworkTypeString();
    View localView = NetworkAnalyseActivity.access$000(this.this$0, "网络类型检查", str);
    NetworkAnalyseActivity.access$100(this.this$0, localView);
    NetworkAnalyseActivity.access$200(this.this$0, null, str, (ImageView)localView.findViewById(2131362704), true);
  }
  
  private void ping()
  {
    View localView = NetworkAnalyseActivity.access$000(this.this$0, "ping检查", "");
    NetworkAnalyseActivity.access$100(this.this$0, localView);
    AtomicInteger localAtomicInteger = new AtomicInteger();
    localAtomicInteger.getAndSet(0);
    NetworkAnalyseActivity.2.2 local2 = new NetworkAnalyseActivity.2.2(this, localAtomicInteger);
    QMLog.log(4, "NetworkAnalyse", "ping begin");
    NetworkAnalyseHelper.debugPing(this.this$0.DEBUG_TEST_ADDRESS[localAtomicInteger.intValue()], local2, (TextView)localView.findViewById(2131365755), (ImageView)localView.findViewById(2131362704));
  }
  
  private void proxySocket()
  {
    View localView = NetworkAnalyseActivity.access$000(this.this$0, "proxysocket检查", "");
    NetworkAnalyseActivity.access$100(this.this$0, localView);
    AtomicInteger localAtomicInteger = new AtomicInteger();
    localAtomicInteger.getAndSet(0);
    NetworkAnalyseActivity.2.3 local3 = new NetworkAnalyseActivity.2.3(this, localAtomicInteger);
    NetworkAnalyseHelper.debugSocket(this.this$0.DEBUG_PROXY_SOCKET[localAtomicInteger.intValue()].ip, this.this$0.DEBUG_PROXY_SOCKET[localAtomicInteger.intValue()].port, local3, (TextView)localView.findViewById(2131365755), (ImageView)localView.findViewById(2131362704));
  }
  
  private void sendRequest()
  {
    View localView = NetworkAnalyseActivity.access$000(this.this$0, "发送请求", "");
    NetworkAnalyseActivity.access$100(this.this$0, localView);
    NetworkAnalyseActivity.2.5 local5 = new NetworkAnalyseActivity.2.5(this);
    QMLog.log(4, "NetworkAnalyse", "sendrequest begin");
    NetworkAnalyseHelper.debugSendRequest(local5, (TextView)localView.findViewById(2131365755), (ImageView)localView.findViewById(2131362704));
  }
  
  private void trace()
  {
    View localView = NetworkAnalyseActivity.access$000(this.this$0, "traceroute检查", "");
    NetworkAnalyseActivity.access$100(this.this$0, localView);
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "i.mail.qq.com";
    arrayOfString[1] = "qumas.mail.qq.com";
    arrayOfString[2] = "rescdn.qqmail.com";
    arrayOfString[3] = "umasocksproxy.mail.qq.com";
    QMLog.log(4, "NetworkAnalyse", "traceroute begin");
    AtomicInteger localAtomicInteger = new AtomicInteger();
    localAtomicInteger.getAndSet(0);
    NetworkAnalyseActivity.2.4 local4 = new NetworkAnalyseActivity.2.4(this, localAtomicInteger, arrayOfString);
    doTraceroute(arrayOfString[localAtomicInteger.intValue()], local4, (TextView)localView.findViewById(2131365755), (ImageView)localView.findViewById(2131362704));
  }
  
  public void onClick(View paramView)
  {
    Threads.runOnMainThread(new NetworkAnalyseActivity.2.6(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.networkanalyse.NetworkAnalyseActivity.2
 * JD-Core Version:    0.7.0.1
 */