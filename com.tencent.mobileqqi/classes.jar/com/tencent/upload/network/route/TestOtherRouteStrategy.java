package com.tencent.upload.network.route;

import com.tencent.upload.uinterface.Utility.TestServerCategory;

public class TestOtherRouteStrategy
  implements IUploadRouteStrategy
{
  private final int TEST_SERVER;
  
  public TestOtherRouteStrategy(int paramInt)
  {
    this.TEST_SERVER = paramInt;
  }
  
  public boolean causedByApnChanged()
  {
    return false;
  }
  
  public int getServerCategory()
  {
    return 1;
  }
  
  public String getUsedRoutesDescription()
  {
    return "";
  }
  
  public UploadRoute[] next(UploadRoute paramUploadRoute, int paramInt)
  {
    return null;
  }
  
  public UploadRoute[] reset()
  {
    return new UploadRoute[] { Utility.TestServerCategory.getTestRoute(getServerCategory(), this.TEST_SERVER) };
  }
  
  public boolean save(UploadRoute paramUploadRoute)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.upload.network.route.TestOtherRouteStrategy
 * JD-Core Version:    0.7.0.1
 */