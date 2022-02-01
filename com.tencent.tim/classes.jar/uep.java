import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.vas.PobingDecoder.a;
import java.util.HashMap;

public class uep
  implements ajdq<PobingDecoder.a>
{
  public uep(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void a(PobingDecoder.a parama)
  {
    if (parama.id == AddFriendVerifyActivity.a(this.this$0).uG())
    {
      Object localObject = (Bitmap)parama.pg.get(Integer.valueOf(2131381519));
      AddFriendVerifyActivity.b(this.this$0).setVisibility(0);
      AddFriendVerifyActivity.b(this.this$0).setBackgroundDrawable(new BitmapDrawable(this.this$0.getResources(), (Bitmap)localObject));
      localObject = (Bitmap)parama.pg.get(Integer.valueOf(2131381514));
      localObject = aqsr.a(this.this$0.getResources(), (Bitmap)localObject);
      AddFriendVerifyActivity.a(this.this$0).setBackgroundDrawable((Drawable)localObject);
      AddFriendVerifyActivity.b(this.this$0).setTextColor(parama.textColor);
      AddFriendVerifyActivity.a(this.this$0).setTextColor(parama.textColor);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uep
 * JD-Core Version:    0.7.0.1
 */