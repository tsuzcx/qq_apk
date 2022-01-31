import android.graphics.drawable.Drawable;
import android.text.Editable;
import com.tencent.mobileqq.activity.HornPublishActivity;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.widget.XEditText;

public class cqq
  implements EmoticonCallback
{
  public cqq(HornPublishActivity paramHornPublishActivity) {}
  
  public void a()
  {
    TextUtils.a(this.a.a);
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    if ((paramEmoticonInfo instanceof SystemEmoticonInfo))
    {
      int i = this.a.a.getSelectionStart();
      int j = this.a.a.getSelectionEnd();
      if ((i >= 0) && (j >= 0) && (j >= i)) {
        this.a.a.getEditableText().replace(i, j, TextUtils.b(((SystemEmoticonInfo)paramEmoticonInfo).a));
      }
    }
  }
  
  public void a(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public boolean a(EmoticonInfo paramEmoticonInfo)
  {
    return false;
  }
  
  public void b() {}
  
  public void b(EmoticonInfo paramEmoticonInfo) {}
  
  public void d() {}
  
  public void u_() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cqq
 * JD-Core Version:    0.7.0.1
 */