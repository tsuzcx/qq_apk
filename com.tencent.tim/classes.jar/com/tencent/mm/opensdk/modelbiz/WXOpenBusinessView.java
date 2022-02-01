package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class WXOpenBusinessView
{
  public static final class Req
    extends BaseReq
  {
    private static final String TAG = "MicroMsg.SDK.WXOpenBusinessView.Req";
    public String businessType;
    public String extInfo;
    public String query;
    
    public final boolean checkArgs()
    {
      if (d.b(this.businessType))
      {
        Log.e("MicroMsg.SDK.WXOpenBusinessView.Req", "businessType is null");
        return false;
      }
      return true;
    }
    
    public final void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
      this.businessType = paramBundle.getString("_openbusinessview_businessType");
      this.query = paramBundle.getString("_openbusinessview__query_info");
      this.extInfo = paramBundle.getString("_openbusinessview_extInfo");
    }
    
    public final int getType()
    {
      return 26;
    }
    
    public final void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      paramBundle.putString("_openbusinessview_businessType", this.businessType);
      paramBundle.putString("_openbusinessview__query_info", this.query);
      paramBundle.putString("_openbusinessview_extInfo", this.extInfo);
    }
  }
  
  public static final class Resp
    extends BaseResp
  {
    public String businessType;
    public String extMsg;
    
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      fromBundle(paramBundle);
    }
    
    public final boolean checkArgs()
    {
      return true;
    }
    
    public final void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
      this.extMsg = paramBundle.getString("_openbusinessview_ext_msg");
      this.businessType = paramBundle.getString("_openbusinessview_business_type");
    }
    
    public final int getType()
    {
      return 26;
    }
    
    public final void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      paramBundle.putString("_openbusinessview_ext_msg", this.extMsg);
      paramBundle.putString("_openbusinessview_business_type", this.businessType);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView
 * JD-Core Version:    0.7.0.1
 */