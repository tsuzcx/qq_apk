package android.support.v7.app;

class AppCompatDelegateImplV9$1
  implements Runnable
{
  AppCompatDelegateImplV9$1(AppCompatDelegateImplV9 paramAppCompatDelegateImplV9) {}
  
  public void run()
  {
    if ((this.this$0.mInvalidatePanelMenuFeatures & 0x1) != 0) {
      this.this$0.doInvalidatePanelMenu(0);
    }
    if ((this.this$0.mInvalidatePanelMenuFeatures & 0x1000) != 0) {
      this.this$0.doInvalidatePanelMenu(108);
    }
    this.this$0.mInvalidatePanelMenuPosted = false;
    this.this$0.mInvalidatePanelMenuFeatures = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplV9.1
 * JD-Core Version:    0.7.0.1
 */