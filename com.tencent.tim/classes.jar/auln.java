import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.teamwork.SharePolicyInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.a;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.b;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.c;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tim.teamwork.TeamWorkFileImportInfo;
import com.tencent.tim.teamwork.TeamWorkShareActionSheetBuilder.1;
import com.tencent.tim.teamwork.TeamWorkShareActionSheetBuilder.4;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class auln
  extends ShareActionSheetBuilder
{
  private ImageView DR;
  private TextView ZM;
  private TextView ZN;
  private TextView ZO;
  private aqzs jdField_a_of_type_Aqzs;
  private aunj jdField_a_of_type_Aunj;
  private SharePolicyInfo jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo;
  private Context aa;
  private TeamWorkFileImportInfo e;
  private RelativeLayout md;
  private WebView webView;
  
  private void iS(View paramView)
  {
    if ((this.jdField_a_of_type_Aunj == null) || (!this.jdField_a_of_type_Aunj.isShowInfo()))
    {
      paramView.findViewById(2131361830).setVisibility(8);
      return;
    }
    paramView = (LinearLayout)paramView.findViewById(2131361830);
    URLImageView localURLImageView = (URLImageView)paramView.findViewById(2131369644);
    TextView localTextView1 = (TextView)paramView.findViewById(2131380976);
    TextView localTextView2 = (TextView)paramView.findViewById(2131380945);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Aunj.getIcon()))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLImageView.setImageDrawable(URLDrawable.getDrawable(this.jdField_a_of_type_Aunj.getIcon(), localURLDrawableOptions));
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Aunj.getTitle())) {
      localTextView1.setText(this.jdField_a_of_type_Aunj.getTitle());
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Aunj.getDesc())) {
      localTextView2.setText(this.jdField_a_of_type_Aunj.getDesc());
    }
    paramView.setVisibility(0);
  }
  
  private void iT(View paramView)
  {
    if ((this.jdField_a_of_type_Aqzs != null) && (this.jdField_a_of_type_Aqzs.c() != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo = this.jdField_a_of_type_Aqzs.c().b().a();
      paramView = (RelativeLayout)paramView.findViewById(2131363112);
      if ((this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.isCreator)) {
        break label376;
      }
      paramView.setVisibility(0);
      this.ZM = ((TextView)paramView.findViewById(2131380569));
      this.ZM.setOnClickListener(new aulo(this));
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.taskType != 1) {
        break label273;
      }
      this.ZM.setText(this.aa.getText(2131690646));
    }
    for (;;)
    {
      this.md = ((RelativeLayout)paramView.findViewById(2131377619));
      this.ZM = ((TextView)paramView.findViewById(2131380569));
      this.ZN = ((TextView)paramView.findViewById(2131380567));
      this.ZN.setTextColor(Color.parseColor("#000000"));
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.taskType == 2) {
        this.ZN.setTextColor(Color.parseColor("#fe6c6c"));
      }
      this.ZN.setText(this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.cjd);
      this.ZO = ((TextView)paramView.findViewById(2131380568));
      this.DR = ((ImageView)paramView.findViewById(2131369667));
      if (2 != this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.taskType) {
        break label326;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.cje)) {
        break;
      }
      this.ZO.setVisibility(8);
      return;
      label273:
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.taskType == 2) {
        this.ZM.setText(this.aa.getText(2131689935));
      }
    }
    this.ZO.setVisibility(0);
    this.ZO.setText(this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.cje);
    return;
    label326:
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.cjh))
    {
      this.ZO.setVisibility(8);
      return;
    }
    this.ZO.setVisibility(0);
    gb(this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.cjh, this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.dNJ);
    return;
    label376:
    paramView.setVisibility(8);
  }
  
  public View L()
  {
    View localView = View.inflate(this.V, 2131563170, null);
    iT(localView);
    iS(localView);
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$c.B((RelativeLayout)localView.findViewById(2131362258));
    this.mTitleTv = ((TextView)localView.findViewById(2131362010));
    Object localObject2;
    Object localObject1;
    if (this.zO)
    {
      this.mTitleTv.setVisibility(0);
      if (this.ac != null) {
        this.mTitleTv.setText(this.ac);
      }
      this.c = ((ElasticHorScrView)localView.findViewById(2131377768));
      this.d = ((ElasticHorScrView)localView.findViewById(2131377769));
      localObject2 = a();
      if (localObject2.length <= 0) {
        break label392;
      }
      localObject1 = localObject2[0];
      label135:
      if (!((List)localObject1).isEmpty()) {
        break label955;
      }
    }
    label160:
    label944:
    label947:
    label950:
    label955:
    for (int j = 0;; j = 1)
    {
      if (localObject2.length > 1)
      {
        localObject2 = localObject2[1];
        if (!((List)localObject2).isEmpty()) {
          break label950;
        }
      }
      for (int k = 0;; k = 1)
      {
        Object localObject3 = new TextPaint();
        ((TextPaint)localObject3).setTextSize(this.V.getResources().getDimensionPixelSize(2131299551));
        Object localObject4 = new StaticLayout(G(q((List)localObject1), 5), (TextPaint)localObject3, this.dAd, Layout.Alignment.ALIGN_CENTER, 1.0F, this.dAf, true);
        StaticLayout localStaticLayout = new StaticLayout(G(q((List)localObject2), 5), (TextPaint)localObject3, this.dAd, Layout.Alignment.ALIGN_CENTER, 1.0F, this.dAf, true);
        localObject3 = localStaticLayout;
        if (((StaticLayout)localObject4).getHeight() >= localStaticLayout.getHeight()) {
          localObject3 = localObject4;
        }
        int m = this.V.getResources().getDimensionPixelOffset(2131296956);
        int i;
        if (j != 0)
        {
          this.n = ((GridView)localView.findViewById(2131368140));
          if (Build.VERSION.SDK_INT >= 9) {
            this.c.setOverScrollMode(2);
          }
          localObject4 = ((List)localObject1).iterator();
          i = 0;
          label352:
          if (((Iterator)localObject4).hasNext())
          {
            if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject4).next()).visibility != 0) {
              break label947;
            }
            i += 1;
          }
        }
        for (;;)
        {
          break label352;
          hideTitle();
          break;
          localObject1 = new ArrayList(0);
          break label135;
          localObject2 = new ArrayList(0);
          break label160;
          int n = this.dAc + getIconWidth() + this.dAc;
          this.n.setColumnWidth(n);
          this.n.setNumColumns(i);
          localObject4 = this.n.getLayoutParams();
          this.n.setPadding(this.dAg, this.n.getPaddingTop(), this.dAg, this.n.getPaddingBottom());
          ((ViewGroup.LayoutParams)localObject4).width = (n * i + this.dAg + this.dAg);
          this.bgd = ((ViewGroup.LayoutParams)localObject4).width;
          ((ViewGroup.LayoutParams)localObject4).height = (this.OC + this.dAe + ((StaticLayout)localObject3).getHeight() + m);
          this.n.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          this.n.setAdapter(new ShareActionSheetBuilder.a(this.V, (List)localObject1));
          this.n.setSelector(new ColorDrawable(0));
          this.n.setOnItemClickListener(this.j);
          if (k != 0)
          {
            this.o = ((GridView)localView.findViewById(2131368141));
            if (Build.VERSION.SDK_INT >= 9) {
              this.d.setOverScrollMode(2);
            }
            this.o.setSmoothScrollbarEnabled(false);
            localObject1 = ((List)localObject2).iterator();
            i = 0;
            if (((Iterator)localObject1).hasNext())
            {
              if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject1).next()).visibility != 0) {
                break label944;
              }
              i += 1;
            }
          }
          for (;;)
          {
            break;
            n = this.dAc + getIconWidth() + this.dAc;
            this.o.setColumnWidth(n);
            this.o.setNumColumns(i);
            localObject1 = this.o.getLayoutParams();
            this.o.setPadding(this.dAg, this.o.getPaddingTop(), this.dAg, this.o.getPaddingBottom());
            ((ViewGroup.LayoutParams)localObject1).width = (n * i + this.dAg + this.dAg);
            this.bgc = ((ViewGroup.LayoutParams)localObject1).width;
            ((ViewGroup.LayoutParams)localObject1).height = (this.OC + this.dAe + ((StaticLayout)localObject3).getHeight() + m);
            this.o.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.o.setNumColumns(i);
            this.o.setAdapter(new ShareActionSheetBuilder.a(this.V, (List)localObject2));
            this.o.setSelector(new ColorDrawable(0));
            this.o.setOnItemClickListener(this.j);
            localObject1 = (TextView)localView.findViewById(2131362002);
            ((TextView)localObject1).setText(2131721058);
            ((TextView)localObject1).setOnClickListener(new aulp(this));
            if (j == 0) {
              this.c.setVisibility(8);
            }
            if (k == 0) {
              this.d.setVisibility(8);
            }
            localView.post(new TeamWorkShareActionSheetBuilder.4(this));
            return localView;
          }
        }
      }
    }
  }
  
  public void gb(String paramString, int paramInt)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.cji;
    if (paramInt == 0)
    {
      this.ZO.setText(this.aa.getString(2131720902));
      return;
    }
    this.md.post(new TeamWorkShareActionSheetBuilder.1(this, paramString, str));
  }
  
  public void setItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    super.setItemClickListener(new auln.a(this.aa, this.webView, this.e, paramOnItemClickListener));
  }
  
  static class a
    implements AdapterView.OnItemClickListener
  {
    private WeakReference<WebView> bs;
    private WeakReference<Context> cH;
    private TeamWorkFileImportInfo e;
    private AdapterView.OnItemClickListener l;
    
    a(Context paramContext, WebView paramWebView, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, AdapterView.OnItemClickListener paramOnItemClickListener)
    {
      this.cH = new WeakReference(paramContext);
      this.bs = new WeakReference(paramWebView);
      this.e = paramTeamWorkFileImportInfo;
      this.l = paramOnItemClickListener;
    }
    
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      if (this.l != null) {
        this.l.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      }
      QLog.w("TeamWorkShareActionSheetBuilder", 1, "inner on item click");
      if (this.e == null) {}
      for (;;)
      {
        EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
        return;
        QLog.w("TeamWorkShareActionSheetBuilder", 1, "info exist");
        QLog.w("TeamWorkShareActionSheetBuilder", 1, "from online preview");
        Object localObject = paramView.getTag();
        if (localObject != null)
        {
          int i = ((ShareActionSheetBuilder.b)localObject).b.action;
          if ((i == 1) || (i == 2) || (i == 9) || (i == 10))
          {
            localObject = (WebView)this.bs.get();
            if (localObject != null) {
              ((WebView)localObject).getUrl();
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auln
 * JD-Core Version:    0.7.0.1
 */