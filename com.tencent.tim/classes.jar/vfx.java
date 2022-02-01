import android.view.View;
import com.tencent.mobileqq.activity.LikeRankingListActivity;
import com.tencent.mobileqq.activity.LikeRankingListActivity.2.1;
import com.tencent.mobileqq.activity.LikeRankingListActivity.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.LikeRankingInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class vfx
  extends accn
{
  public vfx(LikeRankingListActivity paramLikeRankingListActivity) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LikeRankingListActivity", 2, "onCardDownload isSuccess=" + paramBoolean);
    }
    if ((paramBoolean) && ((paramObject instanceof Card)))
    {
      paramObject = (Card)paramObject;
      if (paramObject.uin.equals(this.this$0.aNR)) {
        this.this$0.app.execute(new LikeRankingListActivity.2.1(this, paramObject));
      }
    }
  }
  
  protected void onReqLikeRankingListResult(boolean paramBoolean1, String paramString, List<LikeRankingInfo> paramList, int paramInt, boolean paramBoolean2)
  {
    int i;
    if (QLog.isColorLevel())
    {
      String str = "onReqLikeRankingListResult success:" + paramBoolean1;
      paramString = new StringBuilder().append(", uin:").append(paramString).append(", size:");
      if (paramList == null)
      {
        i = 0;
        QLog.d("LikeRankingListActivity", 2, new Object[] { str, i + ", nextIndex: " + paramInt + ", isComplete:" + paramBoolean2 });
      }
    }
    else
    {
      if (!paramBoolean1) {
        break label341;
      }
      if ((paramList == null) || ((paramList.size() <= 0) && (!paramBoolean2))) {
        break label284;
      }
      this.this$0.jdField_a_of_type_Acgx.e(paramList, paramInt, paramBoolean2);
      if ((!paramBoolean2) || (paramList.size() != 0)) {
        break label258;
      }
      this.this$0.mEmptyView.setVisibility(0);
      label165:
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity$a.W(paramList, true);
      if (this.this$0.mStartIndex == 0)
      {
        if (paramList.size() <= 0) {
          break label273;
        }
        this.this$0.updateCover(String.valueOf(((LikeRankingInfo)paramList.get(0)).uin));
        LikeRankingListActivity.a(this.this$0, false);
      }
    }
    for (;;)
    {
      paramString = this.this$0;
      if (paramBoolean2) {
        paramInt = -1;
      }
      paramString.mStartIndex = paramInt;
      return;
      i = paramList.size();
      break;
      label258:
      this.this$0.mEmptyView.setVisibility(8);
      break label165;
      label273:
      this.this$0.updateCover(null);
      continue;
      label284:
      this.this$0.updateCover(null);
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity$a.mIsLoading = false;
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity$a.notifyDataSetChanged();
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity$a.getCount() <= 1) {
        this.this$0.mEmptyView.setVisibility(0);
      }
    }
    label341:
    this.this$0.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity$a.mIsLoading = false;
    this.this$0.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity$a.notifyDataSetChanged();
    QQToast.a(BaseApplication.getContext(), 1, acfp.m(2131707742), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vfx
 * JD-Core Version:    0.7.0.1
 */