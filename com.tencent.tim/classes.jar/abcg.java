import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.tim.timme.MeListAdapter.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.widget.GridListView.b;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class abcg
  extends GridListView.b
{
  private auoi a;
  private QQAppInterface app;
  private adyp b;
  private Context context;
  private List<aunr> data = new ArrayList();
  private View.OnClickListener onClickListener;
  
  public abcg(Context paramContext, QQAppInterface paramQQAppInterface, View.OnClickListener paramOnClickListener)
  {
    this.context = paramContext;
    this.app = paramQQAppInterface;
    this.onClickListener = paramOnClickListener;
    this.a = ((auoi)paramQQAppInterface.getManager(376));
    this.b = ((adyp)paramQQAppInterface.getManager(112));
  }
  
  private void a(View paramView, aunr paramaunr)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(2131373417);
    if ((paramaunr != null) && (paramaunr.icon != null)) {
      paramView = paramaunr.icon;
    }
    for (;;)
    {
      paramaunr = paramView;
      if (paramView == null) {
        paramaunr = this.context.getResources().getDrawable(2130846238);
      }
      localImageView.setImageDrawable(paramaunr);
      return;
      if ((paramaunr != null) && (paramaunr.c != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MeListAdapter", 2, "item.icon == null, info=" + paramaunr.c.strResName);
        }
        paramView = auns.b(this.context, paramaunr.c.strPkgName, paramaunr.c.strResURL);
        if (paramView != null)
        {
          Object localObject = "LebaIcon://" + paramView.getAbsolutePath();
          Bitmap localBitmap = (Bitmap)BaseApplicationImpl.sImageCache.get(localObject);
          if (localBitmap != null)
          {
            paramaunr.icon = new BitmapDrawable(localBitmap);
            localObject = paramaunr.icon;
            paramView = (View)localObject;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("MeListAdapter", 2, "found bitmap from cache, info=" + paramaunr.c.strResName);
            paramView = (View)localObject;
            continue;
          }
          ThreadManager.post(new MeListAdapter.1(this, paramView, paramaunr, (String)localObject, localImageView), 5, null, true);
        }
      }
      paramView = null;
    }
  }
  
  private void a(ImageView paramImageView, aunr paramaunr)
  {
    paramaunr = paramaunr.fV;
    if ((paramaunr instanceof Boolean)) {}
    for (boolean bool = ((Boolean)paramaunr).booleanValue();; bool = false)
    {
      if (bool)
      {
        paramImageView.setVisibility(0);
        return;
      }
      paramImageView.setVisibility(8);
      return;
    }
  }
  
  private void b(View paramView, aunr paramaunr)
  {
    if ((paramaunr != null) && (paramaunr.c != null)) {
      ((TextView)paramView.findViewById(2131373422)).setText(paramaunr.c.strResName);
    }
  }
  
  private void c(View paramView, aunr paramaunr)
  {
    String str;
    int i;
    if ((paramaunr != null) && (paramaunr.c != null))
    {
      str = paramaunr.c.strResSimpleDesc;
      if (!"PKG_TODOLIST".equals(paramaunr.c.strPkgName)) {
        break label92;
      }
      i = this.a.et().size();
      if (i > 0) {
        str = this.app.getApp().getString(2131695254, new Object[] { Integer.valueOf(i) });
      }
      paramaunr = str;
    }
    for (;;)
    {
      ((TextView)paramView.findViewById(2131373424)).setText(paramaunr);
      return;
      label92:
      if ("PKG_EMAIL".equals(paramaunr.c.strPkgName))
      {
        i = this.app.a().A(acbn.bnN, 8001);
        if (i > 0) {
          str = this.app.getApp().getString(2131695236, new Object[] { Integer.valueOf(i) });
        }
        paramaunr = str;
      }
      else
      {
        if ("PKG_BUSINESS_CARD".equals(paramaunr.c.strPkgName))
        {
          i = this.b.cO().size();
          if (i > 0)
          {
            paramaunr = this.app.getApp().getString(2131695217, new Object[] { Integer.valueOf(i) });
            continue;
          }
        }
        paramaunr = str;
      }
    }
  }
  
  private void d(View paramView, aunr paramaunr)
  {
    paramView = (ImageView)paramView.findViewById(2131373423);
    if (paramaunr.c.uiResId == 24L)
    {
      a(paramView, paramaunr);
      return;
    }
    paramView.setVisibility(8);
  }
  
  public void bQ(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  public int fT(int paramInt)
  {
    return 0;
  }
  
  public int fU(int paramInt)
  {
    return 0;
  }
  
  public int getCount()
  {
    if (this.data == null) {
      return 0;
    }
    return this.data.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.data == null) || (paramInt >= this.data.size()) || (paramInt < 0)) {
      return null;
    }
    return (aunr)this.data.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    aunr localaunr = (aunr)getItem(paramInt);
    if (localaunr == null) {
      return 1;
    }
    if (TextUtils.isEmpty(localaunr.bCo)) {}
    for (paramInt = 0;; paramInt = 1) {
      return paramInt;
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    aunr localaunr = (aunr)getItem(paramInt);
    if (paramView == null) {
      paramView = LayoutInflater.from(this.context).inflate(2131559528, null);
    }
    for (;;)
    {
      a(paramView, localaunr);
      b(paramView, localaunr);
      c(paramView, localaunr);
      d(paramView, localaunr);
      View localView = paramView.findViewById(2131365374);
      localView.setOnClickListener(this.onClickListener);
      localView.setTag(localaunr);
      localView.setTag(-1, Integer.valueOf(paramInt));
      if ((AppSetting.enableTalkBack) && (localaunr.c != null) && (!TextUtils.isEmpty(localaunr.c.strResName))) {
        localView.setContentDescription(localaunr.c.strResName + "按钮");
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 4;
  }
  
  public void hN(List<aunr> paramList)
  {
    if (paramList != null)
    {
      Iterator localIterator1 = this.data.iterator();
      while (localIterator1.hasNext())
      {
        aunr localaunr1 = (aunr)localIterator1.next();
        if ((localaunr1 != null) && (localaunr1.icon != null) && (localaunr1.c != null))
        {
          Iterator localIterator2 = paramList.iterator();
          while (localIterator2.hasNext())
          {
            aunr localaunr2 = (aunr)localIterator2.next();
            if ((localaunr2 != null) && (localaunr2.c != null) && (localaunr2.c.strPkgName.equals(localaunr1.c.strPkgName))) {
              localaunr2.icon = localaunr1.icon;
            }
          }
        }
      }
    }
    this.data.clear();
    if (paramList != null)
    {
      this.data.addAll(paramList);
      if ((getItemViewType(0) == 1) && (this.data != null) && (this.data.size() > 0)) {
        this.data.remove(0);
      }
    }
    notifyDataSetChanged();
  }
  
  public int zu()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abcg
 * JD-Core Version:    0.7.0.1
 */