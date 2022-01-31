import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppItemBubbleBuilder.Holder;
import com.tencent.mobileqq.ark.ArkAppCenter.OnGetAppIcon;

public class uun
  implements ArkAppCenter.OnGetAppIcon
{
  public uun(ArkAppItemBubbleBuilder.Holder paramHolder1, ArkAppItemBubbleBuilder.Holder paramHolder2) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.b.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uun
 * JD-Core Version:    0.7.0.1
 */