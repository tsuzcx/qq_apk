package com.tencent.upload.network.route;

public class OtherRouteStrategy
  extends AbstractRouteStrategy
{
  public int getServerCategory()
  {
    return 1;
  }
  
  public UploadRoute[] next(UploadRoute paramUploadRoute, int paramInt)
  {
    return super.next(paramUploadRoute, paramInt);
  }
  
  public UploadRoute[] reset()
  {
    return super.reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.upload.network.route.OtherRouteStrategy
 * JD-Core Version:    0.7.0.1
 */