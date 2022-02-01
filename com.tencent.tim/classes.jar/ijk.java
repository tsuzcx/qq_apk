import com.tencent.av.app.VideoAppInterface;

public class ijk
{
  private accg[] a = new accg[4];
  
  private accg b(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    Object localObject = null;
    long l1 = System.currentTimeMillis();
    switch (paramInt)
    {
    }
    for (paramVideoAppInterface = localObject;; paramVideoAppInterface = new ije(paramVideoAppInterface))
    {
      igd.aJ("BusinessHandlerFactory", "createHandler unknown name");
      for (;;)
      {
        long l2 = System.currentTimeMillis();
        igd.aJ("BusinessHandlerFactory", "createHandler,cost time:" + (l2 - l1));
        return paramVideoAppInterface;
        paramVideoAppInterface = new ijj(paramVideoAppInterface);
        continue;
        paramVideoAppInterface = new ijh(paramVideoAppInterface);
        continue;
        paramVideoAppInterface = new iro(paramVideoAppInterface);
      }
    }
  }
  
  public accg a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    Object localObject = this.a[paramInt];
    if (localObject != null) {
      return localObject;
    }
    synchronized (this.a)
    {
      accg localaccg = this.a[paramInt];
      localObject = localaccg;
      if (localaccg == null)
      {
        paramVideoAppInterface = b(paramVideoAppInterface, paramInt);
        localObject = paramVideoAppInterface;
        if (paramVideoAppInterface != null)
        {
          this.a[paramInt] = paramVideoAppInterface;
          localObject = paramVideoAppInterface;
        }
      }
      return localObject;
    }
  }
  
  public void a(ijb paramijb)
  {
    paramijb.c("TransInfoCreate.CreateSession", new int[] { 1 });
    paramijb.c("TransInfo.JoinSession", new int[] { 0 });
    paramijb.c("TransInfo.ExitSession", new int[] { 0 });
    paramijb.c("TransInfo.ChangeSession", new int[] { 0 });
    paramijb.c("TransInfo.RawData", new int[] { 0 });
    paramijb.c("OidbSvc.0xa75", new int[] { 2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ijk
 * JD-Core Version:    0.7.0.1
 */