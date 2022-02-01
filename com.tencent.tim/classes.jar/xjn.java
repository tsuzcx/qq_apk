import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;

public class xjn
  implements ausj.a
{
  public xjn(MarketFaceItemBuilder paramMarketFaceItemBuilder, afpu paramafpu, ausj paramausj, MessageForMarketFace paramMessageForMarketFace) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if (this.a.e.jobType != 1) {
        break;
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (this.a.e.jobType == 3) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.this$0.mContext, this.this$0.app.getAccount(), 8, this.a.e.epId, bool1, bool2);
        this.jdField_b_of_type_Ausj.cancel();
        return;
      }
      ujt.a(this.this$0.app, this.this$0.mContext, this.this$0.sessionInfo, this.a.e, this.jdField_b_of_type_ComTencentMobileqqDataMessageForMarketFace.uniseq);
      this.jdField_b_of_type_Ausj.cancel();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xjn
 * JD-Core Version:    0.7.0.1
 */