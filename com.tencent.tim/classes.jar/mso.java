import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountBrowser.a;
import com.tencent.biz.pubaccount.PublicAccountBrowser.b;
import com.tencent.biz.pubaccount.PublicAccountBrowser.c;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.video.TopicShareHelper.4;
import com.tencent.biz.pubaccount.readinjoy.video.TopicShareHelper.5;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class mso
  implements AdapterView.OnItemClickListener
{
  public static String akb = "https://kandian.qq.com/mqq/html/topicvideo.html?_wv=3&_bid=2378&videotopicid=";
  private ausj E;
  private myz a;
  private boolean anG = true;
  private boolean anH;
  private ChannelInfo c;
  private Bitmap cb;
  private URLDrawable h;
  private arhz m;
  private Activity mActivity;
  private QQAppInterface mApp;
  private Context mContext;
  private Intent mIntent;
  
  public mso(Activity paramActivity)
  {
    this.mActivity = paramActivity;
    this.mContext = paramActivity;
    paramActivity = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramActivity instanceof QQAppInterface))
    {
      this.mApp = ((QQAppInterface)paramActivity);
      paramActivity = awit.a(this.mApp, true, true).getString("readinjoy_social_weburl_topicvideo", "");
      if (!TextUtils.isEmpty(paramActivity))
      {
        akb = paramActivity;
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video.TopicShareHelper", 2, "update SHARE_URL_PREF from config, config=" + paramActivity);
        }
      }
    }
  }
  
  private View L()
  {
    View localView = LayoutInflater.from(this.mActivity).inflate(2131559311, null);
    float f = this.mActivity.getResources().getDisplayMetrics().density;
    ElasticHorScrView localElasticHorScrView1 = (ElasticHorScrView)localView.findViewById(2131377768);
    ElasticHorScrView localElasticHorScrView2 = (ElasticHorScrView)localView.findViewById(2131377769);
    GridView localGridView2 = (GridView)localView.findViewById(2131368140);
    GridView localGridView1 = (GridView)localView.findViewById(2131368141);
    Object localObject1 = (TextView)localView.findViewById(2131362018);
    Object localObject2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject2).topMargin = ((int)(13.0F * f));
    ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((TextView)localObject1).setText(2131721058);
    ((TextView)localObject1).setOnClickListener(new msq(this));
    this.E.setOnDismissListener(new msr(this));
    if (Build.VERSION.SDK_INT >= 9)
    {
      localElasticHorScrView1.setOverScrollMode(2);
      localElasticHorScrView2.setOverScrollMode(2);
    }
    localGridView1.setSmoothScrollbarEnabled(false);
    localObject2 = a();
    if (localObject2.length > 0)
    {
      localObject1 = localObject2[0];
      if (localObject2.length <= 1) {
        break label430;
      }
    }
    label430:
    for (localObject2 = localObject2[1];; localObject2 = new ArrayList(0))
    {
      int i = ((List)localObject1).size();
      localGridView2.setNumColumns(i);
      ViewGroup.LayoutParams localLayoutParams = localGridView2.getLayoutParams();
      localLayoutParams.width = ((int)(((i - 1) * 10 + i * 75 + 3) * f));
      localGridView2.setLayoutParams(localLayoutParams);
      localGridView2.setAdapter(new PublicAccountBrowser.b(this.mActivity, 0, (List)localObject1));
      localGridView2.setSelector(new ColorDrawable(0));
      localGridView2.setOnItemClickListener(this);
      i = localLayoutParams.width;
      int j = ((List)localObject2).size();
      localObject1 = localGridView1.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = ((int)(f * (j * 75 + (j - 1) * 10 + 3)));
      localGridView1.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localGridView1.setNumColumns(j);
      localGridView1.setAdapter(new PublicAccountBrowser.b(this.mActivity, 0, (List)localObject2));
      localGridView1.setSelector(new ColorDrawable(0));
      localGridView1.setOnItemClickListener(this);
      localView.post(new TopicShareHelper.4(this, localElasticHorScrView1, i, localElasticHorScrView2, ((ViewGroup.LayoutParams)localObject1).width));
      return localView;
      localObject1 = new ArrayList(0);
      break;
    }
  }
  
  public static String a(ChannelInfo paramChannelInfo, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramInt = 6;
    }
    try
    {
      for (;;)
      {
        String str1 = URLEncoder.encode(paramChannelInfo.mChannelName, "UTF-8");
        return akb + paramChannelInfo.mChannelID + "&topicname=" + str1 + "&sourcefrom=" + paramInt;
        paramInt = 0;
        continue;
        paramInt = 1;
        continue;
        paramInt = 2;
        continue;
        paramInt = 3;
        continue;
        paramInt = 4;
        continue;
        paramInt = 5;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
        String str2 = "";
      }
    }
  }
  
  private List<PublicAccountBrowser.a>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new PublicAccountBrowser.a();
    ((PublicAccountBrowser.a)localObject).label = this.mActivity.getResources().getString(2131698630);
    ((PublicAccountBrowser.a)localObject).icon = 2130839252;
    ((PublicAccountBrowser.a)localObject).iconNeedBg = true;
    ((PublicAccountBrowser.a)localObject).action = 2;
    ((PublicAccountBrowser.a)localObject).argus = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.a();
    ((PublicAccountBrowser.a)localObject).label = this.mActivity.getResources().getString(2131698643);
    ((PublicAccountBrowser.a)localObject).icon = 2130839253;
    ((PublicAccountBrowser.a)localObject).iconNeedBg = true;
    ((PublicAccountBrowser.a)localObject).action = 3;
    ((PublicAccountBrowser.a)localObject).argus = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.a();
    ((PublicAccountBrowser.a)localObject).label = this.mActivity.getResources().getString(2131698652);
    ((PublicAccountBrowser.a)localObject).icon = 2130839256;
    ((PublicAccountBrowser.a)localObject).action = 9;
    ((PublicAccountBrowser.a)localObject).argus = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.a();
    ((PublicAccountBrowser.a)localObject).label = this.mActivity.getResources().getString(2131698633);
    ((PublicAccountBrowser.a)localObject).icon = 2130839249;
    ((PublicAccountBrowser.a)localObject).action = 10;
    ((PublicAccountBrowser.a)localObject).argus = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.a();
    ((PublicAccountBrowser.a)localObject).label = this.mActivity.getResources().getString(2131698647);
    ((PublicAccountBrowser.a)localObject).icon = 2130839255;
    ((PublicAccountBrowser.a)localObject).action = 12;
    ((PublicAccountBrowser.a)localObject).argus = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.a();
    ((PublicAccountBrowser.a)localObject).label = this.mActivity.getResources().getString(2131698627);
    ((PublicAccountBrowser.a)localObject).iconNeedBg = true;
    ((PublicAccountBrowser.a)localObject).icon = 2130843489;
    ((PublicAccountBrowser.a)localObject).action = 4;
    ((PublicAccountBrowser.a)localObject).argus = "";
    localArrayList.add(localObject);
    localObject = new ArrayList();
    PublicAccountBrowser.a locala = new PublicAccountBrowser.a();
    locala.label = this.mActivity.getResources().getString(2131698622);
    locala.icon = 2130839246;
    locala.iconNeedBg = true;
    locala.action = 1;
    locala.argus = "";
    ((ArrayList)localObject).add(locala);
    locala = new PublicAccountBrowser.a();
    locala.label = this.mActivity.getResources().getString(2131698628);
    locala.icon = 2130843479;
    locala.iconNeedBg = true;
    locala.action = 11;
    locala.argus = "";
    ((ArrayList)localObject).add(locala);
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  private void aRM()
  {
    this.cb = null;
    this.h = null;
    do
    {
      try
      {
        this.h = URLDrawable.getDrawable(this.c.mHeaderPicUrl, null, null);
        if ((this.h != null) && (this.h.getStatus() == 1) && ((this.h.getCurrDrawable() instanceof RegionDrawable)))
        {
          this.cb = ((RegionDrawable)this.h.getCurrDrawable()).getBitmap();
          return;
        }
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("Q.readinjoy.video.TopicShareHelper", 2, "initTopicThumbBitmap() URLDrawable.getDrawable ERROR, RETURN");
        return;
      }
    } while (this.h == null);
    this.h.setURLDrawableListener(new msp(this));
    this.h.startDownload();
  }
  
  public void a(ChannelInfo paramChannelInfo, Intent paramIntent, myz parammyz)
  {
    this.c = paramChannelInfo;
    this.mIntent = paramIntent;
    this.a = parammyz;
    aRL();
  }
  
  public void aRL()
  {
    if (this.E == null) {
      this.E = ((ausj)auss.a(this.mActivity, null));
    }
    View localView = L();
    this.E.setActionContentView(localView, null);
    try
    {
      if (!this.E.isShowing())
      {
        this.E.show();
        aRM();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 0;
    this.anH = true;
    Object localObject1 = paramView.getTag();
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder().append("onItemClick, tag = ");
      if (localObject1 == null) {
        break label76;
      }
    }
    label76:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("Q.readinjoy.video.TopicShareHelper", 2, bool);
      if (localObject1 != null) {
        break;
      }
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    if ((this.E != null) && (this.E.isShowing())) {
      this.E.dismiss();
    }
    int j = ((PublicAccountBrowser.c)localObject1).a.action;
    if (j == 2)
    {
      this.anG = false;
      ahgq.f(this.mActivity, this.mIntent, 21);
    }
    for (;;)
    {
      ThreadManager.executeOnSubThread(new TopicShareHelper.5(this, i + ""));
      break;
      if (j == 3)
      {
        this.anG = false;
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("detail_url", a(this.c, 1));
        localObject3 = new ArrayList(1);
        ((ArrayList)localObject3).add(this.c.mHeaderPicUrl);
        ((Bundle)localObject1).putStringArrayList("image_url", (ArrayList)localObject3);
        ((Bundle)localObject1).putLong("req_share_id", 0L);
        avqq.a(this.mApp, this.mActivity, (Bundle)localObject1, null);
        i = 1;
        continue;
      }
      if ((j == 9) || (j == 10))
      {
        this.anG = false;
        if (j == 9)
        {
          a(this.c, 2);
          i = 2;
        }
        for (;;)
        {
          localObject1 = new StringBuilder();
          if (this.c.mFollowNum > 0) {
            ((StringBuilder)localObject1).append(this.c.mFollowNum).append("人正在关注");
          }
          break;
          i = 4;
          a(this.c, 3);
        }
      }
      if (j == 12)
      {
        this.anG = false;
        i = 5;
        continue;
      }
      if (j == 4)
      {
        this.anG = false;
        localObject1 = new Intent("android.intent.action.VIEW", Uri.parse(a(this.c, 6)));
        ((Intent)localObject1).putExtra("big_brother_source_key", kxm.bg(0));
        ((Intent)localObject1).putExtra("normal", true);
        try
        {
          this.mActivity.startActivity((Intent)localObject1);
          i = 3;
        }
        catch (ActivityNotFoundException localActivityNotFoundException)
        {
          for (;;)
          {
            rwt.ez(1, 2131697436);
          }
        }
      }
      String str;
      if (j == 6)
      {
        str = this.mApp.getCurrentAccountUin();
        aviz.a(a(this.c, 6)).c(str).b(this.mActivity, str, 101, null);
        i = 6;
        continue;
      }
      if (j == 1)
      {
        ((ClipboardManager)this.mContext.getSystemService("clipboard")).setText(a(this.c, 6));
        rwt.ez(2, 2131692332);
        i = 3;
        continue;
      }
      if (j == 11)
      {
        this.anG = false;
        localObject3 = null;
      }
      try
      {
        str = URLEncoder.encode(a(this.c, 6), "UTF-8");
        str = "https://post.mp.qq.com/jubao/index?_wv=3&url=" + str + "&type=5&key=" + this.c.mChannelID;
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video.TopicShareHelper", 2, "click jubao btn, reportUrl:" + str);
        }
        localObject3 = new Intent(this.mActivity, QQBrowserActivity.class);
        ((Intent)localObject3).putExtra("url", str);
        ((Intent)localObject3).putExtra("hide_more_button", true);
        this.mActivity.startActivity((Intent)localObject3);
        i = 3;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          Object localObject2 = localObject3;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.readinjoy.video.TopicShareHelper", 2, "encode url failed, because UTF-8 is unknown");
            localObject2 = localObject3;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mso
 * JD-Core Version:    0.7.0.1
 */