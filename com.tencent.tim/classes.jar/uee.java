import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;

public class uee
  extends accn
{
  public uee(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    Object localObject;
    if ((paramBoolean) && (paramObject != null))
    {
      if (!(paramObject instanceof Card)) {
        break label163;
      }
      localObject = (Card)paramObject;
      if ((((Card)localObject).uin != null) && (((Card)localObject).uin.equals(AddFriendVerifyActivity.a(this.this$0))))
      {
        paramObject = aqep.a(this.this$0, ((Card)localObject).shGender, ((Card)localObject).age, ((Card)localObject).strCountry, ((Card)localObject).strProvince, ((Card)localObject).strCity);
        if (this.this$0.a != null) {
          paramObject = aqep.a(this.this$0, ((Card)localObject).shGender, 0, "", "", "");
        }
        if (!TextUtils.isEmpty(paramObject))
        {
          this.this$0.BL.setVisibility(0);
          this.this$0.BL.setText(paramObject);
        }
      }
    }
    for (;;)
    {
      if (asgx.ag(this.this$0.app, AddFriendVerifyActivity.a(this.this$0))) {
        this.this$0.BL.setVisibility(8);
      }
      return;
      label163:
      if ((paramObject instanceof ContactCard))
      {
        localObject = (ContactCard)paramObject;
        if ((((ContactCard)localObject).mobileNo != null) && (((ContactCard)localObject).mobileNo.equals(AddFriendVerifyActivity.a(this.this$0))))
        {
          paramObject = aqep.a(this.this$0, ((ContactCard)localObject).bSex, ((ContactCard)localObject).bAge, ((ContactCard)localObject).strCountry, ((ContactCard)localObject).strProvince, ((ContactCard)localObject).strCity);
          if (this.this$0.a != null) {
            paramObject = aqep.a(this.this$0, ((ContactCard)localObject).bSex, 0, "", "", "");
          }
          if (!TextUtils.isEmpty(paramObject))
          {
            this.this$0.BL.setVisibility(0);
            this.this$0.BL.setText(paramObject);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uee
 * JD-Core Version:    0.7.0.1
 */