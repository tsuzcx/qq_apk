import android.widget.MediaController;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;

public class qlh
  implements qmc.b
{
  public qlh(TextureVideoView paramTextureVideoView) {}
  
  public void b(qmc paramqmc)
  {
    this.a.mCurrentState = 5;
    this.a.mTargetState = 5;
    if (this.a.jdField_a_of_type_AndroidWidgetMediaController != null) {
      this.a.jdField_a_of_type_AndroidWidgetMediaController.hide();
    }
    if (this.a.jdField_a_of_type_Qmc$b != null) {
      this.a.jdField_a_of_type_Qmc$b.b(this.a.jdField_a_of_type_Qmc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qlh
 * JD-Core Version:    0.7.0.1
 */