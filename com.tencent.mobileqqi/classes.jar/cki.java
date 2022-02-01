import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmoticonPackageChangedListener;
import java.util.ArrayList;

public class cki
  implements EmoticonPackageChangedListener
{
  public cki(EmosmActivity paramEmosmActivity) {}
  
  public void a(EmoticonPackage paramEmoticonPackage) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2) {}
  
  public void b(EmoticonPackage paramEmoticonPackage)
  {
    int i = 0;
    while (i < EmosmActivity.a(this.a).size())
    {
      if (((EmoticonPackage)EmosmActivity.a(this.a).get(i)).epId.equals(paramEmoticonPackage.epId)) {
        return;
      }
      i += 1;
    }
    this.a.runOnUiThread(EmosmActivity.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cki
 * JD-Core Version:    0.7.0.1
 */