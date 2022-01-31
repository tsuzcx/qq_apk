import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import java.util.HashMap;

public class zxw
  implements arok<banz>
{
  public zxw(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void a(banz parambanz)
  {
    if (parambanz.jdField_a_of_type_Int == AddFriendVerifyActivity.a(this.a).a())
    {
      Object localObject = (Bitmap)parambanz.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2131313035));
      AddFriendVerifyActivity.b(this.a).setVisibility(0);
      AddFriendVerifyActivity.b(this.a).setBackgroundDrawable(new BitmapDrawable(this.a.getResources(), (Bitmap)localObject));
      localObject = (Bitmap)parambanz.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2131313030));
      localObject = baqu.a(this.a.getResources(), (Bitmap)localObject);
      AddFriendVerifyActivity.a(this.a).setBackgroundDrawable((Drawable)localObject);
      AddFriendVerifyActivity.b(this.a).setTextColor(parambanz.b);
      AddFriendVerifyActivity.a(this.a).setTextColor(parambanz.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     zxw
 * JD-Core Version:    0.7.0.1
 */