package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import aqdf;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StShare;
import feedcloud.FeedCloudMeta.StUser;
import java.util.Map;
import jqc;
import ovz;
import oxh;
import oxk;

public class QCircleSharePart$4
  implements Runnable
{
  public QCircleSharePart$4(oxh paramoxh, Map paramMap, Runnable paramRunnable) {}
  
  private void q(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      Bitmap localBitmap = paramBitmap;
      if (i * j > 8000)
      {
        double d = Math.sqrt(8000.0D / (i * j));
        localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(i * d), (int)(d * j), true);
        if (oxh.a(this.this$0).type != 1) {
          paramBitmap.recycle();
        }
      }
      this.eI.put("image", localBitmap);
      if (this.this$0.getActivity() != null) {
        this.this$0.getActivity().runOnUiThread(this.cY);
      }
    }
  }
  
  public void run()
  {
    try
    {
      if (oxh.a(this.this$0) == null) {
        return;
      }
      if (oxh.a(this.this$0).type == 1)
      {
        QLog.d("QCircleSharePart", 1, "shareToWeChat share user icon");
        aqdf localaqdf = new aqdf(this.this$0.getActivity(), (AppInterface)BaseApplicationImpl.getApplication().getRuntime());
        localBitmap = localaqdf.a(1, oxh.a(this.this$0).feed.poster.id.get(), 1, (byte)1);
        if (localBitmap == null)
        {
          QLog.d("QCircleSharePart", 1, "shareToWeChat share user icon(need decode task)");
          localaqdf.a(new oxk(this, localaqdf));
          localaqdf.a(oxh.a(this.this$0).feed.poster.id.get(), 200, false, 1, true, (byte)1, 1);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      Bitmap localBitmap;
      QLog.e("QCircleSharePart", 1, "shareToWeChat  Exception : " + localException.getMessage());
      return;
      QLog.d("QCircleSharePart", 1, "shareToWeChat share user icon(have cache)");
      q(localBitmap);
      localException.destory();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("QCircleSharePart", 1, "shareToWeChat  OutOfMemoryError : " + localOutOfMemoryError.getMessage());
      return;
    }
    QLog.d("QCircleSharePart", 1, "shareToWeChat share url icon");
    byte[] arrayOfByte = jqc.a(BaseApplicationImpl.getContext(), oxh.a(this.this$0).feed.share.cover.picUrl.get(), "GET", null, null);
    if (arrayOfByte != null) {
      q(BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleSharePart.4
 * JD-Core Version:    0.7.0.1
 */