import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.channelCover.ChannelCoverSimpleAdapter.1;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyVideoTopicTextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class kqn
  extends BaseAdapter
  implements View.OnClickListener
{
  private Context context;
  private ArrayList<ChannelCoverInfo> infos = new ArrayList();
  private int mChannelID;
  
  public kqn(Context paramContext, ArrayList<ChannelCoverInfo> paramArrayList, int paramInt)
  {
    this.context = paramContext;
    this.mChannelID = paramInt;
    if (paramArrayList != null)
    {
      this.infos.clear();
      paramContext = new ChannelCoverInfo();
      this.infos.add(paramContext);
      this.infos.addAll(paramArrayList);
      paramContext = new ChannelCoverInfo();
      this.infos.add(paramContext);
    }
  }
  
  public ChannelCoverInfo a(int paramInt)
  {
    if ((this.infos != null) && (paramInt < this.infos.size())) {
      return (ChannelCoverInfo)this.infos.get(paramInt);
    }
    return null;
  }
  
  public int getCount()
  {
    if (this.infos != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("READINJOYChannelCoverSimpleAdapter", 2, "getCount()" + this.infos.size());
      }
      return this.infos.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == 0) || ((this.infos != null) && (paramInt == this.infos.size() - 1))) {
      return 0;
    }
    return 1;
  }
  
  @TargetApi(16)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    Object localObject2 = this.context.getResources();
    Object localObject1;
    if (getItemViewType(paramInt) == 0)
    {
      localObject1 = paramView;
      if (paramView == null)
      {
        localObject1 = new View(this.context);
        ((View)localObject1).setLayoutParams(new ViewGroup.LayoutParams(wja.dp2px(2.0F, (Resources)localObject2), wja.dp2px(30.0F, (Resources)localObject2)));
      }
      paramView = (View)localObject1;
      localObject2 = localObject1;
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject2;
    }
    if (paramView == null)
    {
      localObject1 = new kqn.a();
      paramView = new ReadInJoyVideoTopicTextView(this.context);
      paramView.setId(2131376716);
      paramView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      ((kqn.a)localObject1).a = paramView;
      paramView.setTag(localObject1);
      label152:
      localObject2 = (ChannelCoverInfo)this.infos.get(paramInt);
      if (localObject2 != null)
      {
        if (((ChannelCoverInfo)localObject2).mColumnType != 1) {
          break label438;
        }
        ((kqn.a)localObject1).a.setTopicText(((ChannelCoverInfo)localObject2).mChannelCoverName);
        label192:
        if (this.mChannelID != 56) {
          break label454;
        }
        ((kqn.a)localObject1).a.setTextColor(7566195);
        label211:
        if (TextUtils.isEmpty(((ChannelCoverInfo)localObject2).mIconUrl)) {
          break label470;
        }
        int i = aqnm.dip2px(21.0F);
        Object localObject3 = this.context.getResources().getDrawable(2130841149);
        localObject3 = URLDrawable.getDrawable(((ChannelCoverInfo)localObject2).mIconUrl, i, i, (Drawable)localObject3, (Drawable)localObject3);
        if ((localObject3 != null) && (((URLDrawable)localObject3).getStatus() == 2)) {
          ((URLDrawable)localObject3).restartDownload();
        }
        ((URLDrawable)localObject3).setBounds(0, 0, i, i);
        ((kqn.a)localObject1).a.setCompoundDrawables((Drawable)localObject3, null, null, null);
        label304:
        if (!((ChannelCoverInfo)localObject2).isReport)
        {
          ((ChannelCoverInfo)localObject2).isReport = true;
          if (this.mChannelID != 56) {
            break label485;
          }
          i = j;
          if ((this.context instanceof Activity))
          {
            i = j;
            if (((Activity)this.context).getIntent() != null) {
              i = ((Activity)this.context).getIntent().getIntExtra("channel_from", -1);
            }
          }
          kqo.a("0X8007BE5", "1", "", "", (ChannelCoverInfo)localObject2, i);
        }
      }
    }
    for (;;)
    {
      kqo.a("0X8007F01", (ChannelCoverInfo)localObject2, kqo.aLl);
      ((kqn.a)localObject1).a.setOnClickListener(this);
      ((kqn.a)localObject1).d = ((ChannelCoverInfo)localObject2);
      localObject1 = paramView;
      localObject2 = paramView;
      break;
      localObject1 = (kqn.a)paramView.getTag();
      break label152;
      label438:
      ((kqn.a)localObject1).a.setSubChannelText(((ChannelCoverInfo)localObject2).mChannelCoverName);
      break label192;
      label454:
      ((kqn.a)localObject1).a.setTextColor(((ChannelCoverInfo)localObject2).mFontColor);
      break label211;
      label470:
      ((kqn.a)localObject1).a.setCompoundDrawables(null, null, null, null);
      break label304;
      label485:
      if (kxm.aL(this.mChannelID)) {
        kvp.c(this.context, "0X8009A70", this.mChannelID, ((ChannelCoverInfo)localObject2).mChannelCoverId);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    ChannelCoverInfo localChannelCoverInfo;
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("READINJOYChannelCoverSimpleAdapter", 2, "click readinjoy_feeds_video_label_textview");
      }
      localChannelCoverInfo = ((kqn.a)paramView.getTag()).d;
    } while (localChannelCoverInfo == null);
    Object localObject;
    if (TextUtils.isEmpty(localChannelCoverInfo.mChannelJumpUrl))
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("param_key_ariticle_id", Long.valueOf(localChannelCoverInfo.mArticleId));
      ((HashMap)localObject).put("param_key_channel_cover_style", Integer.valueOf(localChannelCoverInfo.mChannelCoverStyle));
      ((HashMap)localObject).put("param_key_channel_column_type", Integer.valueOf(localChannelCoverInfo.mColumnType));
      if (this.mChannelID == 56)
      {
        kgw.b(this.context, localChannelCoverInfo.mChannelCoverId, localChannelCoverInfo.mChannelCoverName, localChannelCoverInfo.mChannelType, 4, (Map)localObject);
        label155:
        if (QLog.isColorLevel()) {
          QLog.d("READINJOYChannelCoverSimpleAdapter", 2, "launchChannelActivity info.mArticleId:" + localChannelCoverInfo.mArticleId + " info.mChannelCoverStyle: " + localChannelCoverInfo.mChannelCoverStyle + " info.mChannelCoverId:" + localChannelCoverInfo.mChannelCoverId + " info.mChannelCoverName:" + localChannelCoverInfo.mChannelCoverName + " info.mChannelType: " + localChannelCoverInfo.mChannelType);
        }
        if (this.mChannelID == 56) {
          ThreadManager.executeOnSubThread(new ChannelCoverSimpleAdapter.1(this, localChannelCoverInfo));
        }
      }
    }
    label430:
    for (;;)
    {
      if (kxm.aL(this.mChannelID)) {
        kvp.c(this.context, "0X8009A71", this.mChannelID, localChannelCoverInfo.mChannelCoverId);
      }
      kqo.a("0X8007F02", localChannelCoverInfo, kqo.aLl);
      break;
      kgw.a(this.context, localChannelCoverInfo.mChannelCoverId, localChannelCoverInfo.mChannelCoverName, localChannelCoverInfo.mChannelType, 4, (Map)localObject);
      break label155;
      if (ntp.ek(localChannelCoverInfo.mChannelJumpUrl)) {
        ntp.b(this.context, "", ntp.fd(localChannelCoverInfo.mChannelJumpUrl), null);
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label430;
        }
        QLog.d("READINJOYChannelCoverSimpleAdapter", 2, "info.mChannelJumpUrl:" + localChannelCoverInfo.mChannelJumpUrl);
        break;
        localObject = new Intent(this.context, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", localChannelCoverInfo.mChannelJumpUrl);
        this.context.startActivity((Intent)localObject);
      }
    }
  }
  
  public void setData(ArrayList<ChannelCoverInfo> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("READINJOYChannelCoverSimpleAdapter", 2, "setData size" + paramArrayList.size());
    }
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      this.infos.clear();
      ChannelCoverInfo localChannelCoverInfo = new ChannelCoverInfo();
      this.infos.add(localChannelCoverInfo);
      this.infos.addAll(paramArrayList);
      paramArrayList = new ChannelCoverInfo();
      this.infos.add(paramArrayList);
    }
  }
  
  class a
  {
    ReadInJoyVideoTopicTextView a;
    ChannelCoverInfo d;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kqn
 * JD-Core Version:    0.7.0.1
 */