package com.tencent.qqmail.card.fragment;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.card.model.QMCardData;
import com.tencent.qqmail.card.util.CardUtil;
import com.tencent.qqmail.utilities.template.Template;
import java.util.HashMap;

class CardBirthdayChooseFragment$10$1
  implements Runnable
{
  CardBirthdayChooseFragment$10$1(CardBirthdayChooseFragment.10 param10, String paramString) {}
  
  public void run()
  {
    String str = Template.getTemplate(this.this$1.this$0.getActivity(), Template.CONTENT_HTML_CARD);
    str = str.substring(str.indexOf("<body style=\"margin:0;padding:0\">"), str.lastIndexOf("</body>"));
    HashMap localHashMap = CardUtil.allReplaceIntem();
    localHashMap.put(Integer.valueOf(2131691305), ".greetingCard_previewBtn {display: none !important;} .greetingCard_thanksBtn {display: none !important;}");
    localHashMap.put(Integer.valueOf(2131691313), CardBirthdayChooseFragment.access$1300(this.this$1.this$0).getCardMailUrl());
    localHashMap.put(Integer.valueOf(2131691312), CardBirthdayChooseFragment.access$1300(this.this$1.this$0).getCardOnePxUrl());
    localHashMap.put(Integer.valueOf(2131691306), this.val$h5Url + CardUtil.getFromPlatform(ShareLinkToExternal.SharedType.SHARE_TO_MAIL));
    localHashMap.put(Integer.valueOf(2131691304), CardBirthdayChooseFragment.access$1300(this.this$1.this$0).getMailWord());
    localHashMap.put(Integer.valueOf(2131691310), CardUtil.getDefaultSendName());
    localHashMap.put(Integer.valueOf(2131691311), "http://i.mail.qq.com/cgi-bin/uma_ack_card?" + String.format("cardid=%s", new Object[] { CardBirthdayChooseFragment.access$1300(this.this$1.this$0).getCardId() }) + CardUtil.getFromPlatform(ShareLinkToExternal.SharedType.SHARE_TO_MAIL) + "&email=1");
    localHashMap.put(Integer.valueOf(2131691308), "http://i.mail.qq.com/cgi-bin/uma_compose_card");
    localHashMap.put(Integer.valueOf(2131691309), CardBirthdayChooseFragment.access$1400(this.this$1.this$0).getEmail());
    str = CardUtil.replaceContentInSequence(str, localHashMap);
    CardBirthdayChooseFragment.access$1500(this.this$1.this$0, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardBirthdayChooseFragment.10.1
 * JD-Core Version:    0.7.0.1
 */