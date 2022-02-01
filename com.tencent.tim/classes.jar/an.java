import android.view.View;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class an
  implements ausj.a
{
  public an(LiteActivity paramLiteActivity, long paramLong, DataLineMsgSet paramDataLineMsgSet, List paramList, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_b_of_type_Ausj.cancel();
      return;
      if (this.this$0.d(this.Z))
      {
        paramView = (acde)this.this$0.app.getBusinessHandler(8);
        this.jdField_b_of_type_ComTencentMobileqqDataDataLineMsgSet.setPaused(false);
        if (paramView.af(this.I))
        {
          paramView = this.jdField_b_of_type_ComTencentMobileqqDataDataLineMsgSet.values().iterator();
          while (paramView.hasNext())
          {
            DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)paramView.next();
            if (DataLineMsgSet.isCanReciveOrResend(localDataLineMsgRecord))
            {
              localDataLineMsgRecord.bIsResendOrRecvFile = true;
              localDataLineMsgRecord.fileMsgStatus = 0L;
              localDataLineMsgRecord.progress = 0.0F;
            }
          }
          this.this$0.a.notifyDataSetChanged();
        }
        else
        {
          ahao.OS(2131695433);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     an
 * JD-Core Version:    0.7.0.1
 */