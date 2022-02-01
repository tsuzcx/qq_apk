import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.now.SmallVideoFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class akhv
  implements akid.a, View.OnClickListener
{
  protected NearbyPeopleCard a;
  protected QQAppInterface mApp;
  protected Context mContext;
  protected Map<String, akjj> mf = new HashMap();
  protected Map<String, akjj> mg = new HashMap();
  protected Map<String, akjj> mh = new HashMap();
  protected boolean xv;
  
  public akhv(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.mContext = paramContext;
    this.mApp = paramQQAppInterface;
  }
  
  private void c(akhv.a parama)
  {
    akjj localakjj = parama.b;
    aqha.a(this.mContext, 230).setTitle(acfp.m(2131703133)).setNegativeButton(2131721058, new akib(this)).setPositiveButton(2131692505, new akhz(this, localakjj, parama)).show();
  }
  
  private void g(akhv.a parama)
  {
    if (!aqiw.isNetworkAvailable(this.mContext))
    {
      QQToast.a(this.mContext, 1, acfp.m(2131703130), 0).show();
      return;
    }
    boolean bool = parama.b.isLiked;
    String str = b(parama);
    Object localObject = (akio)this.mApp.getManager(263);
    if (!bool)
    {
      ((akio)localObject).Np(str);
      ajxs localajxs = new ajxs().h("data_card");
      if (!bool) {
        break label157;
      }
      localObject = "feed_unlike";
      label89:
      localObject = localajxs.i((String)localObject).d("2").a(a(parama)).b(str).c(String.valueOf(a(parama)));
      if (!this.xv) {
        break label163;
      }
    }
    label157:
    label163:
    for (parama = "1";; parama = "2")
    {
      ((ajxs)localObject).e(parama).report(this.mApp);
      return;
      ((akio)localObject).Nq(str);
      break;
      localObject = "feed_like";
      break label89;
    }
  }
  
  public abstract int a(akhv.a parama);
  
  public abstract akhv.a a();
  
  public View a(akjj paramakjj, Context paramContext, View paramView)
  {
    Object localObject = (LinearLayout)paramView;
    paramView = (View)localObject;
    akhv.a locala;
    if (localObject == null)
    {
      localObject = new LinearLayout(paramContext);
      ((LinearLayout)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      ((LinearLayout)localObject).setBackgroundColor(-1);
      ((LinearLayout)localObject).setOrientation(1);
      locala = a();
      if (locala == null) {
        paramakjj = null;
      }
    }
    do
    {
      return paramakjj;
      locala.context = ((Activity)paramContext);
      locala.convertView = ((View)localObject);
      paramView = LayoutInflater.from(paramContext).inflate(2131561486, (ViewGroup)localObject, false);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams1.topMargin = rpq.dip2px(paramContext, 20.0F);
      localLayoutParams1.leftMargin = rpq.dip2px(paramContext, 16.0F);
      localLayoutParams1.bottomMargin = rpq.dip2px(paramContext, 0.0F);
      localLayoutParams1.rightMargin = rpq.dip2px(paramContext, 6.0F);
      locala.wS = ((ImageView)paramView.findViewById(2131369766));
      locala.nameView = ((TextView)paramView.findViewById(2131380814));
      locala.BI = ((ImageView)paramView.findViewById(2131369811));
      View localView1 = LayoutInflater.from(paramContext).inflate(2131561482, (ViewGroup)localObject, false);
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams2.leftMargin = rpq.dip2px(paramContext, 66.0F);
      localLayoutParams2.rightMargin = rpq.dip2px(paramContext, 6.0F);
      locala.Wb = ((TextView)localView1.findViewById(2131380792));
      locala.Wc = ((TextView)localView1.findViewById(2131380696));
      locala.Fo = localView1.findViewById(2131373540);
      locala.BJ = ((ImageView)localView1.findViewById(2131369840));
      locala.BJ.setOnClickListener(this);
      locala.Wd = ((TextView)localView1.findViewById(2131380849));
      locala.BK = ((ImageView)localView1.findViewById(2131369711));
      locala.BK.setOnClickListener(this);
      locala.vO = ((TextView)localView1.findViewById(2131380615));
      locala.s = ((ListView)localView1.findViewById(2131365057));
      locala.a = new akid();
      locala.a.a(this);
      locala.s.setAdapter(locala.a);
      locala.We = ((TextView)localView1.findViewById(2131382122));
      locala.Fp = localView1.findViewById(2131365055);
      locala.We.setOnClickListener(this);
      ((LinearLayout)localObject).addView(paramView, localLayoutParams1);
      View localView2 = a((ViewGroup)localObject, locala);
      if (localView2 != null)
      {
        localLayoutParams1 = (LinearLayout.LayoutParams)localView2.getLayoutParams();
        paramView = localLayoutParams1;
        if (localLayoutParams1 == null) {
          paramView = new LinearLayout.LayoutParams(-1, -2);
        }
        paramView.leftMargin = rpq.dip2px(paramContext, 66.0F);
        paramView.rightMargin = rpq.dip2px(paramContext, 6.0F);
        paramView.topMargin = rpq.dip2px(paramContext, -14.0F);
        ((LinearLayout)localObject).addView(localView2);
        localView2.setId(2131374937);
        locala.contentView = localView2;
        localView2.setOnClickListener(this);
      }
      ((LinearLayout)localObject).addView(localView1, localLayoutParams2);
      ((LinearLayout)localObject).setTag(locala);
      locala.BI.setOnClickListener(this);
      paramView = new View(this.mContext);
      paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, rpq.dip2px(this.mContext, 10.0F)));
      paramView.setBackgroundColor(-460807);
      ((LinearLayout)localObject).addView(paramView);
      paramView = (View)localObject;
      localObject = (akhv.a)paramView.getTag();
      ((akhv.a)localObject).b = paramakjj;
      a((akhv.a)localObject);
      if ((!TextUtils.isEmpty(paramakjj.name)) && (!paramakjj.name.endsWith(acfp.m(2131703134)))) {
        break;
      }
      ((akhv.a)localObject).Wb.setCompoundDrawablesWithIntrinsicBounds(2130846439, 0, 0, 0);
      ((akhv.a)localObject).Wb.setOnClickListener(null);
      ((akhv.a)localObject).Wb.setTextColor(Color.parseColor("#777777"));
      paramakjj = paramView;
    } while (this.mf.get(((akhv.a)localObject).b.feedId) != null);
    paramContext = new ajxs().h("data_card").i("feed_exp").a(a((akhv.a)localObject)).d("2").b(((akhv.a)localObject).b.feedId).c(String.valueOf(a((akhv.a)localObject)));
    if (this.xv) {}
    for (paramakjj = "1";; paramakjj = "2")
    {
      paramContext.e(paramakjj).report(this.mApp);
      this.mf.put(((akhv.a)localObject).b.feedId, ((akhv.a)localObject).b);
      return paramView;
      ((akhv.a)localObject).Wb.setCompoundDrawablesWithIntrinsicBounds(2130846441, 0, 0, 0);
      ((akhv.a)localObject).Wb.setTextColor(Color.parseColor("#576B95"));
      ((akhv.a)localObject).Wb.setOnClickListener(new akhw(this, paramContext, paramakjj, (akhv.a)localObject));
      break;
    }
  }
  
  public abstract View a(ViewGroup paramViewGroup, akhv.a parama);
  
  public String a(akhv.a parama)
  {
    return "";
  }
  
  public void a(akhv.a parama)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = rpq.dip2px(this.mContext, 40.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = rpq.dip2px(this.mContext, 40.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.mContext.getResources().getDrawable(2130840647);
    try
    {
      localObject = URLDrawable.getDrawable(parama.b.headUrl, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setTag(aqbn.e(rpq.dip2px(this.mContext, 40.0F), rpq.dip2px(this.mContext, 40.0F)));
      ((URLDrawable)localObject).setDecodeHandler(aqbn.b);
      parama.wS.setImageDrawable((Drawable)localObject);
      if (this.a != null) {
        parama.nameView.setText(this.a.nickname);
      }
      parama.contentView.setOnClickListener(this);
      h(parama);
      if (!TextUtils.isEmpty(parama.b.location))
      {
        parama.Wb.setVisibility(0);
        parama.Wb.setText(parama.b.location);
        localObject = new StringBuilder();
        if (!TextUtils.isEmpty(parama.b.bTx))
        {
          if (((StringBuilder)localObject).length() > 0) {
            ((StringBuilder)localObject).append(" · ");
          }
          ((StringBuilder)localObject).append(parama.b.bTx);
        }
        if (((StringBuilder)localObject).length() <= 0) {
          break label695;
        }
        parama.Wc.setText(((StringBuilder)localObject).toString());
        parama.Wc.setVisibility(0);
        if (!a(parama)) {
          break label730;
        }
        parama.Fo.setVisibility(0);
        if (!parama.b.isLiked) {
          break label707;
        }
        parama.BJ.setImageResource(2130846382);
        parama.Wd.setTextColor(-52924);
        parama.Wd.setText(String.valueOf(parama.b.likeNum));
        parama.BK.setVisibility(0);
        parama.vO.setText(String.valueOf(parama.b.commentNum));
        List localList = parama.b.DV;
        if ((localList == null) || (localList.size() <= 0)) {
          break label748;
        }
        parama.s.setVisibility(0);
        parama.a.setData(localList);
        parama.a.notifyDataSetChanged();
        if (this.mg.get(parama.b.feedId) == null)
        {
          ajxs localajxs = new ajxs().h("data_card").i("feed_com_exp").d("2").a(a(parama)).b(parama.b.feedId).c(String.valueOf(a(parama)));
          if (!this.xv) {
            break label742;
          }
          localObject = "1";
          localajxs.e((String)localObject).report(this.mApp);
          this.mg.put(parama.b.feedId, parama.b);
        }
        if ((localList == null) || (localList.size() <= 0) || (parama.b.commentNum <= localList.size())) {
          break label760;
        }
        parama.We.setVisibility(0);
        if ((parama.s.getVisibility() == 0) || (parama.We.getVisibility() == 0)) {
          break label772;
        }
        parama.Fp.setVisibility(8);
        parama.BI.setClickable(true);
        parama.BI.setAlpha(1.0F);
        parama.BJ.setClickable(true);
        parama.BK.setClickable(true);
        parama.BJ.setAlpha(1.0F);
        parama.Wd.setAlpha(1.0F);
        parama.BK.setAlpha(1.0F);
        parama.vO.setAlpha(1.0F);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        parama.wS.setImageDrawable(this.mContext.getResources().getDrawable(2130840647));
        QLog.i("BaseMomentItemBuilder", 1, "updateUI, holder.momentFeedInfo.headUrl=" + parama.b.headUrl);
        continue;
        parama.Wb.setVisibility(8);
        continue;
        label695:
        parama.Wc.setVisibility(8);
        continue;
        label707:
        parama.BJ.setImageResource(2130846400);
        parama.Wd.setTextColor(-4473925);
        continue;
        label730:
        parama.Fo.setVisibility(8);
        continue;
        label742:
        String str = "2";
        continue;
        label748:
        parama.s.setVisibility(8);
        continue;
        label760:
        parama.We.setVisibility(8);
        continue;
        label772:
        parama.Fp.setVisibility(0);
      }
    }
  }
  
  public boolean a(akhv.a parama)
  {
    return true;
  }
  
  public String b(akhv.a parama)
  {
    return parama.b.feedId;
  }
  
  public void b(akhv.a parama)
  {
    akjj localakjj = parama.b;
    ajxs localajxs = new ajxs().h("data_card").i("feed_more_clk").d("2").a(a(parama)).b(localakjj.feedId).c(String.valueOf(a(parama)));
    if (this.xv) {}
    for (Object localObject = "1";; localObject = "2")
    {
      localajxs.e((String)localObject).report(this.mApp);
      if (!TextUtils.equals(this.mApp.getCurrentAccountUin(), localakjj.uin)) {
        break;
      }
      localObject = ausj.b(this.mContext);
      ((ausj)localObject).addButton(2131692505, 1);
      ((ausj)localObject).addCancelButton(2131721058);
      ((ausj)localObject).a(new akhx(this, parama, localakjj, (ausj)localObject));
      ((ausj)localObject).show();
      return;
    }
    localObject = ausj.b(this.mContext);
    ((ausj)localObject).addButton(2131718050, 1);
    ((ausj)localObject).addCancelButton(2131721058);
    ((ausj)localObject).a(new akhy(this, parama, localakjj, (ausj)localObject));
    ((ausj)localObject).show();
  }
  
  public void cC(String paramString, boolean paramBoolean)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("raw_url", paramString);
      localIntent.putExtra("scroll_to_comment", paramBoolean);
      localIntent.putExtra("play_mode", "2");
      localIntent.putExtra("is_multi_progress_bar", true);
      localIntent.putExtra("_from", "3");
      localIntent.addFlags(268435456);
      localIntent.putExtra("public_fragment_window_feature", 1);
      PublicTransFragmentActivity.start(this.mContext, localIntent, SmallVideoFragment.class);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("BaseMomentItemBuilder", 2, "onItemClick exp:" + paramString.toString());
    }
  }
  
  public void d(akhv.a parama)
  {
    if (!aqiw.isNetworkAvailable(this.mContext))
    {
      QQToast.a(this.mContext, 1, acfp.m(2131703128), 0).show();
      return;
    }
    cC(parama.b.jumpUrl, true);
  }
  
  public void e(akhv.a parama)
  {
    String str = parama.b.feedId;
    ajxs localajxs = new ajxs().h("data_card").i("feed_clk").d("2").a(a(parama)).b(str).c(String.valueOf(a(parama)));
    if (this.xv) {}
    for (str = "1";; str = "2")
    {
      localajxs.e(str).report(this.mApp);
      if (aqiw.isNetworkAvailable(this.mContext)) {
        break;
      }
      QQToast.a(this.mContext, 1, acfp.m(2131703131), 0).show();
      return;
    }
    cC(parama.b.jumpUrl, false);
  }
  
  public void f(akhv.a parama)
  {
    akjk localakjk = (akjk)parama.b;
    Object localObject = localakjk.picUrl;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("feedId", localakjk.feedId);
      ((JSONObject)localObject).put("tinyId", "");
      ((JSONObject)localObject).put("uin", localakjk.uin);
      ((JSONObject)localObject).put("reason", acfp.m(2131703132));
      apmj.a(parama.context, 0, localArrayList, null, null, false, false, "5", 100, null, null, ((JSONObject)localObject).toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public abstract void h(akhv.a parama);
  
  public void hv(View paramView)
  {
    paramView = (akhv.a)akja.a(paramView, akhv.a.class);
    if (paramView == null) {
      return;
    }
    d(paramView);
  }
  
  public void onClick(View paramView)
  {
    akhv.a locala = (akhv.a)akja.a(paramView, akhv.a.class);
    if (locala == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131369711: 
        d(locala);
        break;
      case 2131369811: 
        b(locala);
        break;
      case 2131369840: 
        g(locala);
        break;
      case 2131382122: 
        ajxs localajxs = new ajxs().h("data_card").i("feed_com_clk").d("2").a(a(locala)).b(locala.b.feedId).c(String.valueOf(a(locala)));
        if (this.xv) {}
        for (String str = "1";; str = "2")
        {
          localajxs.e(str).report(this.mApp);
          break;
        }
      case 2131374937: 
        e(locala);
        break;
      case 2131369834: 
        f(locala);
      }
    }
  }
  
  public void setNearbyPeopleCard(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.a = paramNearbyPeopleCard;
    if (TextUtils.equals(this.mApp.getCurrentAccountUin(), paramNearbyPeopleCard.uin)) {
      this.xv = true;
    }
  }
  
  public class a
  {
    public ImageView BI;
    public ImageView BJ;
    public ImageView BK;
    public View Fo;
    public View Fp;
    public TextView Wb;
    public TextView Wc;
    public TextView Wd;
    public TextView We;
    public akid a;
    public akjj b;
    public View contentView;
    public Activity context;
    public View convertView;
    public TextView nameView;
    public ListView s;
    public TextView vO;
    public ImageView wS;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akhv
 * JD-Core Version:    0.7.0.1
 */