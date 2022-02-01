import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.data.TransitionCategoryItem;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class axpg
  extends BaseAdapter
{
  public static final int eGA = aqnm.dpToPx(10.0F);
  public static final int eGy = aqnm.dpToPx(40.0F);
  public static final int eGz = aqnm.dpToPx(5.0F);
  float Eo;
  private ArrayList<axpg.a> FO = new ArrayList(10);
  private boolean dgm;
  public boolean dvN;
  int eCJ;
  private Context mContext;
  List<QIMFilterCategoryItem> mData = new ArrayList(0);
  float qT;
  
  public axpg(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.eCJ = paramInt;
  }
  
  private View cL()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
    FrameLayout localFrameLayout = new FrameLayout(this.mContext);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    if (!this.dvN) {
      localFrameLayout.setPadding(eGA, eGA, eGA, eGA);
    }
    for (;;)
    {
      ((RelativeLayout.LayoutParams)localObject1).setMargins(eGz, eGz, eGz, eGz);
      localRelativeLayout.addView(localFrameLayout, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new URLImageView(this.mContext);
      ((URLImageView)localObject1).setId(2131368698);
      ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
      Object localObject2 = new FrameLayout.LayoutParams(eGy, eGy);
      ((FrameLayout.LayoutParams)localObject2).gravity = 49;
      localFrameLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new TextView(this.mContext);
      ((TextView)localObject2).setId(2131367090);
      ((TextView)localObject2).setGravity(17);
      ((TextView)localObject2).setTextSize(2, 12.0F);
      ((TextView)localObject2).setTextColor(this.mContext.getResources().getColor(2131167654));
      ((TextView)localObject2).setMaxLines(1);
      ((TextView)localObject2).setLines(1);
      ((TextView)localObject2).setShadowLayer(3.0F, 0.0F, 0.0F, Color.parseColor("#7F000000"));
      Object localObject3 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject3).gravity = 81;
      localFrameLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new axpg.a();
      ((axpg.a)localObject3).p = ((URLImageView)localObject1);
      ((axpg.a)localObject3).MP = localFrameLayout;
      ((axpg.a)localObject3).ahv = ((TextView)localObject2);
      ((axpg.a)localObject3).dvN = this.dvN;
      localRelativeLayout.setTag(localObject3);
      this.FO.add(localObject3);
      return localRelativeLayout;
      localFrameLayout.setPadding(eGz, 0, eGz, eGz);
    }
  }
  
  private void p(ImageView paramImageView, String paramString)
  {
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      try
      {
        paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        if (paramString.getStatus() == 2) {
          paramString.restartDownload();
        }
        paramImageView.setImageDrawable(paramString);
        return;
      }
      catch (Error paramImageView) {}
    } while (!QLog.isColorLevel());
    QLog.d("TransitionProviderGridAdapter", 2, "setStaticURLDrawable " + paramImageView.toString());
  }
  
  private void q(ImageView paramImageView, String paramString)
    throws Exception
  {
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString))) {
      throw new Exception("apngUrl null");
    }
    Object localObject1 = this.mContext.getFilesDir() + "/shortvideo_transition_preview/";
    Object localObject2 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdir();
    }
    localObject2 = paramString.substring(paramString.lastIndexOf("/") + 1, paramString.lastIndexOf("."));
    localObject1 = aqqx.a(BaseApplicationImpl.sApplication.getRuntime(), (String)localObject1 + (String)localObject2, paramString, null, new int[] { 16 }, "-Transition-", null);
    if (localObject1 != null)
    {
      paramImageView.setImageDrawable((Drawable)localObject1);
      if (((URLDrawable)localObject1).getStatus() == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TransitionProviderGridAdapter", 2, "restartDownload apng:" + paramString);
        }
        ((URLDrawable)localObject1).restartDownload();
      }
      return;
    }
    throw new Exception("urlDrawableApng null");
  }
  
  public void dLo()
  {
    TransitionCategoryItem localTransitionCategoryItem = ayva.a().a();
    Iterator localIterator = this.FO.iterator();
    axpg.a locala;
    boolean bool2;
    label66:
    boolean bool1;
    if (localIterator.hasNext())
    {
      locala = (axpg.a)localIterator.next();
      if (locala.a == null) {
        break label116;
      }
      if (localTransitionCategoryItem == null) {
        break label111;
      }
      bool2 = TextUtils.equals(localTransitionCategoryItem.id, locala.a.id);
      bool1 = bool2;
      if (!bool2)
      {
        if (((localTransitionCategoryItem != null) && (!localTransitionCategoryItem.auG())) || (!locala.a.auG())) {
          break label105;
        }
        bool1 = true;
      }
    }
    for (;;)
    {
      locala.YM(bool1);
      break;
      label105:
      bool1 = false;
      continue;
      return;
      label111:
      bool2 = false;
      break label66;
      label116:
      bool1 = false;
    }
  }
  
  public int getCount()
  {
    return this.mData.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.mData.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool3 = false;
    if ((this.Eo <= 0.0F) && (paramViewGroup != null))
    {
      this.Eo = paramViewGroup.getMeasuredWidth();
      if (this.dvN) {
        this.qT = ((this.Eo - paramViewGroup.getPaddingLeft() - paramViewGroup.getPaddingRight()) / 3.2F + 0.5F);
      }
    }
    else
    {
      if (paramView != null) {
        break label493;
      }
      paramView = cL();
    }
    label493:
    for (;;)
    {
      if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof axpg.a)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TransitionProviderGridAdapter", 2, "ConvertViewTag null");
        }
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        this.qT = ((this.Eo - paramViewGroup.getPaddingLeft() - paramViewGroup.getPaddingRight()) / 4.0F + 0.5F);
        break;
      }
      axpg.a locala = (axpg.a)paramView.getTag();
      TextView localTextView = locala.ahv;
      URLImageView localURLImageView = locala.p;
      TransitionCategoryItem localTransitionCategoryItem = (TransitionCategoryItem)this.mData.get(paramInt);
      locala.a = localTransitionCategoryItem;
      Object localObject = ayva.a().a();
      if (localObject != null) {}
      for (boolean bool1 = TextUtils.equals(((QIMFilterCategoryItem)localObject).id, localTransitionCategoryItem.id);; bool1 = false) {
        for (;;)
        {
          boolean bool2 = bool1;
          if (!bool1)
          {
            if (localObject != null)
            {
              bool1 = bool3;
              if (!((QIMFilterCategoryItem)localObject).auG()) {}
            }
            else
            {
              bool1 = bool3;
              if (localTransitionCategoryItem.auG()) {
                bool1 = true;
              }
            }
            bool2 = bool1;
          }
          AbsListView.LayoutParams localLayoutParams = (AbsListView.LayoutParams)paramView.getLayoutParams();
          localObject = localLayoutParams;
          if (localLayoutParams == null)
          {
            localObject = new AbsListView.LayoutParams(-1, -1);
            paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          ((AbsListView.LayoutParams)localObject).height = ((int)this.qT);
          locala.YM(bool2);
          try
          {
            q(localURLImageView, localTransitionCategoryItem.apngUrl);
            localTextView.setText(localTransitionCategoryItem.name);
            paramView.setFocusable(true);
            paramView.setFocusableInTouchMode(true);
            paramView.setContentDescription(localTransitionCategoryItem.name + acfp.m(2131715430));
          }
          catch (Error localError)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("TransitionProviderGridAdapter", 2, "setApngURLDrawable " + localError.toString());
              }
              p(localURLImageView, localTransitionCategoryItem.iconUrl);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("TransitionProviderGridAdapter", 2, "setApngURLDrawable " + localException.toString());
              }
              p(localURLImageView, localTransitionCategoryItem.iconUrl);
            }
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TransitionProviderGridAdapter", 2, "onDestroy");
    }
    this.dgm = true;
    this.FO.clear();
  }
  
  public void setData(List<QIMFilterCategoryItem> paramList)
  {
    this.mData = paramList;
  }
  
  public static class a
  {
    View MP;
    TransitionCategoryItem a;
    TextView ahv;
    boolean dvN = false;
    URLImageView p;
    
    public void YM(boolean paramBoolean)
    {
      if ((this.MP != null) && (this.a != null))
      {
        if (!paramBoolean) {
          break label45;
        }
        if (this.dvN) {
          this.MP.setBackgroundResource(2130845304);
        }
      }
      else
      {
        return;
      }
      this.MP.setBackgroundResource(2130845337);
      return;
      label45:
      if (this.dvN)
      {
        this.MP.setBackgroundResource(0);
        return;
      }
      this.MP.setBackgroundResource(2130845334);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axpg
 * JD-Core Version:    0.7.0.1
 */