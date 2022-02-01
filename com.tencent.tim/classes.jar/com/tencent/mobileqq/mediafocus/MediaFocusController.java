package com.tencent.mobileqq.mediafocus;

import ajaq;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Stack;

public class MediaFocusController
  extends BroadcastReceiver
{
  private a a;
  private final Stack<MediaFocusStackItem> j = new Stack();
  private Context mContext = BaseApplicationImpl.getContext();
  
  public MediaFocusController(a parama)
  {
    this.a = parama;
    parama = new IntentFilter();
    parama.addAction("tencent.mobileqq.mediafocus.request");
    parama.addAction("tencent.mobileqq.mediafocus.abandon");
    this.mContext.registerReceiver(this, parama);
    ajaq.registerModule();
  }
  
  private int N(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusController", 2, new Object[] { "handleAbandonMediaFocus size:", Integer.valueOf(this.j.size()), " ,from:", paramString1, " ,pname:", paramString2 });
    }
    try
    {
      try
      {
        gC(paramString1, paramString2);
        Qz(1);
        if (this.a != null) {
          this.a.apk();
        }
        return 0;
      }
      finally {}
      return 0;
    }
    catch (ConcurrentModificationException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MediaFocusController", 2, "handleAbandonMediaFocus FATAL EXCEPTION:", paramString1);
      }
    }
  }
  
  private void Qz(int paramInt)
  {
    MediaFocusStackItem localMediaFocusStackItem;
    if ((!this.j.empty()) && (this.j.peek() != null))
    {
      localMediaFocusStackItem = (MediaFocusStackItem)this.j.peek();
      if (!nk(localMediaFocusStackItem.getProcessName())) {
        break label64;
      }
      if (this.a != null) {
        this.a.dr(paramInt, localMediaFocusStackItem.getClientId());
      }
    }
    return;
    label64:
    ThreadManager.executeOnSubThread(new MediaFocusController.1(this, localMediaFocusStackItem, paramInt));
  }
  
  private int a(MediaFocusStackItem paramMediaFocusStackItem)
  {
    if (paramMediaFocusStackItem == null) {
      return 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusController", 2, new Object[] { "handleRequestMediaFocus size:", Integer.valueOf(this.j.size()), " ,from:", paramMediaFocusStackItem.getClientId() });
    }
    try
    {
      if ((!this.j.empty()) && (this.j.peek() != null) && (((MediaFocusStackItem)this.j.peek()).getClientId().equals(paramMediaFocusStackItem.getClientId())) && (((MediaFocusStackItem)this.j.peek()).getProcessName().equals(paramMediaFocusStackItem.getProcessName())))
      {
        if (((MediaFocusStackItem)this.j.peek()).Gf() == paramMediaFocusStackItem.Gf()) {
          return 0;
        }
        this.j.pop();
      }
      Qz(paramMediaFocusStackItem.Gf() * -1);
      gC(paramMediaFocusStackItem.getClientId(), paramMediaFocusStackItem.getProcessName());
      this.j.push(paramMediaFocusStackItem);
      return 0;
    }
    finally {}
  }
  
  private void gC(String paramString1, String paramString2)
  {
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext())
    {
      MediaFocusStackItem localMediaFocusStackItem = (MediaFocusStackItem)localIterator.next();
      if ((paramString2.equals(localMediaFocusStackItem.getProcessName())) && (paramString1.equals(localMediaFocusStackItem.getClientId())))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MediaFocusController", 2, new Object[] { "removeFocusStackEntry : ", localMediaFocusStackItem.toString() });
        }
        localIterator.remove();
      }
    }
  }
  
  private boolean nk(String paramString)
  {
    return BaseApplicationImpl.processName.equals(paramString);
  }
  
  public boolean be(String paramString1, String paramString2)
  {
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext())
    {
      MediaFocusStackItem localMediaFocusStackItem = (MediaFocusStackItem)localIterator.next();
      if ((paramString2.equals(localMediaFocusStackItem.getProcessName())) && (paramString1.equals(localMediaFocusStackItem.getClientId())))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MediaFocusController", 2, new Object[] { "checkMediaFocusItemExisted yes : ", localMediaFocusStackItem.toString() });
        }
        return true;
      }
    }
    return false;
  }
  
  public void destroy()
  {
    this.mContext.unregisterReceiver(this);
    this.j.clear();
    this.mContext = null;
    this.a = null;
  }
  
  public int dv(String paramString)
  {
    Intent localIntent = new Intent("tencent.mobileqq.mediafocus.abandon");
    localIntent.putExtra("cliendID", paramString);
    localIntent.putExtra("processName", BaseApplicationImpl.processName);
    if (this.mContext != null)
    {
      localIntent.setPackage(this.mContext.getPackageName());
      this.mContext.sendBroadcast(localIntent);
      return 0;
    }
    return 1;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.i("MediaFocusController", 2, "onReceive action:" + paramContext);
    }
    if (paramContext != null)
    {
      if (!paramContext.equals("tencent.mobileqq.mediafocus.request")) {
        break label105;
      }
      paramContext = (MediaFocusStackItem)paramIntent.getExtras().getParcelable("focusItem");
      i = a(paramContext);
      if ((nk(paramContext.getProcessName())) && (i == 0) && (this.a != null)) {
        this.a.dr(1, paramContext.getClientId());
      }
    }
    label105:
    while (!paramContext.equals("tencent.mobileqq.mediafocus.abandon"))
    {
      int i;
      return;
    }
    N(paramIntent.getStringExtra("cliendID"), paramIntent.getStringExtra("processName"));
  }
  
  public int r(int paramInt, String paramString)
  {
    if (this.mContext == null) {
      return 1;
    }
    Intent localIntent = new Intent("tencent.mobileqq.mediafocus.request");
    localIntent.setPackage(this.mContext.getPackageName());
    paramString = new MediaFocusStackItem(paramInt, System.currentTimeMillis(), paramString, BaseApplicationImpl.processName);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("focusItem", paramString);
    localIntent.putExtras(localBundle);
    this.mContext.sendBroadcast(localIntent);
    return 2;
  }
  
  public static abstract interface a
  {
    public abstract void apk();
    
    public abstract void dr(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mediafocus.MediaFocusController
 * JD-Core Version:    0.7.0.1
 */