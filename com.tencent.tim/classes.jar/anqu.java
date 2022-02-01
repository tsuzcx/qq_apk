import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;

public abstract class anqu
  implements View.OnClickListener, anrc
{
  public String Wj;
  public String Wm;
  public String Wn;
  public String bWQ;
  public int cdl;
  public String cgX;
  public String cgY;
  public String cgZ;
  public String chA;
  public String chB;
  public String chC;
  public String chD;
  public String chE;
  public String chF;
  public String chG;
  public String chH;
  public String cha;
  public String chb;
  public String chc;
  public String chd;
  public String che;
  public String chf;
  public String chg;
  public String chh;
  public String chi;
  public String chj;
  public String chk;
  public String chl;
  public String chm;
  public String chn;
  public String cho;
  public String chp;
  public String chq;
  public String chr;
  public String chs;
  public String cht;
  public String chu;
  public String chv;
  public String chw;
  public String chx;
  public String chy;
  public String chz;
  public int dLY;
  public int dLZ;
  public int dMa;
  public int dMb;
  public int dMc;
  public int dMd;
  public int dMe;
  public int dMf;
  public int dMg;
  public int dMh;
  public AbsStructMsg e;
  public WeakReference<wlz> hU;
  public String index;
  public String index_name;
  public String index_type;
  public String ku;
  public String mAppName;
  public String mCommonData;
  public String mPkgName;
  public int mPromotionType = -1;
  int mStyle;
  public String mTypeName;
  public int mVersion = 16;
  public long msgId;
  public String templateIDForPortal = "";
  long time = -1L;
  public String uin;
  
  public static String nH(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    String str = paramString;
    if (!aurr.isValidUrl(paramString)) {
      str = "https://" + paramString;
    }
    try
    {
      paramString = new URL(str).getHost();
      return paramString;
    }
    catch (MalformedURLException paramString) {}
    return "";
  }
  
  public void Vr(int paramInt)
  {
    if ((this.mStyle & paramInt) == 0) {
      this.mStyle |= paramInt;
    }
  }
  
  public abstract View a(Context paramContext, View paramView, Bundle paramBundle);
  
  public abstract void a(XmlSerializer paramXmlSerializer)
    throws IOException;
  
  public abstract boolean a(ansf paramansf);
  
  public void b(AbsShareMsg paramAbsShareMsg) {}
  
  public abstract String getLayoutStr();
  
  public int getStyle()
  {
    return this.mStyle;
  }
  
  public boolean lI(int paramInt)
  {
    return (this.mStyle & paramInt) == paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (SystemClock.uptimeMillis() - this.time < 1000L) {}
    Object localObject1;
    anqu localanqu;
    Object localObject4;
    do
    {
      do
      {
        do
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          this.time = SystemClock.uptimeMillis();
          localObject1 = paramView.getTag();
        } while (!getClass().isInstance(localObject1));
        localanqu = (anqu)localObject1;
        localObject4 = paramView.getContext();
      } while ((!SplashActivity.class.isInstance(localObject4)) && (!ChatActivity.class.isInstance(localObject4)));
      localObject1 = (FragmentActivity)localObject4;
    } while (((FragmentActivity)localObject1).getChatFragment() == null);
    QQAppInterface localQQAppInterface = ((FragmentActivity)localObject1).getChatFragment().getApp();
    if ((localanqu.msgId > 0L) && (!TextUtils.isEmpty(localanqu.chH))) {
      anot.a(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", localanqu.uin, "mp_msg_msgpic_click", "aio_morpic_click", Integer.parseInt(this.chH), 0, "", "", Long.toString(localanqu.msgId), "");
    }
    lcm.a().a(localanqu.uin, localanqu);
    if ((!(((FragmentActivity)localObject1).getChatFragment().a() instanceof ycd)) || (!TextUtils.isEmpty(localanqu.chH))) {}
    for (;;)
    {
      try
      {
        i = Integer.parseInt(this.chH);
        localObject3 = "";
        localObject1 = localObject3;
        if (localanqu.e != null)
        {
          localObject1 = localObject3;
          if (localanqu.e.message != null)
          {
            localObject1 = localObject3;
            if (localanqu.e.message.mExJsonObject != null) {
              localObject1 = localanqu.e.message.mExJsonObject.optString("report_key_bytes_oac_msg_extend");
            }
          }
        }
        localObject3 = localanqu.uin;
        long l = localanqu.msgId;
        adak.a(localQQAppInterface, (String)localObject3, 0, 4, i + l, (String)localObject1);
        if ("2747277822".equals(localanqu.uin)) {
          ((aqrb)localQQAppInterface.getBusinessHandler(71)).X(3, localanqu.msgId + "", localanqu.ku);
        }
        if (localanqu.msgId > 0L) {
          ThreadManager.getSubThreadHandler().postDelayed(new AbsStructMsgElement.1(this, localanqu, localQQAppInterface), 0L);
        }
      }
      catch (NumberFormatException localClassCastException)
      {
        try
        {
          localObject1 = wja.a(paramView);
          if ((localObject1 == null) || (localanqu.e == null) || (!"1".equals(((ChatMessage)localObject1).getExtInfoFromExtStr("is_AdArrive_Msg")))) {}
        }
        catch (ClassCastException localClassCastException)
        {
          try
          {
            Object localObject3 = new JSONObject();
            ((JSONObject)localObject3).put("puin", ((ChatMessage)localObject1).frienduin);
            ((JSONObject)localObject3).put("type", localanqu.index_type);
            ((JSONObject)localObject3).put("index", localanqu.index);
            ((JSONObject)localObject3).put("name", localanqu.index_name);
            ((JSONObject)localObject3).put("net", String.valueOf(jqc.getNetWorkType()));
            ((JSONObject)localObject3).put("mobile_imei", aqgz.getIMEI());
            ((JSONObject)localObject3).put("obj", "");
            ((JSONObject)localObject3).put("gdt_cli_data", ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_msgClick"));
            ((JSONObject)localObject3).put("view_id", ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_view_id"));
            obl.a(localQQAppInterface, ((ChatMessage)localObject1).selfuin, ((JSONObject)localObject3).toString(), "" + localanqu.e.msgId);
            localObject3 = new anra(localQQAppInterface, paramView, (MessageRecord)localObject1);
            localObject5 = ((FragmentActivity)localObject4).getChatFragment();
            Object localObject6;
            if (localObject5 != null)
            {
              localObject5 = ((ChatFragment)localObject5).a();
              if ((localObject5 instanceof ycd))
              {
                localObject6 = (ycd)localObject5;
                ((ycd)localObject6).bYx += 1;
                if ("web".equals(localanqu.cgX))
                {
                  localObject5 = (ycd)localObject5;
                  ((ycd)localObject5).bYz += 1;
                }
              }
            }
            if (localObject1 != null) {
              localanqu.ku = kdm.a(((ChatMessage)localObject1).frienduin, localanqu.ku, localQQAppInterface);
            }
            bool = ((kdm)localQQAppInterface.getManager(88)).a(this, (Activity)localObject4);
            if (!bool)
            {
              if (localanqu.msgId > 0L) {
                if ((localObject1 != null) && ("1".equals(((ChatMessage)localObject1).getExtInfoFromExtStr("is_AdArrive_Msg"))))
                {
                  bool = ((anra)localObject3).a(localanqu.cgX, localanqu.ku, localanqu.cgY, localanqu.cgZ, localanqu.msgId, new Object[] { Boolean.valueOf(true) });
                  if ((localanqu.e == null) || (localanqu.e.message == null)) {}
                }
              }
              try
              {
                if (localanqu.e.mMsgServiceID == 92)
                {
                  i = Integer.parseInt(localanqu.e.mQidianBulkTaskId);
                  localObject3 = localanqu.ku;
                  if (QLog.isColorLevel()) {
                    QLog.d("StructMsg", 2, String.format("click qidian bulk message, taskId: %d, actionUrl: %s", new Object[] { Integer.valueOf(i), localObject3 }));
                  }
                  if (i != 0)
                  {
                    localObject4 = new JSONObject();
                    ((JSONObject)localObject4).put("action", "click");
                    ((JSONObject)localObject4).put("fromUin", localanqu.e.message.frienduin);
                    ((JSONObject)localObject4).put("toUin", localQQAppInterface.getCurrentAccountUin());
                    ((JSONObject)localObject4).put("taskID", localanqu.e.mQidianBulkTaskId);
                    ((JSONObject)localObject4).put("clickURL", localObject3);
                    ((JSONObject)localObject4).put("timestamp", String.valueOf(System.currentTimeMillis() / 1000L));
                    ((ashy)localQQAppInterface.getBusinessHandler(85)).g(((JSONObject)localObject4).toString(), localanqu.e.message.frienduin, "", 10009, 0);
                  }
                }
              }
              catch (Exception localException2)
              {
                int j;
                continue;
              }
              if (asgx.E(localanqu.cgZ, localanqu.cgY, localanqu.ku))
              {
                localObject5 = (asgx)localQQAppInterface.getManager(165);
                localObject4 = "";
                localObject3 = localObject4;
                if ((localanqu instanceof anrw))
                {
                  localObject6 = ((anrw)localanqu).uh;
                  localObject3 = localObject4;
                  if (localObject6 != null)
                  {
                    localObject6 = ((List)localObject6).iterator();
                    localObject3 = localObject4;
                    if (((Iterator)localObject6).hasNext())
                    {
                      localObject3 = (anqu)((Iterator)localObject6).next();
                      if (!(localObject3 instanceof anux)) {
                        continue;
                      }
                      localObject3 = ((anux)localObject3).text;
                    }
                  }
                }
                ((asgx)localObject5).c(localanqu.cgX, localanqu.cgZ, localanqu.cgY, localanqu.ku, 2, (String)localObject3);
              }
              i = 0;
              if (bool) {
                i = 1;
              }
              j = -1;
              try
              {
                int k = Integer.parseInt(localanqu.chH);
                j = k;
              }
              catch (Exception localException1)
              {
                continue;
              }
              anot.a(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", localanqu.uin, "0X80055C7", "0X80055C7", j, i, "" + localanqu.msgId, localanqu.templateIDForPortal, "", localanqu.ku);
              localObject3 = new StringBuilder().append("MSGID=").append(Long.toString(localanqu.msgId)).append(";TEPLATEID=").append(localanqu.templateIDForPortal).append(";ARTICALID=").append("").append(";REFERRER=").append(nH(localanqu.ku));
              anot.a(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", localanqu.uin, "0X8005D49", "0X8005D49", j, i, ((StringBuilder)localObject3).toString(), "", "", "");
              if (localObject1 == null) {
                break;
              }
              localObject3 = ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_msgClick");
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                localObject4 = new JSONObject();
              }
              try
              {
                if (TextUtils.isEmpty(localanqu.uin)) {
                  continue;
                }
                ((JSONObject)localObject4).put("puin", localanqu.uin);
                ((JSONObject)localObject4).put("index", Long.toString(j));
                ((JSONObject)localObject4).put("gdt_cli_data", localObject3);
              }
              catch (JSONException localJSONException2)
              {
                Object localObject2;
                localJSONException2.printStackTrace();
                continue;
                if ((((String)localObject4).equals("1")) || (!((String)localObject5).equals("1"))) {
                  continue;
                }
                continue;
              }
              new ArrayList().add(String.valueOf(localanqu.msgId));
              localObject3 = ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_singleAd");
              localObject4 = ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_mulAd");
              localObject5 = ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_followAd");
              if (((String)localObject3).equals("1"))
              {
                localObject3 = (kdm)localQQAppInterface.getManager(88);
                localObject4 = (kec)localQQAppInterface.getBusinessHandler(88);
                if ((localObject1 == null) || (localObject3 == null) || (localObject4 == null) || (!((kdm)localObject3).dr(((ChatMessage)localObject1).senderuin))) {
                  break;
                }
                ((kec)localObject4).a(false, (MessageRecord)localObject1, j, localanqu.ku);
                break;
                localNumberFormatException = localNumberFormatException;
                i = -1;
                continue;
                localClassCastException = localClassCastException;
                localObject2 = null;
              }
            }
          }
          catch (JSONException localJSONException1)
          {
            Object localObject5;
            localJSONException1.printStackTrace();
            continue;
            boolean bool = localJSONException1.a(localanqu.cgX, localanqu.ku, localanqu.cgY, localanqu.cgZ, localanqu.msgId, new Object[0]);
            continue;
            bool = localJSONException1.i(localanqu.cgX, localanqu.ku, localanqu.cgY, localanqu.cgZ);
            continue;
            ((JSONObject)localObject4).put("puin", localObject2.frienduin);
            continue;
            continue;
          }
        }
      }
      int i = -1;
    }
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    this.mVersion = paramObjectInput.readInt();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeUTF(this.mTypeName);
    paramObjectOutput.writeInt(this.mVersion);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anqu
 * JD-Core Version:    0.7.0.1
 */