package com.tencent.mobileqq.activity;

import acff;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import vbv;

public class FriendProfilePhotoHelper$1
  implements Runnable
{
  public FriendProfilePhotoHelper$1(vbv paramvbv) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = (acff)this.this$0.app.getManager(51);
      Object localObject2 = ((acff)localObject1).b(this.this$0.app.getCurrentAccountUin());
      if (localObject2 == null) {
        return;
      }
      if (((Card)localObject2).checkCoverUrl(this.this$0.ca)) {
        ((Card)localObject2).updateCoverData(this.this$0.ca);
      }
      ((acff)localObject1).a((Card)localObject2);
      localObject1 = ((Card)localObject2).getCoverData(this.this$0.bHA);
      localObject2 = (String)localObject1[0];
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject2).equals(this.this$0.mCoverUrl)))
      {
        this.this$0.mCoverUrl = ((String)localObject2);
        this.this$0.bHA = ((Integer)localObject1[1]).intValue();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfilePhotoHelper.1
 * JD-Core Version:    0.7.0.1
 */