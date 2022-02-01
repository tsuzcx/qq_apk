import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;

public class agou
  implements amxy
{
  private TextView Sx;
  private EllipsizingTextView e;
  private View mItemView;
  private ImageView zM;
  
  public agou(ViewGroup paramViewGroup)
  {
    this.mItemView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561048, paramViewGroup, false);
    this.zM = ((ImageView)this.mItemView.findViewById(2131367020));
    this.e = ((EllipsizingTextView)this.mItemView.findViewById(2131367034));
    this.Sx = ((TextView)this.mItemView.findViewById(2131365721));
    this.e.setMaxLines(1);
    this.e.eca();
    this.e.setEllipsize(TextUtils.TruncateAt.MIDDLE);
  }
  
  public TextView N()
  {
    return this.Sx;
  }
  
  public TextView O()
  {
    return null;
  }
  
  public View g(String paramString)
  {
    return null;
  }
  
  public TextView getTitleView()
  {
    return this.e;
  }
  
  public View getView()
  {
    return this.mItemView;
  }
  
  public ImageView v()
  {
    return null;
  }
  
  public ImageView w()
  {
    return this.zM;
  }
  
  public TextView z()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agou
 * JD-Core Version:    0.7.0.1
 */