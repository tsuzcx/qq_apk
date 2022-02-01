import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.IOException;
import java.io.ObjectInput;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class ansy
  extends anqv
{
  public boolean cJS;
  public boolean cJT;
  private String cib;
  public GradientDrawable l;
  public Bundle mBundle = new Bundle();
  View.OnClickListener mOnClickListener = new ansz(this);
  
  public static boolean U(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForStructing))
    {
      paramChatMessage = (MessageForStructing)paramChatMessage;
      if ((paramChatMessage.structingMsg != null) && ((paramChatMessage.structingMsg instanceof AbsShareMsg)) && (paramChatMessage.structingMsg.mMsgServiceID == 52))
      {
        paramChatMessage = (AbsShareMsg)paramChatMessage.structingMsg;
        if ((paramChatMessage.getItemCount() > 0) && ((paramChatMessage.getItemByIndex(0) instanceof ansy))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private FrameLayout b(Context paramContext)
  {
    FrameLayout localFrameLayout = new FrameLayout(paramContext);
    localFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, wja.dp2px(105.0F, paramContext.getResources())));
    localFrameLayout.setId(2131372234);
    if (AppSetting.enableTalkBack) {
      localFrameLayout.setContentDescription(this.cib);
    }
    return localFrameLayout;
  }
  
  public static String d(AbsStructMsg paramAbsStructMsg)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramAbsStructMsg instanceof AbsShareMsg))
    {
      paramAbsStructMsg = (AbsShareMsg)paramAbsStructMsg;
      if ((paramAbsStructMsg.getItemCount() > 0) && ((paramAbsStructMsg.getItemByIndex(0) instanceof ansy)))
      {
        paramAbsStructMsg = (ansy)paramAbsStructMsg.getItemByIndex(0);
        boolean bool = paramAbsStructMsg.mBundle.getBoolean("isSend", false);
        localStringBuilder.append("isSend:").append(bool).append(" nick:");
        if (!bool) {
          break label97;
        }
        localStringBuilder.append(paramAbsStructMsg.mBundle.getString("rNick"));
      }
    }
    for (;;)
    {
      return localStringBuilder.toString();
      label97:
      localStringBuilder.append(paramAbsStructMsg.mBundle.getString("sNick"));
    }
  }
  
  @TargetApi(11)
  private void hJ(View paramView)
  {
    paramView.setOnTouchListener(new anta(this, paramView));
  }
  
  private String nK(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      str = null;
    }
    try
    {
      localObject = Base64.decode(paramString, 0);
      str = paramString;
      if (localObject != null)
      {
        str = paramString;
        if (localObject.length > 0) {
          str = new String((byte[])localObject);
        }
      }
      return str;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.i("StructMsgItemLayout12", 2, localIllegalArgumentException.getMessage());
          localObject = str;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.i("StructMsgItemLayout12", 2, localException.getMessage());
          localObject = str;
        }
      }
    }
  }
  
  protected int IX()
  {
    return 12;
  }
  
  public boolean a(ansf paramansf)
  {
    boolean bool = super.a(paramansf);
    if (QLog.isColorLevel()) {
      QLog.i("StructMsgItemLayout12", 2, "fromXml inited:" + this.cJS + " " + hashCode());
    }
    if (!this.cJS) {
      dTx();
    }
    return bool;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StructMsgItemLayout12", 2, "getView inited:" + this.cJS + " " + hashCode());
    }
    if (!this.cJS) {
      dTx();
    }
    boolean bool1 = this.mBundle.getBoolean("isSend", false);
    boolean bool2 = this.mBundle.getBoolean("isReceive", false);
    String str1 = this.mBundle.getString("groupCode");
    String str2 = this.mBundle.getString("rNick");
    Object localObject1;
    Resources localResources;
    if (!TextUtils.isEmpty(str1)) {
      if (bool1)
      {
        localObject1 = "0X800638D";
        acie.O(((BaseActivity)paramContext).app, (String)localObject1);
        localResources = paramContext.getResources();
        if ((paramView == null) || (!(paramView instanceof FrameLayout)) || (((FrameLayout)paramView).getChildCount() != 2) || (!(((FrameLayout)paramView).getTag() instanceof ansy.a))) {
          break label519;
        }
        localObject1 = (FrameLayout)paramView;
        paramView = (ansy.a)((FrameLayout)localObject1).getTag();
        if (paramView.yg != null) {
          paramView.yg.setVisibility(8);
        }
        if (paramView.Hu != null) {
          paramView.Hu.setVisibility(8);
        }
        if (paramView.EY != null) {
          paramView.EY.setVisibility(8);
        }
        if (paramView.Hv == null) {
          break label1513;
        }
        paramView.Hv.setVisibility(8);
      }
    }
    label275:
    label284:
    label834:
    label1234:
    label1240:
    label1513:
    for (;;)
    {
      Object localObject2;
      if (bool1)
      {
        paramView.kD.setPadding(0, 0, wja.dp2px(15.0F, localResources), 0);
        localObject2 = this.rz.iterator();
      }
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (anqu)((Iterator)localObject2).next();
          ((anqu)localObject3).hU = this.hU;
          Object localObject4 = ((anqu)localObject3).mTypeName;
          Object localObject5;
          int i;
          if ("title".equals(localObject4))
          {
            if ((localObject3 instanceof StructMsgItemTitle))
            {
              ((StructMsgItemTitle)localObject3).bA(ayW(), 0);
              ((StructMsgItemTitle)localObject3).setSingleLine(true);
              ((StructMsgItemTitle)localObject3).Qv(true);
            }
            localObject4 = ((anqu)localObject3).a(paramContext, paramView.yg, paramBundle);
            localObject5 = (TextView)((View)localObject4).findViewById(2131380976);
            if (paramView.yg == null)
            {
              paramView.yg = ((View)localObject4);
              paramView.kD.addView((View)localObject4, 0);
            }
            for (;;)
            {
              if (!QLog.isColorLevel()) {
                break label834;
              }
              QLog.i("StructMsgItemLayout12", 2, "getview title:" + ((anqw)localObject3).getText() + " realText:" + ((TextView)localObject5).getText());
              break label284;
              if (bool2)
              {
                localObject1 = "0X800638E";
                break;
              }
              localObject1 = "0X800638F";
              break;
              if (bool1)
              {
                localObject1 = "0X80060B1";
                break;
              }
              localObject1 = "0X80060B2";
              break;
              paramView = new ansy.a();
              localObject1 = b(paramContext);
              ((FrameLayout)localObject1).setTag(paramView);
              paramView.bgView = new View(paramContext);
              localObject2 = new FrameLayout.LayoutParams(-1, -1);
              ((FrameLayout)localObject1).addView(paramView.bgView, (ViewGroup.LayoutParams)localObject2);
              ((FrameLayout.LayoutParams)localObject2).setMargins(0, wja.dp2px(10.0F, localResources), 0, 0);
              if (this.l == null)
              {
                this.l = new GradientDrawable();
                this.l.setShape(0);
                this.l.setColor(-1);
                this.l.setCornerRadius(wja.dp2px(14.0F, localResources));
              }
              paramView.bgView.setBackgroundDrawable(this.l);
              paramView.dx = new LinearLayout(paramContext);
              paramView.dx.setOrientation(0);
              localObject2 = new FrameLayout.LayoutParams(-2, -1);
              paramView.dx.setGravity(16);
              ((FrameLayout)localObject1).addView(paramView.dx, (ViewGroup.LayoutParams)localObject2);
              paramView.kD = new LinearLayout(paramContext);
              paramView.kD.setOrientation(1);
              localObject2 = new LinearLayout.LayoutParams(wja.dp2px(135.0F, localResources), -2);
              ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
              ((LinearLayout.LayoutParams)localObject2).topMargin = wja.dp2px(5.0F, localResources);
              localObject3 = paramView.kD;
              if (bool1) {}
              for (i = 5;; i = 3)
              {
                ((LinearLayout)localObject3).setGravity(i);
                paramView.dx.addView(paramView.kD, (ViewGroup.LayoutParams)localObject2);
                break;
              }
              paramView.kD.setPadding(wja.dp2px(15.0F, localResources), 0, 0, 0);
              break label275;
              paramView.yg.setVisibility(0);
            }
          }
          else
          {
            if ("summary".equals(localObject4))
            {
              if ((localObject3 instanceof anux)) {
                ((anux)localObject3).setTextColor("black");
              }
              localObject4 = ((anqu)localObject3).a(paramContext, paramView.Hu, paramBundle);
              localObject5 = (TextView)localObject4;
              if (!TextUtils.isEmpty(str1))
              {
                ((TextView)localObject5).setMaxLines(1);
                if ((localObject3 instanceof anux)) {
                  ((anux)localObject3).setText(str2);
                }
                if (paramView.Hu != null) {
                  break label1022;
                }
                paramView.Hu = ((View)localObject4);
                localObject5 = new LinearLayout.LayoutParams(-1, -2);
                ((LinearLayout.LayoutParams)localObject5).setMargins(0, wja.dp2px(4.0F, localResources), 0, 0);
                paramView.kD.addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
              }
              for (;;)
              {
                localObject3 = (anux)localObject3;
                if ((this.mBundle.size() <= 0) || (!TextUtils.isEmpty(str1))) {
                  break;
                }
                this.mBundle.putString("cMeanPostfix", ((anux)localObject3).getText());
                break;
                ((TextView)localObject5).setMaxLines(2);
                break label918;
                label1022:
                paramView.Hu.setVisibility(0);
              }
            }
            if ("picture".equals(localObject4))
            {
              localObject4 = (ansr)localObject3;
              if (!((ansr)localObject4).aNt.startsWith("https://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s".substring(0, 4))) {
                ((ansr)localObject4).aNt = String.format("https://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s", new Object[] { ((ansr)localObject4).aNt });
              }
              localObject3 = ((anqu)localObject3).a(paramContext, paramView.EY, paramBundle);
              if (this.mBundle.getInt("count", 0) > 9)
              {
                ((ImageView)localObject3).setScaleType(ImageView.ScaleType.FIT_END);
                label1133:
                if (paramView.EY != null) {
                  break label1240;
                }
                paramView.EY = ((View)localObject3);
                paramView.EY.setFocusable(true);
                localObject4 = new LinearLayout.LayoutParams(wja.dp2px(115.0F, localResources), -1);
                ((LinearLayout.LayoutParams)localObject4).weight = 1.0F;
                localObject5 = paramView.dx;
                if (!bool1) {
                  break label1234;
                }
                i = 0;
                ((LinearLayout)localObject5).addView((View)localObject3, i, (ViewGroup.LayoutParams)localObject4);
              }
              for (;;)
              {
                if (!VersionUtils.isHoneycomb()) {
                  break label1282;
                }
                hJ(paramView.EY);
                break;
                ((ImageView)localObject3).setScaleType(ImageView.ScaleType.FIT_CENTER);
                break label1133;
                i = 1;
                break label1192;
                paramView.EY.setVisibility(0);
                if (bool1 != paramView.isSend) {
                  if (bool1) {
                    paramView.kD.bringToFront();
                  } else {
                    paramView.EY.bringToFront();
                  }
                }
              }
              paramView.EY.setOnClickListener(this.mOnClickListener);
            }
            else if ("remark".equals(localObject4))
            {
              if ((localObject3 instanceof anuw)) {
                ((anuw)localObject3).setTextColor("#FF9B9B9B");
              }
              localObject4 = ((anqu)localObject3).a(paramContext, paramView.Hv, paramBundle);
              if (paramView.Hv == null)
              {
                paramView.Hv = ((View)localObject4);
                localObject5 = new LinearLayout.LayoutParams(-1, -2);
                ((LinearLayout.LayoutParams)localObject5).topMargin = wja.dp2px(7.0F, localResources);
                paramView.kD.addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
              }
              for (;;)
              {
                localObject4 = (anuw)localObject3;
                if (this.mBundle.size() > 0)
                {
                  this.mBundle.putString("remark", ((anuw)localObject4).getText());
                  if (!TextUtils.isEmpty(str1)) {
                    this.mBundle.putString("cMeanPostfix", ((anuw)localObject4).getText());
                  }
                }
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.i("StructMsgItemLayout12", 2, "getview remark:" + ((anqw)localObject3).getText());
                break;
                paramView.Hv.setVisibility(0);
              }
            }
          }
        }
      }
      paramView.bundle = this.mBundle;
      paramView.isSend = bool1;
      return localObject1;
    }
  }
  
  public void dTx()
  {
    label1214:
    label1346:
    label1361:
    label1377:
    label1513:
    try
    {
      localObject8 = new JSONObject(this.chc);
      if (QLog.isColorLevel()) {
        QLog.i("StructMsgItemLayout12", 2, ((JSONObject)localObject8).toString());
      }
      if (!((JSONObject)localObject8).has("fMean")) {
        break label1361;
      }
      localObject3 = ((JSONObject)localObject8).getString("fMean");
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject1;
        int i;
        boolean bool1;
        if (QLog.isColorLevel()) {
          QLog.i("StructMsgItemLayout12", 2, localJSONException.getMessage());
        }
      }
    }
    catch (Exception localException)
    {
      label1385:
      for (;;)
      {
        Object localObject8;
        Object localObject3;
        Object localObject4;
        Object localObject5;
        Object localObject6;
        String str1;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str11;
        Object localObject7;
        String str10;
        String str12;
        String str13;
        String str14;
        Object localObject9;
        int j;
        label1264:
        if (QLog.isColorLevel())
        {
          QLog.i("StructMsgItemLayout12", 2, localException.getMessage());
          continue;
          localObject4 = localException;
          Object localObject2 = localObject3;
          localObject3 = localObject4;
          break label1346;
          localObject9 = null;
          continue;
          localObject4 = localObject3;
          localObject3 = localObject2;
          localObject2 = localObject4;
          continue;
          localObject3 = "";
          continue;
          localObject2 = "";
          continue;
          localObject4 = "";
          continue;
          localObject5 = "";
          continue;
          label1393:
          localObject6 = "";
          continue;
          label1401:
          str1 = "";
          continue;
          str2 = "";
          continue;
          str3 = "";
          continue;
          str4 = "";
          continue;
          str5 = "";
          continue;
          str6 = "";
          continue;
          str7 = "";
          continue;
          str8 = "";
          continue;
          str9 = "";
          continue;
          str11 = "";
          continue;
          localObject7 = "";
          continue;
          str10 = "";
          continue;
          str12 = "";
          continue;
          str13 = "";
          continue;
          str14 = "";
          continue;
          label1521:
          localObject8 = "";
          continue;
          label1529:
          j = 0;
          continue;
          label1534:
          j = 0;
          continue;
          localObject3 = str11;
          continue;
          localObject3 = "送你";
        }
      }
    }
    if (((JSONObject)localObject8).has("cMean"))
    {
      localObject1 = ((JSONObject)localObject8).getString("cMean");
      if (!((JSONObject)localObject8).has("bgPic")) {
        break label1377;
      }
      localObject4 = ((JSONObject)localObject8).getString("bgPic");
      if (!((JSONObject)localObject8).has("fPic")) {
        break label1385;
      }
      localObject5 = ((JSONObject)localObject8).getString("fPic");
      if (!((JSONObject)localObject8).has("sinfo")) {
        break label1393;
      }
      localObject6 = ((JSONObject)localObject8).getString("sinfo");
      if (!((JSONObject)localObject8).has("rinfo")) {
        break label1401;
      }
      str1 = ((JSONObject)localObject8).getString("rinfo");
      if (!((JSONObject)localObject8).has("score")) {
        break label1409;
      }
      str2 = ((JSONObject)localObject8).getString("score");
      if (!((JSONObject)localObject8).has("pID")) {
        break label1417;
      }
      str3 = ((JSONObject)localObject8).getString("pID");
      if (!((JSONObject)localObject8).has("pURL")) {
        break label1425;
      }
      str4 = ((JSONObject)localObject8).getString("pURL");
      if (!((JSONObject)localObject8).has("fCount")) {
        break label1433;
      }
      str5 = ((JSONObject)localObject8).getString("fCount");
      if (!((JSONObject)localObject8).has("rUin")) {
        break label1441;
      }
      str6 = ((JSONObject)localObject8).getString("rUin");
      if (!((JSONObject)localObject8).has("sUin")) {
        break label1449;
      }
      str7 = ((JSONObject)localObject8).getString("sUin");
      if (!((JSONObject)localObject8).has("rSex")) {
        break label1457;
      }
      str8 = ((JSONObject)localObject8).getString("rSex");
      if (!((JSONObject)localObject8).has("sSex")) {
        break label1465;
      }
      str9 = ((JSONObject)localObject8).getString("sSex");
      if (!((JSONObject)localObject8).has("rNick")) {
        break label1473;
      }
      str11 = ((JSONObject)localObject8).getString("rNick");
      if (!((JSONObject)localObject8).has("sNick")) {
        break label1481;
      }
      localObject7 = ((JSONObject)localObject8).getString("sNick");
      if (!((JSONObject)localObject8).has("version")) {
        break label1489;
      }
      str10 = ((JSONObject)localObject8).getString("version");
      if (!((JSONObject)localObject8).has("groupCode")) {
        break label1497;
      }
      str12 = ((JSONObject)localObject8).getString("groupCode");
      if (!((JSONObject)localObject8).has("gScore")) {
        break label1505;
      }
      str13 = ((JSONObject)localObject8).getString("gScore");
      if (!((JSONObject)localObject8).has("sID")) {
        break label1513;
      }
      str14 = ((JSONObject)localObject8).getString("sID");
      if (!((JSONObject)localObject8).has("aNony")) {
        break label1521;
      }
      localObject8 = ((JSONObject)localObject8).getString("aNony");
      if (TextUtils.isEmpty(str5)) {}
      for (i = 0;; i = Integer.valueOf(str5).intValue())
      {
        localObject9 = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin();
        bool1 = str7.equals(localObject9);
        boolean bool2 = str6.equals(localObject9);
        this.mBundle.putBoolean("isSend", bool1);
        this.mBundle.putBoolean("isReceive", bool2);
        localObject9 = this.rz.iterator();
        do
        {
          if (!((Iterator)localObject9).hasNext()) {
            break;
          }
          localObject10 = (anqu)((Iterator)localObject9).next();
        } while (!(localObject10 instanceof ansr));
        localObject9 = ((ansr)localObject10).aNt;
        str11 = nK(str11);
        String str15 = nK((String)localObject7);
        localObject7 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        Object localObject10 = (acff)((QQAppInterface)localObject7).getManager(51);
        this.mBundle.putString("sNick", str15);
        if (!bool1)
        {
          if ((localObject10 == null) || (!((acff)localObject10).isFriend(str7))) {
            break label1529;
          }
          j = 1;
          if (j != 0)
          {
            str15 = aqgv.A((QQAppInterface)localObject7, str7);
            this.mBundle.putString("sNick", str15);
            if (bool2) {
              this.mBundle.putBoolean("isFriend", true);
            }
          }
        }
        this.mBundle.putString("rNick", str11);
        if (!bool2)
        {
          if ((localObject10 == null) || (!((acff)localObject10).isFriend(str6))) {
            break label1534;
          }
          j = 1;
          if (j != 0)
          {
            localObject7 = aqgv.A((QQAppInterface)localObject7, str6);
            this.mBundle.putString("rNick", (String)localObject7);
            if (bool1) {
              this.mBundle.putBoolean("isFriend", true);
            }
          }
        }
        this.mBundle.putString("rUin", str6);
        this.mBundle.putString("sUin", str7);
        this.mBundle.putString("rSex", str8);
        this.mBundle.putString("sSex", str9);
        this.mBundle.putString("bgPic", (String)localObject4);
        this.mBundle.putString("sInfo", (String)localObject6);
        this.mBundle.putString("rInfo", str1);
        this.mBundle.putString("score", str2);
        this.mBundle.putString("fPic", (String)localObject5);
        this.mBundle.putString("fMean", (String)localObject3);
        this.mBundle.putString("cMean", (String)localObject1);
        this.mBundle.putString("fCount", str5);
        this.mBundle.putInt("count", i);
        this.mBundle.putString("pID", str3);
        this.mBundle.putString("pURL", str4);
        this.mBundle.putString("version", str10);
        this.mBundle.putString("groupCode", str12);
        this.mBundle.putString("gScore", str13);
        if (!TextUtils.isEmpty((CharSequence)localObject9)) {
          this.mBundle.putString("cover", (String)localObject9);
        }
        this.mBundle.putString("sID", str14);
        if (!TextUtils.isEmpty((CharSequence)localObject8)) {
          this.mBundle.putString("anonyInfo", (String)localObject8);
        }
        if ((!AppSetting.enableTalkBack) || (this.cib != null)) {
          break label1264;
        }
        localObject5 = new StringBuilder();
        if (!bool1) {
          break label1539;
        }
        localObject3 = "我";
        ((StringBuilder)localObject5).append((String)localObject3);
        if (!bool1) {
          break label1546;
        }
        localObject3 = "送出";
        ((StringBuilder)localObject5).append((String)localObject3);
        ((StringBuilder)localObject5).append((String)localObject1).append(',');
        localObject1 = null;
        localObject3 = null;
        localObject6 = this.rz.iterator();
        if (!((Iterator)localObject6).hasNext()) {
          break label1214;
        }
        localObject4 = (anqu)((Iterator)localObject6).next();
        str1 = ((anqu)localObject4).mTypeName;
        if (!"remark".equals(str1)) {
          break;
        }
        localObject4 = ((anuw)localObject4).getText();
        localObject3 = localObject1;
        localObject1 = localObject4;
        break label1346;
      }
      if ("summary".equals(str1))
      {
        localObject4 = ((anux)localObject4).getText();
        localObject1 = localObject3;
        localObject3 = localObject4;
        break label1346;
        ((StringBuilder)localObject5).append((String)localObject1).append(",");
        if (bool1) {
          ((StringBuilder)localObject5).append("对方").append((String)localObject3);
        }
        for (;;)
        {
          ((StringBuilder)localObject5).append("按钮");
          this.cib = ((StringBuilder)localObject5).toString();
          this.cJS = true;
          return;
          ((StringBuilder)localObject5).append((String)localObject3);
        }
      }
    }
  }
  
  public String getName()
  {
    return "Layout12";
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    super.readExternal(paramObjectInput);
    if (QLog.isColorLevel()) {
      QLog.i("StructMsgItemLayout12", 2, "readExternal inited:" + this.cJS + " " + hashCode());
    }
    if (!this.cJS) {
      dTx();
    }
  }
  
  public static class a
  {
    public View EY;
    public View Hu;
    public View Hv;
    public View bgView;
    public Bundle bundle;
    public LinearLayout dx;
    public boolean isSend;
    public LinearLayout kD;
    public View yg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ansy
 * JD-Core Version:    0.7.0.1
 */