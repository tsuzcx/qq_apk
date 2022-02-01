package com.tencent.biz.pubaccount.readinjoy.video;

import accg;
import acci;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import jzu;
import kcp;
import kcr;
import mwo;

public class VideoFeedsAppInterface
  extends AppInterface
{
  public static String PROCESS_NAME = "com.tencent.mobileqq:tool";
  private mwo a;
  private List<acci> bgObservers = new Vector();
  private List<acci> defaultObservers = new Vector();
  private HashMap<Integer, accg> el = new HashMap(20);
  private List<acci> uiObservers = new Vector();
  
  public VideoFeedsAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
  }
  
  public void addObserver(acci paramacci)
  {
    addObserver(paramacci, false);
  }
  
  public void addObserver(acci paramacci, boolean paramBoolean)
  {
    if (paramacci == null) {
      return;
    }
    if (paramBoolean) {
      synchronized (this.bgObservers)
      {
        if (!this.bgObservers.contains(paramacci)) {
          this.bgObservers.add(paramacci);
        }
        return;
      }
    }
    synchronized (this.uiObservers)
    {
      if (!this.uiObservers.contains(paramacci)) {
        this.uiObservers.add(paramacci);
      }
      return;
    }
  }
  
  public void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.a.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.getAppId();
  }
  
  public accg getBusinessHandler(int paramInt)
  {
    accg localaccg = (accg)this.el.get(Integer.valueOf(paramInt));
    if (localaccg == null) {}
    for (;;)
    {
      synchronized (this.el)
      {
        localaccg = (accg)this.el.get(Integer.valueOf(paramInt));
        if (localaccg == null) {
          break label113;
        }
        return localaccg;
        if (localaccg != null) {
          this.el.put(Integer.valueOf(paramInt), localaccg);
        }
        return localaccg;
      }
      Object localObject2 = new kcr(this);
      continue;
      localObject2 = new kcp(this);
      continue;
      localObject2 = new jzu(this);
      continue;
      return localObject2;
      label113:
      switch (paramInt)
      {
      }
    }
  }
  
  public List<acci> getBusinessObserver(int paramInt)
  {
    if (paramInt == 1) {
      return this.uiObservers;
    }
    if (paramInt == 2) {
      return this.bgObservers;
    }
    if (paramInt == 0) {
      return this.defaultObservers;
    }
    return this.defaultObservers;
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    return null;
  }
  
  public String getModuleId()
  {
    return "module_videofeeds";
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = new mwo(this);
  }
  
  public void removeObserver(acci paramacci)
  {
    synchronized (this.uiObservers)
    {
      this.uiObservers.remove(paramacci);
      synchronized (this.bgObservers)
      {
        this.bgObservers.remove(paramacci);
      }
    }
    synchronized (this.defaultObservers)
    {
      this.defaultObservers.remove(paramacci);
      return;
      paramacci = finally;
      throw paramacci;
      paramacci = finally;
      throw paramacci;
    }
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    this.a.g(paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAppInterface
 * JD-Core Version:    0.7.0.1
 */