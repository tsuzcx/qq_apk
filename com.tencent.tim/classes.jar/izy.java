import com.tencent.av.VideoController.b;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class izy
  extends iid
{
  public izy(MultiIncomingCallsActivity paramMultiIncomingCallsActivity) {}
  
  protected void b(long paramLong, ArrayList<VideoController.b> paramArrayList, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "onUserListALLUpdate");
    }
    MultiIncomingCallsActivity.a(this.this$0, paramLong, paramArrayList, paramInt1);
  }
  
  protected void c(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "onMembersChange");
    }
    if ((paramLong != this.this$0.mGroupId) || (paramBoolean)) {}
    while (((paramInt != 10) && (paramInt != 1)) || (!this.this$0.isResume())) {
      return;
    }
    MultiIncomingCallsActivity.a(this.this$0, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     izy
 * JD-Core Version:    0.7.0.1
 */