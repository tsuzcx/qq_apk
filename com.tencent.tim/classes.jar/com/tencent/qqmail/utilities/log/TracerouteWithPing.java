package com.tencent.qqmail.utilities.log;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TracerouteWithPing
{
  private static final String EXCEED_PING = "exceed";
  private static final String FROM_PING = "From";
  public static final int MAXTTL = 40;
  private static final int MAX_TIMEOUT_NUM = 3;
  private static final String PARENTHESE_CLOSE_PING = ")";
  private static final String PARENTHESE_OPEN_PING = "(";
  private static final String PING = "PING";
  private static final String SMALL_FROM_PING = "from";
  private static final int TIMEOUT = 15000;
  private static final String TIME_PING = "time=";
  private static final String UNREACHABLE_PING = "100%";
  private static final String no_connectivity = "No connectivity";
  private static Runnable runnableTimeout;
  private String TAG = "TracerouteWithPing";
  private float elapsedTime;
  private int finishedTasks;
  private Handler handlerTimeout;
  private ImageView imageView;
  private String ipToPing;
  private TextView textView;
  private int timeoutNum = 0;
  private NetworkAnalyseGeneralCallback tracerouteCallback;
  private List<TracerouteContainer> traces;
  private int ttl;
  private String urlToPing;
  
  private void callFinish(boolean paramBoolean, TextView paramTextView, ImageView paramImageView)
  {
    if (this.traces != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < this.traces.size())
      {
        localArrayList.add(((TracerouteContainer)this.traces.get(i)).toString());
        i += 1;
      }
      this.tracerouteCallback.onFinish(paramBoolean, localArrayList, paramTextView, paramImageView);
    }
  }
  
  private String parseIpFromPing(String paramString)
  {
    if (paramString.contains("From"))
    {
      paramString = paramString.substring(paramString.indexOf("From") + 5);
      if (paramString.contains("(")) {
        return paramString.substring(paramString.indexOf("(") + 1, paramString.indexOf(")"));
      }
      paramString = paramString.substring(0, paramString.indexOf("\n"));
      if (paramString.contains(":")) {}
      for (int i = paramString.indexOf(":");; i = paramString.indexOf(" ")) {
        return paramString.substring(0, i);
      }
    }
    return paramString.substring(paramString.indexOf("(") + 1, paramString.indexOf(")"));
  }
  
  private String parseIpToPingFromPing(String paramString)
  {
    String str = "";
    if (paramString.contains("PING")) {
      str = paramString.substring(paramString.indexOf("(") + 1, paramString.indexOf(")"));
    }
    return str;
  }
  
  private String parseTimeFromPing(String paramString)
  {
    String str = "";
    if (paramString.contains("time="))
    {
      paramString = paramString.substring(paramString.indexOf("time=") + 5);
      str = paramString.substring(0, paramString.indexOf(" "));
    }
    return str;
  }
  
  public void executeTraceroute(String paramString, int paramInt, NetworkAnalyseGeneralCallback paramNetworkAnalyseGeneralCallback, TextView paramTextView, ImageView paramImageView)
  {
    this.textView = paramTextView;
    this.imageView = paramImageView;
    this.ttl = 1;
    this.finishedTasks = 0;
    this.timeoutNum = 0;
    this.urlToPing = paramString;
    this.traces = new ArrayList();
    this.tracerouteCallback = paramNetworkAnalyseGeneralCallback;
    new ExecutePingAsyncTask(paramInt).execute(new Void[0]);
  }
  
  class ExecutePingAsyncTask
    extends AsyncTask<Void, Void, String>
  {
    private int MAXTTL;
    private boolean isWholePingTaskFinished = false;
    
    public ExecutePingAsyncTask(int paramInt)
    {
      this.MAXTTL = paramInt;
    }
    
    @SuppressLint({"NewApi"})
    private String launchPing(String paramString)
      throws Exception
    {
      String str1 = String.format("ping -c 1 -t %d ", new Object[] { Integer.valueOf(TracerouteWithPing.this.ttl) });
      Log.d(TracerouteWithPing.this.TAG, "Will launch : " + str1 + paramString);
      long l = System.nanoTime();
      new TracerouteWithPing.TimeOutAsyncTask(TracerouteWithPing.this, this, TracerouteWithPing.this.ttl).execute(new Void[0]);
      Process localProcess = Runtime.getRuntime().exec(str1 + paramString);
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localProcess.getInputStream()));
      paramString = "";
      for (;;)
      {
        String str2 = localBufferedReader.readLine();
        if (str2 == null) {
          break;
        }
        str1 = paramString + str2 + "\n";
        if (!str2.contains("From"))
        {
          paramString = str1;
          if (!str2.contains("from")) {}
        }
        else
        {
          TracerouteWithPing.access$1302(TracerouteWithPing.this, (float)(System.nanoTime() - l) / 1000000.0F);
          paramString = str1;
        }
      }
      localProcess.destroy();
      if (paramString.equals("")) {
        throw new IllegalArgumentException();
      }
      if (TracerouteWithPing.this.ttl == 1) {
        TracerouteWithPing.access$1802(TracerouteWithPing.this, TracerouteWithPing.this.parseIpToPingFromPing(paramString));
      }
      return paramString;
    }
    
    private void onException(Exception paramException)
    {
      Log.e(TracerouteWithPing.this.TAG, paramException.toString());
      TracerouteWithPing.access$1008(TracerouteWithPing.this);
    }
    
    protected String doInBackground(Void... paramVarArgs)
    {
      if (QMNetworkUtils.isNetworkConnected(QMApplicationContext.sharedInstance()))
      {
        String str;
        try
        {
          if ((TracerouteWithPing.this.urlToPing == null) || (TracerouteWithPing.this.urlToPing.equals("")))
          {
            TracerouteWithPing.this.callFinish(false, TracerouteWithPing.this.textView, TracerouteWithPing.this.imageView);
            QMLog.log(5, TracerouteWithPing.this.TAG, "traceroute not set url.");
            return "";
          }
          str = launchPing(TracerouteWithPing.this.urlToPing);
          if ((str.contains("100%")) && (!str.contains("exceed")))
          {
            paramVarArgs = new TracerouteContainer(TracerouteWithPing.this.parseIpFromPing(str), TracerouteWithPing.this.elapsedTime, false, "ttl " + TracerouteWithPing.this.ttl + " exceed");
            TracerouteWithPing.this.traces.add(paramVarArgs);
            return str;
          }
        }
        catch (Exception paramVarArgs)
        {
          Threads.runOnMainThread(new TracerouteWithPing.ExecutePingAsyncTask.1(this, paramVarArgs));
          return "";
        }
        paramVarArgs = TracerouteWithPing.this.parseIpFromPing(str);
        if (TracerouteWithPing.this.ttl == this.MAXTTL) {}
        for (float f = Float.parseFloat(TracerouteWithPing.this.parseTimeFromPing(str));; f = TracerouteWithPing.this.elapsedTime)
        {
          paramVarArgs = new TracerouteContainer(paramVarArgs, f, true, "");
          break;
        }
      }
      return "No connectivity";
    }
    
    public boolean isWholePingTaskFinished()
    {
      return this.isWholePingTaskFinished;
    }
    
    protected void onPostExecute(String paramString)
    {
      try
      {
        if (!"".equals(paramString))
        {
          if (!"No connectivity".equals(paramString)) {
            break label101;
          }
          Log.d(TracerouteWithPing.this.TAG, "no network");
          this.isWholePingTaskFinished = true;
          TracerouteWithPing.this.traces.add(new TracerouteContainer("", 0.0F, false, "no available network"));
          TracerouteWithPing.this.callFinish(false, TracerouteWithPing.this.textView, TracerouteWithPing.this.imageView);
        }
        for (;;)
        {
          TracerouteWithPing.access$1008(TracerouteWithPing.this);
          super.onPostExecute(paramString);
          return;
          label101:
          if (TracerouteWithPing.this.traces.size() >= 1)
          {
            Log.d(TracerouteWithPing.this.TAG, "last trace ip:" + ((TracerouteContainer)TracerouteWithPing.this.traces.get(TracerouteWithPing.this.traces.size() - 1)).getIp() + ", ip to ping:" + TracerouteWithPing.this.ipToPing);
            if (!((TracerouteContainer)TracerouteWithPing.this.traces.get(TracerouteWithPing.this.traces.size() - 1)).getIp().equals(TracerouteWithPing.this.ipToPing)) {
              break;
            }
            this.isWholePingTaskFinished = true;
            Log.e(TracerouteWithPing.this.TAG, "find final ip. ttl:" + TracerouteWithPing.this.ttl + ", MAXTTL:" + this.MAXTTL + ".");
            TracerouteWithPing.this.callFinish(true, TracerouteWithPing.this.textView, TracerouteWithPing.this.imageView);
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Threads.runOnMainThread(new TracerouteWithPing.ExecutePingAsyncTask.2(this, localException));
          continue;
          if (TracerouteWithPing.this.ttl < this.MAXTTL)
          {
            TracerouteWithPing.access$1408(TracerouteWithPing.this);
            new ExecutePingAsyncTask(TracerouteWithPing.this, this.MAXTTL).execute(new Void[0]);
          }
          else
          {
            Log.e("mason", "exceed MAXTTL. stop ping.");
            this.isWholePingTaskFinished = true;
            TracerouteWithPing.this.callFinish(false, TracerouteWithPing.this.textView, TracerouteWithPing.this.imageView);
          }
        }
      }
    }
  }
  
  class TimeOutAsyncTask
    extends AsyncTask<Void, Void, Void>
  {
    private TracerouteWithPing.ExecutePingAsyncTask task;
    private int ttlTask;
    
    public TimeOutAsyncTask(TracerouteWithPing.ExecutePingAsyncTask paramExecutePingAsyncTask, int paramInt)
    {
      this.task = paramExecutePingAsyncTask;
      this.ttlTask = paramInt;
    }
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      return null;
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      if (TracerouteWithPing.this.handlerTimeout == null) {
        TracerouteWithPing.access$002(TracerouteWithPing.this, new Handler());
      }
      if (TracerouteWithPing.runnableTimeout != null) {
        TracerouteWithPing.this.handlerTimeout.removeCallbacks(TracerouteWithPing.runnableTimeout);
      }
      TracerouteWithPing.access$102(new TracerouteWithPing.TimeOutAsyncTask.1(this));
      TracerouteWithPing.this.handlerTimeout.postDelayed(TracerouteWithPing.runnableTimeout, 15000L);
      super.onPostExecute(paramVoid);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.TracerouteWithPing
 * JD-Core Version:    0.7.0.1
 */