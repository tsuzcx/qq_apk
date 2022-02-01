import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import java.io.File;

public class afsz
  extends RecyclerView.ViewHolder
  implements View.OnTouchListener
{
  private afwg a;
  private int cUh;
  URLImageView g;
  RelativeLayout layout;
  RecyclerView mRecyclerView;
  TextView text;
  private int type;
  
  public afsz(View paramView, RecyclerView paramRecyclerView, int paramInt1, afwg paramafwg, int paramInt2)
  {
    super(paramView);
    this.mRecyclerView = paramRecyclerView;
    this.type = paramInt2;
    this.layout = ((RelativeLayout)paramView);
    this.g = ((URLImageView)paramView.findViewById(2131368698));
    this.text = ((TextView)paramView.findViewById(2131379401));
    this.cUh = paramInt1;
    this.a = paramafwg;
    paramView.setOnTouchListener(this);
  }
  
  public void a(afsz paramafsz, afua paramafua, int paramInt)
  {
    paramafua = paramafsz.layout.getLayoutParams();
    paramafua.height = (this.mRecyclerView.getHeight() - this.cUh);
    if ((paramafua instanceof RecyclerView.LayoutParams)) {
      ((RecyclerView.LayoutParams)paramafua).topMargin = this.cUh;
    }
    paramafua = URLDrawable.URLDrawableOptions.obtain();
    paramafua.mLoadingDrawable = aoop.TRANSPARENT;
    paramafua.mFailedDrawable = aoop.TRANSPARENT;
    paramafua = afxw.kL("expand_square_blank.png");
    if (new File(paramafua).exists())
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      paramafua = afxw.decodeFile(paramafua, localOptions);
      paramafsz.g.setImageDrawable(new BitmapDrawable(paramafua));
    }
    if (paramInt == 1) {
      if (this.type == 0) {
        paramInt = 2131701110;
      }
    }
    for (;;)
    {
      this.text.setText(paramInt);
      return;
      paramInt = 2131701106;
      continue;
      if (this.type == 0) {
        paramInt = 2131701109;
      } else {
        paramInt = 2131701105;
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.a != null) && (paramMotionEvent.getAction() == 0)) {
      this.a.dcf();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afsz
 * JD-Core Version:    0.7.0.1
 */