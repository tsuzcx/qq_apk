import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.DanceMachineUploadVideoFragment;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.dancemachine.VideoSharer.1;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder.a;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.b;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;

public class rfo
  implements AdapterView.OnItemClickListener
{
  public static int bqz = -1;
  private long BQ = -1L;
  private WeakReference<AppInterface> K;
  public alyg a;
  protected String aAp;
  protected String aAq;
  protected String aAr;
  protected String aAs;
  public String aAt;
  private String azQ = "https://qun.qq.com/qqweb/m/qun/qun_activity/dance-game.html";
  private String azR = "?ddcat=%s&ddid=%s&uuid=%s&md5=%s&_wv=16778243&_bid=2932";
  protected String azS = "";
  public String bN;
  private int bqA = -1;
  protected int bqM;
  private WXShareHelper.a c;
  protected String mAudioPath;
  public Activity mContext;
  public String mShareUrl;
  protected String mVideoPath;
  
  private boolean Lm()
  {
    String str = null;
    if (!WXShareHelper.a().isWXinstalled()) {
      str = acfp.m(2131716450);
    }
    while (!TextUtils.isEmpty(str))
    {
      bqz = -1;
      QQToast.a(this.mContext, 1, str, 0).show();
      return false;
      if (!WXShareHelper.a().isWXsupportApi()) {
        str = acfp.m(2131716437);
      }
    }
    return true;
  }
  
  private List<ShareActionSheetBuilder.ActionSheetItem>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131721057);
    localActionSheetItem.icon = 2130840732;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131698652);
    localActionSheetItem.icon = 2130839256;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131698633);
    localActionSheetItem.icon = 2130839249;
    localActionSheetItem.action = 10;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    eU(localArrayList);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  private void xi(int paramInt)
  {
    if ((TextUtils.isEmpty(this.mShareUrl)) || (TextUtils.isEmpty(this.bN)) || (TextUtils.isEmpty(this.aAt))) {
      return;
    }
    ThreadManager.executeOnSubThread(new VideoSharer.1(this, paramInt));
  }
  
  protected boolean Ll()
  {
    if ((!TextUtils.isEmpty(this.mShareUrl)) && (!TextUtils.isEmpty(this.bN))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DanceMachinePKVideoSharer", 2, "hasShare : " + bool + " shareUrl : " + this.mShareUrl + " thumbPath : " + this.bN);
      }
      return bool;
    }
  }
  
  protected String a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if ("S".equals(paramString1)) {
      return "[QQ高能舞室]" + paramString2 + " " + paramInt1 + acfp.m(2131716446) + acfp.m(2131716452);
    }
    if ("A".equals(paramString1)) {
      return "[QQ高能舞室]" + paramString2 + " " + paramInt1 + acfp.m(2131716441) + acfp.m(2131716433);
    }
    if ("B".equals(paramString1)) {
      return "[QQ高能舞室]" + paramString2 + " " + paramInt1 + acfp.m(2131716443) + acfp.m(2131716449);
    }
    if ("C".equals(paramString1)) {
      return "[QQ高能舞室]" + paramString2 + " " + paramInt1 + acfp.m(2131716439) + acfp.m(2131716457);
    }
    return "[QQ高能舞室]" + acfp.m(2131716453);
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2, AppInterface paramAppInterface)
  {
    this.mContext = paramActivity;
    this.mVideoPath = paramString2;
    this.mAudioPath = paramString1;
    this.a = new alyg(this.mContext);
    this.a.setActionSheetItems(a(this.mContext));
    this.a.setItemClickListener(this);
    this.a.setActionSheetTitle(this.mContext.getString(2131720177));
    this.K = new WeakReference(paramAppInterface);
    paramActivity = this.mContext.getIntent().getParcelableExtra(EditVideoParams.class.getName());
    if (paramActivity != null)
    {
      paramActivity = ((EditVideoParams)paramActivity).mExtra;
      if (paramActivity != null)
      {
        this.aAp = paramActivity.getString("dance_machine_score_rate");
        this.bqM = paramActivity.getInt("dance_machine_score", 0);
        this.aAq = paramActivity.getString("dance_machine_ptv_category");
        this.aAr = paramActivity.getString("dance_machine_ptv_id");
        this.aAs = paramActivity.getString("over_percent");
        paramActivity = paramActivity.getString("web_share_url");
        if (!TextUtils.isEmpty(paramActivity)) {
          this.azQ = paramActivity;
        }
      }
    }
  }
  
  public String ai(String paramString1, String paramString2)
  {
    String str5 = "";
    try
    {
      if (!TextUtils.isEmpty(this.aAq))
      {
        str1 = URLEncoder.encode(this.aAq, "UTF-8");
        str2 = str5;
        str4 = str1;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          String str2;
          if (!TextUtils.isEmpty(this.aAr))
          {
            str2 = URLEncoder.encode(this.aAr, "UTF-8");
            str4 = str1;
          }
          if (QLog.isColorLevel()) {
            QLog.d("DanceMachinePKVideoSharer", 2, "[DanceMachine Share] encodedCategory : " + str4 + "  encodedPtvId : " + str2);
          }
          return this.azQ + String.format(this.azR, new Object[] { str4, str2, paramString1, paramString2 });
        }
        catch (Exception localException2)
        {
          String str4;
          String str3;
          continue;
        }
        localException1 = localException1;
        String str1 = "";
        localException1.printStackTrace();
        str3 = str5;
        str4 = str1;
        continue;
        str1 = "";
      }
    }
  }
  
  protected boolean b(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    return false;
  }
  
  public void btL()
  {
    if (this.a != null) {
      this.a.show();
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DanceMachinePKVideoSharer", 2, "upload fail");
      }
      QQToast.a(this.mContext, 1, acfp.m(2131716435), 1).show();
    }
    do
    {
      do
      {
        return;
        localObject = this.mContext;
        if (paramInt2 != 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("DanceMachinePKVideoSharer", 2, "upload canceled by user");
      return;
      localObject = this.mContext;
    } while ((paramInt2 != -1) || (paramIntent == null));
    int i = paramIntent.getExtras().getInt("share_method");
    Object localObject = paramIntent.getExtras().getString("pk_rank", "0");
    try
    {
      paramInt2 = Integer.parseInt((String)localObject);
      this.BQ = paramIntent.getExtras().getLong("upload_time_cost", -1L);
      this.azS = paramIntent.getExtras().getString("current_nickname", "");
      String str1 = paramIntent.getExtras().getString("upload_video_uuid");
      localObject = paramIntent.getExtras().getString("upload_video_md5");
      String str2 = paramIntent.getExtras().getString("upload_video_thumb");
      if (paramInt1 == 24466)
      {
        str1 = paramIntent.getExtras().getString("upload_pic_uuid");
        localObject = paramIntent.getExtras().getString("upload_pic_md5");
      }
      this.bN = ge(str2);
      this.mShareUrl = ai(str1, (String)localObject);
      this.aAt = a(this.bqM, this.aAp, this.azS, paramInt2);
      if (QLog.isColorLevel()) {
        QLog.d("DanceMachinePKVideoSharer", 2, "[DanceMachine Share] share  uuid : " + str1 + "  md5 : " + (String)localObject + "  thumbPath : " + this.bN + "  shareUrl : " + this.mShareUrl + "  shareDescStr : " + this.aAt);
      }
      xi(i);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        paramInt2 = 0;
        localNumberFormatException.printStackTrace();
      }
    }
  }
  
  public void doOnDestroy()
  {
    sw(this.bN);
    if (this.c != null) {
      WXShareHelper.a().b(this.c);
    }
  }
  
  protected void eU(List<ShareActionSheetBuilder.ActionSheetItem> paramList) {}
  
  public void eh(int paramInt1, int paramInt2)
  {
    new rfo.a(this.mContext, this.mAudioPath, this.mVideoPath, paramInt1, this.K, paramInt2).execute(new Void[0]);
  }
  
  public int f(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = this.mContext.getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getApplicationInfo("com.sina.weibo", 8192);
      if (QLog.isColorLevel()) {
        QLog.d("DanceMachinePKVideoSharer", 2, "shareMsgToSina installSinaWeibo:true");
      }
      if ((paramString3 == null) || (!new File(paramString3).exists()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DanceMachinePKVideoSharer", 2, "shareMsgToSina Thumb Path Invalid");
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("DanceMachinePKVideoSharer", 2, "shareMsgToSina path:" + paramString3);
        }
        Intent localIntent = new Intent("android.intent.action.SEND");
        localIntent.setFlags(268435456);
        localIntent.setType("image/*");
        localIntent.putExtra("android.intent.extra.TEXT", paramString1 + paramString2);
        localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(paramString3)));
        localIntent.setPackage(((ApplicationInfo)localObject).packageName);
        FileProvider7Helper.intentCompatForN(BaseApplicationImpl.getApplication(), localIntent);
        BaseApplicationImpl.getApplication().startActivity(localIntent);
        if (QLog.isColorLevel()) {
          QLog.d("DanceMachinePKVideoSharer", 2, "shareMsgToSina start weibo!");
        }
        return 0;
      }
    }
    catch (PackageManager.NameNotFoundException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DanceMachinePKVideoSharer", 2, "shareMsgToSina installSinaWeibo:false");
      }
      return -2;
    }
    return -1;
  }
  
  public String ge(String paramString)
  {
    if (!TextUtils.isEmpty(this.bN)) {
      sw(this.bN);
    }
    return paramString;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.getActionSheet().isShowing()) {
      this.a.getActionSheet().dismiss();
    }
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = ((ShareActionSheetBuilder.b)paramView.getTag()).b;
    int i = localActionSheetItem.action;
    bqz = i;
    if (b(localActionSheetItem)) {}
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      switch (i)
      {
      case 11: 
      default: 
        break;
      case 9: 
        if (Lm())
        {
          alwx.Pq("wechat_friends");
          if (Ll()) {
            xi(1);
          } else {
            eh(1, 0);
          }
        }
        break;
      case 10: 
        if (Lm())
        {
          alwx.Pq("wechat_moments");
          if (Ll()) {
            xi(2);
          } else {
            eh(2, 0);
          }
        }
        break;
      case 12: 
        alwx.Pq("weibo");
        if (Ll()) {
          xi(0);
        } else {
          eh(0, 0);
        }
        break;
      }
    }
  }
  
  protected void sw(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      aqhq.cn(new File(paramString).getParent());
    }
  }
  
  static class a
    extends AsyncTask<Void, Void, Integer>
  {
    String aAu;
    String aAv;
    int bpt;
    int bqO;
    private ProgressDialog e;
    WeakReference<AppInterface> mApp;
    Activity mContext;
    private TextView yw;
    
    public a(Activity paramActivity, String paramString1, String paramString2, int paramInt1, WeakReference<AppInterface> paramWeakReference, int paramInt2)
    {
      this.mContext = paramActivity;
      this.aAv = paramString1;
      this.aAu = paramString2;
      this.bpt = paramInt1;
      this.mApp = paramWeakReference;
      this.bqO = paramInt2;
    }
    
    private void U(Context paramContext, int paramInt)
    {
      j("showProgressDialog", null);
      try
      {
        if (this.e != null) {
          cancleProgressDailog();
        }
        for (;;)
        {
          this.yw.setText(paramInt);
          if (this.e.isShowing()) {
            break;
          }
          this.e.show();
          return;
          this.e = new ReportProgressDialog(paramContext, 2131756467);
          this.e.setCancelable(false);
          this.e.show();
          this.e.setContentView(2131559761);
          this.yw = ((TextView)this.e.findViewById(2131373180));
        }
        return;
      }
      catch (Throwable paramContext)
      {
        j("showProgressDialog", paramContext);
      }
    }
    
    private int a(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      if (!anku.x((AppInterface)this.mApp.get())) {
        return -1002;
      }
      anku.x(null);
      if ((paramString2 == null) || ("".equals(paramString2))) {
        return 0;
      }
      if ((paramString1 == null) || ("".equals(paramString1))) {
        return -1002;
      }
      paramString4 = paramString1 + File.separator + paramString4 + "_target.mp4";
      paramString1 = paramString1 + File.separator + "mc_audio.mp4";
      Object localObject = new File(paramString1);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      localObject = AudioEncoder.a(null, null, 0);
      ((AudioEncoder.a)localObject).cez = paramString1;
      ((AudioEncoder.a)localObject).cey = paramString2;
      int i = AudioEncoder.el(paramString2);
      if (i != 0) {
        j("checkSourceAudioIsOK: errcode=" + i, null);
      }
      for (;;)
      {
        return 0;
        long l = System.currentTimeMillis();
        i = AudioEncoder.a((AudioEncoder.a)localObject);
        j("AudioEncoder.encodeSafely:time=" + (System.currentTimeMillis() - l) / 1000.0D, null);
        if (i != 0)
        {
          j("AudioEncoder.encodeSafely: errcode=" + i, null);
          return i;
        }
        paramString2 = new File(paramString1);
        if (!paramString2.exists())
        {
          j("AudioEncoder.encodeSafely: exists = false", null);
        }
        else
        {
          i = ankf.c(paramString3, paramString1, paramString4, 0);
          paramString2.delete();
          if (i != 0)
          {
            j("HwVideoMerge.merge: errcode=" + i, null);
            return i;
          }
          this.aAu = paramString4;
        }
      }
    }
    
    private void cancleProgressDailog()
    {
      j("cancleProgressDailog", null);
      try
      {
        if (this.e != null)
        {
          this.e.cancel();
          this.e = null;
        }
        return;
      }
      catch (Exception localException) {}
    }
    
    private void j(String paramString, Throwable paramThrowable)
    {
      if (QLog.isColorLevel())
      {
        if (paramThrowable != null) {
          QLog.d("DanceMachinePKVideoSharer", 2, "[@] " + paramString, paramThrowable);
        }
      }
      else {
        return;
      }
      QLog.d("DanceMachinePKVideoSharer", 2, "[@] " + paramString);
    }
    
    protected Integer a(Void... paramVarArgs)
    {
      Object localObject = new File(this.aAu);
      paramVarArgs = ((File)localObject).getParent();
      localObject = ((File)localObject).getName();
      return Integer.valueOf(a(paramVarArgs, this.aAv, this.aAu, (String)localObject));
    }
    
    protected void onPostExecute(Integer paramInteger)
    {
      cancleProgressDailog();
      if (paramInteger.intValue() == 0)
      {
        paramInteger = new Intent();
        paramInteger.putExtra("upload_video_path", this.aAu);
        paramInteger.putExtra("share_method", this.bpt);
        paramInteger.putExtra("pk_rank", this.bqO);
        PublicTransFragmentActivity.startForResult(this.mContext, paramInteger, DanceMachineUploadVideoFragment.class, 90001);
        this.mContext = null;
        return;
      }
      j(acfp.m(2131716434) + paramInteger, null);
    }
    
    protected void onPreExecute()
    {
      U(this.mContext, 2131696921);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rfo
 * JD-Core Version:    0.7.0.1
 */