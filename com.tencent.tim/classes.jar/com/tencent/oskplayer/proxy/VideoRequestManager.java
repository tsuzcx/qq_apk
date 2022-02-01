package com.tencent.oskplayer.proxy;

import android.text.TextUtils;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.util.PlayerUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class VideoRequestManager
{
  private static final String TAG = "RequestManager";
  private ArrayList<RequestListener> mListeners = new ArrayList();
  private final Object mLock = new Object();
  private final LinkedHashMap<String, ArrayList<VideoRequest>> requestMap = new LinkedHashMap(8, 0.75F);
  
  private void cancelRequest(VideoRequest paramVideoRequest, boolean paramBoolean)
  {
    PlayerUtils.log(4, "RequestManager", "start cancel request=" + paramVideoRequest);
    paramVideoRequest.cancel(paramBoolean);
  }
  
  private void cancelVideoRequestByUuid(String paramString, boolean paramBoolean)
  {
    try
    {
      paramString = getVideoRequestByUuid(paramString).iterator();
      while (paramString.hasNext()) {
        cancelRequest((VideoRequest)paramString.next(), paramBoolean);
      }
    }
    finally {}
  }
  
  public void addRequest(String paramString, VideoRequest paramVideoRequest)
  {
    try
    {
      ArrayList localArrayList2 = (ArrayList)this.requestMap.get(paramString);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        this.requestMap.put(paramString, localArrayList1);
        PlayerUtils.log(3, "RequestManager", "init requestMap for url " + paramString);
      }
      localArrayList1.add(paramVideoRequest);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void addRequestListener(RequestListener paramRequestListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	com/tencent/oskplayer/proxy/VideoRequestManager:mLock	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_2
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 28	com/tencent/oskplayer/proxy/VideoRequestManager:mListeners	Ljava/util/ArrayList;
    //   18: aload_1
    //   19: invokevirtual 107	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   22: pop
    //   23: aload_2
    //   24: monitorexit
    //   25: return
    //   26: astore_1
    //   27: aload_2
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	VideoRequestManager
    //   0	31	1	paramRequestListener	RequestListener
    //   4	24	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	13	26	finally
    //   14	25	26	finally
    //   27	29	26	finally
  }
  
  public void cancelAllPreloadRequestAsync(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = this.requestMap.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        Object localObject2 = (ArrayList)((Map.Entry)localIterator.next()).getValue();
        if (localObject2 != null)
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            VideoRequest localVideoRequest = (VideoRequest)((Iterator)localObject2).next();
            if (localVideoRequest.getPrority() > 10) {
              continue;
            }
            PlayerUtils.log(4, "RequestManager", "preload cancel url " + localVideoRequest);
            cancelRequest(localVideoRequest, paramBoolean);
            ((Iterator)localObject2).remove();
          }
        }
        else
        {
          PlayerUtils.log(4, "RequestManager", "cancel url fail, associate request not found, mediaplayer is dead?");
        }
      }
      finally {}
    }
  }
  
  public void cancelPreloadRequestByRequest(VideoRequest paramVideoRequest, boolean paramBoolean)
  {
    if (paramVideoRequest != null) {}
    try
    {
      paramVideoRequest.cancel(paramBoolean);
      return;
    }
    finally
    {
      paramVideoRequest = finally;
      throw paramVideoRequest;
    }
  }
  
  public void cancelVideoRequestByUuid(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        cancelVideoRequestByUuid(paramString, true);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public ArrayList<VideoRequest> getActiveVideoRequest()
  {
    try
    {
      ArrayList localArrayList1 = new ArrayList();
      Iterator localIterator = this.requestMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        ArrayList localArrayList2 = (ArrayList)((Map.Entry)localIterator.next()).getValue();
        if (localArrayList2.size() > 0) {
          localArrayList1.addAll(localArrayList2);
        }
      }
    }
    finally {}
    return localArrayList;
  }
  
  public ArrayList<VideoRequest> getPriorityRequest(int paramInt)
  {
    try
    {
      ArrayList localArrayList1 = new ArrayList();
      Iterator localIterator = this.requestMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        ArrayList localArrayList2 = (ArrayList)((Map.Entry)localIterator.next()).getValue();
        if ((localArrayList2.size() > 0) && (paramInt == ((VideoRequest)localArrayList2.get(0)).getPrority())) {
          localArrayList1.addAll(localArrayList2);
        }
      }
    }
    finally {}
    return localArrayList;
  }
  
  public ArrayList<VideoRequest> getVideoRequestByUuid(String paramString)
  {
    try
    {
      paramString = getVideoRequestByUuid(paramString, -1);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public ArrayList<VideoRequest> getVideoRequestByUuid(String paramString, int paramInt)
  {
    ArrayList localArrayList1;
    for (;;)
    {
      try
      {
        localArrayList1 = new ArrayList();
        Iterator localIterator = this.requestMap.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        ArrayList localArrayList2 = (ArrayList)((Map.Entry)localIterator.next()).getValue();
        if (localArrayList2.size() > 0)
        {
          VideoRequest localVideoRequest = (VideoRequest)localArrayList2.get(0);
          if (paramString.equals(localVideoRequest.getUuid())) {
            if (paramInt != -1)
            {
              if (paramInt == localVideoRequest.getPrority()) {
                localArrayList1.addAll(localArrayList2);
              }
            }
            else {
              localArrayList1.addAll(localArrayList2);
            }
          }
        }
      }
      finally {}
    }
    return localArrayList1;
  }
  
  public ArrayList<VideoRequest> getVideoRequestByVideoKey(String paramString, int paramInt)
  {
    ArrayList localArrayList1;
    for (;;)
    {
      try
      {
        localArrayList1 = new ArrayList();
        Iterator localIterator = this.requestMap.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        ArrayList localArrayList2 = (ArrayList)((Map.Entry)localIterator.next()).getValue();
        if (localArrayList2.size() > 0)
        {
          VideoRequest localVideoRequest = (VideoRequest)localArrayList2.get(0);
          if (paramString.equals(localVideoRequest.getVideoKey())) {
            if (paramInt != -1)
            {
              if (paramInt == localVideoRequest.getPrority()) {
                localArrayList1.addAll(localArrayList2);
              }
            }
            else {
              localArrayList1.addAll(localArrayList2);
            }
          }
        }
      }
      finally {}
    }
    return localArrayList1;
  }
  
  public void removeRequest(VideoRequest paramVideoRequest)
  {
    for (;;)
    {
      try
      {
        Object localObject = (ArrayList)this.requestMap.get(paramVideoRequest.getSourceUrl());
        if (localObject == null) {
          break;
        }
        localObject = ((ArrayList)localObject).iterator();
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        if (paramVideoRequest.equals((VideoRequest)((Iterator)localObject).next()))
        {
          if (PlayerConfig.g().isDebugVersion()) {
            PlayerUtils.log(3, "RequestManager", "remove request " + paramVideoRequest);
          }
          Iterator localIterator = this.mListeners.iterator();
          if (localIterator.hasNext()) {
            ((RequestListener)localIterator.next()).onBeforeRequestRemove(paramVideoRequest);
          } else {
            ((Iterator)localObject).remove();
          }
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public void removeRequestListener(RequestListener paramRequestListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	com/tencent/oskplayer/proxy/VideoRequestManager:mLock	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_2
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 28	com/tencent/oskplayer/proxy/VideoRequestManager:mListeners	Ljava/util/ArrayList;
    //   18: aload_1
    //   19: invokevirtual 200	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   22: pop
    //   23: aload_2
    //   24: monitorexit
    //   25: return
    //   26: astore_1
    //   27: aload_2
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	VideoRequestManager
    //   0	31	1	paramRequestListener	RequestListener
    //   4	24	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	13	26	finally
    //   14	25	26	finally
    //   27	29	26	finally
  }
  
  public String toString()
  {
    try
    {
      Object localObject1 = super.toString();
      Object localObject3 = (String)localObject1 + "[";
      Iterator localIterator1 = this.requestMap.entrySet().iterator();
      if (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((ArrayList)((Map.Entry)localIterator1.next()).getValue()).iterator();
        for (localObject1 = localObject3;; localObject1 = (String)localObject1 + ",\n")
        {
          localObject3 = localObject1;
          if (!localIterator2.hasNext()) {
            break;
          }
          localObject3 = (VideoRequest)localIterator2.next();
          localObject1 = (String)localObject1 + ((VideoRequest)localObject3).toString();
        }
      }
      localObject1 = (String)localObject3 + "]";
      return localObject1;
    }
    finally {}
  }
  
  public static abstract interface RequestListener
  {
    public abstract void onBeforeRequestRemove(VideoRequest paramVideoRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.proxy.VideoRequestManager
 * JD-Core Version:    0.7.0.1
 */