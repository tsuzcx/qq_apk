import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendBaseFragment;
import com.tencent.qphone.base.util.QLog;

public class afuf
  extends afsr
{
  public afuf(ExtendFriendBaseFragment paramExtendFriendBaseFragment) {}
  
  protected void a(boolean paramBoolean, afua paramafua, int paramInt)
  {
    if (paramInt != ExtendFriendBaseFragment.a(this.this$0)) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (paramafua == null));
      localObject = ((acff)this.this$0.mApp.getManager(51)).b(this.this$0.mApp.getCurrentUin());
    } while (localObject == null);
    ExtendFriendBaseFragment localExtendFriendBaseFragment = this.this$0;
    if (!TextUtils.isEmpty(paramafua.mDeclaration)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localExtendFriendBaseFragment.caM = paramBoolean;
      this.this$0.caN = ((Card)localObject).isShowCard;
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBaseFragment", 2, String.format("addMyFeed mProfileComplete=%s mShowCard=%s", new Object[] { Boolean.valueOf(this.this$0.caM), Boolean.valueOf(this.this$0.caN) }));
      }
      if (this.this$0.a == null) {
        break;
      }
      localObject = this.this$0.a.a(0);
      paramafua.mIsMyFeed = true;
      if ((localObject != null) && (TextUtils.equals(((afua)localObject).mUin, paramafua.mUin))) {
        this.this$0.a.remove(0);
      }
      this.this$0.a.a(0, paramafua);
      if (!TextUtils.isEmpty(paramafua.mDeclaration)) {
        paramafua.mDeclaration = paramafua.mDeclaration.replace('\n', ' ').trim();
      }
      if ((!this.this$0.caN) || (!this.this$0.caM)) {
        this.this$0.a.remove(0);
      }
      this.this$0.a.notifyDataSetChanged();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afuf
 * JD-Core Version:    0.7.0.1
 */