package com.tencent.tbs.reader;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

public class TbsReaderCore
{
  public static final String TAG = "TbsReaderCore";
  protected ITbsReader.IReaderCore mReaderCore = null;
  
  public TbsReaderCore(Context paramContext, ITbsReader paramITbsReader)
  {
    if (paramITbsReader != null) {
      this.mReaderCore = paramITbsReader.getReaderCore();
    }
  }
  
  public void closeFile()
  {
    if (this.mReaderCore != null) {
      this.mReaderCore.closeFile();
    }
  }
  
  public void destroy()
  {
    closeFile();
    if (this.mReaderCore != null) {
      this.mReaderCore.destroy();
    }
    this.mReaderCore = null;
  }
  
  public boolean init(Context paramContext)
  {
    if (this.mReaderCore != null) {
      return this.mReaderCore.init(paramContext);
    }
    return false;
  }
  
  public void onSizeChanged(Integer paramInteger1, Integer paramInteger2)
  {
    if (this.mReaderCore != null) {
      this.mReaderCore.onSizeChanged(paramInteger1, paramInteger2);
    }
  }
  
  public int openFile(Context paramContext, Bundle paramBundle, FrameLayout paramFrameLayout, View paramView)
  {
    if ((this.mReaderCore == null) || (paramBundle == null))
    {
      Log.e("TbsReaderCore", "init failed!");
      return -1;
    }
    int j = this.mReaderCore.openFile(paramContext, paramBundle, paramFrameLayout, paramView);
    int i = 1100;
    if (j != 0)
    {
      Log.e("TbsReaderCore", "OpenFile failed!");
      i = 1101;
    }
    ReaderEngine.getInstance().report(i, "ViewOpenFile:" + j, null);
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.reader.TbsReaderCore
 * JD-Core Version:    0.7.0.1
 */