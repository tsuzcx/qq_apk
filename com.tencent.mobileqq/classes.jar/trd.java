import android.app.AlertDialog.Builder;
import android.content.Context;
import android.widget.MediaController;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.qphone.base.util.QLog;

public class trd
  implements tsr
{
  public trd(TextureVideoView paramTextureVideoView) {}
  
  public boolean a(tso paramtso, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "Error: " + paramInt1 + "," + paramInt2);
    }
    this.a.jdField_a_of_type_Int = -1;
    this.a.b = -1;
    if (this.a.jdField_a_of_type_AndroidWidgetMediaController != null) {
      this.a.jdField_a_of_type_AndroidWidgetMediaController.hide();
    }
    if ((this.a.jdField_a_of_type_Tsr != null) && (this.a.jdField_a_of_type_Tsr.a(paramtso, paramInt1, paramInt2))) {}
    while (this.a.getWindowToken() == null) {
      return true;
    }
    this.a.getContext().getResources();
    if (paramInt1 == 200) {}
    for (paramInt1 = 17039381;; paramInt1 = 17039377)
    {
      paramtso = TextureVideoView.a(this.a);
      if (paramtso == null) {
        break;
      }
      new AlertDialog.Builder(paramtso).setMessage(paramInt1).setPositiveButton(17039376, new tre(this)).setCancelable(false).show();
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     trd
 * JD-Core Version:    0.7.0.1
 */