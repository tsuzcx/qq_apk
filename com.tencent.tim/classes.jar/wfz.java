import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.VisitorsActivity.d;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.nearby.anim.NearbyZanAnimLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class wfz
  extends Handler
{
  public wfz(VisitorsActivity paramVisitorsActivity) {}
  
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
      this.this$0.e.springBackOverScrollHeaderView();
      return;
    case 4: 
      this.this$0.e.springBackOverScrollHeaderView();
      return;
    case 2: 
      this.this$0.stopTitleProgress();
      this.this$0.e.springBackOverScrollHeaderView();
      this.this$0.e.springBackOverScrollHeaderView();
      this.this$0.aL(1, this.this$0.getString(2131696272));
      return;
    case 3: 
      if (this.this$0.aih == 0) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$d.notifyDataSetChanged();
      }
      for (;;)
      {
        this.this$0.HD = SystemClock.uptimeMillis();
        return;
        this.this$0.b.notifyDataSetChanged();
      }
    case 5: 
      paramMessage = paramMessage.obj;
      if ((paramMessage instanceof Object[]))
      {
        localObject = (Object[])paramMessage;
        paramMessage = (ArrayList)localObject[0];
        localObject = (ArrayList)localObject[1];
        this.this$0.pV.addAll(paramMessage);
        this.this$0.pW.addAll((Collection)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("VisitorsActivity", 2, "setDataSet visitor UI_ONINIT");
        }
        this.this$0.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$d.cV(this.this$0.pV);
        if (QLog.isColorLevel()) {
          QLog.d("VisitorsActivity", 2, "setDataSet favor UI_ONINIT");
        }
        this.this$0.b.cV(this.this$0.pW);
        this.this$0.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$d.notifyDataSetChanged();
        this.this$0.b.notifyDataSetChanged();
      }
      this.this$0.init = true;
      if (!aqiw.isNetSupport(this.this$0))
      {
        this.this$0.mHandler.sendEmptyMessageDelayed(2, 1000L);
        return;
      }
      this.this$0.ap(true);
      return;
    case 6: 
      this.this$0.jdField_a_of_type_Alhr.dFZ();
      return;
    case 7: 
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "setDataSet fresh fav data");
      }
      this.this$0.b.cV(this.this$0.pW);
      this.this$0.b.notifyDataSetChanged();
      return;
    case 8: 
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "setDataSet fresh fav data");
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$d.cV(this.this$0.pV);
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity$d.notifyDataSetChanged();
      return;
    case 9: 
      paramMessage = (CardProfile)paramMessage.obj;
      this.this$0.jdField_a_of_type_Alhr.b(paramMessage);
      return;
    case 10: 
      this.this$0.c(false, paramMessage.arg1, paramMessage.arg2, paramMessage.getData().getInt("totalVoteCount"));
      return;
    case 11: 
      int i = paramMessage.arg1;
      int n = paramMessage.arg2;
      int j;
      alen localalen;
      float f1;
      float f2;
      if (i > 20)
      {
        i = 20;
        j = m;
        if (i > 0)
        {
          paramMessage = (Object[])paramMessage.obj;
          j = m;
          if (paramMessage != null)
          {
            j = m;
            if (paramMessage.length == 2)
            {
              int i1 = ((Integer)paramMessage[0]).intValue();
              localObject = this.this$0.e;
              int i2 = ((XListView)localObject).getFirstVisiblePosition();
              int i3 = ((XListView)localObject).getLastVisiblePosition();
              j = m;
              if (i1 >= i2)
              {
                j = m;
                if (i1 <= i3)
                {
                  localObject = ((XListView)localObject).getChildAt(i1 - i2 + ((XListView)localObject).getHeaderViewsCount());
                  j = m;
                  if (localObject != null)
                  {
                    localObject = (TextView)((View)localObject).findViewById(2131381025);
                    j = m;
                    if (localObject != null)
                    {
                      int[] arrayOfInt = new int[2];
                      ((TextView)localObject).getLocationInWindow(arrayOfInt);
                      localalen = (alen)paramMessage[1];
                      if (!TextUtils.isEmpty(localalen.text)) {
                        break label929;
                      }
                      j = 1;
                      if (!TextUtils.isEmpty(((TextView)localObject).getText())) {
                        break label944;
                      }
                      m = arrayOfInt[0];
                      f1 = j * ((TextView)localObject).getWidth() / k + m;
                      j = arrayOfInt[1];
                      k = this.this$0.bMU;
                      f2 = ((TextView)localObject).getPaddingTop() + (j - k);
                      if ((n <= 0) || (localalen.fS == null)) {
                        break label961;
                      }
                      this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a(localalen, localalen.fS, f1, f2);
                      i -= 1;
                      if (i <= 0) {
                        break label983;
                      }
                      paramMessage = this.this$0.mHandler.obtainMessage(11, i, n, paramMessage);
                      if (this.this$0.mRandom == null) {
                        this.this$0.mRandom = new Random();
                      }
                      i = afcy.kU[this.this$0.mRandom.nextInt(afcy.kU.length)];
                      this.this$0.mHandler.sendMessageDelayed(paramMessage, i * 5);
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
        this.this$0.mHandler.sendEmptyMessageDelayed(12, 100L);
        return;
        break label542;
        label929:
        j = localalen.text.length() + 1;
        break label718;
        k = ((TextView)localObject).getText().length() * 2;
        break label729;
        this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a(localalen, localalen.fR, f1, f2);
        break label811;
        this.this$0.mHandler.sendEmptyMessageDelayed(12, 2000L);
      }
    case 12: 
      label542:
      label718:
      label729:
      this.this$0.bcg = false;
      label811:
      label944:
      label961:
      label983:
      return;
    }
    this.this$0.BU(paramMessage.arg1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wfz
 * JD-Core Version:    0.7.0.1
 */