import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qidian.QidianProfileCardActivity.b;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

public class asgz
  extends acfd
{
  public asgz(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    super.onUpdateCustomHead(paramBoolean, paramString);
    if (paramBoolean)
    {
      if (!paramString.equals(this.this$0.a.e.uin)) {
        break label86;
      }
      if (!anlm.ayn()) {
        break label64;
      }
      this.this$0.mAvatarBitmap = this.this$0.app.a(paramString, (byte)2, false);
      this.this$0.enw();
    }
    label64:
    label86:
    do
    {
      return;
      this.this$0.mAvatarBitmap = this.this$0.app.getFaceBitmap(paramString, false);
      break;
      paramString = (QidianProfileCardActivity.b)this.this$0.jC.get(paramString);
    } while (paramString == null);
    this.this$0.a(paramString.type, (URLImageView)paramString.view.get(), paramString.key, true);
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.this$0.a.e.uin.equals(String.valueOf(paramObject)))) {
      this.this$0.enu();
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2) && (this.this$0.a.e.uin != null) && (!ProfileActivity.AllInOne.b(this.this$0.a.e)) && (this.this$0.c != null) && (this.this$0.c.isFriend(this.this$0.a.e.uin)) && (!this.this$0.a.e.uin.equals(this.this$0.app.getCurrentAccountUin())))
    {
      this.this$0.a.e.pa = 1;
      QidianProfileCardActivity.b(this.this$0, this.this$0.a.e.uin);
      this.this$0.enu();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asgz
 * JD-Core Version:    0.7.0.1
 */