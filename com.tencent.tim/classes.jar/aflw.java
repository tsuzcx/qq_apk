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

public class aflw
  extends afll
{
  public EmoticonPanelLinearLayout.a a = new aflx(this);
  private Drawable eG = BaseApplication.getContext().getResources().getDrawable(2130838109);
  BaseChatPie mBaseChatPie;
  
  public aflw(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, afmf paramafmf, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramafmf);
    this.mBaseChatPie = paramBaseChatPie;
  }
  
  private void a(URLImageView paramURLImageView, ImageView paramImageView)
  {
    URLDrawable localURLDrawable = (URLDrawable)paramURLImageView.getBackground();
    if (localURLDrawable.getStatus() == 0)
    {
      paramURLImageView.setVisibility(8);
      paramImageView.setVisibility(0);
      if (!localURLDrawable.isDownloadStarted()) {
        localURLDrawable.startDownload();
      }
      if (!(paramImageView.getDrawable() instanceof Animatable)) {
        paramImageView.setImageDrawable((Drawable)BaseApplication.getContext().getResources().getDrawable(2130839651));
      }
      paramURLImageView = (Animatable)paramImageView.getDrawable();
      if (!paramURLImageView.isRunning()) {
        paramURLImageView.start();
      }
      return;
    }
    if ((localURLDrawable.getStatus() == 2) || (localURLDrawable.getStatus() == 3))
    {
      paramURLImageView.setVisibility(8);
      paramImageView.setVisibility(0);
      if ((paramImageView.getDrawable() instanceof Animatable)) {
        ((Animatable)paramImageView.getDrawable()).stop();
      }
      paramImageView.setImageDrawable(this.eG);
      return;
    }
    paramURLImageView.setVisibility(0);
    paramImageView.setVisibility(8);
  }
  
  private void b(View paramView, afom paramafom)
  {
    if ((paramView == null) || (!(paramafom instanceof aflv))) {
      QLog.e("CameraEmotionAdapter", 1, "emotionInfo or contentView = null");
    }
    for (;;)
    {
      return;
      Object localObject = (URLImageView)paramView.findViewById(2131366331);
      aflv localaflv = (aflv)paramafom;
      paramView.setTag(localaflv);
      paramView.setVisibility(0);
      if ((QLog.isColorLevel()) && (!aqmr.isEmpty(localaflv.action))) {
        QLog.d("CameraEmotionAdapter", 2, "updateUI info = " + localaflv.action);
      }
      if (((URLImageView)localObject).getTag(2131381960) != paramafom)
      {
        ((URLImageView)localObject).setTag(2131381960, paramafom);
        paramafom = (ImageView)paramView.findViewById(2131366332);
        paramView = (ImageView)paramView.findViewById(2131366337);
        ((URLImageView)localObject).setVisibility(0);
        ((URLImageView)localObject).setURLDrawableDownListener(null);
        if ("cameraEdit".equals(localaflv.action))
        {
          ((URLImageView)localObject).setImageDrawable(null);
          ((URLImageView)localObject).setBackgroundResource(2130847986);
          paramafom.setVisibility(4);
          paramView.setVisibility(4);
          if (AppSetting.enableTalkBack) {
            ((URLImageView)localObject).setContentDescription(acfp.m(2131703363));
          }
        }
        else if ("cameraJump".equals(localaflv.action))
        {
          ((URLImageView)localObject).setImageDrawable(null);
          ((URLImageView)localObject).setBackgroundResource(2130838089);
          paramafom.setVisibility(4);
          paramView.setVisibility(4);
          if (AppSetting.enableTalkBack) {
            ((URLImageView)localObject).setContentDescription(acfp.m(2131703360));
          }
        }
        else
        {
          Drawable localDrawable = localaflv.b(this.mContext, this.density);
          ((URLImageView)localObject).setBackgroundDrawable(localDrawable);
          if (localaflv.bDZ.equals("needUpload"))
          {
            ((URLImageView)localObject).setImageDrawable(new ColorDrawable(-419430401));
            localObject = (Animatable)BaseApplication.getContext().getResources().getDrawable(2130839651);
            paramafom.setImageDrawable((Drawable)localObject);
            ((Animatable)localObject).start();
            paramafom.setVisibility(0);
            paramView.setVisibility(4);
          }
          while (!TextUtils.isEmpty(localaflv.eId))
          {
            anot.a(this.app, "dc00898", "", "", "0X800A370", "0X800A370", 0, 0, "", "", localaflv.eId, "");
            return;
            if (localaflv.bDZ.equals("failed"))
            {
              ((URLImageView)localObject).setImageDrawable(new ColorDrawable(-419430401));
              paramafom.setVisibility(4);
              paramView.setVisibility(0);
            }
            else
            {
              ((URLImageView)localObject).setImageDrawable(null);
              paramafom.setVisibility(4);
              paramView.setVisibility(4);
              if ((localDrawable instanceof URLDrawable))
              {
                ((URLImageView)localObject).setURLDrawableDownListener(new afly(this, localaflv, (URLImageView)localObject, paramafom));
                a((URLImageView)localObject, paramafom);
              }
            }
          }
        }
      }
    }
  }
  
  private RelativeLayout n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraEmotionAdapter", 2, "getCameraEmoView");
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
    localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(this.widthPixels / this.TL, (int)(61.0F * this.density)));
    Object localObject = new URLImageView(this.mContext);
    ((URLImageView)localObject).setId(2131366331);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.density * 56.0F), (int)(this.density * 56.0F));
    localLayoutParams.addRule(13, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.setMargins(0, 0, 0, (int)(5.0F * this.density));
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
    ((URLImageView)localObject).setAdjustViewBounds(false);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new ImageView(this.mContext);
    ((ImageView)localObject).setId(2131366332);
    localLayoutParams = new RelativeLayout.LayoutParams((int)(this.density * 56.0F), (int)(this.density * 56.0F));
    localLayoutParams.addRule(13, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.setMargins(0, 0, 0, (int)(5.0F * this.density));
    ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((ImageView)localObject).setAdjustViewBounds(false);
    ((ImageView)localObject).setVisibility(8);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new ImageView(this.mContext);
    ((ImageView)localObject).setId(2131366337);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    ((ImageView)localObject).setBackgroundResource(2130838085);
    localLayoutParams.addRule(7, 2131366331);
    localLayoutParams.addRule(8, 2131366331);
    localLayoutParams.setMargins(0, 0, (int)(-5.0F * this.density), (int)(-5.0F * this.density));
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    ((ImageView)localObject).setVisibility(8);
    if (AppSetting.enableTalkBack) {
      localRelativeLayout.setFocusable(true);
    }
    return localRelativeLayout;
  }
  
  public afll.a a()
  {
    return new aflw.a();
  }
  
  public View a(afll.a parama, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    boolean bool;
    if (QLog.isColorLevel())
    {
      paramViewGroup = new StringBuilder().append("getEmotionView position = ").append(paramInt).append(" convertView NULL is ");
      if (paramView == null)
      {
        bool = true;
        QLog.d("CameraEmotionAdapter", 2, bool);
      }
    }
    else
    {
      paramViewGroup = (aflw.a)parama;
      if (paramView != null) {
        break label409;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CameraEmotionAdapter", 2, "getEmotionView position = " + paramInt + "; view from inflater");
      }
      parama = new EmoticonPanelLinearLayout(this.mContext, this.mBaseChatPie, -1);
      parama.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      parama.setOrientation(0);
      if (paramInt != 0) {
        break label217;
      }
    }
    label217:
    for (int i = 16;; i = 14)
    {
      parama.setPadding(0, (int)(i * this.density), 0, 0);
      i = 0;
      while (i < this.TL)
      {
        paramView = n();
        paramView.setVisibility(8);
        paramView.setFocusable(true);
        paramView.setFocusableInTouchMode(true);
        parama.addView(paramView);
        i += 1;
      }
      bool = false;
      break;
    }
    parama.b = this.a;
    ((EmoticonPanelLinearLayout)parama).setCallBack(this.f);
    paramView = (ViewGroup)parama;
    paramViewGroup.h = new RelativeLayout[this.TL];
    i = 0;
    while (i < this.TL)
    {
      paramViewGroup.h[i] = ((RelativeLayout)paramView.getChildAt(i));
      i += 1;
    }
    parama.setTag(paramViewGroup);
    i = j;
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
      return parama;
      label409:
      parama = paramView;
      i = j;
    }
  }
  
  public void dag()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraEmotionAdapter", 2, "refreshPanelData");
    }
    afon localafon = afon.a();
    QQAppInterface localQQAppInterface = this.app;
    int j = this.panelType;
    if (this.mBaseChatPie != null) {}
    for (int i = this.mBaseChatPie.a().cZ;; i = -1)
    {
      localafon.a(localQQAppInterface, j, null, -1, i, false, new aflz(this));
      return;
    }
  }
  
  public static class a
    extends afll.a
  {
    RelativeLayout[] h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aflw
 * JD-Core Version:    0.7.0.1
 */