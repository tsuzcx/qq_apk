import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.bizparts.QCircleTopAuthPart.1;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import com.tencent.biz.qqcircle.requests.QCircleConfirmCircleMemberShipRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import qqcircle.QQCircleBase.UserCircleInfo;
import qqcircle.QQCircleFeedBase.StFollowPageData;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class oxz
  extends rxk
  implements View.OnClickListener
{
  private QQCircleBase.UserCircleInfo a;
  private int aUC = -1;
  private String arI = "";
  private String arJ = "";
  private String arK = "";
  private final int bgC = 1;
  private final int bgD = 2;
  private final int bgE = 3;
  private final int bgF = 4;
  private final int bgG = 5;
  private final int bgH = 1;
  private final int bgI = 2;
  private int bgJ = -1;
  private Runnable dh;
  private ImageView ir;
  private View mRootView;
  private Handler mUIHandler;
  private TextView my;
  private ViewStub s;
  private TextView vW;
  private TextView vX;
  private long zn = 8000L;
  
  private owa a()
  {
    if ((b() != null) && ((b() instanceof QCircleBaseTabFragment))) {
      return ((QCircleBaseTabFragment)b()).a();
    }
    return null;
  }
  
  private void b(QQCircleFeedBase.StFollowPageData paramStFollowPageData)
  {
    owa localowa = a();
    if ((localowa != null) && (localowa.getType() == 1) && (paramStFollowPageData != null) && (paramStFollowPageData.has())) {
      c(paramStFollowPageData);
    }
  }
  
  private void bix()
  {
    if ((this.bgJ == 1) || (this.bgJ == 2))
    {
      Context localContext;
      List localList;
      if (a() != null)
      {
        localContext = getContext();
        localList = a().a.urlInfo.get();
        if (this.bgJ != 1) {
          break label63;
        }
      }
      label63:
      for (String str = "authSchoolUrl";; str = "authCampanyUrl")
      {
        oux.aX(localContext, ouw.c(localList, str));
        return;
      }
    }
    biy();
  }
  
  private void biy()
  {
    ausj localausj = ausj.b(getContext());
    localausj.addButton(2131700142, 0);
    localausj.addButton(2131700141, 0);
    localausj.addCancelButton(2131721058);
    localausj.a(new oya(this, localausj));
    if (!localausj.isShowing()) {
      localausj.show();
    }
  }
  
  private void biz()
  {
    if (this.a != null)
    {
      QCircleConfirmCircleMemberShipRequest localQCircleConfirmCircleMemberShipRequest = new QCircleConfirmCircleMemberShipRequest(null, this.a);
      VSNetworkHelper.a().a(localQCircleConfirmCircleMemberShipRequest, new oyb(this));
    }
  }
  
  private void c(QQCircleFeedBase.StFollowPageData paramStFollowPageData)
  {
    if (oue.a().Hv())
    {
      this.a = ((QQCircleBase.UserCircleInfo)paramStFollowPageData.recomCircileCertification.get());
      paramStFollowPageData = paramStFollowPageData.tipsTitle.get();
      if (!TextUtils.isEmpty(paramStFollowPageData)) {}
    }
    else
    {
      return;
    }
    if (this.a.has())
    {
      switch (this.a.circleTab.get())
      {
      default: 
        return;
      }
      this.my.setText(paramStFollowPageData);
      this.vX.setText(getContext().getString(2131700075));
      this.ir.setVisibility(8);
      this.vW.setVisibility(0);
      this.aUC = this.a.circleTab.get();
      this.bgJ = this.a.circleType.get();
      this.arI = (this.bgJ + "");
      this.arJ = this.a.name.get();
      this.arK = this.a.id.get();
    }
    for (;;)
    {
      pco.a("", 22, 2L, 0L, this.arI, "", this.arJ, this.arK, "");
      ri(true);
      if (this.dh != null) {
        this.mUIHandler.removeCallbacks(this.dh);
      }
      this.dh = new QCircleTopAuthPart.1(this);
      this.mUIHandler.postDelayed(this.dh, this.zn);
      return;
      this.aUC = -1;
      this.bgJ = -1;
      this.my.setText(paramStFollowPageData);
      this.vX.setText(getContext().getString(2131700130));
      this.ir.setVisibility(0);
      this.vW.setVisibility(8);
    }
  }
  
  private void ri(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      oue.a().bhC();
      if ((this.mRootView.getVisibility() == 8) && (!getActivity().isFinishing())) {
        this.mRootView.setVisibility(0);
      }
    }
    while ((this.mRootView.getVisibility() != 0) || (getActivity().isFinishing())) {
      return;
    }
    this.mRootView.setVisibility(8);
  }
  
  public void d(QQCircleFeedBase.StFollowPageData paramStFollowPageData)
  {
    b(paramStFollowPageData);
  }
  
  protected void dC(View paramView)
  {
    super.dC(paramView);
    if (paramView != null)
    {
      this.s = ((ViewStub)paramView.findViewById(2131373906));
      this.mRootView = this.s.inflate();
      this.my = ((TextView)this.mRootView.findViewById(2131373907));
      this.vW = ((TextView)this.mRootView.findViewById(2131374498));
      this.vX = ((TextView)this.mRootView.findViewById(2131374499));
      this.ir = ((ImageView)this.mRootView.findViewById(2131374501));
      this.ir.setOnClickListener(this);
      this.vX.setOnClickListener(this);
      this.vW.setOnClickListener(this);
      this.mUIHandler = new Handler(Looper.myLooper());
    }
  }
  
  public String getLogTag()
  {
    return "QCircleTopAuthPart";
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    if ((this.mUIHandler != null) && (this.dh != null)) {
      this.mUIHandler.removeCallbacks(this.dh);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ri(false);
      pco.a("", 22, 6L, 0L, this.arI, "", this.arJ, this.arK, "");
      QQToast.a(getContext(), 0, 2131700071, 0).show();
      continue;
      if (this.aUC == -1)
      {
        pco.h("", 22, 3L);
        biy();
        ri(false);
      }
      else if (this.aUC == 5)
      {
        pco.a("", 22, 4L, 0L, this.arI, "", this.arJ, this.arK, "");
        pco.a("", 22, 7L, 0L, this.arI, "", this.arJ, this.arK, "");
        bix();
        ri(false);
      }
      else if (this.aUC == 4)
      {
        pco.a("", 22, 4L, 0L, this.arI, "", this.arJ, this.arK, "");
        pco.a("", 22, 8L, 0L, this.arI, "", this.arJ, this.arK, "");
        biz();
        QQToast.a(getContext(), 2, 2131700064, 0).show();
        ri(false);
        continue;
        pco.a("", 22, 5L, 0L, this.arI, "", this.arJ, this.arK, "");
        bix();
        ri(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oxz
 * JD-Core Version:    0.7.0.1
 */