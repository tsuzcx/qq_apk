import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.model.FriendManager;

public class bui
  extends CardObserver
{
  public bui(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      Object localObject;
      String str;
      TextView localTextView;
      if ((paramBoolean) && (paramObject != null) && (paramObject.uin != null) && (paramObject.uin.equals(this.a.getIntent().getExtras().getString("uin"))))
      {
        localObject = (FriendManager)this.a.b.getManager(8);
        str = ((FriendManager)localObject).d(paramObject.uin);
        localObject = ((FriendManager)localObject).c(paramObject.uin);
        localTextView = (TextView)this.a.findViewById(2131231090);
        if (!AddFriendVerifyActivity.a(this.a)) {
          break label138;
        }
        if (!((String)localObject).equals(paramObject.uin)) {
          localTextView.setText((CharSequence)localObject);
        }
      }
      return;
      label138:
      localTextView.setText(String.format("%s(%s)", new Object[] { localObject, str }));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bui
 * JD-Core Version:    0.7.0.1
 */