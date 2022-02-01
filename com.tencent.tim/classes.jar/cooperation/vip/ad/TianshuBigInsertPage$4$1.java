package cooperation.vip.ad;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import aqnm;
import avor;
import awkm;
import awkn;
import awkr;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess.AdItem;

public class TianshuBigInsertPage$4$1
  implements Runnable
{
  public TianshuBigInsertPage$4$1(awkr paramawkr, PreloadManager.PathResult paramPathResult) {}
  
  public void run()
  {
    QLog.d("TianshuBigInsertPage", 2, "show insert page...");
    avor.bI(awkn.a(this.a.b));
    awkn.a(this.a.b).addView(awkn.a(this.a.b));
    Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
    localObject1 = URLDrawable.getFileDrawable(this.val$pathRes.filePath, (URLDrawable.URLDrawableOptions)localObject1);
    try
    {
      Object localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(this.val$pathRes.filePath, (BitmapFactory.Options)localObject2);
      QLog.d("TianshuBigInsertPage", 2, "bitmap w: " + ((BitmapFactory.Options)localObject2).outWidth + ", h: " + ((BitmapFactory.Options)localObject2).outHeight);
      int i = aqnm.getScreenWidth();
      i = (int)(((BitmapFactory.Options)localObject2).outHeight * 1.0F / ((BitmapFactory.Options)localObject2).outWidth * i);
      if (i > 0)
      {
        QLog.d("TianshuBigInsertPage", 2, "calc height: " + i);
        localObject2 = awkn.a(this.a.b).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).height = i;
        awkn.a(this.a.b).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
    awkn.a(this.a.b).setBackgroundDrawable((Drawable)localObject1);
    awkn.ji(awkn.b(this.a.b));
    if ((awkn.a(this.a.b) != null) && (awkn.a(this.a.b).a() != null) && (awkn.a(this.a.b).a().app != null) && (awkn.a(this.a.b) != null)) {
      awkm.d(awkn.a(this.a.b).a().app, 101, String.valueOf(awkn.a(this.a.b).iAdId.get()), awkn.a(this.a.b).traceinfo.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.vip.ad.TianshuBigInsertPage.4.1
 * JD-Core Version:    0.7.0.1
 */