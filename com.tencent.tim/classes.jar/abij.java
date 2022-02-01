import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder.a;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.Comparator;
import java.util.List;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class abij
  implements abrp, Manager
{
  TextView PG;
  abij.b a;
  FrameLayout bn;
  View.OnClickListener eN = new abik(this);
  WeakReference<BaseChatPie> fj;
  public QQAppInterface mApp;
  Comparator<ApolloActionData> mComparator = new abil(this);
  String mSenderUin;
  int mSessionType = 0;
  ListView u;
  
  public abij(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  int a(ApolloActionData paramApolloActionData)
  {
    switch (paramApolloActionData.feeType)
    {
    case 8: 
    default: 
      return 1;
    case 6: 
      return 4;
    case 7: 
      return 3;
    }
    return 2;
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam, long paramLong)
  {
    if (this.mApp == null) {}
    int i;
    ApolloActionData localApolloActionData;
    MqqHandler localMqqHandler;
    do
    {
      do
      {
        return;
        i = paramSpriteTaskParam.mActionId;
        localApolloActionData = ((abxk)this.mApp.getManager(155)).b(i);
      } while ((localApolloActionData == null) || ((localApolloActionData.pkIds == null) && (localApolloActionData.pk3DIds == null)) || (paramSpriteTaskParam.mIsSend) || (paramSpriteTaskParam.crd != 1));
      localMqqHandler = this.mApp.getHandler(ChatActivity.class);
    } while (localMqqHandler == null);
    localMqqHandler.removeMessages(82);
    localMqqHandler.removeMessages(83);
    Message localMessage = localMqqHandler.obtainMessage();
    localMessage.what = 82;
    localMessage.obj = localApolloActionData;
    localMessage.arg1 = i;
    localMessage.getData().putString("senderUin", paramSpriteTaskParam.mSenderUin);
    localMqqHandler.sendMessageDelayed(localMessage, 500L);
    localMqqHandler.sendEmptyMessageDelayed(83, 4000L);
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam, long paramLong, int paramInt) {}
  
  public void cCc()
  {
    this.fj = null;
    if (this.u != null)
    {
      if (this.u.getParent() != null) {
        ((ViewGroup)this.u.getParent()).removeView(this.u);
      }
      this.u.setAdapter(null);
      this.u = null;
      this.a = null;
    }
    this.bn = null;
    this.PG = null;
  }
  
  public void onDestroy()
  {
    this.fj = null;
    this.a = null;
    this.u = null;
    this.bn = null;
    this.PG = null;
  }
  
  class a
  {
    URLImageView aw;
    View divider;
    TextView text;
    
    a() {}
  }
  
  class b
    extends BaseAdapter
  {
    List<Integer> actions;
    int coZ;
    Context mContext;
    
    public int getCount()
    {
      return this.actions.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.actions.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject3 = this.mContext.getResources();
      int i = ((Integer)getItem(paramInt)).intValue();
      Object localObject1;
      Object localObject2;
      Object localObject4;
      if (paramView == null)
      {
        paramView = new abij.a(this.a);
        localObject1 = new LinearLayout(this.mContext);
        ((LinearLayout)localObject1).setOrientation(1);
        localObject2 = new LinearLayout(this.mContext);
        ((LinearLayout)localObject2).setBackgroundResource(2130838689);
        ((LinearLayout)localObject2).setOrientation(0);
        localObject4 = new URLImageView(this.mContext);
        int j = wja.dp2px(28.0F, (Resources)localObject3);
        Object localObject5 = new LinearLayout.LayoutParams(j, j);
        ((LinearLayout.LayoutParams)localObject5).leftMargin = wja.dp2px(2.2F, (Resources)localObject3);
        ((LinearLayout.LayoutParams)localObject5).gravity = 16;
        ((LinearLayout)localObject2).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
        localObject5 = new TextView(this.mContext);
        ((TextView)localObject5).setTextSize(11.0F);
        ((TextView)localObject5).setMaxLines(1);
        ((TextView)localObject5).setIncludeFontPadding(false);
        ((TextView)localObject5).setGravity(1);
        ((TextView)localObject5).setTextColor(((Resources)localObject3).getColor(2131167311));
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.gravity = 16;
        ((LinearLayout)localObject2).addView((View)localObject5, localLayoutParams);
        paramView.aw = ((URLImageView)localObject4);
        paramView.text = ((TextView)localObject5);
        localObject4 = new View(this.mContext);
        paramView.divider = ((View)localObject4);
        ((LinearLayout)localObject1).addView((View)localObject2);
        ((LinearLayout)localObject1).addView((View)localObject4);
        ((View)localObject1).setTag(paramView);
      }
      for (;;)
      {
        ((View)localObject1).setTag(2131362812, Integer.valueOf(i));
        ((View)localObject1).setTag(2131362813, Integer.valueOf(this.coZ));
        localObject2 = paramView.divider;
        float f;
        if (paramInt == this.actions.size() - 1)
        {
          f = 8.0F;
          label335:
          ((View)localObject2).setMinimumHeight(wja.dp2px(f, (Resources)localObject3));
        }
        try
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Resources)localObject3).getDrawable(2130838625);
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Resources)localObject3).getDrawable(2130838627);
          localObject3 = new URL("apollo_gif", "", String.valueOf(i));
          localObject4 = new File(ApolloItemBuilder.a.cD(i));
          paramView.aw.setTag(Integer.valueOf(i));
          if (((File)localObject4).exists())
          {
            localObject2 = URLDrawable.getDrawable((File)localObject4, (URLDrawable.URLDrawableOptions)localObject2);
            paramView.aw.setImageDrawable((Drawable)localObject2);
          }
          for (;;)
          {
            label452:
            localObject2 = ((abxk)this.a.mApp.getManager(155)).a(i);
            if (localObject2 != null)
            {
              localObject2 = ((ApolloActionData)localObject2).actionName;
              paramView.text.setText((CharSequence)localObject2);
            }
            ((View)localObject1).setOnClickListener(this.a.eN);
            EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
            return localObject1;
            localObject2 = (abij.a)paramView.getTag();
            localObject1 = paramView;
            paramView = (View)localObject2;
            break;
            f = 5.0F;
            break label335;
            localObject2 = URLDrawable.getDrawable((URL)localObject3, (URLDrawable.URLDrawableOptions)localObject2);
            ((URLDrawable)localObject2).setTag(Integer.valueOf(i));
            paramView.aw.setImageDrawable((Drawable)localObject2);
          }
        }
        catch (Throwable localThrowable)
        {
          break label452;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abij
 * JD-Core Version:    0.7.0.1
 */