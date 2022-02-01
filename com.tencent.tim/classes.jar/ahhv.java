import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
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

public class ahhv
  extends ahgq
{
  private List<Integer> BW;
  private String bKD;
  private JSONObject bx;
  private String mUin;
  private String title;
  
  /* Error */
  public ahhv(Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 21	ahgq:<init>	(Landroid/content/Intent;)V
    //   5: aload_0
    //   6: new 23	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 26	java/util/ArrayList:<init>	()V
    //   13: putfield 28	ahhv:BW	Ljava/util/List;
    //   16: aload_0
    //   17: new 30	org/json/JSONObject
    //   20: dup
    //   21: aload_1
    //   22: ldc 32
    //   24: invokevirtual 38	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   27: invokespecial 41	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   30: putfield 43	ahhv:bx	Lorg/json/JSONObject;
    //   33: aload_0
    //   34: getfield 43	ahhv:bx	Lorg/json/JSONObject;
    //   37: ldc 45
    //   39: invokevirtual 48	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   42: astore_1
    //   43: aload_1
    //   44: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   47: ifne +90 -> 137
    //   50: aload_0
    //   51: getfield 58	ahhv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   54: ifnull +83 -> 137
    //   57: aload_1
    //   58: aload_0
    //   59: getfield 58	ahhv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   62: invokevirtual 64	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   65: invokevirtual 70	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   68: ifne +69 -> 137
    //   71: new 34	android/content/Intent
    //   74: dup
    //   75: invokespecial 71	android/content/Intent:<init>	()V
    //   78: astore_1
    //   79: new 30	org/json/JSONObject
    //   82: dup
    //   83: invokespecial 72	org/json/JSONObject:<init>	()V
    //   86: astore 4
    //   88: aload 4
    //   90: ldc 74
    //   92: ldc 76
    //   94: invokevirtual 80	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   97: pop
    //   98: aload 4
    //   100: ldc 82
    //   102: ldc 84
    //   104: invokevirtual 80	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   107: pop
    //   108: aload_1
    //   109: ldc 86
    //   111: aload 4
    //   113: invokevirtual 89	org/json/JSONObject:toString	()Ljava/lang/String;
    //   116: invokevirtual 93	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   119: pop
    //   120: aload_0
    //   121: getfield 97	ahhv:mActivity	Landroid/app/Activity;
    //   124: iconst_m1
    //   125: aload_1
    //   126: invokevirtual 103	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   129: aload_0
    //   130: getfield 97	ahhv:mActivity	Landroid/app/Activity;
    //   133: invokevirtual 106	android/app/Activity:finish	()V
    //   136: return
    //   137: ldc 108
    //   139: astore_1
    //   140: aload_0
    //   141: getfield 43	ahhv:bx	Lorg/json/JSONObject;
    //   144: ldc 110
    //   146: invokevirtual 48	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   149: astore 5
    //   151: aload_0
    //   152: getfield 43	ahhv:bx	Lorg/json/JSONObject;
    //   155: ldc 112
    //   157: invokevirtual 116	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   160: astore 4
    //   162: aload 5
    //   164: ldc 118
    //   166: invokevirtual 70	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   169: ifeq +77 -> 246
    //   172: aload 4
    //   174: ifnull +22 -> 196
    //   177: aload 4
    //   179: ldc 120
    //   181: invokevirtual 48	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   184: astore_1
    //   185: aload_0
    //   186: aload 4
    //   188: ldc 121
    //   190: invokevirtual 48	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   193: putfield 123	ahhv:title	Ljava/lang/String;
    //   196: aload_1
    //   197: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   200: ifne +95 -> 295
    //   203: aload_1
    //   204: ldc 125
    //   206: invokevirtual 129	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   209: astore_1
    //   210: iconst_0
    //   211: istore_2
    //   212: aload_1
    //   213: arraylength
    //   214: istore_3
    //   215: iload_2
    //   216: iload_3
    //   217: if_icmpge +78 -> 295
    //   220: aload_0
    //   221: getfield 28	ahhv:BW	Ljava/util/List;
    //   224: aload_1
    //   225: iload_2
    //   226: aaload
    //   227: invokestatic 135	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   230: invokestatic 139	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   233: invokeinterface 144 2 0
    //   238: pop
    //   239: iload_2
    //   240: iconst_1
    //   241: iadd
    //   242: istore_2
    //   243: goto -31 -> 212
    //   246: aload_0
    //   247: getfield 43	ahhv:bx	Lorg/json/JSONObject;
    //   250: ldc 146
    //   252: invokevirtual 116	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   255: astore 4
    //   257: aload 4
    //   259: ifnull -63 -> 196
    //   262: aload 4
    //   264: ldc 120
    //   266: invokevirtual 48	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   269: astore_1
    //   270: aload_0
    //   271: aload 4
    //   273: ldc 121
    //   275: invokevirtual 48	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   278: putfield 123	ahhv:title	Ljava/lang/String;
    //   281: goto -85 -> 196
    //   284: astore_1
    //   285: aload_1
    //   286: invokevirtual 149	org/json/JSONException:printStackTrace	()V
    //   289: return
    //   290: astore 4
    //   292: goto -53 -> 239
    //   295: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	this	ahhv
    //   0	296	1	paramIntent	Intent
    //   211	32	2	i	int
    //   214	4	3	j	int
    //   86	186	4	localJSONObject	JSONObject
    //   290	1	4	localNumberFormatException	java.lang.NumberFormatException
    //   149	14	5	str	String
    // Exception table:
    //   from	to	target	type
    //   16	136	284	org/json/JSONException
    //   140	172	284	org/json/JSONException
    //   177	196	284	org/json/JSONException
    //   196	210	284	org/json/JSONException
    //   212	215	284	org/json/JSONException
    //   220	239	284	org/json/JSONException
    //   246	257	284	org/json/JSONException
    //   262	281	284	org/json/JSONException
    //   220	239	290	java/lang/NumberFormatException
  }
  
  public List<RecentUser> aD(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if (localRecentUser != null)
      {
        if ((this.BW.contains(S)) && (localRecentUser.getType() == 0)) {
          localArrayList.add(localRecentUser);
        }
        if ((this.BW.contains(T)) && (localRecentUser.getType() == 1)) {
          localArrayList.add(localRecentUser);
        }
        if ((this.BW.contains(U)) && (localRecentUser.getType() == 3000)) {
          localArrayList.add(localRecentUser);
        }
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
    for (;;)
    {
      try
      {
        switch (this.bf.getInt("uintype"))
        {
        case 1: 
          localObject = this.bx;
          String str = this.bf.getString("uin");
          this.mUin = str;
          ((JSONObject)localObject).put("recv_uin", str);
          this.bx.put("appid", String.valueOf(AppSetting.getAppId()));
          this.bx.put("from_memo", this.app.getCurrentNickname());
          this.bx.put("userId", this.app.getCurrentAccountUin());
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        continue;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("ForwardOption.ForwardH5HongBaoOption", 4, "extra_data = " + this.bx);
      }
      localObject = new Intent(this.mActivity, SendHbActivity.class);
      ((Intent)localObject).putExtra("come_from", 2);
      ((Intent)localObject).putExtra("extra_data", this.bx.toString());
      ((Intent)localObject).putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", "groupType=0", 0, null));
      this.mActivity.startActivityForResult((Intent)localObject, 20002);
      return true;
      this.bKD = "group";
      this.bx.put("group_id", this.bf.getString("uin"));
      this.bx.put("recv_type", 3);
      continue;
      this.bKD = "discuss";
      this.bx.put("group_id", this.bf.getString("uin"));
      this.bx.put("recv_type", 2);
      continue;
      this.bKD = "c2c";
      this.bx.put("recv_type", 1);
    }
  }
  
  protected void dnr()
  {
    Iterator localIterator = this.BW.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      if (anv()) {
        this.cs.add(Integer.valueOf(i));
      }
    }
  }
  
  public boolean e(int paramInt1, String paramString, int paramInt2)
  {
    return false;
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
    Object localObject = paramIntent.getStringExtra("result");
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardH5HongBaoOption", 2, "onActivityResult = " + (String)localObject);
    }
    try
    {
      JSONObject localJSONObject2 = new JSONObject((String)localObject);
      if (localJSONObject2.optInt("resultCode", -1) != 0)
      {
        this.mActivity.setResult(-1, paramIntent);
        return;
      }
      JSONObject localJSONObject1 = localJSONObject2.optJSONObject("data");
      localObject = localJSONObject1;
      if (localJSONObject1 == null) {
        localObject = new JSONObject();
      }
      ((JSONObject)localObject).put("chat_type", this.bKD);
      ((JSONObject)localObject).put("uin", this.mUin);
      localJSONObject2.put("data", localObject);
      paramIntent.putExtra("result", localJSONObject2.toString());
      this.mActivity.setResult(-1, paramIntent);
      this.mActivity.finish();
      return;
    }
    catch (JSONException paramIntent)
    {
      paramIntent.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahhv
 * JD-Core Version:    0.7.0.1
 */