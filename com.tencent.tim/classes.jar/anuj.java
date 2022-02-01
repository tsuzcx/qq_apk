import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.widget.BubbleViewLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class anuj
  extends antd
{
  String TAG = "StructMsgItemLayoutNew2";
  String mCoverUrl = "";
  String mSummary = "";
  String mTitle = "";
  private URLDrawableDownListener.Adapter mUrlAdapter = new anuk(this);
  
  private String az(String paramString, int paramInt)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    String str = "";
    int n = paramString.length();
    int k = 0;
    if ((i < n) && (k < paramInt))
    {
      int j = paramString.codePointAt(i);
      int m;
      if ((j > 65535) || (j == 20))
      {
        m = i;
        j = k;
        if (i + 1 < n)
        {
          str = paramString.substring(i, i + 2);
          if (k < paramInt - 1) {
            localStringBuilder.append(str);
          }
          m = i + 1;
          j = k + 1;
        }
      }
      for (;;)
      {
        i = m + 1;
        k = j;
        break;
        str = paramString.substring(i, i + 1);
        if (k < paramInt - 1) {
          localStringBuilder.append(str);
        }
        j = k + 1;
        m = i;
      }
    }
    if (k == paramInt)
    {
      if (i >= n) {
        break label188;
      }
      localStringBuilder.append(Html.fromHtml("&hellip;"));
    }
    for (;;)
    {
      return localStringBuilder.toString();
      label188:
      localStringBuilder.append(str);
    }
  }
  
  public static String getStructMsgInfo(AbsShareMsg paramAbsShareMsg, String paramString)
  {
    Object localObject2 = "";
    if (paramString.equals("cover"))
    {
      if (TextUtils.isEmpty(paramAbsShareMsg.mContentCover)) {
        break label77;
      }
      localObject1 = paramAbsShareMsg.mContentCover;
    }
    label77:
    do
    {
      do
      {
        do
        {
          return localObject1;
          if (paramString.equals("title"))
          {
            if (!TextUtils.isEmpty(paramAbsShareMsg.mContentTitle)) {
              return paramAbsShareMsg.mContentTitle;
            }
          }
          else if ((paramString.equals("summary")) && (!TextUtils.isEmpty(paramAbsShareMsg.mContentSummary))) {
            return paramAbsShareMsg.mContentSummary;
          }
          localObject1 = localObject2;
        } while (!(paramAbsShareMsg instanceof StructMsgForGeneralShare));
        paramAbsShareMsg = (StructMsgForGeneralShare)paramAbsShareMsg;
        localObject1 = localObject2;
      } while (paramAbsShareMsg.mStructMsgItemLists == null);
      localObject1 = localObject2;
    } while (paramAbsShareMsg.mStructMsgItemLists.isEmpty());
    Iterator localIterator = paramAbsShareMsg.mStructMsgItemLists.iterator();
    paramAbsShareMsg = (AbsShareMsg)localObject2;
    do
    {
      localObject1 = paramAbsShareMsg;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (anqu)localIterator.next();
    } while ((!(localObject1 instanceof anqv)) || (((anqv)localObject1).rz == null) || (((anqv)localObject1).rz.isEmpty()));
    Object localObject1 = ((anqv)localObject1).rz.iterator();
    label191:
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (anqu)((Iterator)localObject1).next();
      if ((paramString.equals("cover")) && ((localObject2 instanceof ansr)))
      {
        paramAbsShareMsg = StructMsgForGeneralShare.getCoverForChatHistory((anqu)localObject2);
        label231:
        if (TextUtils.isEmpty(paramAbsShareMsg)) {
          break label295;
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramAbsShareMsg))
      {
        return paramAbsShareMsg;
        if ((paramString.equals("title")) && ((localObject2 instanceof StructMsgItemTitle)))
        {
          paramAbsShareMsg = StructMsgForGeneralShare.getTitleForChatHistory((anqu)localObject2);
          break label231;
        }
        if ((!paramString.equals("summary")) || (!(localObject2 instanceof anux))) {
          break label301;
        }
        paramAbsShareMsg = StructMsgForGeneralShare.getSummary((anqu)localObject2);
        break label231;
        label295:
        break label191;
      }
      break;
      label301:
      break label231;
    }
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject = new anuj.b();
    Resources localResources = paramContext.getResources();
    View localView;
    int i;
    label122:
    int j;
    if ((paramView != null) && ((paramView instanceof RelativeLayout)) && (paramView.findViewById(2131364052) != null) && ((paramView.getTag() instanceof anuj.b)))
    {
      localObject = (anuj.b)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      initData();
      boolean bool = paramBundle.getBoolean("isSend", true);
      paramBundle = (BubbleViewLayout)localView.findViewById(2131364052);
      i = 19;
      if ((this.e.mMsgServiceID != 114) && (this.e.mMsgServiceID != 116)) {
        break label909;
      }
      paramBundle.TE(false);
      i = 9;
      paramBundle.mIsSend = bool;
      if ((this.e == null) || (this.e.mMsgServiceID == 151) || (this.e.mMsgServiceID == 156) || (TextUtils.isEmpty(this.e.mMsgActionData))) {
        break label917;
      }
      j = 1;
      label177:
      if (!bool) {
        break label934;
      }
      paramView.title.setPadding(wja.dp2px(9.0F, localResources), 0, wja.dp2px(i, localResources), 0);
      paramView.B.setPadding(wja.dp2px(9.0F, localResources), wja.dp2px(3.0F, localResources), wja.dp2px(i, localResources), 0);
      paramBundle = (ViewGroup.MarginLayoutParams)paramView.lZ.getLayoutParams();
      if (j == 0) {
        break label923;
      }
      paramBundle.setMargins(wja.dp2px(18.0F, localResources), 0, 0, 0);
      ((RelativeLayout.LayoutParams)paramView.mb.getLayoutParams()).addRule(9);
      paramBundle = (RelativeLayout.LayoutParams)paramView.kG.getLayoutParams();
      paramBundle.addRule(9);
      paramBundle.setMargins(wja.dp2px(18.0F, localResources), 0, 0, 0);
      paramView.kG.setPadding(wja.dp2px(19.5F, localResources), 0, wja.dp2px(10.0F, localResources), 0);
      label337:
      paramBundle = localResources.getDrawable(2130851465);
      if (TextUtils.isEmpty(this.mCoverUrl)) {
        break label1188;
      }
    }
    try
    {
      localObject = URLDrawable.getDrawable(new URL(this.mCoverUrl), wja.dp2px(249.0F, localResources), wja.dp2px(139.0F, localResources), paramBundle, paramBundle, true);
      paramView.d.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 2)) {
        ((URLDrawable)localObject).restartDownload();
      }
      if ((localObject == null) || (((URLDrawable)localObject).getStatus() != 1)) {
        break label1103;
      }
      paramView.d.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramView.d.setBackgroundDrawable(null);
      label452:
      paramView.d.setImageDrawable((Drawable)localObject);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        label461:
        label1103:
        if (QLog.isColorLevel()) {
          QLog.e(this.TAG, 2, "getView, error: " + localMalformedURLException.getMessage());
        }
        label514:
        label909:
        label917:
        label923:
        label934:
        paramView.d.setImageDrawable(paramBundle);
        paramView.d.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      }
    }
    if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi"))
    {
      this.mTitle += "  ";
      paramView.title.setText(Html.fromHtml(this.mTitle));
      if ((this.mSummary == null) || (TextUtils.isEmpty(this.mSummary.trim())) || (this.mSummary.trim().equals(""))) {
        break label1223;
      }
      paramView.B.setVisibility(0);
      paramView.B.setText(this.mSummary);
    }
    for (;;)
    {
      if (j == 0) {
        break label1235;
      }
      i = (int)(BaseChatItemLayout.bOj * 0.8F) - wja.dp2px(19.5F, localResources) - wja.dp2px(10.0F, localResources) - wja.dp2px(13.0F, localResources);
      paramView.Zy.setMaxWidth(i);
      i /= wja.dp2px(14.0F, localResources);
      localObject = this.e.mMsgActionData;
      paramBundle = (Bundle)localObject;
      if (((String)localObject).length() > i) {
        paramBundle = az((String)localObject, i);
      }
      paramView.Zy.setText(new aofr(paramBundle, 3, 15));
      paramView.ma.setVisibility(0);
      paramContext = new anuj.a(paramContext, new String(this.e.mMsgActionData), this.e.mMsgUrl);
      paramView.mb.setOnClickListener(paramContext);
      paramView.kG.setOnClickListener(paramContext);
      return localView;
      localView = LayoutInflater.from(paramContext).inflate(2131559832, null);
      ((anuj.b)localObject).d = ((URLImageView)localView.findViewById(2131365477));
      ((anuj.b)localObject).title = ((TextView)localView.findViewById(2131379769));
      ((anuj.b)localObject).B = ((SingleLineTextView)localView.findViewById(2131379009));
      ((anuj.b)localObject).lZ = ((RelativeLayout)localView.findViewById(2131364052));
      ((anuj.b)localObject).ma = ((RelativeLayout)localView.findViewById(2131362357));
      ((anuj.b)localObject).kG = ((LinearLayout)localView.findViewById(2131364998));
      ((anuj.b)localObject).Zy = ((TextView)localView.findViewById(2131362356));
      ((anuj.b)localObject).mb = ((RelativeLayout)localView.findViewById(2131364103));
      ((anuj.b)localObject).DM = ((ImageView)localView.findViewById(2131364095));
      localView.setTag(localObject);
      paramView = (View)localObject;
      break;
      paramBundle.TE(true);
      break label122;
      j = 0;
      break label177;
      paramBundle.setMargins(0, 0, 0, 0);
      break label337;
      paramView.title.setPadding(wja.dp2px(i, localResources), 0, wja.dp2px(9.0F, localResources), 0);
      paramView.B.setPadding(wja.dp2px(i, localResources), wja.dp2px(3.0F, localResources), wja.dp2px(9.0F, localResources), 0);
      paramBundle = (ViewGroup.MarginLayoutParams)paramView.lZ.getLayoutParams();
      if (j != 0)
      {
        paramBundle.setMargins(0, 0, wja.dp2px(18.0F, localResources), 0);
        ((RelativeLayout.LayoutParams)paramView.mb.getLayoutParams()).addRule(11);
        paramBundle = (RelativeLayout.LayoutParams)paramView.kG.getLayoutParams();
        paramBundle.addRule(11);
        paramBundle.setMargins(0, 0, wja.dp2px(18.0F, localResources), 0);
        paramView.kG.setPadding(wja.dp2px(10.0F, localResources), 0, wja.dp2px(19.5F, localResources), 0);
        break label337;
      }
      paramBundle.setMargins(0, 0, 0, 0);
      break label337;
      paramView.d.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      paramView.d.setURLDrawableDownListener(this.mUrlAdapter);
      break label452;
      label1188:
      paramView.d.setImageDrawable(paramBundle);
      paramView.d.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      break label461;
      paramView.title.setText(this.mTitle);
      break label514;
      label1223:
      paramView.B.setVisibility(8);
    }
    label1235:
    paramView.ma.setVisibility(8);
    paramView.mb.setOnClickListener(null);
    paramView.kG.setOnClickListener(null);
    return localView;
  }
  
  void initData()
  {
    if ((this.e != null) && (this.e.message != null))
    {
      Object localObject = this.e.message;
      if ((localObject instanceof MessageForStructing))
      {
        localObject = (AbsShareMsg)anre.a(((MessageRecord)localObject).msgData);
        this.mTitle = getStructMsgInfo((AbsShareMsg)localObject, "title");
        this.mCoverUrl = getStructMsgInfo((AbsShareMsg)localObject, "cover");
        this.mSummary = getStructMsgInfo((AbsShareMsg)localObject, "summary");
      }
    }
  }
  
  class a
    implements View.OnClickListener
  {
    String cin = null;
    WeakReference<Context> mContext = null;
    String mUrl = null;
    
    public a(Context paramContext, String paramString1, String paramString2)
    {
      if (paramContext != null) {
        this.mContext = new WeakReference(paramContext);
      }
      if (!TextUtils.isEmpty(paramString1)) {
        this.cin = paramString1;
      }
      if (!TextUtils.isEmpty(paramString2)) {
        this.mUrl = paramString2;
      }
    }
    
    public void onClick(View paramView)
    {
      BaseChatPie localBaseChatPie;
      Object localObject2;
      if ((!TextUtils.isEmpty(this.cin)) && (this.mContext != null) && (this.mContext.get() != null) && ((this.mContext.get() instanceof FragmentActivity)) && (!MultiForwardActivity.class.isInstance(this.mContext.get())))
      {
        localObject1 = ((FragmentActivity)this.mContext.get()).getChatFragment();
        if (localObject1 != null)
        {
          localBaseChatPie = ((ChatFragment)localObject1).a();
          ujt.e(localBaseChatPie.app, (Context)this.mContext.get(), localBaseChatPie.sessionInfo, this.cin + " +1");
          localObject2 = "";
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(this.mUrl)) {
            localObject1 = Uri.parse(this.mUrl);
          }
        }
      }
      try
      {
        localObject1 = ((Uri)localObject1).getQueryParameter("article_id");
        localObject2 = localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      kbp.a(localBaseChatPie.app, "", "0X8007239", "0X8007239", 0, 0, (String)localObject1, "", "", "");
      kbp.d("0X8007239", "", (String)localObject1, "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
    }
  }
  
  class b
  {
    SingleLineTextView B;
    ImageView DM;
    TextView Zy;
    URLImageView d;
    LinearLayout kG;
    RelativeLayout lZ;
    RelativeLayout ma;
    RelativeLayout mb;
    TextView title;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anuj
 * JD-Core Version:    0.7.0.1
 */