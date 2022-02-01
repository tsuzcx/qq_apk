import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.data.TroopAioTopADInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class apvr
  implements View.OnClickListener
{
  protected apbo a;
  protected apmp b;
  int dXy = 1000;
  protected Drawable fK;
  protected Drawable fL;
  long lastClickTime = 0L;
  protected QQAppInterface mApp;
  protected Context mContext;
  protected Drawable mDefaultDrawable;
  protected SessionInfo mSessionInfo;
  protected HashMap<Integer, apvr.d> oK = new LinkedHashMap();
  
  public apvr(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, apbo paramapbo, apmp paramapmp)
  {
    this.mContext = paramContext;
    this.mSessionInfo = paramSessionInfo;
    this.mApp = paramQQAppInterface;
    this.a = paramapbo;
    this.b = paramapmp;
  }
  
  public View a(TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    if (this.oK.get(Integer.valueOf(2)) != null) {
      return null;
    }
    int i = jQ(paramTroopFeedItem.type);
    apvr.d locald2 = (apvr.d)this.oK.get(Integer.valueOf(i));
    apvr.d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = a(i);
      this.oK.put(Integer.valueOf(i), locald1);
    }
    if (locald1 != null) {
      return locald1.a(paramTroopFeedItem, paramInt, paramBoolean);
    }
    return null;
  }
  
  protected apvr.d a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new apvr.b();
    case 0: 
      return new apvr.b();
    }
    return new apvr.e();
  }
  
  public void ecm()
  {
    this.oK.remove(Integer.valueOf(2));
  }
  
  protected int jQ(int paramInt)
  {
    switch (paramInt)
    {
    }
    return 0;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof apvr.a.a)) {
      this.b.RV(true);
    }
    while (SystemClock.uptimeMillis() - this.lastClickTime < this.dXy)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    this.lastClickTime = SystemClock.uptimeMillis();
    Object localObject = new Intent(this.mContext, QQBrowserActivity.class);
    TroopInfo localTroopInfo = ((TroopManager)this.mApp.getManager(52)).b(this.mSessionInfo.aTl);
    String str = this.mApp.getCurrentAccountUin();
    int i;
    if ((localTroopInfo != null) && (str != null)) {
      if (str.equals(localTroopInfo.troopowneruin)) {
        i = 0;
      }
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("url", String.format("https://web.qun.qq.com/qqweb/m/qun/notification/index.html?gc=%s&role=%d&_bid=2223&_wv=1031", new Object[] { this.mSessionInfo.aTl, Integer.valueOf(i) }));
      this.mContext.startActivity((Intent)localObject);
      localObject = paramView.getTag();
      if (!(localObject instanceof apvr.c)) {
        break;
      }
      localObject = ((apvr.c)localObject).b;
      if ((localObject == null) || (!((TroopFeedItem)localObject).isStoryType())) {
        break;
      }
      anot.a(this.mApp, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_story_pgc", 0, 0, this.mSessionInfo.aTl, "", "", "");
      break;
      if ((localTroopInfo.Administrator != null) && (localTroopInfo.Administrator.contains(str))) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
  
  class a
    extends apvr.d
  {
    public TroopAioTopADInfo a;
    
    protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
    {
      paramTroopFeedItem = paramView;
      if (paramView == null) {
        paramTroopFeedItem = LayoutInflater.from(this.b.mContext).inflate(2131560759, null);
      }
      Object localObject = (apvr.a.a)paramTroopFeedItem.getTag();
      paramView = (View)localObject;
      if (localObject == null)
      {
        paramView = new apvr.a.a();
        paramView.I = ((URLImageView)paramTroopFeedItem.findViewById(2131362112));
        paramTroopFeedItem.setOnClickListener(this.b);
        paramTroopFeedItem.setTag(paramView);
      }
      if (!aqiw.isNetSupport(this.b.mContext)) {
        if (this.b.a != null) {
          this.b.a.dYF();
        }
      }
      do
      {
        return paramTroopFeedItem;
        try
        {
          localObject = URLDrawable.URLDrawableOptions.obtain();
          afei localafei = new afei(1, 1);
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localafei;
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localafei;
          localObject = URLDrawable.getDrawable(this.a.uiUrl, (URLDrawable.URLDrawableOptions)localObject);
          paramView.I.setBackgroundDrawable((Drawable)localObject);
          if (QLog.isColorLevel()) {
            QLog.i("TroopAioADManager", 2, "URLDrawable: " + this.a.uiUrl);
          }
          anot.a(this.b.mApp, "P_CliOper", "Grp_AIO", "", "notice_center", "Exp_Promote", 0, 0, this.b.mSessionInfo.aTl, this.a.adId + "", "", "");
          return paramTroopFeedItem;
        }
        catch (IllegalArgumentException paramView) {}
      } while (!QLog.isColorLevel());
      QLog.e("TroopAioADManager", 2, "IllegalArgumentException");
      return paramTroopFeedItem;
    }
    
    class a
    {
      URLImageView I;
      
      a() {}
    }
  }
  
  class b
    extends apvr.d
  {
    b()
    {
      super();
    }
    
    protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
    {
      View localView3 = paramView;
      if (paramView == null) {
        localView3 = LayoutInflater.from(apvr.this.mContext).inflate(2131560760, null);
      }
      apvr.b.a locala = (apvr.b.a)localView3.getTag();
      if (locala == null)
      {
        locala = new apvr.b.a();
        locala.EP = ((ImageView)localView3.findViewById(2131373231));
        locala.titleView = ((TextView)localView3.findViewById(2131379769));
        locala.contentView = ((TextView)localView3.findViewById(2131365360));
        locala.ld = ((LinearLayout)localView3.findViewById(2131361839));
        localView3.setOnClickListener(apvr.this);
        localView3.setTag(locala);
      }
      for (;;)
      {
        locala.position = paramInt;
        locala.b = paramTroopFeedItem;
        locala.titleView.setSingleLine(false);
        locala.titleView.setMaxLines(2);
        paramView = "[" + paramTroopFeedItem.tag + "] " + paramTroopFeedItem.title;
        locala.titleView.setText(paramView);
        locala.EP.setVisibility(0);
        locala.ld.setVisibility(8);
        locala.contentView.setVisibility(0);
        locala.contentView.setSingleLine(false);
        locala.contentView.setMaxLines(2);
        locala.contentView.setText("");
        locala.EP.setBackgroundDrawable(null);
        locala.EP.setScaleType(ImageView.ScaleType.CENTER_CROP);
        String str = acfp.m(2131715668) + paramTroopFeedItem.tag + " " + paramTroopFeedItem.title;
        if (paramTroopFeedItem.type == 5)
        {
          if (apvr.this.fK == null) {
            apvr.this.fK = apvr.this.mContext.getResources().getDrawable(2130844440);
          }
          paramView = apvr.this.fK;
          if (aqmr.isEmpty(paramTroopFeedItem.picPath)) {
            break label1165;
          }
        }
        for (;;)
        {
          try
          {
            paramInt = wja.dp2px(61.0F, apvr.this.mContext.getResources());
            URLDrawable localURLDrawable = URLDrawable.getDrawable(paramTroopFeedItem.picPath, paramInt, paramInt, apvr.this.mDefaultDrawable, apvr.this.mDefaultDrawable);
            Object localObject;
            if (!paramTroopFeedItem.isStoryType())
            {
              localObject = str;
              if (paramTroopFeedItem.type != 5)
              {
                localObject = str;
                if (paramTroopFeedItem.type != 19)
                {
                  localObject = str;
                  if (paramTroopFeedItem.type == 99) {}
                }
              }
            }
            else
            {
              paramView = str;
              if (!aqmr.isEmpty(paramTroopFeedItem.publishUin))
              {
                paramView = str + " " + paramTroopFeedItem.publishUin;
                ((TextView)locala.ld.findViewById(2131372384)).setText(paramTroopFeedItem.publishUin);
              }
              localObject = paramView;
              if (!aqmr.isEmpty(paramTroopFeedItem.feedTime))
              {
                try
                {
                  localObject = acfp.m(2131715671) + apbn.bK(Long.parseLong(paramTroopFeedItem.feedTime));
                  ((TextView)locala.ld.findViewById(2131361838)).setText((CharSequence)localObject);
                  localObject = paramView + (String)localObject;
                  paramInt = 1;
                  if (paramInt != 0)
                  {
                    locala.ld.setVisibility(0);
                    locala.contentView.setVisibility(8);
                  }
                  if (paramTroopFeedItem.type != 131) {
                    continue;
                  }
                  locala.EP.setImageResource(ahav.r(paramTroopFeedItem.title));
                  paramView = (View)localObject;
                  paramTroopFeedItem = paramView;
                  if (!paramBoolean) {
                    paramTroopFeedItem = paramView + " " + acfp.m(2131715672);
                  }
                  localView3.setContentDescription(paramTroopFeedItem);
                  return localView3;
                }
                catch (NumberFormatException localNumberFormatException)
                {
                  localView2 = paramView;
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.e("TroopFeedViewFactory", 2, "item.feedTime:" + paramTroopFeedItem.feedTime);
                  localView2 = paramView;
                }
                if (paramTroopFeedItem.type == 132)
                {
                  if (apvr.this.fL == null) {
                    apvr.this.fL = apvr.this.mContext.getResources().getDrawable(2130844442);
                  }
                  paramView = apvr.this.fL;
                  break;
                }
                if (apvr.this.mDefaultDrawable == null) {
                  apvr.this.mDefaultDrawable = apvr.this.mContext.getResources().getDrawable(2130844440);
                }
                paramView = apvr.this.mDefaultDrawable;
              }
            }
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            localView1 = paramView;
            continue;
            View localView2;
            paramInt = 0;
            continue;
            if ((paramTroopFeedItem.type == 5) || (paramTroopFeedItem.type == 19))
            {
              locala.EP.setImageDrawable(localView1);
              locala.contentView.setText(paramTroopFeedItem.content);
              locala.titleView.setSingleLine(true);
              locala.titleView.setMaxLines(1);
              paramView = localView2 + " " + paramTroopFeedItem.content;
              continue;
            }
            if ((paramTroopFeedItem.type == 133) || (paramTroopFeedItem.type == 18) || (paramTroopFeedItem.type == 0))
            {
              locala.EP.setImageDrawable(localView1);
              paramView = localView2;
              continue;
            }
            if (paramTroopFeedItem.type == 12)
            {
              locala.EP.setImageResource(2130844445);
              paramView = localView2;
              continue;
            }
            if ((paramTroopFeedItem.type == 10) || (paramTroopFeedItem.type == 132))
            {
              locala.EP.setScaleType(ImageView.ScaleType.CENTER);
              locala.EP.setBackgroundDrawable(localView1);
              locala.EP.setImageResource(2130844444);
              paramView = localView2;
              continue;
            }
            paramView = localView2;
            if (paramTroopFeedItem.orginType != 99) {
              continue;
            }
            locala.EP.setImageDrawable(localView1);
            locala.contentView.setText(paramTroopFeedItem.content);
            if (!paramTroopFeedItem.tag.equals(acfp.m(2131715665)))
            {
              locala.titleView.setSingleLine(true);
              locala.titleView.setMaxLines(1);
            }
            paramView = localView2 + " " + paramTroopFeedItem.content;
            continue;
          }
          label1165:
          View localView1 = paramView;
        }
      }
    }
    
    class a
      extends apvr.c
    {
      ImageView EP;
      TextView contentView;
      LinearLayout ld;
      TextView titleView;
      
      a()
      {
        super();
      }
    }
  }
  
  public class c
  {
    TroopFeedItem jdField_b_of_type_ComTencentMobileqqDataTroopFeedItem;
    int position;
    
    public c() {}
  }
  
  public abstract class d
  {
    public d() {}
    
    protected abstract View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean);
    
    public View a(TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
    {
      return a(null, paramTroopFeedItem, paramInt, paramBoolean);
    }
  }
  
  class e
    extends apvr.d
  {
    e()
    {
      super();
    }
    
    protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
    {
      View localView = paramView;
      if (paramView == null) {
        localView = LayoutInflater.from(apvr.this.mContext).inflate(2131560761, null);
      }
      paramView = (apvr.e.a)localView.getTag();
      Object localObject = paramView;
      if (paramView == null)
      {
        localObject = new apvr.e.a();
        ((apvr.e.a)localObject).EP = ((ImageView)localView.findViewById(2131373231));
        ((apvr.e.a)localObject).titleView = ((TextView)localView.findViewById(2131379769));
        ((apvr.e.a)localObject).le = ((LinearLayout)localView.findViewById(2131382076));
        ((apvr.e.a)localObject).abo = ((TextView)localView.findViewById(2131382079));
        ((apvr.e.a)localObject).abp = ((TextView)localView.findViewById(2131382080));
        localView.setOnClickListener(apvr.this);
        localView.setTag(localObject);
      }
      ((apvr.e.a)localObject).position = paramInt;
      ((apvr.e.a)localObject).b = paramTroopFeedItem;
      paramView = "[" + paramTroopFeedItem.tag + "] " + paramTroopFeedItem.title;
      ((apvr.e.a)localObject).titleView.setText(paramView);
      ((apvr.e.a)localObject).abo.setText(paramTroopFeedItem.content);
      ((apvr.e.a)localObject).le.setVisibility(0);
      paramView = acfp.m(2131715667) + paramTroopFeedItem.tag + " " + paramTroopFeedItem.title + " " + paramTroopFeedItem.content;
      if (!aqmr.isEmpty(paramTroopFeedItem.ex_1))
      {
        ((apvr.e.a)localObject).abp.setText(paramTroopFeedItem.ex_1);
        paramView = paramView + " " + paramTroopFeedItem.ex_1;
      }
      for (;;)
      {
        ((apvr.e.a)localObject).EP.setImageResource(2130844445);
        paramTroopFeedItem = paramView;
        if (!paramBoolean) {
          paramTroopFeedItem = paramView + " " + acfp.m(2131715663);
        }
        localView.setContentDescription(paramTroopFeedItem);
        return localView;
        ((apvr.e.a)localObject).le.setVisibility(8);
      }
    }
    
    class a
      extends apvr.c
    {
      ImageView EP;
      TextView abo;
      TextView abp;
      LinearLayout le;
      TextView titleView;
      
      a()
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apvr
 * JD-Core Version:    0.7.0.1
 */