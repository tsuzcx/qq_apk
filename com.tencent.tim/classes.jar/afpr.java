import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class afpr
  extends afoi
  implements Handler.Callback
{
  List<ProgressBar> Al = new ArrayList();
  private MqqHandler q = new aurf(Looper.getMainLooper(), this, true);
  
  public afpr(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, afmf paramafmf)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramafmf);
  }
  
  private ProgressBar a(EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage == null) || (TextUtils.isEmpty(paramEmoticonPackage.epId))) {}
    while ((this.Al == null) || (this.Al.size() <= 0)) {
      return null;
    }
    Iterator localIterator = this.Al.iterator();
    while (localIterator.hasNext())
    {
      ProgressBar localProgressBar = (ProgressBar)localIterator.next();
      Object localObject = localProgressBar.getTag();
      if ((localObject instanceof String)) {}
      for (localObject = (String)localObject; (!TextUtils.isEmpty((CharSequence)localObject)) && (paramEmoticonPackage.epId.equals(localObject)); localObject = null) {
        return localProgressBar;
      }
    }
  }
  
  private void a(URLImageView paramURLImageView, afpu paramafpu)
  {
    if ((paramURLImageView == null) || (paramafpu == null))
    {
      QLog.e("MagicFaceAdapter", 1, "updateImageView view or info = null");
      return;
    }
    Object localObject = (RelativeLayout.LayoutParams)paramURLImageView.getLayoutParams();
    if ("push".equals(paramafpu.action))
    {
      ((RelativeLayout.LayoutParams)localObject).width = ((int)(this.density * 63.0F));
      ((RelativeLayout.LayoutParams)localObject).height = ((int)(this.density * 63.0F));
      if (QLog.isColorLevel()) {
        QLog.d("MagicFaceAdapter", 2, "show push_btn drawable.");
      }
      paramafpu = this.mContext.getSharedPreferences("mobileQQ", 0);
      localObject = this.app.getCurrentAccountUin();
      boolean bool = paramafpu.getBoolean("magic_promotion_is_new_content_" + (String)localObject, false);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.mContext.getResources().getDrawable(2130847982);
      if (bool)
      {
        paramafpu = paramafpu.getString("magic_promotion_gifUrl", "");
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
        if (TextUtils.isEmpty(paramafpu)) {
          break label241;
        }
      }
      for (;;)
      {
        try
        {
          paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramafpu, (URLDrawable.URLDrawableOptions)localObject));
          if (!AppSetting.enableTalkBack) {
            break;
          }
          paramURLImageView.setContentDescription(acfp.m(2131707995));
          return;
          paramafpu = paramafpu.getString("magic_promotion_imgUrl", "");
        }
        catch (IllegalArgumentException paramafpu)
        {
          if (QLog.isColorLevel()) {
            QLog.w("MagicFaceAdapter", 2, paramafpu.getMessage());
          }
          paramURLImageView.setImageDrawable(null);
          continue;
        }
        label241:
        paramURLImageView.setImageDrawable(null);
      }
    }
    Emoticon localEmoticon = paramafpu.e;
    if ((localEmoticon == null) || (TextUtils.isEmpty(localEmoticon.epId)))
    {
      QLog.e("MagicFaceAdapter", 1, "updateImageView emotion is null or epid is null");
      return;
    }
    EmoticonPackage localEmoticonPackage = ((ajdg)this.app.getManager(14)).b(localEmoticon.epId);
    String str = localEmoticon.epId + "_" + localEmoticon.eId;
    localObject = str;
    if (localEmoticonPackage != null) {
      if (localEmoticonPackage.valid)
      {
        localObject = str;
        if (2 == localEmoticonPackage.status) {}
      }
      else
      {
        localObject = str;
        if (!paramafpu.cae) {
          localObject = str + "_panel_magic_gray";
        }
      }
    }
    try
    {
      paramafpu = new URL("emotion_pic", "fromPanel", (String)localObject);
      if (paramafpu != null)
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.mContext.getResources().getDrawable(2130838097);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.mContext.getResources().getDrawable(2130844558);
        paramafpu = URLDrawable.getDrawable(paramafpu, (URLDrawable.URLDrawableOptions)localObject);
        paramafpu.setTag(localEmoticon);
        paramafpu.addHeader("my_uin", this.app.getCurrentAccountUin());
        if (paramafpu != null)
        {
          paramURLImageView.setImageDrawable(paramafpu);
          paramURLImageView.setBackgroundDrawable(null);
          return;
        }
      }
    }
    catch (MalformedURLException paramafpu)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MagicFaceAdapter", 2, "updateImageView ,", paramafpu);
        }
        paramafpu = null;
        continue;
        paramURLImageView.setVisibility(4);
        continue;
        paramafpu = null;
      }
    }
  }
  
  private void b(View paramView, afom paramafom)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceAdapter", 2, "updateUI");
    }
    if ((paramView == null) || (paramafom == null)) {
      return;
    }
    if ((paramafom instanceof afmi)) {}
    for (paramafom = (afpu)paramafom;; paramafom = null)
    {
      if (paramafom == null)
      {
        QLog.e("MagicFaceAdapter", 1, "updateUI emotionInfo = null");
        return;
      }
      paramView.setVisibility(0);
      paramView.setTag(paramafom);
      Object localObject1 = (URLImageView)paramView.findViewById(2131366331);
      ((URLImageView)localObject1).setVisibility(0);
      a((URLImageView)localObject1, paramafom);
      Object localObject2 = (TextView)paramView.findViewById(2131366336);
      ImageView localImageView = (ImageView)paramView.findViewById(2131366338);
      localObject1 = (ImageView)paramView.findViewById(2131366337);
      paramView = (ProgressBar)paramView.findViewById(2131366335);
      if ("push".equals(paramafom.action))
      {
        ((TextView)localObject2).setVisibility(8);
        localImageView.setVisibility(8);
        ((ImageView)localObject1).setVisibility(8);
        paramView.setVisibility(8);
        return;
      }
      paramafom = paramafom.e;
      if ((paramafom == null) || (TextUtils.isEmpty(paramafom.epId)))
      {
        QLog.e("MagicFaceAdapter", 1, "updateUI emotion is null or epid is null");
        return;
      }
      String str = paramafom.name;
      if (!TextUtils.isEmpty(str))
      {
        ((TextView)localObject2).setVisibility(0);
        if (str.length() > 5)
        {
          ((TextView)localObject2).setText(str.substring(0, 4) + "...");
          if (AppSetting.enableTalkBack) {
            ((TextView)localObject2).setContentDescription(str);
          }
          label274:
          localImageView.setVisibility(8);
          ((ImageView)localObject1).setVisibility(8);
          localObject2 = ((ajdg)this.app.getManager(14)).b(paramafom.epId);
          if ((localObject2 != null) && (!((EmoticonPackage)localObject2).valid))
          {
            ((ImageView)localObject1).setImageResource(2130847991);
            ((ImageView)localObject1).setVisibility(0);
          }
          paramView.setVisibility(8);
          paramView.setTag(paramafom.epId);
          if (!this.Al.contains(paramView)) {
            this.Al.add(paramView);
          }
          if (((afke)this.app.getManager(43)).e(paramafom.epId) < 0.0F) {
            break label430;
          }
        }
      }
      label430:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label435;
        }
        paramView.setVisibility(0);
        return;
        ((TextView)localObject2).setText(str);
        break;
        ((TextView)localObject2).setVisibility(8);
        break label274;
      }
      label435:
      paramView.setVisibility(8);
      return;
    }
  }
  
  private RelativeLayout q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceAdapter", 2, "getMagicView");
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
    localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(this.widthPixels / this.TL, (int)(72.0F * this.density)));
    Object localObject = new URLImageView(this.mContext);
    ((URLImageView)localObject).setId(2131366331);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams((int)(56.0F * this.density), (int)(56.0F * this.density));
    localLayoutParams1.addRule(10, -1);
    localLayoutParams1.addRule(14, -1);
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
    ((URLImageView)localObject).setAdjustViewBounds(false);
    ((URLImageView)localObject).setLayoutParams(localLayoutParams1);
    localRelativeLayout.addView((View)localObject);
    localObject = new TextView(this.mContext);
    ((TextView)localObject).setVisibility(8);
    ((TextView)localObject).setId(2131366336);
    ((TextView)localObject).setTextSize(11.0F);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams1.addRule(3, 2131366331);
    localLayoutParams1.topMargin = ((int)(5.0F * this.density));
    localLayoutParams1.addRule(14, -1);
    localRelativeLayout.addView((View)localObject, localLayoutParams1);
    localObject = new ImageView(this.mContext);
    ((ImageView)localObject).setVisibility(8);
    ((ImageView)localObject).setId(2131366337);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams1.addRule(8, 2131366331);
    localLayoutParams1.addRule(7, 2131366331);
    localRelativeLayout.addView((View)localObject, localLayoutParams1);
    localObject = new ImageView(this.mContext);
    ((ImageView)localObject).setId(2131366338);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams1.addRule(5, 2131366331);
    localLayoutParams1.addRule(6, 2131366331);
    ProgressBar localProgressBar = new ProgressBar(this.mContext);
    localProgressBar.setVisibility(8);
    localProgressBar.setId(2131366335);
    localProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(2130839651));
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams((int)(16.0F * this.density), (int)(16.0F * this.density));
    localLayoutParams2.addRule(14, -1);
    localLayoutParams2.topMargin = ((int)(20.0F * this.density));
    localRelativeLayout.addView(localProgressBar, localLayoutParams2);
    localRelativeLayout.addView((View)localObject, localLayoutParams1);
    if (AppSetting.enableTalkBack) {
      localRelativeLayout.setFocusable(true);
    }
    return localRelativeLayout;
  }
  
  public afll.a a()
  {
    return new afpr.a();
  }
  
  public View a(afll.a parama, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    paramViewGroup = (afpr.a)parama;
    int i;
    if (paramView == null)
    {
      paramView = afos.a().getView(this.panelType);
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MagicFaceAdapter", 2, "getEmotionView position = " + paramInt + ";view from infalter");
        }
        paramView = new EmoticonPanelLinearLayout(this.mContext);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        paramView.setOrientation(0);
        if (paramInt == 0) {
          paramView.setPadding(0, (int)(16.0F * this.density), 0, 0);
        }
        for (;;)
        {
          i = 0;
          for (;;)
          {
            parama = paramView;
            if (i >= this.TL) {
              break;
            }
            parama = q();
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.widthPixels / this.TL, -1);
            parama.setGravity(17);
            parama.setVisibility(8);
            parama.setLayoutParams(localLayoutParams);
            parama.setFocusable(true);
            parama.setFocusableInTouchMode(true);
            paramView.addView(parama);
            i += 1;
          }
          paramView.setPadding(0, (int)(14.0F * this.density), 0, 0);
        }
      }
      parama = paramView;
      if (QLog.isColorLevel())
      {
        QLog.d("MagicFaceAdapter", 2, "getEmotionView position = " + paramInt + ";view from cache");
        parama = paramView;
      }
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
      parama.setTag(paramViewGroup);
      i = j;
    }
    for (;;)
    {
      try
      {
        if (i < this.TL)
        {
          j = this.TL * paramInt + i;
          if (j > this.data.size() - 1)
          {
            paramViewGroup.h[i].setTag(null);
            paramViewGroup.h[i].setVisibility(8);
          }
          else
          {
            b(paramViewGroup.h[i], (afom)this.data.get(j));
          }
        }
      }
      catch (OutOfMemoryError paramView)
      {
        QLog.e("MagicFaceAdapter", 1, "updateUI oom");
      }
      return parama;
      parama = paramView;
      i = j;
      continue;
      i += 1;
    }
  }
  
  public void d(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceAdapter", 2, "packageDownloadEnd");
    }
    if (paramEmoticonPackage == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 101;
    localMessage.arg1 = paramInt;
    localMessage.obj = paramEmoticonPackage;
    this.q.sendMessage(localMessage);
  }
  
  public void dag()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceAdapter", 2, "refreshPanelData");
    }
    afon.a().a(this.app, this.panelType, null, -1, 0, false, new afps(this));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      paramMessage = a((EmoticonPackage)paramMessage.obj);
      if (paramMessage != null)
      {
        paramMessage.setVisibility(0);
        continue;
        ProgressBar localProgressBar = a((EmoticonPackage)paramMessage.obj);
        int i = paramMessage.arg1;
        if (localProgressBar != null)
        {
          localProgressBar.setVisibility(8);
          if (i == 0) {
            dag();
          }
        }
      }
    }
  }
  
  public void l(EmoticonPackage paramEmoticonPackage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceAdapter", 2, "packageDownloadStart");
    }
    if (paramEmoticonPackage == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 100;
    localMessage.obj = paramEmoticonPackage;
    this.q.sendMessage(localMessage);
  }
  
  public static class a
    extends afll.a
  {
    RelativeLayout[] h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afpr
 * JD-Core Version:    0.7.0.1
 */