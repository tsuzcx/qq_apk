import com.tencent.image.URLDrawable;
import com.tencent.image.VideoDrawable;
import com.tencent.image.VideoDrawable.OnPlayRepeatListener;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.qphone.base.util.QLog;

public class adwb
  implements VideoDrawable.OnPlayRepeatListener
{
  public adwb(DynamicAvatarView paramDynamicAvatarView) {}
  
  public void onPlayRepeat(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.dynamicAvatar", 2, "onPlayRepeat: " + paramInt);
    }
    if ((this.this$0.bRs) || (paramInt < 1)) {}
    while (this.this$0.b == null) {
      return;
    }
    Object localObject = this.this$0.b.N;
    if ((localObject instanceof URLDrawable))
    {
      localObject = ((URLDrawable)localObject).getCurrDrawable();
      if ((localObject instanceof VideoDrawable))
      {
        ((VideoDrawable)localObject).removeOnPlayRepeatListener(this);
        this.this$0.b.b.a(this.this$0.b, true);
        if (QLog.isColorLevel()) {
          QLog.e("Q.dynamicAvatar", 2, "removeOnPlayRepeatListener.03");
        }
      }
    }
    this.this$0.b.N = null;
    this.this$0.cUN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adwb
 * JD-Core Version:    0.7.0.1
 */