import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSearchBaseFragment;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendMultiLinesTagsView.a;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;

public class afvm
  implements ExtendFriendMultiLinesTagsView.a
{
  public afvm(ExtendFriendSearchBaseFragment paramExtendFriendSearchBaseFragment) {}
  
  public void eA(String paramString, int paramInt)
  {
    ExtendFriendSearchBaseFragment.a(this.this$0).setText(paramString);
    ExtendFriendSearchBaseFragment.a(this.this$0).setSelection(ExtendFriendSearchBaseFragment.a(this.this$0).length());
    ExtendFriendSearchBaseFragment.a(this.this$0, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afvm
 * JD-Core Version:    0.7.0.1
 */