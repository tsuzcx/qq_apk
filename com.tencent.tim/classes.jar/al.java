import android.view.View;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import java.util.ArrayList;
import java.util.Iterator;

public class al
  implements ausj.a
{
  public al(LiteActivity paramLiteActivity, DataLineMsgSet paramDataLineMsgSet, dl paramdl, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_b_of_type_Ausj.cancel();
      return;
      if (this.jdField_b_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -1000)
      {
        paramView = this.a.a().bM;
        this.this$0.a(paramView, this.a.a().mSessionId, -1);
      }
      else
      {
        DataLineMsgRecord localDataLineMsgRecord;
        if (this.jdField_b_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2000)
        {
          this.jdField_b_of_type_ComTencentMobileqqDataDataLineMsgSet.setPaused(false);
          paramView = this.jdField_b_of_type_ComTencentMobileqqDataDataLineMsgSet.values().iterator();
          while (paramView.hasNext())
          {
            localDataLineMsgRecord = (DataLineMsgRecord)paramView.next();
            if (DataLineMsgSet.isCanReciveOrResend(localDataLineMsgRecord)) {
              this.this$0.a(localDataLineMsgRecord.path, localDataLineMsgRecord.sessionid, 0);
            }
          }
        }
        else if ((this.jdField_b_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2005) || (this.jdField_b_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2009))
        {
          this.jdField_b_of_type_ComTencentMobileqqDataDataLineMsgSet.setPaused(false);
          paramView = this.jdField_b_of_type_ComTencentMobileqqDataDataLineMsgSet.values().iterator();
          while (paramView.hasNext())
          {
            localDataLineMsgRecord = (DataLineMsgRecord)paramView.next();
            if (DataLineMsgSet.isCanReciveOrResend(localDataLineMsgRecord)) {
              this.this$0.a(localDataLineMsgRecord.path, localDataLineMsgRecord.sessionid, 2);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     al
 * JD-Core Version:    0.7.0.1
 */