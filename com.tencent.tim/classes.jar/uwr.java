import android.view.View;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.util.Iterator;
import java.util.List;

public class uwr
  implements ajdq<List<EmoticonPackage>>
{
  public uwr(EmosmActivity paramEmosmActivity) {}
  
  public void fP(List<EmoticonPackage> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      this.this$0.sx.setVisibility(8);
    }
    do
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)paramList.next();
        if ((3 == localEmoticonPackage.jobType) || (5 == localEmoticonPackage.jobType)) {
          this.this$0.aVV = true;
        }
      }
    } while (this.this$0.aVV);
    this.this$0.sx.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uwr
 * JD-Core Version:    0.7.0.1
 */