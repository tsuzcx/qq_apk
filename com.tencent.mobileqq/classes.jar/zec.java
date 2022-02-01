import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLive;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLive.RoomIcon;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLiveGoods;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

public class zec
  extends RecyclerView.ViewHolder
{
  int jdField_a_of_type_Int = 1;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  RoundImageView jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  ImageView jdField_d_of_type_AndroidWidgetImageView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  ImageView jdField_e_of_type_AndroidWidgetImageView;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  TextView f;
  
  public zec(zds paramzds, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131370087));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131370091));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView = ((RoundImageView)paramView.findViewById(2131370079));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setmRadius(ImmersiveUtils.a(8.0F), false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370098));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363022));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363701));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367654));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367655));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367653));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367656));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367657));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367658));
    this.jdField_d_of_type_AndroidWidgetImageView.setColorFilter(1291845632);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367659));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370096));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367967));
    this.f = ((TextView)paramView.findViewById(2131371787));
  }
  
  private void a()
  {
    if (zds.a(this.jdField_a_of_type_Zds))
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setAlpha(0.7F);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-16777216);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.f.setTextColor(-6775116);
    }
  }
  
  private void a(CertifiedAccountMeta.StLive paramStLive)
  {
    paramStLive = paramStLive.roomIcon.get().iterator();
    CertifiedAccountMeta.StLive.RoomIcon localRoomIcon;
    do
    {
      if (!paramStLive.hasNext()) {
        break;
      }
      localRoomIcon = (CertifiedAccountMeta.StLive.RoomIcon)paramStLive.next();
    } while (!"1:1".equals(localRoomIcon.size.get()));
    for (paramStLive = localRoomIcon.url.get();; paramStLive = null)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView, paramStLive);
      return;
    }
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("RelativeFeedsAdapter", 1, "imageUrl got failed!");
    }
    String str;
    do
    {
      do
      {
        return;
      } while (paramImageView == null);
      str = (String)paramImageView.getTag();
    } while ((!TextUtils.isEmpty(str)) && (str.equals(paramString)));
    paramImageView.setImageDrawable(URLDrawable.getDrawable(paramString, zds.a(), zds.a()));
    paramImageView.setTag(paramString);
  }
  
  private void b(CertifiedAccountMeta.StLive paramStLive)
  {
    if (TextUtils.isEmpty(paramStLive.typeIcon.get())) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("人气" + paramStLive.viewer.get() + "");
      return;
      Object localObject = paramStLive.typeIcon.get();
      Drawable localDrawable = URLDrawableHelper.TRANSPARENT;
      localObject = VasApngUtil.getApngURLDrawable((String)localObject, new int[] { 2 }, localDrawable, null, null);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  private void c(CertifiedAccountMeta.StLive paramStLive)
  {
    List localList = paramStLive.goodsInfo.get();
    if (localList.isEmpty())
    {
      QLog.d("RelativeFeedsAdapter", 1, "current display has no goods message");
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    int i = 0;
    label47:
    String str;
    if (i < localList.size())
    {
      Object localObject = (CertifiedAccountMeta.StLiveGoods)localList.get(i);
      str = ((CertifiedAccountMeta.StLiveGoods)localObject).imgUrl.get();
      if (i != 0) {
        break label146;
      }
      a(this.jdField_b_of_type_AndroidWidgetImageView, str);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(((CertifiedAccountMeta.StLiveGoods)localObject).name.get());
      localObject = a(((CertifiedAccountMeta.StLiveGoods)localObject).curPrice.get());
      this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    for (;;)
    {
      i += 1;
      break label47;
      break;
      label146:
      if (i == 1)
      {
        a(this.jdField_d_of_type_AndroidWidgetImageView, str);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(paramStLive.totalGoods.get() + "\n好物");
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    }
  }
  
  public String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = "";
    BigDecimal localBigDecimal = new BigDecimal(paramInt);
    if (paramInt >= 10000000)
    {
      localBigDecimal = localBigDecimal.divide(new BigDecimal(1000000));
      str = "万";
    }
    for (;;)
    {
      return new BigDecimal(localBigDecimal.toPlainString()).setScale(2, 1).stripTrailingZeros().toPlainString() + str;
      if (paramInt >= 10000000000L)
      {
        localBigDecimal = localBigDecimal.divide(new BigDecimal(10000000000L));
        str = "亿";
      }
      else
      {
        localBigDecimal = localBigDecimal.divide(new BigDecimal(100));
      }
    }
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {}
    do
    {
      do
      {
        CertifiedAccountMeta.StLive localStLive;
        do
        {
          return;
          localStLive = paramStFeed.live;
        } while (localStLive == null);
        a(localStLive);
        a();
        this.jdField_e_of_type_AndroidWidgetTextView.setText(localStLive.roomTitle.get());
        this.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(localStLive.anchorIcon.get()));
        this.f.setText(localStLive.anchorName.get());
        b(localStLive);
        c(localStLive);
      } while ((paramStFeed.live == null) || (!paramStFeed.live.roomId.has()));
      if (zds.a(this.jdField_a_of_type_Zds) == 0)
      {
        MobileReportManager.getInstance().reportActionLive(paramStFeed.live.roomId.get() + "", "25", "qq_live", "tab_page", "subscribe", 101, 1, System.currentTimeMillis(), paramStFeed.live.roomId.get() + "");
        return;
      }
      if (zds.a(this.jdField_a_of_type_Zds) == 1)
      {
        MobileReportManager.getInstance().reportActionLive(paramStFeed.live.roomId.get() + "", "25", "qq_live", "find_page", "hot_push", 101, 1, System.currentTimeMillis(), paramStFeed.live.roomId.get() + "");
        return;
      }
    } while (zds.a(this.jdField_a_of_type_Zds) != 2);
    MobileReportManager.getInstance().reportActionLive(paramStFeed.live.roomId.get() + "", "25", "qq_live", "shopcart_page", "hot_push", 101, 1, System.currentTimeMillis(), paramStFeed.live.roomId.get() + "");
  }
  
  public void a(zec paramzec, CertifiedAccountMeta.StFeed paramStFeed)
  {
    String.valueOf(paramStFeed.poster.id.get());
    this.itemView.setOnClickListener(new zed(this, paramStFeed));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zec
 * JD-Core Version:    0.7.0.1
 */