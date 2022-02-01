package com.tencent.ark;

class ArkViewModelBase$21
  implements Runnable
{
  ArkViewModelBase$21(ArkViewModelBase paramArkViewModelBase, ArkViewImplement paramArkViewImplement) {}
  
  public void run()
  {
    if (this.val$viewImpl != null) {
      this.val$viewImpl.onFirstPaint();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.ark.ArkViewModelBase.21
 * JD-Core Version:    0.7.0.1
 */