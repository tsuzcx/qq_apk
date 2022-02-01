import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager.TopicInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class abgd
  extends BaseAdapter
{
  private abgd.a a;
  private List<SignatureManager.TopicInfo> jj;
  private QQAppInterface mApp;
  private Context mContext;
  private LayoutInflater mLayoutInflater;
  private XListView mListView;
  private List<SignatureManager.TopicInfo> vX;
  
  public abgd(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, abgd.a parama)
  {
    this.mContext = paramContext;
    this.mApp = paramQQAppInterface;
    this.mListView = paramXListView;
    this.a = parama;
    this.mLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  private String a(SignatureManager.TopicInfo paramTopicInfo)
  {
    if ((paramTopicInfo == null) || ((paramTopicInfo.totalNum <= 0) && (paramTopicInfo.friendNum <= 0))) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramTopicInfo.friendNum > 0)
    {
      if (paramTopicInfo.friendNum >= 10000)
      {
        localStringBuilder.append(r(paramTopicInfo.friendNum));
        localStringBuilder.append("万好友");
      }
    }
    else
    {
      if ((paramTopicInfo.friendNum > 0) && (paramTopicInfo.totalNum > 0)) {
        localStringBuilder.append("、");
      }
      if (paramTopicInfo.totalNum > 0)
      {
        if (paramTopicInfo.totalNum < 10000) {
          break label168;
        }
        localStringBuilder.append(r(paramTopicInfo.totalNum));
        localStringBuilder.append("万人添加该话题");
      }
    }
    for (;;)
    {
      if ((paramTopicInfo.totalNum <= 0) && (paramTopicInfo.friendNum > 0)) {
        localStringBuilder.append("添加该话题");
      }
      return localStringBuilder.toString();
      localStringBuilder.append(paramTopicInfo.friendNum);
      localStringBuilder.append("个好友");
      break;
      label168:
      localStringBuilder.append(paramTopicInfo.totalNum);
      localStringBuilder.append("人添加该话题");
    }
  }
  
  private String iq(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) && (paramString.length() <= 2)) {}
    String str;
    do
    {
      return paramString;
      str = paramString;
      if (paramString.charAt(0) == '#') {
        str = paramString.substring(1);
      }
      paramString = str;
    } while (str.charAt(str.length() - 1) != '#');
    return str.substring(0, str.length() - 1);
  }
  
  private float r(int paramInt)
  {
    return Math.round(paramInt / 10000.0F * 100.0F) / 100.0F;
  }
  
  public SignatureManager.TopicInfo a(int paramInt)
  {
    if ((this.jj == null) || (paramInt < 0) || (paramInt >= this.jj.size())) {
      return null;
    }
    return (SignatureManager.TopicInfo)this.jj.get(paramInt);
  }
  
  public List<SignatureManager.TopicInfo> dA()
  {
    return this.vX;
  }
  
  public List<SignatureManager.TopicInfo> dz()
  {
    return this.jj;
  }
  
  public boolean f(List<SignatureManager.TopicInfo> paramList, boolean paramBoolean)
  {
    if (paramList != this.jj) {
      this.jj = ((ArrayList)paramList);
    }
    for (boolean bool = true;; bool = false)
    {
      if ((paramBoolean) && (paramList != this.vX)) {
        this.vX = ((ArrayList)paramList);
      }
      return bool;
    }
  }
  
  public int getCount()
  {
    if (this.jj == null) {
      return 0;
    }
    return this.jj.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    String str;
    if (paramView == null)
    {
      localView = this.mLayoutInflater.inflate(2131562249, this.mListView, false);
      paramView = new abgd.b();
      paramView.xq = ((ImageView)localView.findViewById(2131369653));
      paramView.pf = ((TextView)localView.findViewById(2131380988));
      paramView.PA = ((TextView)localView.findViewById(2131380989));
      localView.setTag(paramView);
      localObject = a(paramInt);
      if (localObject != null)
      {
        paramView.pf.setText(((SignatureManager.TopicInfo)localObject).topicStr);
        paramView.topicId = ((SignatureManager.TopicInfo)localObject).topicId;
        str = a((SignatureManager.TopicInfo)localObject);
        if (!TextUtils.isEmpty(str)) {
          break label242;
        }
        paramView.PA.setVisibility(8);
        label134:
        localView.setContentDescription(acfp.m(2131715399) + iq(((SignatureManager.TopicInfo)localObject).topicStr) + acfp.m(2131715398));
      }
      if (!ThemeUtil.isNowThemeIsNight(this.mApp, false, null)) {
        break label262;
      }
      localView.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130839634));
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (abgd.b)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label242:
      paramView.PA.setVisibility(0);
      paramView.PA.setText(str);
      break label134;
      label262:
      localView.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130839633));
    }
  }
  
  public static abstract interface a {}
  
  public static class b
  {
    public TextView PA;
    public TextView pf;
    public int topicId;
    public ImageView xq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abgd
 * JD-Core Version:    0.7.0.1
 */