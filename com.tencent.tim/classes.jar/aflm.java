import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.IPSiteModel.Book;
import com.tencent.mobileqq.data.IPSiteModel.Comic;
import com.tencent.mobileqq.data.IPSiteModel.Game;
import com.tencent.mobileqq.data.IPSiteModel.Video;
import com.tencent.mobileqq.data.VipIPSiteInfo;
import com.tencent.mobileqq.emoticonview.BigEmotionDownloadedAdapter.1;
import com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.HorizontalListView;
import java.util.List;

public class aflm
  extends afll
{
  private int businessType;
  public URLDrawable.URLDrawableListener c = new aflt(this);
  public EmoticonPackage d;
  public Drawable eF;
  public ColorDrawable j;
  private BaseChatPie mBaseChatPie;
  
  public aflm(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, afmf paramafmf, BaseChatPie paramBaseChatPie, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramafmf);
    this.d = paramEmoticonPackage;
    this.mBaseChatPie = paramBaseChatPie;
    this.businessType = paramInt4;
    ThreadManager.post(new BigEmotionDownloadedAdapter.1(this, paramContext), 8, null, true);
  }
  
  private View a(VipIPSiteInfo paramVipIPSiteInfo)
  {
    if (paramVipIPSiteInfo != null)
    {
      if (this.j == null) {
        this.j = new ColorDrawable(-1513240);
      }
      int i;
      String str3;
      Object localObject5;
      Object localObject4;
      Object localObject3;
      Object localObject6;
      Object localObject7;
      Object localObject8;
      Object localObject9;
      Object localObject10;
      String str2;
      try
      {
        i = aqiw.getSystemNetwork(this.mContext);
        String str1 = "";
        switch (i)
        {
        default: 
          str3 = "";
        }
        try
        {
          i = paramVipIPSiteInfo.ipID;
          str3 = String.valueOf(i);
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Object localObject1;
            RelativeLayout localRelativeLayout;
            ImageView localImageView;
            QLog.e("BigEmotionDownloadedAdapter", 1, "fillIPSiteViewPagerMode ipId error = " + localException2);
            continue;
            ((TextView)localObject10).setText(acfp.m(2131703193));
            localImageView.setVisibility(8);
            localObject3 = localException2;
            if (localException2 == null) {
              localObject3 = new RelativeLayout.LayoutParams(wja.dp2px(75.0F, this.mContext.getResources()), wja.dp2px(75.0F, this.mContext.getResources()));
            }
            ((RelativeLayout.LayoutParams)localObject3).width = wja.dp2px(75.0F, this.mContext.getResources());
            ((RelativeLayout.LayoutParams)localObject3).height = wja.dp2px(75.0F, this.mContext.getResources());
            ((TextView)localObject7).setMaxWidth(wja.dp2px(126.0F, this.mContext.getResources()));
            ((TextView)localObject8).setMaxWidth(wja.dp2px(126.0F, this.mContext.getResources()));
            continue;
            ((TextView)localObject10).setText(acfp.m(2131703186));
            localImageView.setVisibility(0);
            localObject3 = localException2;
            if (localException2 == null) {
              localObject3 = new RelativeLayout.LayoutParams(wja.dp2px(140.0F, this.mContext.getResources()), wja.dp2px(75.0F, this.mContext.getResources()));
            }
            ((RelativeLayout.LayoutParams)localObject3).width = wja.dp2px(140.0F, this.mContext.getResources());
            ((RelativeLayout.LayoutParams)localObject3).height = wja.dp2px(75.0F, this.mContext.getResources());
            ((TextView)localObject7).setMaxWidth(wja.dp2px(90.0F, this.mContext.getResources()));
            ((TextView)localObject8).setMaxWidth(wja.dp2px(90.0F, this.mContext.getResources()));
          }
          VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "IP", "aio_comicshow", "", 0, 0, 0, str2, str3, "", "", "", "", "", 0, 0, 0, 0);
          paramVipIPSiteInfo = (VipIPSiteInfo)localObject4;
        }
        localObject5 = new aflo(this, paramVipIPSiteInfo, str1, str3);
        localObject1 = paramVipIPSiteInfo.strType;
        if ("comic".equals(localObject1))
        {
          localObject4 = LayoutInflater.from(this.mContext).inflate(2131559293, null, false);
          localObject1 = (TextView)((View)localObject4).findViewById(2131362446);
          localObject3 = (TextView)((View)localObject4).findViewById(2131362427);
          ((RelativeLayout)((View)localObject4).findViewById(2131362442)).setOnClickListener((View.OnClickListener)localObject5);
          localObject5 = (RelativeLayout)((View)localObject4).findViewById(2131362419);
          localObject6 = (ImageView)((View)localObject4).findViewById(2131362423);
          localObject7 = (TextView)((View)localObject4).findViewById(2131362425);
          localObject8 = (TextView)((View)localObject4).findViewById(2131362420);
          localObject9 = (Button)((View)localObject4).findViewById(2131362448);
          localObject10 = (TextView)((View)localObject4).findViewById(2131362426);
          localRelativeLayout = (RelativeLayout)((View)localObject4).findViewById(2131362421);
          localImageView = (ImageView)((View)localObject4).findViewById(2131362422);
          ((TextView)localObject1).setText(paramVipIPSiteInfo.ipName + acfp.m(2131703188));
          ((TextView)localObject3).setText(aqnl.f(paramVipIPSiteInfo.ipContent));
          if (paramVipIPSiteInfo.ipList != null)
          {
            i = 0;
            while (i < paramVipIPSiteInfo.ipList.size())
            {
              localObject1 = paramVipIPSiteInfo.ipList.get(i);
              IPSiteModel.Comic localComic;
              aflp localaflp;
              if ((localObject1 instanceof IPSiteModel.Comic))
              {
                localComic = (IPSiteModel.Comic)localObject1;
                localaflp = new aflp(this, localComic, str1, str3);
                localObject1 = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
              }
              switch (localComic.comicType)
              {
              default: 
                ((ImageView)localObject6).setImageDrawable(aqnl.a(localComic.cover, this.c, this.j));
                ((TextView)localObject7).setText(localComic.name);
                ((TextView)localObject8).setText(localComic.desc);
                ((Button)localObject9).setOnClickListener(localaflp);
                ((RelativeLayout)localObject5).setOnClickListener(localaflp);
                i += 1;
              }
            }
          }
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          i = 0;
          continue;
          str2 = "2G";
          continue;
          str2 = "3G";
          continue;
          str2 = "4G";
          continue;
          str2 = "wifi";
        }
      }
      for (;;)
      {
        if (paramVipIPSiteInfo != null) {
          VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "IP", "aio_entershow", "", 0, 0, 0, str2, str3, "", "", "", "", "", 0, 0, 0, 0);
        }
        return paramVipIPSiteInfo;
        Object localObject2;
        if ("game".equals(localException2))
        {
          localObject2 = LayoutInflater.from(this.mContext).inflate(2131559291, null, false);
          localObject8 = (TextView)((View)localObject2).findViewById(2131362446);
          localObject9 = (TextView)((View)localObject2).findViewById(2131362427);
          ((RelativeLayout)((View)localObject2).findViewById(2131362440)).setOnClickListener((View.OnClickListener)localObject5);
          localObject3 = (RelativeLayout)((View)localObject2).findViewById(2131362429);
          localObject4 = (ImageView)((View)localObject2).findViewById(2131362431);
          localObject5 = (TextView)((View)localObject2).findViewById(2131362433);
          localObject6 = (TextView)((View)localObject2).findViewById(2131362430);
          localObject7 = (Button)((View)localObject2).findViewById(2131362449);
          ((TextView)localObject8).setText(paramVipIPSiteInfo.ipName + acfp.m(2131703191));
          ((TextView)localObject9).setText(aqnl.f(paramVipIPSiteInfo.ipContent));
          if (paramVipIPSiteInfo.ipList != null)
          {
            i = 0;
            while (i < paramVipIPSiteInfo.ipList.size())
            {
              localObject8 = paramVipIPSiteInfo.ipList.get(i);
              if ((localObject8 instanceof IPSiteModel.Game))
              {
                localObject8 = (IPSiteModel.Game)localObject8;
                localObject9 = new aflq(this, (IPSiteModel.Game)localObject8, str2, str3);
                ((ImageView)localObject4).setImageDrawable(aqnl.a(((IPSiteModel.Game)localObject8).cover, this.c, this.j));
                ((TextView)localObject5).setText(((IPSiteModel.Game)localObject8).name);
                ((TextView)localObject6).setText(((IPSiteModel.Game)localObject8).recommDesc);
                ((Button)localObject7).setOnClickListener((View.OnClickListener)localObject9);
                ((RelativeLayout)localObject3).setOnClickListener((View.OnClickListener)localObject9);
              }
              i += 1;
            }
          }
          VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "IP", "aio_gameshow", "", 0, 0, 0, str2, str3, "", "", "", "", "", 0, 0, 0, 0);
          paramVipIPSiteInfo = (VipIPSiteInfo)localObject2;
        }
        else if ("goods".equals(localObject2))
        {
          localObject2 = LayoutInflater.from(this.mContext).inflate(2131559290, null, false);
          localObject3 = (TextView)((View)localObject2).findViewById(2131362446);
          localObject4 = (TextView)((View)localObject2).findViewById(2131362427);
          ((RelativeLayout)((View)localObject2).findViewById(2131362439)).setOnClickListener((View.OnClickListener)localObject5);
          ((TextView)localObject3).setText(paramVipIPSiteInfo.ipName + acfp.m(2131703184));
          ((TextView)localObject4).setText(aqnl.f(paramVipIPSiteInfo.ipContent));
          localObject3 = (HorizontalListView)((View)localObject2).findViewById(2131362444);
          if (paramVipIPSiteInfo.ipList != null)
          {
            paramVipIPSiteInfo = new afpo(this.mContext, paramVipIPSiteInfo.ipList, this.c, this.j, this.app.getCurrentUin(), str3, str2);
            ((HorizontalListView)localObject3).setDividerWidth(wja.dp2px(10.0F, this.mContext.getResources()));
            ((HorizontalListView)localObject3).setAdapter(paramVipIPSiteInfo);
          }
          VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "IP", "aio_productshow", "", 0, 0, 0, str2, str3, "", "", "", "", "", 0, 0, 0, 0);
          paramVipIPSiteInfo = (VipIPSiteInfo)localObject2;
        }
        else if ("video".equals(localObject2))
        {
          localObject3 = LayoutInflater.from(this.mContext).inflate(2131559292, null, false);
          localObject2 = (TextView)((View)localObject3).findViewById(2131362446);
          localObject9 = (TextView)((View)localObject3).findViewById(2131362427);
          ((RelativeLayout)((View)localObject3).findViewById(2131362441)).setOnClickListener((View.OnClickListener)localObject5);
          localObject4 = (RelativeLayout)((View)localObject3).findViewById(2131362451);
          localObject5 = (ImageView)((View)localObject3).findViewById(2131362454);
          localObject6 = (TextView)((View)localObject3).findViewById(2131362456);
          localObject7 = (TextView)((View)localObject3).findViewById(2131362452);
          localObject8 = (Button)((View)localObject3).findViewById(2131362450);
          ((TextView)localObject2).setText(paramVipIPSiteInfo.ipName + acfp.m(2131703192));
          ((TextView)localObject9).setText(aqnl.f(paramVipIPSiteInfo.ipContent));
          if (paramVipIPSiteInfo.ipList != null)
          {
            i = 0;
            if (i < paramVipIPSiteInfo.ipList.size())
            {
              localObject2 = paramVipIPSiteInfo.ipList.get(i);
              if ((localObject2 instanceof IPSiteModel.Video))
              {
                localObject9 = (IPSiteModel.Video)localObject2;
                localObject10 = new aflr(this, (IPSiteModel.Video)localObject9, str2, str3);
                if (!TextUtils.isEmpty(((IPSiteModel.Video)localObject9).buttonDesc)) {
                  break label1874;
                }
                localObject2 = acfp.m(2131703183);
                label1736:
                ((ImageView)localObject5).setImageDrawable(aqnl.a(((IPSiteModel.Video)localObject9).cover, this.c, this.j));
                ((TextView)localObject6).setText(((IPSiteModel.Video)localObject9).name);
                if (!TextUtils.isEmpty(((IPSiteModel.Video)localObject9).showDate)) {
                  break label1884;
                }
                ((TextView)localObject7).setText(((IPSiteModel.Video)localObject9).desc);
                label1788:
                ((Button)localObject8).setText((CharSequence)localObject2);
                if (!((String)localObject2).equals(acfp.m(2131703189))) {
                  break label1919;
                }
                k = 2130840161;
                label1813:
                ((Button)localObject8).setBackgroundResource(k);
                if (!((String)localObject2).equals(acfp.m(2131703182))) {
                  break label1926;
                }
              }
              label1926:
              for (int k = this.mContext.getResources().getColor(2131165571);; k = this.mContext.getResources().getColor(2131165625))
              {
                ((Button)localObject8).setTextColor(k);
                ((Button)localObject8).setOnClickListener((View.OnClickListener)localObject10);
                ((RelativeLayout)localObject4).setOnClickListener((View.OnClickListener)localObject10);
                i += 1;
                break;
                label1874:
                localObject2 = ((IPSiteModel.Video)localObject9).buttonDesc;
                break label1736;
                label1884:
                ((TextView)localObject7).setText(((IPSiteModel.Video)localObject9).showDate + acfp.m(2131703181));
                break label1788;
                label1919:
                k = 2130840160;
                break label1813;
              }
            }
          }
          VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "IP", "aio_movieshow", "", 0, 0, 0, str2, str3, "", "", "", "", "", 0, 0, 0, 0);
          paramVipIPSiteInfo = (VipIPSiteInfo)localObject3;
        }
        else if ("book".equals(localObject2))
        {
          localObject2 = LayoutInflater.from(this.mContext).inflate(2131559294, null, false);
          localObject8 = (TextView)((View)localObject2).findViewById(2131362446);
          localObject9 = (TextView)((View)localObject2).findViewById(2131362427);
          ((RelativeLayout)((View)localObject2).findViewById(2131362443)).setOnClickListener((View.OnClickListener)localObject5);
          localObject3 = (RelativeLayout)((View)localObject2).findViewById(2131362413);
          localObject4 = (ImageView)((View)localObject2).findViewById(2131362415);
          localObject5 = (TextView)((View)localObject2).findViewById(2131362417);
          localObject6 = (TextView)((View)localObject2).findViewById(2131362414);
          localObject7 = (Button)((View)localObject2).findViewById(2131362447);
          ((TextView)localObject8).setText(paramVipIPSiteInfo.ipName + acfp.m(2131703190));
          ((TextView)localObject9).setText(aqnl.f(paramVipIPSiteInfo.ipContent));
          if (paramVipIPSiteInfo.ipList != null)
          {
            i = 0;
            while (i < paramVipIPSiteInfo.ipList.size())
            {
              localObject8 = paramVipIPSiteInfo.ipList.get(i);
              if ((localObject8 instanceof IPSiteModel.Book))
              {
                localObject8 = (IPSiteModel.Book)localObject8;
                localObject9 = new afls(this, (IPSiteModel.Book)localObject8, str2, str3);
                ((ImageView)localObject4).setImageDrawable(aqnl.a(((IPSiteModel.Book)localObject8).cover, this.c, this.j));
                ((TextView)localObject5).setText(((IPSiteModel.Book)localObject8).name);
                ((TextView)localObject6).setText(((IPSiteModel.Book)localObject8).recommDesc);
                ((Button)localObject7).setOnClickListener((View.OnClickListener)localObject9);
                ((RelativeLayout)localObject3).setOnClickListener((View.OnClickListener)localObject9);
              }
              i += 1;
            }
          }
          VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "IP", "aio_bookshow", "", 0, 0, 0, str2, str3, "", "", "", "", "", 0, 0, 0, 0);
          paramVipIPSiteInfo = (VipIPSiteInfo)localObject2;
        }
        else
        {
          paramVipIPSiteInfo = null;
        }
      }
    }
    return null;
  }
  
  public afll.a a()
  {
    return new aflm.a();
  }
  
  public View a(afll.a parama, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    long l1 = System.currentTimeMillis();
    Object localObject1 = (aflm.a)parama;
    int i;
    if (getItemViewType(paramInt) == 0)
    {
      if (paramView != null) {
        break label1080;
      }
      paramView = afos.a().getView(this.panelType);
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BigEmotionDownloadedAdapter", 2, "getEmotionView position = " + paramInt + ";view from inflater");
        }
        paramView = new EmoticonPanelLinearLayout(this.mContext, this.mBaseChatPie, this.businessType);
        paramView.setPanelType(EmoticonPanelLinearLayout.cSp);
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
            parama = super.m();
            parama.setVisibility(8);
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
        QLog.d("BigEmotionDownloadedAdapter", 2, "getEmotionView position = " + paramInt + ";view from cache");
        parama = paramView;
      }
      ((EmoticonPanelLinearLayout)parama).setCallBack(this.f);
      recycleView(this.panelType, parama);
      paramView = (ViewGroup)parama;
      ((aflm.a)localObject1).h = new RelativeLayout[this.TL];
      i = 0;
      while (i < this.TL)
      {
        ((aflm.a)localObject1).h[i] = ((RelativeLayout)paramView.getChildAt(i));
        i += 1;
      }
      parama.setTag(localObject1);
    }
    for (;;)
    {
      i = 0;
      if (i < this.TL)
      {
        int k = this.TL * paramInt + i;
        if (k > this.data.size() - 1)
        {
          localObject1.h[i].setTag(null);
          localObject1.h[i].setVisibility(8);
        }
        for (;;)
        {
          i += 1;
          break;
          paramView = localObject1.h[i];
          paramViewGroup = (afom)this.data.get(k);
          if (paramView != null)
          {
            if (paramViewGroup == paramView.getTag(2131381960)) {
              paramView.setVisibility(0);
            } else {
              paramView.setTag(2131381960, paramViewGroup);
            }
          }
          else
          {
            long l2 = System.currentTimeMillis();
            super.a(paramView, paramViewGroup);
            if (QLog.isColorLevel()) {
              QLog.d("BigEmotionDownloadedAdapter", 2, "updateUi cost = " + (System.currentTimeMillis() - l2));
            }
          }
        }
      }
      do
      {
        if (QLog.isColorLevel()) {
          QLog.d("BigEmotionDownloadedAdapter", 2, "getEmotionView cost = " + (System.currentTimeMillis() - l1));
        }
        return parama;
        parama = paramView;
      } while (paramView != null);
      paramViewGroup = (ajdf)this.app.getManager(200);
      Object localObject2 = (ajdg)this.app.getManager(14);
      parama = this.d.ipSiteInfo;
      if ((parama == null) && (this.d.ipSiteInfoBytes != null) && (this.d.ipSiteInfoBytes.length > 0)) {
        parama = ((ajdg)localObject2).a(this.d.ipSiteInfoBytes);
      }
      for (;;)
      {
        if (paramViewGroup != null) {}
        for (boolean bool = paramViewGroup.a(parama);; bool = false)
        {
          if (bool)
          {
            paramViewGroup = a(parama);
            parama = paramView;
            if (paramViewGroup == null) {
              break;
            }
            paramViewGroup.setTag(localObject1);
            parama = paramViewGroup;
            break;
          }
          paramView = new RelativeLayout(this.mContext);
          paramView.setLayoutParams(new AbsListView.LayoutParams(-1, (int)(46.0F * this.density)));
          localObject2 = new LinearLayout(this.mContext);
          parama = new RelativeLayout.LayoutParams(-2, -2);
          parama.addRule(13, -1);
          ((LinearLayout)localObject2).setLayoutParams(parama);
          paramViewGroup = afns.a(this.d.epId, true);
          Object localObject3 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout)localObject2).setOrientation(0);
          ((LinearLayout.LayoutParams)localObject3).gravity = 16;
          TextView localTextView = new TextView(this.mContext);
          localTextView.setTextSize(14.0F);
          if (paramViewGroup.bZQ)
          {
            parama = acfp.m(2131703185);
            label826:
            localTextView.setText(parama);
            localTextView.setTextColor(-8947849);
            ((LinearLayout)localObject2).addView(localTextView, (ViewGroup.LayoutParams)localObject3);
            parama = new LinearLayout.LayoutParams(-2, -2);
            parama.leftMargin = ((int)(5.0F * this.density));
            parama.gravity = 16;
            localObject3 = new ImageView(this.mContext);
            ((ImageView)localObject3).setBackgroundDrawable(this.mContext.getResources().getDrawable(2130847984));
            ((LinearLayout)localObject2).addView((View)localObject3, parama);
            paramView.addView((View)localObject2);
            ((aflm.a)localObject1).linearLayout = ((LinearLayout)localObject2);
            ((aflm.a)localObject1).linearLayout.setOnClickListener(new afln(this, paramViewGroup));
            ((aflm.a)localObject1).linearLayout.setVisibility(0);
            paramView.setTag(localObject1);
            anot.a(this.app, "CliOper", "", "", "ep_mall", "exp_bq_detail", 0, 0, "", this.d.epId, "", "");
            localObject1 = this.app.getCurrentAccountUin();
            localObject2 = this.d.epId;
            if (!paramViewGroup.bZQ) {
              break label1064;
            }
          }
          label1064:
          for (parama = "1";; parama = "2")
          {
            VasWebviewUtil.reportCommercialDrainage((String)localObject1, "ep_mall", "exp_bq_detail", null, 1, 0, 0, null, (String)localObject2, parama);
            parama = paramView;
            break;
            parama = acfp.m(2131703187);
            break label826;
          }
        }
      }
      label1080:
      parama = paramView;
    }
  }
  
  public EmoticonPackage a()
  {
    return this.d;
  }
  
  public int getCount()
  {
    int i = super.getCount();
    if (i > 0)
    {
      if (this.businessType == 1) {
        return i;
      }
      return i + 1;
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.businessType == 1) {}
    while (paramInt != getCount() - 1) {
      return 0;
    }
    return 1;
  }
  
  public int getViewTypeCount()
  {
    if (this.businessType == 1) {
      return 1;
    }
    return 2;
  }
  
  public static class a
    extends afll.a
  {
    RelativeLayout[] h;
    LinearLayout linearLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aflm
 * JD-Core Version:    0.7.0.1
 */