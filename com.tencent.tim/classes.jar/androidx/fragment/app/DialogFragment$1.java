package androidx.fragment.app;

class DialogFragment$1
  implements Runnable
{
  DialogFragment$1(DialogFragment paramDialogFragment) {}
  
  public void run()
  {
    if (this.this$0.mDialog != null) {
      this.this$0.onDismiss(this.this$0.mDialog);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.fragment.app.DialogFragment.1
 * JD-Core Version:    0.7.0.1
 */