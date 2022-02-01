import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class jtw
{
  private final String TAG = jtw.class.getSimpleName();
  private AccountDetail b;
  private QQAppInterface mApp;
  private Context mContext;
  
  public jtw(QQAppInterface paramQQAppInterface, Context paramContext, AccountDetail paramAccountDetail)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.b = paramAccountDetail;
  }
  
  private Bundle a(jts paramjts)
  {
    boolean bool = true;
    Bundle localBundle1 = new Bundle();
    localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", this.b.uin);
    localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", this.b.name);
    localBundle1.putString("VIDEO_H5_URL", paramjts.jdField_a_of_type_Jtv.h5url);
    localBundle1.putString("VIDEO_CREATE_TIME", kxl.c(paramjts.jdField_a_of_type_Jtt.time, true));
    localBundle1.putString("VIDEO_TIME", String.valueOf(paramjts.jdField_a_of_type_Jtv.aDt));
    localBundle1.putString("VIDEO_WIDTH", String.valueOf(paramjts.jdField_a_of_type_Jtv.aDv));
    localBundle1.putString("VIDEO_HEIGHT", String.valueOf(paramjts.jdField_a_of_type_Jtv.aDu));
    localBundle1.putString("VIDEO_VID", paramjts.jdField_a_of_type_Jtv.vid);
    localBundle1.putString("VIDEO_COVER", paramjts.jdField_a_of_type_Jtv.cover);
    localBundle1.putString("VIDEO_ARTICLE_ID", String.valueOf(paramjts.jdField_a_of_type_Jtt.rowkey));
    if ((paramjts.jdField_a_of_type_Jtv.aDs == 2) || (paramjts.jdField_a_of_type_Jtv.aDs == 3))
    {
      localBundle1.putString("VIDEO_THIRD_ICON", smu.aEN + this.b.uin);
      localBundle1.putString("VIDEO_THIRD_NAME", this.b.name);
      localBundle1.putString("VIDEO_THIRD_ACTION", paramjts.jdField_a_of_type_Jtv.h5url);
      bool = false;
    }
    localBundle1.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
    localBundle1.putInt("VIDEO_ARTICLE_BUSITYPE", paramjts.jdField_a_of_type_Jtv.aDs);
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("VINFO", paramjts.jdField_a_of_type_Jtv.vid);
    localBundle2.putString("TINFO", paramjts.jdField_a_of_type_Jtv.vid);
    localBundle2.putInt("PREVIEW_VIDEO_TIME", paramjts.jdField_a_of_type_Jtv.aDt);
    localBundle2.putInt("PREVIEW_VIDEO_WIDTH", paramjts.jdField_a_of_type_Jtv.aDv);
    localBundle2.putInt("PREVIEW_VIDEO_HEIGHT", paramjts.jdField_a_of_type_Jtv.aDu);
    localBundle2.putInt("FULL_VIDEO_TIME", paramjts.jdField_a_of_type_Jtv.aDt);
    localBundle2.putString("ACCOUNT_UIN", this.b.uin);
    localBundle2.putString("source_puin", this.b.uin);
    localBundle2.putString("ACCOUNT_NAME", this.b.name);
    localBundle2.putInt("TYPE", paramjts.jdField_a_of_type_Jtv.aDs);
    localBundle2.putString("ARTICLE_ID", String.valueOf(paramjts.jdField_a_of_type_Jtt.qJ));
    localBundle2.putInt("layout_item", 5);
    localBundle2.putBoolean("video_url_load", false);
    localBundle2.putString("image_url_remote", paramjts.jdField_a_of_type_Jtv.cover);
    localBundle2.putString("detail_url", paramjts.jdField_a_of_type_Jtv.h5url);
    localBundle2.putString("video_url", paramjts.jdField_a_of_type_Jtv.vid);
    localBundle2.putString("title", paramjts.title);
    localBundle2.putString("req_create_time", kxl.ap(paramjts.jdField_a_of_type_Jtt.time));
    localBundle2.putString("brief_key", paramjts.title);
    localBundle2.putInt("req_type", 140);
    localBundle1.putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)anre.a(localBundle2)).getBytes());
    localBundle1.putString("VIDEO_TITLE", paramjts.title);
    return localBundle1;
  }
  
  private smu.a a()
  {
    smu.a locala = null;
    if (this.b != null) {
      locala = new smu.a(this.b.uin, this.b.name, this.b.summary);
    }
    return locala;
  }
  
  private void azD()
  {
    if (this.b == null) {
      return;
    }
    new smu(this.mApp, (BaseActivity)this.mContext, a(), 1, getShareUrl()).Qq();
  }
  
  private String getShareUrl()
  {
    int i = ocp.getAccountType(this.b.accountFlag);
    if ((i == -2) || (i == -5)) {
      return "https://share.mp.qq.com/cgi/share.php?uin=" + this.b.uin + "&account_flag=" + this.b.accountFlag + "&jumptype=1&card_type=public_account";
    }
    return "https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=accountCard&puin=" + this.b.uin;
  }
  
  private void lq(String paramString)
  {
    ReportDialog localReportDialog = new ReportDialog(this.mContext, 2131756467);
    localReportDialog.setContentView(2131561286);
    ((TextView)localReportDialog.findViewById(2131365903)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365891);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365889);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365895);
    localTextView1.setText(paramString);
    localTextView1.setGravity(3);
    localTextView2.setText(2131721058);
    localTextView3.setText(2131692643);
    localReportDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new jtx(this, localReportDialog));
    localTextView3.setOnClickListener(new jty(this, paramString));
    try
    {
      localReportDialog.show();
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void a(jts paramjts)
  {
    if ((this.mApp != null) && (this.mApp.bF()))
    {
      QQToast.a(this.mContext, 2131698108, 1).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "open full play activity, articleID : " + paramjts.jdField_a_of_type_Jtt.qJ + ",vid : " + paramjts.jdField_a_of_type_Jtv.vid);
    }
    paramjts = a(paramjts);
    Activity localActivity = (Activity)this.mContext;
    Intent localIntent = new Intent(localActivity, VideoFeedsPlayActivity.class);
    localIntent.addFlags(536870912);
    localIntent.putExtras(paramjts);
    localActivity.overridePendingTransition(2130772077, 2130772079);
    this.mContext.startActivity(localIntent);
  }
  
  public void b(jzs.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "handleItemClickEvent->type:" + parama.type + ", event_id:" + parama.aGH);
    }
    if (parama.type == 1) {
      lp(parama.url);
    }
    label66:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                break label66;
                break label66;
                break label66;
                break label66;
                do
                {
                  return;
                } while (parama.type != 3);
                if (parama.aGH != 7) {
                  break;
                }
              } while ((TextUtils.isEmpty(parama.lat)) || (TextUtils.isEmpty(parama.lng)));
              localObject = new Intent(this.mContext, QQMapActivity.class);
              ((Intent)localObject).putExtra("lat", parama.lat);
              ((Intent)localObject).putExtra("lon", parama.lng);
              if (!TextUtils.isEmpty(parama.content)) {
                ((Intent)localObject).putExtra("loc", parama.content);
              }
              this.mContext.startActivity((Intent)localObject);
              return;
              if (parama.aGH != 8) {
                break;
              }
              parama = parama.Vq;
            } while (TextUtils.isEmpty(parama));
            parama = parama.trim();
          } while (!Pattern.compile("[\\d-]+?").matcher(parama).matches());
          lq(parama);
          return;
          if (parama.aGH == 11)
          {
            parama = new Intent(this.mContext, ScannerActivity.class);
            parama.putExtra("from", this.mContext.getClass().getName());
            parama.putExtra("finishAfterSucc", true);
            this.mContext.startActivity(parama);
            return;
          }
          if (parama.aGH == 20)
          {
            azD();
            return;
          }
          if (parama.aGH == 2)
          {
            smu.b((BaseActivity)this.mContext, new smu.a(this.b.uin, this.b.name, this.b.summary), 1, getShareUrl());
            return;
          }
          if (parama.aGH == 17)
          {
            smu.a((BaseActivity)this.mContext, new smu.a(this.b.uin, this.b.name, this.b.summary), 1, getShareUrl());
            return;
          }
          if (parama.aGH == 19)
          {
            smu.a((BaseActivity)this.mContext, new smu.a(this.b.uin, this.b.name, this.b.summary), 1, getShareUrl(), 9);
            return;
          }
          if (parama.aGH == 18)
          {
            smu.a((BaseActivity)this.mContext, new smu.a(this.b.uin, this.b.name, this.b.summary), 1, getShareUrl(), 10);
            return;
          }
          if (parama.aGH == 22)
          {
            lp(parama.url);
            return;
          }
          if (parama.aGH != 23) {
            break;
          }
        } while (TextUtils.isEmpty(parama.content));
        Object localObject = new jts();
        ((jts)localObject).lo(parama.content);
        a((jts)localObject);
        return;
        if ((parama.aGH != 1) && (parama.aGH != 3) && (parama.aGH != 9) && (parama.aGH != 10) && (parama.aGH != 12) && (parama.aGH != 13) && (parama.aGH != 14) && (parama.aGH != 15) && (parama.aGH != 16) && (parama.aGH != 21)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(this.TAG, 2, "handleItemClickEvent->event forbidden or not supported!");
      return;
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "handleItemClickEvent->event unhandled!");
  }
  
  public void lp(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Intent localIntent;
    do
    {
      return;
      localIntent = new Intent(this.mContext, PublicAccountBrowser.class);
    } while ((this.mApp == null) || (this.b == null) || (TextUtils.isEmpty(this.mApp.getAccount())) || (TextUtils.isEmpty(this.b.uin)));
    paramString = paramString.replace("${puin}", this.b.uin).replace("${uin}", this.mApp.getAccount());
    localIntent.putExtra("uin", this.mApp.getCurrentAccountUin());
    localIntent.putExtra("url", paramString);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "jumpWebView->url:" + paramString);
    }
    localIntent.putExtra("puin", this.b.uin);
    localIntent.putExtra("big_brother_source_key", ocp.fq(this.b.uin));
    paramString = this.b.name;
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("source_name", paramString);
    }
    this.mContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jtw
 * JD-Core Version:    0.7.0.1
 */