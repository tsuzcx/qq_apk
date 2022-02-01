import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.hotpic.PublicAccountHotPicPanel;
import com.tencent.widget.XPanelContainer.c;

public class khl
  implements XPanelContainer.c
{
  public khl(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity) {}
  
  public View a(int paramInt)
  {
    EmoticonMainPanel localEmoticonMainPanel = null;
    if (paramInt == 3)
    {
      if (ReadInJoyBaseDeliverActivity.a(this.this$0) == null)
      {
        ReadInJoyBaseDeliverActivity.a(this.this$0, (EmoticonMainPanel)View.inflate(this.this$0, 2131559281, null));
        ReadInJoyBaseDeliverActivity.a(this.this$0).setCallBack(ReadInJoyBaseDeliverActivity.a(this.this$0));
        ReadInJoyBaseDeliverActivity.a(this.this$0).bYY = true;
        bool = this.this$0 instanceof ReadInJoyDeliverBiuActivity;
        ReadInJoyBaseDeliverActivity.a(this.this$0).a(this.this$0.app, 99999, this.this$0, this.this$0.getTitleBarHeight(), null, null, bool);
        ReadInJoyBaseDeliverActivity.a(this.this$0).daq();
      }
      localEmoticonMainPanel = ReadInJoyBaseDeliverActivity.a(this.this$0);
    }
    while (paramInt != 24)
    {
      boolean bool;
      return localEmoticonMainPanel;
    }
    if (ReadInJoyBaseDeliverActivity.a(this.this$0) == null)
    {
      ReadInJoyBaseDeliverActivity.a(this.this$0, (PublicAccountHotPicPanel)View.inflate(this.this$0, 2131559815, null));
      ReadInJoyBaseDeliverActivity.a(this.this$0).a(this.this$0.app, this.this$0, null, this.this$0.c);
      ReadInJoyBaseDeliverActivity.a(this.this$0).setPublicAccountGifListener(ReadInJoyBaseDeliverActivity.a(this.this$0));
    }
    return ReadInJoyBaseDeliverActivity.a(this.this$0);
  }
  
  public void bo() {}
  
  public void n(int paramInt1, int paramInt2)
  {
    boolean bool;
    if ((paramInt1 == 24) && (ReadInJoyBaseDeliverActivity.a(this.this$0) != null)) {
      if (paramInt2 == 1)
      {
        bool = true;
        ReadInJoyBaseDeliverActivity.a(this.this$0).yQ(bool);
        label34:
        if (paramInt2 != 1) {
          break label82;
        }
        this.this$0.oM(1);
      }
    }
    label82:
    do
    {
      return;
      bool = false;
      break;
      if ((paramInt2 != 24) || (ReadInJoyBaseDeliverActivity.a(this.this$0) == null)) {
        break label34;
      }
      ReadInJoyBaseDeliverActivity.a(this.this$0).onShow();
      break label34;
      if (paramInt2 == 3)
      {
        this.this$0.oM(2);
        return;
      }
      if (paramInt2 == 0)
      {
        this.this$0.oM(0);
        return;
      }
    } while (paramInt2 != 24);
    this.this$0.oM(3);
  }
  
  public boolean r(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     khl
 * JD-Core Version:    0.7.0.1
 */