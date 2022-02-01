import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class amaz
  extends amau
{
  private static String fragmentShaderCode = GlUtil.readTextFromRawResource(BaseApplicationImpl.getContext(), 2131230767);
  private int dBu = -1;
  private int dBv;
  private Bitmap mBitmap;
  
  public amaz()
  {
    super("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", fragmentShaderCode);
    this.mFilterType = 6;
  }
  
  public void onDestroy()
  {
    if (this.dBu != -1) {
      GlUtil.deleteTexture(this.dBu);
    }
    if ((this.mBitmap != null) && (!this.mBitmap.isRecycled()))
    {
      this.mBitmap.recycle();
      this.mBitmap = null;
      ram.d("Q.qqstory.publish.edit GPUNashvilleFilter", "mosaic bitmap recycle");
    }
  }
  
  public void onDrawTexture()
  {
    super.onDrawTexture();
    GLES20.glActiveTexture(33985);
    if (this.dBu == -1)
    {
      if ((this.mBitmap == null) || (this.mBitmap.isRecycled()))
      {
        QLog.w("Q.qqstory.publish.edit GPUNashvilleFilter", 1, "bitmap error");
        return;
      }
      this.dBu = GlUtil.createTexture(3553, this.mBitmap);
      this.mBitmap.recycle();
      this.mBitmap = null;
    }
    GLES20.glBindTexture(3553, this.dBu);
    GLES20.glUniform1i(this.dBv, 1);
  }
  
  public void onInitialized()
  {
    super.onInitialized();
    try
    {
      this.mBitmap = BitmapFactory.decodeStream(BaseApplicationImpl.getContext().getResources().openRawResource(2130847019));
      this.dBv = GLES20.glGetUniformLocation(getProgram(), "sTexture2");
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        ram.e("Q.qqstory.publish.edit GPUNashvilleFilter", "OutOfMemoryError:%s", new Object[] { localOutOfMemoryError.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amaz
 * JD-Core Version:    0.7.0.1
 */