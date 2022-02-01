import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.GifDrawable;
import com.tencent.image.NativeGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.File;
import java.net.URL;

public class akyg
{
  xah.a b;
  ChatThumbView d;
  MessageForPic k;
  int[] kK;
  
  private akyg(akyg.a parama)
  {
    this.k = parama.k;
    this.d = parama.d;
    this.kK = parama.kK;
    this.b = parama.b;
  }
  
  private URLDrawable a(File paramFile)
  {
    Resources localResources = BaseApplication.getContext().getResources();
    int i3 = localResources.getDisplayMetrics().densityDpi;
    float f1 = i3 / 160.0F;
    URL localURL = this.b.url;
    boolean bool1 = this.b.bgH;
    boolean bool2 = avfp.ns(this.k.imageType);
    if (bool1) {}
    label453:
    label710:
    for (;;)
    {
      int n;
      int i1;
      int i2;
      try
      {
        Rect localRect = NativeGifImage.getImageSize(paramFile, false);
        if (localRect == null) {
          break label453;
        }
        j = localRect.width();
        i = localRect.height();
        m = this.k.getThumbWidthHeightDP(bool2).mMinWidth;
        n = this.k.getThumbWidthHeightDP(bool2).mMinHeight;
        i1 = this.k.getThumbWidthHeightDP(bool2).mMaxWidth;
        i2 = this.k.getThumbWidthHeightDP(bool2).mMaxHeight;
        f1 *= 6.0F;
        if ((j >= m) && (i >= n)) {
          break label607;
        }
        if (j >= i) {
          break label554;
        }
        f2 = m / j;
        j = (int)(i * f2 + 0.5F);
        i = j;
        if (j > i2) {
          i = i2;
        }
        j = m;
        f1 = f2 * f1;
        j = (j * i3 + 80) / 160;
        i = (i * i3 + 80) / 160;
        if (localRect == null) {
          break label779;
        }
        if (localRect.width() >= j) {
          break label710;
        }
        f1 *= localRect.width() / j;
        if (QLog.isColorLevel()) {
          QLog.d("AIOPicDrawableObject", 2, "getThumbDrawable,roundCornor:" + f1 + "  w:" + j + " h:" + i);
        }
        if (this.kK != null)
        {
          this.kK[0] = j;
          this.kK[1] = i;
        }
        paramFile = aoop.am();
        if (!(aoop.am() instanceof SkinnableBitmapDrawable)) {
          break label736;
        }
        paramFile = new afeg(localResources, ((SkinnableBitmapDrawable)aoop.am()).getBitmap(), j, i, -921103);
        paramFile = aoop.getDrawable(localURL, j, i, paramFile, aoop.getFailedDrawable(), true, f1);
        paramFile.setProgressDrawable(new argt(aoop.aj(), 0, false));
        paramFile.setIgnorePause(true);
        paramFile.setFadeInImage(true);
        if (this.d != null) {
          this.d.flag = true;
        }
        return paramFile;
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
      }
      Object localObject = null;
      continue;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      try
      {
        aqhu.d(paramFile.getAbsolutePath(), localOptions);
        j = localOptions.outWidth;
        i = localOptions.outHeight;
        m = aoop.eI(paramFile.getAbsolutePath());
        if ((m != 90) && (m != 270)) {
          continue;
        }
        j = localOptions.outHeight;
        i = localOptions.outWidth;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AIOPicDrawableObject", 2, "getThumbDrawable", localThrowable2);
          }
        }
      }
      float f2 = n / i;
      int j = (int)(j * f2 + 0.5F);
      int i = j;
      if (j > i1) {
        i = i1;
      }
      j = n;
      int m = i;
      i = j;
      j = m;
      continue;
      label607:
      if ((j >= i1) || (i >= i2))
      {
        if (j > i)
        {
          f2 = i1 / j;
          label639:
          if (j <= i) {
            break label698;
          }
        }
        for (float f3 = n / i;; f3 = m / j)
        {
          f2 = Math.max(f2, f3);
          j = (int)(j * f2 + 0.5F);
          i = (int)(i * f2 + 0.5F);
          break;
          f2 = i2 / i;
          break label639;
        }
        if (localObject.height() < i)
        {
          f1 *= localObject.height() / i;
          continue;
          label736:
          if ((aoop.am() instanceof BitmapDrawable)) {
            paramFile = new afeg(localResources, ((BitmapDrawable)aoop.am()).getBitmap(), j, i, -921103);
          } else {}
        }
      }
    }
  }
  
  private URLDrawable d()
  {
    float f = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi / 160.0F;
    URLDrawable localURLDrawable = aoop.getDrawable(this.b.url, 0, 0, null, null, true, 6.0F * f);
    if (this.kK != null)
    {
      this.kK[0] = localURLDrawable.getIntrinsicWidth();
      this.kK[1] = localURLDrawable.getIntrinsicHeight();
    }
    return localURLDrawable;
  }
  
  private URLDrawable e()
  {
    Object localObject = BaseApplication.getContext();
    Resources localResources = ((Context)localObject).getResources();
    int i4 = localResources.getDisplayMetrics().densityDpi;
    URL localURL = this.b.url;
    boolean bool1 = this.b.bgH;
    boolean bool2 = avfp.ns(this.k.imageType);
    int m;
    int j;
    int n;
    int i1;
    int i;
    int i2;
    int i3;
    label190:
    float f1;
    if (!aoop.bD((Context)localObject))
    {
      m = 1;
      j = this.k.getThumbWidthHeightDP(bool2).mMinWidth;
      n = this.k.getThumbWidthHeightDP(bool2).mMinHeight;
      i1 = this.k.getThumbWidthHeightDP(bool2).mMaxWidth;
      i = this.k.getThumbWidthHeightDP(bool2).mMaxHeight;
      i2 = this.k.thumbWidth;
      i3 = this.k.thumbHeight;
      if ((i2 <= 0) || (i3 <= 0)) {
        break label552;
      }
      if ((i2 >= j) && (i3 >= n)) {
        break label448;
      }
      if (i2 >= i3) {
        break label409;
      }
      n = (int)(j / i2 * i3 + 0.5F);
      if (n <= i) {
        break label403;
      }
      f1 = i4 / 160.0F;
      j = (int)(j * f1 + 0.5F);
      i = (int)(i * f1 + 0.5F);
      localObject = null;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = j;
      localURLDrawableOptions.mRequestHeight = i;
      localURLDrawableOptions.mLoadingDrawable = aoop.am();
      localURLDrawableOptions.mFailedDrawable = aoop.getFailedDrawable();
      localURLDrawableOptions.mPlayGifImage = bool1;
      localURLDrawableOptions.mGifRoundCorner = 6.0F;
      localURLDrawableOptions.mImgType = this.k.imageType;
      if (this.kK != null)
      {
        this.kK[0] = j;
        this.kK[1] = i;
      }
      if (!(aoop.am() instanceof SkinnableBitmapDrawable)) {
        break label606;
      }
      localObject = new afeg(localResources, ((SkinnableBitmapDrawable)aoop.am()).getBitmap(), j, i, -921103);
      label339:
      if (localObject != null) {
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      }
      localObject = URLDrawable.getDrawable(localURL, localURLDrawableOptions);
      if ((!akxk.cuU) && (m == 0)) {
        break label646;
      }
      ((URLDrawable)localObject).setAutoDownload(true);
    }
    for (;;)
    {
      ((URLDrawable)localObject).setProgressDrawable(new argt(aoop.aj(), 0, false));
      return localObject;
      m = 0;
      break;
      label403:
      i = n;
      break label190;
      label409:
      j = (int)(n / i3 * i2 + 0.5F);
      i = j;
      if (j > i1) {
        i = i1;
      }
      j = i;
      i = n;
      break label190;
      label448:
      if ((i2 < i1) && (i3 < i))
      {
        i = i3;
        j = i2;
        break label190;
      }
      if (i2 > i3)
      {
        f1 = i1 / i2;
        label486:
        if (i2 <= i3) {
          break label541;
        }
      }
      label541:
      for (float f2 = n / i3;; f2 = j / i2)
      {
        f1 = Math.max(f1, f2);
        j = (int)(i2 * f1 + 0.5F);
        i = (int)(f1 * i3 + 0.5F);
        break;
        f1 = i / i3;
        break label486;
      }
      label552:
      if (QLog.isColorLevel()) {
        QLog.d("AIOPicDrawableObject", 2, "MessageForPic without width/height of thumb, width = " + i2 + ", height = " + i3);
      }
      j = 99;
      i = 99;
      break label190;
      label606:
      if (!(aoop.am() instanceof BitmapDrawable)) {
        break label339;
      }
      localObject = new afeg(localResources, ((BitmapDrawable)aoop.am()).getBitmap(), j, i, -921103);
      break label339;
      label646:
      ((URLDrawable)localObject).setAutoDownload(false);
    }
  }
  
  public URLDrawable f()
  {
    if (this.b == null) {
      this.b = new xah.a(this.k);
    }
    Object localObject = this.b.url.toString();
    if (this.d != null) {
      this.d.flag = false;
    }
    if (BaseApplicationImpl.sImageCache.get(localObject) != null) {
      localObject = d();
    }
    for (;;)
    {
      ((URLDrawable)localObject).setTag(this.k);
      if ((((URLDrawable)localObject).getCurrDrawable() instanceof GifDrawable)) {
        ((GifDrawable)((URLDrawable)localObject).getCurrDrawable()).mutate();
      }
      return localObject;
      localObject = aoiz.getFile((String)localObject);
      if (localObject != null) {
        localObject = a((File)localObject);
      } else {
        localObject = e();
      }
    }
  }
  
  public static final class a
  {
    xah.a b;
    ChatThumbView d;
    MessageForPic k;
    int[] kK;
    
    public a(MessageForPic paramMessageForPic)
    {
      this.k = paramMessageForPic;
    }
    
    public a a(ChatThumbView paramChatThumbView)
    {
      this.d = paramChatThumbView;
      return this;
    }
    
    public a a(xah.a parama)
    {
      this.b = parama;
      return this;
    }
    
    public a a(int[] paramArrayOfInt)
    {
      this.kK = paramArrayOfInt;
      return this;
    }
    
    public akyg a()
    {
      return new akyg(this, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akyg
 * JD-Core Version:    0.7.0.1
 */