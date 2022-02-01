package com.tencent.qqmail.utilities.ui;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqmail.BaseActivity;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class QMTipsActivity
  extends BaseActivity
{
  public static final String INTENT_EXTRA_CMD = "cmd";
  public static final String TAG = "QMTipsActivity";
  private static Map<Long, QMTipsActivityCallback> callbacks = new HashMap();
  private boolean autoCanceled;
  private LinearLayout containerLL;
  private ImageView icon;
  private QMTipsActivityCommand initCmd;
  private TextView label;
  private RelativeLayout progressBar;
  private IObserver qMTipsNotificationIObserver = new IObserver(new QMTipsActivity.1(this));
  private long tipsId;
  
  public static void addCallback(long paramLong, QMTipsActivityCallback paramQMTipsActivityCallback)
  {
    callbacks.put(Long.valueOf(paramLong), paramQMTipsActivityCallback);
  }
  
  private void doHandleCommand(QMTipsActivityCommand paramQMTipsActivityCommand)
  {
    QMTipsActivityCallback localQMTipsActivityCallback = getMappedCallback();
    if ("showInfo".equals(paramQMTipsActivityCommand.method)) {
      if ((localQMTipsActivityCallback != null) && (localQMTipsActivityCallback.viewShowView(this)))
      {
        this.containerLL.setVisibility(0);
        showInfo(paramQMTipsActivityCommand.msg, paramQMTipsActivityCommand.stayMills);
      }
    }
    do
    {
      return;
      hide();
      return;
      if ("showLoading".equals(paramQMTipsActivityCommand.method))
      {
        if ((localQMTipsActivityCallback != null) && (localQMTipsActivityCallback.viewShowView(this)))
        {
          this.containerLL.setVisibility(0);
          showLoading(paramQMTipsActivityCommand.msg);
          return;
        }
        hide();
        return;
      }
      if ("showSuccess".equals(paramQMTipsActivityCommand.method))
      {
        if ((localQMTipsActivityCallback != null) && (localQMTipsActivityCallback.viewShowView(this)))
        {
          this.containerLL.setVisibility(0);
          showSuccess(paramQMTipsActivityCommand.msg, paramQMTipsActivityCommand.stayMills);
          return;
        }
        hide();
        return;
      }
      if ("showError".equals(paramQMTipsActivityCommand.method))
      {
        if ((localQMTipsActivityCallback != null) && (localQMTipsActivityCallback.viewShowView(this)))
        {
          this.containerLL.setVisibility(0);
          showError(paramQMTipsActivityCommand.msg, paramQMTipsActivityCommand.stayMills);
          return;
        }
        hide();
        return;
      }
      if ("hide".equals(paramQMTipsActivityCommand.method))
      {
        hide();
        return;
      }
    } while (!"setAutoCanceled".equals(paramQMTipsActivityCommand.method));
    setAutoCanceled(paramQMTipsActivityCommand.autoCanceled);
  }
  
  private void handleCommand(QMTipsActivityCommand paramQMTipsActivityCommand)
  {
    if ((paramQMTipsActivityCommand == null) || (paramQMTipsActivityCommand.tipsId != this.tipsId)) {
      return;
    }
    doHandleCommand(paramQMTipsActivityCommand);
  }
  
  private void hide()
  {
    QMTipsActivityCallback localQMTipsActivityCallback = getMappedCallback();
    if (localQMTipsActivityCallback != null) {
      localQMTipsActivityCallback.onHide(this);
    }
    recycle();
    finish();
    overridePendingTransition(0, 0);
  }
  
  private void hideDelayed(long paramLong)
  {
    Threads.runOnMainThread(new QMTipsActivity.2(this), paramLong);
  }
  
  private void init()
  {
    QMTipsActivityCommand localQMTipsActivityCommand = (QMTipsActivityCommand)getIntent().getSerializableExtra("cmd");
    if (localQMTipsActivityCommand != null)
    {
      this.tipsId = localQMTipsActivityCommand.tipsId;
      this.autoCanceled = localQMTipsActivityCommand.autoCanceled;
    }
    for (this.initCmd = localQMTipsActivityCommand;; this.initCmd = new QMTipsActivityCommand())
    {
      initViews();
      registNotification();
      handleCommand(localQMTipsActivityCommand);
      return;
      this.tipsId = 0L;
      this.autoCanceled = true;
    }
  }
  
  private void initViews()
  {
    this.containerLL = ((LinearLayout)findViewById(2131374710));
    this.icon = ((ImageView)findViewById(2131374708));
    this.progressBar = ((RelativeLayout)findViewById(2131374711));
    QMLoading localQMLoading = new QMLoading(getApplicationContext(), QMUIKit.dpToPx(36), 1);
    this.progressBar.addView(localQMLoading);
    this.label = ((TextView)findViewById(2131374712));
  }
  
  private void recycle()
  {
    this.tipsId = 0L;
    unregistNotification();
    removeCallback(this.tipsId);
    this.icon = null;
    this.label = null;
    releaseProgressBar();
  }
  
  private void registNotification()
  {
    QMNotification.registNotification("QMTipsNotification", this.qMTipsNotificationIObserver);
  }
  
  private void releaseProgressBar()
  {
    this.progressBar.removeAllViews();
    this.progressBar = null;
  }
  
  public static void removeCallback(long paramLong)
  {
    callbacks.remove(Long.valueOf(paramLong));
  }
  
  private void showError(String paramString, long paramLong)
  {
    this.label.setText(paramString);
    this.icon.setVisibility(0);
    this.icon.setBackgroundResource(2130841016);
    this.progressBar.setVisibility(8);
    hideDelayed(paramLong);
  }
  
  private void showInfo(String paramString, long paramLong)
  {
    this.label.setText(paramString);
    this.icon.setVisibility(0);
    this.icon.setBackgroundResource(2130841017);
    this.progressBar.setVisibility(8);
    hideDelayed(paramLong);
  }
  
  private void showLoading(String paramString)
  {
    this.label.setText(paramString);
    this.icon.setVisibility(8);
    this.progressBar.setVisibility(0);
  }
  
  private void showSuccess(String paramString, long paramLong)
  {
    this.label.setText(paramString);
    this.icon.setVisibility(0);
    this.icon.setBackgroundResource(2130841015);
    this.progressBar.setVisibility(8);
    hideDelayed(paramLong);
  }
  
  private void unregistNotification()
  {
    QMNotification.unregistNotification("QMTipsNotification", this.qMTipsNotificationIObserver);
  }
  
  public QMTipsActivityCommand getInitCmd()
  {
    return this.initCmd;
  }
  
  public QMTipsActivityCallback getMappedCallback()
  {
    return (QMTipsActivityCallback)callbacks.get(Long.valueOf(this.tipsId));
  }
  
  public long getTipsId()
  {
    return this.tipsId;
  }
  
  public boolean isAutoCanceled()
  {
    return this.autoCanceled;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setWindowAnimations(0);
    paramBundle = new ColorDrawable(0);
    getWindow().setBackgroundDrawable(paramBundle);
    setContentView(2131561142);
    init();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.autoCanceled))
    {
      QMTipsActivityCallback localQMTipsActivityCallback = getMappedCallback();
      if (localQMTipsActivityCallback != null) {
        localQMTipsActivityCallback.onCanceled(this);
      }
      hide();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void setAutoCanceled(boolean paramBoolean)
  {
    this.autoCanceled = paramBoolean;
  }
  
  public static abstract interface QMTipsActivityCallback
  {
    public abstract void onCanceled(QMTipsActivity paramQMTipsActivity);
    
    public abstract void onHide(QMTipsActivity paramQMTipsActivity);
    
    public abstract boolean viewShowView(QMTipsActivity paramQMTipsActivity);
  }
  
  public static class QMTipsActivityCommand
    implements Serializable
  {
    private static final long serialVersionUID = 7715444758408292146L;
    public boolean autoCanceled;
    public String method;
    public String msg;
    public long stayMills;
    public long tipsId;
    
    public QMTipsActivityCommand()
    {
      this.tipsId = 0L;
      this.method = "";
      this.msg = "";
      this.stayMills = -1L;
      this.autoCanceled = true;
    }
    
    public QMTipsActivityCommand(long paramLong1, String paramString1, String paramString2, long paramLong2)
    {
      this.tipsId = paramLong1;
      this.method = paramString1;
      this.msg = paramString2;
      this.stayMills = paramLong2;
      this.autoCanceled = true;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QMTipsActivityCommand: {");
      localStringBuilder.append("tipsId: " + this.tipsId);
      localStringBuilder.append(", method: " + this.method);
      localStringBuilder.append(", msg: " + this.msg);
      localStringBuilder.append(", stayMills: " + this.stayMills);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMTipsActivity
 * JD-Core Version:    0.7.0.1
 */