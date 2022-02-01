import android.text.TextUtils;
import com.tencent.qidian.PhotoWallViewForQiDianProfile.b;
import com.tencent.qidian.QidianProfileCardActivity;

public class ashr
  implements PhotoWallViewForQiDianProfile.b
{
  public ashr(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  public void a(asia paramasia)
  {
    if (paramasia != null)
    {
      paramasia = paramasia.cEQ;
      if (!TextUtils.isEmpty(paramasia)) {
        QidianProfileCardActivity.a(this.this$0, paramasia);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ashr
 * JD-Core Version:    0.7.0.1
 */