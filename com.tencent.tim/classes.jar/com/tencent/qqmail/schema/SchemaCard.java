package com.tencent.qqmail.schema;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.AccountTypeListActivity;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.card.QMCardManager;
import com.tencent.qqmail.card.fragment.CardFragmentActivity;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.ArrayList;
import java.util.Random;

public class SchemaCard
  extends SchemaBase
{
  private static final String PARAM_ACTION = "action";
  private static final String PARAM_CARD_CATAGORY = "catagory";
  private static final String PARAM_CARD_ID = "cardid";
  private static final String PARAM_CARD_TO = "to";
  private static final String PARAM_CARD_TO_SEL = "to_sel";
  private static final String PARAM_CARD_TO_TOTAL = "to_total";
  private static final String VALUE_CARD_BIRTHDAY = "birthday";
  private static final String VALUE_CARD_COMPOSE_CARD = "composecard";
  private static final String VALUE_CARD_MAIN = "main";
  private static final String VALUE_CARD_PREVIEW = "preview";
  private static final String VALUE_CARD_SEND = "sendcard";
  private String TAG = "SchemaCard";
  private String action;
  private ArrayList<String> cardIdList = Lists.newArrayList();
  private String cardid;
  private String catagory;
  private String to;
  private String to_sel;
  private String to_total;
  
  public SchemaCard(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  public boolean doAction(int paramInt)
  {
    Object localObject = AccountManager.shareInstance().getAccountList();
    if ((localObject == null) || (((AccountList)localObject).size() == 0)) {
      localObject = AccountTypeListActivity.createIntent();
    }
    for (;;)
    {
      if (localObject != null)
      {
        this.context.startActivity((Intent)localObject);
        return true;
        if (this.action.equals("main"))
        {
          if (StringExtention.isNullOrEmpty(this.catagory)) {}
          for (paramInt = QMCardManager.shareInstance().getJumpCardDefaulType();; paramInt = Integer.valueOf(this.catagory).intValue())
          {
            localObject = CardFragmentActivity.createIntentToGallery(paramInt, true);
            break;
          }
        }
        if (this.cardIdList.size() > 0)
        {
          localObject = new Random();
          this.cardid = ((String)this.cardIdList.get(((Random)localObject).nextInt(this.cardIdList.size())));
          if (this.action.equals("preview"))
          {
            localObject = CardFragmentActivity.createIntentToPreview(this.cardid);
            continue;
          }
          if (this.action.equals("sendcard"))
          {
            if (StringExtention.isNullOrEmpty(this.to_total))
            {
              localObject = "0";
              label179:
              paramInt = Integer.valueOf((String)localObject).intValue();
              if (!StringExtention.isNullOrEmpty(this.to_sel)) {
                break label233;
              }
            }
            label233:
            for (localObject = "0";; localObject = this.to_sel)
            {
              int i = Integer.valueOf((String)localObject).intValue();
              localObject = CardFragmentActivity.createIntentToPopChoose(this.cardid, this.to, paramInt, i);
              break;
              localObject = this.to_total;
              break label179;
            }
          }
          if (this.action.equals("birthday"))
          {
            localObject = CardFragmentActivity.createIntentToBirthday(this.cardid);
            continue;
          }
          if (this.action.equals("composecard"))
          {
            localObject = new ComposeMailUI();
            ((ComposeMailUI)localObject).setType(ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_CARD);
            MailInformation localMailInformation = new MailInformation();
            localMailInformation.setMessageId(ComposeMailUI.genMessageId());
            localMailInformation.setAccountId(QMSettingManager.sharedInstance().getDefaultMailAccountID());
            ((ComposeMailUI)localObject).setInformation(localMailInformation);
            localObject = ComposeMailActivity.createIntentFromSchemaCard(QMApplicationContext.sharedInstance(), (ComposeMailUI)localObject, this.cardid, this.to);
          }
        }
      }
      else
      {
        return false;
      }
      localObject = null;
    }
  }
  
  public void parseParams()
  {
    for (;;)
    {
      int i;
      Object localObject2;
      Object localObject1;
      try
      {
        if (this.params != null)
        {
          String[] arrayOfString = this.params.split("&");
          int k = arrayOfString.length;
          i = 0;
          if (i < k)
          {
            localObject2 = arrayOfString[i].split("=");
            if (localObject2.length != 2) {
              break label234;
            }
            localObject1 = Uri.decode(localObject2[0]);
            localObject2 = Uri.decode(localObject2[1]);
            if (((String)localObject1).equals("action"))
            {
              this.action = ((String)localObject2);
            }
            else if (((String)localObject1).equals("cardid"))
            {
              localObject1 = ((String)localObject2).split(",");
              int m = localObject1.length;
              int j = 0;
              if (j < m)
              {
                localObject2 = localObject1[j];
                this.cardIdList.add(localObject2);
                j += 1;
                continue;
              }
            }
            else if (((String)localObject1).equals("to"))
            {
              this.to = ((String)localObject2);
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QMLog.log(6, this.TAG, localException.getMessage());
      }
      return;
      if (((String)localObject1).equals("to_total")) {
        this.to_total = ((String)localObject2);
      } else if (((String)localObject1).equals("to_sel")) {
        this.to_sel = ((String)localObject2);
      } else if (((String)localObject1).equals("catagory")) {
        this.catagory = ((String)localObject2);
      }
      label234:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.schema.SchemaCard
 * JD-Core Version:    0.7.0.1
 */