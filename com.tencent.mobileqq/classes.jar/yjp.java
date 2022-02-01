import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.cover.RecordThumbnailUtils;
import java.io.File;

public class yjp
{
  double jdField_a_of_type_Double;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  double jdField_b_of_type_Double;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean;
  int d;
  int e;
  int f;
  
  public yjp(int paramInt1, int paramInt2, String paramString1, float paramFloat, boolean paramBoolean1, int paramInt3, double paramDouble1, double paramDouble2, String paramString2, int paramInt4, boolean paramBoolean2)
  {
    this.d = paramInt1;
    this.e = paramInt2;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_Double = paramDouble1;
    this.jdField_b_of_type_Double = paramDouble2;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.f = paramInt4;
    this.jdField_c_of_type_Boolean = paramBoolean2;
  }
  
  public yjp(@NonNull Bitmap paramBitmap, @NonNull String paramString, int paramInt1, int paramInt2, int paramInt3, float paramFloat, double paramDouble1, double paramDouble2, int paramInt4)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_Double = paramDouble1;
    this.jdField_b_of_type_Double = paramDouble2;
    this.d = paramInt1;
    this.e = paramInt2;
    this.f = paramInt4;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  private int a()
  {
    int i = 0;
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_JavaLangString == null))
    {
      xvv.e("Q.qqstory.publish.edit.GenerateThumbTask", "saveThumb error. bitmap = null or path = null.");
      i = 1;
    }
    for (;;)
    {
      return i;
      int j;
      if (this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() > this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight()) {
        if (this.jdField_a_of_type_Int < this.jdField_b_of_type_Int)
        {
          j = this.jdField_a_of_type_Int;
          this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
          this.jdField_b_of_type_Int = j;
        }
      }
      Bitmap localBitmap;
      for (;;)
      {
        localBitmap = yoy.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, true);
        if (localBitmap != null) {
          break;
        }
        xvv.e("Q.qqstory.publish.edit.GenerateThumbTask", "saveThumb error. resize thumb bitmap error.");
        return 1;
        if (this.jdField_a_of_type_Int > this.jdField_b_of_type_Int)
        {
          j = this.jdField_a_of_type_Int;
          this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
          this.jdField_b_of_type_Int = j;
        }
      }
      if (!yoy.a(localBitmap, this.jdField_a_of_type_JavaLangString))
      {
        xvv.e("Q.qqstory.publish.edit.GenerateThumbTask", "saveThumb error. compress thumb bitmap to file error.");
        return 1;
      }
      try
      {
        bfvo.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Double, this.jdField_b_of_type_Double);
        if (!new File(this.jdField_a_of_type_JavaLangString).exists())
        {
          xvv.e("Q.qqstory.publish.edit.GenerateThumbTask", "saveThumb, coverFile not exists, vf dir = %s, mThumbPath = %s", new Object[] { this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString });
          return 1;
        }
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        if (this.jdField_a_of_type_JavaLangString == null) {}
      }
    }
    for (boolean bool = new File(this.jdField_a_of_type_JavaLangString).exists();; bool = false)
    {
      xwa.b("video_edit", "update_LBS_exif_failed", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString, String.valueOf(bool) });
      break;
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_Int = 320;
    this.jdField_b_of_type_Int = ((int)(this.jdField_a_of_type_Int / this.jdField_a_of_type_Float));
    if (this.jdField_b_of_type_Int % 2 > 0) {
      this.jdField_b_of_type_Int -= 1;
    }
    if (this.d > 0) {
      this.jdField_a_of_type_Int = this.d;
    }
    if (this.e > 0) {
      this.jdField_b_of_type_Int = this.e;
    }
    xvv.b("Q.qqstory.publish.edit.GenerateThumbTask", "FlowSendTask():mFileDir:" + this.jdField_b_of_type_JavaLangString + ", mThumbWidth: " + this.jdField_a_of_type_Int + ", mThumbHeight:" + this.jdField_b_of_type_Int + ", mThumbOK:" + this.jdField_b_of_type_Boolean + ", mShowLastFrameThumb:" + this.jdField_a_of_type_Boolean + ", mExistThumbPath:" + this.jdField_c_of_type_JavaLangString + ", mExistThumbOk:" + this.jdField_c_of_type_Boolean);
  }
  
  private int b()
  {
    int i = 0;
    if ((this.jdField_a_of_type_Boolean) && (VideoEnvironment.getAVCodecVersion() >= 21)) {
      RecordThumbnailUtils.nativeSetLastFrameCover(RecordThumbnailUtils.a(this.jdField_b_of_type_JavaLangString));
    }
    this.jdField_a_of_type_JavaLangString = RecordThumbnailUtils.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, Bitmap.Config.ARGB_8888);
    if ((this.jdField_c_of_type_Int == 90) || (this.jdField_c_of_type_Int == 270))
    {
      int j = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
      this.jdField_b_of_type_Int = j;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      xvv.e("Q.qqstory.publish.edit.GenerateThumbTask", "generateThumb, getNativeCover result is empty, vf dir = %s", new Object[] { this.jdField_b_of_type_JavaLangString });
      i = 1;
    }
    for (;;)
    {
      return i;
      try
      {
        bfvo.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Double, this.jdField_b_of_type_Double);
        if (!new File(this.jdField_a_of_type_JavaLangString).exists())
        {
          xvv.e("Q.qqstory.publish.edit.GenerateThumbTask", "generateThumb, coverFile not exists, vf dir = %s, mThumbPath = %s", new Object[] { this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString });
          return 1;
        }
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        if (this.jdField_a_of_type_JavaLangString == null) {}
      }
    }
    for (boolean bool = new File(this.jdField_a_of_type_JavaLangString).exists();; bool = false)
    {
      xwa.b("video_edit", "update_LBS_exif_failed", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString, String.valueOf(bool) });
      break;
    }
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    long l1 = SystemClock.uptimeMillis();
    a();
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (this.jdField_a_of_type_JavaLangString != null)) {}
    for (int i = a();; i = b())
    {
      long l2 = SystemClock.uptimeMillis();
      if (i == 0) {
        xwa.b("take_video", "create_thumb_time", 0, 0, new String[] { "" + (l2 - l1) });
      }
      xwa.b("take_video", "create_thumb_result", 0, i, new String[0]);
      return Integer.valueOf(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjp
 * JD-Core Version:    0.7.0.1
 */