import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.ecshopassit.EcshopWebActivity;
import com.tencent.biz.pubaccount.ecshopassit.RecentShopParcel;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.SwipListView;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class keg
  extends BaseAdapter
  implements View.OnClickListener, nzu.b
{
  DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  kea jdField_a_of_type_Kea;
  nzu jdField_a_of_type_Nzu;
  int aIj;
  int aIk;
  SwipListView c;
  View jt;
  Context mContext;
  List<RecentShopParcel> mDatas;
  LayoutInflater mInflater;
  
  public keg(Context paramContext, SwipListView paramSwipListView, kea paramkea, String paramString)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(this.mContext);
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    this.aIj = ((localDisplayMetrics.widthPixels - 8) / 3);
    this.aIk = ((localDisplayMetrics.widthPixels - 8) % 3);
    this.jdField_a_of_type_Nzu = new nzu();
    this.c = paramSwipListView;
    this.jdField_a_of_type_Kea = paramkea;
    paramContext = View.inflate(paramContext, 2131562088, null);
    this.jt = paramContext.findViewById(2131366432);
    paramContext.findViewById(2131363857).setOnClickListener(new keh(this, paramString));
    this.c.addFooterView(paramContext);
  }
  
  public void a(RecentShopParcel paramRecentShopParcel)
  {
    if ((paramRecentShopParcel == null) || (TextUtils.isEmpty(paramRecentShopParcel.puin))) {}
    do
    {
      return;
      if (paramRecentShopParcel.aIi != 1) {
        break;
      }
      paramRecentShopParcel = ((EcshopWebActivity)this.mContext).Yv;
    } while (TextUtils.isEmpty(paramRecentShopParcel));
    Object localObject = new Intent(this.mContext, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramRecentShopParcel);
    ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
    this.mContext.startActivity((Intent)localObject);
    try
    {
      this.jdField_a_of_type_Kea.a.a(134246437, null, null, null, null, ((EcshopWebActivity)this.mContext).rN, false);
      return;
    }
    catch (Exception paramRecentShopParcel)
    {
      return;
    }
    int i = paramRecentShopParcel.unReadNum;
    String str = paramRecentShopParcel.puin;
    Intent localIntent = new Intent(this.mContext, ChatActivity.class);
    localIntent.putExtra("uintype", 1008);
    localIntent.putExtra("uin", str);
    localIntent.putExtra("uinname", paramRecentShopParcel.nickName);
    localIntent.putExtra("start_time", System.currentTimeMillis());
    localIntent.putExtra("red_hot_count", i);
    localIntent.putExtra("jump_from", 1);
    boolean bool;
    if (i > 0)
    {
      bool = true;
      localIntent.putExtra("has_unread_msg", bool);
      paramRecentShopParcel.unReadNum = 0;
      if (this.jdField_a_of_type_Kea.dw.get(str) != null) {
        break label377;
      }
      i = 0;
      label242:
      if (i > 0)
      {
        if (i / 1000 <= 0) {
          break label401;
        }
        localObject = new BigDecimal(i / 1000.0F);
      }
    }
    label401:
    for (localObject = this.mContext.getResources().getString(2131696191) + ((BigDecimal)localObject).setScale(1, 4).floatValue() + "km";; localObject = this.mContext.getString(2131696191) + i + "m")
    {
      localIntent.putExtra("pub_account_type", "type_ecshop_account");
      localIntent.putExtra("ecshop_distance_tip", (String)localObject);
      this.mContext.startActivity(localIntent);
      anot.a(null, "P_CliOper", "Shop_lifeservice", "", "Shop_helper", "Clk_shopItem", 0, 0, str, "", paramRecentShopParcel.nickName, "");
      return;
      bool = false;
      break;
      label377:
      i = ((Integer)this.jdField_a_of_type_Kea.dw.get(str)).intValue();
      break label242;
    }
  }
  
  public boolean a(ImageView paramImageView)
  {
    if ((this.c == null) || (paramImageView == null)) {
      return false;
    }
    int i = ((Integer)paramImageView.getTag(2131375407)).intValue();
    int j = this.c.getFirstVisiblePosition();
    int k = this.c.getLastVisiblePosition();
    return (i >= j) && (i <= k);
  }
  
  public void bJ(List<RecentShopParcel> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.jt.setVisibility(8);
    }
    for (;;)
    {
      this.mDatas = paramList;
      notifyDataSetChanged();
      return;
      this.jt.setVisibility(0);
    }
  }
  
  public void destroy()
  {
    this.jdField_a_of_type_Nzu.destroy();
    this.c = null;
    if (this.mDatas != null)
    {
      this.mDatas.clear();
      this.mDatas = null;
    }
    this.jdField_a_of_type_Kea = null;
  }
  
  public int getCount()
  {
    if (this.mDatas == null) {
      return 0;
    }
    return this.mDatas.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.mDatas == null) {
      return null;
    }
    return (RecentShopParcel)this.mDatas.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    keg.a locala;
    Object localObject1;
    float f;
    if (paramView == null)
    {
      locala = new keg.a();
      paramView = this.mInflater.inflate(2131562091, null);
      locala.mIcon = ((ImageView)paramView.findViewById(2131368698));
      locala.g = new ImageView[] { (ImageView)paramView.findViewById(2131368963), (ImageView)paramView.findViewById(2131368964), (ImageView)paramView.findViewById(2131368965) };
      locala.e = ((SingleLineTextView)paramView.findViewById(2131372190));
      locala.f = ((SingleLineTextView)paramView.findViewById(2131371989));
      locala.a = ((DragTextView)paramView.findViewById(2131381284));
      locala.a.setDragViewType(0, paramView);
      locala.a.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      locala.bL = ((Button)paramView.findViewById(2131371285));
      locala.ju = paramView.findViewById(2131366181);
      localObject1 = this.mContext.getResources().getColorStateList(2131167393);
      locala.f.setExtendTextColor((ColorStateList)localObject1, 0);
      locala.f.setExtendTextSize(12.0F, 0);
      f = aqgz.getDesity();
      locala.f.setExtendTextPadding((int)(f * 5.0F), 2);
      paramView.setTag(locala);
      if ((this.jdField_a_of_type_Kea != null) && (this.jdField_a_of_type_Kea.aet))
      {
        paramView.findViewById(2131365990).setVisibility(0);
        localObject1 = new ColorStateList(new int[][] { new int[0] }, new int[] { -8947849 });
        paramView.findViewById(2131366181).setBackgroundResource(2130847971);
        locala.f.setExtendTextColor((ColorStateList)localObject1, 0);
        locala.e.setTextColor(Color.parseColor("#FF777777"));
        locala.f.setTextColor(Color.parseColor("#FF000000"));
      }
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = (RecentShopParcel)getItem(paramInt);
      if (localObject2 != null) {
        break;
      }
      localObject1 = null;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
      locala = (keg.a)paramView.getTag();
    }
    int i;
    label420:
    label606:
    int j;
    if (((RecentShopParcel)localObject2).rR > ((RecentShopParcel)localObject2).lastMsgTime)
    {
      i = 1;
      locala.uin = ((RecentShopParcel)localObject2).puin;
      if (((RecentShopParcel)localObject2).mAuthenIconId == 0) {
        break label1372;
      }
      localObject1 = this.mContext.getResources().getDrawable(((RecentShopParcel)localObject2).mAuthenIconId);
      locala.e.setCompoundDrawablePadding(wja.dp2px(6.0F, this.mContext.getResources()));
      ((Drawable)localObject1).setBounds(0, 0, wja.dp2px(15.0F, this.mContext.getResources()), wja.dp2px(15.0F, this.mContext.getResources()));
      locala.e.setCompoundDrawables(null, (Drawable)localObject1);
      label520:
      localObject1 = (String)this.jdField_a_of_type_Kea.dx.get(((RecentShopParcel)localObject2).puin);
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!this.jdField_a_of_type_Kea.isFriend((String)localObject1))) {
        break label1385;
      }
      localObject1 = ((RecentShopParcel)localObject2).nickName + "(" + this.jdField_a_of_type_Kea.getNickName((String)localObject1) + ")";
      locala.e.setText((CharSequence)localObject1);
      locala.e.setExtendText("", 1);
      if (TextUtils.isEmpty(((RecentShopParcel)localObject2).time)) {
        break label1395;
      }
      locala.f.setExtendText(((RecentShopParcel)localObject2).time, 0);
      label652:
      locala.f.setExtendText(" ", 2);
      if (((RecentShopParcel)localObject2).unReadNum <= 0) {
        break label1409;
      }
      j = 3;
      label675:
      aute.updateCustomNoteTxt(locala.a, j, ((RecentShopParcel)localObject2).unReadNum, 2130851404, 99, null);
      locala.a.setTag(2131375406, localObject2);
      localObject1 = this.jdField_a_of_type_Kea.q(((RecentShopParcel)localObject2).puin);
      if (localObject1 == null) {
        break label1415;
      }
      locala.mIcon.setImageBitmap((Bitmap)localObject1);
      label738:
      locala.mIcon.setOnClickListener(this);
      locala.mIcon.setTag(-1, Integer.valueOf(paramInt));
      locala.mIcon.setTag(2131375406, localObject2);
      if ((this.jdField_a_of_type_Kea.dw != null) && (!this.jdField_a_of_type_Kea.dw.isEmpty()) && (this.jdField_a_of_type_Kea.dw.get(((RecentShopParcel)localObject2).puin) != null)) {
        break label1434;
      }
      j = 0;
      label821:
      if (j <= 0) {
        break label1767;
      }
      if (j / 1000 <= 0) {
        break label1462;
      }
      localObject1 = new BigDecimal(j / 1000.0F);
      localObject1 = "[" + this.mContext.getResources().getString(2131696191) + ((BigDecimal)localObject1).setScale(1, 4).floatValue() + "km]";
    }
    for (;;)
    {
      label903:
      Object localObject3 = new aofk(String.valueOf(((RecentShopParcel)localObject2).msg).replaceFirst("^\\s+", ""), 3, 20);
      Object localObject4;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject4 = new SpannableString((CharSequence)localObject1);
        ((Spannable)localObject4).setSpan(new ForegroundColorSpan(Color.rgb(255, 132, 68)), 0, ((String)localObject1).length(), 33);
        localObject1 = new SpannableStringBuilder();
        ((SpannableStringBuilder)localObject1).append((CharSequence)localObject4);
        ((SpannableStringBuilder)localObject1).append((CharSequence)localObject3);
        locala.f.setText((CharSequence)localObject1);
        label1018:
        if (i == 0) {
          break label1522;
        }
        locala.f.setCompoundDrawablesWithIntrinsicBounds(2130839799, 0);
        label1035:
        locala.bL.setTag(2131375406, localObject2);
        locala.bL.setOnClickListener(this);
        f = wja.dp2px(65.0F, this.mContext.getResources());
        if ((!TextUtils.isEmpty(((RecentShopParcel)localObject2).YF)) && (i == 0)) {
          break label1535;
        }
        paramView.findViewById(2131369087).setVisibility(8);
        label1101:
        locala.ju.setTag(2131375406, localObject2);
        locala.ju.setOnClickListener(this);
        paramView.setTag(-3, Integer.valueOf((int)f));
        localObject1 = (LinearLayout.LayoutParams)locala.e.getLayoutParams();
        if (((RecentShopParcel)localObject2).aIi != 1) {
          break label1717;
        }
        locala.f.setExtendText("", 0);
        locala.mIcon.setOnClickListener(this);
        localObject3 = (ImageButton)paramView.findViewById(2131363824);
        ((ImageButton)localObject3).setVisibility(0);
        ((ImageButton)localObject3).setTag(2131375406, localObject2);
        ((ImageButton)localObject3).setOnClickListener(this);
        localObject3 = ((EcshopWebActivity)this.mContext).Yu;
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject2 = (URLImageView)paramView.findViewById(2131362129);
          localObject4 = this.mContext.getResources().getDrawable(2130839767);
        }
      }
      label1318:
      label1372:
      label1385:
      label1522:
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject4);
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject4);
        localObject3 = URLDrawable.getDrawable((String)localObject3, localURLDrawableOptions);
        if (localObject3 != null)
        {
          if (((URLDrawable)localObject3).getStatus() == 2) {
            ((URLDrawable)localObject3).restartDownload();
          }
          ((URLImageView)localObject2).setImageDrawable((Drawable)localObject3);
          ((URLImageView)localObject2).setVisibility(0);
        }
      }
      catch (Exception localException)
      {
        label1395:
        label1535:
        break label1318;
      }
      for (((LinearLayout.LayoutParams)localObject1).rightMargin = wja.dp2px(6.0F, this.mContext.getResources());; ((LinearLayout.LayoutParams)localObject1).rightMargin = wja.dp2px(45.0F, this.mContext.getResources()))
      {
        locala.e.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramView.setOnClickListener(this);
        paramView.setTag(-1, Integer.valueOf(paramInt));
        localObject1 = paramView;
        break;
        i = 0;
        break label420;
        locala.e.setCompoundDrawables(null, null);
        break label520;
        localObject1 = ((RecentShopParcel)localObject2).nickName;
        break label606;
        locala.f.setExtendText("", 0);
        break label652;
        label1409:
        j = 0;
        break label675;
        label1415:
        this.jdField_a_of_type_Kea.aF(this.mContext, ((RecentShopParcel)localObject2).puin);
        break label738;
        label1434:
        j = ((Integer)this.jdField_a_of_type_Kea.dw.get(((RecentShopParcel)localObject2).puin)).intValue();
        break label821;
        label1462:
        localObject1 = "[" + this.mContext.getResources().getString(2131696191) + j + "m]";
        break label903;
        locala.f.setText((CharSequence)localObject3);
        break label1018;
        locala.f.setCompoundDrawablesWithIntrinsicBounds(0, 0);
        break label1035;
        localObject1 = new ArrayList(Arrays.asList(((RecentShopParcel)localObject2).YF.split(",")));
        i = 0;
        while (i < 3)
        {
          locala.g[i].setTag(2131375407, Integer.valueOf(paramInt));
          localObject3 = locala.g[i].getLayoutParams();
          j = this.aIj;
          ((ViewGroup.LayoutParams)localObject3).width = j;
          ((ViewGroup.LayoutParams)localObject3).height = j;
          if (i == 2) {
            ((ViewGroup.LayoutParams)localObject3).width += this.aIk;
          }
          locala.g[i].setLayoutParams((ViewGroup.LayoutParams)localObject3);
          this.jdField_a_of_type_Nzu.a(obs.a((String)((List)localObject1).get(i), 1), locala.g[i], ((ViewGroup.LayoutParams)localObject3).width, ((ViewGroup.LayoutParams)localObject3).height, this);
          i += 1;
        }
        paramView.findViewById(2131369087).setVisibility(0);
        break label1101;
        label1717:
        paramView.findViewById(2131363824).setVisibility(8);
        paramView.findViewById(2131362129).setVisibility(8);
      }
      label1767:
      localObject1 = "";
    }
  }
  
  public void lX(String paramString)
  {
    if ((this.c == null) || (TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_Kea == null)) {
      return;
    }
    int i = this.c.getFirstVisiblePosition();
    int j = this.c.getLastVisiblePosition();
    label38:
    Object localObject;
    if (i <= j)
    {
      localObject = this.c.getChildAt(i);
      if (localObject != null) {
        break label65;
      }
    }
    for (;;)
    {
      i += 1;
      break label38;
      break;
      label65:
      localObject = (keg.a)((View)localObject).getTag();
      if ((localObject != null) && (paramString.equals(((keg.a)localObject).uin)))
      {
        Bitmap localBitmap = this.jdField_a_of_type_Kea.q(paramString);
        if (localBitmap != null) {
          ((keg.a)localObject).mIcon.setImageBitmap(localBitmap);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    RecentShopParcel localRecentShopParcel = (RecentShopParcel)paramView.getTag(2131375406);
    if (i == 2131366181) {
      a(localRecentShopParcel);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent;
      if ((i == 2131371285) || (i == 2131363824))
      {
        i = localRecentShopParcel.unReadNum;
        this.mDatas.remove(localRecentShopParcel);
        notifyDataSetChanged();
        if (this.mDatas.isEmpty()) {
          this.jt.setVisibility(0);
        }
        localIntent = new Intent("action_shop_set_read");
        localIntent.putExtra("uin", localRecentShopParcel.puin);
        localIntent.putExtra("needDelete", true);
        localIntent.putExtra("unReadNum", i);
        this.mContext.sendBroadcast(localIntent);
      }
      else if (i == 2131368698)
      {
        localIntent = new Intent(this.mContext, AccountDetailActivity.class);
        localIntent.putExtra("uin", localRecentShopParcel.puin);
        localIntent.putExtra("report_src_param_type", "");
        localIntent.putExtra("report_src_param_name", "");
        localIntent.setFlags(67108864);
        this.mContext.startActivity(localIntent);
        anot.a(null, "P_CliOper", "Shop_lifeservice", "", "Shop_helperhead", "Clk_shopItemhead", 0, 0, localRecentShopParcel.puin, "", localRecentShopParcel.nickName, "");
      }
    }
  }
  
  public void setDragHost(DragFrameLayout paramDragFrameLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = paramDragFrameLayout;
  }
  
  class a
  {
    DragTextView jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView;
    Button bL;
    SingleLineTextView e;
    SingleLineTextView f;
    ImageView[] g;
    View ju;
    ImageView mIcon;
    String uin;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     keg
 * JD-Core Version:    0.7.0.1
 */