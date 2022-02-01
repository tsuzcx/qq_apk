import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.channelCover.ChannelCoverView.2;
import com.tencent.biz.pubaccount.readinjoy.channelCover.ChannelCoverView.3;
import com.tencent.biz.pubaccount.readinjoy.channelCover.ChannelCoverView.4;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;

public class kqo
  implements AdapterView.c
{
  public static int aLk = 2;
  public static int aLl = 1;
  private kqn a;
  private HorizontalListView c;
  private int channelId;
  private Context context;
  private LinearLayout dx;
  private ListView f;
  private ArrayList<ChannelCoverInfo> infos = new ArrayList();
  protected lce mObserver = new kqp(this);
  
  public kqo(Context paramContext, int paramInt, ListView paramListView)
  {
    this.channelId = paramInt;
    this.context = paramContext;
    this.f = paramListView;
    this.infos = ((ArrayList)lbz.a().r(paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverView", 2, "ChannelCoverView createSimpleView");
    }
    bP(paramContext);
    if ((this.infos != null) && (this.infos.size() > 0)) {
      this.f.addHeaderView(this.dx);
    }
    lcc.a().b(this.mObserver);
    if ((this.infos == null) || (this.infos.size() == 0)) {
      lbz.a().qq(paramInt);
    }
    lbz.a().qo(paramInt);
  }
  
  public static void a(String paramString, ChannelCoverInfo paramChannelCoverInfo, int paramInt)
  {
    a(paramString, paramChannelCoverInfo, paramInt, -1, -1);
  }
  
  public static void a(String paramString, ChannelCoverInfo paramChannelCoverInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    ThreadManager.post(new ChannelCoverView.4(paramChannelCoverInfo, paramInt1, paramInt2, paramInt3, paramString), 5, null, true);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, ChannelCoverInfo paramChannelCoverInfo, int paramInt)
  {
    ThreadManager.executeOnSubThread(new ChannelCoverView.3(paramChannelCoverInfo, paramInt, paramString1, paramString2, paramString3, paramString4));
  }
  
  public LinearLayout b()
  {
    return this.dx;
  }
  
  void bP(Context paramContext)
  {
    this.dx = ((LinearLayout)LayoutInflater.from(paramContext).inflate(2131558887, null, false));
    LinearLayout localLinearLayout = (LinearLayout)this.dx.findViewById(2131365322);
    this.c = ((HorizontalListView)this.dx.findViewById(2131382276));
    this.c.setOverScrollMode(2);
    this.c.setDividerWidth(wja.dp2px(6.0F, paramContext.getResources()));
    this.a = new kqn(paramContext, this.infos, this.channelId);
    this.c.setAdapter(this.a);
    this.c.setOverScrollMode(2);
    if (this.channelId == 56)
    {
      this.c.setOnTouchListener(new kqq(this, paramContext));
      localLinearLayout.setPadding(0, (int)aqho.convertDpToPixel(paramContext, 2.0F), 0, (int)aqho.convertDpToPixel(paramContext, 2.0F));
    }
    if (this.channelId == 41523) {
      this.dx.setPadding(0, wja.dp2px(10.0F, paramContext.getResources()), 0, 0);
    }
  }
  
  public void onDestroy()
  {
    lcc.a().c(this.mObserver);
    this.infos = null;
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverView", 2, "onDestroy()");
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.infos.size() > paramInt)
    {
      paramAdapterView = (ChannelCoverInfo)this.infos.get(paramInt);
      if (!TextUtils.isEmpty(paramAdapterView.mChannelJumpUrl)) {
        break label250;
      }
      paramView = new HashMap();
      paramView.put("param_key_ariticle_id", Long.valueOf(paramAdapterView.mArticleId));
      paramView.put("param_key_channel_cover_style", Integer.valueOf(paramAdapterView.mChannelCoverStyle));
      if (this.channelId != 56) {
        break label226;
      }
      kgw.b(this.context, paramAdapterView.mChannelCoverId, paramAdapterView.mChannelCoverName, paramAdapterView.mChannelType, 4, paramView);
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverView", 2, "launchChannelActivity info.mArticleId:" + paramAdapterView.mArticleId + " info.mChannelCoverStyle: " + paramAdapterView.mChannelCoverStyle + " info.mChannelCoverId:" + paramAdapterView.mChannelCoverId + " info.mChannelCoverName:" + paramAdapterView.mChannelCoverName + " info.mChannelType: " + paramAdapterView.mChannelType);
      }
      if (this.channelId == 56) {
        ThreadManager.executeOnSubThread(new ChannelCoverView.2(this, paramAdapterView));
      }
    }
    for (;;)
    {
      if (this.channelId == 0) {
        a("0X8007F02", paramAdapterView, aLk);
      }
      return;
      label226:
      kgw.a(this.context, paramAdapterView.mChannelCoverId, paramAdapterView.mChannelCoverName, paramAdapterView.mChannelType, 4, paramView);
      break;
      label250:
      paramView = new Intent(this.context, QQBrowserActivity.class);
      paramView.putExtra("url", paramAdapterView.mChannelJumpUrl);
      this.context.startActivity(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverView", 2, "info.mChannelJumpUrl:" + paramAdapterView.mChannelJumpUrl);
      }
      paramAdapterView.mPreUpdateTime = paramAdapterView.mUpdateTime;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kqo
 * JD-Core Version:    0.7.0.1
 */