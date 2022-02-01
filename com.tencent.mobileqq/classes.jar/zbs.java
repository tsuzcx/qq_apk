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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;

public class zbs
  extends zbl<zbi>
  implements View.OnClickListener
{
  public zbs(Context paramContext)
  {
    super(paramContext);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Zbc == null)
    {
      localObject = paramView;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
    if (paramView == null) {}
    for (Object localObject = new zbt(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.getWidth(), ((zbi)this.jdField_a_of_type_Zbc).a(), ((zbi)this.jdField_a_of_type_Zbc).a(), this);; localObject = (zbt)paramView)
    {
      ((zbt)localObject).a((zbi)this.jdField_a_of_type_Zbc, paramInt, getCount());
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    ImageView localImageView = (ImageView)paramView;
    int j = ((Integer)localImageView.getTag(2131378270)).intValue();
    zbi localzbi = (zbi)this.jdField_a_of_type_Zbc;
    Object localObject3 = Uri.parse(localzbi.a(j));
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
            yqp.c("NormalFaceAdapter", "get marginLeft error : %s", localException);
            continue;
            float f1 = (i - (k + (i - j) / 2) * 2) / i;
          }
        }
        localObject3 = (zbt)paramView.getParent();
        j = (int)yww.b((View)localObject3);
        f2 = yww.a(paramView);
        f3 = paramView.getWidth() / 2;
        f4 = i;
        f5 = ((zbt)localObject3).getHeight() / 2 + j;
        i = ((Drawable)localObject1).getIntrinsicWidth();
        j = localImageView.getWidth();
        k = localImageView.getPaddingLeft();
        if (j > i)
        {
          f1 = (((j - i) / 2 - k) * 2 + i) / i;
          localObject1 = new yya(localzbi.b, str, (Drawable)localObject1);
          this.jdField_a_of_type_Zbe.a((yya)localObject1, f4 + (f2 + f3), f5, f1 * 1.2F);
          EventCollector.getInstance().onViewClicked(paramView);
          return;
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        yqp.c("NormalFaceAdapter", "createFromPath error", localOutOfMemoryError);
        localObject2 = null;
        continue;
        yqp.e("NormalFaceAdapter", "can create drawable from uri:" + localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zbs
 * JD-Core Version:    0.7.0.1
 */