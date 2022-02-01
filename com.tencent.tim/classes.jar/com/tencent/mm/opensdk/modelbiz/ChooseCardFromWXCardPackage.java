package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;

public class ChooseCardFromWXCardPackage
{
  private static final String TAG = "MicroMsg.ChooseCardFromWXCardPackage";
  
  public static class Req
    extends BaseReq
  {
    public String appId;
    public String canMultiSelect;
    public String cardId;
    public String cardSign;
    public String cardType;
    public String locationId;
    public String nonceStr;
    public String signType;
    public String timeStamp;
    
    public boolean checkArgs()
    {
      if ((this.appId == null) || (this.appId.length() <= 0)) {}
      while ((this.signType == null) || (this.signType.length() <= 0) || (this.cardSign == null) || (this.cardSign.length() <= 0)) {
        return false;
      }
      return true;
    }
    
    public int getType()
    {
      return 16;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_choose_card_from_wx_card_app_id", this.appId);
      paramBundle.putString("_wxapi_choose_card_from_wx_card_location_id", this.locationId);
      paramBundle.putString("_wxapi_choose_card_from_wx_card_sign_type", this.signType);
      paramBundle.putString("_wxapi_choose_card_from_wx_card_card_sign", this.cardSign);
      paramBundle.putString("_wxapi_choose_card_from_wx_card_time_stamp", this.timeStamp);
      paramBundle.putString("_wxapi_choose_card_from_wx_card_nonce_str", this.nonceStr);
      paramBundle.putString("_wxapi_choose_card_from_wx_card_card_id", this.cardId);
      paramBundle.putString("_wxapi_choose_card_from_wx_card_card_type", this.cardType);
      paramBundle.putString("_wxapi_choose_card_from_wx_card_can_multi_select", this.canMultiSelect);
    }
  }
  
  public static class Resp
    extends BaseResp
  {
    public String cardItemList;
    
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      fromBundle(paramBundle);
    }
    
    public boolean checkArgs()
    {
      return (this.cardItemList != null) && (this.cardItemList.length() != 0);
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
      paramBundle = paramBundle.getString("_wxapi_choose_card_from_wx_card_list");
      if ((paramBundle != null) && (paramBundle.length() > 0))
      {
        this.cardItemList = paramBundle;
        return;
      }
      Log.i("MicroMsg.ChooseCardFromWXCardPackage", "cardItemList is empty!");
    }
    
    public int getType()
    {
      return 16;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_choose_card_from_wx_card_list", this.cardItemList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage
 * JD-Core Version:    0.7.0.1
 */