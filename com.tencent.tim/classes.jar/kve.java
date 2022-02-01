import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ImageCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class kve
  extends ImageBase
{
  private static Drawable cv = new BitmapDrawable(BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130842559));
  private ReadInJoyHeadImageView e;
  private Long i;
  
  public kve(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.e = new ReadInJoyHeadImageView(paramVafContext.getContext());
  }
  
  public int getComMeasuredHeight()
  {
    return this.e.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.e.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.e;
  }
  
  public void loadImage(String paramString)
  {
    QLog.d("", 2, "loadImage: path is " + paramString);
    if ((paramString != null) && (!paramString.equals("-1")))
    {
      if ((!paramString.startsWith("http")) && (!paramString.startsWith("pubaccount"))) {
        break label76;
      }
      this.e.setImagePlaceHolder(cv);
      this.e.setImageSrc(paramString);
    }
    label76:
    do
    {
      return;
      paramString = ImageCommon.getDrawableResourceId(paramString);
    } while (paramString == null);
    QLog.d("", 2, "loadImage: cant find in offline dir, try to load from resources");
    try
    {
      paramString = this.e.getResources().getDrawable(paramString.intValue());
      this.e.setImageDrawable(paramString);
      return;
    }
    catch (Resources.NotFoundException paramString)
    {
      QLog.d("", 2, "loadImage: cant find in resources dir, do nothing");
    }
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.e.onComLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.e.onComMeasure(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    if (this.i != null) {
      this.e.setHeadImgByUin(this.i.longValue(), true);
    }
    for (;;)
    {
      refresh();
      return;
      loadImage(this.mSrc);
    }
  }
  
  public void reset()
  {
    super.reset();
    this.e.setImageSrc(null);
    this.mSrc = null;
  }
  
  public boolean setAttribute(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return super.setAttribute(paramInt, paramString);
    case 1075: 
      try
      {
        this.i = Long.valueOf(Long.parseLong(paramString));
        return true;
      }
      catch (Exception paramString)
      {
        QLog.e("", 1, "", paramString);
        return true;
      }
    }
    this.mSrc = paramString;
    return true;
  }
  
  public void setBitmap(Bitmap paramBitmap, boolean paramBoolean)
  {
    this.e.setImageBitmap(paramBitmap);
  }
  
  public static class a
    implements ViewBase.IBuilder
  {
    public ViewBase build(VafContext paramVafContext)
    {
      return new kve(paramVafContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kve
 * JD-Core Version:    0.7.0.1
 */