import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout;
import com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class afph
  extends afll
{
  public EmoticonPanelLinearLayout.a a = new afpi(this);
  private Drawable eL = BaseApplication.getContext().getResources().getDrawable(2130838109);
  BaseChatPie mBaseChatPie;
  
  public afph(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, afmf paramafmf, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramafmf);
    this.mBaseChatPie = paramBaseChatPie;
  }
  
  private int a(afmi paramafmi)
  {
    if ((paramafmi instanceof afpg)) {
      return ((afpg)paramafmi).emoId;
    }
    if ((paramafmi instanceof afpu)) {
      return ((afpu)paramafmi).emoId;
    }
    return 0;
  }
  
  private void a(afmi paramafmi, String paramString)
  {
    if ((paramafmi instanceof afpg)) {
      ((afpg)paramafmi).bDZ = paramString;
    }
    while (!(paramafmi instanceof afpu)) {
      return;
    }
    ((afpu)paramafmi).bDZ = paramString;
  }
  
  private void a(URLImageView paramURLImageView1, URLImageView paramURLImageView2)
  {
    URLDrawable localURLDrawable;
    if ((paramURLImageView1.getDrawable() instanceof URLDrawable))
    {
      localURLDrawable = (URLDrawable)paramURLImageView1.getDrawable();
      if (localURLDrawable.getStatus() != 0) {
        break label102;
      }
      paramURLImageView1.setVisibility(8);
      paramURLImageView2.setVisibility(0);
      if (!localURLDrawable.isDownloadStarted()) {
        localURLDrawable.startDownload();
      }
      if (!(paramURLImageView2.getDrawable() instanceof Animatable)) {
        paramURLImageView2.setImageDrawable((Drawable)BaseApplication.getContext().getResources().getDrawable(2130839651));
      }
      paramURLImageView1 = (Animatable)paramURLImageView2.getDrawable();
      if (!paramURLImageView1.isRunning()) {
        paramURLImageView1.start();
      }
    }
    return;
    label102:
    if ((localURLDrawable.getStatus() == 2) || (localURLDrawable.getStatus() == 3))
    {
      paramURLImageView1.setVisibility(8);
      paramURLImageView2.setVisibility(0);
      if ((paramURLImageView2.getDrawable() instanceof Animatable)) {
        ((Animatable)paramURLImageView2.getDrawable()).stop();
      }
      paramURLImageView2.setImageDrawable(this.eL);
      return;
    }
    paramURLImageView1.setVisibility(0);
    paramURLImageView2.setVisibility(8);
  }
  
  private String b(afmi paramafmi)
  {
    String str1 = "isUpdate";
    if ((paramafmi instanceof afpg)) {
      str1 = ((afpg)paramafmi).bDZ;
    }
    for (;;)
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1))
      {
        QLog.e("FavoriteEmotionAdapter", 2, "getRoamingType return null, " + paramafmi.toString());
        str2 = "isUpdate";
      }
      return str2;
      if ((paramafmi instanceof afpu)) {
        str1 = ((afpu)paramafmi).bDZ;
      }
    }
  }
  
  private void b(View paramView, afom paramafom)
  {
    if ((paramView == null) || (!(paramafom instanceof afmi))) {
      QLog.e("FavoriteEmotionAdapter", 1, "emotionInfo or contentView = null");
    }
    afmi localafmi;
    Object localObject1;
    do
    {
      return;
      localafmi = (afmi)paramafom;
      paramView.setTag(localafmi);
      paramView.setVisibility(0);
      localObject1 = (RelativeLayout)paramView.findViewById(2131366726);
      if (localObject1 != null) {
        ((RelativeLayout)localObject1).setVisibility(8);
      }
      localObject1 = (URLImageView)paramView.findViewById(2131366331);
    } while (((URLImageView)localObject1).getTag(2131381960) == localafmi);
    ((URLImageView)localObject1).setTag(2131381960, paramafom);
    URLImageView localURLImageView = (URLImageView)paramView.findViewById(2131366308);
    paramafom = (URLImageView)paramView.findViewById(2131366332);
    ImageView localImageView = (ImageView)paramView.findViewById(2131366330);
    ((URLImageView)localObject1).setVisibility(0);
    ((URLImageView)localObject1).setURLDrawableDownListener(null);
    Object localObject2 = localafmi.action;
    if ("favEdit".equals(localObject2))
    {
      ((URLImageView)localObject1).setImageDrawable(null);
      ((URLImageView)localObject1).setImageResource(2130840174);
      paramafom.setVisibility(8);
      localImageView.setVisibility(8);
      localURLImageView.setVisibility(8);
      if (AppSetting.enableTalkBack) {
        ((URLImageView)localObject1).setContentDescription(acfp.m(2131706110));
      }
      paramView = (ImageView)paramView.findViewById(2131366337);
      if (!(localafmi instanceof afpu)) {
        break label608;
      }
      paramafom = (afpu)localafmi;
      if (!paramafom.ajH()) {
        break label601;
      }
      if (!paramafom.isNewSoundType()) {
        break label591;
      }
      paramView.setImageResource(2130838382);
    }
    for (;;)
    {
      paramView.setVisibility(0);
      return;
      if ("funny_pic".equals(localObject2))
      {
        ((URLImageView)localObject1).setImageDrawable(null);
        ((URLImageView)localObject1).setImageResource(2130847985);
        paramafom.setVisibility(8);
        localImageView.setVisibility(8);
        localURLImageView.setVisibility(8);
        if (!AppSetting.enableTalkBack) {
          break;
        }
        ((URLImageView)localObject1).setContentDescription(acfp.m(2131706102));
        break;
      }
      localObject2 = localafmi.a(this.mContext, this.density, (int)(56.0F * this.density), (int)(56.0F * this.density));
      ((URLImageView)localObject1).setImageDrawable((Drawable)localObject2);
      if (AppSetting.enableTalkBack) {
        ((URLImageView)localObject1).setContentDescription(afhv.a(this.app).a(Integer.valueOf(localafmi.emoId)));
      }
      String str = b(localafmi);
      if (QLog.isColorLevel()) {
        QLog.i("FavoriteEmotionAdapter", 2, "updateUI: roamingType = " + str);
      }
      if (str.equals("needUpload"))
      {
        localURLImageView.setImageDrawable(new ColorDrawable(-419430401));
        localURLImageView.setVisibility(0);
        localObject1 = (Animatable)BaseApplication.getContext().getResources().getDrawable(2130839651);
        paramafom.setImageDrawable((Drawable)localObject1);
        ((Animatable)localObject1).start();
        paramafom.setVisibility(0);
        localImageView.setVisibility(8);
        break;
      }
      if (str.equals("failed"))
      {
        localURLImageView.setImageDrawable(new ColorDrawable(-419430401));
        paramafom.setVisibility(8);
        localImageView.setVisibility(0);
        localURLImageView.setVisibility(0);
        break;
      }
      paramafom.setVisibility(4);
      localImageView.setVisibility(4);
      localURLImageView.setVisibility(8);
      if (!(localObject2 instanceof URLDrawable)) {
        break;
      }
      ((URLImageView)localObject1).setURLDrawableDownListener(new afpj(this, localafmi, (URLImageView)localObject1, paramafom));
      a((URLImageView)localObject1, paramafom);
      break;
      label591:
      paramView.setImageResource(2130851432);
    }
    label601:
    paramView.setVisibility(8);
    return;
    label608:
    paramView.setVisibility(8);
  }
  
  private RelativeLayout o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavoriteEmotionAdapter", 2, "getFavouriteView");
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
    localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(this.widthPixels / this.TL, (int)(61.0F * this.density)));
    Object localObject = new URLImageView(this.mContext);
    ((URLImageView)localObject).setId(2131366331);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.density * 56.0F), (int)(this.density * 56.0F));
    localLayoutParams.addRule(13, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.setMargins(0, 0, 0, (int)(5.0F * this.density));
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((URLImageView)localObject).setAdjustViewBounds(false);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new URLImageView(this.mContext);
    ((URLImageView)localObject).setId(2131366308);
    localLayoutParams = new RelativeLayout.LayoutParams((int)(this.density * 56.0F), (int)(this.density * 56.0F));
    localLayoutParams.addRule(13, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.setMargins(0, 0, 0, (int)(5.0F * this.density));
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((URLImageView)localObject).setAdjustViewBounds(false);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new URLImageView(this.mContext);
    ((URLImageView)localObject).setId(2131366332);
    localLayoutParams = new RelativeLayout.LayoutParams((int)(this.density * 56.0F), (int)(this.density * 56.0F));
    localLayoutParams.addRule(13, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.setMargins(0, 0, 0, (int)(5.0F * this.density));
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((URLImageView)localObject).setAdjustViewBounds(false);
    ((URLImageView)localObject).setVisibility(8);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new RelativeLayout(this.mContext);
    ((RelativeLayout)localObject).setId(2131366726);
    ((RelativeLayout)localObject).setVisibility(8);
    ((RelativeLayout)localObject).setBackgroundResource(2130851404);
    localLayoutParams = new RelativeLayout.LayoutParams(ankt.dip2px(10.0F), ankt.dip2px(10.0F));
    localLayoutParams.addRule(3, 2131366331);
    localLayoutParams.addRule(7, 2131366331);
    localLayoutParams.addRule(6, 2131366331);
    localLayoutParams.topMargin = (-(int)(4.0F * this.density));
    localLayoutParams.rightMargin = (-(int)(4.0F * this.density));
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new ImageView(this.mContext);
    ((ImageView)localObject).setId(2131366330);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    ((ImageView)localObject).setBackgroundResource(2130838085);
    localLayoutParams.addRule(7, 2131366331);
    localLayoutParams.addRule(8, 2131366331);
    localLayoutParams.setMargins(0, 0, (int)(-5.0F * this.density), (int)(-5.0F * this.density));
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new ImageView(this.mContext);
    ((ImageView)localObject).setId(2131366337);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(7, 2131366331);
    localLayoutParams.addRule(8, 2131366331);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    if (AppSetting.enableTalkBack) {
      localRelativeLayout.setFocusable(true);
    }
    return localRelativeLayout;
  }
  
  public afll.a a()
  {
    return new afph.a();
  }
  
  public View a(afll.a parama, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("getEmotionView position = ").append(paramInt).append(" convertView is ");
      if (paramView == null)
      {
        paramViewGroup = "null";
        QLog.d("FavoriteEmotionAdapter", 2, paramViewGroup);
      }
    }
    else
    {
      paramViewGroup = (afph.a)parama;
      if (paramView != null) {
        break label507;
      }
      paramView = afos.a().getView(this.panelType);
      if (paramView != null) {
        break label345;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavoriteEmotionAdapter", 2, "getEmotionView position = " + paramInt + "; view from inflater");
      }
      parama = new EmoticonPanelLinearLayout(this.mContext, this.mBaseChatPie, -1);
      parama.setPanelType(EmoticonPanelLinearLayout.cSr);
      parama.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      parama.setOrientation(0);
      if (paramInt != 0) {
        break label243;
      }
      parama.setPadding(0, (int)(16.0F * this.density), 0, 0);
    }
    for (;;)
    {
      i = 0;
      while (i < this.TL)
      {
        paramView = o();
        paramView.setVisibility(8);
        paramView.setFocusable(true);
        paramView.setFocusableInTouchMode(true);
        parama.addView(paramView);
        i += 1;
      }
      paramViewGroup = paramView.getClass().toString();
      break;
      label243:
      parama.setPadding(0, (int)(14.0F * this.density), 0, 0);
    }
    parama.b = this.a;
    for (;;)
    {
      ((EmoticonPanelLinearLayout)parama).setCallBack(this.f);
      recycleView(this.panelType, parama);
      paramView = (ViewGroup)parama;
      paramViewGroup.h = new RelativeLayout[this.TL];
      i = 0;
      while (i < this.TL)
      {
        paramViewGroup.h[i] = ((RelativeLayout)paramView.getChildAt(i));
        i += 1;
      }
      label345:
      parama = paramView;
      if (QLog.isColorLevel())
      {
        QLog.d("FavoriteEmotionAdapter", 2, "getEmotionView position = " + paramInt + "; view from cache");
        parama = paramView;
      }
    }
    parama.setTag(paramViewGroup);
    int i = j;
    for (;;)
    {
      if (i < this.TL)
      {
        j = this.TL * paramInt + i;
        if (j > this.data.size() - 1)
        {
          paramViewGroup.h[i].setTag(null);
          paramViewGroup.h[i].setVisibility(8);
        }
        for (;;)
        {
          i += 1;
          break;
          b(paramViewGroup.h[i], (afom)this.data.get(j));
        }
      }
      if (QLog.isColorLevel()) {}
      return parama;
      label507:
      parama = paramView;
      i = j;
    }
  }
  
  public void dag()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavoriteEmotionAdapter", 2, "refreshPanelData");
    }
    afon localafon = afon.a();
    QQAppInterface localQQAppInterface = this.app;
    int j = this.panelType;
    if (this.mBaseChatPie != null) {}
    for (int i = this.mBaseChatPie.a().cZ;; i = -1)
    {
      localafon.a(localQQAppInterface, j, null, -1, i, false, new afpk(this));
      return;
    }
  }
  
  public void setData(List<afom> paramList)
  {
    super.setData(paramList);
    afhv.a(this.app).cZG();
  }
  
  public static class a
    extends afll.a
  {
    RelativeLayout[] h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afph
 * JD-Core Version:    0.7.0.1
 */