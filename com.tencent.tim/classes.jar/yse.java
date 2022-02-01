import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class yse
  extends ysa
  implements View.OnClickListener
{
  public yse(Context paramContext, QQAppInterface paramQQAppInterface, ytd paramytd, ytv paramytv)
  {
    super(paramContext, paramQQAppInterface, paramytd, paramytv);
  }
  
  private void a(yse.a parama)
  {
    if (!ThemeUtil.isNowThemeIsNight(this.mApp, false, null))
    {
      parama.ek.setBackgroundResource(2130839545);
      parama.zG.setTextColor(Color.parseColor("#12B7F5"));
      parama.LD.setTextColor(Color.parseColor("#7F12B7F5"));
      parama.uy.setImageDrawable(getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20190920103348_DVTS7XhGQJ.png"));
      return;
    }
    parama.ek.setBackgroundResource(2130839546);
    parama.zG.setTextColor(Color.argb(102, 255, 255, 255));
    parama.LD.setTextColor(Color.argb(102, 255, 255, 255));
    parama.uy.setImageDrawable(getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20190920103348_9H32GY0LpT.png"));
  }
  
  private URLDrawable getDrawable(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    URLDrawable localURLDrawable;
    do
    {
      return localObject;
      localObject = URLDrawable.URLDrawableOptions.obtain();
      if (((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable == null) {
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aoop.TRANSPARENT;
      }
      if (((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable == null) {
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aoop.TRANSPARENT;
      }
      localURLDrawable = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      localObject = localURLDrawable;
    } while (!QLog.isColorLevel());
    QLog.d("NewFriendFillAcademicInfoBuilder", 2, "getDrawable downLoadUrl ->" + paramString);
    return localURLDrawable;
  }
  
  public View a(int paramInt, View paramView)
  {
    if ((paramView == null) || (!(paramView.getTag() instanceof yse.a)))
    {
      paramView = new yse.a();
      localObject = LayoutInflater.from(this.mContext).inflate(2131561723, null);
      Y((View)localObject, aqnm.dip2px(78.0F));
      paramView.uy = ((ImageView)((View)localObject).findViewById(2131369676));
      paramView.LD = ((TextView)((View)localObject).findViewById(2131380710));
      paramView.zG = ((TextView)((View)localObject).findViewById(2131380976));
      paramView.ek = ((Button)((View)localObject).findViewById(2131363797));
      a(paramView);
      ((View)localObject).setOnClickListener(this);
      paramView.ek.setOnClickListener(this);
      ((View)localObject).setTag(paramView);
      anot.a(this.mApp, "dc00898", "", "", "frd_list", "info_add_exp", 1, 0, "", "", "", "");
      return localObject;
    }
    Object localObject = (yse.a)paramView.getTag();
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    anot.a(this.mApp, "dc00898", "", "", "frd_list", "info_add_clk", 1, 0, "", "", "", "");
    Intent localIntent = new Intent(paramView.getContext(), FriendProfileMoreInfoActivity.class);
    localIntent.addFlags(536870912);
    localIntent.addFlags(67108864);
    ((NewFriendActivity)this.mContext).startActivityForResult(localIntent, 231);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public static class a
  {
    public TextView LD;
    public Button ek;
    public ImageView uy;
    public TextView zG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yse
 * JD-Core Version:    0.7.0.1
 */