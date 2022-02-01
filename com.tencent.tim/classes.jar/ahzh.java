import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.mobileqq.hotpic.HotPicPageView.a;
import com.tencent.mobileqq.hotpic.HotPicPageView.c;
import com.tencent.mobileqq.hotpic.HotPicRecyclerView;

public class ahzh
  extends Handler
{
  public ahzh(HotPicPageView paramHotPicPageView) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        int i;
        do
        {
          do
          {
            do
            {
              return;
            } while (HotPicPageView.cjn);
            this.this$0.drk();
            return;
          } while ((HotPicPageView.cjn) || (this.this$0.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.getVisibility() != 0) || (this.this$0.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$a == null) || (this.this$0.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$a.getItemCount() == 0));
          i = this.this$0.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.Fu();
        } while (i < 0);
        paramMessage = this.this$0.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.findViewHolderForPosition(i);
      } while ((paramMessage == null) || (!(paramMessage instanceof HotPicPageView.c)));
      paramMessage = (HotPicPageView.c)paramMessage;
    } while (paramMessage.mPlayState == 0);
    paramMessage.cjo = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahzh
 * JD-Core Version:    0.7.0.1
 */