import android.text.TextUtils;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.model.FriendManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class cgy
  extends CardObserver
{
  public cgy(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {}
    for (Object localObject2 = (Card)paramObject;; localObject2 = null)
    {
      if ((paramBoolean) && (localObject2 != null))
      {
        if ((DiscussionInfoCardActivity.a(this.a) != 0) || (!DiscussionInfoCardActivity.a(this.a).equals(((Card)localObject2).uin))) {
          break label148;
        }
        paramObject = ((FriendManager)this.a.b.getManager(8)).b(DiscussionInfoCardActivity.a(this.a));
        if ((!TextUtils.isEmpty(paramObject)) && (!paramObject.equals(DiscussionInfoCardActivity.b(this.a))))
        {
          DiscussionInfoCardActivity.a(this.a, paramObject);
          ((HashMap)DiscussionInfoCardActivity.a(this.a).get(0)).put("memberName", DiscussionInfoCardActivity.b(this.a));
          DiscussionInfoCardActivity.a(this.a).notifyDataSetChanged();
        }
      }
      return;
      label148:
      while (DiscussionInfoCardActivity.a(this.a) != 3000) {}
      paramObject = (FriendManager)this.a.b.getManager(8);
      String str = ((Card)localObject2).uin;
      Object localObject3 = paramObject.c(str);
      Object localObject1 = paramObject.b(str);
      paramObject = localObject1;
      if (localObject3 != null)
      {
        paramObject = localObject1;
        if (!((Friends)localObject3).isFriend()) {
          if (!TextUtils.isEmpty(((Card)localObject2).strAutoRemark))
          {
            localObject1 = ((Card)localObject2).strAutoRemark;
            label237:
            paramObject = localObject1;
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              break label351;
            }
            paramObject = ((Card)localObject2).uin;
          }
        }
      }
      label351:
      for (;;)
      {
        localObject1 = DiscussionInfoCardActivity.a(this.a).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (HashMap)((Iterator)localObject1).next();
        localObject3 = (String)((HashMap)localObject2).get("memberUin");
        if ((localObject3 == null) || (!((String)localObject3).equals(str))) {
          break;
        }
        ((HashMap)localObject2).put("memberName", paramObject);
        if (DiscussionInfoCardActivity.a(this.a) == null) {
          break;
        }
        DiscussionInfoCardActivity.a(this.a).notifyDataSetChanged();
        return;
        localObject1 = ((Card)localObject2).strNick;
        break label237;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cgy
 * JD-Core Version:    0.7.0.1
 */