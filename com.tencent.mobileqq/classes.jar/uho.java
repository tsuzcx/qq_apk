import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.nearby.anim.NearbyZanAnimLayout;
import com.tencent.mobileqq.profile.like.PraiseInfo;
import com.tencent.mobileqq.profile.vote.VoteHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class uho
  extends Handler
{
  public uho(VisitorsActivity paramVisitorsActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    int k = 2;
    int m = 1;
    Object localObject;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      this.a.jdField_a_of_type_ComTencentWidgetXListView.springBackOverScrollHeaderView();
      return;
    case 4: 
      this.a.jdField_b_of_type_ComTencentWidgetXListView.springBackOverScrollHeaderView();
      return;
    case 2: 
      this.a.stopTitleProgress();
      this.a.jdField_a_of_type_ComTencentWidgetXListView.springBackOverScrollHeaderView();
      this.a.jdField_b_of_type_ComTencentWidgetXListView.springBackOverScrollHeaderView();
      this.a.a(1, this.a.getString(2131434811));
      return;
    case 3: 
      if (this.a.jdField_h_of_type_Int == 0) {
        this.a.jdField_a_of_type_Uio.notifyDataSetChanged();
      }
      for (;;)
      {
        this.a.e = SystemClock.uptimeMillis();
        return;
        this.a.jdField_b_of_type_Uio.notifyDataSetChanged();
      }
    case 5: 
      paramMessage = paramMessage.obj;
      if ((paramMessage instanceof Object[]))
      {
        localObject = (Object[])paramMessage;
        paramMessage = (ArrayList)localObject[0];
        localObject = (ArrayList)localObject[1];
        this.a.jdField_a_of_type_JavaUtilArrayList.addAll(paramMessage);
        this.a.jdField_b_of_type_JavaUtilArrayList.addAll((Collection)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("VisitorsActivity", 2, "setDataSet visitor UI_ONINIT");
        }
        this.a.jdField_a_of_type_Uio.a(this.a.jdField_a_of_type_JavaUtilArrayList);
        if (QLog.isColorLevel()) {
          QLog.d("VisitorsActivity", 2, "setDataSet favor UI_ONINIT");
        }
        this.a.jdField_b_of_type_Uio.a(this.a.jdField_b_of_type_JavaUtilArrayList);
        this.a.jdField_a_of_type_Uio.notifyDataSetChanged();
        this.a.jdField_b_of_type_Uio.notifyDataSetChanged();
      }
      this.a.jdField_h_of_type_Boolean = true;
      if (!NetworkUtil.d(this.a))
      {
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 1000L);
        return;
      }
      this.a.a(true);
      return;
    case 6: 
      this.a.jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper.b();
      return;
    case 7: 
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "setDataSet fresh fav data");
      }
      this.a.jdField_b_of_type_Uio.a(this.a.jdField_b_of_type_JavaUtilArrayList);
      this.a.jdField_b_of_type_Uio.notifyDataSetChanged();
    case 8: 
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "setDataSet fresh fav data");
      }
      this.a.jdField_a_of_type_Uio.a(this.a.jdField_a_of_type_JavaUtilArrayList);
      this.a.jdField_a_of_type_Uio.notifyDataSetChanged();
      return;
    case 9: 
      paramMessage = (CardProfile)paramMessage.obj;
      this.a.jdField_a_of_type_ComTencentMobileqqProfileVoteVoteHelper.a(paramMessage);
      return;
    case 10: 
      this.a.a(false, paramMessage.arg1, paramMessage.arg2, paramMessage.getData().getInt("totalVoteCount"));
      return;
    case 11: 
      int i = paramMessage.arg1;
      int n = paramMessage.arg2;
      int j;
      PraiseInfo localPraiseInfo;
      float f1;
      float f2;
      if (i > 20)
      {
        i = 20;
        j = m;
        if (i > 0)
        {
          localObject = (Object[])paramMessage.obj;
          j = m;
          if (localObject != null)
          {
            j = m;
            if (localObject.length == 2)
            {
              int i1 = ((Integer)localObject[0]).intValue();
              if (this.a.jdField_h_of_type_Int != 0) {
                break label928;
              }
              paramMessage = this.a.jdField_a_of_type_ComTencentWidgetXListView;
              int i2 = paramMessage.getFirstVisiblePosition();
              int i3 = paramMessage.getLastVisiblePosition();
              j = m;
              if (i1 >= i2)
              {
                j = m;
                if (i1 <= i3)
                {
                  paramMessage = paramMessage.getChildAt(i1 - i2 + paramMessage.getHeaderViewsCount());
                  j = m;
                  if (paramMessage != null)
                  {
                    paramMessage = (TextView)paramMessage.findViewById(2131364868);
                    j = m;
                    if (paramMessage != null)
                    {
                      int[] arrayOfInt = new int[2];
                      paramMessage.getLocationInWindow(arrayOfInt);
                      localPraiseInfo = (PraiseInfo)localObject[1];
                      if (!TextUtils.isEmpty(localPraiseInfo.jdField_b_of_type_JavaLangString)) {
                        break label939;
                      }
                      j = 1;
                      if (!TextUtils.isEmpty(paramMessage.getText())) {
                        break label954;
                      }
                      m = arrayOfInt[0];
                      f1 = j * paramMessage.getWidth() / k + m;
                      j = arrayOfInt[1];
                      k = this.a.i;
                      f2 = paramMessage.getPaddingTop() + (j - k);
                      if ((n <= 0) || (localPraiseInfo.c == null)) {
                        break label970;
                      }
                      this.a.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a(localPraiseInfo.c, f1, f2);
                      label809:
                      i -= 1;
                      if (i <= 0) {
                        break label990;
                      }
                      paramMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(11, i, n, localObject);
                      if (this.a.jdField_a_of_type_JavaUtilRandom == null) {
                        this.a.jdField_a_of_type_JavaUtilRandom = new Random();
                      }
                      i = com.tencent.mobileqq.dating.NewVoteAnimHelper.a[this.a.jdField_a_of_type_JavaUtilRandom.nextInt(com.tencent.mobileqq.dating.NewVoteAnimHelper.a.length)];
                      this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, i * 5);
                    }
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        j = 0;
        if (j == 0) {
          break;
        }
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(12, 100L);
        return;
        break label541;
        label928:
        paramMessage = this.a.jdField_b_of_type_ComTencentWidgetXListView;
        break label612;
        label939:
        j = localPraiseInfo.jdField_b_of_type_JavaLangString.length() + 1;
        break label721;
        label954:
        k = paramMessage.getText().length() * 2;
        break label731;
        label970:
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a(localPraiseInfo.jdField_b_of_type_AndroidGraphicsBitmap, f1, f2);
        break label809;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(12, 2000L);
      }
    case 12: 
      label541:
      label612:
      this.a.j = false;
      label721:
      label731:
      label990:
      return;
    }
    this.a.b(paramMessage.arg1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uho
 * JD-Core Version:    0.7.0.1
 */