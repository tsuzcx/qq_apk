import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.transfile.FileDownloadFailedException;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import mqq.app.AccountNotMatchException;

public class aoly
  extends aolf
{
  BaseApplicationImpl a;
  private float mDensity = 2.0F;
  
  public aoly(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.a = paramBaseApplicationImpl;
    try
    {
      this.mDensity = paramBaseApplicationImpl.getResources().getDisplayMetrics().density;
      return;
    }
    catch (Exception paramBaseApplicationImpl) {}
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws IOException
  {
    Object localObject1 = paramDownloadParams.url;
    String str = "http://" + ((URL)localObject1).getAuthority() + "/" + ((URL)localObject1).getFile();
    try
    {
      localObject1 = (MessageForText)paramDownloadParams.tag;
    }
    catch (Exception localException)
    {
      try
      {
        for (;;)
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)this.a.getAppRuntime(((MessageForText)localObject1).selfuin);
          if ((localObject1 != null) && (localQQAppInterface != null)) {
            break;
          }
          throw new FileDownloadFailedException(9366, 0L, "textMsg=" + localObject1 + " app=" + localQQAppInterface, false, false);
          localException = localException;
          localException.printStackTrace();
          localObject2 = null;
        }
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        Object localObject2;
        for (;;)
        {
          localaooi = null;
        }
        aooi localaooi = localaooi.a();
        aool localaool = new aool();
        localaool.mFileType = 131076;
        localaool.mUniseq = localObject2.uniseq;
        localaool.mSelfUin = localObject2.selfuin;
        localaool.mPeerUin = localObject2.frienduin;
        localaool.cmo = str;
        localaool.mOut = paramOutputStream;
        paramOutputStream = new aool.c();
        paramOutputStream.a = paramURLDrawableHandler;
        paramOutputStream.dQO = ((int)paramDownloadParams.downloaded);
        localaool.en = paramOutputStream;
        paramOutputStream = localaooi.a(localaool);
        if (paramOutputStream.mResult == 0) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0)
          {
            if (paramOutputStream.aqr != 9037L) {
              break;
            }
            paramURLDrawableHandler.doCancel();
          }
          return null;
        }
        throw new FileDownloadFailedException((int)paramOutputStream.aqr, 0L, paramOutputStream.clO, false, false);
      }
    }
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    paramDownloadParams = null;
    paramURLDrawableHandler = BitmapFactory.decodeFile(paramFile.getAbsolutePath(), null);
    if (paramURLDrawableHandler == null) {
      paramFile = paramDownloadParams;
    }
    do
    {
      do
      {
        return paramFile;
        int i = paramURLDrawableHandler.getWidth();
        int j = paramURLDrawableHandler.getHeight();
        paramDownloadParams = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        paramDownloadParams.setDensity(160);
        paramFile = new Canvas(paramDownloadParams);
        Paint localPaint = new Paint(1);
        localPaint.setColor(-16777216);
        Rect localRect = new Rect(0, 0, i, j);
        RectF localRectF = new RectF(localRect);
        float f = 11.0F * this.mDensity;
        paramFile.drawRoundRect(localRectF, f, f, localPaint);
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        paramFile.drawBitmap(paramURLDrawableHandler, localRect, localRect, localPaint);
        paramFile = paramDownloadParams;
      } while (paramURLDrawableHandler == null);
      paramFile = paramDownloadParams;
    } while (paramURLDrawableHandler.isRecycled());
    paramURLDrawableHandler.recycle();
    return paramDownloadParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoly
 * JD-Core Version:    0.7.0.1
 */