package com.tencent.mobileqq.apollo.view;

import abhh;
import acae;
import ahbj;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloBaseInfo;

class ApolloPanel$2
  implements Runnable
{
  ApolloPanel$2(ApolloPanel paramApolloPanel, boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  public void run()
  {
    if ((this.this$0.mBaseChatPie == null) || (this.this$0.mBaseChatPie.app == null)) {
      return;
    }
    ApolloBaseInfo localApolloBaseInfo = ((abhh)this.this$0.mBaseChatPie.app.getManager(153)).b(this.this$0.mBaseChatPie.app.getCurrentUin());
    if (localApolloBaseInfo != null) {}
    for (int i = localApolloBaseInfo.apolloStatus;; i = 0)
    {
      if (!this.bGK)
      {
        if (i != 0) {
          break label269;
        }
        this.this$0.a = new acae(this.this$0.mBaseChatPie.mContext, this.this$0.mBaseChatPie.app, this.this$0.g);
        this.this$0.a.setPanelType(1);
        this.this$0.a.a(this.this$0);
        this.this$0.a.Eo(true);
        this.this$0.notifyDataChange();
      }
      while ((i == 1) || (this.bGK))
      {
        if ((ahbj.isFileExists(ApolloUtil.bkb)) || (this.this$0.a == null)) {
          break label350;
        }
        this.this$0.a = new acae(this.this$0.mBaseChatPie.mContext, this.this$0.mBaseChatPie.app, this.this$0.g);
        this.this$0.a.setPanelType(3);
        this.this$0.a.a(this.this$0);
        this.this$0.notifyDataChange();
        return;
        label269:
        if (i == 2)
        {
          this.this$0.a = new acae(this.this$0.mBaseChatPie.mContext, this.this$0.mBaseChatPie.app, this.this$0.g);
          this.this$0.a.setPanelType(1);
          this.this$0.a.a(this.this$0);
          this.this$0.notifyDataChange();
        }
      }
      break;
      label350:
      ApolloPanel.a(this.this$0, 0);
      this.this$0.by(this.val$uin, this.bGL);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.2
 * JD-Core Version:    0.7.0.1
 */