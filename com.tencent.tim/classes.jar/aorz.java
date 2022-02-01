import android.content.Intent;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.troop.activity.AbsPublishActivity;
import com.tencent.mobileqq.troop.activity.AudioRecordFragment;
import mqq.app.QQPermissionCallback;

class aorz
  implements QQPermissionCallback
{
  aorz(aory paramaory) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    aqha.a(this.a.this$0, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = new Intent();
    paramArrayOfString.putExtra("audio_max_length", this.a.this$0.dRz);
    if (this.a.this$0.mBid != null)
    {
      paramArrayOfString.putExtra("from", "publish");
      paramArrayOfString.putExtra("bid", this.a.this$0.mBid);
      paramArrayOfString.putExtra("fromflag", this.a.this$0.cmL);
      aprv.d(this.a.this$0.cmV, this.a.this$0.mOpType, "Clk_record", this.a.this$0.mBid, this.a.this$0.cmL, "", "");
    }
    PublicFragmentActivity.b.startForResult(this.a.this$0.mActivity, paramArrayOfString, PublicTransFragmentActivity.class, AudioRecordFragment.class, 1003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aorz
 * JD-Core Version:    0.7.0.1
 */