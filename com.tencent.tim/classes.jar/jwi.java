import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class jwi
  implements AdapterView.OnItemClickListener
{
  public jwi(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    if (localObject == null)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.isShowing()) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
    }
    int i = ((ShareActionSheetBuilder.b)localObject).b.action;
    int j = kbp.a(this.this$0.app, this.this$0.uin, this.this$0.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    label103:
    String str;
    if (i == 11)
    {
      this.this$0.report();
      i = 7;
      str = this.this$0.uin;
      if (!this.this$0.yr()) {
        break label479;
      }
    }
    label479:
    for (localObject = "02";; localObject = "01")
    {
      kbp.a(null, str, "0X8007CA6", "0X8007CA6", 0, 0, (String)localObject, i + "", j + "", null);
      break;
      if (i == 2)
      {
        smu.b(this.this$0, this.this$0.a(), this.this$0.getAccountType(), this.this$0.getShareUrl());
        i = 1;
        break label103;
      }
      if (i == 3)
      {
        smu.a(this.this$0, this.this$0.a(), this.this$0.getAccountType(), this.this$0.getShareUrl());
        i = 2;
        break label103;
      }
      if ((i == 9) || (i == 10))
      {
        smu.a(this.this$0, this.this$0.a(), this.this$0.getAccountType(), this.this$0.getShareUrl(), i);
        if (i == 9)
        {
          i = 3;
          break label103;
        }
        i = 4;
        break label103;
      }
      if (i == 31)
      {
        this.this$0.aAo();
        i = 6;
        break label103;
      }
      if (i == 30)
      {
        this.this$0.azt();
        i = 5;
        break label103;
      }
      if (i == 32)
      {
        this.this$0.aAp();
        i = 8;
        break label103;
      }
      if (i == 19) {
        asgx.a(this.this$0, 6, this.this$0.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.this$0.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary, this.this$0.shareUrl, "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + this.this$0.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.this$0.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, j, true);
      }
      i = 0;
      break label103;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jwi
 * JD-Core Version:    0.7.0.1
 */