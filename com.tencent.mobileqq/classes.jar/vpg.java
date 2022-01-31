import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import java.io.File;

public class vpg
  extends voz<vow>
  implements View.OnClickListener
{
  public vpg(Context paramContext)
  {
    super(paramContext);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Voq == null) {
      return paramView;
    }
    if (paramView == null) {}
    for (paramView = new vph(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.getWidth(), ((vow)this.jdField_a_of_type_Voq).a(), ((vow)this.jdField_a_of_type_Voq).a(), this);; paramView = (vph)paramView)
    {
      paramView.a((vow)this.jdField_a_of_type_Voq, paramInt, getCount());
      return paramView;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    ImageView localImageView = (ImageView)paramView;
    int j = ((Integer)localImageView.getTag(2131376873)).intValue();
    vow localvow = (vow)this.jdField_a_of_type_Voq;
    Object localObject3 = Uri.parse(localvow.a(j));
    Object localObject1 = ((Uri)localObject3).getPath();
    String str = new File((String)localObject1).getName();
    try
    {
      localObject1 = Drawable.createFromPath((String)localObject1);
      if (localObject1 != null)
      {
        ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
        try
        {
          j = ((RelativeLayout.LayoutParams)((ListView)paramView.getParent().getParent()).getLayoutParams()).leftMargin;
          i = j;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            float f2;
            float f3;
            float f4;
            float f5;
            int k;
            Object localObject2;
            ved.c("NormalFaceAdapter", "get marginLeft error : %s", localException);
            continue;
            float f1 = (i - (k + (i - j) / 2) * 2) / i;
          }
        }
        localObject3 = (vph)paramView.getParent();
        j = (int)vkk.b((View)localObject3);
        f2 = vkk.a(paramView);
        f3 = paramView.getWidth() / 2;
        f4 = i;
        f5 = ((vph)localObject3).getHeight() / 2 + j;
        i = ((Drawable)localObject1).getIntrinsicWidth();
        j = localImageView.getWidth();
        k = localImageView.getPaddingLeft();
        if (j > i)
        {
          f1 = (((j - i) / 2 - k) * 2 + i) / i;
          paramView = new vlo(localvow.b, str, (Drawable)localObject1);
          this.jdField_a_of_type_Vos.a(paramView, f4 + (f2 + f3), f5, f1 * 1.2F);
          return;
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        ved.c("NormalFaceAdapter", "createFromPath error", localOutOfMemoryError);
        localObject2 = null;
      }
      ved.e("NormalFaceAdapter", "can create drawable from uri:" + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vpg
 * JD-Core Version:    0.7.0.1
 */