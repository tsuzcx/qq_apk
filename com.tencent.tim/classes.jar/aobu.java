import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.teamwork.SharePolicyInfo;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.TeamWorkShareActionSheetBuilder.1;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.mobileqq.widget.share.ShareActionSheet.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;

public class aobu
  extends ShareActionSheetBuilder
  implements ShareActionSheet.a
{
  private ImageView DR;
  private TextView ZM;
  private TextView ZN;
  private TextView ZO;
  private SharePolicyInfo a;
  private QQBrowserActivity c;
  private TeamWorkFileImportInfo f;
  private RelativeLayout md;
  private WebView webView;
  
  public aobu(Context paramContext)
  {
    super(paramContext, false, 2);
    setBottomBarInterface(this);
    if ((paramContext instanceof QQBrowserActivity))
    {
      this.c = ((QQBrowserActivity)paramContext);
      this.webView = ((QQBrowserActivity)paramContext).b();
    }
    paramContext = new Intent();
    paramContext.putExtra("forward_type", -3);
    paramContext.putExtra("key_share_data_line_support_type", 1);
    setIntentForStartForwardRecentActivity(paramContext);
    setRowVisibility(0, 0, 0);
  }
  
  private View cv()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.c != null)
    {
      localObject1 = localObject2;
      if (this.c.c() != null)
      {
        this.a = this.c.c().b().a();
        localObject1 = (RelativeLayout)LayoutInflater.from(this.c).inflate(2131563180, null);
        if ((this.a == null) || (!this.a.isCreator)) {
          break label413;
        }
        ((RelativeLayout)localObject1).setVisibility(0);
        this.ZM = ((TextView)((RelativeLayout)localObject1).findViewById(2131380569));
        this.ZM.setOnClickListener(new aobv(this));
        if (this.a.taskType != 1) {
          break label304;
        }
        this.ZM.setText(this.c.getText(2131690646));
        this.md = ((RelativeLayout)((RelativeLayout)localObject1).findViewById(2131377619));
        this.ZM = ((TextView)((RelativeLayout)localObject1).findViewById(2131380569));
        this.ZN = ((TextView)((RelativeLayout)localObject1).findViewById(2131380567));
        this.ZN.setTextColor(Color.parseColor("#777777"));
        if (this.a.taskType == 2) {
          this.ZN.setTextColor(Color.parseColor("#fe6c6c"));
        }
        this.ZN.setText(this.a.cjd);
        this.ZO = ((TextView)((RelativeLayout)localObject1).findViewById(2131380568));
        this.DR = ((ImageView)((RelativeLayout)localObject1).findViewById(2131369667));
        if (2 != this.a.taskType) {
          break label359;
        }
        if (!TextUtils.isEmpty(this.a.cje)) {
          break label334;
        }
        this.ZO.setVisibility(8);
      }
    }
    label413:
    for (;;)
    {
      ((RelativeLayout)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, rpq.dip2px(this.c, 70.0F)));
      return localObject1;
      label304:
      if (this.a.taskType != 2) {
        break;
      }
      this.ZM.setText(this.c.getText(2131689935));
      break;
      label334:
      this.ZO.setVisibility(0);
      this.ZO.setText(this.a.cje);
      continue;
      label359:
      if (TextUtils.isEmpty(this.a.cjh))
      {
        this.ZO.setVisibility(8);
      }
      else
      {
        this.ZO.setVisibility(0);
        gb(this.a.cjh, this.a.dNJ);
        continue;
        ((RelativeLayout)localObject1).setVisibility(8);
      }
    }
  }
  
  public View cw()
  {
    return cv();
  }
  
  public void gb(String paramString, int paramInt)
  {
    String str = this.a.cji;
    if (paramInt == 0)
    {
      this.ZO.setText(this.c.getString(2131720902));
      return;
    }
    this.md.post(new TeamWorkShareActionSheetBuilder.1(this, paramString, str));
  }
  
  public void s(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    this.f = paramTeamWorkFileImportInfo;
  }
  
  public void setItemClickListenerV2(ShareActionSheet.OnItemClickListener paramOnItemClickListener)
  {
    super.setItemClickListenerV2(new aobu.a(this.c, this.webView, this.f, paramOnItemClickListener));
  }
  
  static class a
    implements ShareActionSheet.OnItemClickListener
  {
    private WeakReference<WebView> bs;
    private WeakReference<QQBrowserActivity> cH;
    private TeamWorkFileImportInfo jdField_f_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo;
    private ShareActionSheet.OnItemClickListener jdField_f_of_type_ComTencentMobileqqWidgetShareShareActionSheet$OnItemClickListener;
    
    a(QQBrowserActivity paramQQBrowserActivity, WebView paramWebView, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, ShareActionSheet.OnItemClickListener paramOnItemClickListener)
    {
      this.cH = new WeakReference(paramQQBrowserActivity);
      this.bs = new WeakReference(paramWebView);
      this.jdField_f_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = paramTeamWorkFileImportInfo;
      this.jdField_f_of_type_ComTencentMobileqqWidgetShareShareActionSheet$OnItemClickListener = paramOnItemClickListener;
    }
    
    public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
    {
      QLog.w("TeamWorkShareActionSheetBuilder", 1, "inner on item click");
      if (this.jdField_f_of_type_ComTencentMobileqqWidgetShareShareActionSheet$OnItemClickListener != null) {
        this.jdField_f_of_type_ComTencentMobileqqWidgetShareShareActionSheet$OnItemClickListener.onItemClick(paramActionSheetItem, null);
      }
      if (this.jdField_f_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo == null) {}
      do
      {
        return;
        QLog.w("TeamWorkShareActionSheetBuilder", 1, "info exist");
      } while (!this.jdField_f_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.azu());
      QLog.w("TeamWorkShareActionSheetBuilder", 1, "from online preview");
      int i = paramActionSheetItem.action;
      if ((i == 1) || (i == 2) || (i == 9) || (i == 10))
      {
        paramActionSheetItem = (WebView)this.bs.get();
        if (paramActionSheetItem == null) {
          break label216;
        }
      }
      label216:
      for (paramActionSheetItem = paramActionSheetItem.getUrl();; paramActionSheetItem = "")
      {
        aobw.a(this.jdField_f_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo, paramActionSheetItem, "0X8009F34");
        paramActionSheetItem = (QQBrowserActivity)this.cH.get();
        if (paramActionSheetItem == null) {
          break;
        }
        if (i == 1)
        {
          aobw.s(paramActionSheetItem.getIntent(), "0X800A16F");
          return;
        }
        if ((i == 2) || (i == 9) || (i == 10) || (i == 3) || (i == 12))
        {
          aobw.s(paramActionSheetItem.getIntent(), "0X800A16E");
          return;
        }
        if (i == 6)
        {
          aobw.s(paramActionSheetItem.getIntent(), "0X800A170");
          return;
        }
        if (i != 5) {
          break;
        }
        aobw.s(paramActionSheetItem.getIntent(), "0X800A171");
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aobu
 * JD-Core Version:    0.7.0.1
 */