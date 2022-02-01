import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class ahle
  extends ahgq
{
  protected int cZZ;
  int daa = 5;
  private String title;
  
  public ahle(Intent paramIntent)
  {
    super(paramIntent);
    this.cZZ = paramIntent.getIntExtra("item", 273);
    if (paramIntent.hasExtra("title")) {}
    for (paramIntent = paramIntent.getStringExtra("title");; paramIntent = "")
    {
      this.title = paramIntent;
      return;
    }
  }
  
  public List<RecentUser> aD(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (((!aqft.ri(localRecentUser.uin)) && (localRecentUser.getType() != 10004) && ((localRecentUser.getType() != 0) || (!jqs.d(this.app, localRecentUser.uin, localRecentUser.getType()))) && ((localRecentUser.getType() != 1) || (!kj(localRecentUser.uin))) && ((localRecentUser.getType() == 0) || (localRecentUser.getType() == 1) || (localRecentUser.getType() == 3000))) || (((localRecentUser.getType() == 1004) || (localRecentUser.getType() == 1000)) && (this.cgP) && (((this.cZZ & 0x1) <= 0) || (localRecentUser.getType() == 0))))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  protected boolean anl()
  {
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.a(BaseApplicationImpl.sApplication, 2131696270, 0).show(this.mActivity.getResources().getDimensionPixelSize(2131299627));
      return true;
    }
    Object localObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("listid", this.bf.getString("hb_id"));
        ((JSONObject)localObject2).put("send_uin", this.bf.getString("send_uin"));
        ((JSONObject)localObject2).put("hb_type", Integer.parseInt(this.bf.getString("hb_type")));
        switch (this.bf.getInt("uintype"))
        {
        case 1: 
          ((JSONObject)localObject2).put("recv_uin", this.bf.getString("uin"));
          ((JSONObject)localObject2).put("appid", String.valueOf(AppSetting.getAppId()));
          ((JSONObject)localObject2).put("from_memo", this.app.getCurrentNickname());
          ((JSONObject)localObject1).put("userId", this.app.getCurrentAccountUin());
          ((JSONObject)localObject1).put("viewTag", "qpay_hb_share");
          ((JSONObject)localObject1).put("extra_data", localObject2);
        }
      }
      catch (Exception localException)
      {
        Object localObject2;
        continue;
      }
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("json", ((JSONObject)localObject1).toString());
      ((Bundle)localObject2).putString("callbackSn", "0");
      if (QLog.isColorLevel()) {
        QLog.d("Q.send_hong_bao", 2, "ForwardOperations.forwardTo(). passed data=" + ((Bundle)localObject2).toString());
      }
      localObject1 = new Intent(this.mActivity, PayBridgeActivity.class);
      ((Intent)localObject1).putExtras((Bundle)localObject2);
      ((Intent)localObject1).putExtra("pay_requestcode", 5);
      this.mActivity.startActivityForResult((Intent)localObject1, 20002);
      am(2131693982);
      return true;
      ((JSONObject)localObject2).put("recv_type", 3);
      ((JSONObject)localObject2).put("group_id", this.bf.getString("uin"));
      continue;
      ((JSONObject)localObject2).put("recv_type", 2);
      ((JSONObject)localObject2).put("group_id", this.bf.getString("uin"));
      continue;
      ((JSONObject)localObject2).put("recv_type", 1);
    }
  }
  
  protected void dnr()
  {
    if ((anv()) && ((this.cZZ & 0x100) > 0)) {
      this.cs.add(U);
    }
    if ((anw()) && ((this.cZZ & 0x10) > 0)) {
      this.cs.add(T);
    }
    if ((anx()) && ((this.cZZ & 0x1) > 0)) {
      this.cs.add(S);
    }
  }
  
  public String getTitle()
  {
    if (TextUtils.isEmpty(this.title)) {
      return super.getTitle();
    }
    return this.title;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    paramInt2 = 1;
    hideProgressDialog();
    paramIntent = paramIntent.getStringExtra("result");
    if (QLog.isColorLevel()) {
      QLog.d("Q.send_hong_bao", 2, "ForwardOperations.onActivityResult_sendHongBao(). result_from_cai_fu_tong_SDK=" + paramIntent);
    }
    for (;;)
    {
      int i;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramIntent);
        paramInt1 = paramInt2;
        if (localJSONObject.has("resultCode"))
        {
          i = localJSONObject.getInt("resultCode");
          if (i != 0) {
            break label440;
          }
          paramIntent = this.bf.getString("invoke_from");
          if (QLog.isColorLevel()) {
            QLog.d("Q.send_hong_bao", 2, "ForwardOperations.onActivityResult_sendHongBao(). from=" + paramIntent);
          }
          if ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("qwallet")))
          {
            paramIntent = wja.a(new Intent(this.mActivity, SplashActivity.class), null);
            paramIntent.putExtras(this.bf);
            this.mActivity.startActivity(paramIntent);
            this.mActivity.setResult(-1);
          }
          this.mActivity.setResult(-1);
          this.mActivity.finish();
          paramInt1 = 0;
        }
        if (paramInt1 != 0)
        {
          String str = this.mActivity.getString(2131694003);
          paramIntent = str;
          if (localJSONObject.has("retmsg"))
          {
            paramIntent = str;
            if (!TextUtils.isEmpty(localJSONObject.getString("retmsg"))) {
              paramIntent = localJSONObject.getString("retmsg");
            }
          }
          if (this.daa > 0)
          {
            this.daa -= 1;
            paramIntent = aqha.a(this.mActivity, 230, acfp.m(2131706524), paramIntent, null, null);
            paramIntent.setPositiveButton(2131693981, new ahlg(this, paramIntent));
            paramIntent.setNegativeButton(2131721058, new ahlh(this, paramIntent));
            paramIntent.show();
            return;
            paramIntent = aqha.a(this.mActivity, 230, acfp.m(2131706522), this.mActivity.getString(2131694003), null, null);
            paramIntent.setNegativeButton(2131691039, new ahlf(this, paramIntent));
            paramIntent.show();
            paramInt1 = 0;
            continue;
          }
          paramIntent = aqha.a(this.mActivity, 230, acfp.m(2131706510), paramIntent, null, null);
          paramIntent.setNegativeButton(2131691039, new ahli(this, paramIntent));
          paramIntent.show();
          return;
        }
      }
      catch (JSONException paramIntent)
      {
        paramIntent.printStackTrace();
      }
      return;
      label440:
      if (i != 66201004)
      {
        paramInt1 = paramInt2;
        if (i != 66209015) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahle
 * JD-Core Version:    0.7.0.1
 */