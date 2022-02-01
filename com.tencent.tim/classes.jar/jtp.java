import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

class jtp
  implements AbsListView.e
{
  int aDp;
  int aDq = (int)(2.0F * this.this$0.density);
  
  jtp(jtg paramjtg) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.this$0.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getFirstVisiblePosition() == 0)
    {
      if ((this.this$0.jdField_b_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.this$0.jdField_b_of_type_ComTencentMobileqqDataAccountDetail.protocolVersion == 0))
      {
        paramInt1 = -this.this$0.mX();
        paramAbsListView = this.this$0.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getChildAt(0);
        if (!this.this$0.abG) {
          break label215;
        }
        if (!this.this$0.isFullScreen) {
          break label203;
        }
        paramInt2 = (int)(paramInt1 - 262.0F * this.this$0.density);
        this.this$0.g(paramInt2, paramAbsListView);
        if ((this.this$0.jdField_a_of_type_Jue != null) && (paramInt1 != 0))
        {
          if (paramInt1 >= this.this$0.screenHeight - 75.0F * this.this$0.density) {
            break label247;
          }
          this.this$0.jdField_a_of_type_Jue.ly(false);
        }
      }
      label151:
      paramInt2 = this.this$0.mX();
      if (Math.abs(this.aDp - paramInt2) <= this.aDq) {
        break label290;
      }
      paramInt1 = 1;
      label177:
      if (paramInt1 != 0) {
        if (this.aDp <= paramInt2) {
          break label295;
        }
      }
    }
    label290:
    label295:
    for (this.this$0.abJ = true;; this.this$0.abJ = false)
    {
      this.aDp = paramInt2;
      return;
      label203:
      this.this$0.h(paramInt1, paramAbsListView);
      break;
      label215:
      if ((this.this$0.jdField_b_of_type_ComTencentMobileqqDataAccountDetail == null) && (this.this$0.jdField_b_of_type_ComTencentMobileqqDataEqqDetail == null)) {
        break;
      }
      this.this$0.f(paramInt1, paramAbsListView);
      break;
      label247:
      this.this$0.jdField_a_of_type_Jue.azQ();
      break label151;
      this.this$0.azI();
      if (this.this$0.jdField_a_of_type_Jue == null) {
        break label151;
      }
      this.this$0.jdField_a_of_type_Jue.azQ();
      break label151;
      paramInt1 = 0;
      break label177;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      noy.a().resume();
      if (!this.this$0.abJ) {
        break label89;
      }
      jtg.a(this.this$0, paramAbsListView.getLastVisiblePosition(), jtg.access$100());
    }
    for (;;)
    {
      if ((this.this$0.getCount() - paramAbsListView.getLastVisiblePosition() < jtg.access$300()) && (this.this$0.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.AJ)) {
        jtg.a(this.this$0);
      }
      if ((paramAbsListView instanceof AccountDetailXListView)) {
        ((AccountDetailXListView)paramAbsListView).onScrollStateChanged(paramAbsListView, paramInt);
      }
      return;
      label89:
      jtg.a(this.this$0, paramAbsListView.getFirstVisiblePosition() - jtg.access$100(), jtg.access$100());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jtp
 * JD-Core Version:    0.7.0.1
 */