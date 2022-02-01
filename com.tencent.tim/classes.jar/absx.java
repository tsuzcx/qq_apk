import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil.c;

public class absx
  implements DialogInterface.OnClickListener
{
  public absx(ApolloGameActivity paramApolloGameActivity, Intent paramIntent, String paramString, Bitmap paramBitmap, ApolloGameUtil.c paramc, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ApolloGameUtil.a(this.T, this.val$name, this.bZ, new absy(this));
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     absx
 * JD-Core Version:    0.7.0.1
 */