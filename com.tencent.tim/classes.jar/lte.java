import android.content.res.Resources;
import android.text.SpannableString;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeAwesomeCommentView;
import com.tencent.image.URLDrawable.DownloadListener;

public class lte
  implements URLDrawable.DownloadListener
{
  public lte(NativeAwesomeCommentView paramNativeAwesomeCommentView, SpannableString paramSpannableString) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    soe localsoe = new soe(this.b.getResources().getDrawable(2130843570));
    this.c.setSpan(localsoe, 0, 1, 17);
    NativeAwesomeCommentView.a(this.b).setText(this.c);
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lte
 * JD-Core Version:    0.7.0.1
 */