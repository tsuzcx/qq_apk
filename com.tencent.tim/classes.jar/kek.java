import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcshopWebActivity;
import com.tencent.biz.pubaccount.ecshopassit.RecentShopParcel;
import com.tencent.biz.pubaccount.ecshopassit.ShopWebViewFragment;
import java.util.Iterator;
import java.util.List;

public class kek
  extends BroadcastReceiver
{
  public kek(ShopWebViewFragment paramShopWebViewFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      Object localObject;
      do
      {
        do
        {
          return;
          paramContext = paramIntent.getAction();
          localObject = paramIntent.getStringExtra("uin");
          Bitmap localBitmap = (Bitmap)paramIntent.getParcelableExtra("bitmap");
          if (!"action_decode_finish".equals(paramContext)) {
            break;
          }
          if ((this.b.a != null) && (!TextUtils.isEmpty((CharSequence)localObject)) && (localBitmap != null)) {
            this.b.a.j((String)localObject, localBitmap);
          }
        } while (this.b.b == null);
        this.b.b.lX((String)localObject);
        return;
      } while (!"action_on_shop_msg_receive".equals(paramContext));
      this.b.gb = paramIntent.getParcelableArrayListExtra("datas");
      paramContext = this.b.getActivity();
      if ((paramContext instanceof EcshopWebActivity)) {
        ((EcshopWebActivity)paramContext).gb = this.b.gb;
      }
      paramContext = paramIntent.getStringExtra("uin");
      paramIntent = this.b.gb.iterator();
      while (paramIntent.hasNext())
      {
        localObject = (RecentShopParcel)paramIntent.next();
        if ((!TextUtils.isEmpty(((RecentShopParcel)localObject).puin)) && (((RecentShopParcel)localObject).puin.equals(paramContext))) {
          ((RecentShopParcel)localObject).unReadNum += 1;
        }
      }
    } while ((this.b.mCurrentIndex != 1) || (this.b.b == null));
    this.b.b.bJ(this.b.gb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kek
 * JD-Core Version:    0.7.0.1
 */