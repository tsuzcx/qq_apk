import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.util.ArrayList;

public class uwp
  implements afkm
{
  public uwp(EmosmActivity paramEmosmActivity) {}
  
  public void a(EmoticonPackage paramEmoticonPackage) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2) {}
  
  public void b(EmoticonPackage paramEmoticonPackage)
  {
    int i = 0;
    while (i < this.this$0.pg.size())
    {
      if (((EmoticonPackage)this.this$0.pg.get(i)).epId.equals(paramEmoticonPackage.epId)) {
        return;
      }
      i += 1;
    }
    this.this$0.runOnUiThread(this.this$0.dP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uwp
 * JD-Core Version:    0.7.0.1
 */