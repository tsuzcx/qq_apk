import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;

public class ayys
  extends ayyn
{
  private static String fragmentShaderCode = GlUtil.readTextFromRawResource(BaseApplicationImpl.getContext(), 2131230767);
  private int dBu = -1;
  private int dBv;
  private Bitmap mBitmap;
  
  public ayys()
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
    Object localObject3 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        localInputStream = BaseApplicationImpl.getContext().getResources().openRawResource(2130847019);
        localObject1 = localInputStream;
        localObject3 = localInputStream;
        this.mBitmap = BitmapFactory.decodeStream(localInputStream);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        InputStream localInputStream;
        localObject3 = localIOException1;
        ram.e("Q.qqstory.publish.edit GPUNashvilleFilter", "OutOfMemoryError:%s", new Object[] { localOutOfMemoryError.getMessage() });
        if (localIOException1 == null) {
          continue;
        }
        try
        {
          localIOException1.close();
        }
        catch (IOException localIOException2)
        {
          localIOException2.printStackTrace();
        }
        continue;
      }
      finally
      {
        if (localObject3 == null) {
          break label111;
        }
      }
      try
      {
        localInputStream.close();
        this.dBv = GLES20.glGetUniformLocation(getProgram(), "sTexture2");
        return;
      }
      catch (IOException localIOException1)
      {
        localIOException1.printStackTrace();
      }
    }
    try
    {
      localObject3.close();
      label111:
      throw localObject2;
    }
    catch (IOException localIOException3)
    {
      for (;;)
      {
        localIOException3.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayys
 * JD-Core Version:    0.7.0.1
 */