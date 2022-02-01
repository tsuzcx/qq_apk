import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class afll
  extends BaseAdapter
{
  public static final String TAG = BaseAdapter.class.getSimpleName();
  public int TL;
  public afoo a;
  protected EmotionPanelListView a;
  public int ahx;
  public QQAppInterface app;
  protected int cRT;
  protected List<afom> data = Collections.emptyList();
  protected float density;
  protected afmf f;
  protected Map<Integer, ArrayList<View>> kk;
  protected Context mContext;
  protected int panelType;
  public int widthPixels;
  protected List<afom> zS = new ArrayList();
  protected List<afom> zT = new ArrayList();
  
  public afll(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, afmf paramafmf)
  {
    this.app = paramQQAppInterface;
    this.mContext = paramContext;
    this.TL = paramInt1;
    this.panelType = paramInt2;
    this.ahx = paramInt3;
    this.f = paramafmf;
    this.kk = new ConcurrentHashMap();
    this.cRT = paramContext.getResources().getColor(2131166787);
    this.density = paramContext.getResources().getDisplayMetrics().density;
  }
  
  public abstract afll.a a();
  
  public abstract View a(afll.a parama, int paramInt, View paramView, ViewGroup paramViewGroup);
  
  public EmoticonPackage a()
  {
    return null;
  }
  
  public EmotionPanelListView a()
  {
    return this.a;
  }
  
  public void a(View paramView, afom paramafom)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "updateBigEmotionContentViewData");
    }
    if ((paramView != null) && (paramafom != null))
    {
      paramView.setVisibility(0);
      localObject1 = null;
      if ((paramafom instanceof afmi)) {
        localObject1 = (afmi)paramafom;
      }
      if (localObject1 != null) {
        break label59;
      }
      QLog.e(TAG, 1, "emotionInfo = null");
    }
    label59:
    Object localObject2;
    do
    {
      return;
      paramView.setTag(localObject1);
      paramafom = (URLImageView)paramView.findViewById(2131366331);
      long l = System.currentTimeMillis();
      localObject2 = ((afmi)localObject1).b(this.mContext, this.density);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "getDrawable cost = " + (System.currentTimeMillis() - l));
      }
      paramafom.setImageDrawable((Drawable)localObject2);
      paramafom.setVisibility(0);
    } while (!(localObject1 instanceof afpu));
    paramafom = (afpu)localObject1;
    Object localObject1 = (TextView)paramView.findViewById(2131366336);
    if (paramafom.e != null)
    {
      localObject2 = paramafom.e.name;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label281;
      }
      ((TextView)localObject1).setVisibility(0);
      if (((String)localObject2).length() > 5) {
        ((TextView)localObject1).setText(((String)localObject2).substring(0, 4) + "...");
      }
    }
    else
    {
      paramView = (ImageView)paramView.findViewById(2131366337);
      if (!paramafom.ajH()) {
        break label300;
      }
      if (!paramafom.isNewSoundType()) {
        break label291;
      }
      paramView.setImageResource(2130838382);
    }
    for (;;)
    {
      paramView.setVisibility(0);
      return;
      ((TextView)localObject1).setText((CharSequence)localObject2);
      break;
      label281:
      ((TextView)localObject1).setVisibility(8);
      break;
      label291:
      paramView.setImageResource(2130851432);
    }
    label300:
    paramView.setVisibility(4);
  }
  
  public void a(EmotionPanelListView paramEmotionPanelListView)
  {
    this.a = paramEmotionPanelListView;
  }
  
  public void dag() {}
  
  public void dah() {}
  
  public void destory()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "destory");
    }
    if (this.kk.size() > 0)
    {
      Iterator localIterator = this.kk.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        int j = ((Integer)((Map.Entry)localObject).getKey()).intValue();
        localObject = (ArrayList)((Map.Entry)localObject).getValue();
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          int i = 0;
          while (i < ((ArrayList)localObject).size())
          {
            View localView = (View)((ArrayList)localObject).get(i);
            if (localView.getParent() != null) {
              ((ViewGroup)localView.getParent()).removeView(localView);
            }
            localView.setTag(null);
            if ((localView instanceof EmoticonPanelLinearLayout)) {
              ((EmoticonPanelLinearLayout)localView).setCallBack(null);
            }
            Integer localInteger = (Integer)localView.getTag(2131366379);
            if (afos.widthPixels == localInteger.intValue()) {
              afos.a().t(j, localView);
            }
            i += 1;
          }
        }
      }
    }
    this.kk.clear();
    this.a = null;
    if (this.f != null) {
      this.f = null;
    }
  }
  
  public int getCount()
  {
    if (this.data != null)
    {
      int k = this.data.size();
      int j = k / this.TL;
      int i = j;
      if (k % this.TL > 0) {
        i = j + 1;
      }
      return i;
    }
    QLog.e(TAG, 1, "get count len = 0");
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {}
    for (Object localObject = a();; localObject = (afll.a)paramView.getTag())
    {
      localObject = a((afll.a)localObject, paramInt, paramView, paramViewGroup);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
  }
  
  public RelativeLayout m()
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "getEmotionLayout");
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
    localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(this.widthPixels / this.TL, (int)(72.0F * this.density)));
    try
    {
      Object localObject1 = new TextView(this.mContext);
      if (localObject1 != null)
      {
        ((TextView)localObject1).setVisibility(8);
        ((TextView)localObject1).setId(2131366336);
        ((TextView)localObject1).setTextColor(this.cRT);
        ((TextView)localObject1).setTextSize(11.0F);
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.addRule(12);
        localLayoutParams.topMargin = ((int)(5.0F * this.density));
        ((TextView)localObject1).setGravity(17);
        localRelativeLayout.addView((View)localObject1, localLayoutParams);
      }
      localObject1 = new URLImageView(this.mContext);
      ((URLImageView)localObject1).setId(2131366331);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.density * 56.0F), (int)(this.density * 56.0F));
      localLayoutParams.addRule(13, -1);
      localLayoutParams.addRule(2, 2131366336);
      localLayoutParams.addRule(14);
      ((URLImageView)localObject1).setVisibility(8);
      ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
      ((URLImageView)localObject1).setAdjustViewBounds(false);
      localRelativeLayout.addView((View)localObject1, localLayoutParams);
      localObject1 = new ImageView(this.mContext);
      ((ImageView)localObject1).setVisibility(8);
      ((ImageView)localObject1).setId(2131366337);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(7, 2131366331);
      localLayoutParams.addRule(8, 2131366331);
      localRelativeLayout.addView((View)localObject1, localLayoutParams);
      if (AppSetting.enableTalkBack) {
        localRelativeLayout.setFocusable(true);
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "getEmotionlayout cost = " + (System.currentTimeMillis() - l));
      }
      return localRelativeLayout;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
  }
  
  public void recycleView(int paramInt, View paramView)
  {
    if (paramView == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "recycleView viewType = " + paramInt);
      }
      paramView.setTag(2131366379, Integer.valueOf(this.widthPixels));
      localArrayList = (ArrayList)this.kk.get(Integer.valueOf(paramInt));
      if (localArrayList == null)
      {
        localArrayList = new ArrayList();
        localArrayList.add(paramView);
        this.kk.put(Integer.valueOf(paramInt), localArrayList);
        return;
      }
    } while (localArrayList.contains(paramView));
    localArrayList.add(paramView);
  }
  
  public void setData(List<afom> paramList)
  {
    this.data = paramList;
    super.notifyDataSetChanged();
  }
  
  public static class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afll
 * JD-Core Version:    0.7.0.1
 */