import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.widget.MediaController;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;

public class vsl
  implements vue
{
  public vsl(TextureVideoView paramTextureVideoView) {}
  
  @TargetApi(15)
  public void a_(vtz paramvtz)
  {
    if (this.a.jdField_a_of_type_Vtz == null) {}
    label282:
    do
    {
      int i;
      do
      {
        do
        {
          return;
          this.a.jdField_a_of_type_Int = 2;
          TextureVideoView localTextureVideoView1 = this.a;
          TextureVideoView localTextureVideoView2 = this.a;
          this.a.jdField_d_of_type_Boolean = true;
          localTextureVideoView2.c = true;
          localTextureVideoView1.jdField_b_of_type_Boolean = true;
          if (this.a.jdField_a_of_type_Vue != null) {
            this.a.jdField_a_of_type_Vue.a_(this.a.jdField_a_of_type_Vtz);
          }
          if (this.a.jdField_a_of_type_AndroidWidgetMediaController != null) {
            this.a.jdField_a_of_type_AndroidWidgetMediaController.setEnabled(true);
          }
          this.a.jdField_d_of_type_Int = paramvtz.c();
          this.a.e = paramvtz.d();
          i = this.a.g;
          if (i != 0) {
            this.a.seekTo(i);
          }
          if ((this.a.jdField_d_of_type_Int == 0) || (this.a.e == 0)) {
            break label282;
          }
          if (Build.VERSION.SDK_INT >= 15) {
            this.a.getSurfaceTexture().setDefaultBufferSize(this.a.jdField_d_of_type_Int, this.a.e);
          }
          if (this.a.jdField_b_of_type_Int != 3) {
            break;
          }
          this.a.start();
        } while (this.a.jdField_a_of_type_AndroidWidgetMediaController == null);
        this.a.jdField_a_of_type_AndroidWidgetMediaController.show();
        return;
      } while ((this.a.isPlaying()) || ((i == 0) && (this.a.getCurrentPosition() <= 0)) || (this.a.jdField_a_of_type_AndroidWidgetMediaController == null));
      this.a.jdField_a_of_type_AndroidWidgetMediaController.show(0);
      return;
    } while (this.a.jdField_b_of_type_Int != 3);
    this.a.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vsl
 * JD-Core Version:    0.7.0.1
 */