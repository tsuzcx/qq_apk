import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class arhq
  implements URLDrawableDownListener
{
  final String mLogTag;
  final WeakReference<View> mRef;
  final String mUrl;
  
  public arhq(View paramView, String paramString1, String paramString2)
  {
    this.mRef = new WeakReference(paramView);
    this.mUrl = paramString1;
    this.mLogTag = paramString2;
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramView = (View)this.mRef.get();
    if (paramView != null)
    {
      QLog.e("Q.profilecard.FrdProfileCard", 1, this.mLogTag + this.mUrl);
      paramView.setVisibility(8);
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = (View)this.mRef.get();
    if (paramView != null) {
      paramView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arhq
 * JD-Core Version:    0.7.0.1
 */