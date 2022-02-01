import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

public class let
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public let(ReadInJoySelfFragment paramReadInJoySelfFragment, ImageView paramImageView, kgj paramkgj) {}
  
  public void onGlobalLayout()
  {
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 16)
        {
          ReadInJoySelfFragment.a(this.this$0).getViewTreeObserver().removeOnGlobalLayoutListener(this);
          int j = ReadInJoySelfFragment.a(this.this$0).getWidth();
          if (ReadInJoySelfFragment.b(this.this$0))
          {
            i = (int)(this.this$0.jl + this.this$0.jn + this.this$0.jm);
            if (i <= 0) {
              break;
            }
            double d1 = this.a.mPicWidth / this.a.mPicHeight;
            double d2 = this.this$0.jo;
            i = (int)(j - i - d1 * d2);
            if (i <= 0) {
              break;
            }
            Drawable localDrawable = DrawableUtil.getDrawable(this.this$0.getActivity(), this.a.Zb, null, null);
            if (localDrawable == null) {
              break;
            }
            ReadInJoySelfFragment.a(this.this$0).setMaxWidth(i);
            this.this$0.r.setImageDrawable(localDrawable);
            this.this$0.r.setTag(this.a);
            this.this$0.r.setOnClickListener(this.this$0);
            if (this.this$0.ajM) {
              break;
            }
            kxm.a(this.a);
            this.this$0.ajM = true;
          }
        }
        else
        {
          ReadInJoySelfFragment.a(this.this$0).getViewTreeObserver().removeGlobalOnLayoutListener(this);
          continue;
        }
        f1 = this.iR.getWidth();
      }
      catch (Exception localException)
      {
        QLog.d("Q.readinjoy.self.SelfFragment", 1, "showMedal! error, msg=" + localException);
        return;
      }
      float f1;
      float f2 = this.this$0.jl;
      float f3 = this.this$0.jm;
      float f4 = this.this$0.jn;
      int i = (int)(f1 + f2 + f3 + f4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     let
 * JD-Core Version:    0.7.0.1
 */