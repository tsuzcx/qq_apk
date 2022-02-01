import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.qcall.QCallDetailActivity.9.1;

public class alkl
  extends aqxb
{
  public alkl(QCallDetailActivity paramQCallDetailActivity) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        paramObject = (Bundle)paramObject;
      } while ((paramObject == null) || (TextUtils.isEmpty(QCallDetailActivity.a(this.this$0))) || (!QCallDetailActivity.a(this.this$0).equals(paramObject.getString("uin"))));
      if (this.this$0.app != null) {
        this.this$0.app.removeObserver(this);
      }
    } while (!paramBoolean);
    this.this$0.runOnUiThread(new QCallDetailActivity.9.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alkl
 * JD-Core Version:    0.7.0.1
 */