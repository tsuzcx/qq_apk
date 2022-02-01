import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment;
import com.tencent.qphone.base.util.QLog;

public class afux
  extends acku
{
  public afux(ExtendFriendFragment paramExtendFriendFragment) {}
  
  public void wV(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendFragment", 2, String.format("onDataChange success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    ExtendFriendFragment.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afux
 * JD-Core Version:    0.7.0.1
 */