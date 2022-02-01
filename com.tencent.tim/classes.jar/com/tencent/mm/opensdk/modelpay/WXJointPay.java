package com.tencent.mm.opensdk.modelpay;

import android.os.Bundle;

public class WXJointPay
{
  public static class JointPayReq
    extends PayReq
  {
    public boolean checkArgs()
    {
      return super.checkArgs();
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
    }
    
    public int getType()
    {
      return 27;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
    }
  }
  
  public static class JointPayResp
    extends PayResp
  {
    public JointPayResp() {}
    
    public JointPayResp(Bundle paramBundle)
    {
      fromBundle(paramBundle);
    }
    
    public boolean checkArgs()
    {
      return super.checkArgs();
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
    }
    
    public int getType()
    {
      return 27;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelpay.WXJointPay
 * JD-Core Version:    0.7.0.1
 */