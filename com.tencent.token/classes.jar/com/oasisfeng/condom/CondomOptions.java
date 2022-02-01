package com.oasisfeng.condom;

import android.support.annotation.Keep;
import com.tencent.token.ajv;
import com.tencent.token.la;
import java.util.ArrayList;
import java.util.List;

@Keep
public class CondomOptions
{
  boolean mDryRun;
  boolean mExcludeBackgroundReceivers = true;
  boolean mExcludeBackgroundServices = true;
  List<la> mKits;
  OutboundJudge mOutboundJudge;
  ajv mPackageManagerFactory;
  
  public CondomOptions addKit(la paramla)
  {
    if (this.mKits == null) {
      this.mKits = new ArrayList();
    }
    this.mKits.add(paramla);
    return this;
  }
  
  public CondomOptions preventBroadcastToBackgroundPackages(boolean paramBoolean)
  {
    this.mExcludeBackgroundReceivers = paramBoolean;
    return this;
  }
  
  public CondomOptions preventServiceInBackgroundPackages(boolean paramBoolean)
  {
    this.mExcludeBackgroundServices = paramBoolean;
    return this;
  }
  
  public CondomOptions setDryRun(boolean paramBoolean)
  {
    this.mDryRun = paramBoolean;
    return this;
  }
  
  public CondomOptions setOutboundJudge(OutboundJudge paramOutboundJudge)
  {
    this.mOutboundJudge = paramOutboundJudge;
    return this;
  }
  
  public CondomOptions setPackageManagerFactory(ajv paramajv)
  {
    this.mPackageManagerFactory = paramajv;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.oasisfeng.condom.CondomOptions
 * JD-Core Version:    0.7.0.1
 */