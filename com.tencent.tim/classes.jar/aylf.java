import android.support.annotation.NonNull;
import dov.com.qq.im.capture.text.EditTextPreView;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout.a;

class aylf
  implements HorizontalSelectColorLayout.a
{
  aylf(aykw paramaykw) {}
  
  public void a(@NonNull aytl paramaytl)
  {
    switch (paramaytl.type)
    {
    default: 
      return;
    }
    int i = paramaytl.subType;
    this.this$0.jdField_a_of_type_Aykl.color = i;
    this.this$0.brj = i;
    if ((this.this$0.b instanceof axvb))
    {
      ((axvb)this.this$0.b).setTextColor(i);
      this.this$0.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.invalidate();
    }
    rar.a("video_edit_text", "clk_color", 0, 0, new String[] { (String)pre.a().a("EditVideoDTextFace.mSrcFrom"), paramaytl.cTR, "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aylf
 * JD-Core Version:    0.7.0.1
 */