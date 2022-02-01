import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class afvw
  extends afsr
{
  public afvw(ExtendFriendSquareFragment paramExtendFriendSquareFragment) {}
  
  protected void Ir(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onLimitChatResourceStateUpdate, isReady = " + paramBoolean);
    }
    ExtendFriendSquareFragment.a(this.this$0);
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, aftr paramaftr, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("onMatchResponse success=%s match_op=%s retCode=%s info=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramaftr }));
    }
  }
  
  protected void a(boolean paramBoolean1, long paramLong, String paramString, boolean paramBoolean2, byte[] paramArrayOfByte, boolean paramBoolean3, boolean paramBoolean4, int paramInt, List<afua> paramList, aftq paramaftq)
  {
    if (this.this$0.XN != paramLong) {
      return;
    }
    try
    {
      ExtendFriendSquareFragment.a(this.this$0, 1);
      ExtendFriendSquareFragment.a(this.this$0, paramBoolean1, paramString, paramBoolean2, paramArrayOfByte, paramBoolean3, paramBoolean4, paramInt, paramList, paramaftq);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ExtendFriendSquareFragment", 1, "onGetSquareStrangerList exception", paramString);
    }
  }
  
  protected void as(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("onUpdateCampusCertificateStatus isSuccess=%s scene=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    if ((paramBoolean) && (paramInt == 1)) {
      ExtendFriendSquareFragment.b(this.this$0);
    }
    if (paramBoolean) {
      ExtendFriendSquareFragment.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afvw
 * JD-Core Version:    0.7.0.1
 */