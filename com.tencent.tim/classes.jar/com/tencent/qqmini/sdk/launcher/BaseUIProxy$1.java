package com.tencent.qqmini.sdk.launcher;

class BaseUIProxy$1
  implements BaseRuntimeLoader.OnAppRuntimeLoadListener
{
  BaseUIProxy$1(BaseUIProxy paramBaseUIProxy) {}
  
  public void onResult(int paramInt, String paramString, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    if ((paramInt == 0) && (paramBaseRuntimeLoader != null))
    {
      if (paramBaseRuntimeLoader == this.this$0.mCurrRuntimeLoader) {
        this.this$0.onRuntimeReady();
      }
      return;
    }
    this.this$0.onRuntimeFail(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.BaseUIProxy.1
 * JD-Core Version:    0.7.0.1
 */