import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.widget.ImageView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.maxvideo.trim.TrimNative;

public class yng
  extends yrv
{
  private long jdField_a_of_type_Long;
  private MediaMetadataRetriever jdField_a_of_type_AndroidMediaMediaMetadataRetriever;
  private Integer jdField_a_of_type_JavaLangInteger;
  private ynh jdField_a_of_type_Ynh;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  
  public yng(ImageView paramImageView, MediaMetadataRetriever paramMediaMetadataRetriever, Integer paramInteger, int paramInt1, int paramInt2, long paramLong, int paramInt3, boolean paramBoolean1, ynh paramynh, boolean paramBoolean2)
  {
    super(paramImageView);
    this.jdField_a_of_type_JavaLangInteger = paramInteger;
    this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever = paramMediaMetadataRetriever;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_Long = paramLong;
    this.d = paramInt3;
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_Ynh = paramynh;
    this.jdField_c_of_type_Boolean = paramBoolean2;
  }
  
  public String a()
  {
    return String.valueOf(this.jdField_a_of_type_JavaLangInteger);
  }
  
  @TargetApi(10)
  public void a()
  {
    xvv.d("Q.qqstory.frameWidget.FrameLoader", "runOnBackGround:%s", new Object[] { a() });
    long l3 = System.currentTimeMillis();
    if ((UIUtils.trimNativeIsReady()) && (this.jdField_c_of_type_Boolean)) {
      xvv.d("Q.qqstory.frameWidget.FrameLoader", "runOnBackGround: TrimNative:%s", new Object[] { a() });
    }
    long l1;
    Object localObject;
    Bitmap localBitmap2;
    for (;;)
    {
      try
      {
        Bitmap localBitmap1;
        if (this.jdField_b_of_type_Boolean)
        {
          localBitmap1 = Bitmap.createBitmap(this.jdField_c_of_type_Int, this.jdField_b_of_type_Int, Bitmap.Config.ARGB_8888);
          l1 = this.jdField_a_of_type_JavaLangInteger.intValue() * this.d;
          long l2 = (this.jdField_a_of_type_JavaLangInteger.intValue() + 1) * this.d;
          l1 = l2;
          if (l2 > this.jdField_a_of_type_Long) {
            l1 = this.jdField_a_of_type_Long;
          }
          if (TrimNative.getThumbnail(0L, l1, localBitmap1) == 0)
          {
            Bitmap localBitmap3 = localBitmap1.copy(Bitmap.Config.RGB_565, true);
            localObject = localBitmap3;
            if (this.jdField_b_of_type_Boolean) {
              localObject = UIUtils.rotateBitmap(localBitmap3, 90.0F);
            }
            a(new BitmapDrawable((Bitmap)localObject));
            localBitmap1.recycle();
            l1 = System.currentTimeMillis() - l3;
            xvv.d("Q.qqstory.frameWidget.FrameLoader", "runOnBackGround: TrimNative 完成时间:%s,key=%s", new Object[] { Long.valueOf(l1), a() });
            this.jdField_a_of_type_Ynh.a(this.jdField_a_of_type_JavaLangInteger.intValue(), l1);
          }
        }
        else
        {
          localBitmap1 = Bitmap.createBitmap(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, Bitmap.Config.ARGB_8888);
          continue;
        }
        if ((localBitmap1 == null) || (localBitmap1.isRecycled())) {
          continue;
        }
        localBitmap1.recycle();
      }
      catch (Exception localException)
      {
        xvv.e("Q.qqstory.frameWidget.FrameLoader", "create bitmap width=%s,height=%s,error:%s", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int), localException });
        continue;
        localBitmap2 = this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever.getFrameAtTime(this.jdField_a_of_type_JavaLangInteger.intValue() * this.d * 1000L);
        if (localBitmap2 != null) {
          continue;
        }
        xvv.e("Q.qqstory.frameWidget.FrameLoader", "mRetriever return null!");
        return;
        localObject = new Matrix();
        if (!this.jdField_b_of_type_Boolean) {
          break;
        }
      }
      if (this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever == null)
      {
        xvv.e("Q.qqstory.frameWidget.FrameLoader", "mRetriever is null!");
        return;
        xvv.e("Q.qqstory.frameWidget.FrameLoader", "TrimNative return error!");
      }
      else
      {
        float f1 = this.jdField_b_of_type_Int / localBitmap2.getHeight();
        float f2 = this.jdField_c_of_type_Int / localBitmap2.getWidth();
        ((Matrix)localObject).postRotate(90.0F);
        ((Matrix)localObject).postScale(f1, f2);
      }
    }
    for (;;)
    {
      localObject = Bitmap.createBitmap(localBitmap2, 0, 0, localBitmap2.getWidth(), localBitmap2.getHeight(), (Matrix)localObject, true);
      localBitmap2.recycle();
      a(new BitmapDrawable((Bitmap)localObject));
      l1 = System.currentTimeMillis() - l3;
      xvv.d("Q.qqstory.frameWidget.FrameLoader", "runOnBackGround: mRetriever 完成时间:%s,key=%s", new Object[] { Long.valueOf(l1), a() });
      this.jdField_a_of_type_Ynh.a(this.jdField_a_of_type_JavaLangInteger.intValue(), l1);
      return;
      ((Matrix)localObject).postScale(this.jdField_b_of_type_Int / localBitmap2.getWidth(), this.jdField_c_of_type_Int / localBitmap2.getHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yng
 * JD-Core Version:    0.7.0.1
 */