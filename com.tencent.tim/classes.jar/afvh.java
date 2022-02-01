import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;

class afvh
  extends jnm.c
{
  afvh(afvg paramafvg, boolean paramBoolean) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    boolean bool = true;
    if (paramInt != 0)
    {
      QLog.e("ExtendFriendHandler", 1, "setShowVipIconSwitch error: " + paramInt);
      ExtendFriendProfileEditFragment.a(this.a.this$0).setOnCheckedChangeListener(null);
      paramArrayOfByte = ExtendFriendProfileEditFragment.a(this.a.this$0);
      if (!this.val$isChecked) {}
      for (bool = true;; bool = false)
      {
        paramArrayOfByte.setChecked(bool);
        ExtendFriendProfileEditFragment.a(this.a.this$0).setOnCheckedChangeListener(ExtendFriendProfileEditFragment.a(this.a.this$0));
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandler", 2, "setShowVipIconSwitch(" + this.val$isChecked + ") success");
    }
    paramArrayOfByte = (afua)ExtendFriendProfileEditFragment.a(this.a.this$0).getTag();
    if (!this.val$isChecked) {}
    for (;;)
    {
      paramArrayOfByte.mVipHide = bool;
      VipUtils.a(paramArrayOfByte, ExtendFriendProfileEditFragment.a(this.a.this$0));
      paramArrayOfByte = this.a.this$0.getActivity();
      if (paramArrayOfByte == null) {
        break;
      }
      paramArrayOfByte.setResult(8193);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afvh
 * JD-Core Version:    0.7.0.1
 */