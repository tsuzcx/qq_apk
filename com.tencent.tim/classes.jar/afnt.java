import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonTabAdapter.1;
import com.tencent.mobileqq.emoticonview.HorizontalListViewEx;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

public class afnt
  extends BaseAdapter
{
  public static LruCache<String, URL> r = new LruCache(50);
  private int EP;
  public QQAppInterface app;
  private boolean bZR;
  Drawable eH;
  Drawable eI;
  Drawable eJ;
  Drawable eK;
  protected Context mContext;
  List<afnt.a> mData;
  LayoutInflater mInflater;
  
  public afnt(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    this.app = paramQQAppInterface;
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.mData = new ArrayList();
    this.eH = paramContext.getResources().getDrawable(2130838105);
    this.eI = paramContext.getResources().getDrawable(2130838106);
    this.eJ = aqnm.h(this.mContext.getResources().getColor(2131166786), aqnm.dip2px(2.0F));
    this.eK = new ColorDrawable(0);
    this.EP = paramInt;
  }
  
  public static void Ie(String paramString) {}
  
  public static URL c(String paramString, boolean paramBoolean)
  {
    Object localObject2;
    if (paramString == null)
    {
      localObject2 = null;
      return localObject2;
    }
    label98:
    for (;;)
    {
      try
      {
        Object localObject1 = (URL)r.get(paramString + "_" + paramBoolean);
        localObject2 = localObject1;
        if (localObject1 != null) {
          break;
        }
        QLog.e("EmoticonTabAdapter", 2, "generateTabUrl error = " + localMalformedURLException1.getMessage());
      }
      catch (MalformedURLException localMalformedURLException1)
      {
        try
        {
          localObject2 = new URL("protocol_vas_extension_image", "EMOTICON_TAB", paramString + "_" + paramBoolean);
          localObject1 = localObject2;
          r.put(paramString, localObject1);
          return localObject1;
        }
        catch (MalformedURLException localMalformedURLException2)
        {
          break label98;
        }
        localMalformedURLException1 = localMalformedURLException1;
        localObject1 = null;
      }
    }
  }
  
  public void Ic(boolean paramBoolean)
  {
    this.bZR = paramBoolean;
  }
  
  public Drawable a(afnt.a parama)
  {
    URL localURL = c(parama.epId, parama.completed);
    Object localObject = null;
    if (localURL != null)
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.eH;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.eH;
      if (10 != parama.type) {
        break label130;
      }
    }
    label130:
    for (boolean bool = true;; bool = false)
    {
      ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = Boolean.valueOf(bool);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonTabAdapter", 2, "getTabDrawable, completed = " + parama.completed + ", epId = " + parama.epId);
      }
      parama = URLDrawable.getDrawable(localURL, (URLDrawable.URLDrawableOptions)localObject);
      localObject = parama;
      if (parama.getStatus() == 2)
      {
        parama.restartDownload();
        localObject = parama;
      }
      return localObject;
    }
  }
  
  public void bJ(List<afnt.a> paramList)
  {
    this.mData.clear();
    this.mData.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.mData.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mData.size()))
    {
      QLog.e("EmoticonTabAdapter", 1, "getItem error");
      return null;
    }
    return this.mData.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    afnt.b localb;
    if (paramView == null)
    {
      localb = new afnt.b();
      paramView = HorizontalListViewEx.bV();
      if (paramView != null) {
        break label725;
      }
      paramView = this.mInflater.inflate(2131559302, paramViewGroup, false);
    }
    label725:
    for (;;)
    {
      localb.aU = ((URLImageView)paramView.findViewById(2131379131));
      localb.yc = ((ImageView)paramView.findViewById(2131377020));
      localb.BR = paramView.findViewById(2131366309);
      paramView.setTag(localb);
      Object localObject;
      for (View localView = paramView;; localView = paramView)
      {
        localObject = (afnt.a)getItem(paramInt);
        if (localObject != null) {
          break;
        }
        QLog.e("EmoticonTabAdapter", 1, "getView item is null ,position = " + paramInt);
        paramView = null;
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localb = (afnt.b)paramView.getTag();
      }
      localb.yc.setVisibility(8);
      Drawable localDrawable;
      if (this.bZR)
      {
        localView.setBackgroundDrawable(null);
        paramView = new StateListDrawable();
        localDrawable = this.eJ;
        paramView.addState(new int[] { 16842913 }, localDrawable);
        localDrawable = this.eK;
        paramView.addState(new int[0], localDrawable);
        localb.BR.setBackgroundDrawable(paramView);
        label237:
        switch (((afnt.a)localObject).type)
        {
        case 5: 
        default: 
          paramView = null;
        }
      }
      for (;;)
      {
        if (paramView != null) {
          localb.aU.setImageDrawable(paramView);
        }
        paramView = localView;
        break;
        localb.BR.setBackgroundDrawable(null);
        localView.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130840172));
        break label237;
        paramView = this.mContext.getResources().getDrawable(2130848021);
        if (this.app != null)
        {
          localObject = (ajdg)this.app.getManager(14);
          if ((localObject != null) && (((ajdg)localObject).kp(this.EP)))
          {
            localb.yc.setVisibility(0);
            this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("recommemd_red_effect", true).apply();
            VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "ep_mall", "j_redshow", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
          }
          else
          {
            continue;
            paramView = this.mContext.getResources().getDrawable(2130848005);
            continue;
            paramView = this.mContext.getResources().getDrawable(2130848004);
            continue;
            if (((afgw)this.app.getManager(334)).ajj()) {
              localb.yc.setVisibility(0);
            }
            paramView = this.mContext.getResources().getDrawable(2130838088);
            continue;
            paramView = this.mContext.getResources().getDrawable(2130838104);
            continue;
            paramView = this.mContext.getResources().getDrawable(2130838091);
            continue;
            paramView = a((afnt.a)localObject);
            if (paramView == null)
            {
              paramView = new StateListDrawable();
              localDrawable = this.eI;
              paramView.addState(new int[] { 16842913 }, localDrawable);
              localDrawable = this.eH;
              paramView.addState(new int[0], localDrawable);
              ThreadManager.post(new EmoticonTabAdapter.1(this, (afnt.a)localObject), 5, null, false);
              continue;
              paramView = this.mContext.getResources().getDrawable(2130848013);
              continue;
              paramView = this.mContext.getResources().getDrawable(2130848014);
            }
            else {}
          }
        }
      }
    }
  }
  
  public static class a
  {
    public boolean completed;
    public String description;
    public String epId;
    public int subType;
    public int type;
  }
  
  public class b
  {
    View BR;
    public URLImageView aU;
    ImageView yc;
    
    public b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afnt
 * JD-Core Version:    0.7.0.1
 */