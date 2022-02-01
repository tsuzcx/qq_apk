package android.support.v4.app;

import android.view.View;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;

public class FragmentEx
  extends ReportV4Fragment
{
  public View getContentView()
  {
    return this.mInnerView;
  }
  
  public boolean isActive()
  {
    return getView() != null;
  }
  
  void performDestroy()
  {
    super.performDestroy();
    this.mChildFragmentManager = null;
  }
  
  void performDestroyView()
  {
    this.mCalled = false;
    onDestroyView();
    if (!this.mCalled) {
      throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
    }
    if (this.mLoaderManager != null) {
      this.mLoaderManager.doReportNextStart();
    }
  }
  
  class DestoryView
    implements Runnable
  {
    private DestoryView() {}
    
    public void run()
    {
      if (FragmentEx.this.mChildFragmentManager != null) {
        FragmentEx.this.mChildFragmentManager.dispatchDestroyView();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentEx
 * JD-Core Version:    0.7.0.1
 */