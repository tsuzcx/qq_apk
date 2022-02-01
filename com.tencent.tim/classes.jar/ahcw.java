import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.widget.DocCooperationBanner.2;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ahcw
  implements View.OnClickListener
{
  final String TAG = "DocCooperationBanner";
  private TextView Tf;
  private TextView Tg;
  private TextView Th;
  aeud.c a;
  aeud b;
  private ObjectAnimator bJ;
  private URLImageView bd;
  private URLImageView be;
  private URLImageView bf;
  private Activity context;
  TeamWorkFileImportInfo d;
  String docUrl;
  private boolean isShow;
  private RelativeLayout ku;
  private RelativeLayout kv;
  public View rootView;
  
  public ahcw(Activity paramActivity, ViewGroup paramViewGroup, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, aeud paramaeud)
  {
    this.context = paramActivity;
    ((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(2131561054, paramViewGroup, true);
    this.b = paramaeud;
    this.d = paramTeamWorkFileImportInfo;
    this.rootView = paramViewGroup.findViewById(2131365447);
    this.rootView.setVisibility(8);
    this.rootView.setOnClickListener(this);
    initUI();
  }
  
  private void bm(boolean paramBoolean, int paramInt)
  {
    int j = 1;
    Object localObject = aeue.a();
    int i;
    if (paramBoolean)
    {
      localObject = ((aeud)localObject).bBD;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        i = j;
        if (paramInt != 1)
        {
          if (paramInt != 3000) {
            break label80;
          }
          i = j;
        }
      }
    }
    for (;;)
    {
      anot.a(null, "dc00898", "", "", (String)localObject, (String)localObject, i, 0, "", "", "", "");
      return;
      localObject = ((aeud)localObject).bBF;
      break;
      label80:
      if (paramInt == 0) {
        i = 0;
      } else {
        i = 3;
      }
    }
  }
  
  private Drawable d(int paramInt, String paramString)
  {
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (paramInt == 0) {
        return aqdj.a((AppInterface)localObject, 1, paramString);
      }
      if (paramInt == 1) {
        return aqdj.a((AppInterface)localObject, 4, paramString);
      }
      if (paramInt == 3000) {
        return aqdj.a((AppInterface)localObject, 101, paramString);
      }
    }
    return null;
  }
  
  private void initUI()
  {
    this.ku = ((RelativeLayout)this.rootView.findViewById(2131369359));
    this.kv = ((RelativeLayout)this.rootView.findViewById(2131365451));
    this.Th = ((TextView)this.rootView.findViewById(2131365450));
    this.bd = ((URLImageView)this.rootView.findViewById(2131365443));
    this.be = ((URLImageView)this.rootView.findViewById(2131365444));
    this.bf = ((URLImageView)this.rootView.findViewById(2131365445));
    this.Tf = ((TextView)this.rootView.findViewById(2131365449));
    this.Tg = ((TextView)this.rootView.findViewById(2131365452));
    String str;
    if ((this.b != null) && (this.d != null))
    {
      localObject = this.b.a(this.d.fileName);
      this.a = ((aeud.c)localObject);
      if ((localObject != null) && (!TextUtils.isEmpty(((aeud.c)localObject).text)))
      {
        this.ku.setVisibility(0);
        this.kv.setVisibility(8);
        str = ((aeud.c)localObject).text;
        if ((this.d.peerType != 1) && (this.d.peerType != 3000)) {
          break label245;
        }
      }
    }
    label245:
    for (Object localObject = acfp.m(2131705181);; localObject = acfp.m(2131705166))
    {
      localObject = str.replace("$name", (CharSequence)localObject);
      this.Th.setText((CharSequence)localObject);
      return;
    }
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
        this.bJ.addListener(new ahcx(this));
        this.bJ.setDuration(180L);
        this.bJ.start();
      }
      return;
    }
    this.isShow = false;
    this.rootView.setVisibility(8);
  }
  
  public void a(String paramString1, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, boolean paramBoolean, String paramString2)
  {
    StringBuilder localStringBuilder;
    if ((!TextUtils.isEmpty(paramString1)) && (paramTeamWorkFileImportInfo != null))
    {
      new StringBuilder(paramString1);
      if (paramString1.indexOf("?") <= 0) {
        break label213;
      }
      paramString1 = paramString1 + "&adtag=s_qq_file_inviteedit";
      if (paramBoolean)
      {
        paramBoolean = aeue.a().lJ(paramTeamWorkFileImportInfo.fileName);
        localStringBuilder = new StringBuilder(acfp.m(2131705175));
        if ((paramTeamWorkFileImportInfo.peerType != 1) && (paramTeamWorkFileImportInfo.peerType != 3000)) {
          break label237;
        }
        localStringBuilder.append("群成员");
        label108:
        if (!paramBoolean) {
          break label256;
        }
        localStringBuilder.append("一起编辑");
      }
    }
    for (;;)
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 2, localStringBuilder.toString(), 1).show();
      ThreadManager.excute(new DocCooperationBanner.2(this, paramTeamWorkFileImportInfo, paramString1, paramBoolean, paramString2), 128, null, false);
      aodb.aN(null, "0X800A637");
      paramString2 = new Bundle();
      paramString2.putString("url", paramString1);
      paramString2.putBoolean("temp_preview_from_qq", true);
      paramString2.putParcelable("key_team_work_file_import_info", paramTeamWorkFileImportInfo);
      TeamWorkDocEditBrowserActivity.a(this.context, paramString2, false);
      return;
      label213:
      paramString1 = paramString1 + "?adtag=s_qq_file_inviteedit";
      break;
      label237:
      if (paramTeamWorkFileImportInfo.peerType != 0) {
        break label108;
      }
      localStringBuilder.append("好友");
      break label108;
      label256:
      localStringBuilder.append("一起查看");
    }
  }
  
  public void c(int paramInt, List<aeud.a> paramList, String paramString)
  {
    int i = 0;
    this.docUrl = paramString;
    this.ku.setVisibility(8);
    this.kv.setVisibility(0);
    boolean bool;
    Object localObject1;
    if (this.a != null)
    {
      bool = this.a.fk;
      if (paramInt != 1) {
        break label369;
      }
      this.be.setVisibility(8);
      this.bf.setVisibility(8);
      localObject1 = new StringBuilder().append(acfp.m(2131705164));
      if (!bool) {
        break label325;
      }
      paramString = acfp.m(2131705176);
      label94:
      paramString = paramString;
      if ((paramList == null) || (paramList.size() <= 0)) {
        break label335;
      }
      localObject1 = (aeud.a)paramList.get(0);
      paramString = ((aeud.a)localObject1).bBG + paramString;
      label152:
      this.Tf.setText(paramString);
      localObject1 = this.Tg;
      if (!bool) {
        break label359;
      }
    }
    label325:
    label335:
    label359:
    for (paramString = acfp.m(2131705179);; paramString = acfp.m(2131705169))
    {
      ((TextView)localObject1).setText(paramString);
      if (paramList == null) {
        return;
      }
      paramString = this.bd;
      localObject1 = this.be;
      URLImageView localURLImageView = this.bf;
      paramInt = i;
      while (paramInt < paramList.size())
      {
        Object localObject2 = ((aeud.a)paramList.get(paramInt)).bBH;
        if (paramInt < 3)
        {
          localObject2 = URLDrawable.getDrawable((String)localObject2, URLDrawable.URLDrawableOptions.obtain());
          i = wja.dp2px(24.0F, this.context.getResources());
          ((URLDrawable)localObject2).setTag(aqbn.d(i, i, i / 2));
          ((URLDrawable)localObject2).setDecodeHandler(aqbn.d);
          new URLImageView[] { paramString, localObject1, localURLImageView }[paramInt].setImageDrawable((Drawable)localObject2);
        }
        paramInt += 1;
      }
      bool = false;
      break;
      paramString = acfp.m(2131705183);
      break label94;
      paramString = "1人" + paramString;
      break label152;
    }
    label369:
    this.be.setVisibility(0);
    if (paramInt == 2)
    {
      this.bf.setVisibility(8);
      label391:
      localObject1 = new StringBuilder().append(paramInt).append(acfp.m(2131705177));
      if (!bool) {
        break label481;
      }
      paramString = acfp.m(2131705174);
      label425:
      paramString = paramString;
      this.Tf.setText(paramString);
      localObject1 = this.Tg;
      if (!bool) {
        break label491;
      }
    }
    label481:
    label491:
    for (paramString = acfp.m(2131705161);; paramString = acfp.m(2131705160))
    {
      ((TextView)localObject1).setText(paramString);
      break;
      this.bf.setVisibility(0);
      break label391;
      paramString = acfp.m(2131705163);
      break label425;
    }
  }
  
  public void cv(int paramInt, String paramString)
  {
    if (paramString != null) {
      this.docUrl = paramString;
    }
    boolean bool;
    if (this.a != null)
    {
      bool = this.a.fk;
      this.ku.setVisibility(8);
      this.kv.setVisibility(0);
      this.be.setVisibility(8);
      this.bf.setVisibility(8);
      if (paramInt <= 0) {
        break label176;
      }
      localObject = new StringBuilder().append(paramInt).append(acfp.m(2131705170));
      if (!bool) {
        break label156;
      }
      paramString = acfp.m(2131705178);
      label96:
      localObject = paramString;
      localTextView = this.Tg;
      if (!bool) {
        break label166;
      }
    }
    label156:
    label166:
    for (paramString = acfp.m(2131705162);; paramString = acfp.m(2131705171))
    {
      localTextView.setText(paramString);
      this.bd.setVisibility(8);
      paramString = (String)localObject;
      this.Tf.setText(paramString);
      return;
      bool = false;
      break;
      paramString = acfp.m(2131705172);
      break label96;
    }
    label176:
    Object localObject = acfp.m(2131705168);
    TextView localTextView = this.Tg;
    StringBuilder localStringBuilder = new StringBuilder().append(acfp.m(2131705167));
    if (bool) {}
    for (paramString = acfp.m(2131705182);; paramString = acfp.m(2131705165))
    {
      localTextView.setText(paramString + acfp.m(2131705180));
      this.bd.setVisibility(0);
      if (this.d != null)
      {
        paramString = d(this.d.peerType, this.d.peerUin);
        if (paramString != null) {
          this.bd.setImageDrawable(paramString);
        }
      }
      paramString = (String)localObject;
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    if (!aqiw.isNetSupport(BaseApplication.getContext())) {
      QQToast.a(this.context, acfp.m(2131705173), 0).show();
    }
    label201:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.ku.getVisibility() == 0)
      {
        Object localObject = BaseApplicationImpl.sApplication.getRuntime();
        if ((localObject instanceof QQAppInterface))
        {
          localObject = (aoar)((QQAppInterface)localObject).getBusinessHandler(120);
          if ((localObject != null) && (this.d != null) && (!((aoar)localObject).e(this.d)))
          {
            aodb.fy(this.d.traceId + "-" + this.d.dNQ);
            this.d.dNR = 0;
            ((aoar)localObject).j(this.d);
          }
        }
      }
      for (boolean bool = true;; bool = false)
      {
        if (this.d == null) {
          break label201;
        }
        bm(bool, this.d.peerType);
        break;
        if (this.kv.getVisibility() == 0) {
          a(this.docUrl, this.d, false, "");
        }
      }
    }
  }
  
  public void show()
  {
    show(false);
  }
  
  public void show(boolean paramBoolean)
  {
    if ((this.b != null) && (this.d != null))
    {
      if (!paramBoolean) {
        break label105;
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
    label105:
    this.isShow = true;
    this.rootView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahcw
 * JD-Core Version:    0.7.0.1
 */