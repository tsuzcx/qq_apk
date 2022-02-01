import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.hotpic.PublicAccountHotPicPanel;
import com.tencent.widget.XPanelContainer.c;

public class ksg
  implements XPanelContainer.c
{
  public ksg(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public View a(int paramInt)
  {
    EmoticonMainPanel localEmoticonMainPanel = null;
    if (paramInt == 3)
    {
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel == null)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)View.inflate(ReadInJoyCommentComponentFragment.a(this.this$0), 2131559281, null));
        this.this$0.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack(ReadInJoyCommentComponentFragment.a(this.this$0));
        this.this$0.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.bYY = true;
        this.this$0.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(ReadInJoyCommentComponentFragment.a(this.this$0).app, 1008, ReadInJoyCommentComponentFragment.a(this.this$0), ReadInJoyCommentComponentFragment.a(this.this$0).getTitleBarHeight(), null, null);
        this.this$0.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.daq();
      }
      localEmoticonMainPanel = this.this$0.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
    }
    while (paramInt != 24) {
      return localEmoticonMainPanel;
    }
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel == null)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel = ((PublicAccountHotPicPanel)View.inflate(ReadInJoyCommentComponentFragment.a(this.this$0), 2131559815, null));
      this.this$0.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel.a(ReadInJoyCommentComponentFragment.a(this.this$0).app, ReadInJoyCommentComponentFragment.a(this.this$0), null, this.this$0.c);
      this.this$0.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel.setPublicAccountGifListener(ReadInJoyCommentComponentFragment.a(this.this$0));
    }
    return this.this$0.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel;
  }
  
  public void bo() {}
  
  public void n(int paramInt1, int paramInt2)
  {
    boolean bool;
    if ((paramInt1 == 24) && (this.this$0.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel != null)) {
      if (paramInt2 == 1)
      {
        bool = true;
        this.this$0.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel.yQ(bool);
        label34:
        if (paramInt2 != 1) {
          break label82;
        }
        ReadInJoyCommentComponentFragment.a(this.this$0, 1);
      }
    }
    label82:
    do
    {
      return;
      bool = false;
      break;
      if ((paramInt2 != 24) || (this.this$0.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel == null)) {
        break label34;
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel.onShow();
      break label34;
      if (paramInt2 == 3)
      {
        ReadInJoyCommentComponentFragment.a(this.this$0, 2);
        return;
      }
      if (paramInt2 == 0)
      {
        ReadInJoyCommentComponentFragment.a(this.this$0, 0);
        return;
      }
    } while (paramInt2 != 24);
    ReadInJoyCommentComponentFragment.a(this.this$0, 3);
  }
  
  public boolean r(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ksg
 * JD-Core Version:    0.7.0.1
 */