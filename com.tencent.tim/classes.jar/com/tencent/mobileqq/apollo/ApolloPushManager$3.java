package com.tencent.mobileqq.apollo;

import abht;
import abvg;
import abxk;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionPush;

public class ApolloPushManager$3
  implements Runnable
{
  public ApolloPushManager$3(abht paramabht, ApolloActionPush paramApolloActionPush, SpriteTaskParam paramSpriteTaskParam) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface;
    SpriteTaskParam localSpriteTaskParam;
    if ((this.b != null) && (this.a != null))
    {
      localQQAppInterface = abht.a(this.this$0);
      localSpriteTaskParam = this.a;
      if (TextUtils.isEmpty(this.b.mContent)) {
        break label99;
      }
    }
    label99:
    for (boolean bool = true;; bool = false)
    {
      abvg.a(localQQAppInterface, localSpriteTaskParam, bool, this.a.bEW);
      if ((abht.a(this.this$0) != null) && (this.b != null)) {
        ((abxk)abht.a(this.this$0).getManager(155)).hg(this.b.mId);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloPushManager.3
 * JD-Core Version:    0.7.0.1
 */