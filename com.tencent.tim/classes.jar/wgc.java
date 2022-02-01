import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.VisitorsActivity.d;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class wgc
  extends accn
{
  public wgc(VisitorsActivity paramVisitorsActivity) {}
  
  protected void onFavoritorsList(boolean paramBoolean, String paramString, ArrayList<CardProfile> paramArrayList, long paramLong1, long paramLong2, byte[] paramArrayOfByte, Card paramCard)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("VisitorsActivity", 2, "onFavoritorsList.isSuccess=" + paramBoolean + ";uin=" + paramString + ";startMid=" + paramLong1 + ";nextMid=" + paramLong2);
      if (paramArrayList != null) {
        QLog.d("VisitorsActivity", 2, "onFavoritorsList.voters.size=" + paramArrayList.size());
      }
    }
    if (!this.this$0.app.getCurrentAccountUin().equals(paramString)) {
      return;
    }
    if (paramBoolean)
    {
      paramString = this.this$0.pW;
      if (this.this$0.bbZ) {
        paramString = new ArrayList();
      }
      this.this$0.HA = paramLong2;
      paramArrayOfByte = this.this$0.b;
      if (this.this$0.HA != -1L) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramArrayOfByte.setHasMore(paramBoolean);
        paramArrayOfByte = paramString;
        if (paramArrayList != null) {
          paramArrayOfByte = anav.b(paramString, paramArrayList);
        }
        this.this$0.d(paramArrayOfByte, paramLong1);
        return;
      }
    }
    this.this$0.bXU();
  }
  
  protected void onGetPartakeLikeRankingList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "onGetPartakeLikeRankingList.isSuccess=" + paramBoolean1 + ";isOn=" + paramBoolean2);
    }
    if (paramBoolean1) {
      this.this$0.yj(paramBoolean2);
    }
  }
  
  protected void onReqDelVoteRecord(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VisitorsActivity", 2, String.format("onReqDelVoteRecord selfUin:%s targetUin:%d type:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) }));
    }
    if (paramLong1 != Long.parseLong(this.this$0.app.getCurrentAccountUin())) {}
    while (paramBoolean) {
      return;
    }
    this.this$0.aL(1, acfp.m(2131716839));
  }
  
  protected void onReqFavoriteResult(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (!paramString1.equals(this.this$0.app.getCurrentAccountUin())) {}
    do
    {
      return;
      if (paramInt2 == 1)
      {
        if (!paramBoolean)
        {
          this.this$0.jdField_a_of_type_Alhr.u(paramString2, paramInt1, true);
          return;
        }
        this.this$0.jdField_a_of_type_Alhr.t(paramString2, paramInt1, true);
        return;
      }
    } while (paramInt2 != 0);
    this.this$0.jdField_a_of_type_Alhr.kG(Long.parseLong(paramString2));
  }
  
  protected void onSetPartakeLikeRankingList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "onSetPartakeLikeRankingList.isSuccess=" + paramBoolean1 + ";isOn=" + paramBoolean2);
    }
    if (paramBoolean1) {
      this.this$0.yj(paramBoolean2);
    }
  }
  
  protected void onVoterList(boolean paramBoolean, String paramString, ArrayList<CardProfile> paramArrayList, ArrayList<Long> paramArrayList1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong1, long paramLong2, byte[] paramArrayOfByte, Card paramCard)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("VisitorsActivity", 2, "onVoterList.isSuccess=" + paramBoolean + ";uin=" + paramString + ";startMid=" + paramLong1 + ";nextMid=" + paramLong2 + "todayVoteCount=" + paramInt3 + "todayVoteRank=" + paramInt4 + "totalVoteCount=" + paramInt5);
      if (paramArrayList != null) {
        QLog.d("VisitorsActivity", 2, "onVoterList.voters.size=" + paramArrayList.size());
      }
    }
    if (!this.this$0.app.getCurrentAccountUin().equals(paramString)) {
      return;
    }
    if (paramBoolean)
    {
      this.this$0.jdField_a_of_type_Alhr.a(paramArrayList1, paramInt1, paramInt2, paramLong1);
      paramString = this.this$0.pV;
      if (this.this$0.ob)
      {
        this.this$0.app.b().ca(acbn.bkB, 1001);
        this.this$0.app.b().ca(acbn.bkB, 10002);
        paramString = new ArrayList();
      }
      this.this$0.Hz = paramLong2;
      paramArrayList1 = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$d;
      if (this.this$0.Hz != -1L) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramArrayList1.setHasMore(paramBoolean);
        paramArrayList1 = paramString;
        if (paramArrayList != null) {
          paramArrayList1 = anav.b(paramString, paramArrayList);
        }
        this.this$0.c(paramArrayList1, paramLong1);
        this.this$0.an(paramInt3, paramInt4, paramInt5);
        return;
      }
    }
    this.this$0.bXT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wgc
 * JD-Core Version:    0.7.0.1
 */