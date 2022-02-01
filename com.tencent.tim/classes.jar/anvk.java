import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class anvk
  implements View.OnClickListener
{
  anvk(anvf paramanvf) {}
  
  public void onClick(View paramView)
  {
    Object localObject8 = null;
    Context localContext = paramView.getContext();
    Object localObject1 = paramView.getTag(2131378850);
    if ((localObject1 != null) && ((localObject1 instanceof anvf.b)))
    {
      localObject1 = (anvf.b)localObject1;
      if ((!(this.this$0.e instanceof StructMsgForGeneralShare)) || (TextUtils.isEmpty(((StructMsgForGeneralShare)this.this$0.e).mMsgActionData)) || (!((StructMsgForGeneralShare)this.this$0.e).mMsgActionData.startsWith("mqqapi://qsubscribe"))) {}
    }
    else
    {
      try
      {
        localObject1 = new Intent(localContext, JumpActivity.class);
        ((Intent)localObject1).setData(Uri.parse(((StructMsgForGeneralShare)this.this$0.e).mMsgActionData));
        ((Intent)localObject1).putExtra("from", "from_aio");
        localContext.startActivity((Intent)localObject1);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localException1.printStackTrace();
        }
      }
    }
    if (this.this$0.type == 4) {
      if ((this.this$0.e == null) || (this.this$0.e.message == null)) {
        break label900;
      }
    }
    Object localObject3;
    label900:
    for (Object localObject2 = this.this$0.e.message.getExtInfoFromExtStr("public_account_msg_id");; localObject3 = "")
    {
      Object localObject4 = (String)paramView.getTag(2131378856);
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        break;
      }
      String str = aurr.addParameter(aurr.addParameter((String)localObject4, "progress", String.valueOf(0L)), "msgId", (String)localObject2);
      Intent localIntent = new Intent(localContext, QQBrowserActivity.class);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      for (;;)
      {
        for (;;)
        {
          Object localObject10;
          Object localObject5;
          try
          {
            localObject2 = this.this$0.e.message.getExtInfoFromExtStr("gdt_view_id");
            try
            {
              localObject4 = this.this$0.e.message.getExtInfoFromExtStr("gdt_msgImp");
              if (TextUtils.isEmpty((CharSequence)localObject4))
              {
                localObject6 = new JSONObject();
                localObject4 = ((JSONObject)localObject6).optString("ad_id");
              }
            }
            catch (Exception localException3)
            {
              localObject10 = null;
              localObject6 = localObject8;
              localObject5 = localObject2;
              localObject2 = localObject10;
            }
          }
          catch (Exception localException2)
          {
            StringBuilder localStringBuilder;
            localObject3 = null;
            localObject5 = null;
            Object localObject6 = localObject8;
            continue;
          }
          Object localObject7;
          try
          {
            localObject6 = ((JSONObject)localObject6).optString("key");
          }
          catch (Exception localException4)
          {
            localObject10 = null;
            localObject7 = localObject3;
            localObject8 = localObject5;
            localObject3 = localObject10;
            localObject5 = localObject7;
            localObject7 = localObject8;
            continue;
          }
          try
          {
            localObject8 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            localObject10 = new kds.a();
            ((kds.a)localObject10).aId = 3;
            ((kds.a)localObject10).aIh = 1;
            localObject10 = kds.a((kds.a)localObject10, this.this$0.e.message);
            ((kds)((QQAppInterface)localObject8).getBusinessHandler(139)).a((kds.a)localObject10, null);
            Long.parseLong((String)localObject4);
            localObject8 = localObject6;
            localObject6 = localObject4;
            localObject4 = localObject8;
            localObject8 = localObject2;
            if (localObject2 != null) {
              localObject8 = ((String)localObject2).replace("\"", "").replace("\n", "");
            }
            if (!"3".equals(this.this$0.chg)) {
              continue;
            }
            localObject2 = (kdm)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(88);
            if (localObject2 == null) {
              break;
            }
            ((kdm)localObject2).a(this.this$0, (Activity)localContext);
          }
          catch (Exception localException5)
          {
            Object localObject9 = localObject7;
            localObject7 = localObject5;
            localObject5 = localObject3;
            localObject3 = localObject9;
          }
        }
        localObject6 = new JSONObject((String)localObject4);
        continue;
        localObject8 = localObject2;
        localObject2 = localObject5;
        localObject5 = localObject8;
        continue;
        localObject10 = new StringBuilder();
        localStringBuilder = ((StringBuilder)localObject10).append(str);
        if (str.contains("?")) {}
        for (localObject2 = "&view_id=";; localObject2 = "?view_id=")
        {
          localStringBuilder.append((String)localObject2).append(String.valueOf(localObject8)).append("&ad_id=").append(String.valueOf(localObject6)).append("&trace_id=").append(String.valueOf(localObject5));
          localIntent.putExtra("url", ((StringBuilder)localObject10).toString());
          localIntent.putExtra("big_brother_source_key", "biz_src_gzh_qqgw");
          localContext.startActivity(localIntent);
          break;
        }
        if ((this.this$0.e != null) && (this.this$0.e.mMsgUrl != null) && (this.this$0.e.mMsgUrl.contains("kandianshare.html5.qq.com")))
        {
          kxm.C(localContext, this.this$0.e.mMsgUrl);
          break;
        }
        localObject2 = anqs.a();
        if (!((anqs)localObject2).ayP())
        {
          if (!(this.this$0.e instanceof StructMsgForGeneralShare)) {
            break;
          }
          localObject2 = (StructMsgForGeneralShare)this.this$0.e;
          this.this$0.a(localContext, (StructMsgForGeneralShare)localObject2, 0L);
          break;
        }
        if (((anqs)localObject2).d(localContext, 3, this.this$0.e.uinType))
        {
          if (!(this.this$0.e instanceof StructMsgForGeneralShare)) {
            break;
          }
          localObject2 = (StructMsgForGeneralShare)this.this$0.e;
          this.this$0.a(localContext, (StructMsgForGeneralShare)localObject2, 0L);
          break;
        }
        if (!jqc.ak(localContext))
        {
          QQToast.a(localContext, 2131693404, 0).show();
          break;
        }
        this.this$0.a(localContext, (StructMsgForGeneralShare)this.this$0.e, 0L);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anvk
 * JD-Core Version:    0.7.0.1
 */