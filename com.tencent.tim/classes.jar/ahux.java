import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ahux
  implements View.OnClickListener
{
  public ahux(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void onClick(View paramView)
  {
    String str2 = "";
    String str1 = "";
    Object localObject = QQGameFeedWebFragment.a(this.this$0);
    int i;
    if (localObject != null)
    {
      str2 = ((QQGameMsgInfo)localObject).gameAppId;
      if (TextUtils.isEmpty(((QQGameMsgInfo)localObject).paMsgid)) {
        str1 = "";
      }
    }
    else
    {
      localObject = new HashMap();
      ((Map)localObject).put(Integer.valueOf(24), "1");
      ((Map)localObject).put(Integer.valueOf(1), str1);
      ((Map)localObject).put(Integer.valueOf(3), "2");
      ((Map)localObject).put(Integer.valueOf(4), "20");
      tbb.a(abmt.getAppInterface(), "769", "205037", str2, "76901", "1", "160", (Map)localObject);
      if (QQGameFeedWebFragment.a(this.this$0) != null)
      {
        i = QQGameFeedWebFragment.a(this.this$0).getCurrentItem();
        if (i + 1 >= QQGameFeedWebFragment.a(this.this$0).size()) {
          break label196;
        }
        QQGameFeedWebFragment.a(this.this$0).setCurrentItem(i + 1);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      str1 = ((QQGameMsgInfo)localObject).paMsgid;
      break;
      label196:
      if (i == QQGameFeedWebFragment.a(this.this$0).size() - 1) {
        QQGameFeedWebFragment.a(this.this$0).setCurrentItem(QQGameFeedWebFragment.a(this.this$0).size());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahux
 * JD-Core Version:    0.7.0.1
 */