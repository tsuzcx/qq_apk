import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class yhz
  implements Handler.Callback, View.OnClickListener, yjf
{
  private static final String aYb = acfp.m(2131703323);
  private static final String aYc = acfp.m(2131703324);
  private asgx jdField_a_of_type_Asgx;
  private yjh jdField_a_of_type_Yjh;
  private String aYd;
  private String aYe;
  private int bZg;
  private int bZh;
  private Set<String> bv;
  private String mContent;
  private BaseActivity mContext;
  private Handler mHandler;
  private String mURL;
  
  public yhz(BaseActivity paramBaseActivity, yjh paramyjh)
  {
    this.mContext = paramBaseActivity;
    this.jdField_a_of_type_Yjh = paramyjh;
    this.jdField_a_of_type_Asgx = ((asgx)paramBaseActivity.app.getManager(165));
    paramBaseActivity = SharedPreferencesProxyManager.getInstance().getProxy("qidian_sp", 0);
    this.mContent = paramBaseActivity.getString("sp_c2b_tip_content", aYb);
    this.mURL = paramBaseActivity.getString("sp_c2b_tip_url", "https://m.qidian.qq.com/agreement/verified.html");
    this.aYd = paramBaseActivity.getString("sp_c2b_tip_highlight", aYc);
    this.bZg = paramBaseActivity.getInt("sp_c2b_tip_is_show", 1);
    this.bv = paramBaseActivity.getStringSet("sp_c2b_tip_uins_shown", new HashSet());
    this.bZh = paramBaseActivity.getInt("sp_c2b_tip_hide_time", 60);
    this.mHandler = new Handler(this);
  }
  
  public static void clearConfig()
  {
    SharedPreferences.Editor localEditor = SharedPreferencesProxyManager.getInstance().getProxy("qidian_sp", 0).edit();
    localEditor.remove("sp_c2b_tip_content");
    localEditor.remove("sp_c2b_tip_url");
    localEditor.remove("sp_c2b_tip_highlight");
    localEditor.remove("sp_c2b_tip_is_show");
    localEditor.remove("sp_c2b_tip_hide_time");
    localEditor.apply();
  }
  
  public static boolean ia(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (!"lawtip".equals(paramString.getString("type"))) {
        return false;
      }
      SharedPreferences.Editor localEditor = SharedPreferencesProxyManager.getInstance().getProxy("qidian_sp", 0).edit();
      localEditor.putString("sp_c2b_tip_content", paramString.getString("content"));
      localEditor.putString("sp_c2b_tip_url", paramString.getString("url"));
      localEditor.putString("sp_c2b_tip_highlight", paramString.getString("highlight"));
      localEditor.putInt("sp_c2b_tip_is_show", paramString.getInt("show"));
      localEditor.putInt("sp_c2b_tip_hide_time", paramString.getInt("hideTime"));
      localEditor.apply();
      return true;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("C2BTipsBar", 2, "parse config error:" + paramString.toString());
      }
    }
    return false;
  }
  
  public int[] E()
  {
    return null;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = LayoutInflater.from(this.mContext).inflate(2131558696, null);
    TextView localTextView = (TextView)paramVarArgs.findViewById(2131362531);
    SpannableString localSpannableString = new SpannableString(this.mContent);
    int i = 0;
    for (;;)
    {
      if (i < this.mContent.length())
      {
        i = this.mContent.indexOf(this.aYd, i);
        if (i >= 0) {}
      }
      else
      {
        localTextView.setText(localSpannableString);
        paramVarArgs.setOnClickListener(this);
        paramVarArgs.findViewById(2131362530).setOnClickListener(this);
        return paramVarArgs;
      }
      localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#12b7f5")), i, this.aYd.length() + i, 33);
      i += this.aYd.length();
    }
  }
  
  public int getType()
  {
    return 22;
  }
  
  public void h(int paramInt, Object... paramVarArgs) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && (this.jdField_a_of_type_Yjh.a() == this)) {
      this.jdField_a_of_type_Yjh.ciA();
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = new Intent(this.mContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.mURL);
      ((Intent)localObject).putExtra("hide_operation_bar", true);
      this.mContext.startActivity((Intent)localObject);
      anot.a(this.mContext.app, "dc00899", "Qidian", this.aYe, "0X8009788", "ClickLawTip", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), this.jdField_a_of_type_Asgx.qW(this.aYe), "3.4.4", "");
      continue;
      localObject = new HashSet(this.bv);
      ((HashSet)localObject).add(this.aYe);
      SharedPreferences.Editor localEditor = SharedPreferencesProxyManager.getInstance().getProxy("qidian_sp", 0).edit();
      localEditor.putStringSet("sp_c2b_tip_uins_shown", (Set)localObject);
      localEditor.apply();
      this.bv = ((Set)localObject);
      this.mHandler.removeMessages(1);
      this.jdField_a_of_type_Yjh.ciA();
      anot.a(this.mContext.app, "dc00899", "Qidian", this.aYe, "0X8009789", "CloseLawTip", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), this.jdField_a_of_type_Asgx.qW(this.aYe), "3.4.4", "");
    }
  }
  
  public int wM()
  {
    return 59;
  }
  
  public void yI(String paramString)
  {
    if ((this.bZg == 0) || (this.bv.contains(paramString))) {
      return;
    }
    this.aYe = paramString;
    this.jdField_a_of_type_Yjh.a(this, new Object[0]);
    this.mHandler.removeMessages(1);
    this.mHandler.sendEmptyMessageDelayed(1, this.bZh * 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yhz
 * JD-Core Version:    0.7.0.1
 */