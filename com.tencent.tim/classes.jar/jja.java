import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

final class jja
  implements ausj.a
{
  jja(jln paramjln, int[] paramArrayOfInt, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Jln.dismiss();
    switch (this.cT[paramInt])
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt > 0) {
        anot.a(this.val$app, "CliOper", "", "", "0X800A518", "0X800A518", 0, paramInt, "", "", "", "");
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.cZ == 1)
      {
        jiy.b(this.val$app, this.val$context, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true);
        paramInt = 3;
      }
      else
      {
        jiy.b(this.val$app, this.val$context, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, this.lM, null);
        paramInt = 1;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.cZ == 1)
        {
          jiy.b(this.val$app, this.val$context, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
          paramInt = 4;
        }
        else
        {
          jiy.b(this.val$app, this.val$context, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, this.lM, null);
          paramInt = 2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jja
 * JD-Core Version:    0.7.0.1
 */