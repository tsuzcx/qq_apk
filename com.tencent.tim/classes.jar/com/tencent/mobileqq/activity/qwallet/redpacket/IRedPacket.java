package com.tencent.mobileqq.activity.qwallet.redpacket;

import Wallet.RedPackGrapInfo;
import java.util.List;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public abstract interface IRedPacket
{
  public abstract JSONObject getPopAd(int paramInt1, int paramInt2);
  
  public abstract List<String> getReadyResList();
  
  public abstract void getSkin(RedPacketInfoBase paramRedPacketInfoBase, OnGetSkinListener paramOnGetSkinListener);
  
  public abstract JSONObject getTail(int paramInt1, int paramInt2);
  
  public abstract void getVoiceRateRes(RedPacketInfoBase paramRedPacketInfoBase, OnGetSkinListener paramOnGetSkinListener);
  
  public abstract boolean isRiskSwitchOpen();
  
  public abstract void onActiveAccount();
  
  public abstract boolean onGetThemeConfig(int paramInt);
  
  public abstract void onUpdate(int paramInt);
  
  public abstract void registRedPacketSkinListObserver(BusinessObserver paramBusinessObserver);
  
  public abstract void reqGroupAvailableList(String paramString, int paramInt, OnGetAvailableListListener paramOnGetAvailableListListener);
  
  public abstract void requestRedPacketSkinList();
  
  public abstract void requestRedPacketSkinList(String paramString1, String paramString2, int paramInt);
  
  public abstract void setSelectedSkin(int paramInt, BusinessObserver paramBusinessObserver);
  
  public abstract void unregistRedPacketSkinListObserver(BusinessObserver paramBusinessObserver);
  
  public static abstract interface OnDownLoadListener
  {
    public abstract void onDownLoad(int paramInt);
  }
  
  public static abstract interface OnGetAvailableListListener
  {
    public abstract void OnGetAvailableList(List<RedPackGrapInfo> paramList);
  }
  
  public static abstract interface OnGetSkinListener
  {
    public static final int TYPE_AIO_REDPACKET = 1;
    public static final int TYPE_POP_ANIM = 4;
    public static final int TYPE_POP_REDPACKET = 2;
    public static final int TYPE_SPECAIL_ANIM = 3;
    
    public abstract void onGetSkin(RedPacketInfoBase paramRedPacketInfoBase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket
 * JD-Core Version:    0.7.0.1
 */