package com.facebook.stetho.inspector.elements.android;

import com.facebook.stetho.inspector.elements.DocumentProviderListener;

class AndroidDocumentProvider$1
  implements Runnable
{
  AndroidDocumentProvider$1(AndroidDocumentProvider paramAndroidDocumentProvider) {}
  
  public void run()
  {
    AndroidDocumentProvider.access$002(this.this$0, false);
    if (AndroidDocumentProvider.access$100(this.this$0) != null)
    {
      AndroidDocumentProvider.access$100(this.this$0).onPossiblyChanged();
      AndroidDocumentProvider.access$002(this.this$0, true);
      this.this$0.postDelayed(this, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.elements.android.AndroidDocumentProvider.1
 * JD-Core Version:    0.7.0.1
 */