import android.app.AlertDialog.Builder;
import android.content.Context;
import android.widget.MediaController;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.qphone.base.util.QLog;

public class qlj
  implements qmc.c
{
  public qlj(TextureVideoView paramTextureVideoView) {}
  
  public boolean b(qmc paramqmc, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.TAG, 2, "Error: " + paramInt1 + "," + paramInt2);
    }
    this.a.mCurrentState = -1;
    this.a.mTargetState = -1;
    if (this.a.jdField_a_of_type_AndroidWidgetMediaController != null) {
      this.a.jdField_a_of_type_AndroidWidgetMediaController.hide();
    }
    if ((this.a.jdField_a_of_type_Qmc$c != null) && (this.a.jdField_a_of_type_Qmc$c.b(paramqmc, paramInt1, paramInt2))) {}
    while (this.a.getWindowToken() == null) {
      return true;
    }
    this.a.getContext().getResources();
    if (paramInt1 == 200) {}
    for (paramInt1 = 17039381;; paramInt1 = 17039377)
    {
      paramqmc = TextureVideoView.a(this.a);
      if (paramqmc == null) {
        break;
      }
      new AlertDialog.Builder(paramqmc).setMessage(paramInt1).setPositiveButton(17039376, new qlk(this)).setCancelable(false).show();
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qlj
 * JD-Core Version:    0.7.0.1
 */