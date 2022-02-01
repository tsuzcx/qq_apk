import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout.b;
import com.tencent.qphone.base.util.QLog;

public class nkx
  implements CommonSuspensionGestureLayout.b
{
  public nkx(FastWebActivity paramFastWebActivity) {}
  
  public void W(boolean paramBoolean, int paramInt)
  {
    QLog.d(FastWebActivity.a(this.this$0), 2, "mFloating onCustomAnimStart");
  }
  
  public void aZl()
  {
    QLog.d(FastWebActivity.a(this.this$0), 2, "mFloating onPageExposure");
  }
  
  public void aZm()
  {
    QLog.d(FastWebActivity.a(this.this$0), 2, "mFloating onPopAnimStart");
  }
  
  public void aZn()
  {
    QLog.d(FastWebActivity.a(this.this$0), 2, "mFloating onPopAnimEnd");
  }
  
  public void h(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    FastWebActivity.a(this.this$0, true);
    FastWebActivity.a(this.this$0, false);
    FastWebActivity.b(this.this$0);
    if ((paramInt2 != 3) && (paramInt2 != 5)) {
      this.this$0.overridePendingTransition(0, 0);
    }
    if (paramInt2 == 5)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("float_layer_finsh_action");
      this.this$0.sendBroadcast(localIntent);
    }
    QLog.d(FastWebActivity.a(this.this$0), 2, "mFloating mCommonSuspensionGestureLayout onPageClose type = " + paramInt2);
  }
  
  public void mT(int paramInt)
  {
    QLog.d(FastWebActivity.a(this.this$0), 2, "mFloating onStateChange");
  }
  
  public void tM(int paramInt)
  {
    QLog.d(FastWebActivity.a(this.this$0), 2, "mFloating onPositionStateChange");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nkx
 * JD-Core Version:    0.7.0.1
 */