import SummaryCard.RespCondSearch;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class accx
  extends acfd
{
  accx(accv paramaccv) {}
  
  protected void onCondSearchFriendResult(long paramLong, boolean paramBoolean, Object paramObject, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "searchseq = " + this.this$0.Pj + " | seq = " + paramLong + ", isSuccess=" + paramBoolean + ", ret=" + paramInt1 + ", searchFrom=" + paramInt2);
    }
    if (this.this$0.Pj != paramLong) {
      return;
    }
    if ((paramBoolean) && (paramInt1 == 0))
    {
      paramObject = (RespCondSearch)paramObject;
      accv localaccv = this.this$0;
      if (paramObject.cEndFlag == 0)
      {
        paramBoolean = true;
        localaccv.hasMore = paramBoolean;
        this.this$0.cuK = paramObject.iPage;
        this.this$0.mSessionId = paramObject.dwSessionID;
        if (this.this$0.xl != null) {
          break label342;
        }
        this.this$0.xl = paramObject.vUserList;
      }
      for (;;)
      {
        if ((this.this$0.cuL >= 2) || ((this.this$0.xl != null) && (this.this$0.xl.size() >= 10)) || (!this.this$0.hasMore)) {
          break label382;
        }
        paramObject = this.this$0;
        paramObject.cuL += 1;
        ((FriendListHandler)accv.a(this.this$0).getBusinessHandler(1)).a(this.this$0.Pj, this.this$0.cuK + 1, this.this$0.mSessionId, this.this$0.bnZ, this.this$0.cuF, this.this$0.cuG, this.this$0.cuH, this.this$0.dZ, this.this$0.ea, this.this$0.cuI, this.this$0.cuJ, paramInt2);
        return;
        paramBoolean = false;
        break;
        label342:
        if ((paramObject.vUserList != null) && (!paramObject.vUserList.isEmpty())) {
          this.this$0.xl.addAll(paramObject.vUserList);
        }
      }
      label382:
      if ((this.this$0.xl == null) || (this.this$0.xl.size() < 6)) {
        this.this$0.hasMore = false;
      }
      this.this$0.a(true, this.this$0.xl, this.this$0.hasMore, paramInt2);
      return;
    }
    if ((paramBoolean) && (paramInt1 != 0))
    {
      this.this$0.hasMore = false;
      this.this$0.a(true, this.this$0.xl, this.this$0.hasMore, paramInt2);
      return;
    }
    if (this.this$0.cuL == 0)
    {
      this.this$0.a(false, null, this.this$0.hasMore, paramInt2);
      return;
    }
    this.this$0.a(true, this.this$0.xl, this.this$0.hasMore, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     accx
 * JD-Core Version:    0.7.0.1
 */