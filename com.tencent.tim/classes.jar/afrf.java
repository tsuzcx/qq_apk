import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;

public class afrf
  implements ajdq<EmoticonPackage>
{
  public afrf(AIOEmotionFragment paramAIOEmotionFragment, QQAppInterface paramQQAppInterface) {}
  
  public void c(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage == null)
    {
      AIOEmotionFragment.a(this.this$0, this.val$app, 7);
      return;
    }
    MarketFaceItemBuilder.a(7, this.this$0.getActivity(), this.val$app, paramEmoticonPackage, this.this$0.g, this.this$0.mSessionInfo, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afrf
 * JD-Core Version:    0.7.0.1
 */