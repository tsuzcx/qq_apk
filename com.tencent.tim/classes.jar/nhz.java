import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class nhz
  implements nid
{
  private static Set<KandianMsgBoxRedPntInfo> am = new HashSet();
  private KandianMsgBoxRedPntInfo b;
  private FrameLayout contentView;
  private VafContext e;
  private Container i;
  private View.OnClickListener onClickListener;
  private Activity x;
  
  public nhz(Activity paramActivity)
  {
    this.x = paramActivity;
    init();
  }
  
  private static void a(boolean paramBoolean, int paramInt, KandianMsgBoxRedPntInfo paramKandianMsgBoxRedPntInfo)
  {
    kxm.b localb = new kxm.b();
    for (;;)
    {
      try
      {
        localb.k(1037);
        localb.a(0);
        localb.a("message_type", String.valueOf(paramKandianMsgBoxRedPntInfo.messageType));
        localb.a("feedsid", String.valueOf(paramKandianMsgBoxRedPntInfo.feedsID));
        localb.a("feedstype", String.valueOf(paramKandianMsgBoxRedPntInfo.feedsType));
        if (paramKandianMsgBoxRedPntInfo.mMsgType == 2)
        {
          localb.a("sys_msg_id", String.valueOf(paramKandianMsgBoxRedPntInfo.sysMsgID));
          localb.a("sys_msg_from", String.valueOf(paramKandianMsgBoxRedPntInfo.sysMsgFrom));
        }
        localb.a("reddot_num", String.valueOf(paramKandianMsgBoxRedPntInfo.mMsgCnt));
        localb.b("msgbox1000000000");
        if (paramBoolean) {
          break label220;
        }
        localb.a("behavior_type", String.valueOf(paramInt));
      }
      catch (Exception paramKandianMsgBoxRedPntInfo)
      {
        QLog.e("ReadinjoySocialMsgCard", 1, "report has error " + paramKandianMsgBoxRedPntInfo);
        return;
      }
      kbp.a(null, "CliOper", "", String.valueOf(paramKandianMsgBoxRedPntInfo.mUin), str, str, 0, 0, String.valueOf(paramKandianMsgBoxRedPntInfo.mUin), "", "", localb.build(), false);
      return;
      String str = "0X8007626";
      continue;
      label220:
      if (paramBoolean) {
        str = "0X8007625";
      }
    }
  }
  
  private void init()
  {
    this.e = new VafContext();
    this.e.setContext(this.x);
    this.e.setCurActivity(this.x);
    kvx.a(this.e, "default_feeds");
    this.contentView = new FrameLayout(this.x);
    this.contentView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
    this.contentView.setOnClickListener(new nia(this));
  }
  
  public static void tD(int paramInt)
  {
    Object localObject = am;
    am = new HashSet();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      a(false, paramInt, (KandianMsgBoxRedPntInfo)((Iterator)localObject).next());
    }
  }
  
  public void d(KandianMsgBoxRedPntInfo paramKandianMsgBoxRedPntInfo)
  {
    if ((paramKandianMsgBoxRedPntInfo == null) || (paramKandianMsgBoxRedPntInfo.equals(this.b))) {
      QLog.d("ReadinjoySocialMsgCard", 2, "210 msgInfo is null ! " + paramKandianMsgBoxRedPntInfo);
    }
    TemplateBean localTemplateBean;
    for (;;)
    {
      return;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (!TextUtils.isEmpty(paramKandianMsgBoxRedPntInfo.mIconUrl)) {
          localJSONObject.put("msgbox_redpoint_icon", paramKandianMsgBoxRedPntInfo.mIconUrl);
        }
        localObject2 = paramKandianMsgBoxRedPntInfo.mCardSummary;
        Object localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = this.x.getResources().getString(2131696055);
        }
        localJSONObject.put("msgbox_redpoint_content", new aofk(anbk.nn((String)localObject1), 7, 17));
        if (!TextUtils.isEmpty(paramKandianMsgBoxRedPntInfo.mArticlePicUrl)) {
          localJSONObject.put("msgbox_redpoint_image", paramKandianMsgBoxRedPntInfo.mArticlePicUrl);
        }
        localJSONObject.put("msgbox_redpoint_count", String.format(this.x.getResources().getString(2131696056), new Object[] { awit.gM(paramKandianMsgBoxRedPntInfo.mMsgCnt) }));
        localJSONObject.put("style_ID", "ReadInjoy_msgbox_cell");
        localJSONObject.put("message_type", paramKandianMsgBoxRedPntInfo.messageType);
        localJSONObject.put("feedsid", paramKandianMsgBoxRedPntInfo.feedsID);
        localJSONObject.put("feedstype", paramKandianMsgBoxRedPntInfo.feedsType);
        localJSONObject.put("sys_msg_from", paramKandianMsgBoxRedPntInfo.sysMsgFrom);
        localJSONObject.put("sys_msg_id", paramKandianMsgBoxRedPntInfo.sysMsgID);
        localJSONObject.put("reddot_num", paramKandianMsgBoxRedPntInfo.mMsgCnt);
        try
        {
          if (!TextUtils.isEmpty(paramKandianMsgBoxRedPntInfo.mExtraData))
          {
            localObject1 = new JSONObject(paramKandianMsgBoxRedPntInfo.mExtraData);
            localObject2 = ((JSONObject)localObject1).keys();
            while (((Iterator)localObject2).hasNext())
            {
              String str = (String)((Iterator)localObject2).next();
              localJSONObject.put(str, ((JSONObject)localObject1).get(str));
            }
          }
          if (localTemplateBean == null) {
            continue;
          }
        }
        catch (JSONException localJSONException)
        {
          localTemplateBean = ProteusParser.getTemplateBean(npi.a("default_feeds", true), localJSONObject);
        }
        if (this.i != null) {
          break label439;
        }
        this.i = this.e.getViewFactory().inflate(this.e, localTemplateBean);
        if (this.i == null)
        {
          QLog.d("ReadinjoySocialMsgCard", 1, "create proteus view error!");
          return;
        }
      }
      catch (JSONException paramKandianMsgBoxRedPntInfo)
      {
        paramKandianMsgBoxRedPntInfo.printStackTrace();
        return;
      }
    }
    Object localObject2 = this.i.getVirtualView().getComLayoutParams();
    localObject2 = new RelativeLayout.LayoutParams(((Layout.Params)localObject2).mLayoutWidth, ((Layout.Params)localObject2).mLayoutHeight);
    this.contentView.addView(this.i, (ViewGroup.LayoutParams)localObject2);
    label439:
    kvx.a(this.i.getVirtualView(), localTemplateBean.getViewBean());
    this.b = paramKandianMsgBoxRedPntInfo;
    QLog.d("ReadinjoySocialMsgCard", 1, "set msg info : " + paramKandianMsgBoxRedPntInfo);
  }
  
  public View getContentView()
  {
    return this.contentView;
  }
  
  public void onDestroy()
  {
    this.x = null;
    this.contentView = null;
    this.onClickListener = null;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.onClickListener = paramOnClickListener;
  }
  
  public void show()
  {
    if ((this.contentView != null) && (this.b != null))
    {
      this.contentView.setVisibility(0);
      am.add(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nhz
 * JD-Core Version:    0.7.0.1
 */