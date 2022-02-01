import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;

public class afrg
  implements ajdq<EmoticonPackage>
{
  public afrg(AIOEmotionFragment paramAIOEmotionFragment, QQAppInterface paramQQAppInterface) {}
  
  public void c(EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.name != null) && ((paramEmoticonPackage.mobileFeetype != 0) || (paramEmoticonPackage.downloadCount != 0)))
    {
      int i = this.val$app.getPreferences().getInt("emosm_json_last_download_timestamp", 0);
      int j = (int)(System.currentTimeMillis() / 1000L);
      if ((j - i > 86400) || (j < i))
      {
        AIOEmotionFragment.a(this.this$0, this.val$app, 6);
        return;
      }
      MarketFaceItemBuilder.a(6, this.this$0.getActivity(), this.val$app, paramEmoticonPackage, this.this$0.g, this.this$0.mSessionInfo, null, true);
      return;
    }
    AIOEmotionFragment.a(this.this$0, this.val$app, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afrg
 * JD-Core Version:    0.7.0.1
 */