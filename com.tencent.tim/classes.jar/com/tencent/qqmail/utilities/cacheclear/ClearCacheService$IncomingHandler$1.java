package com.tencent.qqmail.utilities.cacheclear;

import java.util.ArrayList;

class ClearCacheService$IncomingHandler$1
  implements QMClearCacheManager.ClearAttachCallback
{
  ClearCacheService$IncomingHandler$1(ClearCacheService.IncomingHandler paramIncomingHandler, ClearCacheService paramClearCacheService) {}
  
  public void onResult(ArrayList<String> paramArrayList)
  {
    ClearCacheService.access$100(this.val$service, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.cacheclear.ClearCacheService.IncomingHandler.1
 * JD-Core Version:    0.7.0.1
 */