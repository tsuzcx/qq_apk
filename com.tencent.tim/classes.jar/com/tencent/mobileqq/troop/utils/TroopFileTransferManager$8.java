package com.tencent.mobileqq.troop.utils;

import apbr;
import java.util.Map;
import java.util.UUID;

class TroopFileTransferManager$8
  implements Runnable
{
  TroopFileTransferManager$8(TroopFileTransferManager paramTroopFileTransferManager, UUID paramUUID, apbr paramapbr, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    this.this$0.dYP();
    TroopFileTransferManager.Item localItem2 = (TroopFileTransferManager.Item)this.this$0.nC.get(this.b);
    TroopFileTransferManager.Item localItem1 = localItem2;
    if (localItem2 == null)
    {
      localItem1 = new TroopFileTransferManager.Item(this.f);
      this.this$0.a(localItem1);
    }
    this.this$0.c(localItem1, this.dVH, this.val$fileType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.8
 * JD-Core Version:    0.7.0.1
 */