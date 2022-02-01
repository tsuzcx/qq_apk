import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.FriendInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class ahum
  extends ausj
  implements AdapterView.c
{
  private List<FeedsItemData.FriendInfo> Ch;
  private ahum.a a;
  private aqdf d = new aqdf(this.mContext, abmt.getAppInterface());
  private int dbg;
  private aqrd g = new ahun(this);
  private String mAppid;
  private Context mContext;
  
  protected ahum(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  public ahum(Context paramContext, String paramString, int paramInt)
  {
    this(paramContext);
    this.dbg = paramInt;
    this.mAppid = paramString;
    initView();
    abmt.getAppInterface().addObserver(this.g);
    ((aqrb)abmt.getAppInterface().getBusinessHandler(71)).gr(this.mAppid, this.dbg);
  }
  
  private String getTimeString(long paramLong)
  {
    paramLong = System.currentTimeMillis() / 1000L - paramLong;
    if (paramLong < 60L) {
      return paramLong / 60L + acfp.m(2131711702);
    }
    if ((paramLong >= 60L) && (paramLong < 3600L)) {
      return paramLong / 60L + acfp.m(2131711705);
    }
    if ((paramLong >= 3600L) && (paramLong < paramLong / 86400L)) {
      return paramLong / 3600L + acfp.m(2131711703);
    }
    int i = (int)(paramLong / 86400L);
    if (i >= 30) {
      return i / 30 + acfp.m(2131711708);
    }
    if (i >= 7) {
      return i / 7 + acfp.m(2131711706);
    }
    return i + acfp.m(2131711707);
  }
  
  private void initView()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, wja.dp2px(500.0F, this.mContext.getResources()));
    RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
    Object localObject2 = new ImageView(this.mContext);
    ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_popView_card@2x.png"));
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    ((ImageView)localObject2).setId(2131367856);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, (int)(aqgz.getWidth() / 750L * 36L));
    ((RelativeLayout.LayoutParams)localObject1).addRule(10);
    localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(this.mContext);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout)localObject1).setBackgroundColor(-1);
    localLayoutParams1.addRule(3, ((ImageView)localObject2).getId());
    localObject2 = new TextView(this.mContext);
    ((TextView)localObject2).setText(acfp.m(2131711704));
    Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(9);
    ((RelativeLayout.LayoutParams)localObject3).setMargins(wja.dp2px(20.0F, this.mContext.getResources()), wja.dp2px(16.0F, this.mContext.getResources()), 0, 0);
    ((TextView)localObject2).setTextSize(18.0F);
    ((TextView)localObject2).setTextColor(-16777216);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    ((TextView)localObject2).setId(2131367858);
    localObject3 = new ListView(this.mContext);
    this.a = new ahum.a(this.mContext, this.Ch);
    ((ListView)localObject3).setAdapter(this.a);
    ((ListView)localObject3).setOnItemClickListener(this);
    ((ListView)localObject3).setBackgroundColor(-1);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams2.addRule(3, ((TextView)localObject2).getId());
    ((RelativeLayout)localObject1).addView((View)localObject3, localLayoutParams2);
    localRelativeLayout.addView((View)localObject1, localLayoutParams1);
    ((ListView)localObject3).setDividerHeight(0);
    ((ListView)localObject3).setSelector(this.mContext.getResources().getDrawable(2130851770));
    setActionContentView(localRelativeLayout, localLayoutParams);
  }
  
  public void dismiss()
  {
    super.dismiss();
    abmt.getAppInterface().removeObserver(this.g);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (acff)abmt.getAppInterface().getManager(51);
    paramView = (FeedsItemData.FriendInfo)this.Ch.get(paramInt);
    if (TextUtils.isEmpty(paramView.jumpUrl))
    {
      if (paramAdapterView.isFriend(paramView.uin)) {
        paramAdapterView = new ProfileActivity.AllInOne(paramView.uin, 1);
      }
      for (paramAdapterView.nickname = paramView.name;; paramAdapterView.nickname = paramView.name)
      {
        paramAdapterView.aOF = paramView.uin;
        paramAdapterView.bIX = 3000;
        paramAdapterView.bIZ = 2;
        paramAdapterView.bJa = 106;
        ProfileActivity.b(getContext(), paramAdapterView);
        return;
        paramAdapterView = new ProfileActivity.AllInOne(paramView.uin, 19);
      }
    }
    paramAdapterView = new Intent(this.mContext, QQBrowserActivity.class);
    paramAdapterView.putExtra("url", paramView.jumpUrl);
    this.mContext.startActivity(paramAdapterView);
  }
  
  class a
    extends BaseAdapter
  {
    public List<FeedsItemData.FriendInfo> Ci = new ArrayList();
    public Context mContext;
    
    public a(List<FeedsItemData.FriendInfo> paramList)
    {
      this.mContext = paramList;
      List localList;
      setData(localList);
    }
    
    public int getCount()
    {
      if (this.Ci == null) {
        return 0;
      }
      return this.Ci.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.Ci.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject2 = (FeedsItemData.FriendInfo)ahum.a(ahum.this).get(paramInt);
      RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
      CornerImageView localCornerImageView = new CornerImageView(this.mContext);
      localCornerImageView.setId(2131367857);
      Object localObject3 = ((FeedsItemData.FriendInfo)localObject2).uin;
      localCornerImageView.setRadius(wja.dp2px(50.0F, this.mContext.getResources()) / 2);
      Object localObject1 = ahum.a(ahum.this).b(1, (String)localObject3);
      paramView = (View)localObject1;
      if (localObject1 == null)
      {
        paramView = aqhu.G();
        ahum.a(ahum.this).i((String)localObject3, 1, false);
      }
      localCornerImageView.setImageBitmap(paramView);
      paramView = new RelativeLayout.LayoutParams(wja.dp2px(50.0F, this.mContext.getResources()), wja.dp2px(50.0F, this.mContext.getResources()));
      paramView.addRule(9);
      paramView.setMargins(wja.dp2px(20.0F, this.mContext.getResources()), wja.dp2px(10.0F, this.mContext.getResources()), 0, wja.dp2px(10.0F, this.mContext.getResources()));
      localObject1 = new RelativeLayout(this.mContext);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(15);
      ((RelativeLayout.LayoutParams)localObject3).addRule(1, localCornerImageView.getId());
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = wja.dp2px(8.0F, this.mContext.getResources());
      ((RelativeLayout.LayoutParams)localObject3).rightMargin = wja.dp2px(80.0F, this.mContext.getResources());
      Object localObject4 = new TextView(this.mContext);
      ((TextView)localObject4).setText(((FeedsItemData.FriendInfo)localObject2).name);
      ((TextView)localObject4).setTextSize(16.0F);
      ((TextView)localObject4).setTextColor(-16777216);
      ((TextView)localObject4).setMaxLines(1);
      ((TextView)localObject4).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject4).setId(2131372190);
      ((TextView)localObject4).setMaxWidth(wja.dp2px(110.0F, this.mContext.getResources()));
      ((RelativeLayout)localObject1).addView((View)localObject4);
      TextView localTextView = new TextView(this.mContext);
      localTextView.setTextSize(10.0F);
      localTextView.setTextColor(-2145246686);
      if (((FeedsItemData.FriendInfo)localObject2).loginTime < 0L)
      {
        localTextView.setVisibility(4);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(1, ((TextView)localObject4).getId());
        localLayoutParams.addRule(8, ((TextView)localObject4).getId());
        localLayoutParams.leftMargin = wja.dp2px(4.0F, this.mContext.getResources());
        localLayoutParams.bottomMargin = wja.dp2px(2.0F, this.mContext.getResources());
        ((RelativeLayout)localObject1).addView(localTextView, localLayoutParams);
        localTextView = new TextView(this.mContext);
        localTextView.setTextSize(10.0F);
        localTextView.setTextColor(-6579301);
        if ((!TextUtils.isEmpty(((FeedsItemData.FriendInfo)localObject2).partition)) || (!TextUtils.isEmpty(((FeedsItemData.FriendInfo)localObject2).roleName))) {
          break label852;
        }
        localTextView.setText(acfp.m(2131711709));
      }
      for (;;)
      {
        localTextView.setBackgroundColor(1270796256);
        localTextView.setPadding(wja.dp2px(2.0F, this.mContext.getResources()), wja.dp2px(2.0F, this.mContext.getResources()), wja.dp2px(2.0F, this.mContext.getResources()), wja.dp2px(2.0F, this.mContext.getResources()));
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(3, ((TextView)localObject4).getId());
        ((RelativeLayout.LayoutParams)localObject2).topMargin = wja.dp2px(4.0F, this.mContext.getResources());
        ((RelativeLayout)localObject1).addView(localTextView, (ViewGroup.LayoutParams)localObject2);
        localObject2 = new TextView(this.mContext);
        ((TextView)localObject2).setText(acfp.m(2131711710));
        ((TextView)localObject2).setTextColor(-1);
        ((TextView)localObject2).setTextSize(16.0F);
        ((TextView)localObject2).setGravity(17);
        ((TextView)localObject2).setBackgroundDrawable(ahtz.a(new ColorDrawable(-16776961), new ColorDrawable(-16776961), "https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big@2x.png", "https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big_click@2x.png"));
        localObject4 = new RelativeLayout.LayoutParams(wja.dp2px(70.0F, this.mContext.getResources()), wja.dp2px(40.0F, this.mContext.getResources()));
        ((RelativeLayout.LayoutParams)localObject4).addRule(11);
        ((RelativeLayout.LayoutParams)localObject4).addRule(15);
        ((RelativeLayout.LayoutParams)localObject4).rightMargin = wja.dp2px(20.0F, this.mContext.getResources());
        localRelativeLayout.addView(localCornerImageView, paramView);
        localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
        localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject4);
        EventCollector.getInstance().onListGetView(paramInt, localRelativeLayout, paramViewGroup, getItemId(paramInt));
        return localRelativeLayout;
        localTextView.setText(ahum.a(ahum.this, ((FeedsItemData.FriendInfo)localObject2).loginTime));
        break;
        label852:
        localTextView.setText(((FeedsItemData.FriendInfo)localObject2).partition + " " + ((FeedsItemData.FriendInfo)localObject2).roleName);
      }
    }
    
    public void setData(List<FeedsItemData.FriendInfo> paramList)
    {
      this.Ci = paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahum
 * JD-Core Version:    0.7.0.1
 */