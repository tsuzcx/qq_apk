import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class aaxq
  extends acdv
{
  public aaxq(SelectMemberActivity paramSelectMemberActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString)
  {
    if (!paramBoolean) {
      SelectMemberActivity.bAJ = false;
    }
    if (this.this$0.c != null)
    {
      this.this$0.c.dismiss();
      if (paramBoolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SelectMemberActivity", 2, "create discussion success: roomId: " + paramLong + ", mSubType: " + this.this$0.bGG + ", mEntrance: " + this.this$0.eK);
        }
        paramString = new ArrayList();
        Iterator localIterator = this.this$0.aQ.iterator();
        while (localIterator.hasNext())
        {
          ResultRecord localResultRecord = (ResultRecord)localIterator.next();
          if (localResultRecord.type == 5)
          {
            if (localResultRecord.uin.startsWith("pstn")) {
              localResultRecord.uin = localResultRecord.uin.substring("pstn".length());
            }
            paramString.add(localResultRecord.uin);
          }
          else if ((localResultRecord.type == 4) && (localResultRecord.uin.startsWith("+")))
          {
            paramString.add(localResultRecord.uin);
          }
        }
        this.this$0.mIntent.putExtra("roomId", paramLong);
        if (this.this$0.eK == 12) {
          this.this$0.mIntent.putExtra("select_memeber_discussion_memeber_count", this.this$0.aQ.size() + 1);
        }
        this.this$0.mIntent.putParcelableArrayListExtra("result_set", this.this$0.aQ);
        this.this$0.setResult(-1, this.this$0.mIntent);
        this.this$0.finish();
      }
    }
    else
    {
      return;
    }
    QLog.d("SelectMemberActivity", 1, "create discussion fail, errCode=" + paramInt);
    if (paramInt == 1000)
    {
      QQToast.a(this.this$0, this.this$0.getString(2131699836), 2000).show(this.this$0.mTitleBar.getHeight());
      anot.a(this.this$0.app, "dc00899", "Grp_set", "", "Grp_data", "forbid_discuss", 0, 0, "", "", "", "");
      return;
    }
    QQToast.a(this.this$0, this.this$0.getString(2131692823), 2000).show(this.this$0.mTitleBar.getHeight());
  }
  
  protected void b(boolean paramBoolean, int paramInt, long paramLong, ArrayList<String> paramArrayList)
  {
    if (this.this$0.c != null)
    {
      this.this$0.c.dismiss();
      if (!paramBoolean) {
        break label231;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "add discussion member success: roomId: " + paramLong);
      }
      paramArrayList = new ArrayList();
      Iterator localIterator = this.this$0.aQ.iterator();
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        if (localResultRecord.type == 5)
        {
          if (localResultRecord.uin.startsWith("pstn")) {
            localResultRecord.uin = localResultRecord.uin.substring("pstn".length());
          }
          paramArrayList.add(localResultRecord.uin);
        }
      }
      this.this$0.mIntent.putExtra("roomId", paramLong);
      this.this$0.mIntent.putParcelableArrayListExtra("result_set", this.this$0.aQ);
      if (!paramBoolean) {
        break label213;
      }
      this.this$0.setResult(-1, this.this$0.mIntent);
    }
    for (;;)
    {
      this.this$0.finish();
      return;
      label213:
      this.this$0.setResult(1, this.this$0.mIntent);
    }
    label231:
    if (QLog.isColorLevel()) {
      QLog.d("SelectMemberActivity", 2, "add discussion member fail");
    }
    if (paramInt == 1000) {
      anot.a(this.this$0.app, "dc00899", "Grp_set", "", "Grp_data", "forbid_discuss", 0, 0, "", "", "", "");
    }
    QQToast.a(this.this$0, this.this$0.getString(2131692818), 2000).show(this.this$0.mTitleBar.getHeight());
  }
  
  protected void w(Object[] paramArrayOfObject)
  {
    if (this.this$0.c != null) {
      this.this$0.c.dismiss();
    }
    if (paramArrayOfObject == null) {}
    String str;
    do
    {
      return;
      str = (String)paramArrayOfObject[0];
    } while (!this.this$0.aRJ.equals(str));
    int i = ((Integer)paramArrayOfObject[1]).intValue();
    QLog.d("SelectMemberActivity", 2, "add discussion member failed, error code: " + i);
    QQToast.a(this.this$0, this.this$0.getString(2131692818), 0).show(this.this$0.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaxq
 * JD-Core Version:    0.7.0.1
 */