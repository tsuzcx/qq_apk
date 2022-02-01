import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahcu
  implements View.OnClickListener
{
  final String TAG = "DocCollectFormBanner";
  private TextView Tf;
  private TextView Tg;
  private ObjectAnimator bJ;
  boolean cgc;
  private boolean cgd;
  private Activity context;
  TeamWorkFileImportInfo d;
  String docUrl;
  private boolean isShow;
  public View rootView;
  
  public ahcu(Activity paramActivity, ViewGroup paramViewGroup, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    this.context = paramActivity;
    ((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(2131561051, paramViewGroup, true);
    this.d = paramTeamWorkFileImportInfo;
    this.rootView = paramViewGroup.findViewById(2131364860);
    this.rootView.setVisibility(8);
    this.rootView.setOnClickListener(this);
    initUI();
  }
  
  private void initUI()
  {
    this.Tf = ((TextView)this.rootView.findViewById(2131365449));
    this.Tg = ((TextView)this.rootView.findViewById(2131365452));
    dmw();
  }
  
  public void Kk(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.isShow)
      {
        if (this.bJ != null) {
          this.bJ.cancel();
        }
        this.isShow = false;
        this.bJ = ObjectAnimator.ofFloat(this.rootView, "translationY", new float[] { this.rootView.getHeight() });
        this.bJ.setInterpolator(new AccelerateDecelerateInterpolator());
        this.bJ.addListener(new ahcv(this));
        this.bJ.setDuration(180L);
        this.bJ.start();
      }
      return;
    }
    this.isShow = false;
    this.rootView.setVisibility(8);
  }
  
  public void dmw()
  {
    this.cgd = false;
    this.Tf.setText(2131700300);
    this.Tg.setText(2131700301);
  }
  
  public void onClick(View paramView)
  {
    if (!aqiw.isNetSupport(BaseApplication.getContext())) {
      QQToast.a(this.context, acfp.m(2131705173), 0).show();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label115:
      Object localObject;
      if (this.cgd)
      {
        if ((!TextUtils.isEmpty(this.docUrl)) && (this.d != null))
        {
          if (this.cgc)
          {
            new StringBuilder(this.docUrl);
            if (this.docUrl.indexOf("?") > 0) {
              this.docUrl += "&converFrom=qqFile";
            }
          }
          else
          {
            if (!this.cgc) {
              break label204;
            }
            aodb.aN(null, "0X800ABAB");
          }
          for (;;)
          {
            localObject = new Bundle();
            ((Bundle)localObject).putString("url", this.docUrl);
            ((Bundle)localObject).putBoolean("temp_preview_from_qq", true);
            ((Bundle)localObject).putParcelable("key_team_work_file_import_info", this.d);
            TeamWorkDocEditBrowserActivity.a(this.context, (Bundle)localObject, false);
            break;
            this.docUrl += "?converFrom=qqFile";
            break label115;
            label204:
            aodb.aN(null, "0X800ABAC");
          }
        }
      }
      else
      {
        localObject = BaseApplicationImpl.sApplication.getRuntime();
        if ((localObject instanceof QQAppInterface))
        {
          localObject = (aoar)((QQAppInterface)localObject).getBusinessHandler(120);
          if ((localObject != null) && (this.d != null))
          {
            if (!((aoar)localObject).e(this.d))
            {
              this.d.dNR = 0;
              ((aoar)localObject).j(this.d);
            }
            aodb.aN(null, "0X800ABA6");
            aoag.a(this.context, this.d, null);
          }
        }
      }
    }
  }
  
  public void q(int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramString != null)
    {
      this.docUrl = paramString;
      this.cgc = paramBoolean;
    }
    this.cgd = true;
    StringBuilder localStringBuilder = new StringBuilder().append(paramInt).append(acfp.m(2131705170));
    if (paramBoolean) {}
    for (paramString = acfp.m(2131700302);; paramString = acfp.m(2131705178))
    {
      paramString = paramString;
      this.Tf.setText(paramString);
      if (!paramBoolean) {
        break;
      }
      this.Tg.setText(2131700299);
      return;
    }
    this.Tg.setText(2131705161);
  }
  
  public void show()
  {
    show(false);
  }
  
  public void show(boolean paramBoolean)
  {
    if (this.d != null)
    {
      if (!paramBoolean) {
        break label98;
      }
      if (!this.isShow)
      {
        if (this.bJ != null) {
          this.bJ.cancel();
        }
        this.isShow = true;
        this.rootView.setVisibility(0);
        this.bJ = ObjectAnimator.ofFloat(this.rootView, "translationY", new float[] { 0.0F });
        this.bJ.setDuration(180L);
        this.bJ.setInterpolator(new AccelerateDecelerateInterpolator());
        this.bJ.start();
      }
    }
    return;
    label98:
    this.isShow = true;
    this.rootView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahcu
 * JD-Core Version:    0.7.0.1
 */