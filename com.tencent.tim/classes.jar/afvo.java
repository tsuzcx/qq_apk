import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSearchFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class afvo
  extends afsr
{
  public afvo(ExtendFriendSearchFragment paramExtendFriendSearchFragment) {}
  
  protected void a(boolean paramBoolean1, long paramLong, String paramString, boolean paramBoolean2, byte[] paramArrayOfByte, boolean paramBoolean3, boolean paramBoolean4, int paramInt, List<afua> paramList, aftq paramaftq)
  {
    if (this.this$0.XN != paramLong) {
      return;
    }
    try
    {
      ExtendFriendSearchFragment.a(this.this$0, 1);
      ExtendFriendSearchFragment.a(this.this$0, paramBoolean1, paramString, paramBoolean2, paramArrayOfByte, paramBoolean3, paramBoolean4, paramInt, paramList, paramaftq);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ExtendFriendSearchFragment", 1, "onGetSquareStrangerList exception", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afvo
 * JD-Core Version:    0.7.0.1
 */