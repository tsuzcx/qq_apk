package com.oasisfeng.condom;

import android.support.annotation.Keep;
import android.support.annotation.Nullable;
import com.tencent.token.h;
import java.util.ArrayList;
import java.util.List;

@Keep
public class CondomOptions
{
  boolean mDryRun;
  boolean mExcludeBackgroundReceivers = true;
  boolean mExcludeBackgroundServices = true;
  @Nullable
  List<c> mKits;
  @Nullable
  OutboundJudge mOutboundJudge;
  @Nullable
  h mPackageManagerFactory;
  
  public CondomOptions addKit(c paramc)
  {
    if (this.mKits == null) {
      this.mKits = new ArrayList();
    }
    this.mKits.add(paramc);
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
  
  public CondomOptions setPackageManagerFactory(h paramh)
  {
    this.mPackageManagerFactory = paramh;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.oasisfeng.condom.CondomOptions
 * JD-Core Version:    0.7.0.1
 */