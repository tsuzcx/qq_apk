import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.util.List;

public class mlm
  extends auwm<mlu, mlm.a>
{
  public mlm(Context paramContext, List<mlu> paramList)
  {
    super(paramContext, paramList);
  }
  
  public mlm.a a(ViewGroup paramViewGroup, int paramInt)
  {
    ImageView localImageView = new ImageView(this.context);
    paramInt = paramViewGroup.getLayoutParams().height;
    localImageView.setLayoutParams(new ViewGroup.LayoutParams(paramInt, paramInt));
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    return new mlm.a(localImageView);
  }
  
  public void a(mlm.a parama, int paramInt)
  {
    Bitmap localBitmap = ((mlu)getItem(paramInt)).P();
    if (localBitmap != null) {
      ((ImageView)parama.itemView).setImageBitmap(localBitmap);
    }
  }
  
  public int dr(int paramInt)
  {
    return 0;
  }
  
  public class a
    extends auwn<mlu>
  {
    public a(View paramView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mlm
 * JD-Core Version:    0.7.0.1
 */