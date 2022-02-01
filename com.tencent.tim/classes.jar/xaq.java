import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.CommonHobbyForAIOShowItemBuilder.3;
import com.tencent.mobileqq.activity.aio.item.CommonHobbyForAIOShowItemBuilder.4;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.QQPlayerService.c;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import org.json.JSONException;
import org.json.JSONObject;

public class xaq
  extends wjd
  implements QQPlayerService.c
{
  private long IO;
  private View.OnClickListener dO = new xar(this);
  private View.OnClickListener dP = new xas(this);
  private WeakReference<ImageView> ef;
  private float mDensity = this.mContext.getResources().getDisplayMetrics().density;
  
  public xaq(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  private void a(long paramLong, int paramInt, ImageView paramImageView1, ImageView paramImageView2, boolean paramBoolean)
  {
    Object localObject;
    boolean bool;
    if (paramInt != 1)
    {
      paramImageView1.setVisibility(8);
      localObject = (RelativeLayout.LayoutParams)paramImageView2.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      paramImageView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramImageView2.setImageDrawable(aqdj.a(this.app, 1, String.valueOf(paramLong)));
      bool = anlm.ayn();
      if (!paramBoolean) {
        break label144;
      }
      if (!bool) {
        break label138;
      }
    }
    label138:
    for (paramInt = 2130845860;; paramInt = 2130845859)
    {
      paramImageView1.setBackgroundResource(paramInt);
      paramImageView2.setBackgroundResource(paramInt);
      return;
      localObject = aqdj.a(this.app, 1, this.app.getCurrentUin());
      aqdj localaqdj = aqdj.a(this.app, 1, String.valueOf(paramLong));
      paramImageView1.setImageDrawable((Drawable)localObject);
      paramImageView2.setImageDrawable(localaqdj);
      break;
    }
    label144:
    if (bool) {}
    for (paramInt = 2130845858;; paramInt = 2130845857)
    {
      paramImageView1.setBackgroundResource(paramInt);
      paramImageView2.setBackgroundResource(paramInt);
      return;
    }
  }
  
  private void b(boolean paramBoolean, TextView paramTextView)
  {
    if (!paramBoolean)
    {
      paramTextView.setTextColor(-14277082);
      return;
    }
    paramTextView.setTextColor(this.mContext.getResources().getColor(2131167311));
  }
  
  @NonNull
  private Drawable getIconDrawable(String paramString)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(this.mContext.getResources().getColor(2131166111));
    float f = 8.0F * this.mDensity;
    localGradientDrawable.setCornerRadius(f);
    localGradientDrawable.setShape(0);
    int i = wja.dp2px(35.0F, this.mContext.getResources());
    localGradientDrawable.setSize(i, i);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = i;
    localURLDrawableOptions.mRequestHeight = i;
    localURLDrawableOptions.mFailedDrawable = localGradientDrawable;
    localURLDrawableOptions.mLoadingDrawable = localURLDrawableOptions.mFailedDrawable;
    String str = null;
    try
    {
      paramString = URLDrawable.getDrawable(aomc.l(paramString), localURLDrawableOptions);
      str = paramString;
      paramString.setTag(aqbn.d(i, i, (int)f));
      str = paramString;
      paramString.setDecodeHandler(aqbn.d);
    }
    catch (MalformedURLException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("CommonHobbyForAIOShowItemBuilder", 0, Log.getStackTraceString(paramString));
        }
        paramString = str;
      }
    }
    if (paramString == null) {
      return localGradientDrawable;
    }
    return paramString;
  }
  
  private void m(View paramView, String paramString)
    throws JSONException
  {
    Object localObject2 = new JSONObject(paramString);
    int i = ((JSONObject)localObject2).optInt("type");
    String str1 = ((JSONObject)localObject2).optString("icon_url");
    paramString = ((JSONObject)localObject2).optString("jump_url");
    Object localObject1 = ((JSONObject)localObject2).optString("name");
    String str2 = ((JSONObject)localObject2).optString("sub_title");
    Object localObject3 = ((JSONObject)localObject2).optString("title");
    ((JSONObject)localObject2).optString("url");
    long l = ((JSONObject)localObject2).optLong("friend_uin");
    int j = ((JSONObject)localObject2).optInt("show_both_head");
    Object localObject4 = paramView.findViewById(2131370213);
    ((View)localObject4).getLayoutParams().width = this.mContext.getResources().getDisplayMetrics().widthPixels;
    Object localObject5 = (ImageView)((View)localObject4).findViewById(2131369105);
    ImageView localImageView = (ImageView)((View)localObject4).findViewById(2131369106);
    ((TextView)((View)localObject4).findViewById(2131381137)).setText((CharSequence)localObject3);
    boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    a(l, j, (ImageView)localObject5, localImageView, bool);
    if ((i == 1) || (i == 500) || (i == 400) || (i == 401) || (i == 404) || (i == 402) || (i == 403))
    {
      paramView = ((ViewStub)paramView.findViewById(2131381992)).inflate();
      localObject2 = (TextView)paramView.findViewById(2131381134);
      ((TextView)localObject2).setText((CharSequence)localObject1);
      paramView.setTag(paramString);
      paramView.setOnClickListener(this.dP);
      b(bool, (TextView)localObject2);
      return;
    }
    if ((i == 100) || (i == 200) || (i == 300) || (i == 201))
    {
      paramView = ((ViewStub)paramView.findViewById(2131381990)).inflate();
      localObject3 = (URLImageView)paramView.findViewById(2131369107);
      localObject4 = (TextView)paramView.findViewById(2131381136);
      localObject5 = (TextView)paramView.findViewById(2131381135);
      ((TextView)localObject4).setText((CharSequence)localObject1);
      if (TextUtils.isEmpty(str2))
      {
        ((TextView)localObject5).setVisibility(8);
        ((URLImageView)localObject3).setImageDrawable(getIconDrawable(str1));
        if (i != 100) {
          break label497;
        }
        localObject1 = (ImageView)paramView.findViewById(2131369110);
        ((ImageView)localObject1).setVisibility(0);
        this.ef = new WeakReference(localObject1);
        ((URLImageView)localObject3).setTag(localObject2);
        ((ImageView)localObject1).setTag(localObject2);
        ((URLImageView)localObject3).setOnClickListener(this.dO);
        ((ImageView)localObject1).setOnClickListener(this.dO);
      }
      for (;;)
      {
        paramView.setTag(paramString);
        b(bool, (TextView)localObject4);
        return;
        ((TextView)localObject5).setText(str2);
        break;
        label497:
        if ((i == 201) || (i == 200)) {
          paramView.setOnClickListener(this.dP);
        }
      }
    }
    ((TextView)((ViewStub)paramView.findViewById(2131381992)).inflate().findViewById(2131381134)).setText(acfp.m(2131704218));
  }
  
  private void xU(String paramString)
  {
    Intent localIntent = new Intent(this.mContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    this.mContext.startActivity(localIntent);
  }
  
  protected View a(MessageRecord paramMessageRecord, wjd.a parama, View paramView, LinearLayout paramLinearLayout, wlz paramwlz)
  {
    parama = paramView;
    if (paramView == null)
    {
      parama = LayoutInflater.from(this.mContext).inflate(2131561263, null);
      if (QLog.isColorLevel()) {
        QLog.i("CommonHobbyForAIOShowItemBuilder", 0, String.format("bindData2View msg is: %s", new Object[] { paramMessageRecord.msg }));
      }
    }
    try
    {
      m(parama, paramMessageRecord.msg);
      this.IO = paramMessageRecord.uniseq;
      return parama;
    }
    catch (JSONException paramView)
    {
      for (;;)
      {
        QLog.e("CommonHobbyForAIOShowItemBuilder", 1, "getItemView JSONException", paramView);
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        QLog.e("CommonHobbyForAIOShowItemBuilder", 1, "getItemView Exception", paramView);
      }
    }
  }
  
  protected wjd.a a()
  {
    return new xaq.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public aqob[] a(View paramView)
  {
    return new aqob[0];
  }
  
  public String getToken()
  {
    return QQPlayerService.I(1, String.valueOf(this.IO));
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo) {}
  
  public void onPlayStateChanged(int paramInt)
  {
    if ((this.ef == null) || (this.ef.get() == null)) {}
    ImageView localImageView;
    do
    {
      return;
      localImageView = (ImageView)this.ef.get();
    } while (localImageView == null);
    Resources localResources = localImageView.getContext().getResources();
    if ((paramInt == 2) || (paramInt == 1))
    {
      localImageView.post(new CommonHobbyForAIOShowItemBuilder.3(this, localImageView));
      localImageView.setContentDescription(localResources.getString(2131690640));
      return;
    }
    localImageView.post(new CommonHobbyForAIOShowItemBuilder.4(this, localImageView));
    localImageView.setContentDescription(localResources.getString(2131690638));
  }
  
  public static final class a
    extends wjd.a
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xaq
 * JD-Core Version:    0.7.0.1
 */