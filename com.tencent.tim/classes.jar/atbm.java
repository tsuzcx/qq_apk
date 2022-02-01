import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;

class atbm
  implements Handler.Callback
{
  atbm(atbj paramatbj) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject = (acff)this.this$0.mApp.getManager(51);
    switch (paramMessage.what)
    {
    default: 
    case 1: 
      Card localCard;
      do
      {
        return true;
        paramMessage = (String)paramMessage.obj;
        localCard = aqep.a(this.this$0.mApp, paramMessage);
      } while ((localCard == null) || (localObject == null));
      if ((((acff)localObject).isFriend(localCard.uin)) && (!this.this$0.c.e.uin.equals(this.this$0.mApp.getCurrentAccountUin())) && (!ProfileActivity.AllInOne.b(this.this$0.c.e))) {
        this.this$0.c.e.pa = 1;
      }
      this.this$0.c.d = localCard;
      this.this$0.a(localCard, false, 1);
      localObject = localCard.vSeed;
      paramMessage = null;
      if ((this.this$0.c.e.pa == 56) || (this.this$0.c.e.pa == 57)) {}
      for (paramMessage = this.this$0.c.e.cf;; paramMessage = this.this$0.c.e.cf) {
        do
        {
          this.this$0.a(localCard.feedPreviewTime, (byte[])localObject, paramMessage, false);
          atbj.b(this.this$0);
          return true;
        } while ((this.this$0.c.e.pa != 35) && (this.this$0.c.e.pa != 37) && (this.this$0.c.e.pa != 36));
      }
    }
    if ((paramMessage.obj instanceof Card))
    {
      this.this$0.a((Card)paramMessage.obj, true, 8);
      return true;
    }
    this.this$0.a(this.this$0.c.d, true, 8);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atbm
 * JD-Core Version:    0.7.0.1
 */