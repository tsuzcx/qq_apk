import com.tencent.mobileqq.tribe.fragment.TribeVideoPreviewFragment;
import mqq.app.QQPermissionCallback;

class aore
  implements QQPermissionCallback
{
  aore(aord paramaord) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    TribeVideoPreviewFragment.a(this.a.this$0, false);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.this$0.Se(this.a.val$path);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aore
 * JD-Core Version:    0.7.0.1
 */