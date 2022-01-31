package com.tencent.upload.network.route;

import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.UploadLog;
import com.tencent.upload.network.session.IUploadSessionCallback.FailureCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractRouteStrategy
  implements IUploadRouteStrategy
{
  protected boolean mCausedByApnChanged = false;
  protected final int mHashCode = hashCode();
  protected List<Integer> mPorts;
  protected Iterator<Integer> mPortsIterator;
  protected RecentRouteSet mRecentRouteSet;
  protected List<UploadRoute> mRoutes;
  protected Iterator<UploadRoute> mRoutesIterator;
  protected final String mTag = getClass().getSimpleName();
  protected String mUsedApn;
  protected List<UsedRouteInfo> mUsedRouteInfos;
  
  private UploadRoute doChangeRoute(UploadRoute paramUploadRoute)
  {
    UploadLog.d(this.mTag, this.mHashCode + " doChangeRoute: currentRoute:" + paramUploadRoute);
    if (this.mPortsIterator.hasNext())
    {
      paramUploadRoute.setPort(((Integer)this.mPortsIterator.next()).intValue());
      UploadLog.d(this.mTag, this.mHashCode + " doChangeRoute:, to next port" + paramUploadRoute);
    }
    for (;;)
    {
      UploadRoute localUploadRoute2 = doRetrieveRecentRoute();
      UploadRoute localUploadRoute1 = paramUploadRoute;
      if (localUploadRoute2 != null)
      {
        localUploadRoute1 = paramUploadRoute;
        if (localUploadRoute2.isDuplicate(paramUploadRoute))
        {
          UploadLog.d(this.mTag, this.mHashCode + " isDuplicate with recent, doChangeRoute:" + paramUploadRoute.toString());
          localUploadRoute1 = doChangeRoute(paramUploadRoute);
        }
      }
      return localUploadRoute1;
      if (this.mRoutesIterator.hasNext())
      {
        this.mPortsIterator = this.mPorts.iterator();
        if (this.mPortsIterator.hasNext())
        {
          paramUploadRoute = (UploadRoute)this.mRoutesIterator.next();
          paramUploadRoute.setPort(((Integer)this.mPortsIterator.next()).intValue());
          UploadLog.d(this.mTag, this.mHashCode + " doChangeRoute: to next ip" + paramUploadRoute);
        }
        else
        {
          paramUploadRoute = null;
          UploadLog.w(this.mTag, this.mHashCode + " doChangeRoute: to next ip, but no port. exception");
        }
      }
      else
      {
        paramUploadRoute = null;
        UploadLog.d(this.mTag, this.mHashCode + " doChangeRoute: finish, return null");
      }
    }
  }
  
  private void doInitParams()
  {
    this.mRoutes = UploadConfiguration.getUploadRoutes(getServerCategory());
    if ((this.mRoutes == null) || (this.mRoutes.size() == 0)) {
      throw new RuntimeException(this.mTag + this.mHashCode + " doInitParams, getUploadRoutes illegel");
    }
    this.mPorts = UploadConfiguration.getUploadRoutePorts();
    if ((this.mPorts == null) || (this.mPorts.size() == 0)) {
      throw new RuntimeException(this.mTag + this.mHashCode + " doInitParams, getUploadRoutePorts illegel");
    }
    this.mRoutesIterator = this.mRoutes.iterator();
    this.mPortsIterator = this.mPorts.iterator();
    StringBuffer localStringBuffer = new StringBuffer(this.mRoutes.size());
    Iterator localIterator = this.mRoutes.iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        UploadLog.d(this.mTag, this.mHashCode + " doInitParams:" + localStringBuffer.toString());
        this.mUsedRouteInfos = new ArrayList();
        return;
      }
      localStringBuffer.append(((UploadRoute)localIterator.next()).toString() + " ");
    }
  }
  
  private void doLoadRecentRouteSet()
  {
    String str = UploadConfiguration.getRecentRouteApnKey();
    if (str == null)
    {
      UploadLog.d(this.mTag, this.mHashCode + " doLoadRecentRouteSet, unknown key");
      return;
    }
    this.mRecentRouteSet = new RecentRouteSetStorage(getServerCategory()).getData(str);
  }
  
  private UploadRoute doRetrieveFirstRoute()
  {
    if ((!this.mRoutesIterator.hasNext()) || (!this.mPortsIterator.hasNext()))
    {
      UploadLog.d(this.mTag, this.mHashCode + " doRetrieveFirstRoute return null");
      return null;
    }
    UploadRoute localUploadRoute1 = (UploadRoute)this.mRoutesIterator.next();
    localUploadRoute1.setPort(((Integer)this.mPortsIterator.next()).intValue());
    UploadRoute localUploadRoute2 = doRetrieveRecentRoute();
    if ((localUploadRoute2 != null) && (localUploadRoute2.isDuplicate(localUploadRoute1)))
    {
      UploadLog.d(this.mTag, this.mHashCode + " doRetrieveFirstRoute isDuplicate with recent, doChangeRoute:" + localUploadRoute1.toString());
      return doChangeRoute(localUploadRoute1);
    }
    UploadLog.d(this.mTag, this.mHashCode + " doRetrieveFirstRoute return:" + localUploadRoute1.toString());
    return localUploadRoute1;
  }
  
  private UploadRoute doRetrieveRecentRoute()
  {
    if (this.mRecentRouteSet == null) {
      return null;
    }
    UploadRoute localUploadRoute = this.mRecentRouteSet.getRecentTcpRoute();
    if (localUploadRoute != null)
    {
      UploadLog.d(this.mTag, this.mHashCode + " doRetrieveRecentRoute: " + localUploadRoute.toString());
      return localUploadRoute;
    }
    localUploadRoute = this.mRecentRouteSet.getRecentHttpRoute();
    if (localUploadRoute != null)
    {
      UploadLog.d(this.mTag, this.mHashCode + " doRetrieveRecentRoute: " + localUploadRoute.toString());
      return localUploadRoute;
    }
    return null;
  }
  
  public boolean causedByApnChanged()
  {
    return this.mCausedByApnChanged;
  }
  
  public String getUsedRoutesDescription()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.mUsedRouteInfos.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localStringBuffer.toString();
      }
      localStringBuffer.append(((UsedRouteInfo)localIterator.next()).toString());
    }
  }
  
  public UploadRoute[] next(UploadRoute paramUploadRoute, int paramInt)
  {
    if (paramUploadRoute == null)
    {
      UploadLog.d(this.mTag, this.mHashCode + " next: null, route == null");
      return null;
    }
    this.mUsedRouteInfos.add(new UsedRouteInfo(paramUploadRoute.clone(), paramInt));
    boolean bool2 = UploadConfiguration.isNetworkAvailable();
    if (bool2) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      this.mCausedByApnChanged = bool1;
      if (bool2) {
        break;
      }
      UploadLog.d(this.mTag, this.mHashCode + " next: null, !isNetworkAvailable");
      return null;
    }
    if ((this.mUsedApn != null) && (this.mUsedApn.compareToIgnoreCase(UploadConfiguration.getCurrentApn()) == 0)) {}
    for (bool1 = false;; bool1 = true)
    {
      this.mCausedByApnChanged = bool1;
      if (!bool1) {
        break;
      }
      UploadLog.d(this.mTag, this.mHashCode + " next: null, isApnChanged:" + bool1);
      return null;
    }
    Object localObject;
    if (paramUploadRoute.getRouteCategory() == 3)
    {
      localObject = doRetrieveFirstRoute();
      if (localObject != null)
      {
        UploadLog.d(this.mTag, this.mHashCode + " next: return" + localObject);
        return new UploadRoute[] { localObject };
      }
    }
    label271:
    boolean bool3;
    label282:
    boolean bool4;
    if (paramUploadRoute.getProxyIp() != null)
    {
      bool1 = true;
      if (paramUploadRoute.getProtocol() != 1) {
        break label472;
      }
      bool2 = true;
      if (paramUploadRoute.getProtocol() != 2) {
        break label478;
      }
      bool3 = true;
      bool4 = UploadConfiguration.isWapSetting();
      UploadLog.d(this.mTag, this.mHashCode + " next start: " + IUploadSessionCallback.FailureCode.print(paramInt) + " wap:" + bool4 + " tcp:" + bool2 + " http:" + bool3 + " proxy:" + bool1);
      if (paramInt != 0) {
        break label540;
      }
      if ((!bool4) || (!bool2)) {
        break label484;
      }
      UploadLog.d(this.mTag, this.mHashCode + " next: wap tcp -> proxy http, " + IUploadSessionCallback.FailureCode.print(paramInt));
      paramUploadRoute.setProtocol(2);
      UploadConfiguration.setRouteProxy(paramUploadRoute);
      localObject = paramUploadRoute;
    }
    for (;;)
    {
      if (localObject != null) {
        break label979;
      }
      UploadLog.d(this.mTag, this.mHashCode + " next return: null");
      return null;
      bool1 = false;
      break;
      label472:
      bool2 = false;
      break label271;
      label478:
      bool3 = false;
      break label282;
      label484:
      UploadLog.d(this.mTag, this.mHashCode + " next: change route " + IUploadSessionCallback.FailureCode.print(paramInt));
      paramUploadRoute.clearProxy();
      paramUploadRoute.setProtocol(1);
      localObject = doChangeRoute(paramUploadRoute);
      continue;
      label540:
      if (paramInt == 1)
      {
        if ((bool4) && (!bool1) && (bool3))
        {
          UploadLog.d(this.mTag, this.mHashCode + " next: wap direct http -> proxy http " + IUploadSessionCallback.FailureCode.print(paramInt));
          paramUploadRoute.setProtocol(2);
          UploadConfiguration.setRouteProxy(paramUploadRoute);
          localObject = paramUploadRoute;
        }
        else
        {
          UploadLog.d(this.mTag, this.mHashCode + " next: change route " + IUploadSessionCallback.FailureCode.print(paramInt));
          paramUploadRoute.clearProxy();
          paramUploadRoute.setProtocol(1);
          localObject = doChangeRoute(paramUploadRoute);
        }
      }
      else if (paramInt == 2)
      {
        if (bool2)
        {
          UploadLog.d(this.mTag, this.mHashCode + " next: tcp -> direct http " + IUploadSessionCallback.FailureCode.print(paramInt));
          paramUploadRoute.setProtocol(2);
          paramUploadRoute.clearProxy();
          localObject = paramUploadRoute;
        }
        else if ((bool4) && (!bool1) && (bool3))
        {
          UploadLog.d(this.mTag, this.mHashCode + " next: wap direct http -> proxy http " + IUploadSessionCallback.FailureCode.print(paramInt));
          paramUploadRoute.setProtocol(2);
          UploadConfiguration.setRouteProxy(paramUploadRoute);
          localObject = paramUploadRoute;
        }
        else
        {
          UploadLog.d(this.mTag, this.mHashCode + " next: change route " + IUploadSessionCallback.FailureCode.print(paramInt));
          paramUploadRoute.clearProxy();
          paramUploadRoute.setProtocol(1);
          localObject = doChangeRoute(paramUploadRoute);
        }
      }
      else
      {
        if (paramInt == 3) {
          for (;;)
          {
            if (!this.mPortsIterator.hasNext())
            {
              UploadRoute localUploadRoute = doChangeRoute(paramUploadRoute);
              localObject = localUploadRoute;
              if (localUploadRoute == null) {
                break;
              }
              localObject = localUploadRoute;
              if (paramUploadRoute == null) {
                break;
              }
              localUploadRoute.setProxy(paramUploadRoute.getProxyIp(), paramUploadRoute.getPorxyPort());
              localUploadRoute.setProtocol(paramUploadRoute.getProtocol());
              localUploadRoute.setRouteCategory(paramUploadRoute.getRouteCategory());
              localObject = localUploadRoute;
              break;
            }
            this.mPortsIterator.next();
          }
        }
        UploadLog.e(this.mTag, this.mHashCode + " next: failureCode exception");
        localObject = null;
      }
    }
    label979:
    UploadLog.d(this.mTag, this.mHashCode + " next return: " + ((UploadRoute)localObject).toString());
    return new UploadRoute[] { localObject };
  }
  
  public UploadRoute[] reset()
  {
    this.mCausedByApnChanged = false;
    doInitParams();
    if ((this.mUsedApn != null) && (this.mUsedApn.compareToIgnoreCase(UploadConfiguration.getCurrentApn()) == 0)) {}
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        this.mUsedApn = UploadConfiguration.getCurrentApn();
        doLoadRecentRouteSet();
      }
      localUploadRoute = doRetrieveRecentRoute();
      if (localUploadRoute == null) {
        break;
      }
      UploadLog.d(this.mTag, this.mHashCode + " reset: return: " + localUploadRoute.toString());
      return new UploadRoute[] { localUploadRoute };
    }
    UploadRoute localUploadRoute = doRetrieveFirstRoute();
    if (localUploadRoute != null)
    {
      UploadLog.d(this.mTag, this.mHashCode + " reset: return" + localUploadRoute);
      return new UploadRoute[] { localUploadRoute };
    }
    UploadLog.d(this.mTag, this.mHashCode + " reset: return null");
    return null;
  }
  
  public boolean save(UploadRoute paramUploadRoute)
  {
    String str = UploadConfiguration.getRecentRouteApnKey();
    if (str == null)
    {
      UploadLog.d(this.mTag, "save, unknown key");
      return false;
    }
    if ((str != null) && (str.length() > 0))
    {
      UploadLog.d(this.mTag, this.mHashCode + " save: as recent:" + paramUploadRoute + " recentApnKey:" + str);
      this.mRecentRouteSet = UploadConfiguration.saveAsRecentIp(getServerCategory(), str, paramUploadRoute);
      return true;
    }
    UploadLog.d(this.mTag, this.mHashCode + " save: apnKey isNullOrEmpty");
    return true;
  }
  
  private static final class UsedRouteInfo
  {
    public final int routeFailureCode;
    public final UploadRoute usedRoute;
    
    public UsedRouteInfo(UploadRoute paramUploadRoute, int paramInt)
    {
      this.usedRoute = paramUploadRoute;
      this.routeFailureCode = paramInt;
    }
    
    public String toString()
    {
      return String.format("[%1$s, %2$s]", new Object[] { this.usedRoute.toString(), IUploadSessionCallback.FailureCode.print(this.routeFailureCode) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.upload.network.route.AbstractRouteStrategy
 * JD-Core Version:    0.7.0.1
 */