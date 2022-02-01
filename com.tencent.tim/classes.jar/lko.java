import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderFriendRecommend;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.FixSizeImageView;
import com.tencent.widget.ListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.FriendRecommendInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.SpecialTopicInfo;

public class lko
  implements View.OnClickListener, lkf
{
  private aqdf jdField_a_of_type_Aqdf;
  private autw jdField_a_of_type_Autw;
  private nhk jdField_a_of_type_Nhk;
  private boolean akH;
  private ListView jdField_b_of_type_ComTencentWidgetListView;
  private ndi jdField_b_of_type_Ndi;
  private lie c;
  private Context mContext;
  
  public lko(Context paramContext, aqdf paramaqdf, ndi paramndi, ListView paramListView, autw paramautw)
  {
    this.mContext = paramContext;
    this.jdField_a_of_type_Aqdf = paramaqdf;
    this.jdField_b_of_type_Ndi = paramndi;
    this.jdField_a_of_type_Autw = paramautw;
    this.jdField_b_of_type_ComTencentWidgetListView = paramListView;
  }
  
  private URL a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo.mHeaderIconUrl == null) {
      try
      {
        String str = ((articlesummary.SpecialTopicInfo)paramArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_icon_url.get();
        if (TextUtils.isEmpty(str)) {
          QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader special topic icon url empty");
        }
        if (TextUtils.isEmpty(str)) {
          return null;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          localObject = null;
        }
        Object localObject = kxm.b((String)localObject);
        paramArticleInfo.mHeaderIconUrl = ((URL)localObject);
        return localObject;
      }
    }
    return paramArticleInfo.mHeaderIconUrl;
  }
  
  private void a(nhk paramnhk, lie paramlie, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int j = this.jdField_b_of_type_ComTencentWidgetListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      lie locallie = (lie)this.jdField_b_of_type_ComTencentWidgetListView.getChildAt(i).getTag(2131381960);
      nhk localnhk = (nhk)this.jdField_b_of_type_ComTencentWidgetListView.getChildAt(i).getTag(2131381965);
      if ((locallie != null) && (localnhk != null) && (paramlie.a().mGroupId == locallie.a().mGroupId))
      {
        localArrayList1.add(localnhk);
        localArrayList2.add(locallie);
      }
      i += 1;
    }
    paramnhk = new lks(this, paramnhk, localArrayList2, paramArrayList, paramInt, paramObject);
    paramInt = 0;
    if (paramInt < localArrayList1.size())
    {
      paramlie = (Animation)((nhk)localArrayList1.get(paramInt)).getView().getTag(2131370016);
      if (paramInt != 0) {
        paramlie.setAnimationListener(null);
      }
      for (;;)
      {
        ((nhk)localArrayList1.get(paramInt)).getView().startAnimation(paramlie);
        paramInt += 1;
        break;
        paramlie.setAnimationListener(paramnhk);
      }
    }
  }
  
  private void a(boolean paramBoolean, ArticleInfo paramArticleInfo)
  {
    int k = 8;
    int i;
    label90:
    label123:
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = c(paramArticleInfo);
      if ((localObject1 != null) && (((List)localObject1).size() == 1))
      {
        this.jdField_a_of_type_Nhk.bK.setOnClickListener(this);
        this.jdField_a_of_type_Nhk.qC.setTypeface(this.jdField_a_of_type_Nhk.qC.getTypeface(), 1);
        this.jdField_a_of_type_Nhk.mv.setVisibility(0);
        localObject1 = this.jdField_a_of_type_Nhk.J;
        if (!paramBoolean) {
          break label205;
        }
        i = 8;
        ((KandianUrlImageView)localObject1).setVisibility(i);
        this.jdField_a_of_type_Nhk.J.setOnClickListener(this);
        localObject1 = this.jdField_a_of_type_Nhk.a;
        int m = localObject1.length;
        i = 0;
        if (i >= m) {
          break label217;
        }
        localObject2 = localObject1[i];
        if (!paramBoolean) {
          break label210;
        }
      }
    }
    label205:
    label210:
    for (int j = 0;; j = 8)
    {
      localObject2.setVisibility(j);
      i += 1;
      break label123;
      this.jdField_a_of_type_Nhk.bK.setOnClickListener(null);
      this.jdField_a_of_type_Nhk.qC.setTypeface(this.jdField_a_of_type_Nhk.qC.getTypeface(), 0);
      break;
      this.jdField_a_of_type_Nhk.bK.setOnClickListener(this);
      break;
      i = 0;
      break label90;
    }
    label217:
    Object localObject1 = this.jdField_a_of_type_Nhk.qC;
    if (paramBoolean) {
      if (c(paramArticleInfo).size() == 1) {
        i = 0;
      }
    }
    for (;;)
    {
      ((TextView)localObject1).setVisibility(i);
      this.jdField_a_of_type_Nhk.qC.setOnClickListener(this);
      paramArticleInfo = this.jdField_a_of_type_Nhk.qx;
      i = k;
      if (paramBoolean) {
        i = 0;
      }
      paramArticleInfo.setVisibility(i);
      this.jdField_a_of_type_Nhk.mw.setVisibility(0);
      return;
      i = 8;
      continue;
      i = 0;
    }
  }
  
  private List<Long> c(ArticleInfo paramArticleInfo)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.addAll(((articlesummary.FriendRecommendInfo)paramArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).rpt_recommenders.get());
      if (localArrayList.isEmpty()) {
        QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader friend recommend uin list empty");
      }
      return localArrayList;
    }
    catch (Exception paramArticleInfo)
    {
      for (;;)
      {
        paramArticleInfo.printStackTrace();
      }
    }
  }
  
  private String g(ArticleInfo paramArticleInfo)
  {
    try
    {
      paramArticleInfo = ((articlesummary.SpecialTopicInfo)paramArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_title.get();
      if (TextUtils.isEmpty(paramArticleInfo)) {
        QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader special topic title empty");
      }
      return paramArticleInfo;
    }
    catch (Exception paramArticleInfo)
    {
      for (;;)
      {
        paramArticleInfo.printStackTrace();
        paramArticleInfo = null;
      }
    }
  }
  
  private String h(ArticleInfo paramArticleInfo)
  {
    try
    {
      paramArticleInfo = ((articlesummary.SpecialTopicInfo)paramArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_jump_url.get();
      if (TextUtils.isEmpty(paramArticleInfo)) {
        QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader special topic url empty");
      }
      return paramArticleInfo;
    }
    catch (Exception paramArticleInfo)
    {
      for (;;)
      {
        paramArticleInfo.printStackTrace();
        paramArticleInfo = null;
      }
    }
  }
  
  private String i(ArticleInfo paramArticleInfo)
  {
    try
    {
      paramArticleInfo = ((articlesummary.FriendRecommendInfo)paramArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).str_header_title.get();
      if (TextUtils.isEmpty(paramArticleInfo)) {
        QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader friend recommend description empty");
      }
      return paramArticleInfo;
    }
    catch (Exception paramArticleInfo)
    {
      for (;;)
      {
        paramArticleInfo.printStackTrace();
        paramArticleInfo = null;
      }
    }
  }
  
  private void lO(String paramString)
  {
    label103:
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = kxm.v();
        localJSONObject.put("feeds_source", paramString);
        localJSONObject.put("kandian_mode", kxm.nR());
        paramString = "0X800744D";
        if (this.c != null)
        {
          if (odv.aT(this.c.nh()))
          {
            paramString = "0X8009357";
            break label103;
          }
        }
        else
        {
          kbp.a(null, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", localJSONObject.toString(), false);
          return;
        }
        paramString = "0X800744D";
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
  }
  
  public void a(nhk paramnhk, lie paramlie)
  {
    paramnhk = paramlie.a();
    paramlie = c(paramnhk);
    int i = 0;
    if (i < Math.min(4, paramlie.size()))
    {
      if (kxm.AI()) {
        this.jdField_a_of_type_Nhk.a[i].setImageDrawable(amxk.b(this.jdField_a_of_type_Aqdf, String.valueOf(paramlie.get(i)), 1));
      }
      for (;;)
      {
        String str = String.valueOf(paramlie.get(i));
        this.jdField_a_of_type_Nhk.a[i].setOnClickListener(new lkr(this, str, paramnhk));
        i += 1;
        break;
        this.jdField_a_of_type_Nhk.a[i].setImageBitmap(this.jdField_b_of_type_Ndi.c(((Long)paramlie.get(i)).longValue()));
      }
    }
    i = Math.min(4, paramlie.size());
    while (i < 4)
    {
      this.jdField_a_of_type_Nhk.a[i].setVisibility(8);
      i += 1;
    }
  }
  
  public void a(nhk paramnhk, lie paramlie, int paramInt)
  {
    this.jdField_a_of_type_Nhk = paramnhk;
    this.c = paramlie;
    ArticleInfo localArticleInfo = this.c.a();
    if (this.jdField_a_of_type_Nhk.bK != null)
    {
      localObject = this.jdField_a_of_type_Nhk.mu;
      if (!this.c.isShowHeader()) {
        break label179;
      }
    }
    label179:
    for (paramInt = 0;; paramInt = 8)
    {
      ((View)localObject).setVisibility(paramInt);
      if (this.c.isShowHeader())
      {
        this.jdField_a_of_type_Nhk.aWZ();
        if (this.c.oF() != 3) {
          break;
        }
        this.jdField_a_of_type_Nhk.bK.setVisibility(8);
        this.jdField_a_of_type_Nhk.my.setVisibility(8);
        if (this.jdField_a_of_type_Nhk.mz != null) {
          this.jdField_a_of_type_Nhk.mz.setVisibility(8);
        }
        this.jdField_a_of_type_Nhk.c.setVisibility(0);
        this.jdField_a_of_type_Nhk.c.setLogic(this.jdField_b_of_type_Ndi, this.jdField_a_of_type_Aqdf);
        this.jdField_a_of_type_Nhk.c.P(paramlie);
      }
      return;
    }
    this.jdField_a_of_type_Nhk.c.setVisibility(8);
    this.jdField_a_of_type_Nhk.bK.setVisibility(0);
    switch (this.c.oF())
    {
    default: 
      this.jdField_a_of_type_Nhk.mw.setOnClickListener(new lkp(this, paramlie, paramnhk));
      return;
    case 1: 
      this.akH = false;
      a(false, localArticleInfo);
      localObject = a(localArticleInfo);
      if (localObject == null)
      {
        this.jdField_a_of_type_Nhk.J.setVisibility(8);
        this.jdField_a_of_type_Nhk.mv.setVisibility(8);
      }
      for (;;)
      {
        this.jdField_a_of_type_Nhk.qC.setText(g(localArticleInfo));
        break;
        kwz.a(this.jdField_a_of_type_Nhk.J, (URL)localObject, this.mContext);
      }
    }
    this.akH = true;
    a(true, localArticleInfo);
    a(paramnhk, paramlie);
    Object localObject = c(localArticleInfo);
    if (((List)localObject).size() == 1) {
      if (!kxm.AI()) {
        break label447;
      }
    }
    label447:
    for (localObject = aqgv.A((QQAppInterface)kxm.getAppRuntime(), String.valueOf(((List)localObject).get(0)));; localObject = this.jdField_b_of_type_Ndi.az(((Long)((List)localObject).get(0)).longValue()))
    {
      this.jdField_a_of_type_Nhk.qC.setText(kxm.ew((String)localObject));
      this.jdField_a_of_type_Nhk.qx.setText(i(localArticleInfo));
      break;
    }
  }
  
  public void a(nhk paramnhk, lie paramlie, long paramLong, Bitmap paramBitmap)
  {
    if (this.c.oF() == 3) {
      this.jdField_a_of_type_Nhk.c.b(paramLong, paramBitmap);
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Nhk.bK == null) || (this.c.oF() != 2) || (!kxm.AI()));
      paramnhk = c(paramlie.a());
    } while ((paramnhk.size() <= 0) || (!paramnhk.contains(Long.valueOf(paramLong))));
    int i = paramnhk.indexOf(Long.valueOf(paramLong));
    this.jdField_a_of_type_Nhk.a[i].setImageBitmap(paramBitmap);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      lO(kxm.f(this.c.a()));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject;
      if (this.akH)
      {
        localObject = c(this.c.a());
        if ((localObject != null) && (((List)localObject).size() == 1))
        {
          localObject = kwt.acF + aqgo.encodeToString(String.valueOf(((List)localObject).get(0)).getBytes(), 2);
          kxm.aJ(this.mContext, (String)localObject);
        }
      }
      else
      {
        localObject = h(this.c.a());
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          kxm.aJ(this.mContext, (String)localObject);
          continue;
          if (!this.akH)
          {
            localObject = h(this.c.a());
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              kxm.aJ(this.mContext, (String)localObject);
            }
          }
          else
          {
            localObject = c(this.c.a());
            if (!((List)localObject).isEmpty())
            {
              localObject = kwt.acF + aqgo.encodeToString(String.valueOf(((List)localObject).get(0)).getBytes(), 2);
              kxm.aJ(this.mContext, (String)localObject);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lko
 * JD-Core Version:    0.7.0.1
 */