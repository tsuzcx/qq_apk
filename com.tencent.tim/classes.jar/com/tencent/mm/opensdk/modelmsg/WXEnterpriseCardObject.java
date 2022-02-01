package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;

public class WXEnterpriseCardObject
  implements WXMediaMessage.IMediaObject
{
  private static final int LENGTH_LIMIT = 10240;
  private static final String TAG = "MicroMsg.SDK.WXEnterpriseCardObject";
  public String cardInfo;
  public int msgType;
  
  public boolean checkArgs()
  {
    if ((this.cardInfo == null) || (this.cardInfo.length() == 0))
    {
      Log.e("MicroMsg.SDK.WXEnterpriseCardObject", "checkArgs fail, cardInfo is invalid");
      return false;
    }
    return true;
  }
  
  public void serialize(Bundle paramBundle)
  {
    paramBundle.putInt("_wxenterprisecard_msgtype", this.msgType);
    paramBundle.putString("_wxenterprisecard_cardinfo", this.cardInfo);
  }
  
  public int type()
  {
    return 45;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.msgType = paramBundle.getInt("_wxenterprisecard_msgtype");
    this.cardInfo = paramBundle.getString("_wxenterprisecard_cardinfo");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXEnterpriseCardObject
 * JD-Core Version:    0.7.0.1
 */