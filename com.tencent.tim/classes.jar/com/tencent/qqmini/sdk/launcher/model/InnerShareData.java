package com.tencent.qqmini.sdk.launcher.model;

import android.app.Activity;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.shell.IShareManager;
import com.tencent.qqmini.sdk.launcher.ui.MoreItem;
import org.json.JSONObject;

public class InnerShareData
  extends ShareData
{
  public int callbackId;
  public EntryModel entryModel;
  public String entryPath;
  public String event;
  public Activity fromActivity;
  public JSONObject jsonObject;
  public String recvOpenId;
  public ShareChatModel shareChatModel;
  public String templateData;
  public String templateId;
  public String webURL;
  public boolean withShareTicket;
  
  public MiniAppInfo getMiniAppInfo()
  {
    return this.miniAppInfo;
  }
  
  public int getShareType()
  {
    switch (this.shareTarget)
    {
    default: 
      return 6;
    case 0: 
    case 2: 
    case 5: 
    case 6: 
      return 0;
    case 1: 
      return 1;
    case 3: 
      return 3;
    }
    return 4;
  }
  
  public void shareAppMessage()
  {
    AppLoaderFactory.g().getShareManager().shareAppMessage(this);
  }
  
  public void shareAppPictureMessage(IMiniAppContext paramIMiniAppContext)
  {
    AppLoaderFactory.g().getShareManager().shareAppPictureMessage(paramIMiniAppContext, this);
  }
  
  public static class Builder
  {
    private InnerShareData shareData = new InnerShareData(null);
    
    public InnerShareData build()
    {
      return this.shareData;
    }
    
    public Builder setCallbackId(int paramInt)
    {
      this.shareData.callbackId = paramInt;
      return this;
    }
    
    public Builder setEntryModel(EntryModel paramEntryModel)
    {
      this.shareData.entryModel = paramEntryModel;
      return this;
    }
    
    public Builder setEntryPath(String paramString)
    {
      this.shareData.entryPath = paramString;
      return this;
    }
    
    public Builder setEvent(String paramString)
    {
      this.shareData.event = paramString;
      return this;
    }
    
    public Builder setFromActivity(Activity paramActivity)
    {
      this.shareData.fromActivity = paramActivity;
      return this;
    }
    
    public Builder setIsLocalPic(boolean paramBoolean)
    {
      this.shareData.isLocalPic = paramBoolean;
      return this;
    }
    
    public Builder setMiniAppInfo(MiniAppInfo paramMiniAppInfo)
    {
      this.shareData.miniAppInfo = paramMiniAppInfo;
      return this;
    }
    
    public Builder setRecvOpenId(String paramString)
    {
      this.shareData.recvOpenId = paramString;
      return this;
    }
    
    public Builder setShareChatModel(ShareChatModel paramShareChatModel)
    {
      this.shareData.shareChatModel = paramShareChatModel;
      return this;
    }
    
    public Builder setShareInMiniProcess(boolean paramBoolean)
    {
      this.shareData.shareInMiniProcess = paramBoolean;
      return this;
    }
    
    public Builder setShareItemId(int paramInt)
    {
      this.shareData.shareItemId = paramInt;
      return this;
    }
    
    public Builder setSharePicPath(String paramString)
    {
      this.shareData.sharePicPath = paramString;
      return this;
    }
    
    public Builder setShareSource(int paramInt)
    {
      this.shareData.shareSource = paramInt;
      return this;
    }
    
    public Builder setShareTarget(int paramInt)
    {
      this.shareData.shareTarget = paramInt;
      switch (paramInt)
      {
      }
      for (;;)
      {
        if (MoreItem.isValidExtendedItemId(paramInt)) {
          setShareItemId(paramInt);
        }
        return this;
        setShareItemId(1);
        continue;
        setShareItemId(2);
        continue;
        setShareItemId(3);
        continue;
        setShareItemId(4);
      }
    }
    
    public Builder setSummary(String paramString)
    {
      this.shareData.summary = paramString;
      return this;
    }
    
    public Builder setTargetUrl(String paramString)
    {
      this.shareData.targetUrl = paramString;
      return this;
    }
    
    public Builder setTemplateData(String paramString)
    {
      this.shareData.templateData = paramString;
      return this;
    }
    
    public Builder setTemplateId(String paramString)
    {
      this.shareData.templateId = paramString;
      return this;
    }
    
    public Builder setTitle(String paramString)
    {
      this.shareData.title = paramString;
      return this;
    }
    
    public Builder setWebUrl(String paramString)
    {
      this.shareData.webURL = paramString;
      return this;
    }
    
    public Builder setWithShareTicket(boolean paramBoolean)
    {
      this.shareData.withShareTicket = paramBoolean;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.InnerShareData
 * JD-Core Version:    0.7.0.1
 */